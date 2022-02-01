package es.spain.club

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.spain.club.databinding.FilmOverviewBinding
import javax.inject.Inject


typealias OnMessageClick= (FilmOverviewDataView) -> Unit



open class FilmViewHolder(val binding: FilmOverviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

}

class FilmListAdapter @Inject constructor() :
    ListAdapter<FilmOverviewDataView, FilmViewHolder>(diffUtil) {

    var callback: OnMessageClick? = null

    companion object {




        private val diffUtil = object : DiffUtil.ItemCallback<FilmOverviewDataView>() {
            override fun areItemsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ): Boolean {
                return oldItem == newItem


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return object : FilmViewHolder(
            FilmOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)) {}
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.binding.Titulo1.text = film.title
        Glide.with(holder.binding.poster).load(film.imageURL).into(holder.binding.poster)
        holder.binding.root.setOnClickListener {
            callback?.invoke(film)
        }
    }

}