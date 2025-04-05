package com.sbarrasa.bank.product.factory

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sbarrasa.bank.product.Product
import com.sbarrasa.bank.product.dto.ProductDTO
import java.time.LocalDate

object ProductAdapter {
    private val mapper = jacksonObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .registerModule(JavaTimeModule())
        .registerModule(SimpleModule().apply {
            addDeserializer(LocalDate::class.java, CardDateDeserializer())
        })
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)


    fun <T:Product> map(dto: ProductDTO, product: T): T{
        val json = mapper.writeValueAsString(dto.attributes)
        return mapper.readerForUpdating(product).readValue(json)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: Product> create(dto: ProductDTO): T {
        val product: Product = ProductRegistry.create(dto.productType)

        return map(dto, product) as T
    }
}