package com.example.samplegetretrofitwithmvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplegetretrofitwithmvvm.module.ModuleRetro
import com.example.samplegetretrofitwithmvvm.repository.RepositoryData
import kotlinx.coroutines.launch
import retrofit2.Response

// Implement Repository
class MainView(private val repositoryData: RepositoryData): ViewModel()
{
    // Implement Life-Cycle MVVM
    var multiJSON: MutableLiveData<Response<List<ModuleRetro>>> = MutableLiveData()

    // Implement Repository Method
    fun multiData(auth: String, token: String, userId: Int, options: Map<String, String>)
    {
        // Call View Model
        viewModelScope.launch {
            val multiResponse = repositoryData.multiData(auth, token, userId, options)
            // Add Life-Cycle
            multiJSON.value = multiResponse
        }
    }
}