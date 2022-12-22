package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Stack;


public class atributos extends AppCompatActivity {



    private FirebaseFirestore bdNeutro;
    private ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    private Spinner sp1;
    Stack<String> idV1 = new Stack<>();
    RadioButton r1,r2;
    RadioGroup rd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos);

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

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
                        }
                    }}}}


        b1 = (ImageButton) findViewById(R.id.izquierda_b1);
        b2 =(ImageButton) findViewById(R.id.tesla_b2);
        b3 =(ImageButton) findViewById(R.id.tesla_b3);
        b4 =(ImageButton) findViewById(R.id.tesla_b4);
        b5 =(ImageButton) findViewById(R.id.tesla_b5);
        b6 =(ImageButton) findViewById(R.id.tesla_b6);

        b7 =(ImageButton) findViewById(R.id.atributos_piesa1);
        b8 =(ImageButton) findViewById(R.id.atributos_piesa2);
        b9 =(ImageButton) findViewById(R.id.atributos_piesa3);
        b10 =(ImageButton) findViewById(R.id.atributos_piesa4);
        b11 =(ImageButton) findViewById(R.id.atributos_piesa5);
        b12 =(ImageButton) findViewById(R.id.atributos_piesa6);

        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);

        b7.setVisibility(View.GONE);
        b8.setVisibility(View.GONE);
        b9.setVisibility(View.GONE);
        b10.setVisibility(View.GONE);
        b11.setVisibility(View.GONE);
        b12.setVisibility(View.GONE);

        r1 = (RadioButton) findViewById(R.id.eventoN1_r1);
        r2 = (RadioButton) findViewById(R.id.eventoN1_r2);
        rd1 =(RadioGroup) findViewById(R.id.atributo_grupo_rd);

        sp1 = (Spinner) findViewById(R.id.eventoN1_sp1);
