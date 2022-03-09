//
//  ConvertedResultListView.swift
//  arithmetick
//
//  Created by Sal Aldana on 3/1/22.
//

import SwiftUI

struct ConvertedResultListView: View {
    @ObservedObject var viewModel: ConversionViewModel
    var body: some View {
        List {
            Section("Results") {
                ForEach(viewModel.convertedUnits, id: \.self) { item in
                    HStack {
                        Text(item.value)
                        Text(item.unit.symbol)
                            .fontWeight(.bold)
                            .foregroundColor(viewModel.categoryItem.backgroundColor)
                    }
                    .contentShape(Rectangle())
                    .onTapGesture {
                        Level3Bundle.playClickSound()
                        viewModel.didSelectUnit(convertedUnit: item)
                    }
                }
            }
        }
    }
}

struct ConvertedResultListView_Previews: PreviewProvider {
    static var previews: some View {
        ConvertedResultListView(viewModel: ConversionViewModel.testModel())
    }
}
