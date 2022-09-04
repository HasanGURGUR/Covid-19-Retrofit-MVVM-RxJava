package hasan.gurgur.covid_19.data

import hasan.gurgur.covid_19.model.CountryModel
import hasan.gurgur.covid_19.model.CountryResponseModel
import hasan.gurgur.covid_19.model.DeathsModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/countries")
    fun getCountries(): Single<CountryResponseModel>

    @GET("api/countries/{country}/deaths")
    fun getDeaths( @Path("country") country: String) : Single<List<DeathsModel>>
}