if(idV1.size() == 0){

}else{
   idV1.clear();
}
try {
    bdNeutro.collection("EventoTesla").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {

            if (task.isSuccessful()) {
                ArrayAdapter<String> datos = null;
                idV1.add("Elija al rival");
                for (QueryDocumentSnapshot document : task.getResult()) {

                    val.setKeyDuelista(document.getString("nick"));

                    idV1.add(val.getKeyDuelista());
                }

                datos = new ArrayAdapter<>(getApplication(), R.layout.spiner_jornada_random, idV1);
                sp1.setAdapter(datos);
            }
        }
    });
}catch (Exception sdfs){

}





  bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
  @Override
  public void onSuccess(DocumentSnapshot documentSnapshot) {

   if(documentSnapshot.exists()){

       val.setKeyTeslaLlave1(documentSnapshot.getString("ficha1"));
       val.setKeyTeslaLlave2(documentSnapshot.getString("ficha2"));
       val.setKeyTeslaLlave13(documentSnapshot.getString("ficha3"));
       val.setKeyTeslaLlave4(documentSnapshot.getString("ficha4"));
       val.setKeyTeslaLlave5(documentSnapshot.getString("ficha5"));
       val.setKeyTeslaLlave6(documentSnapshot.getString("ficha6"));

       if(val.getKeyTeslaLlave1().contains("true")){ b1.setVisibility(View.VISIBLE);}
       if(val.getKeyTeslaLlave2().contains("true")){b2.setVisibility(View.VISIBLE);}
       if(val.getKeyTeslaLlave4().contains("true")){b4.setVisibility(View.VISIBLE);}
       if(val.getKeyTeslaLlave5().contains("true")){b5.setVisibility(View.VISIBLE);}
       if(val.getKeyTeslaLlave6().contains("true")){b6.setVisibility(View.VISIBLE);}
       if(val.getKeyTeslaLlave13().contains("true")){b3.setVisibility(View.VISIBLE);}



       if(val.getKeyTeslaLlave1().contains("true")&&val.getKeyTeslaLlave2().contains("true")&&
               val.getKeyTeslaLlave13().contains("true")&&val.getKeyTeslaLlave4().contains("true")&&val.getKeyTeslaLlave5().contains("true")
       ){



           try {

               bdNeutro.collection("BDsalonEventoTesla").whereEqualTo("proceso","ejecucion").get()
                       .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                           @Override
                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
                               if(task.isSuccessful()) {
                                   for (QueryDocumentSnapshot document : task.getResult()) {


                                       val.setKeyExiste(document.getString("proceso"));


                                   }

                              if(val.getKeyExiste().equals("ejecucion")){

                        Toast.makeText(getApplicationContext(), "Evento en su etapa final", Toast.LENGTH_SHORT).show();
                    }else{
                        HashMap<String, Object> dato = new HashMap<>();
                        Toast.makeText(getApplicationContext(), "Cargando el contenido.", Toast.LENGTH_SHORT).show();
                        dato.put("evento", "0");
                        dato.put("ganador1", "null");
                        dato.put("ganador2", "null");
                        dato.put("ganador3", "null");
                        dato.put("proceso", "ejecucion");

                        bdNeutro.collection("BDsalonEventoTesla").document("info").set(dato);
                    }




                               }
                           }
                       });



           }catch (Exception sdfs){}
       }

   if(val.getKeyTeslaLlave1().contains("true")&&val.getKeyTeslaLlave2().contains("true")&&
   val.getKeyTeslaLlave13().contains("true")&&val.getKeyTeslaLlave4().contains("true")&&val.getKeyTeslaLlave5().contains("true")
   &&val.getKeyTeslaLlave6().contains("true")
   ){
   bdNeutro.collection("BDsalonEventoTesla").whereEqualTo("proceso","ejecucion")

   .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
   @Override
   public void onComplete(@NonNull Task<QuerySnapshot> task) {
   if(task.isSuccessful()) {

   HashMap<String, Object> dato = new HashMap<>();

   for (QueryDocumentSnapshot document : task.getResult()) {
   val.setKeyId1(document.getString("evento"));

   val.setKeyGanadorTesla1(document.getString("ganador1"));
       val.setKeyGanadorTesla2(document.getString("ganador2"));
       val.setKeyGanadorTesla3(document.getString("ganador3"));

}
      if(val.getKeyGanadorTesla1().equals(val.getKeyNick())){
      val.setKeyRemitente2("fin");
}else{
      if(val.getKeyGanadorTesla2().equals(val.getKeyNick())){
          val.setKeyRemitente2("fin");
} else{
      if(val.getKeyGanadorTesla3().equals(val.getKeyNick())){
          val.setKeyRemitente2("fin");
 }else{
          val.setKeyJ1(Integer.parseInt(val.getKeyId1()));
          if(val.getKeyJ1() == 0){
              val.setKeyId1("1");
              dato.put("ganador1", val.getKeyNick());
          }else{
              if(val.getKeyJ1() == 1){
                  val.setKeyId1("2");
                  dato.put("ganador2", val.getKeyNick());
              }else{
                  if(val.getKeyJ1() == 2){
                      val.setKeyId1("3");
                      dato.put("ganador3", val.getKeyNick());
                      dato.put("proceso", "finalizado");
                  }else{
                      if(val.getKeyJ1() == 3){
                          val.setKeyJ1(4);

                          Toast.makeText(getApplicationContext(), "solo hay 3 cupos y ya fueron utilizados", Toast.LENGTH_SHORT).show();
                      }}} }

          if(val.getKeyJ1()>3){}else {
              Toast.makeText(getApplicationContext(), "Enviadno informacion del ganador.", Toast.LENGTH_SHORT).show();
              dato.put("evento", val.getKeyId1());
              bdNeutro.collection("BDsalonEventoTesla").document("info").update(dato);
          }
 }

}
}







  }

}
});

       }

} else{
if(val.getKeyIdGremio().equals("100")){
Toast.makeText(getApplicationContext(), "Creando contenido Evento Tesla.", Toast.LENGTH_SHORT).show();
crear();}else{
if(val.getKeyIdGremio().equals("1100")) {
Toast.makeText(getApplicationContext(), "Creando contenido Evento Tesla.", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyIdGremio().equals("2100")) {
Toast.makeText(getApplicationContext(), "Creando contenido Evento Tesla.", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyIdGremio().equals("3100")) {
Toast.makeText(getApplicationContext(), "Creando contenido Evento Tesla.", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyIdGremio().equals("4100")) {
Toast.makeText(getApplicationContext(), "Creando contenido Evento Tesla.", Toast.LENGTH_SHORT).show();
}
}
}
}
}


   }

}});

  sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

  val.setKeyDuelista(sp1.getSelectedItem().toString());
  if(val.getKeyDuelista().equals("Elija al rival")){


  }else{
  rd1.clearCheck();



      bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1())
              .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                  @Override
                  public void onSuccess(DocumentSnapshot documentSnapshot) {


if(val.getKeyRemitente2().equals("fin")){
    Toast.makeText(getApplicationContext(), "!CONGRRATULATIONS!", Toast.LENGTH_SHORT).show();
}else{
    val.setKeyRemitente1(documentSnapshot.getString("remitente"));
      if (val.getKeyRemitente1().equals("true")) {
          //deja elegir
          val.setKeyRemitente2("aprobado");
      } else {

          if (val.getKeyRemitente1().equals(val.getKeyDuelista())) {
              val.setKeyAviso1(documentSnapshot.getString("aviso1"));

              if (val.getKeyAviso1().equals("false")) {
                  val.setKeyRemitente2("concluido");
              } else {
                  if (val.getKeyAviso1().equals("Victoria")) {
                      val.setKeyRemitente2("Victoria");

                  } else {
                      if (val.getKeyAviso1().equals("Derrota")) {
                          val.setKeyRemitente2("Derrota");
                      }
                  }
              }
          } else {
              if (val.getKeyRemitente1().equals("novisto")) {
                  val.setKeyAviso1(documentSnapshot.getString("aviso1"));
                  Toast.makeText(getApplicationContext(), "A usted no le han contestado su solicitud que envio al rival:" + val.getKeyAviso1(), Toast.LENGTH_SHORT).show();
                  val.setKeyRemitente2("novisto");

              } else {
                  Toast.makeText(getApplicationContext(), "otro duelista le envio una soliciturd rival:" + val.getKeyRemitente1(), Toast.LENGTH_SHORT).show();
                  val.setKeyRemitente2("incorrecto");
              }
          }
      }
  }


  bdNeutro.collection("EventoTesla").whereEqualTo("nick", val.getKeyDuelista())
  .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
  @Override
  public void onComplete(@NonNull Task<QuerySnapshot> task) {

  if (task.isSuccessful()) {
  for (QueryDocumentSnapshot document : task.getResult()) {
 val.setKeyCodigo2(document.getString("codigo")); }





    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
      @Override
      public void onSuccess(DocumentSnapshot documentSnapshot) {

if(documentSnapshot.exists()) {

    b7.setVisibility(View.GONE);
    b8.setVisibility(View.GONE);
    b9.setVisibility(View.GONE);
    b10.setVisibility(View.GONE);
    b11.setVisibility(View.GONE);
    b12.setVisibility(View.GONE);

   val.setKeyFich1(documentSnapshot.getString("ficha1"));
   val.setKeyFich2(documentSnapshot.getString("ficha2"));
   val.setKeyFich3(documentSnapshot.getString("ficha3"));
   val.setKeyFich4(documentSnapshot.getString("ficha4"));
   val.setKeyFich5(documentSnapshot.getString("ficha5"));
   val.setKeyFich6(documentSnapshot.getString("ficha6"));


if(val.getKeyFich1().equals("true")){
b7.setVisibility(View.VISIBLE);
}
if(val.getKeyFich2().equals("true")){
b8.setVisibility(View.VISIBLE);
}
if(val.getKeyFich3().equals("true")){
b9.setVisibility(View.VISIBLE);
}
if(val.getKeyFich4().equals("true")){
b10.setVisibility(View.VISIBLE);
}
if(val.getKeyFich5().equals("true")){
b11.setVisibility(View.VISIBLE);
}

 if(val.getKeyFich6().equals("true")){
        b12.setVisibility(View.VISIBLE);

 }

 if(val.getKeyFich6().equals("true") && val.getKeyFich5().equals("true")&&val.getKeyFich4().equals("true")&&val.getKeyFich3().equals("true")

 &&val.getKeyFich2().equals("true")&&val.getKeyFich1().equals("true")){
     Toast.makeText(getApplicationContext(), "Este duelista no puede competir ", Toast.LENGTH_SHORT).show();
     val.setKeyRemitente2("fin");
 }







}

      }});


}

  } });

  }});
}

  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {

  }});



 r1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
