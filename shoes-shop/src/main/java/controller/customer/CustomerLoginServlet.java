package controller.customer;

import dal.customer.AccountDAO;
import entity.customer.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CustomerLoginServlet", urlPatterns = "/login")
public class CustomerLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO adao = new AccountDAO();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account accountLogin = adao.getOneByAccountAndPassword(username, password);

        if (accountLogin != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("accountLogin", accountLogin);
            request.setAttribute("loginStatus", "Login Success!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("loginStatus", "Login Fail!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
