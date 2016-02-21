package fachada;

import android.content.Context;
import java.util.ArrayList;
import modelo.TurmaDAO;	
import modelo.TurmaVO;
import modelo.AlunoDAO;	
import modelo.AlunoVO;

 /**@author Willamys Araujo
 **Generate for Jacroid**/
 
public class Fachada{

	public static Fachada fachada = null; 

	public Fachada() {
	}
	/***metodo estatico para obter a instancia da classe Fachada ***/
	public static Fachada getInstance() {
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	/***INICIO Turma**/

	/***metodo de insercao de Turma*
	*  ctx passar contexto do view que esta em uso
	*  turma passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "insercao falhou"
	*  1 a "inserido com sucesso" **/
	public long insertTurma(Context ctx, TurmaVO turma) {
	TurmaDAO turmaDao = new TurmaDAO(ctx);
		if(turma == null){
			return -1;
		}else{
			return turmaDao. insertTurma (turma);
		}
	}
	/***metodo de alteracao de Turma*
	*  ctx passar contexto do view que esta em uso**
	*  turma passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "alteracao falhou"
	*  1 a "alterado com sucesso" ***/
	public long updateTurma(Context ctx, TurmaVO turma) {
		TurmaDAO turmaDao = new TurmaDAO(ctx);
		if(turma == null){
			return -1;
		}else{
			return turmaDao. updateTurma (turma);
		}
	}
	/***metodo de insercao de Turma**
	*  ctx passar contexto do view que esta em uso**
	*  id passar o id que do registro a ser deletado
	* @return long - se o valor retornado for:
	* -1 a "delete falhou"
	*  1 a "delete com sucesso" **/
	public long deleteTurma(Context ctx, long id) {
	TurmaDAO turmaDao = new TurmaDAO(ctx);
		if(id == 0 || id < 0){
			return -1;
		}else{
			return turmaDao. deleteTurma (id);
		}
	}
	/***metodo de listar todos os registros de Turma**
	*  ctx passar contexto do view que esta em uso
	* @return ArrayList de Objeto da classe Turma preenchidos**/
	public ArrayList<TurmaVO> getAllTurma(Context ctx) {
	TurmaDAO turmaDao = new TurmaDAO(ctx);
		return turmaDao. getAllTurma (); 
	}
	/***metodo de listar registro por Id de Turma**
	*  ctx passar contexto do view que esta em uso**
	*  id passar o id que do registro a ser buscado
	* @return Objeto da classe Turma preenchido**/
	public TurmaVO getTurmaById(Context ctx, long id) {
	TurmaDAO turmaDao = new TurmaDAO(ctx);
		if(id == 0 || id < 0){
			return null;
		}else{
			return turmaDao. getTurmaById (id);
		}
	}
	/***FIM Turma****/

/***INICIO Aluno**/

	/***metodo de insercao de Aluno*
	*  ctx passar contexto do view que esta em uso
	*  aluno passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "insercao falhou"
	*  1 a "inserido com sucesso" **/
	public long insertAluno(Context ctx, AlunoVO aluno) {
	AlunoDAO alunoDao = new AlunoDAO(ctx);
		if(aluno == null){
			return -1;
		}else{
			return alunoDao. insertAluno (aluno);
		}
	}
	/***metodo de alteracao de Aluno*
	*  ctx passar contexto do view que esta em uso**
	*  aluno passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "alteracao falhou"
	*  1 a "alterado com sucesso" ***/
	public long updateAluno(Context ctx, AlunoVO aluno) {
		AlunoDAO alunoDao = new AlunoDAO(ctx);
		if(aluno == null){
			return -1;
		}else{
			return alunoDao. updateAluno (aluno);
		}
	}
	/***metodo de insercao de Aluno**
	*  ctx passar contexto do view que esta em uso**
	*  id passar o id que do registro a ser deletado
	* @return long - se o valor retornado for:
	* -1 a "delete falhou"
	*  1 a "delete com sucesso" **/
	public long deleteAluno(Context ctx, long id) {
	AlunoDAO alunoDao = new AlunoDAO(ctx);
		if(id == 0 || id < 0){
			return -1;
		}else{
			return alunoDao. deleteAluno (id);
		}
	}
	/***metodo de listar todos os registros de Aluno**
	*  ctx passar contexto do view que esta em uso
	* @return ArrayList de Objeto da classe Aluno preenchidos**/
	public ArrayList<AlunoVO> getAllAluno(Context ctx) {
	AlunoDAO alunoDao = new AlunoDAO(ctx);
		return alunoDao. getAllAluno (); 
	}
	/***metodo de listar registro por Id de Aluno**
	*  ctx passar contexto do view que esta em uso**
	*  id passar o id que do registro a ser buscado
	* @return Objeto da classe Aluno preenchido**/
	public AlunoVO getAlunoById(Context ctx, long id) {
	AlunoDAO alunoDao = new AlunoDAO(ctx);
		if(id == 0 || id < 0){
			return null;
		}else{
			return alunoDao. getAlunoById (id);
		}
	}
	/***FIM Aluno****/

	}