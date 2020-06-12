package pt.ismt.classyrentf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {

    //Ligação à api que contem a tabela dos utilizadores
    private ApiConnection _api;
    //Caixas de textos presentes no front-end para preenchimento de dados do utilizador
    private EditText etNome, etEmail, etPalavrapasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etPalavrapasse = findViewById(R.id.etPalavrapasse);

    }

    public void inserirAluno(View v)
    {
        //validação das caixas de texto
        if (etNome.getText().toString().length() == 0) {
            etNome.setError("É necessário preencher o nome!");
            etNome.requestFocus();
        } else if (etEmail.getText().toString().length() == 0) {
            etEmail.setError("É necessário preencher o email!");
            etEmail.requestFocus();
        } else if (etPalavrapasse.getText().toString().length() == 0) {
            etPalavrapasse.setError("É necessário preencher a palavra-passe!");
            etPalavrapasse.requestFocus();
        } else {
            //dados a enviar para a API (formato BODY)
            String dados = "person=" + etNome.getText() + "&email=" + etEmail.getText() + "&pass=" + etPalavrapasse.getText();

            //executa o pedido à API
            _api = new ApiConnection();
            _api._activity = InsertActivity.this;
            _api._listaUser = new ArrayList();
            _api.execute("http://10.0.2.2:3001/registo", "1", dados);
        }
    }
    public void sucessMessage() {
        Toast.makeText(this, "Utilizador registado com sucesso!", Toast.LENGTH_LONG).show();
        etNome.setText(etNome.getText());
        etEmail.setText(etEmail.getText());
        etPalavrapasse.setText("");

        Intent registoEntrar = new Intent(this, EntraActivity.class);
        startActivity(registoEntrar);
    }
}
