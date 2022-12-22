package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;



public class RegistroNuevo<val> extends AppCompatActivity {

    private EditText t1,t2,t3;
    private String codigo,descripcion,precio, telefono,contraseña;
    int  contador=0;
    int converCdigo;
    FirebaseFirestore gremio, bdAzul,bdNeutro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_nuevo);

        t1=(EditText) findViewById(R.id.t1);
        t2=(EditText) findViewById(R.id.t2);
        t3=(EditText) findViewById(R.id.t3);
     //   t4=(EditText) findViewById(R.id.t4);
      //  t5=(EditText) findViewById(R.id.t5);


       gremio = FirebaseFirestore.getInstance();
       bdAzul= FirebaseFirestore.getInstance();
        bdNeutro= FirebaseFirestore.getInstance();
}

    public void consulta2022(View dos) {


   if (t1.getText().toString().equals("") && t2.getText().toString().equals("") && t3.getText().toString().equals("")) {
   Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_SHORT).show();
   }else{


   codigo = t1.getText().toString();
   gremio.collection("BDgremio").document(codigo).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override
   public void onSuccess(DocumentSnapshot documentSnapshot) {

   String codigo1 = documentSnapshot.getString("codigo");
   String key = documentSnapshot.getString("key");

   contexto val = new contexto();
   val.setKeyCodigo4(codigo);

   if (codigo1.equals("100")) {// BD AZUL 1000P 100 AL 600 + 600 =1000
   converCdigo = Integer.parseInt(codigo1);

   converCdigo = Integer.parseInt(key);
   converCdigo = converCdigo + 1;
   String key_1 = String.valueOf(converCdigo);


                    //////////// actualixar BDGRENIO  KEY
  HashMap<String, Object> registro = new HashMap<>();
  registro.put("key", key_1);
  gremio.collection("BDgremio").document(codigo).update(registro);

  contador = Integer.parseInt(codigo1);
  contador = contador + converCdigo;
  String codigo2 = String.valueOf(contador);

  descripcion = t2.getText().toString(); // nick
  precio = t3.getText().toString(); // nombre


  bdAzul.collection("BDAsary").document(descripcion).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override
  public void onSuccess(DocumentSnapshot documentSnapshot) {

  if (documentSnapshot.exists()) {

  Toast.makeText(getApplicationContext(), "Nick duplicado", Toast.LENGTH_SHORT).show();


  } else {
  try {

   HashMap<String, Object> map = new HashMap<>();
   map.put("codigo", codigo2);
   map.put("nick", descripcion);
   map.put("pass", precio);
   map.put("telefono", "null");
   map.put("fecha", "null");
   map.put("dimencion", "null");
   map.put("rival", "null");

   bdAzul.collection("BDazul").document(codigo2).set(map);

   t1.setText("");
    t2.setText("");
   t3.setText("");
   Toast.makeText(getApplicationContext(), "REGISTRO COMPLETO CON EXITO", Toast.LENGTH_SHORT).show();
      llamadoBinvenidao();
  } catch (Exception fdDGD) {
   }


    try {

   HashMap<String, Object> valueNeutral = new HashMap<>();
   valueNeutral.put("codigo", codigo2);
   valueNeutral.put("nick", descripcion);
    valueNeutral.put("pass", precio);
    valueNeutral.put("telefono", "null");
   valueNeutral.put("fecha", "null");
   valueNeutral.put("fx", "FALSE");
    bdNeutro.collection("BDAsary").document(descripcion).set(valueNeutral);
 } catch (Exception fsf) {
 }}}});


} else {

    //9910
 if (codigo1.equals("1100")) {
     converCdigo = Integer.parseInt(codigo1);

     converCdigo = Integer.parseInt(key);
     converCdigo = converCdigo + 1;
     String key_1 = String.valueOf(converCdigo);


     //////////// actualixar BDGRENIO  KEY
     HashMap<String, Object> registro = new HashMap<>();
     registro.put("key", key_1);
     gremio.collection("BDgremio").document(codigo).update(registro);

     contador = Integer.parseInt(codigo1);
     contador = contador + converCdigo;
     String codigo2 = String.valueOf(contador);

     descripcion = t2.getText().toString(); // nick
     precio = t3.getText().toString(); // nombre


     bdAzul.collection("BDAsary").document(descripcion).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
         @Override
         public void onSuccess(DocumentSnapshot documentSnapshot) {

             if (documentSnapshot.exists()) {

                 Toast.makeText(getApplicationContext(), "Nick duplicado", Toast.LENGTH_SHORT).show();


             } else {
                 try {

                     HashMap<String, Object> map = new HashMap<>();
                     map.put("codigo", codigo2);
                     map.put("nick", descripcion);
                     map.put("pass", precio);
                     map.put("telefono", "null");
                     map.put("fecha", "null");
                     map.put("dimencion", "null");
                     map.put("rival", "null");

                     bdAzul.collection("BDrojo").document(codigo2).set(map);

                     t1.setText("");
                     t2.setText("");
                     t3.setText("");
                     Toast.makeText(getApplicationContext(), "REGISTRO COMPLETO CON EXITO", Toast.LENGTH_SHORT).show();
                     llamadoBinvenidao();
                 } catch (Exception fdDGD) {
                 }


                 try {

                     HashMap<String, Object> valueNeutral = new HashMap<>();
                     valueNeutral.put("codigo", codigo2);
                     valueNeutral.put("nick", descripcion);
                     valueNeutral.put("pass", precio);
                     valueNeutral.put("telefono", "null");
                     valueNeutral.put("fecha", "null");
                     valueNeutral.put("fx", "FALSE");
                     bdNeutro.collection("BDAsary").document(descripcion).set(valueNeutral);
                 } catch (Exception fsf) {
                 }}}});


}else{
     if (codigo1.equals("2100")) {

         converCdigo = Integer.parseInt(key);
         converCdigo = converCdigo + 1;
         String key_1 = String.valueOf(converCdigo);


         //////////// actualixar BDGRENIO  KEY
         HashMap<String, Object> registro = new HashMap<>();
         registro.put("key", key_1);
         gremio.collection("BDgremio").document(codigo).update(registro);

         contador = Integer.parseInt(codigo1);
         contador = contador + converCdigo;
         String codigo2 = String.valueOf(contador);

         descripcion = t2.getText().toString(); // nick
         precio = t3.getText().toString(); // nombre


         bdAzul.collection("BDAsary").document(descripcion).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
             @Override
             public void onSuccess(DocumentSnapshot documentSnapshot) {

                 if (documentSnapshot.exists()) {

                     Toast.makeText(getApplicationContext(), "Nick duplicado", Toast.LENGTH_SHORT).show();


                 } else {
                     try {

                         HashMap<String, Object> map = new HashMap<>();
                         map.put("codigo", codigo2);
                         map.put("nick", descripcion);
                         map.put("pass", precio);
                         map.put("telefono", "null");
                         map.put("fecha", "null");
                         map.put("dimencion", "null");
                         map.put("rival", "null");

                         bdAzul.collection("BDnaranja").document(codigo2).set(map);

                         t1.setText("");
                         t2.setText("");
                         t3.setText("");
                         Toast.makeText(getApplicationContext(), "REGISTRO COMPLETO CON EXITO", Toast.LENGTH_SHORT).show();
                         llamadoBinvenidao();
                     } catch (Exception fdDGD) {
                     }


                     try {

                         HashMap<String, Object> valueNeutral = new HashMap<>();
                         valueNeutral.put("codigo", codigo2);
                         valueNeutral.put("nick", descripcion);
                         valueNeutral.put("pass", precio);
                         valueNeutral.put("telefono", "null");
                         valueNeutral.put("fecha", "null");
                         valueNeutral.put("fx", "FALSE");
                         bdNeutro.collection("BDAsary").document(descripcion).set(valueNeutral);
                     } catch (Exception fsf) {
                     }}}});



     }else{
         if (codigo1.equals("3100")) {

             converCdigo = Integer.parseInt(key);
             converCdigo = converCdigo + 1;
             String key_1 = String.valueOf(converCdigo);


             //////////// actualixar BDGRENIO  KEY
             HashMap<String, Object> registro = new HashMap<>();
             registro.put("key", key_1);
             gremio.collection("BDgremio").document(codigo).update(registro);

             contador = Integer.parseInt(codigo1);
             contador = contador + converCdigo;
             String codigo2 = String.valueOf(contador);

             descripcion = t2.getText().toString(); // nick
             precio = t3.getText().toString(); // nombre


             bdAzul.collection("BDAsary").document(descripcion).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                 @Override
                 public void onSuccess(DocumentSnapshot documentSnapshot) {

                     if (documentSnapshot.exists()) {

                         Toast.makeText(getApplicationContext(), "Nick duplicado", Toast.LENGTH_SHORT).show();


                     } else {
                         try {

                             HashMap<String, Object> map = new HashMap<>();
                             map.put("codigo", codigo2);
                             map.put("nick", descripcion);
                             map.put("pass", precio);
                             map.put("telefono", "null");
                             map.put("fecha", "null");
                             map.put("dimencion", "null");
                             map.put("rival", "null");

                             bdAzul.collection("BDnegro").document(codigo2).set(map);

                             t1.setText("");
                             t2.setText("");
                             t3.setText("");
                             Toast.makeText(getApplicationContext(), "REGISTRO COMPLETO CON EXITO", Toast.LENGTH_SHORT).show();
                             llamadoBinvenidao();
                         } catch (Exception fdDGD) {
                         }


                         try {

                             HashMap<String, Object> valueNeutral = new HashMap<>();
                             valueNeutral.put("codigo", codigo2);
                             valueNeutral.put("nick", descripcion);
                             valueNeutral.put("pass", precio);
                             valueNeutral.put("telefono", "null");
                             valueNeutral.put("fecha", "null");
                             valueNeutral.put("fx", "FALSE");
                             bdNeutro.collection("BDAsary").document(descripcion).set(valueNeutral);
                         } catch (Exception fsf) {
                         }}}});



         }else{
             if (codigo1.equals("4100")) {

                 converCdigo = Integer.parseInt(key);
                 converCdigo = converCdigo + 1;
                 String key_1 = String.valueOf(converCdigo);


                 //////////// actualixar BDGRENIO  KEY
                 HashMap<String, Object> registro = new HashMap<>();
                 registro.put("key", key_1);
                 gremio.collection("BDgremio").document(codigo).update(registro);

                 contador = Integer.parseInt(codigo1);
                 contador = contador + converCdigo;
                 String codigo2 = String.valueOf(contador);

                 descripcion = t2.getText().toString(); // nick
                 precio = t3.getText().toString(); // nombre


                 bdAzul.collection("BDAsary").document(descripcion).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                     @Override
                     public void onSuccess(DocumentSnapshot documentSnapshot) {

                         if (documentSnapshot.exists()) {

                             Toast.makeText(getApplicationContext(), "Nick duplicado", Toast.LENGTH_SHORT).show();


                         } else {
                             try {

                                 HashMap<String, Object> map = new HashMap<>();
                                 map.put("codigo", codigo2);
                                 map.put("nick", descripcion);
                                 map.put("pass", precio);
                                 map.put("telefono", "null");
                                 map.put("fecha", "null");
                                 map.put("dimencion", "null");
                                 map.put("rival", "null");

                                 bdAzul.collection("BDcalido").document(codigo2).set(map);

                                 t1.setText("");
                                 t2.setText("");
                                 t3.setText("");
                                 Toast.makeText(getApplicationContext(), "REGISTRO COMPLETO CON EXITO", Toast.LENGTH_SHORT).show();
                                 llamadoBinvenidao();
                             } catch (Exception fdDGD) {
                             }


                             try {

                                 HashMap<String, Object> valueNeutral = new HashMap<>();
                                 valueNeutral.put("codigo", codigo2);
                                 valueNeutral.put("nick", descripcion);
                                 valueNeutral.put("pass", precio);
                                 valueNeutral.put("telefono", "null");
                                 valueNeutral.put("fecha", "null");
                                 valueNeutral.put("fx", "FALSE");
                                 bdNeutro.collection("BDAsary").document(descripcion).set(valueNeutral);
                             } catch (Exception fsf) {
                             }}}});



             }
         }
     }

}


}




   }}); } }

    Context contexto;
    public void llamadoBinvenidao(){
        contexto = this;
        new detlles_inicializacion(contexto);
    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();
            Intent siguiente = new Intent(this,MainActivity2.class);
            startActivity(siguiente);
    }

   public void infoAsari(View sdfsfd){

   Intent siguiente = new Intent(this, reglasAsary.class);
   startActivity(siguiente);

   }





    public void entradaGremio(View sdfs){

   Intent sigienete = new Intent(this,puerta_gremio.class);
   startActivity(sigienete);

    }


}

