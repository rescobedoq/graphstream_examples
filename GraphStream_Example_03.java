import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
* GraphStream_Example_03 is a example of GraphStream library
* GraphStream is a Java library for the modeling and analysis 
* of dynamic graphs. You can generate, import, export, measure, 
* layout and visualize them.
* GraphStream is distributed under both licenses:
* <ul>
* <li>CeCILL-C.
* <li>LGPL v3.
* </ul>
* <p>
* Command for compile in Unix is:
* javac -classpath .:gs-core-2.0.jar:gs-ui-swing-2.0.jar GraphStream_Example_03.java
* <p>
* Comand for execution in Unix is:
* java -classpath .:gs-core-2.0.jar:gs-ui-swing-2.0.jar GraphStream_Example_03
* <p>
* The most important and necessary one is gs-core.
* It defines the base graph classes, the graph event streaming classes and a minimalist, 
* yet efficient, graph rendering user interface. The goal of this library is to remain small.
* <p>
* You will be able to visualize your graph with the gs-ui-swing module. 
* You can easily do this using the display() utility method: graph.display().
* <p>
* See: https://graphstream-project.org/doc/Tutorials/Getting-Started/
* See: https://graphstream-project.org/doc/Advanced-Concepts/GraphStream-CSS-Reference/
* 
* @author      Richart Smith Escobedo Quispe
* @version     1.0
* @date       2023-June-12
*/
public class GraphStream_Example_03 {
	
	public static void main(String args[]) {

		System.setProperty("org.graphstream.ui", "swing");
		
		Graph graph = new SingleGraph("GraphStream_Example_03");

		graph.setAttribute("ui.stylesheet", styleSheet);

		graph.setStrict(false);
		graph.setAutoCreate( true );

		//graph.addNode("A");
		//graph.addNode("Q");
		//graph.addNode("P");
		
		graph.addEdge("AQ", "A", "Q");
		graph.addEdge("AP", "A", "P");

		graph.display();
	}

	protected static String styleSheet =
		"node {"+
			"	shape: circle;"+
			"	size: 40px;"+
			" text-size: 12;"+
			"	fill-mode: plain;"+
			"	fill-color: skyblue;"+
			"	stroke-mode: plain;"+
			"	stroke-color: black;"+
			"	stroke-width: 1px;"+
		"}"+
		"edge { arrow-shape: arrow; arrow-size: 20px, 4px; }";
	
}