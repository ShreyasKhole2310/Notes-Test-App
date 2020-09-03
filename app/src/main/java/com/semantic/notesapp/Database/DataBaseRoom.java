package com.semantic.notesapp.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.semantic.notesapp.DaoClasses.NoteDao;
import com.semantic.notesapp.DaoClasses.NotesDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = NoteDao.class, version = 1, exportSchema = false)
public abstract class DataBaseRoom extends RoomDatabase {

    public abstract NotesDao noteDao();

    private static volatile DataBaseRoom dataBaseRoomInstance;
    public static final ExecutorService databastWriterExecuter =
            Executors.newFixedThreadPool(4);

    public static DataBaseRoom getDataBase(final Context mContext){
        if(dataBaseRoomInstance == null){
            synchronized (DataBaseRoom.class){
                dataBaseRoomInstance = Room.databaseBuilder(mContext.getApplicationContext(),
                        DataBaseRoom.class, "notes_database")
                        .build();
            }
        }
        return dataBaseRoomInstance;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
