# language: es
Cartacterística: Generación periodica de pelotas
    Con el fin de aumentar la dificultad del juego
    Como jugador
    Quiero que cada 10 segundos se genere una nueva pelota
	
	Antecedentes:
		Dado que la parida esta en curso
		
    Escenario: Generación de pelota
		Dado que se ha generado la primera pelota
		Cuando se cumplan diez segundos después de la aparición de una pelota
		Entonces otra pelota tiene que aparecer
		
	Escenario: Reinicio del contador
		Dado que el usuario ha destruido un pelota
		Y se haya generado una nueva pelota
		Cuando se cumplan diez segundos después de la aparición de la nueva pelota
		Entonces otra pelota tiene que aparecer
		Pero no tiene que aparecer otra antes
		