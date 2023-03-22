package com.example.myunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myunittest.databinding.ActivityMainBinding
import com.example.myunittest.model.CuboidModel
import com.example.myunittest.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = MainViewModel(CuboidModel())

        with(binding) {
            btnSave.setOnClickListener(this@MainActivity)
            btnCalculateSurfaceArea.setOnClickListener(this@MainActivity)
            btnCalculateCircumference.setOnClickListener(this@MainActivity)
            btnCalculateVolume.setOnClickListener(this@MainActivity)
        }

    }

    override fun onClick(v: View) {
        val length = binding.edtLength.text.toString().trim()
        val width = binding.edtWidth.text.toString().trim()
        val height = binding.edtHeight.text.toString().trim()

        when {
            length.isEmpty() -> binding.edtLength.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> binding.edtLength.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> binding.edtLength.error = "Field ini tidak boleh kosong"

            else -> {
                val valueWidth = width.toDouble()
                val valueLength = width.toDouble()
                val valueHeight = width.toDouble()
                when (v.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        binding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }

            }
        }
    }
    private fun gone() {
        with(binding) {
            btnCalculateVolume.visibility = View.GONE
            btnCalculateCircumference.visibility = View.GONE
            btnCalculateSurfaceArea.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
        }
    }
    private fun visible(){
        with(binding){
            btnCalculateVolume.visibility = View.VISIBLE
            btnCalculateCircumference.visibility = View.VISIBLE
            btnCalculateSurfaceArea.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        }
    }

}