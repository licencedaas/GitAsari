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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Stack;


public class detlles_entrada_calabozo {

    FirebaseFirestore bdNeutro;
    private VideoView v1;
    ImageView enrada;
    Stack<String> idV1 = new Stack<>();

    public detlles_entrada_calabozo(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_entrada_calabozo);

        contexto val = new contexto();

     //   v1 = (VideoView)  dialog.findViewById(R.id.intro_calabozov6);



        ImageButton b1 =(ImageButton) dialog.findViewById(R.id.entrada_calabozo_b1);
        ImageButton b2 =(ImageButton) dialog.findViewById(R.id.entrada_calabozo_b2);
        ImageButton b3 =(ImageButton) dialog.findViewById(R.id.calabozo_b3);
        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);//calabozo_b4
        ImageButton b4 =(ImageButton) dialog.findViewById(R.id.calabozo_b4);
        ImageButton b5 =(ImageButton) dialog.findViewById(R.id.calabozo_b5);
        ImageButton b6 =(ImageButton) dialog.findViewById(R.id.calabozo_b6);
        ImageButton b7 =(ImageButton) dialog.findViewById(R.id.calabozo_b7);
        ImageButton b8 =(ImageButton) dialog.findViewById(R.id.entrada_lose);//creditos_lose
        ImageButton b9 =(ImageButton) dialog.findViewById(R.id.creditos_lose);//
        ImageButton b10 =(ImageButton) dialog.findViewById(R.id.id_duelo);//
        ImageButton b11 =(ImageButton) dialog.findViewById(R.id.entrada_underword);

        EditText t1 =(EditText) dialog.findViewById(R.id.calabozo_t1);
        EditText t2 =(EditText) dialog.findViewById(R.id.calabozo_t2);
        Spinner sp1 =(Spinner) dialog.findViewById(R.id.calabozo_sp1);

        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        sp1.setVisibility(View.GONE);



        enrada =(ImageView) dialog.findViewById(R.id.entrada_dungeon);
        bdNeutro = FirebaseFirestore.getInstance();


        try {
            if( val.getKeyPermisoInicio().equals("TRUE")){
                b4.setVisibility(View.VISIBLE);
            }
        }catch (Exception dfg){}


        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context1.getApplicationContext(), "TORNEO UNDERWORD ESTA EN DESARROLLO.", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
                Intent siguiente = new Intent(context1,calabozo_v4.class);
                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                context1.startActivity(siguiente);


            }
        });
        

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                b4.setVisibility(View.GONE);
                b3.setVisibility(View.GONE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                sp1.setVisibility(View.VISIBLE);
                b5.setVisibility(View.VISIBLE);
                b6.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);

ArrayAdapter<String> datos = null;
                            idV1.add("Elija la sala");
                            idV1.add("6");
                            idV1.add("5");
                            idV1.add("4");
                            idV1.add("9");
                            idV1.add("10");
                            idV1.add("11");
                            idV1.add("12");
                            idV1.add("7");
                            idV1.add("8");
