package br.com.fiap.Sprint1.resository;

import br.com.fiap.Sprint1.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
