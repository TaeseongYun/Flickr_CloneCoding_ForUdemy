package tsdev.tech.data.source.flickr

import retrofit2.Call
import tsdev.tech.data.PhotoInfo
import tsdev.tech.data.PhotoResponse
import tsdev.tech.network.FlickrServiceInterface
import tsdev.tech.network.createRetrofit

class FlickrRemoteData : FlickrDataSource {


    companion object {
        const val FLICKR_URL = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
            = flickrServiceInterface.getFlickrSearchPhotos(
        keyword = keyword,
        page = page,
        perPage = perPage)

    override fun getPhotoDetail(photoId: String): Call<PhotoInfo>
            = flickrServiceInterface.getFlickrPhotoDetail(photoId)

}