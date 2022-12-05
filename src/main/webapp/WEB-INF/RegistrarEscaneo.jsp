<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
    <title>Lista de Servicios</title>
  </head>
  <body>

    <div class='container'>
      <div class="row mb-5 mt-4">
        <div class="col-lg-6">
          <h1 class=''>Registrar Impresión 3D</h1>
        </div>
      </div>
      <form method="post" action="<%=request.getContextPath()%>/Inicio?action=guardarEscaneo" enctype="multipart/form-data">
        <!-- Form Group (username)-->
        <div class="mb-3">
          <input class="form-control " id="idUsuario" type="hidden"
                 name="id" value="id">
        </div>
        <div class="mb-3">
          <label for="largo"> Largo: </label>
          <input class="form-control " id="largo" type="text"
                 name="largo">
        </div>
        <div class="mb-3">
          <label for="ancho"> Ancho: </label>
          <input class="form-control " id="ancho" type="text"
                 name="ancho">
        </div>
        <div class="mb-3">
          <label for="altura"> Alto: </label>
          <input class="form-control " id="altura" type="text"
                 name="altura">
        </div>
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label"><h5>Resolución</h5>
          </label>
          <div class="col-sm-4">
            <select class="form-select" aria-label="Default select example"
                    name="tipo">
              <option selected>Seleccione</option>
              <option value="alta">Alta</option>
              <option value="media">Media</option>
              <option value="baja">Baja</option>
            </select>
          </div>
        </div>
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label"><h5>Grosor </h5>
          </label>
          <div class="col-sm-4">
            <select class="form-select" aria-label="Default select example"
                    name="nivel">
              <option selected>Seleccione...</option>
              <option value="fino">Fino</option>
              <option value="normal">Formal</option>
              <option value="grueso">Grueso</option>
            </select>
          </div>
        </div>
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label"><h5>Altura capa</h5>
          </label>
          <div class="col-sm-4">
            <select class="form-select" aria-label="Default select example"
                    name="nivel">
              <option selected>Seleccione</option>
              <option value="0.1">0.1</option>
              <option value="0.2">0.2</option>
              <option value="0.3">0.3</option>
              <option value="0.4">0.4</option>

            </select>
          </div>
        </div>
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label"><h5>Material </h5>
          </label>
          <div class="col-sm-4">
            <select class="form-select" aria-label="Default select example"
                    name="nivel">
              <option selected>Seleccione</option>
              <option value="abs">abs</option>
              <option value="pla">pla</option>
              <option value="flexible">flexible</option>
            </select>
          </div>
        </div>

        <div class="form-group mb-3">
          <label for="exampleFormControlTextarea1">Url de la imagen:</label>
          <textarea class="form-control" id="exampleFormControlTextarea1"
                    rows="1" name="descripcion"></textarea>
        </div>
        <div class="row mb-3">
          <label class="col-sm-2 col-form-label"><h5>Autoservicio </h5>
          </label>
          <div class="col-sm-4">
            <select class="form-select" aria-label="Default select example"
                    name="nivel">
              <option selected>Seleccione...</option>
              <option value="Si">Si</option>
              <option value="No">No</option>
            </select>
          </div>
        </div>

        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
          <button type="submit" class="btn btn-primary">Guardar
          </button>
          <button class="btn btn-primary"
                  href="<%=request.getContextPath()%>/Inicio">Cancelar
          </button>
        </div>
      </form>

    </div>
  </body>
</html>