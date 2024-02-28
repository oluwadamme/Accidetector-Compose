package com.example.accidetector.utils.di

import android.content.Context
import com.example.accidetector.service.DataStoreService
import com.example.accidetector.viewmodel.LoginViewModel
import com.example.accidetector.viewmodel.SignUpViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun providesLoginViewModel(service: DataStoreService):LoginViewModel{
        return LoginViewModel(service)
    }

    @Singleton
    @Provides
    fun providesSignupViewModel(service: DataStoreService):SignUpViewModel{
        return SignUpViewModel(service)
    }
    @Singleton
    @Provides
    fun provideDataStoreService(@ApplicationContext context: Context):DataStoreService{
        return DataStoreService(context)
    }
}