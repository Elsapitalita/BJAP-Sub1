package a114w6077dicoding.develops.moviecatalog.ui.tv

import a114w6077dicoding.develops.moviecatalog.data.MovieCatalogueEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }


    @Test
    fun getTVShow(){
        val tvShowEntities = viewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(11, tvShowEntities.size)
    }

    @Test
    fun checkIndexOfBound(){
        val tvShowEntities = viewModel.getTvShow()
        val exception = assertThrows(IndexOutOfBoundsException::class.java){
            tvShowEntities[12]
        }

        assertEquals("Index 12 out of bounds for length 11", exception.message)

    }

    @Test
    fun getTVShowNull(){
        val tvShowCatalogCheck:MutableList<List<MovieCatalogueEntity>> = mutableListOf(viewModel.getTvShow())
        tvShowCatalogCheck.clear()
        assertTrue(tvShowCatalogCheck.isEmpty())
    }

}