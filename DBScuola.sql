DROP TABLE IF EXISTS `t_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_province` (
  `pv` varchar(4) NOT NULL,
  PRIMARY KEY (`pv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_province`
--

LOCK TABLES `t_province` WRITE;
/*!40000 ALTER TABLE `t_province` DISABLE KEYS */;
INSERT INTO `t_province` VALUES ('al'),('at'),('bi'),('cn'),('no'),('to'),('vb'),('vc');
/*!40000 ALTER TABLE `t_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_anagrafiche`
--

DROP TABLE IF EXISTS `t_anagrafiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_anagrafiche` (
  `id_anagrafica` int(11) NOT NULL AUTO_INCREMENT,
  `cognome` varchar(45) NOT NULL,
  `nome` varchar(65) NOT NULL,
  `pv` varchar(4) NOT NULL,
  PRIMARY KEY (`id_anagrafica`),
  KEY `idxcog` (`cognome`,`nome`),
  KEY `fkpv_idx` (`pv`),
  CONSTRAINT `fk_anagpv` FOREIGN KEY (`pv`) REFERENCES `t_province` (`pv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_anagrafiche`
--

LOCK TABLES `t_anagrafiche` WRITE;
/*!40000 ALTER TABLE `t_anagrafiche` DISABLE KEYS */;
INSERT INTO `t_anagrafiche` VALUES (1,'rossi','mario','to'),(2,'bianchi','maria','cn'),(3,'verdi','luca','to'),(4,'alessi','giorgio','vc'),(5,'rosselli','Lucia','to'),(6,'belli','aldo','vc'),(7,'torri','Alessandro','cn'),(8,'garda','Paolo','al'),(9,'redi','filippo','to'),(10,'magni','alex','to');
/*!40000 ALTER TABLE `t_anagrafiche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_corsi`
--

DROP TABLE IF EXISTS `t_corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_corsi` (
  `id_corso` int(11) NOT NULL AUTO_INCREMENT,
  `titolocorso` varchar(250) NOT NULL,
  `descrizionecorso` varchar(1000) DEFAULT NULL,
  `datainizio` date DEFAULT NULL,
  `duratacorso` smallint(6) DEFAULT NULL,
  `costocorso` decimal(6,2) DEFAULT NULL,
  `datacreazione` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_corso`),
  UNIQUE KEY `udx_tc` (`titolocorso`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_corsi`
--

LOCK TABLES `t_corsi` WRITE;
/*!40000 ALTER TABLE `t_corsi` DISABLE KEYS */;
INSERT INTO `t_corsi` VALUES (1,'java db',NULL,'2022-02-02',100,122.00,'2022-03-03 14:01:13'),(2,'html5','css js html','2022-02-03',50,50.00,'2022-03-03 14:01:13'),(3,'inglese','talk and pick','2022-03-03',12,100.00,'2022-03-03 14:04:01'),(4,'jakarta EE','applicazioni web con jakarta EE','2022-03-07',120,0.00,'2022-03-07 13:28:39'),(6,'IOT wio seed','IOT develop red node','2022-05-05',80,500.00,NULL);
/*!40000 ALTER TABLE `t_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_iscrizioni`
--

DROP TABLE IF EXISTS `t_iscrizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_iscrizioni` (
  `id_iscrizione` int(11) NOT NULL AUTO_INCREMENT,
  `id_anagrafica` int(11) NOT NULL,
  `id_corso` int(11) NOT NULL,
  `dataiscrizione` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id_iscrizione`),
  UNIQUE KEY `udx_anc` (`id_anagrafica`,`id_corso`),
  KEY `idxiscran` (`id_anagrafica`),
  KEY `idxiscrc` (`id_corso`),
  CONSTRAINT `fk_iscran` FOREIGN KEY (`id_anagrafica`) REFERENCES `t_anagrafiche` (`id_anagrafica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iscrc` FOREIGN KEY (`id_corso`) REFERENCES `t_corsi` (`id_corso`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_iscrizioni`
--

LOCK TABLES `t_iscrizioni` WRITE;
/*!40000 ALTER TABLE `t_iscrizioni` DISABLE KEYS */;
INSERT INTO `t_iscrizioni` VALUES (1,1,1,'2022-03-08 08:54:37'),(2,2,1,'2022-03-08 08:54:37'),(3,1,2,'2022-03-08 08:54:37');
/*!40000 ALTER TABLE `t_iscrizioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_opzioni`
--

DROP TABLE IF EXISTS `t_opzioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_opzioni` (
  `idt_opzioni` int(11) NOT NULL AUTO_INCREMENT,
  `ivastd` decimal(4,2) DEFAULT NULL,
  `scontostd` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`idt_opzioni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_opzioni`
--

LOCK TABLES `t_opzioni` WRITE;
/*!40000 ALTER TABLE `t_opzioni` DISABLE KEYS */;
INSERT INTO `t_opzioni` VALUES (1,22.00,25.00);
/*!40000 ALTER TABLE `t_opzioni` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Final view structure for view `v_anagrafica_no_iscrizione`
--

/*!50001 DROP TABLE IF EXISTS `v_anagrafica_no_iscrizione`*/;
/*!50001 DROP VIEW IF EXISTS `v_anagrafica_no_iscrizione`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE   VIEW `v_anagrafica_no_iscrizione` AS select `a`.`id_anagrafica` AS `id_anagrafica`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from (`t_anagrafiche` `a` left join `t_iscrizioni` `i` on(`a`.`id_anagrafica` = `i`.`id_anagrafica`)) where `i`.`id_iscrizione` is null order by `a`.`cognome`,`a`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corsi_ok`
--

/*!50001 DROP TABLE IF EXISTS `v_corsi_ok`*/;
/*!50001 DROP VIEW IF EXISTS `v_corsi_ok`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE   VIEW `v_corsi_ok` AS select ucase(`c`.`titolocorso`) AS `titolocorso`,`c`.`id_corso` AS `id_corso`,`c`.`duratacorso` AS `duratacorso`,`c`.`descrizionecorso` AS `descrizionecorso`,`c`.`datainizio` AS `datainizio`,`c`.`costocorso` AS `costocorso`,`c`.`datacreazione` AS `datacreazione`,`c`.`costocorso` * (1 / (1 + `o`.`ivastd` / 100)) AS `costo_noiva` from (`t_corsi` `c` join `t_opzioni` `o`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;


--
-- Final view structure for view `v_profitto_corsi`
--

/*!50001 DROP TABLE IF EXISTS `v_profitto_corsi`*/;
/*!50001 DROP VIEW IF EXISTS `v_profitto_corsi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE   VIEW `v_profitto_corsi` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,count(`i`.`id_iscrizione`) AS `tot_iscritti`,round(`c`.`costo_noiva` * count(`i`.`id_iscrizione`),2) AS `profitto` from (`v_corsi_ok` `c` left join `t_iscrizioni` `i` on(`c`.`id_corso` = `i`.`id_corso`)) group by `c`.`id_corso` order by round(`c`.`costo_noiva` * count(`i`.`id_iscrizione`),2) desc,`c`.`titolocorso` */;


--
-- Final view structure for view `v_corso_best`
--

/*!50001 DROP TABLE IF EXISTS `v_corso_best`*/;
/*!50001 DROP VIEW IF EXISTS `v_corso_best`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE   VIEW `v_corso_best` AS select `v_profitto_corsi`.`id_corso` AS `id_corso`,`v_profitto_corsi`.`titolocorso` AS `titolocorso`,`v_profitto_corsi`.`tot_iscritti` AS `tot_iscritti`,`v_profitto_corsi`.`profitto` AS `profitto` from `v_profitto_corsi` limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_corso_best_alunni`
--

/*!50001 DROP TABLE IF EXISTS `v_corso_best_alunni`*/;
/*!50001 DROP VIEW IF EXISTS `v_corso_best_alunni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE   VIEW `v_corso_best_alunni` AS select `c`.`id_corso` AS `id_corso`,`c`.`titolocorso` AS `titolocorso`,`c`.`tot_iscritti` AS `tot_iscritti`,`c`.`profitto` AS `profitto`,`a`.`id_anagrafica` AS `id_anagrafica`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from ((`v_corso_best` `c` join `t_iscrizioni` `i` on(`c`.`id_corso` = `i`.`id_corso`)) join `t_anagrafiche` `a` on(`i`.`id_anagrafica` = `a`.`id_anagrafica`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_iscrizioni_full`
--

/*!50001 DROP TABLE IF EXISTS `v_iscrizioni_full`*/;
/*!50001 DROP VIEW IF EXISTS `v_iscrizioni_full`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE   VIEW `v_iscrizioni_full` AS select `i`.`id_iscrizione` AS `id_iscrizione`,`i`.`id_anagrafica` AS `id_anagrafica`,`i`.`id_corso` AS `id_corso`,`i`.`dataiscrizione` AS `dataiscrizione`,`c`.`titolocorso` AS `titolocorso`,`c`.`duratacorso` AS `duratacorso`,`c`.`costocorso` AS `costocorso`,`a`.`cognome` AS `cognome`,`a`.`nome` AS `nome`,`a`.`pv` AS `pv` from ((`t_iscrizioni` `i` join `t_corsi` `c`) join `t_anagrafiche` `a`) where `i`.`id_corso` = `c`.`id_corso` and `i`.`id_anagrafica` = `a`.`id_anagrafica` */;
