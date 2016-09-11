/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cart={};
var orderForm = document.getElementById("orderForm");
orderForm.onsubmit = function (event) {
    
    event.preventDefault();
    var cupcake = {};
    cupcake.top = orderForm.Top.value;
    cupcake.bottom = orderForm.Bottom.value;    
    cupcake.amount = orderForm.quantity.value;
    console.log(cupcake);
    addToCart(cupcake);
    populateTable();
};

function addToCart(cupcake){
    
};
