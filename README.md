# Midas
## Links
[**Midas design**](https://www.figma.com/file/QqtW2yWhyvDJjJWEebENa6/%D0%95%D0%B1%D1%83%D1%87%D0%B8%D0%B9-Midas?type=design&node-id=0%3A1&mode=design&t=oO38OKr2pcaVb9cF-1)

> [!IMPORTANT]
> It was decided to **split the client and server** into two repositories. This repository is the **server** repository.
The repository for the **client** is located at the link: [**client**](https://github.com/StickyDice/Midas)

### How to open the docs? (Swagger UI format)
1. clone the repository to your local machine
2. run server using `docker compose up -d`.
3. go to `http://localhost:8181/swagger-ui/index.html#/`.

### How to open the docs? (JSON format)
1. clone the repository to your local machine
2. run server using `docker compose up -d`.
3. go to `http://localhost:8181/v3/api-docs`.

> [!NOTE]
> To launch the application use a `docker compose up` for Ubuntu and `docker-compose up` for Windows. You can specify the way to start your server using `-d` tag. The one starts server in a background, so if you need to stop server runs in the background use `docker compose down` for Ubuntu and `docker-compose down` for Windows. 
