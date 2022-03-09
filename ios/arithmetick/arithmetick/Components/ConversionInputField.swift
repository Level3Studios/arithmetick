//
//  ConversionInputField.swift
//  arithmetick
//
//  Created by Sal Aldana on 3/1/22.
//

import SwiftUI

struct ConversionInputField: View {
   @ObservedObject var viewModel: ConversionViewModel
    private let roundedRect = RoundedRectangle(cornerRadius: 4)
    
    var body: some View {
        HStack {
            inputField
            inputType
        }.padding(.horizontal, 24)
    }
    
    var inputField: some View {
        TextField("0", text: $viewModel.inputValue)
            .padding(.leading, 20)
            .tint(viewModel.categoryItem.backgroundColor)
            .textFieldStyle(RoundedBorderTextFieldStyle())
            .keyboardType(.decimalPad)
            .shadow(color: .gray, radius: 3, x: 0, y: 2)
    }
    
    var inputType: some View {
        Text(viewModel.selectedUnit.symbol)
            .padding(.vertical, 6)
            .padding(.horizontal, 12)
            .foregroundColor(.white)
            .background(roundedRect.fill(viewModel.categoryItem.backgroundColor))
    }
}

struct ConversionInputField_Previews: PreviewProvider {
    static var previews: some View {
        ConversionInputField(viewModel: ConversionViewModel.testModel()).preferredColorScheme(.dark)
    }
}
