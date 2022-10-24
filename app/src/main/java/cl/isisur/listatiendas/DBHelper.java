package cl.isisur.listatiendas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by pablo on 28-07-14.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="catalogo.sqlite";
    private static final int DB_SCHEMA_VERSION=1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEMA_VERSION);
    }


    @Override  // /* alt + Enter metodos abreviados*/
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataBaseManager.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
