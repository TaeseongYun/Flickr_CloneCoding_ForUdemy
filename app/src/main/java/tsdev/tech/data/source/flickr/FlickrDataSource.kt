package tsdev.tech.data.source.flickr

import retrofit2.Call
import tsdev.tech.data.PhotoResponse

interface FlickrDataSource {

    fun getRecentPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>
}