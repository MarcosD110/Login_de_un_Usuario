package com.example.dos_activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Credenciales predefinidas
        String usuarioCorrecto = "Admin";
        String contraseñaCorrecta = "Password1234";

        // Inicializar componentes
        EditText usuarioInput = findViewById(R.id.usuario);
        EditText contraseñaInput = findViewById(R.id.contraseña);
        Button botonLogin = findViewById(R.id.iniciarSesion);

        botonLogin.setOnClickListener(v -> {
            // Obtener los valores ingresados
            String usuarioIngresado = usuarioInput.getText().toString();
            String contraseñaIngresada = contraseñaInput.getText().toString();

            // Validar credenciales
            if (usuarioIngresado.equals(usuarioCorrecto) && contraseñaIngresada.equals(contraseñaCorrecta)) {
                // Iniciar nueva actividad
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish(); // Cierra la actividad actual
            } else {
                // Mostrar mensajes de error específicos
                if (!usuarioIngresado.equals(usuarioCorrecto) && !contraseñaIngresada.equals(contraseñaCorrecta)) {
                    Toast.makeText(getApplicationContext(), "El usuario y la contraseña no son correctos, intentelo de nuevo.", Toast.LENGTH_LONG).show();
                } else if (!usuarioIngresado.equals(usuarioCorrecto)) {
                    Toast.makeText(getApplicationContext(), "El usuario no es correcto, intentelo de nuevo.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "La contraseña no es válida, intentelo de nuevo.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}