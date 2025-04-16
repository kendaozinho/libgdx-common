# libgdx-common

Library used in games created by Lunar Bits.

## Prerequisites

- Java 11.0.2
- LibGDX 1.11.0

## Initialization

```bash
gradle desktop:run
```

## Installation

Add the library to the core project inside the build.gradle file located in your project's root folder:

```js
project(":core") {
    apply plugin: "java-library"

    dependencies {
        api "com.badlogicgames.gdx:gdx:$gdxVersion"

        // ...

        implementation "com.github.kendaozinho:libgdx-common:0.0.92" // <-- add this
    }
}
```

Add the [ui](./core/assets/ui) folder and the [audio](./core/assets/audio) folder inside your Android project's assets (
or the core project if it doesn't exist).

Import the [payment libs](https://github.com/libgdx/gdx-pay) along with
the [smartphone libs](https://github.com/libgdx/gdx-pay/tree/master/gdx-pay-android-googlebilling) if needed.

## Publishing

Maven Local:

```
rm -rf $HOME/.m2/repository/com/kendao/libgdx/libgdx-common/ && gradle publishToMavenLocal
```

Mavel Central:

```
gradle publish
```

## Author

Kenneth Gottschalk de Azevedo
