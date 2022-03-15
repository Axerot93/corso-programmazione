create view v_corsi_ok as v_corsi_ok
SELECT upper(titolo_corso), id_corso, durata, descrizione, 
data_inizio,costo_corso,datacreazione, costo_corso*(1/(1+o.ivastd)) as prezzo_noiva 
FROM DBscuola.t_corsi, t_opzioni o;