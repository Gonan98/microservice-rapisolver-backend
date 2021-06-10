INSERT INTO categories (created_at,name,status) VALUES (CURRENT_TIMESTAMP,'Mantenimiento','CREATED');
INSERT INTO categories (created_at,name,status) VALUES (CURRENT_TIMESTAMP,'Decoracion','CREATED');
INSERT INTO categories (created_at,name,status) VALUES (CURRENT_TIMESTAMP,'Limpieza','CREATED');

INSERT INTO attentions (created_at,name,status,category_id) VALUES (CURRENT_TIMESTAMP,'Reparacion de luces','CREATED',1);