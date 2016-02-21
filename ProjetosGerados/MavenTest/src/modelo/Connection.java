package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**@author Willamys Araujo
	**Generate for Jacroid**/

public class Connection extends SQLiteOpenHelper{
	
	/**Criando a Tabela do Banco de Dados**/
	private String SCRIPTCREATE;
	private String SCRIPTDELETE;
	
	private static final String TAG = "SQLiteHelper";
	
		/**Nome do Banco de Dados**/
	private static final String DATABASE_NAME = "bd_MavenTest";
	   
	/**Versao do Banco de Dados**/
	private static final int DATABASE_VERSION = 1;	



			private static final String SCRIPT_DB_DELETE_TURMA = 
			"DROP TABLE IF EXISTS tturma";
			
			private static final String SCRIPT_DB_CREATE_TURMA = 
			"create table tturma("
			+"idTurma integer primary key autoincrement not null ,"
			+"nome  text  not null ,"
			+"alunodaturma  integer  not null "
			+");";
			
			private static final String SCRIPT_DB_DELETE_ALUNO = 
			"DROP TABLE IF EXISTS taluno";
			
			private static final String SCRIPT_DB_CREATE_ALUNO = 
			"create table taluno("
			+"idAluno integer primary key autoincrement not null ,"
			+"nome  text  not null ,"
			+"idade  text  not null "
			+");";
			

	public Connection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	
			db.execSQL(SCRIPT_DB_CREATE_TURMA);		db.execSQL(SCRIPT_DB_CREATE_ALUNO);	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TAG, "Upgrading database from version " + oldVersion 
                + " to "
                + newVersion + ", which will destroy all old data");
	 db.execSQL(SCRIPT_DB_DELETE_TURMA); db.execSQL(SCRIPT_DB_DELETE_ALUNO);		onCreate(db);
	}
	

}
