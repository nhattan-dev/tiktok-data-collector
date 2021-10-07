# tiktok-data-collector

**1.Installation**
  >mvn compile exec:java -Dexec.mainClass=Application -Dexec.cleanupDaemonThreads=false -Dexec.args="advertiser_id access_token"
  
**2.Built With**
  * Hibernate
  * Java core
  * Maven
  * PostgresSQL
  
**3.Database**
  * [Restore File](./dump-tiktok_data_collector-202110051036.sql)
  * [Connection String](./src/main/resources/META-INF/persistence.xml)
  
**4.Other**
  * [URL](./src/main/resources/url.properties)
