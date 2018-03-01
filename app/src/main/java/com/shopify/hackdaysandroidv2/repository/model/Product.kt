package com.shopify.hackdaysandroidv2.repository.model

/**
 * Created by cavedon on 2018-03-01.
 */
internal data class Product(
    val title: String,
    val totalInventory: Int = 0,
    val totalVariants: Int = 0,
    val hasOnlyDefaultVariants: Boolean = true,
    val imageSrc: String
) {
    fun hasStock() = totalInventory > 0
}