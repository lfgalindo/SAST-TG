-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02-Nov-2016 às 23:12
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(26),
(26),
(26),
(26),
(26),
(26),
(26),
(26),
(26);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_caixa`
--

CREATE TABLE `tb_caixa` (
  `codigo` int(11) NOT NULL,
  `dtCriacao` date DEFAULT NULL,
  `removido` int(11) NOT NULL,
  `pessoa_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cargo`
--

CREATE TABLE `tb_cargo` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_cargo`
--

INSERT INTO `tb_cargo` (`codigo`, `descricao`, `nome`) VALUES
(5, 'Teste', 'Programmer'),
(10, 'Teste', 'Programmer'),
(16, 'Teste', 'Programmer'),
(21, 'Teste', 'Programmer'),
(24, 'Teste', 'Programmer');

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
  `senha` varchar(34) COLLATE utf8_bin NOT NULL,
  `telefone` varchar(13) COLLATE utf8_bin NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `email`, `endereco`, `estado`, `estadoCivil`, `login`, `nascimento`, `nome`, `numero`, `razao`, `rg`, `senha`, `telefone`, `codigoPerfil_codigo`) VALUES
(0, 'Teste', 'Teste', 'Teste', '82460743424', 'Teste@teste.com', 'TESTE', 'SP', 'TESTE', 'TESTE', '2016-11-10', 'teste', 'tes12', 'teste', '481399847', '99a29dc8105fd2fa39d8cdc04733938d', '482659-9173', 4);

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
-- Estrutura da tabela `tb_fatura`
--

