package hasan.gurgur.covid_19.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import hasan.gurgur.covid_19.databinding.ActivityDetailBinding
import hasan.gurgur.covid_19.databinding.ActivityMainBinding
import hasan.gurgur.covid_19.model.CountryModel
import hasan.gurgur.covid_19.viewmodel.CountryListViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: CountryListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)

        val model = intent.getSerializableExtra("code")
        binding.detail = model as CountryModel?

        model?.let { viewModel.fetchDeathsValueFromRemoteApi(it.iso2) }

        viewModel.deaths.observe(this) {
            if (!it.isNullOrEmpty()) {
                binding.deathsCount.text = it[0].deaths.toString()
            }
        }

        val url = "https://countryflagsapi.com/png/${model?.iso2}"
        Glide.with(this).load(url).into(binding.ivFlag)
    }
}