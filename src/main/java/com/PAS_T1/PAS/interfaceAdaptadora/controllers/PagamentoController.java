package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;
import com.PAS_T1.PAS.dominio.servicos.AssinaturaService;
import com.PAS_T1.PAS.dominio.servicos.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;
    private final AssinaturaService assinaturaService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService, AssinaturaService assinaturaService) {
        this.pagamentoService = pagamentoService;
        this.assinaturaService = assinaturaService;
    }

    public static class PagamentoRequest {
        private String dia;
        private String mes;
        private String ano;
        private Double valorPago;
        private Long codass;

        public String getDia() {
            return dia;
        }

        public String getMes() {
            return mes;
        }

        public String getAno() {
            return ano;
        }

        public Double getValorPago() {
            return valorPago;
        }

        public Long getCodass() {
            return codass;
        }
    }

    @PostMapping("/pagamento")
    public ResponseEntity<Resposta> registrarPagamento(@RequestBody PagamentoRequest request) {
        String dia = request.getDia();
        String mes = request.getMes();
        String ano = request.getAno();
        Double valorPago = request.getValorPago();
        Long codass = request.getCodass();

        AssinaturaModel assinatura = assinaturaService.getFromAssinaturaId(codass);
        double custoMensal = assinatura.getAplicativo().getCustoMensal();
        Resposta resposta = new Resposta();
        Date date = new Date(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
        String promocao = "some promotion";
        if (valorPago >= custoMensal) {
            PagamentoModel pagamento = new PagamentoModel(1, assinatura, valorPago, date, promocao);
            resposta.status = "PAGAMENTO_OK";
            resposta.valorEstornado = 0.0;
            resposta.data = date;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            Date nowInAMonth = calendar.getTime();

            assinatura.setFimVigencia(nowInAMonth);
            assinaturaService.saveAssinatura(assinatura);

        } else {
            resposta.status = "VALOR_INCORRETO";
            resposta.valorEstornado = custoMensal - valorPago;
            resposta.data = date;
        }
        return ResponseEntity.ok(resposta);
    }

    public static class Resposta {
        public String status;
        public Date data;
        public double valorEstornado;
    }
}