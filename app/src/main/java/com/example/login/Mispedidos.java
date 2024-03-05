package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class Mispedidos extends AppCompatActivity {
    ListView listaPedidos;
    daoProveedor dao;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos);

        listaPedidos = findViewById(R.id.listaPedidos);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            id = b.getInt("id");

            dao = new daoProveedor(this);

            ArrayList<Proveedor> listaProveedores = dao.selectProveedores(id);

            ArrayList<String> list = new ArrayList<>();
            for (Proveedor p : listaProveedores) {
                list.add("Proyecto: "+p.getProyecto() + ", Producto:" + p.getProducto() + ", Cantidad: " + p.getCantidad());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
            listaPedidos.setAdapter(adapter);
        }
    }
}
