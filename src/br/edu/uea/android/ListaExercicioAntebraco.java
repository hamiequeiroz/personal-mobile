package br.edu.uea.android;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaExercicioAntebraco extends ListActivity {
    //Declarando  variaveis globais
	SQLiteDatabase bancodedados = null; 
	Cursor cursor;
	ArrayList<String> myArr = new ArrayList<String>();
    		
	//Fim Da declarao Variaveis
	
	public void onCreate(Bundle savedInstanceState) {
		abreouCriaBanco();	//Chama funcao pra abrir banco
		super.onCreate(savedInstanceState);
		
		buscadados();
				
		ArrayAdapter<String> treinos= new 
				ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArr);
				
		setListAdapter(treinos);
		
		}
		protected void onListItemClick(ListView l,View v,int position, long id){
			super.onListItemClick(l, v, position, id);
			Intent i = new Intent(this,ListaImagensAntebraco.class);
			i.putExtra("posicao", position);
			startActivity(i);
			
		    
		}
	
		public boolean buscadados(){
			try {
				String sql ="SELECT e.exercicio FROM exercicio e " +
						"where e.id_tipo = 7 ";
				
				cursor = bancodedados.rawQuery(sql, null);
				int count = cursor.getCount();
				
				if (count== 0){
				
					mensagemExibir("Busca dados ", "Não Contém dados Cadastrados! Aperte Menu e Cadastre");
					
				}else{
					cursor.moveToFirst();
					for (int i=0; i < count; i++) {
						
						myArr.add(Integer.toString(i+1)+" - " + cursor.getString(0));
					   
					cursor.moveToNext();				
					    
					}
					
				}
				return true;
			} catch (Exception e) {
				mensagemExibir("Busca dados ", "Eroo");
				return false;
			}
			
		}
		
		
		public void mensagemExibir(String titulo, String texto) {
			AlertDialog.Builder mensagem = new AlertDialog.Builder(ListaExercicioAntebraco.this);
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