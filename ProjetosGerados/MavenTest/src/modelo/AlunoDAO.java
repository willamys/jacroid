	package modelo;
	import java.util.ArrayList;
	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.SQLException;
	import android.database.sqlite.SQLiteDatabase;

	/**@author Willamys Araujo
	**Generate for Jacroid**/

	public class AlunoDAO {

		public static final String KEY_IDALUNO = "idAluno";
		public static final String KEY_NOME = "nome";
		public static final String KEY_IDADE = "idade";
		
		/***@return
			int idAluno	
			String nome	
			String idade	
	**/
		private static final String DATABASE_TABLE = "taluno";

		private SQLiteDatabase db;
		
		private long result = 0;
		
		private Context context;

		
		public AlunoDAO (Context ctx){
			Connection dbHelper = new Connection(ctx);
			this.context = ctx;
			db = dbHelper.getWritableDatabase();
		}

		//---insert Aluno---//
		/***
		 * @return long
		 * db.insert()
		 *  table
		 *  column
		 *  initialvalues
		 * **/
		public long insertAluno(AlunoVO objAluno) 
		{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objAluno.nome);
			initialValues.put(KEY_IDADE, objAluno.idade);
			result = db.insert(DATABASE_TABLE, null, initialValues);
			db.close();
			}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar inserir os dados.\n Erro:\n" + e.toString());
		}
			return result;
		}

		//---deletes a particular Aluno---
		/**
		 * @return boolean
		 * db.delete()
		 *  table
		 *  whereClause
		 *  whereArgs
		 * **/
		public long deleteAluno(long rowId) 
		{
		try{
			result = db.delete(DATABASE_TABLE, KEY_IDALUNO + "=" + rowId, null);
			db.close();
			}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar excluir os dados.\n Erro:\n" + e.toString());
		}
			return result;
		}

		//---retrieves all the Aluno---

		/**metodo query 
		 * @return Cursor
		 * db.query
		 *  table
		 *  String[] columns
		 *  String selection
		 *  selectionArgs
		 *  groupby
		 *  having
		 *  orderby
		 * **/
		public ArrayList<AlunoVO> getAllAluno() 
		{
		ArrayList<AlunoVO> arrayAlunoVO = new ArrayList<AlunoVO>();
		try{
		Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " ; ",null);
		if(c.moveToFirst()){
			do{
				AlunoVO objAluno = new AlunoVO();
				objAluno.idAluno = Integer.parseInt(c.getString(0).toString());
									objAluno.nome = c.getString(1).toString();
									objAluno.idade = c.getString(2).toString();
			arrayAlunoVO .add(objAluno);
			} while (c.moveToNext());
		}
				c.close();		
		db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de listar os dados.\n Erro:\n" + e.toString());
		}

		return arrayAlunoVO;
		}


		//---retrieves a particular Aluno---
		/**metodo query 
		 * @return Cursor
		 * db.query
		 *  table
		 *  String[] columns
		 *  String selection
		 *  selectionArgs
		 *  groupby
		 *  having
		 *  orderby
		 * **/
		public AlunoVO getAlunoById(long rowId) throws SQLException 
		{
		AlunoVO objAluno = new AlunoVO();
		try{
			Cursor c = db.rawQuery("SELECT * FROM "+ DATABASE_TABLE + " WHERE "+
					KEY_IDALUNO + "=" + rowId + ";", null);
			if (c != null) {
			c.moveToFirst();
				objAluno.idAluno = Integer.parseInt(c.getString(0).toString());
									objAluno.nome = c.getString(1).toString();
									objAluno.idade = c.getString(2).toString();
			}
		c.close();
		db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de buscar as informacoes para alteracao.\n Erro:\n" + e.toString());
		}
		return objAluno;
		}

		//---updates a Aluno---
		/**@return boolean
		 *  table
		 *  values
		 *  whereClause
		 *  whereArgs 
		 * **/
		public long updateAluno(AlunoVO objAluno) 
		{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objAluno.nome);
			initialValues.put(KEY_IDADE, objAluno.idade);
			result = db.update(DATABASE_TABLE, initialValues, 
			KEY_IDALUNO + "=" + objAluno.idAluno, null);
			db.close();
			} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar alterar os dados." + e.toString());
		}
			return result;
		}
	}
	
