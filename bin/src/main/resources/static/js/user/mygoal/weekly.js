document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.querySelector('.calendar__weekly');
	let content = [];

	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: '',
			center: '',
			right: ''
		},
		locale: 'ko',
		firstDay: 1,
		initialView: 'dayGridWeek',
		initialDate: `${new Date().toISOString().slice(0, 10)}`,
		navLinks: false, // can click day/week names to navigate views
		editable: false,
		dayMaxEvents: true, // allow "more" link when too many events
		dayHeaderContent: function(date) {
			let weekList = ["일", "월", "화", "수", "목", "금", "토"];
			return weekList[date.dow];
		},
		events: '/api/mygoal/list'
	});

	calendar.render();
});