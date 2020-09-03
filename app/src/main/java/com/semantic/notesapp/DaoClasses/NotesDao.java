package com.semantic.notesapp.DaoClasses;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert
    void insertData(NoteDao lstNotes);

    @Query("delete from Notes")
    void deleteAll();

    @Update
    void updateNote(NoteDao notes);

    @Delete
    void DeleteNote(NoteDao notes);

    @Query("Select * from notes")
    LiveData<List<NoteDao>>  getAll();

}
