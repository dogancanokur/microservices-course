# Transaction Service

#### get user's transactions

````
GET /api/v1/transaction/1 HTTP/1.1
Host: localhost:4444
Authorization: Basic base64(username:password)
````

#### getAll

````
GET /api/v1/transaction/getAll HTTP/1.1
Host: localhost:4444
Authorization: Basic base64(username:password)
````

#### Save

````
POST /api/v1/transaction/ HTTP/1.1
Host: localhost:4444
Authorization: Basic base64(username:password)
Content-Type: application/json
Content-Length: 42

{
    "userId": 1,
    "productId": 1
}
````

#### Delete

````
DELETE /api/v1/transaction/1 HTTP/1.1
Host: localhost:4444
Authorization: Basic base64(username:password)
````
