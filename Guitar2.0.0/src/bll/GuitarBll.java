package bll;

import dao.GuitarDao;
import beans.Inventory;

public class GuitarBll {
	public static  Inventory inventory()       //��ʼ��inventory ��ȡ���м������ص�inventory��
	{
		return GuitarDao.inventory();
	}
}