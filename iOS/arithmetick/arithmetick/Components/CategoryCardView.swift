//
//  CategoryCardView.swift
//  arithmetick
//
//  Created by Aldana, Sal on 8/18/22.
//

import SwiftUI

struct CategoryCardView: View {
    var categoryItem: CategoryItem
    let roundedRect = RoundedRectangle(cornerRadius: 6)
    let fillColor = Color(uiColor: .secondarySystemBackground)
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                self.iconView
                Spacer()
                self.countLabel
            }.padding(.all, 6)
            self.titleLabel
        }
        .cornerRadius(6)
        .overlay(self.roundedRect.stroke(Color.secondary))
        .background(self.roundedRect.fill(fillColor))
        .padding(.horizontal, 6)
    }
    
    var iconView: some View {
        categoryItem.category.itemIcon
            .foregroundColor(.white)
            .frame(width: 32, height: 32)
            .background(Circle().fill(categoryItem.category.itemColor))
    }
    
    var countLabel: some View {
        Text("\(categoryItem.category.availableUnits.count)")
            .font(.callout)
            .foregroundColor(.secondary)
    }
    
    var titleLabel: some View {
        Text(categoryItem.category.displayLabel)
            .font(.headline)
            .foregroundColor(.primary)
            .padding(.leading, 4)
            .padding(.bottom, 2)
    }
}

struct CategoryCardView_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(ColorScheme.allCases, id: \.self) {
            CategoryCardView(categoryItem: .init(category: .length)).preferredColorScheme($0)
        }
    }
}
