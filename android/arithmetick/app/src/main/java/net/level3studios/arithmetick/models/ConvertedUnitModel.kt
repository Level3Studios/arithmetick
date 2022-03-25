package net.level3studios.arithmetick.models

import io.nacular.measured.units.Units
import java.text.NumberFormat

class ConvertedUnitModel(value: Double, unit: Units) {

    val actualUnit: Units = unit
    val displayValue: String = NumberFormat.getInstance().format(value)
    val displayUnit: String = unit.suffix

}