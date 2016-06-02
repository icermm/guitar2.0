package bll;

import dao.GuitarDao;
import beans.Inventory;

public class GuitarBll {
	public static  Inventory inventory()       //初始化inventory 获取所有吉他加载到inventory内
	{
		return GuitarDao.inventory();
	}
}