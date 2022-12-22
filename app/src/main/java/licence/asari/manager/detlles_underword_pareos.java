package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.TimeZone;

public class detlles_underword_pareos {

    FirebaseFirestore bdNeutro;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    LinkedHashMap<Integer, String> equipo = new LinkedHashMap<Integer,String>();
    EditText tex1,tex2; Stack<String> idV1 = new Stack<>();

    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);

    public detlles_underword_pareos(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_underword_pareos);


        ImageView cerrarGeneral =(ImageView) dialog.findViewById(R.id.under_pareo_cierre);
        contexto val = new contexto();

        bdNeutro =FirebaseFirestore.getInstance();
        b1 = (ImageButton) dialog.findViewById(R.id.underPareo_b1);//equipo 1
        b2 = (ImageButton) dialog.findViewById(R.id.underPareo_b2);//equipo
        b3 = (ImageButton) dialog.findViewById(R.id.underPare_b3);//equipo 3
        b4 = (ImageButton) dialog.findViewById(R.id.underPareo_b4);//equipo 4

        b5 = (ImageButton) dialog.findViewById(R.id.underPareo_b5);//equipo 5
         b6 = (ImageButton) dialog.findViewById(R.id.underPareo_b6);//equipo 6
       b7 = (ImageButton) dialog.findViewById(R.id.underPareo_b7);//equipo 7
        b8 = (ImageButton) dialog.findViewById(R.id.underPareo_b8);//equipo 8
        b9 = (ImageButton) dialog.findViewById(R.id.underPareo_b9);//equipo 9
         b10 = (ImageButton) dialog.findViewById(R.id.underPareo_b10);//equipo 10
        ImageButton  generar = (ImageButton) dialog.findViewById(R.id.underPareo_generar);//generar
        Spinner sp1 = (Spinner) dialog.findViewById(R.id.under_pareo_sp1);
         tex1 =(EditText) dialog.findViewById(R.id.underPareo_t1);tex2 =(EditText) dialog.findViewById(R.id.underPareo_t2);

        t1 =(TextView) dialog.findViewById(R.id.under_pareo_t1);// equipo 1
        t2 =(TextView) dialog.findViewById(R.id.under_pareo_t2);// equipo 2
        t3 =(TextView) dialog.findViewById(R.id.under_pareo_t3);// equipo 3
        t4 =(TextView) dialog.findViewById(R.id.under_pareo_t4);// equipo 4
       t5 =(TextView) dialog.findViewById(R.id.under_pareo_t5);// equipo 5
        t6 =(TextView) dialog.findViewById(R.id.under_pareo_t6);// equipo 6
       t7 =(TextView) dialog.findViewById(R.id.under_pareo_t7);// equipo 7
       t8 =(TextView) dialog.findViewById(R.id.under_pareo_t8);// equipo 8
       t9 =(TextView) dialog.findViewById(R.id.under_pareo_t9);// equipo 9
      t10 =(TextView) dialog.findViewById(R.id.under_pareo_t10);// equipo 10

        RadioButton r1 =(RadioButton) dialog.findViewById(R.id.under_pareo_r1);
        RadioButton r2 =(RadioButton) dialog.findViewById(R.id.under_pareo_r2);

        t1.setVisibility(View.GONE);t3.setVisibility(View.GONE);t5.setVisibility(View.GONE);t7.setVisibility(View.GONE);t9.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);t4.setVisibility(View.GONE);t6.setVisibility(View.GONE);t8.setVisibility(View.GONE);t10.setVisibility(View.GONE);


        b1.setVisibility(View.GONE); b3.setVisibility(View.GONE); b5.setVisibility(View.GONE); b7.setVisibility(View.GONE); b9.setVisibility(View.GONE);
        b2.setVisibility(View.GONE); b4.setVisibility(View.GONE); b6.setVisibility(View.GONE); b8.setVisibility(View.GONE); b10.setVisibility(View.GONE);


bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro")
 .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
  @Override
 public void onSuccess(DocumentSnapshot documentSnapshot) {
if(documentSnapshot.exists()){

    val.setKeyconteoUnder(documentSnapshot.getString("keyEquipos"));
    val.setKeyJ1(Integer.parseInt(val.getKeyconteoUnder()));

    //SE HABILITA LOS BOTONES Y LABELES DEACUERDO ALA CANTIDAD DE EQUIPOS CREADOS

    if (val.getKeyJ1() == 4) {
        b1.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);

        t1.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
    }
    if (val.getKeyJ1() == 5) {

        b1.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        b5.setVisibility(View.VISIBLE);b6.setVisibility(View.VISIBLE);

        t1.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        t5.setVisibility(View.VISIBLE);t6.setVisibility(View.VISIBLE);

        val.setKeyconteoUnder(documentSnapshot.getString("fases"));
        val.setKeyJ4(Integer.parseInt(val.getKeyconteoUnder()));


        if(val.getKeyJ4()==3){//a,b,c

            equipo.put(1, documentSnapshot.getString("A1"));
            equipo.put(2, documentSnapshot.getString("A2"));

            equipo.put(3, documentSnapshot.getString("B1"));
            equipo.put(4, documentSnapshot.getString("B2"));

            equipo.put(5, documentSnapshot.getString("C1"));
            equipo.put(6, documentSnapshot.getString("A1"));

            t1.setText(equipo.get(1));
            t2.setText(equipo.get(2));
            t3.setText(equipo.get(3));
            t4.setText(equipo.get(4));
            t5.setText(equipo.get(5));
            t6.setText(equipo.get(1));

        }

        }




}else {
 bdNeutro.collection("BDcalabozo").document("InfoUnderCreate")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                     @Override
                                     public void onSuccess(DocumentSnapshot documentSnapshot) {

                                         val.setKeyconteoUnder(documentSnapshot.getString("kekEquipo"));
                                         val.setKeyJ1(Integer.parseInt(val.getKeyconteoUnder()));

                                         //SE HABILITA LOS BOTONES Y LABELES DEACUERDO ALA CANTIDAD DE EQUIPOS CREADOS
                                         if (val.getKeyJ1() == 4) {
                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);

                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                         }
                                         if (val.getKeyJ1() == 5) {

                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);
                                             b5.setVisibility(View.VISIBLE);b6.setVisibility(View.VISIBLE);

                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                             t5.setVisibility(View.VISIBLE);t6.setVisibility(View.VISIBLE);
                                         }

                                         if (val.getKeyJ1() == 6) {
                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);
                                             b5.setVisibility(View.VISIBLE);
                                             b6.setVisibility(View.VISIBLE);

                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t6.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                             t5.setVisibility(View.VISIBLE);
                                         }
                                         if (val.getKeyJ1() == 7) {
                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);
                                             b5.setVisibility(View.VISIBLE);
                                             b6.setVisibility(View.VISIBLE);
                                             b7.setVisibility(View.VISIBLE);b8.setVisibility(View.VISIBLE);

                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t6.setVisibility(View.VISIBLE);
                                             t7.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                             t5.setVisibility(View.VISIBLE);t8.setVisibility(View.VISIBLE);
                                         }
                                         if (val.getKeyJ1() == 8) {

                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);
                                             b8.setVisibility(View.VISIBLE);
                                             b5.setVisibility(View.VISIBLE);
                                             b6.setVisibility(View.VISIBLE);
                                             b7.setVisibility(View.VISIBLE);

                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t6.setVisibility(View.VISIBLE);
                                             t7.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                             t5.setVisibility(View.VISIBLE);
                                             t8.setVisibility(View.VISIBLE);

                                         }
                                         if (val.getKeyJ1() == 9) {
                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b9.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);
                                             b8.setVisibility(View.VISIBLE);
                                             b5.setVisibility(View.VISIBLE);
                                             b6.setVisibility(View.VISIBLE); b10.setVisibility(View.VISIBLE);
                                             b7.setVisibility(View.VISIBLE);
                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t6.setVisibility(View.VISIBLE);
                                             t7.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                             t5.setVisibility(View.VISIBLE);
                                             t8.setVisibility(View.VISIBLE);
                                             t9.setVisibility(View.VISIBLE);t10.setVisibility(View.VISIBLE);

                                         }
                                         if (val.getKeyJ1() == 10) {
                                             b1.setVisibility(View.VISIBLE);
                                             b3.setVisibility(View.VISIBLE);
                                             b9.setVisibility(View.VISIBLE);
                                             b2.setVisibility(View.VISIBLE);
                                             b4.setVisibility(View.VISIBLE);
                                             b8.setVisibility(View.VISIBLE);
                                             b5.setVisibility(View.VISIBLE);
                                             b6.setVisibility(View.VISIBLE);
                                             b7.setVisibility(View.VISIBLE);
                                             b10.setVisibility(View.VISIBLE);

                                             t1.setVisibility(View.VISIBLE);
                                             t3.setVisibility(View.VISIBLE);
                                             t6.setVisibility(View.VISIBLE);
                                             t7.setVisibility(View.VISIBLE);
                                             t2.setVisibility(View.VISIBLE);
                                             t4.setVisibility(View.VISIBLE);
                                             t5.setVisibility(View.VISIBLE);
                                             t8.setVisibility(View.VISIBLE);
                                             t9.setVisibility(View.VISIBLE);
                                             t10.setVisibility(View.VISIBLE);

                                         }//FIN DE LA HABILITACION DE BOTONES Y LABELES


                                         for (int a = 1; a <= val.getKeyJ1(); a++) {

                                             val.setKeyEquipoUnder_1(documentSnapshot.getString("equipo" + a + "Titulo1"));

                                             equipo.put(a, val.getKeyEquipoUnder_1());

                                         }

                                         HashMap<String, Object> dato1 = new HashMap<>();



                                         //DEACUERDO CON LOS EQUIPOS CREADOS SE PUBLICAN
                                         if (val.getKeyJ1() == 4) {
                                             t1.setText(equipo.get(1));
                                             t2.setText(equipo.get(2));
                                             t3.setText(equipo.get(3));
                                             t4.setText(equipo.get(4));


                                             dato1.put("A",year+"-"+month+"-"+day);
                                             dato1.put("B",year+"-"+month+"-"+day);

                                             dato1.put("keyEquipos",val.getKeyJ1() );
                                             dato1.put("keyVs","1");

                                             bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").set(dato1);
                                         }

                                         if (val.getKeyJ1() == 5) {
                                             t1.setText(equipo.get(1));
                                             t2.setText(equipo.get(2));
                                             t3.setText(equipo.get(3));
                                             t4.setText(equipo.get(4));
                                             t5.setText(equipo.get(5));


                                             dato1.put("fases", "3");

                                             dato1.put("A1",equipo.get(1) );
                                             dato1.put("A2",equipo.get(2) );

                                             dato1.put("B1",equipo.get(3) );
                                             dato1.put("B2",equipo.get(4) );

                                             dato1.put("C1",equipo.get(5) );
                                             dato1.put("C2",equipo.get(1) );




                                             dato1.put("keyEquipos",String.valueOf(val.getKeyJ1()) );
                                             dato1.put("keyVs","1");

                                             bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").set(dato1);

                                         }


                                     }
                                 });

}
}});


        cerrarGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });


