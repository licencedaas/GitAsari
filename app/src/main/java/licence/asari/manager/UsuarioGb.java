package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Stack;



public class UsuarioGb extends AppCompatActivity {

    private TextView l1,l2;
    private RadioButton r1,r2,r3,r4;
    private ImageButton b1,b2;

    FirebaseFirestore bdNeutral, bdAzul;
    String llave2, eleccionDimencio;
    private RadioGroup  rdStandar;
    public static Stack<String> idV1 = new Stack <String>  ();
    contexto val ;
    double conver3=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_gb);
        val = new contexto();

        String llave1 = getIntent().getStringExtra("nick");
        llave2 = getIntent().getStringExtra("cdGremio");

        val.setKeyCodigo(llave2);

        bdNeutral = FirebaseFirestore.getInstance();
        bdAzul = FirebaseFirestore.getInstance();

        l1 =(TextView) findViewById(R.id.l1_perfilgb);
        r1 =(RadioButton) findViewById(R.id.r1Gb);
        r2 =(RadioButton) findViewById(R.id.r2Gb);
        r3 =(RadioButton) findViewById(R.id.r3Gb);
        r4 =(RadioButton) findViewById(R.id.r4Gb);
        b1=(ImageButton) findViewById(R.id.registroDimen);
        b2=(ImageButton) findViewById(R.id.EventTesla_b2);
        rdStandar =(RadioGroup) findViewById(R.id.confDimen1);
        l2 =(TextView) findViewById(R.id.EventTesla_l2);

    int    converLLave2 = Integer.parseInt(llave2);



        if(converLLave2 >100 && converLLave2 < 600){//gremio azul



            bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    if(documentSnapshot.exists()){
                        val.setKeyAviso2(documentSnapshot.getString("acceso"));
                        if(val.getKeyAviso2().contains("on")){
                            b2.setVisibility(View.VISIBLE);
                            l2.setVisibility(View.VISIBLE);
                        }else{
                            if(val.getKeyAviso2().contains("of")){
                                b2.setVisibility(View.GONE);
                                l2.setVisibility(View.GONE);
                            }
                        }

                    }}});




            l1.setText(llave1);
            contexto val = new contexto();

            bdNeutral.collection("BDazul").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    val.setKeyDimencion(documentSnapshot.getString("dimencion"));


                    if(val.getKeyDimencion().equals("null")){



                        rdStandar.setVisibility(View.VISIBLE);b1.setVisibility(View.VISIBLE);
                        Toast.makeText(UsuarioGb.this, "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                        try{

                            bdNeutral.collection("BDgremio").document("100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                    String elegir1 = documentSnapshot.getString("dimencion_1");
                                    r1.setText(elegir1);
                                    idV1.add(elegir1);//0
                                    String elegir2 = documentSnapshot.getString("dimencion_2");
                                    r2.setText(elegir2);
                                    idV1.add(elegir2);//1
                                    String elegir3 = documentSnapshot.getString("dimencion_3");
                                    r3.setText(elegir3);
                                    idV1.add(elegir3);//2
                                    String elegir4 = documentSnapshot.getString("dimencion_4");
                                    r4.setText(elegir4);
                                    idV1.add(elegir4);//3


                                }});

                        }catch (Exception h){
                            Toast.makeText(UsuarioGb.this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                        }




                    }else{
                        rdStandar.setVisibility(View.GONE);
                        b1.setVisibility(View.GONE);

                    }
                }});




        }else{
        if(converLLave2>1100 && converLLave2 < 1600){//gremio azul
                contexto val = new contexto();
                val.setKeyEscaneoGrenio("rojo");
                bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            val.setKeyAviso2(documentSnapshot.getString("acceso"));
                            if(val.getKeyAviso2().contains("on")){
                                b2.setVisibility(View.VISIBLE);
                                l2.setVisibility(View.VISIBLE);
                            }else{
                                if(val.getKeyAviso2().contains("of")){
                                    b2.setVisibility(View.GONE);
                                    l2.setVisibility(View.GONE);
                                }} }}});


                bdAzul.collection("BDrojo").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        val.setKeyDimencion(documentSnapshot.getString("dimencion"));
                        if(val.getKeyDimencion().equals("null")){
                            rdStandar.setVisibility(View.VISIBLE);b1.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                            try{
                                bdAzul.collection("BDgremio").document("1100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                                        String elegir1 = documentSnapshot.getString("dimencion_1");
                                        r1.setText(elegir1);
                                        idV1.add(elegir1);//0
                                        String elegir2 = documentSnapshot.getString("dimencion_2");
                                        r2.setText(elegir2);
                                        idV1.add(elegir2);//1
                                        String elegir3 = documentSnapshot.getString("dimencion_3");
                                        r3.setText(elegir3);
                                        idV1.add(elegir3);//2
                                        String elegir4 = documentSnapshot.getString("dimencion_4");
                                        r4.setText(elegir4);
                                        idV1.add(elegir4);//3


                                    }});

                            }catch (Exception h){
                                Toast.makeText(getApplicationContext(), "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                            }




                        }else{
                            rdStandar.setVisibility(View.GONE);
                            b1.setVisibility(View.GONE);
                        } }}); }else{
        if(converLLave2 >2100 && converLLave2 < 2600){//gremio azul
                        contexto val = new contexto();

                    val.setKeyEscaneoGrenio("naranja");
                    bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if(documentSnapshot.exists()){
                                val.setKeyAviso2(documentSnapshot.getString("acceso"));
                                if(val.getKeyAviso2().contains("on")){
                                    b2.setVisibility(View.VISIBLE);
                                    l2.setVisibility(View.VISIBLE);
                                }else{
                                    if(val.getKeyAviso2().contains("of")){
                                        b2.setVisibility(View.GONE);
                                        l2.setVisibility(View.GONE);
                                    }} }}});


                    bdAzul.collection("BDnaranja").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            val.setKeyDimencion(documentSnapshot.getString("dimencion"));
                            if(val.getKeyDimencion().equals("null")){
                                rdStandar.setVisibility(View.VISIBLE);b1.setVisibility(View.VISIBLE);
                                Toast.makeText(getApplicationContext(), "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                                try{
                                    bdAzul.collection("BDgremio").document("2100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                                            String elegir1 = documentSnapshot.getString("dimencion_1");
                                            r1.setText(elegir1);
                                            idV1.add(elegir1);//0
                                            String elegir2 = documentSnapshot.getString("dimencion_2");
                                            r2.setText(elegir2);
                                            idV1.add(elegir2);//1
                                            String elegir3 = documentSnapshot.getString("dimencion_3");
                                            r3.setText(elegir3);
                                            idV1.add(elegir3);//2
                                            String elegir4 = documentSnapshot.getString("dimencion_4");
                                            r4.setText(elegir4);
                                            idV1.add(elegir4);//3


                                        }});

                                }catch (Exception h){
                                    Toast.makeText(getApplicationContext(), "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                                }




                            }else{
              //                  Toast.makeText(getApplicationContext(), "DESABILITANDO ASIGNACION", Toast.LENGTH_SHORT).show();
                                rdStandar.setVisibility(View.GONE);
                                b1.setVisibility(View.GONE);

                            } }}); }else{
         if(converLLave2 >3100 && converLLave2 < 3600){
             //gremio azul
        contexto val = new contexto();
        val.setKeyEscaneoGrenio("negro");

             Toast.makeText(getApplicationContext(), "CD: " + converLLave2, Toast.LENGTH_SHORT).show();

                       bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {

                                if(documentSnapshot.exists()){
                                    val.setKeyAviso2(documentSnapshot.getString("acceso"));
                                    if(val.getKeyAviso2().contains("on")){
                                        b2.setVisibility(View.VISIBLE);
                                        l2.setVisibility(View.VISIBLE);
                                    }else{
                                        if(val.getKeyAviso2().contains("of")){
                                            b2.setVisibility(View.GONE);
                                            l2.setVisibility(View.GONE);
                                        }} }}});


                        bdAzul.collection("BDnegro").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                val.setKeyDimencion(documentSnapshot.getString("dimencion"));
                                if(val.getKeyDimencion().equals("null")){
                                    rdStandar.setVisibility(View.VISIBLE);b1.setVisibility(View.VISIBLE);
                                    Toast.makeText(getApplicationContext(), "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                                    try{
                                        bdAzul.collection("BDgremio").document("3100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                String elegir1 = documentSnapshot.getString("dimencion_1");
                                                r1.setText(elegir1);
                                                idV1.add(elegir1);//0
                                                String elegir2 = documentSnapshot.getString("dimencion_2");
                                                r2.setText(elegir2);
                                                idV1.add(elegir2);//1
                                                String elegir3 = documentSnapshot.getString("dimencion_3");
                                                r3.setText(elegir3);
                                                idV1.add(elegir3);//2
                                                String elegir4 = documentSnapshot.getString("dimencion_4");
                                                r4.setText(elegir4);
                                                idV1.add(elegir4);//3
                                            }}); }catch (Exception h){
                                        Toast.makeText(getApplicationContext(), "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                                    }




                                }else{
                                    rdStandar.setVisibility(View.GONE);
                                    b1.setVisibility(View.GONE);
                                } }});


         }else{
                        if(converLLave2 >4100 && converLLave2 < 4600){//gremio azul
                            //  Toast.makeText(getApplicationContext(), "capacidad de 4100", Toast.LENGTH_SHORT).show();
                            contexto val = new contexto();
                            val.setKeyEscaneoGrenio("calido");
                            bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                    if(documentSnapshot.exists()){
                                        val.setKeyAviso2(documentSnapshot.getString("acceso"));
                                        if(val.getKeyAviso2().contains("on")){
                                            b2.setVisibility(View.VISIBLE);
                                            l2.setVisibility(View.VISIBLE);
                                        }else{
                                            if(val.getKeyAviso2().contains("of")){
                                                b2.setVisibility(View.GONE);
                                                l2.setVisibility(View.GONE);
                                            }} }}});


                            bdAzul.collection("BDcalido").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    val.setKeyDimencion(documentSnapshot.getString("dimencion"));
                                    if(val.getKeyDimencion().equals("null")){
                                        rdStandar.setVisibility(View.VISIBLE);b1.setVisibility(View.VISIBLE);
                                        Toast.makeText(getApplicationContext(), "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                                        try{
                                            bdAzul.collection("BDgremio").document("4100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                @Override
                                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                    String elegir1 = documentSnapshot.getString("dimencion_1");
                                                    r1.setText(elegir1);
                                                    idV1.add(elegir1);//0
                                                    String elegir2 = documentSnapshot.getString("dimencion_2");
                                                    r2.setText(elegir2);
                                                    idV1.add(elegir2);//1
                                                    String elegir3 = documentSnapshot.getString("dimencion_3");
                                                    r3.setText(elegir3);
                                                    idV1.add(elegir3);//2
                                                    String elegir4 = documentSnapshot.getString("dimencion_4");
                                                    r4.setText(elegir4);
                                                    idV1.add(elegir4);//3


                                                }});

                                        }catch (Exception h){
                                            Toast.makeText(getApplicationContext(), "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                                        }




                                    }else{
                                        rdStandar.setVisibility(View.GONE);
                                        b1.setVisibility(View.GONE);
                                    } }}); }
                    }

                };
            }
        }


    }//find

    public void actualizar(){
        HashMap<String, Object> registro = new HashMap<>();
        registro.put("dimencion",eleccionDimencio);

        bdAzul.collection("BD"+val.getKeyEscaneoGrenio()).document(llave2).update(registro);

        Toast.makeText(this, "REGISTRO COMPLETADOS CON EXITO", Toast.LENGTH_SHORT).show();
        rdStandar.setVisibility(View.GONE);b1.setVisibility(View.GONE);

    }

    public void exitos(){
        if(r1.isChecked() == true){
            eleccionDimencio=idV1.get(0);
            actualizar();

        }else{
            if(r2.isChecked() == true){
                eleccionDimencio=idV1.get(1);
                actualizar();

            }else{
                if(r3.isChecked() == true) {
                    eleccionDimencio=idV1.get(2);
                    actualizar();
                }else {
                    if (r4.isChecked() == true) {
                        eleccionDimencio=idV1.get(3);
                        actualizar();
                    } } } }
    }

    public void accionElegirDimencio(View control){

        exitos();

    }

    public void estadisticas(View sdfs){
        contexto val = new contexto();
        Intent siguiente = new Intent(this,estadisticas.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "admin");

        startActivity(siguiente);

    }

    public void renovarClave(View sdfs){
        contexto val = new contexto();
        Intent siguiente = new Intent(this,renovarPass.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "admin");

        startActivity(siguiente);



    }

   public void random(View random){



       Intent siguiente = new Intent(this, Random.class);
       siguiente.putExtra("nick", val.getKeyNick());
       siguiente.putExtra("cdGremio", val.getKeyCodigo());
       siguiente.putExtra("keyDimen", val.getKeyDimencion());


       startActivity(siguiente);


   }

   public void puntaje(View uno){
       Intent siguiente = new Intent(getApplicationContext(), RegistroPuntos.class);


       siguiente.putExtra("nick", val.getKeyNick());
      siguiente.putExtra("cdGremio", val.getKeyCodigo());
       siguiente.putExtra("keyDimen", val.getKeyDimencion());

       siguiente.putExtra("standar", "admin");



       startActivity(siguiente);

   }

   public void tablaRandom(View random){
      contexto val = new contexto();

     //  Toast.makeText(this, "nick: " + val.getKeyNick() + "cdGremio:  "+ val.getKeyCodigo(), Toast.LENGTH_SHORT).show();

/*
     Intent siguiente = new Intent(this, tablaPunto.class);
     siguiente.putExtra("nick", val.getKeyNick());
     siguiente.putExtra("cdGremio", val.getKeyCodigo());

     startActivity(siguiente);
*/

   }

public void tablaFinal(View finala){

        Intent siguiente = new Intent(this,tablaFinal.class);
    siguiente.putExtra("nick", val.getKeyNick());
    siguiente.putExtra("cdGremio", val.getKeyCodigo());
    siguiente.putExtra("standar", "admin");
        startActivity(siguiente);

}

    public void permisos(View sfds){

        Intent siguiente = new Intent(this,gremio.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "admin");
        startActivity(siguiente);
    }

    public void salonEventos2(View sdfgbvb){

        contexto val = new contexto();
        Intent siguiente = new Intent(this, MenuEventos.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "admin");
        startActivity(siguiente);
    }

    public void salonEventos(View sdf){

        contexto val = new contexto();
        Intent siguiente = new Intent(this,menuSalonFanma.class);
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("standar", "admin");
        startActivity(siguiente);
    }

public void eventoCierre(View sfds){

    Intent siguiente = new Intent(this,confi2.class);
    siguiente.putExtra("nick", val.getKeyNick());
    siguiente.putExtra("cdGremio", val.getKeyCodigo());
    siguiente.putExtra("standar", "admin");

    startActivity(siguiente);


}



}