package licence.asari.manager;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class detlles_derrota_lose {

    FirebaseFirestore bdNeutro;
    private  VideoView v1;
    ImageView fondo1;


    public detlles_derrota_lose(Context context1) {


        final Dialog dialog = new Dialog(context1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.cuadro_dialogo_deroorta_lose);


        v1 = (VideoView)  dialog.findViewById(R.id.v1_lose);

        v1.setVideoURI(Uri.parse("android.resource://"+ context1.getPackageName() + "/" + R.raw.lose));
        v1.setVisibility(View.GONE);

        ImageButton cerrar = (ImageButton) dialog.findViewById(R.id.reglas_cerrar);
        ImageButton b1 = (ImageButton) dialog.findViewById(R.id.lose_derrota_b1);
        fondo1 =(ImageView) dialog.findViewById(R.id.fondo_kise1);

        bdNeutro = FirebaseFirestore.getInstance();
        contexto val = new contexto();



        HashMap<String,Object> dato = new HashMap<>();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdNeutro.collection("BDcalabozo").document(val.getKeyRutaDungeon1())
                        .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){



                            val.setKeyEstado1(documentSnapshot.getString("puestoN1"));
                            val.setKeyEstado2(documentSnapshot.getString("puestoN2"));
                            val.setKeyEstado3(documentSnapshot.getString("puestoN3"));
                            val.setKeyEstado4(documentSnapshot.getString("puestoN4"));
                            val.setKeyEstado5(documentSnapshot.getString("puestoN5"));
                            val.setKeyEstado6(documentSnapshot.getString("puestoN6"));
                            val.setKeyEstado7(documentSnapshot.getString("puestoN7"));
                            val.setKeyEstado8(documentSnapshot.getString("puestoN8"));
                            val.setKeyEstado9(documentSnapshot.getString("puestoN9"));
                            val.setKeyEstado10(documentSnapshot.getString("puestoN10"));
                            val.setKeyEstado11(documentSnapshot.getString("puestoN11"));
                            val.setKeyEstado12(documentSnapshot.getString("puestoN12"));



HashMap<String, Object> dato = new HashMap<>();
HashMap<String, Object> dato2 = new HashMap<>();

if (val.getKeyCalabozolvl1().equals(val.getKeyNick())) {
dato.put("puestoN1", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl1());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl1()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl1()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl1()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl1());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl1()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl1()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl1()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl1()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl1());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }

}
}
} else {

if (val.getKeyCalabozolvl2().equals(val.getKeyNick())) {
dato.put("puestoN2", "derrota");

if (val.getKeyEstado1().equals("esperando")) {
 if (!val.getKeyEstado2().equals("esperando")) {
     if (val.getKeyEstado3().equals("esperando")) {
         if (val.getKeyEstado4().equals("esperando")) {
             if (val.getKeyEstado5().equals("esperando")) {
                 if (val.getKeyEstado6().equals("esperando")) {
                     if (val.getKeyEstado7().equals("esperando")) {
                         if (val.getKeyEstado8().equals("esperando")) {
                             if (val.getKeyEstado9().equals("esperando")) {
                                 if (val.getKeyEstado10().equals("esperando")) {
                                     if (val.getKeyEstado11().equals("esperando")) {
                                         dato2.put("puestoN11", val.getKeyCalabozolvl2());
                                     }else { dato2.put("puestoN10", val.getKeyCalabozolvl2()); }
                                 }else { dato2.put("puestoN9", val.getKeyCalabozolvl2()); }
                             }else { dato2.put("puestoN8", val.getKeyCalabozolvl2()); }
                         }else{ dato2.put("puestoN7", val.getKeyCalabozolvl2());
                         } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl2()); }
                 } else { dato2.put("puestoN5", val.getKeyCalabozolvl2()); }
             } else { dato2.put("puestoN4", val.getKeyCalabozolvl2()); }
         } else { dato2.put("puestoN3", val.getKeyCalabozolvl2()); }
     } else { dato2.put("puestoN2", val.getKeyCalabozolvl2());
         dato2.put("lvl1", "1");
         dato2.put("puestoN1", val.getKeyDuelista2());
     }
}
}
} else {
if (val.getKeyCalabozolvl3().equals(val.getKeyNick())) {
dato.put("puestoN3", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl3());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl3()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl3()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl3()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl3());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl3()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl3()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl3()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl3()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl3());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
} else {
if (val.getKeyCalabozolvl4().equals(val.getKeyNick())) {
dato.put("puestoN4", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl4());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl4()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl4()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl4()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl4());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl4()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl4()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl4()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl4()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl4());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
}else{
if (val.getKeyCalabozolvl5().equals(val.getKeyNick())) {
dato.put("puestoN5", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl5());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl5()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl5()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl5()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl5());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl5()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl5()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl5()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl5()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl5());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
} else {
}
}
}else{
if (val.getKeyCalabozolvl6().equals(val.getKeyNick())) {
dato.put("puestoN6", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl6());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl6()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl6()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl6()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl6());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl6()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl6()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl6()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl6()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl6());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
} else{
if (val.getKeyCalabozolvl7().equals(val.getKeyNick())) {
dato.put("puestoN7", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl7());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl7()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl7()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl7()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl7());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl7()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl7()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl7()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl7()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl7());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
}else{
if (val.getKeyCalabozolvl8().equals(val.getKeyNick())) {
dato.put("puestoN8", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl8());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl8()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl8()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl8()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl8());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl8()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl8()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl8()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl8()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl8());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
}else{
if (val.getKeyCalabozolvl9().equals(val.getKeyNick())) {
dato.put("puestoN9", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl9());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl9()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl9()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl9()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl9());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl9()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl9()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl9()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl9()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl9());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
}else{
if (val.getKeyCalabozolvl10().equals(val.getKeyNick())) {
dato.put("puestoN10", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl10());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl10()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl10()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl10()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl10());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl10()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl10()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl10()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl10()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl10());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}
}else{
 if (val.getKeyCalabozolvl11().equals(val.getKeyNick())) {
dato.put("puestoN11", "derrota");
if (val.getKeyEstado1().equals("esperando")) {
 if (!val.getKeyEstado2().equals("esperando")) {
     if (val.getKeyEstado3().equals("esperando")) {
         if (val.getKeyEstado4().equals("esperando")) {
             if (val.getKeyEstado5().equals("esperando")) {
                 if (val.getKeyEstado6().equals("esperando")) {
                     if (val.getKeyEstado7().equals("esperando")) {
                         if (val.getKeyEstado8().equals("esperando")) {
                             if (val.getKeyEstado9().equals("esperando")) {
                                 if (val.getKeyEstado10().equals("esperando")) {
                                     if (val.getKeyEstado11().equals("esperando")) {
                                         dato2.put("puestoN11", val.getKeyCalabozolvl11());
                                     }else { dato2.put("puestoN10", val.getKeyCalabozolvl11()); }
                                 }else { dato2.put("puestoN9", val.getKeyCalabozolvl11()); }
                             }else { dato2.put("puestoN8", val.getKeyCalabozolvl11()); }
                         }else{ dato2.put("puestoN7", val.getKeyCalabozolvl11());
                         } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl11()); }
                 } else { dato2.put("puestoN5", val.getKeyCalabozolvl11()); }
             } else { dato2.put("puestoN4", val.getKeyCalabozolvl11()); }
         } else { dato2.put("puestoN3", val.getKeyCalabozolvl11()); }
     } else { dato2.put("puestoN2", val.getKeyCalabozolvl11());
         dato2.put("lvl1", "1");
         dato2.put("puestoN1", val.getKeyDuelista2());
     }
 }
}
}else{
if (val.getKeyCalabozolvl12().equals(val.getKeyNick())) {
dato.put("puestoN12", "derrota");
 if (val.getKeyEstado1().equals("esperando")) {
if (!val.getKeyEstado2().equals("esperando")) {
    if (val.getKeyEstado3().equals("esperando")) {
        if (val.getKeyEstado4().equals("esperando")) {
            if (val.getKeyEstado5().equals("esperando")) {
                if (val.getKeyEstado6().equals("esperando")) {
                    if (val.getKeyEstado7().equals("esperando")) {
                        if (val.getKeyEstado8().equals("esperando")) {
                            if (val.getKeyEstado9().equals("esperando")) {
                                if (val.getKeyEstado10().equals("esperando")) {
                                    if (val.getKeyEstado11().equals("esperando")) {
                                        dato2.put("puestoN11", val.getKeyCalabozolvl12());
                                    }else { dato2.put("puestoN10", val.getKeyCalabozolvl12()); }
                                }else { dato2.put("puestoN9", val.getKeyCalabozolvl12()); }
                            }else { dato2.put("puestoN8", val.getKeyCalabozolvl12()); }
                        }else{ dato2.put("puestoN7", val.getKeyCalabozolvl12());
                        } }else{ dato2.put("puestoN6", val.getKeyCalabozolvl12()); }
                } else { dato2.put("puestoN5", val.getKeyCalabozolvl12()); }
            } else { dato2.put("puestoN4", val.getKeyCalabozolvl12()); }
        } else { dato2.put("puestoN3", val.getKeyCalabozolvl12()); }
    } else { dato2.put("puestoN2", val.getKeyCalabozolvl12());
        dato2.put("lvl1", "1");
        dato2.put("puestoN1", val.getKeyDuelista2());
    }
}
}


}



                                                            //fin12
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                    }
                                } } } } }
                historialduelo();
             bdNeutro.collection("BDcalabozo").document("tablaUp" + val.getKeyCalabozoActivo()+"lose").update(dato2);
              bdNeutro.collection("BDcalabozo").document("calabozoUp" + val.getKeyCalabozoActivo()+"lose").update(dato);
             fondo1.setVisibility(View.GONE);
                v1.setVisibility(View.VISIBLE);
               v1.start();



         }
               }});

            }
        }

        );




        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();

    }




    public void historialduelo(){

    contexto val = new contexto();

    bdNeutro.collection("BDcalabozo").document("historialDueloLose")
    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
     @Override
     public void onSuccess(DocumentSnapshot documentSnapshot) {
     HashMap<String, Object> dato4 = new HashMap<>();

      if(documentSnapshot.exists()) {
          try {

              val.setKeyAdmonEncuentro1(documentSnapshot.getString(val.getKeyDuelista2() + "VS" + val.getKeyNick()));///ganador
              val.setKeyAdmonEncuentro2(documentSnapshot.getString(val.getKeyNick() + "VS" + val.getKeyDuelista2()));///perdedor

              val.setKeyTotalDerrotasLose(documentSnapshot.getString(val.getKeyNick() + "DERROTA"));
              val.setKeyTotalVictoriasLose(documentSnapshot.getString(val.getKeyDuelista2() + "VICTORIA"));

              val.setKeyJ9(Integer.parseInt(val.getKeyAdmonEncuentro2()));//perdedor
              val.setKeyJ8(Integer.parseInt(val.getKeyAdmonEncuentro1()));//ganador
              val.setKeyJ8(val.getKeyJ8() + 1);

              val.setKeyJ10(Integer.parseInt(val.getKeyTotalDerrotasLose()));//perdedor
              val.setKeyJ10(val.getKeyJ10() + 1);

              val.setKeyJ11(Integer.parseInt(val.getKeyTotalVictoriasLose()));//perdedor
              val.setKeyJ11(val.getKeyJ11() + 1);

              dato4.put(val.getKeyDuelista2() + "VS" + val.getKeyNick(), String.valueOf(val.getKeyJ8()));
              dato4.put(val.getKeyNick() + "VS" + val.getKeyDuelista2(), String.valueOf(val.getKeyJ9()));

              dato4.put(val.getKeyNick() + "DERROTA", String.valueOf(val.getKeyJ10()));
              dato4.put(val.getKeyDuelista2() + "VICTORIA", String.valueOf(val.getKeyJ11()));

              bdNeutro.collection("BDcalabozo").document("historialDueloLose").update(dato4);


}catch (Exception dsfds){

              dato4.put(val.getKeyDuelista2() + "VS" + val.getKeyNick(), "1");
              dato4.put(val.getKeyNick()+ "VS" +val.getKeyDuelista2()  , "0");
              dato4.put( val.getKeyNick() + "DERROTA", "1");
              dato4.put( val.getKeyDuelista2() + "VICTORIA","1");

              bdNeutro.collection("BDcalabozo").document("historialDueloLose").update(dato4);

}


      }else{
      dato4.put(val.getKeyDuelista2() + "VS" + val.getKeyNick(), "1");
      dato4.put(val.getKeyNick()+ "VS" +val.getKeyDuelista2()  , "0");

      dato4.put( val.getKeyNick() + "DERROTA", "1");
      dato4.put( val.getKeyDuelista2() + "VICTORIA","1");

      bdNeutro.collection("BDcalabozo").document("historialDueloLose").set(dato4);
        }

            }});

    }



}
