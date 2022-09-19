package br.edu.uea.android;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaTreinosSexta extends ListActivity{
	//Declarando  variaveis globais
	SQLiteDatabase bancodedados = null; 
	Cursor cursor;
	ArrayList<String> myArr = new ArrayList<String>();
	ArrayList<String> sequencia = new ArrayList<String>();
	
	int posicao; 
	
	public void onCreate(Bundle savedInstanceState) {
		abreouCriaBanco();	//Chama funcao pra abri banco
		super.onCreate(savedInstanceState);
		posicao = getIntent().getIntExtra("posicao", -1);
		
		buscadados();
		
		ArrayAdapter<String> treinos= new 
				ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArr );
		setListAdapter(treinos);
		
		}
		protected void onListItemClick(ListView l,View v,int position, long id){
			super.onListItemClick(l, v, position, id);
			//mensagemExibir("posicao", Integer.toString(position));
			//mensagemExibir("sequenccia", sequencia.get(0));
			
			String a = sequencia.get(position);
			
			//if (position == 0){
				
				if (Integer.parseInt(a) == 1){
					startActivity(new Intent(this, ListaExercicioOmbros.class));
				}
				if (Integer.parseInt(a) == 2){
					startActivity(new Intent(this, ListaExercicioPeito.class));
				}
				if (Integer.parseInt(a) == 3){
					startActivity(new Intent(this, ListaExercicioAbdome.class));
				}
				if (Integer.parseInt(a) == 4){
					startActivity(new Intent(this, ListaExercicioCostas.class));
				}
				if (Integer.parseInt(a) == 5){
					startActivity(new Intent(this, ListaExercicioCostas.class));
				}
				if (Integer.parseInt(a) == 6){
					startActivity(new Intent(this, ListaExercicioBraco.class));
				}
				if (Integer.parseInt(a) == 7){
					startActivity(new Intent(this, ListaExercicioAntebraco.class));
				}
				if (Integer.parseInt(a) == 8){
					startActivity(new Intent(this, ListaExercicioTricpes.class));
				}
				
				
				
			//}
		}
	
		
		public boolean buscadados(){
			try {
				String sql ="SELECT ti.tipo, ti.id_tipo FROM treino t, tipo ti " +
								"where ti.id_tipo = t.id_tipo " +
								"and id_dia=5;";
				
				cursor = bancodedados.rawQuery(sql, null);
				int count = cursor.getCount();
				
				if (count== 0){
				
					mensagemExibir("Busca dados ", "Não Contém dados Cadastrados! Aperte Menu e Cadastre");
					
				}else{
					cursor.moveToFirst();
					for (int i=0; i < count; i++) {
						
						myArr.add(Integer.toString(i+1)+" - " + cursor.getString(0));
						
						sequencia.add(Integer.toString(cursor.getInt(1)));
						
					   
					cursor.moveToNext();				
					    
					}
					
				}
				return true;
			} catch (Exception e) {
				mensagemExibir("Busca dados ", "Eroo");
				return false;
			}
			
		}
		
		    @Override
		    public boolean onCreateOptionsMenu(Menu menu) {
		    	 	menu.add(Menu.NONE,1,Menu.NONE,"Cadastrar Novo Exercicio");
		    	return super.onCreateOptionsMenu(menu);
		    }
		    
		    @Override
		    public boolean onOptionsItemSelected(MenuItem item) {
		    	switch (item.getItemId()) {
					case 1:
						//startActivity(new Intent(ListaTreinosSegunda.this, cadastrar.class));
						
						Intent i = new Intent(this,cadastrar.class);
						i.putExtra("posicao", posicao);
						startActivity(i);
						finish();
					break;
					}
		    	
		    	return super.onOptionsItemSelected(item);
		    }
		
		
		public void mensagemExibir(String titulo, String texto) {
			AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
			mensagem.setTitle(titulo);
			mensagem.setMessage(texto);
			mensagem.setNeutralButton("OK",null);
			mensagem.show();
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
