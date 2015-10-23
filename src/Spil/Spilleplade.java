package Spil;

public class Spilleplade {

	// [En spilleplade der har de forskellige navne til felterne, og deres numre,
	// sammen med deres effekt på ens scorre
	// Der er tre forskellige metoder (D.D. 23-10-15 05:47), disse er:
	// getNytFeltNummer, denne metode skal bruge det nuværende feltnummer
	// altså spillerens nuværende placering inden der rykkes, og den sum
	// spilleren slog med terningerne, den tager højde for hvis man kommer
	// over spillepladens længde (Beskrivelse af denne står længere nede i næste
	// kommentar spor), og derefter returnere den det nye felt.
	// Næste metode er getFeltNavn, denne metode skal bruge spillerens placering
	// på felterne (Ny som gammel), og læser så fra
	// arrayet private String[] FeltNavn, og vil så returnere hvad feltets navn
	// er.
	// Sidste metode er getNyScorre, denne skal bruge spillerens nuværende
	// scorre, og læser så fra tidligere hvilket felt spilleren er på
	// derefter lægges spillerens nuværende scorre sammen med den effekt feltet
	// det står på har, hvad end den er positiv eller negativ
	//
	// Da de to sidste bruger variablen private int NewFelt, er det en
	// forudsætning at metoden getNytFeltNummer er blevet kørt for spilleren,
	// inden de to andre metoder kan fungere rigtigt

	private int SpillePladeLængde = 10;

	// Husk at hvis der ændres på spillepladens længde, skal der sættes
	// dubletter af de allerede eksisterende felter
	// ind igen, lige nu er pladen som i ProjektBeskrivelsen, Dvs. med 11 felter
	// hvor de alle, borteset fra et, har en effekt på ens scorre.
	// For at sætte nye felter ind, skal der tilføjes en scorre effekt (Dvs.
	// hvordan feltet har en effekt på ens scorre), i Arrayet > private int[] Felter <
	// og der skal tilføjes et navn til (OBS VIGTIGT (Navnet skal have det samme
	// placeringsnummer, som den effekt der blev tilføjet))
	//
	// Spilleplade som beskrevet af projektet ( Kan genindsættes hvis der er
	// sket utilsigtede ændringer )
	//
	// private int[] Felter = { 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650 };
	// private String[] FeltNavn = {"Tower", "Crater", "Palace gates", "Cold Desert", "Cold Desert", "Monastery", "Black cave", "Huts in the mountain", "The Werewall", "The pit", "Goldmine"};
	// private int NewFelt = 0;
	// private int NyScorre = 0;

	private int[] Felter = { 250, -100, 100, -20, 180, 0, -70, 60, -80, -50, 650 };
	private String[] FeltNavn = { "Tower", "Crater", "Palace gates", "Cold Desert", "Cold Desert", "Monastery", "Black cave", "Huts in the mountain", "The Werewall", "The pit", "Goldmine" };
	private int NewFelt = 0;
	private int NyScorre = 0;

	public int getNytFeltNummer(int SpillerFelt, int RollSum) {

		NewFelt = 0;

		NewFelt = SpillerFelt + RollSum;

		if (NewFelt > SpillePladeLængde) {

			NewFelt = NewFelt - SpillePladeLængde;
		}

		return NewFelt;

	}

	public String getNytFeltNavn() {

		return FeltNavn[NewFelt];

	}

	public int getNyScorre(int SpillerScorre) {

		NyScorre = 0;

		NyScorre = SpillerScorre + Felter[NewFelt];

		return NyScorre;
	}

}

