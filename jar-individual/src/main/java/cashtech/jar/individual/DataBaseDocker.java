/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cashtech.jar.individual;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author wkjunior
 */
public class DataBaseDocker {
    private String porta = "3306";

    private String servidor = "localhost";

    private String bancoDeDados = "cashtech";

    private String login = "root";

    private String senha = "container";

    private JdbcTemplate connection;

    public DataBaseDocker() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl(String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC",
                servidor, porta, bancoDeDados));

        dataSource.setUsername(login);
        dataSource.setPassword(senha);

        this.connection = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnection() {

        return connection;

    }
}
