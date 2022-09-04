package hasan.gurgur.covid_19.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hasan.gurgur.covid_19.data.CountryInstance
import hasan.gurgur.covid_19.model.CountryModel
import hasan.gurgur.covid_19.model.CountryResponseModel
import hasan.gurgur.covid_19.model.DeathsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CountryListViewModel : ViewModel() {

    val countries = MutableLiveData<List<CountryModel>>()
    val deaths = MutableLiveData<List<DeathsModel>>()

    private val countryService: CountryInstance = CountryInstance()
    private val disposable: CompositeDisposable = CompositeDisposable()


    fun fetchDataFromRemoteApi() {
        disposable.add(
            countryService.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CountryResponseModel>() {
                    override fun onSuccess(response: CountryResponseModel) {
                        val list = arrayListOf<CountryModel>()
                        response.countries.forEach {
                            if (!it.iso2.isNullOrEmpty()) {
                                list.add(it)
                            }
                        }
                        countries.value = list
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun fetchDeathsValueFromRemoteApi(country: String) {
        disposable.add(
            countryService.getDeaths(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DeathsModel>>() {
                    override fun onSuccess(deathList: List<DeathsModel>) {
                        deaths.value = deathList
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}