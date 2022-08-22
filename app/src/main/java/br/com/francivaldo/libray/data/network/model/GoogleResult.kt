package br.com.francivaldo.libray.data.network.model

data class GoogleResult(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)