# 06-Espera_wait/Readme.md

## 1. Per què s’atura l’execució al cap d’un temps?

L'execució s'atura al cap d'un temps perquè els fils (`Assistent`) estan en un bucle infinit (`while (true)`), i cada fil realitza accions de reserva o cancel·lació de manera aleatòria. Com que no hi ha una condició de sortida del bucle, els fils continuen executant-se indefinidament. No obstant això, el programa principal (`Organitzador`) no té cap mecanisme per aturar els fils, de manera que l'execució continua fins que l'usuari decideixi aturar el programa manualment (per exemple, tancant la terminal o utilitzant una comanda com `Ctrl+C`).

---

## 2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar)? I si foren al revés les probabilitats?

### Cas 1: Probabilitat 70% ferReserva - 30% cancel·lar
En aquest cas, és més probable que les places disponibles s'esgotin ràpidament, ja que hi ha més sol·licituds de reserva que de cancel·lacions. Els assistents que intentin fer una reserva quan no hi hagi places disponibles es quedaran en espera (wait()), i només podran continuar quan algun altre assistent cancel·li una reserva. Això pot provocar que molts assistents quedin bloquejats esperant que es alliberin places.

### Cas 2: Probabilitat 30% ferReserva - 70% cancel·lar
En aquest cas, és més probable que les places disponibles augmentin, ja que hi ha més cancel·lacions que reserves. Això fa que els assistents que estan en espera (wait()) siguin notificats més sovint per a fer reserves, i és menys probable que es quedin bloquejats per falta de places. Les places tendeixen a estar disponibles més temps, i els assistents poden fer reserves amb més facilitat.

## 3. Per què creus que fa falta la llista i no valdria només amb una variable sencera de reserves?
La llista assistents és necessària perquè permet gestionar de manera individual les reserves de cada assistent. Si només s'utilitzés una variable sencera per comptar les places disponibles, no es podria:

Verificar si un assistent ja ha fet una reserva: La llista permet comprovar si un assistent ja està a la llista abans d'afegir-lo, evitant duplicats.

Cancel·lar reserves de manera específica: La llista permet eliminar un assistent concret quan cancel·la la seva reserva. Amb una variable sencera, no es podria saber quins assistents han fet reserves.

Notificar als assistents en espera: La llista ajuda a gestionar qui està esperant i qui ha de ser notificat quan es cancel·la una reserva.