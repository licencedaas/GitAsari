package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class detlles_reporte_reino {

    FirebaseFirestore bdNeutro;


    public detlles_reporte_reino(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_reporte_reino);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        TextView l1 = (TextView) dialog.findViewById(R.id.codigo_reporte_l1);
        TextView l2 = (TextView) dialog.findViewById(R.id.codigo_reporte_l2);
        TextView l3= (TextView) dialog.findViewById(R.id.codigo_reporte_l3);
        TextView l4 = (TextView) dialog.findViewById(R.id.codigo_reporte_l4);
        ImageView image_1=(ImageView) dialog.findViewById(R.id.final_image);

        image_1.setVisibility(View.GONE);
        ImageButton b2 = (ImageButton) dialog.findViewById(R.id.reporte_b2);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.reporte_b1);
        EditText t1 =(EditText)dialog.findViewById(R.id.reporte_t1);

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();


      l1.setText(val.getKeyCodigoReporte1());




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         if(t1.getText().toString().equals("")){

             Toast.makeText(context1.getApplicationContext(), "CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
         }else{

          bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
              @Override
              public void onSuccess(DocumentSnapshot documentSnapshot) {

                  if(documentSnapshot.exists()){

try {
    if (documentSnapshot.getString("keyGenerate_" + val.getKeyNick()).equals(val.getKeyCodigoReporte1())) {


            HashMap<String,Object> dato = new HashMap<>();
        HashMap<String,Object> dato1 = new HashMap<>();
        HashMap<String,Object> dato2 = new HashMap<>();

        val.setKeyVictoriaReino_1(documentSnapshot.getString("estrellas"));


        bdNeutro.collection("BDreino").whereEqualTo("nick",val.getKeyDuelista2())
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        val.setKeyCodigo2(document.getString("codigo"));
                        val.setKeyAprovacion_2(document.getString("keyApuesta" + val.getKeyNick()));
                        val.setKeyEstrellas(document.getString("estrellas"));
                    }

                    dato.put("keyGenerate_"+val.getKeyNick(),"0");
                    dato.put("keyGenerate","resibir");
                    dato.put("keyApuesta"+val.getKeyDuelista2(),"0");
                    dato.put("keyOcupado","no");
                    dato.put("nickApuesta","auxiliar");



                    val.setKeyJ4(Integer.parseInt(val.getKeyAprovacion_2()));
                    val.setKeyJ5(Integer.parseInt(val.getKeyEstrellas()));
                    val.setKeyJ6(Integer.parseInt(val.getKeyVictoriaReino_1()));

                    val.setKeyJ6(val.getKeyJ6()+val.getKeyJ4());
                    dato.put("estrellas",String.valueOf(val.getKeyJ6()));

                    if(val.getKeyJ6()>=10){


                        bdNeutro.collection("BDsalonfamaReino").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {

                                if (documentSnapshot.exists()) {

      val.setKeyFinalReino1(documentSnapshot.getString("puestoN1"));
                                    val.setKeyFinalReino2(documentSnapshot.getString("puestoN2"));
                                    val.setKeyFinalReino3(documentSnapshot.getString("puestoN3"));
                                    val.setKeyFinalReino4(documentSnapshot.getString("puestoN4"));
                                    val.setKeyFinalReino5(documentSnapshot.getString("puestoN5"));



                                    if(val.getKeyFinalReino1().contains("esperando")){
                                        dato2.put("puestoN1",val.getKeyNick());
                                    }else{
                                        if(val.getKeyNick().contains(val.getKeyFinalReino1())){
                                        } else{


                                            if(val.getKeyFinalReino2().contains("esperando")){
                                                dato2.put("puestoN2",val.getKeyNick());
                                            }else{
                                                if(val.getKeyNick().contains(val.getKeyFinalReino1())){
                                                }else{
                                                    if(val.getKeyFinalReino3().contains("esperando")){
                                                        dato2.put("puestoN3",val.getKeyNick());
                                                    }else{
                                                        if(val.getKeyNick().contains(val.getKeyFinalReino1())){
                                                        }else{
                                                            if(val.getKeyFinalReino3().contains("esperando")){
                                                                dato2.put("puestoN3",val.getKeyNick());
                                                            }else{
                                                                if(val.getKeyNick().contains(val.getKeyFinalReino1())){
                                                                }else{
                                                                    if(val.getKeyFinalReino4().contains("esperando")){
                                                                        dato2.put("puestoN4",val.getKeyNick());
                                                                    }else{
                                                                        if(val.getKeyNick().contains(val.getKeyFinalReino1())){
                                                                        }else{
                                                                            if(val.getKeyFinalReino5().contains("esperando")){
                                                                                dato2.put("puestoN5",val.getKeyNick());
                                                                            }else{
                                                                                if(val.getKeyNick().contains(val.getKeyFinalReino1())){
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }

                                                    }
                                                }
                                            }
                                        }
                                    }

                                    bdNeutro.collection("BDsalonfamaReino").document(val.getKeySiguienteN1()).update(dato2);
                                    val.setKeyJ5(val.getKeyJ5()-val.getKeyJ4());

                                    dato1.put("estrellas",String.valueOf(val.getKeyJ5()));
                                    dato1.put("keyApuesta"+val.getKeyNick(),"0");
                                    dato1.put("keyOcupado","no");
                                    dato1.put("nickApuesta","auxiliar");
                                    bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).update(dato);
                                    bdNeutro.collection("BDreino").document(val.getKeyCodigo2()).update(dato1);
                                    l2.setVisibility(View.GONE);
                                    l3.setVisibility(View.GONE);
                                    l4.setVisibility(View.GONE);
                                    l1.setVisibility(View.GONE);
                                    b1.setVisibility(View.GONE);
                                    b2.setVisibility(View.GONE);
                                    t1.setVisibility(View.GONE);
                                    image_1.setVisibility(View.VISIBLE);

                                 //   llamadoReporte();
                                    Toast.makeText(context1.getApplicationContext(), "Felicitacones Este es el final ", Toast.LENGTH_SHORT).show();
                                } else {
                                    dato2.put("puestoN1",val.getKeyNick());
                                    dato2.put("puestoN2","esperando");
                                    dato2.put("puestoN3","esperando");
                                    dato2.put("puestoN4","esperando");
                                    dato2.put("puestoN5","esperando");
                                    dato2.put("puestoN6","esperando");
                                    dato2.put("puestoN7","esperando");
                                    dato2.put("puestoN8","esperando");
                                    dato2.put("puestoN9","esperando");
                                    dato2.put("puestoN10","esperando");
                                    dato2.put("puestoN11","esperando");
                                    dato2.put("puestoN12","esperando");
                                    dato2.put("puestoN13","esperando");
                                    dato2.put("puestoN14","esperando");
                                    dato2.put("puestoN15","esperando");
                                    dato2.put("puestoN16","esperando");
                                    dato2.put("puestoN17","esperando");
                                    dato2.put("puestoN18","esperando");
                                    dato2.put("puestoN19","esperando");
                                    dato2.put("puestoN20","esperando");
                                    dato2.put("puestoN21","esperando");
                                    dato2.put("puestoN22","esperando");
                                    dato2.put("puestoN23","esperando");
                                    dato2.put("puestoN24","esperando");
                                    dato2.put("puestoN25","esperando");

                                    Toast.makeText(context1.getApplicationContext(), "Felicitacones Este es el final ", Toast.LENGTH_SHORT).show();

                                    bdNeutro.collection("BDsalonfamaReino").document(val.getKeySiguienteN1()).set(dato2);

                                    val.setKeyJ5(val.getKeyJ5()-val.getKeyJ4());

                                    dato1.put("estrellas",String.valueOf(val.getKeyJ5()));
                                    dato1.put("keyApuesta"+val.getKeyNick(),"0");
                                    dato1.put("keyOcupado","no");
                                    dato1.put("nickApuesta","auxiliar");
                                    bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).update(dato);
                                    bdNeutro.collection("BDreino").document(val.getKeyCodigo2()).update(dato1);

                                    l2.setVisibility(View.GONE);
                                    l3.setVisibility(View.GONE);
                                    l4.setVisibility(View.GONE);
                                    l1.setVisibility(View.GONE);
                                    b1.setVisibility(View.GONE);
                                    b2.setVisibility(View.GONE);
                                    t1.setVisibility(View.GONE);
                                    image_1.setVisibility(View.VISIBLE);

                                   // llamadoReporte();
                                }
                            }});




                    }

                    if(val.getKeyJ6()<10){
                    val.setKeyJ5(val.getKeyJ5()-val.getKeyJ4());

                    dato1.put("estrellas",String.valueOf(val.getKeyJ5()));
                    dato1.put("keyApuesta"+val.getKeyNick(),"0");
                    dato1.put("keyOcupado","no");
                    dato1.put("nickApuesta","auxiliar");
                    bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).update(dato);
                    bdNeutro.collection("BDreino").document(val.getKeyCodigo2()).update(dato1);
                    Toast.makeText(context1.getApplicationContext(), "Felicitaciones duelista has aumentado sus estrellas", Toast.LENGTH_SHORT).show();
                    }
}}});



    }else{
        Toast.makeText(context1.getApplicationContext(), "CODIGO INCORRECTO", Toast.LENGTH_SHORT).show();
    }
}catch (Exception dfsf){
    Toast.makeText(context1.getApplicationContext(), "error1", Toast.LENGTH_SHORT).show();
}
                  }

              }
          }) ;


         }


            }
        });








        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }





}
