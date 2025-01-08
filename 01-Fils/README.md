
# 01-Fils - Exercici de Fils en Java

Aquest projecte conté el codi necessari per demostrar la creació i gestió de fils en Java, utilitzant les tècniques descrites en la teoria de la carpeta "Processos i fils" (pàgines 6 a 10). L'exercici inclou diferents comportaments de fils que s'executen de manera alternativa per a simular processos concurrent i intercalats.

## Contingut de la carpeta

- **Principal.java**: Conté la classe principal que gestiona la creació i execució dels fils "Juan" i "Pepe", implementant alternança estricta mitjançant el mètode `join()`, ajustant les prioritats i utilitzant pauses controlades amb `sleep()`.
  
- **Fil.java**: Conté la definició de la classe `Fil`, que estèn `Thread` i defineix el comportament de cada fil, imprimint el nom del fil i el número d'iteració.

- **README.md**: Aquest fitxer que documenta el codi i els resultats obtinguts.

## Com executar el codi

1. **Compilar el codi**:
   - Obre una terminal a la carpeta on es troben els fitxers `.java` i utilitza la següent ordre per compilar els arxius:
     ```bash
     javac Principal.java Fil.java
     ```

2. **Executar el programa**:
   - Un cop compilat, executa el programa amb la següent ordre:
     ```bash
     java Principal
     ```

3. **Resultats esperats**:
   El programa imprimeix una sèrie de missatges a la consola seguint l'ordre alternat entre els fils "Juan" i "Pepe". Els resultats es mostren a continuació.

## Comportament i Resultats Obtinguts

### **Execució 1: Ordre alternat estricte entre fils**

El codi està dissenyat per garantir que els fils "Juan" i "Pepe" s'executin en un ordre estricte alternatiu. La sortida serà la següent:

```
Termina thread main
Juan 1
Pepe 1
Juan 2
Pepe 2
Juan 3
Pepe 3
Juan 4
Pepe 4
Juan 5
Pepe 5
Juan 6
Pepe 6
Juan 7
Pepe 7
Juan 8
Pepe 8
Juan 9
Pepe 9
Termina el fil Juan
Termina el fil Pepe
```

### Explicació dels Resultats:
- Els fils "Juan" i "Pepe" s'executen de manera intercalada per assegurar que els números es mostren en ordre estricte alternatiu.
- Es fa servir el mètode `join()` per garantir que un fil finalitzi la seva iteració abans que l'altre comenci, controlant així l'ordre de l'execució.
- Es fa servir `sleep()` dins de cada fil per evitar que un fil monopolitzi el temps de CPU i per permetre que l'altre fil tingui temps de ser executat.

### **Comportament esperat**:
- Cada fil ha de mostrar el seu nom seguit d'un número de l'1 al 9, amb "Juan" i "Pepe" alternant-se estrictament en l'ordre d'execució.
- El programa finalitza amb els missatges "Termina el fil Juan" i "Termina el fil Pepe".

## Conclusió

Aquest projecte demostra l'ús de fils en Java per a executar tasques de manera concurrent i controlada. L'ús de `join()`, `sleep()`, i l'ajust de les prioritats dels fils permet una sincronització eficient i un control d'execució entre fils.
