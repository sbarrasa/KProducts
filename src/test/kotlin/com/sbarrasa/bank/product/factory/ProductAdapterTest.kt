package com.sbarrasa.bank.product.factory

import com.sbarrasa.bank.product.Branch
import com.sbarrasa.bank.product.Currency
import com.sbarrasa.bank.product.dto.ProductDTO
import com.sbarrasa.bank.product.types.CheckingAccount
import com.sbarrasa.bank.product.types.CreditCard
import com.sbarrasa.bank.product.types.DebitCard
import com.sbarrasa.bank.product.types.SavingAccount
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ProductAdapterTest {
    @BeforeEach
    fun init(){
        ProductRegistry
            .register(SavingAccount)
            .register(CheckingAccount)
            .register(CreditCard)
            .register(DebitCard)

    }

    @Test
    fun savingAccount() {
        val dto = ProductDTO("CC").apply {
            this["cbu"] = "123456789"
            this["currency"] = Currency.USD
            this["creditLimit"] = 1234.56
            this["dummy"] = "hola"
        }

        val product: SavingAccount = ProductAdapter.create(dto)

        assertNotNull(product)
        assertEquals("123456789", product.cbu)
        assertEquals(Currency.USD, product.currency)
    }

    @Test
    fun debitCard() {
        val dto = ProductDTO("TD").apply {
            this["number"] = "987654321"
            this["expirationDate"] = "12/27"
            this["branch"] = Branch.VISA
        }

        val product:DebitCard = ProductAdapter.create(dto)

        assertNotNull(product)
        assertEquals(Branch.VISA, product.branch)
        assertEquals("987654321", product.number)
        assertEquals(LocalDate.of(2027, 12,1), product.expirationDate)
    }

    @Test
    fun cardDate() {
        val dto = ProductDTO("TD").apply {
            this["expirationDate"] = "2027-12-01"
        }

        val product:DebitCard = ProductAdapter.create(dto)

        assertNotNull(product)
        assertEquals(LocalDate.of(2027, 12,1), product.expirationDate)
    }

    @Test
    fun cardBranch() {
        var dto = ProductDTO("TD").apply {
            set("branch", Branch.AMEX)
        }

        var product:DebitCard? = ProductAdapter.create(dto)
        assertEquals(Branch.AMEX, product?.branch)

        dto = ProductDTO("TD").apply {
            set("branch","AMEX")
        }

        product = ProductAdapter.create(dto)
        assertEquals(Branch.AMEX, product.branch)

        dto = ProductDTO("TD").apply {
            set("branch", 2)
        }

        product = ProductAdapter.create(dto)
        assertEquals(Branch.AMEX, product.branch)

    }


}