# Полный список архитектурных паттернов, подходов и методологий

## 1. Архитектурные паттерны (Architectural Patterns)

### Слоистые архитектуры
- **Layered (N-tier) Architecture** - многослойная архитектура
- **Three-tier Architecture** - трёхслойная (Presentation, Business, Data)
- **Clean Architecture** - чистая архитектура (Uncle Bob)
- **Hexagonal Architecture (Ports & Adapters)** - шестиугольная архитектура
- **Onion Architecture** - луковичная архитектура

### Распределённые системы
- **Microservices Architecture** - микросервисная архитектура
- **Service-Oriented Architecture (SOA)** - сервис-ориентированная архитектура
- **Event-Driven Architecture (EDA)** - событийно-ориентированная архитектура
- **CQRS (Command Query Responsibility Segregation)** - разделение команд и запросов
- **Event Sourcing** - хранение событий
- **Saga Pattern** - паттерн саг для распределённых транзакций
- **API Gateway Pattern** - паттерн шлюза API
- **Backend for Frontend (BFF)** - backend для каждого frontend
- **Strangler Fig Pattern** - постепенная миграция legacy систем

### Монолитные подходы
- **Monolithic Architecture** - монолитная архитектура
- **Modular Monolith** - модульный монолит

### Современные подходы
- **Serverless Architecture** - бессерверная архитектура
- **JAMstack** - JavaScript, APIs, Markup
- **Micro Frontends** - микрофронтенды
- **Space-Based Architecture** - космическая архитектура
- **Peer-to-Peer Architecture** - P2P архитектура
- **Lambda Architecture** - лямбда-архитектура (для Big Data)
- **Kappa Architecture** - каппа-архитектура

### Паттерны презентационного слоя
- **MVC (Model-View-Controller)** - модель-представление-контроллер
- **MVP (Model-View-Presenter)** - модель-представление-презентер
- **MVVM (Model-View-ViewModel)** - модель-представление-модель представления
- **MVU (Model-View-Update)** - Elm Architecture
- **Flux / Redux Pattern** - однонаправленный поток данных
- **MVI (Model-View-Intent)** - модель-представление-намерение

## 2. Design Patterns (Gang of Four и другие)

### Порождающие паттерны (Creational)
- **Singleton** - одиночка
- **Factory Method** - фабричный метод
- **Abstract Factory** - абстрактная фабрика
- **Builder** - строитель
- **Prototype** - прототип
- **Object Pool** - пул объектов
- **Dependency Injection** - внедрение зависимостей
- **Lazy Initialization** - ленивая инициализация

### Структурные паттерны (Structural)
- **Adapter** - адаптер
- **Bridge** - мост
- **Composite** - компоновщик
- **Decorator** - декоратор
- **Facade** - фасад
- **Flyweight** - приспособленец
- **Proxy** - заместитель
- **Module Pattern** - модуль
- **Private Class Data** - приватные данные класса

### Поведенческие паттерны (Behavioral)
- **Chain of Responsibility** - цепочка обязанностей
- **Command** - команда
- **Iterator** - итератор
- **Mediator** - посредник
- **Memento** - хранитель
- **Observer** - наблюдатель
- **State** - состояние
- **Strategy** - стратегия
- **Template Method** - шаблонный метод
- **Visitor** - посетитель
- **Interpreter** - интерпретатор
- **Null Object** - нулевой объект
- **Specification** - спецификация

## 3. Принципы проектирования

### SOLID принципы
- **S - Single Responsibility Principle** - принцип единственной ответственности
- **O - Open/Closed Principle** - принцип открытости/закрытости
- **L - Liskov Substitution Principle** - принцип подстановки Барбары Лисков
- **I - Interface Segregation Principle** - принцип разделения интерфейса
- **D - Dependency Inversion Principle** - принцип инверсии зависимостей

