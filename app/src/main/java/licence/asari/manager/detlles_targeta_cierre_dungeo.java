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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;


public class detlles_targeta_cierre_dungeo {

    FirebaseFirestore bdNeutro;



    public detlles_targeta_cierre_dungeo(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_cierre_dungeo_xyz);

        contexto val = new contexto();
        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.random_xyz_cerrar);//calabozo_b4



        bdNeutro = FirebaseFirestore.getInstance();


        TextView l1 =(TextView) dialog.findViewById(R.id.punto_final_l1);
        TextView l2 =(TextView) dialog.findViewById(R.id.punto_final_l2);
        TextView l3 =(TextView) dialog.findViewById(R.id.punto_final_l3);
        TextView l4 =(TextView) dialog.findViewById(R.id.punto_final_l4);


        l1.setText(val.getKeyParticipante1());
        l2.setText("PS TOTALES: "+val.getKeyEstado1());

        bdNeutro.collection("BDcalabozo").document("TierList").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

            if(documentSnapshot.exists()){

            val.setKeyTier1(documentSnapshot.getString("Deck1"));
            val.setKeyTier2(documentSnapshot.getString("Deck2"));
            val.setKeyTier3(documentSnapshot.getString("Deck3"));

                l3.setText("1TIER:"+val.getKeyTier1());

                SimpleDateFormat mes = new SimpleDateFormat("MMMM");
                String mes1= mes.format(new Date());

                HashMap<String, Object> dato = new HashMap<>();
                dato.put(mes1,val.getKeyParticipante1());

                bdNeutro.collection("BDcalabozo").document("finalistaDungeonXyzV6Mensual").update(dato);
                l4.setText(mes1);
                Toast.makeText(context1.getApplicationContext(), "FINALIZO EL TORNEO DE ESTE MES", Toast.LENGTH_SHORT).show();


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



