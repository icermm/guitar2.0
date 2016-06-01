package service;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.guitarDao;
import beans.*;

/**
 * Servlet implementation class matchguitar
 */
@WebServlet("/matchguitar")
public class matchguitar extends HttpServlet {
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ҳ���ѯ����������װ��spec
		guitarspec spec = new guitarspec(null, null, null, null, null);
		spec.setBackWood(request.getParameter("backwood"));
		spec.setBuilder(request.getParameter("builder"));
		spec.setModel(request.getParameter("model"));
		spec.setTopWood(request.getParameter("topwood"));
		spec.setType(request.getParameter("type"));
		// �½�һ��guitar List �����洢ƥ�䵽��guitars
		List matchingGuitars = new LinkedList();

		matchingGuitars = guitarDao.inventory().search(spec);
		
		System.out.println(matchingGuitars);
		
		request.setAttribute("res", matchingGuitars);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
