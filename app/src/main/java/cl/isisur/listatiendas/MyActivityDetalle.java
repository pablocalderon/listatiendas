package cl.isisur.listatiendas;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

//import com.ist.myapplication5.app.R;

public class MyActivityDetalle extends AppCompatActivity {

    String textoSuperior;
    TextView t,t1,t2,t3;
    Bundle b,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detalle);

        t=(TextView) findViewById(R.id.textView_nombre);
        b=getIntent().getExtras();
        t.setText(b.getString("textoSuperior"));



        DataBaseManager manager = new DataBaseManager(this);
        Cursor c =  manager.buscarcatalodgo(b.getString("textoSuperior"));
        //String CN_NAME = c.getString(0);
        //String CN_DESC = c.getString(1);
        c.moveToFirst();
        t1=(TextView) findViewById(R.id.textView_descrip);
        t1.setText(c.getString(2).toString());


        ImageView iv = (ImageView)findViewById(R.id.imageView_imagen);

        Bitmap bm;


        String Name = c.getString(3).toString()+"_g";
        int intnombre=0;

        try {
            intnombre = R.drawable.class.getField(Name).getInt(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        bm = BitmapFactory.decodeResource(getResources(),intnombre);
        iv.setImageBitmap(bm);


        t3=(TextView) findViewById(R.id.textView_fono);
        t3.setText(c.getString(4).toString());

      ////////////
       Spinner spinner = (Spinner) findViewById(R.id.spinner);
       String[] valores = {"Plato1","Plato2","Plato3","Plato4"};
       spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
       spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

         @Override
         public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
          {
             Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

          }
           @Override
          public void onNothingSelected(AdapterView<?> parent)
           {
                           // vacio
           }
         });


      /////////////////////////////////

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
