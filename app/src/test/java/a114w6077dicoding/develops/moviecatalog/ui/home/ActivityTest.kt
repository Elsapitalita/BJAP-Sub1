package a114w6077dicoding.develops.moviecatalog.ui.home

import a114w6077dicoding.develops.moviecatalog.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class ActivityTest{

    private lateinit var activity: MainActivity

    @Before
    fun setUp(){
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create().resume().get()
    }

    @Test
    fun shouldHaveCorrectAppName(){
        val appName = activity.resources.getString(R.string.app_name)
        assertEquals(appName, "Movie Catalogue")
    }

    @Test
    fun checkActivityNotNull(){
        assertNotNull(activity)
    }



}