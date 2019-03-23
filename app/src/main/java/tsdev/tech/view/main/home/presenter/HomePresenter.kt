package tsdev.tech.view.main.home.presenter

import android.os.AsyncTask
import tsdev.tech.data.source.image.ImageRepository
import tsdev.tech.util.random
import tsdev.tech.view.main.home.adapter.model.ImageRecyclerModel

class HomePresenter(val view: HomeContract.View,
                    private val imageRepository: ImageRepository,
                    private val imageRecyclerModel: ImageRecyclerModel) : HomeContract.Presenter {

    var isLoading = false

    override fun loadImage() {
        ImageAsyncTask(this, view, imageRepository, imageRecyclerModel).execute()
    }

    class ImageAsyncTask(val homePresenter: HomePresenter,
                         val view: HomeContract.View,
                         private val imageRepository: ImageRepository,
                         private val imageRecyclerModel: ImageRecyclerModel) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?){

            imageRepository.loadImageFileName ({
                it.forEach {
                    imageRecyclerModel.addItem(it)
                }
            }, 10)
            Thread.sleep(1000)
        }

        override fun onPreExecute() {
            super.onPreExecute()

            homePresenter.isLoading = true
            view.showProgress()
        }

        //doInBackground에서 처리가 완료되면 여기로 결과가 날라옴
        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            imageRecyclerModel.notifyDataSetChang()
            view.hideProgress()

            homePresenter.isLoading = false
        }

    }
}