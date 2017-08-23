var initCharts = function() {
  var charts = $('.percentage1');
  charts.easyPieChart({
    animate: 1000,
    lineWidth: 5,
    barColor: "#eb5055",
    lineCap: "butt",
    size: "150",
    scaleColor: "transparent",
    onStep: function(from, to, percent) {
		$(this.el).find('.cpercent').text(Math.round(percent));
	}
  });
    charts.each(function() {
        $(this).data('easyPieChart').update(Math.floor(100*Math.random()));
      });
};
function updatePer(per,i) {
    var charts = $('.percentage');
    charts.easyPieChart({
        animate: 1000,
        lineWidth: 5,
        barColor: "#eb5055",
        lineCap: "butt",
        size: "150",
        scaleColor: "transparent",
        onStep: function(from, to, percent) {
            $(this.el).find('.cpercent').text(Math.round(percent));
        }
    });
    $(charts[i]).data('easyPieChart').update(per);
}

$(function(){
  $(".knob").knob();
  initCharts();
});