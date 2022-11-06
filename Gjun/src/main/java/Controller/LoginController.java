package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.member.memberDaoimpl;
import Model.member;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		member m=new memberDaoimpl().queryMember(username, password);
		HttpSession session;
		if(m != null) {
			session=request.getSession();
			session.setAttribute("M", m);
			response.sendRedirect("member/loginSuccess.jsp");
		}else {
			response.sendRedirect("member/loginError.jsp");
		}
		
	}

}
