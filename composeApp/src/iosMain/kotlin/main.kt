import androidx.compose.ui.window.ComposeUIViewController
import org.habit.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
