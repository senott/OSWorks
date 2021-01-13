## Dependencies

### Docker

### MySQL
#### To create the container (run only once):
```bash
docker run --name=algaworks_mysql -p 3307:3306 -d mysql/mysql-server:8.0
```
Get the root generated password:
```bash
docker logs algaworks_mysql 2>&1 | grep GENERATED
```
#### To run the container:
```bash
docker start algaworks_mysql
```

Connect to the database using the generated password:
```bash
docker exec -it algaworks_mysql mysql -u root -p
```

Alter root password:
```mysql
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';
```
Create the user in the database:
```mysql
CREATE USER 'algaworks'@'localhost' IDENTIFIED BY 'skrowagla';
```

Grant the CREATE permission to the created user:
```mysql
GRANT CREATE ON *.* TO 'algaworks'@'localhost';
 ```
Change user permission to connect from localhost:
```mysql
update mysql.user set host = '%' where user='algaworks';
```
Grant ALL to the user after database has been created:
```mysql
CREATE ROLE 'osworks_admin';
GRANT ALL ON osworks.* TO 'osworks_admin';
GRANT 'osworks_admin' TO 'algaworks'@'%';
SET @@PERSIST.activate_all_roles_on_login=ON;
```