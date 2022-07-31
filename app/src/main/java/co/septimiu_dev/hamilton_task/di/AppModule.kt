package co.septimiu_dev.hamilton_task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

/**
 * Annotation created to be sure which coroutine scope are we using if there will be more created
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope