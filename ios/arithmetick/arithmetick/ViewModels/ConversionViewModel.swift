//
//  ConversionViewModel.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import Foundation
import SwiftUI
import Combine
import SwiftySound

class ConversionViewModel: ObservableObject {
    
    //MARK: - Helpers -
    static func testModel() -> ConversionViewModel {
        return ConversionViewModel(categoryItem: .init(category: .length))
    }
    lazy var numberFormatter: NumberFormatter = {
        let formatter = NumberFormatter()
        formatter.numberStyle = .decimal
        formatter.allowsFloats = true
        return formatter
    }()
    
    //MARK: - Private variables -
    private var cancellables: [AnyCancellable] = []
    private var compareOptions: [Dimension]
    
    //MARK: - Public variables -
    var categoryItem: CategoryItem
    
    //MARK: - Published variables -
    @Published var inputValue: String = ""
    @Published var selectedCategory: Int = -1
    @Published var selectedUnit: Dimension
    @Published var convertedUnits: [ConvertedUnitModel] = []
    
    //MARK: - Init -
    init(categoryItem: CategoryItem) {
        self.categoryItem = categoryItem
        self.selectedUnit = categoryItem.categoryOption.defaultUnit
        self.compareOptions = categoryItem.categoryOption.convertableUnits
        self.$inputValue.sink(receiveValue: { value in
            self.performConversion(inputValue: value)
        }).store(in: &cancellables)
        self.performConversion(inputValue: "0")
    }
    
    //MARK: - Functions -
    func performConversion(inputValue: String) {
        let inputNumber = inputValue.isEmpty ? "0" : inputValue
        guard let numberValue = Double(inputNumber) else {
            return
        }
        
        let baseUnit = Measurement(value: numberValue, unit: selectedUnit)
        let conversionOptions = self.getFilteredUnits()
        let convertedValues = conversionOptions.compactMap({ baseUnit.converted(to: $0) })
        let convertedModels = convertedValues.compactMap({ ConvertedUnitModel(value: numberFormatter.string(from: NSNumber(value: $0.value)), unit: $0.unit) })
        self.convertedUnits = convertedModels
    }
    
    func getFilteredUnits() -> [Dimension] {
        return self.compareOptions.filter({ $0 != self.selectedUnit})
    }
    
    func didSelectUnit(convertedUnit: ConvertedUnitModel) {
        self.selectedUnit = convertedUnit.unit
        self.performConversion(inputValue: self.inputValue)
    }
}
