INSERT INTO DEV(id, firstname, lastname, avatar) VALUES
  (1, 'Bill', 'Gates',),
  (2, 'Hermann', 'Gottlieb',),
  (3, 'Dennis', 'Nedry',);
  (4, 'Elon', 'Musk',);
  (5, 'Alan', 'Turing',);

INSERT INTO BUG(id, title, description, creationdate, dev, priority, state) VALUES
  (1, 'Impossible Logout/WEB', 'Depuis les paramêtres le bouton logout ne fonctionne pas', '02-09-2020',d, 'BASSE',
   'TODO'),FROM Dev d WHERE d.id = 1;
  (2, 'Images ne chargent pas/WEB', 'Sur la page de customisation les images restent blanches', '13-09-2020',, 'HAUTE'
  , 'TODO'),
  (3, 'Exeption non supportée/WEB', 'Sur les formulaires l\'entrée de nombres aux lieu d\'un String bloque le chargement'
  ,'06-10-2020',, 'NORMALE', 'TODO'),
  (4, 'Service notification HS/APP', 'Le service n\'envoie plus de notification depuis la dernière maj', '06-10-2020',,
   'NORMALE', 'TODO'),
  (5, 'Mauvais affichage web mobile/WEB', 'La barre du haut ne s\'affiche pas sur certains appareils', '18-10-2020',,
  'BASSE', 'TODO'),
  (6, 'Liste défilemment magasin/APP', 'Si un click est réalisé en bas de la liste page magasin les items font un bond vers le bas'
  , '22-10-2020',, 'BASSE', 'TODO'),
  (7, '404 Profil/WEB', 'L\'onglet profil produit des erreurs 404', '01-11-2020',, 'HAUTE', 'TODO'),
  (8, 'Accès stockage manuel/APP', 'La notification de permissions d\'accès au stockage ne s\'affiche pas sur certains appareils'
  , '04-11-2020',, 'HAUTE', 'TODO');