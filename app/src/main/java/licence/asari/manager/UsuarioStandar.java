package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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



public class UsuarioStandar extends AppCompatActivity {

    private TextView l1,l2;
    private RadioGroup rdStandar;
    private RadioButton r1,r2,r3,r4;
    public static Stack<String> idV1 = new Stack <String>  ();
    private ImageButton b1,b2;
    FirebaseFirestore bdNeutral, bdAzul;
    int converLLave2=0;

    String llave2, eleccionDimencio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_standar);

        String llave1 = getIntent().getStringExtra("nick");
        llave2 = getIntent().getStringExtra("cdGremio");
        contexto val = new contexto();

        val.setKeyDuelista(llave1);
        val.setKeyCodigo(llave2);

        bdNeutral = FirebaseFirestore.getInstance();
        bdAzul = FirebaseFirestore.getInstance();

        l1 =(TextView) findViewById(R.id.perfil_l1);
        l2 =(TextView) findViewById(R.id.Eventtesla_l1);

        rdStandar =(RadioGroup) findViewById(R.id.EleccionDimencionGb);
        r1=(RadioButton) findViewById(R.id.dimenInicial_1Gb);
        r2=(RadioButton) findViewById(R.id.dimenInicial_2Gb);
        r3=(RadioButton) findViewById(R.id.dimenInicial_3Gb);
        r4=(RadioButton) findViewById(R.id.dimenInicial_4Gb);
        b1 =(ImageButton) findViewById(R.id.perfilB1);
     //   b3 =(ImageButton) findViewById(R.id.eventoDos);


        b1.setVisibility(View.GONE);
    //    b3.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);

        b2 =(ImageButton) findViewById(R.id.Eventtesla_b2);
        b2.setVisibility(View.GONE);

        rdStandar.setVisibility(View.GONE);
        l1.setText(llave1);

        converLLave2 = Integer.parseInt(llave2);
      //  Toast.makeText(getApplicationContext(), "gremio: "+converLLave2, Toast.LENGTH_SHORT).show();
            if(converLLave2 >100 && converLLave2 < 500){//gremio azul

      //      Toast.makeText(getApplicationContext(), "capacidad de 500", Toast.LENGTH_SHORT).show();
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


         bdAzul.collection("BDazul").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
         @Override
         public void onSuccess(DocumentSnapshot documentSnapshot) {

         val.setKeyDimencion(documentSnapshot.getString("dimencion"));


         if(val.getKeyDimencion().equals("null")){



         rdStandar.setVisibility(View.VISIBLE);b1.setVisibility(View.VISIBLE);
         Toast.makeText(UsuarioStandar.this, "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
         try{

          bdAzul.collection("BDgremio").document("100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
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
                            Toast.makeText(UsuarioStandar.this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                        }




                    }else{
                        rdStandar.setVisibility(View.GONE);

} }}); }else{

       gremio1100();

 }

}

public void gremio2100(){
    if(converLLave2 >2100 && converLLave2 < 2600){//gremio azul
        contexto val = new contexto();
   //     Toast.makeText(getApplicationContext(), "capacidad de 2600", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(UsuarioStandar.this, "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(UsuarioStandar.this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                    }




                }else{
                    rdStandar.setVisibility(View.GONE);

                } }}); }else{

        gremio3100();
    }

}

public void gremio3100(){
    if(converLLave2 >3100 && converLLave2 < 3600){//gremio azul

     //   Toast.makeText(getApplicationContext(), "capacidad de 3600", Toast.LENGTH_SHORT).show();
        contexto val = new contexto();
        val.setKeyEscaneoGrenio("negro");
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
                    Toast.makeText(UsuarioStandar.this, "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(UsuarioStandar.this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                    }




                }else{
                    rdStandar.setVisibility(View.GONE);

                } }}); }else{

    }
}

public void gremio4100(){
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
                    Toast.makeText(UsuarioStandar.this, "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(UsuarioStandar.this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                    }




                }else{
                    rdStandar.setVisibility(View.GONE);

                } }}); }
}


