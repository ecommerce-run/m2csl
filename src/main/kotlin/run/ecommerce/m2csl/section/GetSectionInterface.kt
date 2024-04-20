package run.ecommerce.m2csl.section

import kotlinx.serialization.json.JsonElement

fun interface GetSectionInterface {
     fun getSection(sessionCookieValue: String?, currentTime: Long): JsonElement
}