package a114w6077dicoding.develops.moviecatalog.ui.detail

import a114w6077dicoding.develops.moviecatalog.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getMovie()[0]
    private val dummyMovieId = dummyMovie.id

    private val dummyTvShow = DataDummy.getTvShow()[0]
    private val dummyTvShowId = dummyTvShow.id


    @Before
    fun setUpMovie(){
        viewModel = DetailViewModel()
        viewModel.setFilm(dummyMovieId, "movie")
    }

    @Test
    fun getMovieDetail(){
        viewModel.setFilm(dummyMovie.id, "movie")
        val movie = viewModel.getFilmDetail()
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.release_date, movie.release_date)
        assertEquals(dummyMovie.overview, movie.overview)
        assertEquals(dummyMovie.duration, movie.duration)
        assertEquals(dummyMovie.image, movie.image)
    }

    @Before
    fun setUpTvShow(){
        viewModel = DetailViewModel()
        viewModel.setFilm(dummyTvShowId, "tvShow")
    }

    @Test
    fun getTvShowDetail(){
        viewModel.setFilm(dummyTvShow.id, "tvShow")
        val tvShow = viewModel.getFilmDetail()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.release_date, tvShow.release_date)
        assertEquals(dummyTvShow.overview, tvShow.overview)
        assertEquals(dummyTvShow.duration, tvShow.duration)
        assertEquals(dummyTvShow.image, tvShow.image)
    }


}