//
//  CategoryItemModel.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import Foundation
import SwiftUI
import SFSafeSymbols

//MARK: - Category Enum -
public enum CategoryItems: String, CaseIterable {
    case length, temperature, mass, volume, pressure, energy
    
    var displayLabel: String {
        switch self {
        case .length: return "Length"
        case .temperature: return "Temperature"
        case .mass: return "Mass"
        case .volume: return "Volume"
        case .pressure: return "Pressure"
        case .energy: return "Energy"
        }
    }
    
    var itemIcon: Image {
        var systemImageName: SFSymbol
        switch self {
        case .length: systemImageName = .rulerFill
        case .temperature: systemImageName = .flameFill
        case .mass: systemImageName = .scalemassFill
        case .volume: systemImageName = .dropFill
        case .pressure: systemImageName = .gauge
        case .energy: systemImageName = .boltFill
        }
        return Image(systemSymbol: systemImageName)
    }
    
    var itemColor: Color {
        switch self {
        case .length: return .blue
        case .temperature: return .red
        case .mass: return .purple
        case .volume: return .orange
        case .pressure: return .mint
        case .energy: return .teal
        }
    }
    
    var defaultUnit: Dimension {
        switch self {
        case .length: return UnitLength.feet
        case .temperature: return UnitTemperature.fahrenheit
        case .mass: return UnitMass.ounces
        case .volume: return UnitVolume.cups
        case .pressure: return UnitPressure.poundsForcePerSquareInch
        case .energy: return UnitEnergy.joules
        }
    }
    
    var convertableUnits: [Dimension] {
        switch self {
        case .length: let lengths: [UnitLength] = [.feet,
                                                   .inches,
                                                   .yards,
                                                   .miles,
                                                   .meters,
                                                   .centimeters,
                                                   .millimeters,
                                                   .kilometers]
            return lengths
        case .temperature: let temps: [UnitTemperature] = [.celsius,
                                                           .fahrenheit,
                                                           .kelvin]
            return temps
        case .mass: let masses: [UnitMass] = [.ounces,
                                              .grams,
                                              .kilograms,
                                              .carats,
                                              .pounds]
            return masses
        case .volume: let volumes: [UnitVolume] = [.cups,
                                                   .liters,
                                                   .gallons,
                                                   .pints,
                                                   .quarts,
                                                   .teaspoons,
                                                   .tablespoons]
            return volumes
        case .pressure: let pressures: [UnitPressure] = [.poundsForcePerSquareInch,
                                                         .kilopascals,
                                                         .gigapascals,
                                                         .bars,
                                                         .millibars]
            return pressures
        case .energy: let energies: [UnitEnergy] = [.joules,
                                                    .kilojoules,
                                                    .kilowattHours,
                                                    .calories]
            return energies
        }
    }
}

//MARK: Category Object -
class CategoryItem: Identifiable, Hashable {
    let id: Int = UUID().hashValue
    let categoryOption: CategoryItems
    
    static func getAllItems() -> [CategoryItem] {
        return CategoryItems.allCases.map({ CategoryItem(category: $0)})
    }
    
    init(category: CategoryItems) {
        self.categoryOption = category
    }
    
    var displayLabel: String {
        return categoryOption.displayLabel
    }
    
    var categoryIcon: Image {
        return categoryOption.itemIcon
    }
    
    var backgroundColor: Color {
        return categoryOption.itemColor
    }
    
    var itemCount: Int {
        return categoryOption.convertableUnits.count
    }
    
    var viewModel: ConversionViewModel {
        switch (categoryOption) {
        default: return ConversionViewModel(categoryItem: self)
        }
    }
    
    // MARK: - Hashable -
    static func == (lhs: CategoryItem, rhs: CategoryItem) -> Bool {
        return lhs.id == rhs.id
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(ObjectIdentifier(self))
    }
}