if(sp1.getSelectedItem().toString().equals("Elija al rival")){

    Toast.makeText(getApplicationContext(), "No a elegido al rival", Toast.LENGTH_SHORT).show();

}else{
     if (r1.isChecked()) {

         val.setKeyAviso1(r1.getText().toString());
         if (val.getKeyRemitente2().contains("aprobado")) {
             if (val.getKeyAviso1().contains("Derrota")) {
                 Toast.makeText(getApplicationContext(), "No tificacion enviada al ganador.", Toast.LENGTH_SHORT).show();
                 victoria();
                 HashMap<String, Object> dato = new HashMap<>();
                 dato.put("remitente", val.getKeyNick());
                 dato.put("aviso1", "false");

                 bdNeutro.collection("EventoTesla").whereEqualTo("nick", val.getKeyDuelista())
                         .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                     @Override
                     public void onComplete(@NonNull Task<QuerySnapshot> task) {

                         if (task.isSuccessful()) {
                             for (QueryDocumentSnapshot document : task.getResult()) {

                                 val.setKeyCodigo2(document.getString("codigo"));

                             }
                             bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);//codigo remitente falta

                         }
                     }
                 });


             } else {

             }

             HashMap<String, Object> dato = new HashMap<>();
             dato.put("remitente", val.getKeyDuelista());

         } else {
             if (val.getKeyRemitente2().contains("Derrota")) {


                 Toast.makeText(getApplicationContext(), "Debe seleccionar la opcion de VICTORIA ", Toast.LENGTH_SHORT).show();
                 Toast.makeText(getApplicationContext(), "Si no esta deacuerdo mande evidencia  a su lider.", Toast.LENGTH_SHORT).show();
             } else {
                 if (val.getKeyRemitente2().contains("Victoria")) {
                     Toast.makeText(getApplicationContext(), "Proceso de eleccion victoria", Toast.LENGTH_SHORT).show();
                     //opcion derrota
                     //espacion confirmaco su derrota

                     HashMap<String, Object> dato = new HashMap<>();
                     dato.put("remitente", "true");
                     dato.put("aviso1", "true");
                     bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato);//codigo remitente falta


                     bdNeutro.collection("EventoTesla").whereEqualTo("nick", val.getKeyDuelista())
                             .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                         @Override
                         public void onComplete(@NonNull Task<QuerySnapshot> task) {

                             if (task.isSuccessful()) {
                                 for (QueryDocumentSnapshot document : task.getResult()) {

                                     val.setKeyCodigo2(document.getString("codigo"));

                                 }


                                 HashMap<String, Object> dato = new HashMap<>();
                                 dato.put("remitente", "true");
                                 dato.put("aviso1", "true");
                                 bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);//codigo remitente falta
                                 Toast.makeText(getApplicationContext(), "Inicicado traslado de parte exodia", Toast.LENGTH_SHORT).show();
                                 victoria();
                             }
                         }
                     });


                 } else {

                     if (val.getKeyRemitente2().contains("incorrecto")) {
                         Toast.makeText(getApplicationContext(), "No selecciono el jugador correcto ", Toast.LENGTH_SHORT).show();
                     } else {
                         if (val.getKeyRemitente2().contains("concluido")) {
                             Toast.makeText(getApplicationContext(), "Esta opcion no es la conrrecta debe seleccionar victoria", Toast.LENGTH_SHORT).show();
                         } else {
                             if (val.getKeyRemitente2().contains("novisto")) {
                                 Toast.makeText(getApplicationContext(), "El rival no aceptado su solicitud. porfavor espere..", Toast.LENGTH_SHORT).show();
                             }else{
                                 if (val.getKeyRemitente2().contains("fin")) {
                                     Toast.makeText(getApplicationContext(), "Este duelista ya finalizo ele evento busque otro.", Toast.LENGTH_SHORT).show();
                                 }


                             }
                         }
                     }
                 }
             }

         }


     }
 }
 });

        r2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
            if(sp1.getSelectedItem().toString().equals("Elija al rival")){

                Toast.makeText(getApplicationContext(), "No a elegido al rival", Toast.LENGTH_SHORT).show();

            }else{
            if (r2.isChecked()) {

                val.setKeyAviso1(r2.getText().toString());

                if (val.getKeyRemitente2().contains("aprobado")) {

                    HashMap<String, Object> dato = new HashMap<>();
                    dato.put("remitente", val.getKeyNick());
                    dato.put("aviso1", val.getKeyAviso1());

                    HashMap<String, Object> dato2 = new HashMap<>();
                    dato2.put("remitente", "novisto");
                    dato2.put("aviso1", val.getKeyDuelista());
                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);

                    bdNeutro.collection("EventoTesla").whereEqualTo("nick", val.getKeyDuelista())
                            .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    val.setKeyCodigo2(document.getString("codigo"));

                                }
                                Toast.makeText(getApplicationContext(), "Notificacion enviada.", Toast.LENGTH_SHORT).show();
                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);//codigo remitente falta
                            }
                        }
                    });


                } else {
                    if (val.getKeyRemitente2().contains("Victoria")) {

                        Toast.makeText(getApplicationContext(), "El rival le envio Victoria usted debe marcar Derrota", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "Si no esta deacuerdo mande evidencia  a su lider ", Toast.LENGTH_SHORT).show();

                    } else {
                        if (val.getKeyRemitente2().contains("Derrota")) {
                            Toast.makeText(getApplicationContext(), "Debe seleccionar el boton de DERROTA segun la solicitud enviada", Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Si no esta deacuerdo mande evidencia  a su lider ", Toast.LENGTH_SHORT).show();
                        } else {
                            if (val.getKeyRemitente2().contains("concluido")) {
                                Toast.makeText(getApplicationContext(), "El rival ya confirmo su derrota Pieza ya traslada.", Toast.LENGTH_SHORT).show();
                                HashMap<String, Object> dato = new HashMap<>();
                                dato.put("remitente", "true");
                                dato.put("aviso1", "true");

                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato);
                            } else {
                                if (val.getKeyRemitente2().contains("incorrecto")) {
                                    Toast.makeText(getApplicationContext(), "No selecciono el jugador correcto", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (val.getKeyRemitente2().contains("novisto")) {
                                        Toast.makeText(getApplicationContext(), "El rival no aceptado su solicitud. porfavor espere..", Toast.LENGTH_SHORT).show();
                                    }else{
                                        if (val.getKeyRemitente2().contains("fin")) {
                                            Toast.makeText(getApplicationContext(), "Este duelista ya finalizo ele evento busque otro.", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                }

                            }

                        }
                    }
                }
            }
        }
        }); }

   public void victoria(){
   contexto val = new contexto();
   bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override public void onSuccess(DocumentSnapshot documentSnapshot) {

  val.setKeyTeslaLlave1(documentSnapshot.getString("ficha1"));val.setKeyTeslaLlave1(documentSnapshot.getString("ficha2"));val.setKeyTeslaLlave1(documentSnapshot.getString("ficha3"));val.setKeyTeslaLlave1(documentSnapshot.getString("ficha4"));val.setKeyTeslaLlave1(documentSnapshot.getString("ficha5"));val.setKeyTeslaLlave1(documentSnapshot.getString("ficha6"));
//si el perdedor tiene la ficha 1 true dentro preguntara si el perdedor la tiene si la tiene se pregusntara por las demas llaves hasta estar deacurdo


  if(val.getKeyTeslaLlave1().contains("true")){ primeraFicha();

  }else{//inicio de la segunda llave
  if(val.getKeyTeslaLlave2().contains("true")){ segundaFicha();
  }else{
  if(val.getKeyTeslaLlave4().contains("true")){ cuartaFicha();
  }else{
  if(val.getKeyTeslaLlave5().contains("true")){ quintaFicha();
  }else{
  if(val.getKeyTeslaLlave6().contains("true")){ sestaFicha();
  }else{
  if(val.getKeyTeslaLlave13().contains("true")){ terceraFicha();
} } } } } }

  }


 });
 }

 public void primeraFicha(){
        contexto val = new contexto();
     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
         @Override public void onSuccess(DocumentSnapshot documentSnapshot) {
             if(documentSnapshot.exists()){

                 val.setKeyFicha1(documentSnapshot.getString("ficha1"));
                 if(val.getKeyFicha1().contains("true")){
                     val.setKeyFicha2(documentSnapshot.getString("ficha2"));

                     if(val.getKeyFicha2().contains("true")){
                         val.setKeyFicha3(documentSnapshot.getString("ficha3"));

                         if(val.getKeyFicha3().contains("true")){
                             val.setKeyFicha4(documentSnapshot.getString("ficha4"));

                             if(val.getKeyFicha4().contains("true")){
                                 val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                                 if(val.getKeyFicha5().contains("true")){
                                     val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                                     if(val.getKeyFicha6().contains("true")){

//gano
                                     }else{
                                         if(val.getKeyTeslaLlave6().contains("true")){//si la tiene la puede dar
                                             HashMap <String, Object> dato = new HashMap<>();
                                             dato.put("ficha6","true");
                                             bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                             HashMap <String, Object> dato2 = new HashMap<>();
                                             dato2.put("ficha6","false");
                                             bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                         }else{
                                             Toast.makeText(getApplicationContext(), "El jugador no tiene fichas para dar", Toast.LENGTH_SHORT).show();
                                         }
//fin de la ficha 5
                                     }}else{//puede dar la ficha5
                                     if(val.getKeyTeslaLlave5().contains("true")){//si la tiene la puede dar
                                         HashMap <String, Object> dato = new HashMap<>();
                                         dato.put("ficha5","true");
                                         bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                         HashMap <String, Object> dato2 = new HashMap<>();
                                         dato2.put("ficha5","false");
                                         bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                     }else{
                                         if(val.getKeyTeslaLlave6().contains("true")){
                                             val.setKeyFicha6(documentSnapshot.getString("ficha6"));
                                             if(val.getKeyFicha6().contains("true")){
                                             }else{
                                                 HashMap <String, Object> dato = new HashMap<>();
                                                 dato.put("ficha6","true");
                                                 bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                                 HashMap <String, Object> dato2 = new HashMap<>();
                                                 dato2.put("ficha6","false");
                                                 bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                             }}}
                                     //fin de la ficha 5
                                 }}else{
                                 // el ganador no tiene la ficha4
                                 if(val.getKeyTeslaLlave4().contains("true")){//si la tiene la puede dar
                                     HashMap <String, Object> dato = new HashMap<>();
                                     dato.put("ficha4","true");
                                     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                     HashMap <String, Object> dato2 = new HashMap<>();
                                     dato2.put("ficha4","false");
                                     bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                 }else{
                                     if(val.getKeyTeslaLlave5().contains("true")){

                                         val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                                         if(val.getKeyFicha5().contains("true")){

                                             if(val.getKeyTeslaLlave6().contains("true")) {
                                                 val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                                                 if(val.getKeyFicha6().contains("true")) {


                                                 }else{
                                                     HashMap <String, Object> dato = new HashMap<>();
                                                     dato.put("ficha6","true");
                                                     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                     HashMap <String, Object> dato2 = new HashMap<>();
                                                     dato2.put("ficha6","false");
                                                     bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                                 } }
                                         }else{
                                             HashMap <String, Object> dato = new HashMap<>();
                                             dato.put("ficha5","true");
                                             bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                             HashMap <String, Object> dato2 = new HashMap<>();
                                             dato2.put("ficha5","false");
                                             bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                         }}}
                                 //fin de la ficha 4
                             }}else{
                             //no tiene la ficha 3 confirmar si el perdedor la puede dar
                             if(val.getKeyTeslaLlave13().contains("true")){//si la tiene la puede dar
                                 HashMap <String, Object> dato = new HashMap<>();
                                 dato.put("ficha2","true");
                                 bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                 HashMap <String, Object> dato2 = new HashMap<>();
                                 dato2.put("ficha2","false");
                                 bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                             }else{
                                 if(val.getKeyTeslaLlave4().contains("true")){

                                     val.setKeyFicha4(documentSnapshot.getString("ficha3"));

                                     if(val.getKeyFicha4().contains("true")){

                                         if(val.getKeyTeslaLlave5().contains("true")) {
                                             val.setKeyFicha5(documentSnapshot.getString("ficha4"));

                                             if(val.getKeyFicha5().contains("true")) {
                                                 if(val.getKeyTeslaLlave6().contains("true")) {
                                                     val.setKeyFicha6(documentSnapshot.getString("ficha5"));
                                                     if(val.getKeyFicha6().contains("true")) {

                                                     } else{
                                                         HashMap <String, Object> dato = new HashMap<>();
                                                         dato.put("ficha6","true");
                                                         bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                         HashMap <String, Object> dato2 = new HashMap<>();
                                                         dato2.put("ficha6","false");
                                                         bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                                     }}
                                             }else{
                                                 HashMap <String, Object> dato = new HashMap<>();
                                                 dato.put("ficha5","true");
                                                 bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                 HashMap <String, Object> dato2 = new HashMap<>();
                                                 dato2.put("ficha5","false");
                                                 bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);

                                             }
                                         }



                                     }else{
                                         HashMap <String, Object> dato = new HashMap<>();
                                         dato.put("ficha4","true");
                                         bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                         HashMap <String, Object> dato2 = new HashMap<>();
                                         dato2.put("ficha4","false");
                                         bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                     }}}
                             ////fin ficha3
                         }


                     }else{
                         //ficha2 ganador

                         if(val.getKeyTeslaLlave2().contains("true")){//si la tiene la puede dar
                             HashMap <String, Object> dato = new HashMap<>();
                             dato.put("ficha2","true");
                             bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                             HashMap <String, Object> dato2 = new HashMap<>();
                             dato2.put("ficha2","false");
                             bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                         }else{
                             if(val.getKeyTeslaLlave13().contains("true")){

                                 val.setKeyFicha3(documentSnapshot.getString("ficha3"));

                                 if(val.getKeyFicha3().contains("true")){

                                     if(val.getKeyTeslaLlave4().contains("true")) {
                                         val.setKeyFicha4(documentSnapshot.getString("ficha4"));

                                         if(val.getKeyFicha5().contains("true")) {
                                             if(val.getKeyTeslaLlave5().contains("true")) {
                                                 val.setKeyFicha5(documentSnapshot.getString("ficha5"));
                                                 if(val.getKeyFicha5().contains("true")) {

                                                     if(val.getKeyTeslaLlave6().contains("true")) {
                                                         val.setKeyFicha6(documentSnapshot.getString("ficha6"));
                                                         if(val.getKeyFicha6().contains("true")) {
                                                             Toast.makeText(getApplicationContext(), "HAS COMPLETADO TODAS LAS FICHAS", Toast.LENGTH_SHORT).show();
                                                         }else{
                                                             HashMap <String, Object> dato = new HashMap<>();
                                                             dato.put("ficha6","true");
                                                             bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                             HashMap <String, Object> dato2 = new HashMap<>();
                                                             dato2.put("ficha6","false");
                                                             bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2); } } } else{

                                                     HashMap <String, Object> dato = new HashMap<>();
                                                     dato.put("ficha5","true");
                                                     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                     HashMap <String, Object> dato2 = new HashMap<>();
                                                     dato2.put("ficha5","false");
                                                     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato2);
                                                 } } }else{
                                             HashMap <String, Object> dato = new HashMap<>();
                                             dato.put("ficha4","true");
                                             bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                             HashMap <String, Object> dato2 = new HashMap<>();
                                             dato2.put("ficha4","false");
                                             bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                         } }}else{
                                     HashMap <String, Object> dato = new HashMap<>();
                                     dato.put("ficha3","true");
                                     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                     HashMap <String, Object> dato2 = new HashMap<>();
                                     dato2.put("ficha3","false");
                                     bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);

                                 } } } } }else{

                     HashMap <String, Object> dato = new HashMap<>();
                     dato.put("ficha1","true");
                     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                     HashMap <String, Object> dato2 = new HashMap<>();
                     dato2.put("ficha1","false");
                     bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);}}}});

