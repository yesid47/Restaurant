INSERT INTO persona (id, nombre,cedula, celular, email, direccion)
VALUES (10, 'Adrian Ramirez','1045044025', 3106078278,'adrian@gmail.com','cll 50 51-62');
INSERT INTO persona (id, nombre,cedula, celular, email, direccion)
VALUES (20, 'Aurelio el lobo','1045044024', 3106078279,'adrian47@gmail.com','cll 50 51-63');


INSERT INTO mesa(id,capacidad,numero_mesa, precio)
VALUES (10,5,10,20000);
INSERT INTO mesa(id,capacidad,numero_mesa, precio)
VALUES (20,10,20,40000);


INSERT INTO reserva(id,fecha,hora_inicial,hora_final,valor_pagar,estado,id_persona,id_mesa)
VALUES (10,'2020-12-31','10:40:00','12:40:00',50000,true,10,10);

INSERT INTO reserva(id,fecha,hora_inicial,hora_final,valor_pagar,estado,id_persona,id_mesa)
VALUES (20,'2020-12-31','18:01:00','20:01:00',60000,true,10,10);