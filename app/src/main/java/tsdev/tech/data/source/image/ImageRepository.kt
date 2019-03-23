package tsdev.tech.data.source.image

import tsdev.tech.data.ImageData

object ImageRepository : ImageDataSource{


    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileName(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageFileName(imageDataList, size)
    }
}