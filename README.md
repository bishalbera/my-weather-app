# Weather App



**Weather App**  prompts the user to see weekly weather forecast of any areas also wind speed, pressure, humidity, sunrise & sunrise time. It also permits user to add their fav cities in favorite tab. Also from setting tab user can toogle between units from celcius to fahrenheit. It also has a about section.

Time spent: Almost **7** days spent in total.

## Functionality

The following **required** functionality is completed:

* [x] User can search for any city.
* [x] The user can check any areas weekly weather forecast.


* The following **extensions** are implemented:

* [x] User can add their fav cities into favlist by tapping on the 'heart' icon and also delete from that list.
* [x] User can change the unit to celsius from fahrenheit or vise-versa. 
* [x] Custom colors selected.
* [x] About section added.  



## Tech Stacks and Libraries Used

- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Jetpack
    - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
    - ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
    - DataBinding: Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    - Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
    - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - [Bindables](https://github.com/skydoves/bindables): Android DataBinding kit for notifying data changes to UI layers.
    - Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Coil](https://github.com/coil-kt/coil) : Helps to load images from url

## Weather API

Weather App using the [OpenWeatherAPI](https://openweathermap.org/) for building this application.







