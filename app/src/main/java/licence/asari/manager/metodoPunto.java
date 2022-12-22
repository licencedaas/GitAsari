package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class metodoPunto extends AppCompatActivity {

    private ImageView ima1,ima2,ima3,ima4,ima5,ima6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_punto);
        contexto val= new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeyDimencion(getIntent().getStringExtra("keyDimen"));

        ima1 =(ImageView)findViewById(R.id.metodo_sitem1);
        ima2 =(ImageView)findViewById(R.id.metodo_sitem2);
        ima3 =(ImageView)findViewById(R.id.metodo_sitem3);
        ima4 =(ImageView)findViewById(R.id.metodo_sitem4);
        ima5 =(ImageView)findViewById(R.id.metodo_sitem5);
        ima6 =(ImageView)findViewById(R.id.metodo_sitem6);

        ima1.setVisibility(View.GONE);
        ima2.setVisibility(View.GONE);
        ima3.setVisibility(View.GONE);
        ima4.setVisibility(View.GONE);
        ima5.setVisibility(View.GONE);
        ima6.setVisibility(View.GONE);


        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));
        val.setEyMini3(getIntent().getStringExtra("keyMini"));

        if(val.getEyMini3().equals("13")){
            ima3.setVisibility(View.VISIBLE);
            ima4.setVisibility(View.VISIBLE);
        }else{
            if(val.getEyMini3().equals("14")){
                ima1.setVisibility(View.VISIBLE);
                ima2.setVisibility(View.VISIBLE);
            }else{
                if(val.getEyMini3().contains("15")){
                    ima5.setVisibility(View.VISIBLE);
                    ima6.setVisibility(View.VISIBLE);
                }else{
                    if(val.getEyMini3().contains("16")){
                        ima3.setVisibility(View.VISIBLE);
                        ima4.setVisibility(View.VISIBLE);
                    }else{
                        if(val.getEyMini3().contains("17")){
                            ima5.setVisibility(View.VISIBLE);
                            ima6.setVisibility(View.VISIBLE);
                        }else{
                            if(val.getEyMini3().contains("0")){
                                ima1.setVisibility(View.VISIBLE);
                                ima2.setVisibility(View.VISIBLE);

                            }
                        }
                    }
                }
            }
        }
    }

public void cerrar(View sdfs){


    ima1.setVisibility(View.GONE);
    ima2.setVisibility(View.GONE);
    ima3.setVisibility(View.GONE);
    ima4.setVisibility(View.GONE);


    Intent siguiente = new Intent(this,RegistroPuntos.class);
    contexto val= new contexto();

    siguiente.putExtra("nick", val.getKeyNick());
    siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
    siguiente.putExtra("standar", val.getKeySiguienteN2());
    siguiente.putExtra("keyDimen", val.getKeyDimencion());
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
    @Override
    protected void onDestroy() {
        super.onDestroy();





        finishAffinity();
    }


}