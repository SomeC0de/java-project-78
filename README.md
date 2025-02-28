### Hexlet tests and linter status:
[![Actions Status](https://github.com/SomeC0de/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/SomeC0de/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/9c6e06cecc2eb9dae356/maintainability)](https://codeclimate.com/github/SomeC0de/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/9c6e06cecc2eb9dae356/test_coverage)](https://codeclimate.com/github/SomeC0de/java-project-78/test_coverage)

## Описание
Валидатор данных - это библиотека, созданная для проверки корректности введенных данных. 
Поддерживается возможность валидация следующих объектов:
* String;
* Integer;
* Map;
* Вложенные схемы валидации.

## Примеры использования библиотеки

### String
* required() – не позволяет использовать null или пустую строку в качестве значения;
* minLength(N) – строка равна или длиннее указанного числа N;
* contains(substring) – строка содержит определённую подстроку substring.

```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();
StringSchema schema = v.string();

assertThat(schema.isValid(null)).isTrue();
assertThat(schema.isValid("")).isTrue();

schema.required();

assertThat(schema.isValid("")).isFalse();
assertThat(schema.isValid(null)).isFalse();

assertThat(schema.isValid("what does the fox say")).isTrue();
assertThat(schema.isValid("hexlet")).isTrue();
schema.shape(schemas);

schema.minLength(7);
assertThat(schema.isValid("what does the fox say")).isTrue();
assertThat(schema.isValid("hexlet")).isFalse();

assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();

assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();

var schema1 = v.string().required().minLength(10).minLength(4);
assertThat(schema1.isValid("hexlet")).isTrue();
```

### Number
* required() – не позволяет использовать null в качестве значения;
* positive() – ограничение на знак числа (число должно быть положительным);
* range(low, high) – допустимый диапазон, в который должно попадать значение числа включая границы (low и high).

```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();
var schema = v.number();

assertThat(schema.isValid(5)).isTrue();
assertThat(schema.isValid(null)).isTrue();
assertThat(schema.positive().isValid(null)).isTrue();

schema.required();

assertThat(schema.isValid(null)).isFalse();
assertThat(schema.isValid(10)).isTrue();

assertThat(schema.isValid(-10)).isFalse();
assertThat(schema.isValid(0)).isFalse();

schema.range(5, 10);

assertThat(schema.isValid(5)).isTrue();
assertThat(schema.isValid(10)).isTrue();
assertThat(schema.isValid(4)).isFalse();
assertThat(schema.isValid(11)).isFalse();
```

### Map
- required() – ограничение, которое не позволяет использовать null в качестве значения, требуется тип данных Map;
- sizeof(N) – ограничение на размер мапы - количество пар ключ-значений в объекте Map должно быть равно N.

```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

var v = new Validator();
var schema = v.map();

assertThat(schema.isValid(null)).isTrue();

schema.required();

assertThat(schema.isValid(null)).isFalse();
assertThat(schema.isValid(new HashMap<>())).isTrue();
var data = new HashMap<String, String>();
data.put("key1", "value1");
assertThat(schema.isValid(data)).isTrue();

schema.sizeof(2);

assertThat(schema.isValid(data)).isFalse();
data.put("key2", "value2");
assertThat(schema.isValid(data)).isTrue();
```

### Вложенная валидация в Map
- shape(Map<String, BaseSchema> schemesSet) - schemesSet задает набор валидаторов для каждого значений ключа проверяемого объекта Map.
```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

// shape - позволяет описывать валидацию для значений объекта Map по ключам.
var v = new Validator();
var schema = v.map();

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

schema.shape(schemas);

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
assertThat(schema.isValid(human1)).isTrue();

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
assertThat(schema.isValid(human2)).isFalse();

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
assertThat(schema.isValid(human3)).isFalse();
```

