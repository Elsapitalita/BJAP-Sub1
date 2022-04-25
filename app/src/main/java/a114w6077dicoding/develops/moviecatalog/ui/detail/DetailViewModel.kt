package a114w6077dicoding.develops.moviecatalog.ui.detail

import a114w6077dicoding.develops.moviecatalog.data.MovieCatalogueEntity
import a114w6077dicoding.develops.moviecatalog.utils.DataDummy
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel() {

    companion object{
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }

    private lateinit var film: MovieCatalogueEntity

    fun setFilm(id: String, category: String){
        when(category){
            MOVIE -> {
                for (movie in DataDummy.getMovie()) {
                    if (movie.id == id) film = movie
                }
            }

            TV_SHOW -> {
                for (tvShow in DataDummy.getTvShow()){
                    if (tvShow.id == id) film = tvShow
                }
            }
        }
    }

    fun getFilmDetail() = film
}