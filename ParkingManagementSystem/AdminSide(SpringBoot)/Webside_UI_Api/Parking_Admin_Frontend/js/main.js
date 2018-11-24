//Global varibale declarations

function checkLogin() {
  // body...
    if(getCookie("token")=="")
    {
      $("#loginText").show();
      $("#acc").hide();
      return false;
    }
    else
    {
      var token={
        "token":getCookie("token")
      }
      var getUserRequest = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/user/loggeduser", // It's the API which is used to checking user credintials
        "type": "POST",
         error: function(xhr, status, error) {
              alert("error");
          },
        "headers": {
          'Content-Type': "application/json",
          'authorization': "Bearer "+getCookie("token")
        },
        "data":JSON.stringify(token)
      }

      $.ajax(getUserRequest).done(function (response) {
       $("#loginText").hide();
       $("#acc").show();

       getCartSize();
  
      });

      return true;
    }
}

function getCartSize() {
  var data={
    "token":getCookie("token")
  }
  var getcartSizeRequest = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/cart/getsize", // It's the API which is used to checking user credintials
        "type": "POST",
         error: function(xhr, status, error) {
              alert("error");
          },
        "headers": {
          'Content-Type': "application/json",
          'authorization': "Bearer "+getCookie("token")
        },
        "data":JSON.stringify(data)
      }

      $.ajax(getcartSizeRequest).done(function (response) {
        $("#cartsize").text(response);
      });
  // body...
}

function clik(obj){
  var url="product_description.html?id="+obj.id;
  window.location.href=url;
}
function delete_cookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    window.location.replace("http://localhost:8080/apnidukan.com/");
}
function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
          c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
          return c.substring(name.length, c.length);
      }
  }
  return "";
}

 function login()
  {
    //getting data from textboxex
    var LoginData={
        "id": 1,
        "emailid": $("#emailid").val(),
        "password": $("#password").val()
    }
    //creating the request object that will use to call api
    var LoginRequest = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8085/user/login", // It's the API which is used to checking user credintials
      "type": "POST",
      "headers": {
      "Content-Type": "application/json",
      },
      "data":JSON.stringify(LoginData) // this method convert common object to JSON 
    }
    // and this is method which is called after object is created 
    // now look here done() is method in which we gave a call back function as parameter which will invokes when we get reply from server
    $.ajax(LoginRequest).done(function (response) {
      //here response is object that contains data which server send back to client
      // it is in normal form so we have to convert it into JSON then i check their properties
      var data=JSON.parse(response);
      if(data.status=="true")
      {
        document.cookie="token="+data.token+"; Path=/";
        window.location.replace("http://localhost:8080/apnidukan.com/");
      }
      else
      {
        $("#msg").text(data.msg);
      }
    }); 
  }

  
  function getOTP()
  {
    $('#msg1').hide();
    $('#newOTP').hide();
    var otp={
      "emailId":$("#otpmailid").val()
    }
    var otpRequest = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8085/otp/generateOTP", // It's the API which is used to checking user credintials
      "type": "POST",
      "headers": {
      "Content-Type": "application/json",
      },
      "data":JSON.stringify(otp) // this method convert common object to JSON 
    }
    $.ajax(otpRequest).done(function (response) {
      var data=JSON.parse(response);
      if(data.generatedOTP=="true")
      {
        $('#OTPForm').show();
        $('#EmailForm').hide();
      }
      else
      {
        $('#msg2').text(data.msg);  
      }
    });
  }

  $(document).ready(function(){
        $("#otpbox").keyup(function(){
          document.getElementById("signupbtn").disabled = true;
            validateOTP();  
        });
  });
  function validateOTP(){
      
      var otp={
      "emailId":$('#otpmailid').val(),
      "otp":$('#otpbox').val()
      }
      var otpRequest ={
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/otp/validateOTP", // It's the API which is used to checking user credintials
        "type": "POST",
        "headers": {
        "Content-Type": "application/json",
            },
        "data":JSON.stringify(otp) // this method convert common object to JSON 
      }
      $.ajax(otpRequest).done(function (response) {
        var data=JSON.parse(response);
        if(data.status=="true")
        {
          userid=data.userid;
          document.getElementById("signupbtn").disabled = false;
        }
        else
        {
          $("#msg1").text(data.msg);
          $("#newOTP").text("Get new one");
          $('#newOTP').show();  
          $("#msg1").show();
        }
      });
  }
  function setPassword(){
    var uobj={
      "emailid":$('#otpmailid').val(),
      "password":$('#pwd').val(),
    }
    var setPWDRequest ={
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/user/setPassword", // It's the API which is used to checking user credintials
        "type": "POST",
        "headers": {
        "Content-Type": "application/json",
            },
        "data":JSON.stringify(uobj) // this method convert common object to JSON 
      }
      $.ajax(setPWDRequest).done(function (response) {
        var data=JSON.parse(response);
        if(data.status=="true")
        {
          document.cookie="token="+data.token+"; Path=/";
          window.location.replace("http://localhost:8080/apnidukan.com/");
        }
      });
  }

  $.urlParam = function(name)  
{  
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);  
    return results[1] || 0;  
}

