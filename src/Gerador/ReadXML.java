package Gerador;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class ReadXML {

	
	public static ArrayList<ClassDescriptor> read(String nameXML){
		ArrayList<ClassDescriptor> listaAttributes = new ArrayList<ClassDescriptor>();	
			try {
			
		    	String comHTML = nameXML;
		    	
		    	InputStream is = new FileInputStream(nameXML); 
		    	
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
				DocumentBuilder builder = factory.newDocumentBuilder(); 
				Document doc = builder.parse(is);
				
				NodeList itemList = doc.getElementsByTagName("class");
				for (int j=0; j<itemList.getLength(); j++){ 
					Element item = (Element)itemList.item(j); 
					String classname = item.getAttribute("classname");
					String tablename = item.getAttribute("tablename");
					ClassDescriptor cl = new ClassDescriptor();
					NodeList attributeList = item.getElementsByTagName("attributes");
					for (int i = 0; i < attributeList.getLength(); i++) {
						Element itemAtt = (Element) attributeList.item(i);
						String classname_att = itemAtt.getAttribute("classname");
						String name = itemAtt.getAttribute("name");
						String type = itemAtt.getAttribute("type");
						String input = itemAtt.getAttribute("input");
						String columntable = itemAtt.getAttribute("columntable");
						String exhibitionname = itemAtt.getAttribute("exhibitionname");
						Boolean primaryKey = Boolean.parseBoolean(itemAtt.getAttribute("primarykey"));
						Boolean primaryKey_table = Boolean.parseBoolean(itemAtt.getAttribute("primarykey_table"));
						Boolean isColumn = Boolean.parseBoolean(itemAtt.getAttribute("column"));
						AttributeDescriptor attribute = new AttributeDescriptor();
						cl.setName(classname);
						cl.setTablename(tablename);
						attribute.setColumntable(columntable);
						attribute.setExhibitionname(exhibitionname);
						attribute.setClassname(classname_att);
						attribute.setName(name);
						attribute.setTypeData(type);
						attribute.setColumn(isColumn);
						attribute.setPrimaryKey(primaryKey);
						attribute.setPrimaryKey_table(primaryKey_table);
						attribute.setInput(input);
						cl.addAttribute(attribute);
						listaAttributes.add(cl);
					}
			    }	
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("N„o possÌvel ler o arquivo XML.");
			}
			return listaAttributes;
	}
	
	public static ArrayList<ClassDescriptor> read_class(String nameXML){
		ArrayList<ClassDescriptor> listaAttributes = new ArrayList<ClassDescriptor>();	
			try {
			
		    	String comHTML = nameXML;
		    	
		    	InputStream is = new FileInputStream(nameXML); 
		    	
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
				DocumentBuilder builder = factory.newDocumentBuilder(); 
				Document doc = builder.parse(is);
				
				NodeList itemList = doc.getElementsByTagName("class");
				for (int j=0; j<itemList.getLength(); j++){ 
					Element item = (Element)itemList.item(j); 
					String classname = item.getAttribute("classname");
					ClassDescriptor cl = new ClassDescriptor();
						AttributeDescriptor attribute = new AttributeDescriptor();
						cl.setName(classname);
						attribute.setClassname(classname);
						cl.addAttribute(attribute);
						listaAttributes.add(cl);
					}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("N„o possÌvel ler o arquivo XML.");
			}
			return listaAttributes;
	}
	
	/*public static void main(String[] args) {
		Iterator<ClassDescriptor> list =  read("./bin/classes.xml").iterator();
		while(list.hasNext()){
			ClassDescriptor att = list.next();
			System.out.println("Nome da Classe:"+att.getAttributes(). +"\nAtributos"
					+ "\nNome do Atributo:" +att.getName() +"\nTipo Atributo:"+ att.getType()
					+ "\n… uma coluna:" +att.isColumn());
		}
		}
		*/
}