import React from 'react'

function ProductCard({product,quantity}) {
  return (
    <div style={{border:"1px space solid #ccc",padding:"15px"}}>
      <h3>{product.name}</h3>
      <p style={{fontSize:"8px",fontWeight:"bold"}}>rs {product.price}</p>
      <div>
        <span>Quantity:</span>
        <button onClick={() => onChangeQuantity(product.id,-1)}>-</button>
        <span>{quantity}</span>
        <button onClick={() => onChangeQuantity(product.id,1)}>+</button>
      </div>
    </div>
  )
}

export default ProductCard
