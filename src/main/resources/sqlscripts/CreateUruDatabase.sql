-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.5.39 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for uruappdb
CREATE DATABASE IF NOT EXISTS `uruappdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `uruappdb`;


-- Dumping structure for table uruappdb.catalog_property_key
CREATE TABLE IF NOT EXISTS `catalog_property_key` (
  `PROPERTY_KEY_ID` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'PK—a unique, system-generated number used as a record identifier.',
  `PROPERTY_NAME` varchar(100) NOT NULL COMMENT 'The name of the property (formerly PROPERTY_NAME from the WLCS_PROP_ID table).',
  `CREATION_DATE` date NOT NULL COMMENT 'The time and date the record was created.',
  `MODIFIED_DATE` date NOT NULL COMMENT 'The time and date the record was last modified.',
  `PROPERTY_CODE` varchar(40) NOT NULL COMMENT 'The name of the property set (formerly the SCOPE_NAME from WLCS_PROP_ID).',
  `PROPERTY_SET_TYPE` varchar(100) NOT NULL COMMENT 'The type of property set (for example, USER)',
  PRIMARY KEY (`PROPERTY_KEY_ID`),
  UNIQUE KEY `PROPERTY_CODE` (`PROPERTY_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table stores unique identification numbers for scoped property names that are associated with configurable entities.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.catalog_property_value
