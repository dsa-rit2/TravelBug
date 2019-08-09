package travelBug.UI;

import java.awt.*;
import java.awt.Window.Type;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import travelBug.library.CircularLinkedList;
import travelBug.library.GroupList;
import travelBug.library.LinkArray;
import travelBug.library.ReadWriteFile;
import travelBug.obj.TravelLegAccount;
import travelBug.obj.TravelLegInfo;
import travelBug.obj.User;

import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ItemEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTrip extends JPanel {

	private JPanel callPanel;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JButton btnSelect;
	private JTextField[] txtArray = new JTextField[5];
	private String callFrontArrow = "---";
	private String callBackArrow = "-->";

	private final UIControl mainFrame;

	// Test//
//	private ReadWriteFile<TravelLegAccount> tFile = new ReadWriteFile<TravelLegAccount>("TravelLegAccount.txt",
//			TravelLegAccount.class);
//	private LinkArray<TravelLegAccount> tArray = tFile.readLinkArray();
//	private LinkArray<User> uArray = new LinkArray<User>();

//	private CircularLinkedList<TravelLegAccount> tCircular = new CircularLinkedList<TravelLegAccount>();

	////////
	
	
	private ReadWriteFile<TravelLegInfo> tFile = new ReadWriteFile<TravelLegInfo>("TravelLeg.txt", TravelLegInfo.class);
	private LinkArray<TravelLegInfo> tArray = tFile.readLinkArray();

	private CircularLinkedList<CircularLinkedList<TravelLegInfo>> tCircular = new CircularLinkedList<CircularLinkedList<TravelLegInfo>>();
	
	

	public ViewTrip(UIControl parent) {

		super();
		this.mainFrame = parent;
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(new Rectangle(new Dimension(900, 450)));

		createGUI();
	}

	private void createGUI() {

//////////////////////add read write file data to circular link list///////////////////////
//		
//		tArray = tFile.readLinkArray();
//		for (int i = 0; i < tArray.size(); i++) {
//			
//			tCircular.add(new TravelLegInfo(tArray.getIndexElement(i).getMode(), 
//					                        tArray.getIndexElement(i).getSource(),
//					                        tArray.getIndexElement(i).getDest(), 
//					                        tArray.getIndexElement(i).getPrice(),
//					                        tArray.getIndexElement(i).getDistance(),
//					                        tArray.getIndexElement(i).getfromDate(),
//					                        tArray.getIndexElement(i).gettoDate(),
//					                        tArray.getIndexElement(i).getfromTime(),
//					                        tArray.getIndexElement(i).gettoTime(),
//					                        tArray.getIndexElement(i).getDuration()
//					                        ));
//			}

		// ====================Title=======================//
		JLabel lblViewTrip = new JLabel("View Trip");
		lblViewTrip.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewTrip.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblViewTrip.setBounds(10, 15, 878, 45);
		add(lblViewTrip);

		// ==========================Containers=============//

		CircularLinkedList<TravelLegInfo> pCircularLinkedList = new CircularLinkedList<TravelLegInfo>();
		LocalDate pDate = LocalDate.now();
		LocalTime pLocalTime = LocalTime.now();
		
		pCircularLinkedList.add(new TravelLegInfo("AAA",'T', "A", "B", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 5));
		pCircularLinkedList.add(new TravelLegInfo("BBB",'T', "B", "C", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 4));
		pCircularLinkedList.add(new TravelLegInfo("CCC",'T', "C", "D", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 3));
		pCircularLinkedList.add(new TravelLegInfo("DDD",'T', "D", "E", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		pCircularLinkedList.add(new TravelLegInfo("EEE",'T', "E", "F", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		tCircular.add(pCircularLinkedList);
		pCircularLinkedList.add(new TravelLegInfo("AAA",'T', "G", "H", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 5));
		pCircularLinkedList.add(new TravelLegInfo("BBB",'T', "H", "I", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 4));
		pCircularLinkedList.add(new TravelLegInfo("CCC",'T', "I", "J", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 3));
		pCircularLinkedList.add(new TravelLegInfo("DDD",'T', "J", "K", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		pCircularLinkedList.add(new TravelLegInfo("EEE",'T', "K", "L", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		tCircular.add(pCircularLinkedList);
		pCircularLinkedList.add(new TravelLegInfo("AAA",'T', "L", "M", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 5));
		pCircularLinkedList.add(new TravelLegInfo("BBB",'T', "M", "N", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 4));
		pCircularLinkedList.add(new TravelLegInfo("CCC",'T', "N", "O", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 3));
		pCircularLinkedList.add(new TravelLegInfo("DDD",'T', "O", "P", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		pCircularLinkedList.add(new TravelLegInfo("EEE",'T', "P", "Q", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		tCircular.add(pCircularLinkedList);
		pCircularLinkedList.add(new TravelLegInfo("AAA",'T', "R", "S", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 5));
		pCircularLinkedList.add(new TravelLegInfo("BBB",'T', "S", "T", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 3));
		pCircularLinkedList.add(new TravelLegInfo("DDD",'T', "T", "U", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		pCircularLinkedList.add(new TravelLegInfo("EEE",'T', "U", "V", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		pCircularLinkedList.add(new TravelLegInfo("EEE",'T', "V", "W", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		tCircular.add(pCircularLinkedList);
		pCircularLinkedList.add(new TravelLegInfo("AAA",'T', "AA", "BB", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 5));
		pCircularLinkedList.add(new TravelLegInfo("BBB",'T', "BB", "CC", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 4));
		pCircularLinkedList.add(new TravelLegInfo("CCC",'T', "CC", "DD", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 3));
		pCircularLinkedList.add(new TravelLegInfo("DDD",'T', "DD", "EE", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		pCircularLinkedList.add(new TravelLegInfo("EEE",'T', "EE", "FF", 100.00, 100.00, pDate, pDate, pLocalTime, pLocalTime, 2));
		tCircular.add(pCircularLinkedList);
		
		for (CircularLinkedList<TravelLegInfo> q : tCircular) {
			
		}
		Font callFont = new Font("Segoe UI", Font.PLAIN, 16);
		LineBorder lineBorder = new LineBorder(Color.GRAY, 2, true);
		callPanel = new JPanel(new GridLayout(5, 5));
		callPanel.setBorder(lineBorder);
		callPanel.setBounds(40, 58, 811, 334);
		
		
		//====================On Click=========================//
		for (int i = 0; i < txtArray.length; ++i) {
			txtArray[i] = new JTextField(80);
			txtArray[i].setFont(callFont);
			txtArray[i].setEditable(false);
			txtArray[i].setBackground(Color.white);
			txtArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			if(i == 0) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 1) {
							
							txtArray[0].setBackground(Color.lightGray);
							txtArray[1].setBackground(Color.white);
							txtArray[2].setBackground(Color.white);
							txtArray[3].setBackground(Color.white);
							txtArray[4].setBackground(Color.white);
						}
					}
				});
			}
			else if(i == 1) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 1) {
							
							txtArray[0].setBackground(Color.white);
							txtArray[1].setBackground(Color.lightGray);
							txtArray[2].setBackground(Color.white);
							txtArray[3].setBackground(Color.white);
							txtArray[4].setBackground(Color.white);
						}
					}
				});
			}
			else if(i == 2) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 1) {
							
							txtArray[0].setBackground(Color.white);
							txtArray[1].setBackground(Color.white);
							txtArray[2].setBackground(Color.lightGray);
							txtArray[3].setBackground(Color.white);
							txtArray[4].setBackground(Color.white);
						}
					}
				});
			}
			else if(i == 3) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 1) {
							
							txtArray[0].setBackground(Color.white);
							txtArray[1].setBackground(Color.white);
							txtArray[2].setBackground(Color.white);
							txtArray[3].setBackground(Color.lightGray);
							txtArray[4].setBackground(Color.white);
						}
					}
				});
			}
			else if(i == 4) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 1) {
							
							txtArray[0].setBackground(Color.white);
							txtArray[1].setBackground(Color.white);
							txtArray[2].setBackground(Color.white);
							txtArray[3].setBackground(Color.white);
							txtArray[4].setBackground(Color.lightGray);
						}
					}
				});
			}
			//=============================================================//
			
			//========================Double Click=========================//
			if(i == 0) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 2) {
							

						}
					}
				});
			}
			else if(i == 1) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 2) {
							SwingUtilities.invokeLater(() -> mainFrame
									.changePanel(new DisplayTrip(mainFrame, pCircularLinkedList)));
							
						}
					}
				});
			}
			else if(i == 2) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 2) {
							

						}
					}
				});
			}
			else if(i == 3) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 2) {
							

						}
					}
				});
			}
			else if(i == 4) {
				txtArray[i].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent arg0) {
						if (arg0.getClickCount() == 2) {
							

						}
					}
				});
			}
			//=============================================================//
			
			
			///////////////////////// For readwrite file display///////////////////////////

