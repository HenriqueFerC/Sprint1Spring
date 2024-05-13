package br.com.fiap.Sprint1.resository;

import br.com.fiap.Sprint1.model.Chatbot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotRepository extends JpaRepository<Chatbot, Long> {
}
