# Tutorial APAP
## Authors
* **Eldinta Yerusyah Taripar** - *1706984575* - *B*

### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue tracker merupakan fitur Github yang memungkinkan pengguna menambahkan issue. Issue berupa catatan/pesan mengenai pembaruan, bug, dokumentasi, atau hal-hal lain yang dirasa penting untuk dibagikan kepada kolaborator repository. Saat membuat issue baru, pengguna bisa menambahkan label yang membantu membedakan atau mengkategorikan issue.

2. Apa perbedaan dari git merge dan git merge --squash?
Misalkan kita ingin melakukan merge branch A dengan branch master. Branch A memiliki 2 commit yaitu commit 1 dan commit 2. git merge akan menambahkan commit 1 & commit 2 ke branch master dengan commit message default "Merge branch A to master". Sedangkan git merge --squash akan  melakukan "squashed" atau menindih kedua commit tersebut menjadi satu commit baru dengan commit message yang bisa kita modifikasi.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
Version control system membantu pengembang melakukan tracking dan control pengembangan sistem. Menurut saya, VCS sangat penting terutama saat mengembangkan sistem dengan kolaborator agar pekerjaan tiap anggota tidak tumpang tindih sehingga menyebabkan error.

### Spring
4. Apa itu library & dependency?
Library berisi modul-modul yang bisa digunakan oleh program yang kita kembangkan. Dependency adalah ketegantungan antar class atau method dalam suatu sistem.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven memudahkan pengembang untuk membangun dan mengelola Java project. Maven dapat mengotomasi build, testing, membuat report, mengelola dependencies. Alternatif Maven diantaranya Gradle, Ant.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring framework juga bisa digunakan untuk mengembangkan aplikasi desktop.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?
@RequestParam mengambil value dari string query, sedangkan @PathVariable mengambil value dari path. @RequestParam lebih baik digunakan pada aplikasi web biasa, sedangkan @PathVariable lebih cocok digunakan pada RESTful web service dimana biasanya value yang ingin didapat ada pada URL.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Apa itu JavaBeans? Bagaimana cara menggunakannya?
- [x] ......