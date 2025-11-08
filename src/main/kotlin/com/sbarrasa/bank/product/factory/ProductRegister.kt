package com.sbarrasa.bank.product.factory

import com.sbarrasa.bank.product.Product
import com.sbarrasa.bank.product.ProductHeader
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
interface ProductRegister<T: Product>: ProductHeader {
    fun productClass(): KClass<T> =
        (this::class.supertypes.first().arguments.first().type!!.classifier as KClass<T>)

    fun creator():ProductCreator<T> = productClass().constructors.first() as ProductCreator<T>

}