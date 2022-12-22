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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class sala_elimintarias_aleatorias extends AppCompatActivity {

    ImageView img5,img6,img7,img8, img9,img10,img11,img12;

    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24;
    FirebaseFirestore bdNeutro;
    ImageButton  b1,b2,b3;
    Button b4;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_elimintarias_aleatorias);


        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyPermisoInicio(getIntent().getStringExtra("keyAdmin"));
        val.setKeySalaDuelo(getIntent().getStringExtra("keySala"));
        val.setKeyRutaDungeon1(getIntent().getStringExtra("keyTabla"));
        val.setKeyRutaDungeon2(getIntent().getStringExtra("keyCalabozo"));
        val.setKeyEnlaceCalabozolvl6(getIntent().getStringExtra("keyEnlace"));
        bdNeutro = FirebaseFirestore.getInstance();


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adViewlose);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);//ca-app-pub-5746550188084225/1451846458
        //PRUEVA ca-app-pub-3940256099942544/6300978111

       img5 =(ImageView) findViewById(R.id.vs5);
        img6 =(ImageView) findViewById(R.id.vs6);
        img7 =(ImageView) findViewById(R.id.vs7);
        img8 =(ImageView) findViewById(R.id.vs8);
        img9 =(ImageView) findViewById(R.id.vs9);
        img10 =(ImageView) findViewById(R.id.vs10);
        img11 =(ImageView) findViewById(R.id.vs11);
        img12 =(ImageView) findViewById(R.id.vs12);//vs_l9
        b2 = (ImageButton)findViewById(R.id.lose_politicas);//
        b2.setVisibility(View.GONE);

        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b2.setVisibility(View.VISIBLE); } }catch (Exception dfs){}



        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        img7.setVisibility(View.GONE);
        img8.setVisibility(View.GONE);
        img9.setVisibility(View.GONE);
        img10.setVisibility(View.GONE);
        img11.setVisibility(View.GONE);
        img12.setVisibility(View.GONE);




        ///   4 primeros color negro
        l2 =(TextView) findViewById(R.id.vs_2);//negros
        l4 =(TextView) findViewById(R.id.vs_4);
        l6 =(TextView) findViewById(R.id.vs_6);
        l8 =(TextView) findViewById(R.id.vs_8);//negros
       //fom
        ///   4 primeros color rojo
        l1 =(TextView) findViewById(R.id.vs_1);//rojo
        l3 =(TextView) findViewById(R.id.vs_3);
        l5 =(TextView) findViewById(R.id.vs_5);
        l7 =(TextView) findViewById(R.id.vs_7);
        //fom

        l9 =(TextView) findViewById(R.id.vs_l9);//rojo
        l11 =(TextView) findViewById(R.id.vs_l11);
        l13 =(TextView) findViewById(R.id.vs_l13);
        l15 =(TextView) findViewById(R.id.vs_l15);//rojo
        l17 =(TextView) findViewById(R.id.vs_l17);
        l19 =(TextView) findViewById(R.id.vs_l19);
        l21 =(TextView) findViewById(R.id.vs_l21);
        l23 =(TextView) findViewById(R.id.vs_l23);

        ///   4 primeros color negro
        l10 =(TextView) findViewById(R.id.vs_l10);//negros
        l12 =(TextView) findViewById(R.id.vs_l12);
        l14 =(TextView) findViewById(R.id.vs_l14);
        l16 =(TextView) findViewById(R.id.vs_l16);//negros
        l18 =(TextView) findViewById(R.id.vs_l18);//negros
        l20 =(TextView) findViewById(R.id.vs_l20);
        l22 =(TextView) findViewById(R.id.vs_l22);
        l24 =(TextView) findViewById(R.id.vs_l24);
        //fom



        l9.setVisibility(View.GONE);
        l10.setVisibility(View.GONE);
        l11.setVisibility(View.GONE);
        l12.setVisibility(View.GONE);
        l13.setVisibility(View.GONE);
        l14.setVisibility(View.GONE);
        l15.setVisibility(View.GONE);
        l16.setVisibility(View.GONE);
        l17.setVisibility(View.GONE);
        l18.setVisibility(View.GONE);
        l19.setVisibility(View.GONE);
        l20.setVisibility(View.GONE);
        l21.setVisibility(View.GONE);
        l22.setVisibility(View.GONE);
        l23.setVisibility(View.GONE);
        l24.setVisibility(View.GONE);

        b3 =(ImageButton) findViewById(R.id.lose_b3);//lose_sala
        b4 =(Button) findViewById(R.id.lose_sala);
        b4.setText(val.getKeySalaDuelo());

        relogueolvl6();
    }




    Context contexto;

    protected void onStop() {
        super.onStop();
        contexto val = new contexto();

        relogueolvl6();

    }

    public void relogueolvl6(){
        contexto val = new contexto();

        bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                    val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                    val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                    val.setKeyParticipante4(documentSnapshot.getString("participante4"));

                    val.setKeyConteo(documentSnapshot.getString("keyConteo"));
                    val.setKeyJ1(Integer.parseInt(val.getKeyConteo()));
                    val.setKeyCalabozoActivo("0");

                    l2.setText(val.getKeyParticipante1());
                    l4.setText(val.getKeyParticipante2());
                    l6.setText(val.getKeyParticipante3());
                    l8.setText(val.getKeyParticipante4());








                    bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot1) {

                                    if (documentSnapshot1.exists()) {


                                        val.setKeyCalabozolvl1(documentSnapshot1.getString("puestoN1"));
                                        val.setKeyCalabozolvl2(documentSnapshot1.getString("puestoN2"));
                                        val.setKeyCalabozolvl3(documentSnapshot1.getString("puestoN3"));
                                        val.setKeyCalabozolvl4(documentSnapshot1.getString("puestoN4"));

                                        l1.setText(val.getKeyCalabozolvl1());
                                        l3.setText(val.getKeyCalabozolvl2());
                                        l5.setText(val.getKeyCalabozolvl3());
                                        l7.setText(val.getKeyCalabozolvl4());




                                        if(val.getKeyConteo().equals("5")){
                                            img5.setVisibility(View.VISIBLE);
                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);

                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            l9.setText(val.getKeyParticipante5());
                                            l10.setText(val.getKeyCalabozolvl5());


                                        }
                                        if(val.getKeyConteo().equals("6")) {
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);

                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));

                                            l9.setText(val.getKeyParticipante5());
                                            l10.setText(val.getKeyCalabozolvl5());
                                            l11.setText(val.getKeyParticipante6());
                                            l12.setText(val.getKeyCalabozolvl6());


                                        }
                                        if(val.getKeyConteo().equals("7")){
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            img7.setVisibility(View.VISIBLE);
                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);
                                            l13.setVisibility(View.VISIBLE);
                                            l14.setVisibility(View.VISIBLE);


                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                            val.setKeyCalabozolvl7(documentSnapshot1.getString("puestoN7"));

                                            l9.setText(val.getKeyCalabozolvl5());
                                            l10.setText(val.getKeyParticipante5());
                                            l11.setText(val.getKeyCalabozolvl6());
                                            l12.setText(val.getKeyParticipante6());
                                            l13.setText(val.getKeyCalabozolvl7());
                                            l14.setText(val.getKeyParticipante7());



                                        }
                                        if(val.getKeyConteo().equals("8")){
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            img7.setVisibility(View.VISIBLE);
                                            img8.setVisibility(View.VISIBLE);
                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);
                                            l13.setVisibility(View.VISIBLE);
                                            l14.setVisibility(View.VISIBLE);
                                            l15.setVisibility(View.VISIBLE);
                                            l16.setVisibility(View.VISIBLE);


                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                            val.setKeyCalabozolvl7(documentSnapshot1.getString("puestoN7"));
                                            val.setKeyParticipante8(documentSnapshot.getString("participante8"));
                                            val.setKeyCalabozolvl8(documentSnapshot1.getString("puestoN8"));

                                            l9.setText(val.getKeyCalabozolvl5());
                                            l10.setText(val.getKeyParticipante5());
                                            l11.setText(val.getKeyCalabozolvl6());
                                            l12.setText(val.getKeyParticipante6());
                                            l13.setText(val.getKeyCalabozolvl7());
                                            l14.setText(val.getKeyParticipante7());
                                            l15.setText(val.getKeyCalabozolvl8());
                                            l16.setText(val.getKeyParticipante8());

                                        }

                                        if(val.getKeyJ1()==9){
                                            Toast.makeText(getApplicationContext(), " ENTRANDO A 9LOSE", Toast.LENGTH_SHORT).show();
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            img7.setVisibility(View.VISIBLE);
                                            img8.setVisibility(View.VISIBLE);
                                            img9.setVisibility(View.VISIBLE);
                                            img10.setVisibility(View.VISIBLE);

                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);
                                            l13.setVisibility(View.VISIBLE);
                                            l14.setVisibility(View.VISIBLE);
                                            l15.setVisibility(View.VISIBLE);
                                            l16.setVisibility(View.VISIBLE);
                                            l17.setVisibility(View.VISIBLE);
                                            l18.setVisibility(View.VISIBLE);

                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                            val.setKeyCalabozolvl7(documentSnapshot1.getString("puestoN7"));
                                            val.setKeyParticipante8(documentSnapshot.getString("participante8"));
                                            val.setKeyCalabozolvl8(documentSnapshot1.getString("puestoN8"));
                                            val.setKeyParticipante9(documentSnapshot.getString("participante9"));
                                            val.setKeyCalabozolvl9(documentSnapshot1.getString("puestoN9"));

                                            l9.setText(val.getKeyCalabozolvl5());
                                            l10.setText(val.getKeyParticipante5());
                                            l11.setText(val.getKeyCalabozolvl6());
                                            l12.setText(val.getKeyParticipante6());
                                            l13.setText(val.getKeyCalabozolvl7());
                                            l14.setText(val.getKeyParticipante7());
                                            l15.setText(val.getKeyCalabozolvl8());
                                            l16.setText(val.getKeyParticipante8());
                                            l17.setText(val.getKeyCalabozolvl9());
                                            l18.setText(val.getKeyParticipante9());
                                        }


                                        if(val.getKeyJ1()==10) {
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            img7.setVisibility(View.VISIBLE);
                                            img8.setVisibility(View.VISIBLE);
                                            img9.setVisibility(View.VISIBLE);
                                            img10.setVisibility(View.VISIBLE);
                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);
                                            l13.setVisibility(View.VISIBLE);
                                            l14.setVisibility(View.VISIBLE);
                                            l15.setVisibility(View.VISIBLE);
                                            l16.setVisibility(View.VISIBLE);
                                            l17.setVisibility(View.VISIBLE);
                                            l18.setVisibility(View.VISIBLE);
                                            l19.setVisibility(View.VISIBLE);
                                            l20.setVisibility(View.VISIBLE);

                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                            val.setKeyCalabozolvl7(documentSnapshot1.getString("puestoN7"));
                                            val.setKeyParticipante8(documentSnapshot.getString("participante8"));
                                            val.setKeyCalabozolvl8(documentSnapshot1.getString("puestoN8"));
                                            val.setKeyParticipante9(documentSnapshot.getString("participante9"));
                                            val.setKeyCalabozolvl9(documentSnapshot1.getString("puestoN9"));
                                            val.setKeyParticipante10(documentSnapshot.getString("participante10"));
                                            val.setKeyCalabozolvl10(documentSnapshot1.getString("puestoN10"));


                                            l9.setText(val.getKeyCalabozolvl5());
                                            l10.setText(val.getKeyParticipante5());
                                            l11.setText(val.getKeyCalabozolvl6());
                                            l12.setText(val.getKeyParticipante6());
                                            l13.setText(val.getKeyCalabozolvl7());
                                            l14.setText(val.getKeyParticipante7());
                                            l15.setText(val.getKeyCalabozolvl8());
                                            l16.setText(val.getKeyParticipante8());
                                            l17.setText(val.getKeyCalabozolvl9());
                                            l18.setText(val.getKeyParticipante9());
                                            l19.setText(val.getKeyCalabozolvl10());
                                            l20.setText(val.getKeyParticipante10());

                                        }

                                        if(val.getKeyJ1()==11) {
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            img7.setVisibility(View.VISIBLE);
                                            img8.setVisibility(View.VISIBLE);
                                            img9.setVisibility(View.VISIBLE);
                                            img10.setVisibility(View.VISIBLE);
                                            img11.setVisibility(View.VISIBLE);

                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);
                                            l13.setVisibility(View.VISIBLE);
                                            l14.setVisibility(View.VISIBLE);
                                            l15.setVisibility(View.VISIBLE);
                                            l16.setVisibility(View.VISIBLE);
                                            l17.setVisibility(View.VISIBLE);
                                            l18.setVisibility(View.VISIBLE);
                                            l19.setVisibility(View.VISIBLE);
                                            l20.setVisibility(View.VISIBLE);
                                            l21.setVisibility(View.VISIBLE);
                                            l22.setVisibility(View.VISIBLE);

                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                            val.setKeyCalabozolvl7(documentSnapshot1.getString("puestoN7"));
                                            val.setKeyParticipante8(documentSnapshot.getString("participante8"));
                                            val.setKeyCalabozolvl8(documentSnapshot1.getString("puestoN8"));
                                            val.setKeyParticipante9(documentSnapshot.getString("participante9"));
                                            val.setKeyCalabozolvl9(documentSnapshot1.getString("puestoN9"));
                                            val.setKeyParticipante10(documentSnapshot.getString("participante10"));
                                            val.setKeyCalabozolvl10(documentSnapshot1.getString("puestoN10"));
                                            val.setKeyParticipante11(documentSnapshot.getString("participante11"));
                                            val.setKeyCalabozolvl11(documentSnapshot1.getString("puestoN11"));

                                            l9.setText(val.getKeyCalabozolvl5());
                                            l10.setText(val.getKeyParticipante5());
                                            l11.setText(val.getKeyCalabozolvl6());
                                            l12.setText(val.getKeyParticipante6());
                                            l13.setText(val.getKeyCalabozolvl7());
                                            l14.setText(val.getKeyParticipante7());
                                            l15.setText(val.getKeyCalabozolvl8());
                                            l16.setText(val.getKeyParticipante8());
                                            l17.setText(val.getKeyCalabozolvl9());
                                            l18.setText(val.getKeyParticipante9());
                                            l19.setText(val.getKeyCalabozolvl10());
                                            l20.setText(val.getKeyParticipante10());
                                            l21.setText(val.getKeyCalabozolvl11());
                                            l22.setText(val.getKeyParticipante11());


                                        }

                                        if(val.getKeyJ1()==12) {
                                            img5.setVisibility(View.VISIBLE);
                                            img6.setVisibility(View.VISIBLE);
                                            img7.setVisibility(View.VISIBLE);
                                            img8.setVisibility(View.VISIBLE);
                                            img9.setVisibility(View.VISIBLE);
                                            img10.setVisibility(View.VISIBLE);
                                            img11.setVisibility(View.VISIBLE);
                                            img12.setVisibility(View.VISIBLE);

                                            l9.setVisibility(View.VISIBLE);
                                            l10.setVisibility(View.VISIBLE);
                                            l11.setVisibility(View.VISIBLE);
                                            l12.setVisibility(View.VISIBLE);
                                            l13.setVisibility(View.VISIBLE);
                                            l14.setVisibility(View.VISIBLE);
                                            l15.setVisibility(View.VISIBLE);
                                            l16.setVisibility(View.VISIBLE);
                                            l17.setVisibility(View.VISIBLE);
                                            l18.setVisibility(View.VISIBLE);
                                            l19.setVisibility(View.VISIBLE);
                                            l20.setVisibility(View.VISIBLE);
                                            l21.setVisibility(View.VISIBLE);
                                            l22.setVisibility(View.VISIBLE);
                                            l23.setVisibility(View.VISIBLE);
                                            l24.setVisibility(View.VISIBLE);

                                            val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                            val.setKeyCalabozolvl5(documentSnapshot1.getString("puestoN5"));
                                            val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                            val.setKeyCalabozolvl6(documentSnapshot1.getString("puestoN6"));
                                            val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                            val.setKeyCalabozolvl7(documentSnapshot1.getString("puestoN7"));
                                            val.setKeyParticipante8(documentSnapshot.getString("participante8"));
                                            val.setKeyCalabozolvl8(documentSnapshot1.getString("puestoN8"));
                                            val.setKeyParticipante9(documentSnapshot.getString("participante9"));
                                            val.setKeyCalabozolvl9(documentSnapshot1.getString("puestoN9"));
                                            val.setKeyParticipante10(documentSnapshot.getString("participante10"));
                                            val.setKeyCalabozolvl10(documentSnapshot1.getString("puestoN10"));
                                            val.setKeyParticipante11(documentSnapshot.getString("participante11"));
                                            val.setKeyCalabozolvl11(documentSnapshot1.getString("puestoN11"));
                                            val.setKeyParticipante12(documentSnapshot.getString("participante12"));
                                            val.setKeyCalabozolvl12(documentSnapshot1.getString("puestoN12"));

                                            l9.setText(val.getKeyCalabozolvl5());
                                            l10.setText(val.getKeyParticipante5());
                                            l11.setText(val.getKeyCalabozolvl6());
                                            l12.setText(val.getKeyParticipante6());
                                            l13.setText(val.getKeyCalabozolvl7());
                                            l14.setText(val.getKeyParticipante7());
                                            l15.setText(val.getKeyCalabozolvl8());
                                            l16.setText(val.getKeyParticipante8());
                                            l17.setText(val.getKeyCalabozolvl9());
                                            l18.setText(val.getKeyParticipante9());
                                            l19.setText(val.getKeyCalabozolvl10());
                                            l20.setText(val.getKeyParticipante10());
                                            l21.setText(val.getKeyCalabozolvl11());
                                            l22.setText(val.getKeyParticipante11());
                                            l23.setText(val.getKeyCalabozolvl12());
                                            l24.setText(val.getKeyParticipante12());


                                        }

                                    }}});




                }
            }});

    }


    public void enlaceLVL6(View sdfsd) {

        contexto val = new contexto();
        bdNeutro.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
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


    public void cerrar(View sdfas) {
        contexto val = new contexto();



        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

    public void llamadalose(View dsfs){
        tabla();
    }

    public void tabla(){
        contexto = this;
        new detlles_asistencia_lose(contexto);
    }


    public void lose(){
        contexto = this;
        new detlles_derrota_lose(contexto);
    }

    public void detallesDerrota(View sdfsfd){
    contexto val = new contexto();
    bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
    @Override
    public void onSuccess(DocumentSnapshot documentSnapshot) {
    if(documentSnapshot.exists()) {


       val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
       val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
       val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
       val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
        val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
        val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
        val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN77"));
        val.setKeyCalabozolvl8(documentSnapshot.getString("puestoN8"));
        val.setKeyCalabozolvl9(documentSnapshot.getString("puestoN9"));
        val.setKeyCalabozolvl10(documentSnapshot.getString("puestoN10"));
        val.setKeyCalabozolvl11(documentSnapshot.getString("puestoN11"));
        val.setKeyCalabozolvl12(documentSnapshot.getString("puestoN12"));


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
        val.setKeyEstado11(documentSnapshot.getString("puestoN11"));
        val.setKeyEstado12(documentSnapshot.getString("puestoN12"));


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
        val.setKeyParticipante11(documentSnapshot.getString("participante11"));
        val.setKeyParticipante12(documentSnapshot.getString("participante12"));


try{

    if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante5());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
    }



    }else{
    val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
     val.setKeyDuelista2(val.getKeyParticipante2());
    }
    } else {
    if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
     if(val.getKeyEstado1().equals("derrota")){
     if(val.getKeyEstado3().equals("derrota")){
     if(val.getKeyEstado4().equals("derrota")){
     if(val.getKeyEstado5().equals("derrota")){
     if(val.getKeyEstado6().equals("derrota")){
     if(val.getKeyEstado7().equals("derrota")){
     if(val.getKeyEstado8().equals("derrota")){
     if(val.getKeyEstado9().equals("derrota")){
     if(val.getKeyEstado10().equals("derrota")){
     if(val.getKeyEstado11().equals("derrota")){
     if(val.getKeyEstado12().equals("derrota")){
     Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
     }else{
     val.setKeyDuelista2(val.getKeyParticipante12());
     }
     }else{
     if(val.getKeyEstado12().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante11());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
     }
     }else{
         val.setKeyDuelista2(val.getKeyParticipante10());
     }
     }else{
     if(val.getKeyEstado10().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante9());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
     }
     }else{
         val.setKeyDuelista2(val.getKeyParticipante8());
     }
     }else{
     if(val.getKeyEstado8().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante7());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
     }
     }else{
         val.setKeyDuelista2(val.getKeyParticipante6());
     }
     }else{
     if(val.getKeyEstado6().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante5());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
     }
     }else{
     val.setKeyDuelista2(val.getKeyParticipante4());
     }
     }else{
     if(val.getKeyEstado4().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante3());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
     }
     }else{
     val.setKeyDuelista2(val.getKeyParticipante1());
     }
    ///CONTENIDO POSICION 2
    } else {
    if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
     if(val.getKeyEstado10().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante4());
    }



    ////CONTENIDO POSICION 3
    } else {
    if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
   }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
   }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante3());
    }

    ///CONTENIDO POSICION 4
    } else {
    if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {

try{
    if(val.getKeyEstado6().equals("derrota")){
try{
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado1().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante2());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }

    }catch (Exception dfsdf){
if(val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {

}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}


    }else{
    val.setKeyDuelista2(val.getKeyParticipante6());
    }

}catch (Exception dfsdf){
if(val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {

}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}



        ///CONTENIDO POSICION 5

    } else {

if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
if(val.getKeyEstado5().equals("derrota")){
try{
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
try{
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }catch (Exception dfsdf){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();

}



    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
}catch (Exception dfsdf){
if(val.getKeyEstado3().equals("derrota"))  {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {
    Toast.makeText(getApplicationContext(), "FELICIDADES ERES EL GANADOR DEL TORNEO SEMANAL HAS OPTENIDO 2PS", Toast.LENGTH_SHORT).show();
}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
if(val.getKeyEstado2().equals("derrota")){
val.setKeyDuelista2(val.getKeyParticipante1());
}else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
}
}
}else{
val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
if(val.getKeyEstado4().equals("derrota")){
val.setKeyDuelista2(val.getKeyParticipante3());
}else{
Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
}
}
}



    }else{
    val.setKeyDuelista2(val.getKeyParticipante5());
    }
    ////6

    }else{
    if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {

try{
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){

try{
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }

    }catch (Exception dfsdf){}


    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    if(val.getKeyEstado5().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante6());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }catch (Exception dfsdf){

if(val.getKeyEstado6().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {
if (val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {

}else {
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else {

    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }

}
}else {
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else {
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }

}

}else{
    val.setKeyDuelista2(val.getKeyParticipante5());
}
}else{
    if(val.getKeyEstado5().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante6());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}




    ///CONTENIDO POSICION 7
    }else{
    if (val.getKeyCalabozolvl8().equals(val.getKeyNick())) {
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
try{
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
     val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }

}catch (Exception dfsdf){}





    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado5().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante6());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante7());
    }
    ///CONTENIDO POSICION 8

    }else{
    if (val.getKeyCalabozolvl9().equals(val.getKeyNick())) {
try{
    if(val.getKeyEstado10().equals("derrota")){
try{
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){

    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
}catch (Exception dfsdf){
if(val.getKeyEstado7().equals("derrota")) {
if (val.getKeyEstado8().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
if (val.getKeyEstado6().equals("derrota")) {
if (val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {
}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante6());
}
}else {
    if(val.getKeyEstado6().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}else{
    val.setKeyDuelista2(val.getKeyParticipante8());
}
}else{
    if(val.getKeyEstado8().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}


}


    }else{
    val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }catch (Exception dfsdf){


if(val.getKeyEstado7().equals("derrota")) {
if (val.getKeyEstado8().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
if (val.getKeyEstado6().equals("derrota")) {
if (val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {
}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante6());
}
}else {
    if(val.getKeyEstado6().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}else{
    val.setKeyDuelista2(val.getKeyParticipante8());
}
}else{
    if(val.getKeyEstado8().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}




    ///CONTENIDO POSICION 9
    }else{
    if (val.getKeyCalabozolvl10().equals(val.getKeyNick())) {
    if(val.getKeyEstado9().equals("derrota")){

    try{
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado12().equals("derrota")){
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
     val.setKeyDuelista2(val.getKeyParticipante11());
     }else{
     Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
     }
    }

}catch (Exception dfsdf){

if(val.getKeyEstado7().equals("derrota")) {
if (val.getKeyEstado8().equals("derrota")) {
if (val.getKeyEstado5().equals("derrota")) {
if (val.getKeyEstado6().equals("derrota")) {
if (val.getKeyEstado3().equals("derrota")) {
if (val.getKeyEstado4().equals("derrota")) {
if (val.getKeyEstado1().equals("derrota")) {
if (val.getKeyEstado2().equals("derrota")) {
}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante6());
}
}else {
    if(val.getKeyEstado6().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}else{
    val.setKeyDuelista2(val.getKeyParticipante8());
}
}else{
    if(val.getKeyEstado8().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}


}



    }else{
    val.setKeyDuelista2(val.getKeyParticipante9());
    }
    ///CONTENIDO POSICION 10
    }else{
    if (val.getKeyCalabozolvl11().equals(val.getKeyNick())) {

    try{
    if(val.getKeyEstado12().equals("derrota")){
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado12().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante11());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante12());
    }

}catch (Exception dfsdf){
if(val.getKeyEstado9().equals("derrota")){
if(val.getKeyEstado10().equals("derrota")){
if(val.getKeyEstado7().equals("derrota")){
if(val.getKeyEstado8().equals("derrota")){
if(val.getKeyEstado5().equals("derrota")){
if(val.getKeyEstado6().equals("derrota")){
if(val.getKeyEstado3().equals("derrota")){
if(val.getKeyEstado4().equals("derrota")){
if(val.getKeyEstado1().equals("derrota")){
if(val.getKeyEstado2().equals("derrota")){
}else{
    val.setKeyDuelista2(val.getKeyParticipante2());
}
}else{
    if(val.getKeyEstado2().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante4());
}
}else{
    if(val.getKeyEstado4().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
}else{
    val.setKeyDuelista2(val.getKeyParticipante6());
}
}else {
    if(val.getKeyEstado6().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}else{
    val.setKeyDuelista2(val.getKeyParticipante8());
}
}else{
    if(val.getKeyEstado8().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}

}else{
    val.setKeyDuelista2(val.getKeyParticipante10());
}
}else{
    if(val.getKeyEstado10().equals("derrota")){
        val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
        Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
}
    }



    ///CONTENIDO POSICION 11
    }else{
    if (val.getKeyCalabozolvl12().equals(val.getKeyNick())) {
    if(val.getKeyEstado11().equals("derrota")){
    if(val.getKeyEstado9().equals("derrota")){
    if(val.getKeyEstado10().equals("derrota")){
    if(val.getKeyEstado7().equals("derrota")){
    if(val.getKeyEstado8().equals("derrota")){
    if(val.getKeyEstado5().equals("derrota")){
    if(val.getKeyEstado6().equals("derrota")){
    if(val.getKeyEstado3().equals("derrota")){
    if(val.getKeyEstado4().equals("derrota")){
    if(val.getKeyEstado1().equals("derrota")){
    if(val.getKeyEstado2().equals("derrota")){
    Toast.makeText(getApplicationContext(), "Felixidases", Toast.LENGTH_SHORT).show();
    }else{
    val.setKeyDuelista2(val.getKeyParticipante2());
    }
    }else{
    if(val.getKeyEstado2().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante1());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante4());
    }
    }else{
    if(val.getKeyEstado4().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante3());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante6());
    }
    }else{
    if(val.getKeyEstado6().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante5());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
        val.setKeyDuelista2(val.getKeyParticipante8());
    }
    }else{
    if(val.getKeyEstado8().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante7());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
    }
    }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante10());
    }
    }else{
    if(val.getKeyEstado10().equals("derrota")){
    val.setKeyDuelista2(val.getKeyParticipante9());
    }else{
    Toast.makeText(getApplicationContext(), "Debe esperar que los otros rivales definan", Toast.LENGTH_SHORT).show();
   }
     }
    }else{
    val.setKeyDuelista2(val.getKeyParticipante11());
    }
    ///CONTENIDO POSICION 12
    }else{
    Toast.makeText(getApplicationContext(), "Esta accion no esta  disponible gracias", Toast.LENGTH_SHORT).show();
    }

    } } } } } } } } } } }

    lose();
        Toast.makeText(getApplicationContext(), val.getKeyNick() + "  vs   " + val.getKeyDuelista2(), Toast.LENGTH_SHORT).show();
}catch (Exception dfsf){

    val.setKeyEstado6("nodefinido");val.setKeyEstado7("nodefinido");val.setKeyEstado8("nodefinido");
    val.setKeyEstado9("nodefinido");val.setKeyEstado10("nodefinido");val.setKeyEstado11("nodefinido");val.setKeyEstado12("nodefinido");
    val.setKeyParticipante6("nodefinido"); val.setKeyParticipante7("nodefinido"); val.setKeyParticipante8("nodefinido"); val.setKeyParticipante9("nodefinido");
    val.setKeyParticipante10("nodefinido"); val.setKeyParticipante11("nodefinido"); val.setKeyParticipante12("nodefinido");
    val.setKeyCalabozolvl6("nodefinido");val.setKeyCalabozolvl7("nodefinido");val.setKeyCalabozolvl8("nodefinido");
    val.setKeyCalabozolvl9("nodefinido");val.setKeyCalabozolvl10("nodefinido");val.setKeyCalabozolvl1("nodefinido");val.setKeyCalabozolvl12("nodefinido");
    val.setKeyDuelista2("nodefinido");

    if(val.getKeyConteo().equals("5")){
        if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
            Toast.makeText(getApplicationContext(), val.getKeyEstado5()+"   Su rival no se ha definido" , Toast.LENGTH_SHORT).show();
        }
    }else{
        if(val.getKeyConteo().equals("9")){
            if (val.getKeyCalabozolvl9().equals(val.getKeyNick())) {
                Toast.makeText(getApplicationContext(), val.getKeyEstado5()+"   Su rival no se ha definido" , Toast.LENGTH_SHORT).show();
            }
        }else{
            if(val.getKeyConteo().equals("11")){
                if (val.getKeyCalabozolvl11().equals(val.getKeyNick())) {
                    Toast.makeText(getApplicationContext(), val.getKeyEstado5()+"   Su rival no se ha definido" , Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "    Bienvenido visitante    ", Toast.LENGTH_SHORT).show();
            }
        }
    }






}


     }}});



    }

    public void llamadaPoliticas(View dsfs){
        contexto = this;
        new detlles_politicas_dungeon(contexto);
    }
    public void llamadainfo(View dsfs){
        contexto = this;
        new detlles_info_lose(contexto);
    }



}