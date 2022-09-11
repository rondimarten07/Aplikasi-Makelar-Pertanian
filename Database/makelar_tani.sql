-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Jul 2021 pada 10.28
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makelar_tani`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bandar`
--

CREATE TABLE `bandar` (
  `id_bandar` varchar(11) NOT NULL,
  `nama_bandar` varchar(36) NOT NULL,
  `no_ponsel` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bandar`
--

INSERT INTO `bandar` (`id_bandar`, `nama_bandar`, `no_ponsel`) VALUES
('BDR001', 'Mansyur', '082341545279'),
('BDR002', 'Sofyan', '085437556785'),
('BDR003', 'Asep', '086789766444'),
('BDR004', 'Ujang', '087553765245'),
('BDR005', 'Yusuf', '082145367890'),
('BDR006', 'Haris', '081365789443'),
('BDR007', 'Isman', '086738553468'),
('BDR008', 'Aceng', '087668990543'),
('BDR009', 'Komar', '089765889533'),
('BDR010', 'Ahmad', '083445667890');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(36) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `id_trx` varchar(11) NOT NULL,
  `tanggal` varchar(36) NOT NULL,
  `hasil_tani` varchar(36) NOT NULL,
  `jumlah` int(16) NOT NULL,
  `harga` int(16) NOT NULL,
  `total` int(100) NOT NULL,
  `id_petani` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`id_trx`, `tanggal`, `hasil_tani`, `jumlah`, `harga`, `total`, `id_petani`) VALUES
('TRX001', '31-07-2021 12:09:01', 'Padi', 1000, 5000, 5000000, 'PTN001'),
('TRX002', '31-07-2021 12:57:10', 'Cabe', 100, 4000, 400000, 'PTN002'),
('TRX003', '31-07-2021 12:58:27', 'Terong', 80, 3500, 280000, 'PTN003'),
('TRX004', '31-07-2021 12:59:12', 'Kacang', 150, 3000, 450000, 'PTN004'),
('TRX005', '31-07-2021 01:00:39', 'Timun', 200, 2500, 500000, 'PTN005'),
('TRX006', '31-07-2021 01:03:32', 'Pare', 120, 35000, 4200000, 'PTN006'),
('TRX007', '31-07-2021 01:04:30', 'Oyong', 90, 4000, 360000, 'PTN007'),
('TRX008', '31-07-2021 01:05:29', 'Kacang Panjang', 140, 2500, 350000, 'PTN008'),
('TRX009', '31-07-2021 01:08:00', 'Padi', 80, 5500, 440000, 'PTN009'),
('TRX010', '31-07-2021 01:09:35', 'Cabe', 3500, 150, 525000, 'PTN009');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `id_trx` varchar(11) NOT NULL,
  `tanggal` varchar(36) NOT NULL,
  `hasil_tani` varchar(36) NOT NULL,
  `jumlah` int(16) NOT NULL,
  `harga` int(16) NOT NULL,
  `total` int(100) NOT NULL,
  `id_bandar` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`id_trx`, `tanggal`, `hasil_tani`, `jumlah`, `harga`, `total`, `id_bandar`) VALUES
('TRX001', '31-07-2021 01:11:00', 'Padi', 1000, 6000, 6000000, 'BDR002'),
('TRX002', '31-07-2021 01:10:40', 'Cabe', 100, 5500, 550000, 'BDR001'),
('TRX003', '31-07-2021 01:12:37', 'Terong', 80, 5000, 400000, 'BDR005'),
('TRX004', '31-07-2021 01:11:37', 'Kacang', 150, 3500, 525000, 'BDR003'),
('TRX005', '31-07-2021 01:14:38', 'Timun', 200, 4500, 900000, 'BDR006'),
('TRX006', '31-07-2021 01:15:54', 'Pare', 120, 40000, 4800000, 'BDR008'),
('TRX007', '31-07-2021 01:15:03', 'Oyong', 90, 5000, 450000, 'BDR007'),
('TRX008', '31-07-2021 01:12:08', 'Kacang Panjang', 140, 3500, 490000, 'BDR004'),
('TRX009', '31-07-2021 01:16:44', 'Padi', 80, 6500, 520000, 'BDR010'),
('TRX010', '31-07-2021 01:16:28', 'Cabe', 3500, 5000, 17500000, 'BDR009');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petani`
--

CREATE TABLE `petani` (
  `id_petani` varchar(11) NOT NULL,
  `nama_petani` varchar(36) NOT NULL,
  `lokasi_sawah` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `petani`
--

INSERT INTO `petani` (`id_petani`, `nama_petani`, `lokasi_sawah`) VALUES
('PTN001', 'Dzalil', 'Blok Utara'),
('PTN002', 'Jalal', 'Blok Selatan'),
('PTN003', 'Samsudin', 'Blok Timur'),
('PTN004', 'Syamsul', 'Blok Barat'),
('PTN005', 'Arif', 'Blok Barat'),
('PTN006', 'Malih', 'Blok Selatan'),
('PTN007', 'Slamet', 'Blok Timur'),
('PTN008', 'Riyadi', 'Blok Barat'),
('PTN009', 'Agus', 'Blok Utara'),
('PTN010', 'Dadang', 'Blok Timur');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bandar`
--
ALTER TABLE `bandar`
  ADD PRIMARY KEY (`id_bandar`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id_trx`),
  ADD KEY `id_petani` (`id_petani`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_trx`),
  ADD KEY `id_bandar` (`id_bandar`);

--
-- Indeks untuk tabel `petani`
--
ALTER TABLE `petani`
  ADD PRIMARY KEY (`id_petani`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`id_petani`) REFERENCES `petani` (`id_petani`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`id_bandar`) REFERENCES `bandar` (`id_bandar`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
