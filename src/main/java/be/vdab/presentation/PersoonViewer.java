package be.vdab.presentation;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import be.vdab.entities.Persoon;
import be.vdab.enums.PersoonEigenschap;
import be.vdab.services.PersoonService;

@Controller
public class PersoonViewer {
	PersoonEigenschap[] persoonEigenschappen;
	PersoonService persoonService;

	public PersoonViewer(PersoonEigenschap[] persoonEigenschappen,PersoonService persoonService ) {
		this.persoonEigenschappen = persoonEigenschappen;
		this.persoonService = persoonService;
	}

	public void afbeelden() throws IOException {
		for (Persoon persoon : persoonService.findAll()) {
			for (PersoonEigenschap eigenschap : persoonEigenschappen) {
				toonEigenschap(persoon, eigenschap);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	private void toonEigenschap(Persoon persoon, PersoonEigenschap eigenschap) {
		switch (eigenschap) {
		case PERSOON_NR:
			System.out.print(persoon.getPersoonNr());
			break;
		case VOORNAAM:
			System.out.print(persoon.getVoornaam());
			break;
		case FAMILIENAAM:
			System.out.print(persoon.getFamilienaam());
			break;
		case AANTAL_KINDEREN:
			System.out.print(persoon.getAantalKinderen());
			break;
		}
	}

}
