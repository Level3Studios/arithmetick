//
//  CategoryCountView.swift
//  arithmetick
//
//  Created by Sal Aldana on 2/25/22.
//

import SwiftUI

struct CategoryCountView: View {
    var categoryItem: CategoryItem
    
    var body: some View {
        Text("\(categoryItem.itemCount)")
            .font(.callout)
            .foregroundColor(.secondary)
    }
}

struct CategoryCountView_Previews: PreviewProvider {
    static var previews: some View {
        CategoryCountView(categoryItem: .init(category: .energy))
    }
}
