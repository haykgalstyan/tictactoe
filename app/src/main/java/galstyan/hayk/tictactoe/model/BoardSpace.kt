package galstyan.hayk.tictactoe.model

data class BoardSpace(
    private var mark: Mark?
) {
    fun setMark(mark: Mark) {
        require(isEmpty()) { "BoardSpace already marked" }
        this.mark = mark
    }

    fun getMark() = mark

    fun isEmpty() = mark == null
}