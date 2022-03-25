package net.level3studios.arithmetick.viewmodels

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.nacular.measured.units.Units
import io.nacular.measured.units.times
import net.level3studios.arithmetick.R
import net.level3studios.arithmetick.models.CategoryItemModel
import net.level3studios.arithmetick.models.ConvertedUnitModel

class ConversionViewModel(val itemModel: CategoryItemModel, val context: Context?): ViewModel() {
    //region Companion
    companion object {
        fun testViewModel(): ConversionViewModel = ConversionViewModel(CategoryItemModel.testModel(), null)
    }
    //endregion
    //region Published variables
    var inputValue: String = "0"
    var selectedUnit: Units = itemModel.defaultUnit
    var unitShortText = MutableLiveData("")
    var convertedList = MutableLiveData<List<ConvertedUnitModel>>()
    //endregion

    //region Private Variables
    private var mediaPlayer: MediaPlayer? = null
    //endregion

    //region Functions
    private fun getUnitShortText() {
        unitShortText.postValue(selectedUnit.suffix)
    }
    fun updateInputValue(newValue: String) {
        inputValue = newValue
        performConversion(inputValue)
    }
    fun performConversion(inputValue: String) {
        val allOptions = itemModel.conversionOptions
        val currentOption = allOptions.firstOrNull {
            it == selectedUnit
        } ?: return
        val convertedValue = inputValue.toDoubleOrNull() ?: 0.0
        val startValue = currentOption * convertedValue
        val convertedValues = allOptions.map { startValue `as` it }
        val filteredResults = convertedValues.filter { it.units != currentOption }
        val convertedResults = filteredResults.map {
            ConvertedUnitModel(it.amount, it.units)
        }
        convertedList.postValue(convertedResults)
    }
    fun didSelectUnit(unit: Units) {
        selectedUnit = unit
        updateView()
    }
    //endregion

    init {
        mediaPlayer = MediaPlayer.create(context, R.raw.click_note2)
        mediaPlayer?.start()
        updateView()
    }

    private fun updateView() {
        getUnitShortText()
        performConversion(inputValue)
    }
}