**NOTICE**

This project is a test.

---

# WeatherTestPSA
.

This app performs basic REST call to obtain a public list of records from Discogs API,
with the idea to test and showcase some Android architecture and coding
patterns.

## Code Features

- Kotlin.
- Coroutines.
- Dependency injection with dagger.
- Retrofit + Moshi.
- Architecture Components.
_ clean Architecture
- Modularization.
- Unit Testing mockito .

## App Modules

```
- lib                  (M: model Retrofit , room )
  | - data repository  (communicate with local and remote)
  | - domain use case  (Use case communicatae with repository)

- app                  (VVM : view + viewModel)

```

![graph](https://i.ibb.co/cxdLcq6/Capture-d-e-cran-2020-07-28-a-12-03-06.png)


### Dependencies

-   [Jetpack](https://developer.android.com/jetpack):
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    -   [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [Room](https://developer.android.com/topic/libraries/architecture/room) - persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - managing background threads with simplified code and reducing needs for callbacks.
-   [Dagger2](https://dagger.dev/) - dependency injector for replacement all FactoryFactory classes.
-   [Retrofit](https://square.github.io/retrofit/) - type-safe HTTP client.
-   [Moshi](https://github.com/square/moshi) - makes it easy to parse JSON into Kotlin objects.
```
