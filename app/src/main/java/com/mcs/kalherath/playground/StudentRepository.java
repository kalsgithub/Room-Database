package com.mcs.kalherath.playground;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class StudentRepository {
    private StudentDao mStudentDao;
    private LiveData<List<Student>> mAllStudents;
    StudentRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        mStudentDao = db.studentDao();
        mAllStudents = mStudentDao.getAll();
    }

    LiveData<List<Student>> getAll() {
        return mAllStudents;
    }


    public void insert (Student student) {
        new insertAsyncTask(mStudentDao).execute(student);
    }

    private static class insertAsyncTask extends AsyncTask<Student, Void, Void> {

        private StudentDao mAsyncTaskDao;

        insertAsyncTask(StudentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            mAsyncTaskDao.insertAll(params[0]);
            return null;
        }
    }

}
