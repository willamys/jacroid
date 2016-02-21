package Telas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import util.UnaccentedDocument;
import util.UnaccentedLowerCaseDocument;
import util.UnaccentedNoSpace;
import Gerador.ClassDescriptor;
import Gerador.GeneratorUtility;


/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * 
 */
public class DlgAlterarDados extends JDialog
{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;


	private JLabel lblNome = null;
	private JComboBox cmbNome = null;
	private JTextField txtIdade = null;

	private JLabel jLabel1;
	private JSeparator jSeparator1= null;
	private JLabel jlNomeClasse= null;
	private JLabel jlNomeAtributo= null;
	private JLabel jlTipo= null;
	private JComboBox jcChaveEstrangeira= null;
	private JComboBox jcTipoComponente= null;
	private JTextField jtNomeColunaBd;
	private JTextField jtNomeDeExibicao;
	private JLabel jlNomeDaColuna;
	private JLabel jlNomeDeExibicao;
	private  JComboBox jcColuna= null;
	private JComboBox jcChavePrimaria= null;
	private JComboBox jcTipo= null;
	private JButton btnOk = null;
	private JButton btnCancelar = null;
	private JLabel jlChaveEstrangeira= null;
	private JLabel jlTipoComponente= null;
	private JLabel jlColuna= null;
	private JLabel jlChavePrimaria= null;
	private JTextField jtNomeAtributo= null;


	private String NomeClasse;

	public String getNomeClasse() {
		return NomeClasse;
	}

	public void setNomeClasse(String nome_classe) {
		this.NomeClasse = nome_classe;
	}

