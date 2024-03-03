function aplicarMascara(elemento, funcao) {
    setTimeout(() => {
        elemento.value = funcao(elemento.value);
    }, 1);
}

function formatarCPF(cpf) {
    cpf = cpf.replace(/\D/g, ""); // Remove tudo o que não é dígito
    cpf = cpf.replace(/^(\d{3})(\d)/, "$1.$2"); // Coloca . em volta dos dois primeiros dígitos
    cpf = cpf.replace(/^(\d{3})\.(\d{3})(\d)/, "$1.$2.$3"); // Coloca ponto entre o terceiro e o quarto dígitos
    cpf = cpf.replace(/^(\d{3})\.(\d{3})\.(\d{3})(\d)/, "$1.$2.$3-$4"); // Coloca hífen entre o décimo segundo e o décimo terceiro dígitos
    return cpf;
}

function formatarTelefone(telefone) {
    telefone = telefone.replace(/\D/g, ""); // Remove tudo o que não é dígito
    telefone = telefone.replace(/^(\d{2})(\d)/g, "($1) $2"); // Coloca parênteses em volta dos dois primeiros dígitos
    telefone = telefone.replace(/(\d)(\d{4})$/, "$1-$2"); // Coloca hífen entre o quarto e o quinto dígitos
    return telefone;
}

window.onload = function () {
    document.getElementById("cpf").onkeyup = function () {
        aplicarMascara(this, formatarCPF);
    };

    document.getElementById("telefone").onkeyup = function () {
        aplicarMascara(this, formatarTelefone);
    };
};
