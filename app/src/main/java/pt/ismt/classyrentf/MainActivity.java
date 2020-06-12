package pt.ismt.classyrentf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView _lv;
    ApiConnection _api;
    ApiConnectionA _apiA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        _lv = findViewById(R.id.listAlunos);
    }

    public void inserirAlojamento(View v)  {
        Intent novoAlojamento = new Intent(this, InsertAloActivity.class);
        startActivity(novoAlojamento);
    }

    public void eliminarConta(View v)  {
        Intent eliConta = new Intent(this, EliminarActivity.class);
        startActivity(eliConta);
    }

    public void voltarClose(View v)  {
        Intent ecraInicio = new Intent(this, PreMainActivity.class);
        Toast.makeText(this, "O utilizador terminou a sessão!",
                Toast.LENGTH_LONG).show();
        startActivity(ecraInicio);
    }

    public void buscaAlojamentos(View v) {
        //inicia o pedido à API
        _apiA = new ApiConnectionA();
        _apiA._activityA = MainActivity.this;
        _apiA._listaPlace = new ArrayList();
        _apiA.execute("http://10.0.2.2:3001/alojamentos","0");
    }

    public void updateUI() {
        //lista onde irá ficar armazenado a string para mostrar na lista (listView)
        final ArrayList<String> dadosLista = new ArrayList<>();

        //ciclo que percorre todos os alunos retornados pela API
        for (int i=0; i<_apiA._listaPlace.size(); i++) {
            //variável que guarda os dados do aluno (no formato key-value-pair)
            HashMap<String, String> place = _apiA._listaPlace.get(i);

            //string com os dados a mostrar na lista no formato - nome(id) e por baixo o email
            String dataA = place.get("alojamento")+" ("+place.get("uni")+") \n"+place.get("preco");
            dadosLista.add(dataA);
        }

        _lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, dadosLista));

    }
}
