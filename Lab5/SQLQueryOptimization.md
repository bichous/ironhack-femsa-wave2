*** Consulta Orders Query ***

Consulta Inicial:
SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
FROM Orders
JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
WHERE OrderDetails.Quantity > 10
GROUP BY Orders.OrderID;

Observaciones:
a) La consulta anterior posiblemente no tiene un índice para los campos OrderId y Quantity por lo que se deben generar los índices 'idx_orderdetails_orderid' y 'idx_orderdetails_quantity' involucrando los campos anteriormente mencionados, con la finalidad de optimizar la búsqueda y el filtrado de datos.
b) Por mantenimiento se recomienda colocar un alías cuando se genera un JOIN.
c) El segmentar/filtrar un universo de datos después de hacer un JOIN considero no es lo más óptimo por lo que se podría generar una subconsulta para asi reducir el conjunto de datos procesados en el JOIN.

Resultado:
SELECT o.OrderID, SUM(od.Quantity * od.UnitPrice) AS TotalPrice
FROM Orders o
JOIN (SELECT OrderID, Quantity, UnitPrice FROM OrderDetails WHERE Quantity > 10) AS od
ON o.OrderID = od.OrderID
GROUP BY o.OrderID;

CREATE INDEX idx_orderdetails_orderid ON OrderDetails(OrderID);
CREATE INDEX idx_orderdetails_quantity ON OrderDetails(Quantity);


*** Customer Query ***

Consulta Inicial:
SELECT CustomerName
FROM Customers
WHERE City = 'London'
ORDER BY CustomerName;

Observaciones:
a) La consulta anterior posiblemente no tiene un índice para los campos City y CustomerName por lo que se debe generar el índice 'idx_customers_city_name' involucrando los campos anteriormente mencionados, con la finalidad de optimizar la búsqueda y el filtrado de datos.

Resultado:
SELECT CustomerName
FROM Customers
WHERE City = 'London'
ORDER BY CustomerName;

CREATE INDEX idx_customers_city_name ON Customers(City, CustomerName);