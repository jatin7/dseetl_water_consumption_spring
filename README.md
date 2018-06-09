# spring-data-cassandra

Handle the import of hourly water consumption, got by smart meter devices deployed in several buildings, mainly in the area of Canton Ticino.
Data are stored in a non-relational database in order to make efficient the retrieval of high volume of measurements, in short times. <br>
ETL stands for <b>E</b>xtract data from XML repository, ; <b>T</b>ransform and discard negative measurements; <b>L</b>oad values in Cassandra database, by reading districts from MySQL view.

## Getting Started
Download Eclipse (v.>=4.7.3a) and install Java (v.>=1.8).<br>
Install also Spring Tools:
```
Help -> Eclipse Marketplace -> Search 'Spring Tools' (v.>=3.9.4) -> Install and restart Eclipse
```
Import project in your workspace, then in Eclipse :
```
File -> Import -> Existing Project into Workspace
```
It'a a Maven Project, so each dependency will resolve automatically
```
Right click on project -> Maven -> Update Project
```

### Prerequisites

You need to have XML files following RD_H2O_SES_Daily schema.
<br>
Install Apache Cassandra (v.>=3.11.2) by following <a href="https://medium.com/@areeves9/cassandras-gossip-on-os-x-single-node-installation-of-apache-cassandra-on-mac-634e6729fad6" target="_blank" >this</a> guide.
<br>
Install MySQL Server and workbench from the <a href="https://www.mysql.com/downloads/" target="_blank" > official</a> webiste.
<br>
Get from the root of this project, CQL script to prepare Cassandra keyspace that will store data imported from XMLs.<br>
Get SQL script to create tables and view, needed to ETL to read districts of smart meters and write in Cassandra.
- Cassandra: open command shell and run 
```
cqlsh -e "SOURCE /your/path/Cassandra_schema.cql"
```
- MySQL: open sql file in MySql workbench and click on Execute button

### Installing

In application.properties file:<br>
- set database connections <br>
- select folder in which are stored XML files, where to move them in case of successfull and unsuccesfull extraction<br>

Have also a look in your build path, to check, in Libraries tab, that JRE is correctly set on a version >= 1.8

## Running 

Right click on the project and Run As Spring Boot App OR Run from Boot Dashboard (preferred)

In console is printed the progress.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JAXB](http://www.oracle.com/technetwork/articles/javase/index-140168.html) - XML data exchanger
* [Lombok](https://projectlombok.org/) - Easy access Java functions

## Versioning

I use [SourceTree](https://www.sourcetreeapp.com/) as Git desktop client for versioning. But you may use your preferred  version control system.

## Authors

* **Pietro Borrelli** - *Initial work*

## Acknowledgments

* Thesis research project - Politecnico di Milano
