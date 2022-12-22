package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class detlles_default {

    FirebaseFirestore bdNeutro;
    Stack<String> idV1 = new Stack<>();
    int contador=1;

    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    LinkedHashMap<String, String> equipo = new LinkedHashMap<String,String>();
    LinkedHashMap<String, String> rival = new LinkedHashMap<String,String>();

    public detlles_default(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_default);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reporte_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.reportes_b1);
        RadioGroup rg1 =(RadioGroup) dialog.findViewById(R.id.reporte_rg2);
        RadioGroup rg2 =(RadioGroup) dialog.findViewById(R.id.reporte_rg3);
        EditText t1= (EditText) dialog.findViewById(R.id.reporte_1);

        rg1.setVisibility(View.GONE); rg2.setVisibility(View.GONE);

        Spinner sp1 = (Spinner) dialog.findViewById(R.id.reporte_sp1);
        RadioButton r1 =(RadioButton) dialog.findViewById(R.id.reporte_r1);
        RadioButton r2 =(RadioButton) dialog.findViewById(R.id.reporte_r2);
        RadioButton r3 =(RadioButton) dialog.findViewById(R.id.reporte_r3);
        RadioButton r4 =(RadioButton) dialog.findViewById(R.id.reporte_r4);
        RadioButton r5 =(RadioButton) dialog.findViewById(R.id.reporte_r5);

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        try {
            bdNeutro.collection("BDAsary").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {
                        ArrayAdapter<String> datos = null;
                        idV1.add("Elija la cuenta");
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            val.setKeyDuelista(document.getString("nick"));

                            idV1.add(val.getKeyDuelista());
                        }

                        datos = new ArrayAdapter<>(context1.getApplicationContext(), R.layout.spiner_jornada_random, idV1);
                        sp1.setAdapter(datos);
                    }
                }
            });
        } catch (Exception sdfs) {

        }




 r2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
 if (sp1.getSelectedItem().toString().equals("Elija la cuenta")) {Toast.makeText(context1.getApplicationContext(), "DEBE ELEGIR SU CUENTA NICK", Toast.LENGTH_SHORT).show();} else {

if (r2.isChecked()) {
    Toast.makeText(context1.getApplicationContext(), "Porfavor Seleccione su resultado de duelo ..... gracias.", Toast.LENGTH_SHORT).show();

    val.setKeyEleccionTorneoReport("underword");
    val.setKeyNick(sp1.getSelectedItem().toString());
    rg1.setVisibility(View.VISIBLE);

}
}
});

