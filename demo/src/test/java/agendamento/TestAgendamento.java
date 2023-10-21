package agendamento;

import agendamento.facade.AgendamentoFacade;
import agendamento.repository.AgendamentoRepository;
import agendamento.strategy.EstrategiaDataDisponivel;
import agendamento.strategy.EstrategiaAgendamento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAgendamento {
    @Test
    public void testAgendarConsulta() {
        AgendamentoRepository repository = new AgendamentoRepository();
        EstrategiaAgendamento estrategia = new EstrategiaDataDisponivel();
        AgendamentoFacade facade = new AgendamentoFacade(repository, estrategia);

        facade.agendarConsulta("Paciente 1", "2023-10-30");
        facade.agendarConsulta("Paciente 2", "2023-10-31");

        assertEquals(2, repository.listarAgendamentos().size());
    }
}
