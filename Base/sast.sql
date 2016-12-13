-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 13-Dez-2016 às 02:54
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sast`
--

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
(50),
(50),
(50),
(50),
(50),
(50),
(50),
(50);

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
  `telefone` varchar(20) COLLATE utf8_bin NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `email`, `endereco`, `estado`, `estadoCivil`, `login`, `nascimento`, `nome`, `numero`, `razao`, `rg`, `senha`, `telefone`, `codigoPerfil_codigo`) VALUES
(5, 'Vila Santa Tereza', 'Chavantes', 'Casa', '445.687.868-19', 'teste@teste.com', 'Rua José de Souza Carvalho', 'SP', 'Solteiro', 'guihms1', '2001-12-03', 'rapadura', '06', 'asfasfasfasf', '11.111.111-1', 'd41d8cd98f00b204e9800998ecf8427e', '(14) 9974-22644', 3),
(10, 'vila santa tereza', 'CHAVANTES', '', '44568786818', 'luizinho@sast.com.br', 'JOSÉ DE SOUZA CARVALHO', 'SP', 'Casado', 'luizinho', '2016-11-11', 'Luiz Felipe Magalhães Galindo', '06', 'Luiz Felipe Magalhães Galindo', '445687869', '827ccb0eea8a706c4c34a16891f84e7b', '1433421787', 8),
(14, 'awdawdawd', 'wadawdaw', 'awdawdawd', '401.824.148-84', 'awdawdawdawdaw', 'wadwdawdawd', 'RR', 'Divorciado', 'testeCliente', '2016-11-10', 'teste', 'wadaw', 'teste', '50.799.815-7', '827ccb0eea8a706c4c34a16891f84e7b', '1414141414141', 3),
(25, 'TestesMask', 'TestesMask', 'TestesMask', '12313123123', 'TestesMask', 'TestesMask', 'AL', 'Solteiro', 'TestesMask', '2016-12-07', 'TestesMask', '12312', 'TestesMask', '11.111.111-11', 'bdc19726cf8e5eacaa41f943adc3017c', '1231231231231', 3),
(29, 'LuisLuisLuisLuisLuis', 'LuisLuisLuisLuisLuis', 'LuisLuisLuis', '111.111.111-11', 'LuisLuisLuisLuisLuis', 'LuisLuisLuisLuis', 'BA', 'Divorciado', 'LuisLuisLuisLuis', '2016-12-14', 'LuisLuisLuisLuis', '12312', 'LuisLuisLuisLuis', '12.312.312-32', '9469394b25cba3f8c000b5d10a527264', '1241412412412', 3),
(45, 'Santo Antônio', 'Teresina', '', '718.514.037-44', 'marc-bern79@heinrich.co', 'Rua Porto Alegre', 'PI', 'Solteiro', 'hu3teste', '2001-12-04', 'Marcelo Bernardo Luan Pinto', '635', 'tester', '15.621.627-9', 'f3308440775a1749caf8b1496dfd29a2', '(86) 9940-31507', 3);

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

--
-- Extraindo dados da tabela `tb_empresa`
--

INSERT INTO `tb_empresa` (`codigoEmpresa`, `bairro`, `cidade`, `cnpj`, `email`, `endereco`, `estado`, `nomeEmpresa`, `numero`, `razaoSocial`, `telefone`) VALUES
(49, 'cednet', 'cednet', '61.242.015/0001-50', 'cednet@cednet.com', 'cednet', 'CE', 'cednet', 'cedne', 'cednet', '(23) 2131-2313');

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
  `telefone` varchar(20) COLLATE utf8_bin NOT NULL,
  `codigoCargo_codigo` int(11) NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_funcionario`
--

INSERT INTO `tb_funcionario` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `dataAdmissao`, `dataDemissao`, `email`, `endereco`, `estado`, `estadoCivil`, `formacao`, `login`, `nascimento`, `nome`, `numero`, `rg`, `senha`, `telefone`, `codigoCargo_codigo`, `codigoPerfil_codigo`) VALUES
(1, 'Teste', 'teste', 'teste', '12332112332', '2016-11-01', NULL, 'teste@teste.com', 'teste', 'sp', 'teste', 'teste', 'luis', '1996-10-10', 'luis', '123', '121231231', '202cb962ac59075b964b07152d234b70', '1498741234', 12, 3),
(18, 'teste', 'teste', 'teste', 'testetestes', '2016-11-22', NULL, 'testeteste', 'teste', 'DF', 'Divorciado', 'teste', 'teste', '2016-11-01', 'teste', 'teste', 'testetest', '698dc19d489c4e4db73e28a713eab07b', 'testetesteste', 12, 8),
(20, 'MEU BAIRRO', 'CHAVANTES', 'CASA', '44568786817', '2016-11-05', '2016-11-05', 'func@func.com.br', 'RUA DO FUNC', 'SP', 'Solteiro', 'ENSINO MÉDIO COMPLETO', 'func', '2016-11-05', 'FUNCIONARIO DO MÊS', '888', '469823732', '698dc19d489c4e4db73e28a713eab07b', '33421785', 12, 8),
(21, 'teste', 'teste', 'teste', 'testetestee', '2016-11-15', '2016-11-08', 'testeteste', 'teste', 'CE', 'Solteiro', 'teste', 'teste', '2016-11-01', 'testeste', 'teste', 'teetstest', '698dc19d489c4e4db73e28a713eab07b', 'testetesteste', 12, 8),
(46, 'testehu3', 'testehu3', 'testehu3', '401.824.148-84', '2016-12-12', '2016-12-14', 'testehu3@testehu3.com', 'testehu3', 'BA', 'Solteiro', 'testehu3', 'testehu3', '2000-12-12', 'testehu3', 'teste', '50.799.815-7', 'a4ca0ecb86acb893485bed9825cce19b', '(14) 9516-51651', 12, 8);

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
(1, 0, 'teste', 'teste', '2016-11-02 02:00:00', '2016-11-04 02:00:00', 'teste', '', 10, 20),
(2, 0, 'Teste2', 'teste2', '2016-11-07 07:29:43', '2016-11-11 02:00:00', 'gtesdggesfef', 'ALTA', 5, 20),
(13, 0, 'HAHAHAHAHAHA', 'vai pro relatório', '2016-11-09 14:31:57', '2016-11-10 10:30:00', 'Teste de manuteção', 'ALTA', 5, 1);

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
(6, 'FIBRA 5MB', 40, 'Fibra', 89.99, 5000),
(22, 'Teste planos', 60, 'Fibra', 150, 100),
(24, 'hahahha', 99, 'Fibra', 123456, 123123);

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
(11, 14, 6),
(23, 14, 22),
(47, 10, 24),
(48, 45, 6);

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
