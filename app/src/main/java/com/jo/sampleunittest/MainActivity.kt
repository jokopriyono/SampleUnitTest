package com.jo.sampleunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        btn_save.setOnClickListener(this)
        btn_calculate_circumference.setOnClickListener(this)
        btn_calculate_surface_area.setOnClickListener(this)
        btn_calculate_volume.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val l = edt_length.text.toString().trim()
        val w = edt_width.text.toString().trim()
        val h = edt_height.text.toString().trim()

        when {
            l.isEmpty() -> edt_length.error = "Field ini tidak boleh kosong"
            w.isEmpty() -> edt_width.error = "Field ini tidak boleh kosong"
            h.isEmpty() -> edt_height.error = "Field ini tidak boleh kosong"

            else -> {
                val len = l.toDouble()
                val wid = w.toDouble()
                val hei = h.toDouble()

                when {
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(len, wid, hei)
                        toggleVisible(true)
                    }
                    v.id == R.id.btn_calculate_circumference -> {
                        txt_result.text = mainViewModel.getCircumference().toString()
                        toggleVisible(false)
                    }
                    v.id == R.id.btn_calculate_surface_area -> {
                        txt_result.text = mainViewModel.getSurfaceArea().toString()
                        toggleVisible(false)
                    }
                    v.id == R.id.btn_calculate_volume -> {
                        txt_result.text = mainViewModel.getVolume().toString()
                        toggleVisible(false)
                    }
                }
            }
        }
    }

    fun toggleVisible(save: Boolean) = if (save) {
        btn_save.visibility = GONE
        linear_buttons.visibility = VISIBLE
    } else {
        btn_save.visibility = VISIBLE
        linear_buttons.visibility = GONE
    }
}
