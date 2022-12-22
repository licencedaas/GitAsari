package licence.asari.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class reglas_good_n1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglas_good_n1);
        contexto val = new contexto();

        val.setKeyNick(getIntent().getStringExtra("nick"));
        val.setSearKeyCodigo(Integer.parseInt(getIntent().getStringExtra("cdGremio")));
        val.setKeySiguienteN1(getIntent().getStringExtra("cdGremio"));
        val.setKeySiguienteN2(getIntent().getStringExtra("standar"));
    }



    public void cerrar(View sdfas) {
        contexto val = new contexto();



        Intent siguiente = new Intent(this, eventoN2.class);

        siguiente.putExtra("nick", val.getKeyNick());
        siguiente.putExtra("cdGremio", val.getKeySiguienteN1());
        siguiente.putExtra("standar", val.getKeySiguienteN2());
        startActivity(siguiente);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
    }
}