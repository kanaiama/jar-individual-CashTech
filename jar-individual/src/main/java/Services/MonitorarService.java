/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 *
 * @author kanaiama
 */
public class MonitorarService {
    public void monitorarHardware(Integer idAtm, Integer idEmpresaUsuario) {

        Integer idMemoria = 84;
        Integer idProcessador = 83;
        Integer idRede = 20;
        Integer idSistema = 27;
        List<Integer> idsVolume = new ArrayList<>();
        idsVolume.addAll(List.of(85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101,
                102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122,
                123, 124, 125, 126, 127, 128, 129, 130, 131, 132));

        new Timer().scheduleAtFixedRate(new TimerTask() {
            Long bytesRecebidosAntigo = null;
            Long bytesEnviadosAntigo = null;

            @Override
            public void run() {
                Looca looca = new Looca();
                Sistema sistema = looca.getSistema();
                Memoria memoria = looca.getMemoria();
                Processador processador = looca.getProcessador();
                DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
                List<Volume> volumes = grupoDeDiscos.getVolumes();
                Rede rede = looca.getRede();
                ProcessoGrupo processoGrupo = looca.getGrupoDeProcessos();
                List<Processo> processos = processoGrupo.getProcessos();
                RedeInterfaceGroup redeInterfaceGroup = rede.getGrupoDeInterfaces();
                List<RedeInterface> redeInterfaces = redeInterfaceGroup.getInterfaces();

                ZonedDateTime horarioBrasilia = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
                LocalDateTime dtMetrica = horarioBrasilia.toLocalDateTime();

//                monitorarRepository.enviarSistema(idAtm, sistema, dtMetrica, idSistema);
//
//                monitorarRepository.enviarMetrica(idMemoria, dtMetrica, memoria.getEmUso());
//                monitorarRepository.enviarMetrica(idProcessador, dtMetrica, processador.getUso());

                Volume volumeMonitorado = null;
//            for (Map<String, Object> volume : idsVolume) {
//                Integer idVolume = (Integer) volume.get("id");
//                String pontoMontagemTodo = (String) volume.get("ponto_montagem");
//                String pontoMontagem = pontoMontagemTodo.endsWith("\\") ? pontoMontagemTodo.substring(0, pontoMontagemTodo.lastIndexOf("\\")) : pontoMontagemTodo;
//
//                Optional<Volume> volumeOptional = volumes.stream().filter(v -> v.getPontoDeMontagem().equals(pontoMontagem)).findFirst();
//                volumeMonitorado = volumeOptional.get();
//                monitorarRepository.enviarMetrica(idVolume, dtMetrica, volumeMonitorado.getDisponivel());
//            }

                Optional<RedeInterface> optRedeInterface = redeInterfaces.stream().filter(
                        r -> r.getBytesEnviados() > 0 || r.getBytesRecebidos() > 0).findFirst();

                RedeInterface redeInterface = optRedeInterface.get();

//                Collections.sort(processos, new ComparadorUsoProcesso());

                List<Processo> topVinteProcessos = new ArrayList<>();

                for (int i = 0; i < processos.size(); i++) {
                    if (i < 20) {
                        topVinteProcessos.add(processos.get(i));
                    } else {
                        break;
                    }
                }

//                processosRepository.cadastrarProcessosAgora(idAtm, topVinteProcessos, dtMetrica);
//                monitorarRepository.enviarMetricaRede(idRede,
//                        bytesRecebidosAntigo == null ? 0 : redeInterface.getBytesRecebidos() - bytesRecebidosAntigo,
//                        bytesEnviadosAntigo == null ? 0 : redeInterface.getBytesEnviados() - bytesEnviadosAntigo, dtMetrica);
//
//                verificarMetricas(memoria, processador, volumeMonitorado,
//                        redeInterface, dtMetrica, idEmpresaUsuario);

                bytesRecebidosAntigo = redeInterface.getBytesRecebidos();
                bytesEnviadosAntigo = redeInterface.getBytesEnviados();
            }

        }, 0, 3000);
    }
}
