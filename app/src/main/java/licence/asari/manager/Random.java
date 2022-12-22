package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
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


public class Random extends AppCompatActivity {


    private static Stack<String> idV1 = new Stack <String>  ();
    private static Stack<String> idV2 = new Stack <String>  ();
    private  Stack<String> idV3 = new Stack <String>  ();
    private static Stack<String> idV4 = new Stack <String>  ();
    private static Stack<String> idV5 = new Stack <String>  ();

    private HashMap<String, Object> datos = new HashMap<>();
    private HashMap<String, Object> datos1 = new HashMap<>();
    private HashMap<String,Object>  datos2 = new HashMap<>();
    private HashMap<String,Object>  datos3 = new HashMap<>();
     Stack<String> idV10 = new Stack <String>  ();
    int i =0, numeroAleatorio=0, contador;
    private TextView l1,l2,usuarioEspectador;
    private ImageButton b1;
    private RadioButton r1,r2,r3,r4,r5,r6,r7,r8;
    contexto val = new contexto();
    private EditText t1;
    FirebaseFirestore bdNeutral,dbPuntos,bdNeutro;
    private int contando =0, contadorRandom=0,cont=0;
    private Spinner sp1;
    RadioGroup rg1,rg2;

    private int verdad=0;

private  String finalizo="null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        l1 =(TextView) findViewById(R.id.l1);
        l2 =(TextView) findViewById(R.id.l2);
        b1 = (ImageButton) findViewById(R.id.ramdon_b1);
        usuarioEspectador=(TextView) findViewById(R.id.usuarioEspectador);
        bdNeutral = FirebaseFirestore.getInstance();
        dbPuntos  = FirebaseFirestore.getInstance();

        t1 = (EditText) findViewById(R.id.Ramdon_t1);
        bdNeutro = FirebaseFirestore.getInstance();
        r1=(RadioButton) findViewById(R.id.r5);
        r2=(RadioButton) findViewById(R.id.r6);
        r3=(RadioButton) findViewById(R.id.r7);
        r4=(RadioButton) findViewById(R.id.r8);
        r5=(RadioButton) findViewById(R.id.r9);  //r9  r10  r11 r12
        r6=(RadioButton) findViewById(R.id.r10);
        r7=(RadioButton) findViewById(R.id.r11);
        r8=(RadioButton) findViewById(R.id.r12);
        sp1 =(Spinner) findViewById(R.id.spJornada);
        rg1 = (RadioGroup) findViewById(R.id.on1);
        rg2 = (RadioGroup) findViewById(R.id.on2);

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeyCodigo(getIntent().getStringExtra("cdGremio"));
        val.setKeyDimencion(getIntent().getStringExtra("keyDimen"));
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

  //      Toast.makeText(getApplicationContext(), "key: " + val.getKeyIdGremio(), Toast.LENGTH_SHORT).show();

   bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override
   public void onSuccess(DocumentSnapshot documentSnapshot) {

   val.setKeyJ1(Integer.parseInt(documentSnapshot.getString("acceso"+ val.getKeyIdGremio())));

   //    Toast.makeText(getApplicationContext(), "key: " + val.getKeyJ1(), Toast.LENGTH_SHORT).show();

   bdNeutral.collection("BDgremio").document(val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        ArrayAdapter <String>  dat = null;
                        idV10.add("Elija un Titulo");   idV10.add("Jornada N1");   idV10.add("Jornada N2");   idV10.add("Jornada N3");   idV10.add("Jornada N4");   idV10.add("Jornada N5");
                        idV10.add("Jornada N6");   idV10.add("Jornada N7");   idV10.add("Jornada N8");   idV10.add("Jornada N9");   idV10.add("Jornada N10");   idV10.add("Jornada N11");   idV10.add("Jornada N12");


                        for(int a =1; a < (val.getKeyJ1()+1); a++) {


            //                Toast.makeText(getApplicationContext(), "Titulo: "+documentSnapshot.getString("mini" + a), Toast.LENGTH_SHORT).show();
                            if(documentSnapshot.getString("mini" + a).contains("false")){

                                val.setEyMini2("Cargando..");

                                idV10.add(val.getEyMini2());
                            }else {

                                idV10.add(documentSnapshot.getString("mini" + a));
                            }

                            if(a == val.getKeyJ1()){
                                dat = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV10);

                                sp1.setAdapter(dat);
                                break;
                            }
                        }

                    }
                });




            }
        });



        if(contando == 0){

        contando =1;
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("nick"));

        if(val.getSearKeyCodigo() > 100  && val.getSearKeyCodigo() < 600) {//amplitud 600mas




            bdNeutral.collection("BDgremio").document("100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    r1.setText(documentSnapshot.getString("dimencion_1"));
                    r2.setText(documentSnapshot.getString("dimencion_2"));
                    r3.setText(documentSnapshot.getString("dimencion_3"));
                    r4.setText(documentSnapshot.getString("dimencion_4"));
                    r5.setText(documentSnapshot.getString("dimencion_1"));
                    r6.setText(documentSnapshot.getString("dimencion_2"));
                    r7.setText(documentSnapshot.getString("dimencion_3"));
                    r8.setText(documentSnapshot.getString("dimencion_4"));
                    val.setKeyEscaneoGrenio("azul");
                }
            });
}else{

            if(val.getSearKeyCodigo() > 1100  && val.getSearKeyCodigo() < 1600) {//amplitud 600mas




                bdNeutral.collection("BDgremio").document("1100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        r1.setText(documentSnapshot.getString("dimencion_1"));
                        r2.setText(documentSnapshot.getString("dimencion_2"));
                        r3.setText(documentSnapshot.getString("dimencion_3"));
                        r4.setText(documentSnapshot.getString("dimencion_4"));
                        r5.setText(documentSnapshot.getString("dimencion_1"));
                        r6.setText(documentSnapshot.getString("dimencion_2"));
                        r7.setText(documentSnapshot.getString("dimencion_3"));
                        r8.setText(documentSnapshot.getString("dimencion_4"));
                        val.setKeyEscaneoGrenio("rojo");
                    }
                });
            }else{
                if(val.getSearKeyCodigo() > 2100  && val.getSearKeyCodigo() < 2600) {//amplitud 600mas




                    bdNeutral.collection("BDgremio").document("2100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            r1.setText(documentSnapshot.getString("dimencion_1"));
                            r2.setText(documentSnapshot.getString("dimencion_2"));
                            r3.setText(documentSnapshot.getString("dimencion_3"));
                            r4.setText(documentSnapshot.getString("dimencion_4"));
                            r5.setText(documentSnapshot.getString("dimencion_1"));
                            r6.setText(documentSnapshot.getString("dimencion_2"));   val.setKeyEscaneoGrenio("naranja");
                            r7.setText(documentSnapshot.getString("dimencion_3"));
                            r8.setText(documentSnapshot.getString("dimencion_4"));
                        }
                    });
                }else{

                    if(val.getSearKeyCodigo() > 3100  && val.getSearKeyCodigo() < 3600) {//amplitud 600mas




                        bdNeutral.collection("BDgremio").document("3100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                r1.setText(documentSnapshot.getString("dimencion_1"));
                                r2.setText(documentSnapshot.getString("dimencion_2"));
                                r3.setText(documentSnapshot.getString("dimencion_3"));
                                r4.setText(documentSnapshot.getString("dimencion_4"));
                                r5.setText(documentSnapshot.getString("dimencion_1"));   val.setKeyEscaneoGrenio("negro");
                                r6.setText(documentSnapshot.getString("dimencion_2"));
                                r7.setText(documentSnapshot.getString("dimencion_3"));
                                r8.setText(documentSnapshot.getString("dimencion_4"));
                            }
                        });
                    }  else{
                        if(val.getSearKeyCodigo() > 4100  && val.getSearKeyCodigo() < 4600) {//amplitud 600mas




                            bdNeutral.collection("BDgremio").document("4100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    r1.setText(documentSnapshot.getString("dimencion_1"));
                                    r2.setText(documentSnapshot.getString("dimencion_2"));
                                    r3.setText(documentSnapshot.getString("dimencion_3"));
                                    r4.setText(documentSnapshot.getString("dimencion_4"));
                                    r5.setText(documentSnapshot.getString("dimencion_1"));   val.setKeyEscaneoGrenio("calido");
                                    r6.setText(documentSnapshot.getString("dimencion_2"));
                                    r7.setText(documentSnapshot.getString("dimencion_3"));
                                    r8.setText(documentSnapshot.getString("dimencion_4"));
                                }
                            });
                        }
                    }
                }
            }

}







        }

      r1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

      if(r1.isChecked()) {
          val.setKeyDimencion(r1.getText().toString());
          val.setKeyJornada(sp1.getSelectedItem().toString());


if(val.getKeyJornada().contains("Elija un Titulo")){
 val.setKeyDimencion("");
val.setKeyJornada("");
Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
val.setKeyExiste("titulo");
}else {
    if(idV1.size()== 0){}else{
        idV1.clear();
    }
    val.setKeyVerdad("of");
    val.setKeyExiste("elija");
    try { if (verdad==0) {
        val.setKeygrupoAleatorioVerdadero("false");




    bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {




            if (task.isSuccessful()) {

                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(document.getString("dimencion").equals(val.getKeyDimencion())){

                        if(!document.getString("R"+val.getKeyJornada()).equals("null")){
                            Toast.makeText(getApplicationContext(), "Esta jornada esta en uso para esta dimencion.", Toast.LENGTH_SHORT).show();

  //  r1.setEnabled(false);
    rg1.clearCheck();
    rg2.clearCheck();
      val.setKeyDimencion("");
    val.setKeyJornada("");

                            break;
                        }else{

                            bdNeutral.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("dimencion",r3.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if(task.isSuccessful()) {
                                        for(QueryDocumentSnapshot document : task.getResult()){
                                            idV1.add(document.getString("nick")); }

                        //                Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                    }
                                }});
                            val.setKeyVerdad("on");
                            break;
                        }
                    }else{
                  //      Toast.makeText(getApplicationContext(), "NO EXISTEN DATOS N1", Toast.LENGTH_SHORT).show();
                                        rg1.clearCheck();
                                        rg2.clearCheck();
                                        val.setKeyDimencion("");
                                        val.setKeyJornada("");
                    }
                }


 try {
if(val.getKeyVerdad().equals("of")){
bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
@Override
 public void onComplete(@NonNull Task<QuerySnapshot> task) {

  if(task.isSuccessful()) {
 for(QueryDocumentSnapshot document : task.getResult()){
 idV1.add(document.getString("nick")); }
      Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
  } }}); } }catch (Exception  sdf){ }

}else{ } }});


}else{
        if(val.getKeygrupoAleatorio_1().contains(val.getKeyDimencion())){
            Toast.makeText(getApplicationContext(), "No se pueden las mismas dimenciones", Toast.LENGTH_SHORT).show();
            rg1.clearCheck();
            rg2.clearCheck();

            val.setKeyDimencion("");
            val.setKeyJornada("");
            val.setKeygrupoAleatorio_1("");
        }else{
            bdNeutro.collection("BD" + val.getKeyEscaneoGrenio())
                    .whereEqualTo("dimencion", val.getKeyDimencion()).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    idV1.add(document.getString("nick"));

                                }
                                Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                            } }}); }

}}catch (Exception dfsf){}


}

}



});


r2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

if(r2.isChecked()) {

val.setKeyDimencion(r2.getText().toString());
val.setKeyJornada(sp1.getSelectedItem().toString());


    if(val.getKeyJornada().contains("Elija un Titulo")){

val.setKeyDimencion("");
val.setKeyJornada("");
Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
val.setKeyExiste("titulo");
}else {


        if(idV1.size()== 0){}else{
            idV1.clear();
        }

        val.setKeyExiste("elija");
        val.setKeyVerdad("of");
        try { if (verdad==0) {
            val.setKeygrupoAleatorioVerdadero("false");



        bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(document.getString("dimencion").equals(val.getKeyDimencion())){
                            if(!document.getString("R"+val.getKeyJornada()).equals("null")){
                                Toast.makeText(getApplicationContext(), "Esta jornada esta en uso para esta dimencion.", Toast.LENGTH_SHORT).show();

                          //      r2.setEnabled(false);
                                rg1.clearCheck();
                                rg2.clearCheck();
                                  val.setKeyDimencion("");
                                val.setKeyJornada("");

                                break;
                            }else{

                                bdNeutral.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("dimencion",r3.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if(task.isSuccessful()) {
                                            for(QueryDocumentSnapshot document : task.getResult()){
                                                idV1.add(document.getString("nick")); }

                                            Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                        }
                                    }});
                                break;
                            }
                        }
                    }
                    try {
                        if(val.getKeyVerdad().equals("of")){
                            bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                    if(task.isSuccessful()) {
                                        for(QueryDocumentSnapshot document : task.getResult()){
                                            idV1.add(document.getString("nick")); }
                                        Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                    } }}); } }catch (Exception  sdf){ }


                }
            }
        });
        }else{

            if(val.getKeygrupoAleatorio_1().contains(val.getKeyDimencion())){
                Toast.makeText(getApplicationContext(), "No se pueden las mismas dimenciones", Toast.LENGTH_SHORT).show();
                rg1.clearCheck();
                rg2.clearCheck();

                val.setKeyDimencion("");
                val.setKeyJornada("");
                val.setKeygrupoAleatorio_1("");
            }else{
                bdNeutro.collection("BD" + val.getKeyEscaneoGrenio())
                        .whereEqualTo("dimencion", val.getKeyDimencion()).get().
                        addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        idV1.add(document.getString("nick"));

                                    }
                                    Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                } }}); }

        }
        }catch (Exception dfsf){}
}
}
});




