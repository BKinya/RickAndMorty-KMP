# Rick n Morty Cast

A Kotlin Multiplatform App targeting Android, and iOS. The app displays Rick and Morty show characters


## Android
<img src="https://github.com/BKinya/RickAndMorty-KMP/blob/add_gifs/media/android.gif" alt="Android" width="327" height="660">

## iOS
<img src="https://github.com/BKinya/RickAndMorty-KMP/blob/add_gifs/media/ios.gif" alt="ios" width="327" height="660" >

## Architecture
- MVI architecture (Model - View - Intent) - For Unidirectional data flow.
- Repository pattern - To ensure clean separation of concerns and improve maintainability of the application

## Tech Stack and Third-Party Libraries
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html): A technology that enables 
sharing code across multiple platforms
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/): Modern Declarative 
UI framework for sharing UI across multiple platforms
- [Ktor](https://ktor.io): A framework for creating asynchronous server-side and client-side applications
- Kotlin [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) and [Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/): 
For asynchronous operation
- [Koin](https://insert-koin.io): A Kotlin Dependency Injection framework
- [Lifecycle Components]()
- [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization): For serializing and 
deserialization data in Kotlin
- [Kamel](https://github.com/Kamel-Media/Kamel): For loading, caching, decoding and displaying images 
in Compose Multiplatform
- [Napier](https://github.com/AAkira/Napier): A logging library for Kotlin multiplatform
- [Compose Navigation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html)
- [Multiplatform-paging](https://github.com/cashapp/multiplatform-paging)

## Run Project
To run the app on Android:
- Import the project into Android studio 
- In the list of configurations, select **composeApp**
- Choose either an emulator or a device and click run

To run the app on ios:
- open the **iosApp** directory in Xcode and run the standard configurations

## Resources
- [Create a multiplatform app with shared logic and ui](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html)


