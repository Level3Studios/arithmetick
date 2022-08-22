package net.level3studios.arithmetick.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.nacular.measured.units.*
import net.level3studios.arithmetick.R
import net.level3studios.arithmetick.ui.theme.*


enum class CategoryOption(val id: Int) {
    LENGTH(0),
    TIME(1),
    MASS(2),
    ANGLE(3),
    BINARY(4)
}


class CategoryModel(val option: CategoryOption) {

    companion object {
        fun testModel(): CategoryModel = CategoryModel(CategoryOption.LENGTH)
        fun allCategories() = CategoryOption.values().map { CategoryModel(it) }
    }

    val displayLabel: String
        get() = when(this.option) {
            CategoryOption.LENGTH -> "Length"
            CategoryOption.TIME -> "Time"
            CategoryOption.MASS -> "Mass"
            CategoryOption.ANGLE -> "Angle"
            CategoryOption.BINARY -> "Binary"
        }

    val itemColor: Color
        @Composable
        get() = when(this.option) {
            CategoryOption.LENGTH -> customBlue
            CategoryOption.TIME -> customRed
            CategoryOption.MASS -> customPurple
            CategoryOption.ANGLE -> customOrange
            CategoryOption.BINARY -> customGreen
        }

    val itemIcon: Int
        get() = when(this.option) {
            CategoryOption.LENGTH -> R.drawable.ic_baseline_square_foot_24
            CategoryOption.TIME -> R.drawable.ic_baseline_access_time_filled_24
            CategoryOption.MASS -> R.drawable.ic_baseline_fitness_center_24
            CategoryOption.ANGLE -> R.drawable.ic_baseline_signal_cellular_null_24
            CategoryOption.BINARY -> R.drawable.ic_baseline_memory_24
        }

    val defaultUnit: Units
        @RequiresApi(Build.VERSION_CODES.N)
        get() = when(this.option) {
            CategoryOption.LENGTH -> Length.feet
            CategoryOption.TIME -> Time.minutes
            CategoryOption.MASS -> Mass.grams
            CategoryOption.ANGLE -> Angle.degrees
            CategoryOption.BINARY -> BinarySize.megabytes
        }

    val availableUnits: Array<Units>
        @RequiresApi(Build.VERSION_CODES.N)
        get() = when(this.option) {
            CategoryOption.LENGTH -> arrayOf(Length.feet,
                Length.inches,
                Length.miles,
                Length.centimeters,
                Length.millimeters,
                Length.kilometers,
                Length.meters)
            CategoryOption.TIME -> arrayOf(Time.minutes,
                Time.seconds,
                Time.hours,
                Time.milliseconds)
            CategoryOption.MASS -> arrayOf(Mass.grams,
                Mass.kilograms)
            CategoryOption.ANGLE -> arrayOf(Angle.degrees,
                Angle.radians)
            CategoryOption.BINARY -> arrayOf(BinarySize.megabytes,
                BinarySize.gigabytes,
                BinarySize.kilobytes,
                BinarySize.terabytes
            )
        }
}