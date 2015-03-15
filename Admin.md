# Introduction #

Admin program structure.


# Details #

Sistemul CGYMPoker prezinta o interfata Web de monitorizare, realizata prin
tehnologia JSP, prin care un administrator poate urmari, la cerere, starea
curenta a serverului. Actiunile care pot fi intreprinse de un admin sunt urmatoarele:
> - listarea turneelor
> - creearea unui turneu
> - pornirea unui turneu
> - listarea si monitorizarea statusului tuturor utilizatorilor inregistrati
> - stergerea contului unui utilizator
Dupa pagina de autentificare a administratorului, se deschide pagina(welcome.jsp) care contine lista turneelor de pe server. Tot in aceasta pagina
se permite adminului creearea, respectiv pornirea de noi turnee. Acest lucru se realizeaza cu ajutorul tehnoligiei RMI. Prin RMI se acceseaza obiectul ServerCentral(obiect de pe server) si pentru crearea sau pornirea unui turneu sunt apelate metodele specifice de pe server(pagina de jsp este un client RMI la serverul central). Informatiile necesare pentru crearea unui turneu sunt introduse intr-un form(TournamentForm.html). Pentru transmiterea datelor intre fisierele jsp s-au folosit JavaBeans.