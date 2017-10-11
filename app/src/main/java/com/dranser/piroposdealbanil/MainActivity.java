package com.dranser.piroposdealbanil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button b1;
    /*
    Contenedor de todas las citas
     */
    private String citas[] = {
            "The best preparation for tomorrow is doing your best today"+"\n\n\tJackson Brown, Jr.","The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart"+"\n\n\tHelen Keller"
            ,"Put your heart, mind, and soul into even your smallest acts. This is the secret of success"+"\n\n\tSwami Sivananda"
            ,"The best thing to give to your enemy is forgiveness; to an opponent, tolerance; to a friend, your heart; to your child, a good example; to a father, deference; to your mother, conduct that will make her proud of you; to yourself, respect; to all men, charity"+"\n\n\tBenjamin Franklin"
            ,"Hope lies in dreams, in imagination and in the courage of those who dare to make dreams into reality"+"\n\n\tJonas Salk"
            ,"We all live with the objective of being happy; our lives are all different and yet the same"+"\n\n\tAnne Frank"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView)findViewById(R.id.textView);
        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num = random.nextInt(citas.length);
                t1.setText(citas[num]);
                t1.setTextIsSelectable(true); //Seleccionar el texto y copiarlo al portapapeles
                b1.setText("Más piropos");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu:
                String compartir = t1.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,compartir);
                intent.setType("text/plain");
                startActivity(intent);
            default:  return super.onOptionsItemSelected(item);
        }
    }
}

