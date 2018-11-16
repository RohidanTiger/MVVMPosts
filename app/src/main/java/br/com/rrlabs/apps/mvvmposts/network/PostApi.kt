package br.com.rrlabs.apps.mvvmposts.network

import br.com.rrlabs.apps.mvvmposts.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}