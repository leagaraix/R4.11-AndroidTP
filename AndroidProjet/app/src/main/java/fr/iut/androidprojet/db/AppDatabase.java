package fr.iut.androidprojet.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, QuestionReponse.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract QuestionReponseDao questionReponseDao();

}