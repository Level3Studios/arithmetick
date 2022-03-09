//
//  CategoryRowView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import SwiftUI

struct CategoryRowView: View {
    var categoryItem: CategoryItem
    
    var body: some View {
        HStack {
            CategoryIconView(categoryItem: categoryItem)
            CategoryTitleView(categoryItem: categoryItem)
            Spacer()
            CategoryCountView(categoryItem: categoryItem)
        }.padding(.horizontal, 4)
    }
}

struct CategoryRowView_Previews: PreviewProvider {
    static var previews: some View {
        CategoryRowView(categoryItem: .init(category: .pressure))
    }
}
