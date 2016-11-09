-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 09-Nov-2016 às 01:56
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(11) NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

--
-- Extraindo dados da tabela `pma__central_columns`
--

INSERT INTO `pma__central_columns` (`db_name`, `col_name`, `col_type`, `col_length`, `col_collation`, `col_isNull`, `col_extra`, `col_default`) VALUES
('sast', 'gerenciarCaixas', 'int', '11', '', 0, ',', ''),
('sast', 'nomePerfil', 'varchar', '45', 'latin1_swedish_ci', 0, ',', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Extraindo dados da tabela `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{"db":"sast","table":"tb_manutencao"},{"db":"sast","table":"tb_planocliente"},{"db":"sast","table":"tb_cliente"},{"db":"sast","table":"tb_funcionario"},{"db":"sast","table":"tb_perfil"},{"db":"sast","table":"tb_pessoa"},{"db":"sast","table":"tb_planopessoa"},{"db":"sast","table":"tb_plano"},{"db":"sast","table":"tb_movimentacao"},{"db":"sast","table":"tb_fatura"}]');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float UNSIGNED NOT NULL DEFAULT '0',
  `y` float UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Extraindo dados da tabela `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2016-09-12 02:07:48', '{"lang":"pt","collation_connection":"utf8mb4_unicode_ci"}');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Estrutura da tabela `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;--
-- Database: `sast`
--
CREATE DATABASE IF NOT EXISTS `sast` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sast`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(13),
(13),
(13),
(13),
(13),
(13),
(13),
(13);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cargo`
--

CREATE TABLE `tb_cargo` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) COLLATE utf8_bin NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_cargo`
--

INSERT INTO `tb_cargo` (`codigo`, `descricao`, `nome`) VALUES
(12, 'Teste', 'Programmer');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `codigo` int(11) NOT NULL,
  `bairro` varchar(45) COLLATE utf8_bin NOT NULL,
  `cidade` varchar(25) COLLATE utf8_bin NOT NULL,
  `complemento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8_bin NOT NULL,
  `email` varchar(30) COLLATE utf8_bin NOT NULL,
  `endereco` varchar(45) COLLATE utf8_bin NOT NULL,
  `estado` varchar(2) COLLATE utf8_bin NOT NULL,
  `estadoCivil` varchar(20) COLLATE utf8_bin NOT NULL,
  `login` varchar(20) COLLATE utf8_bin NOT NULL,
  `nascimento` date DEFAULT NULL,
  `nome` varchar(45) COLLATE utf8_bin NOT NULL,
  `numero` varchar(5) COLLATE utf8_bin NOT NULL,
  `razao` varchar(45) COLLATE utf8_bin NOT NULL,
  `rg` varchar(20) COLLATE utf8_bin NOT NULL,
  `senha` varchar(32) COLLATE utf8_bin NOT NULL,
  `telefone` varchar(13) COLLATE utf8_bin NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `email`, `endereco`, `estado`, `estadoCivil`, `login`, `nascimento`, `nome`, `numero`, `razao`, `rg`, `senha`, `telefone`, `codigoPerfil_codigo`) VALUES