//			for (int j = 1; j <= tCircular.getSize(); j++) {
//				pStrings += tCircular.getEntry(j).getDest();
//				
//				if(tCircular.getEntry(j+1) !=null) {
//					pStrings +=  callArrow;
//				}
//			}
			///////////////////////////

			////////////////////////////////////////// Time
			////////////////////////////////////////// calculation////////////////////////////////////////////
			String dateStart = "01/14/2012 09:29:58";
			String dateStop = "01/15/2012 10:31:48";

			String tString = new String();

			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

			Date d1 = null;
			Date d2 = null;

			try {
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);

				// in milliseconds
				long diff = d2.getTime() - d1.getTime();

				// long diffSeconds = diff / 1000 % 60; //define seconds
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				tString += diffDays + "D " + diffHours + "h " + diffMinutes + "m ";

			} catch (Exception e) {
				e.printStackTrace();
			}
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////

			/////////////////////////// For hard code display/////////////////////////////

			String pStrings = new String();
			double totalPrice = 0;

			int adult = 4;
			int kiddo = 5;

			for (int j = 1; j <= tCircular.getEntry(i+1).getSize(); j++) {

				double kids = tCircular.getEntry(i+1).getEntry(j).getPrice() * 0.5 * kiddo;
				double adults = tCircular.getEntry(i+1).getEntry(j).getPrice() * adult;

				totalPrice += kids + adults;

				if (j == 1) {// Display first source and first destination

					pStrings += tCircular.getEntry(i+1).getEntry(j).getSource();

					pStrings += callFrontArrow;
					pStrings += tString;
					pStrings += callBackArrow;

					pStrings += tCircular.getEntry(i+1).getEntry(j).getDest();
					pStrings += callFrontArrow;
					pStrings += tString;
					pStrings += callBackArrow;
				} else {// Display next destination
					pStrings += tCircular.getEntry(i+1).getEntry(j).getDest();

					if (tCircular.getEntry(i+1).getEntry(j + 1) != null) {
						pStrings += callFrontArrow;
						pStrings += tString;
						pStrings += callBackArrow;
					}
				}

			}
			///////////////////////////////////////////////////////////////////////////
			// put data to panel
			txtArray[i].setText(pStrings + "\n Price: RM " + totalPrice);

			callPanel.add(txtArray[i]);
		}
		add(callPanel);// display panel

		// =====================Button======================//
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.GRAY);
		btnBack.setActionCommand("");
		btnBack.setBounds(340, 410, 120, 40);
		add(btnBack);

		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> mainFrame
						.changePanel(new DisplayTrip(mainFrame, pCircularLinkedList)));
			}
		});
		btnSelect.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSelect.setForeground(Color.BLACK);
		btnSelect.setBackground(Color.GRAY);
		btnSelect.setActionCommand("");
		btnSelect.setBounds(470, 410, 120, 40);
		add(btnSelect);

	}

}
