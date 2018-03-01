package com.shopify.hackdaysandroidv2.service

import com.shopify.hackdaysandroidv2.repository.GraphQLRepository
import com.shopify.hackdaysandroidv2.repository.model.Product
import com.shopify.hackdaysandroidv2.repository.model.ProductCollection
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

/**
 * Created by cavedon on 2018-03-01.
 */
internal class ProductService(private val repository: GraphQLRepository) {

    fun getOutOfStockProducts(): Observable<Product> {
        return repository
            .getProducts()
            .filter { !it.hasStock() }
            .toObservable()
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