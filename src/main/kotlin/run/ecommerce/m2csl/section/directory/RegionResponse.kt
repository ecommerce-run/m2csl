package run.ecommerce.m2csl.section.directory

import kotlinx.serialization.Serializable

@Serializable
data class Region(val code: String, val name: String)

@Serializable
data class DirectoryData(val name: String, val regions: Map<String, Region>, val dataId: Long)