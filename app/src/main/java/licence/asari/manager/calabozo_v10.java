package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class calabozo_v10 extends AppCompatActivity {
    FirebaseFirestore bdNeutral, bdAzul,gremio;
    Button b1;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
    ImageButton b2;
    ImageView fondo1,fondo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calabozo_v10);



        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyPermisoInicio(getIntent().getStringExtra("keyAdmin"));
        val.setKeySalaDuelo(getIntent().getStringExtra("keySala"));
        val.setKeyRutaDungeon1(getIntent().getStringExtra("keyTabla"));
        val.setKeyRutaDungeon2(getIntent().getStringExtra("keyCalabozo"));
        val.setKeyTorneoActivo(getIntent().getStringExtra("keyTorneo"));
        val.setKeyEnlaceCalabozolvl6(getIntent().getStringExtra("keyEnlace"));




        l1 = (TextView) findViewById(R.id.v10_l1);
        l2 = (TextView) findViewById(R.id.v10_l2);
        l3 = (TextView) findViewById(R.id.v10_l3);
        l4 = (TextView) findViewById(R.id.v10_l4);
        l5 = (TextView) findViewById(R.id.v10_l5);
        l6 = (TextView) findViewById(R.id.v10_l6);
        l7 = (TextView) findViewById(R.id.v10_l8);
        l8 = (TextView) findViewById(R.id.v10_l9);
        l17 = (TextView) findViewById(R.id.v10_l10);


        l9 = (TextView) findViewById(R.id.v10_l11);


        l10 = (TextView) findViewById(R.id.v10_l12);
        l11 = (TextView) findViewById(R.id.v10_l13);
        l12 = (TextView) findViewById(R.id.v10_l14);
        l13 = (TextView) findViewById(R.id.v10_l15);
        l14 = (TextView) findViewById(R.id.v10_l16);
        l15 = (TextView) findViewById(R.id.v10_l17);
        l16 = (TextView) findViewById(R.id.v10_l18);
        l18 = (TextView) findViewById(R.id.v10_l19);
        l19 = (TextView) findViewById(R.id.v10_l20);
        l20 = (TextView) findViewById(R.id.v10_l21);

        fondo1 =(ImageView) findViewById(R.id.ondo_dungeoxyzv10);//fondo_arquetipo_kuri
        fondo1.setVisibility(View.GONE);

        fondo2 =(ImageView) findViewById(R.id.fondo_arquetipo_kuriv10);//fondo_arquetipo_kuri
        fondo2.setVisibility(View.GONE);
        try { if (val.getKeyTorneoActivo().equals("arquetipokurivo")) { fondo2.setVisibility(View.VISIBLE);}else{fondo1.setVisibility(View.VISIBLE);}
        }catch (Exception dfs){}


        b2 = (ImageButton) findViewById(R.id.politicas_v10);
        b2.setVisibility(View.GONE);
        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b2.setVisibility(View.VISIBLE); val.setKeyCalabozoActivo("10");} }catch (Exception dfs){}
        b1 = (Button) findViewById(R.id.calabozo_v10_b1);
        b1.setText(val.getKeySalaDuelo());
        bdNeutral = FirebaseFirestore.getInstance();
     relogueolvl6();
    }


    public void detallesDerrota(View sdfsfd) {
        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    val.setKeydueloFinal("desactivado");
                    val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                    val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                    val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                    val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                    val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                    val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                    val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));
                    val.setKeyCalabozolvl8(documentSnapshot.getString("puestoN8"));
                    val.setKeyCalabozolvl9(documentSnapshot.getString("puestoN9"));
                    val.setKeyCalabozolvl10(documentSnapshot.getString("puestoN10"));

                    val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                    val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                    val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                    val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                    val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                    val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
                    val.setKeyEstado7(documentSnapshot.getString("puestoN7"));
                    val.setKeyEstado8(documentSnapshot.getString("puestoN8"));
                    val.setKeyEstado9(documentSnapshot.getString("puestoN9"));
                    val.setKeyEstado10(documentSnapshot.getString("puestoN10"));



