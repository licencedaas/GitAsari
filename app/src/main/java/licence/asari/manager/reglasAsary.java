package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class reglasAsary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglas_asary);
        contexto val = new contexto();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if(id== R.id.menu_1){

            registroTEAM();

        }else{

            if(id== R.id.menu_2){

                asary();
            }

        }
        return super.onOptionsItemSelected(item);
    }


    public void registroTEAM(){

        Intent siguiente = new Intent(this, sentinGremio.class);
        startActivity(siguiente);



    }

    public void asary(){
        Intent sguiente =new Intent(this, about.class);
        startActivity(sguiente);
    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();
        val.setSearKeyCodigo(0);


            Intent siguiente = new Intent(this,RegistroNuevo.class);

            startActivity(siguiente);

        }








    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == event.KEYCODE_BACK){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Deseas  salir de Asary").setPositiveButton("si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent  siguiente = new Intent(Intent.ACTION_MAIN);
                    siguiente.addCategory(Intent.CATEGORY_HOME);
                    siguiente .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    finishAffinity();
                    startActivity(siguiente);
                    finish();
                }



            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();


                }
            });
            builder.show();
        }

        return super.onKeyDown(keyCode, event);
    }
}