
CREATE TABLE IF NOT EXISTS tb_access_level(
   access_level_id INT PRIMARY KEY, 
   access_level_name VARCHAR(25) NOT NULL 
);

INSERT INTO  tb_access_level (access_level_id, access_level_name) VALUES (1, 'ADMINISTRADOR')
ON CONFLICT (access_level_id) DO NOTHING; 
INSERT INTO  tb_access_level (access_level_id, access_level_name) VALUES (2, 'MODERADOR')
ON CONFLICT (access_level_id) DO NOTHING; 
INSERT INTO  tb_access_level (access_level_id, access_level_name) VALUES (3, 'COMANDANTE')
ON CONFLICT (access_level_id) DO NOTHING; 
INSERT INTO  tb_access_level (access_level_id, access_level_name) VALUES (4, 'SECRETARIA')
ON CONFLICT (access_level_id) DO NOTHING; 
INSERT INTO  tb_access_level (access_level_id, access_level_name) VALUES (5, 'USUARIO')
ON CONFLICT (access_level_id) DO NOTHING; 


CREATE TABLE IF NOT EXISTS tb_marital_status (
    marital_status_id SERIAL PRIMARY KEY,
    marital_status VARCHAR(255) NOT NULL
);

INSERT INTO tb_marital_status (marital_status_id, marital_status) VALUES (1, 'SOLTEIRO(A)')
ON CONFLICT (marital_status_id) DO NOTHING; 
INSERT INTO tb_marital_status (marital_status_id, marital_status) VALUES (2, 'CASADO(A)')
ON CONFLICT (marital_status_id) DO NOTHING; 
INSERT INTO tb_marital_status (marital_status_id, marital_status) VALUES (3, 'SEPARADO(A)')
ON CONFLICT (marital_status_id) DO NOTHING; 
INSERT INTO tb_marital_status (marital_status_id, marital_status) VALUES (4, 'DIVORCIADO(A)')
ON CONFLICT (marital_status_id) DO NOTHING; 
INSERT INTO tb_marital_status (marital_status_id, marital_status) VALUES (5, 'VIUVO(A)')
ON CONFLICT (marital_status_id) DO NOTHING; 
INSERT INTO tb_marital_status (marital_status_id, marital_status) VALUES (6, 'UNIAO ESTAVEL')
ON CONFLICT (marital_status_id) DO NOTHING; 















