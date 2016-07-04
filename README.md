# MVP-Navigator

Sample of using Navigator with MVP. It contains an Android application that allows you to browse through articles, read them and see the list of favorite articles. There are 5 examples each of them shows this approach from a different angle.

First three examples shares same Fragments but apply different navigation patterns: 
* **New screen**. In the first example I’m opening another Activity, but same logic can be applied for replacing Fragments.
* **Master-Detail Pattern**. This could be useful in the case of tablet layout.
* **ViewPager**. Some times instead of opening new screen we want to slide to another tab.. 

Forth example illustrates how dependency injection makes code simpler and more decoupled.

Fifth example shows how to work with Navigator in case of Presenters that retains on configuration change. It retains Presenter using [this library.](https://github.com/NikitaKozlov/RetainPresenter)

