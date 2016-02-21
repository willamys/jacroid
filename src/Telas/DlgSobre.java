package Telas;
import img.Messages2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;


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
public class DlgSobre extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JButton jButton1;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JEditorPane jEditorPane2;
	private JEditorPane jEditorPane1;
	private JLabel jLabel1;
	private JSeparator jSeparator1;
	private JPanel jPanel2;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				DlgSobre inst = new DlgSobre(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public DlgSobre(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("Jacroid - CRUD Generate for Android ");
				this.setSize(411, 332);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(489, 271));
				jPanel1.setBackground(new java.awt.Color(238,237,234));
				{
					jPanel2 = new JPanel();
					jPanel1.add(jPanel2);
					jPanel2.setLayout(null);
					jPanel2.setBounds(0, 0, 489, 161);
					jPanel2.setBackground(new java.awt.Color(255,255,255));
					{
						jLabel1 = new JLabel();
						jPanel2.add(jLabel1);
						jLabel1.setBounds(12, 21, 120, 123);
						Icon icone = new ImageIcon(Messages2.class.getResource("/img/jacroid.png"));
						jLabel1.setIcon(icone);
					}
					{
						jEditorPane1 = new JEditorPane();
						jPanel2.add(jEditorPane1);
						jEditorPane1.setBounds(150, 12, 228, 20);
						jEditorPane1.setText("Jacroid - CRUD Generate for Android");
						jEditorPane1.setEditable(false);
					}
					{
						jEditorPane2 = new JEditorPane();
						jPanel2.add(jEditorPane2);
						jEditorPane2.setBounds(146, 57, 344, 69);
						jEditorPane2.setText("Jacroid é um sistema desenvolvido com o intuito de facilitar " +
								"o desenvolvimento de aplicações para Android, as quais     necessitem do " +
								"CRUD(Create, Retrieve, Update and Delete)     para o manuseio de dados em aplicações móveis.");
						jEditorPane2.setEditable(false);
					}
				}
				{
					jSeparator1 = new JSeparator();
					jPanel1.add(jSeparator1);
					jSeparator1.setBounds(0, 160, 445, 10);
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("Ok");
					jButton1.setBounds(364, 224, 103, 23);
					jButton1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
							
						}
					});
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Desenvolvido por:");
					jLabel2.setBounds(24, 199, 138, 16);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("Willamys G. F. Araújo");
					jLabel3.setBounds(45, 227, 141, 16);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("(c) Copyright Jacroid 2011.  All rights reserved.");
					jLabel4.setBounds(217, 199, 624, 16);
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
