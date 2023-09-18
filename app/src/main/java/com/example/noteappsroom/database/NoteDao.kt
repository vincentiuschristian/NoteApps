package com.example.noteappsroom.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// 3
// kelas Dao sebagai CRUD
@Dao
interface NoteDao {


    // OnConflictStrategy.IGNORE agar jika datanya sama dibiarkan
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * from note ORDER BY date DESC")
    fun getAllNotes(): LiveData<List<Note>>

}