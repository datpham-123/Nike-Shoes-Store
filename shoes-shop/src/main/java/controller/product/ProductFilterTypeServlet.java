package controller.product;

import dal.product.ProductDAO;
import dal.product.TypeDAO;
import entity.product.Product;
import entity.product.Type;
import util.PagiSettings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductFilterTypeServlet", urlPatterns = "/filter-type")
public class ProductFilterTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //0. Class Helper
        ProductDAO pdao = new ProductDAO();
        TypeDAO tdao = new TypeDAO();
        PagiSettings pagiSet = new PagiSettings();

        //1.Pagination

        //1.1. get page number
        String pageStr = request.getParameter("page");
        int page = 1;

        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        //1.1.1. Get search String from form
        int typeID = Integer.parseInt(request.getParameter("id"));

        //1.2. Pagination settings (for TypeID Products only)
        pagiSet.paginationByTypeID(typeID);

        int totalProduct = pagiSet.getTotalProduct();
        int numberProduct = pagiSet.getNumberProduct();
        int totalPage = pagiSet.getTotalPage();

        //1.3. Create list-page-index and list-products-per-page
        List<Integer> listPage = new ArrayList<>();
        List<Product> listProduct;

        //1.4. Set value for list-page-index and list-products-perpage
        for (int i = 1; i <= totalPage; ++i) {
            listPage.add(i);
        }

        listProduct = pdao.getProductPerPageByTypeID((page * numberProduct) - numberProduct, numberProduct, typeID);

        //1.5. init and set value for list contain all product types
        List<Type> listProductType = tdao.getAll();

        //2. Set attribute and push to product.jsp

        request.setAttribute("pageMode", 3);
        request.setAttribute("typeID", typeID);
        request.setAttribute("page", page);
        request.setAttribute("listPage", listPage);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("listProductType", listProductType);

        request.getRequestDispatcher("product.jsp").forward(request, response);

    }
}
