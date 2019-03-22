package tsdev.tech.view.main.home.presenter

interface HomeContract {
    interface View {
        fun hideProgress()
        fun showProgress()

        fun showImage(imageName: String)
    }

    interface Presenter{

        fun loadImage()
    }
}