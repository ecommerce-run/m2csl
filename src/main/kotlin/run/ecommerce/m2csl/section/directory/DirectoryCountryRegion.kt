package run.ecommerce.m2csl.section.directory

import io.quarkus.hibernate.orm.panache.kotlin.*
import jakarta.persistence.*

@Entity
@Table(name = "directory_country_region")
class DirectoryCountryRegion : PanacheEntityBase {
    companion object: PanacheCompanion<DirectoryCountryRegion> {
        fun findByCountryCode(countryId: String) = list("countryId", countryId)

    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "region_id")
    var regionId: Int = 0

    @Column(name = "code")
    lateinit var code: String

    @Column(name = "default_name")
    lateinit var defaultName: String

    @Column(name = "country_id")
    lateinit var countryId: String
}