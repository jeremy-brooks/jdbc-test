# Simple JDBC SQL Server connection test app

To run you'll need to download and install the Microsoft SQL Server JDBC driver and install using maven.

The driver is not available via the normal public maven resources so you need to download it separately, then run maven
build phase to ensure project dependencies are setup correctly.

1. Get the [Microsoft SQL Server JDBC driver](https://msdn.microsoft.com/en-us/sqlserver/aa937724.aspx).
2. [Install the driver](http://claude.betancourt.us/add-microsoft-sql-jdbc-driver-to-maven/).
3. Run maven clean verify (`mvn clean verify`) to ensure all project dependencies are downloaded and setup.
4. Add to DBConnect class: database endpoint and port number, username and password.
5. Check the SELECT statement in DBConnect (line 34/35) is what you expect.
4. Run Main to test a SQL Server connection.