function inverterData(data) {
  var partes = data.split("-");
  var dataInvertida = partes[2] + "/" + partes[1] + "/" + partes[0];

  return dataInvertida;
}

function exibirDataInvertida() {
  var camposData = document.querySelectorAll(".dataInverter");

  camposData.forEach(function (elemento) {
    var dataOriginal = elemento.value;
    var dataInvertida = inverterData(dataOriginal);
    elemento.value = dataInvertida;
  });
}

exibirDataInvertida();
