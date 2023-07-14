
package com.Torneo.TorneoDeLatas.Repositorio;

import com.Torneo.TorneoDeLatas.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String>{
    
    @Query("SELECT u From Usuario u Where u.dni=:dni")
    public Usuario buscarpordni(@Param("dni")Integer dni);
}
