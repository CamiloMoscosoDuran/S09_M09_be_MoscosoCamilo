package pe.edu.vallegrande.games_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.vallegrande.games_backend.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
