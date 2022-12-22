package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class detlles_registro_deck_arquetipo_kuribo {

    FirebaseFirestore bdNeutro;
    private  VideoView v1;


    public detlles_registro_deck_arquetipo_kuribo(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_registrodeck_arquetipo_kuribo);



        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.deck_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.deck_b1);
        ImageButton b2 = (ImageButton) dialog.findViewById(R.id.deck_b2);
        EditText t1 = (EditText) dialog.findViewById(R.id.deck_t1);
        TextView l1 = (TextView) dialog.findViewById(R.id.deck_l1);


        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();




        bdNeutro.collection("BDcalabozo").document("ArqKuriDeckRegist").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

                    val.setKeyExiste(documentSnapshot.getString("deck"+val.getKeyNick()));
l1.setText(val.getKeyExiste());
                }else{
                    l1.setText("NO HAY DECK REGISTRADO");

                    HashMap<String, Object> dato4 = new HashMap<>();
                    dato4.put("REGISTRO","DECK");
                    bdNeutro.collection("BDcalabozo").document("ArqKuriDeckRegist").update(dato4);
                }
            }});


                    b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (t1.getText().toString().equals("")){
                    Toast.makeText(context1.getApplicationContext(), "BEBE INGRESA EL NOMBRE DEL DECK", Toast.LENGTH_SHORT).show();
                }else{

    bdNeutro.collection("BDcalabozo").document("ArqKuriDeckRegist").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

          if(documentSnapshot.exists()){


              HashMap<String,Object> dato = new HashMap<>();
              dato.put("deck"+val.getKeyNick(),t1.getText().toString());
              bdNeutro.collection("BDcalabozo").document("ArqKuriDeckRegist").update(dato);
              l1.setText(t1.getText().toString());
          }else{


              Toast.makeText(context1.getApplicationContext(), "Existem datps ", Toast.LENGTH_SHORT).show();
          }
        }
    }) ;}
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (t1.getText().toString().equals("")){
                    Toast.makeText(context1.getApplicationContext(), "BEBE INGRESA EL NUEVO NOMBRE DEL DECK", Toast.LENGTH_SHORT).show();
                }else{

                    bdNeutro.collection("BDcalabozo").document("ArqKuriDeckRegist").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if(documentSnapshot.exists()){

                                val.setKeyExiste(documentSnapshot.getString("deck"+val.getKeyNick()));
                                l1.setText("DECK ELIMINADO -DELET: "+val.getKeyExiste());

                                HashMap<String,Object> dato = new HashMap<>();
                                dato.put("deck"+val.getKeyNick(),t1.getText().toString());
                                bdNeutro.collection("BDcalabozo").document("ArqKuriDeckRegist").update(dato);
                                Toast.makeText(context1.getApplicationContext(), "DECK GUARDADO CON EXITO: "+ t1.getText().toString(), Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context1.getApplicationContext(), "No Existem datps ", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }) ;}
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
