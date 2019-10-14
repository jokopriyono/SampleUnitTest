package com.jo.sampleunittest

class MainViewModel (val cuboidModel: CuboidModel) {

    fun save(length: Double, width: Double, height: Double) {
        cuboidModel.save(width, length, height)
    }

    fun getCircumference() = cuboidModel.circumference

    fun getSurfaceArea() = cuboidModel.surfaceArea

    fun getVolume() = cuboidModel.volume
}