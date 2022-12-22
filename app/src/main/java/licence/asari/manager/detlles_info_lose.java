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


public class detlles_info_lose {

    FirebaseFirestore bdNeutro;

    public detlles_info_lose(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_info_lose);



        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.cerrar_info_lose);



        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        TextView l1 = (TextView) dialog.findViewById(R.id.info_l2);
        TextView l2 = (TextView) dialog.findViewById(R.id.info_l3);
        TextView l3 = (TextView) dialog.findViewById(R.id.info_l4);
        TextView l4 = (TextView) dialog.findViewById(R.id.info_l5);
        TextView l5 = (TextView) dialog.findViewById(R.id.info_l6);
        TextView l6 = (TextView) dialog.findViewById(R.id.info_l7);
        TextView l7 = (TextView) dialog.findViewById(R.id.info_l8);
        TextView l8 = (TextView) dialog.findViewById(R.id.info_l9);
        TextView l9 = (TextView) dialog.findViewById(R.id.info_l10);

        TextView l20 = (TextView) dialog.findViewById(R.id.info_l20);
        TextView l21 = (TextView) dialog.findViewById(R.id.info_l21);
        TextView l22 = (TextView) dialog.findViewById(R.id.info_l23);
        TextView l23 = (TextView) dialog.findViewById(R.id.info_l24);
        TextView l24 = (TextView) dialog.findViewById(R.id.info_l25);
        TextView l25 = (TextView) dialog.findViewById(R.id.info_l26);
        TextView l26 = (TextView) dialog.findViewById(R.id.info_l27);
        TextView l27 = (TextView) dialog.findViewById(R.id.info_l28);
        TextView l28 = (TextView) dialog.findViewById(R.id.info_l30);

        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);
        l6.setVisibility(View.GONE);
        l7.setVisibility(View.GONE);
        l8.setVisibility(View.GONE);
        l9.setVisibility(View.GONE);

        l20.setVisibility(View.GONE);
        l21.setVisibility(View.GONE);
        l22.setVisibility(View.GONE);
        l23.setVisibility(View.GONE);
        l24.setVisibility(View.GONE);
        l25.setVisibility(View.GONE);
        l26.setVisibility(View.GONE);
        l27.setVisibility(View.GONE);
        l28.setVisibility(View.GONE);



HashMap<String,Object> dato = new HashMap<>();
bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1())
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
 @Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

