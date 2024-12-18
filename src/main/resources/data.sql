
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


CREATE TABLE IF NOT EXISTS tb_endereco (
    endereco_id SERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    complemento VARCHAR(255)
);

INSERT INTO tb_endereco (endereco_id, rua, bairro, cidade, estado, cep, complemento) VALUES (1, 'Edimo Belmiro Pastro', 'Bela Vista', 'Pato Branco', 'Parana', '85509280', 'Casa')
ON CONFLICT (endereco_id) DO NOTHING; 

CREATE TABLE IF NOT EXISTS tb_pessoa (
    pessoa_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    genero VARCHAR(255),
    nascimento DATE NOT NULL, 
    rg VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    estado_civil_id BIGINT, 
    nome_pai VARCHAR(255), 
    nome_mae VARCHAR(255), 
    telefone VARCHAR (50), 
    celular VARCHAR (50), 
    email VARCHAR(255) UNIQUE,
    endereco_id BIGINT, 
    FOREIGN KEY (estado_civil_id) REFERENCES tb_estado_civil (estado_civil_id) ON DELETE CASCADE,
    FOREIGN KEY (endereco_id) REFERENCES tb_endereco (endereco_id) ON DELETE CASCADE 
    
);

INSERT INTO tb_pessoa (pessoa_id, nome, sobrenome, genero, nascimento, rg, cpf, estado_civil_id, nome_pai, nome_mae, telefone, celular, email, endereco_id ) VALUES (1, 'Fernando Augusto', 'Gnoatto', 'Masculino', '2001-08-17', '126932596', '10003345971', 2, 'Darci Conte Gnoatto', 'Rozeli Terezinha Rizelo Gnoatto', '-', '46991331722', 'contatognoatto01@gmail.com', 1)
ON CONFLICT (pessoa_id) DO NOTHING; 











