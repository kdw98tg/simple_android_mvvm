package com.example.mvvmstructure

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvvmstructure.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var _binding: ActivityMainBinding
    private val _viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        init()
    }

    private fun init()
    {
        initObserve()
        initEvents()
    }

    private fun initEvents()
    {
        initButtonPlusEvent()
        initButtonMinusEvent()
    }

    private fun initObserve()
    {
        _viewModel.count.observe(this) { count ->
            _binding.textViewNumber.text = count.toString()
        }
    }

    private fun initButtonPlusEvent()
    {
        _binding.buttonMinus.setOnClickListener {
            _viewModel.subCount()
        }
    }

    private fun initButtonMinusEvent()
    {
        _binding.buttonPlus.setOnClickListener {
            _viewModel.addCount()
        }
    }
}