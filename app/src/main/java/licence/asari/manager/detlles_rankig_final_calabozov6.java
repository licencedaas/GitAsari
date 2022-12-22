package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class detlles_rankig_final_calabozov6 {

    FirebaseFirestore bdNeutro;
   TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;


    public detlles_rankig_final_calabozov6(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_ranking_calabozov6_final);

        contexto val = new contexto();
        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        bdNeutro = FirebaseFirestore.getInstance();

        l1 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l1);
        l2 =(TextView)dialog.findViewById(R.id.finalista_dungeo_la);
        l3 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l2);
        l4 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l3);
        l5 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l4);
        l6 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l5);
        l7 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l6);
        l8 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l7);
        l9 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l8);
        l10 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l9);
        l11 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l10);
        l12 =(TextView)dialog.findViewById(R.id.finalista_dungeo_l11);

        bdNeutro.collection("BDcalabozo").document("finalistaDungeonXyzV6Mensual").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists()){


                    val.setKeyFinalista01(documentSnapshot.getString("enero"));
                    val.setKeyFinalista02(documentSnapshot.getString("febrero"));
                    val.setKeyFinalista03(documentSnapshot.getString("marzo"));
                    val.setKeyFinalista04(documentSnapshot.getString("abril"));
                    val.setKeyFinalista05(documentSnapshot.getString("mayo"));
                    val.setKeyFinalista06(documentSnapshot.getString("junio"));
                    val.setKeyFinalista07(documentSnapshot.getString("julio"));
                    val.setKeyFinalista08(documentSnapshot.getString("agosto"));
                    val.setKeyFinalista09(documentSnapshot.getString("setptiembre"));
                    val.setKeyFinalista10(documentSnapshot.getString("octubre"));
                    val.setKeyFinalista11(documentSnapshot.getString("noviembre"));
                    val.setKeyFinalista12(documentSnapshot.getString("diciembre"));

                    l1.setText(val.getKeyFinalista01());
                    l2.setText(val.getKeyFinalista02());
                    l3.setText(val.getKeyFinalista03());
                    l4.setText(val.getKeyFinalista04());
                    l5.setText(val.getKeyFinalista05());
                    l6.setText(val.getKeyFinalista06());
                    l7.setText(val.getKeyFinalista07());
                    l8.setText(val.getKeyFinalista08());
                    l9.setText(val.getKeyFinalista09());
                    l10.setText(val.getKeyFinalista10());
                    l11.setText(val.getKeyFinalista11());
                    l12.setText(val.getKeyFinalista12());
                }
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
