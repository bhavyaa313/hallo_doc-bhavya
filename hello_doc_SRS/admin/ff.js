$(document).ready(function(){
    debugger
    
    accountType = $("#AccountType").val();
    AccountTypeAjax(accountType)
    
    $("#AccountType").on("change", function(){
        accountType = $("#AccountType").val();
        AccountTypeAjax(accountType)
    
    
    
    })

    
})

function AccountTypeAjax(accountType){
    $("#roles").empty();
    $.ajax({
        method: "GET",
        url: "GetFilteredMenus/"+accountType,
        
        success: function (result) {
            debugger
            console.log(result);
      
            let str="";
             for (let i = 0; i < result.length; i++)
            {
                str = `<div class=" ms-3 form-check">
                    <input class="form-check-input Change1 me-3" type="checkbox" value=`+result[i].menuId+`
                       id=`+result[i].menuId+` name="checkbox_group" 
                   />
                <label class="form-check-label me-3" for=`+result[i].menuId+`>`+result[i].name+`</label>
            </div>`;
                $("#roles").append(str);
            } 
             
        }
    })
}