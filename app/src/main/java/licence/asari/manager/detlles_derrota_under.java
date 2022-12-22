package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class detlles_derrota_under {

    FirebaseFirestore bdNeutral;
    private  VideoView v1;


    public detlles_derrota_under(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_derrota_under);


        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        bdNeutral = FirebaseFirestore.getInstance();
        contexto val = new contexto();

        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.serrota_under);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bdNeutral.collection("BDcalabozo").document("InfoUnderInfo").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if (documentSnapshot.exists()) {
                            HashMap<String, Object> dato1 = new HashMap<>();
                            dato1.put("nickReport",val.getKeyNick()+" = DERROTA");

                            bdNeutral.collection("BDcalabozo").document("InfoUnderInfo").update(dato1);
                            Toast.makeText(context1.getApplicationContext(), "REPORTE CREADO CON EXITO", Toast.LENGTH_SHORT).show();
                        }
                    }});

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
