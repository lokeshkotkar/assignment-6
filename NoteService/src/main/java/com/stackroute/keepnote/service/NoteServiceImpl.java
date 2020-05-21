package com.stackroute.keepnote.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.keepnote.exception.NoteNotFoundExeption;
import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.model.NoteUser;
import com.stackroute.keepnote.repository.NoteRepository;
import java.util.Optional;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

@Service
public class NoteServiceImpl implements NoteService {

	/*
	 * Autowiring should be implemented for the NoteRepository and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	private NoteRepository noteRepository;

	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	/*
	 * This method should be used to save a new note.
	 */
	public boolean createNote(Note note) {

		NoteUser noteUser = null;
		NoteUser returnedNoteUser = null;

		try {
			Optional<NoteUser> noteUserOption = noteRepository.findById(note.getNoteCreatedBy());
			noteUser = noteUserOption.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == noteUser) {
			noteUser = new NoteUser();
			List<Note> notes = new ArrayList<>();
			notes.add(note);
			noteUser.setNotes(notes);
			noteUser.setUserId(note.getNoteCreatedBy());
			returnedNoteUser = noteRepository.insert(noteUser);
		} else {
			List<Note> notes = noteUser.getNotes();
			notes.add(note);
			noteUser.setNotes(notes);
			returnedNoteUser = noteRepository.save(noteUser);
		}

		if (returnedNoteUser != null) {
			return true;
		} else {
			return false;
		}

	}

	/* This method should be used to delete an existing note. */

	public boolean deleteNote(String userId, int noteId) {

		try {
			NoteUser noteUserData = noteRepository.findById(userId).get();
			noteRepository.deleteById(noteUserData.getUserId());
			return true;
		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	/* This method should be used to delete all notes with specific userId. */

	public boolean deleteAllNotes(String userId) {

		try {
			noteRepository.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * This method should be used to update a existing note.
	 */
	public Note updateNote(Note note, int id, String userId) throws NoteNotFoundExeption {

		try {
			NoteUser noteData = noteRepository.findById(userId).get();

			Note notes = noteData.getNotes().get(0);
			notes.setCategory(note.getCategory());
			notes.setNoteContent(note.getNoteContent());
			notes.setNoteCreatedBy(note.getNoteCreatedBy());
			notes.setNoteCreationDate(new Date());
			notes.setNoteId(note.getNoteId());
			notes.setNoteStatus(note.getNoteStatus());
			notes.setNoteTitle(note.getNoteTitle());
			notes.setReminders(note.getReminders());

			noteRepository.save(noteData);
			return notes;
		} catch (Exception e) {
			throw new NoteNotFoundExeption("note not found");
		}

	}

	/*
	 * This method should be used to get a note by noteId created by specific user
	 */
	public Note getNoteByNoteId(String userId, int noteId) throws NoteNotFoundExeption {

		try {
			NoteUser noteUser = noteRepository.findById(userId).get();
			Note notes = noteUser.getNotes().get(0);
			return notes;
		} catch (Exception e) {
			throw new NoteNotFoundExeption("note not found");
		}

	}

	/*
	 * This method should be used to get all notes with specific userId.
	 */
	public List<Note> getAllNoteByUserId(String userId) {

		try {
			NoteUser noteUser = noteRepository.findById(userId).get();
			List<Note> notes = noteUser.getNotes();
			return notes;
		} catch (Exception e) {
			return null;
		}

	}

}
