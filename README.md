# MarioPizzaAssignment


# what it is
This is a Java Maven project for PBA Test soft2019spring. A hand-in for [assignment6](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/06%20TDD%20assignment.pdf)<br>
This is a console application build using TDD method <br>
<br>

*NB - please note the interface (the menusystem) was tagged on merely as a gimmick, and no tests were created to develop this*

# Setup
1) clone the repo<br>
2) verify the contents
```
mvn verify
```
3) check test-code-coverage with Jacoco (profile ID : jacoco)
```
mvn -P jacoco test
```
4) *for kicks* execute the application, the menusystem should be self-explanatory <br>

*linux*
```
mvn exec:java -Dexec.mainClass="com.js284.App"
```
*windows*
```
mvn exec:java -D"exec.mainClass"="com.js284.App"
```

## Jacoco <br>
![jacoco](https://github.com/cph-js284/MarioPizzaAssignment/blob/master/jacoco_report_mariopizza.png)
<br>
*The code-coverage report is available at ROOT/target/site/jacoco/index.html*  





