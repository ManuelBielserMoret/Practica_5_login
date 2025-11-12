package com.example.practica_5_login;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText tCorreo;
    private EditText tContraseña;
    private Button bContinuar;
    private Switch sRecordar;
    private TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tCorreo = findViewById(R.id.edCorreo);
        tContraseña = findViewById(R.id.edContraseña);
        bContinuar = findViewById(R.id.Continuar);
        sRecordar = findViewById(R.id.sRecordar);
        textView5 = findViewById(R.id.textView5);

        bContinuar.setOnClickListener(v ->  {
            String correo = tCorreo.getText().toString();
            String contraseña = tContraseña.getText().toString();

            if (correo.equals("correo@gmail.com") && contraseña.equals("123")) {
                Intent intent = new Intent(MainActivity.this, MenuPrincipalActivity.class);
                intent.putExtra("Email_Usuario", correo);
                startActivity(intent);
            }else{
                textView5.setText("usuario o contraseña incorrectos");
                textView5.setTextColor(getResources().getColor(R.color.rojo_error, getTheme()));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        tCorreo.setText("");
        tContraseña.setText("");
        textView5.setText("");
    }
}