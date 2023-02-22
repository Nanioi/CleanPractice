package com.nanioi.cleanpracticeapp.di

import com.nanioi.data.MSARetrofit
import com.nanioi.data.service.APIService
import com.nanioi.data.repositoryimpl.LMSRepositoryImpl
import com.nanioi.domain.repository.LMSRepository
import com.nanioi.domain.usecase.GetAttendStatusUseCase
import com.nanioi.domain.usecase.GetMenuWatchTimeGraphUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideAPIService(
        @MSARetrofit retrofit:Retrofit
    ): APIService {
        return retrofit.create(APIService::class.java)
    }

    //    @Provides
//    fun provideMIMSService(retrofit:Retrofit): MIMSService {
//        return retrofit.create(MIMSService::class.java)
//    }

    @Provides
    fun provideLMSRepository(apiService: APIService): LMSRepository {
        return LMSRepositoryImpl(apiService) as LMSRepository
    }

    //    @Provides
//    fun provideMIMSRepository(apiService: MIMSService): MIMSRepository {
//        return MIMSRepositoryImpl(apiService) as MIMSRepository
//    }

    @Provides
    fun provideGetAttendStatusUseCase(repository: LMSRepository): GetAttendStatusUseCase {
        return GetAttendStatusUseCase(repository)
    }

    @Provides
    fun provideGetMenuWatchTimeGraphUseCase(repository: LMSRepository): GetMenuWatchTimeGraphUseCase {
        return GetMenuWatchTimeGraphUseCase(repository)
    }

}



