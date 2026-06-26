# IronAsia Mobile Technical Test
Aplikasi Android sederhana yang dibuat sebagai bagian dari Technical Test Middle Mobile Developer PT Iron Asia Global.

## 📱 Fitur

### Authentication
- Login menggunakan dummy account
- Validasi email dan password
- Menampilkan pesan error jika login gagal
- Menyimpan status login menggunakan DataStore

### CRUD User
- Read data dari Public API
- Create data baru secara lokal
- Update data secara lokal
- Delete data secara lokal

### Search & Filter
- Search berdasarkan nama user
- Sort data

## 🛠 Tech Stack
- Kotlin
- MVVM Architecture
- Hilt (Dependency Injection)
- Retrofit
- OkHttp
- Gson
- Room Database
- DataStore Preferences
- Coroutines
- StateFlow
- Navigation Component
- Material Design 3

---

## 🏛 Architecture
Project menggunakan arsitektur **MVVM (Model - View - ViewModel)** agar pemisahan tanggung jawab antar layer menjadi jelas dan mudah dikembangkan.

---

## 🔐 Dummy Login
```
Email    : admin@gmail.com
Password : admin123
```

---

## 💾 Local Storage
Aplikasi menggunakan local storage untuk:

### DataStore
- Menyimpan status login pengguna.
- Saat aplikasi dibuka kembali, pengguna tidak perlu login ulang.

### Room Database
Digunakan untuk menyimpan perubahan CRUD secara lokal.

- Create
- Update
- Delete

Perubahan tidak dikirim ke Public API.

---

## 🔄 Pendekatan Teknis
Public API hanya digunakan sebagai sumber data awal (**Read**).

Untuk fitur **Create**, **Update**, dan **Delete**, data diproses secara lokal menggunakan Room Database sesuai ketentuan technical test.

Repository bertugas menggabungkan data dari Remote API dan Local Database sehingga perubahan lokal langsung tercermin pada tampilan aplikasi.

---

## 📱 Screen
- Splash Screen
- Login
- User List
- Add User
- User Detail
- Update User

---

## ▶️ Cara Menjalankan Project
1. Clone repository

```bash
git clone https://github.com/Fajri009/IronAsia.git
```

2. Buka project menggunakan Android Studio.

3. Sync Gradle.

4. Jalankan aplikasi pada emulator atau perangkat Android.

---

## 🎥 Demo

Video demo:

http://

---

## 👨‍💻 Developer

Fajri Rayrahman Harlan
