package tsdev.tech.view.main.detail.presenter

interface DetailImageContract {
    interface View {
        fun updateToolbarItem(buddyIcon: String, buddyName: String)

        fun updateItem(imageUrl: String, title: String, content: String, date: String, viewCount: String, commentCount: String)

        fun showFlickrWebPage(webUrl: String)
    }

    interface Presenter {

        fun loadDetailInfo(photoId: String)

        fun loadFlickrWebPage()
    }
}