package pt.ismt.classyrentf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PreMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        //Inicia a aplicação na página que irá redirecionar o utilizador para o registo ou iniciar uma nova sessão
    }

    public void registarConta(View v)  {
        Intent novaConta = new Intent(this, InsertActivity.class);
        //Envia o utilizador para a página de criar uma nova conta
        startActivity(novaConta);
    }

    public void entrarConta(View v)  {
        Intent entrarConta = new Intent(this, EntraActivity.class);
        //Envia o utilizador para a página de entrar com uma conta existente
        startActivity(entrarConta);
    }

}