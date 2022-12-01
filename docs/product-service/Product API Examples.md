# Product Service

#### Save Product

````
POST /api/v1/product HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
Content-Type: application/json
Content-Length: 46

{
    "name": "test-1",
    "price": 9.99
}
````

### Get All Products

````
GET /api/v1/product HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
````

### Update Product

````
PUT /api/v1/product HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
Content-Type: application/json
Content-Length: 67

{
    "id": 1,
    "name": "updated-name",
    "price": 11.20
}
````

### Delete Product

````
DELETE /api/v1/product/1 HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
````
