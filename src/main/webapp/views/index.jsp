<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>


<div class="container-lg text-center">
    <h1 class="text-center" style="margin-left: -2.5%">Index Page</h1>
    <br><br>

    <button type="button" class="btn btn-primary mx-4 my-2 px-5 py-3" data-bs-toggle="modal" data-bs-target="#addStudent">
        Add Student</button>

    <button type="button" class="btn btn-success mx-4 my-2 px-5 py-3" data-bs-toggle="modal" data-bs-target="#add">
    Add Marks</button>

    <button type="button" class="btn btn-danger mx-4 my-2 px-5 py-3" data-bs-toggle="modal" data-bs-target="#deleteS">
    Delete Student</button>
</div>

<!-- add marks Modal -->
<div class="modal fade" id="add" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel0" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel0">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action = "/addStudentMarks" method = "POST">
                    <div class="mb-3">
                        <label for="StudentId" class="form-label">Student Id</label>
                        <input type="number" class="form-control" id="StudentId" required min="0" name="Id">
                    </div>
                    <div class="mb-3">
                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" required name="sem">
                            <option value="1">One</option>
                            <option value="2">Two</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" required name="subject">
                            <option value="English">English</option>
                            <option value="Maths">Maths</option>
                            <option value="Science">Science</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="marks" class="form-label">Marks</label>
                        <input type="number" class="form-control" id="marks" required min="0" max="100" name="marks">
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add Marks</button>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>



<!-- delete Modal -->
<div class="modal fade" id="deleteS" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel1">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action = "/deleteStudent" method = "POST">
                    <div class="mb-3">
                        <label for="SId" class="form-label">Student Id</label>
                        <input type="text" class="form-control" id="SId" required name="SId">
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>

                </form>

            </div>

        </div>
    </div>
</div>


<!-- delete Modal -->
<div class="modal fade" id="addStudent" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel2">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action = "/addStudent" method = "POST">
                    <div class="mb-3">
                        <label for="SName" class="form-label">Student Name</label>
                        <input type="text" class="form-control" id="SName" required name="SName">
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add Student</button>
                    </div>

                </form>

            </div>

        </div>
    </div>
</div>


<div class="container justify-content-center">
<div class="col-auto">
<table class="table table-dark table-striped table-responsive text-center">
<thead>
<tr>
    <th scope="col">Id</th>
    <th scope="col">Name</th>
    <th scope="col">Maths_1</th>
    <th scope="col">Maths_2</th>
    <th scope="col">English_1</th>
    <th scope="col">English_2</th>
    <th scope="col">Science_1</th>
    <th scope="col">Science_2</th>
</tr>
</thead>
<tbody>

<c:forEach items="${students}" var="s">
    <tr>
        <td>${s.getId()}</td>
        <td>${s.getName()}</td>
        <td>${s.getSemesters().get(0).getMaths()}</td>
        <td>${s.getSemesters().get(1).getMaths()}</td>
        <td>${s.getSemesters().get(0).getEnglish()}</td>
        <td>${s.getSemesters().get(1).getEnglish()}</td>
        <td>${s.getSemesters().get(0).getScience()}</td>
        <td>${s.getSemesters().get(1).getScience()}</td>

    </tr>
</c:forEach>

</tbody>
</table>
</div>
</div>


<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Understood</button>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
