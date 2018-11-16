package br.com.rrlabs.apps.mvvmposts.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.rrlabs.apps.mvvmposts.model.Post
import br.com.rrlabs.apps.mvvmposts.model.PostDao

@Database(entities = arrayOf(Post::class),version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun postDao():PostDao
}