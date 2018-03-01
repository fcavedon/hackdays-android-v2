package com.shopify.hackdaysandroidv2

import com.shopify.hackdaysandroidv2.repository.model.Product
import com.shopify.hackdaysandroidv2.repository.model.ProductCollection
import com.shopify.hackdaysandroidv2.repository.model.Repository
import com.shopify.hackdaysandroidv2.service.ProductService
import io.reactivex.observers.TestObserver
import org.junit.Test

/**
 * Created by cavedon on 2018-03-01.
 */
internal class ProductServiceTest {

    object MockRepository : Repository {

        override fun getProducts(): List<Product> {
            return listOf(
                Product(
                    title = "test1",
                    totalInventory = 2,
                    imageSrc = "imgSrc"
                ),
                Product(
                    title = "test2",
                    imageSrc = "imgSrc"
                )
            )
        }

        override fun getCollections(): List<ProductCollection> {
            return listOf(
                ProductCollection(
                    title = "Collection 1",
                    products = listOf(
                        Product(
                            title = "collectionProduct1",
                            totalVariants = 3,
                            hasOnlyDefaultVariants = false,
                            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
                        )
                    )
                ),
                ProductCollection(
                    title = "collection 2",
                    products = listOf(
                        Product(
                            title = "collectionProduct1",
                            totalVariants = 3,
                            totalInventory = 3,
                            hasOnlyDefaultVariants = false,
                            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/south_african_chilibites.jpg?v=1475435870"
                        ),
                        Product(
                            title = "collectionProduct2",
                            totalVariants = 4,
                            hasOnlyDefaultVariants = false,
                            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/grass_fed_biltong_on_table.jpg?v=1464753236"
                        ),
                        Product(
                            title = "collectionProduct2",
                            totalVariants = 3,
                            totalInventory = 2,
                            hasOnlyDefaultVariants = false,
                            imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
                        )
                    )
                )
            )
        }

    }

    private val productService = ProductService(MockRepository)

    @Test
    fun withProductService_whenGetOutOfStockProducts_thenReturnInStockOnly() {
        val to = TestObserver<List<Product>>()

        productService.getOutOfStockProducts().subscribe(to)

        to.assertValue { it.size == 1 }
        to.assertValue {
            it.first() == Product(
                title = "test2",
                imageSrc = "imgSrc"
            )
        }
        to.assertComplete()
    }

    @Test
    fun withProductService_whenGetRecentlyEditedProducts_thenReturnRecentOnly() {
        val to = TestObserver<List<Product>>()

        productService.getRecentlyEditedProducts().subscribe(to)

        to.assertValue { it.size == 1 }
        to.assertValue {
            it.first() == Product(
                title = "test2",
                imageSrc = "imgSrc"
            )
        }
        to.assertComplete()
    }

    @Test
    fun withProductService_whenGetRecentlyEditedCollections_thenReturnRecentOnly() {
        val to = TestObserver<List<ProductCollection>>()

        productService.getRecentlyEditedCollections().subscribe(to)

        to.assertValue { it.size == 1 }
        to.assertValue {
            it.first() == ProductCollection(
                title = "collection 2",
                products = listOf(
                    Product(
                        title = "collectionProduct1",
                        totalVariants = 3,
                        totalInventory = 3,
                        hasOnlyDefaultVariants = false,
                        imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/south_african_chilibites.jpg?v=1475435870"
                    ),
                    Product(
                        title = "collectionProduct2",
                        totalVariants = 4,
                        hasOnlyDefaultVariants = false,
                        imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/grass_fed_biltong_on_table.jpg?v=1464753236"
                    ),
                    Product(
                        title = "collectionProduct2",
                        totalVariants = 3,
                        totalInventory = 2,
                        hasOnlyDefaultVariants = false,
                        imageSrc = "https://cdn.shopify.com/s/files/1/0698/8987/products/giftcard.png?v=1430535278"
                    )
                )
            )
        }
        to.assertComplete()
    }

}