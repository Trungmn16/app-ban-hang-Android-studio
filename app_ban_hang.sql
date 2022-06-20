-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 20, 2022 lúc 04:25 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `app_ban_hang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `iddonhang` int(11) NOT NULL,
  `idsp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`iddonhang`, `idsp`, `soluong`, `gia`) VALUES
(17, 19, 1, '33990000'),
(17, 20, 3, '20500000'),
(18, 19, 1, '33990000'),
(18, 20, 3, '20500000'),
(19, 19, 1, '33990000'),
(20, 19, 1, '33990000'),
(21, 19, 1, '33990000'),
(22, 19, 1, '33990000'),
(23, 20, 1, '20500000'),
(24, 20, 2, '41000000'),
(24, 19, 1, '33990000'),
(25, 20, 2, '41000000'),
(25, 19, 1, '33990000'),
(26, 19, 1, '33990000'),
(27, 20, 1, '20500000'),
(28, 19, 1, '33990000'),
(28, 20, 3, '20500000'),
(29, 17, 1, '46600000'),
(30, 17, 1, '46600000'),
(31, 17, 1, '46600000'),
(32, 18, 1, '24280000'),
(33, 11, 1, '12200000'),
(34, 19, 1, '33990000'),
(35, 20, 1, '20500000'),
(36, 20, 1, '20500000'),
(37, 20, 1, '20500000'),
(38, 19, 1, '33990000'),
(39, 20, 1, '20500000'),
(40, 20, 1, '20500000'),
(41, 17, 1, '46600000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `diachi` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `tongtien` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `iduser`, `diachi`, `sdt`, `email`, `soluong`, `tongtien`) VALUES
(19, 9, 'Thai nguyen', '08888666', 'trung@gmail.com', 1, '33990000'),
(20, 9, 'Thai nguyen', '08888666', 'trung@gmail.com', 1, '33990000'),
(21, 9, 'Thai nguyen', '08888666', 'trung@gmail.com', 1, '33990000'),
(22, 9, 'Thai', '08888666', 'trung@gmail.com', 1, '33990000'),
(23, 9, 'Bac kan', '08888666', 'trung@gmail.com', 1, '20500000'),
(24, 9, 'Bac Ninh', '08888666', 'trung@gmail.com', 3, '115990000'),
(25, 9, 'Bac Ninh', '08888666', 'trung@gmail.com', 3, '115990000'),
(26, 9, 'Thai binh', '08888666', 'trung@gmail.com', 1, '33990000'),
(27, 10, 'Thai Binh', '0634505', 'maitrungmnt01@gmail.com', 1, '20500000'),
(28, 2, 'hihi', '0634505', 'maitrungmnt01@gmail.com', 5, '9999'),
(29, 10, 'Thai Nguyen', '0634505', 'maitrungmnt01@gmail.com', 1, '46600000'),
(30, 10, 'Thai Nguyen', '0634505', 'maitrungmnt01@gmail.com', 1, '46600000'),
(31, 10, 'Bac kan', '0634505', 'maitrungmnt01@gmail.com', 1, '46600000'),
(32, 10, 'Bac Ninh', '0634505', 'maitrungmnt01@gmail.com', 1, '24280000'),
(33, 10, 'Ha Noi', '0634505', 'maitrungmnt01@gmail.com', 1, '12200000'),
(34, 10, 'Nam dinh', '0634505', 'maitrungmnt01@gmail.com', 1, '33990000'),
(35, 10, 'Quang ninh', '0634505', 'maitrungmnt01@gmail.com', 1, '20500000'),
(36, 9, 'camau', '08888666', 'trung@gmail.com', 1, '20500000'),
(37, 9, 'ok', '08888666', 'trung@gmail.com', 1, '20500000'),
(38, 9, 'hihi', '08888666', 'trung@gmail.com', 1, '33990000'),
(39, 9, 'k', '08888666', 'trung@gmail.com', 1, '20500000'),
(40, 9, 'Lang son', '08888666', 'trung@gmail.com', 1, '20500000'),
(41, 9, 'Hung yen', '08888666', 'trung@gmail.com', 1, '46600000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `name`, `image`) VALUES
(1, 'Trang chủ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3JG2x9oP38yVxf-o_xZg4NsjwvA8BItfnJVasQzumFZxMVi-y-Wp275eP7TP-oTCaA3o&usqp=CAU'),
(2, 'Iphone', 'https://ngochieu.name.vn/img/mobile.png'),
(3, 'Samsung', 'https://ngochieu.name.vn/img/laptop.png'),
(4, 'Liên hệ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJrukctjhaL-C15ECOPLVuzddgFJ04mGjuHQ&usqp=CAU'),
(5, 'Tài khoản', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKRCfg2xIu9yLGDGiAXcw56FM5zjIvvCPsfQ&usqp=CAU'),
(21, 'Đơn hàng', 'https://www.thegioididong.com/lich-su-mua-hang/images/i1.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanphammoi`
--

CREATE TABLE `sanphammoi` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` int(2) NOT NULL,
  `price` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanphammoi`
--

INSERT INTO `sanphammoi` (`id`, `name`, `image`, `description`, `type`, `price`) VALUES
(1, 'Samsung Galaxy S22 plus 256GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/2/s22_2.jpg', 'Kích thước màn hình	6.6 inches\nCông nghệ màn hình	Dynamic AMOLED 2X\nCamera sau	50 MP + 12 MP + 10MP\nCamera trước	10 MP\nChipset	Snapdragon 8 Gen 1 8 nhân\nDung lượng RAM	8 GB\nBộ nhớ trong	256 GB\nPin	4500 mAh\nThẻ SIM	2 SIM (Nano-SIM)\nHệ điều hành	Android 12\nĐộ phân giải màn hình	1080 x 2340 pixels (FullHD+)', 2, '20900000'),
(2, 'Samsung Galaxy Z Fold3 5G', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/m/sm-f926_zfold3_5g_openback_phantomblack_210601.jpg', 'Kích thước màn hình	7.6 inches\nCông nghệ màn hình	Dynamic AMOLED\nCamera sau	Camera góc rộng: 12 MP, f/1.8, 26mm, Dual Pixel PDAF, OIS\nCamera tele: 12 MP, f/2.4, 52mm, PDAF, OIS, 2x Zoom quang học\nCamera góc siêu rộng: 12 MP, f/2.2\nCamera màn hình phụ: 10MP, f/2.2\nCamera trước	Camera ẩn dưới màn hình: 4MP, f/1.8\nChipset	Snapdragon 888 5G (5 nm)\nDung lượng RAM	12 GB\nBộ nhớ trong	256 GB\nPin	Li-Po 4400 mAh\nThẻ SIM	2 SIM (nano‑SIM và eSIM)\nHệ điều hành	Android 11\nTính năng màn hình	Màn hình chính: 7.9\" 2208x1768, 374ppi, HDR10+, 120Hz\nMàn hình phụ: 6.23\" 2268x832, HD+ Dynamic AMOLED 2X (24.5:9) Infinity-O Display, 38ppi, 120Hz\nLoại CPU	1 nhân 2.84 GHz, 3 nhân 2.42 GHz & 4 nhân 1.8 GHz', 2, '31100000'),
(3, 'Samsung Galaxy Z Flip3 5G', 'https://dienthoaihay.vn/images/products/2020/12/06/large/samsung-z-flip_1607228299.jpg', 'Kích thước màn hình	6.7 inches\nCông nghệ màn hình	Super AMOLED\nCamera sau	Camera góc siêu rộng: 12MP, f/2.2, Dual Pixel AF, OIS\nCamera góc rộng: 12MP, f/1.8\nCamera trước	Góc rộng 10MP, f/2.4\nChipset	Snapdragon 888 8 (5nm)\nDung lượng RAM	8 GB\nBộ nhớ trong	128 GB\nPin	3300 mAh\nThẻ SIM	2 SIM (nano‑SIM và eSIM)\nHệ điều hành	Android 11\nTính năng màn hình	Màn hình chính: 6.7\" 2640 x 1080 425ppi , FHD+ Dynamic AMOLED 2X Display (22:9), 120Hz\nMàn hình phụ: 1.9\" Super AMOLED, 260 x 512 302ppi\nLoại CPU	1 nhân 2.84 GHz, 3 nhân 2.42 GHz & 4 nhân 1.8 GHz', 2, '24280000'),
(4, 'iPhone 13 Pro Max 128GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/i/p/iphone_13-_pro-4_2.jpg', '\"Kích thước màn hình 6.1 inches\nCông nghệ màn hình OLED\nCamera sau Camera góc rộng: 12MP, f/1.6\nCamera góc siêu rộng: 12MP, ƒ/2.4\nCamera trước 12MP, f/2.2\nChipset Apple A15\nDung lượng RAM 4 GB\"', 1, '33990000'),
(5, 'iPhone 12 Pro Max 128GB', 'https://bachkhoamobile.com/wp-content/uploads/2021/04/637382725406081030_ip-12-pro-max-vang-11607421625452.png.webp', 'Màn hình: OLED6.7 Super Retina XDR\nHệ điều hành:iOS 14\nCamera sau:3 camera 12 MP\nCamera trước:12 MP\nChip:Apple A14 Bionic\nRAM:6 GB\nBộ nhớ trong:128 GB\nSIM:1 Nano SIM & 1 eSIMHỗ trợ 5G\nPin, Sạc: 3687 mAh20 W', 1, '20500000'),
(6, 'Samsung Galaxy S22 Ultra 256GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/m/sm-s908_galaxys22ultra_front_green_211119_2.jpg', 'Kích thước màn hình	6.8 inches\nCông nghệ màn hình	Dynamic AMOLED 2X\nCamera sau	108 MP, f/1.8 góc rộng\n10 MP, f/4.9\n10 MP, f/2.4\n12 MP, f/2.2 góc siêu rộng\nCamera trước	40 MP, f/2.2\nChipset	Qualcomm Snapdragon 8 Gen 1 (4 nm)\nDung lượng RAM	12 GB\nBộ nhớ trong	256 GB\nPin	Li-Ion 5000 mAh\nThẻ SIM	2 Nano-SIM + eSIM\nHệ điều hành	Android 12, One UI 4.1\nĐộ phân giải màn hình	1440 x 3088 pixels (QHD+)', 2, '26990000'),
(7, 'Samsung Galaxy A73 (5G) 256GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/a/samsung-galaxy-a73-1-600x600.jpg', 'Kích thước màn hình	6.7 inches\nCông nghệ màn hình	Super AMOLED\nCamera sau	Camera chính: 108 MP, f/1.8, PDAF, OIS\nCamera gó siêu rộng: 12 MP, f/2.2\nCamera macro: 5 MP, f/2.4\nCamera chân dung: 5 MP, f/2.4\nCamera trước	32 MP, f/2.2\nChipset	Snapdragon 778G 5G 8 nhân\nDung lượng RAM	8 GB\nBộ nhớ trong	256 GB\nPin	5000 mAh\nThẻ SIM	2 SIM (Nano-SIM)\nHệ điều hành	Android 12, One UI 4.1\nĐộ phân giải màn hình	1080 x 2400 pixels (FullHD+)\nTính năng màn hình	Tần số quét 120 Hz, Kính cường lực Corning Gorilla Glass 5\nLoại CPU	Octa-core (2.4 GHz & 1.8 GHz)', 2, '11200000'),
(8, 'Samsung Galaxy M53 5G 256GB', 'https://images.samsung.com/is/image/samsung/p6pim/vn/sm-m536bzghxxv/gallery/vn-galaxy-m53-5g-sm-m536-sm-m536bzghxxv-thumb-532145429?$160_160_PNG$', 'Kích cỡ (Màn hình chính)\n169.5mm (6.7 inch hình chữ nhật hoàn chỉnh) / 166.4mm (6.6 inch tính đến các góc bo tròn)\nĐộ phân giải (Màn hình chính)\n1080 x 2400 (FHD+)\n \nCông nghệ màn hình (màn hình chính)\nSuper AMOLED Plus\n \nĐộ sâu màu sắc (Màn hình chính)\n16M\n\n\nCamera sau - Độ phân giải (Multiple)\n108 MP + 8.0 MP + 2.0 MP + 2.0 MP\n \nCamera sau - Khẩu độ (Đa khẩu độ)\nF1.8 , F2.2 , F2.4 , F2.4\n \nCamera chính - Tự động lấy nét\nOK\n \nCamera sau - OIS\nKhông\n \nCamera trước - Độ phân giải\n32.0 MP\n \nCamera trước - Khẩu độ\nF2.2\n \nCamera trước - Tự động lấy nét\nKhông\n \nCamera trước - OIS\nKhông\n \nCamera chính - Flash\nCó\n \nCamera trước - Flash\nKhông\n \nĐộ Phân Giải Quay Video\nUHD 4K (3840 x 2160)@30fps\n \nQuay Chậm\n240fps @HD\nBộ nhớ\nRAM (GB)\n8\n \nROM (GB)\n256\n \nBộ nhớ khả dụng (GB) *\n218.0\n \nHỗ trợ thẻ nhớ ngoài\nMicroSD (Up to 1TB)', 2, '11900000'),
(9, 'iPhone 11 Pro Max 64GB', 'https://didongmogi.com/wp-content/uploads/2020/06/851886754.jpeg', 'Màn hình:OLED6.5″Super Retina XDR\nHệ điều hành:iOS 14\nCamera sau:3 camera 12 MP\nCamera trước:12 MP\nChip:Apple A13 Bionic\nRAM:4 GB\nBộ nhớ trong: 64 GB\nSIM:1 Nano SIM & 1 eSIMHỗ trợ 4G\nPin, Sạc:3969 mAh', 1, '33990000'),
(10, 'iPhone 11 8GB - 256GB   ', 'https://didongmogi.com/wp-content/uploads/2020/05/1048389602.png', 'Kích thước 75.7 x 8.3 x 150.9 mm\nTrọng lượng sản phẩm 194 g\nMặt lưng máy: Kính\nViền máy: Nhôm\nBộ xử lý\nPhiên bản CPU Apple A13 Bionic\nRAM 4 GB\nKích thước màn hình 6.1 inch\nCông nghệ màn hình IPS LCD\nĐộ phân giải 828 x 1792 Pixels\nChuẩn màn hình Liquid Retina HD\nMàu màn hình 16 Triệu\nChất liệu mặt kính Kính cường lực\nLoại cảm ứng Điện dung đa điểm\nMật độ điểm ảnh	324 ppi\nĐộ sáng tối đa	625 nits\nĐộ phủ màu 100% DCI-P3\nTỷ lệ khung hình 19.5:9\nTỷ lệ tương phản 1400:1\nGPU Apple GPU 4 nhân\nBộ nhớ trong 256 GB', 1, '18500000'),
(11, 'Samsung Galaxy S21 FE 5G ', 'https://cdn.tgdd.vn/Products/Images/42/267212/Samsung-Galaxy-S21-FE-vang-600x600.jpg', 'Màn hình Dynamic AMOLED 2X, 6.4\", Full HD+\nChip Exynos 2100\nRAM 8 GB, ROM 256 GB\nCamera sau: Chính 12 MP & Phụ 12 MP, 8 MP\nCamera trước: 32 MP\nPin 4500 mAh, Sạc 25 W', 2, '12200000'),
(12, 'Samsung Galaxy S22 plus 256GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/2/s22_2.jpg', 'Kích thước màn hình	6.6 inches\nCông nghệ màn hình	Dynamic AMOLED 2X\nCamera sau	50 MP + 12 MP + 10MP\nCamera trước	10 MP\nChipset	Snapdragon 8 Gen 1 8 nhân\nDung lượng RAM	8 GB\nBộ nhớ trong	256 GB\nPin	4500 mAh\nThẻ SIM	2 SIM (Nano-SIM)\nHệ điều hành	Android 12\nĐộ phân giải màn hình	1080 x 2340 pixels (FullHD+)', 2, '20900000'),
(13, 'Samsung Galaxy S22 Ultra 256GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/m/sm-s908_galaxys22ultra_front_green_211119_2.jpg', 'Kích thước màn hình	6.8 inches\nCông nghệ màn hình	Dynamic AMOLED 2X\nCamera sau	108 MP, f/1.8 góc rộng\n10 MP, f/4.9\n10 MP, f/2.4\n12 MP, f/2.2 góc siêu rộng\nCamera trước	40 MP, f/2.2\nChipset	Qualcomm Snapdragon 8 Gen 1 (4 nm)\nDung lượng RAM	12 GB\nBộ nhớ trong	256 GB\nPin	Li-Ion 5000 mAh\nThẻ SIM	2 Nano-SIM + eSIM\nHệ điều hành	Android 12, One UI 4.1\nĐộ phân giải màn hình	1440 x 3088 pixels (QHD+)', 2, '26990000'),
(14, 'iPhone 13 Pro Max 128GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/i/p/iphone_13-_pro-4_2.jpg', '\"Kích thước màn hình 6.1 inches\r\nCông nghệ màn hình OLED\r\nCamera sau Camera góc rộng: 12MP, f/1.6\r\nCamera góc siêu rộng: 12MP, ƒ/2.4\r\nCamera trước 12MP, f/2.2\r\nChipset Apple A15\r\nDung lượng RAM 4 GB\"', 1, '33990000'),
(15, 'iPhone 13 8GB - 256GB ', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/i/p/iphone-13-02_2.jpg', 'Kích thước màn hình	6.1 inches\nCông nghệ màn hình	OLED\nCamera sau	Camera góc rộng: 12MP, f/1.6\nCamera góc siêu rộng: 12MP, ƒ/2.4\nCamera trước	12MP, f/2.2\nChipset	Apple A15\nDung lượng RAM	4 GB\nBộ nhớ trong	256 GB\nPin	Khoảng 3,200mAh\nHệ điều hành	iOS 15\nĐộ phân giải màn hình	2532 x 1170 pixels', 1, '22900000'),
(16, 'Samsung Galaxy A73 (5G) 256GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/s/a/samsung-galaxy-a73-1-600x600.jpg', 'Kích thước màn hình	6.7 inches\nCông nghệ màn hình	Super AMOLED\nCamera sau	Camera chính: 108 MP, f/1.8, PDAF, OIS\nCamera gó siêu rộng: 12 MP, f/2.2\nCamera macro: 5 MP, f/2.4\nCamera chân dung: 5 MP, f/2.4\nCamera trước	32 MP, f/2.2\nChipset	Snapdragon 778G 5G 8 nhân\nDung lượng RAM	8 GB\nBộ nhớ trong	256 GB\nPin	5000 mAh\nThẻ SIM	2 SIM (Nano-SIM)\nHệ điều hành	Android 12, One UI 4.1\nĐộ phân giải màn hình	1080 x 2400 pixels (FullHD+)\nTính năng màn hình	Tần số quét 120 Hz, Kính cường lực Corning Gorilla Glass 5\nLoại CPU	Octa-core (2.4 GHz & 1.8 GHz)', 2, '12200000'),
(17, 'Samsung Galaxy M53 5G 256GB', 'https://images.samsung.com/is/image/samsung/p6pim/vn/sm-m536bzghxxv/gallery/vn-galaxy-m53-5g-sm-m536-sm-m536bzghxxv-thumb-532145429?$160_160_PNG$', 'Kích cỡ (Màn hình chính)\n169.5mm (6.7 inch hình chữ nhật hoàn chỉnh) / 166.4mm (6.6 inch tính đến các góc bo tròn)\nĐộ phân giải (Màn hình chính)\n1080 x 2400 (FHD+)\n \nCông nghệ màn hình (màn hình chính)\nSuper AMOLED Plus\n \nĐộ sâu màu sắc (Màn hình chính)\n16M\n\n\nCamera sau - Độ phân giải (Multiple)\n108 MP + 8.0 MP + 2.0 MP + 2.0 MP\n \nCamera sau - Khẩu độ (Đa khẩu độ)\nF1.8 , F2.2 , F2.4 , F2.4\n \nCamera chính - Tự động lấy nét\nOK\n \nCamera sau - OIS\nKhông\n \nCamera trước - Độ phân giải\n32.0 MP\n \nCamera trước - Khẩu độ\nF2.2\n \nCamera trước - Tự động lấy nét\nKhông\n \nCamera trước - OIS\nKhông\n \nCamera chính - Flash\nCó\n \nCamera trước - Flash\nKhông\n \nĐộ Phân Giải Quay Video\nUHD 4K (3840 x 2160)@30fps\n \nQuay Chậm\n240fps @HD\nBộ nhớ\nRAM (GB)\n8\n \nROM (GB)\n256\n \nBộ nhớ khả dụng (GB) *\n218.0\n \nHỗ trợ thẻ nhớ ngoài\nMicroSD (Up to 1TB)', 2, '11900000'),
(18, 'Samsung Galaxy Z Flip3 5G', 'https://dienthoaihay.vn/images/products/2020/12/06/large/samsung-z-flip_1607228299.jpg', 'Kích thước màn hình	6.7 inches\nCông nghệ màn hình	Super AMOLED\nCamera sau	Camera góc siêu rộng: 12MP, f/2.2, Dual Pixel AF, OIS\nCamera góc rộng: 12MP, f/1.8\nCamera trước	Góc rộng 10MP, f/2.4\nChipset	Snapdragon 888 8 (5nm)\nDung lượng RAM	8 GB\nBộ nhớ trong	128 GB\nPin	3300 mAh\nThẻ SIM	2 SIM (nano‑SIM và eSIM)\nHệ điều hành	Android 11\nTính năng màn hình	Màn hình chính: 6.7\" 2640 x 1080 425ppi , FHD+ Dynamic AMOLED 2X Display (22:9), 120Hz\nMàn hình phụ: 1.9\" Super AMOLED, 260 x 512 302ppi\nLoại CPU	1 nhân 2.84 GHz, 3 nhân 2.42 GHz & 4 nhân 1.8 GHz', 2, '24280000'),
(19, 'iPhone SE 8GB - 128GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/i/p/iphone-se-starlight-select-202203_1.jpg', 'Kích thước màn hình	4.7 inches\nCông nghệ màn hình	Liquid Retina\nCamera sau	Camera góc rộng: 12MP, ƒ/1.8\nCamera trước	7MP, ƒ/2.2\nChipset	Chip A15 Bionic\nDung lượng RAM	4 GB\nBộ nhớ trong	128 GB\nPin	1.820mAh\nThẻ SIM	2 SIM (nano‑SIM và eSIM)\nHệ điều hành	iOS 15\nĐộ phân giải màn hình	1334 x 750 pixels (HD+)\nCamera sau Camera góc rộng: 12MP, f/1.6\nCamera góc siêu rộng: 12MP, ƒ/2.4\nCamera trước 12MP, f/2.2\nChipset Apple A15\nDung lượng RAM 4 GB\"', 1, '14600000'),
(20, 'iPhone 13 mini 128GB', 'https://cdn2.cellphones.com.vn/358x/media/catalog/product/i/p/iphone-13-02_6.jpg', 'Kích thước màn hình	5.4 inches\nCông nghệ màn hình	OLED\nCamera sau	Camera góc rộng: 12MP, f/1.6\nCamera góc siêu rộng: 12MP, ƒ/2.4\nCamera trước	12MP, f/2.2\nChipset	Apple A15\nDung lượng RAM	4 GB\nBộ nhớ trong	128 GB\nPin	2,406mAh\nThẻ SIM	2 SIM (nano‑SIM và eSIM)\nHệ điều hành	iOS15\nĐộ phân giải màn hình	1080 x 2340 pixels (FullHD+)', 1, '18500000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pass` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `pass`, `username`, `mobile`) VALUES
(9, 'trung@gmail.com', '333', 'trung dz', '08888666'),
(10, 'maitrungmnt01@gmail.com', 'trungdz', 'mai trung', '0634505'),
(11, 'trung12345@gmail.com', '123456', 'trung', '035658'),
(12, 'trunglll', '12345', 'trung222', '037966'),
(13, 'trung1234@gmail.com', '123456', 'trung123', '03584524'),
(14, 'trung1232@gmail.com', '123456', 'trung1234', '8325458');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
