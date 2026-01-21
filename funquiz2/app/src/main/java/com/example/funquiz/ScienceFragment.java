package com.example.funquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ScienceFragment extends Fragment {
    public ScienceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_science, container, false);

        // Inisialisasi semua CardView
        CardView cardTataSurya = view.findViewById(R.id.cardTataSurya);
        CardView cardSel = view.findViewById(R.id.cardSel);
        CardView cardAir = view.findViewById(R.id.cardAir);
        CardView cardDaun = view.findViewById(R.id.cardDaun);
        CardView cardGravitasi = view.findViewById(R.id.cardGravitasi);
        CardView cardOksigen = view.findViewById(R.id.cardOksigen);
        CardView cardGalaksi = view.findViewById(R.id.cardGalaksi);
        CardView cardKerangka = view.findViewById(R.id.cardKerangka);
        CardView cardEnergi = view.findViewById(R.id.cardEnergi);
        CardView cardDarah = view.findViewById(R.id.cardDarah);

        // Semua akan menggunakan "Fun Facts" sebagai titleHistory
        String titleHistory = "Fun Facts";
        String titleExtra = "Tambahan"; // Menambahkan string titleExtra

        // Set listener klik
        cardTataSurya.setOnClickListener(v -> openDetail(
                R.drawable.tatasurya, "Tata Surya",
                "Tata Surya adalah sebuah sistem kosmik yang menakjubkan, terdiri dari Matahari sebagai bintang pusat dan semua objek astronomi yang terikat oleh gaya gravitasinya. Ini termasuk delapan planet utama, lima planet kerdil, ratusan bulan, jutaan asteroid, komet, meteoroid, dan debu antarbintang, semuanya bergerak dalam lintasan orbit yang teratur mengelilingi Matahari.",
                "Tata Surya terbentuk sekitar 4,6 miliar tahun yang lalu dari awan molekul raksasa yang runtuh akibat gravitasinya sendiri. Sebagian besar massa awan ini berkumpul membentuk Matahari, sedangkan sisa materi yang berputar pipih membentuk piringan protoplanet. Dari piringan ini, partikel-partikel mulai bertabrakan dan menempel, secara bertahap membentuk planetesimal, lalu protoplanet, dan akhirnya planet-planet yang kita kenal sekarang. Proses pembentukan ini berlangsung selama puluhan juta tahun hingga Tata Surya mencapai konfigurasi yang relatif stabil.",
                "Selain delapan planet (Merkurius, Venus, Bumi, Mars, Jupiter, Saturnus, Uranus, Neptunus), Tata Surya juga memiliki Sabuk Asteroid di antara Mars dan Jupiter, Sabuk Kuiper di luar orbit Neptunus (tempat banyak planet kerdil seperti Pluto berada), dan Awan Oort yang merupakan reservoir komet terjauh. Matahari, yang merupakan bintang tipe G2V, menyumbang 99.86% dari total massa Tata Surya dan menyediakan energi yang penting untuk menopang kehidupan di Bumi. Setiap planet memiliki karakteristik uniknya sendiri, mulai dari Merkurius yang panas dan berbatu hingga raksasa gas seperti Jupiter dan Saturnus dengan cincinnya yang ikonik.",
                titleHistory,
                titleExtra
        ));

        cardSel.setOnClickListener(v -> openDetail(
                R.drawable.cell, "Sel",
                "Sel adalah unit struktural, fungsional, dan biologis terkecil dari semua organisme yang diketahui. Sel sering disebut sebagai 'blok bangunan kehidupan' karena semua makhluk hidup, dari bakteri mikroskopis hingga manusia raksasa, terdiri dari satu atau lebih sel. Setiap sel memiliki kemampuan untuk melakukan semua fungsi vital kehidupan, seperti reproduksi, pertumbuhan, metabolisme, dan respons terhadap rangsangan.",
                "Konsep sel sebagai unit dasar kehidupan berkembang setelah penemuan mikroskop. Robert Hooke adalah ilmuwan pertama yang mengamati 'sel' pada tahun 1665 saat mengamati irisan gabus di bawah mikroskop, meskipun yang ia lihat hanyalah dinding sel mati. Penemuan sel hidup baru dilakukan oleh Antonie van Leeuwenhoek pada akhir abad ke-17. Namun, Teori Sel modern yang menyatakan bahwa semua organisme terdiri dari sel, sel adalah unit dasar kehidupan, dan semua sel berasal dari sel yang sudah ada sebelumnya, baru diformulasikan secara resmi pada pertengahan abad ke-19 oleh ilmuwan seperti Theodor Schwann, Matthias Schleiden, dan Rudolf Virchow.",
                "Ada dua jenis utama sel: **Prokariotik** dan **Eukariotik**. Sel prokariotik (seperti bakteri) lebih sederhana, tidak memiliki inti sel atau organel terikat membran. Sel eukariotik (seperti pada tumbuhan, hewan, jamur, dan protista) jauh lebih kompleks, memiliki inti sel yang jelas dan berbagai organel spesifik seperti mitokondria (pembangkit energi), kloroplas (pada tumbuhan untuk fotosintesis), retikulum endoplasma, dan kompleks Golgi. Sel-sel ini bekerja sama membentuk jaringan, organ, dan sistem organ, yang pada akhirnya membentuk organisme multiseluler yang kompleks. Struktur dan fungsi sel adalah dasar dari seluruh biologi modern.",
                titleHistory,
                titleExtra
        ));

        cardAir.setOnClickListener(v -> openDetail(
                R.drawable.water, "Air (H₂O)",
                "Air adalah senyawa kimia vital yang tidak berwarna, tidak berbau, dan tidak berasa pada suhu ruangan, tetapi sangat krusial bagi kelangsungan hidup semua bentuk kehidupan di Bumi. Dengan rumus kimia H₂O, air terdiri dari dua atom hidrogen dan satu atom oksigen. Sifat-sifat unik air, seperti kemampuan melarutkan berbagai zat dan kapasitas panasnya yang tinggi, menjadikannya pelarut universal dan pengatur suhu yang sangat efektif di planet kita.",
                "Air adalah zat paling melimpah di permukaan Bumi, menutupi sekitar 71% dari permukaannya dalam bentuk lautan, danau, sungai, es, dan uap air. Siklus air alami, yang dikenal sebagai siklus hidrologi, terus-menerus menggerakkan air melalui evaporasi, kondensasi, presipitasi, dan aliran permukaan, memastikan ketersediaannya di berbagai ekosistem. Kehadiran air cair di permukaan Bumi adalah salah satu faktor utama yang memungkinkan Bumi menjadi planet yang dapat dihuni.",
                "Air memiliki **tiga fase utama**: padat (es), cair (air), dan gas (uap air), yang dapat berubah bentuk pada suhu dan tekanan tertentu. Lebih dari 96% air di Bumi adalah air asin di lautan, sementara sisanya adalah air tawar, sebagian besar terkunci dalam gletser dan tudung es. Manusia menggunakan air untuk berbagai tujuan vital, termasuk minum, sanitasi, pertanian (irigasi), industri, dan pembangkit listrik. Menjaga kualitas dan ketersediaan air bersih adalah salah satu tantangan lingkungan terbesar di abad ke-21. Air juga memiliki tegangan permukaan yang tinggi dan daya rekat (kohesi) yang kuat, memungkinkan fenomena seperti kapilaritas yang penting bagi kehidupan tumbuhan.",
                titleHistory,
                titleExtra
        ));

        cardDaun.setOnClickListener(v -> openDetail(
                R.drawable.leaf, "Daun",
                "Daun adalah organ vital pada sebagian besar tumbuhan vaskular, yang dikenal sebagai 'dapur' atau 'pabrik' tumbuhan. Fungsi utamanya adalah melakukan fotosintesis, sebuah proses di mana tumbuhan mengubah energi cahaya matahari menjadi energi kimia (gula) untuk pertumbuhannya. Daun juga berperan penting dalam transpirasi (pelepasan uap air) dan pertukaran gas (karbon dioksida masuk, oksigen keluar) melalui stomata.",
                "Evolusi daun pada tumbuhan merupakan tonggak penting dalam sejarah kehidupan di Bumi, memungkinkan tumbuhan untuk menjajah daratan dan berkembang biak secara luas. Daun paling awal diperkirakan muncul pada tumbuhan primitif sekitar 400 juta tahun yang lalu. Seiring waktu, daun berevolusi menjadi berbagai bentuk dan ukuran, menyesuaikan diri dengan lingkungan yang berbeda-beda, dari daun jarum pinus yang tahan kekeringan hingga daun lebar pada tumbuhan tropis yang memaksimalkan penyerapan cahaya. Fotosintesis, yang dilakukan di kloroplas dalam sel-sel daun, adalah proses biokimia fundamental yang menjadi dasar hampir semua rantai makanan di Bumi.",
                "Struktur daun sangat bervariasi tetapi umumnya terdiri dari lamina (helaian daun), tangkai daun (petiole), dan kadang-kadang pelepah daun (sheath). Warna hijau daun berasal dari pigmen klorofil, yang esensial untuk fotosintesis. **Fotosintesis** adalah proses kompleks yang menggunakan cahaya matahari, air (diserap akar), dan karbon dioksida (diserap dari udara) untuk menghasilkan glukosa (energi) dan oksigen sebagai produk sampingan. **Bentuk dan ukuran daun** dapat menjadi indikator adaptasi tumbuhan terhadap lingkungannya; misalnya, daun berduri untuk mengurangi penguapan atau daun lebar untuk memaksimalkan penyerapan cahaya di hutan lebat. Daun juga dapat dimodifikasi untuk fungsi khusus lainnya, seperti sulur (modifikasi daun untuk memanjat) atau perangkap pada tumbuhan karnivora.",
                titleHistory,
                titleExtra
        ));

        cardGravitasi.setOnClickListener(v -> openDetail(
                R.drawable.gravity, "Gravitasi",
                "Gravitasi adalah salah satu dari empat gaya fundamental di alam semesta, yang bertanggung jawab atas tarik-menarik antara benda-benda yang memiliki massa. Ini adalah gaya yang membuat apel jatuh dari pohon, menjaga planet-planet tetap pada orbitnya mengelilingi bintang, dan membentuk struktur galaksi. Gravitasi adalah gaya yang lemah dalam skala kecil, tetapi menjadi dominan dalam skala kosmik karena jangkauannya tak terbatas dan selalu menarik.",
                "Pemahaman modern tentang gravitasi sebagian besar bermula dari Sir Isaac Newton, yang pada abad ke-17 merumuskan **Hukum Gravitasi Universal**. Ia menyatakan bahwa setiap dua massa di alam semesta saling menarik dengan gaya yang sebanding dengan produk massa mereka dan berbanding terbalik dengan kuadrat jarak di antara pusat mereka. Kemudian, pada awal abad ke-20, Albert Einstein merevolusi pemahaman kita dengan **Teori Relativitas Umum**. Einstein menjelaskan gravitasi bukan sebagai gaya, melainkan sebagai kelengkungan ruang-waktu yang disebabkan oleh massa dan energi. Benda-benda bergerak di sepanjang 'jalur' yang ditentukan oleh kelengkungan ini, itulah mengapa mereka tampak 'ditarik' ke arah massa lain.",
                "Dampak gravitasi terlihat di mana-mana di alam semesta. Di Tata Surya kita, gravitasi Matahari menjaga Bumi dan planet-planet lain tetap di orbitnya. Gravitasi juga bertanggung jawab atas pasang surut air laut yang disebabkan oleh tarikan gravitasi Bulan dan Matahari. Dalam skala yang lebih besar, gravitasi menyebabkan bintang-bintang dan galaksi-galaksi terbentuk dari awan gas dan debu raksasa, dan bahkan memengaruhi cara galaksi-galaksi berkelompok membentuk gugus dan supergugus. Para ilmuwan modern terus meneliti gravitasi, termasuk mencari 'graviton' (partikel hipotetis pembawa gaya gravitasi) dan mempelajari gelombang gravitasi, riak dalam ruang-waktu yang baru-baru ini terdeteksi, yang membuka jendela baru untuk memahami alam semesta.",
                titleHistory,
                titleExtra
        ));

        cardOksigen.setOnClickListener(v -> openDetail(
                R.drawable.oxygen, "Oksigen (O₂)",
                "Oksigen adalah unsur kimia yang paling melimpah ketiga di alam semesta dan merupakan gas yang tidak berwarna, tidak berbau, dan tidak berasa. Dalam bentuk diatomik (O₂), ia sangat penting bagi sebagian besar bentuk kehidupan di Bumi karena perannya dalam proses respirasi seluler, di mana organisme menggunakan oksigen untuk mengubah makanan menjadi energi. Oksigen juga merupakan komponen kunci dalam pembakaran dan korosi.",
                "Oksigen ditemukan secara independen oleh dua ilmuwan pada abad ke-18. Carl Wilhelm Scheele, seorang apoteker Swedia, menemukan oksigen sekitar tahun 1772, tetapi penemuannya tidak diterbitkan sampai setelah penemuan Joseph Priestley, seorang kimiawan dan filsuf Inggris, yang menemukan oksigen pada tahun 1774. Priestley menamakannya 'dephlogisticated air'. Antoine Lavoisier, seorang kimiawan Prancis, kemudian mengakui oksigen sebagai unsur kimia dan memberikan nama 'oxygène' (pembentuk asam) pada tahun 1777-1778, menjelaskan perannya dalam pembakaran. Atmosfer Bumi awalnya tidak memiliki oksigen bebas; sebagian besar oksigen atmosfer diproduksi selama milyaran tahun oleh organisme fotosintetik, sebuah peristiwa yang dikenal sebagai 'Oksigenasi Besar'.",
                "Oksigen merupakan sekitar 21% dari atmosfer Bumi dan merupakan unsur yang sangat reaktif, membentuk senyawa dengan hampir semua unsur lainnya. Selain perannya dalam respirasi, oksigen juga vital dalam **pembakaran** (reaksi kimia yang melibatkan oksigen dan menghasilkan panas serta cahaya). **Lapisan ozon (O₃)** di stratosfer, yang terbentuk dari molekul oksigen, sangat penting karena melindungi Bumi dari radiasi ultraviolet berbahaya dari Matahari. Dalam industri, oksigen digunakan dalam pengelasan, produksi baja, dan aplikasi medis untuk membantu pernapasan. Konsentrasi oksigen yang tepat di atmosfer sangat penting untuk menjaga keseimbangan ekosistem dan kehidupan di planet kita.",
                titleHistory,
                titleExtra
        ));

        cardGalaksi.setOnClickListener(v -> openDetail(
                R.drawable.milkyway, "Galaksi Bima Sakti",
                "Galaksi Bima Sakti adalah galaksi spiral berbatang raksasa tempat Tata Surya kita, termasuk Bumi dan Matahari, berada. Dari Bumi, Bima Sakti terlihat sebagai pita cahaya redup di langit malam karena banyaknya bintang yang tidak dapat dipisahkan secara individual oleh mata telanjang. Galaksi ini adalah 'rumah' bagi ratusan miliar bintang, sejumlah besar awan gas dan debu, serta materi gelap misterius, yang semuanya berputar mengelilingi pusat galaksi.",
                "Nama 'Bima Sakti' berasal dari bahasa Sanskerta yang berarti 'jalur susu', mengacu pada penampilannya yang seperti pita susu yang terbentang di langit malam. Orang Yunani kuno menyebutnya 'Galaxias Kyklos' (lingkaran susu). Meskipun manusia telah mengamati Bima Sakti selama ribuan tahun, pemahaman kita tentang strukturnya baru berkembang setelah penemuan teleskop. Galileo Galilei adalah salah satu yang pertama mengamati bahwa Bima Sakti terdiri dari bintang-bintang individu. Pada awal abad ke-20, Edwin Hubble membuktikan bahwa Bima Sakti hanyalah salah satu dari miliaran galaksi di alam semesta, bukan satu-satunya galaksi seperti yang diyakini sebelumnya.",
                "Bima Sakti memiliki diameter sekitar 100.000 hingga 180.000 tahun cahaya dan tebal sekitar 1.000 tahun cahaya. Diperkirakan mengandung antara 100 hingga 400 miliar bintang. Matahari kita terletak sekitar 27.000 tahun cahaya dari pusat galaksi, di salah satu lengan spiral yang disebut Lengan Orion. Di pusat Bima Sakti terdapat lubang hitam supermasif yang disebut Sagitarius A*. Bima Sakti adalah bagian dari Gugus Lokal, sekelompok galaksi yang lebih kecil, dan sedang dalam jalur tabrakan dengan galaksi Andromeda yang lebih besar, yang diperkirakan akan terjadi dalam sekitar 4,5 miliar tahun. Studi tentang Bima Sakti memberikan wawasan penting tentang bagaimana galaksi terbentuk dan berevolusi di alam semesta.",
                titleHistory,
                titleExtra
        ));

        cardKerangka.setOnClickListener(v -> openDetail(
                R.drawable.kerangka, "Sistem Kerangka Manusia",
                "Sistem kerangka manusia adalah kerangka internal tubuh yang terdiri dari semua tulang, tulang rawan, ligamen, dan tendon. Struktur yang kokoh ini memberikan dukungan dasar bagi tubuh, melindungi organ-organ vital, memungkinkan gerakan melalui sendi, dan berfungsi sebagai tempat penyimpanan mineral penting seperti kalsium dan fosfor. Selain itu, sumsum tulang di dalam tulang adalah tempat produksi sel darah.",
                "Studi tentang kerangka manusia telah dilakukan sejak zaman kuno, dengan para dokter dan filsuf seperti Galen di Yunani kuno memberikan deskripsi awal. Namun, pemahaman yang lebih rinci tentang anatomi kerangka berkembang pesat selama era Renaisans dengan seniman seperti Leonardo da Vinci yang melakukan studi anatomi, dan kemudian dengan perkembangan ilmu kedokteran modern. Pengetahuan tentang tulang dan fungsinya adalah dasar bagi bidang ortopedi dan traumatologi. Evolusi kerangka manusia menunjukkan adaptasi yang luar biasa untuk bipedalisme (berjalan tegak) dan manipulasi objek dengan tangan.",
                "Kerangka manusia dewasa umumnya terdiri dari **206 tulang**. Sistem kerangka dibagi menjadi dua bagian utama: **Kerangka Aksial** (80 tulang), yang membentuk sumbu pusat tubuh dan meliputi tengkorak, tulang belakang, tulang rusuk, dan tulang dada; fungsinya terutama untuk melindungi organ vital. **Kerangka Apendikular** (126 tulang), yang meliputi tulang-tulang anggota gerak (tangan dan kaki) serta gelang bahu dan panggul; fungsinya untuk memungkinkan gerakan. **Sendi** adalah titik di mana dua tulang bertemu, dan mereka memungkinkan berbagai tingkat gerakan. **Ligamen** menghubungkan tulang ke tulang, sementara **tendon** menghubungkan otot ke tulang. Kesehatan tulang sangat dipengaruhi oleh nutrisi (terutama kalsium dan Vitamin D) dan aktivitas fisik. Osteoporosis dan patah tulang adalah beberapa masalah umum yang memengaruhi sistem kerangka.",
                titleHistory,
                titleExtra
        ));

        cardEnergi.setOnClickListener(v -> openDetail(
                R.drawable.energi, "Energi",
                "Energi didefinisikan dalam fisika sebagai kapasitas atau kemampuan untuk melakukan kerja, yaitu untuk menyebabkan perubahan atau gerakan. Ini adalah konsep fundamental dalam sains yang tidak dapat diciptakan atau dimusnahkan, melainkan hanya dapat diubah dari satu bentuk ke bentuk lain. Energi ada di mana-mana di alam semesta dan merupakan pendorong semua fenomena fisik dan biologis.",
                "Konsep energi telah berkembang seiring dengan pemahaman ilmiah. Awalnya, ide tentang 'vis viva' (kekuatan hidup) di abad ke-17 mencoba menjelaskan gerakan. Namun, prinsip **kekekalan energi** (atau Hukum Termodinamika Pertama), yang menyatakan bahwa total energi dalam sistem tertutup tetap konstan, diformulasikan secara formal pada abad ke-19 oleh ilmuwan seperti Julius Robert von Mayer, James Prescott Joule, dan Hermann von Helmholtz. Kemudian, Albert Einstein dengan rumus terkenalnya E=mc² (massa-energi kesetaraan) pada awal abad ke-20 menunjukkan bahwa massa dan energi dapat dipertukarkan, memberikan pemahaman yang lebih mendalam tentang sifat energi.",
                "Energi muncul dalam berbagai bentuk, termasuk: **Energi Kinetik** (energi gerak), **Energi Potensial** (energi yang tersimpan berdasarkan posisi atau keadaan, misalnya gravitasi atau elastis), **Energi Termal/Panas**, **Energi Kimia** (tersimpan dalam ikatan kimia), **Energi Listrik**, **Energi Nuklir** (tersimpan dalam inti atom), dan **Energi Cahaya** (elektromagnetik). Manusia memanfaatkan berbagai sumber energi, dari bahan bakar fosil (minyak bumi, batu bara, gas alam) hingga sumber terbarukan seperti tenaga surya, angin, dan hidro. Transformasi energi dari satu bentuk ke bentuk lain adalah prinsip dasar yang digunakan dalam semua teknologi, mulai dari mesin uap hingga pembangkit listrik modern. Memahami energi adalah kunci untuk memahami alam semesta dan mengembangkan teknologi yang berkelanjutan.",
                titleHistory,
                titleExtra
        ));

        cardDarah.setOnClickListener(v -> openDetail(
                R.drawable.blood, "Darah",
                "Darah adalah cairan jaringan ikat khusus yang mengalir di dalam pembuluh darah seluruh tubuh hewan vertebrata, termasuk manusia. Ia adalah sistem transportasi vital yang bertanggung jawab mengedarkan oksigen dan nutrisi ke seluruh sel dan jaringan, mengangkut produk limbah metabolik untuk dibuang, dan membawa hormon serta antibodi. Darah juga memainkan peran krusial dalam menjaga suhu tubuh, keseimbangan pH, dan melindungi tubuh dari infeksi.",
                "Studi tentang darah dan sirkulasinya telah ada sejak zaman kuno, meskipun pemahaman yang akurat baru muncul di era modern. William Harvey, seorang dokter Inggris, adalah orang pertama yang menjelaskan secara akurat sirkulasi darah di tubuh manusia pada awal abad ke-17. Penemuan golongan darah ABO oleh Karl Landsteiner pada awal abad ke-20 merevolusi transfusi darah, menjadikannya prosedur yang aman dan menyelamatkan banyak nyawa. Ilmu tentang darah disebut hematologi.",
                "Darah terdiri dari beberapa komponen utama: **Plasma** (sekitar 55% dari volume darah) adalah cairan kuning pucat yang sebagian besar terdiri dari air, protein, garam, gula, hormon, dan limbah. **Sel Darah Merah (Eritrosit)**, yang mengandung hemoglobin, bertanggung jawab untuk mengikat dan mengangkut oksigen dari paru-paru ke seluruh tubuh, serta membawa karbon dioksida kembali ke paru-paru. **Sel Darah Putih (Leukosit)** adalah bagian dari sistem kekebalan tubuh, melawan infeksi dan penyakit. **Keping Darah (Trombosit)** berperan penting dalam pembekuan darah untuk menghentikan pendarahan. Jantung adalah pompa yang mendorong darah ke seluruh tubuh melalui sistem pembuluh darah yang kompleks (arteri, vena, kapiler). Golongan darah (A, B, AB, O) dan faktor Rh adalah klasifikasi penting yang harus dipertimbangkan dalam transfusi darah untuk mencegah reaksi imun yang berbahaya.",
                titleHistory,
                titleExtra
        ));

        return view;
    }

    private void openDetail(int imageRes, String title, String description, String history, String extra, String titleHistory, String titleExtra) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("imageRes", imageRes);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("history", history);
        intent.putExtra("extra", extra);
        intent.putExtra("titleHistory", titleHistory);
        intent.putExtra("titleExtra", titleExtra); // Menambahkan titleExtra ke intent
        startActivity(intent);
    }
}