package galstyan.hayk.tictactoe.domain.usecase

import galstyan.hayk.tictactoe.data.GameRepository
import galstyan.hayk.tictactoe.domain.model.BoardPosition
import javax.inject.Inject

class PutMark @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(position: BoardPosition) {
        gameRepository.putMark(position)
    }
}