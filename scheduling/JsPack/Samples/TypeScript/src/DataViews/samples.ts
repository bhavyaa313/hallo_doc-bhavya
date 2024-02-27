document.addEventListener("DOMContentLoaded", function () {
	var e = document.createElement('div');
	e.innerHTML = 	'<hr />' +
	'<h1>About JsDataViews</h1>' +
	'<p>JsDataViews Grid is a lightweight grid control, that binds to an array of objects and displays the data in tabular format.</p>' +
	'<h2>Features</h2>' +
	'<ul>' +
	'<li>Row virtualization</li>' +
	'<li>Inplace editing</li>' +
	'<li>Select, add and delete grid rows interactively</li>' +
	'<li>Interactive column sorting and resizing</li>' +
	'<li>Custom draw cells and column headers</li>' +
	'<li>Localization support</li>' +
	'<li>Themes</li>' +
	'</ul>' +
	'JsGrid is written 100% in JavaScript and can easily be integrated into any web application. ' +
	'It uses Flexible Box for layout.</p>';

	if (document.getElementById('infoTab'))
		document.getElementById('infoTab').appendChild(e);
});
