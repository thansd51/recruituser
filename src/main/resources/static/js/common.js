function selectOpt(ele, vGrpName) {

    var $selectEle = $("#"+ele);

    // API에서 데이터 가져오기
    $.get("/select/" + vGrpName, function (data) {
        // 가져온 데이터를 이용하여 <select>에 옵션 추가
        // populateSelectOptions(ele, data);
        $selectEle.select2({data:data});
        $selectEle.on("select2:open", function (e) { 
            //console.log("select2:open", e); 
        })
        .on("select2:close", function (e) { 
            //console.log("select2:close", e); 
        })
        .on("select2:select", function (e) {

            var selVal="";
            selVal= $selectEle.val();
            var selTxt="";
            selTxt = $selectEle.select2('data')[0].text;

            if(ele == "emailSelection"){
                if(selVal != "typing"){
                    $("#email_domain").val(selTxt);
                    $("#email_domain").attr("readonly",true);
                }
                else{
                    $("#email_domain").val("").attr("readonly",false).focus();
                }

            } 
            else if(ele == "milSrvcSelection"){
                if(selVal == "D05"){
                    $("#mil_exem").prop("disabled", false);
                }
                else{
                    $("#mil_exem").prop("disabled", true).val("");
                }
            }
            //console.log("select2:select", e); 
        })
        .on("select2:unselect", function (e) { 
            //console.log("select2:unselect", e); 
        });
    });
}

// document.querySelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top").element.style.color = "red";