(5, 'Vila Santa Tereza', 'Chavantes', 'Casa', '44568786819', 'guihms1@gmail.com', 'Rua José de Souza Carvalho', 'SP', 'Solteiro', 'guihms1', '2016-11-04', 'Luís Guilherme Fernandes Ferreira', '06', 'Luís Guilherme Fernandes Ferreira', '469823734', '202cb962ac59075b964b07152d234b70', '996440052', 3),
(10, 'vila santa tereza', 'CHAVANTES', '', '44568786818', 'luizinho@sast.com.br', 'JOSÉ DE SOUZA CARVALHO', 'SP', 'Casado', 'luizinho', '2016-11-11', 'Luiz Felipe Magalhães Galindo', '06', 'Luiz Felipe Magalhães Galindo', '445687869', '827ccb0eea8a706c4c34a16891f84e7b', '1433421787', 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_empresa`
--

CREATE TABLE `tb_empresa` (
  `codigoEmpresa` int(11) NOT NULL,
  `bairro` varchar(45) COLLATE utf8_bin NOT NULL,
  `cidade` varchar(25) COLLATE utf8_bin NOT NULL,
  `cnpj` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `endereco` varchar(255) COLLATE utf8_bin NOT NULL,
  `estado` varchar(2) COLLATE utf8_bin NOT NULL,
  `nomeEmpresa` varchar(255) COLLATE utf8_bin NOT NULL,
  `numero` varchar(5) COLLATE utf8_bin NOT NULL,
  `razaoSocial` varchar(255) COLLATE utf8_bin NOT NULL,
  `telefone` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_funcionario`
--

CREATE TABLE `tb_funcionario` (
  `codigo` int(11) NOT NULL,
  `bairro` varchar(45) COLLATE utf8_bin NOT NULL,
  `cidade` varchar(25) COLLATE utf8_bin NOT NULL,
  `complemento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8_bin NOT NULL,
  `dataAdmissao` date DEFAULT NULL,
  `dataDemissao` date DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_bin NOT NULL,
  `endereco` varchar(45) COLLATE utf8_bin NOT NULL,
  `estado` varchar(2) COLLATE utf8_bin NOT NULL,
  `estadoCivil` varchar(20) COLLATE utf8_bin NOT NULL,
  `formacao` varchar(45) COLLATE utf8_bin NOT NULL,
  `login` varchar(20) COLLATE utf8_bin NOT NULL,
  `nascimento` date DEFAULT NULL,
  `nome` varchar(45) COLLATE utf8_bin NOT NULL,
  `numero` varchar(5) COLLATE utf8_bin NOT NULL,
  `rg` varchar(20) COLLATE utf8_bin NOT NULL,
  `senha` varchar(32) COLLATE utf8_bin NOT NULL,
  `telefone` varchar(13) COLLATE utf8_bin NOT NULL,
  `codigoCargo_codigo` int(11) NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_funcionario`
--

INSERT INTO `tb_funcionario` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `dataAdmissao`, `dataDemissao`, `email`, `endereco`, `estado`, `estadoCivil`, `formacao`, `login`, `nascimento`, `nome`, `numero`, `rg`, `senha`, `telefone`, `codigoCargo_codigo`, `codigoPerfil_codigo`) VALUES
(1, 'Teste', 'teste', 'teste', '12332112332', '2016-11-01', NULL, 'teste@teste.com', 'teste', 'sp', 'teste', 'teste', 'luis', '1996-10-10', 'luis', '123', '121231231', '202cb962ac59075b964b07152d234b70', '1498741234', 12, 3),
(20, 'MEU BAIRRO', 'CHAVANTES', 'CASA', '44568786817', '2016-11-05', '2016-11-05', 'func@func.com.br', 'RUA DO FUNC', 'SP', 'Solteiro', 'ENSINO MÉDIO COMPLETO', 'func', '2016-11-05', 'FUNCIONARIO DO MÊS', '888', '469823732', '698dc19d489c4e4db73e28a713eab07b', '33421785', 12, 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_manutencao`
--

CREATE TABLE `tb_manutencao` (
  `codigo` int(11) NOT NULL,
  `baixa` int(11) NOT NULL,
  `descProblema` varchar(255) COLLATE utf8_bin NOT NULL,
  `descricao` varchar(255) COLLATE utf8_bin NOT NULL,
  `dtAgendamento` timestamp NULL DEFAULT NULL,
  `dtExecucao` timestamp NULL DEFAULT NULL,
  `observacoes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prioridade` varchar(15) COLLATE utf8_bin NOT NULL,
  `codigoCliente_codigo` int(11) NOT NULL,
  `codigoFuncionario_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_manutencao`
--

INSERT INTO `tb_manutencao` (`codigo`, `baixa`, `descProblema`, `descricao`, `dtAgendamento`, `dtExecucao`, `observacoes`, `prioridade`, `codigoCliente_codigo`, `codigoFuncionario_codigo`) VALUES
(1, 12, 'teste', 'teste', '2016-11-01 02:00:00', '2016-11-04 02:00:00', 'teste', 'Alta', 10, 20),
(2, 123, 'Teste2', 'teste2', '2016-11-07 02:00:00', '2016-11-11 02:00:00', 'gtes', 'baixa', 5, 20);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_perfil`
--

CREATE TABLE `tb_perfil` (
  `codigo` int(11) NOT NULL,
  `gerenciarCargos` int(11) NOT NULL,
  `gerenciarClientes` int(11) NOT NULL,
  `gerenciarConfiguracoes` int(11) NOT NULL,
  `gerenciarFuncionarios` int(11) NOT NULL,
  `gerenciarManutencoes` int(11) NOT NULL,
  `gerenciarPerfis` int(11) NOT NULL,
  `gerenciarPlanos` int(11) NOT NULL,
  `nomePerfil` varchar(45) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_perfil`
--

INSERT INTO `tb_perfil` (`codigo`, `gerenciarCargos`, `gerenciarClientes`, `gerenciarConfiguracoes`, `gerenciarFuncionarios`, `gerenciarManutencoes`, `gerenciarPerfis`, `gerenciarPlanos`, `nomePerfil`) VALUES
(3, 1, 1, 0, 0, 1, 0, 0, 'Cliente'),
(8, 1, 1, 0, 0, 1, 0, 0, 'Funcionário');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_plano`
--

CREATE TABLE `tb_plano` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) COLLATE utf8_bin NOT NULL,
  `garantia` int(11) NOT NULL,
  `tipoConexao` varchar(45) COLLATE utf8_bin NOT NULL,
  `valor` double NOT NULL,
  `velocidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_plano`
--

INSERT INTO `tb_plano` (`codigo`, `descricao`, `garantia`, `tipoConexao`, `valor`, `velocidade`) VALUES
(6, 'FIBRA 5MB', 40, 'Fibra', 89.99, 5000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_planocliente`
--

CREATE TABLE `tb_planocliente` (
  `codigo` int(11) NOT NULL,
  `codigoCliente_codigo` int(11) NOT NULL,
  `codigoPlano_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_planocliente`
--

INSERT INTO `tb_planocliente` (`codigo`, `codigoCliente_codigo`, `codigoPlano_codigo`) VALUES
(11, 5, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_cargo`
--
ALTER TABLE `tb_cargo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `UK_jgra977gi05fur83l225x4qkr` (`cpf`),
  ADD UNIQUE KEY `UK_c0ygb72owkjbmnaasjef1xwmc` (`rg`),
  ADD KEY `FKjqi4hsls6sxar9ovq9i5svhk3` (`codigoPerfil_codigo`);

--
-- Indexes for table `tb_empresa`
--
ALTER TABLE `tb_empresa`
  ADD PRIMARY KEY (`codigoEmpresa`),
  ADD UNIQUE KEY `UK_gamqi2pvmfim8800oc5jw05up` (`cnpj`);

--
-- Indexes for table `tb_funcionario`
--
ALTER TABLE `tb_funcionario`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `UK_h483q8xwbxkhk56ceeww2pvhw` (`cpf`),
  ADD UNIQUE KEY `UK_c5lnxoi179540th0tcrftcp9l` (`rg`),
  ADD KEY `FKs8ow114fx9fepnq35uukuxho0` (`codigoCargo_codigo`),
  ADD KEY `FKske04fmq3spmop8mqaemnkhbd` (`codigoPerfil_codigo`);

--
-- Indexes for table `tb_manutencao`
--
ALTER TABLE `tb_manutencao`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FKkho82rkppp1l0tmbi6qvgbs6f` (`codigoCliente_codigo`),
  ADD KEY `FK3g144k1785xb5n9cns053tksb` (`codigoFuncionario_codigo`);

--
-- Indexes for table `tb_perfil`
--
ALTER TABLE `tb_perfil`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `tb_plano`
--
ALTER TABLE `tb_plano`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `tb_planocliente`
--
ALTER TABLE `tb_planocliente`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK3bbpttmjv4u3wbc0xrd9xy6y7` (`codigoCliente_codigo`),
  ADD KEY `FKf5c7usfa19g22t1gtk0px1q8a` (`codigoPlano_codigo`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD CONSTRAINT `FKjqi4hsls6sxar9ovq9i5svhk3` FOREIGN KEY (`codigoPerfil_codigo`) REFERENCES `tb_perfil` (`codigo`);

--
-- Limitadores para a tabela `tb_funcionario`
--
ALTER TABLE `tb_funcionario`
  ADD CONSTRAINT `FKs8ow114fx9fepnq35uukuxho0` FOREIGN KEY (`codigoCargo_codigo`) REFERENCES `tb_cargo` (`codigo`),
  ADD CONSTRAINT `FKske04fmq3spmop8mqaemnkhbd` FOREIGN KEY (`codigoPerfil_codigo`) REFERENCES `tb_perfil` (`codigo`);

--
-- Limitadores para a tabela `tb_manutencao`
--
ALTER TABLE `tb_manutencao`
  ADD CONSTRAINT `FK3g144k1785xb5n9cns053tksb` FOREIGN KEY (`codigoFuncionario_codigo`) REFERENCES `tb_funcionario` (`codigo`),
  ADD CONSTRAINT `FKkho82rkppp1l0tmbi6qvgbs6f` FOREIGN KEY (`codigoCliente_codigo`) REFERENCES `tb_cliente` (`codigo`);

--
-- Limitadores para a tabela `tb_planocliente`
--
ALTER TABLE `tb_planocliente`
  ADD CONSTRAINT `FK3bbpttmjv4u3wbc0xrd9xy6y7` FOREIGN KEY (`codigoCliente_codigo`) REFERENCES `tb_cliente` (`codigo`),
  ADD CONSTRAINT `FKf5c7usfa19g22t1gtk0px1q8a` FOREIGN KEY (`codigoPlano_codigo`) REFERENCES `tb_plano` (`codigo`);
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
