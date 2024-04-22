
console.log("jdisujo")
$(".bt-badge").on('click', onBadgeClick);



var qForclas1 =[];
function onBadgeClick(event) {
    event.preventDefault();
    console.log("hii");

    var class1 = $(this).children('span').attr('id');
    
    var valueofInput = $('#search-input').val();
    console.log(valeofInput);
    var roleWiseId = $(this).children('div').attr('id');
    var regionWiseSearch = $(".bt-badge :selected").val().toUpperCase();

    if(class1!=undefined){
        qForclas1.push(clas1);
    }
    
    if(valueofInput!=undefined){
        clas1 = qForclas1.at(qForclas1.length-1);
    }
    console.log(class1);
$.ajax({
      url: "ajaxcall/"+class1+"/"+valueofInput+"/"+roleWiseId+"/"+regionWiseSearch+"",
      type: "GET",    // HTTP method (GET, POST, etc.)
      
      dataType: "json", // Expected data type of the response (optional)
      success: function(data) {
          console.log(data);
          console.log("jii")
        
        $(".t-header").empty();
          
          console.log("hearder-empty");
          
         $(".t-data").empty();
         
         var accbody = $("#a-data");
         accbody.empty();
         var th = `<tr>
         <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Name</th>
                <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"></th>
                
                <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction">Date of Birth</th>
                <th scope="col" class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Physician Name</th>
                <th scope="col" class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Date of Service</th>
                <th scope="col" class="ToCloseAction">Region</th>
                <th scope="col" class="NewAction PendingAction ActiveAction">Requestor</th>
                <th scope="col" class="NewAction">Requested Date</th>
                <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction UnpaidAction">Phone</th>
                <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Address</th>
                <th scope="col" class="NewAction PendingAction ActiveAction ToCloseAction">Notes</th>

                <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Actions</th>
            </tr>`
            
            $(".t-header").append(th);
            
            
            for(let i =0 ; i<data.length ; i++ )
                {
                
                var dataset = data[i];
                console.log(dataset)
                var id = dataset.requestId;
                console.log("hello")
                console.log(id);
                
            
        var rows = `<tr><td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">`+ dataset.name+`</td>
            <td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">e</td>
            
            <td class="NewAction ActiveAction ConcludeAction ToCloseAction PendingAction">`+ dataset.dob+`</td>
            <td class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">docter</td>
            <td class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">DOS</td>
            <td class="ToCloseAction">`+ dataset.region+`</td>
            <td class="NewAction PendingAction ActiveAction">`+ dataset.requestor+`</td>
            <td class="NewAction">`+ dataset.requestedDate+`</td>
            <td class="NewAction PendingAction ActiveAction ConcludeAction UnpaidAction">`+ dataset.phone+`</td>
            <td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">`+ dataset.address+`</td>
            <td class="NewAction PendingAction ActiveAction ToCloseAction">`+ dataset.notes+`</td>
            <td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"><a class=" dropdown-toggle btn-sm btn text-white border border-white "
                style="border: 1px solid rgb(255, 255, 255); border-radius: 2px;"
                href="#" role="button" data-bs-toggle="dropdown"
                aria-expanded="false"> Actions </a>


            <ul class="dropdown-menu text-muted">
                <li class="NewAction"><a class="dropdown-item " onclick="cancelCase('`+dataset.name+`', `+id+`)" data-bs-toggle="modal"
                    data-bs-target="#assign"><i
                        class="bi bi-card-checklist mx-2"></i>assign Case</a></li>
                <li class="NewAction"><a class="dropdown-item" onclick="cancelCase('`+dataset.name+`', `+id+`)" data-bs-toggle="modal"
                    data-bs-target="#cancel" ><i class="bi bi-x-circle mx-2" ></i>cancel
                        case </a></li>
                <li class="PendingAction NewAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"><a class="dropdown-item text-secondary"
                    href="viewCase/`+id+`"><i class="bi bi-card-heading mx-2"></i>view
                        case</a></li>
                <li class="PendingAction ToCloseAction"><a class="dropdown-item" onclick="cancelCase('`+dataset.name+`', `+id+`)" data-bs-toggle="modal"
                    data-bs-target="#clear"><i class="bi bi-x-circle mx-2"></i>clear
                        case</a></li>
                <li class="ToCloseAction"><a class="dropdown-item text-secondary"
                    href="close_case.html"><i class="bi bi-x-circle mx-2"></i>close
                        case</a></li>
                <li class="PendingAction NewAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"><a class="dropdown-item text-secondary"
                    href="viewNotes/`+id+`"><i class="bi bi-journal-medical mx-2 "></i>view
                        notes</a></li>
                <li class="NewAction"><a class="dropdown-item text-secondary" onclick="cancelCase('`+dataset.name+`', `+id+`)"
                    data-bs-toggle="modal" data-bs-target="#block"><i
                        class="bi bi-ban mx-2"></i>Block Patients</a></li>
                <li class="PendingAction ActiveAction ConcludeAction"><a class="dropdown-item text-secondary"
                    href="viewDocs/`+id+`""><i
                        class="bi bi-file-earmark-arrow-up mx-2 ToCloseAction UnpaidAction"></i> view uploads</a></li>
                <li class="PendingAction"><a class="dropdown-item" data-bs-toggle="modal"
                    data-bs-target="#transfer" onclick="cancelCase('`+dataset.name+`', `+id+`)"><i
                        class="bi bi-card-checklist mx-2"></i>transfer</a></li>
                <li class="PendingAction"><a class="dropdown-item" data-bs-toggle="modal"
                    data-bs-target="#send"> <i
                        class="bi bi-file-earmark-slides mx-2 "></i>send agreement
                </a></li>
                <li class="ActiveAction ConcludeAction ToCloseAction"><a class="dropdown-item text-secondary"
                    href="orders.html"><i
                        class="bi bi-clipboard-check-fill mx-2"></i>orders</a></li>
                <li class="ActiveAction ConcludeAction ToCloseAction"><a class="dropdown-item text-secondary" href="#"><i
                        class="bi bi-file-earmark-richtext mx-2"></i>doctors notes</a></li>

                <li class="ActiveAction ConcludeAction ToCloseAction"><a class="dropdown-item text-secondary" href="#"><i
                        class="bi bi-file-earmark-richtext mx-2"></i>encounter</a></li>
            </ul>
            </td></tr>`
            
        let id1 = "id" + i;
        var accordian = `<div class="accordion-item">
            <h2 class="accordion-header">
            <div class="accordion-button collapsed bg-primary-subtle"
                type="button" data-bs-toggle="collapse"
                    data-bs-target="#` + id1 + `"  aria-expanded="false"
                aria-controls="` + id1 + `">
                <div class="container-fluid">
                    <div class="d-flex justify-content-between mb-3">
                        <div class="">
                            <h6>`+ dataset.name +`</h6>
                        </div>
                        <div class="d-flex justify-content-center">
                            <h6 class="me-1">Patients</h6>
                            <div class="rounded-circle mt-1"
                                style="height: 12px; width: 12px; background-color: rgb(15, 189, 64);">
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="">
                            <p class="fw-normal mb-0">`+ dataset.address +`</p>
                            
                        </div>
                        <div class="">
                            <button
                                class="btn btn-outline-info btn-sm rounded-pill maploc">Map
                                Location</button>
                        </div>
                    </div>
                    <div class="d-flex">
                        <img src="" alt="">
                        <p class="text-secondary fw-small" style="font-size: 0.8rem;">
                            Wait Time: <span class="fw-small">Dec 5,2023 08:52AM
                                (641.59)</span>
                        </p>
                    </div>
                </div>
            </div>

        </h2>
        <div id="` + id1 + `" class="accordion-collapse collapse"
            data-bs-parent="#accordionFlushExample">

            <hr class="m-0">
            <div class="d-flex justify-content-end"
                style="margin-top: -12px;">
                <button
                    class="btn text-primary btn-outline-primary rounded-pill bg-white py-0 px-2 me-4 z-3"
                    style="font-size: small; position: absolute;">View
                    Case</button>
            </div>


            <div class="accordion-body container-fluid mt-2">
                <div class="d-flex">
                    <div class="me-1">
                        <i class="bi bi-calendar-event"></i>
                    </div>
                    <label for="" class="me-2 text-secondary">Date of
                        birth:</label>
                    <p>`+ dataset.dob +`</p>
                </div>
                <div class="d-flex">
                    <div class="me-1">
                        <i class="bi bi-envelope"></i>
                    </div>
                    <label for="" class="me-2 text-secondary">Email:</label>
                    <p>`+ dataset.email +`</p>
                </div>
                <div class="d-flex">
                    <div class="me-1">
                        <i class="bi bi-telephone"></i>
                    </div>
                    <label for="" class="me-2 text-secondary">Patient:</label>
                    <p>`+ dataset.phone +`</p>
                </div>
                <div class="d-flex">
                    <div class="me-1">
                        <i class="bi bi-person"></i>
                    </div>
                    <label for="" class="me-2 text-secondary">Requestor:</label>
                    <p>Patient `+ dataset.name +`</p>
                </div>
                <div>
                    <div class="row mb-2 ">
                        <div class="col-6">
                            <button class="btn text-white rounded-pill w-100"
                                data-bs-toggle="modal" data-bs-target="#assign"
                                style="background-color: purple; font-size: small;">Assign
                                Case</button>
                        </div>
                        <div class="col-6">
                            <button
                                class="btn bg-danger border-0 text-white rounded-pill w-100"
                                style="font-size: small;" data-bs-target="#cancel"
                                data-bs-toggle="modal">Cancel Case</button>
                        </div>


                    </div>
                    <div class="row mb-2">
                        <div class="col-6">
                            <a class="btn bg-success text-white rounded-pill w-100"
                                style="font-size: small;" href="view_notes.html">View
                                Notes</a>
                        </div>
                        <div class="col-6">
                            <button
                                class="btn bg-danger border-0 text-white rounded-pill w-100"
                                style="font-size: small;" data-bs-toggle="modal"
                                data-bs-target="#block">Block Patients</button>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-6">
                            <button class="btn bg-success text-white rounded-pill w-100"
                                style="font-size: small;">Email</button>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>` 
    

        



if(class1 == "blue" && dataset.status==1){
                console.log("iffff")
                $(".t-data").append(rows);
                $(accbody).append(accordian);
                
                
                if(dataset.requestTypeId==1){
                    $('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==2) {
                    $('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==3) {
                    $('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==4) {
                    $('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
                }); 
                }
                
                $(".PendingAction").hide();
                 $(".ActiveAction").hide();
                 $(".ConcludeAction").hide();
                 $(".ToCloseAction").hide();
                 $(".UnpaidAction").hide();
                 $(".NewAction").show();
                
                
            }
        
            else if(class1 == "sky" && dataset.status==2){
                    console.log("iffff")
                    $(".t-data").append(rows);
                    $(accbody).append(accordian);
                    
                    if(dataset.requestTypeId==1){
                        $('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                    });
                    }
                    else if(dataset.requestTypeId==2) {
                        $('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
                    });
                    }
                    else if(dataset.requestTypeId==3) {
                        $('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
                    });
                    }
                    else if(dataset.requestTypeId==4) {
                        $('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
                    });
                    }
                    
                    $(".NewAction").hide();
                     $(".ActiveAction").hide();
                     $(".ConcludeAction").hide();
                     $(".ToCloseAction").hide();
                     $(".UnpaidAction").hide();
                     $(".PendingAction").show();
                    
                    
                }
        
            else if(class1 == "green" && (dataset.status==4 || dataset.status==5)){
                console.log("iffff")
                $(".t-data").append(rows);
                $(accbody).append(accordian);
                
                if(dataset.requestTypeId==1){
                    $('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==2) {
                    $('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==3) {
                    $('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==4) {
                    $('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
                });
                }
                
                $(".NewAction").hide();
                 $(".PendingAction").hide();
                 $(".ConcludeAction").hide();
                 $(".ToCloseAction").hide();
                 $(".UnpaidAction").hide();
                 $(".ActiveAction").show();
                
                
            }
        
            else if(class1 == "pink" && dataset.status==6){
                console.log("iffff")
                $(".t-data").append(rows);
                $(accbody).append(accordian);
                
                if(dataset.requestTypeId==1){
                    $('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==2) {
                    $('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==3) {
                    $('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==4) {
                    $('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
                });
                }
                
                 $(".NewAction").hide();
                 $(".PendingAction").hide();
                 $(".ActiveAction").hide();
                 $(".ToCloseAction").hide();
                 $(".UnpaidAction").hide();
                 $(".ConcludeAction").show();
                
                
            }
        
            else if(class1 == "light-blue" && (dataset.status==3 || dataset.status==7 || dataset.status==8)){
                console.log("iffff")
                $(".t-data").append(rows);
                $(accbody).append(accordian);
                
                if(dataset.requestTypeId==1){
                    $('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==2) {
                    $('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==3) {
                    $('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==4) {
                    $('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
                });
                }
                
                 $(".NewAction").hide();
                 $(".PendingAction").hide();
                 $(".ActiveAction").hide();
                 $(".ConcludeAction").hide();
                 $(".UnpaidAction").hide();
                 $(".ToCloseAction").show();
                
                
            }
        
            else if(class1 == "purple" && dataset.status==9){
                console.log("iffff")
                $(".t-data").append(rows);
                $(accbody).append(accordian);
                
                if(dataset.requestTypeId==1){
                    $('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==2) {
                    $('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==3) {
                    $('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
                });
                }
                else if(dataset.requestTypeId==4) {
                    $('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
                });
                }
                
                 $(".NewAction").hide();
                 $(".PendingAction").hide();
                 $(".ActiveAction").hide();
                 $(".ConcludeAction").hide();
                 $(".ToCloseAction").hide();
                 $(".UnpaidAction").show();
                
            }
        
        
        
        
        
        
            
        
            
        
        }
            
        
        
    
        
        

            
            

            
            
      },
    
    });
}