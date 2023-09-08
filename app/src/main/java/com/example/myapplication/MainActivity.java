package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnSend;
    private EditText edtMain;
    private TextView txtMainReply;
    public static final String EXTRA_MESSAGE = "com.example.myapplication.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.button_main);
        edtMain = findViewById(R.id.editText_main);
        txtMainReply = findViewById(R.id.text_message_reply);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = edtMain.getText().toString();
                Log.d(TAG, "message: "+message);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "entrei no Result");
        Log.d(TAG, "requestCode: "+requestCode);
        Log.d(TAG, "resultCode: "+resultCode);

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                txtMainReply.setText(reply);
                txtMainReply.setVisibility(View.VISIBLE);
            }
        }
    }

}