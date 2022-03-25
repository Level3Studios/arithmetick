package net.level3studios.arithmetick

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.nacular.measured.units.BinarySize
import io.nacular.measured.units.Length
import io.nacular.measured.units.Mass
import io.nacular.measured.units.Time
import junit.framework.TestCase.*
import net.level3studios.arithmetick.models.CategoryItemModel
import net.level3studios.arithmetick.models.CategoryOption
import net.level3studios.arithmetick.viewmodels.ConversionViewModel
import org.junit.Rule
import org.junit.Test

class ConversionViewModelTests {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: ConversionViewModel

    @Test
    fun mockModelTests() {
        viewModel = ConversionViewModel.testViewModel()
        assertEquals(viewModel.itemModel.itemTitle, "Length")
        assertEquals(viewModel.itemModel.defaultUnit, Length.feet)
    }

    @Test
    fun lengthModelTests() {
        val option = CategoryItemModel(option = CategoryOption.LENGTH)
        viewModel = ConversionViewModel(option, context = null)
        viewModel.performConversion("12")

        assertEquals(viewModel.itemModel.itemTitle, "Length")
        assertEquals(viewModel.selectedUnit, Length.feet)
        assertEquals(viewModel.unitShortText.value, "ft")
        assertEquals(viewModel.convertedList.value?.size, 6)
        assertEquals(viewModel.itemModel.itemIconId, R.drawable.ic_baseline_square_foot_24)

        val inchOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Length.inches }
        assertNotNull(inchOption)
        assertEquals(inchOption?.displayValue, "144")

        viewModel.didSelectUnit(Length.meters)
        viewModel.performConversion("320")
        assertEquals(viewModel.selectedUnit, Length.meters)
        val kiloOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Length.kilometers}
        assertNotNull(kiloOption)
        assertEquals(kiloOption?.displayValue, "0.32")
        val milliOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Length.millimeters }
        assertNotNull(milliOption)
        assertEquals(milliOption?.displayValue, "320,000")

        val massOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Mass.grams}
        assertNull(massOption)
    }

    @Test
    fun timeModelTests() {
        val option = CategoryItemModel(CategoryOption.TIME)
        viewModel = ConversionViewModel(option, context = null)
        viewModel.performConversion("120")

        assertEquals(viewModel.itemModel.itemTitle, "Time")
        assertEquals(viewModel.selectedUnit, Time.minutes)
        assertEquals(viewModel.unitShortText.value, "min")
        assertEquals(viewModel.convertedList.value?.size, 2)
        assertEquals(viewModel.itemModel.itemIconId, R.drawable.ic_baseline_access_time_24)

        val hourOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Time.hours }
        assertNotNull(hourOption)
        assertEquals(hourOption?.displayValue, "2")

        viewModel.didSelectUnit(Time.seconds)
        viewModel.performConversion("360")
        val minuteOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Time.minutes }
        assertNotNull(minuteOption)
        assertEquals(minuteOption?.displayValue, "6")

        val byteOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == BinarySize.kilobytes }
        assertNull(byteOption)
    }

    @Test
    fun massModelTests() {
        val option = CategoryItemModel(CategoryOption.MASS)
        viewModel = ConversionViewModel(option, context = null)
        viewModel.performConversion("900")

        assertEquals(viewModel.itemModel.itemTitle, "Mass")
        assertEquals(viewModel.selectedUnit, Mass.grams)
        assertEquals(viewModel.unitShortText.value, "g")
        assertEquals(viewModel.convertedList.value?.size, 1)
        assertEquals(viewModel.itemModel.itemIconId, R.drawable.ic_baseline_fitness_center_24)

        val kiloOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Mass.kilograms }
        assertNotNull(kiloOption)
        assertEquals(kiloOption?.displayValue, "0.9")

        val lengthOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Length.meters }
        assertNull(lengthOption)
    }

    @Test
    fun bytesModelTests() {
        val option = CategoryItemModel(CategoryOption.BYTE)
        viewModel = ConversionViewModel(option, context = null)
        viewModel.performConversion("1280")

        assertEquals(viewModel.itemModel.itemTitle, "Bytes")
        assertEquals(viewModel.selectedUnit, BinarySize.kilobytes)
        assertEquals(viewModel.unitShortText.value, "kB")
        assertEquals(viewModel.convertedList.value?.size, 4)
        assertEquals(viewModel.itemModel.itemIconId, R.drawable.ic_baseline_memory_24)

        val megaOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == BinarySize.megabytes }
        assertNotNull(megaOption)
        assertEquals(megaOption?.displayValue, "1.28")

        viewModel.didSelectUnit(BinarySize.terabytes)
        viewModel.performConversion("1")
        val kiloOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == BinarySize.kilobytes }
        assertNotNull(kiloOption)
        assertEquals(kiloOption?.displayValue, "1,000,000,000")

        val timeOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Time.milliseconds }
        assertNull(timeOption)
    }
}