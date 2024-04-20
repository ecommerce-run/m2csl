package run.ecommerce.m2csl

import io.quarkus.test.junit.QuarkusTest
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import run.ecommerce.m2csl.section.directory.DirectoryCountryRegion

@QuarkusTest
class DirectoryCountryRegionTest {

    @Test
    fun testCountryRegion() {
        val countryRegion  = DirectoryCountryRegion()
        countryRegion.countryId = "US"
        countryRegion.code = "DE"
        countryRegion.defaultName = "Delaware"
        assertEquals("US", countryRegion.countryId )
    }

}