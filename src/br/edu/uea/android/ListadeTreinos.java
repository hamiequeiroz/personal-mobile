package br.edu.uea.android;

import android.app.ListActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

public class ListadeTreinos extends ListActivity {
	SQLiteDatabase bancodedados = null; //banco de dados	
	
	
		public void onCreate(Bundle savedInstanceState) {
		abreouCriaBanco();	//Chama funcao pra abri banco
		super.onCreate(savedInstanceState);
		String[] treino = new String[] { "Segunda-Feira", "Terça-Feira", "Quarta-Feira",
						"Quinta-Feira", "Sexta-Feira", "Sábado"};
			
		ArrayAdapter<String> treinos= new 
				ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,treino);
		
		setListAdapter(treinos);
		
		}
		protected void onListItemClick(ListView l,View v,int position, long id){
			super.onListItemClick(l, v, position, id);
						
		switch (position) {
		case 0:
			bancodedados.close();
			//startActivity(new Intent(ListadeTreinos.this, ListaTreinosSegunda.class));
			
			
			Intent i = new Intent(this,ListaTreinosSegunda.class);
			i.putExtra("posicao", position);
			startActivity(i);
			
			break;
		case 1:
			bancodedados.close();
			//startActivity(new Intent(ListadeTreinos.this, ListaTreinosSegunda.class));
			Intent i1 = new Intent(this,ListaTreinosTerca.class);
			i1.putExtra("posicao", position);
			startActivity(i1);
			break;
		case 2:
			bancodedados.close();
			//startActivity(new Intent(ListadeTreinos.this, ListaTreinosSegunda.class));
			Intent i11 = new Intent(this,ListaTreinosQuarta.class);
			i11.putExtra("posicao", position);
			startActivity(i11);
			break;
		case 3:
			bancodedados.close();
			//startActivity(new Intent(ListadeTreinos.this, ListaTreinosSegunda.class));
			Intent i1111 = new Intent(this,ListaTreinosQuinta.class);
			i1111.putExtra("posicao", position);
			startActivity(i1111);
			break;
		case 4:
			bancodedados.close();
			//startActivity(new Intent(ListadeTreinos.this, ListaTreinosSegunda.class));
			Intent i31 = new Intent(this,ListaTreinosSexta.class);
			i31.putExtra("posicao", position);
			startActivity(i31);
			break;
		case 5:
			bancodedados.close();
			//startActivity(new Intent(ListadeTreinos.this, ListaTreinosSegunda.class));
			Intent i15 = new Intent(this,ListaTreinosSabado.class);
			i15.putExtra("posicao", position);
			startActivity(i15);
			break;
		default:
			break;
		}  
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
						+"(id_tipo INT ,id_dia INT, FOREIGN KEY (id_tipo) " +
						"REFERENCES tipo(id_tipo),FOREIGN KEY (id_dia) REFERENCES dia(id_dia));";
				bancodedados.execSQL(sql);
				
			   //sql="drop table treino";
			   //bancodedados.execSQL(sql);
			
				//cadastrar();
				//mensagemExibir("Banco", "Banco criado com sucesso");
			} catch (Exception e) {
				mensagemExibir("Erro no banco", "erro ao criar o banco");
				
			}		
			
		}
		
		public void cadastrar(){
			String sql;
			try {
			/*	
			//Cadastrando Tipo
			sql="INSERT INTO tipo values (1,'ombros');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (2,'peito');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (3,'abdome');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (4,'costa');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (5,'pernas');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (6,'biceps');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (7,'antebraco');";
			bancodedados.execSQL(sql);
			sql="INSERT INTO tipo values (8,'triceps');";
			bancodedados.execSQL(sql);
			//Fim cadastro tipo
			
				
			//Cadastrando dia da Semana
				sql="INSERT INTO dia values (1,'segunda');";
				bancodedados.execSQL(sql);
				sql="INSERT INTO dia values (2,'terça');";
				bancodedados.execSQL(sql);
				sql="INSERT INTO dia values (3,'quarta');";
				bancodedados.execSQL(sql);
				sql="INSERT INTO dia values (4,'quinta');";
				bancodedados.execSQL(sql);
				sql="INSERT INTO dia values (5,'sexta');";
				bancodedados.execSQL(sql);
				sql="INSERT INTO dia values (6,'sabado');";
			//Fim Cadastro de dias
			
				
			//Cadastrando Exercicios Ombros
				sql="INSERT INTO exercicio values (1,'Desenvolvimento com barra',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (2,'Desenvolvimento com halter',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (3,'Desenvolvimento Arnold',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (4,'Elevação frontal alternada com halter',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (5,'Elevação frontal com barra',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (6,'Elevação frontal com halter',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (7,'Elevação frontal com cabo',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (8,'Elevação lateral com halter',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (9,'Elevação lateral com cabo',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (10,'Remada alta com barra',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (11,'Elevação inclinação pra frente',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (12,'Bent-Over cable raise',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (13,'Cruzamento de cabos com inversão',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (14,'Crucifixo invertido',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (15,'Manguito rotador',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (16,'Rotação externa',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (17,'Rotação interna',1);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (18,'Elevação lateral apoiado',1);";
				bancodedados.execSQL(sql);
			
			//Fim de Cadastro Exercios ombros
			
			//cadastro Exercicio Peito
				sql="INSERT INTO exercicio values (19,'Supino inclinado com barra (Incline barbell press)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (20,'Supino inclinado com halter (Incline dumbbell press)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (21,'Crucifixo inclinado com halter (Incline dumbbell fly)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (22,'Crucifixo com cabos (Low-Pulley cable fly)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (23,'Supino reto com barra (Barbell bench press)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (24,'Supino com halter (Dumbbell bench press)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (25,'Crucifixo reto com halter (Dumbbell fly)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (26,'Crucifixo com aparelho (Voador) (Machine Fly)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (27,'Supino em banco declinado (Decline Press)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (28,'Crucifixo declinado com halter (Decline dumbbell fly)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (29,'Cruzamento de cabos (Crossover)',2);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (30,'Paralela (Chest Dip)',2);";
				bancodedados.execSQL(sql);
			//Fim cadastro exercicio Peito	
				
			//Cadastro exercicio Abdome
				sql="INSERT INTO exercicio values (31,'Abdominal (Sit-Up)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (32,'Abdominal grupado (Crunch)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (33,'Abdominal grupado com corda (Rope Crunch)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (34,'Abdominal grupado com aparelho (Machine Crunch)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (35,'Elevação de pernas, corpo inclinado (Incline Leg Raise)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (36,'Elevação de pernas na barra (Hanging Leg Raise)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (37,'Elevação de joelhos (Knee-up)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (38,'Abdominal grupado invertido (Reverse Crunch)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (39,'Abdominal com giro (Twisting Sit-Up)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (40,'Abdominal grupado oblíquo (Oblique Crunch)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (41,'Abdominal grupado oblíquo com cabo (Cable Oblique Crunch)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (42,'Inclinação lateral com halter (Dumbbell Side Bend)',3);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (43,'Pullover (Pullover)',3);";
				bancodedados.execSQL(sql);
			//Fim cadastro Abdome
				
			//Cadastro exercicio Costa
				sql="INSERT INTO exercicio values (44,'Encolhimento com barra (Barbell Shrug)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (45,'Encolhimento com halter (Dumbbell Shrug)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (46,'Remada alta com barra (Barbell Upright Row)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (47,'Remada baixa unilateral (Seated cable row)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (48,'Puxador, pegada aberta (Wide-Grip pulldown)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (49,'Puxador, pegada fechada (Close-Grip pulldown)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (50,'Barra (Pull-Up)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (51,'Remada curvada com barra (Barbell Row)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (52,'Remada serrador com halter (Dumbbell Row)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (53,'Remada articulada (Machine Row)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (54,'Extensão de lombar (Lumbar extension)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (55,'Levantamento terra (Deadlift)',4);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (56,'Levantamento “Bom Dia” (Good Morning Lift)',4);";
				bancodedados.execSQL(sql);
			//Fim cadastro Costa
				
			//Cadastro exercicio pernas
				sql="INSERT INTO exercicio values (57,'Extensão de pernas (Leg extension)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (58,'Agachamento com barra (Barbell Squat)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (59,'Leg press',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (60,'Agachamento Hack (Hack Squat)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (61,'Afundo (Lunge)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (62,'Flexão da perna, deitado (Lying leg curl)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (63,'Flexão da perna, em pé (Standing leg curl)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (64,'Levantamento terra com pernas estendidas (Stiff-leg deadlift)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (65,'Panturrilha, em pé (Standing calf raise)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (66,'Elevação na ponta dos pés (Donkey calf raise)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (67,'Panturrilha em aparelho (Machine calf raise)',5);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (68,'Panturrilha sentado (Seated calf raise)',5);";
				bancodedados.execSQL(sql);
			//Fim cadastro pernas
				
			//Cadastro exercicio Biceps
				sql="INSERT INTO exercicio values (69,'Rosca direta com barra (Barbell Curl)',6);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (70,'Rosca direta com halter (Dumbbell curl)',6);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (71,'Rosca concentrada (Concetration Curl)',6);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (72,'Rosca com cabo (Cable Curl)',6);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (73,'Rosca Scott (Preacher Curl)',6);";
				bancodedados.execSQL(sql);
				
			//Fim cadastro Biceps
				
			//Cadastro exercicio antebraco
				sql="INSERT INTO exercicio values (74,'Rosca de punho (Wrist Curl)',7);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (75,'Rosca de punho invertida (Reverse wrist curl)',7);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (76,'Rosca  invertida com barra (Reverse barbbell curl)',7);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (77,'Rosca martelo (Hammer curl)',7);";
				bancodedados.execSQL(sql);
				
			//Fim cadastro antebraco
				
			//Cadastro exercicio Tricpes
				sql="INSERT INTO exercicio values (78,'Tríceps puxador (Tríceps pushdown)',8);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (79,'Flexão de braço em parra paralela (Dip)',8);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (80,'Extensão do tríceps, deitado (Tríceps Testa)',8);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (81,'Desenvolvimento do tríceps, sentado (Tríceps Francês)',8);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (82,'Supino, pegada fechada (Close-Grip bench press)',8);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO exercicio values (83,'Extensão do tríceps com halter, curvado (Tríceps coice)',8);";
				bancodedados.execSQL(sql);
				
			//Fim cadastro Tricpes	
			
			//Cadastrando treino	
				sql="INSERT INTO treino values (1,1,0);";
				bancodedados.execSQL(sql);
				sql="INSERT INTO treino values (3,1,0);";
				bancodedados.execSQL(sql);
				
			//Fim Cadastro Treino
			 */
			 	 
			 
				
			mensagemExibir("Cadastro", "cadastrado com sucesso");
			} catch (Exception e) {
				mensagemExibir("Erro no banco", "erro ao Cadastrar");
				
			}
			
		}
		
		public void mensagemExibir(String titulo, String texto) {
			AlertDialog.Builder mensagem = new AlertDialog.Builder(ListadeTreinos.this);
			mensagem.setTitle(titulo);
			mensagem.setMessage(texto);
			mensagem.setNeutralButton("OK",null);
			mensagem.show();
		}
		
		
		
	    
		
}