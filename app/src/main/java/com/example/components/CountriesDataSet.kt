package com.example.components
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveCountries() : SnapshotStateList<CountriesModel> {
    val countryList = remember {
        mutableStateListOf<CountriesModel>(
            CountriesModel(1,"Uzbekistan","Uzbekistan is beatiful country", R.drawable.uzbekistan),
            CountriesModel(2,"USA","USA is very beatiful country", R.drawable.usa),
            CountriesModel(3,"Canada","Canada is very beatiful country", R.drawable.canada),
            CountriesModel(4,"Iraq","Iraq is very beatiful country", R.drawable.iraq),
            CountriesModel(5,"Russia","Russia is very beatiful country", R.drawable.russia)

        )
    }
    return countryList;
}