package run.ecommerce.m2csl.section.directory

import jakarta.enterprise.context.ApplicationScoped
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import run.ecommerce.m2csl.section.GetSectionInterface


@ApplicationScoped
class DirectoryConfig {

    var country: String = "US"
//    @field:ConfigProperty(name = "directory.config.country", defaultValue = "US")
//    lateinit var country: String

//    @field:ConfigProperty(name = "directory.config.country", defaultValue = "United States")
//    lateinit var countryName: String

    var countryName: String = "Unites States"
}

@ApplicationScoped
class DirectoryDataSection(
    private val config: DirectoryConfig
) : GetSectionInterface {

    val regions = DirectoryCountryRegion.findByCountryCode(config.country).associate {
        it.regionId.toString() to Region(it.code, it.defaultName)
    }

    override fun getSection(sessionCookieValue: String?, currentTime: Long): JsonElement {
        val directoryData = DirectoryData(config.countryName, regions, currentTime)
        return Json.encodeToJsonElement(directoryData)
    }
}