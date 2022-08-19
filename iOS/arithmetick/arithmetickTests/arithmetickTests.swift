//
//  arithmetickTests.swift
//  arithmetickTests
//
//  Created by Aldana, Sal on 8/18/22.
//

import XCTest
@testable import arithmetick

class arithmetickTests: XCTestCase {
    
    func testHelperMethods() {
        let testModel = ConversionViewModel.testModel(category: .length)
        XCTAssertEqual(testModel.categoryItem.category.displayLabel, "Length")
        
        //empty value should be treated like 0
        testModel.inputValue = ""
        let meterModel = testModel.convertedUnits.first(where: { $0.unit == UnitLength.meters })
        XCTAssertEqual(meterModel?.value, "0")
        
        //non numerical values will be skipped
        testModel.inputValue = "hello"
        let kiloModel = testModel.convertedUnits.first(where: { $0.unit == UnitLength.kilometers })
        XCTAssertEqual(kiloModel?.value, "0")
    }
    
    func testLengthConversions() {
        // Setup model tests
        let viewModel = ConversionViewModel(categoryItem: .init(category: .length))
        XCTAssertEqual(viewModel.categoryItem.category.displayLabel, "Length")
        XCTAssertEqual(viewModel.selectedUnit, UnitLength.feet)
        XCTAssertFalse(viewModel.convertedUnits.contains(where: { $0.unit == UnitLength.feet}))
        
        // Conversion tests
        viewModel.inputValue = "24"
        let inchConversion = viewModel.convertedUnits.first(where: { $0.unit == UnitLength.inches})
        XCTAssertEqual(inchConversion?.value, "288")
        let yardConversion = viewModel.convertedUnits.first(where: { $0.unit == UnitLength.yards})
        XCTAssertEqual(yardConversion?.value, "8")
        
        viewModel.didSelectUnit(converterUnit: ConvertedUnitModel(value: "0", unit: UnitLength.meters))
        viewModel.inputValue = "36"
        let millimeterConversion = viewModel.convertedUnits.first(where: { $0.unit == UnitLength.millimeters})
        XCTAssertEqual(millimeterConversion?.value, "36,000")
    }
    
    func testTemperatureConversions() {
        // Setup model tests
        let viewModel = ConversionViewModel(categoryItem: .init(category: .temperature))
        XCTAssertEqual(viewModel.categoryItem.category.displayLabel, "Temperature")
        XCTAssertEqual(viewModel.selectedUnit, UnitTemperature.fahrenheit)
        XCTAssertTrue(viewModel.convertedUnits.contains(where: { $0.unit == UnitTemperature.kelvin }))
        XCTAssertFalse(viewModel.convertedUnits.contains(where: { $0.unit == UnitMass.pounds}))
        
        // Conversion Tests
        viewModel.inputValue = "32"
        let celciusConversion = viewModel.convertedUnits.first(where: { $0.unit == UnitTemperature.celsius})
        XCTAssertEqual(celciusConversion?.value, "0")
        viewModel.didSelectUnit(converterUnit: ConvertedUnitModel(value: "0", unit: UnitTemperature.kelvin))
        viewModel.inputValue = "98.2"
        let fahrenheitConversion = viewModel.convertedUnits.first(where: { $0.unit == UnitTemperature.fahrenheit})
        XCTAssertEqual(fahrenheitConversion?.value, "-282.91")
    }
    
    func testMassConversions() {
        // Setup model tests
        let viewModel = ConversionViewModel(categoryItem: .init(category: .mass))
        XCTAssertEqual(viewModel.categoryItem.category.displayLabel, "Mass")
        XCTAssertEqual(viewModel.selectedUnit, UnitMass.grams)
        XCTAssertTrue(viewModel.convertedUnits.contains(where: { $0.unit == UnitMass.ounces}))
        XCTAssertFalse(viewModel.convertedUnits.contains(where: { $0.unit == UnitEnergy.joules}))
        
        // Conversion Tests
        viewModel.inputValue = "980"
        let poundModel = viewModel.convertedUnits.first(where: { $0.unit == UnitMass.pounds})
        XCTAssertEqual(poundModel?.value, "2.161")
        viewModel.didSelectUnit(converterUnit: ConvertedUnitModel(value: "0", unit: UnitMass.grams))
        viewModel.inputValue = "2500.0"
        let kiloModel = viewModel.convertedUnits.first(where: { $0.unit == UnitMass.kilograms})
        XCTAssertEqual(kiloModel?.value, "2.5")
    }
    
}
