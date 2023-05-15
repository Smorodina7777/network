<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Мои посты</title>
    <style>
        table {
            width: 100%;
            margin-bottom: 20px;
            border: 1px solid #dddddd;
            border-collapse: collapse;
        }
        table td {
            border: 1px solid #dddddd;
            padding: 5px;
        }
        .date {
            font-size: x-small ;
        }

    </style>
</head>
<body>
<div id="content">

    <table class="datatable">
        <h2>Список постов</h2>

        <#list postList as post>
        <#if user.id == post.user.id>
            <tr>
                <td>
               <h3>
                    ${post.postName}</h3>

                    <p> ${post.text}</p>
            <p class="date">${post.pubDate}</p>
            <p >${post.user.id}</p>


                    <a href="/post/edit/${post.id}">
                        <button>Редактировать</button>
                    </a>
                    <br><br>
            </td>
            </tr>
        </#if>
        </#list>

    </table>
    <br><br>
    <a href="/post/newPost">
        <button>Добавить пост</button>
    </a>

</div>
</body>
</html>