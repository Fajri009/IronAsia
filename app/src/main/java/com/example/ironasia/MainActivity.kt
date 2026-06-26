package com.example.ironasia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import com.example.ironasia.data.datastore.SessionManager
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = PrimaryColor.toArgb()
            )
        )

        setContent {
            val isLogin by sessionManager
                .isLogin
                .collectAsState(initial = false)

            IronAsiaNavGraph(
                startDestination =
                    if (isLogin)
                        IronAsiaRoutes.Home.route
                    else
                        IronAsiaRoutes.Login.route
            )
        }
    }
}