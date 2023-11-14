Clean architecture is a software design philosophy that separates the elements of a design into ring levels. An important goal of clean architecture is to provide developers with a way to organize code in such a way that it encapsulates the business logic but keeps it separate from the delivery mechanism.

## Layers
- **Domain** - Contains the business logic of the application. It is the individual and innermost module. It’s a complete java module.
- **Data** It includes the domain layer. It would implement the interface exposed by domain layer and dispenses data to app
- **Presentation** - A layer that interacts with the UI, mainly Android Stuff like Activities, Fragments, ViewModel, etc. It would include both domain and data layers.

## Apps Feature
- List news
- Detail news

## Demo
|Home Screen|Detail Screen|Detail Screen|
|--|--|--|
|![](assets/mainmenu.png?raw=true)|![](assets/detail.png?raw=true)|![](assets/detail2.png?raw=true)|