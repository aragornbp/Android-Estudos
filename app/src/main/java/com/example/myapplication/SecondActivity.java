package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private final static String TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = TAG+".extra.Reply";
    private TextView txtMessage;
    private EditText edtMessageReply;
    private Button btnReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.d(TAG, "message recebida: "+message);
        txtMessage.setText(message);

        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = edtMessageReply.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, reply);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });

    }

    private void init() {
        txtMessage = findViewById(R.id.text_message);
        edtMessageReply = findViewById(R.id.editText_second);
        btnReply = findViewById(R.id.button_second);
    }
}