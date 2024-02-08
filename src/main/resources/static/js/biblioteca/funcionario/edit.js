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

function formatarCelular(celular) {
    celular = celular.replace(/\D/g, ""); // Remove tudo o que não é dígito
    celular = celular.replace(/^(\d{2})(\d)/g, "($1) $2"); // Coloca parênteses em volta dos dois primeiros dígitos
    celular = celular.replace(/(\d)(\d{4})$/, "$1-$2"); // Coloca hífen entre o quarto e o quinto dígitos
    return celular;
}

window.onload = function () {
    document.getElementById("cpf").onkeyup = function () {
        aplicarMascara(this, formatarCPF);
    };

    document.getElementById("celular").onkeyup = function () {
        aplicarMascara(this, formatarCelular);
    };

    document.getElementById("dataAdmissao").valueAsDate = new Date();
};
