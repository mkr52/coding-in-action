+-----------------------+
|      Element          | <<interface>>
+-----------------------+
| + accept(visitor: Visitor) |
+-----------------------+
^
|
+-------------------+       +-------------------+
|   ConcreteElementA |       | ConcreteElementB |
+-------------------+       +-------------------+
| + accept(visitor) |       | + accept(visitor) |
+-------------------+       +-------------------+
^
|
+-------------------+
|     Visitor       | <<interface>>
+-------------------+
| + visit(ElementA) |
| + visit(ElementB) |
+-------------------+
^
|
+-------------------+
| ConcreteVisitor   |
+-------------------+
| + visit(ElementA) |
| + visit(ElementB) |
+-------------------+

============================================

+-----------------------+
|  FileSystemElement    | <<interface>>
+-----------------------+
| + getName(): String   |
| + accept(visitor: Visitor) |
+-----------------------+
^
|
+-------------------+       +-------------------+
|       File        |       |    Directory      |
+-------------------+       +-------------------+
| - name: String    |       | - name: String    |
| - size: int       |       | - elements: List<FileSystemElement> |
+-------------------+       +-------------------+
| + getSize(): int  |       | + addElement(element: FileSystemElement) |
| + accept(visitor) |       | + getElements(): List<FileSystemElement> |
+-------------------+       | + accept(visitor) |
+-------------------+
^
|
+-------------------+
|     Visitor       | <<interface>>
+-------------------+
| + visit(File)     |
| + visit(Directory)|
+-------------------+
^
|
+-------------------+
| CalculateSizeVisitor |
+-------------------+
| - totalSize: int  |
+-------------------+
| + getTotalSize(): int |
| + visit(File)     |
| + visit(Directory)|
+-------------------+