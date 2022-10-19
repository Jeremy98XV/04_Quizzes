package org.iesch.a04_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.a04_quizzes.databinding.ActivityPantallaResultBinding;

public class PantallaResult extends AppCompatActivity {

    ActivityPantallaResultBinding binding;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPantallaResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        numero = extras.getInt("count");
        Boolean correcto = extras.getBoolean("correcto");
        if (correcto == true) {
            binding.textView.setText(R.string.correcto);
            binding.btnFinalizar.setText(R.string.siguiente);
        } else {
            binding.textView.setText(R.string.fallo);
            binding.btnFinalizar.setText(R.string.siguiente);
        }
        if (numero == 3) {
            if (correcto == true) {
                binding.textView.setText(R.string.correcto);
                binding.btnFinalizar.setText(R.string.siguiente);
            } else {
                binding.txtResp.setText(R.string.fin);
                binding.btnFinalizar.setText(R.string.FinBtn);
                binding.textView.setText(R.string.fallo);
            }

        }
        btnPantalla2();
    }

    private void btnPantalla2() {
        Intent intent = new Intent(this, MainActivity.class);

        binding.btnFinalizar.setOnClickListener(v -> {
            if (numero != 3) {

                intent.putExtra("count", numero);
            }else{
                intent.putExtra("count",0);
            }
            startActivity(intent);
        });

    }
}