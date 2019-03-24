package tsdev.tech.data

data class PhotoInfo(
    val photo: PhotoDetail,
    val stat: String
)

data class PhotoDetail(
    val comments: Comments,
    val dates: Dates,
    val dateuploaded: String,
    val description: Description,
    val editability: Editability,
    private val farm: Int,
    val id: String,
    val isfavorite: Int,
    val license: Int,
    val media: String,
    val notes: Notes,
    val originalformat: String,
    val originalsecret: String,
    val owner: Owner,
    val people: People,
    val publiceditability: Publiceditability,
    val rotation: Int,
    val safety_level: Int,
    private val secret: String,
    private val server: String,
    val tags: Tags,
    val title: Title,
    val urls: Urls,
    val usage: Usage,
    val views: Int,
    val visibility: Visibility
){
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}

data class Urls(
    val url: List<Url>
)

data class Url(
    val _content: String,
    val type: String
)

data class Tags(
    val tag: List<Tag>
)

data class Tag(
    val _content: String,
    val author: String,
    val authorname: String,
    val id: String,
    val machine_tag: Int,
    val raw: String
)

data class Title(
    val _content: String = "Eiffel"
)

data class Comments(
    val _content: Int
)

data class Visibility(
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int
)

data class Editability(
    val canaddmeta: Int,
    val cancomment: Int
)

data class Notes(
    val note: List<Any>
)

data class Publiceditability(
    val canaddmeta: Int,
    val cancomment: Int
)

data class Description(
    val _content: String
)

data class Owner(
    val iconfarm: Int,
    val iconserver: String,
    val location: String,
    val nsid: String,
    val path_alias: String,
    val realname: String,
    val username: String
){
    fun getBouddyIcons()
            = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}

data class People(
    val haspeople: Int
)

data class Dates(
    val lastupdate: String,
    val posted: String,
    val taken: String,
    val takengranularity: Int,
    val takenunknown: Int
)

data class Usage(
    val canblog: Int,
    val candownload: Int,
    val canprint: Int,
    val canshare: Int
)