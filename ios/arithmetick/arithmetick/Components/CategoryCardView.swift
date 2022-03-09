//
//  CategoryCardView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import SwiftUI

struct CategoryCardView: View {
    var categoryItem: CategoryItem
    let roundedRect = RoundedRectangle(cornerRadius: 6)
    let fillColor = Color(uiColor: .secondarySystemBackground)
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                CategoryIconView(categoryItem: categoryItem)
                Spacer()
                CategoryCountView(categoryItem: categoryItem)
            }
            .padding(.all, 6)
            CategoryTitleView(categoryItem: categoryItem)
                .padding(.horizontal, 4)
        }
        .cornerRadius(6)
        .overlay(self.roundedRect.stroke(Color.secondary))
        .background(self.roundedRect.fill(fillColor))
        .padding(.horizontal, 6)
    }
}

struct CategoryCardView_Previews: PreviewProvider {
    static var previews: some View {
        CategoryCardView(categoryItem: .init(category: .energy))
    }
}
