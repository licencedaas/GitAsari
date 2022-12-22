package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Stack;

public class tabla_registro_dungeo_v6 extends AppCompatActivity {

    FirebaseFirestore bdNeutral;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
  public static Stack<String> idV4 = new Stack <String>  ();
   ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_registro_dungeo_v6);

        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyPermisoInicio(getIntent().getStringExtra("keyAdmin"));

        bdNeutral = FirebaseFirestore.getInstance();


        l1=(TextView) findViewById(R.id.talbla_l1);
        l2=(TextView) findViewById(R.id.talbla_l2);
        l3=(TextView) findViewById(R.id.talbla_l3);
        l4=(TextView) findViewById(R.id.talbla_l4);
        l5=(TextView) findViewById(R.id.talbla_l5);
        l6=(TextView) findViewById(R.id.talbla_l6);
        l7=(TextView) findViewById(R.id.talbla_l7);
        l8=(TextView) findViewById(R.id.talbla_l8);
        l9=(TextView) findViewById(R.id.talbla_l9);
        l10=(TextView) findViewById(R.id.talbla_l10);
        l11=(TextView) findViewById(R.id.talbla_l11);
        l12=(TextView) findViewById(R.id.talbla_l12);

        b1= (ImageButton) findViewById(R.id.preregistro_b1);
        b1.setVisibility(View.GONE);
        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b1.setVisibility(View.VISIBLE); } }catch (Exception dfs){}


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

        bdNeutral.collection("BDcalabozo").document("tablaPreregistro")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

                    HashMap<String,Object> dato = new HashMap<>();

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
                 //   Toast.makeText(getApplicationContext(), "NUMNERO11: " + val.getKeyCalabozolvl11(), Toast.LENGTH_SHORT).show();




