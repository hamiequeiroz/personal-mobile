package br.edu.uea.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class cadastrar extends Activity{
	SQLiteDatabase bancodedados = null; 
	String sql;
	
	public void onCreate(Bundle savedInstanceState) {
		abreouCriaBanco();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		
		final int posicao = getIntent().getIntExtra("posicao", -1);
		
		final CheckBox CheckBoxOmbro = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox CheckBoxAbdome = (CheckBox) findViewById(R.id.checkBox2);
		final CheckBox CheckBoxPernas = (CheckBox) findViewById(R.id.checkBox3);
		final CheckBox CheckBoxAntebraco = (CheckBox) findViewById(R.id.checkBox4);
		final CheckBox CheckBoxPeitoral = (CheckBox) findViewById(R.id.checkBox5);
		final CheckBox CheckBoxCosta = (CheckBox) findViewById(R.id.checkBox6);
		final CheckBox CheckBoxBiceps = (CheckBox) findViewById(R.id.checkBox7);
		final CheckBox CheckBoxTriceps = (CheckBox) findViewById(R.id.checkBox8);
		
		
		
		
		Button btcadastrar = new Button(this);
		btcadastrar = (Button) findViewById(R.id.btCadastrar);
		
		btcadastrar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				int checar = 0;
				if(CheckBoxOmbro.isChecked()){
					checar = cadastrar(1,posicao + 1);
				
				}
				if(CheckBoxPeitoral.isChecked()){
					checar =cadastrar(2,posicao + 1);
					
				}
				if(CheckBoxAbdome.isChecked()){
					checar =cadastrar(3,posicao + 1);
					
				}
				if(CheckBoxCosta.isChecked()){
					checar =cadastrar(4,posicao + 1);
					
				}
				
				if(CheckBoxPernas.isChecked()){
					checar =cadastrar(5,posicao + 1);
					
				}
				if(CheckBoxBiceps.isChecked()){
					checar =cadastrar(6,posicao + 1);
					
				}
				if(CheckBoxAntebraco.isChecked()){
					checar =cadastrar(7,posicao + 1);
			
				}
				if(CheckBoxTriceps.isChecked()){
					checar =cadastrar(8,posicao + 1);
	
				}
				if (checar == 1){
					mensagemExibir("","Cadastrado");
					if(posicao+1 == 1){
					 startActivity(new Intent(cadastrar.this, ListaTreinosSegunda.class));
					}
					if(posicao+1 == 2){
						 startActivity(new Intent(cadastrar.this, ListaTreinosTerca.class));
						}
					if(posicao+1 == 3){
						 startActivity(new Intent(cadastrar.this, ListaTreinosQuarta.class));
						}
					if(posicao+1 == 4){
						 startActivity(new Intent(cadastrar.this, ListaTreinosQuinta.class));
						}
					if(posicao+1 == 5){
						 startActivity(new Intent(cadastrar.this, ListaTreinosSexta.class));
						}
					if(posicao+1 == 6){
						 startActivity(new Intent(cadastrar.this, ListaTreinosSabado.class));
						}
					
					
					
					
					
				}else{
					mensagemExibir("","Nenhum Dado Cadastrado! Aperte em Voltar");
					    if(posicao+1 == 1){
						 startActivity(new Intent(cadastrar.this, ListaTreinosSegunda.class));
						}
						if(posicao+1 == 2){
							 startActivity(new Intent(cadastrar.this, ListaTreinosTerca.class));
							}
						if(posicao+1 == 3){
							 startActivity(new Intent(cadastrar.this, ListaTreinosQuarta.class));
							}
						if(posicao+1 == 4){
							 startActivity(new Intent(cadastrar.this, ListaTreinosQuinta.class));
							}
						if(posicao+1 == 5){
							 startActivity(new Intent(cadastrar.this, ListaTreinosSexta.class));
							}
						if(posicao+1 == 6){
							 startActivity(new Intent(cadastrar.this, ListaTreinosSabado.class));
							}
						
					
										
				}
				finish();
				
			}
		});
		
		
		
		
		
	}
	public void mensagemExibir(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(cadastrar.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK",null);
		mensagem.show();
	}
	
	public int cadastrar(int dia, int tipo) {
		
		sql="INSERT INTO treino values ("+dia+","+ tipo+ ");";
		bancodedados.execSQL(sql);
		return 1;
		
	}
	
	public void abreouCriaBanco(){
		try {
			//cria banco de dados
			bancodedados = openOrCreateDatabase("academia",MODE_WORLD_READABLE,null);
			String sql="CREATE TABLE IF NOT EXISTS dia "
					+"(id_dia INT PRIMARY KEY NOT NULL , dia Text);";
			bancodedados.execSQL(sql);
			
			sql="CREATE TABLE IF NOT EXISTS tipo "
					+"(id_tipo INT PRIMARY KEY NOT NULL , tipo Text);";
			bancodedados.execSQL(sql);
			
			sql="CREATE TABLE IF NOT EXISTS exercicio "
					+"(id_exercicio INT PRIMARY KEY NOT NULL, exercicio Text,id_tipo INT, FOREIGN KEY (id_tipo) REFERENCES tipo(id_tipo));";
			bancodedados.execSQL(sql);
			
			sql="CREATE TABLE IF NOT EXISTS treino "
					+"(id_exercicio INT ,id_dia INT ,posicao INT, FOREIGN KEY (id_exercicio) " +
					"REFERENCES exercicio(id_exercicio),FOREIGN KEY (id_dia) REFERENCES dia(id_dia));";
			bancodedados.execSQL(sql);
			
			//sql="drop table exercicio";
			//bancodedados.execSQL(sql);
			
			//mensagemExibir("Banco", "Banco criado com sucesso");
		} catch (Exception e) {
			mensagemExibir("Erro no banco", "erro ao criar o banco");
			
		}		
		
	}
	

}
