package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.Branch
import com.sbarrasa.bank.product.Product
import java.time.LocalDate

abstract class Card(header: ProductHeader): Product(header) {
    var branch: Branch? = null
    var number: String? = null
    var expirationDate: LocalDate? = null
    override fun description() = "${super.description()} ${branch?.description}"
}