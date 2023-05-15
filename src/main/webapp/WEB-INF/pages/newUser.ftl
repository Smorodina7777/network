<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Новый пользователь</title>
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
    <h3>Добавить нового пользователя</h3>
</div>
<div id="content">
    <form action="http://localhost:6060/user/add" method="post" >

        <label>
            <input type="text" name="name">
        </label>Имя<br><br>
        <label>
            <input type="email" name="email">
        </label>Email<br><br>
        <label>
            <input type="password" name="password">
        </label>Пароль<br><br>
        <input type="submit" value="Сохранить">
    </form>
</div>
</body>
</html>