function getProductDetails(argument) {
      var getProductInfoRequest = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/product/"+$.urlParam('id'), // It's the API which is used to checking user credintials
        "type": "GET",
         error: function(xhr, status, error) {
              alert("error");
          },
        "headers": {
          'Content-Type': "application/json",
          'authorization': "Bearer "+getCookie("token")
        }
      }
      $.ajax(getProductInfoRequest).done(function (response) {
    
      $("#pid").val(response.productid);
       $("#product_img").attr("src","images/"+response.image);

       $("#product_name").text(response.productname);
       $("#product_price").text("₹ "+response.price);
      });
}


function addtocart() {
  if(getCookie("token")=="")
  {
    alert("login first....");
  }
  else
  {
    var data={
          "token":getCookie("token"),
          "pid":parseInt($("#pid").val()),
          "price":$("#product_price").text()
        }
        var addToCartRequest = {
          "async": true,
          "crossDomain": true,
          "url": "http://localhost:8085/cart/add", // It's the API which is used to checking user credintials
          "type": "POST",
           error: function(xhr, status, error) {
                alert("error");
            },
          "headers": {
            'Content-Type': "application/json",
            'authorization': "Bearer "+getCookie("token")
          },
          "data":JSON.stringify(data)
        }

        $.ajax(addToCartRequest).done(function (response) {
         alert("Cart Updated...!!!");
         location.reload();
        });
      }
}
 

  function cartUpdate() {
    var data={
      "token":getCookie("token")
    }
    var cartUpdateRequest = {
          "async": true,
          "crossDomain": true,
          "url": "http://localhost:8085/cart/get", // It's the API which is used to checking user credintials
          "type": "POST",
           error: function(xhr, status, error) {
                alert("error");
            },
          "headers": {
            'Content-Type': "application/json",
            'authorization': "Bearer "+getCookie("token")
          },
          "data":JSON.stringify(data)
        }

        $.ajax(cartUpdateRequest).done(function (response) {
          var data=JSON.parse(response);
          var total=0;
          for(var i=0;i<data.length;i++)
          { 
              var addItem="<tr> <td data-th='Product'><div class='row'><div class='col-sm-2 hidden-xs'><img src='images/"+data[i].img+"' id='product_img' alt='...' class='img-responsive'/></div><div class='col-sm-10'><h4 class='nomargin' id='product_name'>"+data[i].pname+"</h4> </div></div></td><td data-th='Price' id='price"+i+"'>" +data[i].pprice+"</td><td data-th='Quantity'><input type='number' class='form-control text-center' value='"+data[i].qty+"' id='"+i+"' onkeyup='qtyUpdate(this)' onclick='qtyUpdate(this)'></td><td data-th='Subtotal' class='text-center' id='total"+i+"'>"+data[i].qty*data[i].pprice+"</td><td class='actions' data-th=''><button class='btn btn-danger btn-sm' value='"+data[i].pid+"' onclick='deleteFromCart(this)'><i class='glyphicon glyphicon-trash'></i></button></td></tr>";
              $("tbody").append(addItem);             
            total+=data[i].qty*data[i].pprice;
          }
          $("#gtotal").text("₹ "+total);
        });
  }
  function qtyUpdate(obj) {
    //$("#qty"+obj.id).text( * $("#total"+obj.id).val());
    //alert();
   $("#total"+obj.id).text($("#"+obj.id).val() * $("#price"+obj.id).text());
   updateGtotal();
  }

  function updateGtotal() {
    var total=0;
  var carts=0;
  var data={
    "token":getCookie("token")
  }
     var getcartSizeRequest = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/cart/getsize", // It's the API which is used to checking user credintials
        "type": "POST",
         error: function(xhr, status, error) {
              alert("error");
          },
        "headers": {
          'Content-Type': "application/json",
          'authorization': "Bearer "+getCookie("token")
        },
        "data":JSON.stringify(data)
      }
      
      $.ajax(getcartSizeRequest).done(function (response) {
        carts=parseInt(response);
        for(var i=0;i<carts;i++)
        {
          var t=$("#total"+i).text();

          total=total+parseInt(t);
        }
        $("#gtotal").text("₹ "+total);
      });
  }
  function deleteFromCart(btn) {
    var data={
      "token":getCookie("token"),
      "pid":parseInt(btn.value)
    };
    var deleteRequest = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8085/cart/delete", // It's the API which is used to checking user credintials
      "type": "POST",
       error: function(xhr, status, error) {
            alert("error ahiya");
        },
      "headers": {
        'Content-Type': "application/json",
        'authorization': "Bearer "+getCookie("token")
      },
      "data":JSON.stringify(data)
    }

    $.ajax(deleteRequest).done(function (response) {
      
      alert("Delete Sucessfully....!!!");
      location.reload();
    });
  }

  function getAddress() {
    var data={
      "token":getCookie("token")
    }
    var getAddressRequest = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8085/addressbook/findbyuserid", // It's the API which is used to checking user credintials
      "type": "POST",
       error: function(xhr, status, error) {
            alert("error ");
        },
      "headers": {
        'Content-Type': "application/json",
        'authorization': "Bearer "+getCookie("token")
      },
      "data":JSON.stringify(data)
    }

    $.ajax(getAddressRequest).done(function (response) {

      for(var i=0;i<response.length;i++)
      {
           var obj=response[i];
           var addItem="<div class='col-sm-6' style='border: #D9D9D9 solid 1px ;' id='addresscontainer' ><input type='radio' name='add' value='"+obj.addressid+"'> <div id='addname' style='display:inline-block; font-size:14px ;' value='defadd'>"+obj.receivername+"</div><div id='editlink' style=' display:inline-block; float:right' ;><a style='font-size:14px' href='#addAdress' data-toggle='modal' onclick='editAddress(this)' id='addid"+obj.addressid+"'> edit </a></div> <div id='addct' style=' font-size:14px; color:#D9D9D9'>"+obj.city+"</div></div>"
           $("#addrow").append(addItem);
      }
    });
  }

  function getAddress() {
    var data={
      "token":getCookie("token")
    }
    var getAddressRequest = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8085/addressbook/findbyuserid", // It's the API which is used to checking user credintials
      "type": "POST",
       error: function(xhr, status, error) {
            alert("error ahiya");
        },
      "headers": {
        'Content-Type': "application/json",
        'authorization': "Bearer "+getCookie("token")
      },
      "data":JSON.stringify(data)
    }

    $.ajax(getAddressRequest).done(function (response) {
      for(var i=0;i<response.length;i++)
      {
           var obj=response[i];
           var addItem="<div class='col-sm-6' style='border: #D9D9D9 solid 1px ;' id='addresscontainer' ><input type='radio' name='add' value='"+obj.addressid+"'> <div id='addname' style='display:inline-block; font-size:14px ;' value='defadd'>"+obj.receivername+"</div><div id='editlink' style=' display:inline-block; float:right' ;><a style='font-size:14px' href='#addAdress' data-toggle='modal' onclick='editAddress(this)' id='addid"+obj.addressid+"'> edit </a></div> <div id='addct' style=' font-size:14px; color:#D9D9D9'>"+obj.city+"</div></div>"
           $("#addressrow").append(addItem);

      }
    });
  }

