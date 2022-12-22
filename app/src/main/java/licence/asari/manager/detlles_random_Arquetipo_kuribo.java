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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Stack;


public class detlles_random_Arquetipo_kuribo {

  FirebaseFirestore bdNeutro,bdNeutral;
  Stack<String> idV5 = new Stack <String>  ();
  int numeroAleatorio=0,contador=0;

    public detlles_random_Arquetipo_kuribo(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_random_xyz);

        contexto val = new contexto();
        TextView l1 = (TextView) dialog.findViewById(R.id.xyz_l1);
        TextView l2 = (TextView) dialog.findViewById(R.id.xyz_l2);

        ImageButton b1 =(ImageButton) dialog.findViewById(R.id.xyz_b1);
        ImageButton b2 =(ImageButton) dialog.findViewById(R.id.xyz_b2);
        ImageButton b3 =(ImageButton) dialog.findViewById(R.id.xyz_b3);
        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.random_xyz_cerrar);

        bdNeutro = FirebaseFirestore.getInstance();
        bdNeutral= FirebaseFirestore.getInstance();

b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if(tabla_registro_dungeo_v6.idV4.size()==1){

                        l2.setText("DESCANSO");
                        Toast.makeText(context1.getApplicationContext(), "Finalizo el random", Toast.LENGTH_SHORT).show();
                    }

                    int said1 = tabla_registro_dungeo_v6.idV4.size();
                    numeroAleatorio = (int) (Math.random() * said1); // numero aleatorio del stack
                    val.setKeyDuelista(tabla_registro_dungeo_v6.idV4.get(numeroAleatorio));//nombre duelista
                    idV5.add(val.getKeyDuelista());
                    tabla_registro_dungeo_v6.idV4.remove(numeroAleatorio);  // eliminamos el duelista del stak
                    l1.setText(val.getKeyDuelista());  // publicacmos

                    int said2 = tabla_registro_dungeo_v6.idV4.size();
                    numeroAleatorio = (int) (Math.random() * said2); // numero aleatorio del stack
                    val.setKeyDuelista2(tabla_registro_dungeo_v6.idV4.get(numeroAleatorio));//nombre duelista
                    idV5.add(val.getKeyDuelista2());
                    tabla_registro_dungeo_v6.idV4.remove(numeroAleatorio);  // eliminamos el duelista del stak
                    l2.setText(val.getKeyDuelista2());  // publicacmos



                }catch (Exception sdfsf){}

                if(tabla_registro_dungeo_v6.idV4.size()==0){
                    Toast.makeText(context1.getApplicationContext(), "Finalizo el random", Toast.LENGTH_SHORT).show();
                }

            }
});

