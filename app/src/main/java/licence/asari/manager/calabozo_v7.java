package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class calabozo_v7 extends AppCompatActivity {
    FirebaseFirestore bdNeutral, bdAzul,gremio;
    Button b1;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    ImageButton b2;
    ImageView fondo1,fondo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calabozo_v7);
        contexto val = new contexto();





        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeyPermisoInicio(getIntent().getStringExtra("keyAdmin"));
        val.setKeySalaDuelo(getIntent().getStringExtra("keySala"));
        val.setKeyRutaDungeon1(getIntent().getStringExtra("keyTabla"));
        val.setKeyRutaDungeon2(getIntent().getStringExtra("keyCalabozo"));
        val.setKeyTorneoActivo(getIntent().getStringExtra("keyTorneo"));
        val.setKeyEnlaceCalabozolvl6(getIntent().getStringExtra("keyEnlace"));

        b2 = (ImageButton) findViewById(R.id.politicas_v7);
        b2.setVisibility(View.GONE);
        try { if (val.getKeyPermisoInicio().equals("TRUE")) { b2.setVisibility(View.VISIBLE); val.setKeyCalabozoActivo("7");} }catch (Exception dfs){}


        bdNeutral = FirebaseFirestore.getInstance();


        l1 = (TextView) findViewById(R.id.v7_l1);
        l2 = (TextView) findViewById(R.id.v7_l2);
        l3 = (TextView) findViewById(R.id.v7_l3);
        l4 = (TextView) findViewById(R.id.v7_l4);
        l5 = (TextView) findViewById(R.id.v7_l5);
        l6 = (TextView) findViewById(R.id.v7_l6);
        l7 = (TextView) findViewById(R.id.v7_l7);

        l8 = (TextView) findViewById(R.id.v7_la);
        l9 = (TextView) findViewById(R.id.v7_lb);
        l10 = (TextView) findViewById(R.id.v7_lc);
        l11 = (TextView) findViewById(R.id.v7_ld);
        l12 = (TextView) findViewById(R.id.v7_le);
        l13 = (TextView) findViewById(R.id.v7_lf);
        l14 = (TextView) findViewById(R.id.v7_lg);

        b1 = (Button) findViewById(R.id.calabozo_v7_b1);


        fondo1 =(ImageView) findViewById(R.id.ondo_dungeoxyzv7);//fondo_arquetipo_kuri
        fondo1.setVisibility(View.GONE);

        fondo2 =(ImageView) findViewById(R.id.fondo_arquetipo_kuriv7);//fondo_arquetipo_kuri
        fondo2.setVisibility(View.GONE);
        try { if (val.getKeyTorneoActivo().equals("arquetipokurivo")) { fondo2.setVisibility(View.VISIBLE);}else{fondo1.setVisibility(View.VISIBLE);}
        }catch (Exception dfs){}


        if (val.getSearKeyCodigo() > 100 && val.getSearKeyCodigo() < 600) {
            val.setKeyEscaneoGrenio("azul");
            val.setKeyIdGremio("100");

        } else {
            if (val.getSearKeyCodigo() > 1100 && val.getSearKeyCodigo() < 1600) {
                val.setKeyEscaneoGrenio("rojo");
                val.setKeyIdGremio("1100");
            } else {
                if (val.getSearKeyCodigo() > 2100 && val.getSearKeyCodigo() < 2600) {
                    val.setKeyEscaneoGrenio("naranja");
                    val.setKeyIdGremio("2100");
                } else {
                    if (val.getSearKeyCodigo() > 3100 && val.getSearKeyCodigo() < 3600) {
                        val.setKeyEscaneoGrenio("negro");
                        val.setKeyIdGremio("3100");
                    } else {
                        if (val.getSearKeyCodigo() > 4100 && val.getSearKeyCodigo() < 4600) {
                            val.setKeyEscaneoGrenio("calido");
                            val.setKeyIdGremio("4100");
                        }
                    }
                }
            }
        }

        bdNeutral.collection("BDcalabozo").document("Info")
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

                    HashMap<String, Object> dato1 = new HashMap<>();
                    b1.setText(val.getKeySalaDuelo());

                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {

                                    if (documentSnapshot.exists()) {

                                        val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                                        val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                                        val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                                        val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                                        val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                                        val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                                        val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));

                                        if (val.getKeyCalabozolvl1().equals("esperando")) {
                                            HashMap<String, Object> dato = new HashMap<>();
                                            dato.put("puestoN1", val.getKeyNick());
                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);

                                        } else {
                                            if (val.getKeyCalabozolvl2().equals("esperando")) {
                                                if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
                                                } else {
                                                    dato1.put("participante2", val.getKeyNick());
                                                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato1);
                                                    HashMap<String, Object> dato = new HashMap<>();
                                                    dato.put("puestoN2", val.getKeyNick());
                                                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                                }
                                            } else {
                                                if (val.getKeyCalabozolvl3().equals("esperando")) {
                                                    if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
                                                    } else {
                                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
                                                        } else {
                                                            dato1.put("participante3", val.getKeyNick());
                                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato1);
                                                            HashMap<String, Object> dato = new HashMap<>();
                                                            dato.put("puestoN3", val.getKeyNick());
                                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                                        }
                                                    }
                                                } else {
                                                    if (val.getKeyCalabozolvl4().equals("esperando")) {
                                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
                                                        } else {
                                                            if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
                                                            } else {
                                                                if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
                                                                } else {
                                                                    dato1.put("participante4", val.getKeyNick());
                                                                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato1);
                                                                    HashMap<String, Object> dato = new HashMap<>();
                                                                    dato.put("puestoN4", val.getKeyNick());
                                                                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (val.getKeyCalabozolvl5().equals("esperando")) {
                                                            if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
                                                            } else {
                                                                if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
                                                                } else {
                                                                    if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
                                                                    } else {
                                                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
                                                                        } else {

                                                                            dato1.put("participante5", val.getKeyNick());
                                                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato1);
                                                                            HashMap<String, Object> dato = new HashMap<>();
                                                                            dato.put("puestoN5", val.getKeyNick());
                                                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                        } else {
                                                            if (val.getKeyCalabozolvl6().equals("esperando")) {
                                                                if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
                                                                } else {
                                                                    if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
                                                                    } else {
                                                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
                                                                        } else {
                                                                            if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
                                                                            } else {
                                                                                if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
                                                                                } else {
                                                                                    dato1.put("participante6", val.getKeyNick());
                                                                                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato1);
                                                                                    HashMap<String, Object> dato = new HashMap<>();
                                                                                    dato.put("puestoN6", val.getKeyNick());
                                                                                    bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {

                                                                if (val.getKeyCalabozolvl7().equals("esperando")) {
                                                                    if (val.getKeyNick().equals(val.getKeyCalabozolvl1())) {
                                                                    } else {
                                                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl2())) {
                                                                        } else {
                                                                            if (val.getKeyNick().equals(val.getKeyCalabozolvl3())) {
                                                                            } else {
                                                                                if (val.getKeyNick().equals(val.getKeyCalabozolvl4())) {
                                                                                } else {
                                                                                    if (val.getKeyNick().equals(val.getKeyCalabozolvl5())) {
                                                                                    } else {
                                                                                        if (val.getKeyNick().equals(val.getKeyCalabozolvl6())) {
                                                                                        } else {

                                                                                            dato1.put("participante7", val.getKeyNick());
                                                                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).update(dato1);
                                                                                            HashMap<String, Object> dato = new HashMap<>();
                                                                                            dato.put("puestoN7", val.getKeyNick());
                                                                                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).update(dato);

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
                                        }
                                        relogueolvl6();
                                    } else {
                                        crear();
                                    }
                                }
                            });
                }
            }
        });

    }


    public void crear() {
        contexto val = new contexto();

        HashMap<String, Object> dato = new HashMap<>();
        HashMap<String, Object> dato1 = new HashMap<>();


        dato.put("puestoN1", val.getKeyNick());
        dato.put("puestoN2", "esperando");
        dato.put("puestoN3", "esperando");
        dato.put("puestoN4", "esperando");
        dato.put("puestoN5", "esperando");
        dato.put("puestoN6", "esperando");
        dato.put("puestoN7", "esperando");


        l1.setText(val.getKeyNick());

        dato1.put("participante1", val.getKeyNick());
        dato1.put("participante2", "esperando");
        dato1.put("participante3", "esperando");
        dato1.put("participante4", "esperando");
        dato1.put("participante5", "esperando");
        dato1.put("participante6", "esperando");
        dato1.put("participante7", "esperando");
        dato1.put("puesto1", "esperando");
        dato1.put("puesto2", "esperando");
        dato1.put("puesto3", "esperando");
        dato1.put("puesto4", "esperando");
        dato1.put("puesto5", "esperando");
        dato1.put("puesto6", "esperando");
        dato1.put("puesto7", "esperando");
        dato1.put("lvl1", "0");
        dato1.put("lvl2", "0");
        dato1.put("lvl3", "0");
        dato1.put("lvl4", "0");
        dato1.put("lvl5", "0");
        dato1.put("lvl6", "0");
        dato1.put("lvl7", "0");

        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).set(dato1);

        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).set(dato);
    }

    public void relogueolvl6() {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if (documentSnapshot.exists()) {

                            val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                            val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                            val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                            val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                            val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                            val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                            val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));

                            l1.setText(val.getKeyCalabozolvl1());
                            l2.setText(val.getKeyCalabozolvl2());
                            l3.setText(val.getKeyCalabozolvl3());
                            l4.setText(val.getKeyCalabozolvl4());
                            l5.setText(val.getKeyCalabozolvl5());
                            l6.setText(val.getKeyCalabozolvl6());
                            l7.setText(val.getKeyCalabozolvl7());

                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).get()
                                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                                            if (documentSnapshot.exists()) {

                                                val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                                                val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                                                val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                                                val.setKeyParticipante4(documentSnapshot.getString("participante4"));
                                                val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                                val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                                val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                                l8.setText(val.getKeyParticipante1());
                                                l9.setText(val.getKeyParticipante2());
                                                l10.setText(val.getKeyParticipante3());
                                                l11.setText(val.getKeyParticipante4());
                                                l12.setText(val.getKeyParticipante5());
                                                l13.setText(val.getKeyParticipante6());
                                                l14.setText(val.getKeyParticipante7());

                                            }
                                        }
                                    });


                        }

                    }
                });
    }

    public void relogueolv6(View sdfs) {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if (documentSnapshot.exists()) {

                            val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                            val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                            val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                            val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                            val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                            val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                            val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));

                            l1.setText(val.getKeyCalabozolvl1());
                            l2.setText(val.getKeyCalabozolvl2());
                            l3.setText(val.getKeyCalabozolvl3());

                            l4.setText(val.getKeyCalabozolvl4());
                            l5.setText(val.getKeyCalabozolvl5());
                            l6.setText(val.getKeyCalabozolvl6());
                            l7.setText(val.getKeyCalabozolvl7());

                            bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon1()).get()
                                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                                            if (documentSnapshot.exists()) {

                                                val.setKeyParticipante1(documentSnapshot.getString("participante1"));
                                                val.setKeyParticipante2(documentSnapshot.getString("participante2"));
                                                val.setKeyParticipante3(documentSnapshot.getString("participante3"));
                                                val.setKeyParticipante4(documentSnapshot.getString("participante4"));
                                                val.setKeyParticipante5(documentSnapshot.getString("participante5"));
                                                val.setKeyParticipante6(documentSnapshot.getString("participante6"));
                                                val.setKeyParticipante7(documentSnapshot.getString("participante7"));
                                                l8.setText(val.getKeyParticipante1());
                                                l9.setText(val.getKeyParticipante2());
                                                l10.setText(val.getKeyParticipante3());
                                                l11.setText(val.getKeyParticipante4());
                                                l12.setText(val.getKeyParticipante5());
                                                l13.setText(val.getKeyParticipante6());
                                                l14.setText(val.getKeyParticipante7());

                                            }
                                        }
                                    });


                        }

                    }
                });
    }


    public void llamadaDerrota() {
        contexto = this;
        new detlles_derrota_v7(contexto);
    }


    protected void onStop() {
        super.onStop();
        contexto val = new contexto();
        //   Toast.makeText(this, "OnStop:"+val.getKeyNick(), Toast.LENGTH_SHORT).show();
        relogueolvl6();

    }


    public void cerrar(View sdfas) {
        contexto val = new contexto();


        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

    public void enlaceLVL6(View sdfsd) {

        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document("Info").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {

                    Toast.makeText(getApplicationContext(), "EBLACE: " + val.getKeyEnlaceCalabozolvl6(), Toast.LENGTH_SHORT).show();
                    Uri url = Uri.parse(val.getKeyEnlaceCalabozolvl6());
                    Intent siguiente = new Intent(Intent.ACTION_VIEW, url);
                    startActivity(siguiente);
                }
            }
        });
    }


    Context contexto;

    public void detallesDerrota(View sdfsfd) {
        contexto val = new contexto();
        bdNeutral.collection("BDcalabozo").document(val.getKeyRutaDungeon2())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    val.setKeydueloFinal("desactivado");
                    val.setKeyCalabozolvl1(documentSnapshot.getString("puestoN1"));
                    val.setKeyCalabozolvl2(documentSnapshot.getString("puestoN2"));
                    val.setKeyCalabozolvl3(documentSnapshot.getString("puestoN3"));
                    val.setKeyCalabozolvl4(documentSnapshot.getString("puestoN4"));
                    val.setKeyCalabozolvl5(documentSnapshot.getString("puestoN5"));
                    val.setKeyCalabozolvl6(documentSnapshot.getString("puestoN6"));
                    val.setKeyCalabozolvl7(documentSnapshot.getString("puestoN7"));

                    val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                    val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                    val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                    val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                    val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                    val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
                    val.setKeyEstado7(documentSnapshot.getString("puestoN7"));


                    if (val.getKeyEstado1().equals("derrota")) {
                        if (val.getKeyEstado3().equals("derrota")) {
                            if (val.getKeyEstado4().equals("derrota")) {
                                //finalista  2
                                if (val.getKeyEstado5().equals("derrota")) {
                                    if (val.getKeyEstado7().equals("derrota")) {
                                        //finalista  6

                                        val.setKeydueloFinal("activado");
                                        if (val.getKeyEstado2().equals(val.getKeyNick())) {
                                            val.setKeyDuelista2(val.getKeyEstado6());
                                        } else {
                                            if (val.getKeyEstado6().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyEstado2());
                                            }
                                        }
                                    } else {
                                        if (val.getKeyEstado6().equals("derrota")) {
                                            //finalista  7
                                            val.setKeydueloFinal("activado");
                                            if (val.getKeyEstado2().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyEstado7());
                                            } else {
                                                if (val.getKeyEstado7().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado2());
                                                }
                                            }

                                        }
                                    }
                                } else {
                                    if (val.getKeyEstado6().equals("derrota")) {
                                        if (val.getKeyEstado7().equals("derrota")) {
//finalista  5
                                            val.setKeydueloFinal("activado");
                                            if (val.getKeyEstado5().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyEstado2());
                                            } else {
                                                if (val.getKeyEstado2().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado5());
                                                }
                                            }
                                        }
                                    }
                                }


                            } else {
                                if (val.getKeyEstado2().equals("derrota")) {
                                    //finalista  4

                                    if (val.getKeyEstado5().equals("derrota")) {
                                        if (val.getKeyEstado7().equals("derrota")) {
                                            //finalista  6

                                            val.setKeydueloFinal("activado");
                                            if (val.getKeyEstado4().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyEstado6());
                                            } else {
                                                if (val.getKeyEstado6().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado4());
                                                }
                                            }
                                        } else {
                                            if (val.getKeyEstado6().equals("derrota")) {
                                                //finalista  7
                                                val.setKeydueloFinal("activado");
                                                if (val.getKeyEstado4().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado7());
                                                } else {
                                                    if (val.getKeyEstado7().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyEstado4());
                                                    }
                                                }

                                            }
                                        }
                                    } else {
                                        if (val.getKeyEstado6().equals("derrota")) {
                                            if (val.getKeyEstado7().equals("derrota")) {
//finalista  5
                                                val.setKeydueloFinal("activado");
                                                if (val.getKeyEstado5().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado4());
                                                } else {
                                                    if (val.getKeyEstado4().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyEstado5());
                                                    }
                                                }
                                            }
                                        }
                                    }


                                }
                            }
                        } else {
                            if (val.getKeyEstado2().equals("derrota")) {
                                if (val.getKeyEstado4().equals("derrota")) {
                                    //finalista  3
                                    if (val.getKeyEstado5().equals("derrota")) {
                                        if (val.getKeyEstado7().equals("derrota")) {
                                            //finalista  6

                                            val.setKeydueloFinal("activado");
                                            if (val.getKeyEstado3().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyEstado6());
                                            } else {
                                                if (val.getKeyEstado6().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado3());
                                                }
                                            }
                                        } else {
                                            if (val.getKeyEstado6().equals("derrota")) {
                                                //finalista  7
                                                val.setKeydueloFinal("activado");
                                                if (val.getKeyEstado3().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado7());
                                                } else {
                                                    if (val.getKeyEstado7().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyEstado3());
                                                    }
                                                }

                                            }
                                        }
                                    } else {
                                        if (val.getKeyEstado6().equals("derrota")) {
                                            if (val.getKeyEstado7().equals("derrota")) {
//finalista  5
                                                val.setKeydueloFinal("activado");
                                                if (val.getKeyEstado5().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado3());
                                                } else {
                                                    if (val.getKeyEstado3().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyEstado5());
                                                    }
                                                }
                                            }
                                        }
                                    }


                                }
                            }
                        }


                    } else {
                        if (val.getKeyEstado2().equals("derrota")) {
                            if (val.getKeyEstado3().equals("derrota")) {
                                if (val.getKeyEstado4().equals("derrota")) {
                                    //finalista  1
                                    if (val.getKeyEstado5().equals("derrota")) {
                                        if (val.getKeyEstado7().equals("derrota")) {
                                            //finalista  6

                                            val.setKeydueloFinal("activado");
                                            if (val.getKeyEstado1().equals(val.getKeyNick())) {
                                                val.setKeyDuelista2(val.getKeyEstado6());
                                            } else {
                                                if (val.getKeyEstado6().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado1());
                                                }
                                            }
                                        } else {
                                            if (val.getKeyEstado6().equals("derrota")) {
                                                //finalista  7
                                                val.setKeydueloFinal("activado");
                                                if (val.getKeyEstado1().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado7());
                                                } else {
                                                    if (val.getKeyEstado7().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyEstado1());
                                                    }
                                                }

                                            }
                                        }
                                    } else {
                                        if (val.getKeyEstado6().equals("derrota")) {
                                            if (val.getKeyEstado7().equals("derrota")) {
//finalista  5
                                                val.setKeydueloFinal("activado");
                                                if (val.getKeyEstado5().equals(val.getKeyNick())) {
                                                    val.setKeyDuelista2(val.getKeyEstado1());
                                                } else {
                                                    if (val.getKeyEstado1().equals(val.getKeyNick())) {
                                                        val.setKeyDuelista2(val.getKeyEstado5());
                                                    }
                                                }
                                            }
                                        }
                                    }


                                }
                            }
                        }

                    }


                    if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
                           llamadaDerrota();
                    } else {
                        if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
                                  llamadaDerrota();
                        } else {
                            if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
                                      llamadaDerrota();
                            } else {
                                if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
                                         llamadaDerrota();
                                } else {
                                    //
                                    if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
                                               llamadaDerrota();

                                    } else {
                                        if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
                                            llamadaDerrota();
                                        } else {
                                            if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {

                                                val.setKeyDuelista2("auxiliar");
                                                if(val.getKeyEstado5().equals("derrota")){
                                                    val.setKeyDuelista2(val.getKeyCalabozolvl6());
                                                }else{
                                                    if(val.getKeyEstado6().equals("derrota")){
                                                        val.setKeyDuelista2(val.getKeyCalabozolvl5());

                                                    }else{
                                                        Toast.makeText(getApplicationContext(), "Aun su rival no ha sido definido epera.. Arigato.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                                if(val.getKeyDuelista2().equals("auxiliar")){
                                                }else{
                                                    llamadaDerrota();
                                                }

                                            }else{

                                            Toast.makeText(getApplicationContext(), "No puede generar mas codigos..", Toast.LENGTH_SHORT).show();}
                                        }
                                    }
                                }

                            }
                        }
                    }

                }


            }
        });


    }
    public void llamadaPoliticas(View dsfs){
        contexto = this;
        new detlles_politicas_dungeon(contexto);
    }
}