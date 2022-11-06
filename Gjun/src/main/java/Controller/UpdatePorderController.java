package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.porder.porderDaoimpl;
import Model.porder;

public class UpdatePorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("BIG5");
		int id=Integer.parseInt(request.getParameter("id"));
		porder p=new porderDaoimpl().queryPorder(id);
		p.setDesk(request.getParameter("desk"));
		p.setA(Integer.parseInt(request.getParameter("A")));
		p.setB(Integer.parseInt(request.getParameter("B")));
		p.setC(Integer.parseInt(request.getParameter("C")));
		p.setSum();
		
		new porderDaoimpl().update(p);
		response.sendRedirect("porder/update.jsp");
	}

}
