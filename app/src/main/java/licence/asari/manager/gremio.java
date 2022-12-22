package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
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



public class gremio extends AppCompatActivity {

    private RadioButton r1,r2,r3,r4,r5,r6,r7;
    private RadioGroup grupo1,grupo2;
    private Spinner sp1;
    private FirebaseFirestore bdNeutro;
    private Stack <String> idV1 = new Stack<>();
    private TextView l1,l2;
    private EditText t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gremio);

        r1 = (RadioButton) findViewById(R.id.permiso_r1);
        r2 = (RadioButton) findViewById(R.id.permiso_r2);
        r3 = (RadioButton) findViewById(R.id.permiso_r3);
        r4 = (RadioButton) findViewById(R.id.permiso_r4);
        r5 = (RadioButton) findViewById(R.id.permiso_r5);
        r6 = (RadioButton) findViewById(R.id.permiso_r6);
        r7 = (RadioButton) findViewById(R.id.permiso_r7);

        t1 =(EditText) findViewById(R.id.gremio_t1);

        l1 =(TextView) findViewById(R.id.gremio_l1);
        l2 =(TextView) findViewById(R.id.gremio_l2);

        grupo1=(RadioGroup) findViewById(R.id.gremio_rg1);
        grupo2=(RadioGroup) findViewById(R.id.Gremiogrupo_2);

        sp1=(Spinner) findViewById(R.id.permiso_sp1);
        bdNeutro = FirebaseFirestore.getInstance();//Gremiogrupo_2

    contexto val = new contexto();

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

            try {

  bdNeutro.collection("BD"+ val.getKeyEscaneoGrenio()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
  @RequiresApi(api = Build.VERSION_CODES.N)
  @Override
  public void onComplete(@NonNull Task<QuerySnapshot> task) {

  if (task.isSuccessful()) {
  ArrayAdapter<String> datos = null;
      idV1.add("Seleccione");

  for (QueryDocumentSnapshot document : task.getResult()) {


  val.setKeyDuelista(document.getString("nick"));

  idV1.add(val.getKeyDuelista());

  }

  datos = new ArrayAdapter<>(getApplication(), R.layout.spiner_jornada_random, idV1);
  sp1.setAdapter(datos);
  } }}); }catch (Exception sdfs){}
        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));


     //   Toast.makeText(getApplicationContext(), "GREMIO: " + val.getKeyIdGremio(), Toast.LENGTH_SHORT).show();
        try{

            bdNeutro.collection("BDgremio").document(val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    String elegir1 = documentSnapshot.getString("dimencion_1");
                    r1.setText(elegir1);

                    String elegir2 = documentSnapshot.getString("dimencion_2");
                    r2.setText(elegir2);

                    String elegir3 = documentSnapshot.getString("dimencion_3");
                    r3.setText(elegir3);

                    String elegir4 = documentSnapshot.getString("dimencion_4");
                    r4.setText(elegir4);}});}catch (Exception h){}


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                          @Override
                                          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
if(sp1.getSelectedItem().toString().contains("Seleccione")){
    Toast.makeText(getApplicationContext(), "Elige a un duelista de la lista. "+val.getKeyEscaneoGrenio(), Toast.LENGTH_SHORT).show();
}else{
    val.setKeyDuelista2(sp1.getSelectedItem().toString());


    bdNeutro.collection("BD"+val.getKeyEscaneoGrenio())
            .whereEqualTo("nick",val.getKeyDuelista2()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {

  if(task.isSuccessful()) {

  for (QueryDocumentSnapshot document : task.getResult()) {
  val.setKeyDimencion2(document.getString("dimencion"));
  val.setKeyExiste(document.getString("codigo"));
}

  l1.setText("Dimen:"+val.getKeyDimencion2());

  l2.setText("Codigo:"+val.getKeyExiste());


  } }});


}
                                          }

                                          @Override
                                          public void onNothingSelected(AdapterView<?> parent) {

                                          }
                                      });








