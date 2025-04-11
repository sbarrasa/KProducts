package com.sbarrasa.bank.product.factory

import com.sbarrasa.bank.product.Product
import com.sbarrasa.bank.product.types.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProductRegistryTest{
    @BeforeEach
    fun init(){
        ProductRegistry
            .register("CC", ::SavingAccount)
            .register(CheckingAccount)
            .register(CreditCard)
            .register(DebitCard)

    }

    @Test
    fun containsProductType(){
        assertTrue("TC" in ProductRegistry)
        assertFalse("casa" in ProductRegistry)
    }

    @Test
    fun containsProductClass(){
        assertTrue(SavingAccount::class in ProductRegistry)
        assertFalse(Product::class in ProductRegistry)
    }


    @Test
    fun unknownProductType() {
        assertThrows<ProductTypeNotRegistered>{ProductRegistry.create<Product>("HOLA")}

    }

    @Suppress("UNUSED_VARIABLE")
    @Test
    fun invalidCastProductType() {
        assertThrows<ClassCastException> {
            val product: SavingAccount = ProductRegistry.create("TC")
        }

    }

    @Test
    fun createSavingAccount() {
        assertDoesNotThrow { ProductRegistry.create<SavingAccount>("CC")}
    }

    @Test
    fun createCheckingAccount() {
        assertDoesNotThrow { ProductRegistry.create<CheckingAccount>("CA")}
    }

    @Test
    fun createCreditCard() {
        assertDoesNotThrow { ProductRegistry.create<CreditCard>("TC")}
    }

    @Test
    fun createDebitCard() {
        assertDoesNotThrow{ProductRegistry.create<DebitCard>("TD")}
    }

    @Test
    fun accounts(){
        assertEquals(2, ProductRegistry.getProductClasses(Account::class).size)
    }

    @Test
    fun credit(){
        assertEquals(setOf(CreditCard::class, SavingAccount::class), ProductRegistry.getProductClasses(CreditProduct::class))
    }

    @Test
    fun products(){
        assertEquals(4, ProductRegistry.getProductClasses().size)
    }

    @Test
    fun classNotRegistered(){
        assertEquals(emptySet<Any>(), ProductRegistry.getProductClasses(String::class))
    }

}