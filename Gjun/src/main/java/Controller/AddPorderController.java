package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.porder.porderDaoimpl;
import Model.porder;

public class AddPorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		porder p=(porder)session.getAttribute("P");
		new porderDaoimpl().add(p);
		
		response.sendRedirect("porder/finish.jsp");
	}

}
