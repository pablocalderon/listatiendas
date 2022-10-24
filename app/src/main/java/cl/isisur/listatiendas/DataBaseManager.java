package cl.isisur.listatiendas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pablo on 28-07-14.
 */
public class DataBaseManager {
    public static final String TABLE_NAME="locales";
    public static final String CN_ID = "_id";
    public static final String CN_NAME = "textoSuperior";
    public static final String CN_DESC = "textoInferior";
    public static final String CN_IMG = "textoIMG";
    public static final String CN_PHONE = "textoFono";


    public static final String
            CREATE_TABLE  = "create table " +TABLE_NAME+
            " ("+ CN_ID + " integer primary key autoincrement, "
            + CN_NAME + " text not null,  "
            + CN_DESC + " text not null,  "
            + CN_IMG + " text not null,  "
            + CN_PHONE + " text);";


    private DBHelper helper;
    private SQLiteDatabase db;
    public DataBaseManager( Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();

    }
    private ContentValues generarContentValues(String textoSup, String textoInf,String textoIng,String textoFon) {
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, textoSup);
        valores.put(CN_DESC, textoInf);
        valores.put(CN_IMG , textoIng);
        valores.put(CN_PHONE, textoFon);
        return valores;
    }
    public Cursor buscarcatalodgo(String nombre) {
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_DESC,CN_IMG,CN_PHONE};
        return db.query(TABLE_NAME,columnas,CN_NAME + "=?",new String[]{nombre},null,null,null);
    }
    public void insertar ()
    {
        String ID = "_id";
        String NAME = "textoSuperior";
        String DESC = "textoInferior";
        String IMG = "textoIMG";
        String PHONE = "textoFono";


        NAME="Fuente Alemana";
        DESC= "Acepta reservas No se requiere reserva  Indicado para grupos Indicado para niños Para llevar " +
                "Servicio a domicilio " +
                "Catering " +
                "Servicio de camarero " +
                "Mesas en el exterior ";
        IMG="im_fuente_alemana";
        PHONE="2222222";

        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));

        NAME="El Pinar";
        DESC="Encuentra las más recientes opiniones y calificaciones de viajeros sobre Parrilladas El Pinar.";
        IMG="im_parrillas_pinar";
        PHONE="8888888";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));
        NAME="La Motoneta";
        DESC="Avda. Padre Hurtado  242 " +
            "Teléfonos:  042 - 227 6693    La Motoneta  1 " +
            "042 - 227 2677   La Motoneta  2 " +
            "Chillán";
        IMG="im_la_motoneta";
        PHONE="227 2677";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));
        NAME="Ondel Pala";
        DESC="Local típico de la zona, una " +
                "de las mejores picadas de Chile.";
        IMG="im_ondel_pala";
        PHONE="99999999";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));
        NAME="Devorin";
        DESC="muy rico, sabroso,todo se hace al "+
            "instante buen servicio";
        IMG="im_devorin";
        PHONE="787878787";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));
        NAME="Sushi Yan";
        DESC="Cuidados detalles. Buen ambiente. " +
            "Cortos tiempos de espera. Estacionamiento con cuidador. " +
            "Agradable atención.";
        IMG="im_sushi_yan";
        PHONE="32342423";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));
        NAME="Arcoiris";
        DESC="comida para El sabor de vivir sano";
        IMG="im_restoran_arcoiris";
        PHONE="3333333";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));
        NAME="El Trauco";
        DESC="Congrio frito, los chupes y cancato";
        IMG="im_trauco_chillan";
        PHONE="3333333";
        db.insert(TABLE_NAME,null,generarContentValues(NAME,DESC,IMG,PHONE));








    }
   /* public void Eliminar ()
    {
        db.insert(TABLE_NAME,null,generarContentValues(textoSup,textoInf,textoIng,textoFon));


    }*/

}
