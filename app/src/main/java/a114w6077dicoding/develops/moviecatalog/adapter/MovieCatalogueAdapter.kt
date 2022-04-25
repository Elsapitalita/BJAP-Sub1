package a114w6077dicoding.develops.moviecatalog.adapter

import a114w6077dicoding.develops.moviecatalog.R
import a114w6077dicoding.develops.moviecatalog.data.MovieCatalogueEntity
import a114w6077dicoding.develops.moviecatalog.databinding.ItemListBinding
import a114w6077dicoding.develops.moviecatalog.ui.detail.DetailActivity
import a114w6077dicoding.develops.moviecatalog.ui.detail.DetailViewModel.Companion.MOVIE
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class MovieCatalogueAdapter : RecyclerView.Adapter<MovieCatalogueAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<MovieCatalogueEntity>()

    fun setMovie(listMovieCatalogue: List<MovieCatalogueEntity>){
        if (listMovieCatalogue.isEmpty())
            return
        this.listMovie.clear()
        this.listMovie.addAll(listMovieCatalogue)
    }

    class MovieViewHolder(private var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieCatalogueEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemReleasedDate.text = movie.release_date

                Glide.with(itemView.context)
                    .load(movie.image).transform(RoundedCorners(28))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imagePoster)

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, MOVIE)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size
}