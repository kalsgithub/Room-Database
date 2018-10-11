package com.mcs.kalherath.playground;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAll();

    @Query("SELECT * FROM student WHERE rollNum IN (:rollnums)")
    List<Student> loadAllByIds(int[] rollnums);

    @Query("SELECT * FROM student WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Student findByName(String first, String last);

    @Insert
    void insertAll(Student...students);

    @Delete
    void delete(Student student);

}

