package br.com.prasheapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.prasheapp.infra.MotivationConstants
import br.com.prasheapp.R
import br.com.prasheapp.infra.SecurityPreferences
import br.com.prasheapp.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        verifyUserName()
        binding.btnSave.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save) {
            handleSave()
        }
    }

    private fun handleSave() {
       val name = binding.editTextUser.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

           val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}