package br.com.ronaldo.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.ronaldo.agenda.dao.AlunoDAO;
import br.com.ronaldo.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //contém métodos de auxílio, como pegar do xml e criar um objeto aluno
        helper = new FormularioHelper(this);

        //quando clicado lá na lista, vem pra cá com um aluno pendurado na intent
        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        if (aluno != null){
            helper.preencheFormulario(aluno);
        }

        
    }

    @Override
    //botao superior direito que salva a pessoa
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override //botao superior direito de adicionar
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_formulario_ok: //caso o item do menu seja o gravar
                Aluno aluno = helper.pegaAluno(); //cria o objeto aluno e atribui

                AlunoDAO dao = new AlunoDAO(this); //cria instancia que ira conectar no banco
                if (aluno.getId() != null){
                    dao.altera(aluno); //se não nulo atualiza
                }else {
                    dao.insere(aluno); // pede pra gravar no banco
                }
                dao.close(); //vem de SQLiteOpenHelper

                Toast.makeText(FormularioActivity.this, " Aluno "+aluno.getNome()+" salvo", Toast.LENGTH_LONG).show();
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
