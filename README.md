Stock Trading Report Generator on Daily Basis

Note:
   Need to update log4j path in APP.Java file.
   /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/src/main/resource/log4j.properties
   
   
 
MAVEN Command output: mvn install
---------------------------------

[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building dailytrade-report 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ dailytrade-report ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ dailytrade-report ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ dailytrade-report ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ dailytrade-report ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ dailytrade-report ---
[INFO] Surefire report directory: /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.jpmorgan.daily.trade.dailytrade_report.PrcessStockDataActionTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.304 sec

Results :

Tests run: 8, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ dailytrade-report ---
[INFO] Building jar: /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/target/dailytrade-report-0.0.1-SNAPSHOT.jar
[INFO] META-INF/maven/com.jpmorgan.daily.trade/dailytrade-report/pom.xml already added, skipping
[INFO] META-INF/maven/com.jpmorgan.daily.trade/dailytrade-report/pom.properties already added, skipping
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ dailytrade-report ---
[INFO] Installing /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/target/dailytrade-report-0.0.1-SNAPSHOT.jar to /Users/suresh/.m2/repository/com/jpmorgan/daily/trade/dailytrade-report/0.0.1-SNAPSHOT/dailytrade-report-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/suresh/eclipse/workspace/boot/Demo/dailytrade-report/pom.xml to /Users/suresh/.m2/repository/com/jpmorgan/daily/trade/dailytrade-report/0.0.1-SNAPSHOT/dailytrade-report-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.551 s
[INFO] Finished at: 2017-08-29T07:59:36+01:00
[INFO] Final Memory: 11M/225M
[INFO] ------------------------------------------------------------------------


   
Application OUTPUT:
~~~~~~~~~~~~~~~~~~~

Amount in USD settled incoming (SELL) everyday:
Date         :  Total Amount
2016-01-11   :  200.00
2016-01-08   :  50.00


Amount in USD settled outgoing (BUY) everyday:
Date         :  Total Amount
2016-01-11   :  200.00
2016-01-08   :  50.00


Ranking of entities based on incoming (SELL) amount:
Rank   :  Enitity   :  Date      
1   :  ES2   :  2016-01-11
2   :  ES3   :  2016-01-11
1   :  ES1   :  2016-01-08


Ranking of entities based on outgoing (BUY) amount:
Rank   :  Enitity   :  Date      
1   :  ES3   :  2016-01-11
2   :  EB2   :  2016-01-11
1   :  EB1   :  2016-01-08