//finc de la primera llave
 }

 public void segundaFicha(){
        contexto val = new contexto();
     val.setKeyDuelista(sp1.getSelectedItem().toString());
    //al gandador
     bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
     @Override public void onSuccess(DocumentSnapshot documentSnapshot) {
     if(documentSnapshot.exists()){

     val.setKeyFicha2(documentSnapshot.getString("ficha2"));
     if(val.getKeyFicha2().equals("true")){
     val.setKeyFicha3(documentSnapshot.getString("ficha3"));

    if(val.getKeyFicha3().contains("true")){ val.setKeyFicha4(documentSnapshot.getString("ficha4"));

    if(val.getKeyFicha4().contains("true")){ val.setKeyFicha5(documentSnapshot.getString("ficha5"));

    if(val.getKeyFicha5().contains("true")){val.setKeyFicha6(documentSnapshot.getString("ficha6"));

    if(val.getKeyFicha6().contains("true")){
    }else{
                                            if(val.getKeyTeslaLlave6().contains("true")){//si la tiene la puede dar
                                                HashMap <String, Object> dato = new HashMap<>();
                                                dato.put("ficha6","true");
                                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                HashMap <String, Object> dato2 = new HashMap<>();
                                                dato2.put("ficha6","false");
                                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                            }else{
                                                Toast.makeText(getApplicationContext(), "El jugador no tiene fichas para dar", Toast.LENGTH_SHORT).show();
                                            }
//fin de la ficha 5
                                        }}else{//puede dar la ficha5
                                        if(val.getKeyTeslaLlave5().contains("true")){//si la tiene la puede dar
                                            HashMap <String, Object> dato = new HashMap<>();
                                            dato.put("ficha5","true");
                                            bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                            HashMap <String, Object> dato2 = new HashMap<>();
                                            dato2.put("ficha5","false");
                                            bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                        }else{
                                            if(val.getKeyTeslaLlave6().contains("true")){
                                                val.setKeyFicha6(documentSnapshot.getString("ficha6"));
                                                if(val.getKeyFicha6().contains("true")){
                                                }else{
                                                    HashMap <String, Object> dato = new HashMap<>();
                                                    dato.put("ficha6","true");
                                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                                    HashMap <String, Object> dato2 = new HashMap<>();
                                                    dato2.put("ficha6","false");
                                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                                }}}
                                        //fin de la ficha 5
                                    }}else{
                                    // el ganador no tiene la ficha4
                                    if(val.getKeyTeslaLlave4().contains("true")){//si la tiene la puede dar
                                        HashMap <String, Object> dato = new HashMap<>();
                                        dato.put("ficha4","true");
                                        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                        HashMap <String, Object> dato2 = new HashMap<>();
                                        dato2.put("ficha4","false");
                                        bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                    }else{
                                        if(val.getKeyTeslaLlave5().contains("true")){

                                            val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                                            if(val.getKeyFicha5().contains("true")){

                                                if(val.getKeyTeslaLlave6().contains("true")) {
                                                    val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                                                    if(val.getKeyFicha6().contains("true")) {


                                                    }else{
                                                        HashMap <String, Object> dato = new HashMap<>();
                                                        dato.put("ficha6","true");
                                                        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                        HashMap <String, Object> dato2 = new HashMap<>();
                                                        dato2.put("ficha6","false");
                                                        bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                                    } }
                                            }else{
                                                HashMap <String, Object> dato = new HashMap<>();
                                                dato.put("ficha5","true");
                                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                                HashMap <String, Object> dato2 = new HashMap<>();
                                                dato2.put("ficha5","false");
                                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                            }}}
                                    //fin de la ficha 4
                                }}else{
                                //no tiene la ficha 3 confirmar si el perdedor la puede dar
                                if(val.getKeyTeslaLlave13().contains("true")){//si la tiene la puede dar
                                    HashMap <String, Object> dato = new HashMap<>();
                                    dato.put("ficha2","true");
                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                    HashMap <String, Object> dato2 = new HashMap<>();
                                    dato2.put("ficha2","false");
                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                }else{
                                    if(val.getKeyTeslaLlave4().contains("true")){

                                        val.setKeyFicha4(documentSnapshot.getString("ficha3"));

                                        if(val.getKeyFicha4().contains("true")){

                                            if(val.getKeyTeslaLlave5().contains("true")) {
                                                val.setKeyFicha5(documentSnapshot.getString("ficha4"));

                                                if(val.getKeyFicha5().contains("true")) {
                                                    if(val.getKeyTeslaLlave6().contains("true")) {
                                                        val.setKeyFicha6(documentSnapshot.getString("ficha5"));
                                                        if(val.getKeyFicha6().contains("true")) {

                                                        } else{
                                                            HashMap <String, Object> dato = new HashMap<>();
                                                            dato.put("ficha6","true");
                                                            bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                            HashMap <String, Object> dato2 = new HashMap<>();
                                                            dato2.put("ficha6","false");
                                                            bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                                        }}
                                                }else{
                                                    HashMap <String, Object> dato = new HashMap<>();
                                                    dato.put("ficha5","true");
                                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                    HashMap <String, Object> dato2 = new HashMap<>();
                                                    dato2.put("ficha5","false");
                                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);

                                                }
                                            }



    }else{
    HashMap <String, Object> dato = new HashMap<>();
    dato.put("ficha4","true");
    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

    HashMap <String, Object> dato2 = new HashMap<>();
    dato2.put("ficha4","false");
    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
    }}}
   ////fin ficha3
   } }else{
                            //ficha2 ganador
         HashMap <String, Object> dato = new HashMap<>();
         dato.put("ficha2","true");
         bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

         HashMap <String, Object> dato2 = new HashMap<>();
         dato2.put("ficha2","false");
         bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);}}}});}

 public void terceraFicha(){
        contexto val = new contexto();
        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override public void onSuccess(DocumentSnapshot documentSnapshot) {
   if(documentSnapshot.exists()){


    val.setKeyFicha3(documentSnapshot.getString("ficha3"));
    if(val.getKeyFicha3().contains("true")){
    val.setKeyFicha4(documentSnapshot.getString("ficha4"));

    if(val.getKeyFicha4().contains("true")){
    val.setKeyFicha5(documentSnapshot.getString("ficha5"));

    if(val.getKeyFicha5().contains("true")){
    val.setKeyFicha6(documentSnapshot.getString("ficha6"));

    if(val.getKeyFicha6().contains("true")){

//gano
   }else{
   if(val.getKeyTeslaLlave6().contains("true")){//si la tiene la puede dar
                                            HashMap <String, Object> dato = new HashMap<>();
                                            dato.put("ficha6","true");
                                            bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                            HashMap <String, Object> dato2 = new HashMap<>();
                                            dato2.put("ficha6","false");
                                            bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                        }else{
                                            Toast.makeText(getApplicationContext(), "El jugador no tiene fichas para dar", Toast.LENGTH_SHORT).show();
                                        }
//fin de la ficha 5
                                    }}else{//puede dar la ficha5
                                    if(val.getKeyTeslaLlave5().contains("true")){//si la tiene la puede dar
                                        HashMap <String, Object> dato = new HashMap<>();
                                        dato.put("ficha5","true");
                                        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                        HashMap <String, Object> dato2 = new HashMap<>();
                                        dato2.put("ficha5","false");
                                        bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                    }else{
                                        if(val.getKeyTeslaLlave6().contains("true")){
                                            val.setKeyFicha6(documentSnapshot.getString("ficha6"));
                                            if(val.getKeyFicha6().contains("true")){
                                            }else{
                                                HashMap <String, Object> dato = new HashMap<>();
                                                dato.put("ficha6","true");
                                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                                HashMap <String, Object> dato2 = new HashMap<>();
                                                dato2.put("ficha6","false");
                                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                            }}}
                                    //fin de la ficha 5
                                }}else{
                                // el ganador no tiene la ficha4
                                if(val.getKeyTeslaLlave4().contains("true")){//si la tiene la puede dar
                                    HashMap <String, Object> dato = new HashMap<>();
                                    dato.put("ficha4","true");
                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                    HashMap <String, Object> dato2 = new HashMap<>();
                                    dato2.put("ficha4","false");
                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                }else{
                                    if(val.getKeyTeslaLlave5().contains("true")){

                                        val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                                        if(val.getKeyFicha5().contains("true")){

                                            if(val.getKeyTeslaLlave6().contains("true")) {
                                                val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                                                if(val.getKeyFicha6().contains("true")) {


                                                }else{
                                                    HashMap <String, Object> dato = new HashMap<>();
                                                    dato.put("ficha6","true");
                                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                    HashMap <String, Object> dato2 = new HashMap<>();
                                                    dato2.put("ficha6","false");
                                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                                } }
                                        }else{
                                            HashMap <String, Object> dato = new HashMap<>();
                                            dato.put("ficha5","true");
                                            bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                            HashMap <String, Object> dato2 = new HashMap<>();
                                            dato2.put("ficha5","false");
                                            bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                        }}}
                                //fin de la ficha 4
                            }
    }else{
                            //no tiene la ficha 3 confirmar si el perdedor la puede dar
   if(val.getKeyTeslaLlave13().contains("true")){//si la tiene la puede dar

    HashMap <String, Object> dato = new HashMap<>();
    dato.put("ficha3","true");
    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

   HashMap <String, Object> dato2 = new HashMap<>();
   dato2.put("ficha3","false");
   bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
       Toast.makeText(getApplicationContext(), "Setraslado parte 3 exodia", Toast.LENGTH_SHORT).show();
   }
 ////fin ficha3
  }}}});

