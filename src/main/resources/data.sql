
CREATE TABLE IF NOT EXISTS tb_nivel_acesso(
    nivel_acesso_id INT PRIMARY KEY, 
    nome_nivel_acesso VARCHAR(25) NOT NULL 
);

INSERT INTO  tb_nivel_acesso (nivel_acesso_id, nome_nivel_acesso) VALUES (1, 'ADMINISTRADOR')
ON CONFLICT (nivel_acesso_id) DO NOTHING; 
INSERT INTO  tb_nivel_acesso (nivel_acesso_id, nome_nivel_acesso) VALUES (2, 'MODERADOR')
ON CONFLICT (nivel_acesso_id) DO NOTHING; 
INSERT INTO  tb_nivel_acesso (nivel_acesso_id, nome_nivel_acesso) VALUES (3, 'COMANDANTE')
ON CONFLICT (nivel_acesso_id) DO NOTHING; 
INSERT INTO  tb_nivel_acesso (nivel_acesso_id, nome_nivel_acesso) VALUES (4, 'SECRETARIA')
ON CONFLICT (nivel_acesso_id) DO NOTHING; 
INSERT INTO  tb_nivel_acesso (nivel_acesso_id, nome_nivel_acesso) VALUES (5, 'USUARIO')
ON CONFLICT (nivel_acesso_id) DO NOTHING; 

CREATE TABLE IF NOT EXISTS tb_estado_civil (
    estado_civil_id SERIAL PRIMARY KEY,
    estado_civil VARCHAR(255) NOT NULL
);

INSERT INTO tb_estado_civil (estado_civil_id, estado_civil) VALUES (1, 'SOLTEIRO(A)')
ON CONFLICT (estado_civil_id) DO NOTHING; 
INSERT INTO tb_estado_civil (estado_civil_id, estado_civil) VALUES (2, 'CASADO(A)')
ON CONFLICT (estado_civil_id) DO NOTHING; 
INSERT INTO tb_estado_civil (estado_civil_id, estado_civil) VALUES (3, 'DIVORCIADO(A)')
ON CONFLICT (estado_civil_id) DO NOTHING; 
INSERT INTO tb_estado_civil (estado_civil_id, estado_civil) VALUES (4, 'VIUVO(A)')
ON CONFLICT (estado_civil_id) DO NOTHING; 










