import React from 'react'
import ProductCard from './ProductCard'

function ProductGrid({ products, onChangeQuantity })  {
  return (
     <div style={{ display: "grid", gridTemplateColumns: "repeat(3, 1fr)", gap: "15px" }}>
      {products.map((product) => (
        <ProductCard
          key={product.id}
          product={product}
          quantity={product.quantity}
          onChangeQuantity={onChangeQuantity}
        />
      ))}
    </div>
  )
}

export default ProductGrid
