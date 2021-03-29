import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
//This class created in Singleton Design Pattern.
/*
 * This class created for displaying personal profile, menus, recipes, exercises, personal graph, edit weight, leader board options and motivation messages.
 * When user signed up or signed in successfully, program navigates this class.
*/
public class MainScreen {
	
	// Attributes
	private static User currAppUser;
	private static JFrame frame;
	private static MainScreen instance = new MainScreen();
	
	//Here the private constructor as Singleton Design Pattern required.
	private MainScreen() {
	}
	//Here the getInstance method as Singleton Design Pattern required.
	 public static MainScreen getInstance(User currentUser) {
		currAppUser = currentUser;
		initialize();
		frame.setVisible(true);
		return instance;
	 }
	 

	// This method initializes main screen's sections (i.e. buttons with their icons, motivation messages.) which includes visualized content as well. 
	private static void initialize() {
		//Here the frame defined.
		frame = new JFrame();
		frame.setBounds(700, 350, 537, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		//Here the personal profile button with its icon definition.
		Icon profileIco = new ImageIcon("Images/SystemImages/menuPersoProIco.png");
		JButton btnProfile = new JButton(profileIco);
		btnProfile.setText("My Profile");
		btnProfile.setMargin(new Insets(0,0,0,0));
		//When user click to button navigates through personal profile.
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				PersonalProfile psp = new PersonalProfile();
				try {
					psp.initPersonalProfile(currAppUser);
					psp.setVisible(true);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			
			}
		});
		btnProfile.setBounds(5, 0, 165, 100);
		frame.getContentPane().add(btnProfile);
		//Here the personal menus button with its icon definition.And navigation action listener through personal menus.
		Icon menuIco = new ImageIcon("Images/SystemImages/menuMenusIco.png");
		JButton btnMenus = new JButton(menuIco);
		btnMenus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalisedMenus psm = new PersonalisedMenus();
				try {
					psm.initPersonalisedMenus(currAppUser);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				psm.setBounds(100, 100, 1400, 740);
				psm.setVisible(true);
			}
		});
		btnMenus.setText("Menus");
		btnMenus.setBounds(175, 0, 165, 100);
		frame.getContentPane().add(btnMenus);
		//Here the personal menus button with its icon definition.And navigation action listener through personal menus.
		Icon leaderBoardIco = new ImageIcon("Images/SystemImages/menuLeaderBoardIco.png");
		JButton btnLeaderBoard = new JButton(leaderBoardIco);
		btnLeaderBoard.setText("Leader Board");
		btnLeaderBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					LeaderBoard psne = new LeaderBoard();
					try {
						psne.showLeaderBoard(currAppUser.getProgrammeSelection());
					} catch (UnsupportedEncodingException | FileNotFoundException e) {
						
						e.printStackTrace();
					}
					
			}
		});
		btnLeaderBoard.setBounds(5, 195, 165, 100);
		frame.getContentPane().add(btnLeaderBoard);
		//Here the personal execises button with its icon definition.And navigation action listener through personal exercises.
		Icon exerciseIco = new ImageIcon("Images/SystemImages/menuExerciseIco.png");
		JButton btnExercises = new JButton(exerciseIco);
		btnExercises.setText("Exercise");
		btnExercises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					PersonalisedExercises psne = new PersonalisedExercises();
					psne.programmeSelection(currAppUser.getProgrammeSelection());
					
			}
		});
		
		btnExercises.setBounds(350, 101, 175, 93);
		frame.getContentPane().add(btnExercises);
		//Here the recipes button with its icon definition.And navigation action listener through recipes.
		Icon recipeIco = new ImageIcon("Images/SystemImages/menuRecipeIco.png");
		JButton btnRecipes = new JButton(recipeIco);
		btnRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recipes rcp = new Recipes();
			}
		});
		btnRecipes.setText("Recipes");
		btnRecipes.setBounds(350, 0, 175, 100);
		frame.getContentPane().add(btnRecipes);
		
		//Here the edit weight button with its icon definition.And navigation action listener through edit weight.
		Icon editMyWeightIco = new ImageIcon("Images/SystemImages/menuEditMyWeightIco.png");
		JButton btnEditMyWeight = new JButton(editMyWeightIco);
		btnEditMyWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalProgress pesp = new PersonalProgress(currAppUser);
				
			}
		});
		btnEditMyWeight.setText("Edit My Weight");
		btnEditMyWeight.setBounds(175, 195, 165, 100);
		frame.getContentPane().add(btnEditMyWeight);
		
		//Here the personal progress button with its icon definition.And navigation action listener through personal progress.
		Icon myProgressIco = new ImageIcon("Images/SystemImages/menuProgressIco.png");
		JButton btnMyprogress = new JButton(myProgressIco);
		btnMyprogress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonalisedGraph pg;
				try {
					pg = new PersonalisedGraph(currAppUser);
					pg.run();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		btnMyprogress.setText("MyProgress");
		btnMyprogress.setBounds(350, 195, 175, 100);
		frame.getContentPane().add(btnMyprogress);
		//Here the motivational messages displaying options settled.
		JTextArea txtrMotvatob = new JTextArea();
		txtrMotvatob.setBackground(SystemColor.menu);
		txtrMotvatob.setEditable(false);
		txtrMotvatob.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 13));
		//Here the motivation factory object created.
		MotivationFactory mf = new MotivationFactory();
		//Here the motivation message displaying as defined with program selection of user.
		MotivationDisplayer md = mf.display(currAppUser.getProgrammeSelection());
		
		txtrMotvatob.setText(md.displayMotivationMessage());
		
		txtrMotvatob.setBounds(10, 140, 341, 22);
		frame.getContentPane().add(txtrMotvatob);
	}
	//Here getter and setters.
	public static User getCurrAppUser() {
		return currAppUser;
	}
	public static void setCurrAppUser(User currAppUser) {
		MainScreen.currAppUser = currAppUser;
	}
	
}
