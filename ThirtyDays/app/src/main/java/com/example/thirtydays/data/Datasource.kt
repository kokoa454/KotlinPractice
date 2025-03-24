package com.example.thirtydays.data

import com.example.thirtydays.R
import com.example.thirtydays.model.Wellness

class Datasource{
    fun loadWellness(): List<Wellness> {
        return listOf<Wellness>(
            Wellness(R.string.wellness_1, R.string.wellness_1_description),
            Wellness(R.string.wellness_2, R.string.wellness_2_description),
            Wellness(R.string.wellness_3, R.string.wellness_3_description),
            Wellness(R.string.wellness_4, R.string.wellness_4_description),
            Wellness(R.string.wellness_5, R.string.wellness_5_description),
            Wellness(R.string.wellness_6, R.string.wellness_6_description),
            Wellness(R.string.wellness_7, R.string.wellness_7_description),
            Wellness(R.string.wellness_8, R.string.wellness_8_description),
            Wellness(R.string.wellness_9, R.string.wellness_9_description),
            Wellness(R.string.wellness_10, R.string.wellness_10_description),
            Wellness(R.string.wellness_11, R.string.wellness_11_description),
            Wellness(R.string.wellness_12, R.string.wellness_12_description),
            Wellness(R.string.wellness_13, R.string.wellness_13_description),
            Wellness(R.string.wellness_14, R.string.wellness_14_description),
            Wellness(R.string.wellness_15, R.string.wellness_15_description),
            Wellness(R.string.wellness_16, R.string.wellness_16_description),
            Wellness(R.string.wellness_17, R.string.wellness_17_description),
            Wellness(R.string.wellness_18, R.string.wellness_18_description),
            Wellness(R.string.wellness_19, R.string.wellness_19_description),
            Wellness(R.string.wellness_20, R.string.wellness_20_description),
            Wellness(R.string.wellness_21, R.string.wellness_21_description),
            Wellness(R.string.wellness_22, R.string.wellness_22_description),
            Wellness(R.string.wellness_23, R.string.wellness_23_description),
            Wellness(R.string.wellness_24, R.string.wellness_24_description),
            Wellness(R.string.wellness_25, R.string.wellness_25_description),
            Wellness(R.string.wellness_26, R.string.wellness_26_description),
            Wellness(R.string.wellness_27, R.string.wellness_27_description),
            Wellness(R.string.wellness_28, R.string.wellness_28_description),
            Wellness(R.string.wellness_29, R.string.wellness_29_description),
            Wellness(R.string.wellness_30, R.string.wellness_30_description)
        )
    }
}
