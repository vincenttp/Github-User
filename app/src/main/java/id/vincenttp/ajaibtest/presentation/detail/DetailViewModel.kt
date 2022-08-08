package id.vincenttp.ajaibtest.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.vincenttp.ajaibtest.base.Result
import id.vincenttp.ajaibtest.domain.model.RepositoryModel
import id.vincenttp.ajaibtest.domain.usecase.GetRepositories
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRepositories: GetRepositories
) : ViewModel() {
    private val _repositoriesLiveData = MutableLiveData<List<RepositoryModel>>()
    val repositoriesLiveData = _repositoriesLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData = _errorLiveData

    fun getRepositories(username: String) {
        viewModelScope.launch {
            when (val result = getRepositories.invoke(GetRepositories.Params(username))) {
                is Result.Success -> {
                    _repositoriesLiveData.value = result.data
                }
                is Result.Error -> {
                    _errorLiveData.value = result.message
                }

            }
        }
    }
}