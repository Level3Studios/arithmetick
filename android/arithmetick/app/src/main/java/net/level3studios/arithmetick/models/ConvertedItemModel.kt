package net.level3studios.arithmetick.models

import io.nacular.measured.units.Units
import java.text.NumberFormat

class ConvertedItemModel(value: Double, unit: Units) {
    val actualUnit = unit
    val displayValue: String = NumberFormat.getInstance().format(value)
    val displayUnit = unit.suffix
}