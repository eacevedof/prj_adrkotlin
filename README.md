# prj_adrkotlin

## [Youtube - Curso de Android and Kotlin desde cero - Alex Pagoada](https://www.youtube.com/playlist?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)

- [Clase Principal - adrkotlin/MainActivity.kt](https://github.com/eacevedof/prj_adrkotlin/blob/master/app/src/main/java/es/theframework/adrkotlin/MainActivity.kt)
- [15 - Operador Elvis con false](https://youtu.be/Qaa9F4Uv4E4?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS&t=794)
- [21 - RadioButton evento onClick](https://youtu.be/wBPdVE2-aAE?list=PLfkODrpjGnhmzRSUC5L-M_BjkyavnSKXS)

## Errors
- 1 `Android resource linking failed Output: app\build\intermediates\incremental\mergeDebugResources\merged.dir\values\values.xml:646: 
     error: style attribute 'attr/colorButtonBackground (aka es.theframework.adrkotlin:attr/colorButtonBackground)' not found.`
    - Solución:
    - Quitar de values/styles.xml las propiedades name="colorButtonBackground" 