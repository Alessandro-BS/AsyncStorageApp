# AsyncStorageApp (React Native)

Aplicación en **React Native** que guarda un nombre de forma local con **AsyncStorage** (`@react-native-async-storage/async-storage`).

## Funcionalidad

- **Guardar Nombre**: guarda el nombre con la clave `@user_name` (`AsyncStorage.setItem`).
- Al iniciar la app se carga el nombre guardado (`AsyncStorage.getItem`) y se muestra como *"Nombre Guardado: …"*.
- **Eliminar Nombre**: borra el dato (`AsyncStorage.removeItem`). El botón solo aparece cuando hay un nombre guardado.
- Si el campo está vacío, aparece la alerta *"Por favor ingresa un nombre válido."*

Todo el código está en `App.tsx`.

## Requisitos

- Android Studio con el SDK de Android y un emulador (AVD) o un dispositivo conectado.
- Node.js

## Cómo ejecutarlo

```bash
cd ReactNative
npm install
```

1. Abre Android Studio, elige **Open** y selecciona la carpeta `ReactNative/android`.
2. Espera a que Gradle termine de sincronizar.
3. Inicia el emulador desde **Tools > Device Manager**.
4. En una terminal, dentro de `ReactNative`, inicia Metro:

   ```bash
   npx react-native start
   ```

5. En otra terminal, también dentro de `ReactNative`, lanza la app:

   ```bash
   npx react-native run-android
   ```

## Métodos de AsyncStorage usados

- `AsyncStorage.setItem(key, value)`: guarda un texto asociado a una clave. Para guardar un objeto, usa `JSON.stringify(objeto)`.
- `AsyncStorage.getItem(key)`: recupera el texto guardado con esa clave. Para objetos, conviértelo con `JSON.parse(valor)`.
- `AsyncStorage.removeItem(key)`: elimina la clave y su valor.

## Tests

```bash
npm test
```

`__mocks__/@react-native-async-storage/async-storage.js` simula AsyncStorage en memoria para que el test funcione con Jest.
