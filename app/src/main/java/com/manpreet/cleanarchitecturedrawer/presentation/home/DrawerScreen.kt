package com.manpreet.cleanarchitecturedrawer.presentation.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DrawerScreen(userName: String = "John Doe") {
    val scaffoldState = rememberScaffoldState() // manages drawer and snackbar
    val scope = rememberCoroutineScope()        // to launch coroutines safely

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

                Text("Welcome, $userName", style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.height(16.dp))
                Divider()

                // Flow item with click event
                DrawerItem("Flow") {
                    scope.launch {
                        scaffoldState.drawerState.close()
                        scaffoldState.snackbarHostState.showSnackbar("You clicked on Flow")
                    }
                }

                DrawerItem("StateFlow")
                DrawerItem("SharedFlow")
                DrawerItem("LaunchedEffect")
                DrawerItem("SideEffect")
                DrawerItem("DisposableEffect")
            }
        },
        snackbarHost = { SnackbarHost(scaffoldState.snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Home Screen with Drawer")
        }
    }
}

// DrawerItem with optional click lambda
@Composable
fun DrawerItem(title: String, onClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = 12.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.body1)
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerScreenPreview() {
    DrawerScreen("Preview User")
}