CREATE TABLE `tb_fatura` (
  `codigoFatura` int(11) NOT NULL,
  `codigoBarra` varchar(255) NOT NULL,
  `dataExpedicao` datetime NOT NULL,
  `dataVencimento` datetime NOT NULL,
  `desconto` double NOT NULL,
  `juros` double NOT NULL,
  `observacao` varchar(255) NOT NULL,
  `situacao` bit(1) NOT NULL,
  `valor` double NOT NULL,
  `codigoPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `senha` varchar(34) COLLATE utf8_bin NOT NULL,
  `telefone` varchar(13) COLLATE utf8_bin NOT NULL,
  `codigoCargo_codigo` int(11) NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_manutencao`
--

CREATE TABLE `tb_manutencao` (
  `codigo` int(11) NOT NULL,
  `baixa` int(11) NOT NULL,
  `descProblema` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `dtAgendamento` date DEFAULT NULL,
  `dtExecucao` date DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `prioridade` varchar(15) NOT NULL,
  `codigoCliente_codigo` int(11) NOT NULL,
  `codigoFuncionario_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_movimentacao`
--

CREATE TABLE `tb_movimentacao` (
  `codigoMovimentacao` int(11) NOT NULL,
  `abertura` datetime DEFAULT NULL,
  `data` datetime NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `fechamento` datetime DEFAULT NULL,
  `formaPagamento` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `codigoCaixa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_perfil`
--

CREATE TABLE `tb_perfil` (
  `codigo` int(11) NOT NULL,
  `gerenciarCaixas` int(11) NOT NULL,
  `gerenciarCargos` int(11) NOT NULL,
  `gerenciarConfiguracoes` int(11) NOT NULL,
  `gerenciarFaturas` int(11) NOT NULL,
  `gerenciarManutencoes` int(11) NOT NULL,
  `gerenciarMovimentacoes` int(11) NOT NULL,
  `gerenciarPlanos` int(11) NOT NULL,
  `nomePerfil` varchar(45) NOT NULL,
  `gerenciarClientes` int(11) NOT NULL,
  `gerenciarFuncionarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_perfil`
--

INSERT INTO `tb_perfil` (`codigo`, `gerenciarCaixas`, `gerenciarCargos`, `gerenciarConfiguracoes`, `gerenciarFaturas`, `gerenciarManutencoes`, `gerenciarMovimentacoes`, `gerenciarPlanos`, `nomePerfil`, `gerenciarClientes`, `gerenciarFuncionarios`) VALUES
(4, 4, 4, 4, 4, 4, 4, 4, 'TesteQuatro', 0, 0),
(9, 4, 4, 4, 4, 4, 4, 4, 'TesteQuatro', 0, 0),
(14, 4, 4, 4, 4, 4, 4, 4, 'TesteQuatro', 0, 0),
(15, 4, 4, 4, 4, 4, 4, 4, 'TesteQuatro', 0, 0),
(20, 4, 4, 4, 4, 4, 4, 4, 'TesteQuatro', 0, 0),
(23, 4, 4, 4, 4, 4, 4, 4, 'TesteQuatro', 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pessoa`
--

CREATE TABLE `tb_pessoa` (
  `codigo` int(11) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `email` varchar(30) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `login` varchar(20) NOT NULL,
  `nascimento` date DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `codigoCargo_codigo` int(11) NOT NULL,
  `codigoPerfil_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_plano`
--

CREATE TABLE `tb_plano` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `garantia` int(11) NOT NULL,
  `tipoConexao` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `velocidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_plano`
--

INSERT INTO `tb_plano` (`codigo`, `descricao`, `garantia`, `tipoConexao`, `valor`, `velocidade`) VALUES
(6, 'testetres', 70, 'Fumaça', 99.9, 5500),
(11, 'testetres', 70, 'Fumaça', 99.9, 5500),
(17, 'testetres', 70, 'Fumaça', 99.9, 5500),
(22, 'testetres', 70, 'Fumaça', 99.9, 5500),
(25, 'testetres', 70, 'Fumaça', 99.9, 5500);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_planocliente`
--

CREATE TABLE `tb_planocliente` (
  `codigo` int(11) NOT NULL,
  `codigoCliente_codigo` int(11) NOT NULL,
  `codigoPlano_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_planopessoa`
--

CREATE TABLE `tb_planopessoa` (
  `codigo` int(11) NOT NULL,
  `codigoPessoa_codigo` int(11) NOT NULL,
  `codigoPlano_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_caixa`
--
ALTER TABLE `tb_caixa`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK74kdnaud57ca0owv69jcwxylp` (`pessoa_codigo`);

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
-- Indexes for table `tb_fatura`
--
ALTER TABLE `tb_fatura`
  ADD PRIMARY KEY (`codigoFatura`),
  ADD KEY `FKi8jfx4ef6oylvquk934joyj2q` (`codigoPessoa`);

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
  ADD KEY `FKf43dhvnpk2bw51987a3rxyjrq` (`codigoCliente_codigo`),
  ADD KEY `FKmrvk2c2cv3bw01xohardfbilq` (`codigoFuncionario_codigo`);

--
-- Indexes for table `tb_movimentacao`
--
ALTER TABLE `tb_movimentacao`
  ADD PRIMARY KEY (`codigoMovimentacao`),
  ADD KEY `FKjlkck59gmceqhpnkqpq7tw4tg` (`codigoCaixa`);

--
-- Indexes for table `tb_perfil`
--
ALTER TABLE `tb_perfil`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `tb_pessoa`
--
ALTER TABLE `tb_pessoa`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `UK_n8mobknkuk6hwj7nqpfqgqx69` (`cpf`),
  ADD KEY `FK69x6fgbt0vtxhick2n8hw0qew` (`codigoCargo_codigo`),
  ADD KEY `FKl8cbs7fkbwokod6hk6nd37di5` (`codigoPerfil_codigo`);

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
-- Indexes for table `tb_planopessoa`
--
ALTER TABLE `tb_planopessoa`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FKk53g3dp4t1vv9ef90b05a2rxo` (`codigoPessoa_codigo`),
  ADD KEY `FKqf64ua38ssgfyq5d1bg0u4icj` (`codigoPlano_codigo`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_caixa`
--
ALTER TABLE `tb_caixa`
  ADD CONSTRAINT `FK74kdnaud57ca0owv69jcwxylp` FOREIGN KEY (`pessoa_codigo`) REFERENCES `tb_pessoa` (`codigo`);

--
-- Limitadores para a tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD CONSTRAINT `FKjqi4hsls6sxar9ovq9i5svhk3` FOREIGN KEY (`codigoPerfil_codigo`) REFERENCES `tb_perfil` (`codigo`);

--
-- Limitadores para a tabela `tb_fatura`
--
ALTER TABLE `tb_fatura`
  ADD CONSTRAINT `FKi8jfx4ef6oylvquk934joyj2q` FOREIGN KEY (`codigoPessoa`) REFERENCES `tb_pessoa` (`codigo`);

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
  ADD CONSTRAINT `FKf43dhvnpk2bw51987a3rxyjrq` FOREIGN KEY (`codigoCliente_codigo`) REFERENCES `tb_pessoa` (`codigo`),
  ADD CONSTRAINT `FKmrvk2c2cv3bw01xohardfbilq` FOREIGN KEY (`codigoFuncionario_codigo`) REFERENCES `tb_pessoa` (`codigo`);

--
-- Limitadores para a tabela `tb_movimentacao`
--
ALTER TABLE `tb_movimentacao`
  ADD CONSTRAINT `FKjlkck59gmceqhpnkqpq7tw4tg` FOREIGN KEY (`codigoCaixa`) REFERENCES `tb_caixa` (`codigo`);

--
-- Limitadores para a tabela `tb_pessoa`
--
ALTER TABLE `tb_pessoa`
  ADD CONSTRAINT `FK69x6fgbt0vtxhick2n8hw0qew` FOREIGN KEY (`codigoCargo_codigo`) REFERENCES `tb_cargo` (`codigo`),
  ADD CONSTRAINT `FKl8cbs7fkbwokod6hk6nd37di5` FOREIGN KEY (`codigoPerfil_codigo`) REFERENCES `tb_perfil` (`codigo`);

--
-- Limitadores para a tabela `tb_planocliente`
--
ALTER TABLE `tb_planocliente`
  ADD CONSTRAINT `FK3bbpttmjv4u3wbc0xrd9xy6y7` FOREIGN KEY (`codigoCliente_codigo`) REFERENCES `tb_cliente` (`codigo`),
  ADD CONSTRAINT `FKf5c7usfa19g22t1gtk0px1q8a` FOREIGN KEY (`codigoPlano_codigo`) REFERENCES `tb_plano` (`codigo`);

--
-- Limitadores para a tabela `tb_planopessoa`
--
ALTER TABLE `tb_planopessoa`
  ADD CONSTRAINT `FKk53g3dp4t1vv9ef90b05a2rxo` FOREIGN KEY (`codigoPessoa_codigo`) REFERENCES `tb_pessoa` (`codigo`),
  ADD CONSTRAINT `FKqf64ua38ssgfyq5d1bg0u4icj` FOREIGN KEY (`codigoPlano_codigo`) REFERENCES `tb_plano` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
