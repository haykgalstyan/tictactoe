package galstyan.hayk.tictactoe.domain.usecase

import galstyan.hayk.tictactoe.data.GameRepository
import javax.inject.Inject

class StartGame @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke() {
        gameRepository.startGame()
    }
}