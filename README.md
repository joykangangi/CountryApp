# CountryApp
An android application built with Jetpack Compose, consuming the Countries API to display countries and details about them . Credits to HNGi9.

### Features
- Smooth display of Countries from the `API`
- View Country's Details on click.
- Network Error Handling
- Search Country By Name

### ToDo/WishList Features
 - Filter countries by:
  * Currency
  * Sub-region
  * Region
  * Capital
  * Language
 - Enable Localization,i.e read data using any language
### How The Code Works
Being an application handling a lot of data, the project strucure is divided into multiple packages to separate concerns hence making it easier to read, scale and update.
The layers include:
#### 1. Domain
It contains a `repository` that ONLY has function definitions. The functions are what the API should do ONLY not how to do it. For example, `suspend fun getCountries(): List<CountryResponseItem>`
#### 2. Data
It contains the data from the [Country API](https://restcountries.com/v3.1/all). The data is represented in form of a JSON object. 
To transform the JSON to Kotlin objects that can be understood by the compiler, a tool is used.
The tool name is [JSONtoKotlinClass](https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-). This generates Kotlin objects automatically from JSON objects and is obviously faster than manual coding of the Kotlin Objects.
However, not all Kotlin objects from the endpoint are needed in the application, therefore a custom model class is manually created to represent objects that will be presented in the screens.
In the `CountryResponseItem` an extension function is created to return objects of the custom model class.
 
It also contains the routes to be accessed by the API during execution in the `CountryApi`

It also `use_cases` classes.
Each class has only one public function,i.e to execute the use case function
 * It is useful within a class having a single method
 * Specifying an invoke operator on a class allows it to be called/executed on any instances of the class without a method name.
 * The return type of the function is Flow -> emit multiple values over a period time, i.e wrapped in the Resource(Success/Error/Loading)
 * e.g -if an error occurs, it will be emitted here,
 *     -if a success occurs, attach the data fetched(List of Countries) and emit it
 * HttpException- what to do in case of error/ Http codes except those starting with 2 (successes)
 * IOException - what to do if the api can't connect to the remote server e.g when device isn't connected to the internet

 Lastly, the data layer contains the implementations of the repository defined in the domain layer.
 
 #### 3. DI (Dependency Injection)
  It contains functions that create dependencies.
 #### 4. UI/Presentation
 This contains the screens to be displayed as well as the logic used to display the screen, e.g `viewmodel` and state management.
 
 ### Libraries Used
 - [Retrofit](https://square.github.io/retrofit/) - This is a type-safe client for Android which makes it easier to consume RESTful web services/ connect to the network.
 - [Moshi Converter](https://github.com/square/moshi) - This helps in serialization and deserialization of code. The `generateAdter = true` helps in creating an adapter for the data classes generated.
 The codegen is used since if not employed Moshi works by coincidence with just standard Java reflection which is error prone. Therefore, in codegen, the generated adapters are Kotlin themselves which are fast.
 Codegen allows generating code at compile time, so they can perform serialization and deserialization using reflection, that is why it is fast.
 - [Coroutines](https://kotlinlang.org/docs/coroutines-basics.html) - This helps in writing asynchronous code, therefore allowing heavy operations , e.g fetching data from API to be done on a background thread avoiding screen lag.
 - [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) - This enables moving from one screen to the next.
 - [Coil](https://coil-kt.github.io/coil/compose/) - This helps in image loading from the network.
 - [Hilt](https://dagger.dev/hilt/) - It is a library for Android that reduces the boilerplate of using manual DI in your project. It decouples code and makes it easier to test in future.
 
 ### What's New in v1.0.0
 #### Better Network/Data Transfer Object(DTO)
 - The previous version had generated too many and unnecessary model classes. That made the runtime longer and complex to work with in the UI layer. For example, the `Currency` details could only be displayed as an object in the screen, i.e. `Currency: Dollar(name= Dollar, symbol = $)`.
 - Through further consultation, the API was discovered to be inconsistent. It will give different results for different request. Normally, a consistent API would return the same result for different requests, e.g different `names` should return a `String`. Due to the inconsistency, the [JsonToKotlin Plugin](https://plugins.jetbrains.com/plugin/9960-json-to-kotlin-class-jsontokotlinclass-) would generate numerous(400+) data classes.
 - Personally, I tried tweaking with the generated model to give better UI but it led to `ClassCastException`.That is changing Dollar to a data class with name and symbol as parameters.
 - To overcome this, data from the endpoint had to be fetched manually by inferring the inconsistent responses. E.g. ```val currencies: Currencies?``` changed to ```val currencies: Map<String, Currencies?>```. The type inferred should be similar to the JSON response otherwise it would cause avoidable pain e.g. `List<Currencies?>` would cause an error.
 - In future, one can watch out for such anomalies in the endpoints by using [Postman](https://www.postman.com/) to test the API. Alternatively, go through the API documentation to see for yourself.
 ##### The application is still a work in progress and will add the respective features as time goes by. Run the following links, preferrably the latest, and feel free to clone and adjust the applications to your liking.
 ### Links
 - [Appetize Link V.0.0.0](https://appetize.io/app/6sb76yokly4ppcegmsxhoexjvm)
 - [Appetize Link v.1.0.0](https://appetize.io/app/m44ha2dvhb3fu5tlud3jrx45am?device=pixel4&osVersion=11.0&scale=75)
 
 ### Screenshots
 <table>
  <tr>
   <td><img src = "https://user-images.githubusercontent.com/64706463/217352436-c928abcc-beac-44db-ba28-4a642067b2d9.png" alt = "mainlight"></td>
   <td><img src = "https://user-images.githubusercontent.com/64706463/217352414-654acbff-6a39-4e40-b75e-c099f868bb07.png" alt = "detaillight"></td>
      
  </tr> 
  <tr>
      <td><img src = "https://user-images.githubusercontent.com/64706463/217352442-1bce1bee-854a-4c23-b868-3d8611d05845.png" alt = "searchlight"></td>
      <td><img src = "https://user-images.githubusercontent.com/64706463/217352391-941798a6-b524-4d31-a4ec-e20672c6f6e6.png" alt = "coalight"></td>
  
  </tr>
      <td><img src = "https://user-images.githubusercontent.com/64706463/217352426-28cecdf5-da93-445b-96b0-8c22bf444baf.png" alt = "maindark"></td>
      <td><img src = "https://user-images.githubusercontent.com/64706463/217352411-aa0e5f31-b2eb-41c1-83fb-edc4c4597685.png" alt = "detaildark"></td>
  <tr>
    
</table>
