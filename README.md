
# libgdx-common
Biblioteca utilizada nos jogos criados pela kendao games.

## Pré-requisitos
- Java 8
- Gradle 6.7.1
- LibGDX 1.9.14

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

        implementation "com.github.kendaozinho:libgdx-common:0.0.5"
    }
}
```

Adicione a pasta [ui](./core/assets/ui) e a pasta [audio](./core/assets/audio) dentro dos assets do seu projeto android (ou projeto core, caso não exista).

## Publicação
Maven Local:

```
rm -rf $HOME/.m2/repository/com/kendao/libgdx/libgdx-common/
gradle publishToMavenLocal
```

Mavel Central:
```
gradle publish
```
