package tsdev.tech.data.source.flickr

import retrofit2.Call
import tsdev.tech.data.PhotoResponse

object FlickrRepository : FlickrDataSource {


    private val flickrRemoteData = FlickrRemoteData()

    override fun getRecentPhoto(keyword: String, page: Int, perPage: Int)
            = flickrRemoteData.getRecentPhoto(
        keyword,
        page,
        perPage
    )

}