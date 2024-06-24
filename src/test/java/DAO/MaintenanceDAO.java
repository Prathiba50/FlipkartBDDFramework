package DAO;

import org.springframework.jdbc.core.JdbcTemplate;

public class MaintenanceDAO {
    public JdbcTemplate jdbcTemplate;

    public MaintenanceDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
