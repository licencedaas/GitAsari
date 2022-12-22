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

public class pre_asistencia_lose extends AppCompatActivity {
    FirebaseFirestore bdNeutro;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    int contadorParticipantes=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_asistencia_lose);

        contexto val = new contexto();
        bdNeutro = FirebaseFirestore.getInstance();


     //   val.setKeyNick(getIntent().getStringExtra("nick"));
     //   val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyPermisoInicio(getIntent().getStringExtra("keyAdmin"));
     //   val.setKeyTorneoActivo(getIntent().getStringExtra("keyTorneo"));
        val.setKeyCalabozoActivo(getIntent().getStringExtra("numeroSala"));///

        l1=(TextView) findViewById(R.id.lose_l1);
        l2=(TextView) findViewById(R.id.lose_l2);
        l3=(TextView) findViewById(R.id.lose_l3);
        l4=(TextView) findViewById(R.id.lose_l4);
        l5=(TextView) findViewById(R.id.lose_l5);
        l6=(TextView) findViewById(R.id.lose_l6);
        l7=(TextView) findViewById(R.id.lose_l7);
        l8=(TextView) findViewById(R.id.lose_l8);
        l9=(TextView) findViewById(R.id.lose_l9);
        l10=(TextView) findViewById(R.id.lose_l10);
        l11=(TextView) findViewById(R.id.lose_l11);

        ImageButton b1 = (ImageButton)findViewById(R.id.lose_b2);

        b1.setVisibility(View.GONE);
        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b1.setVisibility(View.VISIBLE);} }catch (Exception dfs){}


        bdNeutro.collection("BDcalabozo").document("tablaPreregistroLose").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

             if(documentSnapshot.exists()){


                 val.setKeyParticipanteLose1(documentSnapshot.getString("participante1"));
                 val.setKeyParticipanteLose2(documentSnapshot.getString("participante2"));
                 val.setKeyParticipanteLose3(documentSnapshot.getString("participante3"));
                 val.setKeyParticipanteLose4(documentSnapshot.getString("participante4"));
                 val.setKeyParticipanteLose5(documentSnapshot.getString("participante5"));
                 val.setKeyParticipanteLose6(documentSnapshot.getString("participante6"));
                 val.setKeyParticipanteLose7(documentSnapshot.getString("participante7"));
                 val.setKeyParticipanteLose8(documentSnapshot.getString("participante8"));
                 val.setKeyParticipanteLose9(documentSnapshot.getString("participante9"));
                 val.setKeyParticipanteLose10(documentSnapshot.getString("participante10"));
                 val.setKeyParticipanteLose11(documentSnapshot.getString("participante11"));

                 if(val.getKeyParticipanteLose1().equals("eperando")){
                     l1.setText("");
                 }else{ l1.setText(val.getKeyParticipanteLose1()); }
                 if(val.getKeyParticipanteLose2().equals("eperando")){
                     l2.setText("");
                 }else{ l2.setText(val.getKeyParticipanteLose2()); }
                 if(val.getKeyParticipanteLose3().equals("eperando")){
                     l3.setText("");
                 }else{ l3.setText(val.getKeyParticipanteLose3()); }
                 if(val.getKeyParticipanteLose4().equals("eperando")){
                     l4.setText("");
                 }else{ l4.setText(val.getKeyParticipanteLose4()); }
                 if(val.getKeyParticipanteLose5().equals("eperando")){
                     l5.setText("");
                 }else{ l5.setText(val.getKeyParticipanteLose5()); }
                 if(val.getKeyParticipanteLose6().equals("eperando")){
                     l6.setText("");
                 }else{ l6.setText(val.getKeyParticipanteLose6()); }
                 if(val.getKeyParticipanteLose7().equals("eperando")){
                     l7.setText("");
                 }else{ l7.setText(val.getKeyParticipanteLose7()); }
                 if(val.getKeyParticipanteLose8().equals("eperando")){
                     l8.setText("");
                 }else{ l8.setText(val.getKeyParticipanteLose8()); }
                 if(val.getKeyParticipanteLose9().equals("eperando")){
                     l9.setText("");
                 }else{ l9.setText(val.getKeyParticipanteLose9()); }
                 if(val.getKeyParticipanteLose10().equals("eperando")){
                     l10.setText("");
                 }else{ l10.setText(val.getKeyParticipanteLose10()); }
                 if(val.getKeyParticipanteLose11().equals("eperando")){
                     l11.setText("");
                 }else{ l11.setText(val.getKeyParticipanteLose11()); }




             }else{

                 Toast.makeText(getApplicationContext(), "CREANDO CONTENIDO NUEVO", Toast.LENGTH_SHORT).show();

                 HashMap<String,Object> dato = new HashMap<>();
                 dato.put("participante1","eperando");
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

                 bdNeutro.collection("BDcalabozo").document("tablaPreregistroLose").set(dato);




                 l1.setText("esperando");
                 l2.setText("esperando");
                 l3.setText("esperando");
                 l4.setText("esperando");
                 l5.setText("esperando");
                 l6.setText("esperando");
                 l7.setText("esperando");
                 l8.setText("esperando");
                 l9.setText("esperando");
                 l10.setText("esperando");
                 l11.setText("esperando");
             }

            }
        });


    }

    public void cerrar(View sdfas) {
        contexto val = new contexto();



        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

    @Override
    protected void onStart() {
        super.onStart();
        contexto val = new contexto();

    }


    Context contexto;




    public void exclusion(View dsfs){

        contexto val =new contexto();

        contadorParticipantes=1;

        if(val.getKeyParticipanteLose1().equals("eperando")){
            //crea
        }else{
            tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose1());
            contadorParticipantes++;
            if(val.getKeyParticipanteLose2().equals("eperando")){
                //crea
            }else{
                tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose2());
                contadorParticipantes++;
                if(val.getKeyParticipanteLose3().equals("eperando")){
                }else {
                    tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose3());
                    contadorParticipantes++;
                    if(val.getKeyParticipanteLose4().equals("eperando")){
                    }else{
                        tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose4());
                        contadorParticipantes++;
                        if(val.getKeyParticipanteLose4().equals("eperando")){
                        }else{

                            if(val.getKeyParticipanteLose5().equals("eperando")){
                            }else{
                                tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose5());
                                contadorParticipantes++;
                                if(val.getKeyParticipanteLose6().equals("eperando")){
                                }else{
                                    contadorParticipantes++;tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose6());
                                    if(val.getKeyParticipanteLose7().equals("eperando")){
                                    }else{
                                        contadorParticipantes++;tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose7());
                                        if(val.getKeyParticipanteLose8().equals("eperando")){
                                        }else{
                                            contadorParticipantes++;tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose8());
                                            if(val.getKeyParticipanteLose9().equals("eperando")){
                                            }else{
                                                contadorParticipantes++;tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose9());

                                                if(val.getKeyParticipanteLose10().equals("eperando")){
                                                }else{
                                                    contadorParticipantes++;tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose10());

                                                    if(val.getKeyParticipanteLose11().equals("eperando")){
                                                    }else{
                                                        contadorParticipantes++;tabla_registro_dungeo_v6.idV4.add(val.getKeyParticipanteLose11());
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


        if(contadorParticipantes==0){
            Toast.makeText(this, "NO HAY SUFISIENTE PARTICIPANTES", Toast.LENGTH_SHORT).show();
            contadorParticipantes=0;tabla_registro_dungeo_v6.idV4.clear();
        }else{
            if(contadorParticipantes<4){
                contadorParticipantes=0;tabla_registro_dungeo_v6.idV4.clear();

                Toast.makeText(this, "NO HAY SUFISIENTE PARTICIPANTES ALMENOS 6 PARA INICIAR   "+tabla_registro_dungeo_v6.idV4, Toast.LENGTH_SHORT).show();
            }else{
                if(contadorParticipantes>=4){


                    HashMap<String, Object> dato1 = new HashMap<>();
                    dato1.put("keyAleatorioSalaLose","activo");
                    bdNeutro.collection("BDcalabozo").document("Info").update(dato1);
                    val.setKeyExclucion("activo");



                    contadorParticipantes=contadorParticipantes-1;
                    val.setKeyConteo(String.valueOf(contadorParticipantes));


                    crear();


                    if(val.getKeyEntradaLose().equals("nolose")){

                        HashMap<String, Object> dato = new HashMap<>();
                        dato.put("keyRegistroActivoLose", "youlose");

                        Toast.makeText(getApplicationContext(), "Desactivando Pre-Registro ... ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "Habilitando SALAS LOSE ... ", Toast.LENGTH_SHORT).show();
                        bdNeutro.collection("BDcalabozo").document("Info").update(dato);



                    Intent siguiente = new Intent(this, MainActivity2.class);
                    siguiente.putExtra("nick", val.getKeyNick());
                    siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
                    startActivity(siguiente);


                }

            }

        }
    }
    }




    public void llamadoRandom(){

        contexto = this;
        contexto val = new contexto();

        new detlles_random_xyz_v6(contexto);
    }


    public void llamadoregkas(View fdgdfg){

        contexto = this;
        new detlles_reglas_arquetipo(contexto);
    }



    public void crear() {
        contexto val = new contexto();

        HashMap<String, Object> dato = new HashMap<>();
        HashMap<String, Object> dato1 = new HashMap<>();



         val.setKeyJ1(Integer.parseInt(val.getKeyConteo()));



        if(val.getKeyJ1()==4){
            dato.put("puestoN1",val.getKeyParticipanteLose1());
            dato.put("puestoN2",val.getKeyParticipanteLose2());
            dato.put("puestoN3",val.getKeyParticipanteLose3());
            dato.put("puestoN4",val.getKeyParticipanteLose4());

            dato.put("participante1", val.getKeyParticipanteLose1());
            dato.put("participante2", val.getKeyParticipanteLose2());
            dato.put("participante3",val.getKeyParticipanteLose3());
            dato.put("participante4", val.getKeyParticipanteLose4());

            dato1.put("participante1", val.getKeyParticipanteLose1());
            dato1.put("participante2", val.getKeyParticipanteLose2());
            dato1.put("participante3",val.getKeyParticipanteLose3());
            dato1.put("participante4", val.getKeyParticipanteLose4());

            dato1.put("puestoN1","esperando");
            dato1.put("puestoN2","esperando");
            dato1.put("puestoN3","esperando");
            dato1.put("puestoN4","esperando");

            dato1.put("lvl1","0");
            dato1.put("lvl2","0");
            dato1.put("lvl3","0");
            dato1.put("lvl4","0");

        }else{
            if(val.getKeyJ1()==5){
                dato.put("puestoN1",val.getKeyParticipanteLose1());
                dato.put("puestoN2",val.getKeyParticipanteLose2());
                dato.put("puestoN3",val.getKeyParticipanteLose3());
                dato.put("puestoN4",val.getKeyParticipanteLose4());
                dato.put("puestoN5",val.getKeyParticipanteLose5());

                dato.put("participante1", val.getKeyParticipanteLose1());
                dato.put("participante2", val.getKeyParticipanteLose2());
                dato.put("participante3",val.getKeyParticipanteLose3());
                dato.put("participante4", val.getKeyParticipanteLose4());
                dato.put("participante5", val.getKeyParticipanteLose5());

                dato1.put("participante1", val.getKeyParticipanteLose1());
                dato1.put("participante2", val.getKeyParticipanteLose2());
                dato1.put("participante3",val.getKeyParticipanteLose3());
                dato1.put("participante4", val.getKeyParticipanteLose4());
                dato1.put("participante5", val.getKeyParticipanteLose5());

                dato1.put("puestoN1","esperando");
                dato1.put("puestoN2","esperando");
                dato1.put("puestoN3","esperando");
                dato1.put("puestoN4","esperando");
                dato1.put("puestoN5","esperando");


                dato1.put("lvl1","0");
                dato1.put("lvl2","0");
                dato1.put("lvl3","0");
                dato1.put("lvl4","0");
                dato1.put("lvl5","0");
            }else{
                if(val.getKeyJ1()==6){
                    dato.put("puestoN1",val.getKeyParticipanteLose1());
                    dato.put("puestoN2",val.getKeyParticipanteLose2());
                    dato.put("puestoN3",val.getKeyParticipanteLose3());
                    dato.put("puestoN4",val.getKeyParticipanteLose4());
                    dato.put("puestoN5",val.getKeyParticipanteLose5());
                    dato.put("puestoN6",val.getKeyParticipanteLose6());

                    dato.put("participante1", val.getKeyParticipanteLose1());
                    dato.put("participante2", val.getKeyParticipanteLose2());
                    dato.put("participante3",val.getKeyParticipanteLose3());
                    dato.put("participante4", val.getKeyParticipanteLose4());
                    dato.put("participante5", val.getKeyParticipanteLose5());
                    dato.put("participante6", val.getKeyParticipanteLose6());

                    dato1.put("participante1", val.getKeyParticipanteLose1());
                    dato1.put("participante2", val.getKeyParticipanteLose2());
                    dato1.put("participante3",val.getKeyParticipanteLose3());
                    dato1.put("participante4", val.getKeyParticipanteLose4());
                    dato1.put("participante5", val.getKeyParticipanteLose5());
                    dato1.put("participante6", val.getKeyParticipanteLose6());

                    dato1.put("puestoN1","esperando");
                    dato1.put("puestoN2","esperando");
                    dato1.put("puestoN3","esperando");
                    dato1.put("puestoN4","esperando");
                    dato1.put("puestoN5","esperando");
                    dato1.put("puestoN6","esperando");


                    dato1.put("lvl1","0");
                    dato1.put("lvl2","0");
                    dato1.put("lvl3","0");
                    dato1.put("lvl4","0");
                    dato1.put("lvl5","0");
                    dato1.put("lvl6","0");
                }else{
                    if(val.getKeyJ1()==7){
                        dato.put("puestoN1",val.getKeyParticipanteLose1());
                        dato.put("puestoN2",val.getKeyParticipanteLose2());
                        dato.put("puestoN3",val.getKeyParticipanteLose3());
                        dato.put("puestoN4",val.getKeyParticipanteLose4());
                        dato.put("puestoN5",val.getKeyParticipanteLose5());
                        dato.put("puestoN6",val.getKeyParticipanteLose6());
                        dato.put("puestoN7",val.getKeyParticipanteLose7());

                        dato.put("participante1", val.getKeyParticipanteLose1());
                        dato.put("participante2", val.getKeyParticipanteLose2());
                        dato.put("participante3",val.getKeyParticipanteLose3());
                        dato.put("participante4", val.getKeyParticipanteLose4());
                        dato.put("participante5", val.getKeyParticipanteLose5());
                        dato.put("participante6", val.getKeyParticipanteLose6());
                        dato.put("participante7", val.getKeyParticipanteLose7());

                        dato1.put("participante1", val.getKeyParticipanteLose1());
                        dato1.put("participante2", val.getKeyParticipanteLose2());
                        dato1.put("participante3",val.getKeyParticipanteLose3());
                        dato1.put("participante4", val.getKeyParticipanteLose4());
                        dato1.put("participante5", val.getKeyParticipanteLose5());
                        dato1.put("participante6", val.getKeyParticipanteLose6());
                        dato1.put("participante7", val.getKeyParticipanteLose7());

                        dato1.put("puestoN1","esperando");
                        dato1.put("puestoN2","esperando");
                        dato1.put("puestoN3","esperando");
                        dato1.put("puestoN4","esperando");
                        dato1.put("puestoN5","esperando");
                        dato1.put("puestoN6","esperando");
                        dato1.put("puestoN7","esperando");


                        dato1.put("lvl1","0");
                        dato1.put("lvl2","0");
                        dato1.put("lvl3","0");
                        dato1.put("lvl4","0");
                        dato1.put("lvl5","0");
                        dato1.put("lvl6","0");
                        dato1.put("lvl7","0");

                    }else{
                        if(val.getKeyJ1()==8){
                            dato.put("puestoN1",val.getKeyParticipanteLose1());
                            dato.put("puestoN2",val.getKeyParticipanteLose2());
                            dato.put("puestoN3",val.getKeyParticipanteLose3());
                            dato.put("puestoN4",val.getKeyParticipanteLose4());
                            dato.put("puestoN5",val.getKeyParticipanteLose5());
                            dato.put("puestoN6",val.getKeyParticipanteLose6());
                            dato.put("puestoN7",val.getKeyParticipanteLose7());
                            dato.put("puestoN8",val.getKeyParticipanteLose8());

                            dato.put("participante1", val.getKeyParticipanteLose1());
                            dato.put("participante2", val.getKeyParticipanteLose2());
                            dato.put("participante3",val.getKeyParticipanteLose3());
                            dato.put("participante4", val.getKeyParticipanteLose4());
                            dato.put("participante5", val.getKeyParticipanteLose5());
                            dato.put("participante6", val.getKeyParticipanteLose6());
                            dato.put("participante7", val.getKeyParticipanteLose7());
                            dato.put("participante8", val.getKeyParticipanteLose8());

                            dato1.put("participante1", val.getKeyParticipanteLose1());
                            dato1.put("participante2", val.getKeyParticipanteLose2());
                            dato1.put("participante3",val.getKeyParticipanteLose3());
                            dato1.put("participante4", val.getKeyParticipanteLose4());
                            dato1.put("participante5", val.getKeyParticipanteLose5());
                            dato1.put("participante6", val.getKeyParticipanteLose6());
                            dato1.put("participante7", val.getKeyParticipanteLose7());
                            dato1.put("participante8", val.getKeyParticipanteLose8());

                            dato1.put("puestoN1","esperando");
                            dato1.put("puestoN2","esperando");
                            dato1.put("puestoN3","esperando");
                            dato1.put("puestoN4","esperando");
                            dato1.put("puestoN5","esperando");
                            dato1.put("puestoN6","esperando");
                            dato1.put("puestoN7","esperando");
                            dato1.put("puestoN8","esperando");

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
                                dato.put("puestoN1",val.getKeyParticipanteLose1());
                                dato.put("puestoN2",val.getKeyParticipanteLose2());
                                dato.put("puestoN3",val.getKeyParticipanteLose3());
                                dato.put("puestoN4",val.getKeyParticipanteLose4());
                                dato.put("puestoN5",val.getKeyParticipanteLose5());
                                dato.put("puestoN6",val.getKeyParticipanteLose6());
                                dato.put("puestoN7",val.getKeyParticipanteLose7());
                                dato.put("puestoN8",val.getKeyParticipanteLose8());
                                dato.put("puestoN9",val.getKeyParticipanteLose9());

                                dato.put("participante1", val.getKeyParticipanteLose1());
                                dato.put("participante2", val.getKeyParticipanteLose2());
                                dato.put("participante3",val.getKeyParticipanteLose3());
                                dato.put("participante4", val.getKeyParticipanteLose4());
                                dato.put("participante5", val.getKeyParticipanteLose5());
                                dato.put("participante6", val.getKeyParticipanteLose6());
                                dato.put("participante7", val.getKeyParticipanteLose7());
                                dato.put("participante8", val.getKeyParticipanteLose8());
                                dato.put("participante9", val.getKeyParticipanteLose9());

                                dato1.put("participante1", val.getKeyParticipanteLose1());
                                dato1.put("participante2", val.getKeyParticipanteLose2());
                                dato1.put("participante3",val.getKeyParticipanteLose3());
                                dato1.put("participante4", val.getKeyParticipanteLose4());
                                dato1.put("participante5", val.getKeyParticipanteLose5());
                                dato1.put("participante6", val.getKeyParticipanteLose6());
                                dato1.put("participante7", val.getKeyParticipanteLose7());
                                dato1.put("participante8", val.getKeyParticipanteLose8());
                                dato1.put("participante9", val.getKeyParticipanteLose9());

                                dato1.put("puestoN1","esperando");
                                dato1.put("puestoN2","esperando");
                                dato1.put("puestoN3","esperando");
                                dato1.put("puestoN4","esperando");
                                dato1.put("puestoN5","esperando");
                                dato1.put("puestoN6","esperando");
                                dato1.put("puestoN7","esperando");
                                dato1.put("puestoN8","esperando");
                                dato1.put("puestoN9","esperando");


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
                                    dato.put("puestoN1",val.getKeyParticipanteLose1());
                                    dato.put("puestoN2",val.getKeyParticipanteLose2());
                                    dato.put("puestoN3",val.getKeyParticipanteLose3());
                                    dato.put("puestoN4",val.getKeyParticipanteLose4());
                                    dato.put("puestoN5",val.getKeyParticipanteLose5());
                                    dato.put("puestoN6",val.getKeyParticipanteLose6());
                                    dato.put("puestoN7",val.getKeyParticipanteLose7());
                                    dato.put("puestoN8",val.getKeyParticipanteLose8());
                                    dato.put("puestoN9",val.getKeyParticipanteLose9());
                                    dato.put("puestoN10",val.getKeyParticipanteLose10());

                                    dato.put("participante1", val.getKeyParticipanteLose1());
                                    dato.put("participante2", val.getKeyParticipanteLose2());
                                    dato.put("participante3",val.getKeyParticipanteLose3());
                                    dato.put("participante4", val.getKeyParticipanteLose4());
                                    dato.put("participante5", val.getKeyParticipanteLose5());
                                    dato.put("participante6", val.getKeyParticipanteLose6());
                                    dato.put("participante7", val.getKeyParticipanteLose7());
                                    dato.put("participante8", val.getKeyParticipanteLose8());
                                    dato.put("participante9", val.getKeyParticipanteLose9());
                                    dato.put("participante10", val.getKeyParticipanteLose10());

                                    dato1.put("participante1", val.getKeyParticipanteLose1());
                                    dato1.put("participante2", val.getKeyParticipanteLose2());
                                    dato1.put("participante3",val.getKeyParticipanteLose3());
                                    dato1.put("participante4", val.getKeyParticipanteLose4());
                                    dato1.put("participante5", val.getKeyParticipanteLose5());
                                    dato1.put("participante6", val.getKeyParticipanteLose6());
                                    dato1.put("participante7", val.getKeyParticipanteLose7());
                                    dato1.put("participante8", val.getKeyParticipanteLose8());
                                    dato1.put("participante9", val.getKeyParticipanteLose9());
                                    dato1.put("participante10", val.getKeyParticipanteLose10());

                                    dato1.put("puestoN1","esperando");
                                    dato1.put("puestoN2","esperando");
                                    dato1.put("puestoN3","esperando");
                                    dato1.put("puestoN4","esperando");
                                    dato1.put("puestoN5","esperando");
                                    dato1.put("puestoN6","esperando");
                                    dato1.put("puestoN7","esperando");
                                    dato1.put("puestoN8","esperando");
                                    dato1.put("puestoN9","esperando");
                                    dato1.put("puestoN10","esperando");


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
                                        dato.put("puestoN1",val.getKeyParticipanteLose1());
                                        dato.put("puestoN2",val.getKeyParticipanteLose2());
                                        dato.put("puestoN3",val.getKeyParticipanteLose3());
                                        dato.put("puestoN4",val.getKeyParticipanteLose4());
                                        dato.put("puestoN5",val.getKeyParticipanteLose5());
                                        dato.put("puestoN6",val.getKeyParticipanteLose6());
                                        dato.put("puestoN7",val.getKeyParticipanteLose7());
                                        dato.put("puestoN8",val.getKeyParticipanteLose8());
                                        dato.put("puestoN9",val.getKeyParticipanteLose9());
                                        dato.put("puestoN10",val.getKeyParticipanteLose10());
                                        dato.put("puestoN11",val.getKeyParticipanteLose11());

                                        dato.put("participante1", val.getKeyParticipanteLose1());
                                        dato.put("participante2", val.getKeyParticipanteLose2());
                                        dato.put("participante3",val.getKeyParticipanteLose3());
                                        dato.put("participante4", val.getKeyParticipanteLose4());
                                        dato.put("participante5", val.getKeyParticipanteLose5());
                                        dato.put("participante6", val.getKeyParticipanteLose6());
                                        dato.put("participante7", val.getKeyParticipanteLose7());
                                        dato.put("participante8", val.getKeyParticipanteLose8());
                                        dato.put("participante9", val.getKeyParticipanteLose9());
                                        dato.put("participante10", val.getKeyParticipanteLose10());
                                        dato.put("participante11", val.getKeyParticipanteLose11());

                                        dato1.put("participante1", val.getKeyParticipanteLose1());
                                        dato1.put("participante2", val.getKeyParticipanteLose2());
                                        dato1.put("participante3",val.getKeyParticipanteLose3());
                                        dato1.put("participante4", val.getKeyParticipanteLose4());
                                        dato1.put("participante5", val.getKeyParticipanteLose5());
                                        dato1.put("participante6", val.getKeyParticipanteLose6());
                                        dato1.put("participante7", val.getKeyParticipanteLose7());
                                        dato1.put("participante8", val.getKeyParticipanteLose8());
                                        dato1.put("participante9", val.getKeyParticipanteLose9());
                                        dato1.put("participante10", val.getKeyParticipanteLose10());
                                        dato1.put("participante11", val.getKeyParticipanteLose11());

                                        dato1.put("puestoN1","esperando");
                                        dato1.put("puestoN2","esperando");
                                        dato1.put("puestoN3","esperando");
                                        dato1.put("puestoN4","esperando");
                                        dato1.put("puestoN5","esperando");
                                        dato1.put("puestoN6","esperando");
                                        dato1.put("puestoN7","esperando");
                                        dato1.put("puestoN8","esperando");
                                        dato1.put("puestoN9","esperando");
                                        dato1.put("puestoN10","esperando");
                                        dato1.put("puestoN11","esperando");

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
                                            dato.put("puestoN1",val.getKeyParticipanteLose1());
                                            dato.put("puestoN2",val.getKeyParticipanteLose2());
                                            dato.put("puestoN3",val.getKeyParticipanteLose3());
                                            dato.put("puestoN4",val.getKeyParticipanteLose4());
                                            dato.put("puestoN5",val.getKeyParticipanteLose5());
                                            dato.put("puestoN6",val.getKeyParticipanteLose6());
                                            dato.put("puestoN7",val.getKeyParticipanteLose7());
                                            dato.put("puestoN8",val.getKeyParticipanteLose8());
                                            dato.put("puestoN9",val.getKeyParticipanteLose9());
                                            dato.put("puestoN10",val.getKeyParticipanteLose10());
                                            dato.put("puestoN11",val.getKeyParticipanteLose11());
                                            dato.put("puestoN12",val.getKeyParticipanteLose12());

                                            dato.put("participante1", val.getKeyParticipanteLose1());
                                            dato.put("participante2", val.getKeyParticipanteLose2());
                                            dato.put("participante3",val.getKeyParticipanteLose3());
                                            dato.put("participante4", val.getKeyParticipanteLose4());
                                            dato.put("participante5", val.getKeyParticipanteLose5());
                                            dato.put("participante6", val.getKeyParticipanteLose6());
                                            dato.put("participante7", val.getKeyParticipanteLose7());
                                            dato.put("participante8", val.getKeyParticipanteLose8());
                                            dato.put("participante9", val.getKeyParticipanteLose9());
                                            dato.put("participante10", val.getKeyParticipanteLose10());
                                            dato.put("participante11", val.getKeyParticipanteLose11());
                                            dato.put("participante12", val.getKeyParticipanteLose12());

                                            dato1.put("participante1", val.getKeyParticipanteLose1());
                                            dato1.put("participante2", val.getKeyParticipanteLose2());
                                            dato1.put("participante3",val.getKeyParticipanteLose3());
                                            dato1.put("participante4", val.getKeyParticipanteLose4());
                                            dato1.put("participante5", val.getKeyParticipanteLose5());
                                            dato1.put("participante6", val.getKeyParticipanteLose6());
                                            dato1.put("participante7", val.getKeyParticipanteLose7());
                                            dato1.put("participante8", val.getKeyParticipanteLose8());
                                            dato1.put("participante9", val.getKeyParticipanteLose9());
                                            dato1.put("participante10", val.getKeyParticipanteLose10());
                                            dato1.put("participante11", val.getKeyParticipanteLose11());
                                            dato1.put("participante12", val.getKeyParticipanteLose12());

                                            dato1.put("puestoN1","esperando");
                                            dato1.put("puestoN2","esperando");
                                            dato1.put("puestoN3","esperando");
                                            dato1.put("puestoN4","esperando");
                                            dato1.put("puestoN5","esperando");
                                            dato1.put("puestoN6","esperando");
                                            dato1.put("puestoN7","esperando");
                                            dato1.put("puestoN8","esperando");
                                            dato1.put("puestoN9","esperando");
                                            dato1.put("puestoN10","esperando");
                                            dato1.put("puestoN11","esperando");
                                            dato1.put("puestoN12","esperando");

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
val.setKeyCalabozoActivo("0");
        dato1.put("keyConteo",val.getKeyConteo());

            bdNeutro.collection("BDcalabozo").document("tablaUp" + val.getKeyCalabozoActivo()+"lose").set(dato1);
            bdNeutro.collection("BDcalabozo").document("calabozoUp" + val.getKeyCalabozoActivo()+"lose").set(dato);




    }

}