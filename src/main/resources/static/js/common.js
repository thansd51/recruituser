function selectOpt(ele, vGrpName) {

    var $selectEle = $(".form-select." + ele);

    // API에서 데이터 가져오기
    $.get("/select/" + vGrpName, function (data) {
        $selectEle.select2({
            data: data,
            placeholder: "선택",
            allowClear: false
        });

        $selectEle.on("select2:select", function (e) {
            var selVal = $selectEle.val();
            var selTxt = $selectEle.select2('data')[0].text;

            if (ele == "emailSelection") {
                if (selVal != "typing") {
                    $("#email_domain").val(selTxt);
                    $("#email_domain").attr("readonly", true);
                }
                else {
                    $("#email_domain").val("").attr("readonly", false).focus();
                }

            }
            else if (ele == "emailSelection") {
                if (selVal != "typing") {
                    $("#email_domain").val(selTxt);
                    $("#email_domain").attr("readonly", true);
                }
                else {
                    $("#email_domain").val("").attr("readonly", false).focus();
                }

            }
            else if (ele == "mil_srvc") {

                if (selVal == "면제") {
                    $("#mil_exem").prop("disabled", false);
                    $("#mil_type, #mil_type_dtl, #mil_discharge").prop("disabled", true).val("").trigger("change");
                    $("#mil_start_date, #mil_end_date").prop("disabled", true).val("");
                }
                else if (selVal == "비대상" || selVal == "미필") {
                    $("#mil_exem").prop("disabled", true).val("");
                    $("#mil_type, #mil_type_dtl, #mil_discharge").prop("disabled", true).val("").trigger("change");
                    $("#mil_start_date, #mil_end_date").prop("disabled", true).val("");
                }
                else {
                    $("#mil_exem").prop("disabled", true).val("");
                    $("#mil_type, #mil_type_dtl, #mil_discharge, #mil_start_date, #mil_end_date").prop("disabled", false)
                }
            }
            else if (ele == "vtr_srvc") {
                if (selVal == "F") {
                    $("#vtr_relation, #vtr_num").prop("disabled", true).val("").trigger("change");
                }
                else if (selVal == "T") {
                    $("#vtr_relation, #vtr_num").prop("disabled", false);
                }
            }
            else if (ele == "dis_srvc") {
                if (selVal == "F") {
                    $("#dis_class, #dis_rate").prop("disabled", true).val("").trigger("change");
                }
                else if (selVal == "T") {
                    $("#dis_class, #dis_rate").prop("disabled", false);
                }
            }
            else if (ele == "co_sts") {
                if (selVal == "재직") {
                    $('[name=co_end_date]').prop("disabled", true).val("").trigger("change");
                }
                else {
                    $('[name=co_end_date]').prop("disabled", false);
                }
            }
        });
    });
}

$('.date').datepicker({
    format: "yyyy-mm-dd",
    language: "kr",
    autoclose: true
});

$('.dateMonth input').each(function () {
    $(this).datepicker({
        format: 'yyyy-mm',
        language: "kr",
        minViewMode: "months",
        autoclose: true
    })
});

