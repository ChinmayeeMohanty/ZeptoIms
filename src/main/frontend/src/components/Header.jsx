import React from 'react'

function Header() {
  return (
    <div style={{display:"flex",justifyContent:'space-between',alignItems:'center',padding:'15px',backgroundColor:"#333", color:"white"}}>
      <h2>ZEPTO IMS</h2>
      <div>
        <span style={{marginRight:"20px"}}>Welcome,{userName}</span>
      </div>
    </div>
  )
}

export default Header
