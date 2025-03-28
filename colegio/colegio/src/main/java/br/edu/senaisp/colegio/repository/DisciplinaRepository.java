package br.edu.senaisp.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import br.edu.senaisp.colegio.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

}
