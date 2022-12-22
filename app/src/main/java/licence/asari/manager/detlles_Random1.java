package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.google.firebase.firestore.FirebaseFirestore;

public class detlles_Random1 {

    FirebaseFirestore bdNeutro;


    public detlles_Random1(Context random1){


        final Dialog dialog = new Dialog(random1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_good_detalles2);

        ImageButton cerrar1 = (ImageButton) dialog.findViewById(R.id.id_cerrar);





        bdNeutro = FirebaseFirestore.getInstance();





        cerrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }







}
