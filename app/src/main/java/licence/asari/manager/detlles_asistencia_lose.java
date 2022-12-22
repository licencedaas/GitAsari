package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class detlles_asistencia_lose {

    FirebaseFirestore bdNeutro;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    int contadorParticipantes=0;


    public detlles_asistencia_lose(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_tabla_asistencia_lose);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.cerrar_lose);//asutebcua_b1
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.asutebcua_b1);//lose_politicas
        
        contexto val = new contexto();

        l1=(TextView) dialog.findViewById(R.id.detalle_lose_l1);
        l2=(TextView) dialog.findViewById(R.id.detalle_lose_l2);
        l3=(TextView) dialog.findViewById(R.id.detalle_lose_l3);
        l4=(TextView) dialog.findViewById(R.id.detalle_lose_l4);
        l5=(TextView) dialog.findViewById(R.id.detalle_lose_l5);
        l6=(TextView) dialog.findViewById(R.id.detalle_lose_l6);
        l7=(TextView) dialog.findViewById(R.id.detalle_lose_l7);
        l8=(TextView) dialog.findViewById(R.id.detalle_lose_l8);
        l9=(TextView) dialog.findViewById(R.id.detalle_lose_l9);
        l10=(TextView) dialog.findViewById(R.id.detalle_lose_l10);
        l11=(TextView) dialog.findViewById(R.id.detalle_lose_l11);
        bdNeutro = FirebaseFirestore.getInstance();
        b1.setVisibility(View.GONE);
        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b1.setVisibility(View.VISIBLE); } }catch (Exception dfs){}

        bdNeutro.collection("BDcalabozo").document("tablaPreregistroLose").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){

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

contadorParticipantes=1;


                    if(val.getKeyParticipanteLose1().equals("eperando")){
                        l1.setText("");
                    }else{ l1.setText(val.getKeyParticipanteLose1()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose2().equals("eperando")){
                        l2.setText("");
                    }else{ l2.setText(val.getKeyParticipanteLose2());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose3().equals("eperando")){
                        l3.setText("");
                    }else{ l3.setText(val.getKeyParticipanteLose3()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose4().equals("eperando")){
                        l4.setText("");
                    }else{ l4.setText(val.getKeyParticipanteLose4()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose5().equals("eperando")){
                        l5.setText("");
                    }else{ l5.setText(val.getKeyParticipanteLose5());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose6().equals("eperando")){
                        l6.setText("");
                    }else{ l6.setText(val.getKeyParticipanteLose6());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose7().equals("eperando")){
                        l7.setText("");
                    }else{ l7.setText(val.getKeyParticipanteLose7());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose8().equals("eperando")){
                        l8.setText("");
                    }else{ l8.setText(val.getKeyParticipanteLose8());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose9().equals("eperando")){
                        l9.setText("");
                    }else{ l9.setText(val.getKeyParticipanteLose9()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose10().equals("eperando")){
                        l10.setText("");
                    }else{ l10.setText(val.getKeyParticipanteLose10()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose11().equals("eperando")){
                        l11.setText("");
                    }else{ l11.setText(val.getKeyParticipanteLose11());contadorParticipantes++; }


                    contadorParticipantes = contadorParticipantes-1;

                }

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                val.setKeyJ1(Integer.parseInt(val.getKeyConteo()));
                
            if(val.getKeyJ1()==contadorParticipantes){
                Toast.makeText(context1.getApplicationContext(), "PARTICIPANTES COMPLETOS", Toast.LENGTH_SHORT).show();
            }else{
             val.setKeyJ2(contadorParticipantes - val.getKeyJ1());//diferencia

                HashMap<String, Object> dato = new HashMap<>();
                HashMap<String, Object> dato1 = new HashMap<>();   
                
             if(val.getKeyJ2()==1){
             if(val.getKeyJ1()==4){
                 
             //agregar 5   
                
                 dato.put("puestoN5",val.getKeyParticipanteLose5());
                 dato.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("puestoN5","esperando");
                 dato1.put("lvl5","0");
                 dato1.put("keyConteo","5");
             }else{
             if(val.getKeyJ1()==5){
                 //agreaga 6    

                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6","esperando");
                 dato1.put("lvl6","0");
                 dato1.put("keyConteo","6");
                 
             } else{
             if(val.getKeyJ1()==6){
                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7","esperando");
                 dato1.put("lvl7","0");
                 dato1.put("keyConteo","7");

             }else{
             if(val.getKeyJ1()==7){
                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8","esperando");
                 dato1.put("lvl8","0");
                 dato1.put("keyConteo","8");
             }else{
             if(val.getKeyJ1()==8){
                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9","esperando");
                 dato1.put("lvl9","0");
                 dato1.put("keyConteo","9");

             }else{
             if(val.getKeyJ1()==9){
                 dato.put("puestoN10",val.getKeyParticipanteLose10());
                 dato.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("puestoN10","esperando");
                 dato1.put("lvl10","0");
                 dato1.put("keyConteo","10");
             }else{
             if(val.getKeyJ1()==10){
                 dato.put("puestoN11",val.getKeyParticipanteLose11());
                 dato.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("puestoN11","esperando");
                 dato1.put("lvl11","0");
                 dato1.put("keyConteo","11");

             }else{
             if(val.getKeyJ1()==11){

                 dato.put("puestoN12",val.getKeyParticipanteLose12());
                 dato.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("puestoN12","esperando");
                 dato1.put("lvl12","0");
                 dato1.put("keyConteo","12");
             }
             }
             }
             }
             }
             }
             }
             }
                 
                 
             } else{
             if(val.getKeyJ2()==2){
             if(val.getKeyJ1()==4){

                     //agregar 5 6   

                 dato.put("puestoN5",val.getKeyParticipanteLose5());
                 dato.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("puestoN5",val.getKeyParticipanteLose5());
                 dato1.put("lvl5","0");

                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6",val.getKeyParticipanteLose6());
                 dato1.put("lvl6","0");
                 dato1.put("keyConteo","6");


             }else{
             if(val.getKeyJ1()==5){
                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6",val.getKeyParticipanteLose6());
                 dato1.put("lvl6","0");

                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");
                 dato1.put("keyConteo","7");
             }else{
             if(val.getKeyJ1()==6){

                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");

                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");
                 dato1.put("keyConteo","8");
             }else{
             if(val.getKeyJ1()==7){
                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");

                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");
                 dato1.put("keyConteo","9");
             }else{
             if(val.getKeyJ1()==8){
                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");

                 dato.put("puestoN10",val.getKeyParticipanteLose10());
                 dato.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("puestoN10",val.getKeyParticipanteLose10());
                 dato1.put("lvl10","0");
                 dato1.put("keyConteo","10");
             }else{
             if(val.getKeyJ1()==9){
                 dato.put("puestoN10",val.getKeyParticipanteLose10());
                 dato.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("puestoN10",val.getKeyParticipanteLose10());
                 dato1.put("lvl10","0");

                 dato.put("puestoN11",val.getKeyParticipanteLose11());
                 dato.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("puestoN11",val.getKeyParticipanteLose11());
                 dato1.put("lvl11","0");
                 dato1.put("keyConteo","11");
             }else{
             if(val.getKeyJ1()==10){
                 dato.put("puestoN11",val.getKeyParticipanteLose11());
                 dato.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("puestoN11",val.getKeyParticipanteLose11());
                 dato1.put("lvl11","0");

                 dato.put("puestoN12",val.getKeyParticipanteLose12());
                 dato.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("puestoN12",val.getKeyParticipanteLose12());
                 dato1.put("lvl12","0");
                 dato1.put("keyConteo","12");
             }else{
             if(val.getKeyJ1()==11){
                 dato.put("puestoN12",val.getKeyParticipanteLose12());
                 dato.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("puestoN12",val.getKeyParticipanteLose12());
                 dato1.put("lvl12","0");
                 dato1.put("keyConteo","12");
             }
             }
             }
             }
             }

             }
             }
             }
             }else{
             if(val.getKeyJ2()==3){
             if(val.getKeyJ1()==4){

                     //agregar 5 6 7   


                 dato.put("puestoN5",val.getKeyParticipanteLose5());
                 dato.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("puestoN5",val.getKeyParticipanteLose5());
                 dato1.put("lvl5","0");

                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6",val.getKeyParticipanteLose6());
                 dato1.put("lvl6","0");

                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");
                 dato1.put("keyConteo","7");


             }   else{
              if(val.getKeyJ1()==5){
                  dato.put("puestoN6",val.getKeyParticipanteLose6());
                  dato.put("participante6", val.getKeyParticipanteLose6());
                  dato1.put("participante6", val.getKeyParticipanteLose6());
                  dato1.put("puestoN6",val.getKeyParticipanteLose6());
                  dato1.put("lvl6","0");

                  dato.put("puestoN7",val.getKeyParticipanteLose7());
                  dato.put("participante7", val.getKeyParticipanteLose7());
                  dato1.put("participante7", val.getKeyParticipanteLose7());
                  dato1.put("puestoN7",val.getKeyParticipanteLose7());
                  dato1.put("lvl7","0");

                  dato.put("puestoN8",val.getKeyParticipanteLose8());
                  dato.put("participante8", val.getKeyParticipanteLose8());
                  dato1.put("participante8", val.getKeyParticipanteLose8());
                  dato1.put("puestoN8",val.getKeyParticipanteLose8());
                  dato1.put("lvl8","0");
                  dato1.put("keyConteo","8");
              }else{
              if(val.getKeyJ1()==6){
                  dato.put("puestoN7",val.getKeyParticipanteLose7());
                  dato.put("participante7", val.getKeyParticipanteLose7());
                  dato1.put("participante7", val.getKeyParticipanteLose7());
                  dato1.put("puestoN7",val.getKeyParticipanteLose7());
                  dato1.put("lvl7","0");

                  dato.put("puestoN8",val.getKeyParticipanteLose8());
                  dato.put("participante8", val.getKeyParticipanteLose8());
                  dato1.put("participante8", val.getKeyParticipanteLose8());
                  dato1.put("puestoN8",val.getKeyParticipanteLose8());
                  dato1.put("lvl8","0");

                  dato.put("puestoN9",val.getKeyParticipanteLose9());
                  dato.put("participante9", val.getKeyParticipanteLose9());
                  dato1.put("participante9", val.getKeyParticipanteLose9());
                  dato1.put("puestoN9",val.getKeyParticipanteLose9());
                  dato1.put("lvl9","0");
                  dato1.put("keyConteo","9");
              }else{
               if(val.getKeyJ1()==7){
                   dato.put("puestoN8",val.getKeyParticipanteLose8());
                   dato.put("participante8", val.getKeyParticipanteLose8());
                   dato1.put("participante8", val.getKeyParticipanteLose8());
                   dato1.put("puestoN8",val.getKeyParticipanteLose8());
                   dato1.put("lvl8","0");

                   dato.put("puestoN9",val.getKeyParticipanteLose9());
                   dato.put("participante9", val.getKeyParticipanteLose9());
                   dato1.put("participante9", val.getKeyParticipanteLose9());
                   dato1.put("puestoN9",val.getKeyParticipanteLose9());
                   dato1.put("lvl9","0");

                   dato.put("puestoN10",val.getKeyParticipanteLose10());
                   dato.put("participante10", val.getKeyParticipanteLose10());
                   dato1.put("participante10", val.getKeyParticipanteLose10());
                   dato1.put("puestoN10",val.getKeyParticipanteLose10());
                   dato1.put("lvl10","0");
                   dato1.put("keyConteo","10");
                }else{
               if(val.getKeyJ1()==8){
                   dato.put("puestoN9",val.getKeyParticipanteLose9());
                   dato.put("participante9", val.getKeyParticipanteLose9());
                   dato1.put("participante9", val.getKeyParticipanteLose9());
                   dato1.put("puestoN9",val.getKeyParticipanteLose9());
                   dato1.put("lvl9","0");

                   dato.put("puestoN10",val.getKeyParticipanteLose10());
                   dato.put("participante10", val.getKeyParticipanteLose10());
                   dato1.put("participante10", val.getKeyParticipanteLose10());
                   dato1.put("puestoN10",val.getKeyParticipanteLose10());
                   dato1.put("lvl10","0");

                   dato.put("puestoN11",val.getKeyParticipanteLose11());
                   dato.put("participante11", val.getKeyParticipanteLose11());
                   dato1.put("participante11", val.getKeyParticipanteLose11());
                   dato1.put("puestoN11",val.getKeyParticipanteLose11());
                   dato1.put("lvl11","0");
                   dato1.put("keyConteo","11");
               }else{
               if(val.getKeyJ1()==9){
                   dato.put("puestoN10",val.getKeyParticipanteLose10());
                   dato.put("participante10", val.getKeyParticipanteLose10());
                   dato1.put("participante10", val.getKeyParticipanteLose10());
                   dato1.put("puestoN10",val.getKeyParticipanteLose10());
                   dato1.put("lvl10","0");

                   dato.put("puestoN11",val.getKeyParticipanteLose11());
                   dato.put("participante11", val.getKeyParticipanteLose11());
                   dato1.put("participante11", val.getKeyParticipanteLose11());
                   dato1.put("puestoN11",val.getKeyParticipanteLose11());
                   dato1.put("lvl11","0");

                   dato.put("puestoN12",val.getKeyParticipanteLose12());
                   dato.put("participante12", val.getKeyParticipanteLose12());
                   dato1.put("participante12", val.getKeyParticipanteLose12());
                   dato1.put("puestoN12",val.getKeyParticipanteLose12());
                   dato1.put("lvl12","0");
                   dato1.put("keyConteo","12");
               }else{
               if(val.getKeyJ1()==10){
                   dato.put("puestoN11",val.getKeyParticipanteLose11());
                   dato.put("participante11", val.getKeyParticipanteLose11());
                   dato1.put("participante11", val.getKeyParticipanteLose11());
                   dato1.put("puestoN11",val.getKeyParticipanteLose11());
                   dato1.put("lvl11","0");


                   dato.put("puestoN12",val.getKeyParticipanteLose12());
                   dato.put("participante12", val.getKeyParticipanteLose12());
                   dato1.put("participante12", val.getKeyParticipanteLose12());
                   dato1.put("puestoN12",val.getKeyParticipanteLose12());
                   dato1.put("lvl12","0");
                   dato1.put("keyConteo","12");
               }else{
               if(val.getKeyJ1()==11){
                   dato.put("puestoN12",val.getKeyParticipanteLose12());
                   dato.put("participante12", val.getKeyParticipanteLose12());
                   dato1.put("participante12", val.getKeyParticipanteLose12());
                   dato1.put("puestoN12",val.getKeyParticipanteLose12());
                   dato1.put("lvl12","0");
                   dato1.put("keyConteo","12");
               }
               }
               }
               }
               }

               }
              }
             }
                 
             
             }else{
             if(val.getKeyJ2()==4){
             if(val.getKeyJ1()==4){

                     //agregar 5 6 7 8   

                 dato.put("puestoN5",val.getKeyParticipanteLose5());
                 dato.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("puestoN5",val.getKeyParticipanteLose5());
                 dato1.put("lvl5","0");

                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6",val.getKeyParticipanteLose6());
                 dato1.put("lvl6","0");
                 dato1.put("keyConteo","6");


                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");
                 dato1.put("keyConteo","7");
                 

                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");
                 dato1.put("keyConteo","8");
             }else{
             if(val.getKeyJ1()==5){

                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6",val.getKeyParticipanteLose6());
                 dato1.put("lvl6","0");

                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");

                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");

                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");
                 dato1.put("keyConteo","9");
             }else{
             if(val.getKeyJ1()==6){
                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");

                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");

                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");

                 dato.put("puestoN10",val.getKeyParticipanteLose10());
                 dato.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("puestoN10",val.getKeyParticipanteLose10());
                 dato1.put("lvl10","0");
                 dato1.put("keyConteo","10");
             }else{
             if(val.getKeyJ1()==7){
                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");

                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");

                 dato.put("puestoN10",val.getKeyParticipanteLose10());
                 dato.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("puestoN10",val.getKeyParticipanteLose10());
                 dato1.put("lvl10","0");

                 dato.put("puestoN11",val.getKeyParticipanteLose11());
                 dato.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("puestoN11",val.getKeyParticipanteLose11());
                 dato1.put("lvl11","0");
                 dato1.put("keyConteo","11");
             }else{
             if(val.getKeyJ1()==8){
                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");

                 dato.put("puestoN10",val.getKeyParticipanteLose10());
                 dato.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("participante10", val.getKeyParticipanteLose10());
                 dato1.put("puestoN10",val.getKeyParticipanteLose10());
                 dato1.put("lvl10","0");

                 dato.put("puestoN11",val.getKeyParticipanteLose11());
                 dato.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("participante11", val.getKeyParticipanteLose11());
                 dato1.put("puestoN11",val.getKeyParticipanteLose11());
                 dato1.put("lvl11","0");

                 dato.put("puestoN12",val.getKeyParticipanteLose12());
                 dato.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("participante12", val.getKeyParticipanteLose12());
                 dato1.put("puestoN12",val.getKeyParticipanteLose12());
                 dato1.put("lvl12","0");
                 dato1.put("keyConteo","12");
              }else{
              if(val.getKeyJ1()==9){
                  dato.put("puestoN10",val.getKeyParticipanteLose10());
                  dato.put("participante10", val.getKeyParticipanteLose10());
                  dato1.put("participante10", val.getKeyParticipanteLose10());
                  dato1.put("puestoN10",val.getKeyParticipanteLose10());
                  dato1.put("lvl10","0");

                  dato.put("puestoN11",val.getKeyParticipanteLose11());
                  dato.put("participante11", val.getKeyParticipanteLose11());
                  dato1.put("participante11", val.getKeyParticipanteLose11());
                  dato1.put("puestoN11",val.getKeyParticipanteLose11());
                  dato1.put("lvl11","0");

                  dato.put("puestoN12",val.getKeyParticipanteLose12());
                  dato.put("participante12", val.getKeyParticipanteLose12());
                  dato1.put("participante12", val.getKeyParticipanteLose12());
                  dato1.put("puestoN12",val.getKeyParticipanteLose12());
                  dato1.put("lvl12","0");
                  dato1.put("keyConteo","12");
              }else{
              if(val.getKeyJ1()==10){
                  dato.put("puestoN11",val.getKeyParticipanteLose11());
                  dato.put("participante11", val.getKeyParticipanteLose11());
                  dato1.put("participante11", val.getKeyParticipanteLose11());
                  dato1.put("puestoN11",val.getKeyParticipanteLose11());
                  dato1.put("lvl11","0");

                  dato.put("puestoN12",val.getKeyParticipanteLose12());
                  dato.put("participante12", val.getKeyParticipanteLose12());
                  dato1.put("participante12", val.getKeyParticipanteLose12());
                  dato1.put("puestoN12",val.getKeyParticipanteLose12());
                  dato1.put("lvl12","0");
                  dato1.put("keyConteo","12");
              }else{
              if(val.getKeyJ1()==11){
                  dato.put("puestoN12",val.getKeyParticipanteLose12());
                  dato.put("participante12", val.getKeyParticipanteLose12());
                  dato1.put("participante12", val.getKeyParticipanteLose12());
                  dato1.put("puestoN12",val.getKeyParticipanteLose12());
                  dato1.put("lvl12","0");
                  dato1.put("keyConteo","12");
              }
              }
              }
              }
              }

              }
              }
             }
                 
             }else{
             if(val.getKeyJ2()==5){
             if(val.getKeyJ1()==4){

                     //agregar 5 6 7 8 9   

                 dato.put("puestoN5",val.getKeyParticipanteLose5());
                 dato.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("participante5", val.getKeyParticipanteLose5());
                 dato1.put("puestoN5",val.getKeyParticipanteLose5());
                 dato1.put("lvl5","0");

                 dato.put("puestoN6",val.getKeyParticipanteLose6());
                 dato.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("participante6", val.getKeyParticipanteLose6());
                 dato1.put("puestoN6",val.getKeyParticipanteLose6());
                 dato1.put("lvl6","0");

                 dato.put("puestoN7",val.getKeyParticipanteLose7());
                 dato.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("participante7", val.getKeyParticipanteLose7());
                 dato1.put("puestoN7",val.getKeyParticipanteLose7());
                 dato1.put("lvl7","0");

                 dato.put("puestoN8",val.getKeyParticipanteLose8());
                 dato.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("participante8", val.getKeyParticipanteLose8());
                 dato1.put("puestoN8",val.getKeyParticipanteLose8());
                 dato1.put("lvl8","0");

                 dato.put("puestoN9",val.getKeyParticipanteLose9());
                 dato.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("participante9", val.getKeyParticipanteLose9());
                 dato1.put("puestoN9",val.getKeyParticipanteLose9());
                 dato1.put("lvl9","0");
                 dato1.put("keyConteo","9");
             }    
                 
            }else{
             if(val.getKeyJ2()==6){
            if(val.getKeyJ1()==4){

                         //agregar 5 6 7 8 9 10     
                dato.put("puestoN5",val.getKeyParticipanteLose5());
                dato.put("participante5", val.getKeyParticipanteLose5());
                dato1.put("participante5", val.getKeyParticipanteLose5());
                dato1.put("puestoN5",val.getKeyParticipanteLose5());

                dato.put("puestoN6",val.getKeyParticipanteLose6());
                dato.put("participante6", val.getKeyParticipanteLose6());
                dato1.put("participante6", val.getKeyParticipanteLose6());
                dato1.put("puestoN6",val.getKeyParticipanteLose6());
                dato1.put("lvl6","0");

                dato.put("puestoN7",val.getKeyParticipanteLose7());
                dato.put("participante7", val.getKeyParticipanteLose7());
                dato1.put("participante7", val.getKeyParticipanteLose7());
                dato1.put("puestoN7",val.getKeyParticipanteLose7());
                dato1.put("lvl7","0");
                dato1.put("keyConteo","7");

                dato.put("puestoN8",val.getKeyParticipanteLose8());
                dato.put("participante8", val.getKeyParticipanteLose8());
                dato1.put("participante8", val.getKeyParticipanteLose8());
                dato1.put("puestoN8",val.getKeyParticipanteLose8());
                dato1.put("lvl8","0");

                dato.put("puestoN9",val.getKeyParticipanteLose9());
                dato.put("participante9", val.getKeyParticipanteLose9());
                dato1.put("participante9", val.getKeyParticipanteLose9());
                dato1.put("puestoN9",val.getKeyParticipanteLose9());
                dato1.put("lvl9","0");

                dato.put("puestoN10",val.getKeyParticipanteLose10());
                dato.put("participante10", val.getKeyParticipanteLose10());
                dato1.put("participante10", val.getKeyParticipanteLose10());
                dato1.put("puestoN10",val.getKeyParticipanteLose10());
                dato1.put("lvl10","0");
                dato1.put("keyConteo","10");
                
            }

            }else{
            if(val.getKeyJ2()==7){
            if(val.getKeyJ1()==4){

            //agregar 5 6 7 8 9 10 11   

                dato.put("puestoN5",val.getKeyParticipanteLose5());
                dato.put("participante5", val.getKeyParticipanteLose5());
                dato1.put("participante5", val.getKeyParticipanteLose5());
                dato1.put("puestoN5",val.getKeyParticipanteLose5());

                dato.put("puestoN6",val.getKeyParticipanteLose6());
                dato.put("participante6", val.getKeyParticipanteLose6());
                dato1.put("participante6", val.getKeyParticipanteLose6());
                dato1.put("puestoN6",val.getKeyParticipanteLose6());
                dato1.put("lvl6","0");

                dato.put("puestoN7",val.getKeyParticipanteLose7());
                dato.put("participante7", val.getKeyParticipanteLose7());
                dato1.put("participante7", val.getKeyParticipanteLose7());
                dato1.put("puestoN7",val.getKeyParticipanteLose7());
                dato1.put("lvl7","0");

                dato.put("puestoN8",val.getKeyParticipanteLose8());
                dato.put("participante8", val.getKeyParticipanteLose8());
                dato1.put("participante8", val.getKeyParticipanteLose8());
                dato1.put("puestoN8",val.getKeyParticipanteLose8());
                dato1.put("lvl8","0");

                dato.put("puestoN9",val.getKeyParticipanteLose9());
                dato.put("participante9", val.getKeyParticipanteLose9());
                dato1.put("participante9", val.getKeyParticipanteLose9());
                dato1.put("puestoN9",val.getKeyParticipanteLose9());
                dato1.put("lvl9","0");

                dato.put("puestoN10",val.getKeyParticipanteLose10());
                dato.put("participante10", val.getKeyParticipanteLose10());
                dato1.put("participante10", val.getKeyParticipanteLose10());
                dato1.put("puestoN10",val.getKeyParticipanteLose10());
                dato1.put("lvl10","0");
                dato1.put("keyConteo","10");

                dato.put("puestoN11",val.getKeyParticipanteLose11());
                dato.put("participante11", val.getKeyParticipanteLose11());
                dato1.put("participante11", val.getKeyParticipanteLose11());
                dato1.put("puestoN11",val.getKeyParticipanteLose11());
                dato1.put("lvl11","0");
                dato1.put("keyConteo","11");

            }

            }else{

            if(val.getKeyJ2()==8){
            if(val.getKeyJ1()==4){

                        //agregar 5 6 7 8 9  10 1 12   
                dato.put("puestoN5",val.getKeyParticipanteLose5());
                dato.put("participante5", val.getKeyParticipanteLose5());
                dato1.put("participante5", val.getKeyParticipanteLose5());
                dato1.put("puestoN5",val.getKeyParticipanteLose5());
                dato1.put("lvl5","0");

                dato.put("puestoN6",val.getKeyParticipanteLose6());
                dato.put("participante6", val.getKeyParticipanteLose6());
                dato1.put("participante6", val.getKeyParticipanteLose6());
                dato1.put("puestoN6",val.getKeyParticipanteLose6());
                dato1.put("lvl6","0");

                dato.put("puestoN7",val.getKeyParticipanteLose7());
                dato.put("participante7", val.getKeyParticipanteLose7());
                dato1.put("participante7", val.getKeyParticipanteLose7());
                dato1.put("puestoN7",val.getKeyParticipanteLose7());
                dato1.put("lvl7","0");

                dato.put("puestoN8",val.getKeyParticipanteLose8());
                dato.put("participante8", val.getKeyParticipanteLose8());
                dato1.put("participante8", val.getKeyParticipanteLose8());
                dato1.put("puestoN8",val.getKeyParticipanteLose8());
                dato1.put("lvl8","0");

                dato.put("puestoN9",val.getKeyParticipanteLose9());
                dato.put("participante9", val.getKeyParticipanteLose9());
                dato1.put("participante9", val.getKeyParticipanteLose9());
                dato1.put("puestoN9",val.getKeyParticipanteLose9());
                dato1.put("lvl9","0");

                dato.put("puestoN10",val.getKeyParticipanteLose10());
                dato.put("participante10", val.getKeyParticipanteLose10());
                dato1.put("participante10", val.getKeyParticipanteLose10());
                dato1.put("puestoN10",val.getKeyParticipanteLose10());
                dato1.put("lvl10","0");

                dato.put("puestoN11",val.getKeyParticipanteLose11());
                dato.put("participante11", val.getKeyParticipanteLose11());
                dato1.put("participante11", val.getKeyParticipanteLose11());
                dato1.put("puestoN11",val.getKeyParticipanteLose11());
                dato1.put("lvl11","0");

                dato.put("puestoN12",val.getKeyParticipanteLose12());
                dato.put("participante12", val.getKeyParticipanteLose12());
                dato1.put("participante12", val.getKeyParticipanteLose12());
                dato1.put("puestoN12",val.getKeyParticipanteLose12());
                dato1.put("lvl12","0");
                dato1.put("keyConteo","12");
            }

            }    
                
            }
                     
                     
            }
            }
            }
            }
            }
             }

               

                bdNeutro.collection("BDcalabozo").document("tablaUp" + val.getKeyCalabozoActivo()+"lose").update(dato1);
                bdNeutro.collection("BDcalabozo").document("calabozoUp" + val.getKeyCalabozoActivo()+"lose").update(dato);
                Toast.makeText(context1.getApplicationContext(), "PROCESO EXITOSO ", Toast.LENGTH_SHORT).show();

            }
                
                
                
            }
        });
        


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorParticipantes=0;
                dialog.dismiss();

            }
        });

        dialog.show();

    }







}
