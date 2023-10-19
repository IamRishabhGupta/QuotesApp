package com.example.quotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)


            setQuote(mainViewModel.getQuote())
            binding.prev.setOnClickListener{prevq()}
        binding.next.setOnClickListener{nextq()}
        binding.floatingActionButton.setOnClickListener{
            onShare()
        }






    }
    fun setQuote(quotes: Quotes)
    {
        binding.quoteText.text=quotes.text
        binding.quoteAuthor.text=quotes.author
    }

    fun prevq()
    {


            setQuote(mainViewModel.prevQuote())


    }

    fun nextq()
    {


        setQuote(mainViewModel.nextQuote())


    }

    fun onShare() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
        startActivity(intent)
    }
}