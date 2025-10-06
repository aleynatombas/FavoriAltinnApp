# Favori Altın Uygulaması

Bu proje, güncel altın fiyatlarını takip etmenizi sağlayan Android uygulamasıdır. Uygulama, backend API'den gerçek zamanlı altın fiyatlarını çekerek kullanıcıların yatırım kararlarını destekler.

## Proje Açıklaması

Bu Android uygulaması, özel backend API'sinden güncel altın fiyatlarını çekerek kullanıcıya gösterir. Uygulama şu özelliklere sahiptir:

- **Gerçek Zamanlı Fiyatlar**: Backend API'den canlı altın fiyatlarını görüntüleme
- **Favori Seçimi**: Kullanıcılar istediği altın türlerini favorilere ekleyebilir
- **Temiz Arayüz**: Kullanıcı dostu ve modern tasarım
- **Offline Çalışma**: Backend erişilemezse örnek veriler gösterme
- **Kalıcı Favoriler**: SharedPreferences ile favori altınları saklama

## Kullanılan Teknolojiler

- **Android Studio**: Geliştirme ortamı
- **Java**: Programlama dili
- **Retrofit 2.9.0**: API iletişimi için
- **Gson**: JSON veri dönüşümü için
- **OkHttp**: HTTP istekleri ve logging
- **SharedPreferences**: Yerel veri saklama
- **RecyclerView**: Liste görüntüleme

## Kurulum ve Çalıştırma

### Gereksinimler
- Android Studio (en son sürüm)
- Android SDK (API 24+)
- Java 11 veya üzeri
- Backend sunucu (Port 5001)

### Adım Adım Kurulum

1. Android Studio'yu açın
2. "Open an existing project" seçeneğini tıklayın
3. Bu proje klasörünü seçin ve import edin
4. Gradle sync işlemini bekleyin (otomatik başlar)
5. Emülatör veya fiziksel cihaz bağlayın
6. Backend sunucunuzu başlatın (Port 5001)
7. Run butonuna basarak uygulamayı çalıştırın

### İlk Çalıştırma

- Uygulama açıldığında backend sunucuya bağlanmaya çalışır
- Backend erişilemezse örnek altın verileri gösterir
- Herhangi bir kullanıcı kaydı gerektirmez
- Favori seçimleri otomatik olarak kaydedilir

## Test Kullanıcı Bilgileri

Bu uygulama kullanıcı kaydı gerektirmez. Direkt olarak:

- Altın fiyatlarını görüntüleyebilirsiniz
- Kalp ikonuna tıklayarak favori altın türlerini seçebilirsiniz
- Favoriler cihazda kalıcı olarak saklanır
- Uygulama yeniden açıldığında favoriler korunur

## API Kullanımı

Uygulama özel backend API'sini kullanmaktadır. API endpoint'leri:

### Mevcut API Endpoint'leri:
- **Ana Endpoint**: `http://10.0.2.2:5001/api/goldprice` (Android emülatör için)
- **Tekil Fiyat**: `http://10.0.2.2:5001/api/goldprice/{id}`
- **Arama**: `http://10.0.2.2:5001/api/goldprice/search?name={name}`
- **Özet**: `http://10.0.2.2:5001/api/goldprice/summary`

### API Özellikleri:
- RESTful API tasarımı
- JSON formatında veri döner
- Timeout ayarları: 20-30 saniye
- HTTP logging aktif

## Backend Konfigürasyonu

### Kendi Backend'inizi Kullanmak İçin:
1. `RetrofitClient.java` dosyasını açın
2. `BASE_URL` değerini kendi backend adresinizle değiştirin:
   ```java
   private static final String BASE_URL = "http://YOUR_BACKEND_URL:PORT/";
   ```
3. Backend'inizin API endpoint'lerinin uyumlu olduğundan emin olun

### Gerçek Cihaz İçin:
- Emülatörde: `10.0.2.2:5001`
- Gerçek cihazda: `YOUR_COMPUTER_IP:5001`

## Proje Yapısı

```
app/src/main/java/com/aleynatombas/favorialtinnapp/
├── MainActivity.java          # Ana ekran
├── adapters/
│   └── GoldAdapter.java       # Liste adaptörü
├── models/                    # Veri modelleri
│   ├── GoldPrice.java         # Altın fiyat modeli
│   ├── Summary.java           # Özet bilgi modeli
│   └── GoldItem.java          # Altın öğe modeli
├── services/                  # API servisleri
│   ├── AltinApi.java          # API endpoint'leri
│   └── RetrofitClient.java    # HTTP istemci
└── utils/
    └── Prefs.java             # Yerel veri saklama
```

## Bonus Görevler

Geliştirilebilecek özellikler:

- ✅ **Favori altın türlerini kaydetme**: SharedPreferences ile kalıcı saklama
- 🔄 **Fiyat değişim grafikleri**: Geçmiş fiyat verilerini grafik olarak gösterme
- 🔄 **Push notification ile fiyat uyarıları**: Belirlenen fiyatlarda bildirim gönderme
- ✅ **Offline mod desteği**: Backend erişilemezse örnek veriler gösterme
- 🔄 **Fiyat karşılaştırması**: Farklı altın türlerini karşılaştırma
- 🔄 **Widget desteği**: Ana ekranda hızlı erişim için widget
- 🔄 **Arama özelliği**: Altın türlerini isme göre arama

## Sorun Giderme

### Yaygın Sorunlar:

**Fiyatlar yüklenmiyor:**
- Backend sunucunuzun çalıştığını kontrol edin (Port 5001)
- İnternet bağlantınızı kontrol edin
- Emülatör kullanıyorsanız `10.0.2.2:5001` kullanın

**Uygulama çöküyor:**
- Android Studio'da Logcat'i kontrol edin
- Backend API endpoint'lerinin doğru olduğundan emin olun

**Gradle sync hatası:**
- "Clean Project" ve "Rebuild Project" yapın
- Gradle wrapper'ı güncelleyin

**Build hatası:**
- Java 11 kullandığınızdan emin olun
- Android SDK'nın güncel olduğunu kontrol edin

## Örnek Veriler

Backend erişilemezse gösterilen örnek altın fiyatları:
- **Gram Altın**: 2150₺ / 2155₺
- **Çeyrek Altın**: 8600₺ / 8620₺  
- **Yarım Altın**: 17200₺ / 17240₺
- **Tam Altın**: 34400₺ / 34480₺

## Destek

Herhangi bir sorun yaşarsanız, [GitHub Issues](https://github.com/aleynatombas/FavoriAltinnApp/issues) bölümünden bildirebilirsiniz.

## Lisans

Bu proje eğitim amaçlı geliştirilmiştir.