b2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

  bdNeutro.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
      @Override
      public void onSuccess(DocumentSnapshot documentSnapshot) {

       if(documentSnapshot.exists()){

           val.setKeyCalabozoActivo(documentSnapshot.getString("salakeyArquetopoKuribo"));


           bdNeutro.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).get()
                   .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                       @Override
                       public void onSuccess(DocumentSnapshot documentSnapshot) {

                           if (documentSnapshot.exists()) {

                               val.setKeyJ1(Integer.parseInt(val.getKeyCalabozoActivo()));
                               if(val.getKeyJ1()==4){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));

                               }
                               if(val.getKeyJ1()==5){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));

                               }

                               if(val.getKeyJ1()==6){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));

                               }

                               if(val.getKeyJ1()==7){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));
                                   val.setKeyCalabozolvl7(documentSnapshot.getString("participante7"));

                               }

                               if(val.getKeyJ1()==8){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));
                                   val.setKeyCalabozolvl7(documentSnapshot.getString("participante7"));
                                   val.setKeyCalabozolvl8(documentSnapshot.getString("participante8"));

                               }
                               if(val.getKeyJ1()==9){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));
                                   val.setKeyCalabozolvl7(documentSnapshot.getString("participante7"));
                                   val.setKeyCalabozolvl8(documentSnapshot.getString("participante8"));
                                   val.setKeyCalabozolvl9(documentSnapshot.getString("participante9"));

                               }
                               if(val.getKeyJ1()==10){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));
                                   val.setKeyCalabozolvl7(documentSnapshot.getString("participante7"));
                                   val.setKeyCalabozolvl8(documentSnapshot.getString("participante8"));
                                   val.setKeyCalabozolvl9(documentSnapshot.getString("participante9"));
                                   val.setKeyCalabozolvl10(documentSnapshot.getString("participante10"));

                               }
                               if(val.getKeyJ1()==11){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));
                                   val.setKeyCalabozolvl7(documentSnapshot.getString("participante7"));
                                   val.setKeyCalabozolvl8(documentSnapshot.getString("participante8"));
                                   val.setKeyCalabozolvl9(documentSnapshot.getString("participante9"));
                                   val.setKeyCalabozolvl10(documentSnapshot.getString("participante10"));
                                   val.setKeyCalabozolvl11(documentSnapshot.getString("participante11"));

                               }
                               if(val.getKeyJ1()==12){
                                   val.setKeyCalabozolvl1(documentSnapshot.getString("participante1"));
                                   val.setKeyCalabozolvl2(documentSnapshot.getString("participante2"));
                                   val.setKeyCalabozolvl3(documentSnapshot.getString("participante3"));
                                   val.setKeyCalabozolvl4(documentSnapshot.getString("participante4"));
                                   val.setKeyCalabozolvl5(documentSnapshot.getString("participante5"));
                                   val.setKeyCalabozolvl6(documentSnapshot.getString("participante6"));
                                   val.setKeyCalabozolvl7(documentSnapshot.getString("participante7"));
                                   val.setKeyCalabozolvl8(documentSnapshot.getString("participante8"));
                                   val.setKeyCalabozolvl9(documentSnapshot.getString("participante9"));
                                   val.setKeyCalabozolvl10(documentSnapshot.getString("participante10"));
                                   val.setKeyCalabozolvl11(documentSnapshot.getString("participante11"));
                                   val.setKeyCalabozolvl12(documentSnapshot.getString("participante12"));

                               }



                               b1.setVisibility(View.GONE);



 HashMap<String, Object> dato1 = new HashMap<>();

