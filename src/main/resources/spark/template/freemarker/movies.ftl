<html>
    <head>
        <title>Movies Library</title>
        <link rel="stylesheet" href="/style.css">
    </head>
    <body>
        <header>Movies Library</header>

        <#list books as id, book>
            <section>
                <p>Title: ${title}</p>
                <p>Length: ${movie.length}</p>
                <p>Ratings: ${movie.ratings}</p>
                <p>Year: ${movie.year}</p>
                <p>Director: ${movie.director}</p>
                <p>Actor: ${movie.actor}</p>
                <p>Genre: ${movie.genre}</p>
            </section>
        </#list>

        <footer>Java Programming - Harbour.Space University</footer>
    </body>
</html>