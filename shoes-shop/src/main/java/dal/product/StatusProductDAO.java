package dal.product;

import entity.product.StatusProduct;
import jdbc.DBContext;
import jdbccore.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class StatusProductDAO implements IProduct {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List getAll() {
        String sql = "SELECT * FROM Status_Product";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, StatusProduct.class);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public StatusProduct getOneByID(int id) {
        String sql = "SELECT * FROM Status_Product WHERE id = ?";
        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, StatusProduct.class,id);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Object item) {
        return false;
    }

    @Override
    public boolean update(Object item, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public static void main(String[] args) {
        StatusProductDAO spdao = new StatusProductDAO();

//        List<StatusProduct> list = spdao.getAll();
//        list.forEach(System.out::println);
        StatusProduct statusProduct = spdao.getOneByID(4);
        System.out.println(statusProduct.getStatus());
    }
}
