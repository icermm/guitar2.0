package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import tool.DbUtil;
import beans.*;


public class guitarDao {

	public static inventory inventory() // 获取所有吉他加载到inventory内
	{
		inventory inventory = new inventory();
		// List<guitar> guitars = new ArrayList<guitar>();
		Connection connection = DbUtil.getConnection();
		PreparedStatement pstat;
		ResultSet rs;
		try {
			pstat = connection.prepareStatement("select * from guitar");
			rs = pstat.executeQuery();
			while (rs.next()) {
				guitarspec guitarspec = new guitarspec(null, null, null, null, null);
				guitarspec.setBuilder(rs.getString("builder"));
				guitarspec.setTopWood(rs.getString("topWood"));
				guitarspec.setBackWood(rs.getString("backWood"));
				guitarspec.setType(rs.getString("type"));
				guitarspec.setModel(rs.getString("model"));
                
	//			System.out.println(guitarspec.getModel());
				
				inventory.addguitar(rs.getString("serialNumber"), rs.getDouble("price"), guitarspec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
}
