package telas;

import modelo.TurmaVO;
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
import modelo.AlunoVO;
 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class TurmaCadastrarActivity extends Activity{

//Definindo Tag para a classe
	public static final String tag = "TurmaCadastrarActivity";
		public  TextView  idTurmaField;
		public EditText  nomeField;
		public  Spinner  idAlunoField;
		String message;
	long idB;

TurmaVO objTurma = new TurmaVO();
	//objeto criado com o intuito de obter os dados alterados
	TurmaVO objTurmaInserir = new TurmaVO();

	private void initControls() {
	
	idTurmaField =  (TextView) findViewById(R.id.TextViewidTurma); 	
	nomeField = (EditText) findViewById(R.id.EditTextnome); 	
	idAlunoField =  (Spinner) findViewById(R.id.SpinneridAluno); }


	public TurmaCadastrarActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.turmacadastraractivity);
		initControls();
		
		objTurmaInserir = new TurmaVO();

				
			/***INICIO Codigo usado quando houver um spinner do tipo Int**/
			ArrayList<AlunoVO> arrayAluno = new ArrayList<AlunoVO>();
		arrayAluno = Fachada.getInstance().getAllAluno (TurmaCadastrarActivity .this);
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

        idAlunoField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
              			objTurmaInserir.idAluno = Integer.parseInt(arg0.getSelectedItem().toString());
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
			try {
				Intent data = new Intent();

				Log.i(tag,"onClick invoked.");

				/*******INSERCAO NO BD********/
							objTurmaInserir.nome = nomeField.getText().toString();

				if(validation(objTurmaInserir)){
									
					idB = Fachada.getInstance().insertTurma(TurmaCadastrarActivity.this, objTurmaInserir);

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
				ConnectionException.erro(TurmaCadastrarActivity.this, "Erro ao inserir.\n Erro:\n " + e.toString());
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

	protected boolean validation(TurmaVO objturmaInserir) {
	String campos="";
		if(!(String.valueOf(objTurmaInserir.nome).toString().equals("")
	||
	 objTurmaInserir.idAluno == 0
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
