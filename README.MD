# Instrucciones:

1 - Utilizar el comando "docker-compose up" en la ruta donde se encuentra el archivo "docker-compose.yml" para subir Zookeper y Kafka.  
  
2- Luego de que Kafka y Zookeper esten en funcionamiento, ejecutar el microservicio "user-service"  
  
3- Ejecutar el microservicio "notification-service"

4- Hacer una peticion de tipo POST a esta URL **http://localhost:8080/api/v1/users** con el siguiente Paylodad:  

```json
{
  "name": "John"
}
```

5 - Revisar la consola para revisar el correcto funcionamiento y luego estudiar/curiosear este codigo.