generar.setOnClickListener(new View.OnClickListener() {
@Override
 public void onClick(View v) {
if(tex1.getText().toString().equals("")&&tex2.getText().toString().equals("")){
Toast.makeText(context1.getApplicationContext(), "NO DEJE ESPACION DIGITE LOS NUMEROS DE PAREOS", Toast.LENGTH_SHORT).show();
}else{
 val.setKeyJ2(Integer.parseInt(tex1.getText().toString()));//POSICION
val.setKeyJ3(Integer.parseInt(tex2.getText().toString()));//ASIGNACION


if(val.getKeyJ2()<=val.getKeyJ1()&&val.getKeyJ3()<=val.getKeyJ1()||val.getKeyJ2()==6||val.getKeyJ3()==6){
Toast.makeText(context1.getApplicationContext(), "PROCESANDO DATOS", Toast.LENGTH_SHORT).show();

String posicion1 =  equipo.get(val.getKeyJ2());//NOMBRE EQUIPO ELEGIDO
String asignacion1 =  equipo.get(val.getKeyJ3());//NOMBRE EQUIPO A TRASLADAR
HashMap<String, Object> dato1 = new HashMap<>();

val.setKeyUnderFases(sp1.getSelectedItem().toString());
if(val.getKeyUnderFases().equals("fase1")){
val.setKeyGrupoN1("A");val.setKeyGrupoN2("B");val.setKeyGrupoN3("C");
}else{
if(val.getKeyUnderFases().equals("fase2")){
    val.setKeyGrupoN1("E");val.setKeyGrupoN2("F");val.setKeyGrupoN3("G");
}else{
if(val.getKeyUnderFases().equals("fase3")){
    val.setKeyGrupoN1("I");val.setKeyGrupoN2("J");val.setKeyGrupoN3("K");
}else{
if(val.getKeyUnderFases().equals("fase4")){
    val.setKeyGrupoN1("L");val.setKeyGrupoN2("M");val.setKeyGrupoN3("N");
}
}
}
}

if(val.getKeyJ2()==1||val.getKeyJ2()==2){
Toast.makeText(context1.getApplicationContext(), "GRUPO "+val.getKeyGrupoN1()+":     "+posicion1, Toast.LENGTH_SHORT).show();

if(val.getKeyJ3()==3||val.getKeyJ3()==4){
Toast.makeText(context1.getApplicationContext(), "GRUPO  "+val.getKeyGrupoN2()+asignacion1, Toast.LENGTH_SHORT).show();

if(val.getKeyJ2()==1) {
dato1.put(val.getKeyGrupoN1()+"2", asignacion1);
if(val.getKeyJ3()==3){dato1.put(val.getKeyGrupoN2()+"1", equipo.get(2));}else{dato1.put(val.getKeyGrupoN2()+"2", equipo.get(2));}

}else{
dato1.put(val.getKeyGrupoN1()+"1", asignacion1);if(val.getKeyJ3()==3){dato1.put(val.getKeyGrupoN2()+"1", equipo.get(1));}else{dato1.put(val.getKeyGrupoN2()+"2", equipo.get(1));}
}
}
if(val.getKeyJ3()==5||val.getKeyJ3()==6){
Toast.makeText(context1.getApplicationContext(), "GRUPO "+val.getKeyGrupoN3()+":       "+asignacion1, Toast.LENGTH_SHORT).show();
if(val.getKeyJ2()==1) {
dato1.put(val.getKeyGrupoN1()+"2", asignacion1);
 if(val.getKeyJ3()==5){dato1.put(val.getKeyGrupoN3()+"1", equipo.get(2));}else{dato1.put(val.getKeyGrupoN3()+"2", equipo.get(1));}
}else{
dato1.put(val.getKeyGrupoN1()+"1", asignacion1);

if(val.getKeyJ3()==5){
    dato1.put(val.getKeyGrupoN3()+"1", equipo.get(1));
    bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
}else{

dato1.put(val.getKeyGrupoN3()+"2", equipo.get(2));bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);}


}

}
if(val.getKeyJ3()==7||val.getKeyJ3()==8){
Toast.makeText(context1.getApplicationContext(), "GRUPO  "+val.getKeyGrupoN4()+":     "+asignacion1, Toast.LENGTH_SHORT).show();
if(val.getKeyJ2()==1) {
dato1.put("A2", asignacion1);
if(val.getKeyJ3()==7){dato1.put("A1", equipo.get(2));}else{dato1.put("A2", equipo.get(2));}
}else{
dato1.put("A1", asignacion1);
if(val.getKeyJ3()==7){dato1.put("A1", equipo.get(1));}else{dato1.put("A2", equipo.get(1));}
 }

}
if(val.getKeyJ3()==9||val.getKeyJ3()==10){
            Toast.makeText(context1.getApplicationContext(), "GRUPO E "+asignacion1, Toast.LENGTH_SHORT).show();
            if(val.getKeyJ2()==1) {
                dato1.put("A2", asignacion1);
                if(val.getKeyJ3()==7){dato1.put("A1", equipo.get(2));}else{dato1.put("A2", equipo.get(2));}
            }else{
                dato1.put("A1", asignacion1);
                if(val.getKeyJ3()==7){dato1.put("A1", equipo.get(1));}else{dato1.put("A2", equipo.get(1));}
            }

        }

}
if(val.getKeyJ2()==3||val.getKeyJ2()==4){
Toast.makeText(context1.getApplicationContext(), "GRUPO"+val.getKeyGrupoN2()+":    "+posicion1, Toast.LENGTH_SHORT).show();
if(val.getKeyJ3()==1||val.getKeyJ3()==2){
Toast.makeText(context1.getApplicationContext(), "GRUPO"+val.getKeyGrupoN1()+":    "+asignacion1, Toast.LENGTH_SHORT).show();

if(val.getKeyRadio2().equals("pareo2")){

    if(val.getKeyJ2()==3) {
        dato1.put("2"+val.getKeyGrupoN2(), asignacion1);
        if(val.getKeyJ3()==1){dato1.put("1"+val.getKeyGrupoN1(), equipo.get(4));}else{dato1.put("2"+val.getKeyGrupoN1(), equipo.get(3));}
    }else{//4
        dato1.put("1"+val.getKeyGrupoN2(), asignacion1);
        if(val.getKeyJ3()==1){dato1.put("1"+val.getKeyGrupoN1(), equipo.get(3));}else{dato1.put("2"+val.getKeyGrupoN1(), equipo.get(4));}
    }

}else{
if(val.getKeyRadio1().equals("pareo1")){
    if(val.getKeyJ2()==3) {
        dato1.put(val.getKeyGrupoN2()+"2", asignacion1);
        if(val.getKeyJ3()==1){dato1.put(val.getKeyGrupoN1()+"1", equipo.get(4));}else{dato1.put(val.getKeyGrupoN1()+"2", equipo.get(3));}
    }else{//4
        dato1.put(val.getKeyGrupoN2()+"1", asignacion1);
        if(val.getKeyJ3()==1){dato1.put(val.getKeyGrupoN1()+"1", equipo.get(3));}else{dato1.put(val.getKeyGrupoN1()+"2", equipo.get(4));}
    }
}
}





}
if(val.getKeyJ3()==5||val.getKeyJ3()==6){
        Toast.makeText(context1.getApplicationContext(), "GRUPO"+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==3) {
        dato1.put(val.getKeyGrupoN2()+"2", asignacion1);
        if( val.getKeyJ3() == 5 ){ dato1.put(val.getKeyGrupoN3()+"1", equipo.get(4)); }else{dato1.put(val.getKeyGrupoN3()+"2", equipo.get(3));}
        }else{
        dato1.put(val.getKeyGrupoN2()+"1", asignacion1);
        if( val.getKeyJ3() == 5 ){dato1.put(val.getKeyGrupoN3()+"1", equipo.get(3));}else{dato1.put(val.getKeyGrupoN3()+"2", equipo.get(4));}
        }
        }
if(val.getKeyJ3()==7||val.getKeyJ3()==8){
            Toast.makeText(context1.getApplicationContext(), "GRUPO D "+asignacion1, Toast.LENGTH_SHORT).show();

            if(val.getKeyJ2()==1) {
                dato1.put("B2", asignacion1);
            }else{
                dato1.put("B1", asignacion1);
            }
        }
if(val.getKeyJ3()==9||val.getKeyJ3()==10){
            Toast.makeText(context1.getApplicationContext(), "GRUPO E "+asignacion1, Toast.LENGTH_SHORT).show();

            if(val.getKeyJ2()==1) {
                dato1.put("B2", asignacion1);
            }else{
                dato1.put("B1", asignacion1);
            }
        }
}
if(val.getKeyJ2()==5||val.getKeyJ2()==6){
Toast.makeText(context1.getApplicationContext(), "GRUPO"+val.getKeyGrupoN3()+":    "+posicion1, Toast.LENGTH_SHORT).show();
if(val.getKeyJ3()==1||val.getKeyJ3()==2){
Toast.makeText(context1.getApplicationContext(), "GRUPO"+val.getKeyGrupoN1()+":     "+asignacion1, Toast.LENGTH_SHORT).show();

if(val.getKeyJ2()==1) {
dato1.put(val.getKeyGrupoN3()+"2", asignacion1);}else{dato1.put(val.getKeyGrupoN3()+"1", asignacion1);}

}
if(val.getKeyJ3()==3||val.getKeyJ3()==4){
Toast.makeText(context1.getApplicationContext(), "GRUPO"+val.getKeyGrupoN2()+":   "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put(val.getKeyGrupoN3()+"2", asignacion1);
        }else{
            dato1.put(val.getKeyGrupoN3()+"1", asignacion1);
        }
    }
if(val.getKeyJ3()==7||val.getKeyJ3()==8){
        Toast.makeText(context1.getApplicationContext(), "GRUPO D "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("C2", asignacion1);
        }else{
            dato1.put("C1", asignacion1);
        }
    }
if(val.getKeyJ3()==9||val.getKeyJ3()==10){
        Toast.makeText(context1.getApplicationContext(), "GRUPO E "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("C2", asignacion1);
        }else{
            dato1.put("C1", asignacion1);
        }
    }
}
if(val.getKeyJ2()==7||val.getKeyJ2()==8){
        Toast.makeText(context1.getApplicationContext(), "GRUPO D "+posicion1, Toast.LENGTH_SHORT).show();

if(val.getKeyJ3()==1||val.getKeyJ3()==2){
        Toast.makeText(context1.getApplicationContext(), "GRUPO A "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("D2", asignacion1);
        }else{
            dato1.put("D1", asignacion1);
        }
    }
if(val.getKeyJ3()==3||val.getKeyJ3()==4){
        Toast.makeText(context1.getApplicationContext(), "GRUPO B "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("D2", asignacion1);
        }else{
            dato1.put("D1", asignacion1);
        }
    }
if(val.getKeyJ3()==5||val.getKeyJ3()==6){
        Toast.makeText(context1.getApplicationContext(), "GRUPO C "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("D2", asignacion1);
        }else{
            dato1.put("D1", asignacion1);
        }
    }
if(val.getKeyJ3()==9||val.getKeyJ3()==10){
        Toast.makeText(context1.getApplicationContext(), "GRUPO E "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("D2", asignacion1);
        }else{
            dato1.put("D1", asignacion1);
        }
    }
}
if(val.getKeyJ2()==9||val.getKeyJ2()==10){
Toast.makeText(context1.getApplicationContext(), "GRUPO E "+posicion1, Toast.LENGTH_SHORT).show();
if(val.getKeyJ3()==1||val.getKeyJ3()==2){
        Toast.makeText(context1.getApplicationContext(), "GRUPO A "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("E2", asignacion1);
        }else{
            dato1.put("E1", asignacion1);
        }
    }
if(val.getKeyJ3()==3||val.getKeyJ3()==4){
        Toast.makeText(context1.getApplicationContext(), "GRUPO B "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("E2", asignacion1);
        }else{
            dato1.put("E1", asignacion1);
        }
    }
if(val.getKeyJ3()==5||val.getKeyJ3()==6){
        Toast.makeText(context1.getApplicationContext(), "GRUPO C "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("E2", asignacion1);
        }else{
            dato1.put("E1", asignacion1);
        }
    }
if(val.getKeyJ3()==7||val.getKeyJ3()==8){
        Toast.makeText(context1.getApplicationContext(), "GRUPO D "+asignacion1, Toast.LENGTH_SHORT).show();

        if(val.getKeyJ2()==1) {
            dato1.put("E2", asignacion1);
        }else{
            dato1.put("E1", asignacion1);
        }
    }

}

bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
Toast.makeText(context1.getApplicationContext(), "CAMBIO EXITOSO...", Toast.LENGTH_SHORT).show();
}else{
 Toast.makeText(context1.getApplicationContext(), "NO SE DEBE DIGIITAR NUMEROS MAYORES AL TOTAL EN EQUIPOS :  "+val.getKeyJ1(), Toast.LENGTH_SHORT).show();

}









}
                
}
});
r1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

