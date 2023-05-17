package galstyan.hayk.tictactoe.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import galstyan.hayk.tictactoe.ui.components.BoardLayout
import galstyan.hayk.tictactoe.ui.theme.AppTheme


@Composable
fun GameBoard(
    modifier: Modifier = Modifier,
) {
    BoardLayout(modifier = modifier.aspectRatio(1F)) {
        repeat(9) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray,
                border = BorderStroke(1.dp, Color.Gray),
            ) {
                Text(
                    text = "Box $it",
                    color = Color.Blue,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
@Preview
fun BoardPreview() {
    AppTheme {
        GameBoard(
            Modifier
                .width(300.dp)
                .height(300.dp)
        )
    }
}