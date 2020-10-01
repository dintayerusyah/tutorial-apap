# Tutorial APAP
## Authors
* **Eldinta Yerusyah Taripar** - *1706984575* - *B*

### What I have learned today
### Pertanyaan  Tutorial
1. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20F
asilkom&catatan=Semangat
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Browser menampilkan Whitelabel Error Page.
![Gambar Whitelabel Error Page](https://i.ibb.co/DQPxsfG/error-tutorial-2-no-1.png)
Hal tersebut dikarenakan template yang dirender (file HTML) belum dibuat.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.
Anotasi @Autowired merupakan penerapan dari konsep dependency injection. Anotasi tersebut berfungsi untuk menginjeksikan dependensi pada suatu objek. Pada tutorial yang saya kerjakan, terdapat class ResepController dengan property resepService yang memiliki anotasi @Autowired. Dengan menggunakan anotasi @Autowired, maka objek yang mengimplementasikan interface ResepService akan otomatis diinjeksikan pada ResepController.

3. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Yang terjadi adalah browser menampilkan Whitelabel Error Page. Hal tersebut dikarenakan URL tidak berisi request parameter 'catatan', yang seharusnya ada karena request parameter 'catatan' wajib diisi (required = true).

4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang
harus diakses?
Resep dengan nama pasien Quanta memiliki nomor resep 1. Maka link yang harus diakses adalah http://localhost:8080/resep/view?noResep=1 . Jika link tersebut diakses maka akan ditampilkan halaman sebagai berikut.
![Gambar View Resep No 1](https://i.ibb.co/kgRH9NR/hasil-tutorial-2-no-4.png)

5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/resep/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Saya mencoba menambahkan resep baru dengan URL http://localhost:8080/resep/add?noResep=2&namaDokter=Kak%20Pewe&namaPasien=Maung%20Fasilkom&catatan=StayHealthy! . Halaman view all menjadi seperti gambar berikut.
![Gambar View Resep No 2](https://i.ibb.co/HKthpV6/hasil-tutorial-2-no-5.png)

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Apa itu JavaBeans? Bagaimana cara menggunakannya?
- [x] ......