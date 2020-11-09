package controller;

import dal.*;
import entity.product.Image;
import entity.product.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet", urlPatterns = "/product-detail")
public class ProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO pdao = new ProductDAO();
        BrandDAO bdao = new BrandDAO();
        TypeDAO tdao = new TypeDAO();
        StatusProductDAO spdao = new StatusProductDAO();
        ImageDAO idao = new ImageDAO();

        //get product detail info
        int id = Integer.parseInt(request.getParameter("id"));
        Product pDetail = pdao.getOneByID(id);
        String pDetailBrand = bdao.getOneByID(pDetail.getBrandID()).getBrand();
        String pDetailType = tdao.getOneByID(pDetail.getTypeID()).getType();
        String pDetailStatus = spdao.getOneByID(pDetail.getStatusID()).getStatus();
        List<Image> pDetailImages = idao.getAllByProductID(pDetail.getId());

        request.setAttribute("pDetail",pDetail);
        request.setAttribute("pDetailBrand",pDetailBrand);
        request.setAttribute("pDetailType",pDetailType);
        request.setAttribute("pDetailStatus",pDetailStatus);
        request.setAttribute("pDetailImages",pDetailImages);

        request.getRequestDispatcher("product-detail.jsp").forward(request,response);

    }
}
