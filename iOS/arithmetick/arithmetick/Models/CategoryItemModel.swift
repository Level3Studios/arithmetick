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
