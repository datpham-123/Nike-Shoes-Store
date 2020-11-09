package dal;

import entity.product.Type;
import jdbc.DBContext;
import jdbccore.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TypeDAO implements IDAO {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    /**
     * @return List of All type in database
     */
    @Override
    public List<Type> getAll() {
        String sql = "SELECT * FROM Type";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Type.class);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Type getOneByID(int id) {
        String sql = "SELECT * FROM Type WHERE id = ?";
        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, Type.class,id);
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
        TypeDAO tdao = new TypeDAO();
//        List<Type> list = tdao.getAll();
//        list.forEach(System.out::println);
//        Type typeName = tdao.getOneByID(3);
//        System.out.println(typeName.getType());
    }
}
