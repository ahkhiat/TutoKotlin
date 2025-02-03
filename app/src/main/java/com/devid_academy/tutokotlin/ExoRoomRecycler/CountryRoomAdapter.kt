package com.devid_academy.tutokotlin.ExoRoomRecycler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.devid_academy.tutokotlin.CountryRoom
import com.devid_academy.tutokotlin.R
import com.squareup.picasso.Picasso

class CountryRoomAdapter() : RecyclerView.Adapter<CountryRoomAdapter.CountryHolder>() {

//    private var countriesList : ArrayList<Country> = ArrayList()
    private val countriesList : MutableList<CountryRoom> = mutableListOf()

    private var rva : RecyclerCountryRoomActivity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_rv_country, parent, false)
                    .let {
                        CountryHolder(it)
                    }
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val countryRoom = countriesList.get(position)

        with(holder) {
            tvItem.text = countryRoom.countryName

            if(!countryRoom.urlFlag.isNullOrEmpty()) {
                Picasso.get()
                    .load(countryRoom.urlFlag)
                    .into(ivItem)
            } else if(countryRoom.id != null) {
//            holder.ivItem.setImageResource(country.id)
            }
//            itemLayout.setOnClickListener {
//                // lors du clic sur une ligne, à définir
//            }
        }


    }

    fun setCountries(countries: List<CountryRoom>) {
        with(countriesList) {
            clear()
            addAll(countries)
        }
        notifyDataSetChanged() // force l'adapter à recharger
    }

    fun setRva(rva: RecyclerCountryRoomActivity) {
        this.rva = rva
    }

    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvItem: TextView = itemView.findViewById(R.id.tv_item_country)
        val ivItem: ImageView = itemView.findViewById(R.id.iv_item_rv_country)
//        val itemLayout: ConstraintLayout = itemView.findViewById(R.id.cl_item_rv_country)
    }

}