function confirmOrder() {

   var paymode = $("input[name='pay']:checked").val();
   var address = $("input[name='add']:checked").val();

   
   var data={
      "token":getCookie("token"),
      "address":parseInt(address),
      "gtotal":$("#gtotal").text(),
      "paymode":paymode
      
    };
    var confirmOrderRequest = {
      "async": true,
      "crossDomain": true,
      "url": "http://localhost:8085/order/place", // It's the API which is used to checking user credintials
      "type": "POST",
       error: function(xhr, status, error) {
            alert("error ahiya");
        },
      "headers": {
        'Content-Type': "application/json",
        'authorization': "Bearer "+getCookie("token")
      },
      "data":JSON.stringify(data)
    }

    $.ajax(confirmOrderRequest).done(function (response) {

        alert("Order Sucessfully Placed...!!!");
        window.location.replace("http://localhost:8080/apnidukan.com/orders.html");

    });
}

function addAddress(){
  if($("#addAddressbtn").val()=="Add")
  {
      var data={
        "token":getCookie("token"),
        "name":$("#nm").val(),
        "address":$("#addressbox").text(),
        "city":$("#citybox").val(),
        "state":$("#statebox").val(),
        "pincode":$("#pincodebox").val(),
        "mobileno":$("#mn").val()
      };

      
      var addAddressRequest = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/addressbook/add", // It's the API which is used to checking user credintials
        "type": "POST",
        error: function(xhr, status, error) {
              alert("error ahiya");
          },
        "headers": {
          'Content-Type': "application/json",
          'authorization': "Bearer "+getCookie("token")
        },
        "data":JSON.stringify(data)
      }

      $.ajax(addAddressRequest).done(function (response) {

          alert("Address added Sucessfully...!!!");
          window.location.replace("http://localhost:8080/apnidukan.com/cart.html");
      });
    }
    else
    {
      var data={
        "token":getCookie("token"),
        "name":$("#nm").val(),
        "address":$("#addressbox").text(),
        "city":$("#citybox").val(),
        "state":$("#statebox").val(),
        "pincode":$("#pincodebox").val(),
        "mobileno":$("#mn").val(),
        "addressid":parseInt($("#addid").val())
        
      };
      var addAddressRequest = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8085/addressbook/update", // It's the API which is used to checking user credintials
        "type": "POST",
        error: function(xhr, status, error) {
              alert("error ahiya");
          },
        "headers": {
          'Content-Type': "application/json",
          'authorization': "Bearer "+getCookie("token")
        },
        "data":JSON.stringify(data)
      }

      $.ajax(addAddressRequest).done(function (response) {

          alert("Updatedd sucessfully...");
          window.location.replace("http://localhost:8080/apnidukan.com/cart.html");
      });
    }
}

