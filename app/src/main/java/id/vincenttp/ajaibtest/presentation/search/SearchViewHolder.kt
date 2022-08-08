package id.vincenttp.ajaibtest.presentation.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import id.vincenttp.ajaibtest.databinding.ItemUserBinding
import id.vincenttp.ajaibtest.domain.model.UserModel

class SearchViewHolder(
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(
            parent: ViewGroup
        ) = SearchViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    fun bind(data: UserModel, onClick: ((UserModel) -> Unit)) {
        with(binding) {
            Glide.with(ivAvatar)
                .load(data.avatar)
                .transform(CircleCrop())
                .into(ivAvatar)
            tvName.text = data.name
            tvUsername.text = "@${data.username}"
            tvBio.text = data.bio
            tvEmail.text = "${data.city}  ${data.email}"

            tvBio.visibility = if (data.bio.isNotEmpty()) View.VISIBLE else View.GONE
        }

        binding.root.setOnClickListener {
            onClick(data)
        }
    }
}