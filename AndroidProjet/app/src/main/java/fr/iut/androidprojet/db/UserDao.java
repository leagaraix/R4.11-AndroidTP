package fr.iut.androidprojet.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user ORDER BY prenom")
    List<User> getAll();

    @Insert
    long insert(User user);

    @Insert
    long[] insertAll(User... users);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

}