if (val.getKeyCalabozolvl2().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
dato.put("participante2",val.getKeyNick());
bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);
}
}else{

if (val.getKeyCalabozolvl3().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {

dato.put("participante3",val.getKeyNick());
bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);
}
}
}else{

if (val.getKeyCalabozolvl4().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {

    dato.put("participante4",val.getKeyNick());
    bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);
}
}
}
}else{

if (val.getKeyCalabozolvl5().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {

    dato.put("participante5",val.getKeyNick());
    bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);

}
}
}
}

}else{

if (val.getKeyCalabozolvl6().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
} else {

    dato.put("participante6",val.getKeyNick());
    bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);
}
}
}
}
}
}else{

if (val.getKeyCalabozolvl7().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
} else {

    dato.put("participante7",val.getKeyNick());
    bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);


}
}
}
}
}
}
}else{

if (val.getKeyCalabozolvl8().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl7())) {
}else {

dato.put("participante8",val.getKeyNick());
bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);

}
}
}
}
}
}
}
}else{

if (val.getKeyCalabozolvl9().equals("eperando")) {
 if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl7())) {
}else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl8())) {
}else {

dato.put("participante9", val.getKeyNick());
bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);
}
}
}
}
}
}
}
}
}else{

if (val.getKeyCalabozolvl10().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl7())) {
}else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl8())) {
}else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl9())) {
}else {

dato.put("participante10", val.getKeyNick());
bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);
}
}
}
}
}
}
}
}
}
}else{

if (val.getKeyCalabozolvl11().equals("eperando")) {
if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
} else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl7())) {
}else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl8())) {
}else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl9())) {
}else {
if (val.getKeyNick().equals(val.getKeyCalabozolvl10())) {
}else{

dato.put("participante11", val.getKeyNick());
bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);}
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }else{


    if (val.getKeyCalabozolvl12().equals("eperando")) {
        if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
        } else {
            if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
            } else {
                if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
                } else {
                    if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
                    } else {
                        if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
                        } else {
                            if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
                            } else {
                                if (val.getKeyNick().equals(val.getKeyCalabozolvl7())) {
                                }else {
                                    if (val.getKeyNick().equals(val.getKeyCalabozolvl8())) {
                                    }else {
                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl9())) {
                                        }else {
                                            if (val.getKeyNick().equals(val.getKeyCalabozolvl10())) {
                                            }else{

                                                dato.put("participante12", val.getKeyNick());
                                                bdNeutral.collection("BDcalabozo").document("tablaPreregistro").update(dato);}
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

}
}


}
}
}
}
}
}
                    relogueolvl6();
}else{

                 ///talbla_l4

                    HashMap<String,Object> dato = new HashMap<>();
                    dato.put("participante1",val.getKeyNick());
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
                    dato.put("participante12","eperando");

                    bdNeutral.collection("BDcalabozo").document("tablaPreregistro").set(dato);

                    l1.setText(val.getKeyNick());


                }
            }});

    }

    public void llamadoregkas(){
        contexto val = new contexto();

        contexto = this;

        new detlles_reglas_arquetipo(contexto);
    }
    public void llamadoReglas(View  eee){
        llamadoregkas();
    }


    public void relogueolvl6() {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("tablaPreregistro").get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if (documentSnapshot.exists()) {

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

                            l1.setText(val.getKeyCalabozolvl1());
                            l2.setText(val.getKeyCalabozolvl2());
                            l3.setText(val.getKeyCalabozolvl3());
                            l4.setText(val.getKeyCalabozolvl4());
                            l5.setText(val.getKeyCalabozolvl5());
                            l6.setText(val.getKeyCalabozolvl6());
                            l7.setText(val.getKeyCalabozolvl7());
                            l8.setText(val.getKeyCalabozolvl8());
                            l9.setText(val.getKeyCalabozolvl9());
                            l10.setText(val.getKeyCalabozolvl10());
                            l11.setText(val.getKeyCalabozolvl11());
                            l12.setText(val.getKeyCalabozolvl12());

                        }
                    }
                });
    }


    protected void onStop() {
        super.onStop();
        contexto val = new contexto();
        //   Toast.makeText(this, "OnStop:"+val.getKeyNick(), Toast.LENGTH_SHORT).show();
        relogueolvl6();

    }

    public void cerr(View sdfas) {
        contexto val = new contexto();


        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

    Context contexto;



    public void cerr1(View sdfas) {
        contexto val = new contexto();

        bdNeutral.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
       @Override
       public void onSuccess(DocumentSnapshot documentSnapshot) {

           if (documentSnapshot.exists()) {

               val.setKeyCalabozoActivo(documentSnapshot.getString("salakeycalabozo"));
               val.setKeyJ2(Integer.parseInt(val.getKeyCalabozoActivo()));

               if (val.getKeyJ2()==4) {
               if(val.getKeyCalabozolvl1().equals("eperando")){}else{
               if(val.getKeyCalabozolvl2().equals("eperando")){}else{
               if(val.getKeyCalabozolvl3().equals("eperando")){}else{
               if(val.getKeyCalabozolvl4().equals("eperando")){}else{
               if(val.getKeyCalabozolvl5().equals("eperando")){
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
               }else{
                   Toast.makeText(getApplicationContext(), "NO SE PUEDE REALIZAR EL RANDOM, debe asignar la sala deacuerdo con los participantes.", Toast.LENGTH_SHORT).show();
               } } } } }
               }

               if (val.getKeyJ2()==5) {

                   if(val.getKeyCalabozolvl1().equals("eperando")){}else{
                   if(val.getKeyCalabozolvl2().equals("eperando")){}else{
                   if(val.getKeyCalabozolvl3().equals("eperando")){}else{
                   if(val.getKeyCalabozolvl4().equals("eperando")){}else{
                   if(val.getKeyCalabozolvl5().equals("eperando")){ }else{
                   if(val.getKeyCalabozolvl6().equals("eperando")){
                       idV4.add(val.getKeyCalabozolvl1());
                       idV4.add(val.getKeyCalabozolvl2());
                       idV4.add(val.getKeyCalabozolvl3());
                       idV4.add(val.getKeyCalabozolvl4());
                       idV4.add(val.getKeyCalabozolvl5());
                   }else{
                       Toast.makeText(getApplicationContext(), "NO SE PUEDE REALIZAR EL RANDOM, debe asignar la sala deacuerdo con los participantes.", Toast.LENGTH_SHORT).show();
                   }
                   }
                   }
                   }
                   }
                   }





               }
               if (val.getKeyJ2()==6) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());

               }
               if (val.getKeyJ2()==7) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());
                   idV4.add(val.getKeyCalabozolvl7());
               }

               if (val.getKeyJ2()==8) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());
                   idV4.add(val.getKeyCalabozolvl7());
                   idV4.add(val.getKeyCalabozolvl8());
               }
               if (val.getKeyJ2()==9) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());
                   idV4.add(val.getKeyCalabozolvl7());
                   idV4.add(val.getKeyCalabozolvl8());
                   idV4.add(val.getKeyCalabozolvl9());
               }
               if (val.getKeyJ2()==10) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());
                   idV4.add(val.getKeyCalabozolvl7());
                   idV4.add(val.getKeyCalabozolvl8());
                   idV4.add(val.getKeyCalabozolvl9());
                   idV4.add(val.getKeyCalabozolvl10());
               }
               if (val.getKeyJ2()==11) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());
                   idV4.add(val.getKeyCalabozolvl7());
                   idV4.add(val.getKeyCalabozolvl8());
                   idV4.add(val.getKeyCalabozolvl9());
                   idV4.add(val.getKeyCalabozolvl10());
                   idV4.add(val.getKeyCalabozolvl11());
               }

               if (val.getKeyJ2()==12) {
                   idV4.add(val.getKeyCalabozolvl1());
                   idV4.add(val.getKeyCalabozolvl2());
                   idV4.add(val.getKeyCalabozolvl3());
                   idV4.add(val.getKeyCalabozolvl4());
                   idV4.add(val.getKeyCalabozolvl5());
                   idV4.add(val.getKeyCalabozolvl6());
                   idV4.add(val.getKeyCalabozolvl7());
                   idV4.add(val.getKeyCalabozolvl8());
                   idV4.add(val.getKeyCalabozolvl9());
                   idV4.add(val.getKeyCalabozolvl10());
                   idV4.add(val.getKeyCalabozolvl11());
                   idV4.add(val.getKeyCalabozolvl12());
               }

               try {


                   int integrantes = idV4.size();

                   if(integrantes == val.getKeyJ2()){
                       Toast.makeText(getApplicationContext(), "INICIALIZANDO COMPONENTES...", Toast.LENGTH_SHORT).show();

                       llamadoRandom();
                   }else{
                       Toast.makeText(getApplicationContext(), "DEBE ASIGNAR LA SALA DEACUERDO ALOS PARTICIPANTES INSCRIPTOS.", Toast.LENGTH_SHORT).show();
                   }

               }catch (Exception sdfs){Toast.makeText(contexto.getApplicationContext(), "ERROR B1", Toast.LENGTH_SHORT).show();}
           }
       }});



    }

    public void llamadoRandom(){  contexto val = new contexto();

        val.setKeyEntradaLose("silose");
        contexto = this;
        new detlles_random_xyz_v6(contexto);
    }
}

