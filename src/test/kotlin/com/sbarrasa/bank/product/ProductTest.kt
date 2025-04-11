package com.sbarrasa.bank.product

import com.sbarrasa.bank.product.types.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductTest {
    @Test
    fun creditCardProduct() {
        val product = CreditCard().apply { branch = Branch.VISA}

        assertTrue(product is CreditProduct)
        assertEquals(CreditCard.productType, product.productType)
        assertEquals(Branch.VISA, product.branch)
        assertEquals("${CreditCard.name} ${product.branch?.description}", product.description())

        product.tier = "GOLD"

        assertEquals("${CreditCard.name} ${product.branch?.description} GOLD", product.description())
    }

    @Test
    fun debitCard() {
        val product = DebitCard().apply { branch = Branch.MC}
        assertFalse(product is CreditProduct)
        assertEquals(DebitCard.productType, product.productType)
        assertEquals(Branch.MC, product.branch)

    }

    @Test
    fun checkingAccount() {
        val product = CheckingAccount().apply { cbu="1234"; currency = Currency.USD}
        assertFalse(product is CreditProduct)
        assertEquals(CheckingAccount.productType, product.productType)
        assertEquals("${CheckingAccount.name} en ${Currency.USD.description}", product.description())

    }

    @Test
    fun incompleteProduct() {
        val product = CheckingAccount()
        assertFalse(product is CreditProduct)
        assertEquals("${CheckingAccount.name} en null", product.description())

    }

    @Test
    fun isProduct(){
        val creditCard = CreditCard().apply { branch = Branch.VISA}
        assertTrue(creditCard is CreditProduct)
        assertFalse(creditCard is Account)
        assertTrue(creditCard is Product)
        assertTrue(creditCard is Card)
    }

}