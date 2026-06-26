package com.example.ironasia.data.repository.model.cityResponse

typealias CityResponse = List<CityItem>

data class CityItem(
    val id: String,
    val name: String
)