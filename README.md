# Manual de Usuario - AppNotas
**Versión:** 1.0  
**Última actualización:** ``(dokka/latest-update)``

---

## Índice
1️⃣ [Introducción](#introducción)  
2️⃣ [Creación de Notas](#creación-de-notas)  
3️⃣ [Gestión de Notas](#gestión-de-notas)  
4️⃣ [Restaurar Notas](#restaurar-notas)  
5️⃣ [Ayuda Contextual](#ayuda-contextual)

---

## Introducción
Bienvenido a **AppNotas**, tu aplicación para gestionar notas. Con esta herramienta, podrás escribir, organizar y recuperar notas de forma rápida y sencilla.

**Funcionalidades principales:**
- Creación y edición de notas
- Adjuntar imágenes
- Restaurar notas eliminadas

**Más información en la documentación técnica:**  
!INCLUDE dokka/markdown/-app-notas/com.example.appnotas.database/-notes-view-model.md
!INCLUDE dokka/markdown/-app-notas/com.example.appnotas.helpers/-help-manager.md

---

## Creación de Notas

### 1️⃣ **Abrir el editor de notas**
Para crear una nueva nota:  
Pulsa el botón `+` en la pantalla principal

### 2️⃣ **Escribir y adjuntar contenido**
**Opciones disponibles:**
- Escribe un título y descripción
- Añade imágenes tocando **Añadir imagen**

### 3️⃣ **Guardar la nota**
Pulsa el botón **Guardar** para almacenar tu nota.

**Más información técnica:**  
!INCLUDE dokka/markdown/-app-notas/com.example.appnotas.database/-note-save-view-model.md

---

## Gestión de Notas

### **Editar una nota existente**
1️⃣ Selecciona la nota en la pantalla principal  
2️⃣ Realiza los cambios necesarios  
3️⃣ Guarda la nota con el botón **Guardar**
4️⃣ Podrás ver la fecha y hora de la última modificación

### **Eliminar una nota**
Mantén pulsada la nota y selecciona **Eliminar**  
La nota se moverá a la Papelera
La nota permanecerá 7 días en la papelera, a modo de seguridad, hasta que se autoelimine.

**Más detalles técnicos:**  
!INCLUDE dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository.md

---

## Restaurar Notas

1️⃣ Accede a la sección **Papelera**  
2️⃣ Selecciona la nota eliminada, o pulsa el botón correspondiente
3️⃣ Pulsa en **Recuperar**

**Restauración automática:**  
Las notas eliminadas **por más de 7 días** serán **borradas permanentemente**.

**Más detalles en la documentación:**  
!INCLUDE dokka/markdown/-app-notas/com.example.appnotas.database/-notes-repository/restore-note.md

---

##  (!)Ayuda Contextual

AppNotas ofrece asistencia contextual según el uso. Si tienes dudas, busca el ícono **!** de Ayuda en la interfaz.

**Ejemplo de ayuda automática:**  
```
HelpManager.showContextHelp(requireContext(), R.string.help_home)
```

**Referencia técnica:**  
!INCLUDE dokka/markdown/-app-notas/com.example.appnotas.helpers/-help-manager.md

---

**Este manual se actualiza automáticamente con Dokka.**  
Última versión generada: ```(dokka/latest-update)```
