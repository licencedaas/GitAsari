package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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

public class reinoduelo_6025225350 extends AppCompatActivity {
    private Spinner sp1;
    private FirebaseFirestore bdNeutro;
    Stack<String> idV1 = new Stack<>();
    private ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinoduelo6025225350);


        b1=(ImageButton) findViewById(R.id.reino_b1);
        b2=(ImageButton) findViewById(R.id.reino_b2);
        b3=(ImageButton) findViewById(R.id.reino_b3);
        b4=(ImageButton) findViewById(R.id.reino_b4);
        b5=(ImageButton) findViewById(R.id.reino_b5);
        b6=(ImageButton) findViewById(R.id.reino_b6);
        b7=(ImageButton) findViewById(R.id.reino_b7);
        b8=(ImageButton) findViewById(R.id.reino_b8);
        b9=(ImageButton) findViewById(R.id.reino_b9);
        b10=(ImageButton) findViewById(R.id.reino_b10);
        sp1=(Spinner) findViewById(R.id.reino_sp1);
        b3.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.GONE);
        b8.setVisibility(View.GONE);
        b9.setVisibility(View.GONE);
        b10.setVisibility(View.GONE);

        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

        bdNeutro = FirebaseFirestore.getInstance();
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));

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

bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

if (documentSnapshot.exists()) {


    visualSP1();
    val.setKeyEstrellasCero(documentSnapshot.getString("estrellas"));
    Toast.makeText(getApplicationContext(), "Cargando duelista...", Toast.LENGTH_SHORT).show();
    try{
if(val.getKeyEstrellasCero().contains("1")){
    b1.setVisibility(View.VISIBLE);
    b3.setVisibility(View.GONE);
    b2.setVisibility(View.GONE);
    b5.setVisibility(View.GONE);
    b4.setVisibility(View.GONE);
    b6.setVisibility(View.GONE);
    b7.setVisibility(View.GONE);
    b8.setVisibility(View.GONE);
    b9.setVisibility(View.GONE);
    b10.setVisibility(View.GONE);

}else{
    if(val.getKeyEstrellasCero().contains("2")){
        b2.setVisibility(View.VISIBLE);
        b1.setVisibility(View.VISIBLE);
        b3.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.GONE);
        b8.setVisibility(View.GONE);
        b9.setVisibility(View.GONE);
        b10.setVisibility(View.GONE);
    }else{
        if(val.getKeyEstrellasCero().contains("3")){
            b2.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b5.setVisibility(View.GONE);
            b4.setVisibility(View.GONE);
            b6.setVisibility(View.GONE);
            b7.setVisibility(View.GONE);
            b8.setVisibility(View.GONE);
            b9.setVisibility(View.GONE);
            b10.setVisibility(View.GONE);
        }else{
            if(val.getKeyEstrellasCero().contains("4")){
                b2.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);
                b5.setVisibility(View.GONE);
                b4.setVisibility(View.VISIBLE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b9.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
            }else{
                if(val.getKeyEstrellasCero().contains("5")){
                    b2.setVisibility(View.VISIBLE);
                    b1.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);
                    b5.setVisibility(View.VISIBLE);
                    b4.setVisibility(View.VISIBLE);
                    b6.setVisibility(View.GONE);
                    b7.setVisibility(View.GONE);
                    b8.setVisibility(View.GONE);
                    b9.setVisibility(View.GONE);
                    b10.setVisibility(View.GONE);
                }else{
                    if(val.getKeyEstrellasCero().contains("6")){
                        b2.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.VISIBLE);
                        b3.setVisibility(View.VISIBLE);
                        b5.setVisibility(View.VISIBLE);
                        b4.setVisibility(View.VISIBLE);
                        b6.setVisibility(View.VISIBLE);
                        b7.setVisibility(View.GONE);
                        b8.setVisibility(View.GONE);
                        b9.setVisibility(View.GONE);
                        b10.setVisibility(View.GONE);
                    }else{
                        if(val.getKeyEstrellasCero().contains("7")){
                            b2.setVisibility(View.VISIBLE);
                            b1.setVisibility(View.VISIBLE);
                            b3.setVisibility(View.VISIBLE);
                            b5.setVisibility(View.VISIBLE);
                            b4.setVisibility(View.VISIBLE);
                            b6.setVisibility(View.VISIBLE);
                            b7.setVisibility(View.VISIBLE);
                            b8.setVisibility(View.GONE);
                            b9.setVisibility(View.GONE);
                            b10.setVisibility(View.GONE);
                        }else{
                            if(val.getKeyEstrellasCero().contains("8")){
                                b2.setVisibility(View.VISIBLE);
                                b1.setVisibility(View.VISIBLE);
                                b3.setVisibility(View.VISIBLE);
                                b5.setVisibility(View.VISIBLE);
                                b4.setVisibility(View.VISIBLE);
                                b6.setVisibility(View.VISIBLE);
                                b7.setVisibility(View.VISIBLE);
                                b8.setVisibility(View.VISIBLE);
                                b9.setVisibility(View.GONE);
                                b10.setVisibility(View.GONE);
                            }else{
                                if(val.getKeyEstrellasCero().contains("9")){
                                    b2.setVisibility(View.VISIBLE);
                                    b1.setVisibility(View.VISIBLE);
                                    b3.setVisibility(View.VISIBLE);
                                    b5.setVisibility(View.VISIBLE);
                                    b4.setVisibility(View.VISIBLE);
                                    b6.setVisibility(View.VISIBLE);
                                    b7.setVisibility(View.VISIBLE);
                                    b8.setVisibility(View.VISIBLE);
                                    b9.setVisibility(View.VISIBLE);
                                    b10.setVisibility(View.GONE);
                                }else{
                                    if(val.getKeyEstrellasCero().contains("10")){
                                        b2.setVisibility(View.VISIBLE);
                                        b1.setVisibility(View.VISIBLE);
                                        b3.setVisibility(View.VISIBLE);
                                        b5.setVisibility(View.VISIBLE);
                                        b4.setVisibility(View.VISIBLE);
                                        b6.setVisibility(View.VISIBLE);
                                        b7.setVisibility(View.VISIBLE);
                                        b8.setVisibility(View.VISIBLE);
                                        b9.setVisibility(View.VISIBLE);
                                        b10.setVisibility(View.VISIBLE);
                                    }else{
                                        if(val.getKeyEstrellasCero().contains("0")){
                                            b3.setVisibility(View.GONE);
                                            b1.setVisibility(View.GONE);
                                            b2.setVisibility(View.GONE);
                                            b5.setVisibility(View.GONE);
                                            b4.setVisibility(View.GONE);
                                            b6.setVisibility(View.GONE);
                                            b7.setVisibility(View.GONE);
                                            b8.setVisibility(View.GONE);
                                            b9.setVisibility(View.GONE);
                                            b10.setVisibility(View.GONE);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }}
}catch(Exception sdfs){}

}else{
    if(val.getKeyIdGremio().equals("100")){
     //   Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
        crear();
        visualSP1();
    }else{
        if(val.getKeyIdGremio().equals("1100")) {
    //        Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
            crear();
            visualSP1();
        }else{
            if(val.getKeyIdGremio().equals("2100")) {
   //             Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
                crear();
                visualSP1();
            }else{
                if(val.getKeyIdGremio().equals("3100")) {
      //              Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
                    crear();
                    visualSP1();
                }else{
                    if(val.getKeyIdGremio().equals("4100")) {
                        crear();
                        visualSP1();
  //                      Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

}
}});


   sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
   @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

  val.setKeyDuelista2(sp1.getSelectedItem().toString());
  if(!val.getKeyDuelista2().contains("Elija al rival")) {

      bdNeutro.collection("BDreino").document(val.getKeySiguienteN1())
              .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
      @Override
      public void onSuccess(DocumentSnapshot documentSnapshot) {

          if(documentSnapshot.exists()){




      try {
          val.setKeyBloqueo1(documentSnapshot.getString("keyGenerate"));
      }catch (Exception fsfd){
          Toast.makeText(getApplicationContext(), "#1", Toast.LENGTH_SHORT).show();
      }

      try{
      val.setKeyFich1(documentSnapshot.getString("keyApuesta"+val.getKeyDuelista2()));
      }catch (Exception fsfd){
          Toast.makeText(getApplicationContext(), "#2", Toast.LENGTH_SHORT).show();
      }

              try{
                  val.setKeyApuesta1(documentSnapshot.getString("nickApuesta"));
                  Toast.makeText(getApplicationContext(), "ESTOY APOSTANDO: " + val.getKeyApuesta1(), Toast.LENGTH_SHORT).show();
              }catch (Exception fsfd){
                  Toast.makeText(getApplicationContext(), "#2", Toast.LENGTH_SHORT).show();
              }
      try{
      val.setKeyCodigoReporte1(documentSnapshot.getString("keyGenerate_"+val.getKeyNick()));
      }catch (Exception fsfd){
          Toast.makeText(getApplicationContext(), "#3  ", Toast.LENGTH_SHORT).show();
      }

      try{
          Toast.makeText(getApplicationContext(), "KEYGENERATE: " + val.getKeyBloqueo1(), Toast.LENGTH_SHORT).show();


       if(val.getKeyBloqueo1().contains("resibir")){
           Toast.makeText(getApplicationContext(), "ESCANEANDO RIVAL ELEJIDO #1", Toast.LENGTH_SHORT).show();


              bdNeutro.collection("BDreino").whereEqualTo("nick",val.getKeyDuelista2())
                      .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                  @Override
                  public void onComplete(@NonNull Task<QuerySnapshot> task) {
                      Toast.makeText(getApplicationContext(), "ESCANEANDO RIVAL ELEJIDO  #3", Toast.LENGTH_SHORT).show();


                      try{
                      if (task.isSuccessful()) {
                          Toast.makeText(getApplicationContext(), "ESCANEANDO RIVAL ELEJIDO", Toast.LENGTH_SHORT).show();
try{
                          for (QueryDocumentSnapshot document : task.getResult()) {
                           try{
                              val.setKeyCodigo2(document.getString("codigo"));
                          }catch (Exception fsfd){
                              Toast.makeText(getApplicationContext(), "#1  12872420", Toast.LENGTH_SHORT).show();
                          }
                              try{
                                  val.setKeyEstrellasCero(document.getString("estrellas"));
                                  Toast.makeText(getApplicationContext(), "ESTRELLAS DISPO: "+ val.getKeyEstrellasCero(), Toast.LENGTH_SHORT).show();

                              }catch (Exception fsfd){
                                  Toast.makeText(getApplicationContext(), "#1  12872420", Toast.LENGTH_SHORT).show();
                              }

                              try{
                                  val.setKeyOcupado2(document.getString("keyOcupado"));
                                  Toast.makeText(getApplicationContext(), "KEYOCUAPADO RIVAL: " + val.getKeyOcupado2(), Toast.LENGTH_SHORT).show();
                              }catch (Exception fsfd){
                                  Toast.makeText(getApplicationContext(), "#2  12872420", Toast.LENGTH_SHORT).show();
                              }
                           try{
                           val.setKeyAviso2(document.getString("keyGenerate"));

                               Toast.makeText(getApplicationContext(), "AVISO2 RIVAL: " + val.getKeyAviso2(), Toast.LENGTH_SHORT).show();
                           }catch (Exception fsfd){
                              Toast.makeText(getApplicationContext(), "#2  12872420", Toast.LENGTH_SHORT).show();
                          }
                           try{
                              val.setKeyAprovacion_2(document.getString("keyApuesta"+val.getKeyNick()));
                               Toast.makeText(getApplicationContext(), "KEYGENERTE RIVAL:  "+    val.getKeyAprovacion_2() , Toast.LENGTH_SHORT).show();

                           }catch (Exception fsfd){
                               Toast.makeText(getApplicationContext(), "#3  12872420", Toast.LENGTH_SHORT).show();
                           }

                              try{
                                  val.setKeyapuesta2(document.getString("nickApuesta"));
                                  Toast.makeText(getApplicationContext(), "NICL APUESTA RIVAL:  "+    val.getKeyapuesta2() , Toast.LENGTH_SHORT).show();

                              }catch (Exception fsfd){
                                  Toast.makeText(getApplicationContext(), "#3  12872420", Toast.LENGTH_SHORT).show();
                              }
                          }
                      }catch (Exception fsfd){
                          Toast.makeText(getApplicationContext(), "#3  12872420", Toast.LENGTH_SHORT).show();
                      }


if(val.getKeyEstrellasCero().contains("0")){

    Toast.makeText(getApplicationContext(), "NO TIENE EL RIVAL ELEGIDO ESTRELLAS PARA COMPETIR." + val.getKeyAviso2(), Toast.LENGTH_SHORT).show();

}else{
if(val.getKeyAviso2().contains(val.getKeyDuelista2())){

if(val.getKeyOcupado2().contains("si")){

    Toast.makeText(getApplicationContext(), "SELECCIONE OTRO DUELISTA ESTE ESTA OCUPADO", Toast.LENGTH_SHORT).show();
}   else{

val.setKeyJ2(Integer.parseInt(val.getKeyFich1()));
Toast.makeText(getApplicationContext(), "Combrobando .. " + val.getKeyFich1(), Toast.LENGTH_SHORT).show();

try {
if (val.getKeyJ2() >= 1){
Toast.makeText(getApplicationContext(), "Selecciona el boton GENERAR o REPORTAR sea el caso", Toast.LENGTH_SHORT).show();
}else {
    if (val.getKeyJ2() <0){
        Toast.makeText(getApplicationContext(), "No tiene estrellas para competir.", Toast.LENGTH_SHORT).show();
    }else{

    if(val.getKeyApuesta1().contains("auxiliar")){
        val.setKeyBloqueo2("reporte");
        apuesta();}else{
        Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
    }}


}
}catch (Exception  jhjh){}}}else{
    Toast.makeText(getApplicationContext(), "Combrobando INICIO.. " + val.getKeyFich1()+ "  -  " + val.getKeyAviso2(), Toast.LENGTH_SHORT).show();

    try{
if(val.getKeyAviso2().contains("resibir")){

val.setKeyJ2(Integer.parseInt(val.getKeyFich1()));
Toast.makeText(getApplicationContext(), "Combrobando .. " + val.getKeyFich1(), Toast.LENGTH_SHORT).show();
try {
if (val.getKeyJ2() >= 1){
Toast.makeText(getApplicationContext(), "Selecciona el boton GENERAR o REPORTAR sea el caso", Toast.LENGTH_SHORT).show();
}else {
    if(val.getKeyApuesta1().contains("auxiliar")){
        val.setKeyBloqueo2("reporte");
        apuesta();}else{
        Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
    }

}
}catch (Exception  jhjh){}


}else{
Toast.makeText(getApplicationContext(), "#3", Toast.LENGTH_SHORT).show();
}
}catch (Exception fsfd){

        try {



          if(val.getKeyOcupado2().contains("si")){

              Toast.makeText(getApplicationContext(), "EL RIVAL ESTA OCUAPADO.."+ val.getKeyapuesta2(), Toast.LENGTH_SHORT).show();

              if(val.getKeyapuesta2().contains(val.getKeyNick())){
                  Toast.makeText(getApplicationContext(), "#1 ESTOY OCUPADO:" + val.getKeyApuesta1(), Toast.LENGTH_SHORT).show();
                  if(val.getKeyApuesta1().contains("auxiliar")){
                      val.setKeyBloqueo2("reporte");
                      Toast.makeText(getApplicationContext(), "Su rival espera su apuesta..", Toast.LENGTH_SHORT).show();

                      apuesta();}else{


                      try {
                          if (val.getKeyFich1().contains("null")) {
                              val.setKeyBloqueo2("reporte");
                              Toast.makeText(getApplicationContext(), "Su rival espera su apuesta..", Toast.LENGTH_SHORT).show();
                              apuesta();
                          }
                      }catch (Exception sfsf){
                          val.setKeyBloqueo2("reporte");
                          Toast.makeText(getApplicationContext(), "Su rival espera su apuesta suerte.", Toast.LENGTH_SHORT).show();
                          apuesta();
                      }
                      Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
                  }


              }else {
                  Toast.makeText(getApplicationContext(), "SELECCIONE OTRO DUELISTA ESTE ESTA OCUPADO", Toast.LENGTH_SHORT).show();
              }
          } else {
              if(val.getKeyOcupado2().contains("no")) {
                  if(val.getKeyApuesta1().contains("auxiliar")){
                      val.setKeyBloqueo2("reporte");
                      apuesta();}else{
                      Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
                  }

              }else{
                  if(val.getKeyOcupado2().contains("nuevo")) {
                      if(val.getKeyApuesta1().contains("auxiliar")){
                          val.setKeyBloqueo2("reporte");
                          apuesta();}else{
                          Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
                      }

                  }
              }
          }
        }catch (Exception dfsf){
            Toast.makeText(getApplicationContext(), "#5K  :  "  +val.getKeyAprovacion_2(), Toast.LENGTH_SHORT).show();

        }
                         //     Toast.makeText(getApplicationContext(), "SELECCIONE LAS ESTRELLAS DE APUESTA.", Toast.LENGTH_SHORT).show();
}
}}


}
                  }catch (Exception fsfd){
                      Toast.makeText(getApplicationContext(), "ERROR DUELISTA", Toast.LENGTH_SHORT).show();
                  }

                  }});





      }else{

try{
          if( val.getKeyFich1().contains("estrella")){
              Toast.makeText(getApplicationContext(), "Asari te desea suerte..", Toast.LENGTH_SHORT).show();
              if(val.getKeyApuesta1().contains("auxiliar")){
                  val.setKeyBloqueo2("reporte");
                  apuesta();}else{
                  Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
              }


          }else{
              Toast.makeText(getApplicationContext(), "Puede generar su REPORTE O GENERAR EL CODIGO     ", Toast.LENGTH_SHORT).show();
}
}catch (Exception fgf){
    val.setKeyFich1("estrella");
    Toast.makeText(getApplicationContext(), "Reacomodando", Toast.LENGTH_SHORT).show();

    if( val.getKeyFich1().contains("estrella")){
        if(val.getKeyApuesta1().contains("auxiliar")){
            val.setKeyBloqueo2("reporte");
            apuesta();}else{
            Toast.makeText(getApplicationContext(), "Seleccione el duelista que tiene pendiente", Toast.LENGTH_SHORT).show();
        }


    }else{
        Toast.makeText(getApplicationContext(), "Puede generar su REPORTE O GENERAR EL CODIGO", Toast.LENGTH_SHORT).show();
    }

}

      }

      }catch (Exception fsfd){
              Toast.makeText(getApplicationContext(), "#4", Toast.LENGTH_SHORT).show();
}

          }else{
              Toast.makeText(getApplicationContext(), "NO existe", Toast.LENGTH_SHORT).show();

          }
      //

}

});
}


}

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    Context contexto;

    public void apuesta(){
        contexto val = new contexto();
        try{
            if(val.getKeyBloqueo2().contains("reporte")){
                contexto = this;
                new detlles_gener_apostar((Context) contexto);
            }}catch (Exception sdfs){
            Toast.makeText(getApplicationContext(), "#4", Toast.LENGTH_SHORT).show();
        }
    }


    public void generate(View sdfsfd){
        contexto val = new contexto();

        val.setKeyDuelista2(sp1.getSelectedItem().toString());
        if(!val.getKeyDuelista2().contains("Elija al rival")) {


            try {
                val.setKeyJ2(Integer.parseInt(val.getKeyFich1()));
                if(val.getKeyJ2()>=1) {

                    contexto = this;
                    new detlles_gener_reino(contexto);
                }else{
                    Toast.makeText(getApplicationContext(), "Apuesta tus estrallas." + val.getKeyFich1(), Toast.LENGTH_SHORT).show();

                }
            }catch (Exception  dfgd){Toast.makeText(getApplicationContext(), "Apuesta tus estrallas duelista." + val.getKeyFich1(), Toast.LENGTH_SHORT).show();}

        }else{
            Toast.makeText(getApplicationContext(), "Elija a un rival", Toast.LENGTH_SHORT).show();
        }
    }

    public void report(View sdfsfd){

        contexto val = new contexto();

        val.setKeyDuelista2(sp1.getSelectedItem().toString());
        if(!val.getKeyDuelista2().contains("Elija al rival")) {
try {

   val.setKeyJ2(Integer.parseInt(val.getKeyFich1()));
   val.setKeyJ3(Integer.parseInt(val.getKeyCodigoReporte1()));

    if(val.getKeyJ2()>=1){

    //    Toast.makeText(getApplicationContext(), "TIENE RELACION", Toast.LENGTH_SHORT).show();
        if(val.getKeyBloqueo1().contains(val.getKeyNick())){


            llamadoReporte();
        }


    }else{
        Toast.makeText(getApplicationContext(), "Primero Apuesta tus estrellas...", Toast.LENGTH_SHORT).show();
    }
}catch (Exception dfsf){
    Toast.makeText(getApplicationContext(), "No se a cumplido las condiciones para este evento", Toast.LENGTH_SHORT).show();
}





        }else{
            Toast.makeText(getApplicationContext(), "Elija a un rival", Toast.LENGTH_SHORT).show();
        }

    }

  public void llamadoReporte(){
      contexto = this;
      new detlles_reporte_reino(contexto);
  }


    public void crear(){
        contexto val = new contexto();
        HashMap<String, Object> dato = new HashMap<>();
        dato.put("keyGenerate","resibir");
        dato.put("keyOcupado","nuevo");
//        dato.put("keyGenerate_auxiliar","0000");
        dato.put("codigo",val.getKeySiguienteN1());
        dato.put("nick",val.getKeyNick());
        dato.put("estrellas","2");
        dato.put("nickApuesta","auxiliar");

        bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).set(dato);

    }


    public void visualSP1(){
        contexto val = new contexto();
        try {
            bdNeutro.collection("BDreino").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {
                        ArrayAdapter<String> datos = null;
                        idV1.add("Elija al rival");
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            val.setKeyDuelista(document.getString("nick"));
                            if(val.getKeyNick().equals(val.getKeyDuelista())){}else {

                                if (val.getKeyIdGremio().equals("100")) {
                                    val.setKeyJ1(Integer.parseInt(document.getString("codigo")));

                                    if (val.getKeyJ1() >= 101 && val.getKeyJ1() <= 600) {
                                        idV1.add(val.getKeyDuelista());
                                    }


                                } else {
                                    if (val.getKeyIdGremio().equals("1100")) {
                                        val.setKeyJ1(Integer.parseInt(document.getString("codigo")));

                                        if (val.getKeyJ1() >= 1100 && val.getKeyJ1() <= 1600) {
                                            idV1.add(val.getKeyDuelista());
                                        }
                                    } else {
                                        if (val.getKeyIdGremio().equals("2100")) {
                                            val.setKeyJ1(Integer.parseInt(document.getString("codigo")));

                                            if (val.getKeyJ1() >= 2100 && val.getKeyJ1() <= 2600) {
                                                idV1.add(val.getKeyDuelista());
                                            }
                                        }else{
                                            if (val.getKeyIdGremio().equals("3100")) {
                                                val.setKeyJ1(Integer.parseInt(document.getString("codigo")));

                                                if (val.getKeyJ1() >= 3100 && val.getKeyJ1() <= 3600) {
                                                    idV1.add(val.getKeyDuelista());
                                                }
                                            }else{
                                                if (val.getKeyIdGremio().equals("4100")) {
                                                    val.setKeyJ1(Integer.parseInt(document.getString("codigo")));

                                                    if (val.getKeyJ1() >= 4100 && val.getKeyJ1() <= 4600) {
                                                        idV1.add(val.getKeyDuelista());
                                                    }
                                                }
                                            }


                                        }

                                    }
                                }



                            }}

                        datos = new ArrayAdapter<>(getApplication(), R.layout.spiner_jornada_random, idV1);
                        sp1.setAdapter(datos);
                    }}});


        }catch (Exception sdfs){}
    }

}