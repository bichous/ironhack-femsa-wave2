*** User Posts Queryy ***

Consulta Inicial:
db.posts
  .find({ status: "active" }, { title: 1, likes: 1 })
  .sort({ likes: -1 });

Observaciones:
a) Se debe generar un índice compuesto que incluya los campos status y likes, esto tiene como finalidad no procesar todos los documentos en la colección

Resultado:
db.posts
  .find({ status: "active" }, { title: 1, likes: 1 })
  .sort({ likes: -1 });

db.posts.createIndex({ status: 1, likes: -1 });

*** User Data Aggregation ***

Consulta Inicial:
db.users.aggregate([
  { $match: { status: "active" } },
  { $group: { _id: "$location", totalUsers: { $sum: 1 } } },
]);

Observaciones:
a) Se debe generar un índice para los campos status y location, esto tiene como finalidad filtrar primero por usuarios activos y luego agruparlos por su ubicación sin recorrer todos los documentos en la colección.
b) La agregación funciona en memoria. Cada etapa puede utilizar hasta 100 MB de RAM. Recibirá un error de la base de datos si supera este límite por lo que se debe considerar la opción allowDiskUse contemplando que puede ser más lento el proceso.

Resultado:
db.users.aggregate([
  { $match: { status: "active" } },
  { $group: { _id: "$location", totalUsers: { $sum: 1 } } },
], { allowDiskUse: true });

db.users.createIndex({ status: 1, location: 1 });