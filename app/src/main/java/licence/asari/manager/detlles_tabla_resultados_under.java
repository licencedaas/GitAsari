package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class detlles_tabla_resultados_under {

    FirebaseFirestore bdNeutro;

    public detlles_tabla_resultados_under(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_tabla_resultados_under);



       ImageView cerrar = (ImageView) dialog.findViewById(R.id.under_tabla_cerrar);



        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();







HashMap<String,Object> dato = new HashMap<>();






        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }



}
