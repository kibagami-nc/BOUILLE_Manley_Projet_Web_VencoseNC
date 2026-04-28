CREATE TABLE users (
    id_user SERIAL PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_mobile VARCHAR(20),
    phone_landline VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE bids (
    id_bid SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fk_id_user INTEGER NOT NULL,
    FOREIGN KEY (fk_id_user) REFERENCES users(id_user)
);

CREATE TABLE photos (
    id_photo SERIAL PRIMARY KEY,
    photo_url VARCHAR(255) NOT NULL,
    fk_id_bid INTEGER NOT NULL,
    FOREIGN KEY (fk_id_bid) REFERENCES bids(id_bid)
);

CREATE TABLE threads (
    id_thread SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    fk_id_bid INTEGER NOT NULL,
    FOREIGN KEY (fk_id_bid) REFERENCES bids(id_bid)
);

CREATE TABLE messages (
    id_message SERIAL PRIMARY KEY,
    content VARCHAR(1000) NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fk_id_thread INTEGER NOT NULL,
    fk_id_user INTEGER NOT NULL,
    FOREIGN KEY (fk_id_thread) REFERENCES threads(id_thread),
    FOREIGN KEY (fk_id_user) REFERENCES users(id_user)
);





INSERT INTO users (last_name, first_name, email, phone_mobile, phone_landline, password, is_active) VALUES
('Wamejo', 'Manley', 'manley.wamejo@vencose.nc', '87 12 34', '24 56 78', 'Password123!', TRUE),
('Tein', 'Lea', 'lea.tein@gmail.com', '76 45 89', NULL, 'Password123!', TRUE),
('Kasovimoin', 'Joseph', 'joseph.k@yahoo.fr', '85 67 12', '41 23 89', 'Motdepasse2024', TRUE),
('Poigoune', 'Sophie', 'sophie.poigoune@mls.nc', '79 88 23', NULL, 'Sophie2024', TRUE),
('Boanemoi', 'Pierre', 'pierre.boanemoi@gmail.com', '88 14 56', '46 78 90', 'PierreNc987', TRUE),
('Goromido', 'Marina', 'marina.g@hotmail.fr', '74 33 67', NULL, 'Marina123', FALSE),
('Devillers', 'Lucas', 'lucas.devillers@gmail.com', '78 56 34', '25 67 12', 'LucasD456', TRUE),
('Wenethem', 'Camille', 'camille.w@mls.nc', '87 23 45', NULL, 'Camille789', TRUE);

INSERT INTO bids (title, description, fk_id_user) VALUES
('Toyota Hilux 2018 4x4', 'Toyota Hilux double cabine en tres bon etat, 85000 km, entretien suivi a la concession. Prix 3 800 000 CFP a debattre. Visible a Noumea.', 1),
('Surf 6''2 Channel Islands', 'Planche de surf Channel Islands modele Rocket en bon etat, quelques traces d''usage. Vendue avec leash et housse. Prix 65 000 CFP.', 2),
('Frigo americain Samsung', 'Frigo americain Samsung 550L, distributeur d''eau et glacons, achete il y a 2 ans. Prix 180 000 CFP, a recuperer sur place a Dumbea.', 3),
('Location studio meuble Anse Vata', 'Studio meuble de 30m2 a louer a l''Anse Vata, vue mer partielle, proche commerces. Loyer 95 000 CFP par mois charges comprises.', 4),
('Cours particuliers maths Terminale', 'Etudiant en BTS SIO propose cours de maths niveau lycee. 3000 CFP de l''heure, deplacement possible sur grand Noumea.', 1),
('Materiel de plongee complet', 'Ensemble complet de plongee : combi 3mm taille L, palmes, masque, tuba, gilet stab et detendeur. Le tout pour 145 000 CFP.', 5),
('PS5 avec 3 jeux', 'Console PS5 edition standard, 2 manettes, 3 jeux (FIFA 24, GTA V, Spider-Man 2). Prix 95 000 CFP.', 6),
('Pirogue traditionnelle', 'Pirogue en bois sculptee a la main, 4 metres, parfait etat. Ideale pour la peche cotiere. Prix 250 000 CFP.', 3),
('VTT Decathlon Rockrider', 'VTT Rockrider ST 540, taille L, achete en 2023. Tres peu utilise. Prix 75 000 CFP.', 7),
('iPhone 14 Pro 256Go', 'iPhone 14 Pro noir, 256Go, achete en 2024, sous garantie. Boite et accessoires d''origine. Prix 165 000 CFP.', 2),
('Cours de tahitien', 'Professeur diplomee donne cours de langue tahitienne tous niveaux. 2500 CFP la seance d''une heure.', 8);

INSERT INTO threads (title, fk_id_bid) VALUES
('Negociation prix Hilux', 1),
('Question kilometrage', 1),
('Etat de la planche', 2),
('Disponibilite frigo', 3),
('Visite studio', 4),
('Tarifs cours maths', 5),
('Composition pack plongee', 6),
('Reservation PS5', 7),
('Question pirogue', 8),
('Negociation iPhone', 10);

INSERT INTO messages (content, fk_id_thread, fk_id_user) VALUES
('Bonjour, est-ce que vous pourriez descendre a 3 500 000 CFP pour le Hilux ?', 1, 5),
('Bonjour, je peux descendre a 3 700 000 CFP maximum, le vehicule est tres bien entretenu.', 1, 1),
('Ok, est-ce que je peux venir le voir ce week-end ?', 1, 5),
('Pas de probleme, samedi matin vers 9h ca vous va ?', 1, 1),
('Bonjour, le kilometrage est-il certifie par le carnet d''entretien ?', 2, 7),
('Oui tout a fait, j''ai tout l''historique a la concession Toyota.', 2, 1),
('Bonjour, la planche a-t-elle deja ete reparee ?', 3, 6),
('Non aucune reparation, juste des traces d''usage normales sur le pont.', 3, 2),
('Le frigo est-il toujours disponible ?', 4, 4),
('Oui toujours dispo, vous pouvez venir le chercher quand vous voulez.', 4, 3),
('Bonjour, peut-on visiter le studio en semaine apres 17h ?', 5, 7),
('Oui sans souci, je vous propose mardi a 17h30.', 5, 4),
('Parfait, je serai la.', 5, 7),
('Bonjour, faites-vous des forfaits pour plusieurs seances ?', 6, 8),
('Oui, 25 000 CFP les 10 heures au lieu de 30 000 CFP.', 6, 1),
('Le pack plongee comprend-il un ordinateur de plongee ?', 7, 2),
('Non desole, l''ordinateur n''est pas inclus dans le lot.', 7, 5),
('Je suis interesse par la PS5, est-elle encore dispo ?', 8, 8),
('Oui toujours dispo.', 8, 6),
('La pirogue est-elle livree avec une pagaie ?', 9, 4),
('Oui, deux pagaies sculptees sont incluses dans le prix.', 9, 3),
('Bonjour, accepteriez-vous 150 000 CFP pour l''iPhone ?', 10, 5),
('Je peux faire 158 000 CFP, c''est mon dernier prix.', 10, 2),
('Marche conclu, comment procede-t-on pour le paiement ?', 10, 5);
