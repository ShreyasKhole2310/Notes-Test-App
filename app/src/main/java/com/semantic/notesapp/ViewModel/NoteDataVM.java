package com.semantic.notesapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.semantic.notesapp.DaoClasses.NoteDao;
import com.semantic.notesapp.Repositories.NotesDataRepo;

import java.util.List;

public class NoteDataVM extends AndroidViewModel {

    private NotesDataRepo notesDataRepo;

    public NoteDataVM(@NonNull Application application) {
        super(application);
        notesDataRepo = new NotesDataRepo(application);
    }

    public void insertData(NoteDao noteDao){
        notesDataRepo.insertData(noteDao);
    }

    public LiveData<List<NoteDao>> getData(){
        return notesDataRepo.getListNotes();
    }

    public void deleteData(NoteDao noteDao){
        notesDataRepo.updateData(noteDao);
    }

}
