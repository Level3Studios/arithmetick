package net.level3studios.arithmetick.models

import androidx.compose.ui.graphics.Color
import io.nacular.measured.units.*
import net.level3studios.arithmetick.R
import net.level3studios.arithmetick.ui.theme.CustomBlue
import net.level3studios.arithmetick.ui.theme.CustomGreen
import net.level3studios.arithmetick.ui.theme.CustomPurple
import net.level3studios.arithmetick.ui.theme.CustomRed


enum class CategoryOption(val id: Int) {
    LENGTH(0),
    TIME(1),
    MASS(2),
    BYTE(3)
}

class CategoryItemModel(val option: CategoryOption) {

    companion object {
        fun testModel(): CategoryItemModel = CategoryItemModel(CategoryOption.LENGTH)
    }

    val itemTitle: String
        get() = when(this.option) {
            CategoryOption.LENGTH -> "Length"
            CategoryOption.TIME -> "Time"
            CategoryOption.MASS -> "Mass"
            CategoryOption.BYTE -> "Bytes"
        }

    val itemColor: Color
        get() = when(this.option) {
            CategoryOption.LENGTH -> CustomBlue
            CategoryOption.TIME -> CustomRed
            CategoryOption.MASS -> CustomPurple
            CategoryOption.BYTE -> CustomGreen
        }

    val itemIconId: Int
        get() = when(this.option) {
            CategoryOption.LENGTH -> R.drawable.ic_baseline_square_foot_24
            CategoryOption.TIME -> R.drawable.ic_baseline_access_time_24
            CategoryOption.MASS -> R.drawable.ic_baseline_fitness_center_24
            CategoryOption.BYTE -> R.drawable.ic_baseline_memory_24
        }

    val defaultUnit: Units
        get() = when(this.option) {
            CategoryOption.LENGTH -> Length.feet
            CategoryOption.TIME -> Time.minutes
            CategoryOption.MASS -> Mass.grams
            CategoryOption.BYTE -> BinarySize.kilobytes
        }

    val conversionOptions: Array<Units>
        get() = when(this.option) {
            CategoryOption.LENGTH -> arrayOf(
                Length.inches,
                Length.feet,
                Length.miles,
                Length.centimeters,
                Length.millimeters,
                Length.meters,
                Length.kilometers)
            CategoryOption.TIME -> arrayOf(
                Time.seconds,
                Time.minutes,
                Time.hours
            )
            CategoryOption.MASS -> arrayOf(
                Mass.kilograms,
                Mass.grams
            )
            CategoryOption.BYTE -> arrayOf(
                BinarySize.bytes,
                BinarySize.kilobytes,
                BinarySize.megabytes,
                BinarySize.gigabytes,
                BinarySize.terabytes
            )
        }
}