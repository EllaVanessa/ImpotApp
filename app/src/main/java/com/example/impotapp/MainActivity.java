package com.example.impotapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;
    private Button buttonCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);
        buttonCalcul = findViewById(R.id.button_calcul);

        buttonCalcul.setOnClickListener(v -> calculer());
    }

    private void calculer() {

        if(surfaceInput.getText().toString().isEmpty() ||
                piecesInput.getText().toString().isEmpty()) {

            resultView.setText("Veuillez remplir tous les champs !");
            return;
        }

        double surface = Double.parseDouble(surfaceInput.getText().toString());
        int pieces = Integer.parseInt(piecesInput.getText().toString());
        boolean piscine = piscineCheckbox.isChecked();

        double impotBase = surface * 2;
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total = impotBase + supplement;

        resultView.setText(
                "Impôt de base : " + impotBase + " DH\n" +
                        "Supplément : " + supplement + " DH\n" +
                        "Total : " + total + " DH"
        );
    }
}