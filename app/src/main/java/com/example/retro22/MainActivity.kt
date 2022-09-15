package com.example.retro22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retro22.ViewModel.BaseViewModel
import com.example.retro22.databinding.ActivityMainBinding
import com.example.retro22.model.Numb

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HistoryAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        adapter = HistoryAdapter()
        recycler = binding.historyRecycler
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)



        val mViewModel = ViewModelProvider(this).get(BaseViewModel::class.java)

        mViewModel.liveNumberDescription.observe(this){
            binding.tvContainer.text = it
        }

        mViewModel.liveHistoryList.observe(this){
            it.let { adapter.setList(it) }
        }

        binding.btnRnd.setOnClickListener {
            mViewModel.getRandomNumberDescription()
            val result = mViewModel.liveNumberDescription.value
            val numbToAdd = Numb(0, binding.etField.text.toString(), result?: "Ola")
            mViewModel.addNumberToHistory(numbToAdd)
        }

        binding.btnSearch.setOnClickListener {
            val number = binding.etField.text.toString()
            mViewModel.getNumberDescription(number)
            val result = mViewModel.liveNumberDescription.value

        }

        binding.btnAdd.setOnClickListener {
            val number = binding.etField.text.toString()
            val numbToAdd = Numb(0, number, "Hello world")
            mViewModel.addNumberToHistory(numbToAdd)
        }
    }
}