datos = new ArrayAdapter<>(context1.getApplicationContext(), R.layout.spiner_jornada_random, idV1);
 sp1.setAdapter(datos);

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
val.setKeyRegistroActivo(documentSnapshot.getString("keyRegistroActivo"));
if(val.getKeyRegistroActivo().equals("registro")){
                        dialog.dismiss();
                        Intent siguiente = new Intent(context1,tabla_registro_dungeo_v6.class);
                        siguiente.putExtra("nick", val.getKeyNick());
                        siguiente.putExtra("cdGremio", val.getKeyCodigo());
                        siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                        context1.startActivity(siguiente);
}else{
if(val.getKeyRegistroActivo().equals("eliminatoria")){

bdNeutro.collection("BDcalabozo").document("Info")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
    val.setKeyCalabozoActivo(documentSnapshot.getString("salakeycalabozo"));
val.setKeyEnlaceCalabozolvl6(documentSnapshot.getString("salaLvl1"));
val.setKeySalaDuelo(documentSnapshot.getString("numeroSalaLvl6"));
val.setKeyRutaDungeon1("tablaUp"+val.getKeyCalabozoActivo());
val.setKeyRutaDungeon2("calabozoUp"+val.getKeyCalabozoActivo());
val.setKeyTablaGeneral("tablaGeneral");

if(val.getKeyCalabozoActivo().equals("12")){
                                             Intent siguiente = new Intent(context1,calabozo_v12.class);
                                             siguiente.putExtra("nick", val.getKeyNick());
                                             siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                             siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                             siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                             siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                             siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                             siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                             siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                             dialog.dismiss();
                                             //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
                                             context1.startActivity(siguiente);

                                         }else{
                                        if(val.getKeyCalabozoActivo().equals("11")){
                                            Intent siguiente = new Intent(context1,calabozo_v11.class);
                                            siguiente.putExtra("nick", val.getKeyNick());
                                            siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                            siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                            siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                            siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                            siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                            siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                            siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                            dialog.dismiss();
                                            //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
                                            context1.startActivity(siguiente);

                                        }else{

                                           val.setKeyJ6(Integer.parseInt(val.getKeyCalabozoActivo()));


                                            if(val.getKeyJ6()==10){
                                                Intent siguiente = new Intent(context1,calabozo_v10.class);
                                               siguiente.putExtra("nick", val.getKeyNick());
                                               siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                               siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                              siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                                siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                                siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                               siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                               siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                              dialog.dismiss();
                                                //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
                                              context1.startActivity(siguiente);

                                            }else{
                                                if(val.getKeyCalabozoActivo().equals("9")){

                                                    Intent siguiente = new Intent(context1,calabozo_v9.class);
                                                   siguiente.putExtra("nick", val.getKeyNick());
                                                   siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                                   siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                                    siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                                    siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                                    siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                                  siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                                    siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                                    dialog.dismiss();
                                          //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
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

                        }
                    }});



            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context1.getApplicationContext(), "EL CRECIMIENTO ES IMPORTANTE EN TODOS LOS PROYECTOS", Toast.LENGTH_SHORT).show();
                Toast.makeText(context1.getApplicationContext(), "POR ESO DOY MERITOS AL DUELISTA QUE DIO UNA IDEA BASADA EN LA TEMATICA YA CREADA", Toast.LENGTH_SHORT).show();
                Toast.makeText(context1.getApplicationContext(), "DEL APP ASARI MANAGER PARA HACER LOS TORNEOS MAS ENERGICOS", Toast.LENGTH_SHORT).show();
                Toast.makeText(context1.getApplicationContext(), "PRESENTA:", Toast.LENGTH_SHORT).show();
                Toast.makeText(context1.getApplicationContext(), "* ELGRINCHO09  DAVID R LEZCANO", Toast.LENGTH_SHORT).show();
                Toast.makeText(context1.getApplicationContext(), "* HIZOKA - Hizoka", Toast.LENGTH_SHORT).show();
                Toast.makeText(context1.getApplicationContext(), "DUELISTA DE LA COMUNIDA ELITE ASARI", Toast.LENGTH_SHORT).show();

            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context1.getApplicationContext(), "ASARI MANAGER TE INVITA A PARTICIPAR THE WARRIOR OF ASARI", Toast.LENGTH_SHORT).show();
                Intent siguiente = new Intent(context1,id_duelo.class);
                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                dialog.dismiss();
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
  dato.put("salaLvl1", t1.getText().toString());
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
                    dato.put("numeroSalaLvl6", t2.getText().toString());
                    bdNeutro.collection("BDcalabozo").document("Info").update(dato);
                    Toast.makeText(context1.getApplicationContext(), "Guardado con exito", Toast.LENGTH_SHORT).show();

                }

}
});

        b7.setOnClickListener(new View.OnClickListener() {
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
                }
                }


            }
        });


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

       b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(context1,calabozo_ranking.class);
                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());
                context1.startActivity(siguiente);

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

