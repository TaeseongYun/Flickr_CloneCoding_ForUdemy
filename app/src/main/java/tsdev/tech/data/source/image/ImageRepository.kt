package tsdev.tech.data.source.image

import tsdev.tech.data.ImageData

object ImageRepository : ImageDataSource{


    private val IMAGE_REMOTE_DATA: ImageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImageFileName(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        IMAGE_REMOTE_DATA.loadImageFileName(imageDataList, size)
    }
}