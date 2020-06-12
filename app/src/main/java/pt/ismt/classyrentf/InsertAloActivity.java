package pt.ismt.classyrentf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertAloActivity extends AppCompatActivity {

    private ApiConnectionA _apiA;
    private EditText etAlo, etCid, etUni, etDis, etPre, etMai, etDes, etUi, etUi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar);

        etAlo = findViewById(R.id.alojamento_text);
        etCid = findViewById(R.id.cidade_text);
        etUni = findViewById(R.id.uni_text);
        etDis = findViewById(R.id.editText9);
        etPre = findViewById(R.id.editText10);
        etMai = findViewById(R.id.editText11);
        etDes = findViewById(R.id.editText12);
        etUi = findViewById(R.id.id_text);
        etUi2 = findViewById(R.id.id_text2);

    }

    public void voltarMain(View v)  {
        Intent voltarHome = new Intent(this, MainActivity.class);
        //Envia o utilizador para a página principal
        startActivity(voltarHome);
    }

    public void inserirAlo(View v) {
        //validação das caixas de texto
        if (etAlo.getText().toString().length() == 0) {
            etAlo.setError("É necessário preencher o nome!");
            etAlo.requestFocus();
        } else if (etCid.getText().toString().length() == 0) {
            etCid.setError("É necessário preencher o email!");
            etCid.requestFocus();
        } else if (etUni.getText().toString().length() == 0) {
            etUni.setError("É necessário preencher a palavra-passe!");
            etUni.requestFocus();
        } else if (etDis.getText().toString().length() == 0) {
            etDis.setError("É necessário preencher o email!");
            etDis.requestFocus();
        } else if (etPre.getText().toString().length() == 0) {
            etPre.setError("É necessário preencher a palavra-passe!");
            etPre.requestFocus();
        } else if (etMai.getText().toString().length() == 0) {
            etMai.setError("É necessário preencher o email!");
            etMai.requestFocus();
        } else if (etDes.getText().toString().length() == 0) {
            etDes.setError("É necessário preencher a palavra-passe!");
            etDes.requestFocus();
        } else {
            //dados a enviar para a API (formato BODY)
            String dados = "alojamento=" + etAlo.getText() + "&cidade=" + etCid.getText() + "&uni=" + etUni.getText() + "&distancia=" + etDis.getText() + "&preco=" + etPre.getText() + "&mail=" + etMai.getText() + "&descricao=" + etDes.getText();

            //executa o pedido à API
            _apiA = new ApiConnectionA();
            _apiA._activityA = InsertAloActivity.this;
            _apiA._listaPlace = new ArrayList();
            _apiA.execute("http://10.0.2.2:3001/alojamento/"+etUi.getText()+"/criar", "1", dados);

            Toast.makeText(this, "Alojamento inserido com sucesso!", Toast.LENGTH_LONG).show();
        }
    }

    public void updateAlo(View v) {
        //validação das caixas de texto
        if (etAlo.getText().toString().length() == 0) {
            etAlo.setError("É necessário preencher o nome!");
            etAlo.requestFocus();
        } else if (etCid.getText().toString().length() == 0) {
            etCid.setError("É necessário preencher o email!");
            etCid.requestFocus();
        } else if (etUni.getText().toString().length() == 0) {
            etUni.setError("É necessário preencher a palavra-passe!");
            etUni.requestFocus();
        } else if (etDis.getText().toString().length() == 0) {
            etDis.setError("É necessário preencher o email!");
            etDis.requestFocus();
        } else if (etPre.getText().toString().length() == 0) {
            etPre.setError("É necessário preencher a palavra-passe!");
            etPre.requestFocus();
        } else if (etMai.getText().toString().length() == 0) {
            etMai.setError("É necessário preencher o email!");
            etMai.requestFocus();
        } else if (etDes.getText().toString().length() == 0) {
            etDes.setError("É necessário preencher a palavra-passe!");
            etDes.requestFocus();
        } else {
            //dados a enviar para a API (formato BODY)
            String dadosU = "alojamento=" + etAlo.getText() + "&cidade=" + etCid.getText() + "&uni=" + etUni.getText() + "&distancia=" + etDis.getText() + "&preco=" + etPre.getText() + "&mail=" + etMai.getText() + "&descricao=" + etDes.getText();

            //executa o pedido à API
            _apiA = new ApiConnectionA();
            _apiA._activityA = InsertAloActivity.this;
            _apiA._listaPlace = new ArrayList();
            _apiA.execute("http://10.0.2.2:3001/alojamento/"+etUi.getText()+"/alterar/"+etUi2.getText(), "3", dadosU);

            Toast.makeText(this, "Alojamento atualizado com sucesso!", Toast.LENGTH_LONG).show();
        }
    }

    public void removerAlo(View v) {
        //validação das caixas de texto
        if (etUi2.getText().toString().length() == 0) {
            etUi2.setError("É necessário preencher o ID do alojamento!");
            etUi2.requestFocus();
        } else if (etUi.getText().toString().length() == 0) {
            etUi.setError("É necessário preencher o ID do utilizador!");
            etUi.requestFocus();
            } else {

            //dados a enviar para a API (formato BODY)
            String dadosE = "id="+ etUi.getText() + "&uni="+ etUi2.getText();

            //executa o pedido à API
            _apiA = new ApiConnectionA();
            _apiA._activityA = InsertAloActivity.this;
            _apiA._listaPlace = new ArrayList();
            _apiA.execute("http://10.0.2.2:3001/alojamento/"+etUi.getText()+"/remover/"+etUi2.getText(), "2", dadosE);

            Toast.makeText(this, "Alojamento removido com sucesso!", Toast.LENGTH_LONG).show();
        }
    }

        public void successMessage () {
            //Toast.makeText(this, "Alojamento inserido com sucesso!", Toast.LENGTH_LONG).show();
            etAlo.setText(etAlo.getText());
            etCid.setText(etCid.getText());
            etUni.setText(etUni.getText());
            etDis.setText(etDis.getText());
            etPre.setText(etPre.getText());
            etMai.setText(etMai.getText());
            etDes.setText(etDes.getText());
            etUi.setText(etUi.getText());

    }
}