if(documentSnapshot.exists()){

    val.setKeyConteo(documentSnapshot.getString("keyConteo"));
        if(val.getKeyConteo().equals("4")){
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.VISIBLE);
            l3.setVisibility(View.VISIBLE);
            l4.setVisibility(View.VISIBLE);

            l20.setVisibility(View.VISIBLE);
            l21.setVisibility(View.VISIBLE);
            l22.setVisibility(View.VISIBLE);
            l23.setVisibility(View.VISIBLE);


            val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
            val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
            val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
            val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));

            val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
            val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
            val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
            val.setKeyEstado4(documentSnapshot.getString("puestoN4"));

            l20.setText(val.getKeyEstado1());
            l21.setText(val.getKeyEstado2());
            l22.setText(val.getKeyEstado3());
            l23.setText(val.getKeyEstado4());

            l1.setText(val.getKeyPuntosV4_1());
            l2.setText(val.getKeyPuntosV4_2());
            l3.setText(val.getKeyPuntosV4_3());
            l4.setText(val.getKeyPuntosV4_4());

        }else{
            if(val.getKeyConteo().equals("5")){
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.VISIBLE);
                l4.setVisibility(View.VISIBLE);
                l5.setVisibility(View.VISIBLE);

                l20.setVisibility(View.VISIBLE);
                l21.setVisibility(View.VISIBLE);
                l22.setVisibility(View.VISIBLE);
                l23.setVisibility(View.VISIBLE);
                l24.setVisibility(View.VISIBLE);

                val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));

                val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                val.setKeyEstado5(documentSnapshot.getString("puestoN5"));

                l20.setText(val.getKeyEstado1());
                l21.setText(val.getKeyEstado2());
                l22.setText(val.getKeyEstado3());
                l23.setText(val.getKeyEstado4());
                l24.setText(val.getKeyEstado5());

                l1.setText(val.getKeyPuntosV4_1());
                l2.setText(val.getKeyPuntosV4_2());
                l3.setText(val.getKeyPuntosV4_3());
                l4.setText(val.getKeyPuntosV4_4());
                l5.setText(val.getKeyPuntosV4_5());


            }else{
                if(val.getKeyConteo().equals("6")){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    l3.setVisibility(View.VISIBLE);
                    l4.setVisibility(View.VISIBLE);
                    l5.setVisibility(View.VISIBLE);
                    l6.setVisibility(View.VISIBLE);
                    l20.setVisibility(View.VISIBLE);
                    l21.setVisibility(View.VISIBLE);
                    l22.setVisibility(View.VISIBLE);
                    l23.setVisibility(View.VISIBLE);
                    l24.setVisibility(View.VISIBLE);
                    l25.setVisibility(View.VISIBLE);

                    val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                    val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                    val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                    val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                    val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                    val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));

                    val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                    val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                    val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                    val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                    val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                    val.setKeyEstado6(documentSnapshot.getString("puestoN6"));

                    l20.setText(val.getKeyEstado1());
                    l21.setText(val.getKeyEstado2());
                    l22.setText(val.getKeyEstado3());
                    l23.setText(val.getKeyEstado4());
                    l24.setText(val.getKeyEstado5());
                    l25.setText(val.getKeyEstado6());

                    l1.setText(val.getKeyPuntosV4_1());
                    l2.setText(val.getKeyPuntosV4_2());
                    l3.setText(val.getKeyPuntosV4_3());
                    l4.setText(val.getKeyPuntosV4_4());
                    l5.setText(val.getKeyPuntosV4_5());
                    l6.setText(val.getKeyPuntosV4_6());

                }else{
                    if(val.getKeyConteo().equals("7")){
                        l1.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.VISIBLE);
                        l4.setVisibility(View.VISIBLE);
                        l5.setVisibility(View.VISIBLE);
                        l6.setVisibility(View.VISIBLE);
                        l7.setVisibility(View.VISIBLE);

                        l20.setVisibility(View.VISIBLE);
                        l21.setVisibility(View.VISIBLE);
                        l22.setVisibility(View.VISIBLE);
                        l23.setVisibility(View.VISIBLE);
                        l24.setVisibility(View.VISIBLE);
                        l25.setVisibility(View.VISIBLE);
                        l26.setVisibility(View.VISIBLE);
                        val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                        val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                        val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                        val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                        val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                        val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                        val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));

                        val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                        val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                        val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                        val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                        val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                        val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
                        val.setKeyEstado7(documentSnapshot.getString("puestoN7"));

                        l20.setText(val.getKeyEstado1());
                        l21.setText(val.getKeyEstado2());
                        l22.setText(val.getKeyEstado3());
                        l23.setText(val.getKeyEstado4());
                        l24.setText(val.getKeyEstado5());
                        l25.setText(val.getKeyEstado6());
                        l26.setText(val.getKeyEstado7());

                        l1.setText(val.getKeyPuntosV4_1());
                        l2.setText(val.getKeyPuntosV4_2());
                        l3.setText(val.getKeyPuntosV4_3());
                        l4.setText(val.getKeyPuntosV4_4());
                        l5.setText(val.getKeyPuntosV4_5());
                        l6.setText(val.getKeyPuntosV4_6());
                        l7.setText(val.getKeyPuntosV4_7());



                    }else{
                        if(val.getKeyConteo().equals("8")){
                            l1.setVisibility(View.VISIBLE);
                            l2.setVisibility(View.VISIBLE);
                            l3.setVisibility(View.VISIBLE);
                            l4.setVisibility(View.VISIBLE);
                            l5.setVisibility(View.VISIBLE);
                            l6.setVisibility(View.VISIBLE);
                            l7.setVisibility(View.VISIBLE);
                            l8.setVisibility(View.VISIBLE);

                            l20.setVisibility(View.VISIBLE);
                            l21.setVisibility(View.VISIBLE);
                            l22.setVisibility(View.VISIBLE);
                            l23.setVisibility(View.VISIBLE);
                            l24.setVisibility(View.VISIBLE);
                            l25.setVisibility(View.VISIBLE);
                            l26.setVisibility(View.VISIBLE);
                            l27.setVisibility(View.VISIBLE);

                            val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                            val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                            val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                            val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                            val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                            val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                            val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                            val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));

                            val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                            val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                            val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                            val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                            val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                            val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
                            val.setKeyEstado7(documentSnapshot.getString("puestoN7"));
                            val.setKeyEstado8(documentSnapshot.getString("puestoN8"));

                            l20.setText(val.getKeyEstado1());
                            l21.setText(val.getKeyEstado2());
                            l22.setText(val.getKeyEstado3());
                            l23.setText(val.getKeyEstado4());
                            l24.setText(val.getKeyEstado5());
                            l25.setText(val.getKeyEstado6());
                            l26.setText(val.getKeyEstado7());
                            l27.setText(val.getKeyEstado8());

                            l1.setText(val.getKeyPuntosV4_1());
                            l2.setText(val.getKeyPuntosV4_2());
                            l3.setText(val.getKeyPuntosV4_3());
                            l4.setText(val.getKeyPuntosV4_4());
                            l5.setText(val.getKeyPuntosV4_5());
                            l6.setText(val.getKeyPuntosV4_6());
                            l7.setText(val.getKeyPuntosV4_7());
                            l8.setText(val.getKeyPuntosV4_8());
                        }else{
                            if(val.getKeyConteo().equals("9")){
                                l1.setVisibility(View.VISIBLE);
                                l2.setVisibility(View.VISIBLE);
                                l3.setVisibility(View.VISIBLE);
                                l4.setVisibility(View.VISIBLE);
                                l5.setVisibility(View.VISIBLE);
                                l6.setVisibility(View.VISIBLE);
                                l7.setVisibility(View.VISIBLE);
                                l8.setVisibility(View.VISIBLE);
                                l9.setVisibility(View.VISIBLE);

                                l20.setVisibility(View.VISIBLE);
                                l21.setVisibility(View.VISIBLE);
                                l22.setVisibility(View.VISIBLE);
                                l23.setVisibility(View.VISIBLE);
                                l24.setVisibility(View.VISIBLE);
                                l25.setVisibility(View.VISIBLE);
                                l26.setVisibility(View.VISIBLE);
                                l27.setVisibility(View.VISIBLE);
                                l28.setVisibility(View.VISIBLE);


                                val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                                val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));
                                val.setKeyPuntosV4_9(documentSnapshot.getString("lvl9"));

                                val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                                val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                                val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                                val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                                val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                                val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
                                val.setKeyEstado7(documentSnapshot.getString("puestoN7"));
                                val.setKeyEstado8(documentSnapshot.getString("puestoN8"));
                                val.setKeyEstado9(documentSnapshot.getString("puestoN9"));

                                l20.setText(val.getKeyEstado1());
                                l21.setText(val.getKeyEstado2());
                                l22.setText(val.getKeyEstado3());
                                l23.setText(val.getKeyEstado4());
                                l24.setText(val.getKeyEstado5());
                                l25.setText(val.getKeyEstado6());
                                l26.setText(val.getKeyEstado7());
                                l27.setText(val.getKeyEstado8());
                                l28.setText(val.getKeyEstado9());

                                l1.setText(val.getKeyPuntosV4_1());
                                l2.setText(val.getKeyPuntosV4_2());
                                l3.setText(val.getKeyPuntosV4_3());
                                l4.setText(val.getKeyPuntosV4_4());
                                l5.setText(val.getKeyPuntosV4_5());
                                l6.setText(val.getKeyPuntosV4_6());
                                l7.setText(val.getKeyPuntosV4_7());
                                l8.setText(val.getKeyPuntosV4_8());
                                l9.setText(val.getKeyPuntosV4_9());

                            }
                        }
                    }
                }
            }
        }













                } }});





        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }



}
