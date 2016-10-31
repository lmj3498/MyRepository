CREATE TABLE freeboard
  (
    bno    NUMBER (10) NOT NULL ,
    btitle VARCHAR2 (100) NOT NULL ,
    bcontent CLOB NOT NULL ,
    bwriter   VARCHAR2 (15) NOT NULL ,
    bhitcount NUMBER (5) NOT NULL ,
    bdate     DATE NOT NULL
  ) ;
ALTER TABLE freeboard ADD CONSTRAINT freeboard_PK PRIMARY KEY ( bno ) ;
CREATE TABLE member
  (
    mid       VARCHAR2 (15) NOT NULL ,
    mname     VARCHAR2 (20) NOT NULL ,
    mpassword VARCHAR2 (15) NOT NULL ,
    maddress  VARCHAR2 (100) ,
    mtel      VARCHAR2 (15) NOT NULL ,
    memail    VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE member ADD CONSTRAINT member_PK PRIMARY KEY ( mid ) ;
CREATE TABLE photoboard
  (
    bno    NUMBER (10) NOT NULL ,
    btitle VARCHAR2 (100) NOT NULL ,
    bcontent CLOB NOT NULL ,
    bwriter      VARCHAR2 (15) NOT NULL ,
    bhitcount    NUMBER (5) NOT NULL ,
    bdate        DATE NOT NULL ,
    originalfile VARCHAR2 (50) NOT NULL ,
    savedfile    VARCHAR2 (50) NOT NULL ,
    mimetype     VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE photoboard ADD CONSTRAINT photoboard_PK PRIMARY KEY ( bno ) ;
ALTER TABLE freeboard ADD CONSTRAINT freeboard_member_FK FOREIGN KEY ( bwriter ) REFERENCES member ( mid ) ;
ALTER TABLE photoboard ADD CONSTRAINT photoboard_member_FK FOREIGN KEY ( bwriter ) REFERENCES member ( mid ) ;
