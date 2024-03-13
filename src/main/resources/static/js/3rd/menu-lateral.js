document.getElementById('menu-toogle').addEventListener('click', function () {
    document.getElementById('sidebar').classList.toggle('visible');
});

fetch("/biblioteca/api")
    .then((response) => response.json())
    .then((data) => {
        const { id, username, role, email } = data;

        document.getElementById('username').value = username;
        document.getElementById('email').value = email;
        document.getElementById('role').value = role;
        document.querySelector('.editar-usuario').href = `/biblioteca/usuario/${id}/edit`;
    })
    .catch((error) => {
        console.error("Ocorreu um erro:", error);
    });