package galstyan.hayk.tictactoe.domain.usecase

import galstyan.hayk.tictactoe.data.GameRepository
import javax.inject.Inject

class GetCompletion @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke() = gameRepository.getGameCompletion()
}