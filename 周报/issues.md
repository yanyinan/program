### `JVM`堆

1. **新生代（`Young Generation`）：** 新生代是`JVM`堆内存的一部分，用于存储新创建的对象。`Eden`区和两个`Survivor`区（通常称为`From`和`To`区），也可以说它被进一步划分为三个区域：`Eden`区、`SurvivorFrom`区（通常称为`S0`区）和`SurvivorTo`区（通常称为`S1`区）。新创建的对象首先被分配到`Eden`区，经过一次`Minor GC`（年轻代垃圾回收），仍然存活的对象会被移动到`Survivor`区。在`Survivor`区中，存活对象在多次垃圾回收后可能会晋升到老年代。
2. **老年代（`Old Generation`）：** 老年代用于存储长时间存活的对象和从新生代晋升过来的对象。老年代中的对象会在`Major GC`（老年代垃圾回收）时被清理。
3. **永久代（`Permanent Generation`）：** 永久代在Java 8及以前的版本中用于存储类的元数据、静态变量、常量等。但由于永久代的管理和调优比较复杂，并且容易导致内存泄漏等问题，从Java 8开始，永久代被元空间（`Metaspace`）取代。元空间不再位于堆内存，而是使用本地内存。这也是为什么在Java 8及以后的版本中，不再提及永久代。
4. **元空间（`Metaspace`）：** 元空间是Java 8及以后版本中取代了永久代的概念。它用于存储类的元数据信息，如类的结构、方法信息等。元空间不受固定内存大小的限制，可以根据应用程序的需要动态地分配和释放内存。

#### 元空间是啥

在`JVM`中，元空间（`Metaspace`）是Java虚拟机中用于存储类元数据的区域，包括类的名称、方法、字段等信息。当加载大量类或者动态生成类时，元空间的内存可能会被耗尽，导致该错误的发生。解决方法包括增加元空间的大小、减少类的加载或者优化代码等  。