<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Add new item</h1>

<div>

    <fieldset>
        <form name="item" action="" method="POST">
            name:<@spring.formInput "form.name" "" "text" />
            <br>
            providerId:<@spring.formInput "form.providerId" "" "text" />
            <br>
            detailsId:<@spring.formInput "form.detailsId" "" "text" />
            <br>
            quantity:<@spring.formInput "form.quantity" "" "number" />
            <br>
            <br>

            <br>
            <input type="submit" value="Create">

        </form>

    </fieldset>


</div>

</body>
</html>