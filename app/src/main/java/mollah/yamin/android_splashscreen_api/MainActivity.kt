package mollah.yamin.android_splashscreen_api

import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import mollah.yamin.android_splashscreen_api.ui.theme.AndroidSplashScreenAPITheme
import java.time.Duration
import java.time.Instant

const val splashFadeDurationMillis = 300
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        super.onCreate(savedInstanceState)
        loadView()
//        val splashWasDisplayed = savedInstanceState != null
//        if (!splashWasDisplayed) {
//            // Handle the splash screen transition.
//            splash.setOnExitAnimationListener { splashScreenViewProvider ->
//                // Get logo and start a fade out animation
//                splashScreenViewProvider.iconView
//                    .animate()
//                    .setDuration(
//                        splashFadeDurationMillis.toLong()
//                    )
//                    .alpha(0f)
//                    .withEndAction {
//                        // After the fade out, remove the
//                        // splash and set content view
//                        splashScreenViewProvider.remove()
//                        loadView()
//                    }.start()
//            }
//        } else {
//            loadView()
//        }


//        // Set up an OnPreDrawListener to the root view.
//        val content: View = findViewById(android.R.id.content)
//        content.viewTreeObserver.addOnPreDrawListener(
//            object : ViewTreeObserver.OnPreDrawListener {
//                override fun onPreDraw(): Boolean {
//                    // Check whether the initial data is ready.
//                    return if (viewModel.isReady) {
//                        // The content is ready. Start drawing.
//                        content.viewTreeObserver.removeOnPreDrawListener(this)
//                        true
//                    } else {
//                        // The content isn't ready. Suspend.
//                        false
//                    }
//                }
//            }
//        )

        // Customize the animation for dismissing the splash screen
        // Add a callback that's called when the splash screen is animating to the
        // app content.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            val splashScreen = splashScreen
//            splashScreen.setOnExitAnimationListener { splashScreenView ->
//                /*// Get the duration of the animated vector drawable.
//                val animationDuration = splashScreenView.iconAnimationDuration
//                // Get the start time of the animation.
//                val animationStart = splashScreenView.iconAnimationStart
//                // Calculate the remaining duration of the animation.
//                val remainingDuration = if (animationDuration != null && animationStart != null) {
//                    (animationDuration - Duration.between(animationStart, Instant.now()))
//                        .toMillis()
//                        .coerceAtLeast(0L)
//                } else {
//                    0L
//                }*/
//                // Create your custom animation.
//                val slideUp = ObjectAnimator.ofFloat(
//                    splashScreenView,
//                    View.TRANSLATION_Y,
//                    0f,
//                    -splashScreenView.height.toFloat()
//                )
//                slideUp.interpolator = AnticipateInterpolator()
//                slideUp.duration = 200L
//
//                // Call SplashScreenView.remove at the end of your custom animation.
//                slideUp.doOnEnd { splashScreenView.remove() }
//
//                // Run your animation.
//                slideUp.start()
//            }
//        }
    }
}

fun ComponentActivity.loadView() {
    this.setContent {
        AndroidSplashScreenAPITheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSplashScreenAPITheme {
        Greeting("Android")
    }
}