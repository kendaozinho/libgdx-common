# libgdx-common

Biblioteca utilizada nos jogos criados pela lunar bits.

## Pré-requisitos

- Java 11.0.2
- LibGDX 1.11.0

## Inicialização

```bash
gradle desktop:run
```

## Instalação

Adicione a biblioteca no projeto core, dentro do arquivo build.gradle da pasta raiz do seu projeto:

```js
project(":core") {
    apply plugin: "java-library"

    dependencies {
        api "com.badlogicgames.gdx:gdx:$gdxVersion"

        // ...

        implementation "com.github.kendaozinho:libgdx-common:0.0.82" // <-- add this
    }
}
```

Adicione a pasta [ui](./core/assets/ui) e a pasta [audio](./core/assets/audio) dentro dos assets do seu projeto
android (ou projeto core, caso não exista).

Importe as [libs](https://github.com/libgdx/gdx-pay) de pagamento junto com
as [libs](https://github.com/libgdx/gdx-pay/tree/master/gdx-pay-android-googlebilling) do smartphone, caso necessário.

## Publicação

Maven Local:

```
rm -rf $HOME/.m2/repository/com/kendao/libgdx/libgdx-common/ && gradle publishToMavenLocal
```

Mavel Central:

```
gradle publish
```
