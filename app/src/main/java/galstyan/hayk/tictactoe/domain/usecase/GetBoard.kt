package galstyan.hayk.tictactoe.domain.usecase

import galstyan.hayk.tictactoe.data.GameRepository
import javax.inject.Inject

class GetBoard @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke() = gameRepository.getBoard()
}