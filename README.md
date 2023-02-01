
# Project Selenium WebDriver with Java 8 and Apache Poi dependency

## English

This is a project built with the maven package manager, includes the selenium dependency, apache poi and logs for the correct construction of this. The main purpose of the project is to automate the tests to my personal project "Library" (https://library-5ea0.onrender.com/), generating reports in Word format with screenshots of each step executed by the test cases.

The browser used is Microsoft Edge in its version: 109.0.1518.70 (Official build) (64-bit). So the Web driver used is the same one included in the resources/driver/msedgedriver.exe

If you want to use a different browser, you must update the driver to the corresponding version, and in the Browser class within the org.example.browser package update line 16 webDriver = new EdgeDriver(); por webDriver = new (Instance to driver)
## Español

Esto es un proyecto construido con el gestor de paquetes maven, incluye la dependencia selenium, apache poi y logs para la correcta construcción de este. El propósito principal del proyecto es automatizar las pruebas a mi proyecto personar "Library" (https://library-5ea0.onrender.com/), generando reportes en formato Word con capturas de pantalla de cada paso ejecutado por los casos de prueba.

El navegador utilizado es Microsoft Edge en su versión: 109.0.1518.70 (Compilación oficial) (64 bits). Así que el Web driver utilizado es el mismo incluido en la carpeta del proyecto resources/driver/driver.exe

Si se desea utilizar un navegador diferente, deberá de actualizar el driver a la versión correspondiente, y en la clase Browser dentro del paquete org.example.browser actualizar la línea 16 webDriver = new EdgeDriver(); por webDriver = new (Instancia al driver)

## Screenshots

Generate Word Document

![App Screenshot](https://i.postimg.cc/ykxrrMWh/doc-demo.png)

In the same project folder

![App Screenshot](https://i.postimg.cc/yNFFCf90/Project.png)

## Installation

Install my-project with maven 

```bash
  mvn install
  mvn build
  mvn run
```
Or download project with 

```bash
https://github.com/EriVelk/library-selenium.git
```

And execute on `IntelliJ IDEA`



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://portfolio-erivelk.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/erick-veliz-5a40331b9/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/erve_pud)
