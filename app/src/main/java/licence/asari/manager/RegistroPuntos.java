package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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


public class RegistroPuntos extends AppCompatActivity {

    private TextView l1,l2;
    private EditText t1;
    FirebaseFirestore bdNeutral,bdPuntos;
    private Spinner sp1;
    contexto val = new contexto();
    private HashMap <String,Object> datos = new HashMap<>();
    Stack <String> idV1 = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_puntos);



        bdNeutral= FirebaseFirestore.getInstance();
        bdPuntos = FirebaseFirestore.getInstance();val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeyCodigo(getIntent().getStringExtra("cdGremio"));
        val.setKeyDimencion(getIntent().getStringExtra("keyDimen"));

        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));


        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));
        l1=(TextView) findViewById(R.id.punto_l1);
        l2=(TextView) findViewById(R.id.punto_l2);

        t1 =(EditText) findViewById(R.id.punto_t1);

        sp1=(Spinner) findViewById(R.id.punto_sp1);


        l1.setText(val.getKeyNick());



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


    bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

    val.setKeyJ1(Integer.parseInt(documentSnapshot.getString("acceso"+ val.getKeyIdGremio())));

            bdNeutral.collection("BDgremio").document(val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    ArrayAdapter <String>  datos = null;
                    idV1.add("elegir");   idV1.add("Jornada N1");   idV1.add("Jornada N2");   idV1.add("Jornada N3");   idV1.add("Jornada N4");   idV1.add("Jornada N5");
                    idV1.add("Jornada N6");   idV1.add("Jornada N7");   idV1.add("Jornada N8");   idV1.add("Jornada N9");   idV1.add("Jornada N10");   idV1.add("Jornada N11");   idV1.add("Jornada N12");


                    for(int a =1; a < (val.getKeyJ1()+1); a++) {


                        if(documentSnapshot.getString("mini" + a).contains("false")){

                            val.setEyMini2("Cargando..");

                            idV1.add(val.getEyMini2());
                        }else {

                            idV1.add(documentSnapshot.getString("mini" + a));
                        }


                        if(a == val.getKeyJ1()){
                            datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);
                            sp1.setAdapter(datos);
                            break;
                        }

                    }

                }
            });


}
});





