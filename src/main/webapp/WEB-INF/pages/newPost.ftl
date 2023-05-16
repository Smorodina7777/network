<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Новый пост</title>

</head>
<body>
<div id="header">
    <h3>Написать новый пост</h3>
</div>
<div id="content">
    <form action="http://localhost:6060/post/add" method="post" >


            <input style="width: 70%" placeholder="Заголовок" type="text" name="postName">
        <br><br>

            <input style="height: 200px; width: 70%" placeholder="Текст" type="text" name="text" id="text">
        <br><br>
        <input type=hidden" name="user_id" value="${user.id}">
        <input type="submit" value="Сохранить">
    </form>
</div>
</body>
</html>