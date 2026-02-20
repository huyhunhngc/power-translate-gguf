# PowerTranslator – Native LLaMA Integration

Android library module that integrates **llama.cpp** via CMake + JNI.

---

## Requirements
- NDK 29+  
- CMake 3.31.6  
- Java/Kotlin 17  

---

## Project Structure

```

Workspace/
├─ llama.cpp/
└─ PowerTranslator/
└─ power/   ← Android library module

````

> `llama.cpp` can live anywhere — path is configured via `local.properties`.

---

```bash
./gradlew :power:build
```

Or only configure native:

```bash
./gradlew :power:configureCMakeRelease
```

---
## 🧹 Clean build (recommended after path changes)

```bash
./gradlew clean
rm -rf power/.cxx
rm -rf power/build
```

---

## 🚀 Supported ABIs

* arm64-v8a
* x86_64

---

## 📜 License

Follow the licenses of:

* llama.cpp
* ggml
