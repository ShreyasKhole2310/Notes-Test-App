package com.semantic.notesapp.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.semantic.notesapp.DaoClasses.NoteDao;
import com.semantic.notesapp.Database.DataBaseRoom;

import java.util.List;

public class NotesDataRepo {

    private DataBaseRoom dataBaseRoom;

    public NotesDataRepo(Context mContext){
        dataBaseRoom = DataBaseRoom.getDataBase(mContext);
    }

    public void insertData(NoteDao noteDao){
        DataBaseRoom.databastWriterExecuter.execute(() -> {
            dataBaseRoom.noteDao().insertData(noteDao);
        });
//        dataBaseRoom.noteDao().insertData(noteDao);
    }

    public LiveData<List<NoteDao>> getListNotes(){
        return dataBaseRoom.noteDao().getAll();
    }

    public void deleteData(NoteDao noteDao){
        dataBaseRoom.noteDao().DeleteNote(noteDao);
    }

    public void updateData(NoteDao noteDao){
        dataBaseRoom.noteDao().updateNote(noteDao);
    }

}
