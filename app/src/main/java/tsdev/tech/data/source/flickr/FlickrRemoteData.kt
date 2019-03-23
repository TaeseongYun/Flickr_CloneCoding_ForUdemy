package tsdev.tech.data.source.flickr

import retrofit2.Call
import tsdev.tech.data.PhotoResponse
import tsdev.tech.network.FlickrServiceInterface
import tsdev.tech.network.createRetrofit

class FlickrRemoteData : FlickrDataSource {

    companion object {
        const val FILCKR_URL = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FILCKR_URL)

    override fun getRecentPhoto(keyword: String, page: Int, perPage: Int)
            = flickrServiceInterface.getFlickrRecentPhotos(
        keyword = keyword,
        page = page,
        perPage = perPage)

}