package hasan.gurgur.covid_19.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.covid_19.BaseListAdapter
import hasan.gurgur.covid_19.model.CountryModel

class CountryListAdapter(
    private val characterClickCallback: ((CountryModel?) -> Unit)?
) : BaseListAdapter<CountryModel>(
    itemsSame = { old, new -> old.iso2 == new.iso2 },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CountryItemHolder -> {
                holder.bind(
                    country = getItem(position),
                    characterClickCallback = characterClickCallback
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CountryItemHolder(parent, inflater)
    }

}
