package com.mcs.kalherath.playground;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditWordView;
    private EditText ln;
    private EditText rn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.fn);
        ln = findViewById(R.id.ln);
        rn = findViewById(R.id.rn);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    Student student = new Student(mEditWordView.getText().toString(), ln.getText().toString(), Integer.parseInt(rn.getText().toString()));
                    replyIntent.putExtra(EXTRA_REPLY, (Parcelable) student);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}