package a114w6077dicoding.develops.moviecatalog.ui.movie

import a114w6077dicoding.develops.moviecatalog.utils.DataDummy
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {
    fun getMovie() = DataDummy.getMovie()
}