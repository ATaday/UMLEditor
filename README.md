# UMLEditor
Implementing a simple UML editor.

The editor should allow the user to draw class diagrams
and three relations in between: inheritance, aggregation and interface implementation. Class diagrams should allow the
user to enter name of class, methods and instance elds. In addition, the editor should automatically construct code from
that diagram, which includes the header information of classes and methods. Also in another view, you should display
some statistics about the complexity of the UML diagram, such as number of each relation, whether all the classes are
connected in the whole diagram, etc. You will decide on which statistics can be used to evaluate a UML diagram.
Therefore, as your customer, we require you to design and implement a simple UML editor that can;

- be used to draw a UML class diagram,that only includes the above components.
- display the code (all headers), in another view, corresponding to the current drawn UML diagram.
- update the code view whenever the UML diagram is updated. This should be performed by using observer pattern.
- update the statistics view whenever the UML diagram is updated. This also should be performed by using observer
pattern.
