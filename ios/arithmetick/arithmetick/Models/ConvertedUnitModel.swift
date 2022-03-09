//
//  ConvertedUnitModel.swift
//  arithmetick
//
//  Created by Sal Aldana on 3/1/22.
//

import Foundation
import SwiftUI
import Combine

class ConvertedUnitModel: Identifiable, Hashable {
    let id = UUID().hashValue
    var value: String
    var unit: Dimension
    
    init(value: String?, unit: Dimension) {
        let formatter = NumberFormatter()
        formatter.numberStyle = .decimal
        formatter.allowsFloats = true
        self.value =  value ?? ""
        self.unit = unit
    }
    
    //MARK: - Hashable -
    static func == (lhs: ConvertedUnitModel, rhs: ConvertedUnitModel) -> Bool {
        return lhs.id == rhs.id 
    }
    
    func hash(into hasher: inout Hasher) {
       return hasher.combine(ObjectIdentifier(self))
    }
}
