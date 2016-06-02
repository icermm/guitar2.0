package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.*;
import tool.DbUtil;;

public class GuitarDao {
	public static  Inventory inventory()
	{
		Inventory inventory = new Inventory();
		Connection connection = DbUtil.getConnection();
		PreparedStatement pstat;
		ResultSet rs;
		try {
			pstat = connection.prepareStatement("select * from guitar");
			rs = pstat.executeQuery();
			while (rs.next()) {
				GuitarSpec guitarspec = new GuitarSpec( null, null, null, null,null);
				guitarspec.setBuilder(rs.getString("builder"));
				guitarspec.setModel(rs.getString("model"));
				guitarspec.setType(rs.getString("type"));
				guitarspec.setTopWood(rs.getString("topWood"));
				guitarspec.setBackWood(rs.getString("backWood"));
				inventory.addGuitar(rs.getString("serialNumber"), rs.getDouble("price"), guitarspec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
}