function editAddress(obj){
  $("#addAddressbtn").val("Save");
  var adid=obj.id;
  adid=adid.replace("addid","");
  var getAddressRequest = {
    "async": true,
    "crossDomain": true,
    "url": "http://localhost:8085/addressbook/findbyid/"+adid, // It's the API which is used to checking user credintials
    "type": "GET",
     error: function(xhr, status, error) {
          alert("error ahiya");
      },
    "headers": {
      'Content-Type': "application/json",
      'authorization': "Bearer "+getCookie("token")
    }
  }
  $.ajax(getAddressRequest).done(function (response) {
    
    $("#addid").val(response.addressid);
    $("#nm").val(response.receivername);
    $("#addressbox").text(response.area);
    $("#citybox").val(response.city);
    $("#statebox").val(response.state);
    $("#pincodebox").val(response.pincode);
    $("#mn").val(response.mobileno);

  });
}

function enableProfileSaveBtn()
      {
        if($("#profileedit").text()=="edit")
        {
          $("#namesavebtn").show();
          $("#profileedit").text("cancel");
          $("#fnamebox").prop('disabled', false);
          $("#lnamebox").prop('disabled', false);
          $("#maleradio").attr('disabled',false);
          $("#femaleradio").attr('disabled', false);
          $("#maleradiontext").css("color","black");
          $("#femaleradiontext").css("color","black");

        }
        else{
          $("#namesavebtn").hide();
          $("#profileedit").text("edit");
          $("#fnamebox").prop('disabled', true);
          $("#lnamebox").prop('disabled', true);
          $("#maleradio").attr('disabled', true);
          $("#femaleradio").attr('disabled', true);
          $("#maleradiontext").css("color","#c7c7c7");
          $("#femaleradiontext").css("color","#c7c7c7");
        }
    }
    function enableEmailSaveBtn()
      {
        if($("#emailedit").text()=="edit"){
          $("#emailsavebtn").show();
          $("#emailedit").text("cancel");
          $("#emailbox").prop('disabled',false);
        }
        else{
          $("#emailsavebtn").hide();
          $("#emailedit").text("edit");
          $("#emailbox").prop('disabled',true);
        }
      }
      function enableMobileSaveBtn()
      {
        if($("#mobileedit").text()=="edit"){
          $("#mobilesavebtn").show();
          $("#mobileedit").text("cancel");
          $("#mobilebox").prop('disabled',false);
        }
        else{
          $("#mobilesavebtn").hide();
          $("#mobileedit").text("edit");
          $("#mobilebox").prop('disabled',true);
        }
      }

