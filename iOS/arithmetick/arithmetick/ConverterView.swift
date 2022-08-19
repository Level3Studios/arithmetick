//
//  ConverterView.swift
//  arithmetick
//
//  Created by Aldana, Sal on 8/18/22.
//

import SwiftUI

struct ConverterView: View {
    @ObservedObject var viewModel: ConversionViewModel
    private let roundedRect = RoundedRectangle(cornerRadius: 4)
    
    var body: some View {
        GeometryReader { proxy in
        VStack {
            HStack {
                self.inputField
                self.inputType
                    .padding(.trailing, 12)
            }.frame(width: proxy.size.width, height: (proxy.size.height / 4))
            self.resultList
        }
        .navigationTitle(viewModel.categoryItem.category.displayLabel)
        .navigationBarTitleDisplayMode(.inline)
        }
    }
    
    var inputField: some View {
        TextField("0", text: $viewModel.inputValue)
            .padding(.leading, 20)
            .tint(viewModel.categoryItem.category.itemColor)
            .textFieldStyle(RoundedBorderTextFieldStyle())
            .keyboardType(.decimalPad)
            .shadow(color: .gray, radius: 2, x: 0, y: 2)
    }
    
    var inputType: some View {
        Text(viewModel.selectedUnit.symbol)
            .padding(.vertical, 6)
            .padding(.horizontal, 12)
            .foregroundColor(.white)
            .background(roundedRect.fill(viewModel.categoryItem.category.itemColor))
    }
    
    var resultList: some View {
        List {
            Section("Results") {
                ForEach(viewModel.convertedUnits, id: \.self) { item in
                    HStack {
                        Text(item.value)
                        Text(item.unit.symbol)
                            .fontWeight(.bold)
                            .foregroundColor(viewModel.categoryItem.category.itemColor)
                    }
                    .contentShape(Rectangle())
                    .onTapGesture {
                        viewModel.didSelectUnit(converterUnit: item)
                    }
                }
            }
        }
    }
}

struct ConverterView_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) {
            ConverterView(viewModel: ConversionViewModel.testModel(category: .length)).preferredColorScheme($0)
        }
    }
}
