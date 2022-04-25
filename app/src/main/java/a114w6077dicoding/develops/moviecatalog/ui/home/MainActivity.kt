package a114w6077dicoding.develops.moviecatalog.ui.home

import a114w6077dicoding.develops.moviecatalog.R
import a114w6077dicoding.develops.moviecatalog.ui.movie.MovieFragment
import a114w6077dicoding.develops.moviecatalog.ui.tv.TvShowFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewPager()
    }

    private fun setViewPager(){
        val fragmentList = listOf(MovieFragment(), TvShowFragment())
        val tabTitle = listOf("Movie", "TV Show")

        view_pager.adapter = SectionPagerAdapter(fragmentList, this.supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout2, view_pager){
            tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}