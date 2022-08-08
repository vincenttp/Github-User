package id.vincenttp.ajaibtest.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import id.vincenttp.ajaibtest.base.Result
import id.vincenttp.ajaibtest.domain.model.RepositoryModel
import id.vincenttp.ajaibtest.domain.model.UserModel
import id.vincenttp.ajaibtest.domain.usecase.GetUser
import id.vincenttp.ajaibtest.domain.usecase.SearchUsers
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUsers: SearchUsers,
    private val getUser: GetUser
) : ViewModel() {

    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData = _userLiveData

    fun doSearch(q: String) = Pager(
        PagingConfig(pageSize = 100)
    ) { SearchData(searchUsers, q) }
        .flow
        .cachedIn(viewModelScope)

    fun getUserDetail(username: String){
        viewModelScope.launch {
            when(val result = getUser.invoke(GetUser.Params(username))){
                is Result.Success -> {
                    _userLiveData.value = result.data
                }
                is Result.Error -> {}

            }
        }
    }
}