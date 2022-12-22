package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;



public class renovarPass extends AppCompatActivity {

    private EditText t1,t2,t3,t4;
    private FirebaseFirestore bdNeutral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renovar_pass);

        contexto val = new contexto();



  t1 =(EditText) findViewById(R.id.config_t1);
        t2 =(EditText) findViewById(R.id.config_t2);
        t3 =(EditText) findViewById(R.id.config_t3);
        t4 =(EditText) findViewById(R.id.config_t4);

        bdNeutral = FirebaseFirestore.getInstance();

        val.setKeyNick( getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

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


    }



public void nuevoKick(View sdfs){

    contexto val = new contexto();
if(t1.getText().toString().equals("")){
Toast.makeText(getApplicationContext(), "Campo Nick vacio", Toast.LENGTH_SHORT).show();
}else{

if(t4.getText().toString().equals("")){
    Toast.makeText(getApplicationContext(), "Campo KRA1 vacio", Toast.LENGTH_SHORT).show();
}else{

    bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

  if(documentSnapshot.exists()) {
      Toast.makeText(getApplicationContext(), "Realizando cambios .... ", Toast.LENGTH_SHORT).show();
  val.setKeySiguienteN2(documentSnapshot.getString("acceso2"));

  if(val.getKeySiguienteN2().equals(t4.getText().toString())){


      val.setKeyDuelista(t1.getText().toString());

      bdNeutral.collection("BDAsary").document(val.getKeyNick()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
          @Override
          public void onSuccess(DocumentSnapshot documentSnapshot) {

              if(documentSnapshot.exists()){

                  val.setKeyCodigo(documentSnapshot.getString("codigo"));
                  val.setKeyExiste(documentSnapshot.getString("fecha"));
                  val.setKeypass(documentSnapshot.getString("pass"));
                  val.setIdDuelista1(documentSnapshot.getString("telefono"));
              }


              bdNeutral.collection("BDAsary").document(val.getKeyNick()).delete();

              HashMap<String,Object> dato = new HashMap<>();
              dato.put("codigo",val.getKeyCodigo());
              dato.put("fecha",val.getKeyExiste());
              dato.put("nick",val.getKeyDuelista());
              dato.put("pass",val.getKeypass());
              dato.put("telefono",val.getIdDuelista1());

              bdNeutral.collection("BDAsary").document(val.getKeyDuelista()).set(dato);



              HashMap<String,Object> dato2 = new HashMap<>();
              dato2.put("nick",val.getKeyDuelista());
              bdNeutral.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).update(dato2);

              HashMap<String,Object> dato3 = new HashMap<>();
              dato3.put("nick",val.getKeyDuelista());
              bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(dato2);



              HashMap<String,Object> dato1 = new HashMap<>();
              dato1.put("acceso2","usadoJf7845FmN");
             bdNeutral.collection("DAAS").document("Info").update(dato1);
             Toast.makeText(getApplicationContext(), "Proceso Exitoso", Toast.LENGTH_SHORT).show();
          }});


      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N1",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

       @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

           if (task.isSuccessful()) {
               for(QueryDocumentSnapshot document : task.getResult()){

                   HashMap<String,Object> dato4 = new HashMap<>();
                   dato4.put("RJornada N1",val.getKeyDuelista());
                   val.setKeyCodigo2(document.getString("codigo"));
                   bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
               } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N2",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N2",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});


      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N3",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N3",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N4",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N4",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});
      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N5",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N5",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N6",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N6",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N7",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N7",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N8",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N8",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N9",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N9",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N10",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N10",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N11",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N11",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});
      bdNeutral.collection("TablaPuntoCabeza").whereEqualTo("RJornada N12",val.getKeyNick()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {

              if (task.isSuccessful()) {
                  for(QueryDocumentSnapshot document : task.getResult()){

                      HashMap<String,Object> dato4 = new HashMap<>();
                      dato4.put("RJornada N12",val.getKeyDuelista());
                      val.setKeyCodigo2(document.getString("codigo"));
                      bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo2()).update(dato4);
                  } } }});

} else{
      Toast.makeText(getApplicationContext(), "Codigo ivalido", Toast.LENGTH_SHORT).show();

  }

  }}});


} }}

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

            }
        }





    }


    public void cambioPass(View sdfs){
    contexto  val = new contexto();


    if(t2.getText().toString().equals("")&&t3.getText().toString().equals("")&&t4.getText().toString().equals("")){

        Toast.makeText(getApplicationContext(), "debe llenar todos los campos", Toast.LENGTH_SHORT).show();
    }else{


 bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
  @Override
 public void onSuccess(DocumentSnapshot documentSnapshot) {

 if(documentSnapshot.exists()) {
 Toast.makeText(getApplicationContext(), "Realizando cambios .... ", Toast.LENGTH_SHORT).show();
 val.setKeySiguienteN2(documentSnapshot.getString("acceso3"));

 if(val.getKeySiguienteN2().equals(t4.getText().toString())){

     HashMap <String , Object> dato1 = new HashMap<>();
     dato1.put("pass",t3.getText().toString());

     bdNeutral.collection("BDAsary").document(val.getKeyNick()).update(dato1);

         HashMap <String , Object> dato3 = new HashMap<>();
         dato1.put("pass",t3.getText().toString());
         bdNeutral.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyNick()).update(dato3);




 }}}});


 }




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
        //  Toast.makeText(this, "OnDestroy tABLA FINAL", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
        finishAffinity();
    }
}