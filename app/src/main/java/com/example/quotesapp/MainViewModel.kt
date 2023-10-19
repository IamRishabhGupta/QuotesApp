package com.example.quotesapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context:Context):ViewModel() {

    private var quotesList:Array<Quotes> =emptyArray()
    private var counter=0


    init {
        quotesList=loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quotes> {



val inputStream=context.assets.open("quotes.json")
        val size=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer,Charsets.UTF_8)
        val gson=Gson()
        return gson.fromJson(json,Array<Quotes>::class.java)

//yeh jo loadquotes hai isko chaiye context ab isko yeh kaha se milega ?isko yeh pass krna padega kisi tarike se ab
        //yeh paas kaise karenge yeh hga viewmodelfactory ki help se so we did that standrad stuff in code to pass context in view model factory
        //basically viewmodel me var context paas kr diya aur sath me viewmodel factory me paas kr diya
    }

  fun getQuote()=quotesList[counter]
    fun nextQuote()=quotesList[++counter]
    fun prevQuote()=quotesList[--counter]




}