package br.com.rrlabs.apps.mvvmposts.base

import android.arch.lifecycle.ViewModel
import br.com.rrlabs.apps.mvvmposts.module.injection.NetworkModule
import br.com.rrlabs.apps.mvvmposts.module.injection.component.DaggerViewModelInjector
import br.com.rrlabs.apps.mvvmposts.module.injection.component.ViewModelInjector
import br.com.rrlabs.apps.mvvmposts.ui.post.PostListViewModel
import br.com.rrlabs.apps.mvvmposts.ui.post.PostViewModel


abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostViewModel -> injector.inject(this)
            is PostListViewModel -> injector.inject(this)

        }
    }
}