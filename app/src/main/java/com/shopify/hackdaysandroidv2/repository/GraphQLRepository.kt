package com.shopify.hackdaysandroidv2.repository

import com.shopify.hackdaysandroidv2.repository.model.Product
import com.shopify.hackdaysandroidv2.repository.model.ProductCollection
import com.shopify.hackdaysandroidv2.repository.model.Repository

/**
 * Created by cavedon on 2018-03-01.
 */
internal class GraphQLRepository: Repository {

    override fun getProducts(): List<Product> = listOf(
        Product(
            title = "Giftcard",
            totalVariants = 3,
            hasOnlyDefaultVariants = false,
            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
        ),
        Product(
            title = "Chili Bites",
            totalVariants = 3,
            totalInventory = 3,
            hasOnlyDefaultVariants = false,
            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/south_african_chilibites.jpg?v=1475435870"
        ),
        Product(
            title = "Grassfed Biltong",
            totalVariants = 4,
            hasOnlyDefaultVariants = false,
            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/grass_fed_biltong_on_table.jpg?v=1464753236"
        ),
        Product(
            title = "Traditional Biltong",
            totalVariants = 3,
            totalInventory = 2,
            hasOnlyDefaultVariants = false,
            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
        )
    )

    override fun getCollections(): List<ProductCollection> = listOf(
        ProductCollection(
            title = "Giftcard collection",
            products = listOf(
                Product(
                    title = "Giftcard",
                    totalVariants = 3,
                    hasOnlyDefaultVariants = false,
                    imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
                )
            )
        ),
        ProductCollection(
            title = "Biltong collection",
            products = listOf(
                Product(
                    title = "Chili Bites",
                    totalVariants = 3,
                    totalInventory = 3,
                    hasOnlyDefaultVariants = false,
                    imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/south_african_chilibites.jpg?v=1475435870"
                ),
                Product(
                    title = "Grassfed Biltong",
                    totalVariants = 4,
                    hasOnlyDefaultVariants = false,
                    imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/grass_fed_biltong_on_table.jpg?v=1464753236"
                ),
                Product(
                    title = "Traditional Biltong",
                    totalVariants = 3,
                    totalInventory = 2,
                    hasOnlyDefaultVariants = false,
                    imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
                )
            )
        )
    )

}