try {

    sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    val.setKeyJornada(sp1.getSelectedItem().toString());
    if(val.getKeyJornada().contains("elegir")){

        Toast.makeText(getApplicationContext(), "elije  la jornada..", Toast.LENGTH_SHORT).show();
    }else {

        if (!val.getKeyJornada().contains("Jornada")) {
   ///     Toast.makeText(getApplicationContext(), "Cargando .. SISTEMA PUNTOS..", Toast.LENGTH_SHORT).show();
       int indice=0;

             indice = idV1.search(val.getKeyJornada());
            indice = idV1.size() - indice;
       val.setEyMini3(String.valueOf(indice));

            Toast.makeText(getApplicationContext(), "Cargando .. SISTEMA PUNTOS..", Toast.LENGTH_SHORT).show();
        }else{


            val.setEyMini3("0");

            try {
            bdPuntos.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    if (documentSnapshot.exists()) {

                        val.setKeyDuelista2(documentSnapshot.getString("R" + val.getKeyJornada()));
                        l2.setText(val.getKeyDuelista2());
                    } else {
                        Toast.makeText(getApplicationContext(), "Como le fue en sus resultados ... Proceda a registrar su primer reporte", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } catch (Exception sdfs) {
            Toast.makeText(getApplicationContext(), "Error automatico", Toast.LENGTH_SHORT).show();
        }
    }
    }

}

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

}});




}catch (Exception sdfs ) {
    Toast.makeText(getApplicationContext(), "no hay datos ", Toast.LENGTH_SHORT).show();
}


    }//on


    public void puntos(View uo) {
        if(val.getKeyDuelista2().contains("null")){
            Toast.makeText(getApplicationContext(), "No se puede guardar puntos donde no hay oponente..", Toast.LENGTH_SHORT).show();

        }else{
        if (t1.getText().toString().equals("")) {
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
        } else {
            if (sp1.getSelectedItem().toString().contains("Elija")) {
                Toast.makeText(getApplicationContext(), "Se debe elegir el tipo de jornada", Toast.LENGTH_SHORT).show();
            } else {
                contexto val = new contexto();
                val.setKeyJornada(sp1.getSelectedItem().toString());
                try {
                    bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("nick", val.getKeyDuelista2()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    val.setPuntosPj2(document.getString("P" + val.getKeyJornada()));
                                    val.setKeyCodigo2(document.getString("codigo"));

                                    try {
                                        bdPuntos.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                if (documentSnapshot.exists()) {

                                                    val.setPuntosPj1(documentSnapshot.getString("P" + val.getKeyJornada()));


                                                    if (val.getPuntosPj1().contains("0")) {

                                                        val.setPuntosPj1(t1.getText().toString());

                                                        if (val.getPuntosPj1().length() >= 2) {
                                                            Toast.makeText(getApplicationContext(), "Solo se puede asignar un digito por encuentro", Toast.LENGTH_SHORT).show();
                                                        } else {


                                                            val.setKeyJ1(Integer.parseInt(val.getPuntosPj1()));
                                                            if (val.getKeyJ1() >= 3) {
                                                                Toast.makeText(getApplicationContext(), "El resultado no puede ser mayor a 3", Toast.LENGTH_SHORT).show();

                                                            } else {
                                                                HashMap<String, Object> registro = new HashMap<>();
                                                                HashMap<String, Object> registro1 = new HashMap<>();

                                                                val.setKeyJ2(Integer.parseInt(val.getPuntosPj2()));
                                                                Toast.makeText(getApplicationContext(), "Procesando solicitud....", Toast.LENGTH_SHORT).show();

                                                                if (val.getKeyJ1() > val.getKeyJ2()) {

                                                                    if (val.getKeyJ2() == 0) {

                                                                        registro1.put("C" + val.getKeyJornada(), String.valueOf(val.getKeyJ1()));
                                                                        registro.put("V" + val.getKeyJornada(), "1");
                                                                        registro.put("P" + val.getKeyJornada(), String.valueOf(val.getKeyJ1()));

                                                                        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(registro);
                                                                        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(registro1);
                                                                    } else {

                                                                        registro.put("V" + val.getKeyJornada(), "1");
                                                                        registro.put("P" + val.getKeyJornada(), String.valueOf(val.getKeyJ1()));

                                                                        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(registro);

                                                                        registro1.put("C" + val.getKeyJornada(), String.valueOf(val.getKeyJ1()));
                                                                        registro1.put("P" + val.getKeyJornada(), "1");
                                                                        registro1.put("V" + val.getKeyJornada(), "0");
                                                                        bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(registro1);
                                                                    }


                                                                    Toast.makeText(getApplicationContext(), "Proceso Exitoso", Toast.LENGTH_SHORT).show();
                                                                    t1.setText("");
                                                                } else {
                                                                    if (val.getKeyJ1() < val.getKeyJ2()) {

                                                                        if (val.getKeyJ1() == 0) {

                                                                            registro1.put("C" + val.getKeyJornada(), String.valueOf(val.getKeyJ1()));
                                                                            registro.put("V" + val.getKeyJornada(), "0");
                                                                            registro.put("P" + val.getKeyJornada(), "0");

                                                                            bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(registro);
                                                                            bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(registro1);

                                                                        } else {
                                                                            registro1.put("C" + val.getKeyJornada(), String.valueOf(val.getKeyJ1()));
                                                                            registro.put("V" + val.getKeyJornada(), "0");
                                                                            registro.put("P" + val.getKeyJornada(), "1");

                                                                            bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(registro);
                                                                            bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(registro1);
                                                                            t1.setText("");
                                                                        }
                                                                        Toast.makeText(getApplicationContext(), "Proceso Exitoso", Toast.LENGTH_SHORT).show();
                                                                    } else {

                                                                        if (val.getKeyJ1() == 1) {
                                                                            if (val.getKeyJ2() == 1) {
                                                                                Toast.makeText(getApplicationContext(), "SU RIVAL INGRESO ESE MISMO RESULTADO  DESEMPATEN: no pueden quedar 1 a 1", Toast.LENGTH_SHORT).show();

                                                                            }
                                                                        }
                                                                    }

                                                                }

                                                            }


                                                        }


                                                    } else {
                                                        Toast.makeText(getApplicationContext(), "Ya hay datos en esta jornada", Toast.LENGTH_SHORT).show();
                                                    }


                                                }

                                            }
                                        });
                                    } catch (Exception f) {
                                        Toast.makeText(getApplicationContext(), "eroor db  puntos", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }
                        }
                    });

                } catch (Exception sdfs) {
                    Toast.makeText(getApplicationContext(), "eroor db  puntos", Toast.LENGTH_SHORT).show();
                }


            }
        }
    }

    }

    public void cerrar(View sdfas) {
        contexto val = new contexto();

        if(val.getKeySiguienteN2().contains("standar")){

            Intent siguiente = new Intent(this,UsuarioStandar.class);

            siguiente.putExtra("nick", val.getKeyNick());
            siguiente.putExtra("cdGremio", val.getKeySiguienteN1());



            startActivity(siguiente);
        }else{
            if(val.getKeySiguienteN2().contains("admin")) {

                Intent siguiente = new Intent(this, UsuarioGb.class);

                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeySiguienteN1());


                startActivity(siguiente);

            } } }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == event.KEYCODE_BACK){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Deseas  salir de Asary").setPositiveButton("si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent  siguiente = new Intent(Intent.ACTION_MAIN);
                    siguiente.addCategory(Intent.CATEGORY_HOME);
                    siguiente .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(siguiente);
                    finish();
                }



            }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();


                }
            });
            builder.show();
        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();





        finishAffinity();
    }

    public void sistemaPuntos(View sdfa){

        val.setKeyJornada(sp1.getSelectedItem().toString());
        if(val.getKeyJornada().contains("elegir")){
            Toast.makeText(getApplicationContext(), "No se a cargado ningun sistema puntos. elija algun evento.", Toast.LENGTH_SHORT).show();
        }else {

            Intent siguiente = new Intent(this, metodoPunto.class);

            siguiente.putExtra("nick", val.getKeyNick());
            siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
            siguiente.putExtra("standar", "standar");
            siguiente.putExtra("keyDimen", val.getKeyDimencion());
            siguiente.putExtra("keyMini", val.getEyMini3());
            startActivity(siguiente);
        }
    }


}


