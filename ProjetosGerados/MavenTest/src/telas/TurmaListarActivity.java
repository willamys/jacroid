package telas;

import java.util.ArrayList;
import modelo.TurmaVO;
import fachada.Fachada;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.src.android.R;

 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class TurmaListarActivity extends Activity{


	public static final String tag = "TurmaListarActivity";
		TextView tviewColumnIdTurma;
	TextView tviewColumnNome;
	TextView tviewColumnIdAluno;
	long aux;
	TableRow row;
	TableLayout tableLayout;
	ArrayList<TurmaVO> arrayTurma = new ArrayList<TurmaVO>();
	ArrayList<View> arrayView = new ArrayList<View>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.turmalistaractivity);
		clearTable();
		createTable();
		addBotaoVoltar();
	}
	
	private void addBotaoVoltar() {
		
		TableRow row =  new TableRow(this);
		Button botao = new Button(this);
		botao.setText("voltar");
		botao.setTextSize(10);
		botao.setPadding(0, 0, 5, 0);
		botao.setHeight(5);
		botao.setWidth(5);
		botao.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("valor", "voltar");
				setResult(2,data);
				finish();
			}
		});
		row.addView(botao);
		tableLayout.addView(row);
		
	}
	
	private void createTable() {
arrayTurma = Fachada.getInstance().getAllTurma(this);
		
				tviewColumnIdTurma = (TextView) findViewById(R.id.TextViewidTurma);
		tviewColumnIdTurma.setTextSize(10f);
		tviewColumnIdTurma.setLines(2);
				tviewColumnNome = (TextView) findViewById(R.id.TextViewnome);
		tviewColumnNome.setTextSize(10f);
		tviewColumnNome.setLines(2);
				tviewColumnIdAluno = (TextView) findViewById(R.id.TextViewidAluno);
		tviewColumnIdAluno.setTextSize(10f);
		tviewColumnIdAluno.setLines(2);
				tableLayout =  new TableLayout(this);
		tableLayout = (TableLayout) findViewById(R.id.table);
		tableLayout.setPadding(20,10,20,0);
		arrayView = new ArrayList<View>();
		//escrevendo dados que buscados no BD
if(arrayTurma.size() > 0 && arrayTurma != null){
			for (int i = 0; i < arrayTurma.size(); i++) {
				
				TableRow trow = new TableRow(this);
				trow.setTag("trow"+i);
				arrayView.add(trow);
				
								//**coluna1
				TextView tview1 = new TextView(this);
				tview1.setTextSize(12);
				tview1.setPadding(0, 0, 5, 0);
				tview1.setText(String.valueOf(arrayTurma.get(i).idTurma));
				tview1.setTag("view1"+arrayTurma.get(i));
				tview1.setMaxWidth(5);
								//**coluna2
				TextView tview2 = new TextView(this);
				tview2.setTextSize(12);
				tview2.setPadding(0, 0, 5, 0);
				tview2.setText(String.valueOf(arrayTurma.get(i).nome));
				tview2.setTag("view2"+arrayTurma.get(i));
				tview2.setMaxWidth(5);
								//**coluna3
				TextView tview3 = new TextView(this);
				tview3.setTextSize(12);
				tview3.setPadding(0, 0, 5, 0);
				tview3.setText(String.valueOf(arrayTurma.get(i).idAluno));
				tview3.setTag("view3"+arrayTurma.get(i));
				tview3.setMaxWidth(5);
								final Button update = new Button(this);
				update.setText("Alterar");
				update.setTextSize(12);
				update.setPadding(0, 0, 5, 0);
				update.setHeight(5);
				update.setWidth(5);
				update.setTag("view${velocityCount}"+arrayTurma.get(i));
			update.setId(arrayTurma.get(i).  idTurma);  				
				update.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v) {
						Log.i(tag, "on click " + update.getId());
						Intent i =  new Intent(TurmaListarActivity.this, TurmaAlterarActivity.class);
		        		i.putExtra("valor", String.valueOf(update.getId()));
		        		startActivityForResult(i, 1);
					}
				});
				
				
				final Button delete = new Button(this);
				delete.setText("Delete");
				delete.setTextSize(12);
				delete.setPadding(0, 0, 5, 0);
				delete.setHeight(5);
				delete.setWidth(5);
				delete.setTag("view${velocityCount}"+arrayTurma.get(i));
			delete.setId(arrayTurma.get(i).  idTurma);  				
				
				delete.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v) {
						Log.i(tag, "on click " + delete.getId());
							delete(delete.getId());
					}
				});
								//adicionando a linha
				trow.addView(tview1);
				//adicionando a linha
				trow.addView(tview2);
				//adicionando a linha
				trow.addView(tview3);
		trow.addView(update);
		trow.addView(delete);
				//adicionando a coluna
				tableLayout.addView(trow);
			}
			}
	}
	
	private void clearTable() {
		int tam =  arrayView.size();
		for (int i = 0; i < arrayView.size(); i++) {
			tableLayout.removeView(arrayView.get(i).findViewWithTag("trow"+i));
		}
	}
	
	public boolean delete(int id){
		aux = id;
		new AlertDialog.Builder(this).setTitle(this.getResources()
				.getString(R.string.app_name)).setMessage(
				"Voce realmente deseja deletar?").setPositiveButton("SIM", 
				new android.content.DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface arg0,
									int arg1) {
								String message = "";
								long ret = Fachada.getInstance().deleteTurma(TurmaListarActivity.this, aux);
								if( ret != -1 && ret != 0){
									message = "Delete efetuado com sucesso.";
									clearTable();
							createTable();
								}else{
									message = "Nao foi possivel efetuar o delete.";
								}
								Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
							}
						}).setNegativeButton("No", new android.content.DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						}).show();
		return false;
	}
	
	 public void onActivityResult(int requestCode, int resultCode,
			 Intent data) {
		 	Toast.makeText(this,data.getExtras().getString("valor"), Toast.LENGTH_LONG).show();
	clearTable();
		createTable();
	}
}
