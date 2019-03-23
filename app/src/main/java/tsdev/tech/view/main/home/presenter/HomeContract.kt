package tsdev.tech.view.main.home.presenter

interface HomeContract {
    interface View {
        fun hideProgress()
        fun showProgress()

    }

    interface Presenter{

        fun loadImage()
    }
}