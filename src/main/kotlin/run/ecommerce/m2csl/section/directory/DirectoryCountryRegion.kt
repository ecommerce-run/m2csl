package run.ecommerce.m2csl.section.directory

import io.quarkus.hibernate.orm.panache.kotlin.*
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "directory_country_region")
class DirectoryCountryRegion : PanacheEntityBase {
    companion object: PanacheCompanion<DirectoryCountryRegion> {
        fun findByCountryCode(country_id: String) = list("countryId", country_id)

    }
    @Id
    @GeneratedValue
    @Column(name = "region_id")
    var regionId: Long = 0

    @Column(name = "code")
    lateinit var code: String

    @Column(name = "default_name")
    lateinit var defaultName: String

    @Column(name = "country_id")
    lateinit var countryId: String
}