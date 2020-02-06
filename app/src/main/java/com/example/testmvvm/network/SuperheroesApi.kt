package com.example.testmvvm.network

import com.example.testmvvm.models.SuperheroesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface SuperheroesApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/bins/bvyob")
    fun getSuperheroes(): Observable<SuperheroesResponse>
}