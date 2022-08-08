package id.vincenttp.ajaibtest.data.repository

import id.vincenttp.ajaibtest.data.ApiService
import id.vincenttp.ajaibtest.data.response.SearchResponse
import id.vincenttp.ajaibtest.data.room.AppDatabase
import id.vincenttp.ajaibtest.data.room.dao.SearchDao
import id.vincenttp.ajaibtest.data.room.dao.UserDao
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest : TestCase() {

    private lateinit var repository: UserRepositoryImpl

    private val api = mockk<ApiService>(relaxed = true)
    private val db = mockk<AppDatabase>(relaxed = true)
    private val searchDao = mockk<SearchDao>(relaxed = true)
    private val userDao = mockk<UserDao>(relaxed = true)

    @Before
    override fun setUp() {
        super.setUp()
        repository = UserRepositoryImpl(api, db)
        every { db.searchDao() } returns searchDao
        every { db.userDao() } returns userDao
    }

    @Test
    fun `test getUsers Online`() {
        runBlocking {
            //given
            val q = "vincenttp"
            val page = 1
            val mockResponse = SearchResponse(
                items = listOf(
                    SearchResponse.UserResponse(
                        login = "vincenttp",
                        id = 1,
                        avatar_url = "image.png"
                    )
                )
            )
            every { searchDao.loadAllByIds(q + page) } returns null
            coEvery { api.getUsers(q, page) } returns mockResponse

            //when
            repository.getUsers(q, page)

            //then
            coVerify { api.getUsers(q, page) }
        }
    }

    @Test
    fun `test getRepositories`() {
        //given
        val username = "vincenttp"

        runBlocking {
            //when
            repository.getRepositories(username)

            //then
            coVerify { api.getRepositories(username) }
        }
    }
}