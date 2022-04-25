package a114w6077dicoding.develops.moviecatalog.adapter

import a114w6077dicoding.develops.moviecatalog.R
import a114w6077dicoding.develops.moviecatalog.data.MovieCatalogueEntity
import a114w6077dicoding.develops.moviecatalog.databinding.ItemListBinding
import a114w6077dicoding.develops.moviecatalog.ui.detail.DetailActivity
import a114w6077dicoding.develops.moviecatalog.ui.detail.DetailViewModel
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class TvShowCatalogueAdapter: RecyclerView.Adapter<TvShowCatalogueAdapter.TvShowViewHolder>(){

    private var tvShows = ArrayList<MovieCatalogueEntity>()

    fun setTvShows(tvShows: ArrayList<MovieCatalogueEntity>?){
        if (tvShows.isNullOrEmpty()) return
        this.tvShows.clear()
        this.tvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TvShowViewHolder,
        position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    class TvShowViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: MovieCatalogueEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemReleasedDate.text = tvShow.release_date

                Glide.with(binding.root.context)
                    .load(tvShow.image).transform(RoundedCorners(28))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imagePoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.TV_SHOW)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}