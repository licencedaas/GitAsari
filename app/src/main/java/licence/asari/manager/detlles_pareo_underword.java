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
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class detlles_pareo_underword {

    FirebaseFirestore bdNeutro;


    public detlles_pareo_underword(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_underword_pareo);




        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.under_cerrar);
       ImageButton b3 = (ImageButton) dialog.findViewById(R.id.equipo3);
        b3.setVisibility(View.GONE);

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();






    TextView vs_l1 = (TextView) dialog.findViewById(R.id.vs_estado1);
    TextView Est_l1 = (TextView) dialog.findViewById(R.id.under_l1);
    TextView vs_l2 = (TextView) dialog.findViewById(R.id.vs_estado2);
    TextView Est_l2 = (TextView) dialog.findViewById(R.id.under_l2);
    TextView vs_l3 = (TextView) dialog.findViewById(R.id.vs_estado3);
    TextView Est_l3 = (TextView) dialog.findViewById(R.id.under_l3);
    TextView vs_l4 = (TextView) dialog.findViewById(R.id.vs_estado4);
    TextView Est_l4 = (TextView) dialog.findViewById(R.id.under_l4);
    TextView vs_l5 = (TextView) dialog.findViewById(R.id.vs_estado5);
    TextView vs_l6 = (TextView) dialog.findViewById(R.id.vs_estado6);



        TextView Est_l5 =(TextView) dialog.findViewById(R.id.under_l5);
        TextView Est_l6 =(TextView) dialog.findViewById(R.id.under_l6);
        TextView Est_l10 =(TextView) dialog.findViewById(R.id.vs_estado5);
        TextView Est_l11 =(TextView) dialog.findViewById(R.id.vs_estado6);

        ImageView Est_vie_l10 =(ImageView) dialog.findViewById(R.id.imag5_estado);
        ImageView Est_vie_l11 =(ImageView) dialog.findViewById(R.id.imag6_estado);
        ImageView Est_vie_l12 =(ImageView) dialog.findViewById(R.id.imag7_estado);
        ImageView Est_vie_l13 =(ImageView) dialog.findViewById(R.id.imag8_estado);


         Est_l5.setVisibility(View.GONE);
         Est_l6.setVisibility(View.GONE);
         Est_l10.setVisibility(View.GONE);
         Est_l11.setVisibility(View.GONE);
         Est_vie_l10.setVisibility(View.GONE);
         Est_vie_l11.setVisibility(View.GONE);
         Est_vie_l12.setVisibility(View.GONE);
         Est_vie_l13.setVisibility(View.GONE);

try{
        bdNeutro.collection("BDcalabozo").document("InfoUnderInfo").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {
                    Toast.makeText(context1.getApplicationContext(), "INICIANDO PAREOS", Toast.LENGTH_SHORT).show();
                    val.setKeyNGrupos(documentSnapshot.getString("keyNGrupos"));
                    val.setKeyJ2(Integer.parseInt(val.getKeyNGrupos()));

                    val.setKeyEquipo1(documentSnapshot.getString("keyequipo1"));
                    val.setKeyEquipo2(documentSnapshot.getString("keyequipo2"));
                    val.setKeyEquipo3(documentSnapshot.getString("keyequipo3"));
                    val.setKeyEquipo4(documentSnapshot.getString("keyequipo4"));

                    val.setKeyVsEquipo1(documentSnapshot.getString("keyVsEquipo1"));
                    val.setKeyVsEquipo2(documentSnapshot.getString("keyVsEquipo2"));
                    val.setKeyVsEquipo3(documentSnapshot.getString("keyVsEquipo3"));
                    val.setKeyVsEquipo4(documentSnapshot.getString("keyVsEquipo4"));

                    Toast.makeText(context1.getApplicationContext(), "INICIANDO:"+val.getKeyEquipo1(), Toast.LENGTH_SHORT).show();

                    vs_l1.setText(val.getKeyVsEquipo1());
                    Est_l1.setText(val.getKeyEquipo1());
                    vs_l2.setText(val.getKeyVsEquipo1());
                    Est_l2.setText(val.getKeyEquipo2());
                    vs_l3.setText(val.getKeyVsEquipo1());
                    Est_l3.setText(val.getKeyEquipo3());
                    vs_l4.setText(val.getKeyVsEquipo1());
                    Est_l4.setText(val.getKeyEquipo4());

if(val.getKeyJ2()==4){

}else{
if(val.getKeyJ2()==6){

    b3.setVisibility(View.VISIBLE);
    Est_l5.setVisibility(View.VISIBLE);
    Est_l6.setVisibility(View.VISIBLE);
    Est_l10.setVisibility(View.VISIBLE);
    Est_l11.setVisibility(View.VISIBLE);
    Est_vie_l10.setVisibility(View.VISIBLE);
    Est_vie_l11.setVisibility(View.VISIBLE);
    Est_vie_l12.setVisibility(View.VISIBLE);
    Est_vie_l13.setVisibility(View.VISIBLE);


    val.setKeyEquipo5(documentSnapshot.getString("keyequipo5"));
    val.setKeyEquipo6(documentSnapshot.getString("keyequipo6"));
    val.setKeyVsEquipo5(documentSnapshot.getString("keyVsEquipo5"));
    val.setKeyVsEquipo6(documentSnapshot.getString("keyVsEquipo6"));

    vs_l5.setText(val.getKeyVsEquipo5());
    Est_l5.setText(val.getKeyEquipo5());
    vs_l6.setText(val.getKeyVsEquipo6());
    Est_l6.setText(val.getKeyEquipo6());
}
}








                }
            }});
}catch (Exception dfsfdd){
    Toast.makeText(context1.getApplicationContext(), "EROR BUSQUEDA", Toast.LENGTH_SHORT).show();
}




        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }








}
