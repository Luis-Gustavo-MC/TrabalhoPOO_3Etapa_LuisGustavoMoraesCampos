-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29/06/2024 às 04:05
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `petshop`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `animal`
--

CREATE TABLE `animal` (
  `idAnimal` int(11) NOT NULL,
  `nomeAnimal` varchar(30) NOT NULL,
  `especieAnimal` varchar(30) NOT NULL,
  `racaAnimal` varchar(30) NOT NULL,
  `idadeAnimal` int(11) NOT NULL,
  `sexoAnimal` varchar(30) NOT NULL,
  `pesoAnimal` double NOT NULL,
  `fotoAnimal` varchar(255) DEFAULT NULL,
  `statusAnimal` tinyint(1) NOT NULL,
  `caminhoFoto` varchar(255) DEFAULT NULL,
  `idProprietario_Animal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `animal`
--

INSERT INTO `animal` (`idAnimal`, `nomeAnimal`, `especieAnimal`, `racaAnimal`, `idadeAnimal`, `sexoAnimal`, `pesoAnimal`, `fotoAnimal`, `statusAnimal`, `caminhoFoto`, `idProprietario_Animal`) VALUES
(1, 'aaaa', 'a', 'a', 12, 'm', 20, 'zxc', 1, 'jdklsa', 1),
(2, 'aaa', 'aaa', 'aaa', 20, 'm', 2, 'aaadsa', 1, 'jdlsa', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadastro_servico`
--

CREATE TABLE `cadastro_servico` (
  `idCServicos` int(11) NOT NULL,
  `nomeCServico` varchar(30) NOT NULL,
  `descricaoCServico` varchar(200) NOT NULL,
  `precoCServico` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `proprietario`
--

CREATE TABLE `proprietario` (
  `idProprietario` int(11) NOT NULL,
  `enderecoProprietario` varchar(30) NOT NULL,
  `telefoneProprietario` varchar(30) NOT NULL,
  `emailProprietario` varchar(30) NOT NULL,
  `statusProprietario` tinyint(1) NOT NULL,
  `nomeProprietario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `proprietario`
--

INSERT INTO `proprietario` (`idProprietario`, `enderecoProprietario`, `telefoneProprietario`, `emailProprietario`, `statusProprietario`, `nomeProprietario`) VALUES
(1, 'aaaa', '9897321', 'gjklga', 1, 'aaaa'),
(2, 'bbb', '12', 'mg', 1, 'aaa'),
(3, 'kçkdas', '111', 'lg', 1, '0');

-- --------------------------------------------------------

--
-- Estrutura para tabela `servico`
--

CREATE TABLE `servico` (
  `idServico` int(11) NOT NULL,
  `dataServico` date NOT NULL,
  `valor` double NOT NULL,
  `observacoes` varchar(200) NOT NULL,
  `idAnimal_Servico` int(11) NOT NULL,
  `idProprietario_Servico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`idAnimal`),
  ADD KEY `idProprietario_Animal` (`idProprietario_Animal`);

--
-- Índices de tabela `cadastro_servico`
--
ALTER TABLE `cadastro_servico`
  ADD PRIMARY KEY (`idCServicos`);

--
-- Índices de tabela `proprietario`
--
ALTER TABLE `proprietario`
  ADD PRIMARY KEY (`idProprietario`);

--
-- Índices de tabela `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`idServico`),
  ADD KEY `idProprietario_Servico` (`idProprietario_Servico`),
  ADD KEY `idAnimal_Servico` (`idAnimal_Servico`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `animal`
--
ALTER TABLE `animal`
  MODIFY `idAnimal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `cadastro_servico`
--
ALTER TABLE `cadastro_servico`
  MODIFY `idCServicos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `proprietario`
--
ALTER TABLE `proprietario`
  MODIFY `idProprietario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `servico`
--
ALTER TABLE `servico`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`idProprietario_Animal`) REFERENCES `proprietario` (`idProprietario`);

--
-- Restrições para tabelas `servico`
--
ALTER TABLE `servico`
  ADD CONSTRAINT `servico_ibfk_1` FOREIGN KEY (`idProprietario_Servico`) REFERENCES `proprietario` (`idProprietario`),
  ADD CONSTRAINT `servico_ibfk_2` FOREIGN KEY (`idAnimal_Servico`) REFERENCES `animal` (`idAnimal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
