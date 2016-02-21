package Telas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

// xml classes
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;

import Gerador.AttributeDescriptor;
import Gerador.ClassDescriptor;
import Gerador.ClassGenerator;
import Gerador.GeneratorUtility;
import Gerador.ReadXML;
import img.Messages2;
import util.CurrentDir;
import util.DynamicTree;
import util.UnaccentedDocument;

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
public class TelaInicial extends javax.swing.JFrame{
	private JMenuBar barraMenu;
	private JMenuItem importarXml;
	private JMenuItem exportarXml;
	private JButton jbAddChaveEstrangeira;
	private JPanel jPanel3;
	private JButton jbGerarCodigo;
	private JPanel jPanelGerar;
	private JButton jbRemover;
	private JButton jbAddAtributo;
	private JButton jbAddClasse;
	private JPanel jPanelBarradeFerramentas;
	private JPanel jPanel2;
	private JProgressBar jProgressBar1;
	private JTextArea jtXmlVisualizar;
	private JButton jbVisualizarXml;
	private JButton jbAlterarDiretorio;
	private JTextField jtDiretorioProjeto;
	private JTextField jtNomeProjeto;
	private JLabel jlDiretorioProjeto;
	private JLabel jlNomeProjeto;
	private DynamicTree jTreeClassesAtributos;
	//private JTree jTree_classes_atributos;
	private JPanel jPanel1Principal;
	private JMenuItem salvarProjeto;
	private JMenuItem abrir;
	private JMenuItem novoProjeto;
	private JMenu menuArquivo;
	protected JPopupMenu mPopup;
	protected Action mAction;
	protected TreePath mClickedPath;

	ComboBoxModel jComboBox5Model;

	String vetorCl [] = null;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private JMenuItem menuSair;
	private JTextField jtColunoBD;
	private JLabel jlColunaBD;
	private JTextField jtTipoComponente;
	private JLabel jlTipoComponente;
	private JTextField jTextField1;
	private JLabel jlTipo;
	private JTextField jtNomeDeExibicao;
	private JLabel jlNomeDeExibicao;
	private JTextField jtNomeDaTabela;
	private JLabel jlNomeDaTabela;
	private JTextField jtNomeDaClasse;
	private JLabel jlNomeDaClasse;
	private JLabel jLabel3;
	private JPanel jpDetalhamentoAtributosClasses;
	JTree tree;

	HashMap listaClasse = new HashMap();


	public HashMap getListaClasse() {
		return listaClasse;
	}

	public void setListaClasse(HashMap listaClasseHashMap) {
		this.listaClasse = listaClasseHashMap;
	}

	private JScrollPane jScrollPane1;
	private JPanel jPanel1;
	DefaultTreeModel treemodel;

	AttributeDescriptor attr;

	public AttributeDescriptor getAttr() {
		return attr;
	}

	public void setAttr(AttributeDescriptor attr) {
		this.attr = attr;
	}


	JDialog dialog;
	JDialog jdialog;
	Dimension tamanhoTelaPc = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Auto-generated main method to display this JFrame
	 */

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaInicial inst = new TelaInicial();
				inst.setTitle("Jacroid - CRUD(Create, Retrieve, Update and Delete) Generate for Android");
				inst.setVisible( true );
				inst.setResizable( false );
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			}
		});
	}

	public TelaInicial() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					sair();
				}
			});

			CurrentDir c = new CurrentDir();
			/*** comentar se for usar no eclipse*
			 * Inicio**/
