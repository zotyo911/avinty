# Welcome!

Getting started with the development environment

* You should install the following tools (minimum requirements):
    * OpenJDK 11
    * Node.JS 14.15.5
    * IntelliJ IDEA developer tool

If you want to use my code clone the following git repository:
* [github link: `https://github.com/zotyo911/avinty.git`](https://github.com/zotyo911/avinty.git)

You can find my test documentation in this repository in Documents folder or you can find it online: 
* [Test documents link: `Testmanager documents:`](https://docs.google.com/spreadsheets/d/1lnDw42mp5sshUL9gqJ24qPpVfB9zx0Ii/edit?usp=sharing&ouid=100142972014107014188&rtpof=true&sd=true)
```
    * Includes: specification checklist, test cases, bug reports, timelog
```
* [Summary report link: `Summary report`](https://docs.google.com/document/d/17lsgS55kmb5btEoPo98ziVu1KAXJgHeIltw2FxigTjA/edit?usp=sharing)
* This git repository has a CI/CD workflow, which generate an automated test report every `git push` command:
  * [Automated test report link: `Allure report`](https://zotyo911.github.io/avinty)

Run automated test cases in your local repository:
* After you cloned the repository open it in IntelliJ IDEA as a project `File\Open\"Your local repository folder" for example: C:\Java\avinty`
* Choose `Trust this project`
* You can find test java test classes: `.\avinty\src\test\java\tests\`
* Right mouse button click on `BasePageTest.java` and choose `Run 'BasePageTest'`
* At the end all test cases will run, and you will get the result of it in IDEA console

