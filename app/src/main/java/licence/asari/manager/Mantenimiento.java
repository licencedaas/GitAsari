package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class Mantenimiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimiento);
    }

    public void reglasTesla(View  reglas){

        Intent siguiente = new Intent(getApplicationContext(),reglasTesla.class);
        startActivity(siguiente);


    }

    public void reglasJuego(View  sdf ){

        Intent siguiente = new Intent(this,reglasJuegoTesla.class);
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