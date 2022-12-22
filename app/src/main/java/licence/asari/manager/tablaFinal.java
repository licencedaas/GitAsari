package licence.asari.manager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;




public class tablaFinal extends AppCompatActivity {


    private RecyclerView cicle;
    private ArrayList<User> datosDuelista;
    private ArrayList<UserDefaul>datosDefaul;

    FirebaseFirestore database = FirebaseFirestore.getInstance();
    FirebaseFirestore bdNeutral;
    Stack <String> idV1 = new Stack<>();
    Stack <String> idV2 = new Stack<>();
    Stack <Integer> idV3 = new Stack<>();


    int total=0;


    TreeMap<String, Integer>  datos3 = new TreeMap<>();
    LinkedHashMap<String, Integer> datos1 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos2 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos4 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos5 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos6 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos7 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos8 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos9 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos10 = new LinkedHashMap<String,Integer>();
    LinkedHashMap<String, Integer> datos11 = new LinkedHashMap<String,Integer>();


    private int contador=0,contJornadas=0;
    int total2=0;
    private Spinner sp1;
    contexto val;
    int totalPunto =0;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_final);

        cicle = findViewById(R.id.deslis1);
        datosDuelista = new ArrayList<>();
        bdNeutral = FirebaseFirestore.getInstance();
        val = new contexto();
        sp1 = (Spinner) findViewById(R.id.TablaPuntoss_p1);


        val.setKeyNick( getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
val.setKeySiguienteN2(getIntent().getStringExtra("standar"));

        if(val.getSearKeyCodigo() > 100  && val.getSearKeyCodigo() < 600) {

   bdNeutral.collection("BDgremio").document("100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
   @Override
   public void onSuccess(DocumentSnapshot documentSnapshot) {
   if(documentSnapshot.exists()) {

    val.setKeyEscaneoGrenio("azul");

   val.setKeyCodigo(documentSnapshot.getString("Id"));
   ArrayAdapter <String>  datos = null;
   idV1.add("Elija Dimencion");
   for(int a =1; a < val.getSearKeyCodigo(); a++){
   val.setKeyDimencion(documentSnapshot.getString("dimencion_"+ a));
   idV1.add(val.getKeyDimencion());
   datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);
   if(a>=4){
   sp1.setAdapter(datos);
   val.setKeyDimencion("");
   val.setSearKeyCodigo(0);
   break; } } }else{
   Toast.makeText(getApplicationContext(), "No se encuentra datos ", Toast.LENGTH_SHORT).show(); } }});

   }else{

  if(val.getSearKeyCodigo() > 1100  && val.getSearKeyCodigo() < 1600) {

      bdNeutral.collection("BDgremio").document("1100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
          @Override
          public void onSuccess(DocumentSnapshot documentSnapshot) {
              if(documentSnapshot.exists()) {

                  val.setKeyEscaneoGrenio("rojo");
                  val.setKeyCodigo(documentSnapshot.getString("Id"));
                  ArrayAdapter <String>  datos = null;
                  idV1.add("Elija Dimencion");
                  for(int a =1; a < val.getSearKeyCodigo(); a++){
                      val.setKeyDimencion(documentSnapshot.getString("dimencion_"+ a));
                      idV1.add(val.getKeyDimencion());
                      datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);
                      if(a>=4){
                          sp1.setAdapter(datos);
                          val.setKeyDimencion("");
                          val.setSearKeyCodigo(0);
                          break; } } }else{
                  Toast.makeText(getApplicationContext(), "No se encuentra datos ", Toast.LENGTH_SHORT).show(); } }});


  }else{
   if(val.getSearKeyCodigo() > 2100  && val.getSearKeyCodigo() < 2600) {

       bdNeutral.collection("BDgremio").document("2100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
           @Override
           public void onSuccess(DocumentSnapshot documentSnapshot) {
               if(documentSnapshot.exists()) {

                   val.setKeyEscaneoGrenio("naranja");
                   val.setKeyCodigo(documentSnapshot.getString("Id"));
                   ArrayAdapter <String>  datos = null;
                   idV1.add("Elija Dimencion");
                   for(int a =1; a < val.getSearKeyCodigo(); a++){
                       val.setKeyDimencion(documentSnapshot.getString("dimencion_"+ a));
                       idV1.add(val.getKeyDimencion());
                       datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);
                       if(a>=4){
                           sp1.setAdapter(datos);
                           val.setKeyDimencion("");
                           val.setSearKeyCodigo(0);
                           break; } } }else{
                   Toast.makeText(getApplicationContext(), "No se encuentra datos ", Toast.LENGTH_SHORT).show(); } }});


   }else{
  if(val.getSearKeyCodigo() > 3100  && val.getSearKeyCodigo() < 3600) {


      bdNeutral.collection("BDgremio").document("3100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
          @Override
          public void onSuccess(DocumentSnapshot documentSnapshot) {
              if(documentSnapshot.exists()) {

                  val.setKeyEscaneoGrenio("negro");
                  val.setKeyCodigo(documentSnapshot.getString("Id"));
                  ArrayAdapter <String>  datos = null;
                  idV1.add("Elija Dimencion");
                  for(int a =1; a < val.getSearKeyCodigo(); a++){
                      val.setKeyDimencion(documentSnapshot.getString("dimencion_"+ a));
                      idV1.add(val.getKeyDimencion());
                      datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);
                      if(a>=4){
                          sp1.setAdapter(datos);
                          val.setKeyDimencion("");
                          val.setSearKeyCodigo(0);
                          break; } } }else{
                  Toast.makeText(getApplicationContext(), "No se encuentra datos ", Toast.LENGTH_SHORT).show(); } }});


  }else{
  if(val.getSearKeyCodigo() > 4100  && val.getSearKeyCodigo() < 4600) {


      bdNeutral.collection("BDgremio").document("4100").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
          @Override
          public void onSuccess(DocumentSnapshot documentSnapshot) {
              if(documentSnapshot.exists()) {

                  val.setKeyEscaneoGrenio("calido");
                  val.setKeyCodigo(documentSnapshot.getString("Id"));
                  ArrayAdapter <String>  datos = null;
                  idV1.add("Elija Dimencion");
                  for(int a =1; a < val.getSearKeyCodigo(); a++){
                      val.setKeyDimencion(documentSnapshot.getString("dimencion_"+ a));
                      idV1.add(val.getKeyDimencion());
                      datos = new ArrayAdapter<>(getApplication(),R.layout.spiner_jornada_random,idV1);
                      if(a>=4){
                          sp1.setAdapter(datos);
                          val.setKeyDimencion("");
                          val.setSearKeyCodigo(0);
                          break; } } }else{
                  Toast.makeText(getApplicationContext(), "No se encuentra datos ", Toast.LENGTH_SHORT).show(); } }});



  }
  }
  }
  }

  }



        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                contexto val = new contexto();
                val.setKeyDimencion(sp1.getSelectedItem().toString());

                if(val.getKeyDimencion().contains("Elija Dimencion")){
                    Toast.makeText(getApplicationContext(), "Se debe elegir una dimencion", Toast.LENGTH_SHORT).show();
                }else{

                    if(datos1.size()== 0){

                    }else{
                        datos1.clear();datos6.clear();
                         idV2.clear();
                        datos2.clear();datos7.clear();
                        datos3.clear();datos8.clear();
                        datos4.clear();datos9.clear();
                        datos5.clear();datos11.clear();
                        resicleAdapter adap = new resicleAdapter(datosDuelista);
                        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
                        cicle.setLayoutManager(layout);
                        cicle.setItemAnimator(new DefaultItemAnimator());
                        cicle.setAdapter(adap);
                        cicle.removeAllViews();


                    }


                    info();


                }


            }@Override public void onNothingSelected(AdapterView<?> parent) {}}); }













