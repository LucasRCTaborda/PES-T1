package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;

import java.util.List;

public interface IUsuarioRepository  {
    List<UsuarioModel> todos();
    UsuarioModel consultaPorId(long codigo);
}
