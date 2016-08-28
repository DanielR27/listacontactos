package com.listaejemplo;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.Adapter;

import java.util.ArrayList;

public class ListadeContactos extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ListView lista = null;
    ArrayList<Contacto> contactos = null;
    com.listaejemplo.Adapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_contactos);

        lista = (ListView) findViewById(R.id.lista);

        ArrayList<String> telefonos = null,correos = null;

        contactos = new ArrayList<Contacto>();


        telefonos = new ArrayList<String>();
        correos = new ArrayList<String>();


        for(int j = 0;j<3;j++){
            telefonos.add("telefono:"+j);
        }

        for(int h = 0;h<3;h++){
            correos.add("telefono:"+h);
        }

        for(int i = 0;i<30;i++){
            contactos.add(new Contacto("Daniel " + i,telefonos,correos,false));
        }

        adapter = new com.listaejemplo.Adapter(this,contactos);

        Log.d("ADAPTES",telefonos.size()+"");

        lista.setAdapter(adapter);

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int pos = lista.getPositionForView(compoundButton);
        if(pos != ListView.INVALID_POSITION){
            Contacto c = contactos.get(pos);
            c.setChecked(b);
            adapter.notifyDataSetChanged();
        }
    }
}
