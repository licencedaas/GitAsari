package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class reglasTesla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglas_tesla);
        contexto val = new contexto();

        try {
            if (getIntent().getStringExtra("nick").equals("")) {

            } else {

                val.setKeyNick(getIntent().getStringExtra("nick"));
                val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
                val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
                val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

            }
        }catch (Exception sdfs){}
    }

    public void cerrar(View sdfas) {
        contexto val = new contexto();
if(val.getKeyNick().equals("")) {
    Intent siguiente = new Intent(this, Mantenimiento.class);
    startActivity(siguiente);
}else{
    Intent siguiente = new Intent(this, atributos.class);
    siguiente.putExtra("nick", val.getKeyNick());
    siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
    siguiente.putExtra("standar", val.getKeySiguienteN2());
  
    startActivity(siguiente);


}}

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