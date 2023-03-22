package com.example.myunittest.viewModel

import com.example.myunittest.model.CuboidModel

class MainViewModel(private val cuboidModel:CuboidModel) {
    fun getCircumference() = cuboidModel.getCircumReffrence()
    fun getSurfaceArea() = cuboidModel.getSruface()
    fun getVolume() = cuboidModel.getVolume()
    fun save(w: Double, h: Double, l:Double){
        cuboidModel.save(w,l,h)
    }
}