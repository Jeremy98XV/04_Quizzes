package org.iesch.a04_quizzes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.iesch.a04_quizzes.Preguntas.Preguntas;
import org.iesch.a04_quizzes.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    List<Preguntas> lstPreguntas = new ArrayList<>();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Quizzes");

        try {
            Bundle extras = getIntent().getExtras();
            count = extras.getInt("count");
        }catch (Exception e){
            count = 0;
        }

        PreguntasLst();
        randomice();
        btnEnviar();
    }

    private void btnEnviar() {

        Intent intent = new Intent(this, PantallaResult.class);
        Preguntas pregunta = lstPreguntas.get(count);

        binding.btnEnviar.setOnClickListener(v -> {
            if (binding.rBtnRespuesta1.isChecked()) {
                if (binding.rBtnRespuesta1.getText().equals(pregunta.getRespCorrecta())) {
                    intent.putExtra("correcto", true);
                    intent.putExtra("count", pregunta.getNumero());
                    startActivity(intent);
                } else {
                    intent.putExtra("correcto", false);
                    intent.putExtra("count", pregunta.getNumero());
                    startActivity(intent);
                }
            } else if (binding.rBtnRespuesta2.isChecked()) {
                if (binding.rBtnRespuesta2.getText().equals(pregunta.getRespCorrecta())) {
                    intent.putExtra("correcto", true);
                    intent.putExtra("count", pregunta.getNumero());
                    startActivity(intent);
                } else {
                    intent.putExtra("correcto", false);
                    intent.putExtra("count", pregunta.getNumero());
                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, R.string.escogeUna, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void randomice() {
        Preguntas pregunta = lstPreguntas.get(count);
        if (count == 0) {
            binding.tvNumPregunta.setText(pregunta.getNumero()  + " / 3");
            binding.tvProblema.setText(getString(R.string.pregunta1));
            binding.progressBar.setProgress(33);
        } else if (count == 1) {
            binding.tvNumPregunta.setText(pregunta.getNumero()  + " / 3");
            binding.tvProblema.setText(getString(R.string.pregunta2));
            binding.progressBar.setProgress(66);
        } else if (count == 2) {
            binding.tvNumPregunta.setText(pregunta.getNumero()  + " / 3");
            binding.tvProblema.setText(getString(R.string.pregunta3));
            binding.progressBar.setProgress(100);
        }
        cambioRespuestas(pregunta);
    }

    private void cambioRespuestas(Preguntas pregunta) {
        double random = Math.random();
        if (random < 0.5) {
            binding.rBtnRespuesta1.setText(pregunta.getRespCorrecta());
            binding.rBtnRespuesta2.setText(pregunta.getRespIncorrecta());

        } else {
            binding.rBtnRespuesta2.setText(pregunta.getRespCorrecta());
            binding.rBtnRespuesta1.setText(pregunta.getRespIncorrecta());

        }


    }



    private void PreguntasLst() {
        Preguntas pregunta = new Preguntas(1, getString(R.string.pregunta1), getString(R.string.respuesta1), getString(R.string.respuestaMal1));
        Preguntas pregunta2 = new Preguntas(2, getString(R.string.pregunta2), getString(R.string.respuesta2), getString(R.string.respuestaMal2));
        Preguntas pregunta3 = new Preguntas(3, getString(R.string.pregunta3), getString(R.string.respuesta3), getString(R.string.respuestaMal3));

        lstPreguntas.add(pregunta);
        lstPreguntas.add(pregunta2);
        lstPreguntas.add(pregunta3);
    }
}