delete from ALBUNS;
delete from ARTISTAS;

insert into ARTISTAS (id, nome)
     values (1001, 'Serj tankian'),
            (1002, 'Mike Shinoda'),
            (1003, 'Michel Teló'),
            (1004, 'Guns N` Roses');

insert into ALBUNS (id, nome, artista)
     values (1001, 'Harakiri', 1001),
            (1002, 'Black Blooms', 1001),
            (1003, 'The Rough Dog', 1001),
            (1004, 'Post Traumatic', 1002),
            (1005, 'Post Traumatic EP', 1002),
            (1006, 'Where`d You Go', 1002),
            (1007, 'Bem Sertanejo', 1003),
            (1008, 'Bem Sertanejo - O Show (Ao Vivo)', 1003),
            (1009, 'Bem Sertanejo - (1a Temporada) - EP', 1003),
            (10010, 'Use Your IIIlusion I', 1004),
            (10011, 'Use Your IIIlusion II', 1004),
            (10012, 'Greatest Hits', 1004);