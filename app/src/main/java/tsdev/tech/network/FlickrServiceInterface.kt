package tsdev.tech.network

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import tsdev.tech.BuildConfig
import tsdev.tech.data.PhotoResponse

interface FlickrServiceInterface {

    @POST("?method=flickr.photos.getRecent&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrRecentPhotos(
        @Query("text") keyword: String,
        @Query("safe_search") safeSearch: Int = 1,
        @Query("page") page: Int,
        @Query("per_Page") perPage: Int
    ): Call<PhotoResponse>
}