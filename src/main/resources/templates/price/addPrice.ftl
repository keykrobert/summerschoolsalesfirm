<#import "/spring.ftl" as spring/>
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
<h1>Add new item</h1>

<div>

    <fieldset>
        <form name="item" action="" method="POST">
            price:<@spring.formInput "form.name" "" "text" />
            <br>
            Supplies :<@spring.formSingleSelect "form.names" names "" />
            <br>
            <br>
            <input type="submit" value="Create">

        </form>

    </fieldset>



</div>

</body>
</html>