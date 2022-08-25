<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Create supplies</title>
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

<h1>Hello, items! </h1>
<div class="table-center">
    <div class="table-center" style="width: 80%; display: flex; align-content: center">
        <table class="table table-dark table-striped">
            <thead>
            <th> ID</th>
            <th> Price</th>
            <th> SuppliesID</th>
            <th>Details Id</th>
            <th> Created At</th>
            <th> Updated At</th>
            <th> DELETE</th>
            <th> EDIT</th>
            </thead>
            <tbody
            <#list prices as price >
                <tr>
                    <td>${price.id}</td>
                    <td>${price.price}</td>
                    <td>${price.supplies.name}</td>
                    <td>${price.details.id}</td>
                    <td>${price.createdAt}</td>
                    <td>${price.updatedAt?if_exists}</td>
                    <td><a href="/ui/v1/prices/del/${price.id}">
                            <button type="button" class="btn btn-danger">Del</button>
                        </a></td>
                    <td><a href="/ui/v1/prices/edit/${price.id}">
                            <button type="button" class="btn btn-info">Edit</button>
                        </a></td>
                </tr>
            </#list>
            </tbody>


        </table>

    </div>
</div>

<a href="/ui/v1/prices/add">CREATE</a>
</body>
</html>