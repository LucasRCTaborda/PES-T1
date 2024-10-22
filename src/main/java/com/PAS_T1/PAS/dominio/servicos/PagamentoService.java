package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl.PagamentoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private final PagamentoRepositoryImpl pagamentoRepositoryImpl;

    @Autowired
    public PagamentoService(PagamentoRepositoryImpl pagamentoRepositoryImpl) {
        this.pagamentoRepositoryImpl = pagamentoRepositoryImpl;
    }

    public PagamentoModel registrarPagamento(PagamentoModel pagamento) {
        return pagamentoRepositoryImpl.save(pagamento);
    }
}




























/*
    private final IPagamentoRepository iPagamentoRepository;

    public PagamentoService(IPagamentoRepository iPagamentoRepository) {
        this.iPagamentoRepository = iPagamentoRepository;
    }

    public Pagamento save(Pagamento pagamento) {
        return iPagamentoRepository.save(pagamento);
    }

    public void delete(Pagamento pagamento) {
        iPagamentoRepository.delete(pagamento);
    }

    public List<Pagamento> listarPagamentos() {
        return iPagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPagamentoPorId(Long id) {
        return iPagamentoRepository.findById(id);
    }

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        return save(pagamento);
    }

    public Pagamento editarPagamento(Long id, Pagamento pagamentoAtualizado) {
        Optional<Pagamento> optionalPagamento = buscarPagamentoPorId(id);
        if (optionalPagamento.isPresent()) {
            Pagamento pagamentoExistente = optionalPagamento.get();
            // Atualize os campos do pagamentoExistente com os valores de pagamentoAtualizado
            // Exemplo: pagamentoExistente.setValorPago(pagamentoAtualizado.getValorPago());
            return save(pagamentoExistente);
        } else {
            // Lógica de tratamento de erro se o pagamento não for encontrado
            return null;
        }
    }*/
