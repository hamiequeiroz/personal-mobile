package br.edu.uea.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

public class AcademiaActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btTreina = new Button(this);
        btTreina = (Button) findViewById(R.id.btTreinar);
        
        Button btExercicios = new Button(this);
        btExercicios = (Button) findViewById(R.id.btExercicios);
        
         
        btTreina.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				startActivity(new Intent(AcademiaActivity.this, ListadeTreinos.class));
			}
		});
        
        btExercicios.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				chamaTreinamento();
			}
		});
        
        
    }
    
   
    public void chamaTreinamento(){
    	
    	startActivity(new Intent(AcademiaActivity.this, treinamento.class));
    	
    }
    
    public void mensagemExibir(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(AcademiaActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK",null);
		mensagem.show();
	}
    
}