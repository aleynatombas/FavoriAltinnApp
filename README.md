# Favori Altın Uygulaması

Bu proje, güncel altın fiyatlarını takip etmenizi sağlayan Android uygulamasıdır. Uygulama, gerçek zamanlı altın fiyatlarını göstererek kullanıcıların yatırım kararlarını destekler.

## Proje Açıklaması

Bu Android uygulaması, finans.truncgil.com API'sinden güncel altın fiyatlarını çekerek kullanıcıya gösterir. Uygulama şu özelliklere sahiptir:

- **Gerçek Zamanlı Fiyatlar**: Canlı altın fiyatlarını görüntüleme
- **Favori Seçimi**: Kullanıcılar istediği altın türlerini favorilere ekleyebilir
- **Temiz Arayüz**: Kullanıcı dostu ve modern tasarım
- **Offline Çalışma**: Son görüntülenen fiyatları hatırlama

### Kullanılan Teknolojiler
- **Android Studio**: Geliştirme ortamı
- **Java**: Programlama dili
- **Retrofit**: API iletişimi için
- **Gson**: JSON veri dönüşümü için
- **SharedPreferences**: Yerel veri saklama

## Kurulum ve Çalıştırma

### Gereksinimler
- Android Studio (en son sürüm)
- Android SDK (API 21+)
- Java 8 veya üzeri

### Adım Adım Kurulum
1. **Android Studio'yu açın**
2. **"Open an existing project"** seçeneğini tıklayın
3. **Bu proje klasörünü seçin** ve import edin
4. **Gradle sync** işlemini bekleyin (otomatik başlar)
5. **Emülatör veya fiziksel cihaz** bağlayın
6. **Run** butonuna basarak uygulamayı çalıştırın

### İlk Çalıştırma
- Uygulama açıldığında internet bağlantısı gereklidir
- Altın fiyatları otomatik olarak yüklenecektir
- Herhangi bir kullanıcı kaydı gerektirmez

## Test Kullanıcı Bilgileri

Bu uygulama **kullanıcı kaydı gerektirmez**. Direkt olarak:
- Altın fiyatlarını görüntüleyebilirsiniz
- Favori altın türlerini seçebilirsiniz
- Uygulama ayarlarını değiştirebilirsiniz

## API Kullanımı

Uygulama şu anda **finans.truncgil.com** API'sini kullanmaktadır. Bu API:
- Ücretsiz ve açık kaynaklıdır
- Gerçek zamanlı altın fiyatları sağlar
- JSON formatında veri döner

## Bonus Görevler

Geliştirilebilecek özellikler:

- [ ] **Favori altın türlerini kaydetme**: Seçilen altınları kalıcı olarak saklama
- [ ] **Fiyat değişim grafikleri**: Geçmiş fiyat verilerini grafik olarak gösterme
- [ ] **Push notification ile fiyat uyarıları**: Belirlenen fiyatlarda bildirim gönderme
- [ ] **Offline mod desteği**: İnternet olmadan da son fiyatları gösterme
- [ ] **Fiyat karşılaştırması**: Farklı altın türlerini karşılaştırma
- [ ] **Widget desteği**: Ana ekranda hızlı erişim için widget

## Backend

Backend API kodları ayrı bir GitHub reposunda paylaşılmıştır. 

### Kendi Backend'inizi Kullanmak İçin:
1. `RetrofitClient.java` dosyasını açın
2. `BASE_URL` değerini kendi backend adresinizle değiştirin
3. Backend'inizin API endpoint'lerinin uyumlu olduğundan emin olun

### Mevcut API Endpoint'leri:
- **Ana API**: `https://finans.truncgil.com/today.json`
- **Yerel Test**: `http://10.0.2.2:5000/` (Android emülatör için)

## Sorun Giderme

### Yaygın Sorunlar:
- **Fiyatlar yüklenmiyor**: İnternet bağlantınızı kontrol edin
- **Uygulama çöküyor**: Android Studio'da Logcat'i kontrol edin
- **Gradle sync hatası**: "Clean Project" ve "Rebuild Project" yapın

### Destek:
Herhangi bir sorun yaşarsanız, GitHub Issues bölümünden bildirebilirsiniz.


