# prj_adrkotlin

## [Youtube - Curso de Android and Kotlin desde cero - Alex Pagoada](https://www.youtube.com/playlist?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)

- [Clase Principal - adrkotlin/MainActivity.kt](https://github.com/eacevedof/prj_adrkotlin/blob/master/app/src/main/java/es/theframework/adrkotlin/MainActivity.kt)
- [15 - Operador Elvis con false](https://youtu.be/Qaa9F4Uv4E4?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=794)
- [21 - RadioButton evento onClick](https://youtu.be/wBPdVE2-aAE?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
- [22 - Tipos de array](https://www.youtube.com/watch?v=PE22BxijE7M&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=22)
    - No existen arrays de tipo string!!
    - se crea así: `val arString = arrayOf("Alex","Aj","Eaf","PDHN")`
- [23 - Bucle ciclo for](https://www.youtube.com/watch?v=I5SBrAXsMxw&index=23&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
    - `for( s in arString) sData = s`
    - `for(i in 0..3) sData = arString.get(i)`
    ```kotlin
    var iString = arString.count()-1
    for(i in 0..iString) sData =  arString.get(i)
    ```
- [24 - Bucle ciclo forEach](https://www.youtube.com/watch?v=KUgzw_I8uqg&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=24)
    ```kotlin
    var arStrings2 = Array<String>(3){""}
    var arStrings3 = Array(3){""}
    var arInts1 = Array<Int>(3){0}
    var arInts2 = Array(3){0}    
  
    //https://youtu.be/KUgzw_I8uqg?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=866
    arString.forEach {
       sItem -> sData = sItem
    }//froeach
    ```
 - [25 - Funcion arrayOfNulls](https://youtu.be/XNkohi44ghA?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)
    ```kotlin
    var arNulls = Array<String?>(3){null}
    arNulls = arrayOfNulls<String>(3)
    ```
 - [26 - Control listView](https://www.youtube.com/watch?v=7Hl24amE8lo&list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&index=26)
    
## Errors
- 1 `Android resource linking failed Output: app\build\intermediates\incremental\mergeDebugResources\merged.dir\values\values.xml:646: 
     error: style attribute 'attr/colorButtonBackground (aka es.theframework.adrkotlin:attr/colorButtonBackground)' not found.`
    - Solución:
    - Quitar de values/styles.xml las propiedades name="colorButtonBackground" 