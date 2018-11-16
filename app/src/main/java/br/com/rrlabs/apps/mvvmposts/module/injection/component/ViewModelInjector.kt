package br.com.rrlabs.apps.mvvmposts.module.injection.component

import br.com.rrlabs.apps.mvvmposts.module.injection.NetworkModule
import br.com.rrlabs.apps.mvvmposts.ui.post.PostListViewModel
import br.com.rrlabs.apps.mvvmposts.ui.post.PostViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(postListViewModel: PostListViewModel)
    fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}