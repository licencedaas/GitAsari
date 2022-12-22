package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
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

import java.util.HashMap;

public class detlles_tabla_equipos_under {

    FirebaseFirestore bdNeutro;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    int contadorParticipantes=0;
    private AdView mAdView;

    public detlles_tabla_equipos_under(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_tabla_equipos_regisrtrados);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.cerrar_under_equipos);//asutebcua_b1
     //   ImageButton b1 = (ImageButton) dialog.findViewById(R.id.asutebcua_b1);//lose_politicas
        
        contexto val = new contexto();

        l1=(TextView) dialog.findViewById(R.id.under_visor_l1);
        l2=(TextView) dialog.findViewById(R.id.under_visor_l2);
        l3=(TextView) dialog.findViewById(R.id.under_visor_l3);
        l4=(TextView) dialog.findViewById(R.id.under_visor_l4);
        l5=(TextView) dialog.findViewById(R.id.under_visor_l5);
        l6=(TextView) dialog.findViewById(R.id.under_visor_l6);
        l7=(TextView) dialog.findViewById(R.id.under_visor_l7);
        l8=(TextView) dialog.findViewById(R.id.under_visor_l8);



        MobileAds.initialize(context1.getApplicationContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = dialog.findViewById(R.id.adViewvisorunder);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        bdNeutro = FirebaseFirestore.getInstance();
       // b1.setVisibility(View.GONE);
      //  try { if (val.getKeyPermisoInicio().equals("TRUE")) { b1.setVisibility(View.VISIBLE); } }catch (Exception dfs){}

        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){

                    val.setKeyEquipo1(documentSnapshot.getString("equipo1Titulo1"));
                    val.setKeyEquipo2(documentSnapshot.getString("equipo2Titulo1"));
                    val.setKeyEquipo3(documentSnapshot.getString("equipo3Titulo1"));
                    val.setKeyEquipo4(documentSnapshot.getString("equipo4Titulo1"));
                    val.setKeyEquipo5(documentSnapshot.getString("equipo5Titulo1"));
                    val.setKeyEquipo6(documentSnapshot.getString("equipo6Titulo1"));
                    val.setKeyEquipo7(documentSnapshot.getString("equipo7Titulo1"));
                    val.setKeyEquipo8(documentSnapshot.getString("equipo8Titulo1"));


                    l1.setText(val.getKeyEquipo1());
                    l2.setText(val.getKeyEquipo2());
                    l3.setText(val.getKeyEquipo3());
                    l4.setText(val.getKeyEquipo4());
                    l5.setText(val.getKeyEquipo5());
                    l6.setText(val.getKeyEquipo6());
                    l7.setText(val.getKeyEquipo7());
                    l8.setText(val.getKeyEquipo8());

/*
contadorParticipantes=1;


                    if(val.getKeyParticipanteLose1().equals("eperando")){
                        l1.setText("");
                    }else{ l1.setText(val.getKeyParticipanteLose1()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose2().equals("eperando")){
                        l2.setText("");
                    }else{ l2.setText(val.getKeyParticipanteLose2());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose3().equals("eperando")){
                        l3.setText("");
                    }else{ l3.setText(val.getKeyParticipanteLose3()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose4().equals("eperando")){
                        l4.setText("");
                    }else{ l4.setText(val.getKeyParticipanteLose4()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose5().equals("eperando")){
                        l5.setText("");
                    }else{ l5.setText(val.getKeyParticipanteLose5());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose6().equals("eperando")){
                        l6.setText("");
                    }else{ l6.setText(val.getKeyParticipanteLose6());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose7().equals("eperando")){
                        l7.setText("");
                    }else{ l7.setText(val.getKeyParticipanteLose7());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose8().equals("eperando")){
                        l8.setText("");
                    }else{ l8.setText(val.getKeyParticipanteLose8());contadorParticipantes++; }
                    if(val.getKeyParticipanteLose9().equals("eperando")){
                        l9.setText("");
                    }else{ l9.setText(val.getKeyParticipanteLose9()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose10().equals("eperando")){
                        l10.setText("");
                    }else{ l10.setText(val.getKeyParticipanteLose10()); contadorParticipantes++;}
                    if(val.getKeyParticipanteLose11().equals("eperando")){
                        l11.setText("");
                    }else{ l11.setText(val.getKeyParticipanteLose11());contadorParticipantes++; }


                    contadorParticipantes = contadorParticipantes-1;
*/
                }

            }
        });



        


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorParticipantes=0;
                dialog.dismiss();

            }
        });

        dialog.show();

    }







}
