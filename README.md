# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Sacir Turkovic, S333785, s333785@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Sacir Turkovic har hovedansvar for 1, 2, 3, 4, 5, 6 og 8.

# Oppgavebeskrivelse

I oppgave 1 så lagde vi metoden int antall og boolean tom der den som kommer først skal gi antall verdier det er, så skal den andre returnere true eller false om listen er tom eller ikke.

Etter det så lagde vi dobbeltlenketliste Kunstruktør som lager en dobbelt lenket liste med verdier fra a. Vi skal putte verdiene i rekkefølegen som i tabellen. Bruker en requireNonNull for å sjekke om a er null. Bruker en if for å sjekke om liste a ikke er null. Bruker if setninger som sjekkere antallet og avhengig av antallet så setter jeg hode og hale tilsvarende og føge tegningen.

I oppgave 2 

a) lagde vi toString som skal gi tilbake en streng med verdier av listen. Sjekker først om antallet(listen) er 0. Så bruker jeg StringBuilder Så starter jeg med hode (venstre til høyre). bruker Stringbuilder ved å få node(hode) verdi, så til neste node. Bruker while løkke sånn at vi ikke skriver ut null verdiene. I while løkken skriver den ut verdiene som ikke er nul, så går den til neste node og neste.

b) Samme som over, men starter fra hale istedenfor hode for å gå omvendt vei.

I oppgave 3 

a)Lager først hjelpemetoden Node<T> finnNode(int indeks) som retunerer noden med indeksen vi putter inn. Bruker if om antall/2 er mindre enn indeks så starter vi fra hode mot hale og else starter fra hale til hode. Høyre til venstre, tar hode lik current tar en løkke som kjører fra 0 til indeksen og returnerer tallet. SAmme under, men hale istedenfor hode og starter fra toppen av liste og ned mot indeksen.

Så i T hent metoden først bruker jeg indekskontroll fra kompendiet for å sjekke indeks og bruker false som parameter. så returnere jeg indeksen verdi ved bruk av finnNode metoden vi lagde tidligere.

I T Oppdater Sjekker først bruker jeg indekskontroll fra kompendiet for å sjekke indeks og bruker false som parameter, Så om nyVerdi ikke er null med requireNonNull fra Object. Peker til den noden fra indeks ved hjelp av finnNode metoden og bytter den med nyVerdi, endriger går opp og returnerer den verdien vy byttet ut.

b) Returnerer liste med istansav klassen DobbeltLenketListe som inneholder verdiene fra, til. Bruker fraTilKontroll for å sjekke om fra til er lovlig. Kaller DobbeltLenketListe, så lager jeg for løkken som kjører fra til. i den så verdi som er fra klassen med leggInn() fra beholder og hent() fra Liste.

I Oppgave 4

Lagde metoden int indeksTil(T verdi) Starter fra hode og løpper gjennom løkken så en if som sjekker om start(hode) verdi er lik verdi og om den er lik returnerer den i om ikke går den til neste node med start = start.neste. Så returnerer den -1.

I boolean inneholder(T verdi) jeg bruker metoden indeksTil som jeg lsgde tidligere og bruker den i if setningen med verdi og sjekker om den er større eeller lik 0 om den er det returnerer den true om ikke returnerer den false.

I oppgave 5


