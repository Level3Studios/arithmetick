//
//  CategoryItemModel.swift
//  arithmetick
//
//  Created by Aldana, Sal on 8/18/22.
//

import Foundation
import SFSafeSymbols
import SwiftUI

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
    
    var itemColor: Color {
        switch self {
        case .length: return .blue
        case .temperature: return .red
        case .mass: return .purple
        case .volume: return .orange
        case .pressure: return .green
        case .energy: return .yellow
        }
    }
    
    var itemIcon: Image {
        var iconName: SFSymbol
        switch self {
        case .length: iconName = .rulerFill
        case .temperature: iconName = .thermometer
        case .mass: iconName = .scalemassFill
        case .volume: iconName = .dropFill
        case .pressure: iconName = .gauge
        case .energy: iconName = .boltFill
        }
        return Image(systemSymbol: iconName)
    }
    
    var defaultUnit: Dimension {
        switch self {
        case .length: return UnitLength.feet
        case .temperature: return UnitTemperature.fahrenheit
        case .mass: return UnitMass.grams
        case .volume: return UnitVolume.teaspoons
        case .pressure: return UnitPressure.poundsForcePerSquareInch
        case .energy: return UnitEnergy.joules
        }
    }
    
    var availableUnits: [Dimension] {
        switch self {
        case .length: return [UnitLength.feet,
                              UnitLength.inches,
                              UnitLength.yards,
                              UnitLength.centimeters,
                              UnitLength.millimeters,
                              UnitLength.kilometers,
                              UnitLength.meters]
        case .temperature: return [UnitTemperature.fahrenheit,
                                   UnitTemperature.celsius,
                                   UnitTemperature.kelvin]
        case .mass: return [UnitMass.grams,
                            UnitMass.kilograms,
                            UnitMass.milligrams,
                            UnitMass.ounces,
                            UnitMass.pounds]
        case .volume: return [UnitVolume.teaspoons,
                              UnitVolume.gallons,
                              UnitVolume.cups,
                              UnitVolume.liters,
                              UnitVolume.pints,
                              UnitVolume.quarts,
                              UnitVolume.tablespoons]
        case .pressure: return [UnitPressure.poundsForcePerSquareInch,
                                UnitPressure.kilopascals,
                                UnitPressure.megapascals,
                                UnitPressure.bars,
                                UnitPressure.millibars]
        case .energy: return [UnitEnergy.joules,
                              UnitEnergy.kilojoules,
                              UnitEnergy.kilowattHours]
        }
    }
}

//MARK: - Category Object -
class CategoryItem: Identifiable, Hashable {
    let id = UUID()
    let category: CategoryItems
    
    static func getAllItems() -> [CategoryItem] {
        return CategoryItems.allCases.map({ CategoryItem(category: $0)})
    }
    
    init(category: CategoryItems) {
        self.category = category
    }
    
    static func == (lhs: CategoryItem, rhs: CategoryItem) -> Bool {
        return lhs.id == rhs.id
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(ObjectIdentifier(self))
    }
}
