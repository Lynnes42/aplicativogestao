package com.example.projeto1;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Chamado.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract ChamadoDao chamadoDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "chamados_db")
                    .allowMainThreadQueries() // Simplificação para o exemplo, em prod usar threads
                    .build();
        }
        return instance;
    }
}
