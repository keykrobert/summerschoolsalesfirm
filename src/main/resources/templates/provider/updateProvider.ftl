<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Update item</h1>

<div>

    <fieldset>
        <form name="item" action="" method="POST">
            id:<@spring.formInput "form.id" "" "text" />
            <br>
            name:<@spring.formInput "form.name" "" "text" />
            <br>
            description:<@spring.formInput "form.description" "" "text" />
            <br>
            address:<@spring.formInput "form.address" "" "text" />
            <br>
            telephone:<@spring.formInput "form.telephone" "" "text" />
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
