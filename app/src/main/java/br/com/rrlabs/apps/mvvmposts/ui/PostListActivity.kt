package br.com.rrlabs.apps.mvvmposts.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.rrlabs.apps.mvvmposts.R
import br.com.rrlabs.apps.mvvmposts.databinding.ActivityPostListBinding
import br.com.rrlabs.apps.mvvmposts.module.injection.ViewModelFactory
import br.com.rrlabs.apps.mvvmposts.ui.post.PostListViewModel
import com.android.databinding.library.baseAdapters.BR

/**
 * https://proandroiddev.com/mvvm-with-kotlin-android-architecture-components-dagger-2-retrofit-and-rxandroid-1a4ebb38c699
 */
class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostListBinding
    private lateinit var viewModel: PostListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_post_list)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_post_list)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        viewModel = ViewModelProviders.of(this,ViewModelFactory(this)).get(PostListViewModel::class.java)
        viewModel.errorMessage.observe(this,Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel
    }
    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        Log.e("Eita, Deu Ruim","------------------------------")
        errorSnackbar?.show()
    }
    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}
