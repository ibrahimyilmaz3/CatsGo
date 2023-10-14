package com.application.catsgo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.catsgo.R
import kotlinx.android.synthetic.main.item_country.view.*

class DialogOccupationRecyclerAdapter :
    RecyclerView.Adapter<DialogOccupationRecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result = MutableLiveData<String>()

    private var arrayJob = arrayListOf(
        "Aktüer",
        "Biyomedikal Mühendisliği",
        "Yazılım Mühendisliği",
        "Odyolog",
        "Mali Planlayıcı",
        "Diş Sağlığı Uzmanı",
        "Mesleki Terapist",
        "Optometrist",
        "Fizyoterapist",
        "Bilgisayar Sistem Analisti",
        "Kayropraktik Uzmanı",
        "Konuşma Bozuklukları Uzmanı",
        "Fizyolog",
        "Üniversite Profesörü",
        "Veteriner",
        "Diyetisyen",
        "Eczacı",
        "Matematikçi",
        "Sosyolog",
        "İstatistikçi",
        "Fizikçi",
        "Gözlükçü",
        "Ayak Hastalıkları Uzmanı",
        "Web Geliştirici",
        "Tarihçi",
        "Çevre Mühendisi",
        "Şartlı Tahliye Memuru",
        "Petrol Mühendisliği",
        "Meteoroloji Uzmanı",
        "Jeolog",
        "İnsan Kaynakları Müdürü",
        "İnşaat Mühendisi",
        "Ortodonti Uzmanı",
        "Solunum Terapisti",
        "Tıbbi Kayıtlar Teknisyeni",
        "Astronom",
        "Psikiyatrist",
        "Bilgisayar Programcısı",
        "Sosyal ve Topluluk Müdürü/ Yöneticisi",
        "Pazar Araştırma Analisti",
        "Avukat Yardımcısı",
        "Dişçi",
        "Cilt Bakım Uzmanı",
        "Endüstriyel Makine Tamircileri",
        "Hekim",
        "Lojistik",
        "Muhasebeci",
        "Yönetim Danışmanı",
        "Sosyal Hizmet Uzmanı",
        "Hekim Yardımcısı",
        "Cerrah",
        "Meslek Danışmanı",
        "Duvar Ustası",
        "Bilirkişi",
        "Hemşire     ",
        "Arkeolog",
        "Müze Müdürü",
        "Psikolog",
        "Cam Ustası",
        "Teknik Yazar",
        "Mimar",
        "Etkinlik Koordinatörü",
        "Etkinlik Koordinatörü",
        "İş Güvenliği/ Sağlık Müfettişi",
        "Kredi Yöneticisi",
        "Nükleer Arındırma Teknisyeni",
        "Tesisatçı",
        "Tıbbi Teknolog",
        "Mahkeme Yazıcısı",
        "İşveren",
        "Biyolog",
        "Muhasebeci- Sayman",
        "Tıbbi Laboratuar Teknisyeni",
        "Halkla İlişkiler Yöneticisi",
        "Sigortacı",
        "Yönetici Asistanı",
        "Elektrikçi",
        "Otomobil Bakım Servisi",
        "Sigorta Acentası",
        "Yargıç",
        "Nükleer Mühendisliği",
        "Online Satış Müdürü",
        "Makine Mühendisliği",
        "Saç Stilisti",
        "Haberleşme Cihazları Mekanik Tamircileri",
        "Vergi Tahsildarı",
        "Resepsiyonist",
        "Kanalizasyon Tesisi Operatör",
        "Kütüphaneci",
        "Endüstriyel Tasarımcı",
        "Okul Müdürü",
        "Zoolog",
        "Antropolog",
        "İlkokul Öğretmeni",
        "İnşaat/ Yapı Müfettişi",
        "Zararlılarla Mücadele İşcisi",
        "Acil Tıp Teknisyeni",
        "Endüstri Mühendisliği",
        "Elektrik Mühendisi",
        "Hemşire",
        "Havacılık ve Uzay Mühendisi"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            arrayJob.sort()

            tvCountry.text = arrayJob[position]

            setOnClickListener {
                result.value = tvCountry.text.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayJob.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
