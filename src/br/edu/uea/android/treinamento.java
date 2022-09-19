package br.edu.uea.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class treinamento extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercicios);
    	
    	ImageButton btOmbros = new ImageButton(this);
    	btOmbros= (ImageButton) findViewById(R.id.imageButton1);
        
    	ImageButton btPeito = new ImageButton(this);
    	btPeito= (ImageButton) findViewById(R.id.imageButton2);
        
    	ImageButton btAbdome = new ImageButton(this);
    	btAbdome= (ImageButton) findViewById(R.id.imageButton3);
        
    	ImageButton btCostas = new ImageButton(this);
    	btCostas= (ImageButton) findViewById(R.id.imageButton4);
        
    	ImageButton btPernas = new ImageButton(this);
    	btPernas= (ImageButton) findViewById(R.id.imageButton5);
        
    	ImageButton btBraco = new ImageButton(this);
    	btBraco= (ImageButton) findViewById(R.id.imageButton6);
        
    	ImageButton btAntebraco = new ImageButton(this);
    	btAntebraco= (ImageButton) findViewById(R.id.imageButton7);
        
    	ImageButton btTricpes = new ImageButton(this);
    	btTricpes= (ImageButton) findViewById(R.id.imageButton8);
        
    	
    	
    	btOmbros.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				startActivity(new Intent(treinamento.this, ListaExercicioOmbros.class));
	
			}
		});
    	
    	btPeito.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(treinamento.this, ListaExercicioPeito.class));
			}
		});
    	
    	btAbdome.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			  startActivity(new Intent(treinamento.this, ListaExercicioAbdome.class));
			}
		});
    	
    	btCostas.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
			startActivity(new Intent(treinamento.this, ListaExercicioCostas.class));
			}
		});
    	
    	btPernas.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(treinamento.this, ListaExercicioPernas.class));
			}
		});
    	
    	btBraco.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(treinamento.this, ListaExercicioBraco.class));
			}
		});
    	
    	btAntebraco.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(treinamento.this, ListaExercicioAntebraco.class));
			}
		});
    	
    	btTricpes.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(treinamento.this, ListaExercicioTricpes.class));
			}
		});
	
	}
	public void mensagemExibir(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(treinamento.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK",null);
		mensagem.show();
	}

}