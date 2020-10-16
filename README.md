# Tutorial APAP
## Authors
* **Eldinta Yerusyah Taripar** - *1706984575* - *B*

### What I have learned today
### Pertanyaan  Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace!
th:include memasukkan kode fragment ke dalam html yang ada, sedangkan th:replace mensubstitusi atau menghapus kode yang ada dan menggantinya dengan kode dari fragment.

2. Jelaskan apa fungsi dari th:object!
th:object menyatakan object yang sedang dibuat atau diupdate dengan form.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
$ digunakan untuk menyatakan nama dari model attribute, sedangkan * menyatakan attribute dari object. Contoh pada tutorial ini misalnya th:object="${resep}" memaksudkan form merupakan formulir create/update resep, sedangkan untuk membuat field bisa menggunakan "*{nama}", "*{namaDokter}", dsb.

4. Bagaimana kamu menyelesaikan latihan nomor 3?
Saya melakukannya sesuai hint yang diberikan, yaitu dengan mengirim variabel dari html yang dirender ke html fragment. Pada navbar di fragment.html saya memakai th:text=${title}, kemudian value dari title saya tentukan di setiap html setiap kali me-replace nav. Misal, untuk navbar pada halaman Home saya menggunakan kode berikut :
<nav th:replace="fragments/fragment :: navbar(title='Home')"></nav>

### Pertanyaan  Tutorial 3
1. Pada class ResepDb, terdapat method findByNoResep, apakah kegunaan dari method tersebut? <br/>
Method findByNoResep digunakan untuk mencari resep berdasarkan nomor resep dari database, kemudian me-return object ResepModel (atau object Optional kosong jika ResepModel tidak ditemukan).

2. Pada class ResepController , jelaskan perbedaan method addResepFormPage dan addResepSubmit? <br/>
addResepFormPage menggunakan method "GET" dan berfungsi untuk mengakses halaman formulir add resep. Sedangkan addResepSubmit menggunakan method "POST" dan berfungsi untuk menyimpan data dari formulir add resep ke database.

3. Jelaskan kegunaan dari JPA Repository ! <br/>
JPA Repository berfungsi sebagai data layer pada springboot. JPA repository melakukan mapping dan mengakses database. Kita dapat menggunakan JPA repository dengan membuat interface yang meng-extends JPA repository kemudian mengimplementasikan method-method CRUD didalamnya.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara ResepModel dan ObatModel dibuat? <br/>
Relasi antara ResepModel dan ObatModel dibuat di ResepModel.java dengan code berikut : <br/>
@OneToMany(mappedBy = "resepModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL) <br/>
private List<ObatModel> listObat;
<br/>
Potongan kode diatas memetakan satu ResepModel ke banyak ObatModel.
<br/>
Berikut merupakan potongan kode dari ObatModel.java yang memetakan obat ke resep. <br/>
@ManyToOne(fetch = FetchType.EAGER, optional = false)
@JoinColumn(name = "resep_id", referencedColumnName = "no_resep", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnore
private ResepModel resepModel;
<br/>
Pada potongan kode diatas, ObatModel memiliki relasi many to one ke ResepModel dengan menggunakan @JoinColumn menandakan kolom pada ObatModel (resep_id) yang berasosiasi dengan kolom pada ResepModel (no_resep).

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL , dan FetchType.EAGER ! <br/>
LAZY dan EAGER merupakan tipe data fetching/loading. Pada eager loading, jika kita memuat (loading) data obat, maka semua resep yang terasosiasi juga akan dimuat. Sedangkan pada lazy loading, data obat tidak akan dimuat ke memory kecuali dipanggil secara eksplisit. <br/>
CascadeType.ALL digunakan untuk mengaplikasikan semua tipe CascadeTypes Hibernate.

### Pertanyaan  Tutorial 2
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
- [ ] 
- [x] ......