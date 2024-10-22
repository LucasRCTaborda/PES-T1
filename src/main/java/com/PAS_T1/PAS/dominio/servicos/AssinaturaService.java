package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl.AplicativoRepositoryImpl;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl.AssinaturaRepositoryImpl;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl.ClienteRepositoryImpl;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AssinaturaService {

    private AssinaturaRepositoryImpl assinaturaRepositoryImpl;
    private AplicativoRepositoryImpl aplicativoRepositoryImpl;
    private ClienteRepositoryImpl clienteRepositoryImpl;
    private RabbitTemplate rabbitTemplate;
    private FanoutExchange fanout;

    @Autowired
    public AssinaturaService(AssinaturaRepositoryImpl assinaturaRepositoryImpl, AplicativoRepositoryImpl aplicativoRepositoryImpl, ClienteRepositoryImpl clienteRepositoryImpl, RabbitTemplate rabbitTemplate , FanoutExchange fanout) {
        this.assinaturaRepositoryImpl = assinaturaRepositoryImpl;
        this.aplicativoRepositoryImpl = aplicativoRepositoryImpl;
        this.clienteRepositoryImpl = clienteRepositoryImpl;
        this.rabbitTemplate = rabbitTemplate;
        this.fanout = fanout;
    }

    public List<AssinaturaModel> getFromAppId(long appId) {
        return this.assinaturaRepositoryImpl.findByAplicativoId(appId);
    }

    public List<AssinaturaModel> getFromClienteId(long clienteId) {
        return this.assinaturaRepositoryImpl.findByClienteId(clienteId);
    }

    public List<AssinaturaModel> getFromType(StatusATIVO type) {
        if (type == StatusATIVO.TODAS) {
            return this.assinaturaRepositoryImpl.findAll();
        } else if (type == StatusATIVO.ATIVO) {
            return this.assinaturaRepositoryImpl.findActiveAssinaturas();
        } else if (type == StatusATIVO.CANCELADO) {
            return this.assinaturaRepositoryImpl.findInactiveAssinaturas();
        }
        return null;
    }

    public AssinaturaModel criaNovaAssinatura(long codCliente, long codAplicativo) {
        ClienteModel cliente = clienteRepositoryImpl.findById(codCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente not found with ID: " + codCliente);
        }

        AplicativoModel aplicativo = aplicativoRepositoryImpl.findById(codAplicativo);

        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo not found with ID: " + codAplicativo);
        }

        long id = assinaturaRepositoryImpl.findLastAssinaturaId() + 1;
        Date now = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(now);

        calendar.add(Calendar.MONTH, 1);

        Date nowInAMonth = calendar.getTime();
        AssinaturaModel nova = new AssinaturaModel(id, aplicativo,cliente, now, nowInAMonth);

        return assinaturaRepositoryImpl.save(nova);
    }

    public AssinaturaModel getFromAssinaturaId(long assinaturaId) {
        return this.assinaturaRepositoryImpl.findById(assinaturaId);
    }

    public void saveAssinatura(AssinaturaModel assinatura){
        AssinaturaDTO assinaturaDto = new AssinaturaDTO(assinatura.getFimVigencia(), assinatura.getId());
        rabbitTemplate.convertAndSend(fanout.getName(),"",assinaturaDto);
        this.assinaturaRepositoryImpl.save(assinatura);
    }

    public class AssinaturaDTO {
        private Date expirationDate;
        private Long idAssinatura;

        AssinaturaDTO(Date expirationDate, Long idAssinatura) {
            this.expirationDate = expirationDate;
            this.idAssinatura = idAssinatura;
        }

        public Date getExpirationDate() {
            return expirationDate;
        }

        public Long getIdAssinatura() {
            return idAssinatura;
        }
    }
}
