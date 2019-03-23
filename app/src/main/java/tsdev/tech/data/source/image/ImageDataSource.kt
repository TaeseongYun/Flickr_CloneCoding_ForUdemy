package tsdev.tech.data.source.image

import tsdev.tech.data.ImageData

interface ImageDataSource {

    fun loadImageFileName(imageDataList: (List<ImageData>) -> Unit, size: Int)
}