/*
if(sp1.getSelectedItem().toString().contains("Seleccione")){
    Toast.makeText(getApplicationContext(), "Elige a un duelista de la lista. "+val.getKeyEscaneoGrenio(), Toast.LENGTH_SHORT).show();
}else{

 */


     r1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
    if(r1.isChecked()) {
    val.setKeyDuelista2(sp1.getSelectedItem().toString());


    if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){
    Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
    }else{

    val.setKeyDimencion(r1.getText().toString());


        HashMap<String, Object> dato = new HashMap<>();
        dato.put("dimencion",val.getKeyDimencion());

        bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("nick",val.getKeyDuelista2())
        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
         @Override
         public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if(task.isSuccessful()) {
        for (QueryDocumentSnapshot document : task.getResult()) {

        val.setKeyCodigo(document.getString("codigo"));
}
            Toast.makeText(getApplicationContext(), "Cambio exitoso", Toast.LENGTH_SHORT).show();
 bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).update(dato);grupo1.clearCheck();

    } }}); }


            } });

   r2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
    if(r2.isChecked()) {
    val.setKeyDuelista2(sp1.getSelectedItem().toString());
    r2.setEnabled(true);
        if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){
            Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
        }else{

            val.setKeyDimencion(r2.getText().toString());


            HashMap<String, Object> dato = new HashMap<>();
            dato.put("dimencion",val.getKeyDimencion());

            bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("nick",val.getKeyDuelista2())
                    .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            val.setKeyCodigo(document.getString("codigo"));
                        }
                        Toast.makeText(getApplicationContext(), "Cambio exitoso", Toast.LENGTH_SHORT).show();
                        bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).update(dato);grupo1.clearCheck();
                    } }}); }

} });
    r3.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
    if(r3.isChecked()) {
     val.setKeyDuelista2(sp1.getSelectedItem().toString());
        if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){
            Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
        }else{

            val.setKeyDimencion(r3.getText().toString());


            HashMap<String, Object> dato = new HashMap<>();
            dato.put("dimencion",val.getKeyDimencion());

            bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("nick",val.getKeyDuelista2())
                    .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            val.setKeyCodigo(document.getString("codigo"));
                        }
                        Toast.makeText(getApplicationContext(), "Cambio exitoso", Toast.LENGTH_SHORT).show();
                        bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).update(dato);grupo1.clearCheck();
                    } }}); }

} });
  r4.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
  if(r4.isChecked()) {
  val.setKeyDuelista2(sp1.getSelectedItem().toString());
  if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){

  Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
  }else{

   val.setKeyDimencion(r4.getText().toString());


   HashMap<String, Object> dato = new HashMap<>();
   dato.put("dimencion",val.getKeyDimencion());



          bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).whereEqualTo("nick",val.getKeyDuelista2())
                  .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
              @Override
              public void onComplete(@NonNull Task<QuerySnapshot> task) {
                  if(task.isSuccessful()) {
                      for (QueryDocumentSnapshot document : task.getResult()) {
                          val.setKeyCodigo(document.getString("codigo"));
                      }
                      Toast.makeText(getApplicationContext(), "Cambio exitoso ", Toast.LENGTH_SHORT).show();
                      bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).update(dato);grupo1.clearCheck();
                  } }}); }

} });
   r5.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
   if(r5.isChecked()) {
  val.setKeyDuelista2(sp1.getSelectedItem().toString());

 if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){
 Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
 }else{
     Toast.makeText(getApplicationContext(), "Cambio exitoso", Toast.LENGTH_SHORT).show();


     HashMap<String, Object> dato = new HashMap<>();

         dato.put("fx","TRUE");


     bdNeutro.collection("BDAsary").document(val.getKeyDuelista2()).update(dato);grupo2.clearCheck();
 }

  } });
  r6.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
 if(r6.isChecked()) {
 val.setKeyDuelista2(sp1.getSelectedItem().toString());

     if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){
         Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
     }else{
         Toast.makeText(getApplicationContext(), "Cambio exitoso", Toast.LENGTH_SHORT).show();


         HashMap<String, Object> dato = new HashMap<>();

         dato.put("fx","FALSE");


         bdNeutro.collection("BDAsary").document(val.getKeyDuelista2()).update(dato);grupo2.clearCheck();
     }

 } });
   r7.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