if (val.getKeyCalabozolvl3().equals("esperando")) {
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){}
else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){}
else{
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){}
else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){}
else{
    HashMap<String, Object> dato = new HashMap<>();
    dato1.put("participante3", val.getKeyDuelista());
    dato1.put("participante4", val.getKeyDuelista2());


    bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
    dato.put("puestoN3", val.getKeyDuelista());
    dato.put("puestoN4", val.getKeyDuelista2());
    dato.put("participante3", val.getKeyDuelista());
    dato.put("participante4", val.getKeyDuelista2());
    b1.setVisibility(View.VISIBLE);
    bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
    Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas.", Toast.LENGTH_SHORT).show();
}
}
}

}
} else {
if (val.getKeyCalabozolvl4().equals("esperando")) {


    if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){}
    else{
        if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){}
        else{
            if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){}
            else{
                if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){}
                else{
                    HashMap<String, Object> dato = new HashMap<>();
                    dato1.put("participante3", val.getKeyDuelista());
                    dato1.put("participante4", val.getKeyDuelista2());

                    bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
                    dato.put("puestoN3", val.getKeyDuelista());
                    dato.put("puestoN4", val.getKeyDuelista2());b1.setVisibility(View.VISIBLE);
                    dato.put("participante3", val.getKeyDuelista());
                    dato.put("participante4", val.getKeyDuelista2());
                    bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
                    Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas.", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
} else {
if (val.getKeyCalabozolvl5().equals("esperando")) {


    if(val.getKeyJ1()==5){

        HashMap<String, Object> dato = new HashMap<>();
        dato1.put("participante5", val.getKeyDuelista());
        bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
        dato.put("puestoN5", val.getKeyDuelista());
        dato.put("participante5", val.getKeyDuelista());
        bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
        Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas. EN DESCANSO", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyJ1()>=6){

if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){
}else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){
}else{
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){
}else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){
}else {
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl3())){
}else{
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl4())){
}else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl3())){
}else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl4())){}
else{



    HashMap<String, Object> dato = new HashMap<>();
    dato1.put("participante5", val.getKeyDuelista());
    dato1.put("participante6", val.getKeyDuelista2());

    bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
    dato.put("puestoN5", val.getKeyDuelista());
    dato.put("puestoN6", val.getKeyDuelista2());b1.setVisibility(View.VISIBLE);
    dato.put("participante5", val.getKeyDuelista());
    dato.put("participante6", val.getKeyDuelista2());
    bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
    Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas.", Toast.LENGTH_SHORT).show();


}
}
}
}
}}}}}

    }

} else {
if (val.getKeyCalabozolvl6().equals("esperando")) {
    if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){}
    else{
        if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){}
        else{
            if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){}
            else{
                if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){}
                else {
                    if(val.getKeyDuelista().equals(val.getKeyCalabozolvl3())){}
                    else{
                        if(val.getKeyDuelista().equals(val.getKeyCalabozolvl4())){}
                        else{
                            if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl3())){}
                            else{
                                if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl4())){}
                                else{
                                    dato1.put("participante5", val.getKeyDuelista());
                                    dato1.put("participante6", val.getKeyDuelista2());

                                    bdNeutral.collection("BDcalabozo").document("tablaUp" + val.getKeyCalabozoActivo()).update(dato1);
                                    HashMap<String, Object> dato = new HashMap<>();
                                    dato.put("puestoN5", val.getKeyDuelista());
                                    dato.put("puestoN6", val.getKeyDuelista2());
                                    dato.put("participante5", val.getKeyDuelista());
                                    dato.put("participante6", val.getKeyDuelista2());
                                    b1.setVisibility(View.VISIBLE);
                                    bdNeutral.collection("BDcalabozo").document("calabozoUp" + val.getKeyCalabozoActivo()).update(dato);

                                    Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }}}}
} else {
if (val.getKeyCalabozolvl7().equals("esperando")) {
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){}
else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){}
else{
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){}
else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){}
 else {
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl3())){}
else{
if(val.getKeyDuelista().equals(val.getKeyCalabozolvl4())){}
else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl3())){}
else{
if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl4())){}
else {
    if(val.getKeyJ1()==7){
        dato1.put("participante7", val.getKeyDuelista());

        HashMap<String, Object> dato = new HashMap<>();
        dato1.put("participante7", val.getKeyDuelista());
        bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
        dato.put("puestoN7", val.getKeyDuelista());
        dato.put("participante7", val.getKeyDuelista());
        bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
        Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas. EN DESCANSO", Toast.LENGTH_SHORT).show();


    }else {

        HashMap<String, Object> dato = new HashMap<>();
        dato1.put("participante7", val.getKeyDuelista());
        dato1.put("participante8", val.getKeyDuelista2());
        bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
        dato.put("puestoN7", val.getKeyDuelista());
        dato.put("puestoN8", val.getKeyDuelista2());
        dato.put("participante7", val.getKeyDuelista());
        dato.put("participante8", val.getKeyDuelista2());
        bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
        Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas", Toast.LENGTH_SHORT).show();
    }

}}}}}}}}

}else{
    if (val.getKeyCalabozolvl8().equals("esperando")) {
        if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){}
        else{
            if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){}
            else{
                if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){}
                else{
                    if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){}
                    else {
                        if(val.getKeyDuelista().equals(val.getKeyCalabozolvl3())){}
                        else{
                            if(val.getKeyDuelista().equals(val.getKeyCalabozolvl4())){}
                            else{
                                if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl3())){}
                                else{
                                    if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl4())){}
                                    else {
                                        HashMap<String, Object> dato = new HashMap<>();
                                        dato1.put("participante7", val.getKeyDuelista());
                                        dato1.put("participante8", val.getKeyDuelista2());
                                        bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
                                        dato.put("puestoN7", val.getKeyDuelista());
                                        dato.put("puestoN8", val.getKeyDuelista2());
                                        dato.put("participante7", val.getKeyDuelista());
                                        dato.put("participante8", val.getKeyDuelista2());
                                        bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
                                        Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas.", Toast.LENGTH_SHORT).show();
                                    }}}}}}}}
}else{
        if (val.getKeyCalabozolvl9().equals("esperando")) {
            if(val.getKeyDuelista().equals(val.getKeyCalabozolvl1())){}
            else{
                if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl1())){}
                else{
                    if(val.getKeyDuelista().equals(val.getKeyCalabozolvl2())){}
                    else{
                        if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl2())){}
                        else {
                            if(val.getKeyDuelista().equals(val.getKeyCalabozolvl3())){}
                            else{
                                if(val.getKeyDuelista().equals(val.getKeyCalabozolvl4())){}
                                else{
                                    if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl3())){}
                                    else{
                                        if(val.getKeyDuelista2().equals(val.getKeyCalabozolvl4())){}
                                        else {

                                            if(val.getKeyJ1()==9){
                                                dato1.put("participante9", val.getKeyDuelista());

                                                HashMap<String, Object> dato = new HashMap<>();
                                                dato1.put("participante9", val.getKeyDuelista());
                                                bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
                                                dato.put("puestoN9", val.getKeyDuelista());
                                                dato.put("participante9", val.getKeyDuelista());
                                                bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
                                                Toast.makeText(context1.getApplicationContext(), "Asignando puestos... Duelistas. EN DESCANSO", Toast.LENGTH_SHORT).show();


                                            }else {

                                            HashMap<String, Object> dato = new HashMap<>();
                                            dato1.put("participante9", val.getKeyDuelista());
                                            dato1.put("participante10", val.getKeyDuelista2());
                                            bdNeutral.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).update(dato1);
                                            dato.put("puestoN9", val.getKeyDuelista());
                                            dato.put("puestoN10", val.getKeyDuelista2());
                                            dato.put("participante9", val.getKeyDuelista());
                                            dato.put("participante10", val.getKeyDuelista2());
                                            bdNeutral.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).update(dato);
                                            Toast.makeText(context1.getApplicationContext(), "Asignando puestos...", Toast.LENGTH_SHORT).show();
                                       }


                                        }}}}}}}}
        }


}

}

} } } }
}else{
crear();
                               Toast.makeText(context1.getApplicationContext(), "Añadiendo duelistas... ", Toast.LENGTH_SHORT).show();
}
}});

