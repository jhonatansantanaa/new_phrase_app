package br.com.prasheapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.prasheapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bindind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        val view = bindind.root
        setContentView(view)

        handleUserName()

        bindind.btnNewPhrase.setOnClickListener {

        }

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_new_phrase) {
          var s = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        bindind.textViewNameUser.text = "Olá, $name!"
    }
}