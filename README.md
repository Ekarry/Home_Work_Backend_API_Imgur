Тестирование Api документации интернет-магазина

Было протестировано:
Позитивные проверки:
Получение списка продуктов
Получение продукта по ID
Создание продукта
Получение категорий по ID
Удаление продукта
Обновление продукта
Удаление продукта сразу после его создания

Негативные проверки:
Получение продукта по ошибочному ID (code 404)
Создание пустого продукта (code 500)
Создание продукта c длинным именем (code 500)
Удаление несуществующего продукта (code 500)
Обновление продукта с ошибочным ID (code 400)
