package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
import java.util.Stack;


public class detlles_politicas_dungeon {

    FirebaseFirestore bdNeutro;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    private Stack<String> idV1 = new Stack<>();

    public detlles_politicas_dungeon(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_politicas);




        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.politica_cierre_semana);


        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

       l1 = (TextView) dialog.findViewById(R.id.politicas_l1);
       l2 = (TextView) dialog.findViewById(R.id.politicas_l2);
       l3 = (TextView) dialog.findViewById(R.id.politicas_l3);
       l4 = (TextView) dialog.findViewById(R.id.politicas_l4);
       l5 = (TextView) dialog.findViewById(R.id.politicas_l5);
       l6 = (TextView) dialog.findViewById(R.id.politicas_l6);
       l7 = (TextView) dialog.findViewById(R.id.politicas_l7);
       l8 = (TextView) dialog.findViewById(R.id.politicas_l8);
       l9 = (TextView) dialog.findViewById(R.id.politicas_l9);
       l10 = (TextView) dialog.findViewById(R.id.politicas_l10);
       l11 = (TextView) dialog.findViewById(R.id.politicas_l11);
       l12 = (TextView) dialog.findViewById(R.id.politicas_l12);

        l1.setVisibility(View.GONE);l8.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);l9.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);l10.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);l11.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);l12.setVisibility(View.GONE);
        l6.setVisibility(View.GONE);
        l7.setVisibility(View.GONE);

        TextView la = (TextView) dialog.findViewById(R.id.politicas_la);
        TextView la2 = (TextView) dialog.findViewById(R.id.politicas_la2);
        TextView la3 = (TextView) dialog.findViewById(R.id.politicas_la3);
        TextView la4 = (TextView) dialog.findViewById(R.id.politicas_la4);
        TextView la5 = (TextView) dialog.findViewById(R.id.politicas_la5);
        TextView la6 = (TextView) dialog.findViewById(R.id.politicas_la6);
        TextView la7 = (TextView) dialog.findViewById(R.id.politicas_la7);
        TextView la8 = (TextView) dialog.findViewById(R.id.politicas_la8);
        TextView la9 = (TextView) dialog.findViewById(R.id.politicas_la9);
        TextView la10 = (TextView) dialog.findViewById(R.id.politicas_la10);
        TextView la11 = (TextView) dialog.findViewById(R.id.politicas_la11);
        TextView la12 = (TextView) dialog.findViewById(R.id.politicas_la12);

        la.setVisibility(View.GONE);la8.setVisibility(View.GONE);
        la2.setVisibility(View.GONE);la9.setVisibility(View.GONE);
        la3.setVisibility(View.GONE);la10.setVisibility(View.GONE);
        la4.setVisibility(View.GONE);la11.setVisibility(View.GONE);
        la5.setVisibility(View.GONE);la12.setVisibility(View.GONE);
        la6.setVisibility(View.GONE);
        la7.setVisibility(View.GONE);

        TextView lb = (TextView) dialog.findViewById(R.id.politicas_lb);
        TextView lb1 = (TextView) dialog.findViewById(R.id.politicas_lb2);//politicas_lb2
        TextView lb2 = (TextView) dialog.findViewById(R.id.politicas_lb3);
        TextView lb3 = (TextView) dialog.findViewById(R.id.politicas_lb4);
        TextView lb4 = (TextView) dialog.findViewById(R.id.politicas_lb5);
        TextView lb5 = (TextView) dialog.findViewById(R.id.politicas_lb6);
        TextView lb6 = (TextView) dialog.findViewById(R.id.politicas_lb7);
        TextView lb7 = (TextView) dialog.findViewById(R.id.politicas_lb8);
        TextView lb8 = (TextView) dialog.findViewById(R.id.politicas_lb9);
        TextView lb9 = (TextView) dialog.findViewById(R.id.politicas_lb10);
        TextView lb10 = (TextView) dialog.findViewById(R.id.politicas_lb11);
        TextView lb11 = (TextView) dialog.findViewById(R.id.politicas_lb12);

        lb.setVisibility(View.GONE);lb8.setVisibility(View.GONE);
        lb2.setVisibility(View.GONE);lb9.setVisibility(View.GONE);
        lb3.setVisibility(View.GONE);lb10.setVisibility(View.GONE);
        lb4.setVisibility(View.GONE);lb11.setVisibility(View.GONE);
        lb5.setVisibility(View.GONE);lb1.setVisibility(View.GONE);
        lb6.setVisibility(View.GONE);
        lb7.setVisibility(View.GONE);

        TextView lb13 = (TextView) dialog.findViewById(R.id.politicas_lb13);
        TextView lb14 = (TextView) dialog.findViewById(R.id.politicas_lb14);
        TextView lb15 = (TextView) dialog.findViewById(R.id.politicas_lb15);
        TextView lb16 = (TextView) dialog.findViewById(R.id.politicas_lb16);
        TextView lb17 = (TextView) dialog.findViewById(R.id.politicas_lb17);
        TextView lb18 = (TextView) dialog.findViewById(R.id.politicas_lb18);
        TextView lb19 = (TextView) dialog.findViewById(R.id.politicas_lb19);
        TextView lb20 = (TextView) dialog.findViewById(R.id.politicas_lb20);
        TextView lb21 = (TextView) dialog.findViewById(R.id.politicas_lb21);
        TextView lb22 = (TextView) dialog.findViewById(R.id.politicas_lb22);
        TextView lb23 = (TextView) dialog.findViewById(R.id.politicas_lb23);
        TextView lb24 = (TextView) dialog.findViewById(R.id.politicas_lb24);

        lb13.setVisibility(View.GONE);lb20.setVisibility(View.GONE);
        lb14.setVisibility(View.GONE);lb21.setVisibility(View.GONE);
        lb15.setVisibility(View.GONE);lb22.setVisibility(View.GONE);
        lb16.setVisibility(View.GONE);lb23.setVisibility(View.GONE);
        lb17.setVisibility(View.GONE);lb24.setVisibility(View.GONE);
        lb18.setVisibility(View.GONE);
        lb19.setVisibility(View.GONE);






        bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

            if(documentSnapshot.exists()){

           if(val.getKeyRutaDungeon1().equals("tablaUp0lose")){
               val.setKeyJ1(Integer.parseInt(val.getKeyConteo()));

           } else{
           val.setKeyJ1(Integer.parseInt(val.getKeyCalabozoActivo()));}

                        if(val.getKeyJ1()==4){
                            if(val.getKeyRutaDungeon1().equals("tablaUp0lose")){
                                val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                                val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                                val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                                val.setKeyEstado4(documentSnapshot.getString("puestoN4"));

                            } else{

                                val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                                val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                                val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                                val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                            }


                            l1.setText(val.getKeyEstado1());
                            l2.setText(val.getKeyEstado2());
                            l3.setText(val.getKeyEstado3());
                            l4.setText(val.getKeyEstado4());

                            l1.setVisibility(View.VISIBLE);
                            l2.setVisibility(View.VISIBLE);
                            l3.setVisibility(View.VISIBLE);

                            val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                            val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                            val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                            val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));

                            la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);
                            la2.setVisibility(View.VISIBLE);
                            la3.setVisibility(View.VISIBLE);

                            la.setText(val.getKeyPuntosV4_1());
                            la2.setText(val.getKeyPuntosV4_2());
                            la3.setText(val.getKeyPuntosV4_3());
                            la4.setText(val.getKeyPuntosV4_4());

                            bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio())
                                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                    if(documentSnapshot.exists()){

                                        val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                        val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                        val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                        val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                        val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                        val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                        val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));

                                        val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                        val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                        val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                        val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                        val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                        val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                        val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));

                                        lb.setText(val.getKeyFinalPuesto1());
                                        lb2.setText(val.getKeyFinalPuesto2());
                                        lb3.setText(val.getKeyFinalPuesto3());
                                        lb4.setText(val.getKeyFinalPuesto4());
                                        lb5.setText(val.getKeyFinalPuesto5());
                                        lb6.setText(val.getKeyFinalPuesto6());
                                        lb7.setText(val.getKeyFinalPuesto7());

                                        lb13.setText(val.getKeyLugarFinal1());
                                        lb14.setText(val.getKeyLugarFinal2());
                                        lb15.setText(val.getKeyLugarFinal3());
                                        lb16.setText(val.getKeyLugarFinal4());
                                        lb17.setText(val.getKeyLugarFinal5());
                                        lb18.setText(val.getKeyLugarFinal6());
                                        lb19.setText(val.getKeyLugarFinal7());

                                        lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);
                                        lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                        lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                        lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);
                                        lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);
                                        lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                    }
                                }});

                        }else{
                            if(val.getKeyJ1()==5){

                                if(val.getKeyRutaDungeon1().equals("tablaUp0lose")){
                                    val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                                    val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                                    val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                                    val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                                    val.setKeyEstado5(documentSnapshot.getString("puestoN5"));


                                } else{

                                    val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                                    val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                                    val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                                    val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                                    val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                                }


                                l1.setText(val.getKeyEstado1());l5.setText(val.getKeyEstado5());
                                l2.setText(val.getKeyEstado2());
                                l3.setText(val.getKeyEstado3());
                                l4.setText(val.getKeyEstado4());


                                l1.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);
                                l2.setVisibility(View.VISIBLE);
                                l3.setVisibility(View.VISIBLE);

                                val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));

                                la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                la2.setText(val.getKeyPuntosV4_2());
                                la3.setText(val.getKeyPuntosV4_3());
                                la4.setText(val.getKeyPuntosV4_4());

                                la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);
                                la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);
                                la3.setVisibility(View.VISIBLE);

                                bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio())
                                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                                        if(documentSnapshot.exists()){

                                            val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                            val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                            val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                            val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                            val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                            val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                            val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));

                                            val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                            val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                            val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                            val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                            val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                            val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                            val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));

                                            lb.setText(val.getKeyFinalPuesto1());
                                            lb2.setText(val.getKeyFinalPuesto2());
                                            lb3.setText(val.getKeyFinalPuesto3());
                                            lb4.setText(val.getKeyFinalPuesto4());
                                            lb5.setText(val.getKeyFinalPuesto5());
                                            lb6.setText(val.getKeyFinalPuesto6());
                                            lb7.setText(val.getKeyFinalPuesto7());

                                            lb13.setText(val.getKeyLugarFinal1());
                                            lb14.setText(val.getKeyLugarFinal2());
                                            lb15.setText(val.getKeyLugarFinal3());
                                            lb16.setText(val.getKeyLugarFinal4());
                                            lb17.setText(val.getKeyLugarFinal5());
                                            lb18.setText(val.getKeyLugarFinal6());
                                            lb19.setText(val.getKeyLugarFinal7());

                                            lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);
                                            lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                            lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                            lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);
                                            lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);
                                            lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                        }
                                    }});


                            }else{
                                if(val.getKeyJ1()==6){


                                    if(val.getKeyRutaDungeon1().equals("tablaUp0lose")){
                                        val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                                        val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                                        val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                                        val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                                        val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                                        val.setKeyEstado6(documentSnapshot.getString("puestoN6"));

                                    } else{
                                    val.setKeyEstado1(documentSnapshot.getString("puesto1"));
                                    val.setKeyEstado2(documentSnapshot.getString("puesto2"));
                                    val.setKeyEstado3(documentSnapshot.getString("puesto3"));
                                    val.setKeyEstado4(documentSnapshot.getString("puesto4"));
                                    val.setKeyEstado5(documentSnapshot.getString("puesto5"));
                                    val.setKeyEstado6(documentSnapshot.getString("puesto6"));}


                                    val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                                    val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                                    val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                                    val.setKeyParticipante4(documentSnapshot.getString("participante4"));
                                    val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                    val.setKeyParticipante6(documentSnapshot.getString("participante6"));


                                    l1.setText(val.getKeyEstado1());l5.setText(val.getKeyEstado5());
                                    l2.setText(val.getKeyEstado2());l6.setText(val.getKeyEstado6());
                                    l3.setText(val.getKeyEstado3());
                                    l4.setText(val.getKeyEstado4());

                                    l1.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);
                                    l2.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);
                                    l3.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);

                                    val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                    val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                    val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                    val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                    val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                    val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));

                                    la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                    la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                    la3.setText(val.getKeyPuntosV4_3());
                                    la4.setText(val.getKeyPuntosV4_4());

                                    la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);
                                    la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);
                                    la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                    bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio())
                                            .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                                            if(documentSnapshot.exists()){

                                                val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));

                                                val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));

                                                lb.setText(val.getKeyFinalPuesto1());
                                                lb1.setText(val.getKeyFinalPuesto2());
                                                lb2.setText(val.getKeyFinalPuesto3());
                                                lb3.setText(val.getKeyFinalPuesto4());
                                                lb4.setText(val.getKeyFinalPuesto5());
                                                lb5.setText(val.getKeyFinalPuesto6());
                                                lb6.setText(val.getKeyFinalPuesto7());

                                                lb13.setText(val.getKeyLugarFinal1());
                                                lb14.setText(val.getKeyLugarFinal2());
                                                lb15.setText(val.getKeyLugarFinal3());
                                                lb16.setText(val.getKeyLugarFinal4());
                                                lb17.setText(val.getKeyLugarFinal5());
                                                lb18.setText(val.getKeyLugarFinal6());
                                                lb19.setText(val.getKeyLugarFinal7());

                                                lb.setVisibility(View.VISIBLE);lb3.setVisibility(View.VISIBLE);
                                                lb1.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);
                                                lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);
                                                lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);
                                                lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);
                                                lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                            }
                                        }});


                                }else{
                                    if(val.getKeyJ1()==7){


                                        if(val.getKeyRutaDungeon1().equals("tablaUp0lose")){
                                            val.setKeyParticipante1(documentSnapshot.getString("puestoN1"));
                                            val.setKeyParticipante2(documentSnapshot.getString("puestoN2"));
                                            val.setKeyParticipante3(documentSnapshot.getString("puestoN3"));
                                            val.setKeyParticipante4(documentSnapshot.getString("puestoN4"));
                                            val.setKeyParticipante5(documentSnapshot.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("puestoN7"));

                                        } else{
                                        val.setKeyParticipante1(documentSnapshot.getString("puesto1"));
                                        val.setKeyParticipante2(documentSnapshot.getString("puesto2"));
                                        val.setKeyParticipante3(documentSnapshot.getString("puesto3"));
                                        val.setKeyParticipante4(documentSnapshot.getString("puesto4"));
                                        val.setKeyParticipante5(documentSnapshot.getString("puesto5"));
                                        val.setKeyParticipante6(documentSnapshot.getString("puesto6"));
                                        val.setKeyParticipante7(documentSnapshot.getString("puesto7"));}

                                        l1.setText(val.getKeyParticipante1());l5.setText(val.getKeyParticipante5());
                                        l2.setText(val.getKeyParticipante2());l6.setText(val.getKeyParticipante6());
                                        l3.setText(val.getKeyParticipante3());l7.setText(val.getKeyParticipante7());
                                        l4.setText(val.getKeyParticipante4());l8.setText(val.getKeyParticipante8());

                                        l1.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);
                                        l2.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);l8.setVisibility(View.VISIBLE);
                                        l3.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);l7.setVisibility(View.VISIBLE);

                                        val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                        val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                        val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                        val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                        val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                        val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                        val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));


                                        la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                        la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                        la3.setText(val.getKeyPuntosV4_3());la7.setText(val.getKeyPuntosV4_7());
                                        la4.setText(val.getKeyPuntosV4_4());

                                        la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);la7.setVisibility(View.VISIBLE);
                                        la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);
                                        la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                        bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio())
                                                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                if(documentSnapshot.exists()){

                                                    val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                    val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                    val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                    val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                    val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                    val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                    val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));
                                                    val.setKeyFinalPuesto8(documentSnapshot.getString("8Puesto"));

                                                    val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                    val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                    val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                    val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                    val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                    val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                    val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));
                                                    val.setKeyLugarFinal8(documentSnapshot.getString("LugarN8"));

                                                    lb.setText(val.getKeyFinalPuesto1());
                                                    lb1.setText(val.getKeyFinalPuesto2());
                                                    lb2.setText(val.getKeyFinalPuesto3());
                                                    lb3.setText(val.getKeyFinalPuesto4());
                                                    lb4.setText(val.getKeyFinalPuesto5());
                                                    lb5.setText(val.getKeyFinalPuesto6());
                                                    lb6.setText(val.getKeyFinalPuesto7());



                                                    lb13.setText(val.getKeyLugarFinal1());
                                                    lb14.setText(val.getKeyLugarFinal2());
                                                    lb15.setText(val.getKeyLugarFinal3());
                                                    lb16.setText(val.getKeyLugarFinal4());
                                                    lb17.setText(val.getKeyLugarFinal5());
                                                    lb18.setText(val.getKeyLugarFinal6());
                                                    lb19.setText(val.getKeyLugarFinal7());


                                                    lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);lb1.setVisibility(View.VISIBLE);
                                                    lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                                    lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);
                                                    lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);
                                                    lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);lb9.setVisibility(View.VISIBLE);
                                                    lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);

                                                }
                                            }});

                                    }else{
                                        if(val.getKeyJ1()==8){
                                            val.setKeyParticipante1(documentSnapshot.getString("puesto1"));
                                            val.setKeyParticipante2(documentSnapshot.getString("puesto2"));
                                            val.setKeyParticipante3(documentSnapshot.getString("puesto3"));
                                            val.setKeyParticipante4(documentSnapshot.getString("puesto4"));
                                            val.setKeyParticipante5(documentSnapshot.getString("puesto5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("puesto6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("puesto7"));
                                            val.setKeyParticipante8(documentSnapshot.getString("puesto8"));

                                            l1.setText(val.getKeyParticipante1());l5.setText(val.getKeyParticipante5());
                                            l2.setText(val.getKeyParticipante2());l6.setText(val.getKeyParticipante6());
                                            l3.setText(val.getKeyParticipante3());l7.setText(val.getKeyParticipante7());
                                            l4.setText(val.getKeyParticipante4());l8.setText(val.getKeyParticipante8());

                                            l1.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);
                                            l2.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);l8.setVisibility(View.VISIBLE);
                                            l3.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);l7.setVisibility(View.VISIBLE);

                                            val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                            val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                            val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                            val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                            val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                            val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                            val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                                            val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));
                                            Toast.makeText(context1.getApplicationContext(), "PUNTO: " + val.getKeyPuntosV4_1(), Toast.LENGTH_SHORT).show();

                                            idV1.add(val.getKeyPuntosV4_1());
                                            idV1.add(val.getKeyPuntosV4_2());
                                            idV1.add(val.getKeyPuntosV4_3());
                                            idV1.add(val.getKeyPuntosV4_4());
                                            idV1.add(val.getKeyPuntosV4_5());
                                            idV1.add(val.getKeyPuntosV4_6());
                                            idV1.add(val.getKeyPuntosV4_7());
                                            idV1.add(val.getKeyPuntosV4_8());

                                            la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                            la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                            la3.setText(val.getKeyPuntosV4_3());la7.setText(val.getKeyPuntosV4_7());
                                            la4.setText(val.getKeyPuntosV4_4());la8.setText(val.getKeyPuntosV4_8());

                                            la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);la7.setVisibility(View.VISIBLE);
                                            la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);la8.setVisibility(View.VISIBLE);
                                            la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                            bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio())
                                                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                @Override
                                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                    if(documentSnapshot.exists()){

                                                        val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                        val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                        val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                        val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                        val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                        val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                        val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));
                                                        val.setKeyFinalPuesto8(documentSnapshot.getString("8Puesto"));
                                                        val.setKeyFinalPuesto9(documentSnapshot.getString("9Puesto"));

                                                        val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                        val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                        val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                        val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                        val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                        val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                        val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));
                                                        val.setKeyLugarFinal8(documentSnapshot.getString("LugarN8"));
                                                        val.setKeyLugarFinal9(documentSnapshot.getString("LugarN9"));

                                                        lb.setText(val.getKeyFinalPuesto1());
                                                        lb1.setText(val.getKeyFinalPuesto2());
                                                        lb2.setText(val.getKeyFinalPuesto3());
                                                        lb3.setText(val.getKeyFinalPuesto4());
                                                        lb4.setText(val.getKeyFinalPuesto5());
                                                        lb5.setText(val.getKeyFinalPuesto6());
                                                        lb6.setText(val.getKeyFinalPuesto7());
                                                        lb7.setText(val.getKeyFinalPuesto8());
                                                        lb8.setText(val.getKeyFinalPuesto9());

                                                        lb13.setText(val.getKeyLugarFinal1());
                                                        lb14.setText(val.getKeyLugarFinal2());
                                                        lb15.setText(val.getKeyLugarFinal3());
                                                        lb16.setText(val.getKeyLugarFinal4());
                                                        lb17.setText(val.getKeyLugarFinal5());
                                                        lb18.setText(val.getKeyLugarFinal6());
                                                        lb19.setText(val.getKeyLugarFinal7());
                                                        lb20.setText(val.getKeyLugarFinal8());
                                                        lb21.setText(val.getKeyLugarFinal9());

                                                        lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);lb1.setVisibility(View.VISIBLE);
                                                        lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                                        lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                                        lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);lb8.setVisibility(View.VISIBLE);
                                                        lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);lb9.setVisibility(View.VISIBLE);
                                                        lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                                        lb20.setVisibility(View.VISIBLE); lb21.setVisibility(View.VISIBLE);
                                                    }
                                                }});

                                        }else{
                                            if(val.getKeyJ1()==11){
                                                val.setKeyParticipante1(documentSnapshot.getString("puesto1"));
                                                val.setKeyParticipante2(documentSnapshot.getString("puesto2"));
                                                val.setKeyParticipante3(documentSnapshot.getString("puesto3"));
                                                val.setKeyParticipante4(documentSnapshot.getString("puesto4"));
                                                val.setKeyParticipante5(documentSnapshot.getString("puesto5"));
                                                val.setKeyParticipante6(documentSnapshot.getString("puesto6"));
                                                val.setKeyParticipante7(documentSnapshot.getString("puesto7"));
                                                val.setKeyParticipante8(documentSnapshot.getString("puesto8"));
                                                val.setKeyParticipante9(documentSnapshot.getString("puesto9"));
                                                val.setKeyParticipante10(documentSnapshot.getString("puesto10"));
                                                val.setKeyParticipante11(documentSnapshot.getString("puesto11"));

                                                l1.setText(val.getKeyParticipante1());l5.setText(val.getKeyParticipante5());
                                                l2.setText(val.getKeyParticipante2());l6.setText(val.getKeyParticipante6());
                                                l3.setText(val.getKeyParticipante3());l7.setText(val.getKeyParticipante7());
                                                l4.setText(val.getKeyParticipante4());l8.setText(val.getKeyParticipante8());

                                                l9.setText(val.getKeyParticipante9());l11.setText(val.getKeyParticipante11());
                                                l10.setText(val.getKeyParticipante10());

                                                l1.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);
                                                l2.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);l8.setVisibility(View.VISIBLE);
                                                l3.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);l7.setVisibility(View.VISIBLE);

                                                l9.setVisibility(View.VISIBLE);l11.setVisibility(View.VISIBLE);
                                                l10.setVisibility(View.VISIBLE);


                                                val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                                val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                                val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                                val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                                val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                                val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                                val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                                                val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));
                                                val.setKeyPuntosV4_9(documentSnapshot.getString("lvl9"));
                                                val.setKeyPuntosV4_10(documentSnapshot.getString("lvl10"));
                                                val.setKeyPuntosV4_11(documentSnapshot.getString("lvl11"));
                                                                                           la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                                la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                                la3.setText(val.getKeyPuntosV4_3());la7.setText(val.getKeyPuntosV4_7());
                                                la4.setText(val.getKeyPuntosV4_4());la8.setText(val.getKeyPuntosV4_8());

                                                la9.setText(val.getKeyPuntosV4_9());
                                                la10.setText(val.getKeyPuntosV4_10());la11.setText(val.getKeyPuntosV4_11());

                                                la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);la7.setVisibility(View.VISIBLE);
                                                la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);la8.setVisibility(View.VISIBLE);
                                                la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                                la9.setVisibility(View.VISIBLE);la11.setVisibility(View.VISIBLE);
                                                la10.setVisibility(View.VISIBLE);

                                                bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeySalaActiva())
                                                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                        if(documentSnapshot.exists()){

                                                            val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                            val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                            val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                            val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                            val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                            val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                            val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));
                                                            val.setKeyFinalPuesto8(documentSnapshot.getString("8Puesto"));
                                                            val.setKeyFinalPuesto9(documentSnapshot.getString("9Puesto"));
                                                            val.setKeyFinalPuesto10(documentSnapshot.getString("10Puesto"));
                                                            val.setKeyFinalPuesto11(documentSnapshot.getString("11Puesto"));

                                                            val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                            val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                            val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                            val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                            val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                            val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                            val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));
                                                            val.setKeyLugarFinal8(documentSnapshot.getString("LugarN8"));
                                                            val.setKeyLugarFinal9(documentSnapshot.getString("LugarN9"));
                                                            val.setKeyLugarFinal10(documentSnapshot.getString("LugarN10"));
                                                            val.setKeyLugarFinal11(documentSnapshot.getString("LugarN11"));

                                                            lb.setText(val.getKeyFinalPuesto1());
                                                            lb1.setText(val.getKeyFinalPuesto2());
                                                            lb2.setText(val.getKeyFinalPuesto3());
                                                            lb3.setText(val.getKeyFinalPuesto4());
                                                            lb4.setText(val.getKeyFinalPuesto5());
                                                            lb5.setText(val.getKeyFinalPuesto6());
                                                            lb6.setText(val.getKeyFinalPuesto7());
                                                            lb7.setText(val.getKeyFinalPuesto8());
                                                            lb8.setText(val.getKeyFinalPuesto9());
                                                            lb9.setText(val.getKeyFinalPuesto10());
                                                            lb10.setText(val.getKeyFinalPuesto11());

            if(val.getKeyLugarFinal1().equals("esperando")){
                lb13.setText("0");
                lb14.setText("0");
                lb15.setText("0");
                lb16.setText("0");
                lb17.setText("0");
                lb18.setText("0");
                lb19.setText("0");
                lb20.setText("0");
                lb21.setText("0");
                lb22.setText("0");
                lb23.setText("0");

            }else{
                lb13.setText(val.getKeyLugarFinal1());
                lb14.setText(val.getKeyLugarFinal2());
                lb15.setText(val.getKeyLugarFinal3());
                lb16.setText(val.getKeyLugarFinal4());
                lb17.setText(val.getKeyLugarFinal5());
                lb18.setText(val.getKeyLugarFinal6());
                lb19.setText(val.getKeyLugarFinal7());
                lb20.setText(val.getKeyLugarFinal8());
                lb21.setText(val.getKeyLugarFinal9());
                lb22.setText(val.getKeyLugarFinal10());
                lb23.setText(val.getKeyLugarFinal11());
            }








                                                            lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);lb1.setVisibility(View.VISIBLE);
                                                            lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                                            lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                                            lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);lb8.setVisibility(View.VISIBLE);
                                                            lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);lb9.setVisibility(View.VISIBLE);
                                                            lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                                            lb20.setVisibility(View.VISIBLE); lb21.setVisibility(View.VISIBLE);lb10.setVisibility(View.VISIBLE);
                                                            lb22.setVisibility(View.VISIBLE); lb23.setVisibility(View.VISIBLE);
                                                        }
                                                    }});

                                            }else{
                                                if(val.getKeyJ1()==10){
                                                    val.setKeyParticipante1(documentSnapshot.getString("puesto1"));
                                                    val.setKeyParticipante2(documentSnapshot.getString("puesto2"));
                                                    val.setKeyParticipante3(documentSnapshot.getString("puesto3"));
                                                    val.setKeyParticipante4(documentSnapshot.getString("puesto4"));
                                                    val.setKeyParticipante5(documentSnapshot.getString("puesto5"));
                                                    val.setKeyParticipante6(documentSnapshot.getString("puesto6"));
                                                    val.setKeyParticipante7(documentSnapshot.getString("puesto7"));
                                                    val.setKeyParticipante8(documentSnapshot.getString("puesto8"));
                                                    val.setKeyParticipante9(documentSnapshot.getString("puesto9"));
                                                    val.setKeyParticipante10(documentSnapshot.getString("puesto10"));
                                                    val.setKeyParticipante11(documentSnapshot.getString("puesto11"));

                                                    l1.setText(val.getKeyParticipante1());l5.setText(val.getKeyParticipante5());
                                                    l2.setText(val.getKeyParticipante2());l6.setText(val.getKeyParticipante6());
                                                    l3.setText(val.getKeyParticipante3());l7.setText(val.getKeyParticipante7());
                                                    l4.setText(val.getKeyParticipante4());l8.setText(val.getKeyParticipante8());

                                                    l9.setText(val.getKeyParticipante9());l11.setText(val.getKeyParticipante11());
                                                    l10.setText(val.getKeyParticipante10());

                                                    l1.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);
                                                    l2.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);l8.setVisibility(View.VISIBLE);
                                                    l3.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);l7.setVisibility(View.VISIBLE);

                                                    l9.setVisibility(View.VISIBLE);l11.setVisibility(View.VISIBLE);
                                                    l10.setVisibility(View.VISIBLE);


                                                    val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                                    val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                                    val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                                    val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                                    val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                                    val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                                    val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                                                    val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));
                                                    val.setKeyPuntosV4_9(documentSnapshot.getString("lvl9"));
                                                    val.setKeyPuntosV4_10(documentSnapshot.getString("lvl10"));
                                                    val.setKeyPuntosV4_11(documentSnapshot.getString("lvl11"));

                                                    la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                                    la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                                    la3.setText(val.getKeyPuntosV4_3());la7.setText(val.getKeyPuntosV4_7());
                                                    la4.setText(val.getKeyPuntosV4_4());la8.setText(val.getKeyPuntosV4_8());

                                                    la9.setText(val.getKeyPuntosV4_9());
                                                    la10.setText(val.getKeyPuntosV4_10());la11.setText(val.getKeyPuntosV4_11());

                                                    la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);la7.setVisibility(View.VISIBLE);
                                                    la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);la8.setVisibility(View.VISIBLE);
                                                    la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                                    la9.setVisibility(View.VISIBLE);la11.setVisibility(View.VISIBLE);
                                                    la10.setVisibility(View.VISIBLE);

                                                    bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeySalaActiva())
                                                            .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                        @Override
                                                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                            if(documentSnapshot.exists()){

                                                                val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                                val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                                val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                                val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                                val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                                val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                                val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));
                                                                val.setKeyFinalPuesto8(documentSnapshot.getString("8Puesto"));
                                                                val.setKeyFinalPuesto9(documentSnapshot.getString("9Puesto"));
                                                                val.setKeyFinalPuesto10(documentSnapshot.getString("10Puesto"));
                                                                val.setKeyFinalPuesto11(documentSnapshot.getString("11Puesto"));

                                                                val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                                val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                                val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                                val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                                val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                                val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                                val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));
                                                                val.setKeyLugarFinal8(documentSnapshot.getString("LugarN8"));
                                                                val.setKeyLugarFinal9(documentSnapshot.getString("LugarN9"));
                                                                val.setKeyLugarFinal10(documentSnapshot.getString("LugarN10"));
                                                                val.setKeyLugarFinal11(documentSnapshot.getString("LugarN11"));

                                                                lb.setText(val.getKeyFinalPuesto1());
                                                                lb1.setText(val.getKeyFinalPuesto2());
                                                                lb2.setText(val.getKeyFinalPuesto3());
                                                                lb3.setText(val.getKeyFinalPuesto4());
                                                                lb4.setText(val.getKeyFinalPuesto5());
                                                                lb5.setText(val.getKeyFinalPuesto6());
                                                                lb6.setText(val.getKeyFinalPuesto7());
                                                                lb7.setText(val.getKeyFinalPuesto8());
                                                                lb8.setText(val.getKeyFinalPuesto9());
                                                                lb9.setText(val.getKeyFinalPuesto10());
                                                                lb10.setText(val.getKeyFinalPuesto11());

                                                                if(val.getKeyLugarFinal1().equals("esperando")){
                                                                    lb13.setText("0");
                                                                    lb14.setText("0");
                                                                    lb15.setText("0");
                                                                    lb16.setText("0");
                                                                    lb17.setText("0");
                                                                    lb18.setText("0");
                                                                    lb19.setText("0");
                                                                    lb20.setText("0");
                                                                    lb21.setText("0");
                                                                    lb22.setText("0");
                                                                    lb23.setText("0");

                                                                }else{
                                                                    lb13.setText(val.getKeyLugarFinal1());
                                                                    lb14.setText(val.getKeyLugarFinal2());
                                                                    lb15.setText(val.getKeyLugarFinal3());
                                                                    lb16.setText(val.getKeyLugarFinal4());
                                                                    lb17.setText(val.getKeyLugarFinal5());
                                                                    lb18.setText(val.getKeyLugarFinal6());
                                                                    lb19.setText(val.getKeyLugarFinal7());
                                                                    lb20.setText(val.getKeyLugarFinal8());
                                                                    lb21.setText(val.getKeyLugarFinal9());
                                                                    lb22.setText(val.getKeyLugarFinal10());
                                                                    lb23.setText(val.getKeyLugarFinal11());
                                                                }








                                                                lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);lb1.setVisibility(View.VISIBLE);
                                                                lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                                                lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                                                lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);lb8.setVisibility(View.VISIBLE);
                                                                lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);lb9.setVisibility(View.VISIBLE);
                                                                lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                                                lb20.setVisibility(View.VISIBLE); lb21.setVisibility(View.VISIBLE);lb10.setVisibility(View.VISIBLE);
                                                                lb22.setVisibility(View.VISIBLE); lb23.setVisibility(View.VISIBLE);
                                                            }
                                                        }});

                                                }else{
                                                    if(val.getKeyJ1()==9){
                                                        val.setKeyParticipante1(documentSnapshot.getString("puesto1"));
                                                        val.setKeyParticipante2(documentSnapshot.getString("puesto2"));
                                                        val.setKeyParticipante3(documentSnapshot.getString("puesto3"));
                                                        val.setKeyParticipante4(documentSnapshot.getString("puesto4"));
                                                        val.setKeyParticipante5(documentSnapshot.getString("puesto5"));
                                                        val.setKeyParticipante6(documentSnapshot.getString("puesto6"));
                                                        val.setKeyParticipante7(documentSnapshot.getString("puesto7"));
                                                        val.setKeyParticipante8(documentSnapshot.getString("puesto8"));
                                                        val.setKeyParticipante9(documentSnapshot.getString("puesto9"));
                                                        val.setKeyParticipante10(documentSnapshot.getString("puesto10"));
                                                        val.setKeyParticipante11(documentSnapshot.getString("puesto11"));

                                                        l1.setText(val.getKeyParticipante1());l5.setText(val.getKeyParticipante5());
                                                        l2.setText(val.getKeyParticipante2());l6.setText(val.getKeyParticipante6());
                                                        l3.setText(val.getKeyParticipante3());l7.setText(val.getKeyParticipante7());
                                                        l4.setText(val.getKeyParticipante4());l8.setText(val.getKeyParticipante8());

                                                        l9.setText(val.getKeyParticipante9());l11.setText(val.getKeyParticipante11());
                                                        l10.setText(val.getKeyParticipante10());

                                                        l1.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);
                                                        l2.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);l8.setVisibility(View.VISIBLE);
                                                        l3.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);l7.setVisibility(View.VISIBLE);

                                                        l9.setVisibility(View.VISIBLE);l11.setVisibility(View.VISIBLE);
                                                        l10.setVisibility(View.VISIBLE);


                                                        val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                                        val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                                        val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                                        val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                                        val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                                        val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                                        val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                                                        val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));
                                                        val.setKeyPuntosV4_9(documentSnapshot.getString("lvl9"));
                                                        val.setKeyPuntosV4_10(documentSnapshot.getString("lvl10"));
                                                        val.setKeyPuntosV4_11(documentSnapshot.getString("lvl11"));

                                                        la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                                        la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                                        la3.setText(val.getKeyPuntosV4_3());la7.setText(val.getKeyPuntosV4_7());
                                                        la4.setText(val.getKeyPuntosV4_4());la8.setText(val.getKeyPuntosV4_8());

                                                        la9.setText(val.getKeyPuntosV4_9());
                                                        la10.setText(val.getKeyPuntosV4_10());la11.setText(val.getKeyPuntosV4_11());

                                                        la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);la7.setVisibility(View.VISIBLE);
                                                        la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);la8.setVisibility(View.VISIBLE);
                                                        la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                                        la9.setVisibility(View.VISIBLE);la11.setVisibility(View.VISIBLE);
                                                        la10.setVisibility(View.VISIBLE);

                                                        bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeySalaActiva())
                                                                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                            @Override
                                                            public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                                if(documentSnapshot.exists()){

                                                                    val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                                    val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                                    val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                                    val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                                    val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                                    val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                                    val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));
                                                                    val.setKeyFinalPuesto8(documentSnapshot.getString("8Puesto"));
                                                                    val.setKeyFinalPuesto9(documentSnapshot.getString("9Puesto"));
                                                                    val.setKeyFinalPuesto10(documentSnapshot.getString("10Puesto"));
                                                                    val.setKeyFinalPuesto11(documentSnapshot.getString("11Puesto"));

                                                                    val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                                    val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                                    val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                                    val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                                    val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                                    val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                                    val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));
                                                                    val.setKeyLugarFinal8(documentSnapshot.getString("LugarN8"));
                                                                    val.setKeyLugarFinal9(documentSnapshot.getString("LugarN9"));
                                                                    val.setKeyLugarFinal10(documentSnapshot.getString("LugarN10"));
                                                                    val.setKeyLugarFinal11(documentSnapshot.getString("LugarN11"));

                                                                    lb.setText(val.getKeyFinalPuesto1());
                                                                    lb1.setText(val.getKeyFinalPuesto2());
                                                                    lb2.setText(val.getKeyFinalPuesto3());
                                                                    lb3.setText(val.getKeyFinalPuesto4());
                                                                    lb4.setText(val.getKeyFinalPuesto5());
                                                                    lb5.setText(val.getKeyFinalPuesto6());
                                                                    lb6.setText(val.getKeyFinalPuesto7());
                                                                    lb7.setText(val.getKeyFinalPuesto8());
                                                                    lb8.setText(val.getKeyFinalPuesto9());
                                                                    lb9.setText(val.getKeyFinalPuesto10());
                                                                    lb10.setText(val.getKeyFinalPuesto11());

                                                                    if(val.getKeyLugarFinal1().equals("esperando")){
                                                                        lb13.setText("0");
                                                                        lb14.setText("0");
                                                                        lb15.setText("0");
                                                                        lb16.setText("0");
                                                                        lb17.setText("0");
                                                                        lb18.setText("0");
                                                                        lb19.setText("0");
                                                                        lb20.setText("0");
                                                                        lb21.setText("0");
                                                                        lb22.setText("0");
                                                                        lb23.setText("0");

                                                                    }else{
                                                                        lb13.setText(val.getKeyLugarFinal1());
                                                                        lb14.setText(val.getKeyLugarFinal2());
                                                                        lb15.setText(val.getKeyLugarFinal3());
                                                                        lb16.setText(val.getKeyLugarFinal4());
                                                                        lb17.setText(val.getKeyLugarFinal5());
                                                                        lb18.setText(val.getKeyLugarFinal6());
                                                                        lb19.setText(val.getKeyLugarFinal7());
                                                                        lb20.setText(val.getKeyLugarFinal8());
                                                                        lb21.setText(val.getKeyLugarFinal9());
                                                                        lb22.setText(val.getKeyLugarFinal10());
                                                                        lb23.setText(val.getKeyLugarFinal11());
                                                                    }








                                                                    lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);lb1.setVisibility(View.VISIBLE);
                                                                    lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                                                    lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                                                    lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);lb8.setVisibility(View.VISIBLE);
                                                                    lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);lb9.setVisibility(View.VISIBLE);
                                                                    lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                                                    lb20.setVisibility(View.VISIBLE); lb21.setVisibility(View.VISIBLE);lb10.setVisibility(View.VISIBLE);
                                                                    lb22.setVisibility(View.VISIBLE); lb23.setVisibility(View.VISIBLE);
                                                                }
                                                            }});

                                                    }else{
                                                        if(val.getKeyJ1()==12){
                                                            val.setKeyParticipante1(documentSnapshot.getString("puesto1"));
                                                            val.setKeyParticipante2(documentSnapshot.getString("puesto2"));
                                                            val.setKeyParticipante3(documentSnapshot.getString("puesto3"));
                                                            val.setKeyParticipante4(documentSnapshot.getString("puesto4"));
                                                            val.setKeyParticipante5(documentSnapshot.getString("puesto5"));
                                                            val.setKeyParticipante6(documentSnapshot.getString("puesto6"));
                                                            val.setKeyParticipante7(documentSnapshot.getString("puesto7"));
                                                            val.setKeyParticipante8(documentSnapshot.getString("puesto8"));
                                                            val.setKeyParticipante9(documentSnapshot.getString("puesto9"));
                                                            val.setKeyParticipante10(documentSnapshot.getString("puesto10"));
                                                            val.setKeyParticipante11(documentSnapshot.getString("puesto11"));

                                                            l1.setText(val.getKeyParticipante1());l5.setText(val.getKeyParticipante5());
                                                            l2.setText(val.getKeyParticipante2());l6.setText(val.getKeyParticipante6());
                                                            l3.setText(val.getKeyParticipante3());l7.setText(val.getKeyParticipante7());
                                                            l4.setText(val.getKeyParticipante4());l8.setText(val.getKeyParticipante8());

                                                            l9.setText(val.getKeyParticipante9());l11.setText(val.getKeyParticipante11());
                                                            l10.setText(val.getKeyParticipante10());

                                                            l1.setVisibility(View.VISIBLE);l4.setVisibility(View.VISIBLE);
                                                            l2.setVisibility(View.VISIBLE);l5.setVisibility(View.VISIBLE);l8.setVisibility(View.VISIBLE);
                                                            l3.setVisibility(View.VISIBLE);l6.setVisibility(View.VISIBLE);l7.setVisibility(View.VISIBLE);

                                                            l9.setVisibility(View.VISIBLE);l11.setVisibility(View.VISIBLE);
                                                            l10.setVisibility(View.VISIBLE);


                                                            val.setKeyPuntosV4_1(documentSnapshot.getString("lvl1"));
                                                            val.setKeyPuntosV4_2(documentSnapshot.getString("lvl2"));
                                                            val.setKeyPuntosV4_3(documentSnapshot.getString("lvl3"));
                                                            val.setKeyPuntosV4_4(documentSnapshot.getString("lvl4"));
                                                            val.setKeyPuntosV4_5(documentSnapshot.getString("lvl5"));
                                                            val.setKeyPuntosV4_6(documentSnapshot.getString("lvl6"));
                                                            val.setKeyPuntosV4_7(documentSnapshot.getString("lvl7"));
                                                            val.setKeyPuntosV4_8(documentSnapshot.getString("lvl8"));
                                                            val.setKeyPuntosV4_9(documentSnapshot.getString("lvl9"));
                                                            val.setKeyPuntosV4_10(documentSnapshot.getString("lvl10"));
                                                            val.setKeyPuntosV4_11(documentSnapshot.getString("lvl11"));

                                                            la.setText(val.getKeyPuntosV4_1());la5.setText(val.getKeyPuntosV4_5());
                                                            la2.setText(val.getKeyPuntosV4_2());la6.setText(val.getKeyPuntosV4_6());
                                                            la3.setText(val.getKeyPuntosV4_3());la7.setText(val.getKeyPuntosV4_7());
                                                            la4.setText(val.getKeyPuntosV4_4());la8.setText(val.getKeyPuntosV4_8());

                                                            la9.setText(val.getKeyPuntosV4_9());
                                                            la10.setText(val.getKeyPuntosV4_10());la11.setText(val.getKeyPuntosV4_11());

                                                            la.setVisibility(View.VISIBLE);la4.setVisibility(View.VISIBLE);la7.setVisibility(View.VISIBLE);
                                                            la2.setVisibility(View.VISIBLE);la5.setVisibility(View.VISIBLE);la8.setVisibility(View.VISIBLE);
                                                            la3.setVisibility(View.VISIBLE);la6.setVisibility(View.VISIBLE);

                                                            la9.setVisibility(View.VISIBLE);la11.setVisibility(View.VISIBLE);
                                                            la10.setVisibility(View.VISIBLE);

                                                            bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeySalaActiva())
                                                                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                                @Override
                                                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                                    if(documentSnapshot.exists()){

                                                                        val.setKeyFinalPuesto1(documentSnapshot.getString("1Puesto"));
                                                                        val.setKeyFinalPuesto2(documentSnapshot.getString("2Puesto"));
                                                                        val.setKeyFinalPuesto3(documentSnapshot.getString("3Puesto"));
                                                                        val.setKeyFinalPuesto4(documentSnapshot.getString("4Puesto"));
                                                                        val.setKeyFinalPuesto5(documentSnapshot.getString("5Puesto"));
                                                                        val.setKeyFinalPuesto6(documentSnapshot.getString("6Puesto"));
                                                                        val.setKeyFinalPuesto7(documentSnapshot.getString("7Puesto"));
                                                                        val.setKeyFinalPuesto8(documentSnapshot.getString("8Puesto"));
                                                                        val.setKeyFinalPuesto9(documentSnapshot.getString("9Puesto"));
                                                                        val.setKeyFinalPuesto10(documentSnapshot.getString("10Puesto"));
                                                                        val.setKeyFinalPuesto11(documentSnapshot.getString("11Puesto"));

                                                                        val.setKeyLugarFinal1(documentSnapshot.getString("LugarN1"));
                                                                        val.setKeyLugarFinal2(documentSnapshot.getString("LugarN2"));
                                                                        val.setKeyLugarFinal3(documentSnapshot.getString("LugarN3"));
                                                                        val.setKeyLugarFinal4(documentSnapshot.getString("LugarN4"));
                                                                        val.setKeyLugarFinal5(documentSnapshot.getString("LugarN5"));
                                                                        val.setKeyLugarFinal6(documentSnapshot.getString("LugarN6"));
                                                                        val.setKeyLugarFinal7(documentSnapshot.getString("LugarN7"));
                                                                        val.setKeyLugarFinal8(documentSnapshot.getString("LugarN8"));
                                                                        val.setKeyLugarFinal9(documentSnapshot.getString("LugarN9"));
                                                                        val.setKeyLugarFinal10(documentSnapshot.getString("LugarN10"));
                                                                        val.setKeyLugarFinal11(documentSnapshot.getString("LugarN11"));

                                                                        lb.setText(val.getKeyFinalPuesto1());
                                                                        lb1.setText(val.getKeyFinalPuesto2());
                                                                        lb2.setText(val.getKeyFinalPuesto3());
                                                                        lb3.setText(val.getKeyFinalPuesto4());
                                                                        lb4.setText(val.getKeyFinalPuesto5());
                                                                        lb5.setText(val.getKeyFinalPuesto6());
                                                                        lb6.setText(val.getKeyFinalPuesto7());
                                                                        lb7.setText(val.getKeyFinalPuesto8());
                                                                        lb8.setText(val.getKeyFinalPuesto9());
                                                                        lb9.setText(val.getKeyFinalPuesto10());
                                                                        lb10.setText(val.getKeyFinalPuesto11());

                                                                        if(val.getKeyLugarFinal1().equals("esperando")){
                                                                            lb13.setText("0");
                                                                            lb14.setText("0");
                                                                            lb15.setText("0");
                                                                            lb16.setText("0");
                                                                            lb17.setText("0");
                                                                            lb18.setText("0");
                                                                            lb19.setText("0");
                                                                            lb20.setText("0");
                                                                            lb21.setText("0");
                                                                            lb22.setText("0");
                                                                            lb23.setText("0");

                                                                        }else{
                                                                            lb13.setText(val.getKeyLugarFinal1());
                                                                            lb14.setText(val.getKeyLugarFinal2());
                                                                            lb15.setText(val.getKeyLugarFinal3());
                                                                            lb16.setText(val.getKeyLugarFinal4());
                                                                            lb17.setText(val.getKeyLugarFinal5());
                                                                            lb18.setText(val.getKeyLugarFinal6());
                                                                            lb19.setText(val.getKeyLugarFinal7());
                                                                            lb20.setText(val.getKeyLugarFinal8());
                                                                            lb21.setText(val.getKeyLugarFinal9());
                                                                            lb22.setText(val.getKeyLugarFinal10());
                                                                            lb23.setText(val.getKeyLugarFinal11());
                                                                        }








                                                                        lb.setVisibility(View.VISIBLE);lb4.setVisibility(View.VISIBLE);lb1.setVisibility(View.VISIBLE);
                                                                        lb2.setVisibility(View.VISIBLE);lb5.setVisibility(View.VISIBLE);
                                                                        lb3.setVisibility(View.VISIBLE);lb6.setVisibility(View.VISIBLE);lb7.setVisibility(View.VISIBLE);
                                                                        lb13.setVisibility(View.VISIBLE);lb16.setVisibility(View.VISIBLE);lb8.setVisibility(View.VISIBLE);
                                                                        lb14.setVisibility(View.VISIBLE);lb17.setVisibility(View.VISIBLE);lb9.setVisibility(View.VISIBLE);
                                                                        lb15.setVisibility(View.VISIBLE);lb18.setVisibility(View.VISIBLE);lb19.setVisibility(View.VISIBLE);
                                                                        lb20.setVisibility(View.VISIBLE); lb21.setVisibility(View.VISIBLE);lb10.setVisibility(View.VISIBLE);
                                                                        lb22.setVisibility(View.VISIBLE); lb23.setVisibility(View.VISIBLE);
                                                                    }
                                                                }});

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }




                } }});

