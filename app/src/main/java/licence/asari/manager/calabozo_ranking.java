package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class calabozo_ranking extends AppCompatActivity {

    FirebaseFirestore bdNeutral, bdAzul,gremio;
    Button b1;
    ImageButton b2;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calabozo_ranking);contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyTorneoActivo(getIntent().getStringExtra("keyTorneo"));
        val.setSearKeyCodigo(Integer.parseInt(val.getKeySiguienteN1()));
        bdNeutral = FirebaseFirestore.getInstance();


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




        l1=(TextView) findViewById(R.id.rankig_l1);
        l2=(TextView) findViewById(R.id.rankig_l2);
        l3=(TextView) findViewById(R.id.rankig_l3);
        l4=(TextView) findViewById(R.id.rankig_l4);
        l5=(TextView) findViewById(R.id.rankig_l5);
        l6=(TextView) findViewById(R.id.rankig_l6);
        l7=(TextView) findViewById(R.id.rankig_l7);
        l8=(TextView) findViewById(R.id.rankig_l8);
        l9=(TextView) findViewById(R.id.rankig_l9);
        l10=(TextView) findViewById(R.id.rankig_l10);


        b2 = (ImageButton) findViewById(R.id.romm_b1);
        b2.setVisibility(View.GONE);
        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b2.setVisibility(View.VISIBLE); } }catch (Exception dfs){}


