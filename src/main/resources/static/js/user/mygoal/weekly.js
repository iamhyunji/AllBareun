document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.querySelector('.calendar__weekly');
	let calendarEvents = [];

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
		events: {
			url: '/api/mygoal/list',
			method: 'POST',
			success: (content, xhr) => {
				calendarEvents = content;
				return content;
			}
		}
	});

	calendar.render();
});