@Login
Feature: Log in

  Scenario: El usuario nuevo se registra en Sevenly
    Given Ingresa a la app y selecciona registrate
    When ingresa los datos email aleatorio y password "Prueba123*"
    Then el usuario nuevo ingresa a Sevenly



