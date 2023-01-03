package com.pradeep.prefdatastore.ui.layer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pradeep.prefdatastore.pref.UserPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPref: UserPref
):ViewModel() {

    val userName=userPref.getName().stateIn(
        scope = viewModelScope,
       started = SharingStarted.WhileSubscribed(),
        initialValue = ""
    )

    fun saveData(name:String){
        viewModelScope.launch {
            userPref.saveUser(name)
        }
    }
}