package com.nerisal.openswimlab.fit.debug

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DebugViewModel(
    private val fitDebugParser: FitDebugParser = FitDebugParser()
) : ViewModel() {

    // Create a Map of all detected fields
    private val _dumpByType = MutableStateFlow<Map<String, List<FitDebugMessage>>>(emptyMap())
    val dumpByType: StateFlow<Map<String, List<FitDebugMessage>>> = _dumpByType


    // Indicators
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun onFitFileSelected(context: Context, uri: Uri) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            _error.value = null
            try {
                context.contentResolver.openInputStream(uri)?.use { stream ->
                    val bytes = stream.readBytes()
                    _dumpByType.value = fitDebugParser.dump(bytes.inputStream())
                } ?: run {
                    _error.value = "Impossible to open selected file"
                }
            } catch (e: Exception) {
                _error.value = "Error in parsing: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}