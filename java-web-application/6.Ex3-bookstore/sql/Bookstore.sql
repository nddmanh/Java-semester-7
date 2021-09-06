CREATE DATABASE Bookstore1;
USE Bookstore1;

CREATE TABLE book (
  `bookid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` float NOT NULL
);

CREATE TABLE bookItem (
  `bookitemid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `quantity` int(100) NOT NULL,
  `price` float NOT NULL,
  `publisher` varchar(128) NOT NULL,
  `discount` varchar(128),
  FOREIGN KEY (`bookid`) REFERENCES book(`bookid`)
);

CREATE TABLE customer (
  `customerid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(128) NOT NULL
);

CREATE TABLE account (
  `accountid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(45) NOT NULL,
  FOREIGN KEY (`customerid`) REFERENCES customer(`customerid`)
);

CREATE TABLE address (
  `addressid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `num` int(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  FOREIGN KEY (`customerid`) REFERENCES customer(`customerid`)
);

CREATE TABLE shipment (
  `shipmentid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `price` float NOT NULL,
  `shipmentunit` varchar(45) NOT NULL
);

CREATE TABLE bookorder (
  `bookorderid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `shipmentid` int(11) NOT NULL,
  `cartid` int(11) NOT NULL,
  `item` varchar(255) NOT NULL,
  `totalprice` float NOT NULL,
  FOREIGN KEY (`customerid`) REFERENCES customer(`customerid`),
  FOREIGN KEY (`shipmentid`) REFERENCES shipment(`shipmentid`)
);

CREATE TABLE payment (
  `paymentid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `bookorderid` int(11) NOT NULL,
  `totalprice` float NOT NULL,
  FOREIGN KEY (`bookorderid`) REFERENCES bookorder(`bookorderid`)
);

CREATE TABLE cart (
  `cartid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `bookitemid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `paymentid` int(11) NOT NULL,
  `totalprice` float NOT NULL,
  FOREIGN KEY (`customerid`) REFERENCES customer(`customerid`),
  FOREIGN KEY (`bookitemid`) REFERENCES bookitem(`bookitemid`),
  FOREIGN KEY (`paymentid`) REFERENCES payment(`paymentid`)
);

ALTER TABLE bookorder ADD FOREIGN KEY(`cartid`) REFERENCES cart(`cartid`);

CREATE TABLE users (
  `userid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `num` int(100) NOT NULL,
  `city` varchar(255) NOT NULL
);
