# StockTrading
Stock Trading Report Generator on Daily Basis

MAVEN Command output: mvn install
---------------------------
```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building dailytrade-report 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ dailytrade-report ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
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
Running com.jpmorgan.daily.trade.dailytrade_report.GenerateStockReportTest
Amount in USD settled incoming (SELL) everyday:
Date         :  Total Amount
2016-01-11   :  200.00
2016-01-08   :  50.00
Ranking of entities based on incoming (SELL) amount:
Rank   :  Enitity   :  Date      
1   :  ES3   :  2016-01-11
2   :  ES2   :  2016-01-11
1   :  ES1   :  2016-01-08
Ranking of entities based on outgoing (BUY) amount:
Rank   :  Enitity   :  Date      
1   :  ES2   :  2016-01-11
2   :  ES3   :  2016-01-11
1   :  ES1   :  2016-01-08
Amount in USD settled outgoing (BUY) everyday:
Date         :  Total Amount
2016-01-11   :  200.00
2016-01-08   :  50.00
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.381 sec
Running com.jpmorgan.daily.trade.dailytrade_report.PrcessStockDataActionTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.jpmorgan.daily.trade.dailytrade_report.ProcessStockDataServiceTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 sec

Results :

Tests run: 16, Failures: 0, Errors: 0, Skipped: 0

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
[INFO] Total time: 3.262 s
[INFO] Finished at: 2017-08-30T18:38:15+01:00
[INFO] Final Memory: 11M/225M
[INFO] ------------------------------------------------------------------------


```
SAMPLE INPUT:
------------
```
"ES1","S","0.5","USD","07 Jan 2016","08 Jan 2016","10","10" 
"ES2","S","0.5","USD","08 Jan 2016","09 Jan 2016","20","10" 
"ES3","S","0.5","USD","08 Jan 2016","09 Jan 2016","20","10"

"EB1","B","0.5","USD","07 Jan 2016","08 Jan 2016","10","10" 
"EB2","B","0.5","USD","08 Jan 2016","09 Jan 2016","20","10" 
"ES3","B","0.5","USD","08 Jan 2016","09 Jan 2016","20","10"
```

Application OUTPUT:
------------------
```

Amount in USD settled incoming (SELL) everyday:
Date : Total Amount 
2016-01-11 : 200.00 
2016-01-08 : 50.00

Amount in USD settled outgoing (BUY) everyday:
Date : Total Amount 
2016-01-11 : 200.00 
2016-01-08 : 50.00

Ranking of entities based on incoming (SELL) amount:
Rank : Enitity : Date
1 : ES2 : 2016-01-11 
2 : ES3 : 2016-01-11 
1 : ES1 : 2016-01-08

Ranking of entities based on outgoing (BUY) amount:
Rank : Enitity : Date
1 : ES3 : 2016-01-11 
2 : EB2 : 2016-01-11 
1 : EB1 : 2016-01-08

```
