+------------------+
|    Memento       |
+------------------+
| - state: State   |
+------------------+
| + getState(): State |
| + setState(state: State) |
+------------------+

+------------------+
|    Originator    |
+------------------+
| - state: State   |
| - memento: Memento |
+------------------+
| + setState(state: State) |
| + save(): Memento        |
| + restore(memento: Memento) |
+------------------+

+------------------+
|    Caretaker     |
+------------------+
| - mementos: List<Memento> |
+------------------+
| + addMemento(memento: Memento) |
| + getMemento(index: int): Memento |
+------------------+

==========================================

+------------------+
|   PriceMemento   |
+------------------+
| - state: int     |
+------------------+
| + getState(): int|
| + setState(state: int) |
+------------------+

+------------------+
|    StoreItem     |
+------------------+
| - price: int     |
| - memento: PriceMemento |
+------------------+
| + getPrice(): int|
| + setPrice(price: int) |
| + save()         |
| + restore()      |
+------------------+