if(r7.isChecked()) {
  val.setKeyDuelista2(sp1.getSelectedItem().toString());
if(val.getKeyDuelista2().equals("")&&sp1.getSelectedItem().toString().contains("Seleccione")){
  Toast.makeText(getApplicationContext(), "Seleccione a un integrante" , Toast.LENGTH_SHORT).show();
} else{

bdNeutro.collection("BDAsary").document(val.getKeyDuelista2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {

   if(documentSnapshot.exists()){

   val.setKeyCodigo(documentSnapshot.getString("codigo"));
   bdNeutro.collection("BD"+val.getKeyEscaneoGrenio()).document(val.getKeyCodigo()).delete();
   bdNeutro.collection("BDAsary").document(val.getKeyDuelista2()).delete();
   bdNeutro.collection("TablaNick").document(val.getKeyCodigo()).delete();
       Toast.makeText(getApplicationContext(), "Proceos Exitoso.", Toast.LENGTH_SHORT).show();

   }


}
});


}


}

});}

    public void miniEvebto(View sdfs){

   if(t1.getText().toString().equals("")){
       Toast.makeText(getApplicationContext(), "Campos vacio", Toast.LENGTH_SHORT).show();
   }else{

  contexto val = new  contexto();

  val.setKeyMini1(t1.getText().toString());

  bdNeutro.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
      @Override
      public void onSuccess(DocumentSnapshot documentSnapshot) {

     val.setKeyJ1(Integer.parseInt(documentSnapshot.getString("acceso7")));

     bdNeutro.collection("BDgremio").document(val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
         @Override
         public void onSuccess(DocumentSnapshot documentSnapshot) {

             Toast.makeText(getApplicationContext(), "Realizanodo el proceso..", Toast.LENGTH_SHORT).show();
             HashMap<String, Object> registro = new HashMap<>();




             for(int a =1; a <(val.getKeyJ1()+1); a++){

                 if (documentSnapshot.getString("mini"+a).contains("false")) {


                         registro.put("mini"+a, val.getKeyMini1());
                         break;

                 }else{

                     if(a == val.getKeyJ1()){
                         Toast.makeText(getApplicationContext(), "No hay mas campos para guardar", Toast.LENGTH_SHORT).show();
                         break;
                     }
                 }

             }



             bdNeutro.collection("BDgremio").document(val.getKeyIdGremio()).update(registro);
             Toast.makeText(getApplicationContext(), "Prpcesp exitoso  " + val.getKeyIdGremio(), Toast.LENGTH_SHORT).show();
         }
     });

}





  });


   }

   }


    public void cierre(View sdfs){
        contexto val = new contexto();
        Intent siguiente = new Intent(this,UsuarioGb.class);
        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeyCodigo());
        startActivity(siguiente);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();





        finishAffinity();
    }
}
/*


bdNeutro.collection("BDgremio").document(val.getKeyIdGremio()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {

  if(documentSnapshot.exists()) {
      Toast.makeText(getApplicationContext(), "Preparando...", Toast.LENGTH_SHORT).show();
      HashMap<String, Object> registro = new HashMap<>();


     if (documentSnapshot.getString("mini1").equals("false")) {
         if(documentSnapshot.getString("mini").equals( val.getKeyMini1())) {

         }else{
             registro.put("mini1", val.getKeyMini1());}
      }else{
         if (documentSnapshot.getString("mini2").equals("false")) {
             if(documentSnapshot.getString("mini2").equals( val.getKeyMini1())) {
                 registro.put("mini2", val.getKeyMini1());
             }


         }else{
             if (documentSnapshot.getString("mini3").equals("false")) {
                 if(documentSnapshot.getString("mini3").equals( val.getKeyMini1())) {
                     registro.put("mini3", val.getKeyMini1());
                 }
         }else{
                 if (documentSnapshot.getString("mini4").equals("false")) {
                     if(documentSnapshot.getString("mini4").equals( val.getKeyMini1())) {
                         registro.put("mini4", val.getKeyMini1());
                     }
             }else{
                     if (documentSnapshot.getString("mini5").equals("false")) {
                         if(documentSnapshot.getString("mini5").equals( val.getKeyMini1())) {
                             registro.put("mini5", val.getKeyMini1());
                         }
                 }
     }}}}



for(int a =0; a < 5; a++){
      if (documentSnapshot.getString("mini"+a).equals("false")) {

      if(documentSnapshot.getString("mini"+a).equals( val.getKeyMini1())){
          Toast.makeText(getApplicationContext(), "Titulo del evento repetido.", Toast.LENGTH_SHORT).show();
         break;
      }   else {
          Toast.makeText(getApplicationContext(), "Campo guardado.", Toast.LENGTH_SHORT).show();
          dato.put("mini" + a, val.getKeyMini1());
          break;
      }
      }

  }
  bdNeutral.collection("TablaPuntoCabeza").document(val.getKeyCodigo()).update(registro);
  bdNeutro.collection("BDgremio").document(val.getKeyIdGremio()).update(dato);
      Toast.makeText(getApplicationContext(), "Prpcesp exitoso  " + val.getKeyIdGremio(), Toast.LENGTH_SHORT).show();
              }

              }
              });
 */