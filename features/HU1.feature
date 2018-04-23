# language: es
Cartacterística: Pelotas Aleatorias
    Con el fin de hacer el juego más dinámico
    Como jugador
    Quiero que la pelota aparezca en un sitio aleatorio
    
    Escenario: Inicio de partida
        Dado que el usuario ha iniciado una partida
		Cuando cargue la pantalla
		Entonces la pelota tiene que aparecer en una posición aleatoria
		
	Escenario: Disparar a una pelota
		Dado que la parida esta en curso
		Cuando un disparo le de a la pelota
		Y la pelota desaparezca
		Entonces otra pelota tiene que aparecer en un lugar aleatorio
		