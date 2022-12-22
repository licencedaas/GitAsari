package licence.asari.manager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class gremioAdmin extends  SQLiteOpenHelper{
    public gremioAdmin(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table gremio(codigo text primary key, descripcion text, precio text, telefono text,contraseña text, fecha text)");
                                                                 // CODIGO: codigo gremio
                                                                 // DESCRIPCION : gremio
                                                                 // PRECIO:  dimencion1
                                                                 // TELEFONO: dimencion2
                                                                 // contraseña: dimencion3
                                                                 //FECHA :    dimencion4
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
