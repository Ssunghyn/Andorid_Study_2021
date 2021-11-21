package com.example.bogosort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.bogosort.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val model: BongGoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = model

        model.numberList.observe(this, Observer {
            binding.number1.text = it[0].toString()
            binding.number2.text = it[1].toString()
            binding.number3.text = it[2].toString()
            binding.number4.text = it[3].toString()
            binding.number5.text = it[4].toString()
            binding.number6.text = it[5].toString()
            binding.number7.text= it[6].toString()
        })

        model.time.observe(this, Observer {
            binding.min.text = R.string.minute.toString()
            binding.sec.text = R.string.second.toString()
        })
    }


}