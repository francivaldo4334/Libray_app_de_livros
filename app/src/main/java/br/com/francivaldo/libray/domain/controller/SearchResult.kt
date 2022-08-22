package br.com.francivaldo.libray.domain.controller
import br.com.francivaldo.libray.data.network.model.VolumeInfo
import br.com.francivaldo.libray.presentation.model.UiModel

data class SearchResult(
    var image_url:String = "",
    var title:String = "",
    var author:String = "",
    var description:String = ""
)
fun SearchResult.toUiModel():UiModel = UiModel(
    image_url = this.image_url+".png",
    title = this.title,
    author = this.author,
    description = this.description
)
fun SearchResult.fromData(item:VolumeInfo):SearchResult = SearchResult(
    image_url = item.imageLinks.thumbnail,
    author = item.authors.toString(),
    title = item.title,
    description = if(item.description != null) item.description else ""
)
