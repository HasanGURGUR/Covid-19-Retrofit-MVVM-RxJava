package hasan.gurgur.covid_19.data

import hasan.gurgur.covid_19.model.CountryResponseModel
import hasan.gurgur.covid_19.model.DeathsModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryInstance {

    private val BASE_URL = "https://covid19.mathdro.id/"
    private val api  = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getCountries() : Single<CountryResponseModel>{
        return api.getCountries()
    }

    fun getDeaths(country : String) : Single<List<DeathsModel>> {
        return api.getDeaths(country)
    }
}