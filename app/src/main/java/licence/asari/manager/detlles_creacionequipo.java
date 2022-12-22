package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Stack;

public class detlles_creacionequipo {

    FirebaseFirestore bdNeutro;
    private Stack<String> idV1 = new Stack<>();
    private AdView mAdView;
    public detlles_creacionequipo(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_creacionequipo);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.confg_under_cerrar);//asutebcua_b1
        EditText t1 =(EditText) dialog.findViewById(R.id.confg_under_t1);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.confg_under_create);
        ImageButton b2 = (ImageButton) dialog.findViewById(R.id.confg_under_gene);
        ImageButton b3 = (ImageButton) dialog.findViewById(R.id.confg_under_delet);
        Spinner sp1 =(Spinner) dialog.findViewById(R.id.confg_under_sp);
        contexto val = new contexto();

         bdNeutro = FirebaseFirestore.getInstance();
        sp1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        t1.setVisibility(View.GONE);


        MobileAds.initialize(context1.getApplicationContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = dialog.findViewById(R.id.adViewcreateunder);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                sp1.setVisibility(View.VISIBLE);
                b1.setVisibility(View.GONE);

                try {

                    sp1.setAdapter(calabozo_v4.datos);
                }catch (Exception sdfs){}
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.GONE);
            }
        });








b2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if(t1.getText().toString().equals("")){
Toast.makeText(context1.getApplicationContext(), "Debes ingresar el nombre de su equipo.", Toast.LENGTH_SHORT).show();
}else{

val.setKeyDuelista2(sp1.getSelectedItem().toString());

if(val.getKeyDuelista2().equals("Seleccione")){
Toast.makeText(context1.getApplicationContext(), "Debes elegir un compañero", Toast.LENGTH_SHORT).show();
}else{
 try {
bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

if (documentSnapshot.exists()) {


    val.setKeyEquipo1(documentSnapshot.getString("equipo1Titulo1"));
    val.setKeyEquipo2(documentSnapshot.getString("equipo2Titulo1"));
    val.setKeyEquipo3(documentSnapshot.getString("equipo3Titulo1"));
    val.setKeyEquipo4(documentSnapshot.getString("equipo4Titulo1"));
    val.setKeyEquipo5(documentSnapshot.getString("equipo5Titulo1"));
    val.setKeyEquipo6(documentSnapshot.getString("equipo6Titulo1"));
    val.setKeyEquipo7(documentSnapshot.getString("equipo7Titulo1"));
    val.setKeyEquipo8(documentSnapshot.getString("equipo8Titulo1"));
    val.setKeyEquipo9(documentSnapshot.getString("equipo9Titulo1"));
    val.setKeyEquipo10(documentSnapshot.getString("equipo10Titulo1"));

     HashMap<String, Object> dato1 = new HashMap<>();
    if(val.getKeyEquipo1().equals("esperando")){
     dato1.put("equipo1Titulo1",t1.getText().toString());
     dato1.put("equipo1Participante1",val.getKeyNick());
     dato1.put("equipo1Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 1 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo2().equals("esperando")){
    dato1.put("equipo2Titulo1",t1.getText().toString());
    dato1.put("equipo2Participante1",val.getKeyNick());
    dato1.put("equipo2Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 2 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo3().equals("esperando")){
    dato1.put("equipo3Titulo1",t1.getText().toString());
    dato1.put("equipo3Participante1",val.getKeyNick());
    dato1.put("equipo3Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 3 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo4().equals("esperando")){
    dato1.put("equipo4Titulo1",t1.getText().toString());
    dato1.put("equipo4Participante1",val.getKeyNick());
    dato1.put("equipo4Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 4 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo5().equals("esperando")){
    dato1.put("equipo5Titulo1",t1.getText().toString());
    dato1.put("equipo5Participante1",val.getKeyNick());
    dato1.put("equipo5Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 5 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo6().equals("esperando")){
    dato1.put("equipo6Titulo1",t1.getText().toString());
    dato1.put("equipo6Participante1",val.getKeyNick());
    dato1.put("equipo6Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 6 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo7().equals("esperando")){
    dato1.put("equipo7Titulo1",t1.getText().toString());
    dato1.put("equipo7Participante1",val.getKeyNick());
    dato1.put("equipo7Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 7 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo8().equals("esperando")){
    dato1.put("equipo8Titulo1",t1.getText().toString());
    dato1.put("equipo8Participante1",val.getKeyNick());
    dato1.put("equipo8Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 8 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo9().equals("esperando")){
    dato1.put("equipo9Titulo1",t1.getText().toString());
    dato1.put("equipo9Participante1",val.getKeyNick());
    dato1.put("equipo9Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 9 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }else{
    if(val.getKeyEquipo10().equals("esperando")){
    dato1.put("equipo10Titulo1",t1.getText().toString());
    dato1.put("equipo10Participante1",val.getKeyNick());
    dato1.put("equipo10Participante2",val.getKeyDuelista2());
        bdNeutro.collection("BDcalabozo").document("InfoUnderCreate").update(dato1);
        Toast.makeText(context1.getApplicationContext(), "EQUIPO 10 CREADOR CON EXITO", Toast.LENGTH_SHORT).show();
    }
    }
    }
    }
    }
    }
    }
    }

    }

    

    }


}
}
});

}catch (Exception dfdsdf){}
}
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
