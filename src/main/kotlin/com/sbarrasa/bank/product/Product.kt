package com.sbarrasa.bank.product

import com.sbarrasa.bank.product.types.ProductHeader

abstract class Product(header: ProductHeader) : ProductHeader by header {
    open fun description() = name
}