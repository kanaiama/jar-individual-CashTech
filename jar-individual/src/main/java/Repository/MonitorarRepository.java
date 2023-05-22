/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import com.github.britooo.looca.api.group.rede.RedeParametros;
import org.springframework.jdbc.core.JdbcTemplate;
import cashtech.jar.individual.DataBaseDocker;


/**
 *
 * @author kanaiama
 */
public class MonitorarRepository {
    DataBaseDocker conexaoDocker = new DataBaseDocker();
    JdbcTemplate conDock = conexaoDocker.getConnection();
    RedeParametros redeParametros;
}
