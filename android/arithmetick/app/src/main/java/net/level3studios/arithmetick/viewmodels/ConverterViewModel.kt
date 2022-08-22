package net.level3studios.arithmetick.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import io.nacular.measured.units.Units
import io.nacular.measured.units.times
import net.level3studios.arithmetick.models.CategoryModel
import net.level3studios.arithmetick.models.ConvertedItemModel

@RequiresApi(Build.VERSION_CODES.N)
class ConverterViewModel(val option: CategoryModel) {

    companion object {
        fun testViewModel(): ConverterViewModel = ConverterViewModel(CategoryModel.testModel())
    }

    var inputValue: String = "0"
    var selectedUnit = option.defaultUnit
    var unitShortText = MutableLiveData("")
    var convertedList = MutableLiveData<List<ConvertedItemModel>>()

    init {
        this.updateView()
    }

    private fun updateView() {
        this.getUnitShortText()
        this.performConversion(this.inputValue)
    }

    fun updateInputValue(newValue: String) {
        this.inputValue = newValue
        this.performConversion(this.inputValue)
    }

    fun didSelectUnit(unit: Units) {
        this.selectedUnit = unit
        this.updateView()
    }

    fun getUnitShortText() {
        this.unitShortText.postValue(this.selectedUnit.suffix)
    }

    fun performConversion(inputValue: String) {
        val allOptions = option.availableUnits
        val currentOption = allOptions.firstOrNull {
            it == selectedUnit
        } ?: return
        val convertedValue = inputValue.toDoubleOrNull() ?: 0.0
        val startValue = currentOption * convertedValue
        val convertedValues = allOptions.map { startValue `as` it }
        val filteredResults = convertedValues.filter { it.units != currentOption }
        val convertedResults = filteredResults.map { ConvertedItemModel(it.amount, it.units) }
        this.convertedList.postValue(convertedResults)
    }

}