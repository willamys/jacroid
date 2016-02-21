package telas;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.src.android.R;

 /**@author Willamys Araujo
 **Generate for Jacroid**/

public class  AlunoActivity extends Activity {
	/** Called when the activity is first created. */


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alunoactivity);
		//initControls();

		Button buttonCad = (Button) findViewById(R.id.ButtonSendFeedbackCadastrar);
		buttonCad.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(AlunoActivity.this, AlunoCadastrarActivity.class);
				startActivityForResult(i, 1);
			}
		});

		Button buttonList = (Button) findViewById(R.id.ButtonSendFeedbackListar);
		buttonList.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i =  new Intent(AlunoActivity.this, AlunoListarActivity.class);
				startActivityForResult(i, 1);
			}
		});
		
		Button buttonBack = (Button) findViewById(R.id.ButtonBack);
				buttonBack.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						Intent data = new Intent();
						data.putExtra("valor", "voltar");
						setResult(2,data);
						finish();
					}
				});

	} 

	public void onActivityResult(int requestCode, int resultCode,
			Intent data) {
		Toast.makeText(this,data.getExtras().getString("valor"), Toast.LENGTH_LONG).show();
	}

}