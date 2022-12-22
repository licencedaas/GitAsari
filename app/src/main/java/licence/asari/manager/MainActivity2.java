package licence.asari.manager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.content.Context;
import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Calendar;

import java.util.Stack;


import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity2 extends AppCompatActivity {

    EditText t6,t7;
    TextView l1;
    public static Stack<String> idV1 = new Stack <String>  ();
    public static Stack<String> idV2 = new Stack <String>  ();
    public static Stack<String> idV3 = new Stack <String>  ();
    String codigo, searhPass1,searhNick, contraseña, cdGremio, seccion="false", dimenAzul, succeles="false",succeles1="false";
    int searchPass, contadorEntrada=0,searchCodigo=0, ingreso;
    FirebaseFirestore bdNeutral, bdAzul,gremio;
    String codigo1,pass1,pass2,key ;
    private AdView mAdView;
    int TimeH=0,Timemm=0,Timesg=0;
    Thread iniReloj=null;

    Calendar c=null;
    contexto  val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t6=(EditText) findViewById(R.id.t6);
        t7=(EditText) findViewById(R.id.t7);//horaStand2




        val = new contexto();

        c = Calendar.getInstance();

        bdNeutral = FirebaseFirestore.getInstance();
        bdAzul = FirebaseFirestore.getInstance();
        gremio = FirebaseFirestore.getInstance();


        try { val.setKeyNick(getIntent().getStringExtra("nick"));val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio")); }catch (Exception  sdfs){}

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
        @Override
        public void onInitializationComplete(InitializationStatus initializationStatus) {
        }});

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);//ca-app-pub-5746550188084225/2445876309

        //PRUEVA ca-app-pub-3940256099942544/6300978111

}
    public void iniciarseccion(View fddf){

        val = new contexto();

if(t6.getText().toString().equals("")&&t7.getText().toString().equals("") ){
Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_SHORT).show();
}else{
searhNick = t6.getText().toString();
if (t6.getText().toString().contains("gb-")) {
searhNick = searhNick.replace("gb-", ""); }

searhNick.trim();//quita los espacios del final y del principio
searhNick = searhNick.replace(" ", "");

bdNeutral.collection("BDAsary").document(searhNick).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
@Override
public void onSuccess(DocumentSnapshot documentSnapshot) {

if(documentSnapshot.exists()){

val.setKeyCodigo(documentSnapshot.getString("codigo"));
val.setKeyNick(documentSnapshot.getString("nick"));
val.setKeypass(documentSnapshot.getString("pass"));
val.setKeyPermisoInicio(documentSnapshot.getString("fx"));


if (t6.getText().toString().contains("gb-")) {
    Toast.makeText(getApplicationContext(), "ENTRANDO MODO ADMIN", Toast.LENGTH_SHORT).show();
val.setKeyGb("gb-" + val.getKeyNick());

if (t6.getText().toString().equals(val.getKeyGb())) {
    Toast.makeText(getApplicationContext(), "VEERIFICANDO ACCESO KEY1", Toast.LENGTH_SHORT).show();
if (t7.getText().toString().equals(val.getKeypass())) {
    Toast.makeText(getApplicationContext(), "VEERIFICANDO ACCESO KEY2", Toast.LENGTH_SHORT).show();
if (val.getKeyPermisoInicio().contains("TRUE")) {
    Toast.makeText(getApplicationContext(), "VEERIFICANDO ACCESO KEY3", Toast.LENGTH_SHORT).show();
t6.setText("");
t7.setText("");

Toast.makeText(getApplicationContext(), "Bienvenido Master", Toast.LENGTH_SHORT).show();

Intent siguiente = new Intent(getApplicationContext(), UsuarioGb.class);
siguiente.putExtra("nick", val.getKeyNick());
siguiente.putExtra("cdGremio", val.getKeyCodigo());
startActivity(siguiente);

}
}else{ Toast.makeText(getApplicationContext(), "Contraseña invalida. pida confirmacion de pass con su lider gremio.", Toast.LENGTH_SHORT).show();
}}


}else {
if (searhNick.equals(val.getKeyNick())) {
if (t7.getText().toString().equals(val.getKeypass())) {
bdAzul.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
 public void onSuccess(DocumentSnapshot documentSnapshot) {
if (documentSnapshot.exists()) {
    val.setSearKeyCodigo(Integer.parseInt(val.getKeyCodigo()));

    if(val.getSearKeyCodigo() > 100  && val.getSearKeyCodigo() < 600) {
        val.setKeyEscaneoGrenio("azul");
        val.setKeyIdGremio("100");
    }else{
        if(val.getSearKeyCodigo() > 1100  && val.getSearKeyCodigo() < 1600) {
            val.setKeyEscaneoGrenio("rojo");
            val.setKeyIdGremio("1100");
        }else{
            if(val.getSearKeyCodigo() > 2100  && val.getSearKeyCodigo() < 2600) {
                val.setKeyEscaneoGrenio("naranja");val.setKeyIdGremio("2100");
            }else{
                if(val.getSearKeyCodigo() > 3100  && val.getSearKeyCodigo() < 3600) {
                    val.setKeyEscaneoGrenio("negro");val.setKeyIdGremio("3100");
                }else {
                    if (val.getSearKeyCodigo() > 4100 && val.getSearKeyCodigo() < 4600) {
                        val.setKeyEscaneoGrenio("calido");val.setKeyIdGremio("4100");
                    }}}}}

    val.setKeySalaActiva(documentSnapshot.getString("KeyprivateCd"+ val.getKeyIdGremio()));
    val.setKeyTorneoActivo(documentSnapshot.getString("torneoActivo"+ val.getKeyIdGremio()));

    Toast.makeText(getApplicationContext(), "CODIGO GREMIO: " +  val.getKeySalaActiva() + "   TORNEO ACTIVO: "+ val.getKeyTorneoActivo(), Toast.LENGTH_SHORT).show();

if(val.getKeySalaActiva().equals(val.getKeyIdGremio())) {
if (val.getKeyTorneoActivo().equals("dungeonxyz")) {

    Toast.makeText(getApplicationContext(), "Creando contenido...", Toast.LENGTH_SHORT).show();
    val.setKeycEntadaCalabozo("");
    llamadoCalabozo();
    Toast.makeText(getApplicationContext(), "Bienvenido Torneo eliminatorias Dungeon xyz", Toast.LENGTH_SHORT).show();
}else{
if(val.getKeyTorneoActivo().equals("arquetipokurivo")){
    Toast.makeText(getApplicationContext(), "Bienvenido Torneo eliminatorias ARQUETIPO KURIBOH", Toast.LENGTH_SHORT).show();
    llamadoArquetipoKuriboh();
}
}
}else{
    t6.setText("");
    t7.setText("");
    Toast.makeText(getApplicationContext(), "Bienvenido a su cuenta", Toast.LENGTH_SHORT).show();
    Intent siguiente = new Intent(getApplicationContext(), UsuarioStandar.class);
    siguiente.putExtra("nick", val.getKeyNick());
    siguiente.putExtra("cdGremio", val.getKeyCodigo());
    startActivity(siguiente);
}


}
}});
}else{
    Toast.makeText(getApplicationContext(), "Contraseña invalida. pida confirmacion de pass con su lider gremio.", Toast.LENGTH_SHORT).show();
}



}
}
}else{
    Toast.makeText(getApplicationContext(), "No se encuentra este usuario.", Toast.LENGTH_SHORT).show();
}
}
});


}

}


    Context contexto;

    public void llamadaReporteHelp(View sdfsf){
        contexto = this;
        new detlles_default(contexto);
    }



    public void llamadoCalabozo(){
        contexto = this;
        new detlles_entrada_calabozo(contexto);
    }

    public void llamadoArquetipoKuriboh(){
        contexto = this;
        new detlles_entrada_arquetipo_kuriboh(contexto);
    }




    public void registroNuevoUsuario(View dos){

        Intent siguiente = new Intent(this,RegistroNuevo.class);
        startActivity(siguiente);

    }



    public void enlaceLVL6(View sdfsd) {

        contexto val = new contexto();
        bdNeutral.collection("DAAS").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {


                    Uri url = Uri.parse(documentSnapshot.getString("keyEnlaceInicial"));
                    Intent siguiente = new Intent(Intent.ACTION_VIEW, url);
                    startActivity(siguiente);
                }
            }
        });
    }







}