r4.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
if (sp1.getSelectedItem().toString().equals("Elija la cuenta")) {Toast.makeText(context1.getApplicationContext(), "DEBE ELEGIR SU CUENTA NICK", Toast.LENGTH_SHORT).show();} else {
if (r4.isChecked()) {
if(val.getKeyEleccionTorneoReport().equals("underword")){
val.setKeyVerificationReport_1("0");
    rg1.setVisibility(View.GONE);
    rg2.setVisibility(View.VISIBLE);

    Toast.makeText(context1.getApplicationContext(), "FINALIZE OPRIMIENDO EL BOTON LOSE", Toast.LENGTH_SHORT).show();
}
}
}
});


        r5.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {
            if (sp1.getSelectedItem().toString().equals("Elija la cuenta")) {Toast.makeText(context1.getApplicationContext(), "DEBE ELEGIR SU CUENTA NICK", Toast.LENGTH_SHORT).show();} else {

                if (r5.isChecked()) {

                    if(val.getKeyEleccionTorneoReport().equals("underword")){

                        val.setKeyVerificationReport_1("1");
                        rg1.setVisibility(View.GONE);
                        rg2.setVisibility(View.VISIBLE);
                        Toast.makeText(context1.getApplicationContext(), "FINALIZE OPRIMIENDO EL BOTON LOSE", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



 b1.setOnClickListener(new View.OnClickListener() {
 @Override
  public void onClick(View v) {
if (sp1.getSelectedItem().toString().equals("Elija la cuenta")) {Toast.makeText(context1.getApplicationContext(), "DEBE ELEGIR SU CUENTA NICK", Toast.LENGTH_SHORT).show();} else {

if(val.getKeyVerificationReport_1().equals("na")){
    Toast.makeText(context1.getApplicationContext(), "SE DEBE SELECCIONAR RESULTADO DEL DUELO.", Toast.LENGTH_SHORT).show();
}else{

    if(t1.getText().toString().equals("")){
        Toast.makeText(context1.getApplicationContext(), "SE DEBE DIGITAR EL CODIGO DE PERMISO", Toast.LENGTH_SHORT).show();
    }else{
        val.setKeyResultReport(val.getKeyVerificationReport_1());
        val.setKeyCodeReport(t1.getText().toString());

         val.setKeyVerificReport("Nocorrecto");
        bdNeutro.collection("BDnegroinfo").document("ReporteCode")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {


for(int a=1; a < 10; a++){


val.setKeyCodigo(documentSnapshot.getString("codeN"+a));
 if(val.getKeyCodigo().equals(val.getKeyCodeReport())){


     HashMap<String, Object> dato = new HashMap<>();
     dato.put("codeN"+a, "0");
     HashMap<String, Object> dato1 = new HashMap<>();
     dato1.put(equipo.get(val.getKeyNick()),val.getKeyResultReport());
     dato1.put("detallaes_"+day+"_"+month+"_"+val.getKeyNick(),val.getKeyResultReport()+":"+equipo.get(val.getKeyNick()));

     val.setKeyEleccionTorneoReport("torneo"); r1.setChecked(false);
     r2.setChecked(false);
     r3.setChecked(false);
     r4.setChecked(false);
     r5.setChecked(false);

Toast.makeText(context1.getApplicationContext(), "REPORTE ENVIADO CON EXISTO", Toast.LENGTH_SHORT).show();
val.setKeyVerificReport("correcto");
bdNeutro.collection("BDnegroinfo").document("ReporteCode").update(dato);
bdNeutro.collection("BDcalabozo").document("ReporteUnderwordnegro").update(dato1);
     val.setKeyVerificationReport_1("na");
break;
}

}
if(val.getKeyVerificReport().equals("correcto")){

}else{
    r1.setChecked(false);
    r2.setChecked(false);
    r3.setChecked(false);
    r4.setChecked(false);
    r5.setChecked(false);

    Toast.makeText(context1.getApplicationContext(), "CODIGO INGRESADO NO ES CORRECTO ", Toast.LENGTH_SHORT).show();
    Toast.makeText(context1.getApplicationContext(), "NO FUE POSIBLE ENVIAR SU REPORTE ", Toast.LENGTH_SHORT).show();
    Toast.makeText(context1.getApplicationContext(), "VERFIQUE EL CODIGO Y VUELVA A ENVIARLO", Toast.LENGTH_SHORT).show();
}



                }}
            });

    }


}


 }

            }
        });

 sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
 @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

val.setKeyNick(sp1.getSelectedItem().toString());
if (val.getKeyNick().equals("Elija la cuenta")) {
}else{
    r1.setChecked(false);
    r2.setChecked(false);
    r3.setChecked(false);
    val.setKeyVerificationReport_1("na");
    bousquedaEquipos();// organiza y almacena cada duelista con el nombre de su equipo
}
}

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }

    public void bousquedaEquipos(){
        contexto val = new contexto();
 bdNeutro.collection("BDcalabozo").document("InfoUnderCreate")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

 @Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
    val.setKeyconteoUnder(documentSnapshot.getString("kekEquipo"));
    val.setKeyJ1(Integer.parseInt(val.getKeyconteoUnder()));



for (int a = 1; a < val.getKeyJ1(); a++) {


// ejemplo de seleccion de equipos ****************************//
    val.setKeyEquipoUnder_1(documentSnapshot.getString("fase"+a+":"+a+"_1"));// vs equipo3
    val.setKeyEquipoUnder_1(documentSnapshot.getString("fase"+a+":"+a+"_2"));

    equipo.put(val.getKeyEquipoUnder_2(),val.getKeyEquipoUnder_1());
//**************************************************//



    val.setKeyEquipoUnder_1(documentSnapshot.getString("equipo"+a+"Titulo1"));
    val.setKeyEquipoUnder_2(documentSnapshot.getString("equipo"+a+"Participante1"));
    equipo.put(val.getKeyEquipoUnder_2(),val.getKeyEquipoUnder_1());

    val.setKeyEquipoUnder_2(documentSnapshot.getString("equipo"+a+"Participante2"));
    equipo.put(val.getKeyEquipoUnder_2(),val.getKeyEquipoUnder_1());


}

}
}


});

    }



}
