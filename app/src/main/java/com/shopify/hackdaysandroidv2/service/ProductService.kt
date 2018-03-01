package com.shopify.hackdaysandroidv2.service

import com.shopify.hackdaysandroidv2.repository.model.Product
import com.shopify.hackdaysandroidv2.repository.model.ProductCollection
import com.shopify.hackdaysandroidv2.repository.model.Repository
import io.reactivex.Observable

/**
 * Created by cavedon on 2018-03-01.
 */
internal class ProductService(private val repository: Repository) {

    fun getOutOfStockProducts(): Observable<List<Product>> {
        return Observable.just(repository
            .getProducts()
            .filter { !it.hasStock() }
        )
    }

    fun getRecentlyEditedProducts(): Observable<List<Product>> {
        return Observable.just(
            repository.getProducts()
                .filterIndexed { index, _ -> index > 1 }
        )
    }

    fun getRecentlyEditedCollections(): Observable<List<ProductCollection>> {
        return Observable.just(
            repository.getCollections()
                .filterIndexed { index, _ -> index == 0 }
        )
    }

}