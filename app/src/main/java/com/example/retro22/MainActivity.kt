package com.example.retro22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retro22.ViewModel.BaseViewModel
import com.example.retro22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val mViewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
        mViewModel.liveNumberDescription.observe(this){
            binding.tvContainer.text = it
        }

        binding.btnRnd.setOnClickListener {
            mViewModel.getRandomNumberDescription()
        }

        binding.btnSearch.setOnClickListener {
            val number = binding.etField.text.toString()
            mViewModel.getNumberDescription(number)
        }




    }
}