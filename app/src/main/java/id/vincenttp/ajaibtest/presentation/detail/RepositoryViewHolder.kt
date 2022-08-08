package id.vincenttp.ajaibtest.presentation.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import id.vincenttp.ajaibtest.databinding.ItemRepositoryBinding
import id.vincenttp.ajaibtest.domain.model.RepositoryModel

class RepositoryViewHolder(private val binding: ItemRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(
            parent: ViewGroup
        ) = RepositoryViewHolder(
            ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    fun bind(data: RepositoryModel) {
        with(binding) {
            Glide.with(ivAvatar)
                .load(data.avatar)
                .transform(CircleCrop())
                .into(ivAvatar)
            tvName.text = data.name
            tvDescription.text = data.description
            tvDate.text = "${data.stars}    ${data.lastUpdate}"

            tvDescription.visibility = if (data.description.isNotEmpty()) View.VISIBLE else View.GONE
        }
    }
}