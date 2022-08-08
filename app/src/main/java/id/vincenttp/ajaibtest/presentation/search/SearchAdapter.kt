package id.vincenttp.ajaibtest.presentation.search

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import id.vincenttp.ajaibtest.domain.model.UserModel

class SearchAdapter(
    private val onClick: ((UserModel) -> Unit)
) : PagingDataAdapter<UserModel, SearchViewHolder>(DiffUtils()) {
    companion object {
        class DiffUtils : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(
                oldItem: UserModel,
                newItem: UserModel
            ): Boolean =
                oldItem.username == newItem.username

            override fun areContentsTheSame(
                oldItem: UserModel,
                newItem: UserModel
            ): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.run {
            holder.bind(this, onClick)
        }
    }


    fun updateDetail(userModel: UserModel) {
        val index = snapshot().indexOfFirst { it?.username == userModel.username }
        runCatching {
            snapshot()[index].apply {
                this?.name = userModel.name
                this?.bio = userModel.bio
                this?.city = userModel.city
                this?.email = userModel.email
            }
            notifyItemChanged(index)
        }
    }
}