//ca-app-pub-1292672566226312/3232201171



        bdNeutral.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

            if(documentSnapshot.exists()){

             val.setKeyParticipante1(documentSnapshot.getString("1Puesto"));
                val.setKeyParticipante2(documentSnapshot.getString("2Puesto"));
                val.setKeyParticipante3(documentSnapshot.getString("3Puesto"));
                val.setKeyParticipante4(documentSnapshot.getString("4Puesto"));
                val.setKeyParticipante5(documentSnapshot.getString("5Puesto"));
                val.setKeyParticipante6(documentSnapshot.getString("6Puesto"));
                val.setKeyParticipante7(documentSnapshot.getString("7Puesto"));
                val.setKeyParticipante8(documentSnapshot.getString("8Puesto"));
                val.setKeyParticipante9(documentSnapshot.getString("9Puesto"));
                val.setKeyParticipante10(documentSnapshot.getString("10Puesto"));

                val.setKeyEstado1(documentSnapshot.getString("LugarN1"));
                val.setKeyEstado2(documentSnapshot.getString("LugarN2"));
                val.setKeyEstado3(documentSnapshot.getString("LugarN3"));
                val.setKeyEstado4(documentSnapshot.getString("LugarN4"));
                val.setKeyEstado5(documentSnapshot.getString("LugarN5"));
                val.setKeyEstado6(documentSnapshot.getString("LugarN6"));
                val.setKeyEstado7(documentSnapshot.getString("LugarN7"));
                val.setKeyEstado8(documentSnapshot.getString("LugarN8"));
                val.setKeyEstado9(documentSnapshot.getString("LugarN9"));
                val.setKeyEstado10(documentSnapshot.getString("LugarN10"));


                if(val.getKeyParticipante1().equals("esperando")){
                    val.setKeyParticipante1("Duelista");
                    val.setKeyParticipante2("Duelista");
                    val.setKeyParticipante3("Duelista");
                    val.setKeyParticipante4("Duelista");
                    val.setKeyParticipante5("Duelista");
                    val.setKeyParticipante6("Duelista");
                    val.setKeyParticipante7("Duelista");
                    val.setKeyParticipante8("Duelista");
                    val.setKeyParticipante9("Duelista");
                    val.setKeyParticipante10("Duelista");
                    val.setKeyEstado1("0");
                    val.setKeyEstado2("0");
                    val.setKeyEstado3("0");
                    val.setKeyEstado4("0");
                    val.setKeyEstado5("0");
                    val.setKeyEstado6("0");
                    val.setKeyEstado7("0");
                    val.setKeyEstado8("0");
                    val.setKeyEstado9("0");
                    val.setKeyEstado10("0");
                }

                l1.setText("["+val.getKeyParticipante1() + "]  Ps: " + val.getKeyEstado1());
                l2.setText("["+val.getKeyParticipante2() + "]  Ps: " + val.getKeyEstado2());
                l3.setText("["+val.getKeyParticipante3() + "]  Ps: " + val.getKeyEstado3());
                l4.setText("["+val.getKeyParticipante4() + "]  Ps: " + val.getKeyEstado4());
                l5.setText("["+val.getKeyParticipante5() + "]  Ps: " + val.getKeyEstado5());
                l6.setText("["+val.getKeyParticipante6() + "]  Ps: " + val.getKeyEstado6());
                l7.setText("["+val.getKeyParticipante7() + "]  Ps: " + val.getKeyEstado7());
                l8.setText("["+val.getKeyParticipante8() + "]  Ps: " + val.getKeyEstado8());
                l9.setText("["+val.getKeyParticipante9() + "]  Ps: " + val.getKeyEstado9());
                l10.setText("["+val.getKeyParticipante10() + "]  Ps: " + val.getKeyEstado10());



            }else{

                HashMap<String, Object> dato = new HashMap<>();
                dato.put("1Puesto", "esperando");
                dato.put("2Puesto", "esperando");
                dato.put("3Puesto", "esperando");
                dato.put("4Puesto", "esperando");
                dato.put("5Puesto", "esperando");
                dato.put("6Puesto", "esperando");
                dato.put("7Puesto", "esperando");
                dato.put("8Puesto", "esperando");
                dato.put("9Puesto", "esperando");
                dato.put("10Puesto", "esperando");


                dato.put("LugarN1", "esperando");
                dato.put("LugarN2", "esperando");
                dato.put("LugarN3", "esperando");
                dato.put("LugarN4", "esperando");
                dato.put("LugarN5", "esperando");
                dato.put("LugarN6", "esperando");
                dato.put("LugarN7", "esperando");
                dato.put("LugarN8", "esperando");
                dato.put("LugarN9", "esperando");
                dato.put("LugarN10", "esperando");

                Toast.makeText(getApplicationContext(), "CREADO NUEVO CONTENIDO", Toast.LENGTH_SHORT).show();

                bdNeutral.collection("BDcalabozo").document("TG-"+val.getKeyTorneoActivo()+val.getKeyIdGremio()).set(dato);


                val.setKeyParticipante1(documentSnapshot.getString("1Puesto"));
                val.setKeyParticipante2(documentSnapshot.getString("2Puesto"));
                val.setKeyParticipante3(documentSnapshot.getString("3Puesto"));
                val.setKeyParticipante4(documentSnapshot.getString("4Puesto"));
                val.setKeyParticipante5(documentSnapshot.getString("5Puesto"));
                val.setKeyParticipante6(documentSnapshot.getString("6Puesto"));
                val.setKeyParticipante7(documentSnapshot.getString("7Puesto"));
                val.setKeyParticipante8(documentSnapshot.getString("8Puesto"));
                val.setKeyParticipante9(documentSnapshot.getString("9Puesto"));
                val.setKeyParticipante10(documentSnapshot.getString("10Puesto"));

                val.setKeyEstado1(documentSnapshot.getString("LugarN1"));
                val.setKeyEstado2(documentSnapshot.getString("LugarN2"));
                val.setKeyEstado3(documentSnapshot.getString("LugarN3"));
                val.setKeyEstado4(documentSnapshot.getString("LugarN4"));
                val.setKeyEstado5(documentSnapshot.getString("LugarN5"));
                val.setKeyEstado6(documentSnapshot.getString("LugarN6"));
                val.setKeyEstado7(documentSnapshot.getString("LugarN7"));
                val.setKeyEstado8(documentSnapshot.getString("LugarN8"));
                val.setKeyEstado9(documentSnapshot.getString("LugarN9"));
                val.setKeyEstado10(documentSnapshot.getString("LugarN10"));

                l1.setText("["+val.getKeyParticipante1() + "]  Ps: " + val.getKeyEstado1());
                l2.setText("["+val.getKeyParticipante2() + "]  Ps: " + val.getKeyEstado2());
                l3.setText("["+val.getKeyParticipante3() + "]  Ps: " + val.getKeyEstado3());
                l4.setText("["+val.getKeyParticipante4() + "]  Ps: " + val.getKeyEstado4());
                l5.setText("["+val.getKeyParticipante5() + "]  Ps: " + val.getKeyEstado5());
                l6.setText("["+val.getKeyParticipante6() + "]  Ps: " + val.getKeyEstado6());
                l7.setText("["+val.getKeyParticipante7() + "]  Ps: " + val.getKeyEstado7());
                l8.setText("["+val.getKeyParticipante8() + "]  Ps: " + val.getKeyEstado8());
                l9.setText("["+val.getKeyParticipante9() + "]  Ps: " + val.getKeyEstado9());
                l10.setText("["+val.getKeyParticipante10() + "]  Ps: " + val.getKeyEstado10());

            }

            }
        });

    }
    Context contexto;
    public void llamadoReporte(){
        contexto = this;
        new detlles_rankig_final_calabozov6(contexto);
    }


    public void llamadoCierre(){
        contexto = this;
        new detlles_targeta_cierre_dungeo(contexto);
    }

    public void llamadofinal(View sdfsf){
        llamadoReporte();
    }

    public void llamadoCierreFinal(View sdfsf){
        llamadoCierre();
    }

    public void datosWinner(View  sdfs){

contexto val = new contexto();
        Intent siguiente = new Intent(this,tabla_victoria_dungeon_xyz_v6.class);
           siguiente.putExtra("nick", val.getKeyNick());
            siguiente.putExtra("cdGremio", val.getKeyCodigo());

        startActivity(siguiente);
    }
    public void cerrar(View sdfas) {
        Intent siguiente = new Intent(this, MainActivity2.class);
        startActivity(siguiente);
    }

}