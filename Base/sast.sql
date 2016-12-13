-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           10.1.16-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para sast
CREATE DATABASE IF NOT EXISTS `sast` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `sast`;

-- Copiando estrutura para tabela sast.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.hibernate_sequence: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(72),
	(72),
	(72),
	(72),
	(72),
	(72),
	(72),
	(72);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_cargo
CREATE TABLE IF NOT EXISTS `tb_cargo` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) COLLATE utf8_bin NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_cargo: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` (`codigo`, `descricao`, `nome`) VALUES
	(12, 'Teste', 'Programador'),
	(56, 'Atendimento ao cliente, suporte remoto', 'Auxiliar de Suporte Técnico'),
	(59, 'Gerencia todo o setor financeiro', 'Gerente Financeiro'),
	(60, 'Realiza manutenções residenciais', 'Técnico');
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_cliente
CREATE TABLE IF NOT EXISTS `tb_cliente` (
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
  `codigoPerfil_codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `UK_jgra977gi05fur83l225x4qkr` (`cpf`),
  UNIQUE KEY `UK_c0ygb72owkjbmnaasjef1xwmc` (`rg`),
  KEY `FKjqi4hsls6sxar9ovq9i5svhk3` (`codigoPerfil_codigo`),
  CONSTRAINT `FKjqi4hsls6sxar9ovq9i5svhk3` FOREIGN KEY (`codigoPerfil_codigo`) REFERENCES `tb_perfil` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_cliente: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `email`, `endereco`, `estado`, `estadoCivil`, `login`, `nascimento`, `nome`, `numero`, `razao`, `rg`, `senha`, `telefone`, `codigoPerfil_codigo`) VALUES
	(10, 'vila santa tereza', 'CHAVANTES', '', '44568786818', 'luizinho@sast.com.br', 'JOSÉ DE SOUZA CARVALHO', 'SP', 'Casado', 'luizinho', '2016-11-11', 'Luiz Felipe Magalhães Galindo', '06', 'Luiz Felipe Magalhães Galindo', '445687869', '827ccb0eea8a706c4c34a16891f84e7b', '1433421787', 8),
	(45, 'Santo Antônio', 'Teresina', '', '718.514.037-44', 'marc-bern79@heinrich.co', 'Rua Porto Alegre', 'PI', 'Solteiro', 'hu3teste', '2001-12-04', 'Marcelo Bernardo Luan Pinto', '635', 'tester', '15.621.627-9', 'f3308440775a1749caf8b1496dfd29a2', '(86) 9940-31507', 3),
	(65, 'Chavantes Novo', 'Chavantes', 'casa', '042.366.418-28', 'ionegalindo@hotmail.com', 'Rua Antonio Nakagawa', 'SP', 'Casado', 'ionelouzada', '1953-05-22', 'Ione Magalhães Louzada Galindo', '68', 'Ione Magalhães Louzada Galindo', '16.203.090-0', '698dc19d489c4e4db73e28a713eab07b', '(14) 3342-1925', 3);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_empresa
