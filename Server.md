# Introduction #

Add your content here.


# Details #

Rmi in CGYMPoker

Sistemul este format din 3 proiecte:

Server-ul - aici ruleaza jocurile de fapt, fiecare jucator, masa, carte, etc... este un obiect. Aceste ob
e obiecte sunt remote (extind Remote) si sunt observate de catre client.

Clientul - este doar o interfata grafica in swing, cu observeri pentru turnee si masa.
Butoanele de pe client apeleaza de fapt metode ale obiectelor instantiate pe server.

Admin - este un proiect cu jsp, i se permite administratorului sa creeze si sa porneasca turnee.Daca administratorul
porneste un turneu, se instantiaza un obiect pe server, si toti clientii sunt notificati.


Server :
Clasa principala este ServerCentralImpl. Aici sunt toate turneele. Fiecare turneu are mese si jucatori.
Exista doua tipuri de jucatori : Player (acestia sunt oponentii fiecarui jucator) si Felix: reprezinta
fiecare jucator logat si care e repartizat la o masa la inceputul turneului.