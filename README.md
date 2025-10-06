# Favori Altın Uygulaması

Bu proje, güncel altın fiyatlarını takip etmenizi sağlayan Android uygulamasıdır. Uygulama, backend API'den gerçek zamanlı altın fiyatlarını çekerek kullanıcıların yatırım kararlarını destekler.

## Proje Açıklaması

Bu Android uygulaması, özel backend API'sinden güncel altın fiyatlarını çekerek kullanıcıya gösterir. Uygulama şu özelliklere sahiptir:

- **Gerçek Zamanlı Fiyatlar**: Backend API'den canlı altın fiyatlarını görüntüleme
- **Favori Seçimi**: Kullanıcılar istediği altın türlerini favorilere ekleyebilir
- **Temiz Arayüz**: Kullanıcı dostu ve modern tasarım
- **Offline Çalışma**: Backend erişilemezse örnek veriler gösterme

## Kullanılan Teknolojiler

- **Android Studio**: Geliştirme ortamı
- **Java**: Programlama dili
- **Retrofit**: API iletişimi için
- **Gson**: JSON veri dönüşümü için
- **SharedPreferences**: Yerel veri saklama

## Kurulum ve Çalıştırma

### Gereksinimler
- Android Studio (en son sürüm)
- Android SDK (API 24+)
- Java 11 veya üzeri

### Adım Adım Kurulum

1. Android Studio'yu açın
2. "Open an existing project" seçeneğini tıklayın
3. Bu proje klasörünü seçin ve import edin
4. Gradle sync işlemini bekleyin (otomatik başlar)
5. Emülatör veya fiziksel cihaz bağlayın
6. Run butonuna basarak uygulamayı çalıştırın

## Backend API

Bu uygulama için geliştirilmiş backend API'si ayrı bir GitHub reposunda bulunmaktadır. Backend API'si olmadan uygulama örnek verilerle çalışır.

### Kendi Backend'inizi Kullanmak İçin:
1. `RetrofitClient.java` dosyasını açın
2. `BASE_URL` değerini kendi backend adresinizle değiştirin:
   ```java
   private static final String BASE_URL = "http://YOUR_BACKEND_URL:PORT/";
   ```

## Proje Yapısı

```
app/src/main/java/com/aleynatombas/favorialtinnapp/
├── MainActivity.java          # Ana ekran
├── adapters/
│   └── GoldAdapter.java       # Liste adaptörü
├── models/                    # Veri modelleri
│   ├── GoldPrice.java         # Altın fiyat modeli
│   └── Summary.java           # Özet bilgi modeli
├── services/                  # API servisleri
│   ├── AltinApi.java          # API endpoint'leri
│   └── RetrofitClient.java    # HTTP istemci
└── utils/
    └── Prefs.java             # Yerel veri saklama
```

## Sorun Giderme

**Fiyatlar yüklenmiyor:**
- Backend sunucunuzun çalıştığını kontrol edin
- İnternet bağlantınızı kontrol edin

**Uygulama çöküyor:**
- Android Studio'da Logcat'i kontrol edin

**Gradle sync hatası:**
- "Clean Project" ve "Rebuild Project" yapın

## Destek

Herhangi bir sorun yaşarsanız, [GitHub Issues](https://github.com/aleynatombas/FavoriAltinnApp/issues) bölümünden bildirebilirsiniz.