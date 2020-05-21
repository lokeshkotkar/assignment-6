package com.stackroute.keepnote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.keepnote.exception.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;
import com.stackroute.keepnote.service.ReminderService;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */

@RestController
public class ReminderController {

	/*
	 * From the problem statement, we can understand that the application requires
	 * us to implement five functionalities regarding reminder. They are as
	 * following:
	 * 
	 * 1. Create a reminder 2. Delete a reminder 3. Update a reminder 4. Get all
	 * reminders by userId 5. Get a specific reminder by id.
	 * 
	 */

	/*
	 * Autowiring should be implemented for the ReminderService. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword
	 */

	private ReminderService reminderService;

	@Autowired
	public ReminderController(ReminderService reminderService) {
		this.reminderService = reminderService;
	}

	/*
	 * Define a handler method which will create a reminder by reading the
	 * Serialized reminder object from request body and save the reminder in
	 * database. Please note that the reminderId has to be unique. This handler
	 * method should return any one of the status messages basis on different
	 * situations: 1. 201(CREATED - In case of successful creation of the reminder
	 * 2. 409(CONFLICT) - In case of duplicate reminder ID
	 *
	 * This handler method should map to the URL "/api/v1/reminder" using HTTP POST
	 * method".
	 */

	@PostMapping("/api/v1/reminder")
	public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {

		try {
			Reminder reminderData = reminderService.createReminder(reminder);
			return new ResponseEntity<Reminder>(reminder, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Reminder>(HttpStatus.CONFLICT);
		}

	}

	/*
	 * Define a handler method which will delete a reminder from a database.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the reminder deleted successfully from
	 * database. 2. 404(NOT FOUND) - If the reminder with specified reminderId is
	 * not found.
	 * 
	 * This handler method should map to the URL "/api/v1/reminder/{id}" using HTTP
	 * Delete method" where "id" should be replaced by a valid reminderId without {}
	 */

	@DeleteMapping("/api/v1/reminder/{id}")
	public ResponseEntity<Reminder> deleteReminder(@PathVariable("id") String Id) throws ReminderNotFoundException {

		try {
			Reminder reminderData = reminderService.getReminderById(Id);
			Boolean deleteReminderStatus = reminderService.deleteReminder(Id);
			if (deleteReminderStatus) {
				return new ResponseEntity<Reminder>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Reminder>(HttpStatus.NOT_FOUND);

			}

		} catch (ReminderNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Reminder>(HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * Define a handler method which will update a specific reminder by reading the
	 * Serialized object from request body and save the updated reminder details in
	 * a database. This handler method should return any one of the status messages
	 * basis on different situations: 1. 200(OK) - If the reminder updated
	 * successfully. 2. 404(NOT FOUND) - If the reminder with specified reminderId
	 * is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/reminder/{id}" using HTTP
	 * PUT method.
	 */

	@PutMapping("/api/v1/reminder/{id}")
	public ResponseEntity<Reminder> updateReminder(@RequestBody Reminder reminder) throws ReminderNotFoundException {

		try {
			Reminder reminderData = reminderService.getReminderById(reminder.getReminderId());
			try {
				Reminder UpdateReminder = reminderService.updateReminder(reminder, reminder.getReminderId());
				if (null != UpdateReminder)
					return new ResponseEntity<Reminder>(HttpStatus.OK);
				else
					throw new Exception();
			} catch (Exception e) {
				return new ResponseEntity<Reminder>(HttpStatus.NOT_FOUND);

			}

		} catch (ReminderNotFoundException e) {
			return new ResponseEntity<Reminder>(HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * Define a handler method which will show details of a specific reminder. This
	 * handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the reminder found successfully. 2.
	 * 404(NOT FOUND) - If the reminder with specified reminderId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/reminder/{id}" using HTTP
	 * GET method where "id" should be replaced by a valid reminderId without {}
	 */

	@GetMapping("/api/v1/reminder/{id}")
	public ResponseEntity<Reminder> getReminderByUserId(@PathVariable("id") String Id)
			throws ReminderNotFoundException {

		try {
			Reminder reminderData = reminderService.getReminderById(Id);
			if (null != reminderData) {

				return new ResponseEntity<Reminder>(reminderData, HttpStatus.OK);
			} else {
				return new ResponseEntity<Reminder>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Reminder>(HttpStatus.NOT_FOUND);

		}

	}

	/*
	 * Define a handler method which will get us the all reminders. This handler
	 * method should return any one of the status messages basis on different
	 * situations: 1. 200(OK) - If the reminder found successfully. 2. 404(NOT
	 * FOUND) - If the reminder with specified reminderId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/reminder" using HTTP GET
	 * method
	 */

	@GetMapping("api/v1/reminder")
	public ResponseEntity<List<Reminder>> getAllReminder() throws ReminderNotFoundException {

		List<Reminder> reminderData = reminderService.getAllReminders();
		if (null != reminderData) {

			return new ResponseEntity<List<Reminder>>(HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Reminder>>(HttpStatus.NOT_FOUND);
		}

	}
}