package br.com.dynaraoliveira.githubaac.di.modules

import br.com.dynaraoliveira.githubaac.ui.userprofile.UserProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeUserProfileFragment(): UserProfileFragment

}