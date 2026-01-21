package com.example.funquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class HistoryFragment extends Fragment {

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        View cardThomas = view.findViewById(R.id.card_thomas_edison);
        View cardWW1 = view.findViewById(R.id.card_perang_dunia_1);
        View cardCleopatra = view.findViewById(R.id.card_cleopatra);
        View cardTembok = view.findViewById(R.id.card_tembok_besar_china);
        View cardRevolusi = view.findViewById(R.id.card_revolusi_industri);
        View cardRomeo = view.findViewById(R.id.card_romeo_juliet);
        View cardProklamasi = view.findViewById(R.id.card_proklamasi_indonesia);
        View cardGeorge = view.findViewById(R.id.card_george_washington);
        View cardColumbus = view.findViewById(R.id.card_christopher_columbus);
        View cardStalin = view.findViewById(R.id.card_joseph_stalin);

        String titleHistory = "Sejarah Singkat";
        String titleExtra = "Tambahan"; // Menambahkan string titleExtra

        cardThomas.setOnClickListener(v -> openDetail(
                R.drawable.thomas,
                "Thomas Edison",
                "Thomas Alva Edison adalah salah satu penemu paling produktif dan berpengaruh dalam sejarah Amerika, dikenal luas atas kontribusinya dalam pengembangan bola lampu pijar praktis dan sistem distribusi listrik. Jeniusnya tidak hanya terletak pada penemuan, tetapi juga pada kemampuan untuk mengkomersialkan inovasinya dan mendirikan laboratorium penelitian industri modern pertama.",
                "Lahir pada tahun 1847, Edison menunjukkan rasa ingin tahu yang besar sejak kecil. Meskipun pendidikan formalnya terbatas, ia adalah seorang otodidak ulung. Karirnya dimulai sebagai operator telegraf, di mana ia melakukan banyak perbaikan pada perangkat telegraf. Pada tahun 1876, ia mendirikan laboratorium penelitian terkenalnya di Menlo Park, New Jersey, tempat ia dan timnya menciptakan ribuan penemuan. Penemuan terbesar Edison adalah pengembangan bola lampu pijar filamen karbon yang tahan lama dan ekonomis pada tahun 1879, serta sistem pembangkit dan distribusi listrik yang memungkinkan penggunaan listrik secara massal. Ia juga mendirikan General Electric, salah satu perusahaan terbesar di dunia.",
                "Edison memegang rekor dengan lebih dari 1.093 paten AS atas namanya, mencakup berbagai bidang dari telegraf, fonograf (alat perekam dan pemutar suara pertama), kamera gambar bergerak (kinetoskop), hingga baterai alkaline. Ia adalah seorang visioner yang percaya pada kerja keras dan ketekunan, yang terkenal dengan kutipannya: 'Genius is 1% inspiration and 99% perspiration.' Warisannya tidak hanya pada penemuan-penemuannya, tetapi juga pada model laboratorium penelitian dan pengembangan yang menjadi dasar inovasi di era modern.",
                titleHistory,
                titleExtra
        ));

        cardWW1.setOnClickListener(v -> openDetail(
                R.drawable.ww1,
                "Perang Dunia I",
                "Perang Dunia I, atau dikenal juga sebagai Perang Besar (The Great War), adalah konflik global pertama yang mengubah peta geopolitik dunia secara drastis. Konflik ini melibatkan sebagian besar kekuatan besar dunia yang terbagi menjadi dua aliansi yang saling berhadapan: Blok Sekutu (terutama Inggris Raya, Prancis, Rusia, Italia, Jepang, dan Amerika Serikat) dan Blok Sentral (terutama Jerman, Austria-Hongaria, Kesultanan Utsmaniyah, dan Bulgaria). Perang ini dicirikan oleh parit-parit yang panjang, penggunaan teknologi baru yang mematikan, dan jumlah korban jiwa yang belum pernah terjadi sebelumnya.",
                "Perang Dunia I pecah pada musim panas 1914, dipicu oleh pembunuhan Archduke Franz Ferdinand dari Austria-Hongaria di Sarajevo oleh seorang nasionalis Serbia. Namun, akar konflik jauh lebih dalam, melibatkan ketegangan imperialisme, militerisme, aliansi kompleks, dan nasionalisme yang membara di Eropa. Setelah deklarasi perang berantai, konflik dengan cepat meluas ke seluruh benua dan koloni-koloni di seluruh dunia. Perang ini berlangsung selama empat tahun lebih, berakhir dengan gencatan senjata pada 11 November 1918. Meskipun Amerika Serikat baru terlibat secara signifikan pada tahun 1917, intervensi mereka menjadi penentu.",
                "Dampak Perang Dunia I sangat luas dan mengubah tatanan dunia. Jutaan prajurit dan warga sipil tewas, dan banyak negara mengalami kehancuran ekonomi. Perang ini menyebabkan runtuhnya empat kekaisaran besar: Austria-Hongaria, Rusia, Utsmaniyah, dan Jerman. Perjanjian Versailles yang keras terhadap Jerman dianggap sebagai salah satu faktor pemicu Perang Dunia II. Liga Bangsa-Bangsa didirikan sebagai upaya untuk mencegah konflik di masa depan, meskipun akhirnya gagal. Perang ini juga mempercepat perkembangan teknologi militer seperti tank, pesawat terbang, senjata kimia, dan kapal selam, serta secara fundamental mengubah cara peperangan modern dilakukan.",
                titleHistory,
                titleExtra
        ));

        cardCleopatra.setOnClickListener(v -> openDetail(
                R.drawable.cleopatra,
                "Cleopatra VII Philopator",
                "Cleopatra VII Philopator adalah firaun terakhir Mesir Kuno dari dinasti Ptolemaik, yang memerintah dari tahun 51 hingga 30 SM. Ia adalah salah satu tokoh wanita paling ikonik dalam sejarah, dikenal tidak hanya karena kecantikan dan karismanya, tetapi juga karena kecerdasannya, kemampuan linguistik, dan keahlian politik yang luar biasa. Ia berusaha keras untuk mempertahankan kemerdekaan Mesir di tengah dominasi Kekaisaran Romawi yang terus berkembang.",
                "Cleopatra lahir pada tahun 69 SM di Alexandria, Mesir, dari keluarga dinasti Ptolemaik yang berdarah Yunani Makedonia, yang telah memerintah Mesir selama hampir tiga abad setelah kematian Aleksander Agung. Ia naik takhta bersama ayahnya, Ptolemy XII, dan kemudian bersama adik-adiknya, Ptolemy XIII dan Ptolemy XIV. Untuk mengamankan kekuasaannya dan melindungi Mesir, Cleopatra menjalin aliansi politik dan pribadi yang terkenal dengan dua jenderal Romawi paling kuat saat itu: Julius Caesar dan kemudian Mark Antony. Hubungannya dengan Caesar membantunya mengamankan posisinya sebagai ratu. Setelah pembunuhan Caesar, ia bersekutu dengan Mark Antony, yang memicu konflik dengan Octavian (kemudian Augustus), pewaris Caesar. Kekalahan Antony dan Cleopatra dalam Pertempuran Actium pada 31 SM, dan kemudian invasi Romawi ke Mesir, mengakhiri kekuasaannya.",
                "Cleopatra adalah sosok yang sangat terpelajar, mampu berbicara setidaknya sembilan bahasa. Ia bukan hanya seorang pemimpin politik yang cakap, tetapi juga simbol kekuatan wanita di dunia kuno yang didominasi pria. Kisah hidupnya, termasuk hubungan romantisnya yang dramatis dengan Caesar dan Antony, telah menginspirasi banyak karya seni, sastra, dan drama, termasuk tragedi terkenal William Shakespeare, 'Antony and Cleopatra'. Kematiannya pada tahun 30 SM, yang diyakini karena bunuh diri melalui gigitan ular berbisa, menandai akhir dari era independen Mesir Kuno dan menjadikannya provinsi Romawi.",
                titleHistory,
                titleExtra
        ));

        cardTembok.setOnClickListener(v -> openDetail(
                R.drawable.greatwall,
                "Tembok Besar China",
                "Tembok Besar China adalah serangkaian benteng kuno yang dibangun di sepanjang batas utara Tiongkok untuk melindungi kekaisaran dari invasi berbagai suku nomaden dari stepa Eurasia, terutama Bangsa Mongol. Ini adalah salah satu proyek konstruksi terbesar dan paling ambisius dalam sejarah manusia, membentang ribuan kilometer melintasi pegunungan, gurun, dan dataran.",
                "Pembangunan Tembok Besar sebenarnya merupakan serangkaian tembok yang dibangun oleh berbagai dinasti Tiongkok selama ribuan tahun, bukan satu proyek tunggal. Pembangunan paling awal dimulai sejak abad ke-7 SM, tetapi upaya pembangunan skala besar yang paling terkenal dilakukan oleh Kaisar Qin Shi Huang (Dinasti Qin) pada abad ke-3 SM. Ia menghubungkan dan memperkuat bagian-bagian tembok yang sudah ada. Namun, sebagian besar struktur tembok yang kita lihat hari ini dibangun pada masa Dinasti Ming (1368-1644 M), yang dikenal dengan konstruksi batu bata dan menara pengawasnya yang kokoh. Tembok ini berfungsi sebagai sistem pertahanan, pos perbatasan, dan jalur perdagangan.",
                "Panjang total Tembok Besar China, termasuk semua cabangnya, diukur lebih dari 21.196 kilometer (sekitar 13.171 mil), menjadikannya struktur buatan manusia terpanjang di dunia. Meskipun sering ada mitos bahwa tembok ini bisa terlihat dari bulan, hal itu tidak benar tanpa bantuan teleskop. Tembok Besar China ditetapkan sebagai Situs Warisan Dunia UNESCO pada tahun 1987 dan merupakan salah satu ikon budaya dan sejarah Tiongkok yang paling dikenal di dunia, menarik jutaan wisatawan setiap tahunnya. Ini adalah bukti monumental dari rekayasa kuno, ketahanan, dan upaya kolosal yang dilakukan oleh peradaban Tiongkok untuk melindungi wilayahnya.",
                titleHistory,
                titleExtra
        ));

        cardRevolusi.setOnClickListener(v -> openDetail(
                R.drawable.insdutri,
                "Revolusi Industri",
                "Revolusi Industri adalah periode transformatif yang dimulai pada akhir abad ke-18, ditandai oleh perubahan fundamental dalam produksi, teknologi, dan organisasi sosial-ekonomi. Pergeseran dari ekonomi agraris dan berbasis kerajinan tangan ke ekonomi industri dan manufaktur massal ini membawa dampak yang sangat besar pada setiap aspek kehidupan manusia, membentuk dasar dunia modern yang kita kenal sekarang.",
                "Revolusi Industri pertama kali dimulai di Inggris sekitar tahun 1760-an. Beberapa faktor kunci berkontribusi pada kemunculannya di Inggris: ketersediaan sumber daya alam seperti batu bara dan bijih besi, kemajuan pertanian yang menghasilkan surplus tenaga kerja, sistem perbankan dan perdagangan yang mapan, serta inovasi teknologi yang pesat. Penemuan mesin uap oleh James Watt, mesin pemintal 'Spinning Jenny' oleh James Hargreaves, dan 'Power Loom' oleh Edmund Cartwright merevolusi industri tekstil dan memungkinkan produksi massal. Pembangunan rel kereta api dan lokomotif oleh George Stephenson juga merevolusi transportasi dan perdagangan, memungkinkan barang dan orang bergerak lebih cepat dan efisien.",
                "Dampak Revolusi Industri sangat luas: **Urbanisasi** besar-besaran terjadi karena orang-orang berbondong-bondong pindah ke kota untuk mencari pekerjaan di pabrik. **Kelas sosial baru** muncul, yaitu kelas buruh industri (proletariat) dan kelas pemilik pabrik (borjuis). **Kondisi kerja** di pabrik seringkali keras dan tidak manusiawi, memicu gerakan-gerakan buruh dan reformasi sosial. **Perkembangan teknologi** terus berlanjut, memicu Revolusi Industri Kedua pada akhir abad ke-19 (listrik, baja, kimia) dan seterusnya. Revolusi Industri secara fundamental mengubah lanskap global, meningkatkan produksi barang secara eksponensial, menciptakan kemakmuran bagi sebagian kalangan, tetapi juga menimbulkan masalah sosial yang kompleks yang masih relevan hingga saat ini.",
                titleHistory,
                titleExtra
        ));

        cardRomeo.setOnClickListener(v -> openDetail(
                R.drawable.romeo,
                "Romeo dan Juliet",
                "Romeo dan Juliet adalah salah satu tragedi paling terkenal dan abadi karya dramawan Inggris legendaris, William Shakespeare. Kisah ini menceritakan tentang cinta yang terlarang antara dua pemuda dari keluarga yang berseteru di Verona, Italia. Meskipun mereka berasal dari latar belakang yang berlawanan dan penuh permusuhan, cinta mereka mekar dengan cepat dan kuat, namun takdir tragis menanti mereka akibat konflik keluarga dan serangkaian kesalahpahaman.",
                "William Shakespeare menulis 'Romeo dan Juliet' pada akhir abad ke-16, kemungkinan sekitar tahun 1597. Meskipun kisah tentang sepasang kekasih yang bernasib tragis sudah ada dalam literatur jauh sebelum Shakespeare, ia adalah orang yang memberinya bentuk definitif dan keabadian. Sumber inspirasi utama Shakespeare mungkin adalah puisi naratif Arthur Brooke 'The Tragical History of Romeus and Juliet' (1562). Shakespeare mengangkat tema-tema universal seperti cinta, takdir, konflik, dan kematian, menjadikannya relevan sepanjang masa. Drama ini pertama kali dipentaskan di The Globe Theatre dan langsung menjadi populer di kalangan penonton.",
                "Romeo dan Juliet telah menjadi **simbol universal cinta abadi dan tragis**. Pengaruhnya sangat besar terhadap sastra, seni, musik, dan budaya populer di seluruh dunia. Frasa dan kutipan dari drama ini seperti 'What's in a name?' atau 'A plague o' both your houses!' telah meresap ke dalam bahasa sehari-hari. Kisah ini telah diadaptasi berkali-kali menjadi opera, balet, film, dan musikal. Pesan moralnya sering diinterpretasikan sebagai peringatan terhadap bahaya kebencian dan prasangka yang buta. Meskipun berakhir dengan kematian kedua kekasih, kisah mereka tetap menjadi pengingat kuat akan kekuatan cinta dan konsekuensi dari permusuhan yang tak berujung.",
                titleHistory,
                titleExtra
        ));

        cardProklamasi.setOnClickListener(v -> openDetail(
                R.drawable.proklamasi,
                "Proklamasi Kemerdekaan Indonesia",
                "Proklamasi Kemerdekaan Republik Indonesia pada tanggal 17 Agustus 1945 adalah momen paling monumental dalam sejarah bangsa Indonesia. Peristiwa ini secara resmi menandai berakhirnya penjajahan asing yang telah berlangsung selama berabad-abad dan dimulainya era baru sebagai negara merdeka dan berdaulat. Pembacaan teks proklamasi oleh Soekarno menjadi deklarasi yang menggema bagi seluruh rakyat Indonesia dan dunia.",
                "Kemerdekaan Indonesia tidak datang begitu saja. Setelah Jepang menyerah kepada Sekutu pada 15 Agustus 1945, terjadi kekosongan kekuasaan di Indonesia. Golongan muda mendesak Soekarno dan Hatta untuk segera memproklamasikan kemerdekaan, memicu peristiwa Rengasdengklok pada 16 Agustus 1945. Akhirnya, pada dini hari 17 Agustus 1945, di kediaman Soekarno di Jalan Pegangsaan Timur No. 56, Jakarta, perumusan naskah proklamasi dilakukan. Pada pukul 10.00 WIB, Soekarno didampingi Mohammad Hatta, membacakan teks proklamasi kemerdekaan di hadapan rakyat dan tokoh-tokoh penting. Bendera Merah Putih dikibarkan dan lagu 'Indonesia Raya' dikumandangkan, menandai lahirnya Negara Kesatuan Republik Indonesia.",
                "Proklamasi ini bukan akhir dari perjuangan, melainkan awal dari perang mempertahankan kemerdekaan melawan upaya Belanda untuk kembali berkuasa. Peristiwa ini memicu semangat perjuangan rakyat di seluruh pelosok negeri. Setiap tanggal 17 Agustus diperingati sebagai Hari Kemerdekaan Republik Indonesia, sebuah hari libur nasional yang dirayakan dengan upacara bendera, perlombaan, dan berbagai acara kebudayaan. Teks Proklamasi sendiri adalah dokumen singkat namun penuh makna, yang menjadi landasan dan inspirasi bagi pembentukan dasar negara Pancasila dan Undang-Undang Dasar 1945. Ini adalah tonggak sejarah yang mengukuhkan identitas dan kedaulatan bangsa Indonesia di mata dunia.",
                titleHistory,
                titleExtra
        ));

        cardGeorge.setOnClickListener(v -> openDetail(
                R.drawable.george,
                "George Washington",
                "George Washington adalah salah satu figur paling krusial dalam sejarah Amerika Serikat, dikenal sebagai 'Bapak Bangsa' dan merupakan Presiden pertama Amerika Serikat. Perannya dalam memimpin koloni-koloni Amerika menuju kemerdekaan dari Inggris dan kemudian membentuk dasar pemerintahan republik yang stabil menjadikannya tokoh yang tak tergantikan dalam narasi pendirian Amerika.",
                "Lahir pada tahun 1732 di Virginia, George Washington tumbuh sebagai seorang surveyor dan perwira militer yang dihormati. Pengalamannya dalam Perang Tujuh Tahun (Perang Prancis dan Indian) memberinya pengalaman militer yang berharga. Ketika ketegangan dengan Inggris meningkat, Washington menjadi suara penting dalam perlawanan koloni. Pada tahun 1775, ia ditunjuk sebagai Panglima Tertinggi Angkatan Kontinental, memimpin pasukan kolonial yang kurang terlatih dan kurang lengkap melawan kekuatan militer Inggris yang jauh lebih unggul. Kemenangan di Yorktown pada tahun 1781 secara efektif mengakhiri Perang Revolusi. Setelah perang, Washington memimpin Konvensi Konstitusi 1787, yang merancang Konstitusi AS. Pada tahun 1789, ia terpilih sebagai Presiden pertama Amerika Serikat, menjabat selama dua periode hingga 1797.",
                "Sebagai Presiden, Washington menetapkan banyak preseden penting yang membentuk kepresidenan Amerika Serikat. Ia memprioritaskan persatuan nasional, menegakkan Konstitusi, dan menolak godaan kekuasaan monarki. Pidato perpisahannya memperingatkan terhadap perpecahan partisan dan keterlibatan berlebihan dalam urusan luar negeri. Washington meninggal pada tahun 1799, meninggalkan warisan sebagai pemimpin yang bijaksana, berintegritas, dan berdedikasi pada prinsip-prinsip republik. Wajahnya diabadikan di uang kertas satu dolar dan di Mount Rushmore, melambangkan fondasi bangsa Amerika. Kisah hidupnya dan kepemimpinannya terus menjadi inspirasi bagi banyak orang di Amerika dan seluruh dunia.",
                titleHistory,
                titleExtra
        ));

        cardColumbus.setOnClickListener(v -> openDetail(
                R.drawable.colombus,
                "Christopher Columbus",
                "Christopher Columbus adalah seorang penjelajah dan navigator Italia yang terkenal karena pelayaran-pelayaran trans-Atlantiknya yang membuka jalan bagi kontak luas antara Dunia Lama (Eropa, Asia, Afrika) dan Dunia Baru (Amerika). Meskipun ia bukan orang Eropa pertama yang mencapai Amerika, perjalanannya pada akhir abad ke-15 memiliki dampak monumental dalam sejarah dunia, memicu era eksplorasi, kolonisasi, dan perdagangan yang mengubah lanskap global secara permanen.",
                "Lahir di Genoa, Italia, pada tahun 1451, Christopher Columbus adalah seorang pelaut ulung sejak muda. Ia terinspirasi oleh gagasan untuk mencapai Asia dengan berlayar ke barat, percaya bahwa bumi itu bulat dan jaraknya lebih pendek dari yang diyakini umum. Setelah proposalnya ditolak oleh beberapa monarki Eropa, akhirnya Ratu Isabella I dan Raja Ferdinand II dari Spanyol menyetujui dan mendanai ekspedisinya. Pada 3 Agustus 1492, Columbus berlayar dari Palos de la Frontera, Spanyol, dengan tiga kapal: Santa María, Pinta, dan Niña. Pada 12 Oktober 1492, ia mendarat di Bahama (yang ia sebut San Salvador), percaya bahwa ia telah mencapai Hindia Timur. Ia melakukan total empat perjalanan ke Karibia dan Amerika Selatan, mendirikan pemukiman Eropa pertama di Dunia Baru.",
                "Pelayaran Columbus memiliki **dampak yang sangat kompleks dan kontroversial**. Di satu sisi, penemuannya membuka 'Pertukaran Kolumbian' (Columbian Exchange) yang melibatkan pertukaran besar-besaran tanaman, hewan, budaya, dan teknologi antara Dunia Lama dan Baru. Ini juga memicu gelombang eksplorasi dan kolonisasi Eropa yang membentuk sebagian besar peta dunia modern. Namun, di sisi lain, kedatangan Columbus juga membawa penderitaan besar bagi penduduk asli Amerika, termasuk penyakit yang mematikan, perbudakan, dan penindasan yang menghancurkan budaya mereka. Warisannya tetap menjadi subjek perdebatan sengit tentang etika kolonialisme dan interpretasi sejarah. Terlepas dari kontroversinya, perjalanan Columbus tetap menjadi titik balik penting yang mengubah arah sejarah dunia secara fundamental.",
                titleHistory,
                titleExtra
        ));

        cardStalin.setOnClickListener(v -> openDetail(
                R.drawable.stalin,
                "Joseph Stalin",
                "Joseph Vissarionovich Stalin adalah seorang diktator brutal yang memimpin Uni Soviet dari pertengahan 1920-an hingga kematiannya pada tahun 1953. Selama masa kepemimpinannya, ia mengubah Uni Soviet dari masyarakat agraris menjadi kekuatan industri dan militer global, tetapi dengan biaya yang sangat besar berupa jutaan nyawa manusia, melalui kebijakan-kebijakan yang kejam dan represi politik masif. Ia adalah salah satu tokoh paling kontroversial dan kejam dalam sejarah abad ke-20.",
                "Lahir pada tahun 1878 di Georgia (saat itu bagian dari Kekaisaran Rusia), Joseph Dzhugashvili (nama lahirnya) awalnya mengikuti pendidikan seminari sebelum terlibat dalam gerakan revolusioner Bolshevik. Ia mengambil nama 'Stalin' yang berarti 'manusia baja'. Setelah Revolusi Rusia tahun 1917 dan kematian Vladimir Lenin pada tahun 1924, Stalin secara bertahap mengkonsolidasikan kekuasaannya, menyingkirkan lawan-lawan politiknya melalui intrik dan kekerasan. Pada akhir 1920-an, ia telah menjadi pemimpin tak terbantahkan Uni Soviet. Kebijakannya yang paling terkenal adalah 'Lima Tahun Pertama' yang ambisius untuk industrialisasi cepat dan 'kolektivisasi' pertanian, yang secara paksa menyita tanah dari petani dan menyebabkan kelaparan besar-besaran (Holodomor di Ukraina). Ia juga memimpin Uni Soviet selama Perang Dunia II, memainkan peran kunci dalam kemenangan Sekutu atas Nazi Jerman.",
                "Era Stalin dicirikan oleh **kultus individu** yang ekstrem, **pembersihan politik (Great Purge)** yang menewaskan jutaan orang yang dituduh musuh negara, dan **sistem kamp kerja paksa (Gulag)** yang brutal. Diperkirakan puluhan juta orang tewas di bawah rezimnya akibat eksekusi, kelaparan, dan kerja paksa. Meskipun ia berhasil memodernisasi Uni Soviet dan menjadi pemenang kunci dalam Perang Dunia II, warisan Stalin adalah salah satu teror, represi, dan pelanggaran hak asasi manusia skala besar. Kematiannya pada tahun 1953 memicu periode 'de-Stalinisasi', namun dampaknya terhadap masyarakat Rusia dan dunia masih terasa hingga saat ini, menjadikannya peringatan mengerikan tentang bahaya totalitarianisme.",
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
