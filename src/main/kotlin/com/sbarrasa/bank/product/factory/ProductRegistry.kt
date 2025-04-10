package com.sbarrasa.bank.product.factory

import com.sbarrasa.bank.product.Product
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

typealias ProductCreator<T> = () -> T

object ProductRegistry {
    private val creators = HashMap<String, ProductCreator<out Product>>()
    private val classes = HashMap<String, KClass<out Product>>()

    operator fun contains(productType: String) = creators.containsKey(productType)
    operator fun contains(productClass: KClass<out Product>) = productClass in classes.values

    fun <T : Product> register(productRegister: ProductRegister<T>): ProductRegistry {
        classes[productRegister.productType] = productRegister.productClass()
        creators[productRegister.productType] = productRegister.creator()
        return this
    }


    fun <T : Product> register(productType: String, creator: ProductCreator<T>): ProductRegistry {
        creators[productType] = creator
        classes[productType] = creator().javaClass.kotlin
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Product> create(productType: String): T {
        val creator = creators[productType]
            ?: throw ProductTypeNotRegistered(productType)
        return creator.invoke() as T
    }

    fun getProductClasses(): Set<KClass<out Product>> =
        classes.values.toSet()

    fun getProductClasses(type: KClass<*>): Set<KClass<out Product>> =
        classes.values
            .filter { it.isSubclassOf(type) }
            .toSet()
}