//
//  ContentView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/23/22.
//

import SwiftUI
import SFSafeSymbols

enum ViewStyles {
    case grid, list
}

struct ContentView: View {
    let values: [CategoryItem] = CategoryItem.getAllItems()
    private let gridSizes: [GridItem] = Array(repeating: .init(.adaptive(minimum: 120)), count: 2)
    @State private var viewStyle: ViewStyles = .grid
    
    init() {
        let textAttributes: [NSAttributedString.Key: Any] = [.foregroundColor: Level3Bundle.level3Blue.uiColor()]
        let navAppearance = UINavigationBarAppearance()
        navAppearance.configureWithOpaqueBackground()
        navAppearance.titleTextAttributes = textAttributes
        navAppearance.largeTitleTextAttributes = textAttributes
        
        UINavigationBar.appearance().standardAppearance = navAppearance
        UINavigationBar.appearance().compactAppearance = navAppearance
        UINavigationBar.appearance().scrollEdgeAppearance = navAppearance
        UINavigationBar.appearance().tintColor = Level3Bundle.level3Yellow.uiColor()
        
    }
    
    var body: some View {
        NavigationView {
            viewForState(viewState: viewStyle)
                .navigationTitle("Categories")
                .toolbar {
                    ToolbarItem(placement: .navigationBarTrailing) {
                        viewStyleToggle
                    }
                }
        }.onDisappear(perform: {
            Level3Bundle.playClickSound()
        })
    }
    
    @ViewBuilder func viewForState(viewState: ViewStyles) -> some View {
        if viewState == .grid {
            gridView
        } else {
            listView
        }
    }
    
    var viewStyleToggle: some View {
        Picker("ViewStyle", selection: $viewStyle) {
            Image(systemSymbol: .squareGrid2x2).tag(ViewStyles.grid)
            Image(systemSymbol: .listDash).tag(ViewStyles.list)
        }.pickerStyle(SegmentedPickerStyle())
    }
    
    //MARK: - Grid View -
    var gridView: some View {
        ScrollView(.vertical) {
            LazyVGrid(columns: self.gridSizes,
                      spacing: 12,
                      content: {
                ForEach(values, id: \.self) { item in
                    NavigationLink(destination: ConverterView(viewModel: item.viewModel),
                                   label: {
                        CategoryCardView(categoryItem: item)
                    })
                }
            })
        }
    }
    
    
    //MARK: - List View -
    var listView: some View {
        List(values, id: \.self) { item in
            NavigationLink(destination: ConverterView(viewModel: item.viewModel), label: {
                CategoryRowView(categoryItem: item)
            })
        }.listStyle(PlainListStyle())
    }
}

//MARK: - Previews -
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) {
            ContentView().preferredColorScheme($0)
        }
    }
}
