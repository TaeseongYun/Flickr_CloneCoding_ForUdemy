package tsdev.tech.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import tsdev.tech.R
import tsdev.tech.data.source.flickr.FlickrRepository
import tsdev.tech.data.source.image.ImageRepository
import tsdev.tech.view.main.home.adapter.ImageRecyclerAdapter
import tsdev.tech.view.main.home.presenter.HomeContract
import tsdev.tech.view.main.home.presenter.HomePresenter

class HomeFragment : Fragment(), HomeContract.View {
    override fun showLoadFail() {
        if( isDetached ) return

        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail(message: String) {
        if( isDetached ) return

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment,
            FlickrRepository,
            ImageRepository,
            imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@HomeFragment.context)
    }
    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadFlickrImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)

//            여기 add의 리스너는 계속 적으로 추가 하겠다는 말이기때문에
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

//        꼭 여기서 뷰가 사라졌을때 remove를 해줘야 함함
        recycler_view?.removeOnScrollListener(recyclerViewOnScrollListener)
    }
    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)


            val visibleItemCount = recyclerView?.childCount as Int
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!homePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 3) {
                homePresenter.loadFlickrImage()
            }
        }
    }
}