package components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title : String,
    onBackClick : () -> Unit
) {

    Row(
        modifier = modifier
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Button"
            )
        }
        Text(text = title, style = TextStyle(
            fontSize = 12.sp,
            color = Color.Black
        ))
    }
}
