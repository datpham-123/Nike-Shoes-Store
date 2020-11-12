package controller.customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CustomerLogoutServlet", urlPatterns = "/logout")
public class CustomerLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //delete status login, logout and logout link
        session.removeAttribute("accountLogin");
        request.setAttribute("loginStatus", "Logout Success!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
