<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Create supplies</title>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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

<h1>Update Supplied</h1>
<div>
    <form name="issuedBook" action="" method="POST">
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">ID</label>
            <input class="form-control" type="text" id="exampleInputEmail1" disabled
                   readonly <@spring.formInput "form.id" "" "text"/>

        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.name" "" "text" />
        </div>

        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Reader</label>
            <select class="form-select" id="exampleInputEmail1"
                    aria-describedby="emailHelp" <@spring.formSingleSelect "form.providerId" providerMap "text" />
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Details ID</label>
            <select  class="form-select" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formSingleSelect "form.detailsId" detailsMap "text" />
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Quantity</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.quantity" "" "number" />
        </div>
        <button type="submit" class="btn btn-outline-info">Update</button>
    </form>
</div>

</body>
</html>
