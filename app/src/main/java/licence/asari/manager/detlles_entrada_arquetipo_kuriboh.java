package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Stack;


public class detlles_entrada_arquetipo_kuriboh {

    FirebaseFirestore bdNeutro;
    Stack<String> idV1 = new Stack<>();

    public detlles_entrada_arquetipo_kuriboh(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_entrada_arquitipo_kuriboh);

        contexto val = new contexto();

        ImageButton b1 =(ImageButton) dialog.findViewById(R.id.arquetipo_b1);//entrada_arque_politica
        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);//calabozo_b4
        ImageButton b2 = (ImageButton) dialog.findViewById(R.id.entrada_arque_politica);
        ImageButton b3 = (ImageButton) dialog.findViewById(R.id.arquetipo_b2);//arquetipo_b5
        EditText t1 =(EditText) dialog.findViewById(R.id.arquetipo_t1);
        EditText t2 =(EditText) dialog.findViewById(R.id.arquetipo_t2);
        ImageButton b4 = (ImageButton) dialog.findViewById(R.id.arquetipo_b4);
        ImageButton b5 = (ImageButton) dialog.findViewById(R.id.arquetipo_b5);//arquetipo_b5
        ImageButton b6 = (ImageButton) dialog.findViewById(R.id.arquetipo_b3);//arquetipo_b5
        Spinner sp1 =(Spinner) dialog.findViewById(R.id.arquetipo_sp1);//arquetipo_ba
        ImageButton b7 = (ImageButton) dialog.findViewById(R.id.arquetipo_ba);//arquetipo_b5
//entrada_arque_politica
        b4.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        sp1.setVisibility(View.GONE);

        bdNeutro = FirebaseFirestore.getInstance();
      //  Toast.makeText(context1.getApplicationContext(), "ADMIN:"+val.getKeyPermisoInicio(), Toast.LENGTH_SHORT).show();
        try {
            if( val.getKeyPermisoInicio().equals("TRUE")){
                b2.setVisibility(View.VISIBLE);
            }
        }catch (Exception dfg){}


        ArrayAdapter<String> datos = null;
        idV1.add("Elija la sala");
        idV1.add("5");
        idV1.add("4");
        idV1.add("6");
        idV1.add("7");
        idV1.add("8");
        idV1.add("9");
        idV1.add("10");
        idV1.add("11");
        idV1.add("12");




        datos = new ArrayAdapter<>(context1.getApplicationContext(), R.layout.spiner_jornada_random, idV1);
        sp1.setAdapter(datos);


