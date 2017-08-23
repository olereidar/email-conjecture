# "Email Conjecture"
Email Conjecture er et prosjekt startet av frivillige studenter. Programmet er under utvikling.
Målet med applikasjonen er å kunne automatisere gjetningsarbeid når man er usikker på en e-post adresse.


## Retningslinjer under utvikling
For at flere skal kunne være med å utvikle dette, er det laget noen retningslinjer. Disse retningslinjene er ment for at alle utviklere skal kunne jobbe på best mulig måte, være i stand til å fortsette der en annen slapp og ikke rote seg bort i kode.

### Kode
Vi holder oss til kodestandardene som tilhører språket vi skriver i. 

#### Kommentarer
Kommentarer skal unngåes så langt det lar seg gjøre. Koden som blir skrevet skal være så forståelig, med god semantikk og kohesjon med resten av prosjeket. Hvis det er noe forretningslogikk som *ikke* er selvforklarende er kommentarer greit.

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
2. Ha heller flere mindre commits der du gjør, enn å endre veldig mange filer på en gang.
3. Ved refaktorering av kode må commit-meldingen starte med enten **[KAIZEN]** eller **[REFAKTORERING]**

#### Pull-requests
Når en **feature** er ferdig skal det lages en Pull Request. Dette gir muligheten for code review. Dette betyr at andre utviklere kan se igjennom hva som er gjort, kommentere det de lurer på, liker eller ikke. 
En Pull Request skal *alltid* godkjennes av en annen før den merges inn i **release**.

## Last ned
```java
    // TODO: komme med første versjon.
```