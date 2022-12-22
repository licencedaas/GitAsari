package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class salonFama extends AppCompatActivity {

    FirebaseFirestore bdNeutro;
    private TextView l1, l2, l3, l4, l6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_fama);
        contexto val = new contexto();

        l1 = (TextView) findViewById(R.id.fama_l1);
        l2 = (TextView) findViewById(R.id.fama_l2);
        l3 = (TextView) findViewById(R.id.fama_l3);
        l4 = (TextView) findViewById(R.id.fama_l4);
        //   l5 =(TextView) findViewById(Rid.fama_l5);
        l6 = (TextView) findViewById(R.id.fama_l6);


        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));
        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        bdNeutro = FirebaseFirestore.getInstance();


        try {
            bdNeutro.collection("BDsalonEventoTesla").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot document) {


                    if (document.exists()) {
                        val.setKeyGanadorTesla1(document.getString("ganador1"));
                        val.setKeyGanadorTesla2(document.getString("ganador2"));
                        val.setKeyGanadorTesla3(document.getString("ganador3"));

                        l1.setText("Primer lugar: " + val.getKeyGanadorTesla1());
                        l2.setText("Segundo lugar: " + val.getKeyGanadorTesla2());
                        l3.setText("Tercer lugar: " + val.getKeyGanadorTesla3());
                        l4.setText("Primer lugar:");
                        //       l5.setText("Segundo lugar:" );
                        l6.setText("Tercer lugar:");

                    } else {

                        l1.setText("Primer lugar:");
                        l2.setText("Segundo lugar:");
                        l3.setText("Tercer lugar:");
                        l4.setText("Primer lugar:");
                        //      l5.setText("Segundo lugar:" );
                        l6.setText("Tercer lugar:");


                    }
                }
            });


        } catch (Exception sfds) {
        }
    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();


        Intent siguiente = new Intent(this, menuSalonFanma.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        siguiente.putExtra("standar", val.getKeySiguienteN2());


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