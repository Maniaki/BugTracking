INSERT INTO DEV(id, firstname, lastname, avatar) VALUES
  (1, 'Bill', 'Gates','https://img2.freepng.fr/20180723/jji/kisspng-computer-icons-system-administrator-clip-art-administrator-icon-5b55e5abe6c9b4.2869445815323560119453.jpg'),
  (2, 'Hermann', 'Gottlieb','https://img2.freepng.fr/20180723/jji/kisspng-computer-icons-system-administrator-clip-art-administrator-icon-5b55e5abe6c9b4.2869445815323560119453.jpg'),
  (3, 'Dennis', 'Nedry','https://img2.freepng.fr/20180723/jji/kisspng-computer-icons-system-administrator-clip-art-administrator-icon-5b55e5abe6c9b4.2869445815323560119453.jpg'),
  (4, 'Elon', 'Musk','https://img2.freepng.fr/20180723/jji/kisspng-computer-icons-system-administrator-clip-art-administrator-icon-5b55e5abe6c9b4.2869445815323560119453.jpg'),
  (5, 'Alan', 'Turing','https://img2.freepng.fr/20180723/jji/kisspng-computer-icons-system-administrator-clip-art-administrator-icon-5b55e5abe6c9b4.2869445815323560119453.jpg');

INSERT INTO BUG(id, title, description, creationdate, devid, priority, state) VALUES
  (1, 'Impossible Logout/WEB', 'Depuis les paramêtres le bouton logout ne fonctionne pas', '2020-09-02',1, 'LOW',
   'TODO'),
  (2, 'Images ne chargent pas/WEB', 'Sur la page de customisation les images restent blanches', '2020-09-13',1, 'HIGH'
  , 'TODO'),
  (3, 'Exeption non supportée/WEB', 'Sur les formulaires l entrée de nombres aux lieu d un String bloque le chargement'
  ,'2020-10-06',4, 'NORMAL', 'TODO'),
  (4, 'Service notification HS/APP', 'Le service n envoie plus de notification depuis la dernière maj', '2020-10-06',2,
   'NORMAL', 'TODO'),
  (5, 'Mauvais affichage web mobile/WEB', 'La barre du haut ne s affiche pas sur certains appareils', '2020-10-18',3,
  'LOW', 'TODO'),
  (6, 'Liste défilemment magasin/APP', 'Si un click est réalisé en bas de la liste page magasin les items font un bond vers le bas'
  , '2020-10-22',5, 'LOW', 'TODO'),
   (7, '404 Profil/WEB', 'L onglet profil produit des erreurs 404', '2020-11-01',5, 'HIGH', 'TODO'),
  (8, 'Accès stockage manuel/APP', 'La notification de permissions d accès au stockage ne s affiche pas sur certains appareils'
  , '2020-11-04',5, 'HIGH', 'TODO');