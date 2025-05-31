# 📄 IoT Kalkulator rizika

## 🔍 Šta procenjuje?
Ovaj kalkulator koristi 4 ključna parametra za procenu rizika kućne IoT mreže:
1️⃣ **Broj uređaja** – Više uređaja znači više potencijalnih napadnih tačaka.  
2️⃣ **Default lozinke** – Poznate lozinke su meta za hakere (OWASP IoT #1).  
3️⃣ **Starost uređaja** – Starija oprema retko dobija zakrpe.  
4️⃣ **Wi-Fi enkripcija** – Nedostatak enkripcije izlaže saobraćaj prisluškivanju (NIST).

## ⚙️ Kako se računa?
- **Broj uređaja**:  
  - >15 ➜ 3 poena  
  - 8–15 ➜ 2 poena  
  - 1–7 ➜ 1 poen

- **Default lozinke**:  
  - "da" ➜ +3

- **Starost uređaja**:  
  - >5 god ➜ +3  
  - 3–5 god ➜ +2  

- **Wi-Fi enkripcija**:  
  - Nema ➜ +2  

Ukupan rizik se prikazuje na skali od **0–10** (veće = opasnije).

## 📚 Relevantni izvori
- [OWASP IoT Top Ten](https://owasp.org/www-project-internet-of-things/)  
- [NIST SP 800-183 IoT](https://csrc.nist.gov/publications/detail/sp/800-183/final)  
- EU Cyber Resilience Act – preporuke za pametne uređaje

---

✅ **Dizajn**: moderni “Nimbus” stil + ikone/emodžiji za bolje korisničko iskustvo.  
✅ **Preciznost**: bazirano na stvarnim preporukama i istraživanjima.  
✅ **Jasno i jednostavno**: svako može lako uneti parametre i odmah videti rezultat.
