package com.shopify.hackdaysandroidv2.repository.model

/**
 * Created by cavedon on 2018-03-01.
 */
interface Repository {

    fun getProducts(): List<Product>

    fun getCollections(): List<ProductCollection>
}