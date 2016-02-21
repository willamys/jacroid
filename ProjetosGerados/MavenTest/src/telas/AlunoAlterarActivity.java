package telas;

import modelo.AlunoDAO;
import modelo.AlunoVO;
import modelo.ConnectionException;
import java.util.ArrayList;
import fachada.Fachada;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Vector;
import android.widget.ArrayAdapter;
import com.src.android.R;
 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class AlunoAlterarActivity extends Activity{

	public static final String tag = "AlunoAlterarActivity";

		public  TextView  idAlunoField;
		public  EditText  nomeField;
		public  EditText  idadeField;
		String message;
		long idB;
	String valor ;
	AlunoVO objAluno = new AlunoVO();
	//objeto criado com o intuito de obter os dados alterados
	AlunoVO objAlunoInserir = new AlunoVO();

	private void initControls() {
	idAlunoField =  (TextView) findViewById(R.id.TextViewidAluno); 	nomeField = (EditText) findViewById(R.id.EditTextnome); 	idadeField = (EditText) findViewById(R.id.EditTextidade); }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alunoalteraractivity);
		initControls();
		//pegar valor passado como parametro
		Intent intr = getIntent();
		valor = intr.getStringExtra("valor");

		Log.i(tag, " Valor passado " + "[ " + valor + " ]");

		objAluno = Fachada.getInstance().getAlunoById(this,Integer.parseInt(valor));
		
		objAlunoInserir = new AlunoVO();



								
										
		Button botao = (Button) findViewById(R.id.ButtonSendFeedback);
		botao.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				update();
			}
		});

		Button botaoVoltar = (Button) findViewById(R.id.ButtonBack);
		botaoVoltar.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				back();
			}
		});
		// INICIO adicionando os valores dos campos quando for feita a alteracao
		if(objAluno != null){
			nomeField.setText(String.valueOf(objAluno.nome.toString()));			idadeField.setText(String.valueOf(objAluno.idade.toString()));		}else{
			Toast.makeText(this, "Nenhum dado foi encontrado.", 
					Toast.LENGTH_LONG).show();
		}
		//FIM adicionando os valores dos campos quando for feita a alteracao
	}
protected boolean validation(AlunoVO objalunoInserir) {
String campos="";
		if(!(String.valueOf(objAlunoInserir.nome).toString().equals("")
	||
	String.valueOf(objAlunoInserir.idade).toString().equals("")
	)){
	return true;
		}
		else{
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


	private void update(){
	try {
		Intent data = new Intent();
		Log.i(tag,"onClick invoked.");

		/*******INSERCAO NO BD********/
			objAlunoInserir.idAluno = Integer.parseInt(valor);
			objAlunoInserir.nome = nomeField.getText().toString();
			objAlunoInserir.idade = idadeField.getText().toString();

		if(validation(objAlunoInserir)){

			idB = Fachada.getInstance().updateAluno(this,objAlunoInserir);

			Log.i(tag, "The update have a return equal ["+ idB +"]");

			if(idB == -1 || idB == 0){
				message = "Nao foi possivel efetuar a alteracao.";
			}else{
				message = "Alteracao efetuada com sucesso.";
				data.putExtra("valor", message);
				setResult(2,data);
				finish();
			}
		}else{
			message = "Complete todos os campos. Tente novamente.";
		}
		} catch (Exception e) {
				ConnectionException.erro(this, e.toString());
			}		
	}

	private void back() {
		Intent data = new Intent();
		data.putExtra("valor", "Voltar");
		setResult(2,data);
		finish();

	}

	//metodo para enviar o resultado para a tela anterior
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				idAlunoField.setText(data.getExtras().getString("valor"));
											}

}
