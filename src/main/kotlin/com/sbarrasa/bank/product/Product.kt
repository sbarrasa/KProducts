package com.sbarrasa.bank.product


abstract class Product(header: ProductHeader) : ProductHeader by header {
    open fun description() = name
}