if(tabla_registro_dungeo_v6.idV4.size() == 0){
    HashMap<String, Object> dato = new HashMap<>();
    dato.put("keyRegistroActivoKuribo","eliminatoria");

    Toast.makeText(context1.getApplicationContext(), "Desactivando Pre-Registro ... ", Toast.LENGTH_SHORT).show();
    Toast.makeText(context1.getApplicationContext(), "Habilitando ARQUETPO KURIBO ... ", Toast.LENGTH_SHORT).show();
    bdNeutro.collection("BDcalabozo").document("Info").update(dato);
}

           bdNeutro.collection("BDcalabozo").document("tablaEncuentro")
                   .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
               @Override
               public void onSuccess(DocumentSnapshot documentSnapshot) {
                   HashMap<String, Object> dato4 = new HashMap<>();
                   if (documentSnapshot.exists()) {
                   }else{
                       HashMap<String, Object> dato5 = new HashMap<>();
                       dato4.put("iciando", "1");
                       bdNeutro.collection("BDcalabozo").document("tablaEncuentro").update(dato5);
                   }
               }});


       }

      }
  })  ;


 }
 });




 cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabla_registro_dungeo_v6.idV4.size()== 0){
                    tabla_registro_dungeo_v6.idV4 = (Stack<String>) idV5.clone();
                    idV5.clear();

                    bdNeutro.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).delete();
                    bdNeutro.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).delete();
                    Toast.makeText(context1.getApplicationContext(), "Cambio exitoso puede volver a realizar el Pareo", Toast.LENGTH_SHORT).show();

                    HashMap<String, Object> dato1 = new HashMap<>();
                    dato1.put("keyRegistroActivoKuribo","registro");
                    bdNeutro.collection("BDcalabozo").document("Info").update(dato1);

                    Toast.makeText(context1.getApplicationContext(), "Habilitando Pre-Registro ... ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(context1.getApplicationContext(), "Desactivando  Arquetipo Kuribo ... ", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(context1.getApplicationContext(), "Aun no es el momento para este uso..", Toast.LENGTH_SHORT).show();

                }

            }
        });



        dialog.show();

    }




    public void crear(){
        contexto val = new contexto();

        HashMap<String, Object> dato = new HashMap<>();
        HashMap<String, Object> dato1 = new HashMap<>();






        val.setKeyJ1(Integer.parseInt(val.getKeyCalabozoActivo()));
        if(val.getKeyJ1()==4){
            dato.put("puestoN1",val.getKeyDuelista());
            dato.put("puestoN2",val.getKeyDuelista2());
            dato.put("puestoN3","esperando");
            dato.put("puestoN4","esperando");

            dato.put("participante1", val.getKeyDuelista());
            dato.put("participante2", val.getKeyDuelista2());
            dato.put("participante3","esperando");
            dato.put("participante4", "esperando");

            dato1.put("participante1",val.getKeyDuelista());
            dato1.put("participante2",val.getKeyDuelista2());
            dato1.put("participante3","esperando");
            dato1.put("participante4","esperando");

            dato1.put("puesto1","esperando");
            dato1.put("puesto2","esperando");
            dato1.put("puesto3","esperando");
            dato1.put("puesto4","esperando");

            dato1.put("lvl1","0");
            dato1.put("lvl2","0");
            dato1.put("lvl3","0");
            dato1.put("lvl4","0");

        }else{
        if(val.getKeyJ1()==5){
            dato.put("puestoN1",val.getKeyDuelista());
            dato.put("puestoN2",val.getKeyDuelista2());
            dato.put("puestoN3","esperando");
            dato.put("puestoN4","esperando");
            dato.put("puestoN5","esperando");
            dato.put("participante1", val.getKeyDuelista());
            dato.put("participante2", val.getKeyDuelista2());
            dato.put("participante3","esperando");
            dato.put("participante4", "esperando");
            dato.put("participante5", "esperando");

            dato1.put("participante1",val.getKeyDuelista());
            dato1.put("participante2",val.getKeyDuelista2());
            dato1.put("participante3","esperando");
            dato1.put("participante4","esperando");
            dato1.put("participante5","esperando");

            dato1.put("puesto1","esperando");
            dato1.put("puesto2","esperando");
            dato1.put("puesto3","esperando");
            dato1.put("puesto4","esperando");
            dato1.put("puesto5","esperando");

            dato1.put("lvl1","0");
            dato1.put("lvl2","0");
            dato1.put("lvl3","0");
            dato1.put("lvl4","0");
            dato1.put("lvl5","0");
        }else{
            if(val.getKeyJ1()==6){
                dato.put("puestoN1",val.getKeyDuelista());
                dato.put("puestoN2",val.getKeyDuelista2());
                dato.put("puestoN3","esperando");
                dato.put("puestoN4","esperando");
                dato.put("puestoN5","esperando");
                dato.put("puestoN6","esperando");

                dato.put("participante1", val.getKeyDuelista());
                dato.put("participante2", val.getKeyDuelista2());
                dato.put("participante3","esperando");
                dato.put("participante4", "esperando");
                dato.put("participante5", "esperando");
                dato.put("participante6", "esperando");

                dato1.put("participante1",val.getKeyDuelista());
                dato1.put("participante2",val.getKeyDuelista2());
                dato1.put("participante3","esperando");
                dato1.put("participante4","esperando");
                dato1.put("participante5","esperando");
                dato1.put("participante6","esperando");

                dato1.put("puesto1","esperando");
                dato1.put("puesto2","esperando");
                dato1.put("puesto3","esperando");
                dato1.put("puesto4","esperando");
                dato1.put("puesto5","esperando");
                dato1.put("puesto6","esperando");

                dato1.put("lvl1","0");
                dato1.put("lvl2","0");
                dato1.put("lvl3","0");
                dato1.put("lvl4","0");
                dato1.put("lvl5","0");
                dato1.put("lvl6","0");
            }else{
                if(val.getKeyJ1()==7){
                    dato.put("puestoN1",val.getKeyDuelista());
                    dato.put("puestoN2",val.getKeyDuelista2());
                    dato.put("puestoN3","esperando");
                    dato.put("puestoN4","esperando");
                    dato.put("puestoN5","esperando");
                    dato.put("puestoN6","esperando");
                    dato.put("puestoN7","esperando");

                    dato.put("participante1", val.getKeyDuelista());
                    dato.put("participante2", val.getKeyDuelista2());
                    dato.put("participante3","esperando");
                    dato.put("participante4", "esperando");
                    dato.put("participante5", "esperando");
                    dato.put("participante6", "esperando");
                    dato.put("participante7", "esperando");

                    dato1.put("participante1",val.getKeyDuelista());
                    dato1.put("participante2",val.getKeyDuelista2());
                    dato1.put("participante3","esperando");
                    dato1.put("participante4","esperando");
                    dato1.put("participante5","esperando");
                    dato1.put("participante6","esperando");
                    dato1.put("participante7","esperando");

                    dato1.put("puesto1","esperando");
                    dato1.put("puesto2","esperando");
                    dato1.put("puesto3","esperando");
                    dato1.put("puesto4","esperando");
                    dato1.put("puesto5","esperando");
                    dato1.put("puesto6","esperando");
                    dato1.put("puesto7","esperando");

                    dato1.put("lvl1","0");
                    dato1.put("lvl2","0");
                    dato1.put("lvl3","0");
                    dato1.put("lvl4","0");
                    dato1.put("lvl5","0");
                    dato1.put("lvl6","0");
                    dato1.put("lvl7","0");
                }else{
                    if(val.getKeyJ1()==8){
                        dato.put("puestoN1",val.getKeyDuelista());
                        dato.put("puestoN2",val.getKeyDuelista2());
                        dato.put("puestoN3","esperando");
                        dato.put("puestoN4","esperando");
                        dato.put("puestoN5","esperando");
                        dato.put("puestoN6","esperando");
                        dato.put("puestoN7","esperando");
                        dato.put("puestoN8","esperando");

                        dato.put("participante1", val.getKeyDuelista());
                        dato.put("participante2", val.getKeyDuelista2());
                        dato.put("participante3","esperando");
                        dato.put("participante4", "esperando");
                        dato.put("participante5", "esperando");
                        dato.put("participante6", "esperando");
                        dato.put("participante7", "esperando");
                        dato.put("participante8", "esperando");

                        dato1.put("participante1",val.getKeyDuelista());
                        dato1.put("participante2",val.getKeyDuelista2());
                        dato1.put("participante3","esperando");
                        dato1.put("participante4","esperando");
                        dato1.put("participante5","esperando");
                        dato1.put("participante6","esperando");
                        dato1.put("participante7","esperando");
                        dato1.put("participante8","esperando");

                        dato1.put("puesto1","esperando");
                        dato1.put("puesto2","esperando");
                        dato1.put("puesto3","esperando");
                        dato1.put("puesto4","esperando");
                        dato1.put("puesto5","esperando");
                        dato1.put("puesto6","esperando");
                        dato1.put("puesto7","esperando");
                        dato1.put("puesto8","esperando");

                        dato1.put("lvl1","0");
                        dato1.put("lvl2","0");
                        dato1.put("lvl3","0");
                        dato1.put("lvl4","0");
                        dato1.put("lvl5","0");
                        dato1.put("lvl6","0");
                        dato1.put("lvl7","0");
                        dato1.put("lvl8","0");
                    }else{
                        if(val.getKeyJ1()==9){
                            dato.put("puestoN1",val.getKeyDuelista());
                            dato.put("puestoN2",val.getKeyDuelista2());
                            dato.put("puestoN3","esperando");
                            dato.put("puestoN4","esperando");
                            dato.put("puestoN5","esperando");
                            dato.put("puestoN6","esperando");
                            dato.put("puestoN7","esperando");
                            dato.put("puestoN8","esperando");
                            dato.put("puestoN9","esperando");

                            dato.put("participante1", val.getKeyDuelista());
                            dato.put("participante2", val.getKeyDuelista2());
                            dato.put("participante3","esperando");
                            dato.put("participante4", "esperando");
                            dato.put("participante5", "esperando");
                            dato.put("participante6", "esperando");
                            dato.put("participante7", "esperando");
                            dato.put("participante8", "esperando");
                            dato.put("participante9", "esperando");

                            dato1.put("participante1",val.getKeyDuelista());
                            dato1.put("participante2",val.getKeyDuelista2());
                            dato1.put("participante3","esperando");
                            dato1.put("participante4","esperando");
                            dato1.put("participante5","esperando");
                            dato1.put("participante6","esperando");
                            dato1.put("participante7","esperando");
                            dato1.put("participante8","esperando");
                            dato1.put("participante9","esperando");

                            dato1.put("puesto1","esperando");
                            dato1.put("puesto2","esperando");
                            dato1.put("puesto3","esperando");
                            dato1.put("puesto4","esperando");
                            dato1.put("puesto5","esperando");
                            dato1.put("puesto6","esperando");
                            dato1.put("puesto7","esperando");
                            dato1.put("puesto8","esperando");
                            dato1.put("puesto9","esperando");

                            dato1.put("lvl1","0");
                            dato1.put("lvl2","0");
                            dato1.put("lvl3","0");
                            dato1.put("lvl4","0");
                            dato1.put("lvl5","0");
                            dato1.put("lvl6","0");
                            dato1.put("lvl7","0");
                            dato1.put("lvl8","0");
                            dato1.put("lvl9","0");
                        }else{
                            if(val.getKeyJ1()==10){
                                dato.put("puestoN1",val.getKeyDuelista());
                                dato.put("puestoN2",val.getKeyDuelista2());
                                dato.put("puestoN3","esperando");
                                dato.put("puestoN4","esperando");
                                dato.put("puestoN5","esperando");
                                dato.put("puestoN6","esperando");
                                dato.put("puestoN7","esperando");
                                dato.put("puestoN8","esperando");
                                dato.put("puestoN9","esperando");
                                dato.put("puestoN10","esperando");
                                dato.put("participante1", val.getKeyDuelista());
                                dato.put("participante2", val.getKeyDuelista2());
                                dato.put("participante3","esperando");
                                dato.put("participante4", "esperando");
                                dato.put("participante5", "esperando");
                                dato.put("participante6", "esperando");
                                dato.put("participante7", "esperando");
                                dato.put("participante8", "esperando");
                                dato.put("participante9", "esperando");
                                dato.put("participante10", "esperando");

                                dato1.put("participante1",val.getKeyDuelista());
                                dato1.put("participante2",val.getKeyDuelista2());
                                dato1.put("participante3","esperando");
                                dato1.put("participante4","esperando");
                                dato1.put("participante5","esperando");
                                dato1.put("participante6","esperando");
                                dato1.put("participante7","esperando");
                                dato1.put("participante8","esperando");
                                dato1.put("participante9","esperando");
                                dato1.put("participante10","esperando");

                                dato1.put("puesto1","esperando");
                                dato1.put("puesto2","esperando");
                                dato1.put("puesto3","esperando");
                                dato1.put("puesto4","esperando");
                                dato1.put("puesto5","esperando");
                                dato1.put("puesto6","esperando");
                                dato1.put("puesto7","esperando");
                                dato1.put("puesto8","esperando");
                                dato1.put("puesto9","esperando");
                                dato1.put("puesto10","esperando");

                                dato1.put("lvl1","0");
                                dato1.put("lvl2","0");
                                dato1.put("lvl3","0");
                                dato1.put("lvl4","0");
                                dato1.put("lvl5","0");
                                dato1.put("lvl6","0");
                                dato1.put("lvl7","0");
                                dato1.put("lvl8","0");
                                dato1.put("lvl9","0");
                                dato1.put("lvl10","0");
                            }else{
                                if(val.getKeyJ1()==11){
                                    dato.put("puestoN1",val.getKeyDuelista());
                                    dato.put("puestoN2",val.getKeyDuelista2());
                                    dato.put("puestoN3","esperando");
                                    dato.put("puestoN4","esperando");
                                    dato.put("puestoN5","esperando");
                                    dato.put("puestoN6","esperando");
                                    dato.put("puestoN7","esperando");
                                    dato.put("puestoN8","esperando");
                                    dato.put("puestoN9","esperando");
                                    dato.put("puestoN10","esperando");
                                    dato.put("puestoN11","esperando");
                                    dato.put("participante1", val.getKeyDuelista());
                                    dato.put("participante2", val.getKeyDuelista2());
                                    dato.put("participante3","esperando");
                                    dato.put("participante4", "esperando");
                                    dato.put("participante5", "esperando");
                                    dato.put("participante6", "esperando");
                                    dato.put("participante7", "esperando");
                                    dato.put("participante8", "esperando");
                                    dato.put("participante9", "esperando");
                                    dato.put("participante10", "esperando");
                                    dato.put("participante11", "esperando");

                                    dato1.put("participante1",val.getKeyDuelista());
                                    dato1.put("participante2",val.getKeyDuelista2());
                                    dato1.put("participante3","esperando");
                                    dato1.put("participante4","esperando");
                                    dato1.put("participante5","esperando");
                                    dato1.put("participante6","esperando");
                                    dato1.put("participante7","esperando");
                                    dato1.put("participante8","esperando");
                                    dato1.put("participante9","esperando");
                                    dato1.put("participante10","esperando");
                                    dato1.put("participante11","esperando");

                                    dato1.put("puesto1","esperando");
                                    dato1.put("puesto2","esperando");
                                    dato1.put("puesto3","esperando");
                                    dato1.put("puesto4","esperando");
                                    dato1.put("puesto5","esperando");
                                    dato1.put("puesto6","esperando");
                                    dato1.put("puesto7","esperando");
                                    dato1.put("puesto8","esperando");
                                    dato1.put("puesto9","esperando");
                                    dato1.put("puesto10","esperando");
                                    dato1.put("puesto11","esperando");

                                    dato1.put("lvl1","0");
                                    dato1.put("lvl2","0");
                                    dato1.put("lvl3","0");
                                    dato1.put("lvl4","0");
                                    dato1.put("lvl5","0");
                                    dato1.put("lvl6","0");
                                    dato1.put("lvl7","0");
                                    dato1.put("lvl8","0");
                                    dato1.put("lvl9","0");
                                    dato1.put("lvl10","0");
                                    dato1.put("lvl11","0");
                                }else{
                                    if(val.getKeyJ1()==12){
                                        dato.put("puestoN1",val.getKeyDuelista());
                                        dato.put("puestoN2",val.getKeyDuelista2());
                                        dato.put("puestoN3","esperando");
                                        dato.put("puestoN4","esperando");
                                        dato.put("puestoN5","esperando");
                                        dato.put("puestoN6","esperando");
                                        dato.put("puestoN7","esperando");
                                        dato.put("puestoN8","esperando");
                                        dato.put("puestoN9","esperando");
                                        dato.put("puestoN10","esperando");
                                        dato.put("puestoN11","esperando");
                                        dato.put("puestoN12","esperando");
                                        dato.put("participante1", val.getKeyDuelista());
                                        dato.put("participante2", val.getKeyDuelista2());
                                        dato.put("participante3","esperando");
                                        dato.put("participante4", "esperando");
                                        dato.put("participante5", "esperando");
                                        dato.put("participante6", "esperando");
                                        dato.put("participante7", "esperando");
                                        dato.put("participante8", "esperando");
                                        dato.put("participante9", "esperando");
                                        dato.put("participante10", "esperando");
                                        dato.put("participante11", "esperando");
                                        dato.put("participante12", "esperando");

                                        dato1.put("participante1",val.getKeyDuelista());
                                        dato1.put("participante2",val.getKeyDuelista2());
                                        dato1.put("participante3","esperando");
                                        dato1.put("participante4","esperando");
                                        dato1.put("participante5","esperando");
                                        dato1.put("participante6","esperando");
                                        dato1.put("participante7","esperando");
                                        dato1.put("participante8","esperando");
                                        dato1.put("participante9","esperando");
                                        dato1.put("participante10","esperando");
                                        dato1.put("participante11","esperando");
                                        dato1.put("participante12","esperando");

                                        dato1.put("puesto1","esperando");
                                        dato1.put("puesto2","esperando");
                                        dato1.put("puesto3","esperando");
                                        dato1.put("puesto4","esperando");
                                        dato1.put("puesto5","esperando");
                                        dato1.put("puesto6","esperando");
                                        dato1.put("puesto7","esperando");
                                        dato1.put("puesto8","esperando");
                                        dato1.put("puesto9","esperando");
                                        dato1.put("puesto10","esperando");
                                        dato1.put("puesto11","esperando");
                                        dato1.put("puesto12","esperando");

                                        dato1.put("lvl1","0");
                                        dato1.put("lvl2","0");
                                        dato1.put("lvl3","0");
                                        dato1.put("lvl4","0");
                                        dato1.put("lvl5","0");
                                        dato1.put("lvl6","0");
                                        dato1.put("lvl7","0");
                                        dato1.put("lvl8","0");
                                        dato1.put("lvl9","0");
                                        dato1.put("lvl10","0");
                                        dato1.put("lvl11","0");
                                        dato1.put("lvl12","0");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }



        bdNeutro.collection("BDcalabozo").document("tablaUpArqKuri"+val.getKeyCalabozoActivo()).set(dato1);
        bdNeutro.collection("BDcalabozo").document("UpArqKuri"+val.getKeyCalabozoActivo()).set(dato);

    }


}