/*
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1.getApplicationContext(), "BIENVENIDO A SU CUENTA", Toast.LENGTH_SHORT).show();

                Intent siguiente = new Intent(context1, UsuarioStandar.class);
                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeyCodigo());

                context1.startActivity(siguiente);

            }
        });
*/
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1.getApplicationContext(), "BIENVENIDO TABLA GENERAL RANKING", Toast.LENGTH_SHORT).show();

                Intent siguiente = new Intent(context1, calabozo_ranking.class);
                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());
                context1.startActivity(siguiente);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(t1.getText().toString().equals("")){
                    Toast.makeText(context1.getApplicationContext(), "Campos vacio del enlace", Toast.LENGTH_SHORT).show();
                }else {


                    HashMap<String, Object> dato = new HashMap<>();
                    dato.put("salaLvl2", t1.getText().toString());
                    bdNeutro.collection("BDcalabozo").document("Info").update(dato);
                    Toast.makeText(context1.getApplicationContext(), "Guardado con exito", Toast.LENGTH_SHORT).show();

                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(t2.getText().toString().equals("")){
                    Toast.makeText(context1.getApplicationContext(), "Campos vacio numero sala", Toast.LENGTH_SHORT).show();
                }else {


                    HashMap<String, Object> dato = new HashMap<>();
                    dato.put("numeroSalaArqK", t2.getText().toString());
                    bdNeutro.collection("BDcalabozo").document("Info").update(dato);
                    Toast.makeText(context1.getApplicationContext(), "Guardado con exito", Toast.LENGTH_SHORT).show();

                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(sp1.getSelectedItem().toString().equals("Elija la sala")){
                    Toast.makeText(context1.getApplicationContext(), "Debe elegir un numero de sala.", Toast.LENGTH_SHORT).show();
                }else{
                    val.setKeyDuelista(sp1.getSelectedItem().toString());

                    val.setKeyJ4(Integer.parseInt(val.getKeyDuelista()));


                    if(val.getKeyJ4() <= 12){
                        HashMap<String, Object> dato = new HashMap<>();
                        dato.put("salakeycalabozo", val.getKeyDuelista());
                        bdNeutro.collection("BDcalabozo").document("Info").update(dato);
                        Toast.makeText(context1.getApplicationContext(), "Guardado con exito", Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(context1.getApplicationContext(), "sala incorrecta", Toast.LENGTH_SHORT).show();
                    }}


            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {



           bdNeutro.collection("BDcalabozo").document("Info")
                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

 if (documentSnapshot.exists()) {

 val.setKeyRegistroActivo(documentSnapshot.getString("keyRegistroActivoKuribo"));
Toast.makeText(context1.getApplicationContext(), "ENTRADA: " + val.getKeyRegistroActivo(), Toast.LENGTH_SHORT).show();



if (val.getKeyRegistroActivo().equals("registro")) {
dialog.dismiss();
    Toast.makeText(context1.getApplicationContext(), "INICIANDO PRE-REGISTRO", Toast.LENGTH_SHORT).show();

Intent siguiente = new Intent(context1, pre_registro_arquetipo_kuribo.class);
                              siguiente.putExtra("nick", val.getKeyNick());
                               siguiente.putExtra("cdGremio", val.getKeyCodigo());
                              siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
context1.startActivity(siguiente);
}else{
if (val.getKeyRegistroActivo().equals("eliminatoria")) {
    bdNeutro.collection("BDcalabozo").document("Info")
            .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

            if (documentSnapshot.exists()) {


                val.setKeyEnlaceCalabozolvl6(documentSnapshot.getString("salaLvl2"));
                val.setKeySalaDuelo(documentSnapshot.getString("numeroSalaArqK"));
                val.setKeyCalabozoActivo(documentSnapshot.getString("salakeyArquetopoKuribo"));
                val.setKeyRutaDungeon1("tablaUpArqKuri"+val.getKeyCalabozoActivo());
                val.setKeyRutaDungeon2("UpArqKuri"+val.getKeyCalabozoActivo());
                val.setKeyTablaGeneral("tablaGeneralArqKuri");

                if(val.getKeyCalabozoActivo().equals("12")){
                    dialog.dismiss();
                    Intent siguiente = new Intent(context1,calabozo_v12.class);
                    siguiente.putExtra("nick", val.getKeyNick());
                    siguiente.putExtra("cdGremio", val.getKeyCodigo());
                    siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                    siguiente.putExtra("keySala", val.getKeySalaDuelo());
                    siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                    siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                    siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                    siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                    context1.startActivity(siguiente);
                }else{
                    if(val.getKeyCalabozoActivo().equals("11")){
                        dialog.dismiss();
                        Intent siguiente = new Intent(context1,calabozo_v11.class);
                        siguiente.putExtra("nick", val.getKeyNick());
                        siguiente.putExtra("cdGremio", val.getKeyCodigo());
                        siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                        siguiente.putExtra("keySala", val.getKeySalaDuelo());
                        siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                        siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                        siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                        siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                        context1.startActivity(siguiente);
                    }else{

                        val.setKeyJ6(Integer.parseInt(val.getKeyCalabozoActivo()));
                        if(val.getKeyJ6()==10){
                            dialog.dismiss();
                            Intent siguiente = new Intent(context1,calabozo_v10.class);
                            siguiente.putExtra("nick", val.getKeyNick());
                            siguiente.putExtra("cdGremio", val.getKeyCodigo());
                            siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                            siguiente.putExtra("keySala", val.getKeySalaDuelo());
                            siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                            siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                            siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                            siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                            context1.startActivity(siguiente);

                        }else{
                            if(val.getKeyCalabozoActivo().equals("9")){
                                dialog.dismiss();
                                Intent siguiente = new Intent(context1,calabozo_v9.class);
                                siguiente.putExtra("nick", val.getKeyNick());
                                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                context1.startActivity(siguiente);

                            }else{// val.setKeyPermisoInicio(documentSnapshot.getString("fx"));
                                if(val.getKeyCalabozoActivo().equals("8")){
                                    dialog.dismiss();
                                    Intent siguiente = new Intent(context1,calabozo_v8.class);
                                    siguiente.putExtra("nick", val.getKeyNick());
                                    siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                    siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                    siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                    siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                    siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                    siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                    siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                    context1.startActivity(siguiente);
                                }else{
                                    if(val.getKeyCalabozoActivo().equals("7")){
                                        dialog.dismiss();
                                        Intent siguiente = new Intent(context1,calabozo_v7.class);
                                        siguiente.putExtra("nick", val.getKeyNick());
                                        siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                        siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                        siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                        siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                        siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                        siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                        siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                        context1.startActivity(siguiente);
                                    }else{
                                        if(val.getKeyCalabozoActivo().equals("6")){
                                            dialog.dismiss();
                                            Intent siguiente = new Intent(context1,calabozo_v6.class);
                                            siguiente.putExtra("nick", val.getKeyNick());
                                            siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                            siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                            siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                            siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                            siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                            siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                            siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                            context1.startActivity(siguiente);
                                        }else{
                                            if(val.getKeyCalabozoActivo().equals("5")){
                                                dialog.dismiss();
                                                Intent siguiente = new Intent(context1,calabozo_v5.class);
                                                siguiente.putExtra("nick", val.getKeyNick());
                                                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                                siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                                siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                                siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                                siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                                siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                                siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                                context1.startActivity(siguiente);
                                            }else{
                                                if(val.getKeyCalabozoActivo().equals("4")){


                                                    dialog.dismiss();
                                                    Intent siguiente = new Intent(context1,calabozo_v4.class);
                                     //             Toast.makeText(context1.getApplicationContext(), "NUMEROSALA: " + val.getKeySalaDuelo(), Toast.LENGTH_SHORT).show();
                                                    siguiente.putExtra("nick", val.getKeyNick());
                                                    siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                                    siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                                    siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                                    siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                                    siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                                    siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                                    siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                                    context1.startActivity(siguiente);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }}



            }
        }});
}

}
}else{
Toast.makeText(context1.getApplicationContext(), "CREANDO CONTENIDO PRE-REGISTRO", Toast.LENGTH_SHORT).show();
} }});


 }



});


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
b1.setVisibility(View.GONE);

                b7.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                b4.setVisibility(View.VISIBLE);
                b5.setVisibility(View.VISIBLE);
                b6.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                sp1.setVisibility(View.VISIBLE);



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




}



