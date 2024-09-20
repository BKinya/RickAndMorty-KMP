# Rick n Morty Cast

A Kotlin Multiplatform App targeting Android, iOS. The app displays Rick and Morty show characters

## Screenshots
<img src="https://github.com/BKinya/RickAndMorty-KMP/blob/main/images/android.png" alt="Android" >&emsp;&emsp;&emsp;<img src="https://github.com/BKinya/RickAndMorty-KMP/blob/main/images/ios.png" alt="ios" width="327" height="660" >

### See Full Demo
- [Android Demo](https://www.loom.com/share/68a5c49258384288ad3b48fb2b61daf9?sid=22ab37eb-a836-4db8-bd53-f331f32f1f18)
- [iOS Demo](https://www.loom.com/share/e4507e3dfc5f49699f5c14f7e06b58d5?sid=ec0d429a-2c67-48dd-a88b-956129ca4d2a)


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
- Import the project in Android studio 
- In the list of configurations, select **composeApp**
- Choose either an emulator or a device and click run

To run the app on ios:
- open the **iosApp** directory in Xcode and run the standard configurations

## Resources
- [Create a multiplatform app with shared logic and ui](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html)


