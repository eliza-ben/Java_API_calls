Run it 
mvn spring-boot:run

Token via App
curl -X POST "http://localhost:8080/auth/token" \
  -H "Content-Type: application/json" \
  -d '{
    "clientId":"YOUR_CLIENT_ID",
    "clientSecret":"YOUR_CLIENT_SECRET",
    "username":"YOUR_USERNAME",
    "password":"YOUR_PASSWORD"
  }'

  upload 
  curl -X POST "http://localhost:8080/files/upload-xlsx" \
  -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
  -F "file=@/path/to/File.xlsx"

  upload wirh Serverside login 
  curl -X POST "http://localhost:8080/files/upload-xlsx-with-login" \
  -F "file=@/path/to/File.xlsx"
