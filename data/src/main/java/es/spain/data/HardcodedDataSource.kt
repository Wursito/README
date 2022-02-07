package es.spain.data

import es.spain.domain.entity.Film
import javax.inject.Inject

class HardcodedDataSource @Inject constructor(){
    fun getfilm(): Film {
        return Film(
            title = "FastAndFurious",
            url = "www.Tofasttofurious.com",
            rating = 10.0,
            directorName = "Michael Jack",
            description = "Peliculon",
            id = 1,
            videoId = null

        )
    }

}