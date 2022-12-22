package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class detlles_id_duelista {

    FirebaseFirestore bdNeutro;


    public detlles_id_duelista(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_id_duelista);


        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.id_carga);
        ImageButton cerrar1 = (ImageButton) dialog.findViewById(R.id.id_cerrar);
        TextView l1=(TextView) dialog.findViewById(R.id.id_codigo);
        TextView l2=(TextView) dialog.findViewById(R.id.id_codigo2);
        EditText t1=(EditText) dialog.findViewById(R.id.id_digitar);//pla_Kirito
        ImageView img_fondKirito =(ImageView) dialog.findViewById(R.id.fon_Kirito);
        ImageView img_plaKirito =(ImageView) dialog.findViewById(R.id.pla_Kirito);//

        ImageView img_marco1 =(ImageView) dialog.findViewById(R.id.marco_sala1);
        ImageView img_marco2 =(ImageView) dialog.findViewById(R.id.marco_ud1);
        ImageView img_marco3 =(ImageView) dialog.findViewById(R.id.marco_mesa1);
        ImageView img_marco4 =(ImageView) dialog.findViewById(R.id.marco_idmesa1);

        img_marco1.setVisibility(View.GONE);
        img_marco2.setVisibility(View.GONE);
        img_marco3.setVisibility(View.GONE);
        img_marco4.setVisibility(View.GONE);
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);

        img_plaKirito.setVisibility(View.GONE);
        img_fondKirito.setVisibility(View.GONE);

        if(val.getKeyNick().contains("Kirito")){
            if(val.getKeyFormatoImgagen().equals("fondo")){

                img_fondKirito.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                img_marco4.setVisibility(View.VISIBLE);

            }else {
                if(val.getKeyFormatoImgagen().equals("player")){

                    img_plaKirito.setVisibility(View.VISIBLE);
                    img_marco1.setVisibility(View.VISIBLE);
                    img_marco2.setVisibility(View.VISIBLE);
                    img_marco3.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.VISIBLE);

                }
            }

        }

        val.setSearKeyCodigo(Integer.parseInt(val.getKeySiguienteN1()));

        if(val.getSearKeyCodigo() > 100  && val.getSearKeyCodigo() < 600) {
            val.setKeyEscaneoGrenio("azul");
            val.setKeyIdGremio("100");

        }else{
            if(val.getSearKeyCodigo() > 1100  && val.getSearKeyCodigo() < 1600) {
                val.setKeyEscaneoGrenio("rojo");
                val.setKeyIdGremio("1100");
            }else{
                if(val.getSearKeyCodigo() > 2100  && val.getSearKeyCodigo() < 2600) {
                    val.setKeyEscaneoGrenio("naranja");val.setKeyIdGremio("2100");
                }else{
                    if(val.getSearKeyCodigo() > 3100  && val.getSearKeyCodigo() < 3600) {
                        val.setKeyEscaneoGrenio("negro");val.setKeyIdGremio("3100");
                    }else {
                        if (val.getSearKeyCodigo() > 4100 && val.getSearKeyCodigo() < 4600) {
                            val.setKeyEscaneoGrenio("calido");val.setKeyIdGremio("4100");
                        } }}}}



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = t1.getText().toString();

                if(val.getKeyFormatoImgagen().equals("fondo")) {
                    l2.setText(id);
                }
                if(val.getKeyFormatoImgagen().equals("player")){
                    l1.setText(id);
                }else{

                HashMap <String, Object> dato = new HashMap<>();

                bdNeutro.collection("BDClanInfo").document("info"+val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {



                        if(documentSnapshot.exists()){


                            val.setKeyidClan1(documentSnapshot.getString("keyID1"));
                            val.setKeyidClan2(documentSnapshot.getString("keyID2"));
                            val.setKeyidClan3(documentSnapshot.getString("keyID3"));
                            val.setKeyidClan4(documentSnapshot.getString("keyID4"));
                            val.setKeyidClan5(documentSnapshot.getString("keyID5"));
                            val.setKeyidClan6(documentSnapshot.getString("keyID6"));



if(val.getKeyidClan1().equals("espera")){
 dato.put("keyID1",id);
}else{
                             if(val.getKeyidClan2().equals("espera")){
                                 if(t1.getText().toString().equals(val.getKeyidClan1())){

                                 }else {
                                     dato.put("keyID2", id);//val.getKeyNick()
                                     dato.put("key"+id, val.getKeyNick());//
                                 }
                             }else{
                                 if(val.getKeyidClan3().equals("espera")){
                                     if(t1.getText().toString().equals(val.getKeyidClan1())){

                                     }else {
                                         if(t1.getText().toString().equals(val.getKeyidClan2())){

                                         }else {
                                             dato.put("keyID3",id);
                                             dato.put("key"+id, val.getKeyNick());//
                                         }
                                     }

                                 }else{
                                     if(val.getKeyidClan4().equals("espera")){
                                         if(t1.getText().toString().equals(val.getKeyidClan1())){

                                         }else {
                                             if(t1.getText().toString().equals(val.getKeyidClan2())){

                                             }else {
                                                 if(t1.getText().toString().equals(val.getKeyidClan3())){

                                                 }else {
                                                     dato.put("keyID4", id);
                                                     dato.put("key"+id, val.getKeyNick());//
                                                 }
                                             }
                                         }
                                     }else{
                                         if(val.getKeyidClan5().equals("espera")){
                                             if(t1.getText().toString().equals(val.getKeyidClan1())){

                                             }else {
                                                 if(t1.getText().toString().equals(val.getKeyidClan2())){

                                                 }else {
                                                     if(t1.getText().toString().equals(val.getKeyidClan3())){

                                                     }else {
                                                         if(t1.getText().toString().equals(val.getKeyidClan4())){

                                                         }else {
                                                             dato.put("keyID5", id);
                                                             dato.put("key"+id, val.getKeyNick());//
                                                         }
                                                     }
                                                 }
                                             }
                                         }else{
                                             if(val.getKeyidClan6().equals("espera")){
                                                 if(t1.getText().toString().equals(val.getKeyidClan1())){

                                                 }else {
                                                     if(t1.getText().toString().equals(val.getKeyidClan2())){

                                                     }else {
                                                         if(t1.getText().toString().equals(val.getKeyidClan3())){

                                                         }else {
                                                             if(t1.getText().toString().equals(val.getKeyidClan4())){

                                                             }else {
                                                                 if(t1.getText().toString().equals(val.getKeyidClan5())){

                                                                 }else {
                                                                     dato.put("keyID6", id);
                                                                     dato.put("key"+id, val.getKeyNick());//
                                                                 }
                                                             }
                                                         }
                                                     }
                                                 }
                                             }else{
                                                 Toast.makeText(context1.getApplicationContext(), "NO hay mas campos por el momento.", Toast.LENGTH_SHORT).show();
                                             }
                                         }
                                     }
                                 }
                             }

                             bdNeutro.collection("BDClanInfo").document("info"+val.getKeySiguienteN1()).update(dato);
                         }


                        }else{


                            dato.put("keyID1",id);
                            dato.put("keyID2","espera");
                            dato.put("keyID3","espera");
                            dato.put("keyID4","espera");
                            dato.put("keyID5","espera");
                            dato.put("keyID6","espera");

                            dato.put("key"+id,val.getKeyNick());
                            dato.put("key","espera");
                            dato.put("key","espera");
                            dato.put("key","espera");
                            dato.put("key","espera");
                            dato.put("key","espera");
                            bdNeutro.collection("BDClanInfo").document("info"+val.getKeySiguienteN1()).set(dato);
                        }



                    }
                });}



            }
        });

        cerrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* contexto val = new contexto();


                Intent siguiente = new Intent(context1.getApplicationContext(), MainActivity2.class);

                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
                context1.startActivity(siguiente);*/

                dialog.dismiss();

            }
        });



        dialog.show();

    }







}
