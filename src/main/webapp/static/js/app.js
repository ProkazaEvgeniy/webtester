function hello() {
	$(".name").text("Vasya");

	var accounts = $(".name");
	for (var i = 0; i < accounts.length; i++) {
		$(accounts[i]).text("Petr");
	}
}

function loadCurrentDate() {
	$('#load').css('display', 'none');
	$.ajax({
		url : '/data',
		method : 'GET',
		success : function(data) {
			$('#data-container').append(data + "</br>");
			$('#load').css('display', 'inline');
		},

		error : function() {
			$('#load').css('display', 'inline');
		}
	});
}

function loadAjax() {
	$('#load').css('display', 'none');
	$.ajax({
		url : '/accounts',
		method : 'GET',
		success : function(data) {
			$('#data-container').append(data + "</br>");
			$('#load').css('display', 'inline');
		},

		error : function() {
			$('#load').css('display', 'inline');
		}
	});
}

function loadJson() {
	$('#load').css('display', 'none');
	$
			.ajax({
				url : '/accounts-json',
				method : 'GET',
				success : function(data) {
					var table = "<table class=table>"
							+ "<thead><tr><th>#</th><th>First Name</th><th>Last Name</th><th>Email</th></tr></thead>"
							+ "<tbody>";
					for (i = 0; i < data.length; i++) {
						var account = data[i];
						table += "<tr><td>" + account.id + "</td><td>"
								+ account.firstName + "</td><td>"
								+ account.lastName + "</td><td>"
								+ account.email + "</td></tr>";
					}
					table += "</tbody></table>";
					$('#data-container').append(table + "</br>");
					$('#load').css('display', 'inline');
				},

				error : function(jqXHR, textStatus, errorThrown) {

					$('#load').css('display', 'inline');
				}
			});
}

function loadLogout(){
	
}
