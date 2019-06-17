package com.floydwiz.testplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private TextInputEditText webURL;
    private CardView runGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webURL = findViewById(R.id.webLinkId);
        runGame = findViewById(R.id.runGameId);

        runGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!TextUtils.isEmpty(webURL.getText().toString().trim())){

                    String gameLink = webURL.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this,FullscreenActivity.class);
                    intent.putExtra("link",gameLink);
                    startActivity(intent);

                }else {

                    webURL.setError("Game URL Cannot be empty");
                }


            }
        });



    }
}
