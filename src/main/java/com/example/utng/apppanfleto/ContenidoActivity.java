package com.example.utng.apppanfleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContenidoActivity extends AppCompatActivity {

    Button btnRegresar;
    TextView tvContenido;
    ImageView ivContenido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);

        tvContenido = (TextView)findViewById(R.id.tvContenido);
        ivContenido = (ImageView) findViewById(R.id.ivContenido);
        btnRegresar = (Button) findViewById(R.id.btnRegrear);
        ArrayList<String> contenidos = new ArrayList<String>();
        contenidos.add(getResources().getString(R.string.tema_conten));
        contenidos.add(getResources().getString(R.string.activs_didac));
        contenidos.add(getResources().getString(R.string.eval_usuario));
        contenidos.add(getResources().getString(R.string.progress_usuario));

        Intent intent = getIntent();
        int posicion = intent.getIntExtra("OPCION",0);
        tvContenido.setText(contenidos.get(posicion));
        switch (posicion){
            case 0: ivContenido.setImageResource(R.drawable.m); break;
            case 1: ivContenido.setImageResource(R.drawable.posi); break;
            case 2: ivContenido.setImageResource(R.drawable.v); break;
            case 3: ivContenido.setImageResource(R.drawable.ca); break;

        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContenidoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