public  void gremio1100(){
    if(converLLave2 >1100 && converLLave2 < 1600){//gremio azul

   //     Toast.makeText(getApplicationContext(), "capacidad de 1600", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(UsuarioStandar.this, "ELIJA SU DIMENCION ESTABLECIDA", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(UsuarioStandar.this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
                    }




                }else{
                    rdStandar.setVisibility(View.GONE);

                } }}); }else{

        gremio2100();
    }
}


    
    public void puntuacion (View uno){
       Intent siguiente = new Intent(this, RegistroPuntos.class);
       contexto val = new contexto();


        siguiente.putExtra("keyDimen", val.getKeyDimencion());
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "standar");

       startActivity(siguiente);
    }


    public void actualizar(){

        contexto val = new contexto();
        HashMap<String, Object> registro = new HashMap<>();
        registro.put("dimencion",eleccionDimencio);

        bdAzul.collection("BD"+val.getKeyEscaneoGrenio()).document(llave2).update(registro);




       Toast.makeText(this, "REGISTRO COMPLETADOS CON EXITO", Toast.LENGTH_SHORT).show();
       rdStandar.setVisibility(View.GONE);b1.setVisibility(View.GONE);

 }

    public void registroRadioDimencion(){
try{

        bdAzul.collection("BDazul").document(llave2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

            String elegir1 = documentSnapshot.getString("dimencion_1");
            idV1.add(elegir1);
            String elegir2 = documentSnapshot.getString("dimencion_2");
            idV1.add(elegir2);
            String elegir3 = documentSnapshot.getString("dimencion_3");
            idV1.add(elegir3);
            String elegir4 = documentSnapshot.getString("dimencion_4");
            idV1.add(elegir4);

            Toast.makeText(UsuarioStandar.this, "dimencion 4: " + elegir4, Toast.LENGTH_SHORT).show();
        }});

    }catch (Exception h){
    Toast.makeText(this, "Error  estableciendo  dimenciones", Toast.LENGTH_SHORT).show();
}
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


    public void tablaFinal(View finala){
          contexto val = new contexto();
        Intent siguiente = new Intent(this,tablaFinal.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "standar");

        startActivity(siguiente);

    }

    public void renovarClave(View sdfs){
        contexto val = new contexto();
    Intent siguiente = new Intent(this,renovarPass.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "standar");

        startActivity(siguiente);



    }

    public void salonEventos2(View sdfgbvb){

        contexto val = new contexto();
        Intent siguiente = new Intent(this, MenuEventos.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        siguiente.putExtra("standar", "standar");

        startActivity(siguiente);

    }

   public void menuResultados(View sdfs){

       contexto val = new contexto();
       Intent siguiente = new Intent(this,menuSalonFanma.class);
       siguiente.putExtra("nick", val.getKeyNick());
       siguiente.putExtra("cdGremio", val.getKeyCodigo());
       siguiente.putExtra("standar", "standar");

       startActivity(siguiente);

   }



  public void estadisticas(View sdfs){
      contexto val = new contexto();
      Intent siguiente = new Intent(this,estadisticas.class);
      siguiente.putExtra("nick", val.getKeyNick());
      siguiente.putExtra("cdGremio", val.getKeyCodigo());
      siguiente.putExtra("standar", "standar");

      startActivity(siguiente);

  }


    @Override
    protected void onStart() {
        super.onStart();  contexto val = new contexto();


      //  Toast.makeText(this, "OnStart  STANDAR:  "+ val.getSearKeyCodigo(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();


        // La actividad se ha vuelto visible (ahora se "reanuda").

    }
    @Override
    protected void onPause() {
        super.onPause();
       // Toast.makeText(this, "OnPause  STANDAR", Toast.LENGTH_SHORT).show();


    }
    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
      //  Toast.makeText(this, "OnDestroy  STANDAR", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }



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
                    siguiente.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    siguiente.putExtra("EXIT",true);
                    finishAffinity();
                    startActivity(siguiente);

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



}