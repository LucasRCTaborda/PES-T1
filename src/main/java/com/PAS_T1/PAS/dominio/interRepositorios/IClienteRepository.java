package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.ClienteModel;

import java.util.List;

public interface IClienteRepository {
    List<ClienteModel> findByNome(String nome);
    ClienteModel findByEmail(String email);
    List<ClienteModel> findAll();
    ClienteModel findById(long id);
}
