package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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

public class eventoN2 extends AppCompatActivity {

    private Spinner sp1;
    private FirebaseFirestore bdNeutro;
    private Stack<String> idV1 = new Stack<>();
    private ImageButton b1,b2,b3;
    private TextView l1,l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_n2);

        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

        sp1=(Spinner) findViewById(R.id.god_sp);
        bdNeutro = FirebaseFirestore.getInstance();

        b1 =(ImageButton) findViewById(R.id.good_b1);
        b2 =(ImageButton) findViewById(R.id.good_b2);
        b3 =(ImageButton) findViewById(R.id.good_b3);

        l1 = (TextView) findViewById(R.id.good_l1);
        l2 = (TextView) findViewById(R.id.good_l2);

        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);

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

   bdNeutro.collection("goodVBatle").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override
   public void onSuccess(DocumentSnapshot documentSnapshot) {

   if (documentSnapshot.exists()) {
       Toast.makeText(getApplicationContext(), "Bienvenido Duelista", Toast.LENGTH_SHORT).show();
    visualSP1();

   }else{
       if(val.getKeyIdGremio().equals("100")){
           Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
           crear();
          visualSP1();
       }else{
           if(val.getKeyIdGremio().equals("1100")) {
               Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
               crear();
              visualSP1();
           }else{
               if(val.getKeyIdGremio().equals("2100")) {
                   Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
                   crear();
                  visualSP1();
               }else{
                   if(val.getKeyIdGremio().equals("3100")) {
                       Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
                       crear();
                      visualSP1();
                   }else{
                       if(val.getKeyIdGremio().equals("4100")) {
                           crear();
                          visualSP1();
                           Toast.makeText(getApplicationContext(), "Creando contenido Evento Caparazon.", Toast.LENGTH_SHORT).show();
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
Toast.makeText(getApplicationContext(), "Se debe elegir un rival.", Toast.LENGTH_SHORT).show();}else{

 bdNeutro.collection("goodVBatle").whereEqualTo("nick",val.getKeyDuelista()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
    if (task.isSuccessful()) {
    for (QueryDocumentSnapshot document : task.getResult()) {

    val.setKeyCodigo2(document.getString("vida"));

    }

    bdNeutro.collection("goodVBatle").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {

    val.setKeyVida1(documentSnapshot.getString("vida"));
    l1.setText(val.getKeyVida1());
    }
    });


    val.setKeyJ2(Integer.parseInt(val.getKeyCodigo2()));
    l2.setText(String.valueOf(val.getKeyJ2()));

    if(val.getKeyJ2() == 0){Toast.makeText(getApplicationContext(), "Este rival no tiene puntos de vida.", Toast.LENGTH_SHORT).show();
    val.setKeyAviso2("die");
    }else {

        val.setKeyAviso2("true");

    }


    }

    }
});

}
}

@Override
public void onNothingSelected(AdapterView<?> parent) {
} });


    }


    public void visualSP1(){
        contexto val = new contexto();
        try {
            bdNeutro.collection("goodVBatle").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
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

    public void crear(){
        contexto val = new contexto();

        HashMap<String, Object> dato = new HashMap<>();



       dato.put("face1","false");dato.put("face2","false");dato.put("face3","false");

        dato.put("remitente","true");
        dato.put("aviso1","true");
        dato.put("bloke","true");
        dato.put("codigo",val.getKeySiguienteN1());
        dato.put("nick",val.getKeyNick());
        dato.put("vida","4000");
        dato.put("duelo1","0");
        dato.put("duelo2","0");
        dato.put("duelo3","0");

        dato.put("Vduelo1_1","false");
        dato.put("Vduelo2_2","false");
        dato.put("Vduelo3_3","false");
        dato.put("Vduelo4_4","false");
        dato.put("Vduelo5_5","false");
        dato.put("Vduelo6_6","false");

        dato.put("Dduelo1_1","false");
        dato.put("Dduelo2_2","false");
        dato.put("Dduelo3_3","false");
        dato.put("Dduelo4_4","false");
        dato.put("Dduelo5_5","false");
        dato.put("Dduelo6_6","false");


        dato.put("VDduelo1_1","false");
        dato.put("VDduelo2_2","false");
        dato.put("VDduelo3_3","false");
        dato.put("VDduelo4_4","false");
        dato.put("VDduelo5_5","false");
        dato.put("VDduelo6_6","false");

        bdNeutro.collection("goodVBatle").document(val.getKeySiguienteN1()).set(dato);

    }


    public void reglasGood(View sdfskk){
        contexto val = new contexto();
        Intent siguiente = new Intent(this,reglas_good_n1.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        siguiente.putExtra("standar", val.getKeySiguienteN2());
        startActivity(siguiente);

    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();



    Intent siguiente = new Intent(this, MenuEventos.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        siguiente.putExtra("standar", val.getKeySiguienteN2());
        startActivity(siguiente);
}

Context contexto;

public void detalles(View sdfsfd){
contexto = this;
new detlles_good1(contexto);

}


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
    }


    String enlace="https://chat.whatsapp.com/IYXiOGsAA7c4YdrruJaSAH";

    public void enlace(View sdfs){

        Uri url = Uri.parse(enlace);
        Intent siguiente = new Intent(Intent.ACTION_VIEW,url);
        startActivity(siguiente);

    }
}