r3.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
if(r3.isChecked()) {

    contexto val = new contexto();
    val.setKeyDimencion(r3.getText().toString());
    val.setKeyJornada(sp1.getSelectedItem().toString());

    if(val.getKeyJornada().contains("Elija un Titulo")){
        Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();

        val.setKeyExiste("titulo");
        rg1.clearCheck();
        rg2.clearCheck();
        val.setKeyDimencion("");
        val.setKeyJornada("");


}else {

        if (idV1.size() == 0) {
        } else {
            idV1.clear();
        }

        val.setKeyExiste("elija");
        val.setKeyVerdad("of");

        Toast.makeText(getApplicationContext(), "VEDAD:  " + verdad, Toast.LENGTH_SHORT).show();
        try {
            if (verdad == 0) {
                val.setKeygrupoAleatorioVerdadero("false");




        bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("dimencion", val.getKeyDimencion()).
                get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getString("dimencion").equals(val.getKeyDimencion())) {
                            if (!document.getString("R" + val.getKeyJornada()).equals("null")) {
                                Toast.makeText(getApplicationContext(), "Esta jornada esta en uso para esta dimencion.", Toast.LENGTH_SHORT).show();

                                // r3.setEnabled(false);
                                rg1.clearCheck();
                                rg2.clearCheck();

                                val.setKeyDimencion("");
                                val.setKeyJornada("");

                                break;
                            } else {

                                bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).whereEqualTo("dimencion", r3.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                idV1.add(document.getString("nick"));
                                            }

                                            Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                break;
                            }
                        }
                    }
                    try {
                        if (val.getKeyVerdad().equals("of")) {
                            bdNeutro.collection("BD" + val.getKeyEscaneoGrenio())
                                    .whereEqualTo("dimencion", val.getKeyDimencion()).get().
                                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            idV1.add(document.getString("nick"));

                                        }
                                        Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    } catch (Exception sdf) {
                    }

                }
            }
        });

    }else{

   if(val.getKeygrupoAleatorio_1().contains(val.getKeyDimencion())){
       Toast.makeText(getApplicationContext(), "No se pueden las mismas dimenciones", Toast.LENGTH_SHORT).show();
       rg1.clearCheck();
       rg2.clearCheck();

       val.setKeyDimencion("");
       val.setKeyJornada("");
       val.setKeygrupoAleatorio_1("");
}else{
 bdNeutro.collection("BD" + val.getKeyEscaneoGrenio())
.whereEqualTo("dimencion", val.getKeyDimencion()).get().
addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
@Override
public void onComplete(@NonNull Task<QuerySnapshot> task) {

if (task.isSuccessful()) {
for (QueryDocumentSnapshot document : task.getResult()) {
idV1.add(document.getString("nick"));

}
Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
} }}); }
}

        } catch (Exception dfsf) {
        }
}

}

});
//////////////////////-------------R4------------------------////////////////////////////////////
r4.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
if(r4.isChecked()) {
 contexto val = new contexto();

val.setKeyDimencion(r4.getText().toString());
val.setKeyJornada(sp1.getSelectedItem().toString());
if(val.getKeyJornada().contains("Elija un Titulo")){
Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
val.setKeyExiste("titulo");
val.setKeyDimencion("");
val.setKeyJornada("");
}else {

    if(idV1.size()== 0){}else{
        idV1.clear();
    }

    val.setKeyExiste("elija");
    val.setKeyVerdad("of");
    try { if (verdad==0) {
        val.setKeygrupoAleatorioVerdadero("false");


    bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    if(document.getString("dimencion").equals(val.getKeyDimencion())){
                        if(!document.getString("R"+val.getKeyJornada()).equals("null")){
                            Toast.makeText(getApplicationContext(), "Esta jornada esta en uso para esta dimencion.", Toast.LENGTH_SHORT).show();

  //  r4.setEnabled(false);
    rg1.clearCheck();
    rg2.clearCheck();
      val.setKeyDimencion("");
    val.setKeyJornada("");

                            break;
                        }else{

                            bdNeutral.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("dimencion",r3.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if(task.isSuccessful()) {
                                        for(QueryDocumentSnapshot document : task.getResult()){
                                            idV1.add(document.getString("nick")); }

                                        Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                    }
                                }});
                            break;
                        }
                    }
                }

                try {
                    if(val.getKeyVerdad().equals("of")){
                        bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if(task.isSuccessful()) {
                                    for(QueryDocumentSnapshot document : task.getResult()){
                                        idV1.add(document.getString("nick")); }
                                    Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                                } }}); } }catch (Exception  sdf){ }
            }
        }
    });



    }else {

        if(val.getKeygrupoAleatorio_1().contains(val.getKeyDimencion())){
            Toast.makeText(getApplicationContext(), "No se pueden las mismas dimenciones", Toast.LENGTH_SHORT).show();
            rg1.clearCheck();
            rg2.clearCheck();

            val.setKeyDimencion("");
            val.setKeyJornada("");
            val.setKeygrupoAleatorio_1("");
        }else{
            bdNeutro.collection("BD" + val.getKeyEscaneoGrenio())
                    .whereEqualTo("dimencion", val.getKeyDimencion()).get().
                    addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    idV1.add(document.getString("nick"));

                                }
                                Toast.makeText(getApplicationContext(), "Tamaño: " + idV1, Toast.LENGTH_SHORT).show();
                            } }}); }


    }
    }catch (Exception dfsf){}



}}});


        r5.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
            if(r5.isChecked()) {

                if(idV4.size()== 0){

                }else{
                    idV4.clear();
                }
              //  contexto val = new contexto();
                verdad =1;
                val.setKeygrupoAleatorioVerdadero("true");
                val.setKeygrupoAleatorio_1(r5.getText().toString());

//                Toast.makeText(getApplicationContext(), "SELECCION:  "+ val.getKeygrupoAleatorioVerdadero() + "   DIMENCION:   " + val.getKeygrupoAleatorio_1(), Toast.LENGTH_SHORT).show();


                val.setKeyJornada(sp1.getSelectedItem().toString());
                if(val.getKeyJornada().contains("Elija un Titulo")){
                    rg1.clearCheck();
                    rg2.clearCheck();

                    Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
                    val.setKeyExiste("titulo");
                    val.setKeyDimencion("");
                    val.setKeyJornada("");



                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    val.setKeygrupoAleatorio_1("");
                }else {

                    bdNeutral.collection("BD" + val.getKeyEscaneoGrenio())
                            .whereEqualTo("dimencion", val.getKeygrupoAleatorio_1()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    idV4.add(document.getString("nick"));
                                }
                                Toast.makeText(getApplicationContext(), verdad+ "]CONTENIDO:  " + idV4, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
            }
        });

        r6.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
            if(r6.isChecked()) {
                contexto val = new contexto(); val.setKeyDimencion(r6.getText().toString());
                val.setKeygrupoAleatorio_1(r6.getText().toString());
                val.setKeygrupoAleatorioVerdadero("true");
                verdad =1;
                if(idV4.size()== 0){

                }else{
                    idV4.clear();
                }
                val.setKeyJornada(sp1.getSelectedItem().toString());
                if(val.getKeyJornada().contains("Elija un Titulo")){
                    Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
                    val.setKeyExiste("titulo");
                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    rg1.clearCheck();
                    rg2.clearCheck();

                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    val.setKeygrupoAleatorio_1("");
                }else {


                    bdNeutral.collection("BD" + val.getKeyEscaneoGrenio())
                            .whereEqualTo("dimencion", val.getKeygrupoAleatorio_1()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    idV4.add(document.getString("nick"));
                                }
                                Toast.makeText(getApplicationContext(), verdad+ "]CONTENIDO:  " + idV4, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        r7.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
            if(r7.isChecked()) {
                verdad =1;
                val.setKeygrupoAleatorioVerdadero("true");
                val.setKeygrupoAleatorio_1(r7.getText().toString());
                //      Toast.makeText(getApplicationContext(), "SELECCION:  "+ val.getKeygrupoAleatorioVerdadero() + "   DIMENCION:   " + val.getKeygrupoAleatorio_1(), Toast.LENGTH_SHORT).show();
                if (idV4.size() == 0) {

                } else {
                    idV4.clear();
                }

                val.setKeyJornada(sp1.getSelectedItem().toString());
                if(val.getKeyJornada().contains("Elija un Titulo")){
                    Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
                    val.setKeyExiste("titulo");
                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    rg1.clearCheck();
                    rg2.clearCheck();

                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    val.setKeygrupoAleatorio_1("");
                }else {
                bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).whereEqualTo("dimencion", val.getKeygrupoAleatorio_1()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                idV4.add(document.getString("nick"));
                            }
                            Toast.makeText(getApplicationContext(), verdad+ "]  CONTENIDO:  " + idV4, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            }
        });

        r8.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
            if(r8.isChecked()) {
                contexto val = new contexto();

                val.setKeygrupoAleatorio_1(r8.getText().toString());
                val.setKeygrupoAleatorioVerdadero("true");
                //      Toast.makeText(getApplicationContext(), "SELECCION:  "+ val.getKeygrupoAleatorioVerdadero() + "   DIMENCION:   " + val.getKeygrupoAleatorio_1(), Toast.LENGTH_SHORT).show();
                if (idV4.size() == 0) {

                } else {
                    idV4.clear();
                }
                verdad =1;
                val.setKeyJornada(sp1.getSelectedItem().toString());
                if(val.getKeyJornada().contains("Elija un Titulo")){
                    Toast.makeText(Random.this, "ELIJA UN TITULO PARA ESTA DIMENCION", Toast.LENGTH_SHORT).show();
                    val.setKeyExiste("titulo");
                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    rg1.clearCheck();
                    rg2.clearCheck();

                    val.setKeyDimencion("");
                    val.setKeyJornada("");
                    val.setKeygrupoAleatorio_1("");
                }else {
                bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).whereEqualTo("dimencion", val.getKeygrupoAleatorio_1()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                idV4.add(document.getString("nick"));
                            }
                            Toast.makeText(getApplicationContext(), verdad+ "]CONTENIDO:  " + idV4, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            }
        });


    } //  r5  r6  r7 r8





