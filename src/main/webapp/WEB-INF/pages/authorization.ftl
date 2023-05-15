<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Мое приложение</title>
</head>
<body>

<h1>Добро пожаловать: ${user.name} </h1>

<h3>Ваши данные</h3>
<h5>Email: ${user.email}</h5>




<a href="/user/list">Информация о пользователях</a><br><br>
<a href="/post/list">Мои посты</a><br><br>

<a href="/user/new">
    <button>Добавить нового пользователя</button>
</a>
</body>
</html>