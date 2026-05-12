package pe.edu.vallegrande.games_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.vallegrande.games_backend.model.Game;
import pe.edu.vallegrande.games_backend.repository.GameRepository;

@Service
@Transactional(readOnly = true)
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Transactional(readOnly = false)
    public Game updateGame(Integer id, Game gameDetails) {
        return gameRepository.findById(id).map(game -> {
            game.setTitle(gameDetails.getTitle());
            game.setGenre(gameDetails.getGenre());
            game.setReleaseDate(gameDetails.getReleaseDate());
            game.setPrice(gameDetails.getPrice());
            return gameRepository.save(game);
        }).orElseThrow(() -> new RuntimeException("Game not found with id: " + id));
    }

    @Transactional(readOnly = false)
    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
}
