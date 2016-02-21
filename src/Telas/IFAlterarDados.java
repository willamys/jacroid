package Telas;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.JTextComponent;

import util.UnaccentedDocument;
import util.UnaccentedLowerCaseDocument;


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
public class IFAlterarDados extends javax.swing.JInternalFrame {
	private JPanel jPanel1;

	private JLabel jLabel1;
	private JSeparator jSeparator1= null;
	private JLabel jlNomeClasse= null;
	private JLabel jlNomeAtributo= null;
	private JLabel jlTipo= null;
	private JTextField jtChaveEstrangeira= null;
	private JComboBox jcTipoComponente= null;
	private JTextField jtNomeColunaBd;
	private JTextField jtNomeDeExibicao;
	private JLabel jlNomeAtributo2;
	private JLabel jlNomeDaColuna;
	private JLabel jlNomeDeExibicao;
	private JComboBox jtColuna= null;
	private JTextField jtChavePrimaria= null;
	private JComboBox jcTipo= null;
	private JButton jButton1;
	private JLabel jlChaveEstrangeira= null;
	private JLabel jlTipoComponente= null;
	private JLabel jlColuna= null;
	private JLabel jlChavePrimaria= null;
	private JSeparator jSeparator2;
	private JTextField jtClasseReferenciada;
	private JLabel jlClasseReferenciada;
	
	
	private String nomeAtributo;
	private String nomeClasse;
	private String nomeExibicao;
	private String nomeColunaBD;
	private String tipoDado;
	private String tipoComponente;
	private Boolean isColuna;
	private Boolean chavePrimaria;
	private Boolean chaveEstrangeira;
	private String classeReferenciada;
	
	protected boolean okSelecionado;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	
	public String getNomeClasse() {
		return jlNomeClasse.getText();
	}

	public void setNomeClasse(String nomeClasse) {
		jlNomeClasse.setText(nomeClasse);
	}

	public String getNomeExibicao() {
		return jtNomeDeExibicao.getText();
	}

	public void setNomeExibicao(String nomeExibicao) {
		jtNomeDeExibicao.setText(nomeExibicao);
	}

	public String getNomeColunaBD() {
		return jtNomeColunaBd.getText();
	}

	public void setNomeColunaBD(String nomeColunaBD) {
		jtNomeColunaBd.setText(nomeColunaBD);
	}

	public String getTipoDado() {
		return jcTipo.getSelectedItem().toString();
	}

	public void setTipoDado(String tipoDado) {
		jcTipo.setSelectedItem(tipoDado);
	}

	public String getTipoComponente() {
		return jcTipoComponente.getSelectedItem().toString();
	}

	public void setTipoComponente(String tipoComponente) {
		jcTipoComponente.setSelectedItem(tipoComponente);
	}

	public Boolean getIsColuna() {
		return Boolean.parseBoolean(jtColuna.getSelectedItem().toString());
	}

	public void setIsColuna(Boolean isColuna) {
		jtColuna.setSelectedItem(String.valueOf(isColuna));
	}

	public Boolean getChavePrimaria() {
		return Boolean.parseBoolean(jtChavePrimaria.getText());
	}

	public void setChavePrimaria(Boolean chavePrimaria) {
		jtChavePrimaria.setText(String.valueOf(chavePrimaria));
	}

	public Boolean getChaveEstrangeira() {
		return Boolean.parseBoolean(jtChaveEstrangeira.getText());
	}

	public void setChaveEstrangeira(Boolean chaveEstrangeira) {
		jtChaveEstrangeira.setText(String.valueOf(chaveEstrangeira));
	}

	public void setNomeAtributo(String nomeAtributo) {
		jlNomeAtributo2.setText(nomeAtributo);
	}
	
	public String getNomeAtributo() {
		return jlNomeAtributo2.getText().toString();
	}
	public String getNomeClasseReferenciada() {
		return classeReferenciada;
	}

