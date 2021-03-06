# KrsEvents
## Hack4Universitetsbyen

### By "Salt Mine Workers", as part of our SaltMineHackathon
Om idéen

KrsEvents er en app til Android som knytter folk sammen ved hjelp av lokasjonsdata og tilrettelegger for studenter og nyinnflyttede som ønsker et nettverk for å bli integrert i Kristiansand. Appen er også til for alle som allerede bor på sørlandets perle, men kanskje ønsker å finne på noe nytt med andre.

Applikasjonen er ment til å fremvise lokasjonsdata basert på hvilke interesser brukeren har. I førsteomgang er den programmert til at du selv kan velge hva du ønsker å få opp (Idrett, Rekreasjon og kultur er valgene nå) og basert på valget får du opp lokasjonsdata tilhørende temaet du valgte i form av markører på et kart. Disse kartene representerer nøkkel-mål innen temaet, som for eksempel idrettshaller og fotballbaner dersom du velger idrett.

Med videreutvikling vil man kunne trykke på en markør og få opp informasjon om relevante events i fremtiden på den lokasjonen, og det skal fargekodes basert på aktivitetsnivå så man har en indikasjon av hvilke steder det skjer ting. I tillegg skal brukere kunne opprette arrangementer på disse stedene, for eksempel om en kompisgjeng på 7 stykker ser etter noen flere til å spille fotball 5 mot 5 neste kveld.

Når appen videreutvikles vil dette baseres på interesser som kan settes opp ved førstegangsinnstallering hos brukeren, eller eventuelt basert på liker-klikk på Facebook slik at man får skreddersydd innhold. Det å få innholdet skreddersydd kan man også påvirke direkte ved å endre på innstillingene. Foreløpig er det begrenset funksjonalitet der, på bakgrunn av vår mangel av sorteringsalgoritmer for interessene. Dette vil bli lagt til ved en senere anledning. 

Eksempel på events som kan opprettes og avholdes gjennom appen: fotballturneringer, fester, konserter, fagkvelder, etc. 

Det er ønskelig med et samarbeid med Universitetet i Agder og Kristiansand Kommune for å få synliggjort appen og tiltrekke seg brukere. Dette kan forhåpentligvis fås til om studentaktivitetene tar i bruk appen for å ha en samlingsportal for events og samlinger. Til den tid skal det være best mulig integrert med Facebook for innlogging gjennom FB og mulighet for deling av events direkte til Facebook.

### Teknisk

Prosjektet er utviklet i Java, i Android Studio for Android 7.0. For bruk av datasett konverterte vi de aktuelle datasettene for dette stadiet ved å konvertere JSON til .kml ved hjelp av en converter, og videre implementert disse data ved Google Maps API og google-maps-utils. Autentisering er ikke implementert i denne versjonen (sjekk av credentials er satt vekk). For å illustrere bruk av profildata opprettet vi en lokal UserModel-klasse, som konstrueres ved oppstart.
