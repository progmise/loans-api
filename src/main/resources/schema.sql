CREATE TABLE IF NOT EXISTS public."USER" (
	"ID" serial NOT NULL,
	"EMAIL" character varying(80) NOT NULL,
	"FIRST_NAME" character varying(25) NOT NULL, 
	"LAST_NAME" character varying(45) NOT NULL, 
	CONSTRAINT "USER_PK" PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."LOAN" (
	"ID" serial NOT NULL, 
	"TOTAL" numeric NOT NULL, 
	"USER_ID" integer NOT NULL, 
	CONSTRAINT "LOAN_PK" PRIMARY KEY ("ID"), 
	CONSTRAINT "LOAN_FK" FOREIGN KEY ("USER_ID")
		REFERENCES public."USER" ("ID")	
);