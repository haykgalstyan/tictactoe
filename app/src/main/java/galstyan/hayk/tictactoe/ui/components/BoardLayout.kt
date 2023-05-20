package galstyan.hayk.tictactoe.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import kotlin.math.sqrt

@Composable
fun BoardLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val sideCount = sqrt(measurables.size.toFloat()).let {
            if (it % 1F != 0F) throw IllegalArgumentException("Unsupported child count")
            it.toInt()
        }
        val itemWidth = constraints.maxWidth / sideCount
        val itemHeight = constraints.maxHeight / sideCount
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth,
            minHeight = itemHeight,
            maxHeight = itemHeight,
        )
        val placeables = measurables.map { it.measure(itemConstraints) }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var position = 0
            repeat(sideCount) { i ->
                repeat(sideCount) { j ->
                    placeables[position++].placeRelative(i * itemWidth, j * itemHeight)
                }
            }
        }
    }
}