if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
                                    //finalista  2
    if (val.getKeyEstado6().equals("derrota")) {
        if (val.getKeyEstado7().equals("derrota")) {
            if (val.getKeyEstado8().equals("derrota")) {
                if (val.getKeyEstado9().equals("derrota")) {
                    //finalista  10
                    val.setKeydueloFinal("activado");
                    if (val.getKeyEstado2().equals(val.getKeyNick())) {
                        val.setKeyDuelista2(val.getKeyEstado10());
                    } else {
                        if (val.getKeyEstado10().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado2());
                        } } } } else {
                if (val.getKeyEstado9().equals("derrota")) {
                    if (val.getKeyEstado10().equals("derrota")) {
                        //finalista  8
                        val.setKeydueloFinal("activado");
                        if (val.getKeyEstado2().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado8());
                        } else { if (val.getKeyEstado8().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado2());
                        } } } } } } else {
            if (val.getKeyEstado8().equals("derrota")) { if (val.getKeyEstado9().equals("derrota")) { if (val.getKeyEstado10().equals("derrota")) {
                //finalista  7
                val.setKeydueloFinal("activado");
                if (val.getKeyEstado2().equals(val.getKeyNick())) {
                    val.setKeyDuelista2(val.getKeyEstado7());
                } else { if (val.getKeyEstado7().equals(val.getKeyNick())) {
                    val.setKeyDuelista2(val.getKeyEstado2());
                } } } } } } }


}
 } else {
 if (val.getKeyEstado5().equals("derrota")) {
 if (val.getKeyEstado2().equals("derrota")) {
                                        //finalista  4
if (val.getKeyEstado6().equals("derrota")) {
if (val.getKeyEstado7().equals("derrota")) {
if (val.getKeyEstado8().equals("derrota")) {
if (val.getKeyEstado9().equals("derrota")) {
                     //finalista  10
val.setKeydueloFinal("activado");
if (val.getKeyEstado4().equals(val.getKeyNick())) {
val.setKeyDuelista2(val.getKeyEstado10());
} else {
 if (val.getKeyEstado10().equals(val.getKeyNick())) {
val.setKeyDuelista2(val.getKeyEstado4());
} } } } else {
if (val.getKeyEstado9().equals("derrota")) {
if (val.getKeyEstado10().equals("derrota")) {
                         //finalista  8
val.setKeydueloFinal("activado");
if (val.getKeyEstado4().equals(val.getKeyNick())) {
val.setKeyDuelista2(val.getKeyEstado8());
} else { if (val.getKeyEstado8().equals(val.getKeyNick())) {
val.setKeyDuelista2(val.getKeyEstado4());
} } } } } } else {
if (val.getKeyEstado8().equals("derrota")) { if (val.getKeyEstado9().equals("derrota")) { if (val.getKeyEstado10().equals("derrota")) {
                         //finalista  7
val.setKeydueloFinal("activado");
if (val.getKeyEstado4().equals(val.getKeyNick())) {
val.setKeyDuelista2(val.getKeyEstado7());
} else { if (val.getKeyEstado7().equals(val.getKeyNick())) {
val.setKeyDuelista2(val.getKeyEstado4());
} } } } } } }

 }
}
}
} else {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {
                                        //finalista  3
    if (val.getKeyEstado6().equals("derrota")) {
        if (val.getKeyEstado7().equals("derrota")) {
            if (val.getKeyEstado8().equals("derrota")) {
                if (val.getKeyEstado9().equals("derrota")) {
                    //finalista  10
                    val.setKeydueloFinal("activado");
                    if (val.getKeyEstado3().equals(val.getKeyNick())) {
                        val.setKeyDuelista2(val.getKeyEstado10());
                    } else {
                        if (val.getKeyEstado10().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado3());
                        } } } } else {
                if (val.getKeyEstado9().equals("derrota")) {
                    if (val.getKeyEstado10().equals("derrota")) {
                        //finalista  8
                        val.setKeydueloFinal("activado");
                        if (val.getKeyEstado3().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado8());
                        } else { if (val.getKeyEstado8().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado3());
                        } } } } } } else {
            if (val.getKeyEstado8().equals("derrota")) { if (val.getKeyEstado9().equals("derrota")) { if (val.getKeyEstado10().equals("derrota")) {
                //finalista  7
                val.setKeydueloFinal("activado");
                if (val.getKeyEstado3().equals(val.getKeyNick())) {
                    val.setKeyDuelista2(val.getKeyEstado7());
                } else { if (val.getKeyEstado7().equals(val.getKeyNick())) {
                    val.setKeyDuelista2(val.getKeyEstado3());
                } } } } } } }
}
}
}
}
}else{
if (val.getKeyEstado2().equals("derrota")) {
if (val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
    //finalista 1
if (val.getKeyEstado6().equals("derrota")) {
if (val.getKeyEstado7().equals("derrota")) {
 if (val.getKeyEstado8().equals("derrota")) {
if (val.getKeyEstado9().equals("derrota")) {
                    //finalista  10
 val.setKeydueloFinal("activado");
 if (val.getKeyEstado1().equals(val.getKeyNick())) {
                        val.setKeyDuelista2(val.getKeyEstado10());
                    } else {
                        if (val.getKeyEstado10().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado1());
                        } } } } else {
                if (val.getKeyEstado9().equals("derrota")) {
                    if (val.getKeyEstado10().equals("derrota")) {
                        //finalista  8
                        val.setKeydueloFinal("activado");
                        if (val.getKeyEstado1().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado8());
                        } else { if (val.getKeyEstado8().equals(val.getKeyNick())) {
                            val.setKeyDuelista2(val.getKeyEstado1());
                        } } } } } } else {
            if (val.getKeyEstado8().equals("derrota")) { if (val.getKeyEstado9().equals("derrota")) { if (val.getKeyEstado10().equals("derrota")) {
                //finalista  7
                val.setKeydueloFinal("activado");
                if (val.getKeyEstado1().equals(val.getKeyNick())) {
                    val.setKeyDuelista2(val.getKeyEstado7());
                } else { if (val.getKeyEstado7().equals(val.getKeyNick())) {
                    val.setKeyDuelista2(val.getKeyEstado1());
                } } } } } } }

}
}
}
}

}

