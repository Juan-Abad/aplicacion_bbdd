package com.juan.aplicacion_bbdd.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.juan.aplicacion_bbdd.databinding.ActivityMainBinding
import com.juan.aplicacion_bbdd.ui.viewModel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.viewContainer)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            //Podemos poner nombre a it justo después de "{", por ejemplo, "currentQuote ->"
            binding.tvQuote.text = it?.quote
            binding.tvAuthor.text = it?.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}