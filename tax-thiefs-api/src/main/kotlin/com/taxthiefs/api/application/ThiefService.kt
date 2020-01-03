package com.taxthiefs.api.application

import com.taxthiefs.api.domain.ThiefRepository
import org.elasticsearch.index.query.GeoDistanceQueryBuilder
import org.springframework.stereotype.Service

@Service
class ThiefService(private val thiefRepository: ThiefRepository) {
    fun getThiefs() = thiefRepository
            .search(
                    GeoDistanceQueryBuilder("coords")
                            .point(37.5712378, 126.9659801)
                            .distance("3km")
            )
}
