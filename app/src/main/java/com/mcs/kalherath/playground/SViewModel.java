package com.mcs.kalherath.playground;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class SViewModel extends AndroidViewModel {

    private StudentRepository mRepository;

    private LiveData<List<Student>> mAllStudents;

    public SViewModel (Application application) {
        super(application);
        mRepository = new StudentRepository(application);
        mAllStudents = mRepository.getAll();
    }

    LiveData<List<Student>> getAll() { return mAllStudents; }

    public void insert(Student student) { mRepository.insert(student); }
}