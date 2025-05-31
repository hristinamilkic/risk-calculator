package risk;

public class RiskScoring {

    /**
     * Računa rizik prema parametrima, koristeći relevantne smernice iz NIST IoT osnovnih bezbednosnih kontrola
     * i OWASP IoT Top Ten preporuka.
     */
    public static int calculateRisk(int devices, boolean defaultPass, int age, boolean noEncryption) {
        int risk = 0;

        // Više uređaja = veći napadni prostor
        if (devices > 15) risk += 3;
        else if (devices > 7) risk += 2;
        else risk += 1;

        // Default lozinke su velika opasnost
        if (defaultPass) risk += 3;

        // Starija oprema (bez ažuriranja) - ranjivosti
        if (age > 5) risk += 3;
        else if (age > 2) risk += 2;

        // Nema Wi-Fi enkripcije = ozbiljna opasnost
        if (noEncryption) risk += 2;

        // Ograniči na maksimum 10
        return Math.min(risk, 10);
    }
}
