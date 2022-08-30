<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Supplies table</title>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/ui/v1/items/">Providers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ui/v1/details/">Details</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ui/v1/supplies/">Supplies</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>
<body>

<h1>Supplies table</h1>
<hr>
<a href="/ui/v1/supplies/add"><input type="button" class="btn btn-outline-success margin-table" value="Create" ></a>

<div class="table-center">
    <div class="table-center" style="width: 80%; display: flex; align-content: center">
        <table class="table table-dar">
            <thead>
            <th> ID </th>
            <th> Name</th>
            <th> Provider ID</th>
            <th> Details ID</th>
            <th> Quantity</th>
            <th> Date</th>

            <th> Created At</th>
            <th> Updated At</th>

            <th> DELETE</th>
            <th> EDIT</th>
            </thead>
            <tbody
            <#list supplies as supplie >
                <tr>
                    <td>${supplie.id}</td>
                    <td>${supplie.name}</td>
                    <td>${supplie.providerId.id}</td>
                    <td>${supplie.detailsId.id}</td>
                    <td>${supplie.quantity}</td>
                    <td>${supplie.date}</td>


                    <td>${supplie.createdAt}</td>
                    <td>${supplie.updatedAt?if_exists}</td>
                    <td><a href="/ui/v1/supplies/del/${supplie.id}"><button type="button" class="btn btn-outline-danger">Del</button></a></td>
                    <td><a href="/ui/v1/supplies/edit/${supplie.id}"><button type="button" class="btn btn-outline-info">Edit</button></a></td>
                </tr>
            </#list>
            </tbody>


        </table>

    </div>
</div>

</body>
</html>