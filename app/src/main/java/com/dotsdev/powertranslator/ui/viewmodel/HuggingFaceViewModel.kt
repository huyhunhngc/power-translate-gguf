package com.dotsdev.powertranslator.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dotsdev.powertranslator.data.model.HuggingFaceModel
import com.dotsdev.powertranslator.data.repository.HuggingFaceRepository
import kotlinx.coroutines.flow.Flow

class HuggingFaceViewModel : ViewModel() {
    private val repository = HuggingFaceRepository()
    
    val modelsFlow: Flow<PagingData<HuggingFaceModel>> = repository.getModels()
        .cachedIn(viewModelScope)
}
