package a114w6077dicoding.develops.moviecatalog.ui.detail

import a114w6077dicoding.develops.moviecatalog.R
import a114w6077dicoding.develops.moviecatalog.data.MovieCatalogueEntity
import a114w6077dicoding.develops.moviecatalog.databinding.ActivityDetailBinding
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.title =title

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_FILM)
            val dataCategory = extras.getString(EXTRA_CATEGORY)

            if (dataId !== null && dataCategory != null) {
                viewModel.setFilm(dataId, dataCategory)
                val film = viewModel.getFilmDetail()
                populateDataDetail(film)
            }
        }

    }

    private fun populateDataDetail(data: MovieCatalogueEntity) {
        detailBinding.tvItemTitle.text = data.title
        detailBinding.tvItemReleaseDate.text = data.release_date
        detailBinding.tvItemOverview.text = data.overview
        detailBinding.tvItemDuration.text = data.duration
        detailBinding.tvItemScore.text = data.score.toString()

        Glide.with(this).load(data.image)
            .into(detailBinding.imagePoster)

        detailBinding.imagePoster.tag = data.image

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.action_share ->{
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "This Film ${detailBinding.tvItemTitle} is Great!!"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Movie Catalogue")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Bagikan Film Melalui"))
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }

    companion object{
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_CATEGORY = "extra_category"
    }
}