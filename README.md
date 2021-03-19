
# libgdx-common
Biblioteca utilizada nos jogos criados pela kendao games.

## Requisitos
- Java 8
- Gradle 6.7.1
- IntelliJ

## Inicialização
```bash
gradle desktop:run
```

## Instalação
Faça o clone deste projeto na máquina e execute o comando de publicação no seu maven local.

Adicione a biblioteca no projeto core, dentro do arquivo build.gradle na pasta raiz do seu projeto:

```js
project(":core") {
    apply plugin: "java-library"

    dependencies {
        api "com.badlogicgames.gdx:gdx:$gdxVersion"

        // ...

        implementation "com.github.kendaozinho:libgdx-common:0.0.1"
    }
}
```

Adicione a pasta [ui](./core/assets/ui) e a pasta [audio](./core/assets/audio) dentro dos assets do seu projeto android (ou projeto core, caso não exista o projeto android).

## Publicação
Local:

```
rm -rf $HOME/.m2/repository/com/kendao/libgdx/libgdx-common/
gradle publishToMavenLocal
```

Público:
```
gradle publish
```

## Atualizar dependências do Gradle
```
gradle build --refresh-dependencies
```
