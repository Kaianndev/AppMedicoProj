package agendamento.strategy;

import agendamento.model.Agendamento;

import java.util.List;

public interface EstrategiaAgendamento {
    void agendar(List<Agendamento> agendamentos, Agendamento novoAgendamento);
}

