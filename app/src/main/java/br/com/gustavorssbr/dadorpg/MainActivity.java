/*
 *@author:Gustavo Rodrigues Santos Silva
 * RA: 1110481922011
 */
package br.com.gustavorssbr.dadorpg;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbD4;
    private RadioButton rbD6;
    private RadioButton rbD8;
    private RadioButton rbD10;
    private RadioButton rbD12;
    private RadioButton rbD20;
    private RadioButton rbD100;
    private Button btnGerar;
    private Spinner spQtdDados;
    private TextView tvSaida;

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

        rbD4 = findViewById(R.id.rbD4);
        rbD4.setChecked(true);
        rbD6 = findViewById(R.id.rbD6);
        rbD8 = findViewById(R.id.rbD8);
        rbD10 = findViewById(R.id.rbD10);
        rbD12 = findViewById(R.id.rbD12);
        rbD20 = findViewById(R.id.rbD20);
        rbD100 = findViewById(R.id.rbD100);

        btnGerar = findViewById(R.id.btnGerar);

        spQtdDados = findViewById(R.id.spQtdDados);

        tvSaida = findViewById(R.id.tvSaida);

        preencheSpinner();

        btnGerar.setOnClickListener(op -> gerar());
    }

    private void gerar() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        Integer qtd = (Integer) spQtdDados.getSelectedItem();
        int cont = 0;
        int i = 1;

        if (rbD4.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(4) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        if (rbD6.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(6) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        if (rbD8.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(8) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        if (rbD10.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(10) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        if (rbD12.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(12) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        if (rbD20.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(20) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        if (rbD100.isChecked()) {
            while (cont < qtd) {
                buffer.append(random.nextInt(100) + 1);
                if (cont < qtd - 1) {
                    buffer.append(", ");
                }
                cont++;
            }
        }

        tvSaida.setText(buffer.toString());
    }

    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQtdDados.setAdapter(adapter);
    }
}