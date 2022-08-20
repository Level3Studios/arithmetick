package net.level3studios.arithmetick.models

import android.icu.util.MeasureUnit
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import net.level3studios.arithmetick.R
import net.level3studios.arithmetick.ui.theme.*


enum class CategoryOption(val id: Int) {
    LENGTH(0),
    TEMPERATURE(1),
    MASS(2),
    VOLUME(3),
    PRESSURE(4),
    ENERGY(5)
}


class CategoryModel(val option: CategoryOption) {

    companion object {
        fun testModel(): CategoryModel = CategoryModel(CategoryOption.LENGTH)
        fun allCategories() = CategoryOption.values().map { CategoryModel(it) }
    }

    val displayLabel: String
    get() = when(this.option) {
        CategoryOption.LENGTH -> "Length"
        CategoryOption.TEMPERATURE -> "Temperature"
        CategoryOption.MASS -> "Mass"
        CategoryOption.VOLUME -> "Volume"
        CategoryOption.PRESSURE -> "Pressure"
        CategoryOption.ENERGY -> "Energy"
    }

    val itemColor: Color
    @Composable
    get() = when(this.option) {
        CategoryOption.LENGTH -> MaterialTheme.colorScheme.customBlue
        CategoryOption.TEMPERATURE -> MaterialTheme.colorScheme.customRed
        CategoryOption.MASS -> MaterialTheme.colorScheme.customPurple
        CategoryOption.VOLUME -> MaterialTheme.colorScheme.customOrange
        CategoryOption.PRESSURE -> MaterialTheme.colorScheme.customGreen
        CategoryOption.ENERGY -> MaterialTheme.colorScheme.customYellow
    }

    val itemIcon: Int
    get() = when(this.option) {
        CategoryOption.LENGTH -> R.drawable.ic_baseline_square_foot_24
        CategoryOption.TEMPERATURE -> R.drawable.ic_baseline_whatshot_24
        CategoryOption.MASS -> R.drawable.ic_baseline_fitness_center_24
        CategoryOption.VOLUME -> R.drawable.ic_baseline_opacity_24
        CategoryOption.PRESSURE -> R.drawable.ic_baseline_countertops_24
        CategoryOption.ENERGY -> R.drawable.ic_baseline_bolt_24
    }

    val defaultUnit: MeasureUnit
    @RequiresApi(Build.VERSION_CODES.N)
    get() = when(this.option) {
        CategoryOption.LENGTH -> MeasureUnit.FOOT
        CategoryOption.TEMPERATURE -> MeasureUnit.FAHRENHEIT
        CategoryOption.MASS -> MeasureUnit.GRAM
        CategoryOption.VOLUME -> MeasureUnit.TEASPOON
        CategoryOption.PRESSURE -> MeasureUnit.POUND_PER_SQUARE_INCH
        CategoryOption.ENERGY -> MeasureUnit.JOULE
    }

    val availableUnits: Array<MeasureUnit>
    @RequiresApi(Build.VERSION_CODES.N)
    get() = when(this.option) {
        CategoryOption.LENGTH -> arrayOf(MeasureUnit.FOOT,
            MeasureUnit.INCH,
            MeasureUnit.YARD,
            MeasureUnit.CENTIMETER,
            MeasureUnit.MILLIMETER,
            MeasureUnit.KILOMETER,
            MeasureUnit.METER)
        CategoryOption.TEMPERATURE -> arrayOf(MeasureUnit.FAHRENHEIT,
            MeasureUnit.CELSIUS,
            MeasureUnit.KELVIN)
        CategoryOption.MASS -> arrayOf(MeasureUnit.GRAM,
            MeasureUnit.KILOGRAM,
            MeasureUnit.MILLIGRAM,
            MeasureUnit.OUNCE,
            MeasureUnit.POUND)
        CategoryOption.VOLUME -> arrayOf(MeasureUnit.TEASPOON,
            MeasureUnit.TABLESPOON,
            MeasureUnit.GALLON,
            MeasureUnit.CUP,
            MeasureUnit.LITER,
            MeasureUnit.PINT,
            MeasureUnit.QUART)
        CategoryOption.PRESSURE -> arrayOf(MeasureUnit.POUND_PER_SQUARE_INCH,
            MeasureUnit.HECTOPASCAL,
            MeasureUnit.MILLIBAR)
        CategoryOption.ENERGY -> arrayOf(MeasureUnit.JOULE,
            MeasureUnit.KILOJOULE,
            MeasureUnit.KILOWATT,
            MeasureUnit.KILOWATT_HOUR)
    }
}