@RequiresApi(api = Build.VERSION_CODES.N)
public void setAdapter(View sd){


        List<Map.Entry<String,Integer>> list = new ArrayList<>(datos8.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
}
        });
        User contenedor []= new User[idV2.size()];
        for(Map.Entry<String,Integer> e: list){

        String llave = datos1.get(String.valueOf(String.valueOf(e.getKey()))).toString();
        String vict = datos5.get(String.valueOf(String.valueOf(e.getKey()))).toString();
        String derrota = datos6.get(String.valueOf(String.valueOf(e.getKey()))).toString();
        String puntos = datos4.get(String.valueOf(String.valueOf(e.getKey()))).toString();
        String pContra = datos7.get(String.valueOf(String.valueOf(e.getKey()))).toString();
        String pDiferencia = datos9.get(String.valueOf(String.valueOf(e.getKey()))).toString();
        String pExtras = datos11.get(String.valueOf(String.valueOf(e.getKey()))).toString();

        datosDuelista.add(contenedor[contador] = new User("Puntos: "+e.getValue() ,"Nick: "+e.getKey(), "Partidas: "+ llave,"Victorias: "
                +vict, "Derrotas:"+derrota, "Anotaciones: "+puntos,"Puntos Contra: " + pContra, "Puntos Diferencia: "+pDiferencia,"Puntos Extras: "+ pExtras));

}

        resicleAdapter adap = new resicleAdapter(datosDuelista);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
        cicle.setLayoutManager(layout);
        cicle.setItemAnimator(new DefaultItemAnimator());
        cicle.setAdapter(adap);
        Toast.makeText(getApplicationContext(), "Proceso exitoso", Toast.LENGTH_SHORT).show();

