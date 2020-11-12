package controller.customer;

import dal.customer.AccountDAO;
import entity.customer.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerRegisterServlet", urlPatterns = "/register")
public class CustomerRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO adao = new AccountDAO();

        //get info from register.jsp
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        //role: user, status: active
        final int roleID = 2;
        final int statusID = 1;

        //validate info
        if (adao.getOneByAccount(username) == null) {
            if (password1.equals(password2)) {
                //add account to db
                adao.add(new Account(roleID, statusID, username, password1, email));
                request.setAttribute("accountRegistered", "Account registered!");
            } else {
                request.setAttribute("accountRegistered", "password must match!");
            }
        } else {
            request.setAttribute("accountRegistered", "username existed!");
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
