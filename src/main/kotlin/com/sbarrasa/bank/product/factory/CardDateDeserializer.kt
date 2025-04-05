package com.sbarrasa.bank.product.factory

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class CardDateDeserializer : JsonDeserializer<LocalDate>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDate {
        val text = p.text.trim()
        return try { LocalDate.parse(text) }
               catch (e: DateTimeParseException) {
                    val formatter = DateTimeFormatter.ofPattern("MM/yy")
                    YearMonth.parse(text, formatter).atDay(1)
               }
    }
}