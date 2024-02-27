import * as Diagramming from '@mindfusion/diagramming';
import * as Controls from '@mindfusion/diagramming-controls';

namespace TabbedView {

    let theme;

    let diagramView = Controls.TabbedDiagramView.create(<HTMLCanvasElement>document.getElementById("diagram"));
    diagramView.tabAlignment = Controls.TabAlignment.Top;
    diagramView.showNavigationButtons = true;
    diagramView.showAddButton = true;
    diagramView.allowInplaceEdit = true;
    diagramView.addEventListener(Controls.Events.pageAdded, (sender, args) => {
        setupPage(args.page);
    })
    setupPage(diagramView.selectedPage);

    function setupPage(page) {
        page.theme = theme;
        page.showGrid = true;
        page.gridStyle = Diagramming.GridStyle.Points;
        page.defaultShape = Diagramming.Shapes.Rectangle();
        page.routeLinks = true;
        page.roundedLinks = true;
        page.roundedLinksRadius = 5;
        page.linkHeadShape = Diagramming.ArrowHeads.Triangle();
        page.linkHeadShapeSize = 3;
        page.shadowOffsetX = 2;
        page.shadowOffsetY = 2;
    }

    document.getElementById("tabAlignment").addEventListener("change", (e) => {
        diagramView.tabAlignment = +(<HTMLInputElement>e.target).value;
    });

    document.getElementById("showAddBtn").addEventListener("change", (e) => {
        diagramView.showAddButton = (<HTMLInputElement>e.target).checked;
    });

    document.getElementById("showCloseBtn").addEventListener("change", (e) => {
        diagramView.showTabCloseButtons = (<HTMLInputElement>e.target).checked;
    });

    document.getElementById("showNavBtn").addEventListener("change", (e) => {
        diagramView.showNavigationButtons = (<HTMLInputElement>e.target).checked;
    });

    document.getElementById("theme").onchange = function () {
        var themeId = (<HTMLSelectElement>document.getElementById("theme")).value;
        theme = Diagramming.Theme.fromId(themeId);
        diagramView.setTheme(theme, true);
    }
}