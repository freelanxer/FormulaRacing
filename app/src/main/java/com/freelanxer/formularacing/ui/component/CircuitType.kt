package com.freelanxer.formularacing.ui.component

import com.freelanxer.formularacing.R

sealed class CircuitType(
    val countryCode: String,
    val circuitKey: Int,
    val iconResId: Int,
    val backgroundResId: Int,
) {
    data object UAE_70 : CircuitType(countryCode = "UAE", circuitKey = 70, iconResId = R.drawable.ic_circuit_uae_70, backgroundResId = R.drawable.bg_uae_70)
    data object QAT_150 : CircuitType(countryCode = "QAT", circuitKey = 150, iconResId = R.drawable.ic_circuit_qat_150, backgroundResId = R.drawable.bg_qat_150)
    data object USA_9 : CircuitType(countryCode = "USA", circuitKey = 9, iconResId = R.drawable.ic_circuit_usa_9, backgroundResId = R.drawable.bg_usa_9)
    data object USA_152 : CircuitType(countryCode = "USA", circuitKey = 152, iconResId = R.drawable.ic_circuit_usa_152, backgroundResId = R.drawable.bg_usa_152)
    data object BRA_14 : CircuitType(countryCode = "BRA", circuitKey = 14, iconResId = R.drawable.ic_circuit_bra_14, backgroundResId = R.drawable.bg_bra_14)
    data object MEX_65 : CircuitType(countryCode = "MEX", circuitKey = 65, iconResId = R.drawable.ic_circuit_mex_65, backgroundResId = R.drawable.bg_mex_65)
    data object SGP_61 : CircuitType(countryCode = "SGP", circuitKey = 61, iconResId = R.drawable.ic_circuit_sgp_61, backgroundResId = R.drawable.bg_sgp_61)
    data object AZE_144 : CircuitType(countryCode = "AZE", circuitKey = 144, iconResId = R.drawable.ic_circuit_aze_144, backgroundResId = R.drawable.bg_aze_144)
    data object ITA_39 : CircuitType(countryCode = "ITA", circuitKey = 39, iconResId = R.drawable.ic_circuit_ita_39, backgroundResId = R.drawable.bg_ita_39)
    data object NED_55 : CircuitType(countryCode = "NED", circuitKey = 55, iconResId = R.drawable.ic_circuit_ned_55, backgroundResId = R.drawable.bg_ned_55)
    data object BEL_7 : CircuitType(countryCode = "BEL", circuitKey = 7, iconResId = R.drawable.ic_circuit_bel_7, backgroundResId = R.drawable.bg_bel_7)
    data object HUN_4 : CircuitType(countryCode = "HUN", circuitKey = 4, iconResId = R.drawable.ic_circuit_hun_4, backgroundResId = R.drawable.bg_hun_4)
    data object GBR_2 : CircuitType(countryCode = "GBR", circuitKey = 2, iconResId = R.drawable.ic_circuit_gbr_2, backgroundResId = R.drawable.bg_gbr_2)
    data object AUT_19 : CircuitType(countryCode = "AUT", circuitKey = 19, iconResId = R.drawable.ic_circuit_aut_19, backgroundResId = R.drawable.bg_aut_19)
    data object ESP_15 : CircuitType(countryCode = "ESP", circuitKey = 15, iconResId = R.drawable.ic_circuit_esp_15, backgroundResId = R.drawable.bg_esp_15)
    data object CAN_23 : CircuitType(countryCode = "CAN", circuitKey = 23, iconResId = R.drawable.ic_circuit_can_23, backgroundResId = R.drawable.bg_can_23)
    data object MON_22 : CircuitType(countryCode = "MON", circuitKey = 22, iconResId = R.drawable.ic_circuit_mon_22, backgroundResId = R.drawable.bg_mon_22)
    data object ITA_6 : CircuitType(countryCode = "ITA", circuitKey = 6, iconResId = R.drawable.ic_circuit_ita_6, backgroundResId = R.drawable.bg_ita_6)
    data object USA_151 : CircuitType(countryCode = "USA", circuitKey = 151, iconResId = R.drawable.ic_circuit_usa_151, backgroundResId = R.drawable.bg_usa_151)
    data object CHN_49 : CircuitType(countryCode = "CHN", circuitKey = 49, iconResId = R.drawable.ic_circuit_chn_49, backgroundResId = R.drawable.bg_chn_49)
    data object JPN_46 : CircuitType(countryCode = "JPN", circuitKey = 46, iconResId = R.drawable.ic_circuit_jpn_46, backgroundResId = R.drawable.bg_jpn_46)
    data object AUS_10 : CircuitType(countryCode = "AUS", circuitKey = 10, iconResId = R.drawable.ic_circuit_aus_10, backgroundResId = R.drawable.bg_aus_10)
    data object KSA_149 : CircuitType(countryCode = "KSA", circuitKey = 149, iconResId = R.drawable.ic_circuit_ksa_149, backgroundResId = R.drawable.bg_ksa_149)
    data object BRN_63 : CircuitType(countryCode = "BRN", circuitKey = 63, iconResId = R.drawable.ic_circuit_brn_63, backgroundResId = R.drawable.bg_brn_63)

    companion object {
        private val values = listOf(
            UAE_70,
            QAT_150,
            USA_9,
            USA_152,
            BRA_14,
            MEX_65,
            SGP_61,
            AZE_144,
            ITA_39,
            NED_55,
            BEL_7,
            HUN_4,
            GBR_2,
            AUT_19,
            ESP_15,
            CAN_23,
            MON_22,
            ITA_6,
            USA_151,
            CHN_49,
            JPN_46,
            AUS_10,
            KSA_149,
            BRN_63,
        )
        fun fromCircuitKey(circuitKey: Int): CircuitType? {
            return values.find { it.circuitKey == circuitKey }
        }
    }
}