package com.example.myunittest.viewModel

import com.example.myunittest.model.CuboidModel

class MainViewModel(private val cuboidModel:CuboidModel) {
    fun getCircumference() = cuboidModel.getCircumReffrence()
    fun getSurfaceArea() = cuboidModel.getSruface()
    fun getVolume() = cuboidModel.getVolume()
    fun save(l: Double, w: Double, h:Double){
        cuboidModel.save(l,w,h)
    }
}