	public void setNomeClasseReferenciada(String n) {
		jtClasseReferenciada.setText(n);
		this.classeReferenciada = n;
	}
	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		IFAlterarDados inst = new IFAlterarDados();
		JDesktopPane jdp = new JDesktopPane();
		jdp.add(inst);
		jdp.setPreferredSize(inst.getPreferredSize());
		frame.setContentPane(jdp);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public IFAlterarDados() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			setBounds(new Rectangle(0, 0, 400, 300));
			setVisible(true);
			{
				getContentPane().add(Jpanel());
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JPanel Jpanel() {
		try {
			
			jPanel1 = new JPanel();
			setPreferredSize(new Dimension(400, 300));
			jPanel1.setLayout(null);
			jPanel1.setPreferredSize(new java.awt.Dimension(399, 305));

			jLabel1 = new JLabel();
			jLabel1.setText("Nome da Classe:");
			jLabel1.setBounds(207, 12, 88, 16);

			jSeparator1 = new JSeparator();
			jSeparator1.setBounds(1, 35, 398, 117);

			jlNomeClasse = new JLabel();

			jlNomeClasse.setBounds(302, 11, 91, 16);
			jlNomeClasse.setFont(new java.awt.Font("Segoe UI",1,14));

			jlNomeAtributo = new JLabel();
			jlNomeAtributo.setText("Nome Atributo:");
			jlNomeAtributo.setBounds(8, 12, 88, 16);

			jlTipo = new JLabel();
			jlTipo.setText("Tipo:");
			jlTipo.setBounds(8, 90, 44, 16);


			jlChavePrimaria = new JLabel();

			jlChavePrimaria.setText("Chave Primária:");
			jlChavePrimaria.setBounds(8, 247, 121, 16);

			jlColuna = new JLabel();

			jlColuna.setText("Coluna no BD:");
			jlColuna.setBounds(8, 197, 76, 16);

			jlTipoComponente = new JLabel();

			jlTipoComponente.setText("Tipo de Componente:");
			jlTipoComponente.setBounds(8, 123, 125, 16);

			jlChaveEstrangeira = new JLabel();

			jlChaveEstrangeira.setText("Chave Estrangeira:");
			jlChaveEstrangeira.setBounds(8, 222, 101, 16);

			jPanel1.add(jLabel1);
			jPanel1.add(jSeparator1);
			jSeparator1.setBorder(BorderFactory.createTitledBorder("Dados"));
			jPanel1.add(jlNomeClasse);
			jPanel1.add(jlNomeAtributo);
			jPanel1.add(jlTipo);
			jPanel1.add(jlChavePrimaria);
			jPanel1.add(jlColuna);
			jPanel1.add(jlTipoComponente);
			jPanel1.add(jlChaveEstrangeira);
			{
				jSeparator2 = new JSeparator();
				jPanel1.add(jSeparator2);
				jSeparator2.setBounds(1, 158, 398, 116);
				jSeparator2.setBorder(BorderFactory.createTitledBorder("Dados BD"));
			}
			
			jPanel1.add(getJcTipo());
			jPanel1.add(getJtChaveEstrangeira());
			jPanel1.add(getJtColuna());
			jPanel1.add(getJcTipoComponente());
			jPanel1.add(getJtChavePrimaria());
			jPanel1.add(getJlNomeDeExibicao());
			jPanel1.add(getJlNomeDaColuna());
			jPanel1.add(getJtNomeDeExibicao());
			jPanel1.add(getJtNomeColunaBd());
			jPanel1.add(getJlNomeAtributo());
			jPanel1.add(getJtClasseReferenciada());
			jPanel1.add(getJlClasseReferenciada());
			jPanel1.add(getJButton1());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jPanel1;
	}
	

	public JTextField getJtChaveEstrangeira() {
		if(jtChaveEstrangeira == null){
			jtChaveEstrangeira = new JTextField();
			jtChaveEstrangeira.setBounds(109, 222, 103, 23);
			jtChaveEstrangeira.setText(String.valueOf(chaveEstrangeira));
			jtChaveEstrangeira.setEditable(false);
			jtChaveEstrangeira.setDocument(new UnaccentedDocument());
		}
		return jtChaveEstrangeira;
	}

	public void setJcchave_estrangeira(JTextField jcchave_estrangeira) {
		this.jtChaveEstrangeira = jcchave_estrangeira;
	}

	public JComboBox getJcTipoComponente() {
		if(jcTipoComponente == null){
			ComboBoxModel jComboBox4Model = 
				new DefaultComboBoxModel(
						new String[] { ""});
			jcTipoComponente = new JComboBox();
			jcTipoComponente.setModel(jComboBox4Model);
			jcTipoComponente.setBounds(129,121, 112, 23);
			jcTipoComponente.setEditable(false);
			jcTipoComponente.setEnabled(false);
			}
		return jcTipoComponente;
	}
	
	public void setJctipo_componente(JComboBox jctipo_componente) {
		this.jcTipoComponente = jctipo_componente;
	}

	public JComboBox getJtColuna() {

		if(jtColuna == null){
			jtColuna = new JComboBox();
			ComboBoxModel jComboBox4Model = 
				new DefaultComboBoxModel(
						new String[] { "true"," false"});
			jtColuna = new JComboBox();
			jtColuna.setModel(jComboBox4Model);
			jtColuna.setBounds(102, 196, 110, 23);
			jtColuna.setEditable(false);
			jtColuna.setEnabled(false);
		}
		return jtColuna;

	}

	public void setJccoluna(JComboBox jccoluna) {
		this.jtColuna = jccoluna;
	}

	public JTextField getJtChavePrimaria() {
		if(jtChavePrimaria == null){
			jtChavePrimaria = new JTextField();
			jtChavePrimaria.setBounds(100,247, 83, 23);
			jtChavePrimaria.setText(String.valueOf(chavePrimaria));
			jtChavePrimaria.setEditable(false);
			jtChavePrimaria.setDocument(new UnaccentedDocument());

		}
		return jtChavePrimaria;
	}

	public void setJcchave_primaria(JTextField jcchave_primaria) {
		this.jtChavePrimaria = jcchave_primaria;
	}

	
	public JComboBox getJcTipo() {
		if(jcTipo == null ){
			ComboBoxModel jComboBox1Model = 
				new DefaultComboBoxModel(
						new String[] { "","Boolean", "int","Long","String" });
			jcTipo = new JComboBox();
			jcTipo.setModel(jComboBox1Model);
			jcTipo.setBounds(46, 88, 94, 23);
			jcTipo.setEditable(false);
			jcTipo.setEnabled(false);
			jcTipo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(jcTipo.getSelectedItem().equals("Boolean")){
						jcTipoComponente.removeAllItems();
						jcTipoComponente.addItem("checkbox");
					}else if(jcTipo.getSelectedItem().equals("int")){
						if(jtChavePrimaria.getText().equals("true")){
							jcTipoComponente.removeAllItems();
							jcTipoComponente.addItem("hidden");
						}else if(jtChaveEstrangeira.getText().equals("true")){
							jcTipoComponente.removeAllItems();
							jcTipoComponente.addItem("select");
						}else{
							jcTipoComponente.removeAllItems();
							jcTipoComponente.addItem("text");
						}
					}else if(jcTipo.getSelectedItem().equals("Long")){
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
			jlNomeDeExibicao.setBounds(8, 58, 98, 23);
			
		}
		return jlNomeDeExibicao;
	}

	private JLabel getJlNomeDaColuna() {
		if(jlNomeDaColuna == null) {
			jlNomeDaColuna = new JLabel();
			jlNomeDaColuna.setText("Nome da Coluna BD:");
			jlNomeDaColuna.setBounds(8, 170, 111, 23);
		}
		return jlNomeDaColuna;
	}

	public JTextField getJtNomeDeExibicao() {
		if(jtNomeDeExibicao == null) {
			jtNomeDeExibicao = new JTextField();
			jtNomeDeExibicao.setBounds(118, 58, 157, 23);
			jtNomeDeExibicao.setText(nomeExibicao);
			jtNomeDeExibicao.setEditable(false);
			jtNomeDeExibicao.setDocument(new UnaccentedDocument());
		}
		return jtNomeDeExibicao;
	}

	public void setjcTipoComponente(JComboBox jcTipoComponente) {
		this.jcTipoComponente = jcTipoComponente;
	}

	public void setJtNomeColunaBd(JTextField jtNomeColunaBd) {
		this.jtNomeColunaBd = jtNomeColunaBd;
	}

	public void setJtColuna(JComboBox jtColuna) {
		this.jtColuna = jtColuna;
	}

	public void setjcTipo(JComboBox jcTipo) {
		this.jcTipo = jcTipo;
	}

	public void setJtNomeDeExibicao(JTextField jtNomeDeExibicao) {
		this.jtNomeDeExibicao = jtNomeDeExibicao;
	}

	public JTextField getJtNomeColunaBd() {
		if(jtNomeColunaBd == null) {
			jtNomeColunaBd = new JTextField();
			jtNomeColunaBd.setBounds(125, 169, 150, 23);
			jtNomeColunaBd.setText(nomeColunaBD);
			jtNomeColunaBd.setEditable(false);
			jtNomeColunaBd.setDocument(new UnaccentedLowerCaseDocument());
		}
		return jtNomeColunaBd;
	}
	
	private JLabel getJlNomeAtributo() {
		if(jlNomeAtributo2 == null) {
			jlNomeAtributo2 = new JLabel();
			jlNomeAtributo2.setBounds(102, 12, 92, 16);
			jlNomeAtributo2.setFont(new java.awt.Font("Segoe UI",1,14));
			jlNomeAtributo2.setText(nomeAtributo);
			}
		return jlNomeAtributo2;
	}
	
	private JLabel getJlClasseReferenciada() {
		if(jlClasseReferenciada == null) {
			jlClasseReferenciada = new JLabel();
			jlClasseReferenciada.setText("Classe Referenciada:");
			jlClasseReferenciada.setBounds(277, 222, 107, 16);
		}
		return jlClasseReferenciada;
	}
	
	private JTextField getJtClasseReferenciada() {
		if(jtClasseReferenciada == null) {
			jtClasseReferenciada = new JTextField();
			jtClasseReferenciada.setBounds(278, 244, 107, 23);
			jtClasseReferenciada.setEditable(false);
			jtClasseReferenciada.setDocument(new UnaccentedDocument());
		}
		return jtClasseReferenciada;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Alterar dados");
			jButton1.setBounds(148, 277, 100, 23);
			jButton1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//okSelecionado = true;
					//setVisible(false);
					dispose();
				}
			});
		}
		return jButton1;
	}
	
	public boolean alterarDados()    
	{        
		okSelecionado = false;  //Marcamos que o ok não foi selecionado
		setVisible(true);
		return okSelecionado;   //Retornamos true, se ele pressionou ok.
	}


}
