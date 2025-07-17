package com.manpreet.cleanarchitecturedrawer.di

import com.manpreet.cleanarchitecturedrawer.data.network.AuthApi
import com.manpreet.cleanarchitecturedrawer.data.repository.AuthRespositoryImpl
import com.manpreet.cleanarchitecturedrawer.domain.repository.AuthRepository
import com.manpreet.cleanarchitecturedrawer.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAuthAPi():AuthApi= Retrofit.Builder()
        .baseUrl("https://dummyapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthApi::class.java)

    @Provides
    fun provideAuthRespository(api:AuthApi):AuthRepository=AuthRespositoryImpl(api)

    @Provides
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase=LoginUseCase(repository)

}