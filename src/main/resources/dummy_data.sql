/*
DROP TABLE IF EXISTS public."USER" CASCADE;

CREATE TABLE public."USER" (
	"ID" serial NOT NULL,
	"EMAIL" character varying(80) NOT NULL,
	"FIRST_NAME" character varying(25) NOT NULL, 
	"LAST_NAME" character varying(45) NOT NULL, 
	CONSTRAINT "USER_PK" PRIMARY KEY ("ID")
);

DROP TABLE IF EXISTS public."LOAN";

CREATE TABLE public."LOAN" (
	"ID" serial NOT NULL, 
	"TOTAL" numeric NOT NULL, 
	"USER_ID" integer NOT NULL, 
	CONSTRAINT "LOAN_PK" PRIMARY KEY ("ID"), 
	CONSTRAINT "LOAN_FK" FOREIGN KEY ("USER_ID")
		REFERENCES public."USER" ("ID")	
); 
*/

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user1@example.com','Araceli','Diéguez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(76606.92,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user2@example.com','José Manuel','Monreal') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(41602.65,(SELECT user_id FROM rows)),
	(3061.49,(SELECT user_id FROM rows)),
	(147833.29,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user3@example.com','Lope','Casares') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(1928.57,(SELECT user_id FROM rows)),
	(46584.95,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user4@example.com','Rosenda','Mosquera') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(121472.67,(SELECT user_id FROM rows)),
	(54643.34,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user5@example.com','Ovidio','Salgado') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(58997.09,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user6@example.com','Concepción','Guardia');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user7@example.com','Graciano','Olmedo') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(111720.86,(SELECT user_id FROM rows)),
	(57677.41,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user8@example.com','Ismael','Vilar') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(149935.36,(SELECT user_id FROM rows)),
	(121424.09,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user9@example.com','Luís','Andres');

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user10@example.com','Inocencio','Bautista');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user11@example.com','Carmen','Garcés') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(142192.18,(SELECT user_id FROM rows)),
	(82784.54,(SELECT user_id FROM rows)),
	(26048.43,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user12@example.com','Dulce','Tur') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(55273.73,(SELECT user_id FROM rows)),
	(23239.12,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user13@example.com','Cayetana','Santos') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(6414.61,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user14@example.com','Trini','Estevez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(68481.57,(SELECT user_id FROM rows)),
	(27897.92,(SELECT user_id FROM rows)),
	(26833.51,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user15@example.com','Carmelita','Bolaños') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(8730.23,(SELECT user_id FROM rows)),
	(44323.81,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user16@example.com','Nadia','Carretero') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(2696.45,(SELECT user_id FROM rows)),
	(64886.9,(SELECT user_id FROM rows)),
	(29170.56,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user17@example.com','Almudena','Escalona');

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user18@example.com','Eligia','Elorza');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user19@example.com','Marciano','Blazquez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(7211.14,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user20@example.com','Magdalena','Maestre') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(57185.0,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user21@example.com','Apolonia','Planas') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(140786.24,(SELECT user_id FROM rows)),
	(64905.01,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user22@example.com','Brunilda','Falcón') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(19902.03,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user23@example.com','Jonatan','Clavero');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user24@example.com','Eleuterio','Ramos') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(121289.33,(SELECT user_id FROM rows)),
	(147745.68,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user25@example.com','Casemiro','Goicoechea') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(148208.7,(SELECT user_id FROM rows)),
	(66690.39,(SELECT user_id FROM rows)),
	(31327.4,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user26@example.com','Ana Belén','Azcona') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(131345.51,(SELECT user_id FROM rows)),
	(16134.03,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user27@example.com','Candelaria','Calderon') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(53090.5,(SELECT user_id FROM rows)),
	(59177.51,(SELECT user_id FROM rows)),
	(98455.79,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user28@example.com','Gertrudis','Martinez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(149521.46,(SELECT user_id FROM rows)),
	(49394.64,(SELECT user_id FROM rows)),
	(145292.39,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user29@example.com','Godofredo','Mesa');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user30@example.com','Faustino','Espada') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(108745.99,(SELECT user_id FROM rows)),
	(102405.97,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user31@example.com','Aníbal','Fernandez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(61027.69,(SELECT user_id FROM rows)),
	(16038.38,(SELECT user_id FROM rows)),
	(83575.51,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user32@example.com','Luis Miguel','Larrea') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(92724.38,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user33@example.com','Pablo','Arranz') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(12251.13,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user34@example.com','Hipólito','Alegria') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(44185.45,(SELECT user_id FROM rows)),
	(111597.27,(SELECT user_id FROM rows)),
	(24951.73,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user35@example.com','Eva','Melero') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(76519.44,(SELECT user_id FROM rows)),
	(144693.53,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user36@example.com','Cruz','Serna') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(73528.43,(SELECT user_id FROM rows)),
	(129150.62,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user37@example.com','Pío','Carbonell') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(40653.88,(SELECT user_id FROM rows)),
	(109212.13,(SELECT user_id FROM rows)),
	(132644.21,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user38@example.com','Hernán','Rocamora');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user39@example.com','Lucho','Torrents') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(12120.93,(SELECT user_id FROM rows)),
	(6070.56,(SELECT user_id FROM rows)),
	(113207.92,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user40@example.com','Soraya','Parra');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user41@example.com','Susanita','Muñoz') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(90765.38,(SELECT user_id FROM rows)),
	(86271.08,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user42@example.com','Fortunata','Francisco');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user43@example.com','Jenny','Barba') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(134988.83,(SELECT user_id FROM rows)),
	(24020.79,(SELECT user_id FROM rows)),
	(77220.39,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user44@example.com','Constanza','Romeu');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user45@example.com','María Manuela','Landa') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(100098.07,(SELECT user_id FROM rows)),
	(63386.64,(SELECT user_id FROM rows)),
	(88443.24,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user46@example.com','Leocadia','Uría');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user47@example.com','Joaquina','Alfaro') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(85585.15,(SELECT user_id FROM rows)),
	(140691.81,(SELECT user_id FROM rows)),
	(124496.85,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user48@example.com','Bruno','Cases') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(106745.99,(SELECT user_id FROM rows)),
	(2509.44,(SELECT user_id FROM rows)),
	(67797.56,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user49@example.com','Cornelio','Roda') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(62100.92,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user50@example.com','Apolonia','Marqués');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user51@example.com','Aránzazu','Calvo') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(19729.93,(SELECT user_id FROM rows)),
	(47059.19,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user52@example.com','Andrés','Llano') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(86889.99,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user53@example.com','Arsenio','Merino') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(129251.42,(SELECT user_id FROM rows)),
	(87229.62,(SELECT user_id FROM rows)),
	(6496.39,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user54@example.com','Carolina','Benito');

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user55@example.com','Cristóbal','Vega');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user56@example.com','Norberto','Morales') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(25847.08,(SELECT user_id FROM rows)),
	(146444.74,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user57@example.com','Osvaldo','Luís') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(143486.8,(SELECT user_id FROM rows)),
	(72540.91,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user58@example.com','Azucena','Tomás') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(5378.69,(SELECT user_id FROM rows)),
	(107692.92,(SELECT user_id FROM rows)),
	(111852.46,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user59@example.com','Jose Antonio','Lamas') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(79652.72,(SELECT user_id FROM rows)),
	(10110.67,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user60@example.com','Alma','Seco');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user61@example.com','Juanito','Sales') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(69281.3,(SELECT user_id FROM rows)),
	(60562.99,(SELECT user_id FROM rows)),
	(103161.97,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user62@example.com','Isaura','Carmona') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(93331.84,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user63@example.com','Pía','Cantón') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(97268.02,(SELECT user_id FROM rows)),
	(124170.82,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user64@example.com','Jesusa','Bermudez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(101131.46,(SELECT user_id FROM rows)),
	(14658.88,(SELECT user_id FROM rows)),
	(112968.88,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user65@example.com','Lilia','Arco');

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user66@example.com','Alejandro','Adán');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user67@example.com','Jesusa','Ordóñez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(3601.23,(SELECT user_id FROM rows)),
	(34378.6,(SELECT user_id FROM rows)),
	(68229.19,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user68@example.com','Fernando','Castro') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(82140.42,(SELECT user_id FROM rows)),
	(61657.87,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user69@example.com','Aarón','Téllez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(95815.53,(SELECT user_id FROM rows)),
	(68466.43,(SELECT user_id FROM rows)),
	(31351.39,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user70@example.com','Tecla','Coca') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(19086.32,(SELECT user_id FROM rows)),
	(37175.54,(SELECT user_id FROM rows)),
	(95338.32,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user71@example.com','Lara','Vigil');

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user72@example.com','Virginia','Enríquez');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user73@example.com','Juana','Páez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(9741.32,(SELECT user_id FROM rows)),
	(93852.48,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user74@example.com','Ángela','Jáuregui') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(13278.99,(SELECT user_id FROM rows)),
	(28806.44,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user75@example.com','Trinidad','Garay') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(23688.87,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user76@example.com','Amelia','Pou');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user77@example.com','Néstor','Trillo') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(90375.68,(SELECT user_id FROM rows)),
	(62363.47,(SELECT user_id FROM rows)),
	(78677.08,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user78@example.com','Rodolfo','Soriano') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(57847.76,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user79@example.com','Roxana','Carrasco');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user80@example.com','Marcos','Pedraza') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(15196.9,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user81@example.com','Octavia','Diaz');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user82@example.com','Dalila','Páez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(101072.58,(SELECT user_id FROM rows)),
	(93103.46,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user83@example.com','Graciela','Franco') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(66171.11,(SELECT user_id FROM rows)),
	(91593.14,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user84@example.com','Germán','Atienza') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(27762.63,(SELECT user_id FROM rows)),
	(5653.87,(SELECT user_id FROM rows)),
	(14649.01,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user85@example.com','Serafina','Rodriguez') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(107205.03,(SELECT user_id FROM rows)),
	(131474.8,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user86@example.com','Dafne','Jordán') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(48574.14,(SELECT user_id FROM rows)),
	(35012.22,(SELECT user_id FROM rows)),
	(19306.76,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user87@example.com','Purificación','Pujadas') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(15715.71,(SELECT user_id FROM rows)),
	(76530.35,(SELECT user_id FROM rows)),
	(130229.83,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user88@example.com','Lara','Lobato');

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user89@example.com','Quirino','Garay');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user90@example.com','Inmaculada','Bayona') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(26384.39,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user91@example.com','Plácido','Marco') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(134498.59,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user92@example.com','Cristian','Toro') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(85269.27,(SELECT user_id FROM rows)),
	(17715.59,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user93@example.com','Luciana','Aguado');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user94@example.com','Alejo','Álvaro') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(109408.06,(SELECT user_id FROM rows)),
	(10432.3,(SELECT user_id FROM rows)),
	(24247.99,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user95@example.com','Ligia','Alegria') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(85926.74,(SELECT user_id FROM rows)),
	(47592.19,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user96@example.com','José Luis','Bayona') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(64183.2,(SELECT user_id FROM rows)),
	(71476.37,(SELECT user_id FROM rows)),
	(119045.85,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user97@example.com','Moisés','Bellido');

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user98@example.com','Noé','Casal') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(33718.38,(SELECT user_id FROM rows))
;

WITH rows AS (
	INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user99@example.com','Máxima','Balaguer') RETURNING "ID" as user_id
	)
INSERT INTO "LOAN" ("TOTAL","USER_ID") VALUES
	(78681.72,(SELECT user_id FROM rows)),
	(27230.49,(SELECT user_id FROM rows))
;

INSERT INTO "USER" ("EMAIL","FIRST_NAME","LAST_NAME") VALUES ('user100@example.com','Primitiva','Menéndez');