bdNeutro.collection("BDcalabozo").document("Info")
.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
    val.setKeyEntradaLose(documentSnapshot.getString("keyRegistroActivoLose"));
    val.setKeyRegistroActivo(documentSnapshot.getString("keyRegistroActivo"));
    val.setKeyCalabozoActivo(documentSnapshot.getString("salakeycalabozo"));
    try {
        val.setKeyExclucion(documentSnapshot.getString("keyAleatorioSalaLose"));
    }catch (Exception  dfsf){
        val.setKeyExclucion("noactivo");
    }
    if(val.getKeyRegistroActivo().equals("registro")){
        Toast.makeText(context1.getApplicationContext(), "Cuando inicie el torneo se habilitara la entrada LOSE", Toast.LENGTH_SHORT).show();

    }else{
        if(val.getKeyRegistroActivo().equals("eliminatoria")){

            if(val.getKeyEntradaLose().equals("nolose")){


            Toast.makeText(context1.getApplicationContext(), "BIENVENIDO ALAS ELIMINATORIAS LOSE", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            Intent siguiente = new Intent(context1,pre_asistencia_lose.class);

             siguiente.putExtra("numeroSala", val.getKeyCalabozoActivo());
              siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
            context1.startActivity(siguiente);

            }else{
            if(val.getKeyEntradaLose().equals("youlose")){

                if(val.getKeyExclucion().equals("activo")) {

                    val.setKeyEnlaceCalabozolvl6(documentSnapshot.getString("salaLvl1"));
                    val.setKeySalaDuelo(documentSnapshot.getString("numeroSalaLvl6"));

                    val.setKeyRutaDungeon1("tablaUp0"+"lose");
                    val.setKeyRutaDungeon2("calabozoUp0"+"lose");
                    val.setKeyTablaGeneral("tablaGeneral");


                    Intent siguiente = new Intent(context1,sala_elimintarias_aleatorias.class);
                    siguiente.putExtra("nick", val.getKeyNick());
                    siguiente.putExtra("cdGremio", val.getKeyCodigo());
                    siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                    siguiente.putExtra("keySala", val.getKeySalaDuelo());
                    siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                    siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                    siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                    dialog.dismiss();

                    context1.startActivity(siguiente);
                }else{

                val.setKeyJ1(Integer.parseInt(val.getKeyCalabozoActivo()));
                val.setKeyJ1(val.getKeyJ1()-2);
                val.setKeyCalabozoActivo(String.valueOf(val.getKeyJ1()));
                bdNeutro.collection("BDcalabozo").document("Info")
                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {



                            val.setKeyEnlaceCalabozolvl6(documentSnapshot.getString("salaLvl1"));
                            val.setKeySalaDuelo(documentSnapshot.getString("numeroSalaLvl6"));

                            val.setKeyRutaDungeon1("tablaUp" + val.getKeyCalabozoActivo()+"lose");
                            val.setKeyRutaDungeon2("calabozoUp" + val.getKeyCalabozoActivo()+"lose");
                            val.setKeyTablaGeneral("tablaGeneral");

///
                            if(val.getKeyCalabozoActivo().equals("12")){
                                Intent siguiente = new Intent(context1,calabozo_v12.class);
                                siguiente.putExtra("nick", val.getKeyNick());
                                siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                dialog.dismiss();
                                //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
                                context1.startActivity(siguiente);

                            }else{
                                if(val.getKeyCalabozoActivo().equals("11")){

                                    Intent siguiente = new Intent(context1,calabozo_v11.class);
                                    siguiente.putExtra("nick", val.getKeyNick());
                                    siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                    siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                    siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                    siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                    siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                    siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                    siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                    dialog.dismiss();
                                    //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
                                    context1.startActivity(siguiente);

                                }else{

                                    val.setKeyJ6(Integer.parseInt(val.getKeyCalabozoActivo()));


                                    if(val.getKeyJ6()==10){
                                        Intent siguiente = new Intent(context1,calabozo_v10.class);
                                        siguiente.putExtra("nick", val.getKeyNick());
                                        siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                        siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                        siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                        siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                        siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                        siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                        siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                        dialog.dismiss();
                                        //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
                                        context1.startActivity(siguiente);

                                    }else{
                                        if(val.getKeyCalabozoActivo().equals("9")){

                                            Intent siguiente = new Intent(context1,calabozo_v9.class);
                                            siguiente.putExtra("nick", val.getKeyNick());
                                            siguiente.putExtra("cdGremio", val.getKeyCodigo());
                                            siguiente.putExtra("keyAdmin", val.getKeyPermisoInicio());
                                            siguiente.putExtra("keySala", val.getKeySalaDuelo());
                                            siguiente.putExtra("keyTabla", val.getKeyRutaDungeon1());
                                            siguiente.putExtra("keyCalabozo", val.getKeyRutaDungeon2());//val.getKeyTorneoActivo()
                                            siguiente.putExtra("keyTorneo", val.getKeyTorneoActivo());//
                                            siguiente.putExtra("keyEnlace", val.getKeyEnlaceCalabozolvl6());
                                            dialog.dismiss();
                                            //          Toast.makeText(context1.getApplicationContext(), "UR:"+val.getKeyRutaDungeon2(), Toast.LENGTH_SHORT).show();
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

/////
}
}
});
}
            }else{

                Toast.makeText(context1.getApplicationContext(), "No se encuentra activa espere...", Toast.LENGTH_SHORT).show();
            }}
        }
    }
}
}
});




            }
        });


        dialog.show();

    }
    Context contexto;

    public void llamadoRandom(){


    }



}



