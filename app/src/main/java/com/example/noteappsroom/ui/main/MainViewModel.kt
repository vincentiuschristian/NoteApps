package com.example.noteappsroom.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.noteappsroom.database.Note
import com.example.noteappsroom.repository.NoteRepository

// 5
class MainViewModel(application: Application) : ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    // getData
    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()

}