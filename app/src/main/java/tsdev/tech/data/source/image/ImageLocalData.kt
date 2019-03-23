package tsdev.tech.data.source.image

import tsdev.tech.data.ImageData
import tsdev.tech.util.random

class ImageLocalData : ImageDataSource {
    override fun loadImageFileName(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()
        for(index in 1..size) {
            val name = String.format("sample_%02d", (1..10).random() + 1)
            list.add(ImageData(name, name))
        }
        imageDataList(list)
    }
}