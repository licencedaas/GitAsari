package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class sentinGremio extends AppCompatActivity {


    private EditText t1_segting, sentin_t1, sentin_t2, sentin_t3, sentin_t4, sentin_t5 , sentin_t6;
    private ImageButton b1_segting;
    private String per_1= "131301", per_2= "131302", per_3= "131303", per_4= "131304";
    private String comprobar="", dimen_1="",dimen_2="",dimen_3="",dimen_4="",nomGremio="",codigoGremio="0"
            ,nomLider="", passLider ="", fechaLider ="457898", teleLider="30002222",dimeLider="CAMBIAR";
     FirebaseFirestore daas;
 contexto cox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentin_gremio);

        t1_segting =(EditText) findViewById(R.id.t1_segting);
        b1_segting =(ImageButton) findViewById(R.id.b1_segting);

        sentin_t1 =(EditText) findViewById(R.id.sentin_t1);
        sentin_t2 =(EditText) findViewById(R.id.sentin_t2);
        sentin_t3 =(EditText) findViewById(R.id.sentin_t3);
        sentin_t4 =(EditText) findViewById(R.id.sentin_t4);
        sentin_t5 =(EditText) findViewById(R.id.sentin_t5);
        sentin_t6 =(EditText) findViewById(R.id.sentin_t6);

        cox.GremioBd = FirebaseFirestore.getInstance();
        cox.azulBd = FirebaseFirestore.getInstance();
        daas = FirebaseFirestore.getInstance();


        sentin_t1.setEnabled(false);sentin_t3.setEnabled(false);sentin_t5.setEnabled(false);
        sentin_t2.setEnabled(false);sentin_t4.setEnabled(false);sentin_t6.setEnabled(false);

}


    public void codigoPermiso(View uno){

        if(t1_segting.toString().equals("") ){
        Toast.makeText(this, "DEBE INDICAR UN CODIGO DE PERMISO", Toast.LENGTH_SHORT).show();
        }else {
        comprobar =  t1_segting.getText().toString();


    daas.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {
    if(documentSnapshot.exists()) {

    String security = documentSnapshot.getString("acceso1");
        if (comprobar.equals(security)) {

            t1_segting.setText("");
            Toast.makeText(getApplicationContext(), "CAMPOS HABILITADOS INGRESE LOS DATOS DEL GREMIO", Toast.LENGTH_SHORT).show();
            sentin_t1.setEnabled(true);
            sentin_t3.setEnabled(true);
            sentin_t5.setEnabled(true);
            sentin_t2.setEnabled(true);
            sentin_t4.setEnabled(true);
            sentin_t6.setEnabled(true);

            HashMap<String,Object> dato = new HashMap<>();
            dato.put("acceso1","HjUikkj9*oP");
            daas.collection("DAAS").document("Info").update(dato);

        } else {
            Toast.makeText(getApplicationContext(), "Codgo erroneo: ", Toast.LENGTH_SHORT).show();
        }

 }}});

            



        }
        
        
    }


    public void registroCloudGremio(View gremio){

        if(sentin_t1.getText().toString().equals("") && sentin_t2.getText().toString().equals("")
                &&sentin_t3.getText().toString().equals("") && sentin_t4.getText().toString().equals("") &&
                sentin_t5.getText().toString().equals("")  &&  sentin_t6.getText().toString().equals("")){

            Toast.makeText(this, "DIGITE BIEN LOS CAMPOS", Toast.LENGTH_SHORT).show();
        }else {


            dimen_1 = sentin_t1.getText().toString();
            dimen_2 = sentin_t5.getText().toString();
            dimen_3 = sentin_t2.getText().toString();
            dimen_4 = sentin_t3.getText().toString();
            nomGremio = sentin_t4.getText().toString();
            nomLider = sentin_t6.getText().toString();

            try {

                codigoGremio = comprobar;
                if(comprobar.equals("131301")){
                    comprobar="100";

                    HashMap<String, Object> value = new HashMap<>();

                    value.put("codigo", comprobar);
                    value.put("gremio", nomGremio);
                    value.put("dimencion_1", dimen_1);
                    value.put("dimencion_2", dimen_2);
                    value.put("dimencion_3", dimen_3);
                    value.put("dimencion_4", dimen_4);
                    value.put("key", "1");

                    value.put("mini1", "false");
                    value.put("min2", "false");
                    value.put("mni3","false");
                    value.put("mini4", "false");
                    value.put("mini5", "false");

                    HashMap<String, Object> valueAzul = new HashMap<>();

                    int cambio = Integer.parseInt(comprobar);
                    cambio = cambio +1;

                    valueAzul.put("codigo", cambio);
                    valueAzul.put("nick", nomLider);
                    valueAzul.put("pass", "1234");
                    valueAzul.put("telefono", "null");
                    valueAzul.put("fecha", "null");
                    valueAzul.put("dimencion","null");

                    HashMap<String, Object> valueAsary = new HashMap<>();

                    valueAsary.put("codigo", String.valueOf(cambio));
                    valueAsary.put("nick", nomLider);
                    valueAsary.put("pass", "1234");
                    valueAsary.put("telefono", "null");
                    valueAsary.put("fecha", "null");
                    valueAsary.put("fx","TRUE");
                    cox.GremioBd.collection("BDAsary").document(nomLider).set(valueAsary);


                    cox.GremioBd.collection("BDgremio").document(comprobar).set(value);
                    cox.azulBd.collection("BDazul").document(String.valueOf(cambio)).set(valueAzul);
                    Toast.makeText(this, "REGISTRO EXITOSO SU CODIGO DE REGISTRO ES: " + comprobar, Toast.LENGTH_SHORT).show();
                } else{

                    if(comprobar.equals("141401")) {
                        comprobar = "1100";

                        HashMap<String, Object> value = new HashMap<>();

                        value.put("codigo", comprobar);
                        value.put("gremio", nomGremio);
                        value.put("dimencion_1", dimen_1);
                        value.put("dimencion_2", dimen_2);
                        value.put("dimencion_3", dimen_3);
                        value.put("dimencion_4", dimen_4);
                        value.put("key", "1");

                        value.put("mini1", "false");
                        value.put("min2", "false");
                        value.put("mni3","false");
                        value.put("mini4", "false");
                        value.put("mini5", "false");
                        HashMap<String, Object> valueAzul = new HashMap<>();

                        int cambio = Integer.parseInt(comprobar);
                        cambio = cambio +1;

                        valueAzul.put("codigo", cambio);
                        valueAzul.put("nick", nomLider);
                        valueAzul.put("pass", "1234");
                        valueAzul.put("telefono", "null");
                        valueAzul.put("fecha", "null");
                        valueAzul.put("dimencion","null");

                        HashMap<String, Object> valueAsary = new HashMap<>();

                        valueAsary.put("codigo", String.valueOf(cambio));
                        valueAsary.put("nick", nomLider);
                        valueAsary.put("pass", "1234");
                        valueAsary.put("telefono", "null");
                        valueAsary.put("fecha", "null");
                        valueAsary.put("fx","TRUE");
                        cox.GremioBd.collection("BDAsary").document(nomLider).set(valueAsary);


                        cox.GremioBd.collection("BDgremio").document(comprobar).set(value);
                        cox.azulBd.collection("BDrojo").document(String.valueOf(cambio)).set(valueAzul);
                        Toast.makeText(this, "REGISTRO EXITOSO SU CODIGO DE REGISTRO ES: " + comprobar,Toast.LENGTH_SHORT).show();

}else{
 if(comprobar.equals("153317")) {
 
     comprobar = "2100";
     HashMap<String, Object> value = new HashMap<>();

     value.put("codigo", comprobar);
     value.put("gremio", nomGremio);
     value.put("dimencion_1", dimen_1);
     value.put("dimencion_2", dimen_2);
     value.put("dimencion_3", dimen_3);
     value.put("dimencion_4", dimen_4);
     value.put("key", "1");
     value.put("mini1", "false");
     value.put("min2", "false");
     value.put("mni3","false");
     value.put("mini4", "false");
     value.put("mini5", "false");
     HashMap<String, Object> valueAzul = new HashMap<>();

     int cambio = Integer.parseInt(comprobar);
     cambio = cambio +1;

     valueAzul.put("codigo", cambio);
     valueAzul.put("nick", nomLider);
     valueAzul.put("pass", "1234");
     valueAzul.put("telefono", "null");
     valueAzul.put("fecha", "null");
     valueAzul.put("dimencion","null");

     HashMap<String, Object> valueAsary = new HashMap<>();

     valueAsary.put("codigo", String.valueOf(cambio));
     valueAsary.put("nick", nomLider);
     valueAsary.put("pass", "1234");
     valueAsary.put("telefono", "null");
     valueAsary.put("fecha", "null");
     valueAsary.put("fx","TRUE");
     cox.GremioBd.collection("BDAsary").document(nomLider).set(valueAsary);

     cox.GremioBd.collection("BDgremio").document(comprobar).set(value);
     cox.azulBd.collection("BDnaranja").document(String.valueOf(cambio)).set(valueAzul);

     Toast.makeText(this, "REGISTRO EXITOSO SU CODIGO DE REGISTRO ES: " + comprobar, Toast.LENGTH_SHORT).show();
     
 }else{

     if(comprobar.equals("ABN*987")) {

         comprobar = "3100";
         HashMap<String, Object> value = new HashMap<>();

         value.put("codigo", comprobar);
         value.put("gremio", nomGremio);
         value.put("dimencion_1", dimen_1);
         value.put("dimencion_2", dimen_2);
         value.put("dimencion_3", dimen_3);
         value.put("dimencion_4", dimen_4);
         value.put("key", "1");
         value.put("mini1", "false");
         value.put("min2", "false");
         value.put("mni3","false");
         value.put("mini4", "false");
         value.put("mini5", "false");
         HashMap<String, Object> valueAzul = new HashMap<>();

         int cambio = Integer.parseInt(comprobar);
         cambio = cambio +1;

         valueAzul.put("codigo", cambio);
         valueAzul.put("nick", nomLider);
         valueAzul.put("pass", "1234");
         valueAzul.put("telefono", "null");
         valueAzul.put("fecha", "null");
         valueAzul.put("dimencion","null");


         HashMap<String, Object> valueAsary = new HashMap<>();

         valueAsary.put("codigo", String.valueOf(cambio));
         valueAsary.put("nick", nomLider);
         valueAsary.put("pass", "1234");
         valueAsary.put("telefono", "null");
         valueAsary.put("fecha", "null");
         valueAsary.put("fx","TRUE");
         cox.GremioBd.collection("BDAsary").document(nomLider).set(valueAsary);


         cox.GremioBd.collection("BDgremio").document(comprobar).set(value);
         cox.azulBd.collection("BDnegro").document(String.valueOf(cambio)).set(valueAzul);
         Toast.makeText(this, "REGISTRO EXITOSO SU CODIGO DE REGISTRO ES: " + comprobar, Toast.LENGTH_SHORT).show();

     }else{

         if(comprobar.equals("TYGR87+")) {

             comprobar = "4100";
             HashMap<String, Object> value = new HashMap<>();

             value.put("codigo", comprobar);
             value.put("gremio", nomGremio);
             value.put("dimencion_1", dimen_1);
             value.put("dimencion_2", dimen_2);
             value.put("dimencion_3", dimen_3);
             value.put("dimencion_4", dimen_4);
             value.put("key", "1");
             value.put("mini1", "false");
             value.put("min2", "false");
             value.put("mni3","false");
             value.put("mini4", "false");
             value.put("mini5", "false");
             HashMap<String, Object> valueAzul = new HashMap<>();

             int cambio = Integer.parseInt(comprobar);
             cambio = cambio +1;

             valueAzul.put("codigo", cambio);
             valueAzul.put("nick", nomLider);
             valueAzul.put("pass", "null");
             valueAzul.put("telefono", "null");
             valueAzul.put("fecha", "null");
             valueAzul.put("dimencion","null");

             HashMap<String, Object> valueAsary = new HashMap<>();

             valueAsary.put("codigo", String.valueOf(cambio));
             valueAsary.put("nick", nomLider);
             valueAsary.put("pass", "1234");
             valueAsary.put("telefono", "null");
             valueAsary.put("fecha", "null");
             valueAsary.put("fx","TRUE");
             cox.GremioBd.collection("BDAsary").document(nomLider).set(valueAsary);


             cox.GremioBd.collection("BDgremio").document(comprobar).set(value);
             cox.azulBd.collection("BDcalido").document(String.valueOf(cambio)).set(valueAzul);
             Toast.makeText(this, "REGISTRO EXITOSO SU CODIGO DE REGISTRO ES: " + comprobar, Toast.LENGTH_SHORT).show();

         }

} }}
                
                
                }







                sentin_t1.setText("");
                sentin_t3.setText("");
                sentin_t2.setText("");
                sentin_t4.setText("");
                sentin_t5.setText("");
                sentin_t6.setText("");
                sentin_t1.setEnabled(false);sentin_t3.setEnabled(false);sentin_t5.setEnabled(false);
                sentin_t2.setEnabled(false);sentin_t4.setEnabled(false);sentin_t6.setEnabled(false);


             


            } catch (Exception fd) {
            }
        }

    }


    public void registroAzul(){


        try {

            DominioAzul azul = new DominioAzul(this, "azul", null, 1);
            SQLiteDatabase abrir = azul.getWritableDatabase();
            ContentValues valueAzul = new ContentValues();
            nomLider = sentin_t6.getText().toString();

            int cambio = Integer.parseInt(comprobar);
            cambio = cambio +1;

         valueAzul.put("codigo", cambio);
         valueAzul.put("descripcion", nomLider);
        valueAzul.put("precio", "null");
        valueAzul.put("telefono", "1234");
       valueAzul.put("contraseña", "null");
        valueAzul.put("fecha","null");

            abrir.insert("azul", null, valueAzul);
            abrir.close();

            sentin_t6.setText("");
        }catch (Exception f){
            Toast.makeText(this, "ERROR AZUL", Toast.LENGTH_SHORT).show();
        }



    }



    public  void registroGremio(View dos){


        if(sentin_t1.getText().toString().equals("") && sentin_t2.getText().toString().equals("")
                &&sentin_t3.getText().toString().equals("") && sentin_t4.getText().toString().equals("") &&
                sentin_t5.getText().toString().equals("")  &&  sentin_t6.getText().toString().equals("")){

            Toast.makeText(this, "DIGITE BIEN LOS CAMPOS", Toast.LENGTH_SHORT).show();
        }else{


            dimen_1 = sentin_t1.getText().toString();
            dimen_2 = sentin_t5.getText().toString();
            dimen_3 = sentin_t2.getText().toString();
            dimen_4 = sentin_t3.getText().toString();
            nomGremio = sentin_t4.getText().toString();
            nomLider = sentin_t6.getText().toString();

            try {


                codigoGremio = comprobar;
                gremioAdmin admon = new gremioAdmin(this, "gremio", null, 1);
                SQLiteDatabase abrir = admon.getWritableDatabase();
                ContentValues value = new ContentValues();

            if(comprobar.equals("131301")){
                comprobar="100";

                registroAzul();

            } else{

                if(comprobar.equals("141401")) {
                    comprobar = "2000";
                }


            }

                value.put("codigo", comprobar);
                value.put("descripcion", nomGremio);
                value.put("precio", dimen_1);
                value.put("telefono", dimen_2);
                value.put("contraseña", dimen_3);
                value.put("fecha", dimen_4);
                value.put("Id", "4");


                abrir.insert("gremio", null, value);
                abrir.close();



                sentin_t1.setText("");
                sentin_t3.setText("");
                sentin_t2.setText("");
                sentin_t4.setText("");
                sentin_t5.setText("");
                sentin_t6.setText("");
                sentin_t1.setEnabled(false);sentin_t3.setEnabled(false);sentin_t5.setEnabled(false);
                sentin_t2.setEnabled(false);sentin_t4.setEnabled(false);sentin_t6.setEnabled(false);


                Toast.makeText(this, "REGISTRO EXITOSO SU CODIGO DE REGISTRO ES: " + comprobar, Toast.LENGTH_SHORT).show();
            }catch (Exception df){
                Toast.makeText(this, "Error base de datos" + codigoGremio, Toast.LENGTH_SHORT).show();
            }
            }

    }



}