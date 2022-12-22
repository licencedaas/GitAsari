package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuSalonFanma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_salon_fanma);
        contexto val = new contexto();

        val.setKeyNick( getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

    }

    public void salonEventos(View sdf){

        contexto val = new contexto();
        Intent siguiente = new Intent(this,salonFama.class);

        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("standar", val.getKeySiguienteN2());

        startActivity(siguiente);

    }

    public void caracteristicas(View  sdf){
        contexto val = new contexto();
        Intent siguiente = new Intent(this,reglas_win_salon.class);

        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("standar", val.getKeySiguienteN2());
        startActivity(siguiente);


    }


    @Override
    protected void onStop() {
        super.onStop();
        // Toast.makeText(this, "OnStop  tABLA FINAL", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        finishAffinity();

        //android.os.Process.killProcess(android.os.Process.myPid());
    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();


        if(val.getKeySiguienteN2().contains("standar")){

            Intent siguiente = new Intent(this,UsuarioStandar.class);

            siguiente.putExtra("nick", val.getKeyNick());
            siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
            siguiente.putExtra("standar", val.getKeySiguienteN2());


            startActivity(siguiente);
        }else{
            if(val.getKeySiguienteN2().contains("admin")) {

                Intent siguiente = new Intent(this, UsuarioGb.class);

                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeySiguienteN1());


                startActivity(siguiente);

            }
        }
}}