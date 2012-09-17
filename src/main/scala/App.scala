import scala.collection.JavaConversions._
import java.awt.event.ActionEvent

import org.cytoscape.app.swing.AbstractCySwingApp
import org.cytoscape.app.swing.CySwingAppAdapter
import org.cytoscape.application.swing.AbstractCyAction
import org.cytoscape.app.CyAppAdapter

import org.cytoscape.model.CyEdge
import org.cytoscape.view.presentation.property.BasicVisualLexicon

class HideSingletonNodesApp(adapter: CySwingAppAdapter)
extends AbstractCySwingApp(adapter) {
  adapter.getCySwingApplication.addAction(new MenuAction(adapter))
}

class MenuAction(adapter: CyAppAdapter)
extends AbstractCyAction("Hide unconnected nodes",
                       adapter.getCyApplicationManager,
                       "network",
                       adapter.getCyNetworkViewManager) {
  setPreferredMenu("Select")

  def actionPerformed(e: ActionEvent) {
    val manager = adapter.getCyApplicationManager
    val networkView = manager.getCurrentNetworkView
    val network = networkView.getModel
    for (node <- network.getNodeList) {
      if (network.getNeighborList(node, CyEdge.Type.ANY).isEmpty) {
        networkView.getNodeView(node).setVisualProperty(
          BasicVisualLexicon.NODE_VISIBLE, false)
      }
    }
    networkView.updateView
  }
}
