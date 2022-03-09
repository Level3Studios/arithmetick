//
//  Level3Helpers.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import Foundation
import UIKit
import SwiftUI
import SwiftHEXColors
import SwiftySound

class Level3Bundle {
    static let level3Blue: Color = Color.init(uiColor: (UIColor(hexString: "#0081B5") ?? .white))
    static let level3Yellow: Color = Color.init(uiColor: (UIColor(hexString: "#DCE36E") ?? .white))
    
    static func playClickSound() {
        Sound.play(file: "Click_Note2", fileExtension: "caf", numberOfLoops: 0)
    }
}

extension Color {
    
    func uiColor() -> UIColor {
        return UIColor(self)
    }
}
