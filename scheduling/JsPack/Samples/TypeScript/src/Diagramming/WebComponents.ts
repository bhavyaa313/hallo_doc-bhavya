import * as Diagramming from '@mindfusion/diagramming';
import * as Controls from '@mindfusion/controls';

namespace WebComponentsSample {
	const GlassEffect = Diagramming.GlassEffect;
	const Style = Diagramming.Style;

	let diagram: Diagramming.Diagram = null;

	let diagramView = Diagramming.DiagramView.find("diagramView");
	diagram = diagramView.diagram;

	//styling
	let shapeNodeStyle = new Style();
	shapeNodeStyle.brush = { type: 'SolidBrush', color: '#e0e9e9' };
	shapeNodeStyle.stroke = "#7F7F7F";
	shapeNodeStyle.fontName = "Verdana";
	shapeNodeStyle.fontSize = 4;
	shapeNodeStyle.nodeEffects = [new GlassEffect()];
	diagram.style = shapeNodeStyle;

	let nodeList = Diagramming.NodeListView.find("nodeList");
	initNodeList(nodeList, diagram);

	let overview = Diagramming.Overview.find("overview");
	overview.diagramView = diagramView;

	let zoomer = Controls.ZoomControl.find("zoomer");
	zoomer.target = diagramView;

	let ruler = Diagramming.Ruler.find("ruler");
	ruler.diagramView = diagramView;


	function initNodeList(nodeList: Diagramming.NodeListView, diagram: Diagramming.Diagram) {
		// add some nodes to the NodeListView
		let shapes = ["Actor", "RoundRect", "Triangle", "Decision"];
		for (let i = 0; i < shapes.length; ++i) {
			let node = new Diagramming.ShapeNode(diagram);
			node.text = shapes[i];
			node.shape = shapes[i];

			nodeList.addNode(node, shapes[i]);
		}
	}
}