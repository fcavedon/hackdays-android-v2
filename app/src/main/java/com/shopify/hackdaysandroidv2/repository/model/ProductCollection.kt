package com.shopify.hackdaysandroidv2.repository.model

/**
 * Created by cavedon on 2018-03-01.
 */
internal data class ProductCollection(
    val title: String,
    val products: List<Product> = emptyList()
)