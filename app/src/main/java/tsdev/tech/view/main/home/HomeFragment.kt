package tsdev.tech.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import tsdev.tech.R
import tsdev.tech.view.main.home.presenter.HomeContract
import tsdev.tech.view.main.home.presenter.HomePresenter

class HomeFragment : Fragment(), HomeContract.View {

    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment)
    }
    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showImage(imageName: String) {
        //기본적으로 불러오는 방식
//        imageView.setImageResource(R.drawable.sample_01)
        // Udemy에서 알려준 방식  위에것과 동일
        imageView.setImageResource(resources.getIdentifier(imageName, "drawable", context.packageName))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadImage()
    }
}