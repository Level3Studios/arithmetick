//
//  ConversionViewModel.swift
//  arithmetick
//
//  Created by Aldana, Sal on 8/18/22.
//

import Foundation
import Combine

class ConversionViewModel: ObservableObject {
    
    //MARK: - Helpers -
    static func testModel(category: CategoryItems) -> ConversionViewModel {
        return ConversionViewModel(categoryItem: .init(category: category))
    }
    lazy var numberFormatter: NumberFormatter = {
        let formatter = NumberFormatter()
        formatter.numberStyle = .decimal
        formatter.allowsFloats = true
        return formatter
    }()
    
    //MARK: - Public variables -
    var categoryItem: CategoryItem
    
    //MARK: - Private variables -
    private var cancellables: [AnyCancellable] = []
    
    //MARK: - Published variables -
    @Published var inputValue: String = ""
    @Published var selectedUnit: Dimension
    @Published var convertedUnits: [ConvertedUnitModel] = []
    
    //MARK: - Init -
    init(categoryItem: CategoryItem) {
        self.categoryItem = categoryItem
        self.selectedUnit = categoryItem.category.defaultUnit
        self.$inputValue.sink(receiveValue: { value in
            self.performConversion(inputValue: value)
        }).store(in: &cancellables)
        self.performConversion(inputValue: "")
    }
    
    //MARK: - Functions -
    func performConversion(inputValue: String) {
        let inputNumber = inputValue.isEmpty ? "0" : inputValue
        guard let numberValue = Double(inputNumber) else {
            return
        }
        
        let baseUnit = Measurement(value: numberValue, unit: self.selectedUnit)
        let conversionOptions = self.getFilteredUnits()
        let convertedValues = conversionOptions.compactMap({ baseUnit.converted(to: $0) })
        let convertedModels: [ConvertedUnitModel] = convertedValues.compactMap({
            let stringValue = self.numberFormatter.string(from: NSNumber(value: $0.value))
            return ConvertedUnitModel(value: stringValue, unit: $0.unit)
        })
        self.convertedUnits = convertedModels
    }
    
    func getFilteredUnits() -> [Dimension] {
        return self.categoryItem.category.availableUnits.filter({ $0 != self.selectedUnit })
    }
    
    func didSelectUnit(converterUnit: ConvertedUnitModel) {
        self.selectedUnit = converterUnit.unit
        self.performConversion(inputValue: self.inputValue)
    }
}
