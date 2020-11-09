package controller;

import dal.ProductDAO;
import dal.TypeDAO;
import entity.product.Product;
import entity.product.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductFilterTypeServlet", urlPatterns = "/filter-type")
public class ProductFilterTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //filter list by type id
        ProductDAO pdao = new ProductDAO();
        TypeDAO tdao = new TypeDAO();

        int typeID = Integer.parseInt(request.getParameter("id"));

        List<Product> listAllProducts = pdao.getAllByType(typeID);
        int numberOfProducts = listAllProducts.size();
        List<Type> listAllProductTypes = tdao.getAll();

        request.setAttribute("listAllProducts", listAllProducts);
        request.setAttribute("numberOfProducts", numberOfProducts);
        request.setAttribute("listAllProductTypes", listAllProductTypes);

        request.getRequestDispatcher("product.jsp").forward(request,response);

    }
}
