package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button btnEntrar, btnRegistar;
    daoUsuario dao;
    int intentosFallidos = 0;
    long tiempoBloqueo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setContentView(R.layout.main);
        user = findViewById(R.id.User);
        pass = findViewById(R.id.Pass);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnRegistar = findViewById(R.id.btnRegistrar);
        btnEntrar.setOnClickListener(this);
        btnRegistar.setOnClickListener(this);
        dao = new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEntrar) {
            String u = user.getText().toString();
            String p = pass.getText().toString();

            if (u.equals("") || p.equals("")) {
                Toast.makeText(this, "ERROR: Campos vacíos", Toast.LENGTH_LONG).show();
            } else {
                if (System.currentTimeMillis() > tiempoBloqueo) {
                    if (dao.login(u, p) == 1) {
                        // Login exitoso
                        Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                        intentosFallidos = 0; // Reiniciar intentos fallidos
                        Intent i2 = new Intent(Main.this, Inicio.class);
                        Usuario ux = dao.getUsuario(u, p);
                        i2.putExtra("id", ux.getId());
                        startActivity(i2);
                    }
                    else {
                        // Login fallido
                        intentosFallidos++;
                        if (intentosFallidos >= 3) {
                            // Bloquear durante 5 minutos después de 3 intentos fallidos
                            tiempoBloqueo = System.currentTimeMillis() + 5 * 60 * 1000;
                            intentosFallidos = 0; // Reiniciar intentos fallidos
                            Toast.makeText(this, "Demasiados intentos fallidos. Bloqueado por 5 minutos.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    // Aún bloqueado
                    Toast.makeText(this, "Cuenta bloqueada. Espera un momento antes de intentar de nuevo.", Toast.LENGTH_LONG).show();
                }
            }
        } else if (v.getId() == R.id.btnRegistrar) {
            Intent i = new Intent(Main.this, Registrar.class);
            startActivity(i);
        }
    }
}