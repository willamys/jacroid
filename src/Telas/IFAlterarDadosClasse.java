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
public class IFAlterarDadosClasse extends javax.swing.JInternalFrame {
	private JPanel jPanel1;

	private JLabel jLabel1;
	private JSeparator jSeparator1= null;
	private JLabel jlNomeClasse= null;
	private JTextField jtNomeTabelaBd;
	private JTextField jtNomeDeExibicao;
	private JLabel jlNomeDaTabelaBd;
	private JLabel jlNomeDeExibicao;
	private JSeparator jSeparator2;
	
	
	private String nomeClasse;
	private String nomeExibicao;
	private String nomeDaTabelaBd;

	private JButton jButton1;

	private boolean okSelecionado;

	
	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		jlNomeClasse.setText(nomeClasse);
	}

	public String getNomeExibicao() {
		return nomeExibicao;
	}

	public void setNomeExibicao(String nomeExibicao) {
		jtNomeDeExibicao.setText(nomeExibicao);
	}

	public String getNomeTabelaBD() {
		return jtNomeTabelaBd.getText().toString();
	}

	public void setNomeTabelaBD(String nomeColunaBD) {
		jtNomeTabelaBd.setText(nomeColunaBD);
	}

	/**
	* Auto-generated main method to display this 
	* JInternalFrame inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		IFAlterarDadosClasse inst = new IFAlterarDadosClasse();
		JDesktopPane jdp = new JDesktopPane();
		jdp.add(inst);
		jdp.setPreferredSize(inst.getPreferredSize());
		frame.setContentPane(jdp);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private JPanel Jpanel() {
		try {
			jPanel1 = new JPanel();
			setPreferredSize(new Dimension(400, 300));
			jPanel1.setLayout(null);
			jPanel1.setPreferredSize(new java.awt.Dimension(399, 305));
			
			jLabel1 = new JLabel();
			jLabel1.setText("Nome da Classe:");
			jLabel1.setBounds(8, 12, 88, 16);

			jSeparator1 = new JSeparator();
			jSeparator1.setBounds(1, 35, 398, 58);

			jlNomeClasse = new JLabel();

			jlNomeClasse.setBounds(103, 12, 91, 16);
			jlNomeClasse.setFont(new java.awt.Font("Segoe UI",1,14));

			jPanel1.add(jLabel1);
			jPanel1.add(jSeparator1);
			jSeparator1.setBorder(BorderFactory.createTitledBorder("Dados"));
			jPanel1.add(jlNomeClasse);
			{
				jSeparator2 = new JSeparator();
				jPanel1.add(jSeparator2);
				jSeparator2.setBounds(0, 96, 398, 58);
				jSeparator2.setBorder(BorderFactory.createTitledBorder("Dados BD"));
			}
			jPanel1.add(getJlNomeDeExibicao());
			jPanel1.add(getJlNomeDaColuna());
			jPanel1.add(getJtNomeDeExibicao());
			jPanel1.add(getJtNomeTabelaBd());
			jPanel1.add(getJButton1());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jPanel1;
	}
	
	public IFAlterarDadosClasse() {
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

	private JLabel getJlNomeDeExibicao() {
		if(jlNomeDeExibicao == null) {
			jlNomeDeExibicao = new JLabel();
			jlNomeDeExibicao.setText("Nome de Exibição:");
			jlNomeDeExibicao.setBounds(8, 58, 98, 23);
		}
		return jlNomeDeExibicao;
	}

	private JLabel getJlNomeDaColuna() {
		if(jlNomeDaTabelaBd == null) {
			jlNomeDaTabelaBd = new JLabel();
			jlNomeDaTabelaBd.setText("Nome da Tabela BD:");
			jlNomeDaTabelaBd.setBounds(8, 120, 111, 23);
		}
		return jlNomeDaTabelaBd;
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

	public void setJtNomeTabelaBd(JTextField jtNomeColunaBd) {
		this.jtNomeTabelaBd = jtNomeColunaBd;
	}

	public void setJtNomeDeExibicao(JTextField jtNomeDeExibicao) {
		this.jtNomeDeExibicao = jtNomeDeExibicao;
	}
	public JTextField getJtNomeTabelaBd() {
		if(jtNomeTabelaBd == null) {
			jtNomeTabelaBd = new JTextField();
			jtNomeTabelaBd.setBounds(125, 120, 111, 23);
			jtNomeTabelaBd.setText(nomeDaTabelaBd);
			jtNomeTabelaBd.setEditable(false);
			jtNomeTabelaBd.setDocument(new UnaccentedLowerCaseDocument());
		}
		return jtNomeTabelaBd;
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
