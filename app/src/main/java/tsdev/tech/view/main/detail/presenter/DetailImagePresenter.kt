package tsdev.tech.view.main.detail.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tsdev.tech.data.PhotoInfo
import tsdev.tech.data.source.flickr.FlickrRepository
import tsdev.tech.util.decimalFormat
import tsdev.tech.util.getDate

class DetailImagePresenter(val view: DetailImageContract.View,
                           private val repository: FlickrRepository) : DetailImageContract.Presenter {

    private var webUrl: String = ""

    override fun loadDetailInfo(photoId: String) {
        repository.getPhotoDetail(photoId)
            .enqueue(object : Callback<PhotoInfo> {


                override fun onResponse(call: Call<PhotoInfo>, response: Response<PhotoInfo>?) {
                    if( response?.isSuccessful == true) {
                        response.body()?.takeIf { it.stat == "ok" }?.let {
                            //처리 부분
                            it.photo.let {
                                view.updateItem(
                                    it.getImageUrl(),
                                    it.title._content,
                                    it.description._content,
                                    it.dates.lastupdate.getDate("MM-dd-yyyy hh:mm:ss"),
                                    it.views.toString().decimalFormat(),
                                    it.comments._content.toString().decimalFormat())

                                view.updateToolbarItem(
                                    it.owner.getBouddyIcons(),
                                    it.owner.username)

                                //null 이면 null 리턴 하여서 엘비스 연산자가 빈칸으로 대체
                                webUrl = it.urls.url.firstOrNull()?._content ?: ""
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<PhotoInfo>, t: Throwable) {

                }
            })
    }

    override fun loadFlickrWebPage() {
        //url을 가지고 와야하는데 포토 안에 url 이 존재한다.
        if(webUrl.isNotEmpty()) {
            view.showFlickrWebPage(webUrl)
        }
    }

}