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


public class detlles_derrota_v7 {

    FirebaseFirestore bdNeutro;
    private  VideoView v1;


    public detlles_derrota_v7(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_v7__derrota);


        v1 = (VideoView)  dialog.findViewById(R.id.derrotaVideov7);

        v1.setVideoURI(Uri.parse("android.resource://"+ context1.getPackageName() + "/" + R.raw.derrota));
        v1.setVisibility(View.GONE);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.v7_derrota_b1);


        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();
        TextView l1 = (TextView) dialog.findViewById(R.id.derrotaV7_l1);
        TextView l2 = (TextView) dialog.findViewById(R.id.derrotaV7_l2);
        TextView l3 = (TextView) dialog.findViewById(R.id.derrotaV6_l3);



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
                    val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                    val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                    val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));

                    val.setKeyEstado1(documentSnapshot.getString("puesto1"));
                    val.setKeyEstado2(documentSnapshot.getString("puesto2"));
                    val.setKeyEstado3(documentSnapshot.getString("puesto3"));
                    val.setKeyEstado4(documentSnapshot.getString("puesto4"));
                    val.setKeyEstado5(documentSnapshot.getString("puesto5"));
                    val.setKeyEstado6(documentSnapshot.getString("puesto6"));
                    val.setKeyEstado7(documentSnapshot.getString("puesto7"));


                    val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                    val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                    val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                    val.setKeyParticipante4(documentSnapshot.getString("participante4"));
                    val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                    val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                    val.setKeyParticipante7(documentSnapshot.getString("participante7"));
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
                            val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                            val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                            val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));

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
                                                } else {
                                                    if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyCalabozolvl6());
                                                    } else {
                                                        if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
                                                            val.setKeyDuelista2(val.getKeyCalabozolvl5());
                                                        }else{
                                                            if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {

                                                                if(val.getKeyEstado5().equals("derrota")){
                                                                    val.setKeyDuelista2(val.getKeyCalabozolvl6());
                                                                }else{
                                                                    if(val.getKeyEstado6().equals("derrota")){
                                                                        val.setKeyDuelista2(val.getKeyCalabozolvl5());
                                                                    }else{
                                                                        Toast.makeText(context1.getApplicationContext(), "Aun su rival no ha sido definido epera.. Arigato.", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }

                                                            } } } } } } }




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
                                            } else {
                                                if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyCalabozolvl6());
                                                } else {
                                                    if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyCalabozolvl7());
                                                    }else{
                                                        if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {
                                                            val.setKeyDuelista2(val.getKeyCalabozolvl6());
                                                        } } } } } } }
                            }


                            if(val.getKeyDuelista2().equals("auxiliar")){
                                Toast.makeText(context1.getApplicationContext(), "Espere duelista que definan los duelistas", Toast.LENGTH_SHORT).show();
                            }else{

                             /*   int numeroAleatorio = (int) (Math.random() * 9999 + 999);
                                try {
                                    l1.setText(String.valueOf(numeroAleatorio));
                                } catch (Exception sdfs) {
                                }*/

                                HashMap<String, Object> dato2 = new HashMap<>();
                                HashMap<String, Object> dato = new HashMap<>();
                                HashMap<String, Object> dato1 = new HashMap<>();

                                if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
                                    dato.put("puestoN1", "derrota");
                                    if (val.getKeyEstado1().equals("esperando")) {
                                        if (val.getKeyEstado2().equals("esperando")) {
                                            if (val.getKeyEstado3().equals("esperando")) {
                                                if (val.getKeyEstado4().equals("esperando")) {
                                                    if (val.getKeyEstado5().equals("esperando")) {
                                                        if (val.getKeyEstado6().equals("esperando")) {
                                                            if (val.getKeyEstado7().equals("esperando")) {
                                                                dato2.put("lvl7", "1");lose();
                                                                dato2.put("puesto7", val.getKeyCalabozolvl1());
                                                            }else{
                                                                dato2.put("lvl6", "1");lose();
                                                                dato2.put("puesto6", val.getKeyCalabozolvl1());
                                                            }
                                                        } else {
                                                            dato2.put("lvl5", "1");lose();
                                                            dato2.put("puesto5", val.getKeyCalabozolvl1());
                                                        }
                                                    } else {
                                                        dato2.put("lvl4", "1");lose();
                                                        dato2.put("puesto4", val.getKeyCalabozolvl1());
                                                    }
                                                } else {
                                                    dato2.put("lvl3", "1");lose();
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
                                                        if (val.getKeyEstado5().equals("esperando")) {
                                                            if (val.getKeyEstado6().equals("esperando")) {
                                                                if (val.getKeyEstado7().equals("esperando")) {
                                                                    dato2.put("lvl7", "1");lose();
                                                                    dato2.put("puesto7", val.getKeyCalabozolvl2());
                                                                }else{
                                                                    dato2.put("lvl6", "1");lose();
                                                                    dato2.put("puesto6", val.getKeyCalabozolvl2());
                                                                    bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                                                }
                                                            } else {
                                                                dato2.put("lvl5", "1");lose();
                                                                dato2.put("puesto5", val.getKeyCalabozolvl2());
                                                                bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);
                                                            }
                                                        } else {
                                                            dato2.put("lvl4", "1");lose();
                                                            dato2.put("puesto4", val.getKeyCalabozolvl2());
                                                            bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);
                                                        }
                                                    } else {
                                                        dato2.put("lvl3", "1");lose();
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
                                                            if (val.getKeyEstado5().equals("esperando")) {
                                                                if (val.getKeyEstado6().equals("esperando")) {
                                                                    if (val.getKeyEstado7().equals("esperando")) {
                                                                        dato2.put("lvl7", "1");lose();
                                                                        dato2.put("puesto7", val.getKeyCalabozolvl3());
                                                                    }else{

                                                                        dato2.put("lvl6", "1");lose();
                                                                        dato2.put("puesto6", val.getKeyCalabozolvl3());}
                                                                } else {
                                                                    dato2.put("lvl5", "1");lose();
                                                                    dato2.put("puesto5", val.getKeyCalabozolvl3());
                                                                }
                                                            } else {
                                                                dato2.put("lvl4", "1");lose();
                                                                dato2.put("puesto4", val.getKeyCalabozolvl3());
                                                            }
                                                        } else {
                                                            dato2.put("lvl3", "1");lose();
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
                                                                if (val.getKeyEstado5().equals("esperando")) {
                                                                    if (val.getKeyEstado6().equals("esperando")) {
                                                                        if (val.getKeyEstado7().equals("esperando")) {
                                                                            dato2.put("lvl7", "1");lose();
                                                                            dato2.put("puesto7", val.getKeyCalabozolvl4());
                                                                        }else{

                                                                            dato2.put("lvl6", "1");lose();
                                                                            dato2.put("puesto6", val.getKeyCalabozolvl4());}
                                                                    } else {
                                                                        dato2.put("lvl5", "1");lose();
                                                                        dato2.put("puesto5", val.getKeyCalabozolvl4());
                                                                    } } else {
                                                                    dato2.put("lvl4", "1");lose();
                                                                    dato2.put("puesto4", val.getKeyCalabozolvl4());
                                                                } } else {
                                                                dato2.put("lvl3", "1");lose();
                                                                dato2.put("puesto3", val.getKeyCalabozolvl4());
                                                            } } else {
                                                            dato2.put("lvl2", "2");
                                                            dato2.put("puesto2", val.getKeyCalabozolvl4());
                                                            dato2.put("lvl1", "3");
                                                            dato2.put("puesto1", val.getKeyDuelista2());
                                                        } }}bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                            }else{
                                                if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {

                                                    dato.put("puestoN5", "derrota");
                                                    //          Toast.makeText(context1.getApplicationContext(), "5USUARIO: "+val.getKeyCalabozolvl5(), Toast.LENGTH_SHORT).show();
                                                    if (val.getKeyEstado1().equals("esperando")) {
                                                        if (val.getKeyEstado2().equals("esperando")) {
                                                            if (val.getKeyEstado3().equals("esperando")) {
                                                                if (val.getKeyEstado4().equals("esperando")) {
                                                                    if (val.getKeyEstado5().equals("esperando")) {
                                                                        if (val.getKeyEstado6().equals("esperando")) {
                                                                            if (val.getKeyEstado7().equals("esperando")) {
                                                                                dato2.put("lvl7", "1");lose();
                                                                                dato2.put("puesto7", val.getKeyCalabozolvl5());
                                                                            }else{
                                                                                dato2.put("lvl6", "1");lose();
                                                                                dato2.put("puesto6", val.getKeyCalabozolvl5());}
                                                                        } else {
                                                                            dato2.put("lvl5", "1");lose();
                                                                            dato2.put("puesto5", val.getKeyCalabozolvl5());
                                                                        } } else {
                                                                        dato2.put("lvl4", "1");lose();
                                                                        dato2.put("puesto4", val.getKeyCalabozolvl5());
                                                                    } } else {
                                                                    dato2.put("lvl3", "1");lose();
                                                                    dato2.put("puesto3", val.getKeyCalabozolvl5());
                                                                } } else {
                                                                dato2.put("lvl2", "2");
                                                                dato2.put("puesto2", val.getKeyCalabozolvl5());
                                                                dato2.put("lvl1", "3");
                                                                dato2.put("puesto1", val.getKeyDuelista2());
                                                            } }}bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                                }else{
                                                    if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
                                                        dato.put("puestoN6", "derrota");
                                                        //         Toast.makeText(context1.getApplicationContext(), "final", Toast.LENGTH_SHORT).show();

                                                        if (val.getKeyEstado1().equals("esperando")) {
                                                            if (val.getKeyEstado2().equals("esperando")) {
                                                                if (val.getKeyEstado3().equals("esperando")) {
                                                                    if (val.getKeyEstado4().equals("esperando")) {
                                                                        if (val.getKeyEstado5().equals("esperando")) {
                                                                            if (val.getKeyEstado6().equals("esperando")) {
                                                                                if (val.getKeyEstado7().equals("esperando")) {
                                                                                    dato2.put("lvl7", "1");lose();
                                                                                    dato2.put("puesto7", val.getKeyCalabozolvl6());
                                                                                }else{
                                                                                    dato2.put("lvl6", "1");lose();
                                                                                    dato2.put("puesto6", val.getKeyCalabozolvl6());}
                                                                            } else {
                                                                                dato2.put("lvl5", "1");lose();
                                                                                dato2.put("puesto5", val.getKeyCalabozolvl6());
                                                                            } } else {
                                                                            dato2.put("lvl4", "1");lose();
                                                                            dato2.put("puesto4", val.getKeyCalabozolvl6());
                                                                        } } else {
                                                                        dato2.put("lvl3", "1");lose();
                                                                        dato2.put("puesto3", val.getKeyCalabozolvl6());
                                                                    } } else {
                                                                    dato2.put("lvl2", "2");
                                                                    dato2.put("puesto2", val.getKeyCalabozolvl6());
                                                                    dato2.put("lvl1", "3");
                                                                    dato2.put("puesto1", val.getKeyDuelista2());
                                                                } } }
                                                        bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                                    } else{
                                                        if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {
                                                            dato.put("puestoN7", "derrota");

                                                            if (val.getKeyEstado1().equals("esperando")) {
                                                                if (val.getKeyEstado2().equals("esperando")) {
                                                                    if (val.getKeyEstado3().equals("esperando")) {
                                                                        if (val.getKeyEstado4().equals("esperando")) {
                                                                            if (val.getKeyEstado5().equals("esperando")) {
                                                                                if (val.getKeyEstado6().equals("esperando")) {
                                                                                    if (val.getKeyEstado7().equals("esperando")) {
                                                                                        dato2.put("lvl7", "1");lose();
                                                                                        dato2.put("puesto7", val.getKeyCalabozolvl7());
                                                                                    }else{
                                                                                        dato2.put("lvl6", "1");lose();
                                                                                        dato2.put("puesto6", val.getKeyCalabozolvl7());}
                                                                                } else {
                                                                                    dato2.put("lvl5", "1");lose();
                                                                                    dato2.put("puesto5", val.getKeyCalabozolvl7());
                                                                                } } else {
                                                                                dato2.put("lvl4", "1");lose();
                                                                                dato2.put("puesto4", val.getKeyCalabozolvl7());
                                                                            } } else {
                                                                            dato2.put("lvl3", "1");lose();
                                                                            dato2.put("puesto3", val.getKeyCalabozolvl7());
                                                                        } } else {
                                                                        dato2.put("lvl2", "2");
                                                                        dato2.put("puesto2", val.getKeyCalabozolvl7());
                                                                        dato2.put("lvl1", "3");
                                                                        dato2.put("puesto1", val.getKeyDuelista2());
                                                                    } } }
                                                            bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato2);

                                                        }
                                                    }
                                                } } } } }


                                bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                Toast.makeText(context1.getApplicationContext(), "Lo siento sera otra opurtunidad.", Toast.LENGTH_SHORT).show();

                                b1.setVisibility(View.GONE);
                                //      l1.setVisibility(View.GONE);
                                l2.setVisibility(View.GONE);
                                l3.setVisibility(View.GONE);
                                v1.setVisibility(View.VISIBLE);
                                v1.start();

                                historialduelo();
                            }











}}})      ;}});

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }
    public void lose(){

        contexto val =new contexto();

        HashMap<String,Object> dato = new HashMap<>();
        bdNeutro.collection("BDcalabozo").document("tablaPreregistroLose").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {


                    val.setKeyParticipanteLose1(documentSnapshot.getString("participante1"));
                    val.setKeyParticipanteLose2(documentSnapshot.getString("participante2"));
                    val.setKeyParticipanteLose3(documentSnapshot.getString("participante3"));
                    val.setKeyParticipanteLose4(documentSnapshot.getString("participante4"));
                    val.setKeyParticipanteLose5(documentSnapshot.getString("participante5"));
                    val.setKeyParticipanteLose6(documentSnapshot.getString("participante6"));
                    val.setKeyParticipanteLose7(documentSnapshot.getString("participante7"));
                    val.setKeyParticipanteLose8(documentSnapshot.getString("participante8"));
                    val.setKeyParticipanteLose9(documentSnapshot.getString("participante9"));
                    val.setKeyParticipanteLose10(documentSnapshot.getString("participante10"));
                    val.setKeyParticipanteLose11(documentSnapshot.getString("participante11"));

                    if(val.getKeyParticipanteLose1().equals("eperando")){
                        //crea
                        dato.put("participante1", val.getKeyNick());

                    }else{
                        if(val.getKeyParticipanteLose2().equals("eperando")){
                            //crea
                            dato.put("participante2",val.getKeyNick());
                        }else{
                            if(val.getKeyParticipanteLose3().equals("eperando")){
                                dato.put("participante3",val.getKeyNick());
                            }else {
                                if(val.getKeyParticipanteLose4().equals("eperando")){
                                    dato.put("participante4", val.getKeyNick());
                                }else{
                                    if(val.getKeyParticipanteLose4().equals("eperando")){
                                        dato.put("participante4", val.getKeyNick());
                                    }else{
                                        if(val.getKeyParticipanteLose5().equals("eperando")){
                                            dato.put("participante5", val.getKeyNick());
                                        }else{
                                            if(val.getKeyParticipanteLose6().equals("eperando")){
                                                dato.put("participante6", val.getKeyNick());
                                            }else{
                                                if(val.getKeyParticipanteLose7().equals("eperando")){
                                                    dato.put("participante7", val.getKeyNick());
                                                }else{
                                                    if(val.getKeyParticipanteLose8().equals("eperando")){
                                                        dato.put("participante8",val.getKeyNick());
                                                    }else{
                                                        if(val.getKeyParticipanteLose9().equals("eperando")){
                                                            dato.put("participante9", val.getKeyNick());
                                                        }else{
                                                            if(val.getKeyParticipanteLose10().equals("eperando")){
                                                                dato.put("participante10", val.getKeyNick());
                                                            }else{
                                                                if(val.getKeyParticipanteLose11().equals("eperando")){
                                                                    dato.put("participante11",val.getKeyNick());
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
                    bdNeutro.collection("BDcalabozo").document("tablaPreregistroLose").update(dato);
                }else{


                    dato.put("participante1", val.getKeyDuelista());
                    dato.put("participante2","eperando");
                    dato.put("participante3","eperando");
                    dato.put("participante4","eperando");
                    dato.put("participante5","eperando");
                    dato.put("participante6","eperando");
                    dato.put("participante7","eperando");
                    dato.put("participante8","eperando");
                    dato.put("participante9","eperando");
                    dato.put("participante10","eperando");
                    dato.put("participante11","eperando");

                    bdNeutro.collection("BDcalabozo").document("tablaPreregistroLose").set(dato);
                }
            }});

    }


    public void historialduelo(){

        contexto val = new contexto();

        bdNeutro.collection("BDcalabozo").document("tablaEncuentro")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        HashMap<String, Object> dato4 = new HashMap<>();

                        if(documentSnapshot.exists()) {
                            try {

                                val.setKeyAdmonEncuentro1(documentSnapshot.getString(val.getKeyDuelista2() + "VS" + val.getKeyNick()));///ganador
                                val.setKeyAdmonEncuentro2(documentSnapshot.getString(val.getKeyNick() + "VS" + val.getKeyDuelista2()));///perdedor

                                val.setKeyTotalDerrotasLose(documentSnapshot.getString(val.getKeyNick() + "DERROTA"));
                                val.setKeyTotalVictoriasLose(documentSnapshot.getString(val.getKeyDuelista2() + "VICTORIA"));

                                val.setKeyJ9(Integer.parseInt(val.getKeyAdmonEncuentro2()));//perdedor
                                val.setKeyJ8(Integer.parseInt(val.getKeyAdmonEncuentro1()));//ganador
                                val.setKeyJ8(val.getKeyJ8() + 1);

                                val.setKeyJ10(Integer.parseInt(val.getKeyTotalDerrotasLose()));//perdedor
                                val.setKeyJ10(val.getKeyJ10() + 1);

                                val.setKeyJ11(Integer.parseInt(val.getKeyTotalVictoriasLose()));//perdedor
                                val.setKeyJ11(val.getKeyJ11() + 1);

                                dato4.put(val.getKeyDuelista2() + "VS" + val.getKeyNick(), String.valueOf(val.getKeyJ8()));
                                dato4.put(val.getKeyNick() + "VS" + val.getKeyDuelista2(), String.valueOf(val.getKeyJ9()));

                                dato4.put(val.getKeyNick() + "DERROTA", String.valueOf(val.getKeyJ10()));
                                dato4.put(val.getKeyDuelista2() + "VICTORIA", String.valueOf(val.getKeyJ11()));

                                bdNeutro.collection("BDcalabozo").document("tablaEncuentro").update(dato4);


                            }catch (Exception dsfds){

                                dato4.put(val.getKeyDuelista2() + "VS" + val.getKeyNick(), "1");
                                dato4.put(val.getKeyNick()+ "VS" +val.getKeyDuelista2()  , "0");
                                dato4.put( val.getKeyNick() + "DERROTA", "1");
                                dato4.put( val.getKeyDuelista2() + "VICTORIA","1");

                                bdNeutro.collection("BDcalabozo").document("tablaEncuentro").update(dato4);

                            }


                        }else{
                            dato4.put(val.getKeyDuelista2() + "VS" + val.getKeyNick(), "1");
                            dato4.put(val.getKeyNick()+ "VS" +val.getKeyDuelista2()  , "0");

                            dato4.put( val.getKeyNick() + "DERROTA", "1");
                            dato4.put( val.getKeyDuelista2() + "VICTORIA","1");

                            bdNeutro.collection("BDcalabozo").document("tablaEncuentro").set(dato4);
                        }

                    }});

    }

}
