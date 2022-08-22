package br.com.francivaldo.libray.data.model

data class SeriesInfo(
    val bookDisplayNumber: String,
    val kind: String,
    val volumeSeries: List<VolumeSery>
)