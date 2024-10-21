package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AplicativoRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aplicativo")
public class AplicativoController {

    @Autowired
    private AplicativoRepJpa aplicativoRepository;

    @PutMapping("/{id}/atualizacusto")
    public ResponseEntity<String> atualizarCustoMensal(@PathVariable long id, @RequestParam double CustoMensal) {
        // Verifica se o valor do custoMensal é maior que zero
        if (CustoMensal <= 0) {
            return ResponseEntity.badRequest().body("O custo mensal deve ser maior que zero.");
        }

        try {
            // Verifica se o aplicativo existe
            Optional<AplicativoModel> aplicativoOptional = Optional.ofNullable(aplicativoRepository.consultaPorId(id));
            if (!aplicativoOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aplicativo com ID " + id + " não encontrado.");
            }

            // Atualiza o custoMensal do aplicativo
            AplicativoModel aplicativo = aplicativoOptional.get();
            aplicativo.setCustoMensal(CustoMensal);
            aplicativoRepository.save(aplicativo);

            // Retorna sucesso após atualizar o banco
            return ResponseEntity.ok("Custo mensal atualizado com sucesso para o aplicativo de ID " + id);

        } catch (DataAccessException dae) {
            // Exceção relacionada a acesso ao banco de dados
            String errorMsg = "Erro de acesso ao banco de dados ao tentar atualizar o custo mensal para o aplicativo de ID " + id;
            System.err.println(errorMsg);
            dae.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg + ": " + dae.getMessage());

        } catch (IllegalArgumentException iae) {
            // Exceção para argumentos inválidos
            String errorMsg = "Argumento inválido ao tentar atualizar o custo mensal para o aplicativo de ID " + id;
            System.err.println(errorMsg);
            iae.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg + ": " + iae.getMessage());

        } catch (Exception e) {
            // Log de erro genérico
            String errorMsg = "Erro inesperado ao tentar atualizar o custo mensal para o aplicativo de ID " + id;
            System.err.println(errorMsg);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg + ": " + e.getMessage());
        }
    }
}
