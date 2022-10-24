package cl.isisur.listatiendas;
import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
//import android.support.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Simulamos que extraemos los datos de la base de datos a un cursor
        String[] columnasBD = new String[] {"_id", "imagen", "textoSuperior", "textoInferior"};
        MatrixCursor cursor = new MatrixCursor(columnasBD);
        cursor.addRow(new Object[] {"0", R.drawable.im_fuente_alemana, "Fuente Alemana", "" +
                "Acepta reservas " +
                "No se requiere reserva " +
                "Indicado para grupos " +
                "Indicado para niños " +
                "Para llevar " +
                "Servicio a domicilio " +
                "Catering " +
                "Servicio de camarero " +
                "Mesas en el exterior "});
        cursor.addRow(new Object[] {"1", R.drawable.im_parrillas_pinar, "El Pinar", "Encuentra las más " +
                 "recientes opiniones y calificaciones de viajeros sobre Parrilladas El Pinar."});
        cursor.addRow(new Object[] {"2", R.drawable.im_la_motoneta, "La Motoneta", "Avda. Padre Hurtado  242 " +
                "Teléfonos:  042 - 227 6693    La Motoneta  1 " +
                "042 - 227 2677   La Motoneta  2 " +
                "Chillán"});
        cursor.addRow(new Object[] {"3", R.drawable.im_ondel_pala, "Ondel Pala", "Local típico de la zona, una "+
                "de las mejores picadas de Chile."});
        cursor.addRow(new Object[] {"4", R.drawable.im_devorin, "Devorin", "muy rico, sabroso,todo se hace al "+
                "instante buen servicio"});
        cursor.addRow(new Object[] {"5", R.drawable.im_sushi_yan, "Sushi Yan", "Cuidados detalles. Buen ambiente. " +
                "Cortos tiempos de espera. Estacionamiento con cuidador. " +
                "Agradable atención. "});
        cursor.addRow(new Object[] {"6", R.drawable.im_restoran_arcoiris, "Arcoiris", "comida para El sabor de vivir sano"});
        cursor.addRow(new Object[] {"7", R.drawable.im_trauco_chillan, "El Trauco", "Congrio frito, los chupes y cancato "});

        //Añadimos los datos al Adapter y le indicamos donde dibujar cada dato en la fila del Layout
        String[] desdeEstasColumnas = {"imagen", "textoSuperior", "textoInferior"};
        int[] aEstasViews = {R.id.imageView_imagen, R.id.textView_superior, R.id.textView_inferior};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_main, cursor, desdeEstasColumnas, aEstasViews, 0);

        ListView listado = getListView();
        listado.setAdapter(adapter);
        //Añadimos a nuestra tabla los datos
        cl.isisur.listatiendas.DataBaseManager manager = new cl.isisur.listatiendas.DataBaseManager(this);
        manager.insertar();

    }

    @Override
    public void onListItemClick(ListView lista, View view, int posicion, long id) {
        // Hacer algo cuando un elemento de la lista es seleccionado
        TextView textoTitulo = (TextView) view.findViewById(R.id.textView_superior);

        CharSequence texto = "Seleccionado: " + textoTitulo.getText();
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
        Intent i =new Intent(this,MyActivityDetalle.class);
        i.putExtra("textoSuperior",textoTitulo.getText());
        startActivity(i);



    }

}