package galstyan.hayk.tictactoe.ui.components.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import galstyan.hayk.tictactoe.ui.theme.AppTheme

@Composable
fun BoardSpace(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        color = Color.LightGray,
        border = BorderStroke(1.dp, Color.Gray),
    ) {
        Box(
            modifier = modifier.background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
@Preview
fun BoardSpacePreview() {
    AppTheme {
        BoardSpace(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}
