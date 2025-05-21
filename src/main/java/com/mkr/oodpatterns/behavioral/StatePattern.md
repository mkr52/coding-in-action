+------------------+
|    Context       |
+------------------+
| - state: State   |
+------------------+
| + setState(state: State) |
| + request()              |
+------------------+
|
v
+------------------+
|     State        | <<interface>>
+------------------+
| + handle(context: Context) |
+------------------+
^
|
+--------------------+       +--------------------+
|  ConcreteStateA    |       |  ConcreteStateB    |
+--------------------+       +--------------------+
| + handle(context)  |       | + handle(context)  |
+--------------------+       +--------------------+

======================================================

+------------------+
|     Auction      |
+------------------+
| - state: AuctionState |
+------------------+
| + startAuction() |
| + closeAuction() |
| + placeBid()     |
| + closeBid()     |
| + setState(state: AuctionState) |
+------------------+
|
v
+------------------+
|  AuctionState    | <<interface>>
+------------------+
| + startAuction(auction: Auction) |
| + closeAuction(auction: Auction) |
| + placeBid()                     |
| + closeBid()                     |
+------------------+
^
|
+--------------------+       +--------------------+
|  AuctionStarted    |       |  AuctionClosed     |
+--------------------+       +--------------------+
| + startAuction()   |       | + startAuction()   |
| + closeAuction()   |       | + closeAuction()   |
| + placeBid()       |       | + placeBid()       |
| + closeBid()       |       | + closeBid()       |
+--------------------+       +--------------------+