//finc de la primera llave
    }


 public void cuartaFicha(){
        contexto val = new contexto();
        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){





                        val.setKeyFicha4(documentSnapshot.getString("ficha4"));

                        if(val.getKeyFicha4().contains("true")){
                            val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                            if(val.getKeyFicha5().contains("true")){
                                val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                                if(val.getKeyFicha6().contains("true")){

//gano
                                }else{
                                    if(val.getKeyTeslaLlave6().contains("true")){//si la tiene la puede dar
                                        HashMap <String, Object> dato = new HashMap<>();
                                        dato.put("ficha6","true");
                                        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                        HashMap <String, Object> dato2 = new HashMap<>();
                                        dato2.put("ficha6","false");
                                        bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                    }else{
                                        Toast.makeText(getApplicationContext(), "El jugador no tiene fichas para dar", Toast.LENGTH_SHORT).show();
                                    }
//fin de la ficha 5
                                }}else{//puede dar la ficha5
                                if(val.getKeyTeslaLlave5().contains("true")){//si la tiene la puede dar
                                    HashMap <String, Object> dato = new HashMap<>();
                                    dato.put("ficha5","true");
                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                    HashMap <String, Object> dato2 = new HashMap<>();
                                    dato2.put("ficha5","false");
                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                }else{
                                    if(val.getKeyTeslaLlave6().contains("true")){
                                        val.setKeyFicha6(documentSnapshot.getString("ficha6"));
                                        if(val.getKeyFicha6().contains("true")){
                                        }else{
                                            HashMap <String, Object> dato = new HashMap<>();
                                            dato.put("ficha6","true");
                                            bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                            HashMap <String, Object> dato2 = new HashMap<>();
                                            dato2.put("ficha6","false");
                                            bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                        }}}
                                //fin de la ficha 5
                            }}else{
                            // el ganador no tiene la ficha4
                            if(val.getKeyTeslaLlave4().contains("true")){//si la tiene la puede dar
                                HashMap <String, Object> dato = new HashMap<>();
                                dato.put("ficha4","true");
                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                HashMap <String, Object> dato2 = new HashMap<>();
                                dato2.put("ficha4","false");
                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                            }else{
                                if(val.getKeyTeslaLlave5().contains("true")){

                                    val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                                    if(val.getKeyFicha5().contains("true")){

                                        if(val.getKeyTeslaLlave6().contains("true")) {
                                            val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                                            if(val.getKeyFicha6().contains("true")) {


                                            }else{
                                                HashMap <String, Object> dato = new HashMap<>();
                                                dato.put("ficha6","true");
                                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                                HashMap <String, Object> dato2 = new HashMap<>();
                                                dato2.put("ficha6","false");
                                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                            } }
                                    }else{
                                        HashMap <String, Object> dato = new HashMap<>();
                                        dato.put("ficha5","true");
                                        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                        HashMap <String, Object> dato2 = new HashMap<>();
                                        dato2.put("ficha5","false");
                                        bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                    }}}
                            //fin de la ficha 4
                        }




                }}});

