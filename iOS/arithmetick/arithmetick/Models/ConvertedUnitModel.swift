//
//  ConvertedUnitModel.swift
//  arithmetick
//
//  Created by Aldana, Sal on 8/18/22.
//

import Foundation

class ConvertedUnitModel: Identifiable, Hashable {
    let id = UUID()
    var value: String
    var unit: Dimension
    
    init(value: String?, unit: Dimension) {
        self.value = value ?? ""
        self.unit = unit
    }
    
    
    static func == (lhs: ConvertedUnitModel, rhs: ConvertedUnitModel) -> Bool {
        return lhs.id == rhs.id
    }
    
    func hash(into hasher: inout Hasher) {
        return hasher.combine(ObjectIdentifier(self))
    }
}
