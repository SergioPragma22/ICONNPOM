@Login
Feature: Log in

  Scenario: El usuario nuevo se registra en Sevenly
    Given Ingresa a la app y selecciona registrate
    When ingresa los datos email aleatorio y password "Prueba123*"
    Then el usuario nuevo ingresa a Sevenly


  Scenario: El usuario ingresa a Sevenly con sus credenciales
    Given Ingresa a la app e ingresa sus credenciales
    Then el usuario ingresa a Sevenly


  Scenario: Iniciar sesion como invitado
    Given el usuario abre la app como invitado
    When acepta los permisos de ubicacion


  @Test
  Scenario: Ver sucursales como invitado
    Given el usuario abre la app como invitado
    When acepta los permisos de ubicacion
    And da click en el boton menu
    Then da click en sucursales y ve el mapa


