package Gerador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.jdom.adapters.CrimsonDOMAdapter;

import util.CurrentDir;
import vm.Messages;


public class ClassGenerator
{
	/**@param String modelFile - endereço do arquivo .vm
	 * @param String pathXML - arquivo .xml a ser lido
	 * @param String nomeProjeto - nome do projeto
	 * @return Cria o projeto na pasta especificada pelo usuário
	 * **/
	public static void start(String modelFile, String pathXML, String nomeProjeto) throws Exception{
		try
		{
			// gerar classe do modelo 

			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classDAO.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"modelo"+System.getProperty("file.separator"),"DAO",".java");
			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classModel.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"modelo"+System.getProperty("file.separator"),"VO",".java");

			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classActivity.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"telas"+System.getProperty("file.separator"),"Activity",".java");
			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classCadastrarActivity.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"telas"+System.getProperty("file.separator"),"CadastrarActivity",".java");
			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classAlterarActivity.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"telas"+System.getProperty("file.separator"),"AlterarActivity",".java");
			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classListarActivity.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"telas"+System.getProperty("file.separator"),"ListarActivity",".java");
			genLayoutXML(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmlmainCrudActivity.vm",pathXML,nomeProjeto,"res"+System.getProperty("file.separator")+System.getProperty("file.separator")+"layout"+System.getProperty("file.separator"),"activity",".xml");
			genLayoutXML(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmlcadastrarActivity.vm",pathXML,nomeProjeto,"res"+System.getProperty("file.separator")+System.getProperty("file.separator")+"layout"+System.getProperty("file.separator"),"cadastraractivity",".xml");
			genLayoutXML(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmlalterarActivity.vm",pathXML,nomeProjeto,"res"+System.getProperty("file.separator")+System.getProperty("file.separator")+"layout"+System.getProperty("file.separator"),"alteraractivity",".xml");
			genLayoutXML(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmllistarActivity.vm",pathXML,nomeProjeto,"res"+System.getProperty("file.separator")+System.getProperty("file.separator")+"layout"+System.getProperty("file.separator"),"listaractivity",".xml");

			genClassesJAVA(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"iScriptBD.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"importscriptdb",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"importScriptDB.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"importScriptDB",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"importScriptDB1.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"importScriptDB1",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"importScriptDB2.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"importScriptDB2",".txt");

			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classConnection.vm","",modelFile,"src"+System.getProperty("file.separator")+"modelo"+System.getProperty("file.separator"),"Connection",".java");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classConnectionException.vm","",modelFile,"src"+System.getProperty("file.separator")+"modelo"+System.getProperty("file.separator"),"ConnectionException",".java");

			createDirectories(nomeProjeto+System.getProperty("file.separator")+"assets");
			createDirectories(nomeProjeto+System.getProperty("file.separator")+"src-mod");
			createDirectories(nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"drawable-hdpi");
			getImgDefault("images"+System.getProperty("file.separator")+"icon.png",nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"drawable-hdpi"+System.getProperty("file.separator")+"ico.png");
			createDirectories(nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"drawable-ldpi");
			getImgDefault("images"+System.getProperty("file.separator")+"icon.png",nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"drawable-ldpi"+System.getProperty("file.separator")+"ico.png");
			createDirectories(nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"drawable-mdpi");
			getImgDefault("images"+System.getProperty("file.separator")+"icon.png",nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"drawable-mdpi"+System.getProperty("file.separator")+"ico.png");
			createDirectories(nomeProjeto+System.getProperty("file.separator")+"res"+System.getProperty("file.separator")+"values"+System.getProperty("file.separator"));

			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"metodosFachada.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"metodos",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"importsFachada.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"imports",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"buttons_main.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"buttons_main",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"buttonsMain.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"buttons_main_activity",".txt");
			genClassesMenu(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"include_android_manifest.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp"+System.getProperty("file.separator"),"include_android_manifest",".txt");

			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmlmainActivity.vm",pathXML,nomeProjeto,"res"+System.getProperty("file.separator")+System.getProperty("file.separator")+"layout"+System.getProperty("file.separator"),"main",".xml");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classFachada.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator"),"Fachada",".java");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classMainActivity.vm",pathXML,nomeProjeto,"src"+System.getProperty("file.separator")+"telas"+System.getProperty("file.separator"),"Main",".java");

			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"proguard.vm",pathXML,nomeProjeto,"","proguard",".cfg");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"defaultproperties.vm",pathXML,nomeProjeto,"","default",".properties");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"androidmanifest.vm",pathXML,nomeProjeto,"","AndroidManifest",".xml");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmlstrings.vm",pathXML,modelFile,"res"+System.getProperty("file.separator")+"values"+System.getProperty("file.separator"),"strings",".xml");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"xmlarrays.vm",pathXML,nomeProjeto,"res"+System.getProperty("file.separator")+"values"+System.getProperty("file.separator"),"arrays",".xml");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"classpath.vm",pathXML,nomeProjeto,"",".","classpath");
			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"project.vm",pathXML,modelFile,"",".","project");

			//criar src para o usuário modificar
			//criar_diretorios(nomeProjeto+"src"+System.getProperty("file.separator")+"my_package"+System.getProperty("file.separator"));

			genClassesDefault(System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+"TwoDScrollView.vm","",modelFile,"src"+System.getProperty("file.separator")+"my_package"+System.getProperty("file.separator"),"TwoDScrollView",".java");

			cleanFilesAux("."+System.getProperty("file.separator")+nomeProjeto+System.getProperty("file.separator")+"src"+System.getProperty("file.separator")+"fachada"+System.getProperty("file.separator")+"temp");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/***@param String dir - passar o diretorio para apagar arquivos**/
	private static void cleanFilesAux(String dir) {
		File temp = new File(dir);
		if (temp.isDirectory()) {  
			File[] sun = temp.listFiles();  
			for (File toDelete : sun) {  
				toDelete.delete();  
			}  
		}
		temp.delete();

	}

	/***Metodo para criar diretorio do projeto*
	 * *
	 * @param nomeProjeto
	 */
	public static void createDirectoryProject(String nomeProjeto){
		File modelo_projeto =  new File(nomeProjeto);
		if(!modelo_projeto.exists()){
			modelo_projeto.mkdir();
		} 
	} 
	/***
	 * Metodo para criar os diretorios
	 * @param path
	 */
	public static void createDirectories(String path) {
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	/***
	 * Obter imagens default do projeto Android
	 * @param path_origem 
	 * @param path_destino
	 */
	public static void getImgDefault(String path_origem, String path_destino) {

		CurrentDir cd = new CurrentDir();
		cd.getDirAtual();
		File file_origem =  new File(path_origem);
		File file_destino =  new File(path_destino);

		if(!file_destino.exists()){
			try {
				FileInputStream input = new FileInputStream(file_origem);
				FileOutputStream output = new  FileOutputStream(file_destino);
				int c;
				while ((c = input.read())!= -1) {
					output.write(c);
				}
				input.close();
				output.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/****
	 * Gerar Classes  
	 * @param templateFile - endereco do template .vm
	 * @param modelFile - arquivo .xml
	 * @param nomeProjeto - nome do projeto
	 * @param packageClass - pacato da classe
	 * @param compleNome - nome diferencial para classe
	 * @param extensao - complemento do nome do arquivo *.java
	 * @throws Exception
	 */
	public static void gerarClasses(String templateFile,String modelFile,String nomeProjeto,String packageClass, String compleNome, String extensao) throws Exception{

		List<ClassDescriptor> classes = new ArrayList<ClassDescriptor>();	
		classes = ReadXML.read(modelFile);

		createDirectoryProject(nomeProjeto);

		GeneratorUtility utility = new GeneratorUtility();
		for (int i = 0; i < classes.size(); i++)
		{ 
			VelocityContext context = new VelocityContext();

			ClassDescriptor cl = (ClassDescriptor) classes.get(i);
			context.put("nome_projeto", nomeProjeto);
			context.put("class", cl);
			context.put("utility", utility);

			Template template = Velocity.getTemplate(templateFile);

			//criar o diretorio que ir� receber as classes do modelo

			File modelo = new File(nomeProjeto+"//"+packageClass);
			modelo.mkdirs();

			//adiciona as classes ao diretorio
			BufferedWriter writer = new BufferedWriter(new FileWriter(nomeProjeto+"//"+packageClass+compleNome+cl.getName()
			+ extensao));

			template.merge(context, writer);
			writer.flush();
			writer.close();

			System.out.println("Class " + cl.getName() + " was generated!");
		}
	}
	/****
	 * Gerar Classes  
	 * @param templateFile - endereco do template .vm
	 * @param modelFile - arquivo .xml
	 * @param nomeProjeto - nome do projeto
	 * @param packageClass - pacato da classe
	 * @param compleNome - nome diferencial para classe
	 * @param extensao - complemento do nome do arquivo *.java
	 * @throws Exception
	 */
	public static void genClassesJAVA(String templatefile,String modelFile,String nomeProjeto,String packageClass, String compleNome, String extensao) throws Exception{

		System.out.println(templatefile);

		List<ClassDescriptor> classes = new ArrayList<ClassDescriptor>();	
		classes = ReadXML.read(modelFile);

		createDirectoryProject(nomeProjeto);

		GeneratorUtility utility = new GeneratorUtility();
		for (int i = 0; i < classes.size(); i++)
		{
			VelocityContext context = new VelocityContext();
			ClassDescriptor cl = (ClassDescriptor) classes.get(i);
			context.put("nome_projeto", nomeProjeto);
			context.put("class", cl);
			context.put("utility", utility);

			Template template = Velocity.getTemplate(templatefile);

			//criar o diretorio que ir� receber as classes do modelo

			File modelo = new File(nomeProjeto+"//"+packageClass);
			modelo.mkdirs();

			//adiciona as classes ao diretorio
			BufferedWriter writer = new BufferedWriter(new FileWriter(nomeProjeto+"//"+packageClass + Gerador.GeneratorUtility.firstToUpperCase(cl.getName())+compleNome
					+ extensao));

			template.merge(context, writer);
			writer.flush();
			writer.close();

			System.out.println("Class " + cl.getName() + " was generated!");
		}
	}
	/****
	 * Gerar XML Layout Android  
	 * @param templateFile - endereco do template .vm
	 * @param modelFile - arquivo .xml
	 * @param nomeProjeto - nome do projeto
	 * @param packageClass - pacato da classe
	 * @param compleNome - nome diferencial para classe
	 * @param extensao - complemento do nome do arquivo *.java
	 * @throws Exception
	 */
	public static void genLayoutXML(String templateFile,String modelFile,String nomeProjeto,String packageClass, String compleNome, String extensao) throws Exception{

		List<ClassDescriptor> classes = new ArrayList<ClassDescriptor>();	
		classes = ReadXML.read(modelFile);

		createDirectoryProject(nomeProjeto);

		GeneratorUtility utility = new GeneratorUtility();
		for (int i = 0; i < classes.size(); i++)
		{
			VelocityContext context = new VelocityContext();
			ClassDescriptor cl = (ClassDescriptor) classes.get(i);
			context.put("nome_projeto", nomeProjeto);
			context.put("class", cl);
			context.put("utility", utility);

			Template template = Velocity.getTemplate(templateFile);

			//criar o diretorio que ir� receber as classes do modelo

			File modelo = new File(nomeProjeto+"//"+packageClass);
			modelo.mkdirs();

			//adiciona as classes ao diretorio
			BufferedWriter writer = new BufferedWriter(new FileWriter(nomeProjeto+"//"+packageClass+utility.firstToLowerCase(cl.getName())+compleNome
					+ extensao));
			template.merge(context, writer);

			writer.flush();
			writer.close();

			System.out.println("Class " + cl.getName() + "was generated!");
		}
	}

	/****
	 * Gerar Classes sem loop de classes declaradas no .xml
	 * @param templateFile - endereco do template .vm
	 * @param modelFile - arquivo .xml
	 * @param nomeProjeto - nome do projeto
	 * @param packageClass - pacato da classe
	 * @param compleNome - nome diferencial para classe
	 * @param extensao - complemento do nome do arquivo *.java
	 * @throws Exception
	 */
	public static void genClassesMenu(String templateFile,String modelFile,String nomeProjeto,String packageClass, String compleNome, String extensao) throws Exception{

		List<ClassDescriptor> classes = new ArrayList<ClassDescriptor>();	
		classes = ReadXML.read_class(modelFile);

		createDirectoryProject(nomeProjeto);

		File modelo = new File(nomeProjeto+"//"+packageClass);
		modelo.mkdirs();

		BufferedWriter writer = new BufferedWriter(new FileWriter(nomeProjeto+"//"+packageClass+compleNome+extensao));

		GeneratorUtility utility = new GeneratorUtility();
		for (int i = 0; i < classes.size(); i++)
		{

			VelocityContext context = new VelocityContext();
			ClassDescriptor cl = (ClassDescriptor) classes.get(i);
			context.put("nome_projeto", nomeProjeto);
			context.put("class", cl);
			context.put("utility", utility);

			Template template = Velocity.getTemplate(templateFile);

			//criar o diretorio que ir� receber as classes do modelo

			//adiciona as classes ao diretorio             

			template.merge(context, writer);

			System.out.println("Class " + cl.getName() + " generated!");
		}
		writer.flush();
		writer.close();
	}

	/****
	 * Gerar Classes Default
	 * @param templateFile - endereco do template .vm
	 * @param modelFile - arquivo .xml
	 * @param nomeProjeto - nome do projeto
	 * @param packageClass - pacato da classe
	 * @param compleNome - nome diferencial para classe
	 * @param extensao - complemento do nome do arquivo *.java
	 * @throws Exception
	 */
	public static void genClassesDefault(String templateFile,String modelFile,String nomeProjeto,String packageClass, String compleNome, String extensao) throws Exception{
		createDirectoryProject(nomeProjeto);
		File modelo = new File(nomeProjeto+"//"+packageClass);
		modelo.mkdir();
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomeProjeto+"//"+packageClass+compleNome+extensao));
		VelocityContext context = new VelocityContext();
		context.put("nome_projeto", nomeProjeto);
		Template template = Velocity.getTemplate(templateFile);
		template.merge(context, writer);	 
		writer.flush();
		writer.close();
		System.out.println("Class Defaults "+compleNome+"."+extensao+ " was generated!");
	}


	/******Mostrar ******/
	public static void gerarClassesDefault2(String templateFile,String modelFile,String nomeProjeto,String packageClass, String compleNome, String extensao) throws Exception{
		createDirectoryProject(nomeProjeto);
		File modelo = new File(nomeProjeto+"//"+packageClass);
		modelo.mkdir();

		File ft = new File(nomeProjeto+"//"+packageClass+compleNome+extensao);

		VelocityContext context = new VelocityContext();
		context.put("nome_projeto", nomeProjeto);

		Template template = Velocity.getTemplate(templateFile);

		if(ft.exists()){
			VelocityContext context1 = new VelocityContext();
			//context1.
		}else{

			BufferedWriter writer = new BufferedWriter(new FileWriter(nomeProjeto+"//"+packageClass+compleNome+extensao));
			template.merge(context, writer);	 
			writer.flush();
			writer.close();
			System.out.println("Class Defaults "+compleNome+"."+extensao+ " was generated!");
		}
	}

	/*
	public static void main(String[] args)
	{
		try
		{
			// gerar classe do modelo 
			gerarClassesJAVA("./src/VM_Android/classDAO.vm","./src/classes3.xml","Android","src/modelo/","DAO",".java");
			gerarClassesJAVA("./src/VM_Android/classModel.vm","./src/classes3.xml","Android","src/modelo/","VO",".java");

			//telas Activity
			gerarClassesJAVA("./src/VM_Android/classActivity.vm","./src/classes3.xml","Android","src/telas/","Activity",".java");
			gerarClassesJAVA("./src/VM_Android/classCadastrarActivity.vm","./src/classes3.xml","Android","src/telas/","CadastrarActivity",".java");
			gerarClassesJAVA("./src/VM_Android/classAlterarActivity.vm","./src/classes3.xml","Android","src/telas/","AlterarActivity",".java");
			gerarClassesJAVA("./src/VM_Android/classListarActivity.vm","./src/classes3.xml","Android","src/telas/","ListarActivity",".java");
			gerarLayoutXML("./src/VM_Android/xmlmainCrudActivity.vm","./src/classes3.xml","Android","res//layout/","activity",".xml");
			gerarLayoutXML("./src/VM_Android/xmlcadastrarActivity.vm","./src/classes3.xml","Android","res//layout/","cadastraractivity",".xml");
			gerarLayoutXML("./src/VM_Android/xmlalterarActivity.vm","./src/classes3.xml","Android","res//layout/","alteraractivity",".xml");
			gerarLayoutXML("./src/VM_Android/xmllistarActivity.vm","./src/classes3.xml","Android","res//layout/","listaractivity",".xml");

			gerarClassesDefault("./src/VM_Android/classConection.vm","","Android","src/modelo/","Connection",".java");

			criar_diretorios("Android/assets");
			criar_diretorios("Android/res/drawable-hdpi");
			pegar_images_default("images/icon.png","Android/res/drawable-hdpi/ico.png");
			criar_diretorios("Android/res/drawable-ldpi");
			pegar_images_default("images/icon.png","Android/res/drawable-ldpi/ico.png");
			criar_diretorios("Android/res/drawable-mdpi");
			pegar_images_default("images/icon.png","Android/res/drawable-mdpi/ico.png");
			criar_diretorios("Android/res/values/");
			gerarClassesMenu("./src/VM_Android/metodosFachada.vm","./src/classes3.xml","Android","src/fachada/","metodos",".txt");
			gerarClassesMenu("./src/VM_Android/importsFachada.vm","./src/classes3.xml","Android","src/fachada/","imports",".txt");
			gerarClassesMenu("./src/VM_Android/buttons_main.vm","./src/classes3.xml","Android","src/fachada/","buttons_main",".txt");
			gerarClassesMenu("./src/VM_Android/buttonsMain.vm","./src/classes3.xml","Android","src/fachada/","buttons_main_activity",".txt");
			gerarClassesMenu("./src/VM_Android/include_android_manifest.vm","./src/classes3.xml","Android","src/fachada/","include_android_manifest",".txt");
			// gerar menu do administrador
			gerarClassesDefault("./src/VM_Android/xmlmainActivity.vm","./src/classes3.xml","Android","res//layout/","main",".xml");
			gerarClassesDefault("./src/VM_Android/classFachada.vm","./src/classes3.xml","Android","src/fachada/","Fachada",".java");
			gerarClassesDefault("./src/VM_Android/classMainActivity.vm","./src/classes3.xml","Android","src/telas/","Main",".java");

			gerarClassesDefault("./src/VM_Android/proguard.vm","./src/classes3.xml","Android","","proguard",".cfg");
			gerarClassesDefault("./src/VM_Android/defaultproperties.vm","./src/classes3.xml","Android","","default",".properties");
			gerarClassesDefault("./src/VM_Android/androidmanifest.vm","./src/classes3.xml","Android","","AndroidManifest",".xml");
			gerarClassesDefault("./src/VM_Android/xmlstrings.vm","./src/classes3.xml","Android","res/values/","strings",".xml");
			gerarClassesDefault("./src/VM_Android/xmlarrays.vm","./src/classes3.xml","Android","res/values/","arrays",".xml");
			gerarClassesDefault("./src/VM_Android/classpath.vm","./src/classes3.xml","Android","",".","classpath");
			gerarClassesDefault("./src/VM_Android/project.vm","./src/classes3.xml","Android","",".","project");

			//apagar arquivos auxiliares
			File file_metodo = new File("./Android/src/fachada/metodos.txt");
			File file_imports = new File("./Android/src/fachada/imports.txt");
			File file_buttons_main = new File("./Android/src/fachada/buttons_main.txt");
			File file_buttons_main_activity = new File("./Android/src/fachada/buttons_main_activity.txt");
			File file_include_android_manifest = new File("./Android/src/fachada/include_android_manifest.txt");
			file_imports.delete();
			file_metodo.delete();
			file_buttons_main.delete();
			file_buttons_main_activity.delete();
			file_include_android_manifest.delete();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	 */
}