public void starRandom(View sdf){




  if (val.getKeygrupoAleatorioVerdadero().contains("false")) {
              Toast.makeText(getApplicationContext(), "STAND", Toast.LENGTH_SHORT).show();

      if(val.getKeyExiste().contains("titulo")){
          Toast.makeText(this, "Debe volver a elegir la Dimencion", Toast.LENGTH_SHORT).show();
          rg1.clearCheck();
          rg2.clearCheck();
          if(idV1.size() >=1){
              idV1.clear();
          }
      }else{

          if (idV1.size() == 1) {
              contexto val = new contexto();
              val.setKeyExpectador(idV1.get(0));
              usuarioEspectador.setText("Usuario Espectador: " + val.getKeyExpectador());

              try {

                  bdNeutro.collection("BDAsary").document(idV1.remove(0))
                          .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                      @Override
                      public void onSuccess(DocumentSnapshot documentSnapshot) {

                          if (documentSnapshot.exists()) {

                              val.setKeyCoidigo3(documentSnapshot.getString("codigo"));

                              bdNeutro.collection("TablaPuntoCabeza").document(val.getKeyCoidigo3())
                                      .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                  @Override
                                  public void onSuccess(DocumentSnapshot documentSnapshot) {

                                      if (documentSnapshot.exists()) {


                                      }else{
                                          Toast.makeText(getApplicationContext(), "Finalizo el ramdom", Toast.LENGTH_SHORT).show();
                                          cont = cont+1;
                                          val.setKeyId1(String.valueOf(cont));
                                          espectador();
                                          bdNeutro.collection("TablaPuntoCabeza").document(val.getKeyCoidigo3()).set(datos2);
                                          r1.setEnabled(false);
                                          r5.setEnabled(false);
                                          rg1.clearCheck();
                                          rg2.clearCheck();
                                          contadorRandom=0;

                                          cont=0;
                                      } }}); }}}); }catch (Exception sfds){
                  Toast.makeText(getApplicationContext(), "error espectador", Toast.LENGTH_SHORT).show();
              } }else {




              if (val.getKeyJornada().contains("Elija Titulo")) {
                  Toast.makeText(this, "Elija el titulo ramdom", Toast.LENGTH_SHORT).show();
                  rg1.clearCheck();
                  rg2.clearCheck();
                  idV1.clear();
 } else {

                  randomDtandar();
 } } }

}else{


if(!val.getKeygrupoAleatorio_1().equals("")){

if(val.getKeyDimencion().contains(val.getKeygrupoAleatorio_1())){
   Toast.makeText(getApplicationContext(), "No se puede las misma dimencion", Toast.LENGTH_SHORT).show();
}else{




  if(idV4.size()==0&&idV1.size()==1){

     idV5.add(idV1.get(0));
     idV1.remove(0);
      rg1.clearCheck();
      rg2.clearCheck();
      val.setKeygrupoAleatorioVerdadero("false");
      val.setKeygrupoAleatorio_1("");

  }else{
  if(idV4.size()==1&&idV1.size()==0) {
      idV5.add(idV4.get(0));
      idV4.remove(0);
      rg1.clearCheck();
      rg2.clearCheck();
      val.setKeygrupoAleatorioVerdadero("false");
      val.setKeygrupoAleatorio_1("");



  }else{
  if(idV4.size()==0&&idV1.size()==2) {
      idV5.add(idV1.get(0));
      idV5.add(idV1.get(1));
      idV1.remove(0);
      idV1.remove(1);
      rg1.clearCheck();
      rg2.clearCheck();
      val.setKeygrupoAleatorioVerdadero("false");
      val.setKeygrupoAleatorio_1("");


  }else{

      if(idV4.size()==2&&idV1.size()==0) {
          idV5.add(idV4.get(0));
          idV5.add(idV4.get(1));
          idV4.remove(0);
          idV4.remove(1);
          rg1.clearCheck();
          rg2.clearCheck();
          val.setKeygrupoAleatorioVerdadero("false");
          val.setKeygrupoAleatorio_1("");

}else{

          if(idV4.size()==3&&idV1.size()==0) {
              idV5.add(idV4.get(0));
              idV5.add(idV4.get(1));
              idV5.add(idV4.get(2));
              idV4.remove(0);
              idV4.remove(1);
              idV4.remove(2);
              rg1.clearCheck();
              rg2.clearCheck();
              val.setKeygrupoAleatorioVerdadero("false");
              val.setKeygrupoAleatorio_1("");

          }else{

              if(idV4.size()==0&&idV1.size()==3) {
                  idV5.add(idV1.get(0));
                  idV5.add(idV1.get(1));
                  idV5.add(idV1.get(2));
                  idV1.remove(0);
                  idV1.remove(1);
                  idV1.remove(2);
                  rg1.clearCheck();
                  rg2.clearCheck();
                  val.setKeygrupoAleatorioVerdadero("false");
                  val.setKeygrupoAleatorio_1("");

}else{
                  if(idV4.size()==0&&idV1.size()==4) {
                      idV5.add(idV1.get(0));
                      idV5.add(idV1.get(1));
                      idV5.add(idV1.get(2));
                      idV5.add(idV1.get(3));
                      idV1.remove(0);
                      idV1.remove(1);
                      idV1.remove(2);
                      idV1.remove(3);
                      rg1.clearCheck();
                      rg2.clearCheck();
                      val.setKeygrupoAleatorioVerdadero("false");
                      val.setKeygrupoAleatorio_1("");

}else{
                      if(idV4.size()==4&&idV1.size()==0) {
                          idV5.add(idV4.get(0));
                          idV5.add(idV4.get(1));
                          idV5.add(idV4.get(2));
                          idV5.add(idV4.get(3));
                          idV4.remove(0);
                          idV4.remove(1);
                          idV4.remove(2);
                          idV4.remove(3);
                          rg1.clearCheck();
                          rg2.clearCheck();
                          val.setKeygrupoAleatorioVerdadero("false");
                          val.setKeygrupoAleatorio_1("");

}else{
                          if(idV4.size()==5&&idV1.size()==0) {
                              idV5.add(idV4.get(0));
                              idV5.add(idV4.get(1));
                              idV5.add(idV4.get(2));
                              idV5.add(idV4.get(3));
                              idV5.add(idV4.get(4));
                              idV4.remove(0);
                              idV4.remove(1);
                              idV4.remove(2);
                              idV4.remove(3);
                              idV4.remove(4);
                              rg1.clearCheck();
                              rg2.clearCheck();
                              val.setKeygrupoAleatorioVerdadero("false");
                              val.setKeygrupoAleatorio_1("");

}else{
                              if(idV4.size()==0&&idV1.size()==1) {
                                  idV5.add(idV1.get(0));
                                  idV5.add(idV1.get(1));
                                  idV5.add(idV1.get(2));
                                  idV5.add(idV1.get(3));
                                  idV5.add(idV1.get(4));
                                  idV1.remove(0);
                                  idV1.remove(1);
                                  idV1.remove(2);
                                  idV1.remove(3);
                                  idV1.remove(4);
                                  rg1.clearCheck();
                                  rg2.clearCheck();
                                  val.setKeygrupoAleatorioVerdadero("false");
                                  val.setKeygrupoAleatorio_1("");

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


    if(idV4.size()==0&&idV1.size()==0) {
        Toast.makeText(getApplicationContext(), "FINALIZO RANDOM :  " + idV5, Toast.LENGTH_SHORT).show();
        rg1.clearCheck();
        rg2.clearCheck();
        val.setKeygrupoAleatorioVerdadero("false");
        val.setKeygrupoAleatorio_1("");
        verdad=0;
    }else{
  try {
      int said1 = idV4.size();
      numeroAleatorio = (int) (Math.random() * said1); // numero aleatorio del stack
      val.setKeyDuelista(idV4.get(numeroAleatorio));//nombre duelista

      idV4.remove(numeroAleatorio);  // eliminamos el duelista del stak

      l1.setText(val.getKeyDuelista());  // publicacmos

      int said2 = idV1.size();
      numeroAleatorio = (int) (Math.random() * said2);
      val.setKeyDuelista2(idV1.get(numeroAleatorio));
      l2.setText(val.getKeyDuelista2());
      idV1.remove(numeroAleatorio);
  }catch (Exception  dfs){


  }}
}

}
          // val.setKeygrupoAleatorioVerdadero("false");

}



}




public void randomDtandar(){
    val.setKeyJornada(sp1.getSelectedItem().toString());
    while (cont >= 1000) {
        cont = 0;
    }
    cont++;


    int said1 = idV1.size();
    numeroAleatorio = (int) (Math.random() * said1);
    val.setKeyDuelista(idV1.get(numeroAleatorio));

    idV1.remove(numeroAleatorio);

    l1.setText(val.getKeyDuelista());

    int said2 = idV1.size();
    numeroAleatorio = (int) (Math.random() * said2);
    val.setKeyDuelista2(idV1.get(numeroAleatorio));
    l2.setText(val.getKeyDuelista2());
    idV1.remove(numeroAleatorio);

    datos.put(val.getKeyDuelista(), val.getKeyDuelista2());


    bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).whereEqualTo("nick", val.getKeyDuelista()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {

            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    val.setKeyCodigo(document.getString("codigo"));
                    val.setKeyDimencion(document.getString("dimencion"));
                    try {
                        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    update();
                                    bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(datos2);
                                } else {
                                    duelista1();
                                    bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).set(datos2);
                                }
                            }
                        });
                    } catch (Exception sdfs) {
                        Toast.makeText(getApplicationContext(), "error BD1", Toast.LENGTH_SHORT).show();
                    }

                    HashMap<String, Object> registro = new HashMap<>();
                    registro.put("rival", val.getKeyDuelista2());
                    bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).update(registro);
                }
            }
        }
    });

    bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).whereEqualTo("nick", val.getKeyDuelista2()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {

                    val.setKeyCodigo2(document.getString("codigo"));
                    val.setKeyDimencion2(document.getString("dimencion"));

                    HashMap<String, Object> registro1 = new HashMap<>();
                    registro1.put("rival", val.getKeyDuelista());

                    bdNeutral.collection("BD" + val.getKeyEscaneoGrenio()).document(val.getKeyCodigo2()).update(registro1);


                    try {
                        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {

                                    update1();
                                    bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(datos2);
                                } else {

                                    duelista2();
                                    bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).set(datos2);
                                }
                            }
                        });
                    } catch (Exception sdfs) {
                        Toast.makeText(getApplicationContext(), "error Noexiste #2", Toast.LENGTH_SHORT).show();
                    }


                    if (finalizo.equals("true")) {
                        contadorRandom = 0;
                        cont = 0;
                    }
                }
            }
        }
    });


    if (idV1.empty()) {

        usuarioEspectador.setText("Usuario Espectador: No hay");

        idV1.clear();
        r1.setEnabled(false);
        r5.setEnabled(false);
        rg1.clearCheck();
        rg2.clearCheck();
        val.setKeyExpectador("null");
        bdNeutral.collection(val.getKeyJornada()).document(val.getKeyDimencion()).set(datos);


        Toast.makeText(this, "FINALIZO RANDOM ", Toast.LENGTH_SHORT).show();
        b1.setEnabled(false);
        finalizo = "true";

    }
    contadorRandom++;

}

    @Override
    protected void onStart() {
        super.onStart();
        //  Toast.makeText(this, "OnStart tABLA FINAL", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        //  Toast.makeText(this, "OnResume  tABLA FINAL", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Toast.makeText(this, "OnPause tABLA FINAL" , Toast.LENGTH_SHORT).show();





    }
    @Override
    protected void onStop() {
        super.onStop();
        // Toast.makeText(this, "OnStop  tABLA FINAL", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();


        finishAffinity();
    }


    public void update1(){


        if(val.getKeyJornada().contains("Jornada N1")) { datos2.put("RJornada N1", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N2")) { datos2.put("RJornada N2",val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N3")) { datos2.put("RJornada N3", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N4")) { datos2.put("RJornada N4", val.getKeyDuelista());}
        if(val.getKeyJornada().contains("Jornada N5")) { datos2.put("RJornada N5", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N6")) { datos2.put("RJornada N6", val.getKeyDuelista());}
        if(val.getKeyJornada().contains("Jornada N7")) { datos2.put("RJornada N7", val.getKeyDuelista());}

        if(val.getKeyJornada().contains("Jornada N8")) { datos2.put("RJornada N8",val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N9")) { datos2.put("RJornada N9", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N10")) { datos2.put("RJornada N10", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N11")) { datos2.put("RJornada N11", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("Jornada N12")) { datos2.put("RJornada N12", val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("caparazon")) { datos2.put("Rcaparazon", val.getKeyDuelista());}

        if(val.getKeyJornada().contains("escarlata")) { datos2.put("Rescarlata",val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("garras")) { datos2.put("Rgarras",val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("aullido")) { datos2.put("Raullido",val.getKeyDuelista()); }
        if(val.getKeyJornada().contains("tempestad")) {datos2.put("Rtempestad", val.getKeyDuelista());}

    }



    public void update(){


        if(val.getKeyJornada().contains("Jornada N1")) { datos2.put("RJornada N1", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N2")) { datos2.put("RJornada N2",val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N3")) { datos2.put("RJornada N3", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N4")) { datos2.put("RJornada N4", val.getKeyDuelista2());}
        if(val.getKeyJornada().contains("Jornada N5")) { datos2.put("RJornada N5", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N6")) { datos2.put("RJornada N6", val.getKeyDuelista2());}
        if(val.getKeyJornada().contains("Jornada N7")) { datos2.put("RJornada N7", val.getKeyDuelista2());}

        if(val.getKeyJornada().contains("Jornada N8")) { datos2.put("RJornada N8",val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N9")) { datos2.put("RJornada N9", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N10")) { datos2.put("RJornada N10", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N11")) { datos2.put("RJornada N11", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("Jornada N12")) { datos2.put("RJornada N12", val.getKeyDuelista2()); }
        if(val.getKeyJornada().contains("caparazon")) { datos2.put("Rcaparazon", val.getKeyDuelista2());}

            if(val.getKeyJornada().contains("escarlata")) { datos2.put("Rescarlata",val.getKeyDuelista2()); }
            if(val.getKeyJornada().contains("garras")) { datos2.put("Rgarras",val.getKeyDuelista2()); }
            if(val.getKeyJornada().contains("aullido")) { datos2.put("Raullido",val.getKeyDuelista2()); }
            if(val.getKeyJornada().contains("tempestad")) {datos2.put("Rtempestad", val.getKeyDuelista2());}

}
public void duelista1(){


    datos2.put("id", String.valueOf(cont));
    datos2.put("nick", val.getKeyDuelista());
    datos2.put("codigo", val.getKeyCodigo());
    datos2.put("dimencion", val.getKeyDimencion());

    datos2.put("PJornada N1", "0");
    datos2.put("PJornada N2","0");
    datos2.put("PJornada N3", "0");
    datos2.put("PJornada N4", "0");
    datos2.put("PJornada N5", "0");
    datos2.put("PJornada N6", "0");
    datos2.put("PJornada N7", "0");
    datos2.put("PJornada N8", "0");
    datos2.put("PJornada N9", "0");
    datos2.put("PJornada N10", "0");
    datos2.put("PJornada N11", "0");
    datos2.put("PJornada N12", "0");
    datos2.put("Pcaparazon", "0");
    datos2.put("Pescarlata", "0");
    datos2.put("Pgarras", "0");
    datos2.put("Paullido", "0");
    datos2.put("Ptempestad", "0");

    datos2.put("CJornada N1","0");
    datos2.put("CJornada N2","0");
    datos2.put("CJornada N3", "0");
    datos2.put("CJornada N4", "0");
    datos2.put("CJornada N5", "0");
    datos2.put("CJornada N6", "0");
    datos2.put("CJornada N7", "0");
    datos2.put("CJornada N8", "0");
    datos2.put("CJornada N9", "0");
    datos2.put("CJornada N10", "0");
    datos2.put("CJornada N11", "0");
    datos2.put("CJornada N12", "0");
    datos2.put("Ccaparazon", "0");
    datos2.put("Cescarlata", "0");
    datos2.put("Cgarras", "0");
    datos2.put("Caullido", "0");
    datos2.put("Ctempestad", "0");

    datos2.put("VJornada N1", "0");
    datos2.put("VJornada N2","0");
    datos2.put("VJornada N3", "0");
    datos2.put("VJornada N4", "0");
    datos2.put("VJornada N5", "0");
    datos2.put("VJornada N6", "0");
    datos2.put("VJornada N7", "0");
    datos2.put("VJornada N8", "0");
    datos2.put("VJornada N9", "0");
    datos2.put("VJornada N10", "0");
    datos2.put("VJornada N11", "0");
    datos2.put("VJornada N12", "0");
    datos2.put("Vcaparazon", "0");
    datos2.put("Vescarlata", "0");
    datos2.put("Vgarras", "0");
    datos2.put("Vaullido", "0");
    datos2.put("Vtempestad", "0");




    if(val.getKeyJornada().contains("Jornada N1")) {
            datos2.put("RJornada N1", val.getKeyDuelista2()); datos2.put("RJornada N6","null"); datos2.put("RJornada N11","null");
            datos2.put("RJornada N2","null"); datos2.put("RJornada N7","null"); datos2.put("RJornada N12","null");
            datos2.put("RJornada N3","null"); datos2.put("RJornada N8","null");
            datos2.put("RJornada N4","null"); datos2.put("RJornada N9","null");
            datos2.put("RJornada N5","null"); datos2.put("RJornada N10","null");
            datos2.put("Rcaparazon", "null");
            datos2.put("Rescarlata", "null");
            datos2.put("Rgarras", "null");
            datos2.put("Raullido", "null");
            datos2.put("Rtempestad", "null");
        }


}

    public void espectador(){


        datos2.put("id", String.valueOf((cont)));
        datos2.put("nick", val.getKeyExpectador());
        datos2.put("codigo", val.getKeyCoidigo3());
        datos2.put("dimencion", val.getKeyDimencion());

        datos2.put("PJornada N1", "0");
        datos2.put("PJornada N2","0");
        datos2.put("PJornada N3", "0");
        datos2.put("PJornada N4", "0");
        datos2.put("PJornada N5", "0");
        datos2.put("PJornada N6", "0");
        datos2.put("PJornada N7", "0");
        datos2.put("PJornada N8", "0");
        datos2.put("PJornada N9", "0");
        datos2.put("PJornada N10", "0");
        datos2.put("PJornada N11", "0");
        datos2.put("PJornada N12", "0");
        datos2.put("Pcaparazon", "0");
        datos2.put("Pescarlata", "0");
        datos2.put("Pgarras", "0");
        datos2.put("Paullido", "0");
        datos2.put("Ptempestad", "0");

        datos2.put("CJornada N1","0");
        datos2.put("CJornada N2","0");
        datos2.put("CJornada N3", "0");
        datos2.put("CJornada N4", "0");
        datos2.put("CJornada N5", "0");
        datos2.put("CJornada N6", "0");
        datos2.put("CJornada N7", "0");
        datos2.put("CJornada N8", "0");
        datos2.put("CJornada N9", "0");
        datos2.put("CJornada N10", "0");
        datos2.put("CJornada N11", "0");
        datos2.put("CJornada N12", "0");
        datos2.put("Ccaparazon", "0");
        datos2.put("Cescarlata", "0");
        datos2.put("Cgarras", "0");
        datos2.put("Caullido", "0");
        datos2.put("Ctempestad", "0");

        datos2.put("VJornada N1", "0");
        datos2.put("VJornada N2","0");
        datos2.put("VJornada N3", "0");
        datos2.put("VJornada N4", "0");
        datos2.put("VJornada N5", "0");
        datos2.put("VJornada N6", "0");
        datos2.put("VJornada N7", "0");
        datos2.put("VJornada N8", "0");
        datos2.put("VJornada N9", "0");
        datos2.put("VJornada N10", "0");
        datos2.put("VJornada N11", "0");
        datos2.put("VJornada N12", "0");
        datos2.put("Vcaparazon", "0");
        datos2.put("Vescarlata", "0");
        datos2.put("Vgarras", "0");
        datos2.put("Vaullido", "0");
        datos2.put("Vtempestad", "0");




        if(val.getKeyJornada().contains("Jornada N1")) {
            datos2.put("RJornada N1", "null"); datos2.put("RJornada N6","null"); datos2.put("RJornada N11","null");
            datos2.put("RJornada N2","null"); datos2.put("RJornada N7","null"); datos2.put("RJornada N12","null");
            datos2.put("RJornada N3","null"); datos2.put("RJornada N8","null");
            datos2.put("RJornada N4","null"); datos2.put("RJornada N9","null");
            datos2.put("RJornada N5","null"); datos2.put("RJornada N10","null");
            datos2.put("Rcaparazon", "null");
            datos2.put("Rescarlata", "null");
            datos2.put("Rgarras", "null");
            datos2.put("Raullido", "null");
            datos2.put("Rtempestad", "null");
        }


    }


public void duelista2(){

    datos2.put("id", String.valueOf(cont+"b"));
    datos2.put("nick", val.getKeyDuelista2());
    datos2.put("codigo", val.getKeyCodigo2());
    datos2.put("dimencion", val.getKeyDimencion2());

    datos2.put("PJornada N1","0");
    datos2.put("PJornada N2","0");
    datos2.put("PJornada N3", "0");
    datos2.put("PJornada N4", "0");
    datos2.put("PJornada N5", "0");
    datos2.put("PJornada N6", "0");
    datos2.put("PJornada N7", "0");
    datos2.put("PJornada N8", "0");
    datos2.put("PJornada N9", "0");
    datos2.put("PJornada N10", "0");
    datos2.put("PJornada N11", "0");
    datos2.put("PJornada N12", "0");
    datos2.put("Pcaparazon", "0");
    datos2.put("Pescarlata", "0");
    datos2.put("Pgarras", "0");
    datos2.put("Paullido", "0");
    datos2.put("Ptempestad", "0");

    datos2.put("VJornada N1", "0");
    datos2.put("VJornada N2","0");
    datos2.put("VJornada N3", "0");
    datos2.put("VJornada N4", "0");
    datos2.put("VJornada N5", "0");
    datos2.put("VJornada N6", "0");
    datos2.put("VJornada N7", "0");
    datos2.put("VJornada N8", "0");
    datos2.put("VJornada N9", "0");
    datos2.put("VJornada N10", "0");
    datos2.put("VJornada N11", "0");
    datos2.put("VJornada N12", "0");
    datos2.put("Vcaparazon", "0");
    datos2.put("Vescarlata", "0");
    datos2.put("Vgarras", "0");
    datos2.put("Vaullido", "0");
    datos2.put("Vtempestad", "0");


    datos2.put("CJornada N1","0");
    datos2.put("CJornada N2","0");
    datos2.put("CJornada N3", "0");
    datos2.put("CJornada N4", "0");
    datos2.put("CJornada N5", "0");
    datos2.put("CJornada N6", "0");
    datos2.put("CJornada N7", "0");
    datos2.put("CJornada N8", "0");
    datos2.put("CJornada N9", "0");
    datos2.put("CJornada N10", "0");
    datos2.put("CJornada N11", "0");
    datos2.put("CJornada N12", "0");
    datos2.put("Ccaparazon", "0");
    datos2.put("Cescarlata", "0");
    datos2.put("Cgarras", "0");
    datos2.put("Caullido", "0");
    datos2.put("Ctempestad", "0");



    if(val.getKeyJornada().contains("Jornada N1")) {
        datos2.put("RJornada N1", val.getKeyDuelista()); datos2.put("RJornada N6","null"); datos2.put("RJornada N11","null");
        datos2.put("RJornada N2","null"); datos2.put("RJornada N7","null"); datos2.put("RJornada N12","null");
        datos2.put("RJornada N3","null"); datos2.put("RJornada N8","null");
        datos2.put("RJornada N4","null"); datos2.put("RJornada N9","null");
        datos2.put("RJornada N5","null"); datos2.put("RJornada N10","null");
        datos2.put("Rcaparazon", "null");
        datos2.put("Rescarlata", "null");
        datos2.put("Rgarras", "null");
        datos2.put("Raullido", "null");
        datos2.put("Rtempestad", "null");
    }

}






    public void cerrar(View sdfas) {
        contexto val = new contexto();



        if(idV1.isEmpty()){

        }else{
            idV1.clear();idV2.clear();idV3.clear();
            datos.clear();datos1.clear();datos2.clear();datos3.clear();

        }


        if(idV2.isEmpty()){

        }else{
            idV1.clear();idV2.clear();idV3.clear();
            datos.clear();datos1.clear();datos2.clear();datos3.clear();

        }

        if(idV3.isEmpty()){

        }else {
            idV1.clear();idV2.clear();idV3.clear();
            datos.clear();datos1.clear();datos2.clear();datos3.clear();

        }
        if(datos.isEmpty()){

        }else{
            idV1.clear();idV2.clear();idV3.clear();
            datos.clear();datos1.clear();datos2.clear();datos3.clear();

        }

        if(datos2.isEmpty()){

        }else{
            idV1.clear();idV2.clear();idV3.clear();
            datos.clear();datos1.clear();datos2.clear();datos3.clear();

        }


        contando=0;



                Intent siguiente = new Intent(this, UsuarioGb.class);



        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("keyDimen", val.getKeyDimencion());
                startActivity(siguiente);








    }

    Context contexto;

    public void detalles(View sdfsfd){
        contexto = this;
        new detlles_Random1(contexto);

    }


public void reasignacion(View fsdf){

if(t1.getText().toString().equals("")){
           Toast.makeText(getApplicationContext(), "Campos de rival vacios", Toast.LENGTH_SHORT).show();
}else{


    bdNeutral.collection("TablaPuntoCabeza")
    .whereEqualTo("nick",t1.getText().toString()).whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {

    if(task.isSuccessful()) {
        for (QueryDocumentSnapshot document : task.getResult()) {
            val.setKeyDuelista2(document.getString("nick"));//rival
            val.setKeyCodigo2(document.getString("codigo"));
            val.setKeyGb(document.getString("R" + val.getKeyJornada()));

        }

        HashMap<String, Object> dato = new HashMap<>();
        dato.put("R" + val.getKeyJornada(), val.getKeyExpectador());
        dato.put("id", String.valueOf(val.getKeyId1() + "b"));

        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato);

        HashMap <String, Object> dao = new HashMap<>();
        dao.put("R"+val.getKeyJornada(),val.getKeyDuelista2());
        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCoidigo3()).update(dao);



        bdNeutral.collection("TablaPuntoCabeza")

        .whereEqualTo("nick",val.getKeyGb().toString()).whereEqualTo("dimencion",val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {

        if(task.isSuccessful()){
        for(QueryDocumentSnapshot document : task.getResult()) {

         val.setKeyCodigo4(document.getString("codigo"));

}


        HashMap <String, Object> dat = new HashMap<>();
        dat.put("R"+val.getKeyJornada(),"null");
        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo4()).update(dat);

            Toast.makeText(getApplicationContext(), "Actualizacion completa.", Toast.LENGTH_SHORT).show();
        }}});



    }else{
        Toast.makeText(getApplicationContext(), "No existe este duelista", Toast.LENGTH_SHORT).show();
}


}});




}


}














}