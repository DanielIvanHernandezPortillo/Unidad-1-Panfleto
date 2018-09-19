package com.example.utng.apppanfleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista;
        ArrayAdapter<String> adapter;
        lista = (ListView) findViewById(R.id.list_item);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);
        adapter.add(getResources().getString(R.string.partidos));
        adapter.add(getResources().getString(R.string.resultados));
        adapter.add(getResources().getString(R.string.tabla));
        adapter.add(getResources().getString(R.string.camisas));



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int opcion = position;
                Toast.makeText(getApplicationContext(),
                        "Opcion ..."+opcion,
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, ContenidoActivity.class);
                intent.putExtra("OPCION",opcion);
                startActivity(intent);
                finish();




            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


    //Asociar con el menu xml

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ContenidoActivity.class);

        int posi;
        switch (item.getItemId()){

            case R.id.itmPartidos:
                Toast.makeText(this,"Lista de Partidos",Toast.LENGTH_LONG).show();
                intent.putExtra("OPCION",0);
                startActivity(intent);
                finish();
                return  true;
            case R.id.itmResultados:
                Toast.makeText(this,"Lista de Resultados",Toast.LENGTH_LONG).show();
                intent.putExtra("OPCION",1);
                startActivity(intent);
                finish();
                return  true;
            case R.id.itmTabla:
                Toast.makeText(this,"Tabla General",Toast.LENGTH_LONG).show();
                intent.putExtra("OPCION",2);
                startActivity(intent);
                finish();
                return  true;
            case R.id.itmCamisa:
                Toast.makeText(this,"Playeras Deportivas",Toast.LENGTH_LONG).show();
                intent.putExtra("OPCION",3);
                startActivity(intent);
                finish();
                return  true;
            default:
                return super.onOptionsItemSelected(item);


        }



    }
}
