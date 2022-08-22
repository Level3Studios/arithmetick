package net.level3studios.arithmetick

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.nacular.measured.units.*
import net.level3studios.arithmetick.models.CategoryModel
import net.level3studios.arithmetick.models.CategoryOption
import net.level3studios.arithmetick.viewmodels.ConverterViewModel
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ConversionViewModelTests {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: ConverterViewModel

    @Test
    fun mockModelTests() {
        viewModel = ConverterViewModel.testViewModel()
        assertEquals(viewModel.option.displayLabel, "Length")
        assertEquals(viewModel.option.defaultUnit, Length.feet)
    }

    @Test
    fun lengthModelTests() {
        val option = CategoryModel(option = CategoryOption.LENGTH)
        viewModel = ConverterViewModel(option)
        viewModel.performConversion("12")

        assertEquals(viewModel.option.displayLabel, "Length")
        assertEquals(viewModel.selectedUnit, Length.feet)
        assertEquals(viewModel.unitShortText.value, "ft")
        assertEquals(viewModel.convertedList.value?.size, 6)
        assertEquals(viewModel.option.itemIcon, R.drawable.ic_baseline_square_foot_24)

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
        val option = CategoryModel(CategoryOption.TIME)
        viewModel = ConverterViewModel(option)
        viewModel.performConversion("120")

        assertEquals(viewModel.option.displayLabel, "Time")
        assertEquals(viewModel.selectedUnit, Time.minutes)
        assertEquals(viewModel.unitShortText.value, "min")
        assertEquals(viewModel.convertedList.value?.size, 3)
        assertEquals(viewModel.option.itemIcon, R.drawable.ic_baseline_access_time_filled_24)

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
        val option = CategoryModel(CategoryOption.MASS)
        viewModel = ConverterViewModel(option)
        viewModel.performConversion("900")

        assertEquals(viewModel.option.displayLabel, "Mass")
        assertEquals(viewModel.selectedUnit, Mass.grams)
        assertEquals(viewModel.unitShortText.value, "g")
        assertEquals(viewModel.convertedList.value?.size, 1)
        assertEquals(viewModel.option.itemIcon, R.drawable.ic_baseline_fitness_center_24)

        val kiloOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Mass.kilograms }
        assertNotNull(kiloOption)
        assertEquals(kiloOption?.displayValue, "0.9")

        val lengthOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Length.meters }
        assertNull(lengthOption)
    }

    @Test
    fun bytesModelTests() {
        val option = CategoryModel(CategoryOption.BINARY)
        viewModel = ConverterViewModel(option)
        viewModel.performConversion("1280")

        assertEquals(viewModel.option.displayLabel, "Binary")
        assertEquals(viewModel.selectedUnit, BinarySize.megabytes)
        assertEquals(viewModel.unitShortText.value, "MB")
        assertEquals(viewModel.convertedList.value?.size, 3)
        assertEquals(viewModel.option.itemIcon, R.drawable.ic_baseline_memory_24)

        val gigaOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == BinarySize.gigabytes }
        assertNotNull(gigaOption)
        assertEquals(gigaOption?.displayValue, "1.28")

        viewModel.didSelectUnit(BinarySize.terabytes)
        viewModel.performConversion("1")
        val kiloOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == BinarySize.kilobytes }
        assertNotNull(kiloOption)
        assertEquals(kiloOption?.displayValue, "1,000,000,000")

        val timeOption = viewModel.convertedList.value?.firstOrNull { it.actualUnit == Time.milliseconds }
        assertNull(timeOption)
    }
}