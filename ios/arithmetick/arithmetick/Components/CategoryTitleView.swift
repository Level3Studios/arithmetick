//
//  CategoryTitleView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import SwiftUI

struct CategoryTitleView: View {
    var categoryItem: CategoryItem
    
    var body: some View {
        Text(categoryItem.displayLabel)
            .font(.headline)
            .foregroundColor(.primary)
            .padding(.leading, 4)
            .padding(.bottom, 2)
    }
}

struct CategoryTitleView_Previews: PreviewProvider {
    static var previews: some View {
        CategoryTitleView(categoryItem: .init(category: .energy)).preferredColorScheme(.dark)
    }
}
