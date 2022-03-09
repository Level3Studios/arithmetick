//
//  ConverterView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import SwiftUI

struct ConverterView: View {
    @ObservedObject var viewModel: ConversionViewModel
    
    var body: some View {
        GeometryReader { proxy in
            VStack {
                ConversionInputField(viewModel: viewModel)
                .frame(width: proxy.size.width, height: proxy.size.height / 4)
                ConvertedResultListView(viewModel: viewModel)
            }
            .navigationTitle(viewModel.categoryItem.displayLabel)
            .navigationBarTitleDisplayMode(.inline)
        }
    }
}

struct ConverterView_Previews: PreviewProvider {
    static var previews: some View {
        ConverterView(viewModel: ConversionViewModel(categoryItem: .init(category: .length))).preferredColorScheme(.dark)
    }
}
