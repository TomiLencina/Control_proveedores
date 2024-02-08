package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener {
EditText user,pass;
Button btnEntrar, btnRegistar;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setContentView(R.layout.main);
        user=(EditText) findViewById(R.id.User);
        pass=(EditText) findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistar=(Button) findViewById(R.id.btnRegistrar);
        btnEntrar.setOnClickListener(this);
        btnRegistar.setOnClickListener(this);
        dao=new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEntrar) {
            // Código para button1
            String u=user.getText().toString();
            String p=pass.getText().toString();
            if(u.equals("")&&p.equals("")){
                Toast.makeText(this,"ERRROR: Campos vacios", Toast.LENGTH_LONG).show();
            } else if (dao.login(u,p)==1) {
                Usuario ux=dao.getUsuario(u,p);
                Toast.makeText(this,"Datos correctos", Toast.LENGTH_LONG).show();
                Intent i2=new Intent(Main.this,Inicio.class);
                //i2.putExtra("Id",ux.getId());
                i2.putExtra("id", ux.getId());
                startActivity(i2);
                //i2.putExtra("id",ux.getId());
            }else{
                Toast.makeText(this,"Usuario y/o password incorrectos", Toast.LENGTH_LONG).show();
            }

        } else if (v.getId() == R.id.btnRegistrar) {
            Intent i=new Intent(Main.this, Registrar.class);
            startActivity(i);

        } else {
            // Otros casos
        }

    }


}