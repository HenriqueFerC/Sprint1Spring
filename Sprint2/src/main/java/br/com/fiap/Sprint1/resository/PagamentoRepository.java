package br.com.fiap.Sprint1.resository;

import br.com.fiap.Sprint1.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