b1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio())
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

if (documentSnapshot.exists()) {
HashMap<String, Object> dato = new HashMap<>();

val.setKeyParticipanteEspera1(documentSnapshot.getString("1Puesto"));
if(val.getKeyParticipanteEspera1().equals("esperando")){

if(val.getKeyJ1()==4) {
    dato.put("keyN", String.valueOf(val.getKeyJ1()));
    dato.put("1Puesto", val.getKeyParticipante1());
    dato.put("2Puesto", val.getKeyParticipante2());
    dato.put("3Puesto",val.getKeyParticipante3());
    dato.put("4Puesto",val.getKeyParticipante4());
    dato.put("LugarN1", val.getKeyPuntosV4_1());
    dato.put("LugarN2", val.getKeyPuntosV4_2());
    dato.put("LugarN3",val.getKeyPuntosV4_3());
    dato.put("LugarN4",val.getKeyPuntosV4_4());

    Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();

}else{
if(val.getKeyJ1()==5) {
    dato.put("keyN", String.valueOf(val.getKeyJ1()));
    dato.put("1Puesto", val.getKeyParticipante1());
    dato.put("2Puesto", val.getKeyParticipante2());
    dato.put("3Puesto",val.getKeyParticipante3());
    dato.put("4Puesto",val.getKeyParticipante4());
    dato.put("5Puesto", val.getKeyParticipante5());
    dato.put("LugarN1", val.getKeyPuntosV4_1());
    dato.put("LugarN2", val.getKeyPuntosV4_2());
    dato.put("LugarN3",val.getKeyPuntosV4_3());
    dato.put("LugarN4",val.getKeyPuntosV4_4());
    dato.put("LugarN5", val.getKeyPuntosV4_5());

    Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyJ1()==6) {
    dato.put("keyN", String.valueOf(val.getKeyJ1()));
    dato.put("1Puesto", val.getKeyParticipante1());
    dato.put("2Puesto", val.getKeyParticipante2());
    dato.put("3Puesto",val.getKeyParticipante3());
    dato.put("4Puesto",val.getKeyParticipante4());
    dato.put("5Puesto", val.getKeyParticipante5());
    dato.put("6Puesto",val.getKeyParticipante6());
    dato.put("LugarN1", val.getKeyPuntosV4_1());
    dato.put("LugarN2", val.getKeyPuntosV4_2());
    dato.put("LugarN3",val.getKeyPuntosV4_3());
    dato.put("LugarN4",val.getKeyPuntosV4_4());
    dato.put("LugarN5", val.getKeyPuntosV4_5());
    dato.put("LugarN6",val.getKeyPuntosV4_6());

    Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyJ1()==7) {
    dato.put("keyN", String.valueOf(val.getKeyJ1()));
    dato.put("1Puesto", val.getKeyParticipante1());
    dato.put("2Puesto", val.getKeyParticipante2());
    dato.put("3Puesto",val.getKeyParticipante3());
    dato.put("4Puesto",val.getKeyParticipante4());
    dato.put("5Puesto", val.getKeyParticipante5());
    dato.put("6Puesto",val.getKeyParticipante6());
    dato.put("7Puesto", val.getKeyParticipante7());
    dato.put("LugarN1", val.getKeyPuntosV4_1());
    dato.put("LugarN2", val.getKeyPuntosV4_2());
    dato.put("LugarN3",val.getKeyPuntosV4_3());
    dato.put("LugarN4",val.getKeyPuntosV4_4());
    dato.put("LugarN5", val.getKeyPuntosV4_5());
    dato.put("LugarN6",val.getKeyPuntosV4_6());
    dato.put("LugarN7", val.getKeyPuntosV4_7());

    Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyJ1()==8) {
    dato.put("keyN", String.valueOf(val.getKeyJ1()));
    dato.put("1Puesto", val.getKeyParticipante1());
    dato.put("2Puesto", val.getKeyParticipante2());
    dato.put("3Puesto",val.getKeyParticipante3());
    dato.put("4Puesto",val.getKeyParticipante4());
    dato.put("5Puesto", val.getKeyParticipante5());
    dato.put("6Puesto",val.getKeyParticipante6());
    dato.put("7Puesto", val.getKeyParticipante7());
    dato.put("8Puesto",val.getKeyParticipante8());

    dato.put("LugarN1", val.getKeyPuntosV4_1());
    dato.put("LugarN2", val.getKeyPuntosV4_2());
    dato.put("LugarN3",val.getKeyPuntosV4_3());
    dato.put("LugarN4",val.getKeyPuntosV4_4());
    dato.put("LugarN5", val.getKeyPuntosV4_5());
    dato.put("LugarN6",val.getKeyPuntosV4_6());
    dato.put("LugarN7", val.getKeyPuntosV4_7());
    dato.put("LugarN8",val.getKeyPuntosV4_8());
    Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
}else{
    if(val.getKeyJ1()==9) {
        dato.put("keyN", String.valueOf(val.getKeyJ1()));
        dato.put("1Puesto", val.getKeyParticipante1());
        dato.put("2Puesto", val.getKeyParticipante2());
        dato.put("3Puesto",val.getKeyParticipante3());
        dato.put("4Puesto",val.getKeyParticipante4());
        dato.put("5Puesto", val.getKeyParticipante5());
        dato.put("6Puesto",val.getKeyParticipante6());
        dato.put("7Puesto", val.getKeyParticipante7());
        dato.put("8Puesto",val.getKeyParticipante8());
        dato.put("9Puesto", val.getKeyParticipante9());

        dato.put("LugarN1", val.getKeyPuntosV4_1());
        dato.put("LugarN2", val.getKeyPuntosV4_2());
        dato.put("LugarN3",val.getKeyPuntosV4_3());
        dato.put("LugarN4",val.getKeyPuntosV4_4());
        dato.put("LugarN5", val.getKeyPuntosV4_5());
        dato.put("LugarN6",val.getKeyPuntosV4_6());
        dato.put("LugarN7", val.getKeyPuntosV4_7());
        dato.put("LugarN8",val.getKeyPuntosV4_8());
        dato.put("LugarN9", val.getKeyPuntosV4_9());

        Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
    }else{
        if(val.getKeyJ1()==10) {
            dato.put("keyN", String.valueOf(val.getKeyJ1()));
            dato.put("1Puesto", val.getKeyParticipante1());
            dato.put("2Puesto", val.getKeyParticipante2());
            dato.put("3Puesto",val.getKeyParticipante3());
            dato.put("4Puesto",val.getKeyParticipante4());
            dato.put("5Puesto", val.getKeyParticipante5());
            dato.put("6Puesto",val.getKeyParticipante6());
            dato.put("7Puesto", val.getKeyParticipante7());
            dato.put("8Puesto",val.getKeyParticipante8());
            dato.put("9Puesto", val.getKeyParticipante9());
            dato.put("10Puesto",val.getKeyParticipante10());

            dato.put("LugarN1", val.getKeyPuntosV4_1());
            dato.put("LugarN2", val.getKeyPuntosV4_2());
            dato.put("LugarN3",val.getKeyPuntosV4_3());
            dato.put("LugarN4",val.getKeyPuntosV4_4());
            dato.put("LugarN5", val.getKeyPuntosV4_5());
            dato.put("LugarN6",val.getKeyPuntosV4_6());
            dato.put("LugarN7", val.getKeyPuntosV4_7());
            dato.put("LugarN8",val.getKeyPuntosV4_8());
            dato.put("LugarN9", val.getKeyPuntosV4_9());
            dato.put("LugarN10",val.getKeyPuntosV4_10());
            Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
        }else{
            if(val.getKeyJ1()==11) {
                dato.put("keyN", String.valueOf(val.getKeyJ1()));
                dato.put("1Puesto", val.getKeyParticipante1());
                dato.put("2Puesto", val.getKeyParticipante2());
                dato.put("3Puesto",val.getKeyParticipante3());
                dato.put("4Puesto",val.getKeyParticipante4());
                dato.put("5Puesto", val.getKeyParticipante5());
                dato.put("6Puesto",val.getKeyParticipante6());
                dato.put("7Puesto", val.getKeyParticipante7());
                dato.put("8Puesto",val.getKeyParticipante8());
                dato.put("9Puesto", val.getKeyParticipante9());
                dato.put("10Puesto",val.getKeyParticipante10());
                dato.put("11Puesto",val.getKeyParticipante11());

                dato.put("LugarN1", val.getKeyPuntosV4_1());
                dato.put("LugarN2", val.getKeyPuntosV4_2());
                dato.put("LugarN3",val.getKeyPuntosV4_3());
                dato.put("LugarN4",val.getKeyPuntosV4_4());
                dato.put("LugarN5", val.getKeyPuntosV4_5());
                dato.put("LugarN6",val.getKeyPuntosV4_6());
                dato.put("LugarN7", val.getKeyPuntosV4_7());
                dato.put("LugarN8",val.getKeyPuntosV4_8());
                dato.put("LugarN9", val.getKeyPuntosV4_9());
                dato.put("LugarN10",val.getKeyPuntosV4_10());
                dato.put("LugarN11",val.getKeyPuntosV4_11());
                Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
            }else{
                if(val.getKeyJ1()==12) {
                    dato.put("keyN", String.valueOf(val.getKeyJ1()));
                    dato.put("1Puesto", val.getKeyParticipante1());
                    dato.put("2Puesto", val.getKeyParticipante2());
                    dato.put("3Puesto",val.getKeyParticipante3());
                    dato.put("4Puesto",val.getKeyParticipante4());
                    dato.put("5Puesto", val.getKeyParticipante5());
                    dato.put("6Puesto",val.getKeyParticipante6());
                    dato.put("7Puesto", val.getKeyParticipante7());
                    dato.put("8Puesto",val.getKeyParticipante8());
                    dato.put("9Puesto", val.getKeyParticipante9());
                    dato.put("10Puesto",val.getKeyParticipante10());
                    dato.put("11Puesto",val.getKeyParticipante11());
                    dato.put("12Puesto",val.getKeyParticipante12());

                    dato.put("LugarN1", val.getKeyPuntosV4_1());
                    dato.put("LugarN2", val.getKeyPuntosV4_2());
                    dato.put("LugarN3",val.getKeyPuntosV4_3());
                    dato.put("LugarN4",val.getKeyPuntosV4_4());
                    dato.put("LugarN5", val.getKeyPuntosV4_5());
                    dato.put("LugarN6",val.getKeyPuntosV4_6());
                    dato.put("LugarN7", val.getKeyPuntosV4_7());
                    dato.put("LugarN8",val.getKeyPuntosV4_8());
                    dato.put("LugarN9", val.getKeyPuntosV4_9());
                    dato.put("LugarN10",val.getKeyPuntosV4_10());
                    dato.put("LugarN11",val.getKeyPuntosV4_11());
                    dato.put("LugarN12",val.getKeyPuntosV4_12());
                    Toast.makeText(context1.getApplicationContext(), "ASIGNANDO PUESTOS TABLA GENERAL", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
}
}
}
}


bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio()).update(dato);
    HashMap<String, Object> dato1 = new HashMap<>();
    if(val.getKeyTorneoActivo().equals("arquetipokurivo")) {
        dato1.put("keyRegistroActivoKuribo", "registro");
        Toast.makeText(context1.getApplicationContext(), "Desactivando  Arquetipo Kuribo ... ", Toast.LENGTH_SHORT).show();

    }else{
        if(val.getKeyTorneoActivo().equals("dungeonxyz")){
            dato1.put("keyRegistroActivo", "registro");
            Toast.makeText(context1.getApplicationContext(), "Desactivando  Dungeon xyz v6 ... ", Toast.LENGTH_SHORT).show();

        }
    }
    bdNeutro.collection("BDcalabozo").document("Info").update(dato1);

    Toast.makeText(context1.getApplicationContext(), "Habilitando Pre-Registro ... ", Toast.LENGTH_SHORT).show();


}else {

      val.setKeyN(documentSnapshot.getString("keyN"));
      int contando= Integer.parseInt(val.getKeyN());
      aumentoTg= contando;

    bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1())
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot1) {

if (documentSnapshot1.exists()) {


for(int e =1; e < val.getKeyJ1(); e++){//ts  5
    val.setKeyParticipante1(documentSnapshot1.getString("puesto"+e));

    int sumae =e;
        val.setKeyPuntosV4_1(idV1.get(sumae-1));




for(int a =1; a < contando; a++){//tg  4

   val.setKeyParticipanteEspera1(documentSnapshot.getString(a+"Puesto"));
    val.setKeyPuntosEspera1(documentSnapshot.getString("LugarN"+a));




if(val.getKeyParticipante1().equals(val.getKeyParticipanteEspera1())){

  val.setKeyJ5(Integer.parseInt(val.getKeyPuntosV4_1()));
  val.setKeyJ6(Integer.parseInt(val.getKeyPuntosEspera1()));
    val.setKeyJ7(val.getKeyJ5()+val.getKeyJ6());
    val.setKeyTotalPuntoEspera1(String.valueOf(val.getKeyJ7()));
    Toast.makeText(context1.getApplicationContext(), val.getKeyJ6()+ "   --->KEYN: " + val.getKeyJ5() + "  = " + val.getKeyTotalPuntoEspera1(), Toast.LENGTH_SHORT).show();

    dato.put("LugarN"+a,val.getKeyTotalPuntoEspera1());
    bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio()).update(dato);
} else{

    if(contando == a){


        aumentoTg=+1;
        dato.put(aumentoTg+"Puesto",val.getKeyParticipante1());
        dato.put("LugarN"+aumentoTg,val.getKeyTotalPuntoEspera1());
        bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio()).update(dato);

    }


}

if(val.getKeyJ1() == e){
    dato.put("keyN", String.valueOf(aumentoTg));
    bdNeutro.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio()).update(dato);
    a=0;
    e=0;
    HashMap<String, Object> dato1 = new HashMap<>();
    if(val.getKeyTorneoActivo().equals("arquetipokurivo")) {
        dato1.put("keyRegistroActivoKuribo", "registro");
        Toast.makeText(context1.getApplicationContext(), "Desactivando  Arquetipo Kuribo ... ", Toast.LENGTH_SHORT).show();

    }else{
        if(val.getKeyTorneoActivo().equals("dungeonxyz")){
            dato1.put("keyRegistroActivo", "registro");
            Toast.makeText(context1.getApplicationContext(), "Desactivando  Dungeon xyz v6 ... ", Toast.LENGTH_SHORT).show();

        }
    }

    bdNeutro.collection("BDcalabozo").document("Info").update(dato1);
    Toast.makeText(context1.getApplicationContext(), "Habilitando Pre-Registro ... ", Toast.LENGTH_SHORT).show();

    break;
}

}
}





 }}});

}
}}});



}});


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

}
    int aumentoTg=0;



}
