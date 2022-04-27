package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import entity.ColorNew;


public class ColorsNewDao {

	//private Connection connection;
	//private final String GET_COLORS_QUERY = "SELECT * FROM colorsNew";
	//private final String ADD_COLOR_QUERY = "INSERT INTO colorsNew (hexId, colorName) VALUES (?)";
	//private final String DELETE_COLOR_BY_HEX_QUERY = "DELETE FROM colorsNew WHERE hexId = ?";
	//private final String EDIT_COLOR_BY_HEX_QUERY = "UPDATE colorsNew SET colorName = ? WHERE hexId = ?";

	//public ColorsNewDao() {
		//connection = DBConnection.getConnection();
	//}

	//List all colors currently in the table
	public List<ColorNew> listColors() throws SQLException {
		String sql = "SELECT * FROM colorsNew";
		Connection conn = DBConnection.instance().getConnection();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			List<ColorNew> colorsNew = new LinkedList<>();
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					ColorNew colorNew = new ColorNew(rs.getString(1), rs.getString(2));
					colorsNew.add(colorNew);
				}
			}
			return colorsNew;
		} catch (SQLException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
		//ResultSet rs = connection.prepareStatement(GET_COLORS_QUERY).executeQuery(); // no additional variable to hold
																						// statement required
		//List<ColorNew> colorNew = new ArrayList<ColorNew>();

		//while (rs.next()) {
		//	colorNew.add(colorList(rs.getString(1), rs.getString(2)));
	//	}
	//	return colorNew;
	}

	//add a color to the table with a hexId and color name
	public void addColor(String hexId, String colorName) throws SQLException {
		String sql = "INSERT INTO colorsNew (hexId, colorName) VALUES (?,?)";
		Connection conn = DBConnection.instance().getConnection();
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, hexId);
			stmt.setString(2, colorName);
			stmt.executeUpdate();
		} catch (SQLException e) {
		}
		
	}
// delete a color in the table - must look up using hexId
	public void deleteColorByHex(String hexId) {
		String sql = "DELETE FROM colorsNew WHERE hexId = ?";
		Connection conn = DBConnection.instance().getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
		ps.setString(1, hexId);
		if (ps.executeUpdate() == 0) {
			throw new IllegalStateException("Color with hexId " + hexId + " does not exist!");
		}
	} catch (SQLException e) {
		throw new IllegalStateException(e.getMessage(), e);
	}
	}
//edit a color in the table by changing the color name, looking it up by hexid
	public void updateColorByHex(String colorName, String hexId) throws SQLException {
		String sql = "UPDATE colorsNew SET colorName = ? WHERE hexId = ?";
		Connection conn = DBConnection.instance().getConnection();

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
		ps.setString(1, colorName);
		ps.setString(2, hexId);
		ps.executeUpdate();
		
		}
	}

	//private ColorNew colorList(String hexId, String colorName) {
		//return new ColorNew(hexId, colorName);
	//}

}
