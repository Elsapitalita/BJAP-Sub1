package a114w6077dicoding.develops.moviecatalog.ui.movie


import a114w6077dicoding.develops.moviecatalog.data.MovieCatalogueEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest{

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie(){
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(13, movieEntities.size)
    }

    @Test
    fun checkIndexOfBound(){
        val movieEntities = viewModel.getMovie()
        val exception = assertThrows(IndexOutOfBoundsException::class.java){
            movieEntities[14]
        }

        assertEquals("Index 14 out of bounds for length 13", exception.message)

    }

    @Test
    fun getMovieNull(){
        val movieCatalogCheck:MutableList<List<MovieCatalogueEntity>> =  mutableListOf(viewModel.getMovie())
        movieCatalogCheck.clear()
        assertTrue(movieCatalogCheck.isEmpty())
    }
}