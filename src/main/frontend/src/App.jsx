import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [user, setUser] = useState("");
  const [products, setProducts] = useState([]);

  useEffect(() => {
    // Fetch user
    fetch("/user")
      .then((res) => res.text())
      .then((data) => setUser(data));

    // Fetch products
    fetch("/products")
      .then((res) => res.json())
      .then((data) => {
        // Add quantity field
        const updated = data.map((p) => ({ ...p, quantity: 1 }));
        setProducts(updated);
      });
  }, []);

  const handleQuantityChange = (id, change) => {
    setProducts((prev) =>
      prev.map((p) =>
        p.id === id
          ? { ...p, quantity: Math.max(1, p.quantity + change) }
          : p
      )
    );
  };

  return (
    <>
      <div>
       <Header/>
       <ProductsGrid/>
       {/* <OrderSummary/>
       <PaymentView/>  */}
      </div>
      
    </>
  )
}

export default App
