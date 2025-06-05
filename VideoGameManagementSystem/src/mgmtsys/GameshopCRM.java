package mgmtsys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class GameshopCRM {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtyr;
	private JTextField txtprice;
	private JTextField txtavp;
	private JTextField searchbox;

	public static Connection c;
	public static PreparedStatement ps;
	public static ResultSet rs;
	private static JTable table_2;
	private JTextField keyword;

	/**
	 * Launch the application.
	 */
	public static void dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamecentral", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void loadTable() {
		String query = "select * from gamedetails";
		try {
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameshopCRM window = new GameshopCRM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameshopCRM() {
		initialize();
		// LoginPass.loginCred(LoginPass.uname,LoginPass.password);
		dbConnection();
		loadTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rishiraj\\Downloads\\hq720.jpg"));
		frame.setBounds(100, 100, 609, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("GameCentral DB");
		lblNewLabel.setBounds(194, 11, 202, 34);
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("PMingLiU-ExtB", Font.BOLD | Font.ITALIC, 27));
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(40, 58, 248, 152);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Insert Records/View Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		final JLabel txtname1 = new JLabel("Game");
		txtname1.setBounds(91, 35, 40, 13);
		txtname1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(txtname1);

		txtname = new JTextField();
		txtname.setBounds(136, 26, 86, 28);
		panel.add(txtname);
		txtname.setColumns(10);

		final JLabel txtyr1 = new JLabel("Desc & release");
		txtyr1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtyr1.setBounds(45, 64, 86, 14);
		panel.add(txtyr1);

		txtyr = new JTextField();
		txtyr.setBounds(136, 58, 86, 24);
		panel.add(txtyr);
		txtyr.setColumns(10);

		final JLabel txtprice1 = new JLabel("Price");
		txtprice1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtprice1.setBounds(103, 91, 28, 14);
		panel.add(txtprice1);

		txtprice = new JTextField();
		txtprice.setBounds(136, 86, 86, 22);
		panel.add(txtprice);
		txtprice.setColumns(10);

		final JLabel txtavp1 = new JLabel("Available copies");
		txtavp1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtavp1.setBounds(40, 121, 91, 14);
		panel.add(txtavp1);

		txtavp = new JTextField();
		txtavp.setBounds(136, 114, 86, 25);
		panel.add(txtavp);
		txtavp.setColumns(10);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gname = txtname.getText();
				String year_type = txtyr.getText();
				String price = txtprice.getText();
				String avail_cpy = txtavp.getText();
				try {
					if (!gname.equals("")) {
						String query = "insert into gamedetails(name,release_year_and_type,price,available_copies) values (?,?,?,?)";
						ps = c.prepareStatement(query);
						// ps.setString(1, id);
						ps.setString(1, gname);
						ps.setString(2, year_type);
						ps.setString(3, price);
						ps.setString(4, avail_cpy);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Added Succesfully!");
						loadTable();
						txtname.setText("");
						txtyr.setText("");
						txtprice.setText("");
						txtavp.setText("");
						txtname.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Enter valid game details!");
					}
				} catch (SQLException s) {
					s.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(40, 212, 76, 34);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(124, 212, 76, 34);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtname.setText("");
				txtyr.setText("");
				txtprice.setText("");
				txtavp.setText("");
				txtname.requestFocus();
			}
		});
		btnNewButton_2.setBounds(210, 212, 76, 34);
		frame.getContentPane().add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Search By Id", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(334, 58, 214, 62);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel gid = new JLabel("Game ID");
		gid.setFont(new Font("Tahoma", Font.BOLD, 10));
		gid.setBounds(33, 29, 46, 14);
		panel_1.add(gid);

		searchbox = new JTextField();
		searchbox.setBounds(95, 24, 86, 25);
		panel_1.add(searchbox);
		searchbox.setColumns(10);

		JButton find = new JButton("FIND");
		find.setBounds(71, 62, 76, 25);
		panel_1.add(find);

//		t1 = new JScrollPane();
//		t1.setBounds(293, 40, 187, 181);
//		frame.getContentPane().add(t1);
//		
//		table = new JTable();
//		t1.setViewportView(table);

		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gname = txtname.getText();
				String year_type = txtyr.getText();
				String price = txtprice.getText();
				String avail_cpy = txtavp.getText();
				String gid = searchbox.getText();
				if (gname.equals("")) {
					JOptionPane.showMessageDialog(null, "No record selected for Update!");
				} else {
					try {
						String query = "update gamedetails set name=?,release_year_and_type=?,price=?,available_copies=? where id=?";
						ps = c.prepareStatement(query);
						// ps.setString(1, id);
						ps.setString(1, gname);
						ps.setString(2, year_type);
						ps.setString(3, price);
						ps.setString(4, avail_cpy);
						ps.setString(5, gid);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Updated Succesfully!");
						loadTable();
					} catch (SQLException x) {
						x.printStackTrace();
					}
				}
			}
		});
		btnNewButton_3.setBounds(186, 458, 84, 34);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String del = searchbox.getText();
				if (txtname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No record selected for Deletion!");
				} else {
					try {
						String query = "delete from gamedetails where id=?";
						ps = c.prepareStatement(query);
						ps.setString(1, del);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Deleted!");
						loadTable();
					} catch (SQLException b) {
						b.printStackTrace();
					}
				}
			}
		});
		btnNewButton_4.setBounds(288, 458, 84, 34);
		frame.getContentPane().add(btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(40, 258, 508, 195);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 21, 466, 154);
		panel_2.add(scrollPane);

		table_2 = new JTable();
		scrollPane.setViewportView(table_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Search by Keywords (Desc)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(334, 156, 214, 68);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Keyword");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(35, 32, 49, 14);
		panel_3.add(lblNewLabel_1);

		keyword = new JTextField();
		keyword.setBounds(94, 25, 86, 28);
		panel_3.add(keyword);
		keyword.setColumns(10);

		JButton fkey = new JButton("Find");
		fkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchByKey = keyword.getText();
				try {
					String query = "select * from gamedetails where release_year_and_type like ?";
					ps = c.prepareStatement(query);
					ps.setString(1, "%" + searchByKey + "%");
					rs = ps.executeQuery();
					String gname = "", details = "", price = "", avail_cpy = "";
					if (searchByKey.equals("")) {
						JOptionPane.showMessageDialog(null, "Enter valid input!");
					} else if (rs.next()) {
						gname = rs.getString(2);
						details = rs.getString(3);
						price = rs.getString(4);
						avail_cpy = rs.getString(5);
						txtname.setText(gname);
						txtyr.setText(details);
						txtprice.setText(price);
						txtavp.setText(avail_cpy);
						JOptionPane.showMessageDialog(null, "Records with " + searchByKey + " found!");
						keyword.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "No records found!");
					}

				} catch (SQLException q) {
					q.printStackTrace();
				}
			}
		});
		fkey.setBounds(398, 230, 89, 23);
		frame.getContentPane().add(fkey);

		JButton ikey = new JButton("Find");
		ikey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchById = searchbox.getText();
				try {
					String query = "select * from gamedetails where id=?";
					ps = c.prepareStatement(query);
					ps.setString(1, searchById);
					rs = ps.executeQuery();

					String gname = "", details = "", price = "", avail_cpy = "";
					if (searchById.equals("")) {
						JOptionPane.showMessageDialog(null, "Enter valid input!");
					} else if (rs.next()) {
						gname = rs.getString(2);
						details = rs.getString(3);
						price = rs.getString(4);
						avail_cpy = rs.getString(5);
						txtname.setText(gname);
						txtyr.setText(details);
						txtprice.setText(price);
						txtavp.setText(avail_cpy);
						// JOptionPane.showMessageDialog(null,searchById+" found!");
						searchbox.setText("");
						// txtname.requestFocus();
					}
//					if(gname!=null) 
//					{
//						txtname.setText(gname);
//						txtyr.setText(details);
//						txtprice.setText(price);
//						txtavp.setText(avail_cpy);
//					}
					else {
						JOptionPane.showMessageDialog(null, "No records found!");
					}
				} catch (SQLException r) {
					r.printStackTrace();
				}
			}
		});
		ikey.setBounds(398, 122, 89, 23);
		frame.getContentPane().add(ikey);
	}
}
