## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Spring-Boot Live-Server Reload

[JSP live-reload](https://atl.kr/dokuwiki/doku.php/vscode_springboot_thymeleaf_%EB%B3%80%EA%B2%BD%EC%82%AC%ED%95%AD_%EC%A6%89%EC%8B%9C_%EB%B0%98%EC%98%81)<details><summary></summary>
VSCode + SpringBoot + Thymeleaf 변경사항 즉시 반영  
위와같은 개발환경에서 톰캣 서버 구동 후 소스 변경 시 톰캣을 재시작 해야만 변경사항이 반영되는 경우가 있다.  
이걸 변경 후 저장하면 바로 반영되도록 하려면  
application.properties에 아래 설정 추가하면 해결된다.

spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=file:src/main/resources/templates/
</details>
