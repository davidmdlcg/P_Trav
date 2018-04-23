@probar
Feature: Mover palo
  Como Profe
  quiero que sólo haya un palo que se pueda mover por todo el tablero
  con el objetivo de poder moverlo por todo el tablero

  Background:
    Given un palo en el centro de la pantalla

  Scenario: Mover palo a la izquierda
    When muevo el joystick hacia la izquierda
    Then el palo se desplaza hacia la izquierda

  Scenario: Mover palo a la derecha
    When muevo el joystick hacia la derecha
    Then el palo se desplaza hacia la derecha

  Scenario: Mover palo a la arriba
    When muevo el joystick hacia la arriba
    Then el palo se desplaza hacia la arriba

  Scenario: Mover palo a la abajo
    When muevo el joystick hacia la abajo
    Then el palo se desplaza hacia la abajo

  Scenario: Mover palo a la izquierda pasando el borde izquierdo
    Given un palo en el limite izquierdo de la pantalla
    When muevo el joystick hacia la izquierda
    Then el palo se desplaza hacia el borde derecho de la pantalla

  Scenario: Mover palo a la derecha pasando el borde derecho
    Given un palo en el limite derecho de la pantalla
    When muevo el joystick hacia la derecha
    Then el palo se desplaza hacia el borde izquierdo de la pantalla

  Scenario: Mover palo a la arriba pasando el borde superior
    Given un palo en el limite superior de la pantalla
    When muevo el joystick hacia la arriba
    Then el palo se desplaza hacia el borde inferior de la pantalla

  Scenario: Mover palo a la abajo pasando el borde inferior
    Given un palo en el limite inferior de la pantalla
    When muevo el joystick hacia la abajo
    Then el palo se desplaza hacia el borde superior de la pantalla