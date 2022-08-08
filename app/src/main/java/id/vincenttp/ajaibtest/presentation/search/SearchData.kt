package id.vincenttp.ajaibtest.presentation.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import id.vincenttp.ajaibtest.base.Result
import id.vincenttp.ajaibtest.domain.model.UserModel
import id.vincenttp.ajaibtest.domain.usecase.SearchUsers

class SearchData(
    private val searchUsers: SearchUsers,
    private val q: String
) : PagingSource<Int, UserModel>() {
    companion object {
        private const val DEFAULT_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        val nextPageNumber = params.key ?: DEFAULT_PAGE_INDEX
        val result = searchUsers.invoke(
            SearchUsers.Params(
                q = q,
                page = nextPageNumber
            )
        )
        return when (result) {
            is Result.Success -> {
                LoadResult.Page(
                    data = result.data,
                    prevKey = null,
                    nextKey = nextPageNumber+1
                )
            }
            is Result.Error -> {
                LoadResult.Error(
                    throwable = result.exception
                )
            }
        }
    }
}