# language: es
Cartacterística: Destruir una pelota
    Con el fin de crear una sensación de progreso
    Como jugador
    Quiero que mis disparos rompan las pelotas al tocarlas
    
    Escenario: Disparo
		Dado que la partida esté en curso
		Y que el jugador haya disparado
		Cuando el disparo toque la pelota
		Entonces la pelota tiene que desaparecer
		Y el siparo tiene que desaparecer
		Y otra pelota tiene que aparecer
		
		