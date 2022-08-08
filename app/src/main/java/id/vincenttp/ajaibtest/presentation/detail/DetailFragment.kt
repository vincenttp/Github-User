package id.vincenttp.ajaibtest.presentation.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.hilt.android.AndroidEntryPoint
import id.vincenttp.ajaibtest.base.BaseFragment
import id.vincenttp.ajaibtest.databinding.FragmentDetailBinding

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    private val viewModel by viewModels<DetailViewModel> { defaultViewModelProviderFactory }
    private val args: DetailFragmentArgs by navArgs()
    private val userModel by lazy {
        args.model
    }
    private val adapter by lazy {
        RepositoryAdapter()
    }

    init {
        lifecycleScope.launchWhenCreated {
            viewModel.getRepositories(userModel.username)
        }
    }
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDetailBinding.inflate(inflater, container, false)

    @SuppressLint("SetTextI18n")
    override fun onInitView() {
        with(binding) {
            Glide.with(ivAvatar)
                .load(userModel.avatar)
                .transform(CircleCrop())
                .into(ivAvatar)
            tvName.text = userModel.name
            tvUsername.text = "@${userModel.username}"
            tvBio.text = userModel.bio
            tvFollower.text = userModel.follower.toString()
            tvLocation.text = userModel.city
            tvEmail.text = userModel.email

            rvRepository.adapter = adapter
        }
    }

    override fun onInitObserve() {
        with(viewModel) {
            repositoriesLiveData.observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }

            errorLiveData.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}