//finc de la primera llave
    }

 public void quintaFicha(){
        contexto val = new contexto();
        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){

                        val.setKeyFicha5(documentSnapshot.getString("ficha5"));

                        if(val.getKeyFicha5().contains("true")){
                            val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                            if(val.getKeyFicha6().contains("true")){

//gano
                            }else{
                                if(val.getKeyTeslaLlave6().contains("true")){//si la tiene la puede dar
                                    HashMap <String, Object> dato = new HashMap<>();
                                    dato.put("ficha6","true");
                                    bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                    HashMap <String, Object> dato2 = new HashMap<>();
                                    dato2.put("ficha6","false");
                                    bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                }else{
                                    Toast.makeText(getApplicationContext(), "El jugador no tiene fichas para dar", Toast.LENGTH_SHORT).show();
                                }
//fin de la ficha 5
                            }}else{//puede dar la ficha5
                            if(val.getKeyTeslaLlave5().contains("true")){//si la tiene la puede dar
                                HashMap <String, Object> dato = new HashMap<>();
                                dato.put("ficha5","true");
                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                HashMap <String, Object> dato2 = new HashMap<>();
                                dato2.put("ficha5","false");
                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                            }else{
                                if(val.getKeyTeslaLlave6().contains("true")){
                                    val.setKeyFicha6(documentSnapshot.getString("ficha6"));
                                    if(val.getKeyFicha6().contains("true")){
                                    }else{
                                        HashMap <String, Object> dato = new HashMap<>();
                                        dato.put("ficha6","true");
                                        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);
                                        HashMap <String, Object> dato2 = new HashMap<>();
                                        dato2.put("ficha6","false");
                                        bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                                    }}}
                            //fin de la ficha 5
                        }




                }}});

