package run.ecommerce.m2csl

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.*
import org.junit.jupiter.api.Test

@QuarkusTest
@QuarkusTestResource(MySqlDatabaseTestResource::class)
class DirectoryDataTest {

    @Test
    fun testDirectoryData() {
        given()
            .`when`().get("/customer/section/load?sections=directory-data")
            .then()
            .statusCode(200)
            .body(containsString("New York"))
    }

    @Test
    fun testAllData() {
        given()
            .`when`().get("/customer/section/load")
            .then()
            .statusCode(200)
            .body(containsString("California"))
    }

}