[![Build Status](https://travis-ci.org/olereidar/email-conjecture.svg?branch=master)](https://travis-ci.org/olereidar/email-conjecture)
# "Email Conjecture"
Email Conjecture er et prosjekt startet av frivillige studenter. Programmet er under utvikling.
Målet med applikasjonen er å kunne automatisere gjetningsarbeid når man er usikker på en e-post adresse.


## Retningslinjer under utvikling
For at flere skal kunne være med å utvikle dette, er det laget noen retningslinjer. Disse retningslinjene er ment for at alle utviklere skal kunne jobbe på best mulig måte, være i stand til å fortsette der en annen slapp og ikke rote seg bort i kode.

### Kode
Vi holder oss til kodestandardene som tilhører språket vi skriver i. 

#### Kommentarer
Kommentarer skal unngås så langt det lar seg gjøre. Koden som blir skrevet skal være enkel, og ha god semantikk og kohesjon med resten av prosjeket. Hvis det er noe forretningslogikk som *ikke* er selvforklarende, er kommentarer greit.

Dersom funksjonalitet ikke er implementert enda, skal kommentar **TODO** legges til. Eksempel følger under: 
```java
    private String generateRandomNames() {
        // TODO: Implementere tilfeldig navn
        return "Mark";
    }
```

### GitHub
Alt som utvikles skal legges ut her på GitHub. Videre følger tips og veiledning til hvordan Git- skal håndteres i dette prosjektet.

#### Branches

Hver gang du skal utvikle noe nytt lager du en **feature** ut ifra den *nyeste* brachen. Den nyeste branchen er som oftest **release**.
Branchene skal navngies på en slik måte at andre forstår hva du jobber med. For eksempel hvis du jobber med en ny feature som skal "optimalisere noe", er et godt brachnavn **feature/optimalisere-noe**

1. **master** - Her ligger ferdig testet nyeste versjon av programmet. **Ingenting** skal dyttes rett til master uten godkjenning.
2. **release** - Her ligger det vi har utviklet sammen, men er ikke nødvendigvis testet ferdig. Kan ses på som beta og er satt sammen av ulike **feature**-braches
3. **feature** - Her ligger det vi jobber med akkurat nå. En release består av ulike features. Når en feature er ferdig legges denne inn i release.

#### Commits
1. Alle commits må inneholde en melding som forteller hva som er gjort. 
2. Ha heller mindre commits, enn å endre veldig mange filer på en gang.
3. Ved refaktorering av kode må commit-meldingen starte med enten **[KAIZEN]** eller **[REFAKTORERING]**

#### Pull-requests
Når en **feature** er ferdig skal det lages en Pull Request. Dette gir muligheten for code review. Dette betyr at andre utviklere kan se igjennom hva som er gjort, kommentere det de lurer på, liker eller ikke. 
En Pull Request skal *alltid* godkjennes av en annen før den merges inn i **release**.

## Kom i gang med utvikling
For å komme i gang med utvikling trenger du følgende:
1. Et utviklingsverktøy som støtter Maven (for eksempel [IntelliJ](https://www.jetbrains.com/idea/) eller [Eclipse](https://eclipse.org/))
2. [Git](https://git-scm.com/)-bash, eller [GitHub Desktop](https://desktop.github.com/) hvis du foretrekket GUI fremfor terminal
3. Java 8 JDK

Når du har utviklingsverktøyene på plass og riktig satt opp, kan du begynne å sette opp.
- Klon repoet med Git i en passende mappe. 
```git
$ cd .\passendeMappe
$ git clone https://github.com/olereidar/email-conjecture.git
``` 
- Åpne utviklingsverktøyet og lag et nytt prosjekt. Et hot tips for å sette opp alt riktig i **IntelliJ**, er å lage prosjektet ved å åpne filen *pom.xml*. Dette laster ned alle avhengigheter som treng for å kjøre programmet. 
- For å kjøre programmet lokalt, se i mappen *test/java*. Der skal det ligge et Entrypoint som heter *App.java*


## Last ned
Du kan laste ned ferdig kompilert program ved å gå inn i mappen *release*, eller bruke direktelenken under:
[Last ned](https://raw.githubusercontent.com/olereidar/email-conjecture/første-release/release/email-conjecture.jar)

### Kjør programmet
1. Last ned programmet
2. Start kommandolinja
3. Flytt deg inn i mappen du lastet ned programmet.
4. Start programmet med Java's -jar flagg (Se eksempel under.)

```git
$ cd .\lokasjonenTilProgrammet
$ java -jar email-conjecture.jar -h
```
