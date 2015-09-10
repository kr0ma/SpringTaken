package be.vdab.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import be.vdab.entities.Persoon;

//@Repository
//@Qualifier("TXT")
class PersoonDAOMeerdereRegels implements PersoonDAO {
	private final File bestand;

//	@Autowired
	PersoonDAOMeerdereRegels(/*@Value("${persoonDAOTXT}")*/ File bestand) {
		this.bestand = bestand;
	}

	@Override
	public List<Persoon> findAll() throws IOException {
		List<Persoon> personen = new ArrayList<>();
		try (Scanner scanner = new Scanner(bestand)) {
			while (scanner.hasNext()) {
				int persoonNr = scanner.nextInt();
				scanner.nextLine();
				String voornaam = scanner.nextLine();
				String familienaam = scanner.nextLine();
				int aantalKinderen = scanner.nextInt();
				if (scanner.hasNext()) {
					scanner.nextLine();
				}
				personen.add(new Persoon(persoonNr, aantalKinderen, voornaam, familienaam));
			}
		}
		return personen;
	}

}
