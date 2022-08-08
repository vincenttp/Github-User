package id.vincenttp.ajaibtest.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import id.vincenttp.ajaibtest.base.BaseFragment
import id.vincenttp.ajaibtest.databinding.FragmentSearchBinding
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val viewModel by viewModels<SearchViewModel> { defaultViewModelProviderFactory }

    private val adapter by lazy {
        SearchAdapter {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailFragment(
                    it
                )
            )
        }
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchBinding.inflate(inflater, container, false)

    override fun onInitView() {
        with(binding) {
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter
            adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
               override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                    super.onItemRangeInserted(positionStart, itemCount)
                    adapter.snapshot().slice(positionStart until itemCount).forEach {
                        if (it?.name.isNullOrEmpty()){
                            it?.username?.run(viewModel::getUserDetail)
                        }
                    }
                }
            })
        }
    }

    override fun onInitObserve() {
        binding.etUsername.addTextChangedListener {
            lifecycleScope.launchWhenStarted {
                viewModel.doSearch(it.toString()).collectLatest {
                    adapter.submitData(it)
                }
            }
        }

        viewModel.userLiveData.observe(viewLifecycleOwner) { model ->
            adapter.updateDetail(model)
        }
    }
}