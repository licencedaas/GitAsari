package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Stack;

public class tabla_victoria_dungeon_xyz_v6 extends AppCompatActivity {

    FirebaseFirestore bdNeutral;
    Spinner sp1;
    Stack<String> idV1 = new Stack<>();
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_victoria_dungeon_xyz_v6);

        bdNeutral = FirebaseFirestore.getInstance();
        contexto val = new contexto();
        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));

        sp1 = (Spinner) findViewById(R.id.tabla_duelos_sp1);

        l1=(TextView) findViewById(R.id.tabla_wins_l2);
        l2=(TextView) findViewById(R.id.tabla_wins_l3);
        l3=(TextView) findViewById(R.id.tabla_wins_l4);
        l4=(TextView) findViewById(R.id.tabla_wins_l5);
        l5=(TextView) findViewById(R.id.tabla_wins_l6);

        l6=(TextView) findViewById(R.id.tabla_wins_l7);
        l7=(TextView) findViewById(R.id.tabla_wins_l8);
        l8=(TextView) findViewById(R.id.tabla_wins_l9);


        l9=(TextView) findViewById(R.id.tabla_wins_l13);
        l10=(TextView) findViewById(R.id.tabla_wins_l14);
        l11=(TextView) findViewById(R.id.tabla_wins_l15);
        l12=(TextView) findViewById(R.id.tabla_wins_l16);
        l13=(TextView) findViewById(R.id.tabla_wins_l17);

        l14=(TextView) findViewById(R.id.tabla_wins_l18);
        l15=(TextView) findViewById(R.id.tabla_wins_l19);
        l16=(TextView) findViewById(R.id.tabla_wins_l20);

        l17=(TextView) findViewById(R.id.tabla_wins_l24);
        l18=(TextView) findViewById(R.id.tabla_wins_l25);
        l19=(TextView) findViewById(R.id.tabla_wins_l26);
        l20=(TextView) findViewById(R.id.tabla_wins_l27);
        l21=(TextView) findViewById(R.id.tabla_wins_l28);

        l22=(TextView) findViewById(R.id.tabla_wins_l29);
        l23=(TextView) findViewById(R.id.tabla_wins_l30);
        l24=(TextView) findViewById(R.id.tabla_wins_l31);


        bdNeutral.collection("BDcalabozo").document("tablaGeneral")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()) {

                    val.setKeyParticipante1(documentSnapshot.getString("1Puesto"));
                    val.setKeyParticipante2(documentSnapshot.getString("2Puesto"));
                    val.setKeyParticipante3(documentSnapshot.getString("3Puesto"));
                    val.setKeyParticipante4(documentSnapshot.getString("4Puesto"));
                    val.setKeyParticipante5(documentSnapshot.getString("5Puesto"));
                    val.setKeyParticipante6(documentSnapshot.getString("6Puesto"));
                    val.setKeyParticipante7(documentSnapshot.getString("7Puesto"));
                    val.setKeyParticipante8(documentSnapshot.getString("8Puesto"));

                    l1.setText(val.getKeyParticipante1());
                    l2.setText(val.getKeyParticipante2());
                    l3.setText(val.getKeyParticipante3());
                    l4.setText(val.getKeyParticipante4());
                    l5.setText(val.getKeyParticipante5());
                    l6.setText(val.getKeyParticipante6());
                    l7.setText(val.getKeyParticipante7());
                    l8.setText(val.getKeyParticipante8());


                    ArrayAdapter<String> datos = null;
                    idV1.add("Elija Duelista");
                    datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);

                    idV1.add(val.getKeyParticipante1());
                    idV1.add(val.getKeyParticipante2());
                    idV1.add(val.getKeyParticipante3());
                    idV1.add(val.getKeyParticipante4());
                    idV1.add(val.getKeyParticipante5());
                    idV1.add(val.getKeyParticipante6());
                    idV1.add(val.getKeyParticipante7());
                    idV1.add(val.getKeyParticipante8());


                    sp1.setAdapter(datos);
                }

            }});

    }

    public void datosJugador(View sdfs){
        contexto val = new contexto();
        val.setKeyDuelista(sp1.getSelectedItem().toString());

   bdNeutral.collection("BDcalabozo").document("tablaEncuentro")
   .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override
   public void onSuccess(DocumentSnapshot documentSnapshot) {

   if (documentSnapshot.exists()) {

       val.setKeyLugarFinal1(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante1()));
       val.setKeyLugarFinal2(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante2()));
       val.setKeyLugarFinal3(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante3()));
       val.setKeyLugarFinal4(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante4()));
       val.setKeyLugarFinal5(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante5()));
       val.setKeyLugarFinal6(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante6()));
       val.setKeyLugarFinal7(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante7()));
       val.setKeyLugarFinal8(documentSnapshot.getString(val.getKeyDuelista()+"VS"+val.getKeyParticipante8()));

       val.setKeyEstado1(documentSnapshot.getString(val.getKeyParticipante1()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado2(documentSnapshot.getString(val.getKeyParticipante2()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado3(documentSnapshot.getString(val.getKeyParticipante3()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado4(documentSnapshot.getString(val.getKeyParticipante4()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado5(documentSnapshot.getString(val.getKeyParticipante5()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado6(documentSnapshot.getString(val.getKeyParticipante6()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado7(documentSnapshot.getString(val.getKeyParticipante7()+"VS"+val.getKeyDuelista()));
       val.setKeyEstado8(documentSnapshot.getString(val.getKeyParticipante8()+"VS"+val.getKeyDuelista()));

       l9.setText(val.getKeyLugarFinal1());
       l10.setText(val.getKeyLugarFinal2());
       l11.setText(val.getKeyLugarFinal3());
       l12.setText(val.getKeyLugarFinal4());
       l13.setText(val.getKeyLugarFinal5());
       l14.setText(val.getKeyLugarFinal6());
       l15.setText(val.getKeyLugarFinal7());
       l16.setText(val.getKeyLugarFinal8());

       l17.setText(val.getKeyEstado1());
       l18.setText(val.getKeyEstado2());
       l19.setText(val.getKeyEstado3());
       l20.setText(val.getKeyEstado4());
       l21.setText(val.getKeyEstado5());
       l22.setText(val.getKeyEstado6());
       l23.setText(val.getKeyEstado7());
       l24.setText(val.getKeyEstado8());

    }

    }});

    }


}