if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
llamadaDerrota();
} else {
if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
llamadaDerrota();
} else {
if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
    val.setKeyDuelista2("auxiliar");
    if(val.getKeyEstado1().equals("derrota")){
        val.setKeyDuelista2(val.getKeyCalabozolvl2());
    }else{
        if(val.getKeyEstado2().equals("derrota")){
            val.setKeyDuelista2(val.getKeyCalabozolvl1());

        }else{
            Toast.makeText(getApplicationContext(), "Aun su rival no ha sido definido epera.. Arigato.", Toast.LENGTH_SHORT).show();
        }
    }
    if(val.getKeyDuelista2().equals("auxiliar")){
    }else{
        llamadaDerrota();
    }
} else {
if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
llamadaDerrota();
} else {
if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
llamadaDerrota();
} else {
if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
llamadaDerrota();
} else {
if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {

    val.setKeyDuelista2("auxiliar");
    if(val.getKeyEstado5().equals("derrota")){
        val.setKeyDuelista2(val.getKeyCalabozolvl6());
    }else{
        if(val.getKeyEstado6().equals("derrota")){
            val.setKeyDuelista2(val.getKeyCalabozolvl5());

        }else{
            Toast.makeText(getApplicationContext(), "Aun su rival no ha sido definido epera.. Arigato.", Toast.LENGTH_SHORT).show();
        }
    }
    if(val.getKeyDuelista2().equals("auxiliar")){
    }else{
        llamadaDerrota();
    }
}else{
if (val.getKeyCalabozolvl8().equals(val.getKeyNick())) {
llamadaDerrota();
}else{
if (val.getKeyCalabozolvl9().equals(val.getKeyNick())) {
llamadaDerrota();
}else{
if (val.getKeyCalabozolvl10().equals(val.getKeyNick())) {
llamadaDerrota();
}else{


    Toast.makeText(getApplicationContext(), "No puede generar mas codigos..", Toast.LENGTH_SHORT).show();

}}
}

}
} } } }} }

                } }});
 }


    Context contexto;

    public void llamadaDerrota() {
        contexto = this;
        new detlles_derrota_v10(contexto);
    }

    public void llamadaPoliticas(View dsfs){
        contexto = this;
        new detlles_politicas_dungeon(contexto);
    }
    protected void onStop() {
        super.onStop();
        contexto val = new contexto();
        //   Toast.makeText(this, "OnStop:"+val.getKeyNick(), Toast.LENGTH_SHORT).show();
        relogueolvl6();

    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();


        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

    public void enlaceLVL6(View sdfsd) {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {


                    Toast.makeText(getApplicationContext(), "EBLACE: " + val.getKeyEnlaceCalabozolvl6(), Toast.LENGTH_SHORT).show();
                    Uri url = Uri.parse(val.getKeyEnlaceCalabozolvl6());
                    Intent siguiente = new Intent(Intent.ACTION_VIEW, url);
                    startActivity(siguiente);
                }
            }
        });
    }

    public void relogueolvl6() {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if (documentSnapshot.exists()) {

                            val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                            val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                            val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                            val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                            val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                            val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                            val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));
                            val.setKeyCalabozolvl8(documentSnapshot.getString("puestoN8"));
                            val.setKeyCalabozolvl9(documentSnapshot.getString("puestoN9"));
                            val.setKeyCalabozolvl10(documentSnapshot.getString("puestoN10"));

                            l1.setText(val.getKeyCalabozolvl1());
                            l2.setText(val.getKeyCalabozolvl2());
                            l3.setText(val.getKeyCalabozolvl3());
                            l4.setText(val.getKeyCalabozolvl4());
                            l5.setText(val.getKeyCalabozolvl5());
                            l6.setText(val.getKeyCalabozolvl6());
                            l7.setText(val.getKeyCalabozolvl7());
                            l8.setText(val.getKeyCalabozolvl8());
                            l17.setText(val.getKeyCalabozolvl9());
                            l9.setText(val.getKeyCalabozolvl10());

                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).get()
                                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                                            if (documentSnapshot.exists()) {

                                                val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                                                val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                                                val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                                                val.setKeyParticipante4(documentSnapshot.getString("participante4"));
                                                val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                                val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                                val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                                val.setKeyParticipante8(documentSnapshot.getString("participante8"));
                                                val.setKeyParticipante9(documentSnapshot.getString("participante9"));
                                                val.setKeyParticipante10(documentSnapshot.getString("participante10"));

                                                l10.setText(val.getKeyParticipante1());
                                                l11.setText(val.getKeyParticipante2());
                                                l12.setText(val.getKeyParticipante3());
                                                l13.setText(val.getKeyParticipante4());
                                                l14.setText(val.getKeyParticipante5());
                                                l15.setText(val.getKeyParticipante6());
                                                l16.setText(val.getKeyParticipante7());
                                                l18.setText(val.getKeyParticipante8());
                                                l19.setText(val.getKeyParticipante9());
                                                l20.setText(val.getKeyParticipante10());

                                            }
                                        }
                                    });


                        }

                    }
                });
    }
    }