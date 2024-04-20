package run.ecommerce.m2csl

import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import kotlinx.serialization.json.JsonElement
import run.ecommerce.m2csl.section.directory.DirectoryDataSection

@Path("/customer/section/load")
class CustomerSectionLoadController (
    private val directoryDataSection: DirectoryDataSection
) {


    val availableSections = mapOf(
        "directory-data" to directoryDataSection
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getCustomerSectionLoad(@QueryParam("sections") @DefaultValue("") sections: String): Map<String,JsonElement> {
        val currentTimestamp = System.currentTimeMillis()/1000
        val sessionId = "sess_id"
        if (sections == "") {
            return availableSections.mapValues {
                it.value.getSection(sessionId, currentTimestamp)
            }
        } else {
            val sessionsSet = sections.split(',').toSet()
            return availableSections.filterKeys {
                sessionsSet.contains(it)
            }.mapValues {
                it.value.getSection(sessionId, currentTimestamp)
            }
        }

        return mapOf()
    }
}