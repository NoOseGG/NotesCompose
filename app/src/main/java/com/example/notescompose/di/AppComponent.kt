package com.example.notescompose.di

import android.app.Application
import android.content.Context
import com.example.notescompose.MainActivity
import dagger.BindsInstance
import dagger.Component


@Component(modules = [DatabaseModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : AppComponent
    }
}