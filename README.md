# Smart Light Controller – Android

## Descripción
**Domóticon** es una aplicación Android que permite gestionar de manera remota el encendido y apagado de luces en casa, simulando actividad cuando no estás presente. La aplicación ofrece un control sencillo de 2 o 3 dispositivos, con una interfaz adaptable a diferentes orientaciones y soporte multilingüe (español e inglés).

## Funcionalidades

### Pantalla Inicial
- Selector del número de dispositivos a controlar (2 o 3) mediante un **Spinner**.
- Layout adaptativo según la orientación del dispositivo (**Portrait** y **Landscape**).
- Navegación fluida hacia el panel de control tras la selección.

### Panel de Control
- Cada bombilla dispone de un botón para encenderla o apagarla.
- Botón para invertir el estado de las bombillas seleccionadas mediante **CheckBox**.
- **Switch** que bloquea la funcionalidad de todos los botones.
- Persistencia del estado de los dispositivos aunque la aplicación se cierre o se destruya.
- Interfaz intuitiva y visualmente clara, diferenciando entre control de 2 y 3 dispositivos.

### Internacionalización
- Soporte completo para **español** e **inglés**, permitiendo cambiar de idioma fácilmente.

<br><br>

<div align="center">
  <img width="200" alt="image" src="https://github.com/user-attachments/assets/6b569507-b7d6-49b1-acff-5d16c9452525" />
  <img src="https://github.com/user-attachments/assets/068a9d50-a046-400d-bf93-26b7ba63ef77" width="200">
  <img src="https://github.com/user-attachments/assets/21a4a9ba-96a2-4cd8-b61f-138acc0b366f" width="200">
</div>

<br>

## Tecnologías utilizadas
- **Lenguaje:** Kotlin
- **Plataforma:** Android Studio
- **Componentes principales:**
  - Layouts adaptativos para Portrait y Landscape
  - Persistencia de datos
  - Recursos multilingüe

## Cómo ejecutar la aplicación
1. Abrir el proyecto en **Android Studio**.
2. Compilar y ejecutar la aplicación en un **emulador** o **dispositivo Android**.
3. Seleccionar el número de dispositivos y acceder al panel de control para gestionar las luces.
