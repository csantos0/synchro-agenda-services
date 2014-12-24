--------------------------------------------------------
--  DDL for Table TB_ADDRESS
--------------------------------------------------------

  CREATE TABLE "CVSASSETS"."TB_ADDRESS" 
   (	"ID" NUMBER, 
	"CITY" VARCHAR2(255 BYTE), 
	"DISTRICT" VARCHAR2(255 BYTE), 
	"NUMBER_ID" NUMBER, 
	"STREET" VARCHAR2(255 BYTE), 
	"ZIPCODE" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TB_CONTACT
--------------------------------------------------------

  CREATE TABLE "CVSASSETS"."TB_CONTACT" 
   (	"ID" NUMBER, 
	"EMAIL" VARCHAR2(255 BYTE) DEFAULT NULL, 
	"NAME" VARCHAR2(255 BYTE) DEFAULT NULL, 
	"PHONE" VARCHAR2(255 BYTE) DEFAULT NULL, 
	"SURNAME" VARCHAR2(255 BYTE) DEFAULT NULL, 
	"ADDRESSID" NUMBER DEFAULT NULL, 
	"USERID" NUMBER DEFAULT NULL
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TB_USER
--------------------------------------------------------

  CREATE TABLE "CVSASSETS"."TB_USER" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(255 BYTE), 
	"PASSWORD" VARCHAR2(255 BYTE), 
	"SURNAME" VARCHAR2(255 BYTE), 
	"USERNAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ADDRESS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CVSASSETS"."ADDRESS_PK" ON "CVSASSETS"."TB_ADDRESS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CONTACT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CVSASSETS"."CONTACT_PK" ON "CVSASSETS"."TB_CONTACT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CVSASSETS"."USER_PK" ON "CVSASSETS"."TB_USER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table TB_ADDRESS
--------------------------------------------------------

  ALTER TABLE "CVSASSETS"."TB_ADDRESS" ADD CONSTRAINT "ADDRESS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TB_CONTACT
--------------------------------------------------------

  ALTER TABLE "CVSASSETS"."TB_CONTACT" ADD CONSTRAINT "CONTACT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TB_USER
--------------------------------------------------------

  ALTER TABLE "CVSASSETS"."TB_USER" ADD CONSTRAINT "USER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TB_CONTACT
--------------------------------------------------------

  ALTER TABLE "CVSASSETS"."TB_CONTACT" ADD CONSTRAINT "FK_ADDRESS" FOREIGN KEY ("ADDRESSID")
	  REFERENCES "CVSASSETS"."TB_ADDRESS" ("ID") ENABLE;
  ALTER TABLE "CVSASSETS"."TB_CONTACT" ADD CONSTRAINT "FK_USER" FOREIGN KEY ("USERID")
	  REFERENCES "CVSASSETS"."TB_USER" ("ID") ENABLE;