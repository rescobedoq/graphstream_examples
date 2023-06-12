import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.ui.view.Viewer;
import java.util.Iterator;

/**
* GraphStream_Example_10 is a example of GraphStream library
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
* javac -classpath .:gs-core-2.0.jar:gs-ui-swing-2.0.jar GraphStream_Example_10.java
* <p>
* Comand for execution in Unix is:
* java -classpath .:gs-core-2.0.jar:gs-ui-swing-2.0.jar GraphStream_Example_10
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
public class GraphStream_Example_10 {

	public static void main(String args[]) {
		new GraphStream_Example_10();
	}
	
	public GraphStream_Example_10() {

		System.setProperty("org.graphstream.ui", "swing");
		
		Graph graph = new SingleGraph("GraphStream_Example_10");

		Viewer viewer = graph.display();
		viewer.disableAutoLayout();	

		graph.setAttribute("ui.stylesheet", styleSheet);

		//		ASCII Symbol	: A,B,C, ... ,Y,Z.
		//		ASCII DEC 		: 65,66,67, ... ,89,90.
		//		
		//		INPUT = {RICHART}
		//
		//		OUTPUT = {
		//
		//					-3	-2	-1	0 1 2 3
		//											|
		//											|	
		//
		//		3 -- 				  		R
		//							 	 		 /\
		//										/	\
		//		2 --		 	 		 I 	R
		//					    		/		\
		//					   		 /		\
		//		1 --    		C 		T
		//			     		 /\
		//		 	    		/ \
		//		0 -- 		 A	H
		//		}
		
    graph.addNode("R");
    graph.getNode("R").setAttribute("xy", 0, 3);

    graph.addNode("I");
    graph.getNode("I").setAttribute("xy", -1, 2);
    graph.addEdge("RI", "R", "I");

    graph.addNode("C");
    graph.getNode("C").setAttribute("xy", -2, 1);
    graph.addEdge("IC", "I", "C");

    graph.addNode("H");
    graph.getNode("H").setAttribute("xy", -2, 0);
    graph.addEdge("CH", "C", "H");

    graph.addNode("A");
    graph.getNode("A").setAttribute("xy", -3, 0);
    graph.addEdge("CA", "C", "A");

    graph.addNode("R2");
    graph.getNode("R2").setAttribute("xy", 1, 2);
    graph.addEdge("RR2", "R", "R2");

    graph.addNode("T");
    graph.getNode("T").setAttribute("xy", 2, 1);
    Edge R2T = graph.addEdge("R2T", "R2", "T");

		Node root = graph.getNode("R");

		root.setAttribute("ui.class", "root");		
		
		explore(root);
		graph.getNode("R2").setAttribute("ui.label", "R");

	}

	public void explore(Node source) {
	    Iterator<? extends Node> k = source.getBreadthFirstIterator();
	    while (k.hasNext()) {
	        Node next = k.next();
	        next.setAttribute("ui.label", next.getId());
	        sleep();
	    }
	}

	protected void sleep() {
      try { Thread.sleep(1000); } catch (Exception e) {}
  	}

	protected String styleSheet =
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
		"edge { arrow-shape: arrow; arrow-size: 20px, 4px; }"+
		"node.root { fill-color: yellow; }";
	
}