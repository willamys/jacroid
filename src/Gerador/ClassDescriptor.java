package Gerador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassDescriptor
{
	private String name;
	private String tablename;



	private List<AttributeDescriptor> attributes = new ArrayList<AttributeDescriptor>();


	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public String toString(){
		return getName();
	}

	public void addAttribute(AttributeDescriptor attribute)
	{
		attributes.add(attribute);
	}

	public List<AttributeDescriptor> getAttributes()
	{
		return attributes;
	}

	public List<AttributeDescriptor> getAttributes2()
	{
		return Collections.unmodifiableList(attributes);
	}
}
