package com.listaejemplo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contacto> lista;

    public Adapter(Context context, ArrayList<Contacto> lista) {
        this.context = context;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;
        ViewHolder holder = null;
        if (vista == null) {


            vista = LayoutInflater.from(context).inflate(R.layout.activity_adapter, parent, false);
            holder = new ViewHolder(context, vista, position);
            // if it's not recycled, initialize some attributes

            Contacto c = lista.get(position);
            holder.checkBox.setChecked(c.isChecked());
            holder.checkBox.setTag(c);
            vista.setTag(holder);
        } else {

            holder = (ViewHolder) vista.getTag();
//            vista = convertView;
//            ((ViewHolder) vista.getTag()).linearLayout.setTag(lista.get(position));
//            ((ViewHolder) vista.getTag()).textView.setTag(lista.get(position));
//            ((ViewHolder) vista.getTag()).checkBox.setTag(lista.get(position));
        }


//        ViewHolder holder = (ViewHolder) vista.getTag();
//        holder.textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        holder.textView.setPadding(8, 8, 8, 8);
//        holder.linearLayout.addView( holder.textView);


        return vista;
    }


    class ViewHolder {
        public TextView textView, telefono;
        public LinearLayout linearLayout, listaprincipal;
        public CheckBox checkBox = null;
        public ArrayList<Boolean> checked = null;

        public ViewHolder(Context context, View v, int position) {

            LinearLayout.LayoutParams layoutLinear = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(layoutLinear);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            textView = new TextView(context);
            checked = new ArrayList<Boolean>();
            listaprincipal = (LinearLayout) v.findViewById(R.id.listaprincipal);

            for (int j = 0; j < lista.get(position).telefonos.size(); j++) {
                checkBox = new CheckBox(context);
                checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                checkBox.setOnCheckedChangeListener((ListadeContactos) context);

                linearLayout.addView(checkBox);
            }

            listaprincipal.addView(linearLayout);

        }
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher
    };
}
