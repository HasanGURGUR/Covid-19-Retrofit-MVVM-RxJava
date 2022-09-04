package hasan.gurgur.covid_19.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.covid_19.databinding.ActivityMainBinding
import hasan.gurgur.covid_19.model.CountryModel
import hasan.gurgur.covid_19.model.DeathsModel
import hasan.gurgur.covid_19.viewmodel.CountryListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CountryListViewModel
    lateinit var countryListAdapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        viewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)
        viewModel.fetchDataFromRemoteApi()

        viewModel.countries.observe(this) {
            countryListAdapter.submitList(it)
        }
    }

    private fun initAdapter() {
        countryListAdapter = CountryListAdapter {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("code", it)
            startActivity(intent)
        }

        binding.countryRec.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.countryRec.adapter = countryListAdapter
    }

}