if (r1.isChecked()) {
Toast.makeText(context1.getApplicationContext(), "CARGANDO DATOS....GRUPO INICIAL", Toast.LENGTH_SHORT).show();
if(sp1.getSelectedItem().toString().equals("elija la fase")){
Toast.makeText(context1.getApplicationContext(), "DEBE ELEJIR  UNA FASE ANTES DE CONTUNUAR", Toast.LENGTH_SHORT).show();
}else{
val.setKeyUnderFases(sp1.getSelectedItem().toString());
    val.setKeyRadio1("pareo1");
    val.setKeyRadio2("pareo");
if(val.getKeyUnderFases().equals("fase1")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
val.setKeyUnderGrup1(documentSnapshot.getString("keyVs"));
if(val.getKeyUnderGrup1().equals("1a")||val.getKeyUnderGrup1().equals("1")){
Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO EQUIPOS..", Toast.LENGTH_SHORT).show();
 t1.setText(documentSnapshot.getString("A1"));
t2.setText(documentSnapshot.getString("A2"));t5.setText(documentSnapshot.getString("C1"));
t3.setText(documentSnapshot.getString("B1"));t6.setText(documentSnapshot.getString("C2"));
t4.setText(documentSnapshot.getString("B2"));
}


 }
 }});
}else{
if(val.getKeyUnderFases().equals("fase2")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
val.setKeyUnderGrup1(documentSnapshot.getString("keyVs2"));
if(val.getKeyUnderGrup1().equals("f1")||val.getKeyUnderGrup1().equals("1f")){
    Toast.makeText(context1.getApplicationContext(), "CARGANDO ARCHIVOS Y VISUALIZANDOLOS", Toast.LENGTH_SHORT).show();

    t1.setText(documentSnapshot.getString("F1"));
    t2.setText(documentSnapshot.getString("F2"));t5.setText(documentSnapshot.getString("H1"));
    t3.setText(documentSnapshot.getString("G1"));t6.setText(documentSnapshot.getString("H2"));
    t4.setText(documentSnapshot.getString("G2"));
}else{
if(val.getKeyUnderGrup1().equals("0")) {
    Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO", Toast.LENGTH_SHORT).show();

    HashMap<String, Object> dato1 = new HashMap<>();

    dato1.put("keyVs2","f1");
    dato1.put("F1",equipo.get(5));dato1.put("G2",equipo.get(3));
    dato1.put("F2",equipo.get(2));dato1.put("H1",equipo.get(1));
    dato1.put("G1",equipo.get(4));dato1.put("H2",equipo.get(5));

    bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
    t1.setText(equipo.get(5));t3.setText(equipo.get(4));t5.setText(equipo.get(1));
    t2.setText(equipo.get(2)); t4.setText(equipo.get(3));t6.setText(equipo.get(5));



}
}

}
}});


}else{
if(val.getKeyUnderFases().equals("fase3")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
 @Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
val.setKeyUnderGrup1(documentSnapshot.getString("keyVs3"));
if(val.getKeyUnderGrup1().equals("i1")||val.getKeyUnderGrup1().equals("1i")){
Toast.makeText(context1.getApplicationContext(), "CARGANDO ARCHIVOS Y VISUALIZANDOLOS", Toast.LENGTH_SHORT).show();
t1.setText(documentSnapshot.getString("I1"));
t2.setText(documentSnapshot.getString("I2"));t5.setText(documentSnapshot.getString("K1"));
t3.setText(documentSnapshot.getString("J1"));t6.setText(documentSnapshot.getString("K2"));
t4.setText(documentSnapshot.getString("J2"));

if(equipo.size()==0){}else{equipo.clear();}
    equipo.put(1, documentSnapshot.getString("I1"));
    equipo.put(2, documentSnapshot.getString("I2"));
    equipo.put(3, documentSnapshot.getString("J1"));
    equipo.put(4, documentSnapshot.getString("J2"));
    equipo.put(5, documentSnapshot.getString("K1"));
    equipo.put(6, documentSnapshot.getString("K2"));

}else{
if(val.getKeyUnderGrup1().equals("0")) {
Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO", Toast.LENGTH_SHORT).show();
HashMap<String, Object> dato1 = new HashMap<>();
dato1.put("keyVs3","i1");
dato1.put("I1",equipo.get(5));dato1.put("J2",equipo.get(3));
dato1.put("I2",equipo.get(2));dato1.put("K1",equipo.get(1));
dato1.put("J1",equipo.get(4));dato1.put("K2",equipo.get(5));

bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
t1.setText(equipo.get(5));t3.setText(equipo.get(4));t5.setText(equipo.get(1));
t2.setText(equipo.get(2)); t4.setText(equipo.get(3));t6.setText(equipo.get(5));



}
}

}
}});
}else{
if(val.getKeyUnderFases().equals("fase4")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
 @Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
val.setKeyUnderGrup1(documentSnapshot.getString("keyVs4"));
if(val.getKeyUnderGrup1().equals("l1")||val.getKeyUnderGrup1().equals("1l")){
Toast.makeText(context1.getApplicationContext(), "CARGANDO ARCHIVOS Y VISUALIZANDOLOS", Toast.LENGTH_SHORT).show();
t1.setText(documentSnapshot.getString("L1"));
t2.setText(documentSnapshot.getString("L2"));t5.setText(documentSnapshot.getString("N1"));
t3.setText(documentSnapshot.getString("M1"));t6.setText(documentSnapshot.getString("N2"));
t4.setText(documentSnapshot.getString("M2"));
 }else{
if(val.getKeyUnderGrup1().equals("0")) {
Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO", Toast.LENGTH_SHORT).show();
HashMap<String, Object> dato1 = new HashMap<>();
dato1.put("keyVs4","l1");
dato1.put("L1",equipo.get(5));dato1.put("M2",equipo.get(3));
dato1.put("L2",equipo.get(2));dato1.put("N1",equipo.get(1));
dato1.put("M1",equipo.get(4));dato1.put("N2",equipo.get(5));

                            bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
                            t1.setText(equipo.get(5));t3.setText(equipo.get(4));t5.setText(equipo.get(1));
                            t2.setText(equipo.get(2)); t4.setText(equipo.get(3));t6.setText(equipo.get(5));



}
}

}
}});
    }
}


}


}

}

}
});
r2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

