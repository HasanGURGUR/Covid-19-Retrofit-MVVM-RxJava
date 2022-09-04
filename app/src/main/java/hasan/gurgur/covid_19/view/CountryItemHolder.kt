package hasan.gurgur.covid_19.view

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.covid_19.BaseViewHolder
import hasan.gurgur.covid_19.databinding.ItemCountryLayoutBinding
import hasan.gurgur.covid_19.model.CountryModel

class CountryItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemCountryLayoutBinding>(
    binding = ItemCountryLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        country : CountryModel,
        characterClickCallback : ((CountryModel) -> Unit)? = null
    ) {
        with(binding) {
            binding.country = country
            binding.mainLayout.setOnClickListener{
                characterClickCallback?.invoke(country)
            }
            executePendingBindings()
        }
    }


}
