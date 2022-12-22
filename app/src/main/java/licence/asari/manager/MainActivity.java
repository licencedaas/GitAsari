package licence.asari.manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {


    private EditText t1_segting;
    private ImageButton b1_segting;
    private  VideoView v1;
    FirebaseFirestore bdNeutro;

    private int contador =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setTheme(R.style.splashTheme);
    bdNeutro = FirebaseFirestore.getInstance();

    v1 = (VideoView)  findViewById(R.id.intro);

    v1.setVideoURI(Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.intro));
    v1.start();
}






  public void inicio (View uno){



    try{

        bdNeutro.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
  public void onSuccess(DocumentSnapshot documentSnapshot) {


  if(documentSnapshot.exists()){
      Toast.makeText(getApplicationContext(), "Recuerda activar los datos o wifi.   ESPERE.....", Toast.LENGTH_SHORT).show();

  contexto val = new contexto();

      val.setKeyExiste(documentSnapshot.getString("acceso5"));

  if(val.getKeyExiste().equals("on")){
      Intent sguiente = new Intent(getApplicationContext(), Mantenimiento.class);
      startActivity(sguiente);
}else{
      Intent sguiente =new Intent(getApplicationContext(), MainActivity2.class);
      startActivity(sguiente);

}


  }

  }
  });

}catch (Exception sdfs){}





  }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

      if(keyCode == event.KEYCODE_BACK){

          AlertDialog.Builder builder = new AlertDialog.Builder(this);
          builder.setMessage("Deseas  salir de Asary").setPositiveButton("si", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
             Intent  siguiente = new Intent(Intent.ACTION_MAIN);
             siguiente.addCategory(Intent.CATEGORY_HOME);
             siguiente .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             startActivity(siguiente);
}



          }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {

             dialog.dismiss();


              }
          });
          builder.show();
      }

        return super.onKeyDown(keyCode, event);
    }

    String enlace="https://1drv.ms/w/s!AtFD3lY_6B3Pk1Sju6BY4a3dmaRj?e=ZW7mx6";

    public void enlace(View sdfs){

        Uri url = Uri.parse(enlace);
        Intent siguiente = new Intent(Intent.ACTION_VIEW,url);
        startActivity(siguiente);

    }

    public void grup(View sdfas) {

        Intent siguiente = new Intent(this, sentinGremio.class);
        startActivity(siguiente);
    }

}