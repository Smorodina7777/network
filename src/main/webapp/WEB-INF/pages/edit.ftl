<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Изменить</title>
    <style>
        table {
            width: 100%;
            margin-bottom: 20px;
            border: 1px solid #dddddd;
            border-collapse: collapse;
        }

        table th {
            font-weight: bold;
            padding: 5px;
            background: #efefef;
            border: 1px solid #dddddd;
        }

        table td {
            border: 1px solid #dddddd;
            padding: 5px;
        }
    </style>
</head>
<body>
<div id="header">
    <h3>Изменить данные пользователя</h3>
</div>
<div id="content">
    <form action="http://localhost:6060/user/edit" method="post" >

        <input type="hidden" name="id" value="${editUser.id}">
        <input type="text" name="name" id="name" value="${editUser.name}">
        <label for="name">Имя </label>
        <br><br>
        <input type="email" name="email" id="email" value="${editUser.email}">
        <label for="email">Email </label>
        <br><br>
        <input type="password" name="password" id="password" value="${editUser.password}">
        <label for="password">Пароль</label>
        <br><br>
        <input type="submit" value="Сохранить изменения">
    </form>
</div>
</body>
</html>