function getUserDetails()
{
  var data={
    "token":getCookie("token")
  };
  var getUserDetailsRequest = {
    "async": true,
    "crossDomain": true,
    "url": "http://localhost:8085/user/get", // It's the API which is used to checking user credintials
    "type": "POST",
     error: function(xhr, status, error) {
          alert("error ahiya");
      },
    "headers": {
      'Content-Type': "application/json",
      'authorization': "Bearer "+getCookie("token")
    },
    "data":JSON.stringify(data)
  }

  $.ajax(getUserDetailsRequest).done(function (response) {

    $("#hiddenuid").val(response.userid);
    $("#fnamebox").val(response.firstname);
    $("#lnamebox").val(response.lastname);
    $("#emailbox").val(response.emailid);
    $("#mobilebox").val(response.mobileno);

    if(response.gender=="male")
      $("#maleradio").prop("checked", true);
    else
      $("#femaleradio").prop("checked", true);
  });
}


function changeEmail(){
  var data={
    "token":getCookie("token"),
    "firstname":$("#fnamebox").val(),
    "lastname":$("#lnamebox").val(),
    "emailid":$("#emailbox").val(),
    "gender":$("input[name='gender']:checked").val(),
    "mobileno":$("#mobilebox").val()
  };
  var changeEmailRequest = {
    "async": true,
    "crossDomain": true,
    "url": "http://localhost:8085/user/save", // It's the API which is used to checking user credintials
    "type": "POST",
    error: function(xhr, status, error) {
          alert("error ahiya");
      },
    "headers": {
      'Content-Type': "application/json",
      'authorization': "Bearer "+getCookie("token")
    },
    "data":JSON.stringify(data)
  }

  $.ajax(changeEmailRequest).done(function (response) {

    alert("Email ID changed...Login again...!!!!");
    delete_cookie("token");
    window.location.replace("http://localhost:8080/apnidukan.com/");

  });
}

function getOrders()
      {
        productName=""
        var data={
          "token":getCookie("token")
        }
        var getAddressRequest = {
          "async": true,
          "crossDomain": true,
          "url": "http://localhost:8085/order/getorders", // It's the API which is used to checking user credintials
          "type": "POST",
          error: function(xhr, status, error) {
                alert("error ahiya");
            },
          "headers": {
            'Content-Type': "application/json",
            'authorization': "Bearer "+getCookie("token")
          },
          "data":JSON.stringify(data)
        }
        $.ajax(getAddressRequest).done(function (response) {
          var data=JSON.parse(response);

          for(var i=0;i<data.length;i++)
          {
              var obj=data[i];
              var date =new Date(obj.date);
              var a=i+1;
              var addItem="<tr><td>"+a+"</td><td><a href='http://localhost:8080/apnidukan.com/order_details.html?orderid="+obj.orderid+"'>"+obj.orderid+"</a></td><td>"+obj.pname+"</td><td>"+obj.paymode+"</td><td>₹ "+obj.amount+"</td><td>"+date.toLocaleString()+"</td></tr>";
              $("#orderrow").append(addItem);
          }
        });
      }
      