delete from user;
delete from worlds;
delete from continents;
delete from regions;
delete from locations;
delete from owners;
delete from shops;
DELETE from items;
delete from inventories;


INSERT INTO `user` VALUES (1, "Jennifer", "Scott", "jscott", "first"),
                          (2, "Joe", "Louise", "jlouise", "second"),
                          (3, "Katie", "Fiora", "kfiroa", "third");

INSERT INTO `worlds` VALUES (1, "Ultaria", 1),
                            (2, "Exandria", 1),
                            (3, "Spire", 3);

INSERT INTO `continents` VALUES (1, "Marquet", 2),
                                (2, "Wildemount", 2),
                                (3, "Aeor", 2),
                                (4, "Klahan", 1),
                                (5, "Placon", 1),
                                (6, "Atayend", 1),
                                (7, "Candia", 3),
                                (8, "Auegfort", 3);

INSERT INTO `regions` VALUES (1, "Segra", 2, 2),
                             (2, "Othua", 2, 2),
                             (3, "Dral Gror", 5, 1),
                             (4, "Prainia", 4, 1),
                             (5, "Ubluasia", 7, 3),
                             (6, "Butrus", 4, 1),
                             (7, "Eglus", 1, 2);

INSERT INTO `locations` VALUES (1, "Moongulf", 2, 2),
                               (2, "Goldvalley", 3, 1),
                               (3, "Faypond", 4, 1),
                               (4, "Bayshell", 4, 1),
                               (5, "Kilburn", 1, 2),
                               (6, "Limegate", 7, 2),
                               (7, "Brinehelm", 6, 1);

INSERT INTO `owners` VALUES (1, "Pyrravyn", "Zinlynn", "Enchanter", 1),
                            (2, "Druindar", "Quidan", "Jewler", 2),
                            (3, "Orist", "Fentris", "Smith", 1),
                            (4, "Cody", "Trixster", "Enchanter", 3),
                            (5, "Gibson", "Zinlynn", "Smith", 2),
                            (6, "Smebbniss", "Orion", "Jewler", 2),
                            (7, "Tulbeg", "Lucielle", "Enchanter", 2),
                            (8, "Jebebnast", "Cobbelpot", "Smith", 2);

INSERT INTO `shops` VALUES (1, "The Rare Quill", "Magic", 3, 4, 1),
                           (2, "The Mirror Image", "Magic", 4, 1, 1),
                           (3, "The Best Defense", "Armory", 3, 3, 1),
                           (4, "Home Sewn", "Tailor", 7, 3, 2),
                           (5, "The Broken Stone", "Jewlery", 5, 2, 2),
                           (6, "Basic Coin", "General", 1, 2, 2),
                           (7, "Patches and Buttons", "Tailor", 5, 5, 2),
                           (8, "Steel and Mortar", "Armory", 1, 5, 2),
                           (9, "Forevery Gems", "Jewlery", 6, 6, 2),
                           (10, "The Enchanted Arcanum", "Magic", 6, 7, 2),
                           (11, "Angered Anvil", "Armory", 6, 8, 2),
                           (12, "Osiria", "Jewlery", 6, 6, 2);

INSERT INTO `items` VALUES (1, "Shortsword", "Uncommon", "Shortsword"),
                           (2, "Warhammer + 1", "Rare", "Mace"),
                           (3, "Shield of Arrow Catching", "Rare", "Shield"),
                           (4, "Diamond", "Epic", "Gemstone"),
                           (5, "Razors Edge", "Epic", "Longsword"),
                           (6, "Spike", "Wonderous", "Longsword"),
                           (7, "Ruby", "Uncommon", "Gemstone"),
                           (8, "Tower Shield of Heaven", "Legendary", "Shield"),
                           (9, "Glimmering Robe", "Uncommon", "Robe");

INSERT INTO `inventories` VALUES (1, 8, 1, 2, 100),
                                 (2, 8, 2, 1, 500),
                                 (3, 8, 3, 3, 600),
                                 (4, 8, 5, 1, 750),
                                 (5, 8, 8, 2, 400),
                                 (6, 2, 9, 1, 500),
                                 (7, 2, 6, 1, 860),
                                 (8, 2, 3, 2, 750),
                                 (9, 2, 8, 3, 950),
                                 (10, 2, 9, 1, 250),
                                 (11, 5, 7, 2, 100),
                                 (12, 5, 4, 6, 500),
                                 (13, 9, 4, 9, 200),
                                 (14, 9, 7, 15, 100),
                                 (15, 10, 2, 1, 100),
                                 (16, 10, 1, 3, 500),
                                 (17, 10, 3, 1, 450),
                                 (18, 10, 9, 2, 350),
                                 (19, 10, 3, 1, 1000);
