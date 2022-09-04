package hasan.gurgur.covid_19.model

import java.io.Serializable

data class DeathsModel(
    val active: Int,
    val admin2: Any,
    val cases28Days: Int,
    val combinedKey: String,
    val confirmed: Int,
    val countryRegion: String,
    val deaths: Int,
    val deaths28Days: Int,
    val fips: Any,
    val incidentRate: Double,
    val iso3: String,
    val lastUpdate: Long,
    val lat: Double,
    val long: Double,
    val peopleHospitalized: Any,
    val peopleTested: Any,
    val provinceState: Any,
    val recovered: Any,
    val uid: Int
):Serializable