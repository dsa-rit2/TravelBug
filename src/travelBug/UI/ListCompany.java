package travelBug.UI;

//=========================
//	Import Package
//=========================
import travelBug.library.*;
import travelBug.obj.*;
//=========================
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListCompany extends JPanel {
	private static final long serialVersionUID = 1L; // Serializable purpose
	private LinkArray<Company> cArray = new LinkArray<Company>();
	private ReadWriteFile<Company> rFile = new ReadWriteFile<Company>("Company.txt", Company.class);
	private JTextField textField;
	private JList displayList;
	DefaultListModel listModel;
	private final UIControl mainFrame;
	private int companyFoundindex;

	public ListCompany(UIControl parent) {
		super();
		this.mainFrame = parent;
		// =================================== Jpanel setting
		// ===========================//
		cArray = rFile.readLinkArray();
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(new Rectangle(new Dimension(900, 450)));

		// =================================== Content component
		// =========================//
		JLabel lblConpanyList = new JLabel("Company List");
		lblConpanyList.setHorizontalAlignment(SwingConstants.CENTER);
		lblConpanyList.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblConpanyList.setBounds(123, 13, 623, 50);
		add(lblConpanyList);

		listModel = new DefaultListModel();
		displayList = new JList(listModel);
		displayList.setBounds(51, 71, 380, 278);
		
		updateList(null);
		add(displayList);
		displayList.setFont(new Font("Calibri", Font.BOLD, 15));
		displayList.setBorder(new LineBorder(new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 71, 380, 278);
		add(scrollPane);

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblSearch.setBounds(41, 362, 65, 20);
		add(lblSearch);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField.setBounds(123, 362, 308, 25);
		textField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateList(textField.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateList(textField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateList(textField.getText());
			}
		});
		add(textField);
		textField.setColumns(10);

		// ============================= Button =====================================//
		JButton btnAdd = new JButton("Add Company");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBounds(464, 128, 164, 55);
		btnAdd.addActionListener(event -> {
			SwingUtilities.invokeLater(() -> mainFrame.changePanel(new AddCompany(mainFrame)));
		});
		add(btnAdd);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(event -> {
			// redirect to mainmenu //

		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(650, 300, 168, 55);
		add(btnBack);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(event -> {
			if (displayList.getSelectedValue() == null) {
				library.dialogMessage("You must select company first");
			} else {
				String getCompany = displayList.getSelectedValue().toString();
				SwingUtilities.invokeLater(() -> mainFrame.changePanel(new EditCompany(getCompany, mainFrame)));
			}
		});
		btnModify.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnModify.setBounds(650, 191, 173, 48);
		add(btnModify);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(event -> {
			if (displayList.getSelectedValue() == null) {
				library.dialogMessage("You must select company first");
			} else {
				String getCompany = displayList.getSelectedValue().toString();
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete it?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (choice == JOptionPane.YES_NO_OPTION) {
					for (int i = 0; i < cArray.size(); i++) {
						if (cArray.getIndexElement(i).getCompanyName().equalsIgnoreCase(getCompany)) {
							cArray.deleteIndexItem(i);
						}
					}
					rFile.writeLinkArray(cArray);
					library.dialogMessage("The company is deleted!!!");
					updateList(null);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(650, 92, 168, 48);
		add(btnNewButton);

		JButton btnTravellegAccountList = new JButton("Travelleg Account List");
		btnTravellegAccountList.addActionListener(event -> {
			if (displayList.getSelectedValue() == null) {
				library.dialogMessage("You must select company first");
			} else {
				String getCompany = displayList.getSelectedValue().toString();
				SwingUtilities
						.invokeLater(() -> mainFrame.changePanel(new ListTravelLegAccount(mainFrame, getCompany)));
			}
		});
		btnTravellegAccountList.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnTravellegAccountList.setBounds(464, 237, 164, 55);
		add(btnTravellegAccountList);

	}

	// ==================== Function ==================== //
	public void updateList(String searchItem) {
		if (searchItem == null) {
			listModel = (DefaultListModel) displayList.getModel();
			listModel.clear();
			for (int i = 0; i < cArray.size(); i++) {
				listModel.addElement(cArray.getIndexElement(i).getCompanyName());
			}
		} else {
			searchItem = searchItem.toUpperCase();
			listModel = (DefaultListModel) displayList.getModel();
			listModel.clear();
			for (int i = 0; i < cArray.size(); i++) {
				if (cArray.getIndexElement(i).getCompanyName().toUpperCase().matches(searchItem + ".*")) {
					listModel.addElement(cArray.getIndexElement(i).getCompanyName());
				}
			}
		}

	}
}