//			String caminhoJar = System.getProperty("user.dir")+System.getProperty("file.separator")+"Jacroid"+".jar";
//			c.createVmDir(caminhoJar);
//			c.createImagesDir(caminhoJar);
			/**Fim**/

			//comentar pra gerar Jar

			//c.startCopyFilesVM();
			//c.startCopyFilesImg();

			{
				jPanel1Principal = new JPanel();
				getContentPane().add(jPanel1Principal, BorderLayout.CENTER);
				jPanel1Principal.setLayout(null);
				jPanel1Principal.setVisible(false);
				
				jLabel3 = new JLabel();
				jLabel3.setBounds(820, 469, 120, 123);
				Icon icone = new ImageIcon(Messages2.class.getResource("/img/jacroid.png"));
				jLabel3.setIcon(icone);
				jPanel1Principal.add(jLabel3);

				{
					/****************INICIO PANEL DADOS PROJETO*****************************************************/
					{
						jPanel3 = new JPanel();
						jPanel1Principal.add(jPanel3);
						jPanel3.setLayout(null);
						jPanel3.setBounds(10, 9, 729, 75);
						jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Dados do Projeto", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
					}

					{
						jlNomeProjeto = new JLabel();
						jPanel3.add(jlNomeProjeto);
						jlNomeProjeto.setText("Nome do Projeto:");
						jlNomeProjeto.setBounds(10, 25, 88, 14);
					}
					{
						jlDiretorioProjeto = new JLabel();
						jPanel3.add(jlDiretorioProjeto);
						jlDiretorioProjeto.setText("Diretório do Projeto:");
						jlDiretorioProjeto.setBounds(10, 50, 100, 14);
					}
					{
						jtNomeProjeto = new JTextField();
						jPanel3.add(jtNomeProjeto);
						jtNomeProjeto.setBounds(102, 22, 457, 19);
						jtNomeProjeto.setDocument(new UnaccentedDocument());
					}
					{
						jtDiretorioProjeto = new JTextField();
						jPanel3.add(jtDiretorioProjeto);
						jtDiretorioProjeto.setBounds(114, 47, 445, 20);
						jtDiretorioProjeto.setEditable(false);
						jtDiretorioProjeto.setText(CurrentDir.getDirAtual());
					}
					{
						jbAlterarDiretorio = new JButton();
						jPanel3.add(jbAlterarDiretorio);
						jbAlterarDiretorio.setText("alterar");
						jbAlterarDiretorio.setFocusable(false);
						jbAlterarDiretorio.setBounds(587, 46, 67, 21);
						jbAlterarDiretorio.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e) {
								Frame jframe = null;
								JFileChooser filechooser = new JFileChooser();
								filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
								int result = filechooser.showDialog(jframe,"Alterar");

								if (result == JFileChooser.APPROVE_OPTION) {
									File file = filechooser.getSelectedFile();
									jtDiretorioProjeto.setText(file.getAbsolutePath());
								}
							}
						});
					}
					/****************FIM PANEL DADOS PROJETO*****************************************************/

					/**************INICIO PANEL BARRA DE FERRAMENTAS**************************/
					{
						jPanelBarradeFerramentas = new JPanel();
						jPanel1Principal.add(jPanelBarradeFerramentas);
						jPanelBarradeFerramentas.setBounds(10, 178, 634, 74);
						jPanelBarradeFerramentas.setBorder(BorderFactory.createTitledBorder("Barra de Ferramentas"));
						jPanelBarradeFerramentas.setLayout(null);
						{
							jbAddClasse = new JButton();
							jPanelBarradeFerramentas.add(jbAddClasse);
							jbAddClasse.setText("Add Classe");
							jbAddClasse.setToolTipText("Para Adicionar uma Classe , pressione a tecla 'Ctrl+L'");
							jbAddClasse.setFocusable(false);
							jbAddClasse.setBounds(11, 31, 87, 23);
							jbAddClasse.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									addClasse();
								}
							});
							jbAddClasse.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_MASK),("Abrir"));
							jbAddClasse.getActionMap().put("Abrir",  
									new AbstractAction("Abrir") {  
								public void actionPerformed(ActionEvent evt) {
									addClasse();
								}  
							}  
							);  
						}
						{
							jbAddAtributo = new JButton();
							jPanelBarradeFerramentas.add(jbAddAtributo);
							jbAddAtributo.setText("Add Atributo");
							jbAddAtributo.setToolTipText("Para Adicionar um Atributo , pressione a tecla 'Ctrl+T'");
							jbAddAtributo.setFocusable(false);
							jbAddAtributo.setBounds(105, 31, 95, 23);
							jbAddAtributo.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) {
									DefaultMutableTreeNode node;
									//pegar o nó selecionado na jtree
									node = (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
									if(node != null){
										String nomeClasse = node.toString().substring(node.toString().indexOf(":")+1,node.toString().length());
										/**verificar para saber o nível em que o nó selecionado se encontra
										 * Se for 0 é o raiz 
										 * se for 1 é classe
										 * se for 2 é atributo ou método
										 * se for 3 é tipo de atributo**/
										if(tree.getSelectionPath().getPathCount() == 2){
											onAlterarDados(nomeClasse,1);
										}else{
											MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
										}

									}else{
										MessageDialog("Selecione algum nó da árvore.");	
									}

								}
							});
							jbAddAtributo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_MASK),("Abrir"));
							jbAddAtributo.getActionMap().put("Abrir",  
									new AbstractAction("Abrir") {  
								public void actionPerformed(ActionEvent evt) {
									DefaultMutableTreeNode node;
									//pegar o nó selecionado na jtree
									node = (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
									if(node != null){
										String nomeClasse = node.toString().substring(node.toString().indexOf(":")+1,node.toString().length());
										/**verificar para saber o nível em que o nó selecionado se encontra
										 * Se for 0 é o raiz 
										 * se for 1 é classe
										 * se for 2 é atributo ou método
										 * se for 3 é tipo de atributo**/
										if(tree.getSelectionPath().getPathCount() == 2){
											onAlterarDados(nomeClasse,1);
										}else{
											MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
										}

									}else{
										MessageDialog("Selecione algum nó da árvore.");	
									}
								}  
							}  
							);  
						}
						{
							jbAddChaveEstrangeira = new JButton();
							jPanelBarradeFerramentas.add(jbAddChaveEstrangeira);
							jbAddChaveEstrangeira.setText("Add Chave Estrangeira");
							jbAddChaveEstrangeira.setToolTipText("Para Adicionar uma Chave Estrangeira , pressione a tecla 'Ctrl+E'");
							jbAddChaveEstrangeira.setBounds(208, 31, 145, 23);
							jbAddChaveEstrangeira.setFocusable(false);
							jbAddChaveEstrangeira.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) {
									DefaultMutableTreeNode node;
									//pegar o nó selecionado na jtree
									node = (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
									if(node != null){
										String nomeClasse = node.toString().substring(node.toString().indexOf(":")+1,node.toString().length());
										/**verificar para saber o nível em que o nó selecionado se encontra
										 * Se for 0 é o raiz 
										 * se for 1 é classe
										 * se for 2 é atributo ou método
										 * se for 3 é tipo de atributo**/
										if(tree.getSelectionPath().getPathCount() == 2){
											onAlterarDados(nomeClasse,2);
										}else{
											MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
										}

									}else{
										MessageDialog("Selecione algum nó da árvore.");	
									}

								}
							});
							jbAddChaveEstrangeira.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK),("Abrir"));
							jbAddChaveEstrangeira.getActionMap().put("Abrir",  
									new AbstractAction("Abrir") {  
								public void actionPerformed(ActionEvent evt) {
									DefaultMutableTreeNode node;
									//pegar o nó selecionado na jtree
									node = (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
									if(node != null){
										String nomeClasse = node.toString().substring(node.toString().indexOf(":")+1,node.toString().length());
										/**verificar para saber o nível em que o nó selecionado se encontra
										 * Se for 0 é o raiz 
										 * se for 1 é classe
										 * se for 2 é atributo ou método
										 * se for 3 é tipo de atributo**/
										if(tree.getSelectionPath().getPathCount() == 2){
											onAlterarDados(nomeClasse,2);
										}else{
											MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
										}

									}else{
										MessageDialog("Selecione algum nó da árvore.");	
									}
								}  
							}  
							);  
						}
						{
							jbRemover = new JButton();
							jPanelBarradeFerramentas.add(jbRemover);
							jbRemover.setText("Remover Classe/Atributo");
							jbRemover.setBounds(360, 31, 155, 23);
							jbRemover.setToolTipText("Para excluir algum classe ou atributo, pressione a tecla 'DEL'");
							jbRemover.setFocusable(false);
							jbRemover.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0),("Abrir"));
							jbRemover.getActionMap().put("Abrir",  
									new AbstractAction("Abrir") {  
								public void actionPerformed(ActionEvent evt) {
									remover();
								}  
							}  
							);  
							jbRemover.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) {
									remover();
								}
							});
						}
						{
							jbVisualizarXml = new JButton();
							jPanelBarradeFerramentas.add(jbVisualizarXml);
							jbVisualizarXml.setText("Visualizar XML");
							jbVisualizarXml.setBounds(521, 31, 101, 23);
							jbVisualizarXml.setFocusable(false);
							jbVisualizarXml.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent e) {
									jProgressBar1 = new JProgressBar();
									jProgressBar1.setIndeterminate(true);
									jProgressBar1.setSize(200,20);
									dialog = new JDialog();
									dialog.setTitle("Aguarde...");
									dialog.setModal(false);
									dialog.getContentPane().add(jProgressBar1);
									dialog.setLocation((tamanhoTelaPc.width - 200)/2, (tamanhoTelaPc.height - 20)/2);
									dialog.pack();

									dialog.setVisible(true);
									SwingWorker worker = new SwingWorker(){
										@Override
										protected Object doInBackground()
										throws Exception {
											//encoder();
											creatreXmlDynamic();
											return null;
										}
										@Override
										protected void done() {
											dialog.setVisible(false);
										}
									};
									worker.execute();
								}
							});
						}

					}
					/****************FIM PANEL BARRA DE FERRAMENTAS*****************************************************/


					/****************INICIO PANEL DETALHES DO PROJETO********************************************/

					{
						jPanel2 = new JPanel();
						jPanel1Principal.add(jPanel2);
						jTreeClassesAtributos = new DynamicTree();
						jTreeClassesAtributos.setBounds(11, 20, 177, 345);
						jPanel2.add(jTreeClassesAtributos);
						jTreeClassesAtributos.setBorder(BorderFactory.createTitledBorder("Árvore de Classes/Atributos"));
						jTreeClassesAtributos.setDoubleBuffered(false);
						jTreeClassesAtributos.setSize(177, 355);
						jPanel2.setBounds(10, 258, 729, 385);
						jPanel2.setLayout(null);
						jPanel2.setBorder(BorderFactory.createTitledBorder("Detalhes do Projeto"));
						jPanel2.setSize(735, 395);
					}
					{
						jpDetalhamentoAtributosClasses = new JPanel();
						jPanel2.add(jpDetalhamentoAtributosClasses);
						jpDetalhamentoAtributosClasses.setBounds(198, 20, 515, 345);
						jpDetalhamentoAtributosClasses.setBorder(BorderFactory.createTitledBorder("Detalhamento de Classes/Atributos"));
						jpDetalhamentoAtributosClasses.setLayout(null);
						jpDetalhamentoAtributosClasses.setSize(515, 355);
					}
					{
						tree = new JTree();
						tree = jTreeClassesAtributos.getTree();
						treemodel = new DefaultTreeModel(jTreeClassesAtributos.getRootNode());
						treemodel = jTreeClassesAtributos.getTreeModel();
						mPopup = new JPopupMenu();
						/***
						 * *verificar a disponibilidade no menu para cada situação
						 **Se for no nó raiz só pode adicionar classe ou expandir/contrair
						 **Se for no nó filho só pode adicionar atributo ou método ou expandir/contrair
						 **Se for no nó filho do filho só pode adicionar o tipo do atributo.
						 **/

						//populateTree(jTree_classes_atributos);

						//MenuItemAdicionarAtributo();
						//MenuItemAdicionarAtributoChaveEstrangeira();
						//Adicionar_Tipo_Atributo();
						//MenuItemAdicionarMetodo();
						//MenuItemRemover();
						//MenuItemMostrar();

						tree.setToolTipText("Para começar selecione o nó raiz(Classe)."+
						"Clique com o botão direito do mouse e escolha uma das opções.");
						tree.add(mPopup);
						//tree.addMouseListener(new PopupTrigger());
						tree.addMouseListener(new MouseAdapter(){
							@Override
							public void mouseReleased(MouseEvent e) {
								if(e.getClickCount() == 2 ){
									TreePath parentPath = tree.getSelectionPath();
									DefaultMutableTreeNode no = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
									if(tree.getSelectionPath().getPathCount() == 2){
										mostrar(1, parentPath, no);
									}else if(tree.getSelectionPath().getPathCount() == 3){
										mostrar(2, parentPath, no);
									}
								}
								if(SwingUtilities.isRightMouseButton(e)){
									int x = e.getX();
									int y = e.getY();
									TreePath path = tree.getPathForLocation(x, y);
									if (path != null)
									{
										if(tree.getSelectionPath().getPathCount() == 1){
											RemoverMenusItens();
											MenuItemExpandirColapsar();
											MenuItemAdicionarClasse();
										}else if(tree.getSelectionPath().getPathCount() == 2){
											RemoverMenusItens();
											MenuItemExpandirColapsar();
											MenuItemAdicionarAtributo();
											MenuItemAdicionarAtributoChaveEstrangeira();
											MenuItemAdicionarMetodo();
											MenuItemRemover();
											MenuItemMostrar();
										}else if(tree.getSelectionPath().getPathCount() == 3){
											RemoverMenusItens();
											MenuItemExpandirColapsar();
											MenuItemRemover();
											MenuItemMostrar();
										}
										mPopup.show(tree, x, y);
										mClickedPath = path;
									}
								}
							}
						});

						tree.addKeyListener(new KeyAdapter(){
							@Override
							public void keyPressed(KeyEvent e) {
								if(e.getKeyCode() == e.VK_ENTER){
									if(tree.getSelectionPath().getPathCount() == 1){
										RemoverMenusItens();
										MenuItemExpandirColapsar();
										MenuItemAdicionarClasse();
									}else if(tree.getSelectionPath().getPathCount() == 2){
										RemoverMenusItens();
										MenuItemExpandirColapsar();
										MenuItemAdicionarAtributo();
										MenuItemAdicionarAtributoChaveEstrangeira();
										MenuItemAdicionarMetodo();
										MenuItemRemover();
										MenuItemMostrar();
									}else if(tree.getSelectionPath().getPathCount() == 3){
										RemoverMenusItens();
										MenuItemExpandirColapsar();
										MenuItemRemover();
										MenuItemMostrar();
									}
									mPopup.show(tree, SwingUtilities.getLocalBounds(tree).x, SwingUtilities.getLocalBounds(tree).y);
								}
							}
						});
					}
				}
			}
			/****************FIM PANEL DETALHES DO PROJETO********************************************/


			/**************INICIO PANEL VISUALIZAR XML**************************/
			{
				jPanel1 = new JPanel();
				jPanel1Principal.add(jPanel1);
				jPanel1.setBounds(10, 85, 729, 91);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(713, 81));
					{
						jtXmlVisualizar = new JTextArea();
						jtXmlVisualizar.setEditable(false);
						jScrollPane1.setViewportView(jtXmlVisualizar);
					}
				}
			}
			/**************FIM PANEL VISUALIZAR XML**************************/


			/****************INICIO PANEL GERAR CÓDIGO*****************************************************/
			{
				jPanelGerar = new JPanel();
				jPanel1Principal.add(jPanelGerar);
				jPanelGerar.setLayout(null);
				jPanelGerar.setBounds(644, 178, 99, 74);
				jPanelGerar.setBorder(BorderFactory.createTitledBorder("Gerar Código"));

				{
					jbGerarCodigo = new JButton();
					jPanelGerar.add(jbGerarCodigo);
					jbGerarCodigo.setText("Gerar");
					jbGerarCodigo.setFocusable(false);
					jbGerarCodigo.setBounds(7, 31, 85, 23);
					jbGerarCodigo.setToolTipText("Para Iniciar a Geração do Código , pressione a tecla 'Ctrl+G'");
					Icon icone = new ImageIcon(Messages2.class.getResource("/img/launch_run.gif"));
					jbGerarCodigo.setIcon(icone);
					jbGerarCodigo.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							Object[] options = { "SIM", "NÃO" };
							if(!(jtNomeProjeto.getText().equalsIgnoreCase("") || jtNomeProjeto == null)){
								if(listaClasse.size() > 0 && listaClasse != null){
									int op = JOptionPane.showOptionDialog(null, "Deseja Realmente iniciar a geração de código?", "Confirme",
											JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
											null, options, options[0]);
									switch (op) {
									case 0:
										try {

											jProgressBar1 = new JProgressBar();
											jProgressBar1.setIndeterminate(true);
											jProgressBar1.setSize(200,20);
											dialog = new JDialog();
											dialog.setTitle("Aguarde...");
											dialog.setModal(false);
											dialog.getContentPane().add(jProgressBar1);
											dialog.setLocation((tamanhoTelaPc.width - 200)/2, (tamanhoTelaPc.height - 20)/2);
											dialog.pack();

											dialog.setVisible(true);
											SwingWorker worker = new SwingWorker(){
												@Override
												protected Object doInBackground()
												throws Exception {
													//encoder();
													try {
														creatreXmlDynamic();
														ClassGenerator.start(jtNomeProjeto.getText(), "."+System.getProperty("file.separator")+"implementor.xml","."+System.getProperty("file.separator")+jtNomeProjeto.getText());

													} catch (Exception e2) {
														JOptionPane.showMessageDialog(null,"Ocorreu um erro no processo de geração.");
														e2.printStackTrace();
													}
													CurrentDir c = new CurrentDir();
													//System.out.println(c.getDirAtual()+"\\"+jtNomeProjeto.getText());
													try{
														//enviar o projeto criado para onde o usuário escolheu.
														File srcDir = new File(c.getDirAtual()+System.getProperty("file.separator")+jtNomeProjeto.getText());
														File dstDir = new File(jtDiretorioProjeto.getText()+System.getProperty("file.separator")+jtNomeProjeto.getText());
														c.copyDirectory(srcDir, dstDir);

														File dirProj = new File(c.getDirAtual()+System.getProperty("file.separator")+"ProjetosGerados");

														if(!dirProj.exists()){
															dirProj.mkdir();
															File dstDir1 = new File(c.getDirAtual()+System.getProperty("file.separator")+"ProjetosGerados"+System.getProperty("file.separator")+jtNomeProjeto.getText());
															c.copyDirectory(srcDir, dstDir1);
															c.deleteDirectory(srcDir);
														}else{
															File dstDir1 = new File(c.getDirAtual()+System.getProperty("file.separator")+"ProjetosGerados"+System.getProperty("file.separator")+jtNomeProjeto.getText());
															if(dstDir1.exists()){
																c.deleteDirectory(dstDir1);
																c.copyDirectory(srcDir, dstDir1);
															}else{
																c.copyDirectory(srcDir, dstDir1);
															}
															c.deleteDirectory(srcDir);
														}
													}catch (Exception e) {
														e.printStackTrace();
													}
													return null;
												}
												@Override
												protected void done() {
													dialog.setVisible(false);
													JOptionPane.showMessageDialog(null, "Geração do Código efetuada com sucesso!\n" +
															"O projeto foi salvo em "+jtDiretorioProjeto.getText()+System.getProperty("file.separator")+jtNomeProjeto.getText());
												}
											};
											worker.execute();

										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										break;
									case 1:

										break;
									default:
										break;
									}
								}else{
									MessageDialog("Não foi criada nenhuma classe ou atributo.");
								}
							}else{
								MessageDialog("O nome do Projeto está vazio.");
							}
						}
					});
					jbGerarCodigo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_MASK),("Abrir"));
					jbGerarCodigo.getActionMap().put("Abrir",  
							new AbstractAction("Abrir") {  
						public void actionPerformed(ActionEvent evt) {
							Object[] options = { "SIM", "NÃO" };
							if(!(jtNomeProjeto.getText().equalsIgnoreCase("") || jtNomeProjeto == null)){
								if(listaClasse.size() > 0 && listaClasse != null){
									int op = JOptionPane.showOptionDialog(null, "Deseja Realmente iniciar a geração de código?", "Confirme",
											JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
											null, options, options[0]);
									switch (op) {
									case 0:
										try {

											jProgressBar1 = new JProgressBar();
											jProgressBar1.setIndeterminate(true);
											jProgressBar1.setSize(200,20);
											dialog = new JDialog();
											dialog.setTitle("Aguarde...");
											dialog.setModal(false);
											dialog.getContentPane().add(jProgressBar1);
											dialog.setLocation((tamanhoTelaPc.width - 200)/2, (tamanhoTelaPc.height - 20)/2);
											dialog.pack();

											dialog.setVisible(true);
											SwingWorker worker = new SwingWorker(){
												@Override
												protected Object doInBackground()
												throws Exception {
													//encoder();
													try {
														creatreXmlDynamic();
														ClassGenerator.start(jtNomeProjeto.getText(), "."+System.getProperty("file.separator")+"implementor.xml", "."+System.getProperty("file.separator")+jtNomeProjeto.getText());
													} catch (Exception e2) {
														JOptionPane.showMessageDialog(null,"Ocorreu um erro no processo de geração.");
													}CurrentDir c = new CurrentDir();
													//System.out.println(c.getDirAtual()+"\\"+jtNomeProjeto.getText());
													try{
														//enviar o projeto criado para onde o usuário escolheu.
														File srcDir = new File(c.getDirAtual()+System.getProperty("file.separator")+jtNomeProjeto.getText());
														File dstDir = new File(jtDiretorioProjeto.getText()+System.getProperty("file.separator")+jtNomeProjeto.getText());
														c.copyDirectory(srcDir, dstDir);

														File dirProj = new File(c.getDirAtual()+System.getProperty("file.separator")+"ProjetosGerados");

														if(!dirProj.exists()){
															dirProj.mkdir();
															File dstDir1 = new File(c.getDirAtual()+System.getProperty("file.separator")+"ProjetosGerados"+System.getProperty("file.separator")+jtNomeProjeto.getText());
															c.copyDirectory(srcDir, dstDir1);
															c.deleteDirectory(srcDir);
														}else{
															File dstDir1 = new File(c.getDirAtual()+System.getProperty("file.separator")+"ProjetosGerados"+System.getProperty("file.separator")+jtNomeProjeto.getText());
															if(dstDir1.exists()){
																c.deleteDirectory(dstDir1);
																c.copyDirectory(srcDir, dstDir1);
															}
															c.deleteDirectory(srcDir);
														}
													}catch (Exception e) {
														e.printStackTrace();
													}
													return null;
												}
												@Override
												protected void done() {
													dialog.setVisible(false);
													JOptionPane.showMessageDialog(null, "Geração do Código efetuada com sucesso!\n" +
															"O projeto foi salvo em "+CurrentDir.getDirAtual()+System.getProperty("file.separator")+jtNomeProjeto.getText());
												}
											};
											worker.execute();

										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										break;
									case 1:

										break;
									default:
										break;
									}
								}else{
									MessageDialog("Não foi criada nenhuma classe ou atributo.");
								}
							}else{
								MessageDialog("O nome do Projeto está vazio.");
							}
						}
					}
					);  
				}
			}
			/****************FIM PANEL GERAR CÓDIGO*****************************************************/

			{
				barraMenu = new JMenuBar();
				setJMenuBar(barraMenu);
				{ 
					menuArquivo = new JMenu();
					barraMenu.add(menuArquivo);
					menuArquivo.setText("Arquivo");
					{
						novoProjeto = new JMenuItem();
						menuArquivo.add(novoProjeto);
						novoProjeto.setText("Novo");
						novoProjeto.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								Object[] options = { "SIM", "NÃO" };
								int op = JOptionPane.showOptionDialog(null, "Deseja criar um Novo Projeto?", "Confirme",
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
										null, options, options[0]);
								switch (op) {
								case 0:
									jtNomeProjeto.setSelectionEnd(0);
									jtNomeProjeto.setText("");
									listaClasse.clear();
									jTreeClassesAtributos.clear();
									creatreXmlDynamic();
									jPanel1Principal.setVisible(true);
									salvarProjeto.setEnabled(true);
									exportarXml.setEnabled(true);
									break;
								case 1:
									break;
								}
							}
						});
						novoProjeto.setText("Novo                       Ctrl+N");
						novoProjeto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK),("Abrir"));
						novoProjeto.getActionMap().put("Abrir",  
								new AbstractAction("Abrir") {  
							public void actionPerformed(ActionEvent evt) {
								Object[] options = { "SIM", "NÃO" };
								int op = JOptionPane.showOptionDialog(null, "Deseja criar um Novo Projeto?", "Confirme",
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
										null, options, options[0]);
								switch (op) {
								case 0:
									jtNomeProjeto.setSelectionEnd(0);
									jtNomeProjeto.setText("");
									listaClasse.clear();
									jTreeClassesAtributos.clear();
									creatreXmlDynamic();
									jPanel1Principal.setVisible(true);
									salvarProjeto.setEnabled(true);
									exportarXml.setEnabled(true);
									break;
								case 1:
									break;	
								}
							}
						});
					}
					{
						abrir = new JMenuItem();
						menuArquivo.add(abrir);
						abrir.setText("Abrir");
						abrir.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e) {
								importXML();
								salvarProjeto.setEnabled(true);
								exportarXml.setEnabled(true);
							}
						});
					}
					{
						salvarProjeto = new JMenuItem();
						menuArquivo.add(salvarProjeto);
						salvarProjeto.setEnabled(false);
						salvarProjeto.setText("Salvar                       Ctrl+S");
						salvarProjeto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK),("Abrir"));
						salvarProjeto.getActionMap().put("Abrir",  
								new AbstractAction("Abrir") {  
							public void actionPerformed(ActionEvent evt) {
								exportXml();
							}
						});
						salvarProjeto.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e) {
								exportXml();
							}
						});
					}
					{
						exportarXml = new JMenuItem();
						menuArquivo.add(exportarXml);
						exportarXml.setText("Exportar XML");
						exportarXml.setEnabled(false);
						exportarXml.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e) {
								exportXml();
							}
						});

					}
					{
						importarXml = new JMenuItem();
						menuArquivo.add(importarXml);
						importarXml.setText("Importar XML");
						importarXml.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e) {
								importXML();
								salvarProjeto.setEnabled(true);
								exportarXml.setEnabled(true);
							}
						});
					}
					{
						menuSair = new JMenuItem();
						menuArquivo.add(menuSair);
						menuSair.setText("Sair                          Alt+F4");
						menuSair.setBounds(146, 105, 135, 21);
						menuSair.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								sair();
							}
						});
						menuSair.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK),("Abrir"));
						menuSair.getActionMap().put("Abrir",  
								new AbstractAction("Abrir") {  
							public void actionPerformed(ActionEvent evt) {
								sair();
							}
						});
					}
				}
				{
					jMenu1 = new JMenu();
					barraMenu.add(jMenu1);
					jMenu1.setText("Sobre");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Jacroid");
						jMenuItem1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								DlgSobre d = new  DlgSobre(null);
								d.setResizable(false);
								d.setModal(true);
								d.setLocation((tamanhoTelaPc.width - 489)/2, (tamanhoTelaPc.height - 271)/2);
								d.setVisible(true);
								
							}
						});
					}
					
				}
			}
			pack();
			//this.setSize(tamanhoTelaPc.width, tamanhoTelaPc.height - 50);
			this.setSize(1024,728);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void RemoverMenusItens() {
		mPopup.removeAll();
	}

	public void sair(){
		Object[] options = { "SIM", "NÃO" };
		int op = JOptionPane.showOptionDialog(null, "Deseja realmente Sair?", "Confirme",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
		if (op==0) {
			System.exit(0);
		}else{
		}
	}

	/***Método para pegar o click do mouse sobre a jTree**/
	class PopupTrigger extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			if (e.isPopupTrigger())
			{
				int x = e.getX();
				int y = e.getY();
				TreePath path = tree.getPathForLocation(x, y);
				if (path != null)
				{
					if (tree.isExpanded(path))
						mAction.putValue(Action.NAME, "Contrair");
					else
						mAction.putValue(Action.NAME, "Expandir");
					mPopup.show(tree, x, y);
					mClickedPath = path;
				}
			}
		}
	}

	/**Método definido para expandir ou colapsar os nós da jTree caso possua filho*/
	private void MenuItemExpandirColapsar() {

		mAction =  new AbstractAction(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (mClickedPath==null)
					return;
				if (jTreeClassesAtributos.getTree().isExpanded(mClickedPath)){
					mAction.putValue(Action.NAME, "Contrair");
					jTreeClassesAtributos.getTree().collapsePath(mClickedPath);
				}else{
					mAction.putValue(Action.NAME, "Contrair");
					jTreeClassesAtributos.getTree().expandPath(mClickedPath);
				}
			}
		};
		mPopup.add(mAction);
		mPopup.addSeparator();

	}

	/**Método de adicionar classe a jtree.**/
	private void MenuItemAdicionarClasse() {

		Action addClasse =  new AbstractAction("Add Class"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				addClasse();	
			}
		};
		mPopup.add(addClasse);

	}


	/**Método de adicionar atributo/tipo a jtree.**/
	private void MenuItemAdicionarAtributoChaveEstrangeira() {

		Action addAtributo =  new AbstractAction("Add Chave Estrangeira"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultMutableTreeNode node;
				//pegar o nó selecionado na jtree
				node = (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
				if(node != null){
					String nomeClasse = node.toString().substring(node.toString().indexOf(":")+1,node.toString().length());
					/**verificar para saber o nível em que o nó selecionado se encontra
					 * Se for 0 é o raiz 
					 * se for 1 é classe
					 * se for 2 é atributo ou método
					 * se for 3 é tipo de atributo**/
					if(tree.getSelectionPath().getPathCount() == 2){
						onAlterarDados(nomeClasse,2);
					}else{
						MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
					}

				}else{
					MessageDialog("Selecione algum nó da árvore.");	
				}
			}
		};
		mPopup.add(addAtributo);
	}

	/**Método de adicionar atributo/tipo a jtree.**/
	private void MenuItemAdicionarAtributo() {

		Action addAtributo =  new AbstractAction("Add Atributo"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultMutableTreeNode node;
				//pegar o nó selecionado na jtree
				node = (DefaultMutableTreeNode)(tree.getLastSelectedPathComponent());
				if(node != null){
					String nomeClasse = node.toString().substring(node.toString().indexOf(":")+1,node.toString().length());
					/**verificar para saber o nível em que o nó selecionado se encontra
					 * Se for 0 é o raiz 
					 * se for 1 é classe
					 * se for 2 é atributo ou método
					 * se for 3 é tipo de atributo**/
					if(tree.getSelectionPath().getPathCount() == 2){
						onAlterarDados(nomeClasse,1);
					}else{
						MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
					}

				}else{
					MessageDialog("Selecione algum nó da árvore.");	
				}
			}
		};
		mPopup.add(addAtributo);
	}

	/**Método de adicionar método a jtree.** AINDA NÂO TERMINADO***/
	private void MenuItemAdicionarMetodo() {

		Action addMetodo =  new AbstractAction("Add Metodo"){
			@Override
			public void actionPerformed(ActionEvent e) {
				addMetodo();
			}
		};
		//m_popup.add(addMetodo);
	}


	private void MenuItemRemover() {
		Action addRemover =  new AbstractAction("Remover"){
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		};
		mPopup.add(addRemover);
	}

	private void MenuItemMostrar() {
		Action addRemover =  new AbstractAction("Mostrar"){
			@Override
			public void actionPerformed(ActionEvent e) {
				//encoder();
				//decoder();
				//recurseXMLJtree();
				TreePath parentPath = tree.getSelectionPath();
				DefaultMutableTreeNode no = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(tree.getSelectionPath().getPathCount() == 2){
					mostrar(1, parentPath, no);
				}else if(tree.getSelectionPath().getPathCount() == 3){
					mostrar(2, parentPath, no);
					//mostrar();
				}

				creatreXmlDynamic();
			}
		};
		mPopup.add(addRemover);
	}

	
	/***********************Métodos Úteis***************************************/
	/**Método abstrato para exibir mensagem de entrada
	 * @param comando - define o nome do requerente da acao, exemplo:
	 * comando = "Classe" 
	 * mensagem exibida = "Informe o nome + "comando" "**/
	private String InputDialog(String comando){
		String nome = JOptionPane.showInputDialog(TelaInicial.this, 
				"Informe o nome "+comando+": ",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		String unaccented = Normalizer.normalize(nome, Normalizer.Form.NFD); // elimina os acentos.  
		unaccented = unaccented.replaceAll("[^\\p{ASCII}]", ""); // remove as sujeiras do processo acima.  
		unaccented = unaccented.replaceAll("[^a-zA-Z]","");
		return unaccented;
	}

	/**Método abstrato para exibir mensagem de saída**
	 * @param mensagem - mensagem a ser exibida:
	 ***/
	private void MessageDialog(String mensagem){
		JOptionPane.showMessageDialog(TelaInicial.this, mensagem ,"Info",JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Verifica e faz a exclusão de itens 
	 * @param nomeClasse
	 * @param nomeAtributo
	 * @param op - 1 para classe e 2 para atributo 
	 */
	private void buscarRemoverListaClasse(String nomeClasse, String nomeAtributo,int op) {

		ClassDescriptor cl = new ClassDescriptor();;

		switch (op) {
		case 1:
			//consulta o hashmap e verificar se há algum item com a chave passada(nome_classe)
			for (int i = 0; i < listaClasse.size(); i++) {
				if (listaClasse.containsKey(nomeClasse)) {
					listaClasse.remove(nomeClasse);
				}
			}
			break;
		case 2:
			for (int i = 0; i < listaClasse.size(); i++) {
				//consulta o hashmap e verificar se há algum item com a chave passada(nome_classe)
				if(listaClasse.containsKey(nomeClasse)){
					cl = (ClassDescriptor) listaClasse.get(nomeClasse);
					for (int j = 0; j < cl.getAttributes().size(); j++) {
						//consulta  os atributos e verificar se há algum item com a chave passada(nome_atributo)
						if(cl.getAttributes().get(j).getName().equals(nomeAtributo)){
							cl.getAttributes().remove(j);
							break;
						}else{
							System.out.println("não achou.");
						}
					}
				}else{
					System.out.println("Não existe na lista.");
				}
			}
			break;	
		default:
			break;
		}
	}

	/**
	 * Verifica e faz a exclusão de itens 
	 * @param nomeClasse
	 * @param nomeAtributo
	 * @param op - 1 para classe e 2 para atributo 
	 */
	private ClassDescriptor buscarClasse(String nomeClasse) {

		ClassDescriptor cl = new ClassDescriptor();

		//consulta o hashmap e verificar se há algum item com a chave passada(nome_classe)
		for (int i = 0; i < listaClasse.size(); i++) {
			if (listaClasse.containsKey(nomeClasse)) {
				return cl = (ClassDescriptor) listaClasse.get(nomeClasse);
			}
		}
		return cl;
	}
	/**
	 * Buscar Atributos para uma classe
	 * @param nomeClasse
	 * @param nomeAtributo
	 * @return objeto do tipo AttributeDescriptor
	 */
	private AttributeDescriptor buscarAtributo(String nomeClasse, String nomeAtributo) {
		ClassDescriptor cl = new ClassDescriptor();
		AttributeDescriptor at = new AttributeDescriptor();

		for (int i = 0; i < listaClasse.size(); i++) {
			//consulta o hashmap e verificar se há algum item com a chave passada(nome_classe)
			if(listaClasse.containsKey(nomeClasse)){
				cl = (ClassDescriptor) listaClasse.get(nomeClasse);
				for (int j = 0; j < cl.getAttributes().size(); j++) {
					//consulta  os atributos e verificar se há algum item com a chave passada(nome_atributo)
					if(cl.getAttributes().get(j).getName().equalsIgnoreCase(nomeAtributo)){
						at = cl.getAttributes().get(j);
						break;
					}else{
						System.out.println("não achou.");
					}
				}
			}else{
				System.out.println("Não existe na lista.");
			}
		}
		return at;
	}
	/**
	 * Método para alterar dados de atributos(chave estrangeira e atributos comuns)
	 * @param op - op=1 para chave estrangeira e op=2 para atributo comun
	 * @param nomeClasse - nome classe
	 * @param nomeAtributo - nome do atributo da classe
	 * @param attribute - objeto com os dados do atributo
	 */
	public void alterarDadosAtributo(int op, String nomeClasse, String nomeAtributo, AttributeDescriptor attribute) {
		ClassDescriptor cl = new ClassDescriptor();
		AttributeDescriptor at = new AttributeDescriptor();

		switch (op) {
		case 1:
			ClassDescriptor clAux = new ClassDescriptor();

			Iterator itt = listaClasse.values().iterator();

			int count = 0;
			//verificar se possui alguma classe com nome da tabela passado
			while(itt.hasNext()){
				clAux = (ClassDescriptor) itt.next();
				//contar quantos possuem o mesmo nome
				if(clAux.getName().equalsIgnoreCase(nomeClasse)){
				for (int j = 0; j < clAux.getAttributes().size(); j++) {
					if(clAux.getAttributes().get(j).getName().equalsIgnoreCase(attribute.getName()) ||
						clAux.getAttributes().get(j).getColumntable().equalsIgnoreCase(attribute.getColumntable()) ||
						clAux.getAttributes().get(j).getExhibitionname().equalsIgnoreCase(attribute.getExhibitionname())){
						count = count + 1;
					}
				}
				}
				
			}
			if(count == 0){
			for (int i = 0; i < listaClasse.size(); i++) {
				//consulta o hashmap e verificar se há algum item com a chave passada(nome_classe)
				if(listaClasse.containsKey(nomeClasse)){
					cl = (ClassDescriptor) listaClasse.get(nomeClasse);
					for (int j = 0; j < cl.getAttributes().size(); j++) {
						//consulta  os atributos e verificar se há algum item com a chave passada(nome_atributo)
						if(cl.getAttributes().get(j).getName().equalsIgnoreCase(nomeAtributo)){
							cl.getAttributes().get(j).setExhibitionname(attribute.getExhibitionname());
							MessageDialog("Chave estrangeira alterado com sucesso.");
							break;
						}else{
							System.out.println("não achou.");
						}
					}
				}else{
					System.out.println("Não existe na lista.");
				}
			}
			}else{
				MessageDialog("Não foi possível alterar o atributo,\n" +
				" uma vez que outra atributo já possui o mesmo nome da coluna do banco de dados informado.");
			}
			break;
		case 2:
			ClassDescriptor clAux2 = new ClassDescriptor();

			Iterator itt2 = listaClasse.values().iterator();

			int count2 = 0;
			//verificar se possui alguma classe com nome da tabela passado
			while(itt2.hasNext()){
				clAux2 = (ClassDescriptor) itt2.next();
				//contar quantos possuem o mesmo nome
				if(clAux2.getName().equalsIgnoreCase(nomeClasse)){
				for (int j = 0; j < clAux2.getAttributes().size(); j++) {
					if(clAux2.getAttributes().get(j).getName().equalsIgnoreCase(attribute.getName()) ||
						clAux2.getAttributes().get(j).getColumntable().equalsIgnoreCase(attribute.getColumntable()) ||
						clAux2.getAttributes().get(j).getExhibitionname().equalsIgnoreCase(attribute.getExhibitionname())){
						count2 = count2 + 1;
					}
				}
				}
				
			}
			if(count2 == 0){
			for (int i = 0; i < listaClasse.size(); i++) {
				//consulta o hashmap e verificar se há algum item com a chave passada(nome_classe)
				if(listaClasse.containsKey(nomeClasse)){
					cl = (ClassDescriptor) listaClasse.get(nomeClasse);
					for (int j = 0; j < cl.getAttributes().size(); j++) {
						//consulta  os atributos e verificar se há algum item com a chave passada(nome_atributo)
						if(cl.getAttributes().get(j).getName().equalsIgnoreCase(nomeAtributo)){
							cl.getAttributes().get(j).setExhibitionname(attribute.getExhibitionname());
							cl.getAttributes().get(j).setTypeData(attribute.getTypeData());
							cl.getAttributes().get(j).setInput(attribute.getInput());
							cl.getAttributes().get(j).setColumntable(attribute.getColumntable());
							cl.getAttributes().get(j).setColumn(attribute.isColumn());
							MessageDialog("Atributo alterado com sucesso.");
							break;
						}else{
							System.out.println("não achou.");
						}
					}
				}else{
					System.out.println("Não existe na lista.");
				}
			}
			}else{
				MessageDialog("Não foi possível alterar o atributo,\n" +
				" uma vez que outra atributo já possui o mesmo nome da coluna do banco de dados informado.");
			}
			break;
		default:
			break;
		}

		creatreXmlDynamic();

	}
	/**
	 * Metodo para alterar dados de classe, mais especificamente o nome da tabela do BD
	 * @param nomeClasse - classe selecionada
	 * @param nomeTabelaBD - nome da tabela selecionado informado para mudança
	 */
	public void alterarDadosClasse(String nomeClasse, String nomeTabelaBD) {
		ClassDescriptor cl = new ClassDescriptor();
		ClassDescriptor cl2 = new ClassDescriptor();
		AttributeDescriptor at = new AttributeDescriptor();

		Iterator i = listaClasse.values().iterator();

		int count = 0;
		//verificar se possui alguma classe com nome da tabela passado
		while(i.hasNext()){
			cl = (ClassDescriptor) i.next();
			//contar quantos possuem o mesmo nome
			if(cl.getTablename().equalsIgnoreCase(nomeTabelaBD)){
				count = count + 1;
			}
		}
		// verifica se a quantidade é maior que zero
		// se for maior que zero não deixa alterar, caso contrario é feita a alteracao
		if(count == 0){
			for (int j = 0; j < listaClasse.size(); j++) {
				if(listaClasse.containsKey(nomeClasse)){
					cl2 = (ClassDescriptor) listaClasse.get(nomeClasse);
					cl2.setTablename(nomeTabelaBD);
				}
			}
			MessageDialog("Alterado com sucesso.");
		}else{
			MessageDialog("Não foi possível alterar o nome da tabela,\n" +
			" uma vez que outra classe já possui o mesmo nome informado.");
		}
		creatreXmlDynamic();

	}

	/**
	 * Verificar se a classe ou atributo  com o mesmo ja foi adicionado*
	 * @param nome - nome da classe ou atributo
	 * @param op - 1 para classe e 2 para atributo*/

	public boolean classeAtributoIsExist(String nome, int op, String nomeClasse) {

		Collection lista = listaClasse.values();
		ClassDescriptor cl = new ClassDescriptor();;
		// obtemos um iterador
		Iterator itt = lista.iterator();

		switch (op) {
		case 1:
			while(itt.hasNext()){
				cl = (ClassDescriptor) itt.next();
				if (cl.getName().equalsIgnoreCase(nome)) {
					return true;
				}
			}
			break;
		case 2:
			while(itt.hasNext()){
				cl = (ClassDescriptor) itt.next();
				for (int i = 0; i < cl.getAttributes().size(); i++) {
					if(cl.getName().equalsIgnoreCase(nomeClasse)){
						if(cl.getAttributes().get(i).getName().toString().equalsIgnoreCase(nome)){
							return true;
						}
					}
				}
			}
			break;
		default:
			break;
		}
		return false;

	}

	/**Método que executa a construção do XML */
	private void creatreXmlDynamic() {
		Document doc;
		org.w3c.dom.Element rootnode;
		org.w3c.dom.Element element;
		org.w3c.dom.Element child;
		try {

			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = dbfac.newDocumentBuilder();

			doc = docBuilder.newDocument();

			rootnode = doc.createElement("Classe");
			doc.appendChild(rootnode);

			Collection lista = listaClasse.values();
			ClassDescriptor cl;
			// obtemos um iterador
			Iterator i = listaClasse.values().iterator();

			// vamos exibir os valores
			while(i.hasNext()){
				cl = (ClassDescriptor) i.next();
				//System.out.println("Nome Classe: "+cl.getName());
				element = doc.createElement("class");
				element.setAttribute("classname",cl.getName());
				element.setAttribute("tablename", cl.getTablename());
				rootnode.appendChild(element);
				if(cl.getAttributes().size() > 0 ){
					for (int j = 0; j < cl.getAttributes().size(); j++) {
						child =  doc.createElement("attributes");
						child.setAttribute("name",cl.getAttributes().get(j).getName());
						child.setAttribute("type", cl.getAttributes().get(j).getTypeData());
						child.setAttribute("column",String.valueOf(cl.getAttributes().get(j).isColumn()));
						child.setAttribute("primarykey",String.valueOf(cl.getAttributes().get(j).isPrimaryKey()) );
						child.setAttribute("primarykey_table",String.valueOf(cl.getAttributes().get(j).isPrimaryKey_table()) );
						child.setAttribute("input", cl.getAttributes().get(j).getInput());
						child.setAttribute("classname", cl.getAttributes().get(j).getClassname());
						child.setAttribute("columntable", cl.getAttributes().get(j).getColumntable());
						child.setAttribute("exhibitionname", cl.getAttributes().get(j).getExhibitionname());
						element.appendChild(child);
						rootnode.appendChild(element);
					}
				}
			}
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			//create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString();

			FileWriter out =  new FileWriter("./implementor.xml");
			out.write(xmlString);
			out.close();

			jtXmlVisualizar.setText(xmlString);
			xmlString = "";
			//print xml
			//System.out.println("Here's the xml:\n\n" + xmlString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**Método que executa a construção do XML */
	private void exportXml() {
		Document doc;
		org.w3c.dom.Element rootnode;
		org.w3c.dom.Element element;
		org.w3c.dom.Element child;
		try {

			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = dbfac.newDocumentBuilder();

			doc = docBuilder.newDocument();

			rootnode = doc.createElement("Classe");
			doc.appendChild(rootnode);

			ClassDescriptor cl;
			// obtemos um iterador
			Iterator i = listaClasse.values().iterator();

			// vamos exibir os valores
			while(i.hasNext()){
				cl = (ClassDescriptor) i.next();
				//System.out.println("Nome Classe: "+cl.getName());
				element = doc.createElement("class");
				element.setAttribute("classname",cl.getName());
				element.setAttribute("tablename", cl.getTablename());
				rootnode.appendChild(element);
				if(cl.getAttributes().size() > 0 ){
					for (int j = 0; j < cl.getAttributes().size(); j++) {
						child =  doc.createElement("attributes");
						child.setAttribute("name",cl.getAttributes().get(j).getName());
						child.setAttribute("type", cl.getAttributes().get(j).getTypeData());
						child.setAttribute("column",String.valueOf(cl.getAttributes().get(j).isColumn()));
						child.setAttribute("primarykey",String.valueOf(cl.getAttributes().get(j).isPrimaryKey()) );
						child.setAttribute("primarykey_table",String.valueOf(cl.getAttributes().get(j).isPrimaryKey_table()) );
						child.setAttribute("input", cl.getAttributes().get(j).getInput());
						child.setAttribute("classname", cl.getAttributes().get(j).getClassname());
						child.setAttribute("columntable", cl.getAttributes().get(j).getColumntable());
						child.setAttribute("exhibitionname", cl.getAttributes().get(j).getExhibitionname());
						element.appendChild(child);
						rootnode.appendChild(element);
					}
				}
			}
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			//trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			//create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString();

			if(listaClasse.size() > 0){

				FileFilter filter = new FileNameExtensionFilter("XML Files", "xml");

				javax.swing.JFileChooser arquivo = new javax.swing.JFileChooser();
				arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY );

				arquivo.addChoosableFileFilter(filter);

				int resultadoArq = arquivo.showDialog( null, "Exportar" );

				if( resultadoArq == javax.swing.JFileChooser.CANCEL_OPTION)
					return;

				File arquivoNome = arquivo.getSelectedFile();

				if( arquivoNome == null || arquivoNome.getName().equals("")){
					javax.swing.JOptionPane.showMessageDialog( null, "Nome do arquivo está vazio.",
							"Nome de Arquivo Inválido", javax.swing.JOptionPane.ERROR_MESSAGE );
				}else{
					if(arquivoNome.toString().indexOf(".") > 0) {
						if (arquivoNome.getAbsolutePath().substring(arquivoNome.toString().length()-4,arquivoNome.toString().length()).equalsIgnoreCase(".xml")) {
							try {
								FileWriter out =  new FileWriter(arquivoNome);
								out.write(xmlString);
								out.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							MessageDialog("O arquivo foi Exportado em: "+arquivoNome);
						}else{
							javax.swing.JOptionPane.showMessageDialog( null, "Nome de Arquivo Deve Ter como Extensão '.xml'.",
									"Nome de Arquivo Inválido", javax.swing.JOptionPane.ERROR_MESSAGE );
						}
					}else{
						try {
							FileWriter out =  new FileWriter(arquivoNome+".xml");
							out.write(xmlString);
							out.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						MessageDialog("O arquivo foi Exportado em: "+arquivoNome+".xml");
					}
				}
			}else{
				MessageDialog("É necessário o projeto possuir no mínimo uma classe pra que possar ser Exportado.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/** jdom sax driver */
	private static String saxDriverClass = null;

	/** jdom root elemnt */

	/**
	 * Importar XML e Montar Jtree
	 */
	private void importXML(){
		jTreeClassesAtributos.clear();
		listaClasse.clear();
		FileFilter filter = new FileNameExtensionFilter("XML Files", "xml");
		javax.swing.JFileChooser arquivo = new javax.swing.JFileChooser();
		arquivo.setFileSelectionMode( javax.swing.JFileChooser.FILES_ONLY );
		arquivo.addChoosableFileFilter(filter);

		if(arquivo.showDialog(arquivo,"Importar") == javax.swing.JFileChooser.APPROVE_OPTION){
			File file = arquivo.getSelectedFile();
			// 
			ArrayList<ClassDescriptor> arrayClasses = ReadXML.read(file.getAbsolutePath().toString());
			for (int i = 0; i < arrayClasses.size(); i++) {
				//adiciono o objeto a lista para posteriormente usa-la para criação do xml
				listaClasse.put(arrayClasses.get(i).getName().toString(), arrayClasses.get(i));
				//click no botão mostrar, para visualizar a criação do xml de entrada em tempo de execução
			}
			creatreXmlDynamic();
			jPanel1Principal.setVisible(true);
			try
			{
				SAXBuilder builder = new SAXBuilder();

				org.jdom.Document d = (org.jdom.Document) builder.build(file.getAbsolutePath().toString());

				Element root = (Element) d.getRootElement();

				DefaultMutableTreeNode rootNode = jTreeClassesAtributos.getRootNode();

				recurseXml(root, rootNode);
			}
			catch(Exception e)
			{
				System.out.println("initXml Exception: " + e);
			}
		}
	}

	/**método recursivo para criar Jtree a partir do arquivo XML
	 * @param Element element - passar o nó root do xml
	 * @param DefaultMutableTreeNode parentNode - passar o nó root da Jtree
	 * */
	private void recurseXml(Element element, DefaultMutableTreeNode parentNode){
		if(element.getChildren().size()>0){
			List elementList = element.getChildren();

			Iterator listIterator = elementList.iterator();

			while (listIterator.hasNext()){
				Element currentElement = (Element) listIterator.next();

				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode();
				if (currentElement.getName().equals("class")){
					newNode.setUserObject("classe:"+currentElement.getAttributeValue("classname"));
				}else{
					DefaultMutableTreeNode newNode2 = new DefaultMutableTreeNode();
					newNode2.setUserObject("tipo:"+currentElement.getAttributeValue("type"));
					if(currentElement.getAttributeValue("primarykey_table").equalsIgnoreCase("true")){
						newNode.setUserObject("primarykey:"+currentElement.getAttributeValue("name"));
						newNode.add(newNode2);
					}else{
						newNode.setUserObject("atributo:"+currentElement.getAttributeValue("name"));
						newNode.add(newNode2);
					}
				}
				jTreeClassesAtributos.getTreeModel().insertNodeInto(newNode,parentNode,parentNode.getChildCount());
				// recurse make the parent node the newnode
				recurseXml(currentElement,newNode);
			}
		}
	}

	/**
	 * Verifica se as telas de adicionar atributo e adicionar chave estrangeira foram devidamente fechadas
	 * @param nomeClasse
	 * @param op - 1 para atributo e 2 para chave estrangeira 
	 */
	private void onAlterarDados(String nomeClasse,int op){

		switch (op) {
		case 1:
			DlgAlterarDados jd = new DlgAlterarDados(null, nomeClasse);
			jd.setResizable(false);
			jd.setBounds((tamanhoTelaPc.width - 411)/2,(tamanhoTelaPc.height - 332)/2,411, 332);
			jd.setNomeClasse(nomeClasse);
			//jd.add_classes_jc_chave_estrangeira(lista_classe, nome_classe);
			if (jd.alterarDados())
			{
				AttributeDescriptor att = new AttributeDescriptor();
				att.setName(jd.getNomeAtributo().toString());
				att.setTypeData(jd.getTypeData());
				att.setColumn(jd.getColumn());
				att.setPrimaryKey(jd.getPrimaryKey());
				att.setPrimaryKey_table(jd.getPrimaryKeyTable());
				att.setInput(jd.getInput());
				att.setClassname(jd.classname());
				att.setColumntable(jd.getColumnTable());
				att.setExhibitionname(jd.getNomeDeExibicao());
				addAtributo(nomeClasse, att);
			}
			jd.dispose();
			break;

		case 2:
			DlgInsertForeignKey ji = new DlgInsertForeignKey(null, nomeClasse);
			ji.setResizable(false);
			ji.setBounds((tamanhoTelaPc.width - 411)/2,(tamanhoTelaPc.height - 332)/2,411, 332);
			ji.setNomeClasse(nomeClasse);
			ji.addClassesJcChaveEstrangeira(listaClasse, nomeClasse);

			if (ji.alterarDados())
			{
				AttributeDescriptor att = new AttributeDescriptor();
				att.setName(ji.getNomeAtributo().toString());
				att.setTypeData(ji.getTypeData());
				att.setColumn(ji.getColumn());
				att.setPrimaryKey(ji.getPrimaryKey());
				att.setPrimaryKey_table(ji.getPrimaryKeyTable());
				att.setInput(ji.getInput());
				att.setClassname(ji.className());
				att.setColumntable(ji.getColumnTable());
				att.setExhibitionname(ji.getNomeDeExibicao());
				addAtributo(nomeClasse, att);
			}
			ji.dispose();
			break;
		default:
			break;
		}
	}


	/*************************Métodos*****************************/

	/**
	 * Método para mostrar os dados da classe ou atributo.
	 * @param op -> 1 para classe e 2 para atributo
	 * @param parentPath -> selecao da arvore
	 * @param no -> nó selecionado
	 * **/

	//METODO PARA ALTERAR REALMENTE A CLASSE E OS ATRIBUTOS
	private void mostrar(int op, TreePath parentPath, DefaultMutableTreeNode no){

		ClassDescriptor cl = new ClassDescriptor();
		AttributeDescriptor at = new AttributeDescriptor();

		switch (op) {
		case 1:
			final IFAlterarDadosClasse i = new IFAlterarDadosClasse();
			i.setBounds(50,10,400, 340);
			i.setResizable(false);
			cl = buscarClasse(parentPath.getLastPathComponent().toString().substring(parentPath.getLastPathComponent().toString().indexOf(":")+1,parentPath.getLastPathComponent().toString().length()));
			jpDetalhamentoAtributosClasses.removeAll();
			jpDetalhamentoAtributosClasses.add(i);
			i.setNomeClasse(cl.getName());
			i.setNomeExibicao(cl.getName());
			i.setNomeTabelaBD(cl.getTablename());
			i.setVisible(true);

			final String nomeDaClasse = cl.getName();

			JTextField jtTabelaBD =  i.getJtNomeTabelaBd();
			jtTabelaBD.setEditable(true);
			i.setJtNomeTabelaBd(jtTabelaBD);
			jpDetalhamentoAtributosClasses.validate();

			i.addInternalFrameListener(new InternalFrameListener() {
				@Override
				public void internalFrameOpened(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameIconified(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameDeiconified(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameDeactivated(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameClosing(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameClosed(InternalFrameEvent arg0) {
					alterarDadosClasse(nomeDaClasse, i.getNomeTabelaBD().toString());
				}
				@Override
				public void internalFrameActivated(InternalFrameEvent arg0) {
				}
			});
			break;
		case 2:
			final IFAlterarDados internal = new IFAlterarDados();
			internal.setBounds(50,10,400, 340);
			internal.setResizable(false);
			jpDetalhamentoAtributosClasses.removeAll();
			jpDetalhamentoAtributosClasses.add(internal);
			at = buscarAtributo(no.getParent().toString().substring(no.getParent().toString().indexOf(":")+1,no.getParent().toString().length()),parentPath.getLastPathComponent().toString().substring(parentPath.getLastPathComponent().toString().indexOf(":")+1,parentPath.getLastPathComponent().toString().length()));
			internal.setNomeClasse(no.getParent().toString().substring(no.getParent().toString().indexOf(":")+1,no.getParent().toString().length()));
			internal.setNomeAtributo(at.getName());
			internal.setNomeExibicao(at.getExhibitionname());
			internal.setNomeColunaBD(at.getColumntable());
			internal.setIsColuna(at.isColumn());
			internal.setChavePrimaria(at.isPrimaryKey_table());
			if(at.isPrimaryKey() == true && at.isPrimaryKey_table() == false){
				internal.setChaveEstrangeira(true);
			}else{
				internal.setChaveEstrangeira(false);
			}
			internal.setTipoDado(at.getTypeData());
			internal.setTipoComponente(at.getInput());
			internal.setNomeClasseReferenciada(at.getClassname());
			internal.setVisible(true);
			//verificar se atributo selecionado é chave(primaria, estrangeira)
			if(!at.isPrimaryKey_table()){
				if(at.isPrimaryKey()){
					JTextField jtNomeDeExibicao1 =  internal.getJtNomeDeExibicao();
					jtNomeDeExibicao1.setEditable(true);
					internal.setJtNomeDeExibicao(jtNomeDeExibicao1);

					JComboBox jtTipo =  internal.getJcTipo();
					jtTipo.setEnabled(false);
					internal.setjcTipo(jtTipo);

					JComboBox jtTipoComp =  internal.getJcTipoComponente();
					jtTipoComp.setEnabled(false);
					internal.setJctipo_componente(jtTipoComp);

					JTextField jtNomeColuna =  internal.getJtNomeColunaBd();
					jtNomeColuna.setEditable(false);
					internal.setJtNomeColunaBd(jtNomeColuna);

					JComboBox jtIsColuna =  internal.getJtColuna();
					jtIsColuna.setEditable(false);
					internal.setJtColuna(jtIsColuna);

				}else{
					JTextField jtNomeDeExibicao1 =  internal.getJtNomeDeExibicao();
					jtNomeDeExibicao1.setEditable(true);
					internal.setJtNomeDeExibicao(jtNomeDeExibicao1);

					JComboBox jtTipo =  internal.getJcTipo();
					jtTipo.setEnabled(true);
					internal.setjcTipo(jtTipo);

					JComboBox jtTipoComp =  internal.getJcTipoComponente();
					jtTipoComp.setEnabled(true);
					internal.setjcTipoComponente(jtTipoComp);

					JTextField jtNomeColuna =  internal.getJtNomeColunaBd();
					jtNomeColuna.setEditable(true);
					internal.setJtNomeColunaBd(jtNomeColuna);

					JComboBox jtIsColuna =  internal.getJtColuna();
					jtIsColuna.setEnabled(true);
					internal.setJtColuna(jtIsColuna);

				}
			}

			jpDetalhamentoAtributosClasses.validate();
			internal.addInternalFrameListener(new InternalFrameListener() {
				@Override
				public void internalFrameOpened(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameIconified(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameDeiconified(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameDeactivated(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameClosing(InternalFrameEvent arg0) {
				}
				@Override
				public void internalFrameClosed(InternalFrameEvent arg0) {
					
					AttributeDescriptor attribute = new AttributeDescriptor();
					System.out.println(internal.getChavePrimaria());
					if(internal.getChavePrimaria() == false){
						if(internal.getChaveEstrangeira() == true){
							attribute.setExhibitionname(internal.getNomeExibicao());
							alterarDadosAtributo(1,internal.getNomeClasse(), internal.getNomeAtributo(), attribute);
						}else{
//							JOptionPane.showMessageDialog(null, internal.getNomeExibicao()+ "\n"
//									+ internal.getTipoDado() + "\n"
//									+ internal.getTipoComponente() + "\n"
//									+ internal.getNomeColunaBD()+ "\n"
//									+ internal.getIsColuna()+ "\n"
//									+ "nome do atributo:" + internal.getNomeAtributo());
							attribute.setExhibitionname(internal.getNomeExibicao());
							attribute.setTypeData(internal.getTipoDado());
							attribute.setInput(internal.getTipoComponente());
							attribute.setColumntable(internal.getNomeColunaBD());
							attribute.setColumn(internal.getIsColuna());
							alterarDadosAtributo(2,internal.getNomeClasse(), internal.getNomeAtributo(), attribute);
						}

					}else{
						MessageDialog("O atributo selecionado é uma chave primária.\n"+ 
								"A alteração não pode ser efetuada.");
					}
					creatreXmlDynamic();
				}
				@Override
				public void internalFrameActivated(InternalFrameEvent arg0) {
				}
			});
			break;

		default:
			break;
		}
	}/*
		TreePath parentPath = tree.getSelectionPath();
		DefaultMutableTreeNode no = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		ClassDescriptor cl = new ClassDescriptor();

		AttributeDescriptor at = new AttributeDescriptor();
//		JInternalFrame dia = new JInternalFrame();
//		dia.setBounds(50,10,400, 330);
//		dia.setResizable(false);
//		dia.setVisible(true);
		JPanelMostrarDadosAtributo jpAtributo =  new JPanelMostrarDadosAtributo();
		jpAtributo.setBounds(60,30,400, 300);

		//jpDetalhamentoAtributosClasses.add(dia);
		//jpAtributo.setVisible(false);




		JPanelMostrarDadosClasse jpClasse =  new JPanelMostrarDadosClasse();
		jpClasse.setBounds(60,30,400, 300);
		//jpDetalhamentoAtributosClasses.add(jpClasse);
		//jpClasse.setVisible(false);


		if(tree.getSelectionPath().getPathCount() == 2){
			cl = buscarClasse(parentPath.getLastPathComponent().toString().substring(parentPath.getLastPathComponent().toString().indexOf(":")+1,parentPath.getLastPathComponent().toString().length()));
			jpDetalhamentoAtributosClasses.removeAll();
			jpDetalhamentoAtributosClasses.add(jpClasse);
			jpClasse.setNomeClasse(cl.getName());
			jpClasse.setNomeExibicao(cl.getName());
			jpClasse.setNomeColunaBD(cl.getTablename());
			jpClasse.setVisible(true);
			jpDetalhamentoAtributosClasses.validate();
		}else if(tree.getSelectionPath().getPathCount() == 3){
			jpDetalhamentoAtributosClasses.removeAll();
			jpDetalhamentoAtributosClasses.add(i);
			at = buscarAtributo(no.getParent().toString().substring(no.getParent().toString().indexOf(":")+1,no.getParent().toString().length()),parentPath.getLastPathComponent().toString().substring(parentPath.getLastPathComponent().toString().indexOf(":")+1,parentPath.getLastPathComponent().toString().length()));
			i.setNomeClasse(no.getParent().toString().substring(no.getParent().toString().indexOf(":")+1,no.getParent().toString().length()));
			i.setNomeAtributo(at.getName());
			i.setNomeExibicao(at.getExhibitionname());
			i.setNomeColunaBD(at.getColumntable());
			i.setIsColuna(at.isColumn());
			i.setChavePrimaria(at.isPrimaryKey_table());
			if(at.isPrimaryKey() == true && at.isPrimaryKey_table() == false){
				i.setChaveEstrangeira(true);
			}else{
				i.setChaveEstrangeira(false);
			}
			i.setTipoComponente(at.getInput());
			i.setTipoDado(at.getType());
			i.setNomeClasseReferenciada(at.getClassname());
			i.setVisible(true);
			jpDetalhamentoAtributosClasses.validate();

			if(i.alterarDados()){
				JOptionPane.showMessageDialog(null, "aqui");
			}
			i.addInternalFrameListener(new InternalFrameListener() {

				@Override
				public void internalFrameOpened(InternalFrameEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void internalFrameIconified(InternalFrameEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void internalFrameDeiconified(InternalFrameEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void internalFrameDeactivated(InternalFrameEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void internalFrameClosing(InternalFrameEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void internalFrameClosed(InternalFrameEvent arg0) {
					JOptionPane.showMessageDialog(null, "Aqui");
				}

				@Override
				public void internalFrameActivated(InternalFrameEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		//	ESTOU AQUI
//			if(jpAtributo.alterarDados()){
//				at.setInput(jpAtributo.getNomeExibicao());
//				JOptionPane.showMessageDialog(null,"funfou");
//				alterarDadosAtributo(jpAtributo.getNomeClasse(),jpAtributo.getNomeAtributo() , at);
//				creatreXmlDynamic();
//////				jpAtributo.getNomeColunaBD();
//////				jpAtributo.getIsColuna();
//////				jpAtributo.getChavePrimaria();
//////				jpAtributo.getChaveEstrangeira();
//////				jpAtributo.getTipoComponente();
//////				jpAtributo.getTipoDado();
//////				jpAtributo.getNomeClasseReferenciada();
////				jpAtributo.setVisible(true);
////			}
		}
	}

	/**Método que adiciona classe ao Árvore de Classes/Atributos/Tipos  ***/
	private void addClasse() {
		//pegar o nó selecionado na jtree
		TreePath parentPath = tree.getSelectionPath();
		if(parentPath != null){
			// *verifica se o nó selecionando é o nó raiz.*
			if(parentPath.toString().substring(1,parentPath.toString().length() - 1).equalsIgnoreCase(jTreeClassesAtributos.getRootNode().toString())){
				//*chama o método para mostrar Joptionpane.showinputdialog*
				String novaClasse = InputDialog("Classe");
				if(classeAtributoIsExist(novaClasse,1,"")== false){
					//verificar se foi passado ou não algum valor no inputdialog
					if(!(novaClasse == null || novaClasse.equalsIgnoreCase(""))){
						String nomeExibicaoClasse = InputDialog("da Tabela do Banco de Dados para a Classe");
						if(!(nomeExibicaoClasse == null || nomeExibicaoClasse.equalsIgnoreCase(""))){
							
							ClassDescriptor clAux = new ClassDescriptor();
							AttributeDescriptor at = new AttributeDescriptor();

							Iterator itt = listaClasse.values().iterator();

							int count = 0;
							//verificar se possui alguma classe com nome da tabela passado
							while(itt.hasNext()){
								clAux = (ClassDescriptor) itt.next();
								//contar quantos possuem o mesmo nome
								if(clAux.getName().equalsIgnoreCase(novaClasse) || 
									clAux.getTablename().equalsIgnoreCase(nomeExibicaoClasse)){
									count = count + 1;
								}
							}
							// verifica se a quantidade é maior que zero
							// se for maior que zero não deixa alterar, caso contrario é feita a alteracao
							if(count == 0){
							
							//adiciona o nó a jtree
							DefaultMutableTreeNode t = new DefaultMutableTreeNode();
							DefaultMutableTreeNode tTipo = new DefaultMutableTreeNode();
							t.setUserObject("primarykey:id"+GeneratorUtility.firstToUpperCase(novaClasse));
							tTipo.setUserObject("tipo:int");
							t.add(tTipo);
							jTreeClassesAtributos.addObject("classe:"+GeneratorUtility.firstToUpperCase(novaClasse)).add(t);

							ClassDescriptor classe = new ClassDescriptor();
							classe.setName(GeneratorUtility.firstToUpperCase(novaClasse));
							classe.setTablename(GeneratorUtility.AllToLowerCase(nomeExibicaoClasse));
							AttributeDescriptor att = new AttributeDescriptor();
							att.setName("id"+GeneratorUtility.firstToUpperCase(novaClasse));
							att.setTypeData("int");
							att.setColumn(true);
							att.setPrimaryKey(true);
							att.setPrimaryKey_table(true);
							att.setInput("hidden");
							att.setClassname("");
							att.setColumntable("id"+novaClasse);
							att.setExhibitionname("id"+novaClasse);
							classe.addAttribute(att);
							//adiciono o objeto a lista para posteriormente usa-la para criação do xml
							listaClasse.put(classe.getName(), classe);
							//click no botão mostrar, para visualizar a criação do xml de entrada em tempo de execução
							creatreXmlDynamic();
							}else{
								MessageDialog("Não foi possível inserir a classe,\n" +
								" uma vez que outra classe já possui o mesmo nome da Tabela do banco de dados informado.");
							}
						}else{
							MessageDialog("É necessário preencher o campo com o Nome da Tabela para a Classe.");
						}
					}else{
						MessageDialog("É necessário preencher o campo com o Nome da Classe.");
					}
				}else{
					MessageDialog("Já existe um classe associada a esse nome. \n Classe:" + novaClasse.toUpperCase());
				}
			}else{
				MessageDialog("Não é possível adicionar um Nova Classe. \n Para Add Class selecione o nó raiz(Classe) da árvore.");
			}
		}else{
			MessageDialog("Selecione algum nó da árvore.");	
		}
	}

	/**Método que adiciona atributo e chave estrangeira ao Árvore de Classes/Atributos/Tipos  *
	 * @param String nome_classe - nome da classe
	 * @param AtributeDescriptor - objeto do tipo AtributeDescriptor,
	 * esses dados são recuperados através do método onAlterarDados e os passa para esse método**/
	public void addAtributo(String nomeClasse, AttributeDescriptor attributes){

		String nomeAtributo = attributes.getName().toString();
		String tipo = attributes.getTypeData().toString();
		String classname = attributes.getClassname().toString();
		String input = attributes.getInput().toString();
		String pchace = String.valueOf(attributes.isPrimaryKey());
		String pestra = String.valueOf(attributes.isPrimaryKey_table());
		String coluna = String.valueOf(attributes.isColumn());
		String columntable = String.valueOf(attributes.getColumntable());
		String exhibitionname = String.valueOf(attributes.getExhibitionname());

		if(classeAtributoIsExist(nomeAtributo, 2, nomeClasse) == false){

			//verificar se foi passado ou não algum valor no inputdialog
			if(!(nomeAtributo == null)){
				//adiciono o atributo e logo em seguida criou o objeto DefaultMutableTreeNode e adiciono o seu tipo
				ClassDescriptor clAux = new ClassDescriptor();

				Iterator itt = listaClasse.values().iterator();

				int count = 0;
				//verificar se possui alguma classe com nome da tabela passado
				while(itt.hasNext()){
					clAux = (ClassDescriptor) itt.next();
					//contar quantos possuem o mesmo nome
					if(clAux.getName().equalsIgnoreCase(nomeClasse)){
					for (int j = 0; j < clAux.getAttributes().size(); j++) {
						if(clAux.getAttributes().get(j).getName().equalsIgnoreCase(attributes.getName()) ||
							clAux.getAttributes().get(j).getColumntable().equalsIgnoreCase(attributes.getColumntable()) ||
							clAux.getAttributes().get(j).getExhibitionname().equalsIgnoreCase(attributes.getExhibitionname())){
							count = count + 1;
							}
						}
					}
					
				}
				if(count == 0){
				
				DefaultMutableTreeNode t = new DefaultMutableTreeNode();
				t.setUserObject("tipo:"+tipo);
				jTreeClassesAtributos.addObject("atributo:"+nomeAtributo).add(t);

				// verificar se há classe com a chave nome_classe para adicionar a lista o atributo com seu tipo
				for (int j = 0; j < listaClasse.size(); j++) {
					if (listaClasse.containsKey(nomeClasse)) {
						ClassDescriptor  cl = (ClassDescriptor) listaClasse.get(nomeClasse);

						AttributeDescriptor att = new AttributeDescriptor();
						att.setName(nomeAtributo);
						att.setTypeData(tipo);
						att.setColumn(Boolean.parseBoolean(coluna));
						att.setPrimaryKey(Boolean.parseBoolean(pchace));
						att.setPrimaryKey_table(Boolean.parseBoolean(pestra));
						att.setInput(input);
						att.setClassname(classname);
						att.setColumntable(columntable);
						att.setExhibitionname(exhibitionname);
						cl.addAttribute(att);
						listaClasse.put(nomeClasse, cl);
						break;
					}
				}
				}else{
					MessageDialog("Não foi possível inserir o atributo,\n" +
					" uma vez que outra atributo já possui o mesmo nome da coluna do banco de dados informado.");
				}
				//click no botão mostrar, para visualizar a criação do xml de entrada em tempo de execução
				creatreXmlDynamic();
			}else{
				MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Add Atributo selecione a Classe correspondente.");
			}

		}else{
			MessageDialog("Já existe um atributo associado a esse nome. \n Atributo:" + nomeAtributo.toUpperCase());	
		}
	}

	/**Método que adiciona método ao Árvore de Classes/Atributos/Tipos  ***/
	private void addMetodo() {
		DefaultMutableTreeNode parentNode = null;
		TreePath parentPath = tree.getSelectionPath();
		if(parentPath != null){
			/**verificar para saber o nível em que o nó selecionado se encontra
			 * Se for 0 é o raiz 
			 * se for 1 é classe
			 * se for 2 é atributo ou método
			 * se for 3 é tipo de atributo**/ 
			if(tree.getSelectionPath().getPathCount() == 2){
				String nomeMetodo = InputDialog("Método");
				if(!(nomeMetodo == null || nomeMetodo.equalsIgnoreCase("")))
					jTreeClassesAtributos.addObject("método:"+nomeMetodo+"()");
			}else{
				MessageDialog("Não é possível adicionar um Novo Atributo. \n Para um Método selecione a Classe correspondente.");
			}
		}else{
			MessageDialog("Selecione algum nó da árvore.");	
		}				
	}

	/**Método que remove classe/atributo da Árvore de Classes/Atributos/Tipos  ***/
	private void remover() {
		Object[] options = { "SIM", "NÃO" };
		if (JOptionPane.showOptionDialog(null, "Deseja Realmente excluir?", "Mensagem",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]) == 0){
			TreePath parentPath = tree.getSelectionPath();
			if(parentPath != null){
				/**verifica se o item selecionado é 
				 * raiz == 1
				 * classe == 2
				 * atributo == 3
				 * tipo == 4**/
				if(parentPath.getPathCount()<=3 && parentPath.getPathCount() > 1){
					/**se o item selecionado for atributo pode ser excluido*/
					if(parentPath.getPathCount() == 3){
						DefaultMutableTreeNode no = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						
						if(parentPath.getLastPathComponent().toString().substring(0,parentPath.getLastPathComponent().toString().indexOf(":")).equalsIgnoreCase("primarykey")){
							MessageDialog("Não é possível remover. \n O nó selecionado é a chave primária.");
						}else{
							//método para remover na lista 
							buscarRemoverListaClasse(no.getParent().toString().substring(no.getParent().toString().indexOf(":")+1,no.getParent().toString().length()), no.getUserObject().toString().substring(no.getUserObject().toString().indexOf(":")+1,no.getUserObject().toString().length()),2);
							//remover da jtree
							jTreeClassesAtributos.removeCurrentNode();
							//refresh na tela e recriar o xml
							creatreXmlDynamic();
						}
					}else{
						DefaultMutableTreeNode no = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						//método para remover na lista
						buscarRemoverListaClasse(parentPath.getLastPathComponent().toString().substring(parentPath.getLastPathComponent().toString().indexOf(":")+1,parentPath.getLastPathComponent().toString().length()), no.getUserObject().toString(),1);
						//remover da jtree
						jTreeClassesAtributos.removeCurrentNode();
						//refresh na tela e recriar o xml
						creatreXmlDynamic();
					}
				}else{
					if(parentPath.getPathCount() == 1){
						MessageDialog("Não é possível remover. \n O nó selecionado é o raiz.");
					}else if(parentPath.getPathCount() == 4){
						MessageDialog("Não é possível remover o tipo. \n Selecione o Atributo para remover.");
					}else{
						MessageDialog("Não é possível remover.");
					}
				}
			}else{
				MessageDialog("Selecione algum nó da árvore.");	
			}
		}
	}
}
