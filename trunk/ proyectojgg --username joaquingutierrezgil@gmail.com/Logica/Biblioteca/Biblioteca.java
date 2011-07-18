package Biblioteca;

/*
 * A recursive method to populate a JTree
 * Author: Danny Battison
 * Contact: gabehabe@googlemail.com
 */

/*
 * @params: String directory ~ the directory to scan
 * @params: DefaultMutableTreeNode parent ~ the node to add any files as children
 * @params: Boolean recursive ~ determine whether to scan all subdirectories, or just the parent
 */


/** EXAMPLE USAGE **/
import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;

public class Biblioteca extends JFrame{
	public Biblioteca() {
		DefaultMutableTreeNode master = new DefaultMutableTreeNode("Node Title");
		JTree tree = new JTree(master);
		JScrollPane scroll = new JScrollPane(tree);
		this.setSize(200,400);
		this.getContentPane().add(scroll);
		// pass the directory that you wish to list the contents
		listAllFiles("C:\\ConfigStreaming",  master, true);
	}

	/*
	 * @params: String directory ~ the directory to scan
	 * @params: DefaultMutableTreeNode parent ~ the node to add any files as children
	 * @params: Boolean recursive ~ determine whether to scan all subdirectories, or just the parent
	 */
	public static void listAllFiles(String directory, DefaultMutableTreeNode parent, Boolean recursive) {
		File [] children = new File(directory).listFiles(); // list all the files in the directory
		for (int i = 0; i < children.length; i++) { // loop through each
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(children[i].getName());
			// only display the node if it isn't a folder, and if this is a recursive call
			if (children[i].isDirectory() && recursive) {
				parent.add(node); // add as a child node
				listAllFiles(children[i].getPath(), node, recursive); // call again for the subdirectory
			} else if (!children[i].isDirectory()){ // otherwise, if it isn't a directory
				parent.add(node); // add it as a node and do nothing else
			}
		}
	}
}