CREATE TABLE IF NOT EXISTS `catalog_property_value` (
  `PROPERTY_VALUE_ID` bigint(15) NOT NULL COMMENT 'PK—a unique, system-generated number used as a record identifier.',
  `PROPERTY_KEY_ID` bigint(15) NOT NULL COMMENT 'A system-generated value and foreign key to the PROPERTY_KEY column.',
  `SKU` varchar(40) NOT NULL COMMENT 'A system-generated value and foreign key to the ENTITY column.',
  `PROPERTY_TYPE` int(1) NOT NULL COMMENT 'Valid entries are:',
  `CREATION_DATE` date NOT NULL COMMENT 'The time and date the record was created.',
  `MODIFIED_DATE` date NOT NULL COMMENT 'The time and date the record was last modified.',
  `BOOLEAN_VALUE` int(1) DEFAULT NULL COMMENT 'The value for each boolean property identifier.',
  `DATETIME_VALUE` date DEFAULT NULL COMMENT 'The value associated with each float property identifier.',
  `DOUBLE_VALUE` int(10) DEFAULT NULL COMMENT 'The value associated with each float property identifier.',
  `LONG_VALUE` int(20) DEFAULT NULL COMMENT 'The value associated with the integer property.',
  `TEXT_VALUE` varchar(254) DEFAULT NULL COMMENT 'The value associated with the text property.',
  `BLOB_VALUE` int(11) DEFAULT NULL COMMENT 'The value associated with the user-defined property.',
  PRIMARY KEY (`PROPERTY_VALUE_ID`),
  KEY `FK_catalog_property_value_ecom_item` (`SKU`),
  KEY `FK_catalog_property_value_catalog_property_key` (`PROPERTY_KEY_ID`),
  CONSTRAINT `FK_catalog_property_value_catalog_property_key` FOREIGN KEY (`PROPERTY_KEY_ID`) REFERENCES `catalog_property_key` (`PROPERTY_KEY_ID`),
  CONSTRAINT `FK_catalog_property_value_ecom_item` FOREIGN KEY (`SKU`) REFERENCES `ecom_item` (`SKU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table stores Boolean, timestamp, float, integer, text, and user-defined (object) property values that are associated with configurable entities.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.discount
CREATE TABLE IF NOT EXISTS `discount` (
  `DISCOUNT_ID` bigint(15) NOT NULL COMMENT 'PK—a unique, system-generated number to be used as the record ID.',
  `DISCOUNT_SET_ID` int(15) NOT NULL COMMENT 'FK—foreign key to the DISCOUNT_SET table.',
  `DISCOUNT_TYPE` varchar(100) NOT NULL COMMENT 'The type of discount offered. It is used for an order or for an order line item.',
  `DISCOUNT_NAME` varchar(254) NOT NULL COMMENT 'The name of the discount.',
  `IS_GLOBAL` int(1) NOT NULL COMMENT 'A flag showing whether or not this discount can be used globally.',
  `PRIORITY` int(1) NOT NULL COMMENT 'The level of priority this discount has over other discounts.',
  `ALLOWED_USERS` int(10) NOT NULL COMMENT 'The number of times the discount may be used.',
  `MODIFIER` varchar(254) NOT NULL COMMENT 'Describes the actual discount to be applied. This is XML.',
  `DISCOUNT_RULE` tinyblob NOT NULL COMMENT 'The method used to select items for discount. This is XML.',
  `START_DATE` date NOT NULL COMMENT 'The starting date and time of the discount',
  `END_DATE` date NOT NULL COMMENT 'The ending date and time of the discount',
  `IS_ACTIVE` int(1) NOT NULL COMMENT 'A flag that determines whether the discount is active or not. Active=1, Not active=0',
  `DESCRIPTION` varchar(254) DEFAULT NULL COMMENT 'The discount description.',
  `DISPLAY_DESCRIPTION` varchar(254) DEFAULT NULL COMMENT 'The discount description used for display purposes only.',
  PRIMARY KEY (`DISCOUNT_ID`),
  KEY `FK_discount_discount_set` (`DISCOUNT_SET_ID`),
  CONSTRAINT `FK_discount_discount_set` FOREIGN KEY (`DISCOUNT_SET_ID`) REFERENCES `discount_set` (`DISCOUNT_SET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table stores stores one or more discount records for every DISCOUNT_SET record.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.discount_association
CREATE TABLE IF NOT EXISTS `discount_association` (
  `DISCOUNT_ASSOCIATION_ID` int(15) NOT NULL COMMENT 'PK—a unique, system-generated number to be used as the record ID.',
  `CUSTOMER_ID` varchar(20) NOT NULL COMMENT 'FK—foreign key to the DISCOUNT_SET table.',
  `DISCOUNT_ID` int(15) NOT NULL COMMENT 'FK—foreign key to the DISCOUNT_SET table.',
  `USE_COUNT` int(10) NOT NULL COMMENT 'The number of times the discount has been used.',
  `DISPLAY_DESCRIPTION` varchar(254) DEFAULT NULL COMMENT 'The discount description used for display purposes only.',
  PRIMARY KEY (`DISCOUNT_ASSOCIATION_ID`),
  KEY `FK_discount_association_discount_set` (`CUSTOMER_ID`),
  KEY `FK_discount_association_discount_set_2` (`DISCOUNT_ID`),
  CONSTRAINT `FK_discount_association_discount_set` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `ecom_customer` (`CUSTOMER_ID`),
  CONSTRAINT `FK_discount_association_discount_set_2` FOREIGN KEY (`DISCOUNT_ID`) REFERENCES `discount_set` (`DISCOUNT_SET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.discount_set
CREATE TABLE IF NOT EXISTS `discount_set` (
  `DISCOUNT_SET_ID` int(15) NOT NULL COMMENT 'PK—a unique, system-generated number to be used as the record ID.',
  `DISCOUNT_SET_NAME` varchar(50) DEFAULT NULL COMMENT 'The name of the discount set.',
  `XML_DEFINITION` tinyblob NOT NULL COMMENT 'This is XML.',
  PRIMARY KEY (`DISCOUNT_SET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to establish a group of discounts as a set.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_cart
CREATE TABLE IF NOT EXISTS `ecom_cart` (
  `ID` bigint(15) NOT NULL,
  `CUSTOMER_ID` varchar(20) DEFAULT NULL COMMENT 'A unique identifier for the customer.',
  `SKU` varchar(40) DEFAULT NULL COMMENT 'A unique identifier (the Stock Keeping Unit or SKU) for a product item.',
  PRIMARY KEY (`ID`),
  KEY `FK_ecom_cart_ecom_item` (`SKU`),
  KEY `FK_ecom_cart_ecom_customer` (`CUSTOMER_ID`),
  CONSTRAINT `FK_ecom_cart_ecom_item` FOREIGN KEY (`SKU`) REFERENCES `ecom_item` (`SKU`),
  CONSTRAINT `FK_ecom_cart_ecom_customer` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `ecom_customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store information about the customer''s saved shopping cart items in the order processing database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_category
CREATE TABLE IF NOT EXISTS `ecom_category` (
  `CATEGORY_ID` varchar(20) NOT NULL COMMENT 'A unique identifier for a category; the primary key for this table. This field cannot be NULL. All other fields in the WLCS_CATEGORY table can be NULL.',
  `PARENT_ID` varchar(20) DEFAULT NULL COMMENT 'The value of the CATEGORY_ID of the parent category in the hierarchy of categories that comprise your product catalog. If this is a top-level user-defined category, the PARENT_ID will be com.beasys.ROOT.',
  `NAME` varchar(50) DEFAULT NULL COMMENT 'The name of the category in the product catalog.',
  `SOURCE` varchar(30) DEFAULT NULL COMMENT 'A reference to a category from which the present category is derived.',
  `LANG` varchar(30) DEFAULT NULL COMMENT 'A language of the intellectual content of the category. The recommended best practice for the values of the language element is defined by RFC 1766, which includes a two-letter Language Code (taken from the ISO 639 standard), such as: en for English; fr for French, or de for German. The language code can, optionally, be followed by a two-letter Country Code (taken from the ISO 3166 standard [ISO3166]). For example, en-uk for English used in the United Kingdom.',
  `RELATION` varchar(30) DEFAULT NULL COMMENT 'A reference to a related category.',
  `CREATION_DATE` date DEFAULT NULL COMMENT 'A date associated with an event in the life cycle of the category. Recommended best practice for encoding the date value is defined in a profile of ISO 8601 and follows the YYYY-MM-DD format.',
  `MODIFIED_DATE` date DEFAULT NULL COMMENT 'A date associated with an event in the life cycle of the category, such as an update or insert by the DBLoader program that is provided with the Commerce services. The recommended best practice for encoding the date value is defined in a profile of ISO 8601 and follows the YYYY-MM-DD format.',
  `SMALL_IMG_TYPE` int(3) DEFAULT NULL COMMENT 'A type field of your own design that relates to the graphic. For example, you can implement your own numbering scheme, such as:',
  `SMALL_IMG_LANG` varchar(30) DEFAULT NULL,
  `SMALL_IMG_NAME` varchar(50) DEFAULT NULL,
  `SMALL_IMG_URL` varchar(254) DEFAULT NULL,
  `SMALL_IMG_ALT_TEXT` varchar(254) DEFAULT NULL,
  `LARGE_IMG_TYPE` int(3) DEFAULT NULL,
  `LARGE_IMG_LANG` varchar(30) DEFAULT NULL,
  `LARGE_IMG_NAME` varchar(50) DEFAULT NULL,
  `LARGE_IMG_URL` varchar(254) DEFAULT NULL,
  `LARGE_IMG_ALT_TEXT` varchar(254) DEFAULT NULL,
  `SHORT_DESC` varchar(50) DEFAULT NULL COMMENT 'A short description of the content of the category.',
  `LONG_DESC` varchar(254) DEFAULT NULL COMMENT 'A long description of the content of the category.',
  `DISPLAY_JSP_URL` varchar(254) DEFAULT NULL COMMENT 'The URL to the JSP used to display the category.',
  PRIMARY KEY (`CATEGORY_ID`),
  KEY `FK_ecom_category_ecom_category` (`PARENT_ID`),
  CONSTRAINT `FK_ecom_category_ecom_category` FOREIGN KEY (`PARENT_ID`) REFERENCES `ecom_category` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store categories in the Commerce database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_customer
CREATE TABLE IF NOT EXISTS `ecom_customer` (
  `CUSTOMER_ID` varchar(20) NOT NULL COMMENT 'A unique identifier for the customer. This field is the table''s primary key and cannot be NULL. All other fields in the WLCS_CUSTOMER table can be NULL.',
  `CUSTOMER_TYPE` varchar(20) DEFAULT NULL,
  `FIRST_NAME` varchar(30) DEFAULT NULL,
  `LAST_NAME` varchar(30) DEFAULT NULL,
  `MIDDLE_NAME` varchar(30) DEFAULT NULL,
  `TITLE` varchar(10) DEFAULT NULL,
  `SUFFIX` varchar(10) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `HOME_PHONE` varchar(15) DEFAULT NULL,
  `BUSINESS_PHONE` varchar(20) DEFAULT NULL,
  `FAX` varchar(15) DEFAULT NULL,
  `MAILING_GEOCODE` varchar(2) DEFAULT NULL,
  `MAILING_STREET1` varchar(30) DEFAULT NULL,
  `MAILING_STREET2` varchar(30) DEFAULT NULL,
  `MAILING_CITY` varchar(30) DEFAULT NULL,
  `MAILING_STATE` varchar(40) DEFAULT NULL,
  `MAILING_COUNTRY` varchar(40) DEFAULT NULL,
  `MAILING_POBOX` varchar(30) DEFAULT NULL,
  `MAILING_COUNTY` varchar(50) DEFAULT NULL,
  `MAILING_POSTAL_CODE` varchar(10) DEFAULT NULL,
  `MAILING_POSTAL_CODE_TYPE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store information about the customer in the order processing database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_customer_shipping_address
CREATE TABLE IF NOT EXISTS `ecom_customer_shipping_address` (
  `SHIPPING_ADDRESS_ID` bigint(15) NOT NULL,
  `MAP_KEY` varchar(60) DEFAULT NULL COMMENT 'Key that maps multiple shipping addresses with a single customer.',
  `SHIPPING_GEOCODE` varchar(2) DEFAULT NULL,
  `SHIPPING_STREET1` varchar(30) DEFAULT NULL,
  `SHIPPING_STREET2` varchar(30) DEFAULT NULL,
  `SHIPPING_CITY` varchar(30) DEFAULT NULL,
  `SHIPPING_STATE` varchar(40) DEFAULT NULL,
  `SHIPPING_COUNTRY` varchar(40) DEFAULT NULL,
  `SHIPPING_POBOX` varchar(30) DEFAULT NULL,
  `SHIPPING_COUNTY` varchar(50) DEFAULT NULL,
  `SHIPPING_POSTAL_CODE` varchar(10) DEFAULT NULL,
  `SHIPPING_POSTAL_CODE_TYPE` varchar(10) DEFAULT NULL,
  `CUSTOMER_ID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SHIPPING_ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store information related to a customer''s shipping address(es) in the order processing database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_item
CREATE TABLE IF NOT EXISTS `ecom_item` (
  `SKU` varchar(40) NOT NULL COMMENT 'A unique identifier ( SKU) for a product item. This field is the table''s primary key and cannot be NULL. All other fields in the WLCS_PRODUCT table can be NULL.',
  `PRODUCT_ID` varchar(40) NOT NULL COMMENT 'A unique identifier for a category.',
  `IN_STOCK` int(1) DEFAULT NULL COMMENT 'A flag to indicate whether the product item is in stock. 0 equates to false, 1 equates to true.',
  `VISIBLE` int(1) DEFAULT NULL COMMENT 'Indicates whether the item should be displayed to the user. Enter 1 if visible or 0 if not visible. If not specified in the database, the default is 1. See Controlling the Visibility of Items in the Product Catalog for important information about this field.',
  `TAX_CODE` varchar(10) DEFAULT NULL COMMENT 'The code used by the TAXWARE system to identify the specific tax category to which this item belongs.',
  `SHIPPING_CODE` varchar(10) DEFAULT NULL COMMENT 'The code used by the shipping company for this item.',
  `NAME` varchar(100) DEFAULT NULL COMMENT 'A name given to the product item.',
  `SOURCE` varchar(30) DEFAULT NULL COMMENT 'A reference to another product item from which the present item is derived.',
  `LANG` varchar(30) DEFAULT NULL COMMENT 'A language of the intellectual content of the category. The recommended best practice for the values of the language element is defined by RFC 1766, which includes a two-letter Language Code (taken from the ISO 639 standard), such as: en for English; fr for French, or de for German. The language code can, optionally, be followed by a two-letter Country Code (taken from the ISO 3166 standard [ISO3166]). For example, en-uk for English used in the United Kingdom.',
  `TYPE` varchar(30) DEFAULT NULL COMMENT 'The nature or genre of the content of the item.',
  `MSRP_CURRENCY` varchar(30) DEFAULT NULL COMMENT 'The currency type of the manufacturer''s recommended price.',
  `MSRP_AMOUNT` bigint(16) DEFAULT NULL COMMENT 'The manufacturer''s recommended price.',
  `PRICE_CURRENCY` varchar(30) DEFAULT NULL COMMENT 'The currency type of our catalog price for this item.',
  `PRICE_AMOUNT` bigint(16) DEFAULT NULL COMMENT 'Our current price for this item in the catalog.',
  `ESTIMATE_SHIP_TIME` varchar(100) DEFAULT NULL COMMENT 'Inventory: number of days/weeks before the item can be shipped.',
  `SPECIAL_NOTES` varchar(100) DEFAULT NULL COMMENT 'Inventory related message to display with the item.',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT 'An entity primarily responsible for making the content of the product item.',
  `CREATION_DATE` date DEFAULT NULL COMMENT 'A date associated with an event in the life cycle of the product item. Recommended best practice for encoding the date value is defined in a profile of ISO 8601 and follows the YYYY-MM-DD format.',
  `MODIFIED_DATE` date DEFAULT NULL COMMENT 'A date associated with an event in the life cycle of the item, such as an update or insert by the DBLoader program that is provided with the Commerce services. The recommended best practice for encoding the date value is defined in a profile of ISO 8601 and follows the YYYY-MM-DD format.',
  `SMALL_IMG_TYPE` int(3) DEFAULT NULL COMMENT 'A type field of your own design that relates to the graphic. For example, you can implement your own numbering scheme, such as:',
  `SMALL_IMG_LANG` varchar(30) DEFAULT NULL,
  `SMALL_IMG_NAME` varchar(50) DEFAULT NULL,
  `SMALL_IMG_URL` varchar(254) DEFAULT NULL,
  `SMALL_IMG_ALT_TEXT` varchar(254) DEFAULT NULL,
  `LARGE_IMG_TYPE` int(3) DEFAULT NULL,
  `LARGE_IMG_LANG` varchar(30) DEFAULT NULL,
  `LARGE_IMG_NAME` varchar(50) DEFAULT NULL,
  `LARGE_IMG_URL` varchar(254) DEFAULT NULL,
  `LARGE_IMG_ALT_TEXT` varchar(254) DEFAULT NULL,
  `SUM_DISPLAY_JSP_URL` varchar(254) DEFAULT NULL COMMENT 'The URL to the JSP used to display the item in summary form.',
  `DET_DISPLAY_JSP_URL` varchar(254) DEFAULT NULL COMMENT 'The URL to the JSP used to display the item in detailed form. ',
  `SHORT_DESC` varchar(254) DEFAULT NULL COMMENT 'A short description of the content of the product item.',
  `LONG_DESC` varchar(2000) DEFAULT NULL COMMENT 'A long description of the content of the product item.',
  PRIMARY KEY (`SKU`),
  KEY `FK_ecom_item_ecom_product` (`PRODUCT_ID`),
  CONSTRAINT `FK_ecom_item_ecom_product` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `ecom_product` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store item records in the Commerce database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_order
CREATE TABLE IF NOT EXISTS `ecom_order` (
  `ORDER_ID` varchar(20) NOT NULL COMMENT 'A unique identifier for the order. This field is the table''s primary key and cannot be NULL. All other fields in the WLCS_ORDER table can be NULL.',
  `CUSTOMER_ID` varchar(20) DEFAULT NULL COMMENT 'A unique identifier for the customer.',
  `TRANSACTION_ID` varchar(25) DEFAULT NULL COMMENT 'A unique identifier for the transaction.',
  `STATUS` varchar(20) DEFAULT NULL COMMENT 'The status of the order.',
  `ORDER_DATE` date DEFAULT NULL COMMENT 'The date the order was placed.',
  `SHIPPING_METHOD` varchar(40) DEFAULT NULL COMMENT 'The method by which the order is to be shipped.',
  `SHIPPING_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The shipping amount for the order.',
  `SHIPPING_CURRENCY` varchar(10) DEFAULT NULL COMMENT 'The currency associated with the shipping amount.',
  `PRICE_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The price of the order.',
  `PRICE_CURRENCY` varchar(10) DEFAULT NULL COMMENT 'The currency associated with the price',
  `SHIPPING_GEOGODE` varchar(2) DEFAULT NULL COMMENT 'The code used by the TAXWARE system to identify taxes for the order based on jurisdiction.',
  `SHIPPING_STREET1` varchar(30) DEFAULT NULL COMMENT 'The first line in the customer''s shipping address.',
  `SHIPPING_STREET2` varchar(30) DEFAULT NULL COMMENT 'The second line in the customer''s shipping address.',
  `SHIPPING_CITY` varchar(30) DEFAULT NULL COMMENT 'The city in the customer''s shipping address.',
  `SHIPPING_STATE` varchar(40) DEFAULT NULL COMMENT 'The state in the customer''s shipping address.',
  `SHIPPING_COUNTRY` varchar(40) DEFAULT NULL COMMENT 'The country in the customer''s shipping address.',
  `SHIPPING_POBOX` varchar(30) DEFAULT NULL COMMENT 'The post office box in the customer''s shipping address.',
  `SHIPPING_POSTAL_CODE` varchar(10) DEFAULT NULL COMMENT 'The postal (ZIP) code in the customer''s shipping address.',
  `SPECIAL_INSTRUCTIONS` varchar(254) DEFAULT NULL COMMENT 'Any special shipping instructions associated with the order.',
  `SPLITTING_PREFERENCE` varchar(254) DEFAULT NULL COMMENT 'The splitting preferences for the customer''s order',
  `ORDER_SUBTOTAL` double(16,4) DEFAULT NULL COMMENT 'The sum of all the TOTAL_LINE_AMOUNT columns in the WLCS_ORDER_LINE table for that specific order.',
  PRIMARY KEY (`ORDER_ID`),
  KEY `FK_ecom_order_ecom_customer` (`CUSTOMER_ID`),
  KEY `FK_ecom_order_ecom_transaction` (`TRANSACTION_ID`),
  CONSTRAINT `FK_ecom_order_ecom_customer` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `ecom_customer` (`CUSTOMER_ID`),
  CONSTRAINT `FK_ecom_order_ecom_transaction` FOREIGN KEY (`TRANSACTION_ID`) REFERENCES `ecom_transaction` (`TRANSACTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store information about a customer''s specific order in the order processing database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_order_adjustment
CREATE TABLE IF NOT EXISTS `ecom_order_adjustment` (
  `ORDER_ADJUSTMENT_ID` bigint(15) NOT NULL,
  `ORDER_ID` varchar(20) DEFAULT NULL,
  `ADJUSTMENT_TYPE` varchar(20) DEFAULT NULL,
  `COMPUTATION` varchar(254) DEFAULT NULL,
  `ADJUSTMENT_AMOUNT` double(16,4) DEFAULT NULL,
  `DISCOUNT_ID` bigint(15) DEFAULT NULL,
  `DISPLAY_DESCRIPTION` varchar(254) DEFAULT NULL,
  `CREATION_DATE` date DEFAULT NULL,
  `MODIFIED_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ORDER_ADJUSTMENT_ID`),
  KEY `FK__ecom_order` (`ORDER_ID`),
  CONSTRAINT `FK__ecom_order` FOREIGN KEY (`ORDER_ID`) REFERENCES `ecom_order` (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to maintain information about a discount taken at the order level (for example, $20.00 off any order between 1/1/02 and 1/31/02.)';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_order_line
CREATE TABLE IF NOT EXISTS `ecom_order_line` (
  `ORDER_LINE_ID` bigint(15) NOT NULL COMMENT 'A unique identifier for each line in a customer''s shopping cart. This field is the table''s primary key and cannot be NULL. All other fields in the WLCS_ORDERLINE table can be NULL.',
  `QUANTITY` double(16,4) DEFAULT NULL COMMENT 'The quantity of the item in the shopping cart.',
  `SKU` varchar(40) DEFAULT NULL COMMENT 'An identification number for the item in the shopping cart.',
  `TAX_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The tax amount for the order.',
  `TAX_CURRENCY` varchar(10) DEFAULT NULL COMMENT 'The currency associated with the tax amount.',
  `SHIPPING_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The shipping amount for the order.',
  `SHIPPING_CURRENCY` varchar(10) DEFAULT NULL COMMENT 'The currency associated with the shipping amount.',
  `UNIT_PRICE_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The unit price amount for the item.',
  `UNIT_PRICE_CURRENCY` varchar(10) DEFAULT NULL COMMENT 'The currency associated with the unit price.',
  `MSRP_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The MSRP amount for the item.',
  `MSRP_CURRENCY` varchar(10) DEFAULT NULL COMMENT 'The currency associated with the MSRP amount.',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT 'The name of the item that is part of the order.',
  `ORDER_ID` varchar(20) DEFAULT NULL COMMENT 'A unique identifier for the order.',
  PRIMARY KEY (`ORDER_LINE_ID`),
  KEY `FK_ecom_order_line_ecom_order` (`ORDER_ID`),
  CONSTRAINT `FK_ecom_order_line_ecom_order` FOREIGN KEY (`ORDER_ID`) REFERENCES `ecom_order` (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store information about each line of a customer''s shopping cart in the order processing database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_order_line_adjustment
CREATE TABLE IF NOT EXISTS `ecom_order_line_adjustment` (
  `ORDER_LINE_ADJUSTMENT_ID` bigint(15) NOT NULL COMMENT 'PK—a unique, system-generated number to be used as the record ID.',
  `ORDER_LINE_ID` bigint(15) NOT NULL COMMENT 'A unique identifier for each line in a customer''s shopping cart. This field is the table''s primary key and cannot be NULL. All other fields in the WLCS_ORDERLINE table can be NULL.',
  `ADJUSTMENT_TYPE` varchar(20) NOT NULL COMMENT 'The type of adjustment being made to the order line item (e.g., order line discount, shipping discount, etc.)',
  `ADJUSTMENT_AMOUNT` double(16,4) NOT NULL COMMENT 'The dollar amount of the adjustment.',
  `ADJUSTMENT_QUANTITY` double(16,4) NOT NULL COMMENT 'The quantity amount for the adjustment.',
  `ADJUSTED_UNIT_PRICE` double(16,4) NOT NULL COMMENT 'The adjusted unit price of the specific line item.',
  `COMPUTATION` varchar(254) NOT NULL COMMENT 'The computation for determining ADJUSTED_UNIT_PRICE.',
  `CREATION_DATE` date NOT NULL COMMENT 'The date and time the adjustment record was created.',
  `MODIFIED_DATE` date NOT NULL COMMENT 'The date and time the adjustment record was last modified.',
  `DISCOUNT_ID` bigint(15) NOT NULL COMMENT 'FK—a foreign key to the discount used from the DISCOUNT table.',
  `DISPLAY_DESCRIPTION` varchar(254) NOT NULL COMMENT 'The adjustment description used for display purposes.',
  PRIMARY KEY (`ORDER_LINE_ADJUSTMENT_ID`),
  UNIQUE KEY `ORDER_LINE_ID` (`ORDER_LINE_ID`),
  KEY `FK_ECOM_ORDER_LINE_ADJUSTMENT_discount` (`DISCOUNT_ID`),
  CONSTRAINT `FK_ECOM_ORDER_LINE_ADJUSTMENT_discount` FOREIGN KEY (`DISCOUNT_ID`) REFERENCES `discount` (`DISCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to maintain information about a discount taken at the order line item level (for example, 10% off SKU "Power Drill").';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_product
CREATE TABLE IF NOT EXISTS `ecom_product` (
  `PRODUCT_ID` varchar(40) NOT NULL COMMENT 'A unique identifier ( PRODUCT_ID) for a product item. This field is the table''s primary key and cannot be NULL.\r\n  All other fields in the WLCS_PRODUCT table can be NULL.',
  `CATEGORY_ID` varchar(20) NOT NULL COMMENT 'A unique identifier for a category.',
  `IN_STOCK` int(1) DEFAULT NULL COMMENT 'A flag to indicate whether the product item is in stock. 0 equates to false, 1 equates to true.',
  `VISIBLE` int(1) DEFAULT NULL COMMENT 'Indicates whether the item should be displayed to the user. Enter 1 if visible or 0 if not visible. If not specified in the database, the default is 1. See Controlling the Visibility of Items in the Product Catalog for important information about this field.',
  `TAX_CODE` varchar(10) DEFAULT NULL COMMENT 'The code used by the TAXWARE system to identify the specific tax category to which this item belongs.',
  `SHIPPING_CODE` varchar(10) DEFAULT NULL COMMENT 'The code used by the shipping company for this item.',
  `NAME` varchar(100) DEFAULT NULL COMMENT 'A name given to the product item.',
  `SOURCE` varchar(30) DEFAULT NULL COMMENT 'A reference to another product item from which the present item is derived.',
  `LANG` varchar(30) DEFAULT NULL COMMENT 'A language of the intellectual content of the category. The recommended best practice for the values of the language element is defined by RFC 1766, which includes a two-letter Language Code (taken from the ISO 639 standard), such as: en for English; fr for French, or de for German. The language code can, optionally, be followed by a two-letter Country Code (taken from the ISO 3166 standard [ISO3166]). For example, en-uk for English used in the United Kingdom.',
  `TYPE` varchar(30) DEFAULT NULL COMMENT 'The nature or genre of the content of the item.',
  `MSRP_CURRENCY` varchar(30) DEFAULT NULL COMMENT 'The currency type of the manufacturer''s recommended price.',
  `MSRP_AMOUNT` bigint(16) DEFAULT NULL COMMENT 'The manufacturer''s recommended price.',
  `PRICE_CURRENCY` varchar(30) DEFAULT NULL COMMENT 'The currency type of our catalog price for this item.',
  `PRICE_AMOUNT` bigint(16) DEFAULT NULL COMMENT 'Our current price for this item in the catalog.',
  `ESTIMATE_SHIP_TIME` varchar(100) DEFAULT NULL COMMENT 'Inventory: number of days/weeks before the item can be shipped.',
  `SPECIAL_NOTES` varchar(100) DEFAULT NULL COMMENT 'Inventory related message to display with the item.',
  `CREATOR` varchar(50) DEFAULT NULL COMMENT 'An entity primarily responsible for making the content of the product item.',
  `CREATION_DATE` date DEFAULT NULL COMMENT 'A date associated with an event in the life cycle of the product item. Recommended best practice for encoding the date value is defined in a profile of ISO 8601 and follows the YYYY-MM-DD format.',
  `MODIFIED_DATE` date DEFAULT NULL COMMENT 'A date associated with an event in the life cycle of the item, such as an update or insert by the DBLoader program that is provided with the Commerce services. The recommended best practice for encoding the date value is defined in a profile of ISO 8601 and follows the YYYY-MM-DD format.',
  `SMALL_IMG_TYPE` int(3) DEFAULT NULL COMMENT 'A type field of your own design that relates to the graphic. For example, you can implement your own numbering scheme, such as:',
  `SMALL_IMG_LANG` varchar(30) DEFAULT NULL,
  `SMALL_IMG_NAME` varchar(50) DEFAULT NULL,
  `SMALL_IMG_URL` varchar(254) DEFAULT NULL,
  `SMALL_IMG_ALT_TEXT` varchar(254) DEFAULT NULL,
  `LARGE_IMG_TYPE` int(3) DEFAULT NULL,
  `LARGE_IMG_LANG` varchar(30) DEFAULT NULL,
  `LARGE_IMG_NAME` varchar(50) DEFAULT NULL,
  `LARGE_IMG_URL` varchar(254) DEFAULT NULL,
  `LARGE_IMG_ALT_TEXT` varchar(254) DEFAULT NULL,
  `SUM_DISPLAY_JSP_URL` varchar(254) DEFAULT NULL COMMENT 'The URL to the JSP used to display the item in summary form.',
  `DET_DISPLAY_JSP_URL` varchar(254) DEFAULT NULL COMMENT 'The URL to the JSP used to display the item in detailed form. ',
  `SHORT_DESC` varchar(254) DEFAULT NULL COMMENT 'A short description of the content of the product item.',
  `LONG_DESC` varchar(2000) DEFAULT NULL COMMENT 'A long description of the content of the product item.',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `FK_ecom_product_ecom_category` (`CATEGORY_ID`),
  CONSTRAINT `FK_ecom_product_ecom_category` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `ecom_category` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store item records in the Commerce database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_product_keyword
CREATE TABLE IF NOT EXISTS `ecom_product_keyword` (
  `ID` varchar(30) NOT NULL,
  `KEYWORD` varchar(30) NOT NULL COMMENT 'Contains a keyword that you associate with the product item assigned to the unique PRODUCT_ID.',
  `PRODUCT_ID` varchar(40) NOT NULL COMMENT 'A unique identifier ( PRODUCT_ID) for an item.',
  PRIMARY KEY (`ID`),
  KEY `FK_ecom_product_keyword_ecom_product` (`PRODUCT_ID`),
  CONSTRAINT `FK_ecom_product_keyword_ecom_product` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `ecom_product` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table stores the keywords that you associate with each product item. The keywords enable rapid retrieval of item records via the search functions on the Web site''s pages or Administration pages.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_transaction
CREATE TABLE IF NOT EXISTS `ecom_transaction` (
  `TRANSACTION_ID` varchar(25) NOT NULL,
  `BATCH_ID` varchar(15) DEFAULT NULL COMMENT 'A unique identifier of a batch submitted for settlement, as returned by CyberCash. This field need not be populated for other external payment services.',
  `TRAN_DATE` date DEFAULT NULL,
  `TRAN_STATUS` varchar(20) DEFAULT NULL,
  `TRAN_AMOUNT` double(16,4) DEFAULT NULL COMMENT 'The most recent amount applied to the transaction. MarkForSettle amounts can be different from the authorization amount.',
  `TRAN_CURRENCY` varchar(30) DEFAULT NULL,
  `CC_NUMBER` varchar(200) DEFAULT NULL,
  `CC_TYPE` varchar(20) DEFAULT NULL,
  `CC_EXP_DATE` date DEFAULT NULL,
  `CC_NAME` varchar(50) DEFAULT NULL,
  `CC_DISPLAY_NUMBER` varchar(20) DEFAULT NULL,
  `CC_COMPANY` varchar(50) DEFAULT NULL,
  `GEOCODE` varchar(2) DEFAULT NULL,
  `STREET1` varchar(30) DEFAULT NULL,
  `STREET2` varchar(30) DEFAULT NULL,
  `CITY` varchar(30) DEFAULT NULL,
  `STATE` varchar(40) DEFAULT NULL,
  `COUNTRY` varchar(40) DEFAULT NULL,
  `POBOX` varchar(30) DEFAULT NULL,
  `DESCRIPTION` varchar(30) DEFAULT NULL,
  `POSTAL_CODE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table is used to store data for every payment transaction in the order processing database.';

-- Data exporting was unselected.


-- Dumping structure for table uruappdb.ecom_transaction_entry
CREATE TABLE IF NOT EXISTS `ecom_transaction_entry` (
  `TRANSACTION_ENTRY_ID` bigint(25) NOT NULL,
  `TRAN_ENTRY_SEQUENCE` varchar(30) DEFAULT NULL COMMENT 'Represents the running count per transaction.',
  `TRAN_ENTRY_DATE` date DEFAULT NULL,
  `TRAN_ENTRY_STATUS` varchar(20) DEFAULT NULL,
  `TRAN_ENTRY_AMOUNT` double(16,4) DEFAULT NULL,
  `TRAN_ENTRY_CURRENCY` varchar(30) DEFAULT NULL,
  `TRANSACTION_ID` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_ENTRY_ID`),
  KEY `FK_ecom_transaction_entry_ecom_transaction` (`TRANSACTION_ID`),
  CONSTRAINT `FK_ecom_transaction_entry_ecom_transaction` FOREIGN KEY (`TRANSACTION_ID`) REFERENCES `ecom_transaction` (`TRANSACTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT=' This table is used to store (log) the different states a payment transaction has passed through in the order processing database.';

CREATE TABLE `ecom_login` (
	`id` BIGINT(20) NOT NULL,
	`created_by` VARCHAR(255) NULL DEFAULT NULL,
	`created_date` DATETIME NULL DEFAULT NULL,
	`modified_by` VARCHAR(255) NULL DEFAULT NULL,
	`modified_date` DATETIME NULL DEFAULT NULL,
	`version` BIGINT(20) NULL DEFAULT NULL,
	`login_name` VARCHAR(255) NOT NULL,
	`password` VARCHAR(100) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UK_bgthcqk4l4tobdqw0okhp6ein` (`login_name`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