### Другие принципы
- **DRY (Don't Repeat Yourself)** - не повторяйся
- **KISS (Keep It Simple, Stupid)** - делай проще
- **YAGNI (You Aren't Gonna Need It)** - тебе это не понадобится
- **Law of Demeter** - закон Деметры (принцип минимальной осведомлённости)
- **Composition Over Inheritance** - композиция вместо наследования
- **Separation of Concerns** - разделение ответственностей
- **Principle of Least Astonishment** - принцип наименьшего удивления
- **Convention Over Configuration** - соглашение важнее конфигурации
- **Fail Fast** - быстрый отказ
- **Encapsulation** - инкапсуляция
- **High Cohesion, Loose Coupling** - высокая связность, слабое зацепление

## 4. Методологии разработки

### Agile методологии
- **Scrum** - скрам
- **Kanban** - канбан
- **Extreme Programming (XP)** - экстремальное программирование
- **Lean Software Development** - бережливая разработка
- **Crystal** - кристалл
- **Feature-Driven Development (FDD)** - разработка, управляемая функциями
- **Scrumban** - скрамбан (гибрид Scrum и Kanban)

### Традиционные методологии
- **Waterfall** - водопад (каскадная модель)
- **V-Model** - V-модель
- **Spiral Model** - спиральная модель
- **Iterative and Incremental Development** - итеративная и инкрементальная разработка

### DevOps практики
- **CI/CD (Continuous Integration/Continuous Deployment)** - непрерывная интеграция/развёртывание
- **Infrastructure as Code (IaC)** - инфраструктура как код
- **GitOps** - управление через Git
- **Continuous Monitoring** - непрерывный мониторинг
- **Blue-Green Deployment** - сине-зелёное развёртывание
- **Canary Deployment** - канареечное развёртывание
- **Feature Toggles** - переключатели функций

## 5. Подходы к проектированию

### Domain-Driven Design (DDD)
- **Bounded Context** - ограниченный контекст
- **Ubiquitous Language** - единый язык
- **Aggregates** - агрегаты
- **Entities** - сущности
- **Value Objects** - объекты-значения
- **Domain Events** - доменные события
- **Repositories** - репозитории
- **Services** - сервисы (Domain, Application, Infrastructure)
- **Anti-Corruption Layer** - защитный слой
- **Context Mapping** - картирование контекстов

### DDD Практики моделирования
- **Event Storming** - штурм событий (collaborative workshop)
- **Domain Storytelling** - рассказывание доменных историй
- **Example Mapping** - картирование примеров
- **Event Modeling** - моделирование событий
- **Impact Mapping** - картирование влияния
- **User Story Mapping** - картирование пользовательских историй

### Test-Driven Development (TDD)
- **Red-Green-Refactor** - красный-зелёный-рефакторинг
- **BDD (Behavior-Driven Development)** - разработка через поведение
- **ATDD (Acceptance Test-Driven Development)** - разработка через приёмочное тестирование

### Другие подходы
- **Reactive Programming** - реактивное программирование
- **Functional Programming** - функциональное программирование
- **Object-Oriented Programming (OOP)** - объектно-ориентированное программирование
- **Aspect-Oriented Programming (AOP)** - аспектно-ориентированное программирование
- **Data-Oriented Design** - дизайн, ориентированный на данные

## 6. Паттерны интеграции (Enterprise Integration Patterns)

- **Message Channel** - канал сообщений
- **Message Router** - маршрутизатор сообщений
- **Message Translator** - транслятор сообщений
- **Message Endpoint** - конечная точка сообщений
- **Publish-Subscribe** - публикация-подписка
- **Request-Reply** - запрос-ответ
- **Message Bus** - шина сообщений
- **Content-Based Router** - маршрутизатор на основе содержимого
- **Message Filter** - фильтр сообщений
- **Aggregator** - агрегатор
- **Splitter** - разделитель
- **Pipes and Filters** - каналы и фильтры

## 7. Паттерны баз данных

- **Repository Pattern** - паттерн репозитория
- **Unit of Work** - единица работы
- **Data Mapper** - маппер данных
- **Active Record** - активная запись
- **Table Data Gateway** - шлюз табличных данных
- **Row Data Gateway** - шлюз строки данных
- **Identity Map** - карта идентичности
- **Lazy Loading** - ленивая загрузка
- **Eager Loading** - жадная загрузка
- **Database per Service** - база данных на сервис
- **Shared Database** - общая база данных
- **Database Sharding** - шардинг базы данных
- **Read Replicas** - реплики для чтения
- **Materialized View** - материализованное представление

## 8. Cloud Patterns (Облачные паттерны)

### Устойчивость и надёжность
- **Circuit Breaker** - автоматический выключатель
- **Retry Pattern** - паттерн повтора
- **Bulkhead Pattern** - паттерн переборки
- **Timeout Pattern** - паттерн таймаута
- **Rate Limiting** - ограничение частоты запросов
- **Throttling** - дросселирование
- **Health Endpoint Monitoring** - мониторинг точки здоровья

### Масштабирование
- **Auto-Scaling** - автоматическое масштабирование
- **Load Balancing** - балансировка нагрузки
- **Queue-Based Load Leveling** - выравнивание нагрузки через очередь
- **Competing Consumers** - конкурирующие потребители
- **Cache-Aside** - кеширование в стороне
- **CDN (Content Delivery Network)** - сеть доставки контента

### Управление данными
- **Sharding** - шардинг
- **CQRS** - разделение команд и запросов
- **Event Sourcing** - источник событий
- **Static Content Hosting** - хостинг статического контента
- **Valet Key** - ключ камердинера

## 9. Security Patterns (Паттерны безопасности)

- **Authentication** - аутентификация
- **Authorization** - авторизация
- **OAuth 2.0 / OpenID Connect** - делегированная авторизация
- **JWT (JSON Web Tokens)** - веб-токены JSON
- **API Key Authentication** - аутентификация через API ключи
- **Role-Based Access Control (RBAC)** - управление доступом на основе ролей
- **Attribute-Based Access Control (ABAC)** - управление доступом на основе атрибутов
- **Encryption at Rest** - шифрование в покое
- **Encryption in Transit** - шифрование при передаче
- **Secret Management** - управление секретами
- **Zero Trust Architecture** - архитектура нулевого доверия
- **Defense in Depth** - эшелонированная защита

## 10. API Design Patterns

- **REST (Representational State Transfer)** - передача состояния представления
- **GraphQL** - язык запросов для API
- **gRPC** - RPC фреймворк от Google
- **WebSockets** - двусторонняя связь
- **Server-Sent Events (SSE)** - события, отправляемые сервером
- **Webhook** - веб-хуки
- **HATEOAS** - гипермедиа как двигатель состояния приложения
- **API Versioning** - версионирование API
- **Pagination** - пагинация
- **Rate Limiting** - ограничение частоты запросов
- **API Gateway** - шлюз API

## 11. Concurrency Patterns (Паттерны параллелизма)

- **Thread Pool** - пул потоков
- **Producer-Consumer** - производитель-потребитель
- **Read-Write Lock** - блокировка чтения-записи
- **Semaphore** - семафор
- **Mutex** - мьютекс
- **Monitor** - монитор
- **Futures and Promises** - будущие значения и обещания
- **Actor Model** - модель актёров
- **MapReduce** - распределённая обработка данных
- **Fork-Join** - разветвление-слияние

## 12. Performance Patterns (Паттерны производительности)

- **Caching** - кеширование
- **Connection Pooling** - пул соединений
- **Lazy Loading** - ленивая загрузка
- **Eager Loading** - жадная загрузка
- **Pagination** - пагинация
- **Data Compression** - сжатие данных
- **Minification** - минификация
- **CDN Usage** - использование CDN
- **Asynchronous Processing** - асинхронная обработка
- **Batch Processing** - пакетная обработка

## 13. Testing Patterns

- **Unit Testing** - модульное тестирование
- **Integration Testing** - интеграционное тестирование
- **End-to-End Testing** - сквозное тестирование
- **Mock Objects** - объекты-заглушки
- **Test Doubles** - тестовые двойники (Dummy, Stub, Spy, Mock, Fake)
- **Arrange-Act-Assert (AAA)** - организация тестов
- **Given-When-Then** - структура BDD тестов
- **Test Fixtures** - тестовые фикстуры
- **Contract Testing** - контрактное тестирование
- **Mutation Testing** - мутационное тестирование
- **Property-Based Testing** - тестирование на основе свойств

## 14. Logging and Monitoring Patterns

- **Structured Logging** - структурированное логирование
- **Correlation ID** - идентификатор корреляции
- **Distributed Tracing** - распределённая трассировка
- **Centralized Logging** - централизованное логирование
- **Health Checks** - проверки здоровья
- **Metrics Collection** - сбор метрик
- **Alerting** - оповещение
- **Log Aggregation** - агрегация логов

## 15. Resilience Patterns (Паттерны устойчивости)

- **Timeout** - тайм-аут
- **Retry** - повтор
- **Circuit Breaker** - автоматический выключатель
- **Fallback** - запасной вариант
- **Bulkhead** - переборка
- **Rate Limiter** - ограничитель частоты
- **Graceful Degradation** - плавная деградация
- **Fail Fast** - быстрый отказ
- **Idempotency** - идемпотентность
- **Compensating Transaction** - компенсирующая транзакция

---

## Источники и дополнительная информация

- **Gang of Four (GoF)** - Design Patterns: Elements of Reusable Object-Oriented Software
- **Martin Fowler** - Patterns of Enterprise Application Architecture
- **Eric Evans** - Domain-Driven Design
- **Robert C. Martin (Uncle Bob)** - Clean Architecture
- **Gregor Hohpe, Bobby Woolf** - Enterprise Integration Patterns
- **Microsoft Azure Architecture Center** - Cloud Design Patterns
- **AWS Well-Architected Framework**
- **Microservices.io** - Microservices patterns by Chris Richardson