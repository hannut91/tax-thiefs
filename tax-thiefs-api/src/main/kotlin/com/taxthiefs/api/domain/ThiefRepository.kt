package com.taxthiefs.api.domain

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ThiefRepository : ElasticsearchRepository<Thief, Int>
