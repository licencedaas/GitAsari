package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Stack;

public class detlles_gener_apostar {

    FirebaseFirestore bdNeutro;
    Stack<String> idV1 = new Stack<>();

    public detlles_gener_apostar(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_apostar);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.apuesta_b1);
        Spinner sp1 =(Spinner)dialog.findViewById(R.id.apuesta_sp1) ;

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();




bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()){


val.setKeyEstrellas(documentSnapshot.getString("estrellas"));
val.setKeyJ1(Integer.parseInt(val.getKeyEstrellas()));
    ArrayAdapter<String> datos = null;
    idV1.add("Estrellas de apusta");

if(val.getKeyJ1()==2){

    idV1.add("1");
    idV1.add("2");
}
    if(val.getKeyJ1()==3){
        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
    }
    if(val.getKeyJ1()==4){

        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
            }
    if(val.getKeyJ1()==5){
        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
        idV1.add("5");
    }
    if(val.getKeyJ1()==6){
        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
        idV1.add("5");
        idV1.add("6");
    }
    if(val.getKeyJ1()==7){
        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
        idV1.add("5");
        idV1.add("6");
        idV1.add("7");
    }
    if(val.getKeyJ1()==8){
        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
        idV1.add("5");
        idV1.add("6");
        idV1.add("7");
        idV1.add("8");

    }
    if(val.getKeyJ1()==9){
        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
        idV1.add("5");
        idV1.add("6");
        idV1.add("7");
        idV1.add("8");
        idV1.add("9");
    }
    if(val.getKeyJ1()==10){

        idV1.add("1");
        idV1.add("2");
        idV1.add("3");
        idV1.add("4");
        idV1.add("5");
        idV1.add("6");
        idV1.add("7");
        idV1.add("8");
        idV1.add("9");
        idV1.add("10");
    }
    if(val.getKeyJ1()==1){

        idV1.add("1");

    }
    datos = new ArrayAdapter<>(context1.getApplicationContext(), R.layout.spiner_jornada_random, idV1);
    sp1.setAdapter(datos);

}

}
});


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val.setKeyVerdad(sp1.getSelectedItem().toString());

                if(!val.getKeyVerdad().contains("Estrellas de apusta")) {
                HashMap<String,Object> dato = new HashMap<>();HashMap<String,Object> dato1 = new HashMap<>();


                dato.put("keyApuesta"+val.getKeyDuelista2(),val.getKeyVerdad());
                dato.put("keyOcupado","si");dato1.put("keyOcupado","si");
                    dato1.put("nickApuesta",val.getKeyNick());
                    dato.put("nickApuesta",val.getKeyDuelista2());

                val.setKeyFich1(val.getKeyVerdad());
               bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).update(dato);
                    bdNeutro.collection("BDreino").document(val.getKeyCodigo2()).update(dato1);
                    Toast.makeText(context1.getApplicationContext(), "Esta listo ...  ahora genere o reporte ... duelista", Toast.LENGTH_SHORT).show();
            }}
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }







}
