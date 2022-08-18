//
//  ContentView.swift
//  arithmetick
//
//  Created by Aldana, Sal on 8/18/22.
//

import SwiftUI

struct ContentView: View {
    private let gridSizes: [GridItem] = Array(repeating: .init(.adaptive(minimum: 120)), count: 2)
    private let gridItems = CategoryItem.getAllItems()
    
    var body: some View {
        NavigationView {
            ScrollView(.vertical) {
                LazyVGrid(columns: self.gridSizes,
                          spacing: 12,
                          content: {
                    ForEach(gridItems, id: \.self) {
                        Text($0.category.displayLabel)
                    }
                })
            }
            .navigationTitle("Categories")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) {
            ContentView().preferredColorScheme($0)
        }
    }
}
