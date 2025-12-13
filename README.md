# TaskMaster - Görev ve Proje Yönetim Sistemi

## 📋 Proje Hakkında

TaskMaster, Java ile geliştirilmiş nesne tabanlı bir görev ve proje yönetim uygulamasıdır. Kullanıcıların projeler oluşturmasına, görevler eklemesine ve bu görevleri öncelik ve tarih bazında yönetmesine olanak sağlar.

## ✨ Özellikler

- **Kullanıcı Yönetimi**: Kullanıcı oluşturma ve yönetme
- **Proje Yönetimi**: Proje oluşturma ve görev ekleme
- **Görev Yönetimi**: 
  - Normal görevler (Task)
  - Süreli görevler (TimedTask) - son teslim tarihi ile
- **Öncelik Sistemi**: HIGH, MEDIUM, LOW öncelik seviyeleri
- **Görev Sıralama**: Önceliğe göre otomatik sıralama
- **Yaklaşan Görevler**: Belirli bir süre içindeki yaklaşan görevleri listeleme
- **Görev Tamamlama**: Görevleri tamamlanmış olarak işaretleme

## 🏗️ Proje Yapısı

```
NTP_Project/
├── src/
│   └── com/
│       └── taskmaster/
│           ├── Main.java                    # Ana uygulama giriş noktası
│           ├── enums/
│           │   └── Priority.java           # Öncelik enum'u
│           ├── interfaces/
│           │   └── Completable.java        # Tamamlanabilir arayüz
│           ├── model/
│           │   ├── BaseTask.java           # Temel görev sınıfı
│           │   ├── Task.java               # Normal görev sınıfı
│           │   ├── TimedTask.java          # Süreli görev sınıfı
│           │   ├── Project.java            # Proje sınıfı
│           │   ├── User.java               # Kullanıcı sınıfı
│           │   └── Notification.java       # Bildirim sınıfı
│           ├── service/
│           │   └── TaskService.java        # Görev yönetim servisi
│           └── test/
│               └── TaskServiceTest.java    # Test sınıfları
├── bin/                                    # Derlenmiş sınıf dosyaları
├── lib/                                    # Kütüphaneler (JUnit)
└── README.md                               # Bu dosya
```

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler

- Java JDK 8 veya üzeri
- Java derleyicisi (javac)
- Java çalıştırıcısı (java)

### Derleme

Projeyi derlemek için:

```bash
javac -d bin -sourcepath src src/com/taskmaster/**/*.java
```

### Çalıştırma

Uygulamayı çalıştırmak için:

```bash
java -cp bin com.taskmaster.Main
```

## 💻 Kullanım Örneği

```java
// TaskService oluştur
TaskService service = new TaskService();

// Kullanıcı oluştur
User user = new User(1, "Ayşe Yılmaz", "ayse@example.com");
service.addUser(user);

// Proje oluştur
Project project = new Project(1, "Görev & Proje Yönetim Aracı", "Proje 9 senaryosu");
service.createProject(project);

// Normal görev ekle
Task task = new Task(101, "Dokümantasyon", "Kullanım kılavuzu yaz", Priority.MEDIUM);
service.addTaskToProject(project.getId(), task);

// Süreli görev ekle
TimedTask timedTask = new TimedTask(
    102,
    "Sürüm Hazırlığı",
    "Test ve paketleme",
    Priority.HIGH,
    LocalDateTime.now().plusDays(14)
);
service.addTaskToProject(project.getId(), timedTask);

// Görevi tamamla
task.complete();

// Önceliğe göre sıralı görevleri listele
List<Task> sortedTasks = service.getTasksSortedByPriority();

// Yaklaşan görevleri listele (21 gün içinde)
List<TimedTask> upcomingTasks = service.getUpcomingTasks(21);
```

## 🧪 Test

JUnit testlerini çalıştırmak için:

```bash
java -cp "bin;lib/junit-platform-console-standalone-1.10.0.jar" org.junit.platform.console.ConsoleLauncher --class-path bin --scan-class-path
```

## 📚 Sınıf Hiyerarşisi

- **BaseTask**: Tüm görev türlerinin temel sınıfı
  - **Task**: Normal görevler için
  - **TimedTask**: Son teslim tarihi olan görevler için

- **Completable**: Görevlerin tamamlanabilir özelliğini tanımlayan arayüz

- **Priority Enum**: HIGH, MEDIUM, LOW öncelik seviyeleri

## 🎯 Proje Senaryosu

Bu proje, Nesne Tabanlı Programlama dersi kapsamında geliştirilmiş "Proje 9" senaryosunun bir uygulamasıdır. Görev ve proje yönetimi için temel bir sistem sağlar.

## 📝 Lisans

Bu proje eğitim amaçlı geliştirilmiştir.

## 👤 Geliştirici

Nesne Tabanlı Programlama Final Projesi

---

**Not**: Bu proje Java nesne tabanlı programlama prensiplerini (kalıtım, polimorfizm, encapsulation, abstraction) uygulamak için geliştirilmiştir.
'@; [System.IO.File]::WriteAllText("$PWD\README.md", $content, [System.Text.Encoding]::UTF8)
