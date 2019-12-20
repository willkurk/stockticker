'use strict';

const ws = new WebSocket(`ws://localhost:9000/ws`);

ws.onopen = function(e) {
  var initialData = {
    symbol: "BAC"
  }
  ws.send(JSON.stringify(initialData))
}

ws.onmessage = function(event) {
  const data = JSON.parse(event.data);
  console.log(data)
  var element = document.getElementById("price")
  element.innerHTML = data.price
};

function updateSymbol() {
  var newSymbol = document.getElementById("newSymbol").value
  var data = {
    symbol: newSymbol
  }
  ws.send(JSON.stringify(data))
  var label = document.getElementById("symbol")
  label.innerHTML = "Showing " + newSymbol
}
