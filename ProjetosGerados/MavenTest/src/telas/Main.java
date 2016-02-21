package telas;

import com.src.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class Main extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
/**Botao para abrir o CRUD da Classe Turma*/
		Button buttonTurma = (Button) findViewById(R.id.ButtonTurma);
		buttonTurma .setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(Main.this, TurmaActivity .class);
				startActivity(i);
			}
		});
		/**Botao para abrir o CRUD da Classe Aluno*/
		Button buttonAluno = (Button) findViewById(R.id.ButtonAluno);
		buttonAluno .setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(Main.this, AlunoActivity .class);
				startActivity(i);
			}
		});
				
	}
}
