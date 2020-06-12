package pt.ismt.classyrentf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EntraActivity extends AppCompatActivity {

    private ApiConnection _api;
    private EditText etEmailE, etPalavrapasseE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        etEmailE = findViewById(R.id.etEmail);
        etPalavrapasseE = findViewById(R.id.etPalavrapasse);

    }

    public void entraConta(View v) {
        //validação das caixas de texto
        if (etEmailE.getText().toString().length() == 0) {
            etEmailE.setError("É necessário preencher o nome!");
            etEmailE.requestFocus();
        } else if (etPalavrapasseE.getText().toString().length() == 0) {
            etPalavrapasseE.setError("É necessário preencher o email!");
            etPalavrapasseE.requestFocus();
        } else {

            //dados a enviar para a API (formato BODY)
            String dadosE = "email=" + etEmailE.getText() + "&pass=" + etPalavrapasseE.getText();

            //executa o pedido à API
            _api = new ApiConnection();
            _api._activity = EntraActivity.this;
            _api._listaUser = new ArrayList();
            _api.execute("http://10.0.2.2:3001/entrar", "0", dadosE);

        }
    }



    public void successMessage() {
        Toast.makeText(this, "Utilizador iniciou a sessão com sucesso!", Toast.LENGTH_LONG).show();
        etEmailE.setText(etEmailE.getText());
        etPalavrapasseE.setText("");

        Intent registoEntrar = new Intent(this, MainActivity.class);
        startActivity(registoEntrar);

    }
}