/*

 */


}



    public void info() {

  try {
  database.collection("TablaPuntoCabeza").whereEqualTo("dimencion", val.getKeyDimencion()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
  @Override
  public void onComplete(@NonNull Task<QuerySnapshot> task) {
  if (task.isSuccessful()) {
  for (QueryDocumentSnapshot document : task.getResult()) {

      val.setKeyDuelista(document.getString("nick"));
      String r1 =document.getString("RJornada N1");



      String c1 = document.getString("CJornada N1");String c7 = document.getString("CJornada N7");
      String c2 = document.getString("CJornada N2");String c8 = document.getString("CJornada N8");
      String c3 = document.getString("CJornada N3");String c9 = document.getString("CJornada N9");
      String c4 = document.getString("CJornada N4");String c10 = document.getString("CJornada N10");
      String c5 = document.getString("CJornada N5");String c11 = document.getString("CJornada N11");
      String c6 = document.getString("CJornada N6");String c12 = document.getString("CJornada N12");

      int cSj2 = Integer.parseInt(c2), cSj3=Integer.parseInt(c3), cSj4 =Integer.parseInt(c4)
      ,cSj5 =Integer.parseInt(c5) ,cSj6 =Integer.parseInt(c6) , cSj7 =Integer.parseInt(c7), cSj8 =Integer.parseInt(c8),
      cSj9 =Integer.parseInt(c9), cSj10 =Integer.parseInt(c10), cSj11 =Integer.parseInt(c11), cSj12 =Integer.parseInt(c12)
      ,cSj1 =Integer.parseInt(c1);


      int cSj = cSj1 + cSj2 +cSj3 +cSj4 +cSj5 +cSj6 +cSj7 +cSj8 +cSj9 +cSj10 + cSj11 + cSj12;

      datos7.put(val.getKeyDuelista(),cSj);

      String d1 = document.getString("RJornada N1");String d7 = document.getString("RJornada N7");
      String d2 = document.getString("RJornada N2");String d8 = document.getString("RJornada N8");
      String d3 = document.getString("RJornada N3");String d9 = document.getString("RJornada N9");
      String d4 = document.getString("RJornada N4");String d10 = document.getString("RJornada N10");
      String d5 = document.getString("RJornada N5");String d11 = document.getString("RJornada N11");
      String d6 = document.getString("RJornada N6");String d12 = document.getString("RJornada N12");


      int dS1=0,dS2=0,dS3=0,dS4=0,dS5=0,dS6=0,dS7=0,dS8=0,dS9=0,dS10=0,dS11=0,dS12=0;

      if(c1.contains("0")){ }else{ dS1=1; }if(c7.contains("0")){ }else{ dS7=1; }
      if(c2.contains("0")){ }else{ dS2=1; }if(c8.contains("0")){ }else{ dS8=1; }
      if(c3.contains("0")){ }else{ dS3=1; }if(c9.contains("0")){ }else{ dS9=1; }
      if(c4.contains("0")){ }else{ dS4=1; }if(c10.contains("0")){ }else{ dS10=1; }
      if(c5.contains("0")){ }else{ dS5=1; }if(c11.contains("0")){ }else{ dS11=1; }
      if(c6.contains("0")){ }else{ dS6=1; }if(c12.contains("0")){ }else{ dS12=1; }




      String v1 = document.getString("VJornada N1");String v7 = document.getString("VJornada N7");
      String v2 = document.getString("VJornada N2");String v8 = document.getString("VJornada N8");
      String v3 = document.getString("VJornada N3");String v9 = document.getString("VJornada N9");
      String v4 = document.getString("VJornada N4");String v10 = document.getString("VJornada N10");
      String v5 = document.getString("VJornada N5");String v11 = document.getString("VJornada N11");
      String v6 = document.getString("VJornada N6");String v12 = document.getString("VJornada N12");

      int sV1 = Integer.parseInt(v1);int sV7 = Integer.parseInt(v7);
      int sV2 = Integer.parseInt(v2);int sV8 = Integer.parseInt(v8);
      int sV3 = Integer.parseInt(v3);int sV9 = Integer.parseInt(v9);
      int sV4 = Integer.parseInt(v4);int sV10 = Integer.parseInt(v10);
      int sV5 = Integer.parseInt(v5);int sV11 = Integer.parseInt(v11);
      int sV6 = Integer.parseInt(v6);int sV12 = Integer.parseInt(v12);





      int totalV = sV1+sV2+sV3+sV4+sV5+sV6+sV7+sV8+sV9+sV10+sV11+sV12 ;//1

      int totalD = dS1+dS2+dS3+dS4+dS5+dS6+dS7+dS8+dS9+dS10 + dS11 + dS12; // 0

      int totalV1 = sV1+sV2+sV3+sV4+sV5+sV6+sV7+sV8+sV9+sV10+sV11+sV12 ;//1

      int totalD2 = dS1+dS2+dS3+dS4+dS5+dS6+dS7+dS8+dS9+dS10 + dS11 + dS12; // 0





      if(totalD == 0 && totalV == 0){

          int totalDV = 0;
          datos6.put(val.getKeyDuelista(),totalDV);//DERROTAS
          datos1.put(val.getKeyDuelista(), totalDV);//total partidas



      }else{

      if(totalD == 1 && totalV == 0){

      if(cSj >0){

          int totalDV = totalD - totalV;
          datos6.put(val.getKeyDuelista(),totalDV);//DERROTAS

          datos1.put(val.getKeyDuelista(), totalDV);//total partidas

      }else{
          int totalDV = 0;
          datos6.put(val.getKeyDuelista(),totalDV);//DERROTAS
          datos1.put(val.getKeyDuelista(), totalDV);//total partidas
      }
      }else{
        //  Toast.makeText(getApplicationContext(), "nick" + val.getKeyDuelista(), Toast.LENGTH_SHORT).show();
          int totalDV = totalD - totalV;
          datos6.put(val.getKeyDuelista(),totalDV);//DERROTAS
          datos1.put(val.getKeyDuelista(), (totalDV + totalV1));//total partidas
      }




      }

   //   Toast.makeText(getApplicationContext(), "nick:  "+ datos6, Toast.LENGTH_SHORT).show();
      datos5.put(val.getKeyDuelista(),totalV);//victorias





      String n1 =document.getString("PJornada N1");
      String n3 =document.getString("PJornada N3");
      String n2 =document.getString("PJornada N2");String n11 =document.getString("PJornada N11");
      String n7 =document.getString("PJornada N7");String n12 =document.getString("PJornada N12");
      String n6 =document.getString("PJornada N6");String n8 =document.getString("PJornada N8");
      String n4 =document.getString("PJornada N4");String n9 =document.getString("PJornada N9");
      String n5 =document.getString("PJornada N5");String n10 =document.getString("PJornada N10");




      int num1=Integer.parseInt(n1);int num7=Integer.parseInt(n7);
      int num2=Integer.parseInt(n2);int num5=Integer.parseInt(n5);
      int num3=Integer.parseInt(n3);int num6=Integer.parseInt(n6);
      int num4=Integer.parseInt(n4);int num8=Integer.parseInt(n8);
      int num9=Integer.parseInt(n9);int num11=Integer.parseInt(n11);
      int num10=Integer.parseInt(n10);int num12=Integer.parseInt(n12);

      int pj=1,pj2=1,pj3=1,pj4=1,pj5=1,pj6=1,pj7=1,pj8=1,pj9=1,pj10=1,pj11=1,pj12=1;

      if(num1 == 0){ pj=0; }else{
      if(num1 == 1){ pj =0;}else{ if(num1 == 2){ pj = num1 + pj; }}}

      if(num2 == 0){ pj2=0; }else{ if(num2 == 1){
          pj2 =0; }else{ if(num2 == 2){ pj2 = num2 + pj2;}}}

      if(num3 == 0){ pj3=0; }else{ if(num3 == 1){
          pj3 =0; }else{ if(num3 == 2){ pj3 = num3 + pj3; }}}

      if(num4 == 0){ pj4=0;}else{ if(num4 == 1){
          pj4 =0; }else{ if(num4 == 2){ pj4 = num4+ pj4;}}}

      if(num5 == 0){ pj5=0; }else{ if(num5 == 1){
          pj5 =0; }else{ if(num5 == 2){ pj5 = num5 + pj5; }}}

      if(num6 == 0){ pj6=0; }else{ if(num6 == 1){
          pj6 =0;}else{ if(num6 == 2){ pj6 = num6 + pj6; }}}

      if(num7 == 0){ pj7=0; }else{ if(num7 == 1){
          pj7 =0; }else{ if(num7 == 2){ pj7 = num7 + pj7;}}}

      if(num8 == 0){ pj8=0;}else{ if(num8 == 1){
          pj8 =0; }else{ if(num8 == 2){ pj8 = num8 + pj8; }}}

      if(num9 == 0){pj9=0;  }else{ if(num9 == 1){
          pj9 =0; }else{ if(num9 == 2){ pj9 = num9 + pj9; }}}

      if(num10 == 0){ pj10=0; }else{ if(num10 == 1){
          pj10 =0; }else{ if(num10 == 2){ pj10 = num10 + pj10;pj2=0; }}}

      if(num11 == 0){ pj11=0; }else{ if(num11 == 1){
          pj11=0; }else{ if(num11 == 2){ pj11 = num11 + pj11; }}}

      if(num12 == 0){ pj12=0;}else{ if(num12 == 1){
          pj12 =0;  }else{ if(num12 == 2){ pj12 = num12 + pj12;}}}

      int totalPuntos = pj +pj2+pj3+pj4+pj5+pj6+pj7+pj8+pj9+pj10+pj11+pj12;

      total = num1+num2+num3+num4+num5+num6+num7+num8+num9+num10+num12+num11;

      datos8.put(val.getKeyDuelista(),totalPuntos); //PUntos


      if(total < cSj){
          int totalDiferencia =  cSj - total;

          datos9.put(val.getKeyDuelista(),(-totalDiferencia)); //PUntosDIFERENCIA

      }else {
          int totalDiferencia = total - cSj;

          datos9.put(val.getKeyDuelista(),totalDiferencia); //PUntosDIFERENCIA

      }


      if(total == 0){
      int total1 = 0;
          datos3.put(val.getKeyDuelista(),total1);
          datos4.put(val.getKeyDuelista(),total1);
          idV3.add(total1);
          total=0;}
  else{

       datos3.put(val.getKeyDuelista(),total);
       datos4.put(val.getKeyDuelista(),total);
          idV3.add(total);
          total=0;
  }




     int totPuntoEx=0,sumaPuntoEx=0;

     if(num1 == 1 && cSj1 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}if(num7 == 1 && cSj7 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}
      if(num2 == 1 && cSj2 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}if(num8 == 1 && cSj8 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}
      if(num3 == 1 && cSj3 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}if(num9 == 1 && cSj9 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}
      if(num4 == 1 && cSj4 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}if(num10 == 1 && cSj10 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}
      if(num5 == 1 && cSj5 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}if(num11 == 1 && cSj11 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}
      if(num6 == 1 && cSj6 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}if(num12 == 1 && cSj12 == 2){ totPuntoEx =1; sumaPuntoEx = totPuntoEx + sumaPuntoEx;totPuntoEx=0;}


      datos11.put(val.getKeyDuelista(),sumaPuntoEx);



       idV2.add(val.getKeyDuelista());



}} else {
Toast.makeText(getApplicationContext(), "No hay datos en esta dimencion", Toast.LENGTH_SHORT).show();
}
}});
 }catch(Exception sgf){ Toast.makeText(getApplicationContext(), "Error db Info", Toast.LENGTH_SHORT).show(); }

}




    @Override
    protected void onStart() {
        super.onStart();
      //  Toast.makeText(this, "OnStart tABLA FINAL", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
      //  Toast.makeText(this, "OnResume  tABLA FINAL", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
       // Toast.makeText(this, "OnPause tABLA FINAL" , Toast.LENGTH_SHORT).show();

        val.setSearKeyCodigo(0);
        idV1.clear();
        val.setKeyDuelista("");
        val.setKeyDimencion("");

    }
    @Override
    protected void onStop() {
        super.onStop();
       // Toast.makeText(this, "OnStop  tABLA FINAL", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        finishAffinity();

     //android.os.Process.killProcess(android.os.Process.myPid());
    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();
        val.setSearKeyCodigo(0);
        idV1.clear();
        val.setKeyDuelista("");
        val.setKeyDimencion("");


        if(val.getKeySiguienteN2().contains("standar")){

            Intent siguiente = new Intent(this,UsuarioStandar.class);

            siguiente.putExtra("nick", val.getKeyNick());
            siguiente.putExtra("cdGremio", val.getKeySiguienteN1());



            startActivity(siguiente);
        }else{
            if(val.getKeySiguienteN2().contains("admin")) {

                Intent siguiente = new Intent(this, UsuarioGb.class);

                siguiente.putExtra("nick", val.getKeyNick());
                siguiente.putExtra("cdGremio", val.getKeySiguienteN1());


                startActivity(siguiente);

            }
        }





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
                    finishAffinity();
                    startActivity(siguiente);
                    finish();
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






















}


