package Gerador;


public class AttributeDescriptor
{
	private String name;
	private String typeData;
	private boolean isColumn;
	private String classname;
	private String input;
	private boolean primaryKey;
	private boolean primaryKey_table;
	private String columntable;
	private String exhibitionname;


	public String getColumntable() {
		return columntable;
	}

	public void setColumntable(String columntable) {
		this.columntable = columntable;
	}

	public String getExhibitionname() {
		return exhibitionname;
	}

	public void setExhibitionname(String exhibitionname) {
		this.exhibitionname = exhibitionname;
	}
	public boolean isPrimaryKey_table() {
		return primaryKey_table;
	}

	public void setPrimaryKey_table(boolean primaryKey_table) {
		this.primaryKey_table = primaryKey_table;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}
	/**@param true ou false
	 * */
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getClassname() {
		return classname;
	}
	/**@param nome da classe
	 * */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	public boolean isColumn()
	{
		return isColumn;
	}
	/**@param true ou false
	 * */
	public void setColumn(boolean isColumn)
	{
		this.isColumn = isColumn;
	}

	/**@param nome do atributo
	 * */
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	/**@param int / String / Boolean / Float
	 * */
	public void setTypeData(String type)
	{
		this.typeData = type;
	}

	public String getTypeData()
	{
		return typeData;
	}

	public String getInput() {
		return input;
	}
	/**@param usado em web 
	 * hidden / text / select / checkbox / text_word / file 
	 * */
	public void setInput(String input) {
		this.input = input;
	}

	public String toString() {  
		return getName();  
	}  


}