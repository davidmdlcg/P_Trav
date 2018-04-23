$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/com/mygdx/test/feature/Disparo.feature");
formatter.feature({
  "name": "Disparar balas",
  "description": "  Como Profe\n  quiero poder disparar con el palo a la pelota\n  con el objetivo de mejorar mi punteria",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Disparo una bala",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "tengo \u003cinicial\u003e balas",
  "keyword": "Given "
});
formatter.step({
  "name": "pulso el boton de disparar",
  "keyword": "When "
});
formatter.step({
  "name": "me quedan \u003cfinal\u003e balas",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "inicial",
        "final"
      ]
    },
    {
      "cells": [
        "5",
        "4"
      ]
    },
    {
      "cells": [
        "4",
        "3"
      ]
    },
    {
      "cells": [
        "3",
        "2"
      ]
    },
    {
      "cells": [
        "1",
        "0"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Disparo una bala",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "tengo 5 balas",
  "keyword": "Given "
});
formatter.match({
  "location": "DisparoStep.tengo_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pulso el boton de disparar",
  "keyword": "When "
});
formatter.match({
  "location": "DisparoStep.pulso_el_boton_de_disparar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me quedan 4 balas",
  "keyword": "Then "
});
formatter.match({
  "location": "DisparoStep.me_quedan_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Disparo una bala",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "tengo 4 balas",
  "keyword": "Given "
});
formatter.match({
  "location": "DisparoStep.tengo_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pulso el boton de disparar",
  "keyword": "When "
});
formatter.match({
  "location": "DisparoStep.pulso_el_boton_de_disparar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me quedan 3 balas",
  "keyword": "Then "
});
formatter.match({
  "location": "DisparoStep.me_quedan_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Disparo una bala",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "tengo 3 balas",
  "keyword": "Given "
});
formatter.match({
  "location": "DisparoStep.tengo_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pulso el boton de disparar",
  "keyword": "When "
});
formatter.match({
  "location": "DisparoStep.pulso_el_boton_de_disparar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me quedan 2 balas",
  "keyword": "Then "
});
formatter.match({
  "location": "DisparoStep.me_quedan_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Disparo una bala",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "tengo 1 balas",
  "keyword": "Given "
});
formatter.match({
  "location": "DisparoStep.tengo_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pulso el boton de disparar",
  "keyword": "When "
});
formatter.match({
  "location": "DisparoStep.pulso_el_boton_de_disparar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me quedan 0 balas",
  "keyword": "Then "
});
formatter.match({
  "location": "DisparoStep.me_quedan_balas(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Gasto todas las balas",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "no me quedan balas por disparar",
  "keyword": "Given "
});
formatter.match({
  "location": "DisparoStep.no_me_quedan_balas_por_disparar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pulso el boton de disparar",
  "keyword": "When "
});
formatter.match({
  "location": "DisparoStep.pulso_el_boton_de_disparar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me aparece un mensaje indicando que he perdido",
  "keyword": "Then "
});
formatter.match({
  "location": "DisparoStep.me_aparece_un_mensaje_indicando_que_he_perdido()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat com.mygdx.test.step.DisparoStep.me_aparece_un_mensaje_indicando_que_he_perdido(DisparoStep.java:75)\n\tat ✽.me aparece un mensaje indicando que he perdido(src/com/mygdx/test/feature/Disparo.feature:22)\n",
  "status": "pending"
});
formatter.uri("src/com/mygdx/test/feature/MoverPala.feature");
formatter.feature({
  "name": "Mover palo",
  "description": "  Como Profe\n  quiero que sólo haya un palo que se pueda mover por todo el tablero\n  con el objetivo de poder moverlo por todo el tablero",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la izquierda",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "muevo el joystick hacia la izquierda",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_izquierda()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia la izquierda",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_la_izquierda()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la derecha",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "muevo el joystick hacia la derecha",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_derecha()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia la derecha",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_la_derecha()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la arriba",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "muevo el joystick hacia la arriba",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_arriba()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia la arriba",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_la_arriba()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la abajo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "muevo el joystick hacia la abajo",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_abajo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia la abajo",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_la_abajo()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la izquierda pasando el borde izquierdo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "un palo en el limite izquierdo de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_limite_izquierdo_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "muevo el joystick hacia la izquierda",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_izquierda()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia el borde derecho de la pantalla",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_el_borde_derecho_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la derecha pasando el borde derecho",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "un palo en el limite derecho de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_limite_derecho_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "muevo el joystick hacia la derecha",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_derecha()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia el borde izquierdo de la pantalla",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_el_borde_izquierdo_de_la_pantalla()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c1440.0\u003e but was:\u003c1.0\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\n\tat org.junit.Assert.assertEquals(Assert.java:575)\n\tat org.junit.Assert.assertEquals(Assert.java:700)\n\tat com.mygdx.test.step.MoverPalaStep.el_palo_se_desplaza_hacia_el_borde_izquierdo_de_la_pantalla(MoverPalaStep.java:245)\n\tat ✽.el palo se desplaza hacia el borde izquierdo de la pantalla(src/com/mygdx/test/feature/MoverPala.feature:34)\n",
  "status": "failed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la arriba pasando el borde superior",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "un palo en el limite superior de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_limite_superior_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "muevo el joystick hacia la arriba",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_arriba()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia el borde inferior de la pantalla",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_el_borde_inferior_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "un palo en el centro de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_centro_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mover palo a la abajo pasando el borde inferior",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@probar"
    }
  ]
});
formatter.step({
  "name": "un palo en el limite inferior de la pantalla",
  "keyword": "Given "
});
formatter.match({
  "location": "MoverPalaStep.un_palo_en_el_limite_inferior_de_la_pantalla()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "muevo el joystick hacia la abajo",
  "keyword": "When "
});
formatter.match({
  "location": "MoverPalaStep.muevo_el_joystick_hacia_la_abajo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el palo se desplaza hacia el borde superior de la pantalla",
  "keyword": "Then "
});
formatter.match({
  "location": "MoverPalaStep.el_palo_se_desplaza_hacia_el_borde_superior_de_la_pantalla()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c2560.0\u003e but was:\u003c18.44714\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\n\tat org.junit.Assert.assertEquals(Assert.java:575)\n\tat org.junit.Assert.assertEquals(Assert.java:700)\n\tat com.mygdx.test.step.MoverPalaStep.el_palo_se_desplaza_hacia_el_borde_superior_de_la_pantalla(MoverPalaStep.java:280)\n\tat ✽.el palo se desplaza hacia el borde superior de la pantalla(src/com/mygdx/test/feature/MoverPala.feature:44)\n",
  "status": "failed"
});
});