/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import cashtech.jar.individual.DataBase;
import cashtech.jar.individual.DataBaseDocker;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

/**
 *
 * @author murilo
 */
public class MonitorarRepository {

    DataBase conexao = new DataBase();

    DataBaseDocker conexaoDocker = new DataBaseDocker();

    JdbcTemplate conDock = conexaoDocker.getConnection();
    RedeParametros redeParametros;

    public JdbcTemplate con = conexao.getConnection();

    public void enviarSistema(Integer idAtm, Sistema sistema, LocalDateTime dtMetrica, Integer idSistema) {
        LocalDateTime inicializado = LocalDateTime.ofInstant(sistema.getInicializado(),
                ZoneId.systemDefault());

        String script = "insert into MetricaSistema (iniciado,tempo_atividade,dt_Metrica,sistema_id) values (?,?,?,?)";

        conDock.update(script, inicializado, sistema.getTempoDeAtividade(), dtMetrica,idSistema);
        con.update(script, inicializado, sistema.getTempoDeAtividade(), dtMetrica, idSistema);
    }

    public void enviarMetrica(Integer componenteId, LocalDateTime dtMetrica, Double qtdConsumido) {
        String script = "insert into MetricaComponente (qtd_consumido,dt_metrica,componente_id) values (?,?,?)";

        conDock.update(script, qtdConsumido, dtMetrica, componenteId);

        con.update(script, qtdConsumido, dtMetrica, componenteId);
    }

    public void enviarMetrica(Integer componenteId, LocalDateTime dtMetrica, Long qtdConsumido) {

        String script = "insert into MetricaComponente (qtd_consumido,dt_metrica,componente_id) values (?,?,?)";

        conDock.update(script, qtdConsumido, dtMetrica, componenteId);
        con.update(script, qtdConsumido, dtMetrica, componenteId);
    }

}
