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
            description:<@spring.formInput "form.description" "" "text" />
            <br>
            address:<@spring.formInput "form.address" "" "text" />
            <br>
            telephone:<@spring.formInput "form.telephone" "" "text" />
            <br>
            <input type="submit" value="Create">

        </form>

    </fieldset>



</div>

</body>
</html>