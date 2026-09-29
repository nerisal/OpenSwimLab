package com.nerisal.openswimlab.ui.settings

import android.content.ClipData
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nerisal.openswimlab.fit.debug.DebugViewModel
import kotlinx.coroutines.launch

@Composable
fun DebugScreen(viewModel: DebugViewModel = viewModel(), onBack: () -> Unit) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboard.current
    val coroutineScope = rememberCoroutineScope()

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let { viewModel.onFitFileSelected(context, it) }
    }

    val dumpByType by viewModel.dumpByType.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    var selectedType by rememberSaveable { mutableStateOf<String?>(null) }

    LaunchedEffect(dumpByType) {
        if (selectedType !in dumpByType.keys) {
            selectedType = dumpByType.keys.minOrNull()
        }
    }

    val currentMessages = selectedType?.let { dumpByType[it] } ?: emptyList()

    SelectionContainer {
        LazyColumn(modifier = Modifier.padding(16.dp)) {

            item {
                Row(modifier = Modifier.padding(vertical = 8.dp)) {
                    TextButton(onClick = onBack) { Text("← Back") }

                    Button(onClick = { filePickerLauncher.launch(arrayOf("*/*")) }) {
                        Text("Select .fit file")
                    }

                    Button(onClick = {
                        val text = currentMessages.joinToString("\n\n") { msg ->
                            msg.fields.joinToString("\n", prefix = "${msg.name}\n") { f ->
                                "    ${f.name} = ${f.displayValue}"
                            }
                        }

                        coroutineScope.launch {
                            clipboardManager.setClipEntry(ClipEntry(ClipData.newPlainText("OSL", text)))

                        }

                    }) {
                        Text("Copy ${selectedType ?: ""}")
                    }
                }

            }


            if (dumpByType.isNotEmpty()) {
                item {
                    FlowRow(modifier = Modifier.padding(vertical = 8.dp)) {
                        dumpByType.keys.sorted().forEach { type ->
                            FilterChip(
                                selected = selectedType == type,
                                onClick = { selectedType = type },
                                label = { Text("$type (${dumpByType[type]?.size ?: 0})") },
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    }
                }


            }

            when {
                isLoading -> item { CircularProgressIndicator() }
                error != null -> item {
                    Text("Error: $error", color = MaterialTheme.colorScheme.error)
                }

                else -> items(currentMessages) { msg ->
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {
                        Text(msg.name, fontFamily = FontFamily.Monospace)
                        msg.fields.forEach { f ->
                            Text(
                                "    ${f.name} = ${f.displayValue}",
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                }
            }
        }
    }
}