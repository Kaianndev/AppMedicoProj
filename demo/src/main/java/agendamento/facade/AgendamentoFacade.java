package agendamento.facade;

import agendamento.model.Agendamento;
import agendamento.repository.AgendamentoRepository;
import agendamento.strategy.EstrategiaAgendamento;

import java.util.List;

public class AgendamentoFacade {
    private AgendamentoRepository repository;
    private EstrategiaAgendamento estrategia;

    public AgendamentoFacade(AgendamentoRepository repository, EstrategiaAgendamento estrategia) {
        this.repository = repository;
        this.estrategia = estrategia;
    }

    public void agendarConsulta(String paciente, String data) {
        Agendamento novoAgendamento = new Agendamento(paciente, data);
        estrategia.agendar(repository.listarAgendamentos(), novoAgendamento);
        repository.adicionarAgendamento(novoAgendamento);
    }

    public List<Agendamento> listarAgendamentos() {
        return repository.listarAgendamentos();
    }
}
