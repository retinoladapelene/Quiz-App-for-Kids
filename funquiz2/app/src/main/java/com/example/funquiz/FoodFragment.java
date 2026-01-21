package com.example.funquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food, container, false);

        // Inisialisasi semua CardView makanan
        View cardPasta = view.findViewById(R.id.cardPasta);
        View cardSushi = view.findViewById(R.id.cardSushi);
        View cardGuacamole = view.findViewById(R.id.cardGuacamole);
        View cardRotiPipih = view.findViewById(R.id.cardRotiPipih);
        View cardCokelat = view.findViewById(R.id.cardCokelat);
        View cardPizza = view.findViewById(R.id.cardPizza);
        View cardBumbu = view.findViewById(R.id.cardBumbu);
        View cardTeh = view.findViewById(R.id.cardTeh);
        View cardKentang = view.findViewById(R.id.cardKentang);
        View cardCremeBrulee = view.findViewById(R.id.cardCremeBrulee);

        String titleHistory = "Sejarah Makanan";
        String titleExtra = "Bahan dan Resep Masakan"; // Mengubah titleExtra

        // Pasta - Italia
        cardPasta.setOnClickListener(v -> openDetail(
                R.drawable.pasta,
                "Pasta - Italia",
                "Pasta adalah hidangan pokok yang ikonik dari Italia, terbuat dari adonan tepung gandum durum yang dicampur dengan air atau telur, kemudian dibentuk menjadi berbagai ukuran dan bentuk. Dari spaghetti yang panjang, penne yang berbentuk tabung, hingga fusilli yang spiral dan lasagna yang berlapis, pasta menawarkan tekstur kenyal yang khas. Hidangan ini sangat serbaguna dan menjadi dasar untuk berbagai saus, mulai dari saus tomat sederhana hingga saus krim yang kaya, menjadikannya favorit di seluruh dunia.",
                "Sejarah pasta memiliki akar yang panjang dan kompleks. Meskipun ada mitos populer bahwa Marco Polo membawanya dari Tiongkok pada abad ke-13, bukti arkeologi menunjukkan bahwa bentuk mi atau adonan berbasis gandum sudah ada di Italia sejak zaman Romawi Kuno. Seiring waktu, pasta berevolusi menjadi berbagai bentuk yang kita kenal sekarang. Industrialisasi pada abad ke-19, terutama di Napoli, memungkinkan produksi pasta kering secara massal, menjadikannya makanan pokok yang terjangkau bagi semua lapisan masyarakat Italia. Migrasi besar-besaran Italia ke berbagai belahan dunia pada abad ke-19 dan ke-20 turut mempopulerkan pasta secara global.",
                "**Bahan Dasar Pasta:** Tepung semolina (dari gandum durum), air, dan kadang telur (untuk pasta segar).\n\n**Resep Dasar Spaghetti Aglio e Olio:**\n1. Rebus 200g spaghetti hingga al dente (sekitar 8-10 menit) dalam air mendidih yang diberi 1 sdt garam. Sisakan sedikit air rebusan pasta.\n2. Di wajan terpisah, tumis 3 siung bawang putih cincang dan 1 buah cabai rawit merah iris (opsional) dengan 2 sdm minyak zaitun hingga harum.\n3. Masukkan spaghetti yang sudah ditiriskan ke dalam wajan. Tambahkan sedikit air rebusan pasta dan aduk rata.\n4. Taburi dengan peterseli cincang (opsional) dan sajikan segera. Tambahkan keju parmesan parut jika suka.",
                titleHistory,
                titleExtra
        ));

        // Sushi - Jepang
        cardSushi.setOnClickListener(v -> openDetail(
                R.drawable.sushi,
                "Sushi - Jepang",
                "Sushi adalah seni kuliner Jepang yang memadukan nasi yang dibumbui cuka dengan beragam bahan segar. Meskipun sering diidentikkan dengan ikan mentah, sushi sebenarnya lebih merujuk pada nasi cuka. Bahan pelengkapnya bisa berupa aneka makanan laut segar (ikan, kerang, udang), sayuran, telur, atau tahu. Ragam bentuknya meliputi nigiri (nasi dengan topping di atasnya), maki (gulungan nasi dengan nori/rumput laut), dan sashimi (irisan ikan mentah tanpa nasi). Rasanya yang segar, tekstur yang lembut, dan presentasi yang artistik membuat sushi menjadi salah satu hidangan Jepang yang paling dicintai di dunia.",
                "Asal-usul sushi dapat dilacak kembali ke Asia Tenggara, di mana metode pengawetan ikan dengan fermentasi dalam nasi (disebut narezushi) digunakan untuk memperpanjang umur simpan ikan. Metode ini kemudian menyebar ke Tiongkok dan akhirnya mencapai Jepang sekitar abad ke-8 Masehi. Di Jepang, proses fermentasi dipersingkat dan nasi mulai ikut dikonsumsi bersama ikan. Bentuk sushi modern seperti nigiri-zushi, yang merupakan sajian cepat saji, berkembang pesat di Edo (sekarang Tokyo) pada awal abad ke-19. Teknik pendinginan modern dan transportasi global memungkinkan sushi menyebar ke luar Jepang, menjadi fenomena kuliner internasional sejak paruh kedua abad ke-20.",
                "**Bahan Dasar Sushi:** Beras sushi Jepang, cuka beras, gula, garam, nori (rumput laut), dan berbagai isian/topping segar.\n\n**Resep Dasar Sushi Maki (Gulungan):**\n1. Cuci bersih 2 cup beras sushi, masak dengan rasio air 1:1, atau sesuai petunjuk kemasan. Dinginkan.\n2. Campurkan 3 sdm cuka beras, 1 sdm gula, dan ½ sdt garam. Aduk hingga gula larut. Tuang ke nasi yang sudah dingin, aduk rata.\n3. Letakkan selembar nori di atas tikar bambu (makisu), sisi kasar menghadap atas. Ratakan nasi di atas nori, sisakan sedikit ruang di ujung.\n4. Tata isian seperti irisan mentimun, alpukat, dan salmon asap di tengah nasi.\n5. Gulung rapat menggunakan makisu. Tekan perlahan dan potong-potong menggunakan pisau basah.\n6. Sajikan dengan wasabi, acar jahe, dan kecap asin.",
                titleHistory,
                titleExtra
        ));

        // Guacamole - Meksiko
        cardGuacamole.setOnClickListener(v -> openDetail(
                R.drawable.guacamole,
                "Guacamole - Meksiko",
                "Guacamole adalah saus atau celupan kental khas Meksiko yang terbuat dari alpukat matang yang dihaluskan, dicampur dengan perasan jeruk nipis atau lemon, tomat cincang, bawang merah atau putih, serta cabai (seperti serrano atau jalapeño) untuk sedikit tendangan pedas. Hidangan ini terkenal dengan teksturnya yang creamy dan rasanya yang segar, asam, gurih, dan sedikit pedas, menjadikannya pendamping sempurna untuk keripik tortilla atau sebagai pelengkap hidangan Meksiko lainnya.",
                "Guacamole memiliki sejarah yang kaya, berasal dari peradaban Aztec di Meksiko Tengah sekitar abad ke-16. Kata 'guacamole' sendiri berasal dari bahasa Nahuatl, bahasa suku Aztec, yaitu 'āhuacamōlli' yang secara harfiah berarti 'saus alpukat'. Alpukat adalah buah suci bagi suku Aztec dan sangat dihargai. Versi asli guacamole mungkin jauh lebih sederhana, hanya alpukat yang dihaluskan dengan sedikit air atau cabai. Ketika bangsa Spanyol tiba di Meksiko, mereka diperkenalkan dengan hidangan ini dan membawanya ke Eropa, meskipun alpukat sendiri baru populer secara luas di luar Meksiko jauh di kemudian hari.",
                "**Bahan Dasar Guacamole:** Alpukat Hass matang, jeruk nipis/lemon, tomat, bawang, cabai.\n\n**Resep Dasar Guacamole:**\n1. Belah 2 buah alpukat Hass matang, buang bijinya, dan keruk dagingnya ke dalam mangkuk. Haluskan dengan garpu, namun sisakan beberapa bagian agar ada tekstur.\n2. Segera tuangkan perasan ½ - 1 buah jeruk nipis/lemon ke alpukat yang sudah dihaluskan untuk mencegah oksidasi.\n3. Tambahkan ¼ cup tomat cincang (buang bijinya), 2 sdm bawang merah cincang halus, dan 1 sdm cabai jalapeño atau serrano cincang (buang bijinya jika tidak suka terlalu pedas).\n4. Bumbui dengan ½ sdt garam dan ¼ sdt lada hitam (opsional). Aduk rata. Jangan terlalu banyak mengaduk agar tidak terlalu encer.\n5. Sajikan segera dengan keripik tortilla, atau sebagai topping taco, burito, atau salad.",
                titleHistory,
                titleExtra
        ));

        // Roti Pipih - India
        cardRotiPipih.setOnClickListener(v -> openDetail(
                R.drawable.rotipipih,
                "Roti Pipih - India",
                "Roti pipih India adalah kategori luas dari berbagai jenis roti tanpa ragi yang menjadi makanan pokok dan pendamping penting di sebagian besar masakan India. Roti ini dibuat dari adonan tepung gandum utuh atau tepung terigu yang dipipihkan dan dimasak di atas wajan panas (tawa) atau di dalam oven tandoor tradisional. Beberapa varian populer termasuk naan (lembut dan kenyal, sering dipanggang tandoor), chapati/roti (tipis, lembut, dimasak di tawa), dan paratha (dilapisi dan sering diisi). Roti pipih India adalah elemen esensial yang digunakan untuk menyendok kari, sayuran, dan hidangan lainnya.",
                "Sejarah roti pipih di anak benua India sangat kuno, diperkirakan sudah ada sejak peradaban Lembah Indus ribuan tahun yang lalu. Pertanian gandum yang melimpah di wilayah tersebut menjadi dasar perkembangan roti pipih sebagai makanan pokok. Bentuk awal roti ini mungkin dimasak di atas batu panas. Selama berabad-abad, berbagai metode dan jenis roti pipih telah berkembang, mencerminkan keragaman regional dan budaya kuliner India. Roti seperti chapati telah menjadi bagian tak terpisahkan dari makanan sehari-hari, sementara naan, yang dipanggang di oven tandoor, menjadi populer setelah kedatangan Kekaisaran Mughal dan kini banyak ditemukan di restoran India di seluruh dunia.",
                "**Bahan Dasar Roti Pipih:** Tepung (gandum utuh/terigu), air, garam, dan kadang sedikit minyak/ghi (mentega cair).\n\n**Resep Dasar Chapati/Roti:**\n1. Dalam mangkuk besar, campurkan 2 cup tepung gandum utuh (atta) dan ½ sdt garam. Perlahan tambahkan sekitar 1 cup air hangat sambil diuleni hingga menjadi adonan yang lembut dan elastis. Sesuaikan jumlah air jika perlu.\n2. Tutup adonan dengan kain lembap dan diamkan selama 30 menit.\n3. Bagi adonan menjadi bola-bola kecil. Taburi sedikit tepung di meja kerja dan giling setiap bola adonan menjadi lingkaran pipih tipis (sekitar 15-20 cm diameter).\n4. Panaskan wajan datar (tawa) di atas api sedang-tinggi. Letakkan roti pipih di atas wajan panas. Masak selama sekitar 30 detik hingga muncul gelembung kecil.\n5. Balik dan masak sisi lainnya selama 30-60 detik hingga matang sempurna dan mengembang. Jika ada api terbuka, Anda bisa memanggangnya sebentar di atas api langsung untuk mengembang lebih baik.\n6. Olesi sedikit ghi atau mentega di atas chapati yang sudah matang dan sajikan hangat.",
                titleHistory,
                titleExtra
        ));

        // Cokelat - Swiss
        cardCokelat.setOnClickListener(v -> openDetail(
                R.drawable.cokelat,
                "Cokelat - Swiss",
                "Cokelat adalah produk olahan dari biji kakao yang telah difermentasi, dikeringkan, dipanggang, dan digiling. Biasanya dicampur dengan gula, susu, dan bahan lainnya untuk menciptakan berbagai varian rasa dan tekstur. Dari cokelat batangan susu yang lembut, cokelat hitam yang pahit, hingga praline yang berisi, cokelat adalah salah satu kudapan paling disukai di seluruh dunia. Swiss, khususnya, telah membangun reputasi global yang tak tertandingi dalam pembuatan cokelat berkualitas tinggi, terutama cokelat susu dan praline.",
                "Sejarah kakao dan cokelat dimulai ribuan tahun yang lalu di Mesoamerika, di mana suku Maya dan Aztec mengonsumsi biji kakao sebagai minuman pahit yang dihargai secara spiritual dan dianggap sebagai 'makanan para dewa'. Kakao tiba di Eropa pada abad ke-16 melalui penjelajah Spanyol, awalnya sebagai minuman pahit. Namun, orang Eropa menambahkan gula dan rempah-rempah, mengubahnya menjadi minuman mewah. Pada abad ke-19, Revolusi Industri memungkinkan produksi cokelat padat. Swiss memainkan peran kunci dalam inovasi cokelat: Daniel Peter menciptakan cokelat susu pertama pada tahun 1875 dengan menggabungkan bubuk kakao dan susu kental, sementara Rodolphe Lindt menemukan proses conching pada tahun 1879 yang menghasilkan cokelat batangan yang halus dan meleleh di mulut. Inovasi-inovasi ini menjadikan Swiss sebagai pemimpin dalam industri cokelat.",
                "**Bahan Dasar Cokelat Batangan:** Massa kakao (pasta dari biji kakao giling), mentega kakao, gula, susu bubuk (untuk cokelat susu), lesitin kedelai (pengemulsi), vanila.\n\n**Resep Dasar Ganache Cokelat (untuk isian/topping):**\n1. Bahan: 200g cokelat hitam berkualitas tinggi (minimal 60% kakao), 200ml whipping cream (krim kental), 1 sdm mentega tawar (opsional).\n2. Cincang cokelat menjadi potongan kecil dan masukkan ke dalam mangkuk tahan panas.\n3. Panaskan whipping cream di panci kecil hingga mulai mendidih di pinggir (jangan sampai mendidih bergolak).\n4. Segera tuangkan krim panas ke atas cokelat cincang. Diamkan selama 5 menit tanpa diaduk.\n5. Aduk perlahan dari tengah ke luar hingga cokelat meleleh sempurna dan campuran menjadi halus dan mengkilap. Masukkan mentega jika digunakan, aduk hingga larut.\n6. Biarkan dingin hingga mencapai konsistensi yang diinginkan untuk isian kue, topping, atau celupan. Jika ingin lebih padat, dinginkan di kulkas.",
                titleHistory,
                titleExtra
        ));

        // Pizza - Italia
        cardPizza.setOnClickListener(v -> openDetail(
                R.drawable.pizza,
                "Pizza - Italia",
                "Pizza adalah hidangan ikonik dari Italia yang terdiri dari adonan roti pipih yang diolesi saus tomat, ditaburi keju mozzarella, dan diberi berbagai topping, kemudian dipanggang dalam oven yang sangat panas. Ciri khas pizza yang otentik adalah bagian pinggirannya yang renyah namun lembut di bagian dalam, serta perpaduan rasa yang sederhana namun lezat. Pizza telah menjadi salah satu makanan paling populer dan dikenal luas di seluruh dunia, dengan variasi yang tak terhingga sesuai selera lokal.",
                "Asal-usul pizza modern yang kita kenal sekarang berakar di Napoli, Italia. Pada abad ke-18 dan ke-19, adonan pipih yang dipanggang dengan topping sederhana adalah makanan jalanan yang populer di kalangan rakyat miskin Napoli. Legenda mengatakan bahwa pizza Margherita diciptakan pada tahun 1889 oleh koki Raffaele Esposito untuk menghormati Ratu Margherita dari Savoy, dengan warna merah (tomat), putih (mozzarella), dan hijau (basil) yang melambangkan bendera Italia. Dari Napoli, popularitas pizza menyebar ke seluruh Italia, dan kemudian ke seluruh dunia berkat imigran Italia, terutama ke Amerika Serikat pada awal abad ke-20. Di AS, pizza mengalami evolusi dan muncul berbagai gaya regional seperti New York-style dan Chicago deep-dish.",
                "**Bahan Dasar Pizza:** Tepung terigu (tinggi protein), air, ragi instan, gula, garam, minyak zaitun. Untuk topping standar: saus tomat (dari tomat San Marzano), keju mozzarella (di fior di latte atau bufala), daun basil segar, minyak zaitun.\n\n**Resep Dasar Pizza Margherita Rumahan:**\n1. **Adonan:** Campurkan 250g tepung terigu protein tinggi dengan 1 sdt ragi instan, ½ sdt gula, dan ½ sdt garam. Tambahkan 150ml air hangat dan 1 sdm minyak zaitun. Uleni hingga kalis dan elastis (sekitar 10-15 menit). Bulatkan adonan, olesi sedikit minyak, tutup, dan diamkan di tempat hangat selama 1-2 jam hingga mengembang dua kali lipat.\n2. **Pembentukan:** Panaskan oven hingga suhu tertinggi (220-250°C) dengan batu pizza atau loyang di dalamnya. Kempiskan adonan, bagi menjadi 1-2 bagian, dan pipihkan secara manual atau dengan rolling pin menjadi lingkaran tipis.\n3. **Topping:** Olesi tipis saus tomat. Taburi keju mozzarella yang sudah diparut atau diiris. Tambahkan beberapa lembar daun basil.\n4. **Panggang:** Pindahkan pizza ke atas batu pizza/loyang panas di oven. Panggang selama 8-15 menit (tergantung oven), hingga pinggiran keemasan dan keju meleleh serta sedikit kecoklatan.\n5. Angkat, beri sedikit gerimis minyak zaitun extra virgin (opsional), dan sajikan hangat.",
                titleHistory,
                titleExtra
        ));

        // Bumbu - Indonesia
        cardBumbu.setOnClickListener(v -> openDetail(
                R.drawable.bumbu,
                "Bumbu - Indonesia",
                "Bumbu adalah inti dari masakan Indonesia, sebuah warisan kuliner yang kaya dan penuh cita rasa. Ini merujuk pada campuran rempah-rempah segar dan kering yang dihaluskan atau diiris, digunakan untuk memberikan aroma, rasa, dan warna pada hidangan. Bumbu Indonesia tidak hanya berperan sebagai penyedap, tetapi juga sebagai bahan pengawet alami dan bahkan memiliki khasiat obat tradisional. Keragaman bumbu mencerminkan kekayaan hayati dan budaya kepulauan Indonesia.",
                "Indonesia telah dikenal sebagai 'Kepulauan Rempah-rempah' sejak zaman kuno, menarik pedagang dari seluruh dunia seperti Tiongkok, India, Timur Tengah, dan Eropa. Rempah-rempah seperti cengkeh, pala, lada, dan kayu manis telah diperdagangkan selama ribuan tahun. Sejarah penggunaan bumbu di Indonesia sangat terkait dengan adaptasi dan inovasi lokal, menciptakan profil rasa yang unik di setiap daerah. Teknik pengolahan bumbu, seperti dihaluskan dengan ulekan atau diiris, serta proses tumis dan sangrai, telah diturunkan secara turun-temurun, menjadi fondasi dari masakan nusantara yang kita kenal sekarang.",
                "**Bahan Dasar Bumbu Dapur Indonesia (Bumbu Dasar Kuning/Bumbu Halus):**\n- Bawang merah\n- Bawang putih\n- Kemiri (sudah disangrai)\n- Kunyit (sudah dibakar sebentar)\n- Jahe\n- Lengkuas\n- Cabai merah (sesuai selera pedas)\n- Merica butiran\n- Ketumbar butiran\n- Garam (secukupnya)\n\n**Resep Dasar Bumbu Halus (untuk Nasi Kuning/Ayam Goreng Kuning):**\n1. Siapkan bahan: 6 siung bawang merah, 4 siung bawang putih, 3 butir kemiri sangrai, 2 cm kunyit bakar, 1 cm jahe, ½ sdt ketumbar butiran, ¼ sdt merica butiran.\n2. Haluskan semua bahan dengan cobek atau blender hingga benar-benar halus. Jika menggunakan blender, tambahkan sedikit minyak atau air agar mudah halus.\n3. Panaskan sedikit minyak di wajan. Tumis bumbu halus hingga harum, matang, dan tidak langu (minyak terpisah dari bumbu). Ini adalah kunci agar masakan tidak cepat basi dan rasanya lebih keluar.\n4. Bumbu dasar ini bisa disimpan di lemari es dan digunakan untuk berbagai hidangan seperti nasi kuning, opor ayam, soto, atau aneka tumisan dengan tambahan bahan aromatik lain seperti serai, daun jeruk, dan daun salam.",
                titleHistory,
                titleExtra
        ));

        cardTeh.setOnClickListener(v -> openDetail(
                R.drawable.teh,
                "Teh - China",
                "Teh adalah minuman aromatik yang disiapkan dengan menyeduh daun kering dari tanaman Camellia sinensis dengan air panas. Ini adalah minuman kedua yang paling banyak dikonsumsi di dunia setelah air putih. Ada berbagai jenis teh yang dihasilkan dari proses pengolahan yang berbeda, seperti teh hijau (tidak teroksidasi), teh hitam (teroksidasi penuh), oolong (teroksidasi sebagian), dan teh putih (paling minim pengolahan). Setiap jenis memiliki profil rasa, aroma, dan manfaat kesehatan yang unik.",
                "Sejarah teh berawal dari Tiongkok, di mana legenda menyebutkan penemuan teh oleh Kaisar Shen Nung pada tahun 2737 SM. Awalnya, teh digunakan sebagai obat, tetapi secara bertahap menjadi minuman populer dan bagian integral dari budaya Tiongkok. Budaya minum teh menyebar ke negara-negara Asia Timur lainnya seperti Jepang dan Korea, seringkali terkait dengan ritual seremonial. Teh tiba di Eropa pada abad ke-17 melalui Jalur Sutra dan jalur laut, dibawa oleh pedagang Belanda. Sejak itu, popularitasnya meledak, terutama di Inggris, yang menjadi salah satu konsumen teh terbesar dan memicu perkebunan teh di koloni-koloni seperti India dan Sri Lanka. Budaya minum teh telah berevolusi menjadi berbagai tradisi di seluruh dunia.",
                "**Bahan Dasar Teh:** Daun kering dari tanaman Camellia sinensis, air.\n\n**Cara Membuat Teh Hijau yang Optimal (Gongfu Cha):**\n1. Pilih teh hijau berkualitas baik. Perbandingan umum adalah 3-5g teh untuk setiap 150-200ml air.\n2. Panaskan air hingga suhu sekitar 75-85°C (jangan mendidih, karena teh hijau peka terhadap air terlalu panas).\n3. Bilas teko atau gaiwan (cangkir teh Tiongkok) dengan air panas untuk memanaskan.\n4. Masukkan daun teh ke dalam teko/gaiwan. Tuangkan sedikit air panas (sekitar 75°C) untuk bilasan pertama. Segera buang air bilasan ini (tujuannya untuk 'membangunkan' daun teh dan membersihkan daunnya).\n5. Tuangkan air panas (75-85°C) lagi ke dalam teko. Seduh selama 30-60 detik untuk seduhan pertama. Untuk seduhan berikutnya, tambahkan waktu seduh sekitar 10-20 detik.\n6. Tuangkan teh ke cangkir dan nikmati. Teh hijau berkualitas dapat diseduh berkali-kali dari daun yang sama, dengan rasa yang berbeda di setiap seduhan.\n**Tips:** Jangan menggunakan air mendidih untuk teh hijau atau putih karena akan membuat rasanya pahit. Untuk teh hitam, suhu air bisa lebih tinggi (90-95°C) dengan waktu seduh 2-3 menit.",
                titleHistory,
                titleExtra
        ));

        cardKentang.setOnClickListener(v -> openDetail(
                R.drawable.kentang,
                "Kentang Goreng - Belgia",
                "Kentang goreng, yang juga dikenal sebagai 'French Fries' di banyak negara, adalah potongan kentang yang digoreng hingga renyah di luar dan lembut di dalam. Hidangan sederhana namun adiktif ini sering disajikan sebagai camilan, hidangan pendamping, atau bagian dari makanan cepat saji. Biasanya ditaburi garam, kentang goreng juga dapat dinikmati dengan berbagai saus seperti saus tomat, mayones, atau bumbu khusus.",
                "Belgia mengklaim asal kentang goreng sejak abad ke-17. Konon, penduduk di wilayah Lembah Meuse di Belgia biasa menggoreng ikan kecil. Ketika sungai membeku di musim dingin dan ikan sulit ditangkap, mereka mulai menggoreng kentang yang dipotong memanjang menyerupai ikan. Hal ini terjadi sekitar akhir abad ke-17. Nama 'French Fries' sendiri kemungkinan muncul selama Perang Dunia I, ketika tentara Amerika yang ditempatkan di Belgia mencicipi hidangan ini. Karena bahasa utama di wilayah Belgia tersebut adalah bahasa Prancis, para tentara mengira itu adalah hidangan Prancis dan menamakannya 'French Fries', nama yang melekat hingga kini.",
                "**Bahan Dasar Kentang Goreng:** Kentang bertepung tinggi (misalnya Russet atau kentang khusus goreng), minyak goreng dalam jumlah banyak, garam.\n\n**Resep Kentang Goreng Renyah (Teknik Goreng Dua Kali):**\n1. **Persiapan Kentang:** Kupas 2-3 buah kentang berukuran sedang. Potong memanjang sekitar 1 cm tebalnya. Rendam potongan kentang dalam air dingin selama minimal 30 menit (atau lebih lama di kulkas) untuk menghilangkan kelebihan pati, yang akan membuat kentang lebih renyah. Tiriskan dan keringkan kentang sepenuhnya dengan handuk bersih—ini sangat penting agar tidak meledak saat digoreng.\n2. **Goreng Pertama (Blanching):** Panaskan minyak goreng dalam wajan besar atau deep fryer hingga suhu sekitar 150°C. Masukkan sebagian kentang (jangan terlalu penuh) dan goreng selama 5-7 menit hingga kentang matang tetapi belum berwarna kecoklatan. Teksturnya akan sedikit lembek. Angkat dan tiriskan di atas tisu dapur. Biarkan dingin sepenuhnya (bisa didinginkan di kulkas selama minimal 30 menit atau beberapa jam).\n3. **Goreng Kedua (Crisping):** Panaskan minyak hingga suhu 180-190°C. Masukkan kentang yang sudah dingin dan goreng lagi selama 3-5 menit hingga berwarna keemasan, renyah, dan matang sempurna. Angkat dan segera tiriskan di atas tisu dapur.\n4. **Penyelesaian:** Segera taburi dengan garam halus selagi panas. Sajikan hangat dengan saus pilihan Anda (saus tomat, mayones, sambal, dll.).",
                titleHistory,
                titleExtra
        ));

        cardCremeBrulee.setOnClickListener(v -> openDetail(
                R.drawable.cremebruele,
                "Crème Brûlée - Perancis",
                "Crème brûlée, yang secara harfiah berarti 'krim yang dibakar' dalam bahasa Prancis, adalah hidangan penutup klasik yang elegan dan mewah. Terdiri dari puding krim vanila yang kaya dan lembut sebagai dasarnya, yang kemudian ditutupi dengan lapisan gula pasir tipis yang dikaramelkan hingga pecah saat disentuh sendok. Kontras tekstur antara krim yang halus dan karamel yang renyah, serta aroma vanila yang khas, menjadikan crème brûlée hidangan penutup yang sangat memuaskan dan populer di restoran-restoran fine dining di seluruh dunia.",
                "Asal-usul pasti crème brûlée masih menjadi perdebatan antara beberapa negara Eropa. Meskipun namanya Prancis, ada klaim serupa dari Inggris (sebagai 'burnt cream' atau 'Cambridge burnt cream') dan Spanyol (sebagai 'Crema Catalana'). Namun, versi modern yang kita kenal sekarang dengan karamelisasi gula di atasnya melalui panas api (obor masak) paling sering dikaitkan dengan tradisi kuliner Prancis, kemungkinan besar sejak abad ke-17 atau ke-18. Hidangan ini menjadi sangat populer di kalangan bangsawan dan kemudian menyebar ke masyarakat luas, mengukuhkan posisinya sebagai salah satu mahakarya patisserie Prancis.",
                "**Bahan Dasar Crème Brûlée:** Kuning telur, gula pasir, heavy cream (krim kental), ekstrak vanila (atau biji vanila), gula pasir tambahan untuk karamelisasi.\n\n**Resep Dasar Crème Brûlée:**\n1. **Persiapan:** Panaskan oven hingga 150°C. Siapkan ramekin (mangkuk keramik kecil tahan panas) dan loyang panggang yang cukup besar untuk menampung ramekin. Didihkan air di teko untuk bain-marie (kukus).\n2. **Krim Vanila:** Dalam panci, panaskan 500ml heavy cream dan ½ sdt ekstrak vanila (atau 1 biji vanila yang dibelah dua dan dikeruk isinya, lalu masukkan kulit dan isinya ke krim) di atas api sedang hingga mulai mendidih di pinggir, namun jangan sampai bergolak. Angkat dari api dan biarkan selama 5-10 menit jika menggunakan biji vanila, lalu saring.\n3. **Campuran Telur:** Dalam mangkuk terpisah, kocok 5-6 kuning telur dengan 100g gula pasir hingga pucat dan sedikit mengembang.\n4. **Campurkan:** Tuangkan perlahan krim panas ke dalam campuran telur sambil terus diaduk rata agar telur tidak matang (temper). Saring campuran ini ke dalam mangkuk lain untuk mendapatkan tekstur yang sangat halus. Buang busa di permukaan jika ada.\n5. **Panggang Bain-Marie:** Tuangkan campuran krim ke dalam ramekin. Letakkan ramekin di loyang panggang. Tuang air panas ke dalam loyang hingga mencapai sekitar setengah tinggi ramekin.\n6. Panggang selama 30-40 menit, atau hingga pinggiran puding mengeras tetapi bagian tengah masih sedikit bergoyang (jika digoyangkan perlahan). Angkat ramekin dari loyang dan biarkan dingin sepenuhnya di suhu ruangan, lalu dinginkan di kulkas minimal 4 jam atau semalaman.\n7. **Karamelisasi:** Sesaat sebelum disajikan, taburi merata setiap crème brûlée dengan sekitar 1-2 sdt gula pasir. Gunakan obor masak (culinary torch) untuk membakar gula hingga meleleh dan mengkaramel menjadi lapisan keras berwarna keemasan. Sajikan segera sebelum karamel meleleh kembali.",
                titleHistory,
                titleExtra
        ));

        return view;
    }

    // Metode untuk membuka DetailActivity
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