//finc de la primera llave
    }

 public void sestaFicha(){
        contexto val = new contexto();
        bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){






                        val.setKeyFicha6(documentSnapshot.getString("ficha6"));

                        if(val.getKeyFicha6().contains("true")){

//gano
                        }else{
                            if(val.getKeyTeslaLlave6().contains("true")){//si la tiene la puede dar
                                HashMap <String, Object> dato = new HashMap<>();
                                dato.put("ficha6","true");
                                bdNeutro.collection("EventoTesla").document(val.getKeyCodigo2()).update(dato);

                                HashMap <String, Object> dato2 = new HashMap<>();
                                dato2.put("ficha6","false");
                                bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).update(dato2);
                            }else{
                                                      }
//fin de la ficha 5
                        }




                }}});

//finc de la primera llave
    }

public void reglasTesla(View  sdfas) {
    contexto val = new contexto();



    Intent siguiente = new Intent(this, reglasTesla.class);
    siguiente.putExtra("nick", val.getKeyNick());
    siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
    siguiente.putExtra("standar", val.getKeySiguienteN2());
    startActivity(siguiente);

    /*

     val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));
     */

}



    public void crear(){
        contexto val = new contexto();

        HashMap<String, Object> dato = new HashMap<>();

        if(val.getSearKeyCodigo() >100 && val.getSearKeyCodigo() < 130){
        dato.put("ficha1","true");
            dato.put("ficha2","false");
            dato.put("ficha3","false");
            dato.put("ficha4","false");
            dato.put("ficha5","false");
            dato.put("ficha6","false");

        b1.setVisibility(View.VISIBLE);
            ;
            b3.setVisibility(View.GONE);
            b2.setVisibility(View.GONE);
            b4.setVisibility(View.GONE);
            b5.setVisibility(View.GONE);
            b6.setVisibility(View.GONE);

}else{

  if(val.getSearKeyCodigo() >130 && val.getSearKeyCodigo() < 145){
//B2

      dato.put("ficha2","true");
      dato.put("ficha3","false");
      dato.put("ficha1","false");
      b1.setVisibility(View.GONE);
      b2.setVisibility(View.VISIBLE);
      b3.setVisibility(View.GONE);
      b4.setVisibility(View.GONE);
      b5.setVisibility(View.GONE);
      b6.setVisibility(View.GONE);


      dato.put("ficha4","false");
      dato.put("ficha5","false");
      dato.put("ficha6","false");

}else{
 if(val.getSearKeyCodigo() >145 && val.getSearKeyCodigo() < 165){
//B3
     dato.put("ficha3","true");
     dato.put("ficha2","false");

     dato.put("ficha1","false");

     dato.put("ficha4","false");
     dato.put("ficha5","false");
     dato.put("ficha6","false");
     b1.setVisibility(View.GONE);
     b2.setVisibility(View.GONE);
     b3.setVisibility(View.VISIBLE);
     b4.setVisibility(View.GONE);
     b5.setVisibility(View.GONE);
     b6.setVisibility(View.GONE);


 }else{
 if(val.getSearKeyCodigo() >165 && val.getSearKeyCodigo() < 180){
//B4
     dato.put("ficha4","true");
     dato.put("ficha2","false");
     dato.put("ficha3","false");
     dato.put("ficha1","false");
     dato.put("ficha5","false");
     dato.put("ficha6","false");


     b4.setVisibility(View.VISIBLE);
     b2.setVisibility(View.GONE);
     b3.setVisibility(View.GONE);
     b5.setVisibility(View.GONE);
     b6.setVisibility(View.GONE);
     b1.setVisibility(View.GONE);
}else{

     if(val.getSearKeyCodigo() >180 && val.getSearKeyCodigo() < 201){
//B4
         dato.put("ficha4","false");
         dato.put("ficha2","true");
         dato.put("ficha3","false");

         dato.put("ficha5","false");
         dato.put("ficha6","false");


         b2.setVisibility(View.VISIBLE);
         b4.setVisibility(View.GONE);
         b3.setVisibility(View.GONE);
         b5.setVisibility(View.GONE);
         b6.setVisibility(View.GONE);
         b1.setVisibility(View.GONE);
     }

}

}
}
}
        dato.put("remitente","true");
        dato.put("aviso1","true");
        dato.put("bloke","true");
        dato.put("codigo",val.getKeySiguienteN1());
        dato.put("nick",val.getKeyNick());

     bdNeutro.collection("EventoTesla").document(val.getKeySiguienteN1()).set(dato);

}






    public void cerrar(View sdfas) {

    contexto val = new contexto();

    Intent siguiente = new Intent(this,MenuEventos.class);

     siguiente.putExtra("nick", val.getKeyNick());
     siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        siguiente.putExtra("standar", val.getKeySiguienteN2());
     startActivity(siguiente);






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
    }






}

