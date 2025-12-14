<img width="829" height="454" alt="image" src="https://github.com/user-attachments/assets/8ae676fa-c8db-45f6-b53c-800c4ce60efe" /># Simulador Bancario en Java Swing

## Funcionalidades
- Inicio de sesión con validación en base de datos.
<img width="373" height="111" alt="image" src="https://github.com/user-attachments/assets/5cedc40f-797c-46d9-a4ab-7e0558fa2fe0" />
<img width="283" height="188" alt="image" src="https://github.com/user-attachments/assets/1f235ab7-12d9-4fe8-beb3-e5b138cac15a" />
<img width="285" height="189" alt="image" src="https://github.com/user-attachments/assets/3a17e40b-3d81-4cca-abe2-57a89f711550" />
<img width="385" height="290" alt="image" src="https://github.com/user-attachments/assets/158bea9a-49ab-4ab9-ade1-5a816dc59a49" />


- Operaciones: depósito, retiro y transferencia.
- Historial de transacciones.
<img width="383" height="291" alt="image" src="https://github.com/user-attachments/assets/b7581a43-63ca-44f6-86a2-c5769b0ff8c4" />

- Saldo actualizado en pantalla.
<img width="383" height="291" alt="image" src="https://github.com/user-attachments/assets/d5f9dda4-d9aa-42ae-a0df-9f19392b6152" />

## Organización
- `config/DBConnection.java`: conexión centralizada a la BD.
- `forms/LoginForm.java`: formulario de login.
- `forms/BancoForm.java`: operaciones bancarias.
- `model/Cliente.java`: clase modelo para cliente.
<img width="423" height="221" alt="image" src="https://github.com/user-attachments/assets/31acea6e-7da3-46bc-ac95-09a198eb6d37" />

## Ejecución
1. Configurar base de datos MySQL.
2. Ejecutar `Main.java`.
   <img width="829" height="454" alt="image" src="https://github.com/user-attachments/assets/2d905dba-21d5-4e4c-a3ee-1e6bbc603056" />
3. Ingresar credenciales válidas.
   

### 3. Extras de Diseño
- Uso de `GroupLayout` o `GridBagLayout` para una interfaz clara.
- Estilo profesional: fuentes legibles, espacios adecuados y centrado visual.


---

## Base de Datos

### Script SQL (MySQL)
```sql
CREATE DATABASE banco;
USE banco;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    saldo DECIMAL(10,2) DEFAULT 1000.00,
    activo BOOLEAN DEFAULT TRUE
);

INSERT INTO clientes (usuario, password, nombre, saldo, activo)
VALUES 
('jdoe', '1234', 'John Doe', 1000.00, TRUE),
('maria', 'abcd', 'Maria Lopez', 1500.00, TRUE),
('carlos', 'pass', 'Carlos Perez', 500.00, FALSE);

