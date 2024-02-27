/// <reference types="../../@mindfusion/controls" />
/// <reference types="../../@mindfusion/diagramming" />
/// <reference types="../../@mindfusion/common-collections" />
/// <reference types="../../@mindfusion/common-ui" />
declare module "Diagramming.Controls/Enum" {
    /**
     * Specifies the alignment of a tab strip relative to its container control.
     */
    export type TabAlignment = number;
    export namespace TabAlignment {
        const None: number;
        const Top: number;
        const Bottom: number;
    }
}
declare module "Diagramming.Controls/Events" {
    /**
    * @namespace MindFusion.Diagramming.Controls
    */
    /**
    * @class Defines all events raised by the controls in the MindFusion.Diagrammming.Controls namespace.
    */
    export class Events {
        /**
        * Raised before the selected page in a TabbedDiagramView control is changed.
        * @type {String}
        * @summary A string containing the event name.
        */
        static get pageChanging(): string;
        /**
        * Raised when the selected page in a TabbedDiagramView control has changed.
        * @type {String}
        * @summary A string containing the event name.
        */
        static get pageChanged(): string;
        /**
        * Raised before a page is added to a TabbedDiagramView control.
        * @type {String}
        * @summary A string containing the event name.
        */
        static get pageAdding(): string;
        /**
        * Raised when the a page has been added to a TabbedDiagramView control.
        * @type {String}
        * @summary A string containing the event name.
        */
        static get pageAdded(): string;
        /**
        * Raised before a page is removed from a TabbedDiagramView control.
        * @type {String}
        * @summary A string containing the event name.
        */
        static get pageRemoving(): string;
        /**
        * Raised when the a page has been removed from a TabbedDiagramView control.
        * @type {String}
        * @summary A string containing the event name.
        */
        static get pageRemoved(): string;
    }
}
declare module "Diagramming.Controls/EventArgs" {
    /**
    * @class Contains the arguments passed to handlers of page-related events in a TabbedDiagramView.
    * @augments CancelEventArgs
    */
    export class PageEventArgs extends CancelEventArgs {
        /**
        * Initializes a new instance of the PageEventArgs class.
        * @constructor
        * @param {Object} args
        */
        constructor(args: any);
        sender: any;
        _page: any;
        _oldPage: any;
        /**
        * Gets the page for which the event is raised.
        * @type {DiagramPage}
        * @summary A DiagramPage instance.
        */
        get page(): any;
        /**
        * Gets the page before the event.
        * @type {DiagramPage}
        * @summary A DiagramPage instance.
        */
        get oldPage(): any;
    }
    import { CancelEventArgs } from "@mindfusion/controls";
}
declare module "Diagramming.Controls/TabbedDiagramView" {
    /**
    * @class Represents a DiagramView that can display DiagramDocument objects.
    * The individual diagram pages can be activated through the tabs in the
    * tray located at one of the view sides.
    * @augments DiagramView
    */
    export class TabbedDiagramView extends DiagramView {
        /**
        * Creates and initializes a new TabbedDiagramView from the specified element.
        * This method is static and can be called without creating an instance of the class.
        * @param {HTMLCanvasElement} element The DOM element that the DiagramView should be attached to.
        * @param {DiagramDocument} [document] The DiagramDocument instance this control is associated with.
        * @returns {TabbedDiagramView} The newly created TabbedDiagramView object.
        */
        static create(element: HTMLCanvasElement, document?: DiagramDocument): TabbedDiagramView;
        /**
        * Initializes a new instance of the TabbedDiagramView class.
        * @constructor
        * @param {HTMLCanvasElement} element The Canvas DOM Element this TabbedDiagramView is associated with.
        * @param {DiagramDocument} [document] The DiagramDocument instance this control is associated with.
        */
        constructor(element: HTMLCanvasElement, document?: DiagramDocument);
        documentChangedDelegate: (sender: any, args: any) => void;
        set document(arg: DiagramDocument);
        /**
        * Gets or sets the diagram document displayed by this view.
        * @type {DiagramDocument}
        * @summary The DiagramDocument instance displayed by this view.
        */
        get document(): DiagramDocument;
        _lastIndex: number;
        items: ObservableCollection<any>;
        _tabAlignment: number;
        tabStrip: TabStrip;
        set tabsSize(arg: number);
        /**
        * Gets or sets the height of the tab strip.
        * @type {Number}
        * @summary The height.
        */
        get tabsSize(): number;
        set showTabCloseButtons(arg: boolean);
        /**
        * Gets or sets a value indicating whether to display a close button for each tab.
        * @type {Boolean}
        * @summary true if the tabs close buttons are visible, or false otherwise.
        * The default value is false.
        */
        get showTabCloseButtons(): boolean;
        set showNavigationButtons(arg: boolean);
        /**
        * Gets or sets a value indicating whether to show tab navigation buttons.
        * @type {Boolean}
        * @summary true if the tab navigation buttons are visible, or false otherwise.
        * The default value is false.
        */
        get showNavigationButtons(): boolean;
        _tabMouseDownHandler: (sender: any, args: any) => void;
        _tabDropHandler: (sender: any, args: any) => void;
        set selectedPage(arg: DiagramPage);
        /**
        * Gets or sets the currently selected tab page.
        * @type {DiagramPage}
        * @summary The selected diagram page.
        */
        get selectedPage(): DiagramPage;
        set tabAlignment(arg: number);
        /**
        * Gets or sets the tab alignment.
        * @type {TabAlignment}
        * @summary A member of the TabAlignment enumeration.
        */
        get tabAlignment(): number;
        set showAddButton(arg: boolean);
        /**
        * Gets or sets a value indicating whether to display the 'Add Tab' button.
        * @type {Boolean}
        * @summary true if the 'Add Tab' button is visible, or false otherwise.
        * The default value is false.
        */
        get showAddButton(): boolean;
        set allowReorder(arg: boolean);
        /**
        * Gets or sets a value indicating whether tabs can be rearranged interactively.
        * @type {Boolean}
        * @summary true if tabs can be rearranged interactively, or false otherwise. The default value is false.
        */
        get allowReorder(): boolean;
        set theme(arg: Theme);
        /**
        * Gets or sets the theme of the control.
        * @type {Theme}
        * @summary An instance of the Theme class.
        */
        get theme(): Theme;
        set selectedIndex(arg: number);
        /**
        * Gets or sets the index of the currently selected diagram page.
        * @type {Number}
        * @summary The index of the selected diagram page.
        */
        get selectedIndex(): number;
        resetTabAlignment(): void;
        resetTabs(): void;
        onTabMouseDown(sender: any, args: any): void;
        onTabDrop(sender: any, args: any): void;
        onItemsChanging(sender: any, args: any): void;
        onItemsChanged(sender: any, args: any): void;
        _selectedPage: DiagramPage;
        /**
        * @private
        */
        private getItemByHeader;
        _document: any;
        _theme: any;
        set themesPath(arg: string);
        /**
        * Gets or sets the path to the control's css themes.
        * @type {String}
        * @summary A string specifying the path.
        * @remarks Only applies to web components.
        */
        get themesPath(): string;
        _themesPath: any;
        /**
       * Sets the current theme of the control and its pages.
       * @param {Theme} theme The theme.
       * @param {Boolean} [setToPages] true to set pages' themes, otherwise false.
       */
        setTheme(theme: Theme, setToPages?: boolean): void;
        onDocumentChanged(sender: any, args: any): void;
        onPageValidateAction(event: any, page: any, oldPage: any): boolean;
    }
    import { DiagramView } from "@mindfusion/diagramming";
    import { DiagramDocument } from "@mindfusion/diagramming";
    import { ObservableCollection } from "@mindfusion/common-collections";
    import { TabStrip } from "@mindfusion/common-ui";
    import { DiagramPage } from "@mindfusion/diagramming";
    import { Theme } from "@mindfusion/diagramming";
}
declare module "@mindfusion/diagramming-controls" {
    export { TabAlignment } from "Diagramming.Controls/Enum";
    export { Events } from "Diagramming.Controls/Events";
    export { PageEventArgs } from "Diagramming.Controls/EventArgs";
    export { TabbedDiagramView } from "Diagramming.Controls/TabbedDiagramView";
}
