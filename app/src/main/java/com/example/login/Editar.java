package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class Editar extends AppCompatActivity implements View.OnClickListener {
    EditText ediUser, ediPass, ediNombre, ediApellido;
    Button btnActualizar, btnCancelar;
    int id=0;
    Usuario u;
    daoUsuario dao;
    Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);
        ediUser=(EditText)findViewById(R.id.EdiUser);
        ediPass=(EditText)findViewById(R.id.EdiPass);
        ediNombre=(EditText)findViewById(R.id.EdiNombre);
        ediApellido=(EditText)findViewById(R.id.EdiApellido);

        btnActualizar=(Button)findViewById(R.id.btnEdiActualizar);
        btnCancelar=(Button)findViewById(R.id.btnEdiCancelar);

        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);



        Bundle b = getIntent().getExtras();
        if (b != null) {
            id = b.getInt("id");
        } else {
            Toast.makeText(this, "Error: El Bundle es nulo", Toast.LENGTH_SHORT).show();
            finish();
        }

        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        ediUser.setText(u.getUsuario());
        ediPass.setText(u.getPassword());
        ediNombre.setText(u.getNombre());
        ediApellido.setText(u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEdiActualizar) {

            u.setUsuario(ediUser.getText().toString());
            u.setPassword(ediPass.getText().toString());
            u.setNombre(ediNombre.getText().toString());
            u.setApellidos(ediApellido.getText().toString());
            if (!u.isNull()) {
                Toast.makeText(this, "Error: Campos Vacíos", Toast.LENGTH_LONG).show();
            } else if (dao.updateUsuario(u)) {
                Toast.makeText(this, "Actualizacion Exitosa!!!", Toast.LENGTH_LONG).show();
                Intent i2=new Intent(Editar.this ,Inicio.class);
               //i2.putExtra("id",u.getId());
                startActivity(i2);
                finish();
            } else {
                Toast.makeText(this, "No se puede actualizar!!!", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.btnEdiCancelar) {
            // Código para el botón de eliminar, si es necesario
            Intent i2 = new Intent(Editar.this, Inicio.class);
            i2.putExtra("id",u.getId());
            startActivity(i2);
            finish();
        }
        }
    }
