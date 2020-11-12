package dal.customer;

import entity.customer.Account;
import jdbc.DBContext;
import jdbccore.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AccountDAO implements ICustomer<Account> {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    /**
     *
     * @return List of all Accounts in db
     */

    @Override
    public List getAll() {
        String sql = "SELECT * FROM Account";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Account.class);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    /**
     *
     * @param statusID 1: active, 2: deactive
     * @return List of account that validate status_id
     */
    public List getAllByStatusID(int statusID) {
        String sql = "SELECT * FROM Account WHERE status_id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForList(ps, Account.class, statusID);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    /**
     *
     * @param id is account id
     * @return Account with validate id
     */

    @Override
    public Account getOne(int id) {
        String sql = "SELECT * FROM Account WHERE id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, Account.class, id);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public Account getOneByAccount(String account) {
        String sql = "SELECT * FROM Account WHERE account = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, Account.class, account);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    /**
     *
     * @param account
     * @param password
     * @return Account from db validate account and password user input
     */
    public Account getOneByAccountAndPassword(String account, String password) {
        String sql = "SELECT * FROM Account WHERE account = ? and password = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return jdbcTemplate.queryForObject(ps, Account.class, account, password);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Account item) {
        int check = 0;
        String sql = "INSERT INTO Account(role_id, status_id, account, password, email) " +
                "VALUES(?, ?, ?, ?, ?)";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            check = jdbcTemplate.update(
                    ps,
                    item.getRoleID(),
                    item.getStatusID(),
                    item.getAccount(),
                    item.getPassword(),
                    item.getEmail()
            );
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(Account item, int id) {
        int check = 0;
        String sql = "UPDATE Account" +
                " SET role_id = ?, status_id = ?, account = ?, password = ?, email = ? " +
                "WHERE id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            check = jdbcTemplate.update(
                    ps,
                    item.getRoleID(),
                    item.getStatusID(),
                    item.getAccount(),
                    item.getPassword(),
                    item.getEmail(),
                    id
            );
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String sql = "DELETE from Account WHERE id = ?";

        try (Connection con = DBContext.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            check = jdbcTemplate.update(ps, id);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean checkRegister(String username) {
        return false;
    }

    public static void main(String[] args) {
        AccountDAO adao = new AccountDAO();

//        Account a = adao.getOneByAccount("admin");
//        System.out.println(a);

//        List<Account> list = adao.getAll();
//        list.forEach(System.out::println);

//        List<Account> list = adao.getAllByStatusID(2);
//        list.forEach(System.out::println);

//        Account a = adao.getOne(1);
//        System.out.println(a);

//        Account a = adao.getOneByAccountAndPassword("sa", "123456");
//        System.out.println(a);

//        System.out.println(adao.add(new Account(1,2,"admins2","admin2", "admin2@gmail.com")));

//        System.out.println(adao.update(new Account(2,2,"admin23","admin23", "admin23@gmail.com"),5));
//        System.out.println(adao.delete(4));
    }
}
