# khttp-gsonconverter

```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

```java
dependencies {
     compile 'com.github.Sjoner:khttp:0.0.5'
     compile 'com.github.Sjoner:khttp-gsonconverter:0.0.2'
}
```


```java
initRetrofit {
   baseUrl("http://www.kuaidi100.com")
   responseConverter = GsonResponseConverter()
}
```