CREATE TABLE IF NOT EXISTS `tb_empresa` (
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
  `telefone` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codigoEmpresa`),
  UNIQUE KEY `UK_gamqi2pvmfim8800oc5jw05up` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_empresa: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_empresa` DISABLE KEYS */;
INSERT INTO `tb_empresa` (`codigoEmpresa`, `bairro`, `cidade`, `cnpj`, `email`, `endereco`, `estado`, `nomeEmpresa`, `numero`, `razaoSocial`, `telefone`) VALUES
	(49, 'cednet', 'cednet', '61.242.015/0001-50', 'cednet@cednet.com', 'cednet', 'SP', 'CedNet', 'cedne', 'cednet provedor de internet', '(14) 3342-1787');
/*!40000 ALTER TABLE `tb_empresa` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_funcionario
CREATE TABLE IF NOT EXISTS `tb_funcionario` (
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
  `codigoPerfil_codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `UK_h483q8xwbxkhk56ceeww2pvhw` (`cpf`),
  UNIQUE KEY `UK_c5lnxoi179540th0tcrftcp9l` (`rg`),
  KEY `FKs8ow114fx9fepnq35uukuxho0` (`codigoCargo_codigo`),
  KEY `FKske04fmq3spmop8mqaemnkhbd` (`codigoPerfil_codigo`),
  CONSTRAINT `FKs8ow114fx9fepnq35uukuxho0` FOREIGN KEY (`codigoCargo_codigo`) REFERENCES `tb_cargo` (`codigo`),
  CONSTRAINT `FKske04fmq3spmop8mqaemnkhbd` FOREIGN KEY (`codigoPerfil_codigo`) REFERENCES `tb_perfil` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_funcionario: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_funcionario` DISABLE KEYS */;
INSERT INTO `tb_funcionario` (`codigo`, `bairro`, `cidade`, `complemento`, `cpf`, `dataAdmissao`, `dataDemissao`, `email`, `endereco`, `estado`, `estadoCivil`, `formacao`, `login`, `nascimento`, `nome`, `numero`, `rg`, `senha`, `telefone`, `codigoCargo_codigo`, `codigoPerfil_codigo`) VALUES
	(52, 'BOA ESPERANÇA', 'OURINHOS', 'CASA', '397.475.158-06', '2016-12-13', NULL, 'luciano@lucianojunior.com.br', 'RUA OLAVO FERREIRA DE SÁ', 'SP', 'Solteiro', 'CURSANDO ADS', 'lucianojunior', '1997-01-03', 'LUCIANO JUNIOR', '113', '46.982.849-3', '698dc19d489c4e4db73e28a713eab07b', '(14) 9818-92154', 12, 8),
	(61, 'JARDIM DAS PAINEIRAS', 'CHAVANTES', 'PROVEDOR', '431.918.998-12', '2016-12-13', NULL, 'carlinhos@cednet.com.br', 'RUA ACÁCIA', 'SP', 'Casado', 'ENSINO MÉDIO COMPLETO', 'carlinhos', '1970-12-02', 'CARLOS ALBERTO DELAFIORI', '734', '47.845.121-2', '698dc19d489c4e4db73e28a713eab07b', '(14) 3342-9400', 12, 8),
	(62, 'CHAVANTES NOVO', 'CHAVANTES', 'CASA', '061.456.928-12', '2016-12-13', NULL, 'tiagobatista@sast.com.br', 'RUA ANTONIO NAKAGAWA', 'SP', 'Casado', 'ENSINO MÉDIO', 'tiagobatista', '1967-01-04', 'TIAGO BATISTA', '68', '45.454.588-7', '698dc19d489c4e4db73e28a713eab07b', '(14) 3342-1925', 60, 8);
/*!40000 ALTER TABLE `tb_funcionario` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_manutencao
CREATE TABLE IF NOT EXISTS `tb_manutencao` (
  `codigo` int(11) NOT NULL,
  `baixa` int(11) NOT NULL,
  `descProblema` varchar(255) COLLATE utf8_bin NOT NULL,
  `descricao` varchar(255) COLLATE utf8_bin NOT NULL,
  `dtAgendamento` timestamp NULL DEFAULT NULL,
  `dtExecucao` timestamp NULL DEFAULT NULL,
  `observacoes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prioridade` varchar(15) COLLATE utf8_bin NOT NULL,
  `codigoCliente_codigo` int(11) NOT NULL,
  `codigoFuncionario_codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKkho82rkppp1l0tmbi6qvgbs6f` (`codigoCliente_codigo`),
  KEY `FK3g144k1785xb5n9cns053tksb` (`codigoFuncionario_codigo`),
  CONSTRAINT `FK3g144k1785xb5n9cns053tksb` FOREIGN KEY (`codigoFuncionario_codigo`) REFERENCES `tb_funcionario` (`codigo`),
  CONSTRAINT `FKkho82rkppp1l0tmbi6qvgbs6f` FOREIGN KEY (`codigoCliente_codigo`) REFERENCES `tb_cliente` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_manutencao: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_manutencao` DISABLE KEYS */;
INSERT INTO `tb_manutencao` (`codigo`, `baixa`, `descProblema`, `descricao`, `dtAgendamento`, `dtExecucao`, `observacoes`, `prioridade`, `codigoCliente_codigo`, `codigoFuncionario_codigo`) VALUES
	(63, 0, 'LENTIDÃO SOMENTE NO PERÍODO NOTURNO', 'CONEXÃO LENTA', '2016-12-13 02:00:00', NULL, 'TESTAR A VELOCIDADE DEPOIS DAS 18H', 'NORMAL', 10, 62);
/*!40000 ALTER TABLE `tb_manutencao` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_perfil
CREATE TABLE IF NOT EXISTS `tb_perfil` (
  `codigo` int(11) NOT NULL,
  `gerenciarCargos` int(11) NOT NULL,
  `gerenciarClientes` int(11) NOT NULL,
  `gerenciarConfiguracoes` int(11) NOT NULL,
  `gerenciarFuncionarios` int(11) NOT NULL,
  `gerenciarManutencoes` int(11) NOT NULL,
  `gerenciarPerfis` int(11) NOT NULL,
  `gerenciarPlanos` int(11) NOT NULL,
  `nomePerfil` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_perfil: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_perfil` DISABLE KEYS */;
INSERT INTO `tb_perfil` (`codigo`, `gerenciarCargos`, `gerenciarClientes`, `gerenciarConfiguracoes`, `gerenciarFuncionarios`, `gerenciarManutencoes`, `gerenciarPerfis`, `gerenciarPlanos`, `nomePerfil`) VALUES
	(3, 1, 1, 0, 0, 1, 0, 0, 'Cliente'),
	(8, 1, 1, 0, 0, 1, 0, 0, 'Funcionário');
/*!40000 ALTER TABLE `tb_perfil` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_plano
CREATE TABLE IF NOT EXISTS `tb_plano` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) COLLATE utf8_bin NOT NULL,
  `garantia` int(11) NOT NULL,
  `tipoConexao` varchar(45) COLLATE utf8_bin NOT NULL,
  `valor` double NOT NULL,
  `velocidade` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_plano: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_plano` DISABLE KEYS */;
INSERT INTO `tb_plano` (`codigo`, `descricao`, `garantia`, `tipoConexao`, `valor`, `velocidade`) VALUES
	(6, 'FIBRA 5MB', 40, 'Fibra', 89.99, 5000),
	(57, 'FIBRA 10MB', 99, 'Fibra', 200, 10000),
	(58, 'FIBRA 20MB', 99, 'Fibra', 300, 20000);
/*!40000 ALTER TABLE `tb_plano` ENABLE KEYS */;

-- Copiando estrutura para tabela sast.tb_planocliente
CREATE TABLE IF NOT EXISTS `tb_planocliente` (
  `codigo` int(11) NOT NULL,
  `codigoCliente_codigo` int(11) NOT NULL,
  `codigoPlano_codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK3bbpttmjv4u3wbc0xrd9xy6y7` (`codigoCliente_codigo`),
  KEY `FKf5c7usfa19g22t1gtk0px1q8a` (`codigoPlano_codigo`),
  CONSTRAINT `FK3bbpttmjv4u3wbc0xrd9xy6y7` FOREIGN KEY (`codigoCliente_codigo`) REFERENCES `tb_cliente` (`codigo`),
  CONSTRAINT `FKf5c7usfa19g22t1gtk0px1q8a` FOREIGN KEY (`codigoPlano_codigo`) REFERENCES `tb_plano` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela sast.tb_planocliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_planocliente` DISABLE KEYS */;
INSERT INTO `tb_planocliente` (`codigo`, `codigoCliente_codigo`, `codigoPlano_codigo`) VALUES
	(48, 45, 6),
	(67, 65, 58);
/*!40000 ALTER TABLE `tb_planocliente` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
