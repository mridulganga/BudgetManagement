# BudgetManagement
This is a java app to manage budget

# Mysql Setup
```
create datbase budget;
use budget;

DROP TABLE IF EXISTS dues;
CREATE TABLE dues (
  id int(20) NOT NULL,
  payee varchar(20) DEFAULT NULL,
  tpay varchar(20) DEFAULT NULL,
  amount int(5) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS members;
CREATE TABLE members (
  mid int(10) NOT NULL,
  name varchar(100) DEFAULT NULL,
  roomno int(4) DEFAULT NULL,
  mob char(11) DEFAULT NULL,
  note varchar(500) DEFAULT NULL,
  password varchar(20) DEFAULT NULL,
  PRIMARY KEY (mid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS transaction;
CREATE TABLE transaction (
  id int(10) NOT NULL,
  name varchar(100) DEFAULT NULL,
  ttype int(2) DEFAULT NULL,
  remark varchar(500) DEFAULT NULL,
  date varchar(10) DEFAULT NULL,
  amount int(5) DEFAULT NULL,
  shared varchar(300) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO members (mid, name, roomno, mob, note, password) VALUES
(1,	'admin',	203,	'9916385511',	'xyz',	'admin123'),
(2,	'anurag',	123,	'9739206599',	'ddfv',	'anurag01@');

```
