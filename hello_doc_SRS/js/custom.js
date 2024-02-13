let queid = [];
let queclass = [];
let arricon = [];
let arriconwhite = [];

function myFunction(spanid, imgid, color, iconidwhite, iconid){

    // for triangle image

    q=document.getElementsByClassName("dblock");
    if(q.length>0){
        q[0].classList.toggle("dnone");
        q[0].classList.toggle("dblock");
    }

    x=document.getElementById(imgid);
    x.classList.remove("dnone");
    x.classList.add("dblock");

    // for dark and light color

    queid.push(spanid)
    queclass.push(color)

    if(queid.length>1){
        let colid = queid.shift();
        let colclass = queclass.shift();

        y = document.getElementById(colid);
        y.classList.remove(colclass);
    }

    z=document.getElementById(spanid);
    z.classList.add(color);

    // for white nd colored icon 
    
    arricon.push(iconid);
    arriconwhite.push(iconidwhite);

    if(arricon.length>1){
        let id1 = arricon.shift();
        let id2 = arriconwhite.shift();

        a = document.getElementById(id1);
        b = document.getElementById(id2);
        a.classList.remove("dnone");
        b.classList.add("dnone");
    }

    r=document.getElementById(iconid);
    r.classList.add("dnone");

    p=document.getElementById(iconidwhite);
    p.classList.remove("dnone");
 
}

function myFunction2(boxid, searchid) {
    c=document.getElementsByClassName(searchid)
    c[0].classList.add("dnone")
    c[1].classList.add("dnone")
}

function changebg(){

    const btn = document.getElementById('btnnn');

btn.addEventListener('click', function onClick(event) {
  // 👇️ change background color
  document.body.style.backgroundColor = 'black';

  // 👇️ optionally change text color
  // document.body.style.color = 'white';
});
}


function myFunctions() {
    var element = document.body;

    element.classList.toggle("dark-mode");

    var navbarElements = document.querySelectorAll('.navbar-nav a.nav-link, .navbar-nav .btn .dm');
    navbarElements.forEach(function (element) {
        element.classList.toggle("text-dark");
    });
}


document.getElementsByClassName('drill_cursor')[0]
.addEventListener('click', function (event) {
    // do something
    document.getElementById('input_file').click();
    changePlaceholder();
    
})
function changePlaceholder() { 
    $('input[type="file"]').change(function (e) {
        const names = e.target.files[0].name;
    
        $('#txt').attr('placeholder', names); 
    });
} 