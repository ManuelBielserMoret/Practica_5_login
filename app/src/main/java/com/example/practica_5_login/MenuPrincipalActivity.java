package com.example.practica_5_login;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipalActivity extends AppCompatActivity {

    private TextView textviewEmail;
    private Button btnDesconectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);
        textviewEmail = findViewById(R.id.viewEmail);
        btnDesconectar = findViewById(R.id.botonDesconectar);

        Intent intent = getIntent();
        String emailRecibido = intent.getStringExtra("Email_Usuario");
        if (emailRecibido != null) {
            textviewEmail.setText(emailRecibido);
        }
        btnDesconectar.setOnClickListener(v -> {
            finish();
        });
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewEmail), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
        });
    }
}