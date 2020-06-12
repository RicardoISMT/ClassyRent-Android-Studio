package pt.ismt.classyrentf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarActivity extends AppCompatActivity {

    private ApiConnection _api;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar);

        etEmail = findViewById(R.id.etEmail);
    }

        public void EliContaA (View v) {
            //validação das caixas de texto
            if (etEmail.getText().toString().length() == 0) {
                etEmail.setError("É necessário preencher o nome!");
                etEmail.requestFocus();
            } else {
                //dados a enviar para a API (formato BODY)
                String dadosEli = "id=" + etEmail.getText();

                //executa o pedido à API
                _api = new ApiConnection();
                _api._activity = EliminarActivity.this;
                _api._listaUser = new ArrayList();
                _api.execute("http://10.0.2.2:3001/eliminar/" + etEmail.getText(), "2", dadosEli);

            }
        }
    }


