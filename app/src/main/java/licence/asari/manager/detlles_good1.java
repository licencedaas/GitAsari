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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class detlles_good1 {

    FirebaseFirestore bdNeutro;


    public detlles_good1(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_good_detalles1);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        TextView t1 = (TextView) dialog.findViewById(R.id.det_t1);
        TextView t2 = (TextView) dialog.findViewById(R.id.det_t2);
        TextView t3 = (TextView) dialog.findViewById(R.id.det_t3);
        TextView t4 = (TextView) dialog.findViewById(R.id.det_t4);


        TextView v1 = (TextView) dialog.findViewById(R.id.det_v1);
        TextView v2 = (TextView) dialog.findViewById(R.id.det_v2);
        TextView v3 = (TextView) dialog.findViewById(R.id.det_v3);
        TextView v4 = (TextView) dialog.findViewById(R.id.det_v4);
        TextView v5 = (TextView) dialog.findViewById(R.id.det_v5);
        TextView v6 = (TextView) dialog.findViewById(R.id.det_v6);

        TextView b1 = (TextView) dialog.findViewById(R.id.det_b1);
        TextView b2 = (TextView) dialog.findViewById(R.id.det_b2);


        TextView n1 = (TextView) dialog.findViewById(R.id.det_n1);
        TextView n2 = (TextView) dialog.findViewById(R.id.det_n2);

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        Toast.makeText(context1.getApplicationContext(), "codigo: " +val.getKeySiguienteN1() , Toast.LENGTH_SHORT).show();

       bdNeutro.collection("goodVBatle").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
           @Override
           public void onSuccess(DocumentSnapshot documentSnapshot) {

          val.setKeyVictGood1(documentSnapshot.getString("VDduelo1_1"));val.setKeyVictGood2(documentSnapshot.getString("VDduelo2_2"));
          val.setKeyVictGood3(documentSnapshot.getString("VDduelo3_3"));
               val.setKeyVictGood4(documentSnapshot.getString("VDduelo4_4"));

               t1.setText(val.getKeyDerrotGood1());t2.setText(val.getKeyDerrotGood2());t3.setText(val.getKeyDerrotGood3());t4.setText(val.getKeyDerrotGood4());


                val.setKeyDerrotGood1(documentSnapshot.getString("Dduelo1_1"));val.setKeyDerrotGood1(documentSnapshot.getString("Dduelo1_1"));
               val.setKeyDerrotGood1(documentSnapshot.getString("Dduelo1_1"));val.setKeyDerrotGood2(documentSnapshot.getString("Dduelo2_2"));
               val.setKeyDerrotGood3(documentSnapshot.getString("Dduelo3_3"));val.setKeyDerrotGood4(documentSnapshot.getString("Dduelo4_4"));
               val.setKeyDerrotGood5(documentSnapshot.getString("Dduelo5_5"));val.setKeyDerrotGood6(documentSnapshot.getString("Dduelo6_6"));

               v1.setText(val.getKeyVictGood1());v2.setText(val.getKeyVictGood2());v3.setText(val.getKeyVictGood3());v4.setText(val.getKeyVictGood4());
               v5.setText(val.getKeyVictGood5());v6.setText(val.getKeyVictGood6());


               /*

               val.setKeyVictGood5(documentSnapshot.getString("VDduelo5_5"));
               val.setKeyVictGood6(documentSnapshot.getString("VDduelo6_6"));
                */


           }
       })  ;

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }







}
