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

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class detlles_gener_reino {

    FirebaseFirestore bdNeutro;
    TextView l1,l2;

    public detlles_gener_reino(Context context1){


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_generar_reino);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        l1 = (TextView) dialog.findViewById(R.id.generar_l1);
        l2 = (TextView) dialog.findViewById(R.id.genere_l2);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.reporte_b1);
        contexto val = new contexto();
        bdNeutro = FirebaseFirestore.getInstance();
        try {
            l2.setText(String.valueOf(val.getKeyFich1()));
        }catch (Exception jkj){
            l2.setText("0");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


       int numeroAleatorio = (int) (Math.random() * 9999 + 999);
       try {
           l1.setText(String.valueOf(numeroAleatorio));
       }catch (Exception FSF){
           Toast.makeText(context1.getApplicationContext(), "CODIGO: " + numeroAleatorio, Toast.LENGTH_SHORT).show();
       }
       bdNeutro.collection("BDreino").document(val.getKeySiguienteN1()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
       @Override
       public void onSuccess(DocumentSnapshot documentSnapshot) {

       val.setKeyBloqueo1(documentSnapshot.getString("keyGenerate")) ;

       if(!val.getKeyBloqueo1().contains("resibir")){
           Toast.makeText(context1.getApplicationContext(), "No se puede generar otro codigo hasta que el rival lo consuma.", Toast.LENGTH_SHORT).show();
       }else{

        bdNeutro.collection("BDreino").whereEqualTo("nick",val.getKeyDuelista2()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()){
            
       for (QueryDocumentSnapshot document : task.getResult()) {

       val.setKeyCodigo2(document.getString("codigo"));
}

}

        HashMap<String,Object> dato = new HashMap<>();
        dato.put("keyGenerate_"+val.getKeyDuelista2(),String.valueOf(numeroAleatorio));
        dato.put("keyGenerate",val.getKeyDuelista2());
            dato.put("keyOcupado","si");
        bdNeutro.collection("BDreino").document(val.getKeyCodigo2()).update(dato);
 }});
       }
}});}
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
