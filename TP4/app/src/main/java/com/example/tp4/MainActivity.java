package com.example.tp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_FROM_A = "keyA";
    private static final String RQC_B = "keyB" ;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextA);


        Intent intentA = new Intent(MainActivity.this, Main2Activity.class);
        intentA.putExtra(KEY_FROM_A, editText.getText().toString());
        startActivityForResult(intentA, Integer.parseInt(RQC_B));
    }

    protected void onRestart(){
        super.onRestart();
        editText.setText("");
    }
}

/*package com.example.tp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String str = getIntent().getStringExtra(KEY_FROM_A);
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.editTextA);

        String retour = getIntent().getStringExtra(MainActivity.KEY_FROM_A);
        textView.setText(retour);
    }

    @Override
    public void finish(){
        Intent intentB = new Intent();
        intentB.putExtra(KEY_FROM_B, messB);
        setResult(RESULT_OK, intentB);
        super.finish();
    }

}*/
