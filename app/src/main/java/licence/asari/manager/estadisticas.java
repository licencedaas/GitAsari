package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class estadisticas extends AppCompatActivity {

    private TextView l1,l2,l3,l4;
    private FirebaseFirestore bdNeutro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        l1 =(TextView) findViewById(R.id.esta_l1);
        l2 =(TextView) findViewById(R.id.esta_l2);
        l3 =(TextView) findViewById(R.id.esta_l3);
        l4 =(TextView) findViewById(R.id.esta_l4);

        contexto val = new contexto();

        val.setKeyNick( getIntent().getStringExtra("nick"));
        val.setKeyCodigo(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

        bdNeutro = FirebaseFirestore.getInstance();


  try {
    bdNeutro.collection("TablaNick").document(getIntent().getStringExtra("cdGremio"))
    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
     @Override
      public void onSuccess(DocumentSnapshot documentSnapshot) {

         if (documentSnapshot.exists()) {


         l1.setText("ANOTACIONES: " + documentSnapshot.get("PTJornada"));
         l2.setText("VISCTORIAS:  " + documentSnapshot.getString("PTVictotia"));
         l3.setText("DERROTAS:    " + documentSnapshot.getString("PTDerrota"));
         l4.setText("Codigo: " + documentSnapshot.getString("codigo"));
     }else{
   l1.setText("ANOTACIONES: ");l2.setText("VISCTORIAS:  ");l3.setText("DERROTAS:    ");l4.setText("Codigo: ");
}
 }});
 }catch (Exception sdfs){
  Toast.makeText(getApplicationContext(), "codigo error :  " + getIntent().getStringExtra("cdGremio"), Toast.LENGTH_SHORT).show();
}







/*
        bdNeutro.collection("TablaNick").document(val.getKeyCodigo())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()){

                    l1.setText("ANOTACIONES: "+documentSnapshot.getString("PTJornada"));
                    l2.setText("VISCTORIAS:  "+ documentSnapshot.getString("PTVictoria"));
                    l3.setText("DERROTAS:    "+documentSnapshot.getString("PTDerrota"));
                    l4.setText("NICK: "+documentSnapshot.getString("nick"));

                }


            }
        });*/


    }









    public void cerrar(View sdfas) {
        contexto val = new contexto();



        if(val.getKeySiguienteN2().contains("standar")){

            Intent siguiente = new Intent(this,UsuarioStandar.class);

            siguiente.putExtra("nick", val.getKeyNick());
            siguiente.putExtra("cdGremio", val.getKeySiguienteN1());



            startActivity(siguiente);
        }else{
            if(val.getKeySiguienteN2().contains("admin")) {

                Intent siguiente = new Intent(this, UsuarioGb.class);

                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeySiguienteN1());


                startActivity(siguiente);

            }
        }





    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == event.KEYCODE_BACK){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Deseas  salir de Asary").setPositiveButton("si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent siguiente = new Intent(Intent.ACTION_MAIN);
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