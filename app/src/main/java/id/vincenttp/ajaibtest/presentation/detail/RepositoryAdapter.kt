package id.vincenttp.ajaibtest.presentation.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import id.vincenttp.ajaibtest.domain.model.RepositoryModel

class RepositoryAdapter : ListAdapter<RepositoryModel, RepositoryViewHolder>(DiffUtils()) {
    companion object {
        class DiffUtils : DiffUtil.ItemCallback<RepositoryModel>() {
            override fun areItemsTheSame(
                oldItem: RepositoryModel,
                newItem: RepositoryModel
            ): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: RepositoryModel,
                newItem: RepositoryModel
            ): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoryViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}