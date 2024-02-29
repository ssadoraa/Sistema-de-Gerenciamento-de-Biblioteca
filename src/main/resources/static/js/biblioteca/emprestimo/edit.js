$(document).ready(function () {
  $("#livroId").select2({
    minimumInputLength: 3,
    ajax: {
      url: "/biblioteca/api/livros",
      data: function (params) {
        return {
          busca: params.term,
        };
      },
      processResults: function (data) {
        return {
          results: data.map(function (item) {
            return {
              id: item.id,
              text: item.titulo + ' - ' + item.nome,
            };
          }),
        };
      },
    },
  });

  $("#userId").select2({
    minimumInputLength: 3,
    ajax: {
      url: "/biblioteca/api/users",
      data: function (params) {
        return {
          busca: params.term,
        };
      },
      processResults: function (data) {
        return {
          results: data.map(function (item) {
            return {
              id: item.id,
              text: item.username,
            };
          }),
        };
      },
    },
  });

  $('#funcionarioId').select2({
      minimumInputLength: 3,
      ajax: {
          url: '/biblioteca/api/funcionarios',
          data: function (params) {
              return {
                  busca: params.term,
              };
          },
          processResults: function (data) {
              return {
                  results: data.map(function(item) {
                      return {
                          id: item.id,
                          text: item.nome,
                      };
                  }),
              };
          },
      },
  });
});
