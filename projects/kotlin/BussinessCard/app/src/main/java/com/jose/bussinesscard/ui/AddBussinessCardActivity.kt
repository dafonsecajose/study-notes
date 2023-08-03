package com.jose.bussinesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.jose.bussinesscard.App
import com.jose.bussinesscard.R
import com.jose.bussinesscard.data.BussinessCard
import com.jose.bussinesscard.databinding.ActivityAddBussinessCardBinding

class AddBussinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBussinessCardBinding.inflate(layoutInflater)}
    private lateinit var mColor: String

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener { finish() }

        binding.tilCor.editText?.setOnClickListener {

            ColorPickerDialog
                .Builder(this)
                .setTitle(R.string.label_choose_color)
                .setColorShape(ColorShape.CIRCLE)
                .setDefaultColor("#FFFFFF")
                .setColorListener { color, colorHex ->
                    binding.tilCor.editText?.setText(colorHex)
                }
                .show()
        }

        binding.btnConfirm.setOnClickListener {
            val bussinessCard = BussinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersinalizado = binding.tilCor.editText?.text.toString(),
            )

            mainViewModel.insert(bussinessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}