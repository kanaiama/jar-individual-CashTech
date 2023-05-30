package Componentes;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.util.List;

public class Maquina {
    Looca looca = new Looca();
    Sistema sistema = looca.getSistema();
    Memoria memoria = looca.getMemoria();
    Processador processador = looca.getProcessador();
    DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
    Rede rede = looca.getRede();
    ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();
    RedeParametros parametros = rede.getParametros();
    RedeInterfaceGroup redeInterfaceGroup = rede.getGrupoDeInterfaces();
    List<RedeInterface> redeInterfaces = redeInterfaceGroup.getInterfaces();

}
