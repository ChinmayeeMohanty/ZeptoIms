import React from 'react'

function ProductCard({ product, quantity, onChangeQuantity }) {
  const [showDetails, setShowDetails] = useState(false);

  return (
    <div
      style={{
        border: "1px solid #ccc",
        padding: "15px",
        borderRadius: "8px",
        cursor: "pointer",
      }}
      onClick={() => setShowDetails(!showDetails)}
    >
      <h3>{product.name}</h3>
      <p style={{ fontSize: "12px", fontWeight: "bold" }}>₹ {product.price}</p>

      <div>
        <span>Quantity: </span>
        <button onClick={(e) => { e.stopPropagation(); onChangeQuantity(product.id, -1); }}>-</button>
        <span style={{ margin: "0 10px" }}>{quantity}</span>
        <button onClick={(e) => { e.stopPropagation(); onChangeQuantity(product.id, 1); }}>+</button>
      </div>

      {showDetails && (
        <div style={{ marginTop: "10px", fontSize: "12px" }}>
          <strong>Details:</strong>
          <p>{product.description}</p>
        </div>
      )}
    </div>
  );
}

export default ProductCard