if (r2.isChecked()) {
Toast.makeText(context1.getApplicationContext(), "CARGANDO DATOS....", Toast.LENGTH_SHORT).show();
if(sp1.getSelectedItem().toString().equals("elija la fase")){
Toast.makeText(context1.getApplicationContext(), "DEBE ELEJIR  UNA FASE ANTES DE CONTUNUAR", Toast.LENGTH_SHORT).show();
}else{
val.setKeyUnderFases(sp1.getSelectedItem().toString());
if(val.getKeyUnderFases().equals("fase1")){

      bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
          @Override
          public void onSuccess(DocumentSnapshot documentSnapshot) {

      if(documentSnapshot.exists()){

          val.setKeyUnderGrup1(documentSnapshot.getString("keyVs"));

          if(val.getKeyUnderGrup1().equals("1a")){
        Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO EQUIPOS..", Toast.LENGTH_SHORT).show();

              t1.setText(documentSnapshot.getString("1A"));
              t2.setText(documentSnapshot.getString("2A"));t5.setText(documentSnapshot.getString("5C"));
              t3.setText(documentSnapshot.getString("3B"));t6.setText(documentSnapshot.getString("6C"));
              t4.setText(documentSnapshot.getString("4B"));

          }else{
         Toast.makeText(context1.getApplicationContext(), "CREANDO DATOS AUTOMATICOS  UN MOMENTO POR FAVOR", Toast.LENGTH_SHORT).show();
              HashMap<String, Object> dato1 = new HashMap<>();

              dato1.put("keyVs","1a");
              dato1.put("keyVs2","0");
              dato1.put("keyVs3","0");
              dato1.put("keyVs4","0");
              dato1.put("1A",equipo.get(3));dato1.put("2A",equipo.get(4));
              dato1.put("3B",equipo.get(5));dato1.put("4B",equipo.get(1));
              dato1.put("5C",equipo.get(2));dato1.put("6C",equipo.get(3));

              bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
              t1.setText(equipo.get(3));
              t2.setText(equipo.get(4));t5.setText(equipo.get(2));
              t3.setText(equipo.get(5));t6.setText(equipo.get(1));
              t4.setText(equipo.get(1));

}

}

}
});
}else{
if(val.getKeyUnderFases().equals("fase2")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

if (documentSnapshot.exists()) {
    val.setKeyUnderGrup1(documentSnapshot.getString("keyVs2"));
if(val.getKeyUnderGrup1().equals("0")) {
    Toast.makeText(context1.getApplicationContext(), "SELECCIONE LA PRIMERA OPCION... AUN NO SE HA CREADO EL PRIMER GRUPO", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyUnderGrup1().equals("1f")){
    Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y CARGANDO DATOS", Toast.LENGTH_SHORT).show();

    t1.setText(documentSnapshot.getString("1F"));
    t2.setText(documentSnapshot.getString("2F"));t5.setText(documentSnapshot.getString("1H"));
    t3.setText(documentSnapshot.getString("1G"));t6.setText(documentSnapshot.getString("2H"));
    t4.setText(documentSnapshot.getString("2G"));
}else{
    Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO", Toast.LENGTH_SHORT).show();

    HashMap<String, Object> dato1 = new HashMap<>();

    dato1.put("keyVs2","1f");
    dato1.put("1F",equipo.get(2));dato1.put("2G",equipo.get(3));
    dato1.put("2F",equipo.get(5));dato1.put("1H",equipo.get(4));
    dato1.put("1G",equipo.get(1));dato1.put("2H",equipo.get(2));

    bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
    t1.setText(equipo.get(2));t3.setText(equipo.get(1));t5.setText(equipo.get(4));
    t2.setText(equipo.get(5)); t4.setText(equipo.get(3));t6.setText(equipo.get(2));

}
}

}

}});
}else{
if(val.getKeyUnderFases().equals("fase3")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
val.setKeyUnderGrup1(documentSnapshot.getString("keyVs3"));
if(val.getKeyUnderGrup1().equals("0")) {
Toast.makeText(context1.getApplicationContext(), "SELECCIONE LA PRIMERA OPCION... AUN NO SE HA CREADO EL PRIMER GRUPO", Toast.LENGTH_SHORT).show();
}else{
    val.setKeyRadio2("pareo2");
    val.setKeyRadio1("pareo");
    if(val.getKeyUnderGrup1().equals("1i")){
        Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y CARGANDO DATOS", Toast.LENGTH_SHORT).show();

        t1.setText(documentSnapshot.getString("1I"));
        t2.setText(documentSnapshot.getString("2I"));t5.setText(documentSnapshot.getString("1K"));
        t3.setText(documentSnapshot.getString("1J"));t6.setText(documentSnapshot.getString("2K"));
        t4.setText(documentSnapshot.getString("2J"));

        if(equipo.size()==0){}else{equipo.clear();}
        equipo.put(1, documentSnapshot.getString("1I"));
        equipo.put(2, documentSnapshot.getString("2I"));
        equipo.put(3, documentSnapshot.getString("1J"));
        equipo.put(4, documentSnapshot.getString("2J"));
        equipo.put(5, documentSnapshot.getString("1K"));
        equipo.put(6, documentSnapshot.getString("2K"));
    }else{
        Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO", Toast.LENGTH_SHORT).show();

        HashMap<String, Object> dato1 = new HashMap<>();

        dato1.put("keyVs3","1i");
        dato1.put("1I",equipo.get(2));dato1.put("2J",equipo.get(3));
        dato1.put("2I",equipo.get(5));dato1.put("1K",equipo.get(4));
        dato1.put("1J",equipo.get(1));dato1.put("2K",equipo.get(2));

        bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
        t1.setText(equipo.get(2));t3.setText(equipo.get(1));t5.setText(equipo.get(4));
        t2.setText(equipo.get(5)); t4.setText(equipo.get(3));t6.setText(equipo.get(2));

    }

}

}
}});
}else{
if(val.getKeyUnderFases().equals("fase4")){
bdNeutro.collection("BDcalabozo" ).document("BDVsUnderwordnegro")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
val.setKeyUnderGrup1(documentSnapshot.getString("keyVs4"));
if(val.getKeyUnderGrup1().equals("0")) {
                                Toast.makeText(context1.getApplicationContext(), "SELECCIONE LA PRIMERA OPCION... AUN NO SE HA CREADO EL PRIMER GRUPO", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyUnderGrup1().equals("1l")){
                                    Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y CARGANDO DATOS", Toast.LENGTH_SHORT).show();

                                    t1.setText(documentSnapshot.getString("1L"));
                                    t2.setText(documentSnapshot.getString("2L"));t5.setText(documentSnapshot.getString("1N"));
                                    t3.setText(documentSnapshot.getString("1M"));t6.setText(documentSnapshot.getString("2N"));
                                    t4.setText(documentSnapshot.getString("2M"));
}else{
                                    Toast.makeText(context1.getApplicationContext(), "EXAMINANDO ARCHIVOS Y ACTUALIZANDO", Toast.LENGTH_SHORT).show();

                                    HashMap<String, Object> dato1 = new HashMap<>();

                                    dato1.put("keyVs2","1L");
                                    dato1.put("1L",equipo.get(2));dato1.put("2M",equipo.get(3));
                                    dato1.put("2L",equipo.get(5));dato1.put("1N",equipo.get(4));
                                    dato1.put("1M",equipo.get(1));dato1.put("2N",equipo.get(2));

                                    bdNeutro.collection("BDcalabozo").document("BDVsUnderwordnegro").update(dato1);
                                    t1.setText(equipo.get(2));t3.setText(equipo.get(1));t5.setText(equipo.get(4));
                                    t2.setText(equipo.get(5)); t4.setText(equipo.get(3));t6.setText(equipo.get(2));

                                }

                            }

                        }
                    }});
    }

}
}



}



}

                }

        });



        ArrayAdapter<String> datos = null;
        idV1.add("elija la fase");
        idV1.add("fase1");
        idV1.add("fase2");
        idV1.add("fase3");
        idV1.add("fase4");
        datos = new ArrayAdapter<>(context1.getApplicationContext(), R.layout.spiner_jornada_random, idV1);
        sp1.setAdapter(datos);

        //r2.setChecked(false);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r2.setChecked(false);r1.setChecked(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dialog.show();

 }







}
