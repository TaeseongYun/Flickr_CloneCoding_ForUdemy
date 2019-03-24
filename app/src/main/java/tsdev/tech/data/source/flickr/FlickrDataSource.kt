package tsdev.tech.data.source.flickr

import retrofit2.Call
import tsdev.tech.data.PhotoInfo
import tsdev.tech.data.PhotoResponse

interface FlickrDataSource {

    fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>

    fun getPhotoDetail(photoId: String): Call<PhotoInfo>
}