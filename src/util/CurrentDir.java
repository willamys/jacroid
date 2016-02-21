package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sun.org.apache.bcel.internal.generic.DMUL;

import vm.Messages;
import Gerador.ClassGenerator;

public class CurrentDir {

	public static String getDirAtual() {
		File dir1 = new File (".");
		//File dir2 = new File ("..");
		try {
			return dir1.getCanonicalPath();
			//System.out.println ("Diretório Pai: " + dir2.getCanonicalPath());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void transferDir(String origem, String destino){
		// Cria channel na origem
		try{
			FileChannel  oriChannel = new FileInputStream(origem).getChannel();
			// Cria channel no destino
			FileChannel destChannel = new FileOutputStream(destino).getChannel();
			// Copia conteúdo da origem no destino
			destChannel.transferFrom(oriChannel, 0, oriChannel.size());

			// Fecha channels
			oriChannel.close();
			destChannel.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void copyFilesToDir(InputStream source, FileOutputStream destination) throws IOException {  
		InputStream resource = source; //getClass().getClassLoader().getResourceAsStream(source);  
		if (resource == null)  
			throw new IOException("Resource not found: " + source);  
		BufferedInputStream input = new BufferedInputStream(resource);  

		BufferedOutputStream output = new BufferedOutputStream(destination);  

		byte[] buffer = new byte[1024];  
		int length;  
		while ((length = input.read(buffer)) > 0) {  
			output.write(buffer, 0, length);  
		}  

		output.close();  
		input.close();  
	} 

	public String[] getFileForDir(String Dir){
		File dir = new File(Dir);
		if(dir.exists()){
			return dir.list(); 
		}else{
			return null;
		}
	}

	public void startCopyFilesVM(){
		try {
			String[] arrayFile = getFileForDir(getDirAtual()+System.getProperty("file.separator")+"vm");
			ClassGenerator cgen =  new  ClassGenerator();
			cgen.createDirectories(getDirAtual()+System.getProperty("file.separator")+"vm_conf");
			for (int i = 0; i < arrayFile.length; i++) {
				FileOutputStream dest = new FileOutputStream(getDirAtual()+System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+arrayFile[i]);
				copyFilesToDir(Messages.class.getResourceAsStream("/vm/"+arrayFile[i]), dest );
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void startCopyFilesImg(){
		try {
			String[] arrayFile = getFileForDir(getDirAtual()+System.getProperty("file.separator")+"img");
			ClassGenerator cgen =  new  ClassGenerator();
			cgen.createDirectories(getDirAtual()+System.getProperty("file.separator")+"images");
			for (int i = 0; i < arrayFile.length; i++) {
				FileOutputStream dest = new FileOutputStream(getDirAtual()+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+arrayFile[i]);
				copyFilesToDir(Messages.class.getResourceAsStream("/img/"+arrayFile[i]), dest );
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public String getfile(){
		File tempDir = new File(System.getProperty("java.io.tmpdir")); 
		File temporaryFile = new File(tempDir, "classDAO.vm"); 
		InputStream templateStream = getClass().getResourceAsStream("/vm/classDAO.vm"); 
		//IOUtils.copy(templateStream, new FileOutputStream(temporaryFile)); 
		try {
			copyFilesToDir(templateStream, new FileOutputStream(temporaryFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String absolutePath = temporaryFile.getAbsolutePath();
		return absolutePath; 
	}
	
	public void createVmDir(String caminhoJar){
		File vmdir = new File(getDirAtual()+System.getProperty("file.separator")+"vm_conf");
		vmdir.mkdir();
		try {
			ZipFile zipFile = new ZipFile(caminhoJar);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) entries.nextElement();
				String name = zipEntry.getName();
				if (!zipEntry.isDirectory() && name.contains("vm")){
					System.out.println(name.substring(3));
					InputStream in = getClass().getResourceAsStream("/vm/"+name.substring(3));
					FileOutputStream out = new FileOutputStream(new File(getDirAtual()+System.getProperty("file.separator")+"vm_conf"+System.getProperty("file.separator")+name.substring(3)));
					copyFilesToDir(in, out);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void createImagesDir(String caminhoJar){
		File vmdir = new File(getDirAtual()+System.getProperty("file.separator")+"images");
		vmdir.mkdir();
		try {
			ZipFile zipFile = new ZipFile(caminhoJar);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) entries.nextElement();
				String name = zipEntry.getName();
				if (!zipEntry.isDirectory() && name.contains("img")){
					System.out.println(name.substring(4));
					InputStream in = getClass().getResourceAsStream("/img/"+name.substring(4));
					FileOutputStream out = new FileOutputStream(new File(getDirAtual()+System.getProperty("file.separator")+"images"+System.getProperty("file.separator")+name.substring(3)));
					copyFilesToDir(in, out);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// Copies all files under srcDir to dstDir.
	// If dstDir does not exist, it will be created.
	public void copyDirectory(File srcDir, File dstDir) throws IOException {
	    if (srcDir.isDirectory()) {
	        if (!dstDir.exists()) {
	            dstDir.mkdir();
	        }
	        String[] children = srcDir.list();
	        for (int i=0; i<children.length; i++) {
	            copyDirectory(new File(srcDir, children[i]),
	                                 new File(dstDir, children[i]));
	        }
	    } else {
	        // This method is implemented in Copying a File
	        copyFile(srcDir, dstDir);
	    }
	}
	
	public void deleteDirectory(File srcDir) throws IOException {
	    if (srcDir.isDirectory()) {
	    	if (srcDir.list() == null || srcDir.list().length == 0 ) {
				srcDir.delete();
			}else{
	        String[] children = srcDir.list();
	        for (int i=0; i<children.length; i++) {
	        	srcDir.delete();
	            deleteDirectory(new File(srcDir, children[i]));
	            srcDir.delete();
	        }
			}
	    } else {
	        // This method is implemented in Copying a File
		        srcDir.delete();
		    }  
	}
	
	public void copyFile(File source, File destination) throws IOException {  
		
		if(!destination.exists()){
			try {
				FileInputStream input = new FileInputStream(source);
				FileOutputStream output = new  FileOutputStream(destination);
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
	
	/***@param diretório passar o diretório para apagar arquivos**/
	public void limparArquivosAuxiliares(String dir) {
		File temp = new File(dir);
		if (temp.isDirectory()) {  
		    File[] sun = temp.listFiles();  
		    for (File toDelete : sun) {  
		        toDelete.delete();  
		    }  
		}
		temp.delete();
		
	}
}