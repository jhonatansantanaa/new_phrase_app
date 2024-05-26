package br.com.prasheapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.prasheapp.infra.MotivationConstants
import br.com.prasheapp.R
import br.com.prasheapp.infra.SecurityPreferences
import br.com.prasheapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bindind: ActivityMainBinding
    private var categoryId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        val view = bindind.root
        setContentView(view)

        handleUserName()

        // Events
        bindind.btnNewPhrase.setOnClickListener(this)
        bindind.icAll.setOnClickListener(this)
        bindind.icSunny.setOnClickListener(this)
        bindind.icHappy.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_new_phrase) {

        } else if(view.id in listOf(R.id.ic_all,
                R.id.ic_sunny, R.id.ic_happy )) {
            handleFilter(view.id)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        bindind.textViewNameUser.text = "Olá, $name!"
    }

    private fun handleFilter(id: Int) {
        bindind.icAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
        bindind.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))
        bindind.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            R.id.ic_all -> {
                bindind.icAll.setColorFilter(ContextCompat.getColor(this, R.color.grey))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.ic_sunny -> {
                bindind.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.grey))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
            R.id.ic_happy -> {
                bindind.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.grey))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
        }
    }
}