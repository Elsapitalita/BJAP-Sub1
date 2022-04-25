package a114w6077dicoding.develops.moviecatalog.ui.home

import a114w6077dicoding.develops.moviecatalog.R
import a114w6077dicoding.develops.moviecatalog.utils.DataDummy
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    private val dummyMovie = DataDummy.getMovie()
    private val dummyTvShow = DataDummy.getTvShow()

    private val dummyTitleMovie = "Wreck-It Ralph"
    private val dummyReleaseDateMovie = "11/02/2012 (US)"
    private val dummyScoreMovie = "7.3"
    private val dummyOverviewMovie = "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Venellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started."
    private val dummyDurationMovie = "1h 41m"

    private val dummyTitleTvShow = "Arrow"
    private val dummyReleaseDateTvShow = "2012"
    private val dummyScoreTvShow = "6.7"
    private val dummyOverviewTvShow = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
    private val dummyDurationTvShow = "42m"



    @Before
    fun setUp(){
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun loadMovie(){
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemScore)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_itemDuration)).check(matches(isDisplayed()))

    }

    @Test
    fun loadTVShow(){
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTVShow(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemScore)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_ItemOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_itemDuration)).check(matches(isDisplayed()))

    }

    @Test
    fun checkViewValueDetailMovie(){
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_ItemTitle)).check(matches(withText(dummyTitleMovie)))
        onView(withId(R.id.tv_ItemReleaseDate)).check(matches(withText(dummyReleaseDateMovie)))
        onView(withId(R.id.tv_ItemScore)).check(matches(withText(dummyScoreMovie)))
        onView(withId(R.id.tv_ItemOverview)).check(matches(withText(dummyOverviewMovie)))
        onView(withId(R.id.tv_itemDuration)).check(matches(withText(dummyDurationMovie)))
    }

    @Test
    fun checkViewValueDetailTvShow(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_ItemTitle)).check(matches(withText(dummyTitleTvShow)))
        onView(withId(R.id.tv_ItemReleaseDate)).check(matches(withText(dummyReleaseDateTvShow)))
        onView(withId(R.id.tv_ItemScore)).check(matches(withText(dummyScoreTvShow)))
        onView(withId(R.id.tv_ItemOverview)).check(matches(withText(dummyOverviewTvShow)))
        onView(withId(R.id.tv_itemDuration)).check(matches(withText(dummyDurationTvShow)))
    }
}