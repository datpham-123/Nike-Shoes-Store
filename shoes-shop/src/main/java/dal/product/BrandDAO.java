package dal.product;

import entity.product.Brand;
import jdbc.DBContext;
import jdbccore.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class BrandDAO implements IProduct {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List getAll() {
        String sql = "SELECT * FROM Brand";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Brand.class);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Brand getOneByID(int id) {
        String sql = "SELECT * FROM Brand WHERE id = ?";
        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, Brand.class,id);
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

//    public static void main(String[] args) {
//        BrandDAO bdao = new BrandDAO();
//
//        List<Brand> list = bdao.getAll();
//        list.forEach(System.out::println);
//
//        Brand brand = bdao.getOneByID(1);
//        System.out.println(brand.getBrand());
//    }
}
