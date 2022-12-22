package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class detlles_derrota_v4 {

    FirebaseFirestore bdNeutro;
    private  VideoView v1;


    public detlles_derrota_v4(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_v4__derrota);


        v1 = (VideoView)  dialog.findViewById(R.id.derrotaViedeo_v4);

        v1.setVideoURI(Uri.parse("android.resource://"+ context1.getPackageName() + "/" + R.raw.derrota));
        v1.setVisibility(View.GONE);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.derrotaV4_b1);


        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();
        TextView l1 = (TextView) dialog.findViewById(R.id.derrotaV4_l5);
        TextView l2 = (TextView) dialog.findViewById(R.id.derrotaV4_l1);
        TextView l3 = (TextView) dialog.findViewById(R.id.derrotaV4_l4);



        HashMap<String,Object> dato = new HashMap<>();

        bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){

                    val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                    val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                    val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                    val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));



                    val.setKeyEstado1(documentSnapshot.getString("puesto1"));
                    val.setKeyEstado2(documentSnapshot.getString("puesto2"));
                    val.setKeyEstado3(documentSnapshot.getString("puesto3"));
                    val.setKeyEstado4(documentSnapshot.getString("puesto4"));



                    val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                    val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                    val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                    val.setKeyParticipante4(documentSnapshot.getString("participante4"));

                } }});



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()) {


                            val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                            val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                            val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                            val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));


                            try {

                                if (val.getKeydueloFinal().equals("activado")) {


                                }else{

                                    if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
                                        val.setKeyDuelista2(val.getKeyCalabozolvl2());
                                    } else {
                                        if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
                                            val.setKeyDuelista2(val.getKeyCalabozolvl1());
                                        } else {
                                            if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyCalabozolvl4());
                                            } else {
                                                if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyCalabozolvl3());
                                                } } } }




                                }
                            }catch (Exception sfsf){
                                if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
                                    val.setKeyDuelista2(val.getKeyCalabozolvl2());
                                } else {
                                    if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
                                        val.setKeyDuelista2(val.getKeyCalabozolvl1());
                                    } else {
                                        if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
                                            val.setKeyDuelista2(val.getKeyCalabozolvl4());
                                        } else {
                                            if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyCalabozolvl3());
                                            } } } }
                            }



                            if(val.getKeyDuelista2().equals("auxiliar")){
                                Toast.makeText(context1.getApplicationContext(), "Espere duelista que definan los duelistas", Toast.LENGTH_SHORT).show();
                            }else{

                                int numeroAleatorio = (int) (Math.random() * 9999 + 999);
                                try {
                                    l1.setText(String.valueOf(numeroAleatorio));
                                } catch (Exception sdfs) {
                                }
                                HashMap<String, Object> dato2 = new HashMap<>();
                                HashMap<String, Object> dato = new HashMap<>();
                                HashMap<String, Object> dato1 = new HashMap<>();
                                dato.put("keyDerrotaCodigo" + val.getKeyDuelista2(), String.valueOf(numeroAleatorio));

                                if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
                                    dato.put("puestoN1", "derrota");
                                    if (val.getKeyEstado1().equals("esperando")) {
                                        if (val.getKeyEstado2().equals("esperando")) {
                                            if (val.getKeyEstado3().equals("esperando")) {
                                                if (val.getKeyEstado4().equals("esperando")) {
                                                        dato2.put("lvl4", "1");
                                                        dato2.put("puesto4", val.getKeyCalabozolvl1());

                                                } else {
                                                    dato2.put("lvl3", "1");
                                                    dato2.put("puesto3", val.getKeyCalabozolvl1());
                                                }
                                            } else {
                                                dato2.put("lvl2", "2");
                                                dato2.put("puesto2", val.getKeyCalabozolvl1());
                                                dato2.put("lvl1", "3");
                                                dato2.put("puesto1", val.getKeyDuelista2());
                                            } } }
                                    bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                } else {
                                    //          Toast.makeText(context1.getApplicationContext(), "2USUARIO: "+val.getKeyCalabozolvl2(), Toast.LENGTH_SHORT).show();
                                    if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
                                        dato.put("puestoN2", "derrota");
                                        //           Toast.makeText(context1.getApplicationContext(), "ENRANDO: "+val.getKeyCalabozolvl2(), Toast.LENGTH_SHORT).show();
                                        if (val.getKeyEstado1().equals("esperando")) {
                                            if (val.getKeyEstado2().equals("esperando")) {
                                                if (val.getKeyEstado3().equals("esperando")) {
                                                    if (val.getKeyEstado4().equals("esperando")) {

                                                            dato2.put("lvl4", "1");
                                                            dato2.put("puesto4", val.getKeyCalabozolvl2());
                                                            bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                                    } else {
                                                        dato2.put("lvl3", "1");
                                                        dato2.put("puesto3", val.getKeyCalabozolvl2());
                                                        bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);
                                                    }
                                                } else {
                                                    dato2.put("lvl2", "2");
                                                    dato2.put("puesto2", val.getKeyCalabozolvl2());
                                                    dato2.put("lvl1", "3");
                                                    dato2.put("puesto1", val.getKeyDuelista2());
                                                    bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);
                                                }
                                            }
                                        }

                                    } else {
                                        if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
                                            dato.put("puestoN3", "derrota");
                                            //              Toast.makeText(context1.getApplicationContext(), "3USUARIO: "+val.getKeyCalabozolvl2(), Toast.LENGTH_SHORT).show();
                                            if (val.getKeyEstado1().equals("esperando")) {
                                                if (val.getKeyEstado2().equals("esperando")) {
                                                    if (val.getKeyEstado3().equals("esperando")) {
                                                        if (val.getKeyEstado4().equals("esperando")) {

                                                                dato2.put("lvl4", "1");
                                                                dato2.put("puesto4", val.getKeyCalabozolvl3());

                                                        } else {
                                                            dato2.put("lvl3", "1");
                                                            dato2.put("puesto3", val.getKeyCalabozolvl3());
                                                        }
                                                    } else {
                                                        dato2.put("lvl2", "2");
                                                        dato2.put("puesto2", val.getKeyCalabozolvl3());
                                                        dato2.put("lvl1", "3");
                                                        dato2.put("puesto1", val.getKeyDuelista2());
                                                    }
                                                }
                                            }
                                            bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);
                                        } else {

                                            if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
                                                dato.put("puestoN4", "derrota");
                                                //          Toast.makeText(context1.getApplicationContext(), "4USUARIO: "+val.getKeyCalabozolvl4(), Toast.LENGTH_SHORT).show();
                                                if (val.getKeyEstado1().equals("esperando")) {
                                                    if (val.getKeyEstado2().equals("esperando")) {
                                                        if (val.getKeyEstado3().equals("esperando")) {
                                                            if (val.getKeyEstado4().equals("esperando")) {

                                                                    dato2.put("lvl4", "1");
                                                                    dato2.put("puesto4", val.getKeyCalabozolvl4());
                                                                } else {
                                                                dato2.put("lvl3", "1");
                                                                dato2.put("puesto3", val.getKeyCalabozolvl4());
                                                            } } else {
                                                            dato2.put("lvl2", "2");
                                                            dato2.put("puesto2", val.getKeyCalabozolvl4());
                                                            dato2.put("lvl1", "3");
                                                            dato2.put("puesto1", val.getKeyDuelista2());
                                                        } }}bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                            }
                                              } } }


                                bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                Toast.makeText(context1.getApplicationContext(), "Lo siento sera otra opurtunidad.", Toast.LENGTH_SHORT).show();

                                b1.setVisibility(View.GONE);
                                //      l1.setVisibility(View.GONE);
                                l2.setVisibility(View.GONE);
                                l3.setVisibility(View.GONE);
                                v1.setVisibility(View.VISIBLE);
                                v1.start();


                            }
                        }

                    }
                })      ;




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
