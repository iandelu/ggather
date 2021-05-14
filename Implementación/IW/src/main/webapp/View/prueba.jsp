<script type="text/javascript">
	function anadir(obj) {
			anadir1(obj);
			if (obj.name =='search_query1'||'search_query2'||'search_query2'){
                anadirImgSQ1();
                anadirImgSQ2();
                anadirImgSQ3();}									
		}
	
	function anadir1(obj) {		
			var radios = document.getElementsByTagName('input');
			var value;
			obj.form.search_query.value = "";
			for (var i = 0; i < radios.length; i++) {
				if (radios[i].type === 'radio' && radios[i].checked) {
				value = radios[i].value; 
				obj.form.search_query.value = obj.form.search_query.value + value;							
				}
			}						
		}
	function anadirImgSQ1(){
			var radio = document.getElementsByName('search_query1');
			var colorPelo = document.getElementById('colorPelo'); 
			if (radio[0].checked){
				colorPelo.src = "http://ritsi.org/wp-content/uploads/2013/03/luis_cabeza_honorifico.jpg";
			}
			if (radio[1].checked){
			colorPelo.src = "http://entimg.msn.com/i/150/Movies/Actors4/brigged0194557_150x200.jpg";
			}
		}
	
	function anadirImgSQ2(){
			var radio = document.getElementsByName('search_query2');
			var siluetaCuerpo = document.getElementById('siluetaCuerpo'); 
			if (radio[0].checked){
				siluetaCuerpo.src = "http://ritsi.org/wp-content/uploads/2013/03/luis_cabeza_honorifico.jpg";
			}
			if (radio[1].checked){
			siluetaCuerpo.src = "http://entimg.msn.com/i/150/Movies/Actors4/brigged0194557_150x200.jpg";
			}
		}
	
	function anadirImgSQ3(){
			var radio = document.getElementsByName('search_query3');
			var estiloRopa = document.getElementById('estiloRopa'); 
			if (radio[0].checked){
				estiloRopa.src = "http://ritsi.org/wp-content/uploads/2013/03/luis_cabeza_honorifico.jpg";
			}
			if (radio[1].checked){
			estiloRopa.src = "http://entimg.msn.com/i/150/Movies/Actors4/brigged0194557_150x200.jpg";
			}
		}
</script>