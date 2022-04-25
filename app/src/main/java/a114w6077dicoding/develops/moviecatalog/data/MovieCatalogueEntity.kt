package a114w6077dicoding.develops.moviecatalog.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieCatalogueEntity(
    val id: String,
    var title: String,
    var release_date: String,
    var overview: String,
    var duration: String,
    var score: Double,
    var image: Int
): Parcelable