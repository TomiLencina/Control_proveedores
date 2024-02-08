package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
    Button btnMisPedidos, btnAgregarPedidos;
    TextView nombre;
    EditText rubro, proyecto, cantidad, producto;
    int id = 0;
    Usuario u;
    //Proveedor p;
    daoUsuario dao;
    daoProveedor daoProveedor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        daoProveedor = new daoProveedor(this);
        nombre = (TextView) findViewById(R.id.nombreUsuario);
        btnMisPedidos = (Button) findViewById(R.id.btnMisPedidos);
        btnAgregarPedidos = (Button) findViewById(R.id.btnAgregarPedidos);
        //btnEditar = (Button) findViewById(R.id.btnEditar);
        //btnEliminar = (Button) findViewById(R.id.btnEliminar);
        //btnMostrar = (Button) findViewById(R.id.btnMostrar);
        //btnSalir = (Button) findViewById(R.id.btnSalir);
        rubro=(EditText) findViewById(R.id.rubro);
        proyecto=(EditText) findViewById(R.id.proyecto);
        producto=(EditText) findViewById(R.id.producto);
        cantidad=(EditText) findViewById(R.id.cantidad);

        btnMisPedidos.setOnClickListener(this);
        btnAgregarPedidos.setOnClickListener(this);
        //btnEditar.setOnClickListener(this);
        //btnEliminar.setOnClickListener(this);
        //btnMostrar.setOnClickListener(this);
        //btnSalir.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);
        nombre.setText("Hola " + u.getNombre() + " " + u.getApellidos() + ", ya puedes realizar tu pedido");


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarPedidos) {
            // Obtener los datos ingresados por el usuario
            String rubroText = rubro.getText().toString();
            String proyectoText = proyecto.getText().toString();
            String productoText = producto.getText().toString();
            int cantidadValue = Integer.parseInt(cantidad.getText().toString());

            // Crear un nuevo objeto Proveedor con los datos ingresados
            Proveedor nuevoProveedor = new Proveedor(u.getId(), rubroText, proyectoText, cantidadValue, productoText);

            // Insertar el proveedor en la base de datos
            if (daoProveedor.insertProveedor(nuevoProveedor)) {
                Toast.makeText(this, "Proveedor agregado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al agregar proveedor", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btnMisPedidos) {
            Log.d("Inicio", "Botón 'Ver Mis Pedidos' pulsado"); // Agregamos un log para saber que el botón fue pulsado

            // Abrir la actividad para ver los pedidos del usuario actual
            Intent intentMisPedidos = new Intent(Inicio.this, Mispedidos.class);
            intentMisPedidos.putExtra("id", u.getId());
            startActivity(intentMisPedidos);
        }
}


    public void menu_mostrarSesiones(View v){
        Intent c = new Intent(Inicio.this, Mostrar.class);
        startActivity(c);
    }
    public void menu_ejecutar_registro(View v){
        Intent i=new Intent(Inicio.this, Registrar.class);
        startActivity(i);
    }
    public void menu_eliminar_cuenta(View v){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("Estas Seguro de Eliminar tu cuenta???");
        b.setCancelable(false);
        b.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dao.deleteUsuario(id)) {
                    Toast.makeText(Inicio.this, "Eliminacion Exitosa!!!", Toast.LENGTH_LONG).show();
                    Intent a = new Intent(Inicio.this, Main.class);
                    startActivity(a);
                    finish();
                }else {
                    Toast.makeText(Inicio.this, "ERROR: no se puede eliminar cuenta!!!", Toast.LENGTH_LONG).show();

                }
            }
        });
        b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.cancel();
            }
        });
        b.show();
    }
    public void menu_editar_cuenta(View v){
        Intent a = new Intent(Inicio.this, Editar.class);
        a.putExtra("id", id);
        startActivity(a);
    }
    public void menu_salir(View v){
        Intent i2 = new Intent(Inicio.this, Main.class);
        startActivity(i2);
        finish();
    }


    @Override public boolean onCreateOptionsMenu(Menu mimenu){

        getMenuInflater().inflate(R.menu.menu_en_activity,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu) {

        int id = opcion_menu.getItemId();

        if (id == R.id.menuSesionesActivas) {
            menu_mostrarSesiones(null);
            return true;
        }

        if (id == R.id.menuRegistrarCta) {
            menu_ejecutar_registro(null);
            return true;
        }

        if (id == R.id.menuEliminarCta) {
            menu_eliminar_cuenta(null);
            return true;
        }

        if (id == R.id.menuEditarCuenta) {
            menu_editar_cuenta(null);
            return true;
        }

        if (id == R.id.menuSalir) {
            menu_salir(null);
            return true;
        }


        return super.onOptionsItemSelected(opcion_menu);
    }
    }


    /*@Override
    public void onClick(View v) {

        if (v.getId() == R.id.mispedidos) {
            // Código para button1
            Proveedor p = new Proveedor();
            p.getIdUsuario();
            p.setRubro(rubro.getText().toString());
            p.setProyecto(proyecto.getText().toString());
            p.setProducto(producto.getText().toString());
            p.setCantidad(Integer.parseInt(cantidad.getText().toString()));
            if (!p.isNull()) {
                Toast.makeText(this, "Error: Campos Vacíos", Toast.LENGTH_LONG).show();
            } else if (dao.insertProveedor(3,p.rubro,p.proyecto,p.producto,p)) {
                Toast.makeText(this, "Registro Exitoso!!!", Toast.LENGTH_LONG).show();
                Intent i2=new Intent(Registrar.this ,Main.class);
                startActivity(i2);
                finish();
            } else {
                Toast.makeText(this, "Usuario ya Registrado!!!", Toast.LENGTH_LONG).show();
            }

        } else if (v.getId() == R.id.btnRegCancelar) {
            Intent i = new Intent(Registrar.this, Main.class);
            startActivity(i);
            finish();*/


