package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class detlles_inicializacion {

    FirebaseFirestore bdNeutro;



    public detlles_inicializacion(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_inicializacion);




        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.randm_cerrar1);
        ImageButton enlace = (ImageButton) dialog.findViewById(R.id.welcome_b1);



        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        val.setSearKeyCodigo(Integer.parseInt(val.getKeyCodigo4()));

        if(val.getSearKeyCodigo() >= 100  && val.getSearKeyCodigo() < 600) {
            val.setKeyEscaneoGrenio("azul");
            val.setKeyIdGremio("100");

        }else{
            if(val.getSearKeyCodigo() >= 1100  && val.getSearKeyCodigo() < 1600) {
                val.setKeyEscaneoGrenio("rojo");
                val.setKeyIdGremio("1100");
            }else{
                if(val.getSearKeyCodigo() >= 2100  && val.getSearKeyCodigo() < 2600) {
                    val.setKeyEscaneoGrenio("naranja");val.setKeyIdGremio("2100");
                }else{
                    if(val.getSearKeyCodigo() >= 3100  && val.getSearKeyCodigo() < 3600) {
                        val.setKeyEscaneoGrenio("negro");val.setKeyIdGremio("3100");
                    }else {
                        if (val.getSearKeyCodigo() >= 4100 && val.getSearKeyCodigo() < 4600) {
                            val.setKeyEscaneoGrenio("calido");val.setKeyIdGremio("4100");
                        } }}}}


        bdNeutro.collection("DAAS").document("Info")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){

                     val.setKeyEnlaceCalabozolvl1(documentSnapshot.getString(val.getKeyIdGremio()+val.getKeyEscaneoGrenio()));


                } }});

        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri url = Uri.parse(val.getKeyEnlaceCalabozolvl1());
                Intent siguiente = new Intent(Intent.ACTION_VIEW,url);
                context1.startActivity(siguiente);

            }
        });



        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Intent siguiente = new Intent( context1,MainActivity2.class);
                context1.startActivity(siguiente);


            }
        });

        dialog.show();

    }





}
