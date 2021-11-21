package com.example.bogosort

import android.app.Application
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext

class BongGoViewModel(application: Application) : AndroidViewModel(application) {
    val model = Model()
    var numberList : MutableLiveData<ArrayList<Int>> = MutableLiveData()
    var time : MutableLiveData<Int> = MutableLiveData()
    init {
        numberList.value = model.reset()
        time.value = 0
    }

    fun isFinish(): Boolean{
        var ans = 0
        for (i in numberList.value!!){
            if (i != ans)
                return false
            ans++
        }
        return true
    }

    suspend fun play(){
        CoroutineScope(Dispatchers.IO
                + CoroutineName("Play")
                + SupervisorJob()
                + CoroutineExceptionHandler { coroutineContext, throwable ->  }).launch {

                CoroutineScope(
                    Dispatchers.IO
                            + CoroutineName("Timer")
                ).launch {
                    time.value = time.value?.plus(1)
                    delay(1000)
                }
                for (i in 0..6) {
                    var shuffleNum = Random().nextInt(7) + 1
                    while (numberList.value!!.contains(shuffleNum)){
                        shuffleNum = Random().nextInt(7) + 1
                    }
                    numberList.value!![i]=shuffleNum

                }
                delay(1000L)
            }

            if (isFinish()){
                yield()
            }
    }
}