package br.com.dynaraoliveira.githubaac.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.dynaraoliveira.githubaac.di.key.ViewModelKey
import br.com.dynaraoliveira.githubaac.ui.userprofile.UserProfileViewModel
import br.com.dynaraoliveira.githubaac.util.viewmodel.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserProfileViewModel(repoViewModel: UserProfileViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory
}
