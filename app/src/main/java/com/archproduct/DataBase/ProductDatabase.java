package com.archproduct.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.archproduct.model.ProductPojo;

@Database(entities = {ProductPojo.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase instance = null;

    public abstract ProductDAO productDAO();

    public static synchronized ProductDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class, "productsDb")
                    .build();
        }
        return instance;
    }
}
