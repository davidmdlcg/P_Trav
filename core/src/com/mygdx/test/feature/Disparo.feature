@probar
Feature: Disparar balas
  Como Profe
  quiero poder disparar con el palo a la pelota
  con el objetivo de mejorar mi punteria

  Scenario Outline: Disparo una bala
    Given tengo <inicial> balas
    When pulso el boton de disparar
    Then me quedan <final> balas

    Examples:
      | inicial | final |
      | 5       | 4     |
      | 4       | 3     |
      | 3       | 2     |
      | 1       | 0     |

  Scenario: Gasto todas las balas
    Given no me quedan balas por disparar
    When pulso el boton de disparar
    Then me aparece un mensaje indicando que he perdido