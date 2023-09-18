package com.example.noteappsroom.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.noteappsroom.database.Note
import com.example.noteappsroom.database.NoteDao
import com.example.noteappsroom.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

//4
class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    // ambil data menggunakan live data, jika insert, delete, update
    // menggunakan executorService dan menggunakan background thread
    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    // insert data
    fun insert(note: Note) {
        executorService.execute { mNotesDao.insert(note) }
    }

    // delete data
    fun delete(note: Note) {
        executorService.execute { mNotesDao.delete(note) }
    }

    // update data
    fun update(note: Note) {
        executorService.execute { mNotesDao.update(note) }
    }
}
