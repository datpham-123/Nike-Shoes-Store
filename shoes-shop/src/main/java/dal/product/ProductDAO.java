package dal.product;

import entity.product.Product;
import jdbc.DBContext;
import jdbccore.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;


public class ProductDAO implements IProduct<Product> {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    /**
     * @return List of All products in database
     */
    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM Product";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Product.class);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * @param typeID is id of type. Ex: 1-Running, 2-football, 3-lifestyle,...
     * @return List products with validate type
     */
    public List<Product> getAllByType(int typeID) {
        String sql = "SELECT * FROM Product WHERE type_id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Product.class, typeID);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * @param text is user input String
     * @return List of products that validate user input
     */

    public List<Product> getAllBySearch(String text) {
        String sql = "SELECT * FROM Product WHERE name LIKE ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Product.class, "%" + text + "%");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }


    //-----------------START PAGINATION-----------------

    /**
     *
     * @param pageIndex
     * @param numberProduct
     * @return get List products per page
     */
    public List<Product> getProductPerPage(int pageIndex, int numberProduct) {

        String sql = "SELECT * FROM product" +
                " ORDER BY id" +
                " OFFSET ? ROWS FETCH NEXT ? ROW ONLY";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Product.class, pageIndex, numberProduct);

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<Product> getProductPerPageBySearch(int pageIndex, int numberProduct, String txtSearch) {

        String sql = "SELECT * FROM product " +
                "WHERE name like ?" +
                " ORDER BY id " +
                "OFFSET ? ROWS FETCH NEXT ? ROW ONLY";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Product.class, "%" + txtSearch + "%", pageIndex, numberProduct);

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<Product> getProductPerPageByTypeID(int pageIndex, int numberProduct, int typeID) {

        String sql = "SELECT * FROM product " +
                "WHERE type_id = ?" +
                " ORDER BY id " +
                "OFFSET ? ROWS FETCH NEXT ? ROW ONLY";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Product.class, typeID, pageIndex, numberProduct);

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    // --------------- END PAGINATION ----------------------

    /**
     * @param id is id of Product
     * @return Product with validate id
     */

    @Override
    public Product getOneByID(int id) {
        String sql = "SELECT * FROM Product WHERE id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, Product.class, id);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * @param item is product to add to database
     * @return check > 0 if add success
     */
    @Override
    public boolean add(Product item) {
        int check = 0;
        String sql = "INSERT INTO Product(brand_id, type_id, status_id, name, image, description, price, quantity) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            check = jdbcTemplate.update(
                    ps,
                    item.getBrandID(),
                    item.getTypeID(),
                    item.getStatusID(),
                    item.getName(),
                    item.getImage(),
                    item.getDescription(),
                    item.getPrice(),
                    item.getQuantity()
            );
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    /**
     * @param item is Product to modify
     * @param id   id of Product to modify
     * @return check > 0 if modify success
     */

    @Override
    public boolean update(Product item, int id) {
        int check = 0;
        String sql = "UPDATE Product" +
                " SET brand_id= ?, type_id = ?, status_id = ?, name = ?, image = ?, description = ?, price = ?, quantity = ? " +
                "WHERE id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            check = jdbcTemplate.update(
                    ps,
                    item.getBrandID(),
                    item.getTypeID(),
                    item.getStatusID(),
                    item.getName(),
                    item.getImage(),
                    item.getDescription(),
                    item.getPrice(),
                    item.getQuantity(),
                    id
            );
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    /**
     * @param id Product id to delete
     * @return check > 0 if delete success
     */

    @Override
    public boolean delete(int id) {
        int check = 0;
        String sql = "DELETE from Product WHERE id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            check = jdbcTemplate.update(ps, id);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }


//    public static void main(String[] args) {
//        ProductDAO pdao = new ProductDAO();
//
//        //------------------------------
////        List<Product> list = pdao.getProductPerPageByTypeID(0,12,3);
////        list.forEach(System.out::println);
//
//        //------------------------------
//
////
////        List<Product> subList = pdao.pagination(12, 12);
////        subList.forEach(System.out::println);
//
////        List<Product> list = pdao.getAll();
////        list.forEach(System.out::println);
//
////        List<Product> listByType = pdao.getAllByType(2);
////        listByType.forEach(System.out::println);
//
////        List<Product> listSearch = pdao.getAllBySearch("react");
////        listSearch.forEach(System.out::println);
//
////        Product p = pdao.getOneByID(26);
////        System.out.println(p);
//
////        Product pAdd = new Product(1, 3, 1, "Nike add test1", "no-image", "supergood1", 200, 3);
////        System.out.println(pdao.add(pAdd));
//
////        Product pUpdate = new Product(1, 3, 2, "Nike add update1", "no-image", "supergood1", 250, 4);
////        System.out.println(pdao.update(pUpdate, 53));
//
////        System.out.println(pdao.delete(53));
//    }
}
