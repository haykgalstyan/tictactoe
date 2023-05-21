package galstyan.hayk.tictactoe.domain.model

data class BoardSpace(
    private var mark: Mark? = null
) {
    fun setMark(mark: Mark) {
        require(isEmpty()) { "BoardSpace already marked" }
        this.mark = mark
    }

    fun getMark() = mark

    fun isEmpty() = mark == null
}