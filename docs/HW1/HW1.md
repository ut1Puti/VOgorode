## HW 1

Создал 3 сервиса. Каждый сервис имеет свой SystemController, отвечающий за endpoint'ы "/system/liveness", "/system/readiness".
Метрики находятся на endpoint'е /actuator/metrics, сделаны с использованием spring-actuator и изменением дефолтного /prometheus на /metrics
Информация о приложении сделана с использованием spring-actuator и endpoint'а /info, данные собираются добавлением к gradle task springBoot task'а buildInfo
