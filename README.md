# Tutorial APAP
## Authors
* **Eldinta Yerusyah Taripar** - *1706984575* - *B*

### What I have learned today
### Pertanyaan Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan. <br/>
Pada latihan nomor 1, saya menggunakan conditional rendering if-else. Jika item movie di "checked" maka checkbox akan ditampilkan, jika tidak maka checkbox tidak ditampilkan. <br/>
Untuk latihan nomor 2 saya membuat function clearFavs yang akan mengosongkan array/me-reset array favItems seperti semula, sehingga tidak ada movie di My Favorites. Kemudian saya membuat button dengan action jika diklik maka akan memanggil function clearFavs. Button tersebut saya beri condition jika array favItems memiliki isi maka tampilkan button. <br/>
Untuk mengerjakan latihan nomor 3, saya meng-comment code else newItems.splice(targetInd, 1); pada App.js . splice() adalah method yang mengembalikan item yang diremove dari array. Method splice(targetInd, 1) berarti meremove item pada index targetInd dan item yang diremove sebanyak 1 item. Jika code ini dihapus, maka item movie tidak bisa diremove dari My Favorites. <br/>
Pada latihan nomor 4, saya membuat switch dengan yang memanggil function showFavs. Function showfavs akan mengatur apakah My Favorites ditampilkan atau tidak sesuai dengan state saat ini. <br/>
Untuk no 5, saya membuat component EmptyState yang me-return HTML yang ingin ditampilkan jika daftar My Favorites kosong. Kemudian saya menambahkan kode {!this.state.favItems.length? <EmptyState/> : pada App.js sebelum bagian "<List>" . Jika array favItems kosong maka EmptyState ditampilkan, jika tidak maka daftar My Favorites ditampilkan.<br/><br/>
Berikut ini tampilan halaman setelah semua soal latihan selesai dikerjakan.
![Gambar 1](https://i.ibb.co/MsmX0r0/tutorial-7-01.png)
![Gambar 2](https://i.ibb.co/bXwR78S/tutorial-7-02.png)
![Gambar 3](https://i.ibb.co/qrK5Jj5/tutorial-7-03.png)
<br/>

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props ?
Menurut saya state mirip dengan props karena sama-sama menyimpan informasi mengenai component. Tetapi menurut saya state bisa dikatakan adalah status atau keadaan suatu component dalam suatu waktu. State digunakan untuk tracking perubahan apa saja yang terjadi pada component. Sedangkan props mirip dengan parameter pada method/function. Props dapat dipassed ke sebuah component atau dapat dimiliki oleh component itu sendiri.

3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!
Setiap component terpisah sehingga lebih mudah untuk memperbaiki code. Component juga dapat dipakai berulang (reusable), sehingga programmer tidak perlu menulis code yang sama berulang kali pada tiap halaman HTML yang berbeda. Component hanya perlu ditulis sekali kemudian di import jika ingin digunakan.

4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?
Code dapat dipakai ulang dan tampilan web lebih dinamis.

5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?
Syntax yang kurang familiar terutama bagi yang baru mencoba React, karena React menggunakan JSX yang merupakan gabungan HTML dan Javascript.

### Pertanyaan Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?<br>
Otentikasi adalah proses yang terkait dengan mengenali user yang ingin masuk ke sistem, konsep ini digunakan saat login menggunakan username dan password. Implementasinya ada pada kode untuk membuat halaman login dan pada method login di controller.<br>
Sedangkan otorisasi berkaitan dengan izin akses yang dimiliki user sesuai dengan rolenya. Otorisasi berguna untuk menentukan apakah user tertentu berhak mengakses halaman tertentu. Contoh implementasinya ada pada WebSecurityConfig.java di method configure. Pada method tersebut terdapat method antMatchers untuk mengkonfigurasi izin akses halaman. Misalnya, .antMatchers("/resep/**").hasAnyAuthority("APOTEKER") berarti url yang diawali "/resep/" hanya dapat diakses oleh Apoteker.
<br>
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!
<br> BCryptPasswordEncoder berfungsi untuk mengenkripsi password dengan mengubah String biasa menjadi string yang sudah terenkripsi, sehingga password yang disimpan di database tidak berupa raw string.
<br>
3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!<br>
UUID merupakan ID yang di generate otomatis oleh spring yang berfungsi sebagai identifier model.
<br>
4. Apa kegunaan class UserDetailsServiceImpl.java ? Mengapa harus ada class tersebut padahal kita sudah
memiliki class UserRoleServiceImpl.java ?



### Pertanyaan Tutorial 5
1. Apa itu Postman? Apa kegunaannya? <br>
Postman merupakan tool untuk menguji REST API. Dengan menggunakan Postman, kita dapat melakukan testing terhadap REST API yang kita buat tanpa harus membangun web presentation sistem terlebih dahulu. <br>

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty <br>
@JsonIgnoreProperties digunakan untuk menandai property yang ingin di-ignore. @JsonProperty digunakan untuk memberi nama property JSON.<br>

3. Apa kegunaan atribut WebClient?<br>
WebClient merupakan sebuah interface untuk menghandle web request.<br>

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?<br>
ResponseEntity merupakan ekstensi dari HttpEntity yang merepresentasikan keseluruhan HTTP Response, termasuk status code, header, dan body. ResponseEntity digunakan untuk mengkonfigurasi HTTP Response. BindingResult adalah objek yang berisi hasil validasi objek yang di-post. Biasanya BindingResult digunakan sebagai parameter method post di controller dan dituliskan setelah objek yang di-post dan ingin divalidasi. <br>
<br>
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