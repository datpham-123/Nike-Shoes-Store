package dal;

import entity.product.Image;
import jdbc.DBContext;
import jdbccore.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;



public class ImageDAO {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    /**
     *
     * @param id Product id
     * @return All images of Product
     */
    public List<Image> getAllByProductID(int id) {
        String sql = "SELECT * FROM Image WHERE product_id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Image.class, id);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

//    public static void main(String[] args) {
//        ImageDAO idao = new ImageDAO();
//
//        List<Image> list = idao.getAllByProductID(1);
//        list.forEach(image -> System.out.println(image.getImage()));
//    }
}
