<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrarse</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
                crossorigin="anonymous"></script>
    </head>
    <body>

        <div class="vh-100 d-flex justify-content-center align-items-center">
            <div class="col-md-4 p-5 shadow-sm border rounded-5 border-secondary">
                <h2 class="text-center mb-4 text-primary">Registrarse</h2>
                <form method="post" action="<%=request.getContextPath()%>/?action=registrarse" class="needs-validation" novalidate>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control border border-secondary" id="nombre"
                               name="nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control border border-secondary" id="apellido"
                               name="apellido" required>
                    </div>
                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo Electronico</label>
                        <input type="text" class="form-control border border-secondary" id="correo"
                               name="correo" required>
                    </div>
                    <div class="mb-3">
                        <label for="password1" class="form-label">Contraseña</label>
                        <input type="password" class="form-control border border-secondary" id="password1"
                               name="password1"
                               required>
                    </div>
                    <div class="mb-3">
                        <label for="password2" class="form-label">Repitir contraseña</label>
                        <input type="password" class="form-control border border-secondary" id="password2"
                               name="password2"
                               required>
                    </div>
                    <div class="mb-3">
                        <label for="tipo" class="form-label">Tipo de Usuario</label>
                        <select class="form-select" name="tipo" id="tipo">
                            <option value="" selected disabled>Seleccione</option>
                            <option value="interno">Interno</option>
                            <option value="externo">Externo</option>
                        </select>
                    </div>

                    <%if (session.getAttribute("msgError") != null){%>
                    <p class="text-danger"><%=session.getAttribute("msgError")%></p>
                    <%session.removeAttribute("msgError");%>
                    <%}%>

                    <p class="text-secondary">Ya tienes cuenta? <a
                            href="<%=request.getContextPath()%>/?action=iniciarSesion">Iniciar sesión</a>
                    </p>

                    <div class="d-grid">
                        <button class="btn btn-primary" type="submit">Registrarse</button>
                    </div>
                </form>

            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>

        <script>
            (function () {
                'use strict'
                var forms = document.querySelectorAll('.needs-validation')

                Array.prototype.slice.call(forms)
                    .forEach(function (form) {
                        form.addEventListener('submit', function (event) {
                            if (!form.checkValidity()) {
                                event.preventDefault()
                                event.stopPropagation()
                            }

                            form.classList.add('was-validated')
                        }, false)
                    })
            })()
        </script>
    </body>
</html>