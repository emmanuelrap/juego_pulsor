package mx.edu.ittepic.juego_pulsor;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    float random,randomFloat,avance=0,auxFloat;
    String random2,secuenciaString,aux; //Random2 es la variable que se genera con punto decimal en string
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt1 = findViewById(R.id.button);
        final TextView numero = findViewById(R.id.textView);
        final TextView num_secuencia = findViewById(R.id.textView2);
        final DecimalFormat df = new DecimalFormat("#.0");

        random = (float) (Math.random()*3);
        random2 = df.format(random);
        randomFloat=Float.parseFloat(random2);

        numero.setText(""+random2);

        timer = new CountDownTimer(3000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                avance= (float) (avance+0.1);
                secuenciaString = df.format(avance);
                num_secuencia.setText(""+secuenciaString);

                if (avance>=3){
                    avance= (float) 0.0;
                }
            }

            @Override
            public void onFinish() {
                timer.start();
            }
        };timer.start();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux=secuenciaString;
                auxFloat = Float.parseFloat(aux);
                if (randomFloat==auxFloat){
                    Toast.makeText(MainActivity.this, "G A N A D O R", Toast.LENGTH_SHORT).show();
                    timer.cancel();
                }else {
                    Toast.makeText(MainActivity.this, "Intenta de nuevo", Toast.LENGTH_SHORT).show();
                    final DecimalFormat df = new DecimalFormat("#.0");
                    random = (float) (Math.random()*3);
                    random2 = df.format(random);
                    numero.setText(""+random2);
                }
            }
        });
    }
}
