package com.example.estudiantes.restaurantealarcn;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaComplejaPostres extends ListActivity {

    private MyAdapter myAdapter = null;

    public class Node{
        public String mTitulo;
        public String mDescripcion;
        public int mImagen;
    }

    private static ArrayList<Node> mArray = new ArrayList<Node>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setData();

        myAdapter = new MyAdapter(this);
        setListAdapter(myAdapter);
    }

    protected void onListItemClick(ListView _l, View _v, int _position, long _id){
        Toast.makeText(this, mArray.get(_position).mTitulo,Toast.LENGTH_SHORT).show();
    }

    private void setData(){
        mArray.clear();

        //Item1
        Node mNodeP1 = new Node();

        mNodeP1.mTitulo = this.getResources().getString(R.string.postre);
        mNodeP1.mDescripcion = this.getResources().getString(R.string.descripcion7);
        mNodeP1.mImagen = R.drawable.postre1;

        mArray.add(mNodeP1);

        //Item2
        Node mNodeP2 = new Node();

        mNodeP2.mTitulo = this.getResources().getString(R.string.postre2);
        mNodeP2.mDescripcion = this.getResources().getString(R.string.descripcion8);
        mNodeP2.mImagen = R.drawable.postre2;

        mArray.add(mNodeP2);
    }

    public static class MyAdapter extends BaseAdapter {
        private Context mContext;

        public MyAdapter(Context c){
            mContext = c;
        }

        @Override
        public int getCount() {
            return mArray.size();
        }

        @Override
        public Object getItem(int i) {
            return mArray.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if (convertView == null){
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_lista_compleja_postres, null);
            }
            else {
                view = convertView;
            }


            ImageView img = (ImageView) view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(mArray.get(position).mImagen));

            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(mArray.get(position).mTitulo);

            TextView Tdescripcion = (TextView) view.findViewById(R.id.description);
            Tdescripcion.setText(mArray.get(position).mDescripcion);

            return view;
        }
    }
}
