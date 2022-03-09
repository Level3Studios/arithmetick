//
//  CategoryIconView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import SwiftUI

struct CategoryIconView: View {
    var categoryItem: CategoryItem
    
    var body: some View {
        categoryItem.categoryIcon
            .foregroundColor(.white)
            .frame(width: 32, height: 32)
            .background(Circle().fill(categoryItem.backgroundColor))
    }
}

struct CategoryIconView_Previews: PreviewProvider {
    static var previews: some View {
        CategoryIconView(categoryItem: .init(category: .length))
    }
}
