	package modelo;
	import java.util.ArrayList;
	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.SQLException;
	import android.database.sqlite.SQLiteDatabase;

	/**@author Willamys Araujo
	**Generate for Jacroid**/

	public class TurmaDAO {

		public static final String KEY_IDTURMA = "idTurma";
		public static final String KEY_NOME = "nome";
		public static final String KEY_IDALUNO = "alunodaturma";
		
		/***@return
			int idTurma	
			String nome	
			int idAluno	
	**/
		private static final String DATABASE_TABLE = "tturma";

		private SQLiteDatabase db;
		
		private long result = 0;
		
		private Context context;

		
		public TurmaDAO (Context ctx){
			Connection dbHelper = new Connection(ctx);
			this.context = ctx;
			db = dbHelper.getWritableDatabase();
		}

		//---insert Turma---//
		/***
		 * @return long
		 * db.insert()
		 *  table
		 *  column
		 *  initialvalues
		 * **/
		public long insertTurma(TurmaVO objTurma) 
		{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objTurma.nome);
			initialValues.put(KEY_IDALUNO, objTurma.idAluno);
			result = db.insert(DATABASE_TABLE, null, initialValues);
			db.close();
			}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar inserir os dados.\n Erro:\n" + e.toString());
		}
			return result;
		}

		//---deletes a particular Turma---
		/**
		 * @return boolean
		 * db.delete()
		 *  table
		 *  whereClause
		 *  whereArgs
		 * **/
		public long deleteTurma(long rowId) 
		{
		try{
			result = db.delete(DATABASE_TABLE, KEY_IDTURMA + "=" + rowId, null);
			db.close();
			}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar excluir os dados.\n Erro:\n" + e.toString());
		}
			return result;
		}

		//---retrieves all the Turma---

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
		public ArrayList<TurmaVO> getAllTurma() 
		{
		ArrayList<TurmaVO> arrayTurmaVO = new ArrayList<TurmaVO>();
		try{
		Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " ; ",null);
		if(c.moveToFirst()){
			do{
				TurmaVO objTurma = new TurmaVO();
				objTurma.idTurma = Integer.parseInt(c.getString(0).toString());
									objTurma.nome = c.getString(1).toString();
				objTurma.idAluno = Integer.parseInt(c.getString(2).toString());
			arrayTurmaVO .add(objTurma);
			} while (c.moveToNext());
		}
				c.close();		
		db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de listar os dados.\n Erro:\n" + e.toString());
		}

		return arrayTurmaVO;
		}


		//---retrieves a particular Turma---
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
		public TurmaVO getTurmaById(long rowId) throws SQLException 
		{
		TurmaVO objTurma = new TurmaVO();
		try{
			Cursor c = db.rawQuery("SELECT * FROM "+ DATABASE_TABLE + " WHERE "+
					KEY_IDTURMA + "=" + rowId + ";", null);
			if (c != null) {
			c.moveToFirst();
				objTurma.idTurma = Integer.parseInt(c.getString(0).toString());
									objTurma.nome = c.getString(1).toString();
				objTurma.idAluno = Integer.parseInt(c.getString(2).toString());
			}
		c.close();
		db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de buscar as informacoes para alteracao.\n Erro:\n" + e.toString());
		}
		return objTurma;
		}

		//---updates a Turma---
		/**@return boolean
		 *  table
		 *  values
		 *  whereClause
		 *  whereArgs 
		 * **/
		public long updateTurma(TurmaVO objTurma) 
		{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objTurma.nome);
			initialValues.put(KEY_IDALUNO, objTurma.idAluno);
			result = db.update(DATABASE_TABLE, initialValues, 
			KEY_IDTURMA + "=" + objTurma.idTurma, null);
			db.close();
			} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar alterar os dados." + e.toString());
		}
			return result;
		}
	}
	
