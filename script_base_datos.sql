USE SistemaVentas;
GO

IF OBJECT_ID('dbo.DetalleVenta', 'U') IS NOT NULL DROP TABLE dbo.DetalleVenta;
IF OBJECT_ID('dbo.Venta', 'U') IS NOT NULL DROP TABLE dbo.Venta;
IF OBJECT_ID('dbo.Producto', 'U') IS NOT NULL DROP TABLE dbo.Producto;
IF OBJECT_ID('dbo.Cliente', 'U') IS NOT NULL DROP TABLE dbo.Cliente;
IF OBJECT_ID('dbo.Empleado', 'U') IS NOT NULL DROP TABLE dbo.Empleado;
GO

CREATE TABLE dbo.Cliente (
    idCliente   INT IDENTITY(1,1) PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    correo      VARCHAR(100) NOT NULL,
    direccion   VARCHAR(150) NULL
);

CREATE TABLE dbo.Empleado (
    idEmpleado  INT IDENTITY(1,1) PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    correo      VARCHAR(100) NOT NULL,
    cargo       VARCHAR(80)  NULL
);

CREATE TABLE dbo.Producto (
    idProducto  INT IDENTITY(1,1) PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    precio      DECIMAL(10,2) NOT NULL,
    stock       INT NOT NULL
);

CREATE TABLE dbo.Venta (
    idVenta     INT IDENTITY(1,1) PRIMARY KEY,
    fecha       DATETIME NOT NULL DEFAULT GETDATE(),
    idCliente   INT NOT NULL,
    idEmpleado  INT NOT NULL,
    total       DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_Venta_Cliente FOREIGN KEY (idCliente) REFERENCES dbo.Cliente(idCliente),
    CONSTRAINT FK_Venta_Empleado FOREIGN KEY (idEmpleado) REFERENCES dbo.Empleado(idEmpleado)
);

CREATE TABLE dbo.DetalleVenta (
    idDetalle   INT IDENTITY(1,1) PRIMARY KEY,
    idVenta     INT NOT NULL,
    idProducto  INT NOT NULL,
    cantidad    INT NOT NULL,
    precio      DECIMAL(10,2) NOT NULL,
    subtotal    DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_Detalle_Venta FOREIGN KEY (idVenta) REFERENCES dbo.Venta(idVenta),
    CONSTRAINT FK_Detalle_Producto FOREIGN KEY (idProducto) REFERENCES dbo.Producto(idProducto)
);
GO
