package hasan.gurgur.covid_19.model

import java.io.Serializable

data class CountryModel(
    val iso2: String,
    val iso3: String,
    val name: String
):Serializable

data class CountryResponseModel(
    val countries : List<CountryModel>
):Serializable
