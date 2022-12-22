package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class confi2 extends AppCompatActivity {

    FirebaseFirestore bdNeutral;
    RadioButton r1,r2;
    ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confi2);


        r1 =(RadioButton) findViewById(R.id.r1_cofig1);
        r2 =(RadioButton) findViewById(R.id.r2_cofig);
        b1 =(ImageButton) findViewById(R.id.config_delet);

        bdNeutral = FirebaseFirestore.getInstance();
contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));
        val.setSearKeyCodigo(Integer.parseInt(val.getKeySiguienteN1()));

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






        bdNeutral.collection("BDcalabozo").document("Info")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

val.setKeyTorneo1(documentSnapshot.getString("nameTorneo1"));
                    val.setKeyTorneo2(documentSnapshot.getString("nameTorneo2"));
r1.setText(val.getKeyTorneo1());
                    r2.setText(val.getKeyTorneo2());
                }
            }});


        r1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

            if (r1.isChecked()) {
              //  val.setKeyDimencion(r1.getText().toString());

                HashMap<String, Object> dato = new HashMap<>();
                dato.put("torneoActivo"+val.getKeyIdGremio(),r1.getText().toString());
                dato.put("KeyprivateCd"+val.getKeyIdGremio(),val.getKeyIdGremio());
                bdNeutral.collection("BDcalabozo").document("Info").update(dato);
                Toast.makeText(getApplicationContext(), "PROCESO EXITOSO EVENTO CREADO", Toast.LENGTH_SHORT).show();
            }
        });

        r2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

            if (r2.isChecked()) {
                //  val.setKeyDimencion(r1.getText().toString());

                HashMap<String, Object> dato = new HashMap<>();
                dato.put("torneoActivo"+val.getKeyIdGremio(),r2.getText().toString());
                dato.put("KeyprivateCd"+val.getKeyIdGremio(),val.getKeyIdGremio());
                bdNeutral.collection("BDcalabozo").document("Info").update(dato);
                Toast.makeText(getApplicationContext(), "PROCESO EXITOSO EVENTO CREADO", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public void deletcalabozo(View sdfs){
        contexto val = new contexto();

         HashMap<String, Object> dato = new HashMap<>();
        dato.put("torneoActivo"+val.getKeyIdGremio(),"");
        dato.put("KeyprivateCd"+val.getKeyIdGremio(),"0");
        bdNeutral.collection("BDcalabozo").document("Info").update(dato);
        Toast.makeText(getApplicationContext(), "PROCESO EXITOSO funcon delet", Toast.LENGTH_SHORT).show();
        r1.isClickable();
        r2.isClickable();
    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();



        Intent siguiente = new Intent(this, UsuarioGb.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }
}