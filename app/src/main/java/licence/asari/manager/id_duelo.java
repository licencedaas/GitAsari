package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class id_duelo extends AppCompatActivity {

    ImageView imgKirito, imgHizoka, imgHioka_player,imgKirito_paler;
RadioButton rd1,rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_duelo);
        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));


        imgKirito=(ImageView) findViewById(R.id.fondo_Kirito);
        imgKirito_paler=(ImageView) findViewById(R.id.Kirito_player);
       imgHizoka =(ImageView) findViewById(R.id.fondo_Hizoka);
       imgHioka_player=(ImageView) findViewById(R.id.Hizoka_plater);

        imgKirito.setVisibility(View.GONE);
        imgHizoka.setVisibility(View.GONE);
        imgHioka_player.setVisibility(View.GONE);
        imgKirito_paler.setVisibility(View.GONE);


        rd1=(RadioButton) findViewById(R.id.stiker_rd1);
        rd2=(RadioButton) findViewById(R.id.stiker_rd2);

    rd1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

            if(rd1.isChecked()) {
                val.setKeyFormatoImgagen("fondo");
    }});
        rd2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (group, checkedId) -> {

            if(rd2.isChecked()) {
                val.setKeyFormatoImgagen("player");
            }});

        if(val.getKeyNick().contains("Kirito")){
            imgKirito.setVisibility(View.VISIBLE);
            imgKirito_paler.setVisibility(View.VISIBLE);
        }
        if(val.getKeyNick().contains("Hizoka")){
            imgHizoka.setVisibility(View.VISIBLE);
            imgHioka_player.setVisibility(View.VISIBLE);
        }




    }
    Context contexto;

    public void llamadaid(View dsfs){
       llamadoRandom();
    }


    public void llamadoRandom(){

        contexto = this;
        contexto val = new contexto();

        new detlles_id_duelista(contexto);
    }
    public void cerrar(View sdfas) {
        contexto val = new contexto();


        Intent siguiente = new Intent(this, MainActivity2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        startActivity(siguiente);
    }

}