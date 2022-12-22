package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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


public class calabozo_v4 extends AppCompatActivity {
FirebaseFirestore  bdNeutral;
TextView l1,l2,l3,l4,l5,l6,l7;
ImageButton b3;
    private Stack<String> idV1 = new Stack<>();
    static ArrayAdapter<String> datos = null;

Button b1;
    ImageButton b2;
    ImageView fondo1,fondo2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calabozo_v4);
        contexto val = new contexto();
        bdNeutral =FirebaseFirestore.getInstance();

        l1 =(TextView) findViewById(R.id.equios_umder1);
        l2 =(TextView) findViewById(R.id.equios_umder2);
        l3 =(TextView) findViewById(R.id.equios_umder_estado1);
        l4 =(TextView) findViewById(R.id.equios_umder_estado2);

        l6 =(TextView) findViewById(R.id.fechas_umder);
        l7=(TextView) findViewById(R.id.fechas_umder2);

        b3 =(ImageButton) findViewById(R.id.under_pareosVs_b1);
        b3.setVisibility(View.GONE);

        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b3.setVisibility(View.VISIBLE); } }catch (Exception dfs){}


        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyPermisoInicio(getIntent().getStringExtra("keyAdmin"));

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



        try {

            bdNeutral.collection("BD"+ val.getKeyEscaneoGrenio()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {

                        idV1.add("Seleccione");

                        for (QueryDocumentSnapshot document : task.getResult()) {


                            val.setKeyDuelista(document.getString("nick"));

                            idV1.add(val.getKeyDuelista());

                        }

                        datos = new ArrayAdapter<>(getApplication(), R.layout.spiner_jornada_random, idV1);

                    } }}); }catch (Exception sdfs){}


        try{
            bdNeutral.collection("BDcalabozo").document("InfoUnderInfo").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

 if(documentSnapshot.exists()){

     val.setKeyfechasUnder(documentSnapshot.getString("keyNoticiaFecha"));
     val.setKeyfechasUnder2(documentSnapshot.getString("keyNoticiaFecha2"));
     val.setKeyEstadoUnder1(documentSnapshot.getString("keyEstado1"));
     val.setKeyEstadoUnder2(documentSnapshot.getString("keyEstado2"));
     val.setKeyEncuentro1(documentSnapshot.getString("keyEncuentro1"));
     val.setKeyEncuentro2(documentSnapshot.getString("keyEncuentro2"));
     l6.setText(val.getKeyfechasUnder());
     l7.setText(val.getKeyfechasUnder2());
     l1.setText(val.getKeyEncuentro1());
     l2.setText(val.getKeyEncuentro2());
     l3.setText(val.getKeyEstadoUnder1());
     l4.setText(val.getKeyEstadoUnder2());

 }}});

        }catch (Exception ssfs){}


        bdNeutral.collection("BDcalabozo").document("InfoUnderCreate").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){ }else{
                    HashMap<String, Object> dato1 = new HashMap<>();
                    dato1.put("equipo1Titulo1","esperando");
                    dato1.put("equipo1Participante1","esperando");
                    dato1.put("equipo1Participante2","esperando");

                    dato1.put("equipo2Titulo1","esperando");
                    dato1.put("equipo2Participante1","esperando");
                    dato1.put("equipo2Participante2","esperando");

                    dato1.put("equipo3Titulo1","esperando");
                    dato1.put("equipo3Participante1","esperando");
                    dato1.put("equipo3Participante2","esperando");

                    dato1.put("equipo4Titulo1","esperando");
                    dato1.put("equipo4Participante1","esperando");
                    dato1.put("equipo4Participante2","esperando");


                    dato1.put("equipo5Titulo1","esperando");
                    dato1.put("equipo5Participante1","esperando");
                    dato1.put("equipo5Participante2","esperando");

                    dato1.put("equipo6Titulo1","esperando");
                    dato1.put("equipo6Participante1","esperando");
                    dato1.put("equipo6Participante2","esperando");

                    dato1.put("equipo7Titulo1","esperando");
                    dato1.put("equipo7Participante1","esperando");
                    dato1.put("equipo7Participante2","esperando");

                    dato1.put("equipo8Titulo1","esperando");
                    dato1.put("equipo8Participante1","esperando");
                    dato1.put("equipo8Participante2","esperando");

                    dato1.put("equipo9Titulo1","esperando");
                    dato1.put("equipo9Participante1","esperando");
                    dato1.put("equipo9Participante2","esperando");

                    dato1.put("equipo10Titulo1","esperando");
                    dato1.put("equipo10Participante1","esperando");
                    dato1.put("equipo10Participante2","esperando");

                    bdNeutral.collection("BDcalabozo").document("InfoUnderCreate").set(dato1);

                }

            }
        });




    }

    Context contexto;



    public void derrota (View sdfsfd){

        contexto = this;
        new detlles_derrota_under(contexto);
    }



    public void llamadaPareos(View sdfsdf) {

                    contexto = this;
                    new detlles_pareo_underword(contexto);


    }

    public void llamadaTabla(View sdfsdf) {

        contexto = this;
        new detlles_tabla_resultados_under(contexto);


    }


    public void llamadaCreate(View sdfsdf) {
        contexto = this;
        new detlles_creacionequipo(contexto);
    }

    public void llamadaEquipos(View sdfsdf) {
        contexto = this;
        new detlles_tabla_equipos_under(contexto);
    }


    public void llamadaVs(View sdfsdf) {
        contexto = this;
        new detlles_underword_pareos(contexto);
    }

    public void cerrar(View sdfas) {
        contexto val = new contexto();



        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }






    public void enlaceLVL6(View sdfsd) {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("DAAS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {


                    Uri url = Uri.parse(documentSnapshot.getString("keyEnlaceInicial"));
                    Intent siguiente = new Intent(Intent.ACTION_VIEW, url);
                    startActivity(siguiente);
                }
            }
        });
    }
}