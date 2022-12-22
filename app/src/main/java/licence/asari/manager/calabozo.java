package licence.asari.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;*/
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class calabozo extends AppCompatActivity {


    FirebaseFirestore bdNeutral, bdAzul,gremio;
    Button b1;
    TextView l1,l2,l3,l4,l5,l6;
   // private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calabozo);

        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setSearKeyCodigo(Integer.parseInt(val.getKeySiguienteN1()));
        bdNeutral = FirebaseFirestore.getInstance();

/*
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @  Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adViewv6);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/
      l1=(TextView) findViewById(R.id.v6_l1);
        l2=(TextView) findViewById(R.id.v6_l2);
        l3=(TextView) findViewById(R.id.v6_l3);
        l4=(TextView) findViewById(R.id.v6_l4);
        l5=(TextView) findViewById(R.id.v6_l5);
        l6=(TextView) findViewById(R.id.v6_l6);

      b1 = (Button) findViewById(R.id.calabozo_v4_b1);

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

        bdNeutral.collection("BDcalabozo").document("Info")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){

                    HashMap<String, Object> dato1 = new HashMap<>();
                    val.setKeySalaDuelo(documentSnapshot.getString("numeroSalaLvl6"));
                    b1.setText(val.getKeySalaDuelo());

                    bdNeutral.collection("BDcalabozo").document("calabozoUp6").get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                    if(documentSnapshot.exists()){

                                        val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                                        val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                                        val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                                        val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                                        val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                                        val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));

                                        if(val.getKeyCalabozolvl1().equals("esperando")){
                                            HashMap<String, Object> dato = new HashMap<>();

                                            dato.put("puestoN1",val.getKeyNick());

                                            bdNeutral.collection("BDcalabozo").document("calabozoUp6").update(dato);
                                        }else{
                                            if(val.getKeyCalabozolvl2().equals("esperando")){

                                                if(val.getKeyNick().equals(val.getKeyCalabozolvl1())){
                                                }else{

                                                    dato1.put("participante2",val.getKeyNick());

                                                    bdNeutral.collection("BDcalabozo").document("tablaUp6").update(dato1);


                                                    HashMap<String, Object> dato = new HashMap<>();
                                                    dato.put("puestoN2",val.getKeyNick());

                                                    bdNeutral.collection("BDcalabozo").document("calabozoUp6").update(dato);
                                                }
                                            }else{
                                                if(val.getKeyCalabozolvl3().equals("esperando")){
                                                    if(val.getKeyNick().equals(val.getKeyCalabozolvl1())){
                                                    }else{
                                                        if(val.getKeyNick().equals(val.getKeyCalabozolvl2())){
                                                        }else{
                                                            dato1.put("participante3",val.getKeyNick());
                                                            bdNeutral.collection("BDcalabozo").document("tablaUp6").update(dato1);

                                                            HashMap<String, Object> dato = new HashMap<>();
                                                            dato.put("puestoN3",val.getKeyNick());

                                                            bdNeutral.collection("BDcalabozo").document("calabozoUp6").update(dato);
                                                        }
                                                    } }else{
                                                    if(val.getKeyCalabozolvl4().equals("esperando")){
                                                        if(val.getKeyNick().equals(val.getKeyCalabozolvl1())){
                                                        }else{
                                                            if(val.getKeyNick().equals(val.getKeyCalabozolvl2())){
                                                            }else{
                                                                if(val.getKeyNick().equals(val.getKeyCalabozolvl3())){
                                                                }else{
                                                                    dato1.put("participante4",val.getKeyNick());
                                                                    bdNeutral.collection("BDcalabozo").document("tablaUp6").update(dato1);
                                                                    HashMap<String, Object> dato = new HashMap<>();
                                                                    dato.put("puestoN4",val.getKeyNick());
                                                                    bdNeutral.collection("BDcalabozo").document("calabozoUp6").update(dato);
                                                                } } }
}else{
if(val.getKeyCalabozolvl5().equals("esperando")){
if(val.getKeyNick().equals(val.getKeyCalabozolvl1())){
}else{
if(val.getKeyNick().equals(val.getKeyCalabozolvl2())){
 }else{
if(val.getKeyNick().equals(val.getKeyCalabozolvl3())){
 }else{
if(val.getKeyNick().equals(val.getKeyCalabozolvl4())){
}else {

    dato1.put("participante5", val.getKeyNick());
    bdNeutral.collection("BDcalabozo").document("tablaUp6").update(dato1);
    HashMap<String, Object> dato = new HashMap<>();
    dato.put("puestoN5", val.getKeyNick());
    bdNeutral.collection("BDcalabozo").document("calabozoUp6").update(dato);
}
} } }

}else{
if(val.getKeyCalabozolvl6().equals("esperando")){
    if(val.getKeyNick().equals(val.getKeyCalabozolvl1())){
    }else{
        if(val.getKeyNick().equals(val.getKeyCalabozolvl2())){
        }else{
            if(val.getKeyNick().equals(val.getKeyCalabozolvl3())){
            }else{
                if(val.getKeyNick().equals(val.getKeyCalabozolvl4())){
                }else {
                    if(val.getKeyNick().equals(val.getKeyCalabozolvl5())){
                    }else {
                        dato1.put("participante6", val.getKeyNick());
                        bdNeutral.collection("BDcalabozo").document("tablaUp6").update(dato1);
                        HashMap<String, Object> dato = new HashMap<>();
                        dato.put("puestoN6", val.getKeyNick());
                        bdNeutral.collection("BDcalabozo").document("calabozoUp6").update(dato);
                    }
                }
            } } }
}
}


                                                    } } } }
                                        relogueolvl6();
                                    }else{ crear(); } }});
                } }});


}


    public void relogueolvl6(){

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("calabozoUp6").get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){

                            val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                            val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                            val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                            val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                            val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                            val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));

                            l1.setText(val.getKeyCalabozolvl1());
                            l2.setText(val.getKeyCalabozolvl2());
                            l3.setText(val.getKeyCalabozolvl3());
                            l4.setText(val.getKeyCalabozolvl4());
                            l5.setText(val.getKeyCalabozolvl5());
                            l6.setText(val.getKeyCalabozolvl6());


                        }

                    }
                });
    }

  public void relogueolv6(View sdfs){

      contexto val = new contexto();
      bdNeutral.collection("BDcalabozo").document("calabozoUp6").get()
              .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                  @Override
                  public void onSuccess(DocumentSnapshot documentSnapshot) {

                      if(documentSnapshot.exists()){

                          val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                          val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                          val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                          val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                          val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                          val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));

                          l1.setText(val.getKeyCalabozolvl1());
                          l2.setText(val.getKeyCalabozolvl2());
                          l3.setText(val.getKeyCalabozolvl3());
                          l4.setText(val.getKeyCalabozolvl4());
                          l5.setText(val.getKeyCalabozolvl5());
                          l6.setText(val.getKeyCalabozolvl6());


                      }

                  }
              });
  }


    public void crear(){
        contexto val = new contexto();

        HashMap<String, Object> dato = new HashMap<>();
        HashMap<String, Object> dato1 = new HashMap<>();


        dato.put("puestoN1",val.getKeyNick());
        dato.put("puestoN2","esperando");
        dato.put("puestoN3","esperando");
        dato.put("puestoN4","esperando");
        dato.put("puestoN5","esperando");
        dato.put("puestoN6","esperando");


        l1.setText(val.getKeyNick());

        dato1.put("participante1",val.getKeyNick());
        dato1.put("participante2","esperando");
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

        bdNeutral.collection("BDcalabozo").document("tablaUp6").set(dato1);

        bdNeutral.collection("BDcalabozo").document("calabozoUp6").set(dato);
    }


public void enlaceLVL6(View sdfsd){

    contexto val = new contexto();
    bdNeutral.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

            if (documentSnapshot.exists()) {

                val.setKeyEnlaceCalabozolvl6(documentSnapshot.getString("salaLvl1"));
                Toast.makeText(getApplicationContext(), "EBLACE: " + val.getKeyEnlaceCalabozolvl6(), Toast.LENGTH_SHORT).show();
                Uri url = Uri.parse(val.getKeyEnlaceCalabozolvl6());
               Intent siguiente = new Intent(Intent.ACTION_VIEW,url);
                startActivity(siguiente);
            }
        }});
}


    Context contexto;

    public void detallesDerrota(View sdfsfd){
        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("calabozoUp6").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {

                    val.setKeydueloFinal("desactivado");
                    val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                    val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                    val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                    val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                    val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                    val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));

                    val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                    val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                    val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                    val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                    val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                    val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
//  val.setKeyDuelista2(val.getKeyEstado4());


                    if (val.getKeyEstado1().equals("derrota")) {
                    if (val.getKeyEstado3().equals("derrota")) {
                        //finalista  2
                    if (val.getKeyCalabozolvl4().equals("derrota")) {
                     if (val.getKeyCalabozolvl6().equals("derrota")) {

           //              Toast.makeText(getApplicationContext(), "FINAL: 2 Y 5", Toast.LENGTH_SHORT).show();
                         val.setKeydueloFinal("activado");
                         if(val.getKeyEstado5().equals(val.getKeyNick())){
                             val.setKeyDuelista2(val.getKeyEstado2());}else{
                             if(val.getKeyEstado2().equals(val.getKeyNick())) {
                                 val.setKeyDuelista2(val.getKeyEstado5());
                             }
                         }
                    }else{
                    if (val.getKeyCalabozolvl5().equals("derrota")) {
       //                 Toast.makeText(getApplicationContext(), "FINAL: 2 Y 6", Toast.LENGTH_SHORT).show();
                        val.setKeydueloFinal("activado");
                        if(val.getKeyEstado6().equals(val.getKeyNick())){
                            val.setKeyDuelista2(val.getKeyEstado2());}else{
                            if(val.getKeyEstado2().equals(val.getKeyNick())) {
                                val.setKeyDuelista2(val.getKeyEstado6());
                            }
                        }
                    }
                    }
                    }else{
                    if (val.getKeyCalabozolvl5().equals("derrota")) {
                        if (val.getKeyCalabozolvl6().equals("derrota")) {
                            //finalista el 4 y 2
         //                   Toast.makeText(getApplicationContext(), "FINAL: 2 Y 4", Toast.LENGTH_SHORT).show();
                            val.setKeydueloFinal("activado");
                            if(val.getKeyEstado2().equals(val.getKeyNick())){
                                val.setKeyDuelista2(val.getKeyEstado4());}else{
                                if(val.getKeyEstado4().equals(val.getKeyNick())) {
                                    val.setKeyDuelista2(val.getKeyEstado2());
                                }
                            }
                        }
                    }
                    }
                    }else{
                     if (val.getKeyEstado2().equals("derrota")) {
                            //finalista el 3

                     if (val.getKeyEstado4().equals("derrota")) {
                    if (val.getKeyEstado5().equals("derrota")) {
                        //finalista el 6
                     //   Toast.makeText(getApplicationContext(), "FINAL: 3 Y 6", Toast.LENGTH_SHORT).show();
                        val.setKeydueloFinal("activado");
                        if(val.getKeyEstado6().equals(val.getKeyNick())){
                            val.setKeyDuelista2(val.getKeyEstado3());}else{
                            if(val.getKeyEstado3().equals(val.getKeyNick())) {
                                val.setKeyDuelista2(val.getKeyEstado6());
                            }
                        }
                   }else{
                        if (val.getKeyEstado6().equals("derrota")) {
                            //finalista el 5
                     //       Toast.makeText(getApplicationContext(), "FINAL: 3 Y 5", Toast.LENGTH_SHORT).show();
                            val.setKeydueloFinal("activado");
                            if(val.getKeyEstado5().equals(val.getKeyNick())){
                                val.setKeyDuelista2(val.getKeyEstado3());}else{
                                if(val.getKeyEstado3().equals(val.getKeyNick())) {
                                    val.setKeyDuelista2(val.getKeyEstado5());
                                }
                            }
                        }
                    }
                   }else{
                         if (val.getKeyEstado5().equals("derrota")) {
                             if (val.getKeyEstado6().equals("derrota")) {
                                 //finalista el 4
                      //           Toast.makeText(getApplicationContext(), "FINAL: 3 Y 4", Toast.LENGTH_SHORT).show();
                                 val.setKeydueloFinal("activado");
                                 if(val.getKeyEstado4().equals(val.getKeyNick())){
                                     val.setKeyDuelista2(val.getKeyEstado3());}else{
                                     if(val.getKeyEstado3().equals(val.getKeyNick())) {
                                         val.setKeyDuelista2(val.getKeyEstado4());
                                     }
                                 }
                             }
                         }
                     }

                   }
                    }
                    }else{
                    if (val.getKeyEstado2().equals("derrota")) {
                    if (val.getKeyEstado3().equals("derrota")) {
                        //finalista 1 con el de aanajp

                    if (val.getKeyEstado4().equals("derrota")) {
                    if (val.getKeyEstado5().equals("derrota")) {
                     //   Toast.makeText(getApplicationContext(), "FINAL: 1 Y 6", Toast.LENGTH_SHORT).show();
                        val.setKeydueloFinal("activado");
                        if(val.getKeyEstado6().equals(val.getKeyNick())){
                        val.setKeyDuelista2(val.getKeyEstado1());}else{
                            if(val.getKeyEstado1().equals(val.getKeyNick())) {
                                val.setKeyDuelista2(val.getKeyEstado6());
                            }
                        }
                        //finalista el 6
                   }else{
                        if (val.getKeyEstado6().equals("derrota")) {
                            //finalista el 5
                    //        Toast.makeText(getApplicationContext(), "FINAL: 1 Y 5", Toast.LENGTH_SHORT).show();
                            val.setKeydueloFinal("activado");
                            if(val.getKeyEstado5().equals(val.getKeyNick())){
                                val.setKeyDuelista2(val.getKeyEstado1());}else{
                                if(val.getKeyEstado1().equals(val.getKeyNick())) {
                                    val.setKeyDuelista2(val.getKeyEstado5());
                                }
                            }
                        }
                    }
                   }else{
                   if (val.getKeyEstado5().equals("derrota")) {
                   if (val.getKeyEstado6().equals("derrota")) {
                       //finalista el 4
                //       Toast.makeText(getApplicationContext(), "FINAL: 1 Y 4", Toast.LENGTH_SHORT).show();
                       val.setKeydueloFinal("activado");
                       if(val.getKeyEstado4().equals(val.getKeyNick())){
                           val.setKeyDuelista2(val.getKeyEstado1());}else{
                           if(val.getKeyEstado1().equals(val.getKeyNick())) {
                               val.setKeyDuelista2(val.getKeyEstado4());
                           }
                       }
                   }else{
                   if (val.getKeyEstado4().equals("derrota")) {
                       //finalista el 6
                  //     Toast.makeText(getApplicationContext(), "FINAL: 1 Y 6", Toast.LENGTH_SHORT).show();
                       val.setKeydueloFinal("activado");
                       if(val.getKeyEstado6().equals(val.getKeyNick())){
                           val.setKeyDuelista2(val.getKeyEstado1());}else{
                           if(val.getKeyEstado1().equals(val.getKeyNick())) {
                               val.setKeyDuelista2(val.getKeyEstado6());
                           }
                       }
                   }
                   }
                   }
                    }

                    }
                    }
                    }
                    if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
               //        llamadaDerrota();
                    }else{
                        if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
             //               llamadaDerrota();
                        }else{
                            if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
                  //              llamadaDerrota();
                            }else{
                                if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
                           //         llamadaDerrota();
                                }else{
                                    //
                                    if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
                         //               llamadaDerrota();

                                    }else{
                                        if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
                           //                 llamadaDerrota();
                                        }else{
                                            Toast.makeText(getApplicationContext(), "No puede generar mas codigos..", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                            } } }

                }







                }});



    }
/*
    public void llamadaDerrota(){
        contexto = this;
        new detlles_derrota_v6(contexto);
    }
*/






    protected void onStop() {
        super.onStop();
        contexto val = new contexto();
        //   Toast.makeText(this, "OnStop:"+val.getKeyNick(), Toast.LENGTH_SHORT).show();
        relogueolvl6();

    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();



        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

    public void detallesVictoria(View sdfsfd){
        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("calabozoUp6").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {

                    val.setKeyCodigoVictoria(documentSnapshot.getString("keyDerrotaCodigo" + val.getKeyNick()));
                    //      Toast.makeText(getApplicationContext(), "Codigo: " + val.getKeyCodigoVictoria()+ "    "+ val.getKeyNick(), Toast.LENGTH_SHORT).show();
                    try {
                        val.setKeyJ1(Integer.parseInt(val.getKeyCodigoVictoria()));
                        Toast.makeText(getApplicationContext(), "Inciando ----", Toast.LENGTH_SHORT).show();
           //             llamadaVictoria();
                    }catch (Exception dfs){
                        Toast.makeText(getApplicationContext(), "Aun no se a generado codigos de victoria para su perfil", Toast.LENGTH_SHORT).show();
                    }



                }}});



    }
/*
    public void llamadaVictoria(){
        contexto = this;
        new detlles_victoria_v6(contexto);
    }
*/

}

