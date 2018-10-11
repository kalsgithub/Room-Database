package com.mcs.kalherath.playground;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    private List<Student> studentList;





    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView number;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            number = view.findViewById(R.id.rollnum);
            //parentLayout = view.findViewById(R.id.seasonParent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String name = studentList.get(position).getFirstName() + " " + studentList.get(position).getLastName();
        holder.name.setText(name);
        name = "Roll Number: " + Integer.toString(studentList.get(position).getRollNum());
        holder.number.setText(name);
    }

    public void setStudents(List<Student> words){
        studentList = words;
        notifyDataSetChanged();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return studentList.size();
    }
}