package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ColorsNewDao;
import entity.ColorNew;

//This displays a menu to allow the user to perform CRUD operations on a colorsNew table.
public class Menu {

	private ColorsNewDao colorsNewDao = new ColorsNewDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"1) Display Colors", // read
			"2) Add Color", // create
			"3) Edit Color", // update
			"4) Delete Color", // delete
			"5) Type 5 to Exit");

	public void start() {
		String selection = "";

		do {
			printMenu();
			selection = scanner.nextLine();

			try {
				if (selection.equals("1")) {
					listColors();
				} else if (selection.equals("2")) {
					addColor();
				} else if (selection.equals("3")) {
					editColor();
				} else if (selection.equals("4")) {
					deleteColor();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Press enter to continue..."); // keeps menu from automatically restarting, allowing user
																// to start the menu again when ready
			scanner.nextLine();

		} while (!selection.equals("5"));
	}

	private void editColor() throws SQLException {
		listColors();
		System.out.println("Enter hexId to edit: ");
		String hexId = scanner.nextLine();
		System.out.println("Enter new color name: ");
		String colorName = scanner.nextLine();
		colorsNewDao.updateColorByHex(hexId, colorName);
	}

	private void deleteColor() throws SQLException {
		System.out.print("Enter hexId to delete: ");
		String hexId = scanner.nextLine();
		colorsNewDao.deleteColorByHex(hexId);
	}

	private void addColor() throws SQLException {
		System.out.print("Enter new hexID: ");
		String hexIdId = scanner.nextLine();
		System.out.println("Enter new Color Name");
		String colorNameNew = scanner.nextLine();
		colorsNewDao.addColor(hexIdId, colorNameNew);
	}

	private void listColors() throws SQLException {
		List<ColorNew> colors = colorsNewDao.listColors();
		System.out.println("All colors: ");
		//System.out.println(colors.size());
		for (ColorNew color : colors) {
			System.out.println(" " + color.getHexId() + " " + color.getName());
		}
	}

	private void printMenu() {
		System.out.println("Select an Option:\n---------------------------");
		for (String line : options) {
			System.out.println(line);
		
	}
	}

}
