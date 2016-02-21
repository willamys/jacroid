package telas;

import modelo.TurmaDAO;
import modelo.TurmaVO;
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
import modelo.AlunoVO;
 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class TurmaAlterarActivity extends Activity{

	public static final String tag = "TurmaAlterarActivity";

		public  TextView  idTurmaField;
		public  EditText  nomeField;
		public  Spinner  idAlunoField;
		String message;
		long idB;
	String valor ;
	TurmaVO objTurma = new TurmaVO();
	//objeto criado com o intuito de obter os dados alterados
	TurmaVO objTurmaInserir = new TurmaVO();

	private void initControls() {
	idTurmaField =  (TextView) findViewById(R.id.TextViewidTurma); 	nomeField = (EditText) findViewById(R.id.EditTextnome); 	idAlunoField =  (Spinner) findViewById(R.id.SpinneridAluno); }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.turmaalteraractivity);
		initControls();
		//pegar valor passado como parametro
		Intent intr = getIntent();
		valor = intr.getStringExtra("valor");

		Log.i(tag, " Valor passado " + "[ " + valor + " ]");

		objTurma = Fachada.getInstance().getTurmaById(this,Integer.parseInt(valor));
		
		objTurmaInserir = new TurmaVO();



				
			/***INICIO Codigo usado quando houver um spinner do tipo Int**/
			ArrayList<AlunoVO> arrayAluno = new ArrayList<AlunoVO>();
		arrayAluno = Fachada.getInstance().getAllAluno (TurmaAlterarActivity.this);
		Vector idAlunoList = new Vector();		
		if(arrayAluno.size() > 0 && arrayAluno !=null){
		for (int i = 0; i < arrayAluno.size(); i++) {
			//passando o nome para o select(spinner)
			idAlunoList.addElement(arrayAluno.get(i).idAluno);
		}
			}
			
		ArrayAdapter idAlunoArrayAdapter = new ArrayAdapter(this,
               android.R.layout.simple_spinner_dropdown_item, idAlunoList);
        //adicionando arraylist ao select(spinner)
		idAlunoField.setAdapter(idAlunoArrayAdapter);
		
        idAlunoField .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
						objTurmaInserir.idAluno  = Integer.parseInt(arg0.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                System.out.println("Nothing selected: " + arg0);
            }
        });
	/***FIM Spinner para tipo Int**/
				
										
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
		if(objTurma != null){
			nomeField.setText(String.valueOf(objTurma.nome.toString()));
		// selecionar o que foi selecionado no cadastro
			for (int i = 0; i < arrayAluno.size(); i++) {
			if(arrayAluno.get(i).idAluno == objTurma.idAluno){
				idAlunoField.setSelection(i);
			}
		}
		}else{
			Toast.makeText(this, "Nenhum dado foi encontrado.", 
					Toast.LENGTH_LONG).show();
		}
		//FIM adicionando os valores dos campos quando for feita a alteracao
	}
protected boolean validation(TurmaVO objturmaInserir) {
String campos="";
		if(!(String.valueOf(objTurmaInserir.nome).toString().equals("")
	||
	 objTurmaInserir.idAluno == 0
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
			objTurmaInserir.idTurma = Integer.parseInt(valor);
			objTurmaInserir.nome = nomeField.getText().toString();

		if(validation(objTurmaInserir)){

			idB = Fachada.getInstance().updateTurma(this,objTurmaInserir);

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
				idTurmaField.setText(data.getExtras().getString("valor"));
											}

}
