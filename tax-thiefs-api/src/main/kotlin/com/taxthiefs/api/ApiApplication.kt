package com.taxthiefs.api

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.filter.CharacterEncodingFilter
import java.nio.charset.Charset

@SpringBootApplication
class ApiApplication {
    @Bean
    fun client(): RestHighLevelClient? {
        val clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200", "localhost:9300")
                .build()
        return RestClients.create(clientConfiguration).rest()
    }

    @Bean
    fun responseBodyConverter(): HttpMessageConverter<String?>? {
        return StringHttpMessageConverter(Charset.forName("UTF-8"))
    }

    @Bean
    fun characterEncodingFilter(): CharacterEncodingFilter? {
        val characterEncodingFilter = CharacterEncodingFilter()
        characterEncodingFilter.encoding = "UTF-8"
        characterEncodingFilter.setForceEncoding(true)
        return characterEncodingFilter
    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
