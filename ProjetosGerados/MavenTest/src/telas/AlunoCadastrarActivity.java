package telas;

import modelo.AlunoVO;
import java.util.ArrayList;
import modelo.ConnectionException;
import fachada.Fachada;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Vector;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import com.src.android.R;
 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class AlunoCadastrarActivity extends Activity{

//Definindo Tag para a classe
	public static final String tag = "AlunoCadastrarActivity";
		public  TextView  idAlunoField;
		public EditText  nomeField;
		public EditText  idadeField;
		String message;
	long idB;

AlunoVO objAluno = new AlunoVO();
	//objeto criado com o intuito de obter os dados alterados
	AlunoVO objAlunoInserir = new AlunoVO();

	private void initControls() {
	
	idAlunoField =  (TextView) findViewById(R.id.TextViewidAluno); 	
	nomeField = (EditText) findViewById(R.id.EditTextnome); 	
	idadeField = (EditText) findViewById(R.id.EditTextidade); }


	public AlunoCadastrarActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alunocadastraractivity);
		initControls();
		
		objAlunoInserir = new AlunoVO();

						
								Button botao = (Button) findViewById(R.id.ButtonSendFeedback);
		botao.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
			try {
				Intent data = new Intent();

				Log.i(tag,"onClick invoked.");

				/*******INSERCAO NO BD********/
							objAlunoInserir.nome = nomeField.getText().toString();
			objAlunoInserir.idade = idadeField.getText().toString();

				if(validation(objAlunoInserir)){
									
					idB = Fachada.getInstance().insertAluno(AlunoCadastrarActivity.this, objAlunoInserir);

					Log.i(tag, "The insert have a return equal ["+ idB +"]");

					if(idB == -1 || idB == 0){
						message = "Nao foi possivel efetuar o cadastro.";
					}else{
						message = "Cadastro efetuado com sucesso.";
						data.putExtra("valor", message);
						setResult(2,data);
						finish();
					}
				}else{
					message = "Complete todos os campos.Tente novamente.";
				}
				} catch (Exception e) {
				ConnectionException.erro(AlunoCadastrarActivity.this, "Erro ao inserir.\n Erro:\n " + e.toString());
			}	
			}
		});

		Button botaoVoltar = (Button) findViewById(R.id.ButtonBack);
		botaoVoltar.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("valor", "Voltar");
				setResult(2,data);
				finish();
			}
		});
	}

	protected boolean validation(AlunoVO objalunoInserir) {
	String campos="";
		if(!(String.valueOf(objAlunoInserir.nome).toString().equals("")
	||
	String.valueOf(objAlunoInserir.idade).toString().equals("")
	)){
	return true;
		}else{
		new AlertDialog.Builder(this).setTitle(this.getResources()
					.getString(R.string.app_name)).setMessage(
					"Os campos:\n" + campos + " esta(ao) vazios.\n" +
					"Complete todos os campos. Tente novamente.")
					.setPositiveButton("continue", 
							new android.content.DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface arg0,
								int arg1) {
						}
					}).show();
			return false;
		}
	}

//metodo para enviar o resultado para a tela anterior
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		TextView t = (TextView) findViewById(R.id.textomain);
		t.setText(data.getExtras().getString("valor"));
	}

}
