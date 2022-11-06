package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.porder.porderDaoimpl;

public class DeletePorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int id=Integer.parseInt(request.getParameter("id"));
    	new porderDaoimpl().delete(id);
    	
    	response.sendRedirect("porder/delete.jsp");
    	
    }

}
