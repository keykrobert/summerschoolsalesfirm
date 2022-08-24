<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Update detail</h1>

<div>

    <fieldset>
        <form name="item" action="" method="POST">
            id:<@spring.formInput "form.id" "" "text" />
            <br>
            name:<@spring.formInput "form.name" "" "text" />
            <br>
            SKU:<@spring.formInput "form.sku" "" "text" />
            <br>
            Price:<@spring.formInput "form.price" "" "text" />
            <br>
            Comment:<@spring.formInput "form.comment" "" "text" />
            <br>
            Currency:<@spring.formInput "form.currency" "" "text" />
            <br>
            created :<@spring.formInput "form.createdAt" "" "date" />
            <br>
            updated :<@spring.formInput "form.updatedAt" "" "date" />
            <br>

            <input type="submit" value="Save">

        </form>

    </fieldset>



</div>

</body>
</html>