	protected boolean okSelecionado;
	/**
	 * @param owner
	 */
	public DlgAlterarDados(Frame owner, String nome)
	{
		super(owner);
		initialize(nome);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize(String nome)
	{
		this.setSize(411, 332);
		this.setTitle("Add Atributo");
		this.NomeClasse = nome;
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane()
	{
		if (jContentPane == null)
		{

			jLabel1 = new JLabel();
			jLabel1.setText("Nome da Classe:");
			jLabel1.setBounds(8, 12, 88, 16);

			jSeparator1 = new JSeparator();
			jSeparator1.setBounds(0, 36, 398, 11);

			jlNomeClasse = new JLabel();

			jlNomeClasse.setBounds(103, 12, 190, 16);
			jlNomeClasse.setFont(new java.awt.Font("Segoe UI",1,14));
			jlNomeClasse.setText(NomeClasse);

			jlNomeAtributo = new JLabel();
			jlNomeAtributo.setText("Nome Atributo:");
			jlNomeAtributo.setBounds(8, 54, 88, 16);

			jlTipo = new JLabel();
			jlTipo.setText("Tipo:");
			jlTipo.setBounds(8, 140, 44, 16);

			lblNome = new JLabel();
			lblNome.setText("Nome do usuário:");

			jlChavePrimaria = new JLabel();

			jlChavePrimaria.setText("Chave Primária:");
			jlChavePrimaria.setBounds(8, 166, 121, 16);
			jlChavePrimaria.setVisible(false);

			jlColuna = new JLabel();

			jlColuna.setText("Coluna no BD:");
			jlColuna.setBounds(8, 196, 76, 16);

			jlTipoComponente = new JLabel();

			jlTipoComponente.setText("Tipo de Componente:");
			jlTipoComponente.setBounds(8, 168, 125, 16);

			jlChaveEstrangeira = new JLabel();

			jlChaveEstrangeira.setText("Chave Estrangeira:");
			jlChaveEstrangeira.setBounds(8, 194, 101, 16);
			jlChaveEstrangeira.setVisible(false);

			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel1);
			jContentPane.add(jSeparator1);
			jContentPane.add(jlNomeClasse);
			jContentPane.add(jlNomeAtributo);
			jContentPane.add(jlTipo);
			jContentPane.add(jlChavePrimaria);
			jContentPane.add(jlColuna);
			jContentPane.add(jlTipoComponente);
			jContentPane.add(jlChaveEstrangeira);

			jContentPane.add(getJtNomeAtributo());
			jContentPane.add(getJcTipo());
			jContentPane.add(getJcChaveEstrangeira());
			jContentPane.add(getJcColuna());
			jContentPane.add(getJcTipoComponente());
			jContentPane.add(getJcChavePrimaria());
			jContentPane.add(getBtnOk());
			jContentPane.add(getBtnCancelar());
			jContentPane.add(getJlNomeDeExibicao());
			jContentPane.add(getJlNomeDaColuna());
			jContentPane.add(getJtNomeDeExibicao());
			jContentPane.add(getJtNomeColunaBd());
		}
		return jContentPane;
	}

	public JTextField getJtNomeAtributo() {
		if(jtNomeAtributo == null ){
			jtNomeAtributo = new JTextField();
			jtNomeAtributo.setBounds(103, 49, 179, 23);
			jtNomeAtributo.setDocument(new UnaccentedNoSpace());
		}
		return jtNomeAtributo;
	}

	public void setJtnome_atributo(JTextField jtnome_atributo) {

		this.jtNomeAtributo = jtnome_atributo;
	}


	public JComboBox getJcChaveEstrangeira() {
		if(jcChaveEstrangeira == null){
			jcChaveEstrangeira = new JComboBox();

			jcChaveEstrangeira.setBounds(109, 191, 103, 23);
			jcChaveEstrangeira.setToolTipText("Escolha a classe referente a chave estrangeria.");
			jcChaveEstrangeira.setVisible(false);
			ComboBoxModel jComboBox2Model = 
				new DefaultComboBoxModel(
						new String[] { "" });
			jcChaveEstrangeira = new JComboBox();
			jcChaveEstrangeira.setModel(jComboBox2Model);
		}
		return jcChaveEstrangeira;
	}

	public void setJcchave_estrangeira(JComboBox jcchave_estrangeira) {
		this.jcChaveEstrangeira = jcchave_estrangeira;
	}

	public JComboBox getJcTipoComponente() {
		if(jcTipoComponente == null){
			ComboBoxModel jComboBox4Model = 
				new DefaultComboBoxModel(
						new String[] { ""});
			jcTipoComponente = new JComboBox();

			jcTipoComponente.setModel(jComboBox4Model);
			jcTipoComponente.setBounds(129,168, 112, 23);
		}
		return jcTipoComponente;
	}

	public void setJctipo_componente(JComboBox jctipo_componente) {
		this.jcTipoComponente = jctipo_componente;
	}

	public JComboBox getJcColuna() {

		if(jcColuna == null){
			ComboBoxModel jComboBox3Model = 
				new DefaultComboBoxModel(
						new String[] { "","true", "false" });
			jcColuna = new JComboBox();
			jcColuna.setModel(jComboBox3Model);
			jcColuna.setBounds(102, 196, 110, 23);
		}
		return jcColuna;

	}

	public void setJccoluna(JComboBox jccoluna) {
		this.jcColuna = jccoluna;
	}

	public JComboBox getJcChavePrimaria() {
		if(jcChavePrimaria == null){
			ComboBoxModel jComboBox2Model = 
				new DefaultComboBoxModel(
						new String[] {"false"});
			jcChavePrimaria = new JComboBox();
			jcChavePrimaria.setEnabled(false);
			jcChavePrimaria.setVisible(false);
			jcChavePrimaria.setModel(jComboBox2Model);
			jcChavePrimaria.setBounds(100,  163, 83, 22);

		}
		return jcChavePrimaria;
	}

	public void setJcchave_primaria(JComboBox jcchave_primaria) {
		this.jcChavePrimaria = jcchave_primaria;
	}

	public JComboBox getJcTipo() {
		if(jcTipo == null ){
			ComboBoxModel jComboBox1Model = 
				new DefaultComboBoxModel(
						new String[] { "","Boolean", "int","Long","String" });
			jcTipo = new JComboBox();
			jcTipo.setModel(jComboBox1Model);
			jcTipo.setBounds(46, 138, 94, 22);
			jcTipo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(jcTipo.getSelectedItem().equals("Boolean")){
						jcTipoComponente.removeAllItems();
						jcTipoComponente.addItem("checkbox");
					}else if(jcTipo.getSelectedItem().equals("int") || jcTipo.getSelectedItem().equals("Long")){
						jcTipoComponente.removeAllItems();
						jcTipoComponente.addItem("text");
					}else if(jcTipo.getSelectedItem().equals("String")){
						jcTipoComponente.removeAllItems();
						jcTipoComponente.addItem("radiobutton");
						jcTipoComponente.addItem("select");
						jcTipoComponente.addItem("text");
					}else{
						jcTipoComponente.removeAllItems();
					}
				}
			});
		}
		return jcTipo;
	}

	private JLabel getJlNomeDeExibicao() {
		if(jlNomeDeExibicao == null) {
			jlNomeDeExibicao = new JLabel();
			jlNomeDeExibicao.setText("Nome de Exibição:");
			jlNomeDeExibicao.setBounds(8, 83, 98, 16);
			
		}
		return jlNomeDeExibicao;
	}

	private JLabel getJlNomeDaColuna() {
		if(jlNomeDaColuna == null) {
			jlNomeDaColuna = new JLabel();
			jlNomeDaColuna.setText("Nome da Coluna BD:");
			jlNomeDaColuna.setBounds(8, 112, 111, 16);
		}
		return jlNomeDaColuna;
	}

	private JTextField getJtNomeDeExibicao() {
		if(jtNomeDeExibicao == null) {
			jtNomeDeExibicao = new JTextField();
			jtNomeDeExibicao.setBounds(118, 78, 157, 23);
			jtNomeDeExibicao.setDocument(new UnaccentedDocument());
		}
		return jtNomeDeExibicao;
	}

	private JTextField getJtNomeColunaBd() {
		if(jtNomeColunaBd == null) {
			jtNomeColunaBd = new JTextField();
			jtNomeColunaBd.setBounds(125, 110, 150, 23);
			jtNomeColunaBd.setDocument(new UnaccentedLowerCaseDocument());
		}
		return jtNomeColunaBd;
	}

	/**
	 * This method initializes btnOk	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnOk()
	{
		if (btnOk == null)
		{
			btnOk = new JButton();
			btnOk.setText("Ok");
			btnOk.setBounds(67, 258, 106, 23);
			btnOk.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					if(validation() == true){
						okSelecionado = true; //Dizemos que o ok foi selecionado.
						setVisible(false);
					}
				}
			});
		}
		return btnOk;
	}

	/**
	 * This method initializes btnCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCancelar()
	{
		if (btnCancelar == null)
		{
			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(205, 258, 106, 23);
			btnCancelar.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					//Fechamos a janela diretamente. 
					//Não há necessidade de dizer que o ok não foi selecionado.
					setVisible(false);
				}
			});
		}
		return btnCancelar;
	}

	public boolean alterarDados()    
	{        
		okSelecionado = false;  //Marcamos que o ok não foi selecionado
		setModal(true);         //A dialog tem que ser modal. Só pode retornar do setVisible após ficar invisível.
		setVisible(true);  //Mostramos a dialog e esperamos o usuário escolher alguma coisa.
		return okSelecionado;   //Retornamos true, se ele pressionou ok.
	}

	public boolean validation(){
		String campos = "";
		if(!(jtNomeAtributo.getText().equalsIgnoreCase("") || jtNomeAtributo.getText() == null) && 
				!(jtNomeAtributo.getText().equalsIgnoreCase("") || jtNomeAtributo.getText() == null) &&
				!(jcChavePrimaria.getSelectedItem().toString().equalsIgnoreCase("") || jcChavePrimaria.getSelectedItem() == null)&&
				!(jcTipo.getSelectedItem().toString().equalsIgnoreCase("") || jcTipo.getSelectedItem() == null)&&
				!(jcColuna.getSelectedItem().toString().equalsIgnoreCase("") || jcColuna.getSelectedItem() == null)&&
				!(jcTipoComponente.getSelectedItem().toString().equalsIgnoreCase("") || jcTipoComponente.getSelectedItem() == null)&&
				!(jtNomeColunaBd.getText().equalsIgnoreCase("") || jtNomeColunaBd.getText() == null)&&
				!(jtNomeDeExibicao.getText().equalsIgnoreCase("") || jtNomeDeExibicao.getText() == null)){

			if(jcTipoComponente.getSelectedItem().toString().equalsIgnoreCase("select")){
				if(!jcTipo.getSelectedItem().toString().equalsIgnoreCase("String")){
					JOptionPane.showMessageDialog(null,"Para adicionar um componente como 'Select' \n" +
					"é necessário que o mesmo tenha como tipo de dado 'String'.");
					return false;
				}else{
					return true;
				}
			}else if(jcTipoComponente.getSelectedItem().toString().equalsIgnoreCase("checkbox")){
				if(!jcTipo.getSelectedItem().toString().equalsIgnoreCase("Boolean")){
					JOptionPane.showMessageDialog(null,"Para adicionar um componente como 'CheckBox' \n" +
					"é necessário que o mesmo tenha como tipo de dado 'Boolean'.");
					return false;
				}else{
					return true;
				}
			}else if(jcTipoComponente.getSelectedItem().toString().equalsIgnoreCase("radiobutton")){
				if(!jcTipo.getSelectedItem().toString().equalsIgnoreCase("String")){
					JOptionPane.showMessageDialog(null,"Para adicionar um componente como 'RadioButton' \n" +
					"é necessário que o mesmo tenha como tipo de dado 'String'.");
					return false;
				}else{
					return true;
				}
			}else if(jcTipoComponente.getSelectedItem().toString().equalsIgnoreCase("text")){
				if(jcTipo.getSelectedItem().toString().equalsIgnoreCase("Boolean")){
					JOptionPane.showMessageDialog(null,"Para adicionar um componente como 'Text' \n" +
					"é necessário que o mesmo tenha como tipo de dado 'String','int' ou 'Long'.");
					return false;
				}else{
					return true;
				}
			}else{
				return true;
			}
		}else{
			if(jtNomeAtributo.getText().equalsIgnoreCase("") || jtNomeAtributo.getText() == null){
				campos = campos + jlNomeAtributo.getText()+"\n";
			}if(jcChavePrimaria.getSelectedItem().toString().equalsIgnoreCase("") || jcChavePrimaria.getSelectedItem() == null){
				campos = campos + jlChavePrimaria.getText()+"\n";
			}if(jcTipo.getSelectedItem().toString().equalsIgnoreCase("") || jcTipo.getSelectedItem() == null){
				campos = campos + jlTipo.getText()+"\n";
			}if(jcColuna.getSelectedItem().toString().equalsIgnoreCase("") || jcColuna.getSelectedItem() == null){
				campos = campos + jlColuna.getText()+"\n";
			}if(jcTipoComponente.getSelectedItem().toString().equalsIgnoreCase("") || jcTipoComponente.getSelectedItem() == null){
				campos = campos + jlTipoComponente.getText()+"\n";
			}if(jtNomeColunaBd.getText().equalsIgnoreCase("") || jtNomeColunaBd.getText() == null){
				campos = campos + jlNomeDaColuna.getText()+"\n";
			}if(jtNomeDeExibicao.getText().equalsIgnoreCase("") || jtNomeDeExibicao.getText() == null){
				campos = campos + jlNomeDeExibicao.getText()+"\n";
			}	
			JOptionPane.showMessageDialog(null, "Os campos \n" + "-" + campos +"\n está vazio.");
			return false;
		}
	}


	public String getNomeAtributo()
	{
		return jtNomeAtributo.getText();        
	}
	
	public String getNomeDeExibicao()
	{
		return jtNomeDeExibicao.getText().toString();        
	}

	public boolean getPrimaryKey()
	{
		return Boolean.parseBoolean(jcChavePrimaria.getSelectedItem().toString()); 
	}

	public boolean getPrimaryKeyTable()
	{
		if(!(jcChaveEstrangeira.getSelectedItem().equals("") || jcChaveEstrangeira.getSelectedItem() == null) ){
			return false;
		}
		return false;
	}

	public String  classname() {
		return jcChaveEstrangeira.getSelectedItem().toString();
	}

	public boolean getColumn()
	{
		return Boolean.parseBoolean(jcColuna.getSelectedItem().toString()); 
	}

	public String getColumnTable()
	{
		return jtNomeColunaBd.getText().toString(); 
	}

	public String getTypeData()
	{
		return jcTipo.getSelectedItem().toString(); 
	}

	public String  getInput()
	{
		return jcTipoComponente.getSelectedItem().toString(); 
	}



} 
