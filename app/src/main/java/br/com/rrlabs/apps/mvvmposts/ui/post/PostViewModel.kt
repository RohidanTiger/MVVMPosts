package br.com.rrlabs.apps.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import br.com.rrlabs.apps.mvvmposts.base.BaseViewModel
import br.com.rrlabs.apps.mvvmposts.model.Post

class PostViewModel:BaseViewModel(){
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }

}