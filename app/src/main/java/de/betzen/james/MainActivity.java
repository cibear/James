package de.betzen.james;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView Countdown = new TextView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout linearLayout = findViewById(R.id.MainLayout);


        //create a sample button
        for(int l=1; l<=5; l++) {
            LinearLayout newLayoutRow = new LinearLayout(this);
            newLayoutRow.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(newLayoutRow);
            for (int i = 1; i <= 5; i++) {
                ImageButton imageButton = new ImageButton(this);
                imageButton.setImageResource(R.mipmap.ic_launcher);
                imageButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageButton.setTag(R.id.button_id,"Button "+Integer.toString(l*i));
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, v.getTag(R.id.button_id) + " erstellt!", Toast.LENGTH_LONG).show();
                    }
                });

                if (newLayoutRow != null) {
                    newLayoutRow.addView(imageButton);
                }
            }
        }
        TextView tvCountdown1 = new TextView(this);
        Countdown = tvCountdown1;
        linearLayout.addView(tvCountdown1);


    }

    public void StartCountdown(){

        final LinearLayout linearLayout = findViewById(R.id.MainLayout);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                Countdown.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Countdown.setText("done!");
            }
        }.start();

    }
}
