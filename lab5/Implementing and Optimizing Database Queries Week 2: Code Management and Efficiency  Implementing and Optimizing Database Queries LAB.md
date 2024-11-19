## 1. SQL Query Optimization
   Participants are given SQL queries and asked to improve them based on theoretical knowledge of database optimization.

- **Provided SQL Queries for Optimization:**

1. **Orders Query:** Retrieve orders with many items and calculate the total price.

```sql
SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
FROM Orders
JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
WHERE OrderDetails.Quantity > 10
GROUP BY Orders.OrderID;
```

### Answer

```sql
# Fullfills the Selecting Only Necessary Columns technique.
SELECT Orders.OrderID, SUM(OrderDetails.Quantity * OrderDetails.UnitPrice) AS TotalPrice
FROM Orders
# Fulfills the Using Joins Effectively technique. It is not necessary to have the data that are null, but those that have information. 
INNER JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
WHERE OrderDetails.Quantity > 10
GROUP BY Orders.OrderID;

# Assuming that the Orders.OrderID column is the primary key, we would not need an index on this column, but it would be convenient to have it from the foreign key and an index composed by Id and quantity to make queries more efficient.
ALTER TABLE `OrderDetails` ADD INDEX `OrderId_Quantity_Index`(`OrderID`,`Quantity`)
```

2. **Customer Query:** Find all customers from London and sort by CustomerName
```sql
SELECT CustomerName FROM Customers WHERE City = 'London' ORDER BY CustomerName;
```

### Answer

```sql
SELECT CustomerName FROM Customers WHERE City = 'London' ORDER BY CustomerName;
# Fullfills the Selecting Only Necessary Columns technique.
# Where clause optimization technique is not necessary.
# It is only necessary to add an index to the column by which the search is performed:
ALTER TABLE `Customers` ADD INDEX `City_Index`(`City`)
```

- **Optimization Tasks:**

  - Participants identify inefficiencies and propose modifications to optimize these queries, such as indexing critical columns, restructuring joins, or adjusting filters.
  - Theoretical application of indexes or rewriting of subqueries is discussed to theoretically reduce computational load.

## 2. NoSQL Query Implementation

Participants will optimize provided NoSQL queries theoretically, focusing on efficient data retrieval and minimized latency.

- **NoSQL Queries for Review:**

1. **User Posts Query:** Retrieve the most popular active posts and display their title and like count.

```
db.posts
  .find({ status: "active" }, { title: 1, likes: 1 })
  .sort({ likes: -1 });

```

### Answer

```json
// - The first thing to do is to design the model on the basis of the query we need
{
  _id = 1
  "title": "Post's title",
  "likes": 10,
  "status": "active"
}
// - It is being fulfilled to bring the necessary fields, but you can omit this step, denormalizing the documents.
// - We do not have aggregation operations.
// - It is advisable to create indexes, to make the queries more efficient.
db.post.createIndex(
  { "status": "text" },
  { "name": "PostStatusIndex" }
)
```

2. **User Data Aggregation:** Summarize the number of active users by location.
```
db.users.aggregate([
  { $match: { status: "active" } },
  { $group: { _id: "$location", totalUsers: { $sum: 1 } } },
]);
```

```json
// - The first thing to do is to design the model on the basis of the query we need
// - - We denormalize the table and duplicate the collection and store the information in that collection.


summaryUsers

{
  _id = 1
  "location": "USA",
  "totalUsers": 10,
  "status": "active"
}
// - Aggregates are heavy, so it is preferable to have a change that already has this value.
// - It is advisable to create indexes, to make the queries more efficient.
db.summaryUsers.createIndex(
  { "status": "text" },
  { "name": "SummaryUserStatusIndex" }
)
```

- **Optimization Task:**

  - Propose changes to improve query performance based on document structure and indexing strategies.
  - Suggestions might include modifying the document schema, adding indexes, or optimizing aggregation pipelines.

