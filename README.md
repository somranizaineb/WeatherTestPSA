**NOTICE**

This project is a test.

---

# WeatherTestPSA

This app performs basic REST call to obtain weather information from (https://openweathermap.org/api/one-call-api) API,
with the idea to showcase some Android architecture and coding
patterns.

## Code constraints

- Kotlin.
- SDK min 23
- Coroutines.
- Dependency injection with dagger.
- Retrofit + Moshi.
- Architecture Components.
- clean Architecture
- Modularization.
- Unit Testing mockito .

## App Modules

```
- lib                  (M: model Retrofit , room )
  | - data repository  (communicate with local and remote)
  | - domain use case  (Use case communicatae with repository)

- app                  (VVM : view + viewModel)

```
## Describing the component : Lib

The `:lib` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) for serving network requests or accessing to the database.
 Providing the data source for app to display it. So to retrieve the data from the lib module we must inject usecase which comes from the lib module and which is responsible for communicating with the repository


## Architecture components + clean + Modularization diagram

The communication between the different layers follow the diagram below using the reactive paradigm, observing changes on components without need of callbacks avoiding leaks and edge cases related with them.

![graph](https://i.ibb.co/cxdLcq6/Capture-d-e-cran-2020-07-28-a-12-03-06.png)


## Describing API used:

- URL : https://openweathermap.org/api/one-call-api
- Params :
  | - lat  latitude of the selected town, her type is double
  | - lon  longitude of the selected town, her type is double
  | - exclude ={part} (optional parameter) by using this parameter you can exclude some parts of the weather data from the API response. It should be a comma-delimited list (without spaces).
               Available values:
               current
               minutely
               hourly
               daily
               In this case i exclude minutely,hourly to dipslay only the current waether and the forecasts of 8 next days
  | - appid  unique API key (you can always find it on the account page, on the "API key" tab)
  | - units  metric to get temperature in Celsius


- Response : WeatherTownResponse
     | - current: Current weather data API response
     | - daily: Daily forecast for 7 days


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
